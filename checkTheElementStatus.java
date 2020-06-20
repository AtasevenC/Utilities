
//To check Element Present: 

if(driver.findElements(By.xpath("value")).size() != 0){
System.out.println("Element is Present");
}else{
System.out.println("Element is Absent");}

// or 
if(driver.findElement(By.xpath("value"))!= null){
System.out.println("Element is Present");
}else{
System.out.println("Element is Absent"); }

//To check Visible:
if(driver.findElement(By.cssSelector("a > font")).isDisplayed()){
System.out.println("Element is Visible");
}else{
System.out.println("Element is InVisible"); }

//To check Enable:
if(driver.findElement(By.cssSelector("a > font")).isEnabled()){
System.out.println("Element is Enable");
}else{
System.out.println("Element is Disabled"); }

// To check text present
if(driver.getPageSource().contains("Text to check")){
System.out.println("Text is present");
}else{
System.out.println("Text is absent"); }