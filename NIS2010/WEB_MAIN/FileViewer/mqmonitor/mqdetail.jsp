<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.BufferedInputStream"%>
<%@ page import="java.io.BufferedOutputStream"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.*"%>

<%!
private String execute(String command){
	String contents = null;
	try{
		System.out.println("MQ Command => " + command ) ;
		Runtime r = Runtime.getRuntime();
		Process p = r.exec(command);
		byte[] result = new byte[2048];
		InputStream is = p.getInputStream();
		int len = 0;
		StringBuffer rtnBuffer = new StringBuffer();
		while(true){
			len = is.read(result);
			if ( len == -1 ) break;
			rtnBuffer.append(new String(result));
			for ( int i=0; i<result.length; i++) result[i] = 0x00;
		}
		contents = rtnBuffer.toString();
	}catch(Exception e){
		e.printStackTrace();
		return null;
	}

	return contents;
}
%>
<%!
private String getUserHome(String userid){
	String homedir = null;
	FileReader fr = null;
	BufferedReader br = null;
	try{
		String passwdFile = "/etc/passwd";
		String passwdLine = "";
		String[] arr = null;
		fr = new FileReader(new File(passwdFile));
		br = new BufferedReader(fr);
		while(true){
			passwdLine = br.readLine();
			/**
			    passwrd 파일 예시
			    mqm:HiM1cLLrp7T0A:320:320::/home/mqm:/usr/bin/ksh
			*/
			if ( passwdLine == null ) break;
			arr = passwdLine.split(":");
			if ( arr[0].equals(userid)){
				homedir = arr[5];
				break;
			} 
		}
	}catch(Exception e){
		e.printStackTrace();
		return null;
	}finally{
		try{
			if ( br != null ) br.close();
		}catch(Exception e){}
		try{
			if ( fr != null ) fr.close();
		}catch(Exception e){}
	}
	
	return homedir;
}
%>
<%
        String mqname=request.getParameter("mqname");
        String cmdtype=request.getParameter("cmdtype");
        
        System.out.print("MQ Name ==> " + mqname);
        System.out.println("   CMD ==> " + cmdtype ) ;
        String command = null;
        String homeDir = getUserHome("mqm");
        
        String[] mqnames = mqname.split(",");
        
        StringBuffer sb = new StringBuffer();
        
        for ( int i=0; i<mqnames.length; i++ ) {
            if ( cmdtype.equals("status") ) {
            	command = homeDir + "/bin/dis " + mqnames[i] ;
            }

            String contents = null;
            contents = execute(command);
            sb.append(contents).append("\n");
        }

        
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MQ Status Result</title>

</head>
<body>
<table width="950px" border="0" cellspacing="0" cellpadding="0" style="border:1px solid #dddddd; border-right:1px solid #E0E0E0;">
	<tr>
		<td style="word-wrap:break-word;word-break:break-all;"><pre><%=sb.toString()%></pre></td>
	</tr>	
</table>
</body>
</html>