<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.text.*" %>

<%!
	public String formatDate(long date) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date);
		Date dt = cal.getTime();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd  HH: mm: ss");
		return ft.format(dt);
	}
%>
<%!
	public String formatNumber(long fsize) {
		DecimalFormat dfm = new DecimalFormat("###,##0");
		
		return dfm.format(fsize);
	}
%>
<%!
	private void responseData(StringBuffer sb, HttpServletRequest request, HttpServletResponse response)
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
		        sout.write( sb.toString().getBytes() );
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
	String dir = request.getParameter("filepath");
    String regexStr = request.getParameter("reg_name");
    System.out.println("filepath ->" + dir);
    System.out.println("reg_name ->" + regexStr);
    StringBuffer tdcBuffer = new StringBuffer();
    
    // 헤더설정
    tdcBuffer.append("image:String^linkFilePath:String^filePath:String^fileRole:String^fileSize:String^fileDate:String\r\n");
    
    if ( regexStr == null ) regexStr = "";
    if(dir == null){
        System.out.println("param error");
    }
	java.io.File f = new java.io.File(dir);
	if(f.exists()){
	    String [] filelist = f.list();
	    
	    if ( filelist == null ) throw new Exception("File list is null!!");
        Arrays.sort(filelist);

        
		if(f.getParent() != null){
				String sep = f.getParent().replaceAll("\\\\","/");
				tdcBuffer.append("./img/btns_file.gif^");
	        	tdcBuffer.append("javascript:getFileList('"+sep+"');^");
	        	tdcBuffer.append("...Parent");
	        	tdcBuffer.append("^^^\r\n");
		}

        String filepath = null;
        java.io.File f2 = null;
        String separator = "/";

        String regexStr2 = null;    // 정규표현식
        boolean iswild = regexStr != null && !regexStr.equals("");   // 와일드카드 적용여부
        java.util.regex.Pattern p = null;
        java.util.regex.Matcher m = null;

        if (iswild) {
            // 와일드카드를 정규표현식으로 변환
            regexStr2 = regexStr
            //.toUpperCase()    // 대소문자 구분 안할 경우
            .replaceAll("\\.","\\\\.").replaceAll("\\^","\\\\^").replaceAll("\\$","\\\\$")
            .replaceAll("\\(","\\\\(").replaceAll("\\)","\\\\)").replaceAll("\\[","\\\\[")
            .replaceAll("\\]","\\\\]").replaceAll("\\{","\\\\{").replaceAll("\\}","\\\\}")
            .replaceAll("\\+","\\\\+").replaceAll("\\|","\\\\|")
            .replaceAll("\\*","[\\\\w\\\\W]*").replaceAll("\\?","\\.");

            p = java.util.regex.Pattern.compile(regexStr2);
        }
        String[] fPerm = null;
	    for(int i=0;i<filelist.length;i++){
	    	filepath = dir + separator + filelist[i];
	        f2 = new java.io.File(filepath);
	        
	        fPerm = new String[3];
	        fPerm[0] = "- ";
	        fPerm[1] = "- ";
	        fPerm[2] = "- ";
	        
	        
			if ( f2.canRead()) fPerm[0] = "r ";
			if ( f2.canWrite()) fPerm[1] = "w ";
			if ( f2.canExecute()) fPerm[2] = "x ";
			
			String permission = fPerm[0] + fPerm[1] + fPerm[2];
			
	        if (iswild) {
	            //m = p.matcher(f2.getName().toUpperCase());   // 대소문자 구분 안할 경우
	            m = p.matcher(f2.getName());
	            if (!m.matches() || f2.getParent()==null) {
	                continue;
	            }
	        }

            if ( f2.isDirectory() ) {
                tdcBuffer.append("./img/btns_file.gif^");
                tdcBuffer.append("javascript:getFileList('"+filepath+"');^");
                tdcBuffer.append(f2.getName()+ "^" );
            } else if (f2.isFile()) {
                tdcBuffer.append("./img/btns_note.gif^");
                tdcBuffer.append("javascript:getFileContents('"+filepath+"');^");
                tdcBuffer.append(f2.getName()+ "^" );
            }
            tdcBuffer.append(permission).append("^");
            tdcBuffer.append(formatNumber(f2.length())).append("^");
            tdcBuffer.append(formatDate(f2.lastModified())).append("\r\n");
	    }
	}else{
		tdcBuffer.append("No file list ^^^^\r\n");
	}
	responseData(tdcBuffer, request, response);

}catch(Exception e){
	e.printStackTrace();
}
%>