package com.lyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {

  // 定义一些值用于生成验证码图片
  // 图像宽度 120 像素
  private int width = 120;
  // 图像高度 30 像素
  private int height = 30;
  // 图像中验证码的起始位置
  private int drawY = 21;
  // 验证码有多少文字
  private int charCount = 6;
  // 生成的验证码内容数组
  private String[] chars = {
          "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
          "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
          "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7",
          "8", "9", "0"
  };

  // 文字的间隔
  private int space = 15;

  // 定义方法：生成验证码内容，在一个图片上，写入文字
  @GetMapping("/code")
  public void makeCaptcha(HttpSession session, HttpServletResponse response) throws IOException {
    /***
     *  基本思路：
     *    1、需要在内存中绘制一张 BufferedImage 图片
     *    2、向这个图片中写入内容
     *    3、把绘制好的图片响应出去
     */

    // 创建一个背景透明的图片，使用 rgb 表示颜色的  （画板）
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    // 画笔
    Graphics graphics = image.getGraphics();

    // 设置使用画笔是白色
    graphics.setColor(Color.white);

    // 给 image 画板涂成自己喜欢的颜色
    // x, y 从哪个坐标开始画，画多宽，多高
    graphics.fillRect(0, 0, width, height);

    // 设置没有缓存
    response.setHeader("Pragma", "no-cache");
    // 设置不要缓存
    response.setHeader("Cache-Control", "no-cache");
    // 过期时间，马上过期
    response.setDateHeader("Expires", 0);
    // 设置输出格式
    response.setContentType("image/png");
    ServletOutputStream os = response.getOutputStream();

    // ------------------ 画内容
    // 设置字体信息
    Font font = new Font("宋体", Font.BOLD, 16);
    graphics.setFont(font);

    // 随机数组中的下标
    int ran = 0;
    // 最大随机数
    int len = chars.length;

    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < charCount; i++) {
      ran = new Random().nextInt(len);
      // 设置字体颜色
      graphics.setColor(makeColor());
      // 参数：文字, x, y 坐标
      graphics.drawString(chars[ran], (i+1)*space, drawY);
      buffer.append(chars[ran]);
    }
    session.setAttribute("captcha", buffer.toString());
    // 绘制干扰线
    for (int m = 0; m < 4;m++) {
      graphics.setColor(makeColor());
      int[] dot = makeLine();
      graphics.drawLine(dot[0], dot[1], dot[2], dot[3]);
    }

    /***
     * RenderedImage im,    要输出的图像
     * String formatName,   图像的格式 jpg，jpeg，png
     * OutputStream output  输出到哪
     */
    ImageIO.write(image, "png", os);
    os.flush();
    os.close();
  }

  // 随机生成颜色方法
  public Color makeColor() {
    Random random = new Random();
    int r = random.nextInt(255);
    int g = random.nextInt(255);
    int b = random.nextInt(255);

    return new Color(r, g, b);
  }

  // 随机生成干扰线
  public int[] makeLine() {
    Random random = new Random();
    int x1 = random.nextInt(width / 2);
    int y1 = random.nextInt(height);

    int x2 = random.nextInt(width);
    int y2 = random.nextInt(height);

    return new int[]{x1, y1, x2, y2};
  }
 }
