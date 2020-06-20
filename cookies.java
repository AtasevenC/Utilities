//cookies

driver.manage().getCookies(); // Return The List of all Cookies
driver.manage().getCookieNamed(arg0); //Return specific cookie according to name
driver.manage().addCookie(arg0); //Create and add the cookie
driver.manage().deleteCookie(arg0); // Delete specific cookie
driver.manage().deleteCookieNamed(arg0); // Delete specific cookie according Name
driver.manage().deleteAllCookies(); // Delete all cookies

// Store cookies cookie information
public class cookieRead extends BasePage{
  public static void main(String[] args){
    driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");

 // Input Email id and Password If you are already Register
    driver.findElement(By.name("username")).sendKeys("abc123");
    driver.findElement(By.name("password")).sendKeys("123xyz");
    driver.findElement(By.name("submit")).click();

    File file = new File("Cookies.data"); // create file to store cookies

   try {
    file.delete(); // Delete old file if exists
    file.createNewFile();
    FileWriter fileWrite = new FileWriter(file);
    BufferedWriter Bwrite = new BufferedWriter(fileWrite);

// loop for getting the cookie information
    for(Cookie ck : driver.manage().getCookies()){
     Bwrite.write((ck.getName() +";"+ ck.getValue() +";"+ ck.getDomain() +";"+ ck.getPath()
     + ";" + ck.getExpiry() +";"+ ck.isSecure()));
     Bwrite.newLine();
     }
     Bwrite.flush(); Bwrite.close(); fileWrite.close();
 } 
    catch(Exception ex) {
    ex.printStackTrace();
    }
 }
}