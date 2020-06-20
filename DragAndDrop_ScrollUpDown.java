
//  Drag And Drop ?
Actions action = new Actions(driver);
action.clickAndHold(driver.findElement(By.id("item")))
.moveToElement(driver.findElement(By.id("destination")))
.release().build()
.perform();


// For Scroll down:
WebDriver driver = new ChromeDriver(); JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("window.scrollBy(0,250)", ""); 

//or 
jse.executeScript("scroll(0, 250);"); 

//For Scroll up: 
jse.executeScript("window.scrollBy(0,-250)", ""); OR, jse.executeScript("scroll(0,-250);");