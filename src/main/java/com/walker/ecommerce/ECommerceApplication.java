package com.walker.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = {"com.walker.ecommerce.model"}) //indica ao SpringBoot onde ele deve procurar as classes de entidade ao inicializar a aplicação
@ComponentScan(basePackages = {"com.*"}) //indica ao SpringBoot os pacotes que devem ser escaneados em busca de componentes Spring, como (controllers, services, repositories, etc...)
@EnableJpaRepositories(basePackages = {"com.walker.ecommerce.repository"}) //habilita a criação de repositórios Spring Data JPA, permitindo que o SpringBoot descubra os repositories em pacotes especificados e os registre como beans
@EnableTransactionManagement //habilita o suporte à gestão de transações Spring, o que significa que você pode usar anotações como @Transactional em seus métodos para controlar transações
public class ECommerceApplication { //LojaVirtualMentoriaApplication

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

}
