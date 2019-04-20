package bean;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeCFactory implements FactoryBean<TypeC> {

	@Autowired 
	TypeA typeA;
	
	@Autowired 
	TypeB typeB;
	
	private AtomicInteger cot= new AtomicInteger(0);
	
	@Override
	public TypeC getObject() throws Exception {
		// TODO Auto-generated method stub
		TypeC c = new TypeC();
		c.setName(typeA.getName()+","+typeB.getName()+",CCCC"+System.currentTimeMillis());
		c.setValue(cot.getAndIncrement());
		return  c;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return TypeC.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
