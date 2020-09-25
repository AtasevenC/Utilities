//cookies

driver.manage().getCookies(); // Return The List of all Cookies
driver.manage().getCookieNamed(arg0); //Return specific cookie according to name
driver.manage().addCookie(arg0); //Create and add the cookie
driver.manage().deleteCookie(arg0); // Delete specific cookie
driver.manage().deleteCookieNamed(arg0); // Delete specific cookie according Name
driver.manage().deleteAllCookies(); // Delete all cookies
// https://ruhr-uni-bochum.zoom.us/j/3237146737?pwd=K1lEcElWM2RHeHk2VTFSTndSckRWZz09
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


//Use stored cookies to login information
public static void main(String[] args){
    try{
    File file = new File("Cookies.data");
    FileReader fileReader = new FileReader(file);
    BufferedReader Buffreader = new BufferedReader(fileReader);
    String strline;
    while((strline=Buffreader.readLine())!=null){
    StringTokenizer token = new StringTokenizer(strline,";");
    String name = token.nextToken();
    String value = token.nextToken();
    String domain = token.nextToken();
    String path = token.nextToken();
    Date expiry = null;

   String val;
  if(!(val=token.nextToken()).equals("null")) {
       expiry = new Date(val);
   }
   Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
   Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
   System.out.println(ck);
   driver.manage().addCookie(ck); // This will add the stored cookie to current session
   }
 }
}catch(Exception ex){
     ex.printStackTrace();
 }
   driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
   
