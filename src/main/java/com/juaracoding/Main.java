package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Juara Coding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Login
        driver.get("https://shop.demoqa.com/my-account/");
        System.out.println("Enter My Account Button");
        System.out.println(driver.getTitle());

        //Input Data
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("username")).sendKeys("muhammadiwan27");
        driver.findElement(By.id("password")).sendKeys("Iwan12345!@#$%");
        driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();
        System.out.println("Button Login Clicked");

        //Kembali Ke Halaman Utama
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div/div/div/a/img")).click();
        System.out.println("Dashboard Clicked");

        //Memilih Item
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[2]")).click();
        System.out.println("Item Clicked");

        //Memilih Warna Item
        js.executeScript("window.scrollBy(0,700)");
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"pa_color\"]"));
        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByIndex(1);
        System.out.println("Item Color Has Been Selected");

        //Memilih Ukuran Item
        WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"pa_size\"]"));
        Select selectDropdown1 = new Select(dropdown1);
        selectDropdown1.selectByIndex(3);
        System.out.println("Item Size Has Been Selected");

        //Memasukkan Item Ke Cart
        driver.findElement(By.xpath("//*[@id=\"product-1491\"]/div[1]/div[2]/form/div/div[2]/button")).click();
        System.out.println("Item Has Been Added To The Cart");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Close Browser");
    }
}