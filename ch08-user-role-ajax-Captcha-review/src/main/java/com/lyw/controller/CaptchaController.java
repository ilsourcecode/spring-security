package com.lyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
public class CaptchaController {

  // 定义验证码 120px 宽
  private Integer width = 120;
  // 30px 高
  private Integer height = 30;
  // 图像中验证码的起始位置
  private Integer drawY = 21;
  // 设置验证码中间的间距
  private Integer space = 15;
  // 验证码中信息的最多数量
  private Integer charCount = 6;
  // 验证码中出现的信息
  private String[] chars = {
          "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
          "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
          "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7",
          "8", "9", "0"
  };

  /***
   *  用来制作验证码
   * @param session     主要是用来存储验证码中的信息，方便验证
   * @param response    输出制造出来的验证码到发送请求的地方
   * @throws IOException
   */
  @GetMapping("/captcha")
  public void makeCaptcha(HttpSession session, HttpServletResponse response) throws IOException {
    // 设置请求响应包中的信息浏览器采用什么编译器进行编译
    response.setContentType("image/png");

    // 创建一个背景透明的图片，使用 rgb 表示颜色的  (画板)
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    // 获取绘画验证码的笔
    Graphics g = image.getGraphics();
    // 设置使用的笔的颜色
    g.setColor(Color.white);
    //
    g.fillRect(0, 0, width, height);

    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");

    response.setDateHeader("Expires", 0);

    Font font = new Font("宋体", Font.BOLD, 16);
    g.setFont(font);

    int ran = 0;
    int len = chars.length;
    StringBuffer buff = new StringBuffer();
    for (int i = 0; i < charCount;i++) {
      ran = new Random().nextInt(len);
      g.setColor(makeColor());
      g.drawString(chars[ran], (i + 1) * space, drawY);
      buff.append(chars[ran]);
    }

    session.setAttribute("captcha", buff.toString());

    for (int i = 0; i < 4;i++)
    {
      g.setColor(makeColor());
      int dot[] = makeLine();
      g.drawLine(dot[0], dot[1], dot[2], dot[3]);
    }

    ServletOutputStream os = response.getOutputStream();
    ImageIO.write(image, "png", os);
    os.flush();
    os.close();
  }

  private Color makeColor() {
    Random random = new Random();
    int r = random.nextInt(255);
    int g = random.nextInt(255);
    int b = random.nextInt(255);

    return new Color(r, g, b);
  }

  public int[] makeLine() {
    Random random = new Random();
    int x1 = random.nextInt(width / 2);
    int y1 = random.nextInt(height);
    int x2 = random.nextInt(width);
    int y2 = random.nextInt(height);

    return new int[]{x1, y1, x2, y2};
  }


}
