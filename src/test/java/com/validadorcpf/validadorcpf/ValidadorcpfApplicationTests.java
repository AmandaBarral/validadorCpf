package com.validador.cpf.validadorCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.validador.cpf.validadorCpf.models.Cliente;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Amanda");
		cliente.setCpf("10889543836");
		assertEquals(true, cliente.validarCPF()); 
	}

    @Test
	void fazendoTesteDeCpfInvalido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Amanda");
		cliente.setCpf("1088954383");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfComVirgula() {
		Cliente cliente = new Cliente();
		cliente.setNome("Amanda");
		cliente.setCpf("1088954383,6");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfComEspacoNoFinal() {
		Cliente cliente = new Cliente();
		cliente.setNome("Amanda");
		cliente.setCpf("10889543836 ");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfComLetra() {
		Cliente cliente = new Cliente();
		cliente.setNome("Amanda");
		cliente.setCpf("1088h5a3836");
		assertEquals(false, cliente.validarCPF());
	}
	
	
}
