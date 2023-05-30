package com.example.demo;

import com.example.demo.rule.ConditionDto;
import com.example.demo.rule.NameCondition;
import com.example.demo.rule.TreeNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Value("#{workersHolder.salaryByWorkers['John']}") // 35000
	private Integer johnSalary;

	@Value("#{workersHolder.salaryByWorkers['George']}") // 14000
	private Integer georgeSalary;

	@Value("#{workersHolder.salaryByWorkers['Susie']}") // 47000
	private Integer susieSalary;

	@Value("#{workersHolder.workers[0]}") // John
	private String firstWorker;

	@Value("#{workersHolder.workers[3]}") // George
	private String lastWorker;

	@Value("#{workersHolder.workers.size()}") // 4
	private Integer numberOfWorkers;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StandardEvaluationContext evaluationContext1 = new StandardEvaluationContext("");
		ConditionDto dto = new ConditionDto(NameCondition.NULL,evaluationContext1,1,2,0 );
		ConditionDto dto1 = new ConditionDto(NameCondition.NULL,evaluationContext1,2,3,1 );
		ConditionDto dto2 = new ConditionDto(NameCondition.NULL,evaluationContext1,3,3,1 );
		ConditionDto dto3 = new ConditionDto(NameCondition.NULL,evaluationContext1,4,5,2 );
		ConditionDto dto4 = new ConditionDto(NameCondition.NULL,evaluationContext1,5,5,2 );

		TreeNode<ConditionDto> node1 = new TreeNode<ConditionDto>(dto);
		node1.addChild(dto1);
		node1.addChild(dto2);
		TreeNode<ConditionDto> node2 = node1.addChild(null);


	}
}
