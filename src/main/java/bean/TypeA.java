package bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

public class TypeA {
	private String name;
	private Integer value;
	@Autowired
	private TypeB b;
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
	public TypeB getB() {
		return b;
	}
	public void setB(TypeB b) {
		this.b = b;
	}
	
	@PostConstruct
	public void init() {
		System.err.println("a inited "+(b!=null));
	}
	
	@PreDestroy
	public void destory() {
		System.err.println("a destory "+(b!=null));
	}
	
}
