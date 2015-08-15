/**
* OWASP Benchmark Project v1.2beta
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01392")
public class BenchmarkTest01392 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("vector")[0];
		}
		

		String bar = new Test().doSomething(param);
		
		byte[] input = new byte[1000];
		String str = "?";
		Object inputParam = param;
		if (inputParam instanceof String) str = ((String) inputParam);
		if (inputParam instanceof java.io.InputStream) {
			int i = ((java.io.InputStream) inputParam).read(input);
			if (i == -1) {
				response.getWriter().println("This input source requires a POST, not a GET. Incompatible UI for the InputStream source.");
				return;
			}			
			str = new String(input, 0, i);
		}
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie", str);
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);

		response.getWriter().println("Created cookie: SomeCookie: with value: '"
		  + org.owasp.esapi.ESAPI.encoder().encodeForHTML(str) + "' and secure flag set to: true");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a6791 = param; //assign
		StringBuilder b6791 = new StringBuilder(a6791);  // stick in stringbuilder
		b6791.append(" SafeStuff"); // append some safe content
		b6791.replace(b6791.length()-"Chars".length(),b6791.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6791 = new java.util.HashMap<String,Object>();
		map6791.put("key6791", b6791.toString()); // put in a collection
		String c6791 = (String)map6791.get("key6791"); // get it back out
		String d6791 = c6791.substring(0,c6791.length()-1); // extract most of it
		String e6791 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6791.getBytes() ) )); // B64 encode and decode it
		String f6791 = e6791.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f6791); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass