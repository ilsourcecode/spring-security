package com.lyw.vo;

// 打印结果的类
public class ResponseInfo {
  // 1 失败 0 成功
  private Integer code;

  private Integer error;

  private String meg;

  public ResponseInfo() {}

  public ResponseInfo(Integer code, Integer error, String meg) {
    this.code = code;
    this.error = error;
    this.meg = meg;
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

  @Override
  public String toString() {
    return "ResponseInfo{" +
            "code=" + code +
            ", error='" + error + '\'' +
            ", meg='" + meg + '\'' +
            '}';
  }
}
