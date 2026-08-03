package com.sist.web.vo;
// => public record BoardDTO => Spring AI
public interface BoardDTO {
	public int getNo();
	public String getSubject();
	public String getName();
	public int getHit();
	public String getDbday();
}
