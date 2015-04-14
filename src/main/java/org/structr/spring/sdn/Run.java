/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.structr.spring.sdn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.structr.spring.sdn.model.Product;
import org.structr.spring.sdn.repository.ProductRepository;

/**
 * Runnable Test class.
 *
 * @author Axel Morgner
 */
public class Run {
	
	public static void main(final String[] args) {

		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		final ProductRepository productRepository = context.getBean(ProductRepository.class);

		final Iterable<Product> products = productRepository.findAll();
		for (final Product p : products) {

			System.out.println(p.productName);

		}


	}


}
