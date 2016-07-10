package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.google.gson.JsonArray;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import matlabcontrol.MatlabProxyFactoryOptions;
import java.util.Arrays;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;

public final class testimage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("application/json;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");

 //String value=request.getParameter("string1");
   // out.println(value);
    String value="IMG_20160610_153202.jpg";
    try
    {
    ServletContext context= pageContext.getServletContext();
    String filepath = context.getInitParameter("D:\\wamp\\www\\AndroidFileImage\\uploads\\"+value);
   String filepathfinal= "'D:/wamp/www/AndroidFileImage/uploads/"+value+"'";
   // out.println(filepath);

final Long MATLAB_PROXY_TIMEOUT= 1000000L;

MatlabProxyFactoryOptions options = new MatlabProxyFactoryOptions.Builder().setHidden(true).setUsePreviouslyControlledSession(true).setProxyTimeout(MATLAB_PROXY_TIMEOUT).build();
    
MatlabProxyFactory factory = new MatlabProxyFactory(options); 
MatlabProxy proxy = factory.getProxy();

//Display 'hello world' just like when using the demo
proxy.eval("disp('hello world')");
proxy.eval("cd('E:/majorpart1/VLFEATROOT/VLFEATROOT/apps')");

proxy.eval("l='';vl_feat_setup = fullfile(l,'E:/majorpart1/VLFEATROOT/VLFEATROOT/toolbox/vl_setup')");
proxy.eval("libsvm_path = fullfile(l,'C:/Users/dell1/Downloads/libsvm-3.21/libsvm-3.21/matlab')");

proxy.eval("run(vl_feat_setup)");
proxy.eval("addpath(libsvm_path)");

//proxy.eval("run('E:/majorpart1/VLFEATROOT/VLFEATROOT/apps/xyz.m')");
String st="array=xyz('E:/majorpart1/VLFEATROOT/VLFEATROOT/apps/11_friedrice_003.jpg')";
//proxy.eval(st);

proxy.eval("array=xyz("+filepathfinal+")");
//proxy.eval("array = magic(3)");

String s="";


for(int i=1;i<15;i++)
{
     try{
         
    Object[] returnArguments= proxy.returningEval("array("+i+")", 1);
    s=s+returnArguments[0].toString();
    //out.print(returnArguments[0].toString());
     }catch(Exception e){
         break;
     }
}
    
//out.print(s+"3456790");
System.out.print("16wyugyegy"+s);
//out.print("jsp message");
     
    
    

//Retrieve the first (and only) element from the returned arguments
//Object firstArgument = returnArguments[0];
//Like before, cast and index to retrieve the double value
//double innerValue = ((double[]) firstArgument)[0];
//Print the result

//System.out.println(innerValue);
//out.println("Result: " + innerValue);


/*
String j= "{'food':'"+s+"'}";
JsonParser jp = new JsonParser();
JsonElement je = jp.parse(j);

out.print(je);
*/

       String food_name = s;
        
        //String[] my_response = new String[15];
        StringBuffer sb = new StringBuffer();
        sb.append("{'food_name':'"+food_name+"',");
        //String url="https://www.zomato.com/ncr/sector-62-noida-restaurants?q=";
        String url="https://www.zomato.com/ncr/restaurants?q="+food_name;
        sb.append("'Restaurants':[");
        
        Document doc = Jsoup.connect(url).timeout(10000).get();
        //Element link = doc.select("a").first();
        //String title = doc.title();  
        Elements ele=doc.getElementsByClass("result-title");
        /*my_response[0] = food_name;
         for(int i=1;i<6;i++)
        {
            //System.out.println(ele.get(i));
            //System.out.println(ele.get(i).attr("title"));
            my_response[i] = ele.get(i-1).attr("title");
        }
        */
        for(int i=1;i<6;i++)
        {
            //System.out.println(ele.get(i));
            //System.out.println(ele.get(i).attr("title"));
            sb.append("'"+ele.get(i-1).attr("title")+"'");
            if(i!=5)
            sb.append(",");
        }
        
        
        sb.append("],'Nutrition':{");
        
        //get nutritional facts
         
   // String url1="https://api.nutritionix.com/v1_1/search/cheddar%20cheese?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat%2Cnf_calories%2Cnf_calories_from_fat%2Cnf_total_fat%2Cnf_saturated_fat%2Cnf_monounsaturated_fat%2Cnf_polyunsaturated_fat&appId=5e888a6f&appKey=985c57a8b1e7332ed344465c82e9d861";
    
    if(food_name.contains(" "))
        food_name = food_name.replace(" ","%20");
         
    String url1="https://api.nutritionix.com/v1_1/search/"+food_name+"?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat%2Cnf_calories%2Cnf_calories_from_fat%2Cnf_total_fat%2Cnf_saturated_fat%2Cnf_monounsaturated_fat%2Cnf_polyunsaturated_fat%2Cnf_sugars%2Cnf_protein%2Cnf_sodium%2Cnf_cholesterol%2Cnf_total_carbohydrate%2Cnf_calcium_dv%2Cnf_iron_dv%2Cnf_potassium%2Cnf_vitamin_a_dv%2Cnf_vitamin_c_dv&appId=5e888a6f&appKey=985c57a8b1e7332ed344465c82e9d861";
    

    // Connect to the URL using java's native library
    URL my_url = new URL(url1);
    HttpURLConnection my_request = (HttpURLConnection) my_url.openConnection();
    my_request.connect();
    
    
    JsonParser jp = new JsonParser(); //from gson
    JsonElement root = jp.parse(new InputStreamReader((InputStream) my_request.getContent()));
    JsonObject rootobj = root.getAsJsonObject();
    JsonArray hits =rootobj.get("hits").getAsJsonArray();
    JsonElement hits_element = hits.get(0);
    JsonObject hits_object = hits_element.getAsJsonObject();
    System.out.println(hits_object);
    
    JsonElement fields_element = hits_object.get("fields");
    JsonObject fields_object = fields_element.getAsJsonObject();
    
    /*for(int i=6;i<12;i++)
    {
     my_response[i]=fields_object.get("nf_calories").getAsString();   
    }
    
    System.out.println(fields_object.get("nf_calories").getAsDouble());
    */
    
    
    /*
    my_response[6]=fields_object.get("nf_calories").getAsString();   
    my_response[7]=fields_object.get("nf_total_fat").getAsString();   
    my_response[8]=fields_object.get("nf_saturated_fat").getAsString();   
    my_response[9]=fields_object.get("nf_monounsaturated_fat").getAsString();   
    my_response[10]=fields_object.get("nf_polyunsaturated_fat").getAsString();   
    my_response[11]=fields_object.get("nf_cholesterol").getAsString();   
    my_response[12]=fields_object.get("nf_sodium").getAsString();   
    my_response[13]=fields_object.get("nf_sugars").getAsString();   
    my_response[14]=fields_object.get("nf_protein").getAsString();   
    
 
         
    for(int i=0;i<15;i++)
    {
        out.println(my_response[i]+"<br>");
    }
    */     
    sb.append("'calories':'"+fields_object.get("nf_calories").getAsString()+"',");
    sb.append("'total_fat':'"+fields_object.get("nf_total_fat").getAsString()+"',");
    sb.append("'saturated_fat':'"+fields_object.get("nf_saturated_fat").getAsString()+"',");
    sb.append("'monounsaturated_fat':'"+fields_object.get("nf_monounsaturated_fat").getAsString()+"',");
    sb.append("'polyunsaturated_fat':'"+fields_object.get("nf_polyunsaturated_fat").getAsString()+"',");
    sb.append("'cholestrol':'"+fields_object.get("nf_cholesterol").getAsString()+"',");
    sb.append("'sodium':'"+fields_object.get("nf_sodium").getAsString()+"',");   
    sb.append("'sugars':'"+fields_object.get("nf_sugars").getAsString()+"',");   
    sb.append("'total_carbohydrate':'"+fields_object.get("nf_total_carbohydrate").getAsString()+"',");   
    sb.append("'calcium':'"+fields_object.get("nf_calcium_dv").getAsString()+"',");   
    sb.append("'iron':'"+fields_object.get("nf_iron_dv").getAsString()+"',");   
    //sb.append("'potassium':'"+fields_object.get("nf_potassium").getAsString()+"',");   
    sb.append("'Vitamin A':'"+fields_object.get("nf_vitamin_a_dv").getAsString()+"',");   
    sb.append("'Vitamin C':'"+fields_object.get("nf_vitamin_c_dv").getAsString()+"',");   
    
    sb.append("'protein':'"+fields_object.get("nf_protein").getAsString()+"'}");  
    
    
    //Restaurant Timings
   /* sb.append(",'Timings':[");
    
    Elements ele1=doc.getElementsByClass("res-timing");
       
    for(int i=0;i<5;i++)
    {
        sb.append("'"+ele1.get(i).attr("title")+"'");
        if(i!=4)
            sb.append(",");
    }
    sb.append("]}");    
    
     
     */
    sb.append("}");
    System.out.println("String: "+sb.toString());
    JsonElement jele = jp.parse(sb.toString());
    out.println("jele::: "+jele);
    
    JsonParser j= new JsonParser();
 
    JsonElement je = j.parse(sb.toString());
out.print("FINAL OUTPUT: "+je);

proxy.disconnect();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }

      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
