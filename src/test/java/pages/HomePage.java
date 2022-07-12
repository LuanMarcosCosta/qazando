package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import support.Utils;

public class HomePage extends Utils {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarAplicacao(){
        driver.manage().window().maximize();
        driver.get("http://qazando.com.br/curso.html");

        Assert.assertEquals("Não acesso a aplicação", true, driver.findElement(By.id("btn-ver-cursos")).isDisplayed());
    }

    public void scrollDown() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, 10000)");
    }

    public void preencheEmail(){
        driver.findElement(By.id("email")).sendKeys("luan@test.com.br");
        esperarElementoEstarPresente(By.id("button"), 10);

    }

    public void clickGanharDesconto(){
        driver.findElement(By.id("button")).click();
    }

    public void verificarCupomDesconto(){
        String texto_cupom = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();
        Assert.assertEquals("o cupom está errado", "QAZANDO15OFF", texto_cupom);
    }
}
