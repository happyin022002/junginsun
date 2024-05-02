<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.text.*" %>
<%@ page import="fileviewer.rmi.*" %>
<%@ page import="java.rmi.Naming" %>

<%!
	private void responseData(String sb, HttpServletRequest request, HttpServletResponse response)
		{
		response.setContentType("text/html;charset=utf-8");
		OutputStream sout = null;
		try {
			response.reset();
		    String ae = request.getHeader("accept-encoding");
		    // 압축이 가능하면 압축한다.
		    if (ae != null && ae.indexOf("gzip") != -1) {
		        response.setHeader("Content-Encoding", "gzip" );
		        sout = new java.util.zip.GZIPOutputStream( response.getOutputStream() );
		        sout.write( sb.toString().getBytes() );
		    } else {
		    	sout = response.getOutputStream();
		        sout.write( sb.getBytes() );
		    }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				sout.flush();
				sout.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
%>
	
<%
	try{
		String server = request.getParameter("server");
		String port = request.getParameter("port");
		String dir = request.getParameter("filepath");
	    String regexStr = request.getParameter("reg_name");
	    
	    System.out.println("server ->" + server);
	    System.out.println("port ->" + port);
	    System.out.println("filepath ->" + dir);
	    System.out.println("reg_name ->" + regexStr);
	    
	    String bindName = "rmi://" + server + ":"+port+"/FileViewer";
	    FileViewerRmi viewer = (FileViewerRmi)Naming.lookup(bindName);
	    String flistStr = viewer.getFileList(dir, regexStr);
		responseData(flistStr, request, response);
	
	}catch(Exception e){
		e.printStackTrace();
	}
%>