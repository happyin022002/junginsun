<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.zip.*"%>
<%@ page import="java.io.BufferedInputStream"%>
<%@ page import="java.io.BufferedOutputStream"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.*"%>
<%!
        int currPos = 0;
		int firstClickPos = 0;
		String firstclick = "Y";
		String filename = null;
%>
<%!
private String readString(String command, String filePath, String readPos, String readByte){
	String contents = null;
	try{
		FileInputStream fr = null;
		File file = new File(filePath);
		filename = file.getName();
		long len = file.length();
		int readbytes = Integer.parseInt(readByte);
		int readPosition = Integer.parseInt(readPos);
		
		// 프로그램 소스이면 전체 내용을 출력해야 한다 .
		if ( (filePath.toLowerCase().lastIndexOf(".java") > 0) || (filePath.toLowerCase().lastIndexOf(".jsp")> 0)
		  || (filePath.toLowerCase().lastIndexOf(".js") > 0) || (filePath.toLowerCase().lastIndexOf(".html") > 0) 
		  || (filePath.toLowerCase().lastIndexOf(".xml") > 0)|| (filePath.toLowerCase().lastIndexOf(".query") > 0)) {
			contents = readString(filePath, 0, (int)len);
			currPos = (int)len;
			return contents;
		}
		
		if ( command.equals("first")) {
			contents = readString(filePath, 0, readbytes);
			currPos = readbytes;
		} else if ( command.equals("prev")) {
			readPosition = readPosition - readbytes;
			if ( readPosition < 0 ) readPosition = 0;
			contents = readString(filePath, readPosition, readbytes);
			currPos = readPosition - readbytes;
		} else if ( command.equals("next")) {
			if ( readPosition > len ) readPosition = (int)len - readbytes;
			contents = readString(filePath, readPosition, readbytes);
			currPos = readPosition + readbytes;
		} else if ( command.equals("last")) {
			readPosition = (int)len - readbytes;
			if ( readPosition < 0 ) readPosition = 0;
			contents = readString(filePath, readPosition, readbytes);
			currPos = readPosition + readbytes;
		} else if ( command.equals("download")) {
			// 다운로드시에는 readByte 는 파일의 맨 끝에서부터 readByte 만큼 앞으로 가서 다운로드 받는다.
			firstClickPos = (int)len - readbytes;
			readbytes = (int)len - firstClickPos;
			contents = readString(filePath, firstClickPos, readbytes);
		}
		
	}catch(Exception e){
		e.printStackTrace();
		return null;
	}

	return contents;
}

private String readString(String filePath, int readPos, int readByte){
    FileInputStream fr = null;
    
    InputStream in = null;
    InputStreamReader ir = null;
    BufferedReader br = null;
    
    StringBuffer sbContents = new StringBuffer();
    try {
        File file = new File(filePath);

        System.out.print("len => " + (int)file.length() );
        System.out.print("  Pos => " + readPos );
        System.out.println("  readLen => " + readByte );

        if(!(file.exists() && file.isFile())){
            System.out.println("No File");
            return null;
        }
        
        // SKIP 하고자 하는 바이트가 음수이면 0 으로 설정.
        if ( readPos < 0 ) readPos = 0;
        
        fr = new FileInputStream(file);
        ir = new InputStreamReader(fr,"UTF-8");
        br = new BufferedReader(ir);
        br.skip(readPos);
        
        char[] c = new char[readByte];
        int len = 0;
        
        if ((len = br.read(c, 0, c.length)) != -1) {
        	sbContents.append(c, 0, len);
        }
        
    }catch(FileNotFoundException e){
        e.printStackTrace();
        return null;
    }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
    }finally{
    	try{
            if(br != null){
                br.close();
            }
    	}catch(Exception e){}
    	try{
            if(ir != null){
                ir.close();
            }
    	}catch(Exception e){}
    	try{
            if(fr != null){
                fr.close();
            }
    	}catch(Exception e){}
	}
    return sbContents.toString();
}

