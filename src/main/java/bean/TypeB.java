package bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

public class TypeB {
	@Autowired
	private TypeA a;
	
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
	public TypeA getA() {
		return a;
	}
	public void setA(TypeA a) {
		this.a = a;
	}
	
	@PostConstruct
	public void init() {
		System.err.println("b inited "+(a!=null));
	}
	
	@PreDestroy
	public void destory() {
		System.err.println("b destory "+(a!=null));
	}
	
	
}
