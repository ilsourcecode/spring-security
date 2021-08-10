package com.lyw.vo;

// 返回的 json 数据
public class Result {
  // code = 0 成功 code = 1 失败
  private Integer code;
  // 表示错误码
  private Integer error;
  // 消息文本
  private String meg;

  @Override
  public String toString() {
    return "Result{" +
            "code='" + code + '\'' +
            ", error=" + error +
            ", meg='" + meg + '\'' +
            '}';
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Integer getError() {
    return error;
  }

  public void setError(Integer error) {
    this.error = error;
  }

  public String getMeg() {
    return meg;
  }

  public void setMeg(String meg) {
    this.meg = meg;
  }
}