// 파일 다운로드...
private void download(HttpServletRequest request, HttpServletResponse response, String contents){
    
    BufferedOutputStream outs = null;
    String savedName = "waslog.txt";
    String zipFileName = "waslog.zip";
    File zipFile = null;
    try {
        response.reset() ;
        String strClient = request.getHeader("user-agent");
        byte[] contentArr = contents.getBytes();
        int zipFileSize = 0;
        FileInputStream fis = null;
        ZipOutputStream zos = null;
    	if ( contents.length() > 100000 ) {
        	zos = new ZipOutputStream(new FileOutputStream(new File(zipFileName)));
        	ZipEntry ze = new ZipEntry(savedName);
    		zos.putNextEntry(ze);
    		zos.write(contentArr);
    		zos.flush();
    		zos.close();
    		savedName = zipFileName;
    		zipFile = new File(savedName);
    		zipFileSize = (int) zipFile.length();
    		fis = new FileInputStream(zipFile);
    		contentArr = new byte[zipFileSize];
    		fis.read(contentArr, 0, zipFileSize);
    	}
    	
    	response.setHeader ("Content-Length", ""+contentArr.length );
        if ( strClient.indexOf("MSIE 5.5") != -1 ) {
            response.setHeader("Content-Type", "doesn/matter; charset=utf-8");
            response.setHeader("Content-Disposition", "filename=" + savedName + "; charset=utf-8");
        } else {
            response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + savedName + ";");
        }
        
        System.out.println("contentArr ==>"+contentArr.length);
        outs = new BufferedOutputStream(response.getOutputStream());
        outs.write(contentArr,0,contentArr.length) ;

    } catch (IOException e) {
        e.printStackTrace();
    } catch ( Exception e ) {
        System.out.print(e+"\n");
    } finally {
        if ( outs != null ) {
            try {
                outs.flush();
            } catch ( Exception e ) {
                System.out.print("Exception occured when outputStream was closed\n");
                e.printStackTrace();
            }
        }
        
        if ( zipFile != null ) {
        	zipFile.delete();
        }
    }
}
%>
<%
        String filepath=request.getParameter("filepath");
        String readPos=request.getParameter("readpos");
        String readbyte=request.getParameter("readbyte");
        String lastFlag=request.getParameter("lastflag");
        String command=request.getParameter("command");
        String dnldSize=request.getParameter("dnldsize");
        
        System.out.print("Read file ==> " + filepath);
        System.out.println("   Read Position ==> " + readPos ) ;
        String contents = null;
        
        if ( command.equals("download")){
        	contents = readString(command, filepath, readPos, dnldSize);
        	download(request,response,contents);
        } else {
        	contents = readString(command, filepath, readPos, readbyte);
        }
        
    	if ( contents != null ) {
    		contents = contents.replaceAll("&","&amp;").replaceAll("<","&lt;")
    		.replaceAll(">","&gt;").replaceAll(" ","&nbsp;").
    		replaceAll("\t","&nbsp;&nbsp;&nbsp;&nbsp;").replaceAll("\\n","<br>");
    	}
        
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FileViewer</title>
<script language="javascript">
window.onload=function(){
	document.getElementsByName("dnldsize")[0].focus();
}

function downloadFile(){
	document.form1.target="dlnd";
    document.form1.command.value='download';
    document.form1.readbyte.value='10000';
    document.form1.readpos.value='<%=currPos%>';
    document.form1.filepath.value='<%=filepath%>';
    document.form1.submit();
}
</script>
</head>
<body>
<font color="blue"><b> FileName : <%=filename %></b></font>
<form name="form1" action="fileview.jsp" method="post">
<div style="width:970px;height:500px;overflow-y:scroll;word-wrap:break-word;word-break:break-all;">
<table width="950px" border="0" cellspacing="0" cellpadding="0" style="border:1px solid #dddddd; border-right:1px solid #E0E0E0;">
	<tr>
		<td style="word-wrap:break-word;word-break:break-all;"><%=contents%></td>
	</tr>	
</table>

</div>
<font color="blue"><b>Download : Last <input type="text" size=20 value="20000" name="dnldsize" /> bytes</b></font>
<input type="button" value="DownLoad" name="download" onClick="downloadFile();" />

<input type="hidden" name="readpos" /> 
<input type="hidden" name="lastflag" />
<input type="hidden" name="readbyte" /> 
<input type="hidden" name="filepath" />
<input type="hidden" name="command" />
</form>

<iframe name="dlnd" style="display:none;width:1px;height:1px;"></iframe>
</body>
</html>