<%-- 
    Document   : get_data
    Created on : 07-Jun-2016, 12:01:43
    Author     : user
--%>

<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        
            
        String food_name = "Pizza";
        
        //String[] my_response = new String[15];
        StringBuffer sb = new StringBuffer();
        sb.append("{'food_name':'"+food_name+"',");
        //String url="https://www.zomato.com/ncr/sector-62-noida-restaurants?q=";
        String url="https://www.zomato.com/ncr/restaurants?q="+food_name;
        sb.append("'Restaurants':[");
        
        Document doc = Jsoup.connect(url).get();
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
         
    String url1="https://api.nutritionix.com/v1_1/search/"+food_name+"?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat%2Cnf_calories%2Cnf_calories_from_fat%2Cnf_total_fat%2Cnf_saturated_fat%2Cnf_monounsaturated_fat%2Cnf_polyunsaturated_fat%2Cnf_sugars%2Cnf_protein%2Cnf_sodium%2Cnf_cholesterol&appId=5e888a6f&appKey=985c57a8b1e7332ed344465c82e9d861";
   

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
    sb.append("'protein':'"+fields_object.get("nf_protein").getAsString()+"'}}");   
        
    out.println("String: "+sb.toString());
    JsonElement jele = jp.parse(sb.toString());
    out.println("JSON element: "+jele);
 
    
        %>
        
    </body>
</html>
