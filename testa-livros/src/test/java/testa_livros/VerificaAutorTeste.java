package testa_livros;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class VerificaAutorTeste {

	WebDriver driver;
	Select select;
	
	@Before
	public void antesDoTeste() {
		System.setProperty(Configuracoes.NOME_DRIVER, Configuracoes.CAMINHO_DRIVER);
		driver = new ChromeDriver();
		driver.get(Configuracoes.URL_APLICACAO_SUBMARINO);
		driver.manage().window().maximize();
	}
	
	@Test
	public void verificarAutorTeste(){
		WebElement paginaLivros = driver.findElement(By.xpath("//*/img[@src='https://images-submarino.b2w.io/spacey/suba/2020/10/09/09_home_micasasubcasa_contenttriplo_02.jpg']"));
		paginaLivros.click();
		
		WebElement livroSubmarino = driver.findElement(By.xpath("//*/img[@src='https://images-submarino.b2w.io/produtos/imagens/133823705/133823713_1GG.jpg']"));
		livroSubmarino.click();
		Assert.assertTrue(driver.getPageSource().contains(MassaDeTeste.NOME_AUTOR));
		
		
		if(driver.getPageSource().contains(MassaDeTeste.NOME_AUTOR)) {
			
			System.out.println("O Autor do livro na loja Submarino é " + MassaDeTeste.NOME_AUTOR);
			
		} 
		else {
		
			System.out.println("O Autor do livro na loja Submarino não é " + MassaDeTeste.NOME_AUTOR);
		}
		
		
		driver.get(Configuracoes.URL_APLICACAO_AMAZON);
		
		WebElement pesquisaLivrosAmazon = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[3]"));
		pesquisaLivrosAmazon.click();
		
		WebElement pesquisaAvançadaAmazon = driver.findElement(By.xpath("//*[@id='nav-subnav']/a[2]/span"));
		pesquisaAvançadaAmazon.click();
		
		WebElement campoISBN = driver.findElement(By.name("field-isbn"));
		campoISBN.sendKeys(MassaDeTeste.ISBN);
		
		WebElement botaoPesquisarAmazon = driver.findElement(By.name("Adv-Srch-Books-Submit"));
		botaoPesquisarAmazon.click();
		Assert.assertTrue(driver.getPageSource().contains(MassaDeTeste.NOME_AUTOR));
		
		
		if(driver.getPageSource().contains(MassaDeTeste.NOME_AUTOR)) {
			
			System.out.println("O Autor do livro na loja Amazon é " + MassaDeTeste.NOME_AUTOR);
			
		} 
		else {
		
			System.out.println("O Autor do livro na loja Amazon não é " + MassaDeTeste.NOME_AUTOR);
		}
		
		
		driver.get(Configuracoes.URL_APLICACAO_LEITURA);
		
		WebElement campoPesquisaLeitura = driver.findElement(By.id("q"));
		campoPesquisaLeitura.sendKeys(MassaDeTeste.ISBN);
		
		WebElement botaoPesquisarLeitura = driver.findElement(By.xpath("//*/form/button[@class='search-bar--submit icon-fallback-text']"));
		botaoPesquisarLeitura.click();
		
		WebElement livroLeitura = driver.findElement(By.xpath("//*/div[@class='img-container-product-item']"));
		livroLeitura.click();
		Assert.assertTrue(driver.getPageSource().contains(MassaDeTeste.NOME_AUTOR));
		
		
		if(driver.getPageSource().contains(MassaDeTeste.NOME_AUTOR)) {
			
			System.out.println("O Autor do livro na loja Leitura é " + MassaDeTeste.NOME_AUTOR);
			
		} 
		else {
		
			System.out.println("O Autor do livro na loja Leitura não é " + MassaDeTeste.NOME_AUTOR);
		}
	}
		
	@After
	public void depoisDoTeste() {
		driver.quit();
	}
	   
	
	
	
}
