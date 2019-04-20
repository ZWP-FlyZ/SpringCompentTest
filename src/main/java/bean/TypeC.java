package bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TypeC {
	private String name;
	private Integer value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	
	//TypeC 并不是由Spring管理的Bean，因此无法触生命周期函数
	@PostConstruct
	public void init() {
		System.err.println("c inited ");
	}
	
	@PreDestroy
	public void destory() {
		System.err.println("c destory ");
	}
}
