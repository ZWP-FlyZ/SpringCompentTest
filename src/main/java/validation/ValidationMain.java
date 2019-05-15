package validation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class ValidationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Validator vat = ctx.getBean("validator",Validator.class);
		TypeA a = ctx.getBean("a",TypeA.class);

		DataBinder bd = new DataBinder(a);

		bd.setValidator(vat);
		
		bd.validate();
		
		BindingResult br = bd.getBindingResult();
		br.getAllErrors().forEach(v->System.err.println(v.getDefaultMessage()));

		
	}

}
