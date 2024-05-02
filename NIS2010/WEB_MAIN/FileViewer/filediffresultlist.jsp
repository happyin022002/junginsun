<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>File Verify Result</title>
</head>
<body>
<center><h2>File Verification Result</h2></center>
<%!
	//두개의 파일을 읽어서 서로다른 내용인지 비교한다.
	public String verifyFile(HttpServletRequest request, String src, String dest){
		String rtnFileName = null;
		try{
			HashMap<Object, Object> diffResult = new HashMap<Object, Object>();
			File srcFile = new File(src);
			File destFile = new File(dest);
			String[] srcFileLst = null;
			rtnFileName = "/Temp/"+request.getSession().getId();
			if ( srcFile.isDirectory() && destFile.isDirectory() ){
				srcFileLst = srcFile.list();
				for ( int i=0; i<srcFileLst.length; i++ ){
					File srcFile1 = new File(src + "/" + srcFileLst[i]);
					if ( srcFile1.isDirectory()) continue;
					File destFile1 = new File(dest + "/" + srcFile1.getName());
					if ( diffFile(srcFile1,destFile1) ) {
						diffResult.put(src + "/" + srcFile1.getName() + "^" + dest + "/" + srcFile1.getName(), "SAME");
					} else {
						diffResult.put(src + "/" + srcFile1.getName() + "^" + dest + "/" + srcFile1.getName(), "DIFF");
					}
				}
			} else if ( srcFile.isFile() && destFile.isFile() ){
				if ( diffFile(srcFile,destFile) ) {
					diffResult.put(srcFile.getPath() + "^" + destFile.getPath(), "SAME");
				} else {
					diffResult.put(srcFile.getPath() + "^" + destFile.getPath(), "DIFF");
				}
			} else {
				return null;
			}
			
			saveFile(rtnFileName, diffResult);
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return rtnFileName;
	}

	// 두개의 파일을 읽어서 서로다른 내용인지 비교한다.
	public boolean diffFile(File srcFile, File destFile) {
		boolean isSame = true;
		FileInputStream srcFi = null;
		FileInputStream destFi = null;
		try{
			long srcBytes = srcFile.length();
			long destBytes = destFile.length();

			// 파일의 사이즈가 같지 않으면 파일의 내용은 틀리다.
			if ( srcBytes != destBytes ) {
				System.out.println("Not Valid => " + srcBytes + "," + destBytes);
				return false;
			}
			
			srcFi = new FileInputStream(srcFile);
			destFi = new FileInputStream(destFile);

			byte[] srcByteArr = new byte[(int)srcBytes];
			byte[] destByteArr = new byte[(int)destBytes];
			
			srcFi.read(srcByteArr);
			destFi.read(destByteArr);
			
			for ( int i=0; i<srcByteArr.length; i++ ) {
				if ( srcByteArr[i] != destByteArr[i] ) {
					System.out.println("Not Valid" + srcByteArr[i] + "," + destByteArr[i]);
					isSame = false;
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		} finally {
			try{
				if ( srcFi != null ) srcFi.close();
			}catch(Exception e){
				//e.printStackTrace();
			}
			try{
				if ( destFi != null ) destFi.close();
			}catch(Exception e){
				//e.printStackTrace();
			}
		}
		
		return isSame;
	}

	// 파일에 HashMap 의 내용을 저장한다.
	public void saveFile(String fileName, HashMap<Object, Object> mapResult) {
		FileOutputStream fo = null;
		try{
			String savePath = fileName;
			fo = new FileOutputStream(savePath, false);
			Collection cols = mapResult.keySet();
			Iterator ite = cols.iterator();
			StringBuffer sb = new StringBuffer();
			while(ite.hasNext()){
				String key = (String)ite.next();
				String value = (String)mapResult.get(key);
				sb.append(key + "^" + value + "\n");
			}
			byte[] writeByte = sb.toString().getBytes();
			fo.write(writeByte);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				fo.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	// 파일의 내용을 읽어서 반환한다.
	public String[] readFile(String fileName) {
		String[] rtnContents = null;
		FileReader fr = null;
		BufferedReader br = null;
		try{
			List<Object> contents = new ArrayList<Object>();
			fr = new FileReader(new File(fileName));
			br = new BufferedReader(fr);
			while(true){
				String cnts = br.readLine();
				if ( cnts == null ) break;	
				contents.add(cnts);
			}
			
			rtnContents = new String[contents.size()];
			rtnContents = (String[])contents.toArray(rtnContents);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				br.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				fr.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return rtnContents;
	}
%>
<script type="text/javascript">
    function getFileContents(srcFileName, destFileName){
        var frm = document.form;
        frm.srcFilePath.value=srcFileName;
        frm.destFilePath.value=destFileName;
        frm.submit();
    }
    
    function getFileDetailContents(filePath){
        var frm = document.form;
        frm.viewfilepath.value=filePath;
        frm.action="filediffdetailview.jsp";
        frm.submit();
    }    
</script>

<form name="form" action="filediffview.jsp" method="post">
<input type="hidden" name="viewfilepath" />
<input type="hidden" name="srcFilePath" />
<input type="hidden" name="destFilePath" />
<table style="width:95%;">
	<tr>
		<td align="center" style="width:300px;">파일경로1</td >
		<td align="center" style="width:300px;">파일경로2</td >
		<td align="center" style="width:70px;">결과</td>
	</tr>
<%
	String srcFilePath = request.getParameter("srcfilepath");
	String destFilePath = request.getParameter("destfilepath");
	String fileName = verifyFile(request, srcFilePath, destFilePath);
	String contents[] = readFile(fileName);
	String srcFileName = null;
	String destFileName = null;
	String diffResult = null;
	for ( int i=0; i<contents.length; i++ ) {
		StringTokenizer st = new StringTokenizer(contents[i], "^");
		if ( st.hasMoreElements() ){
			srcFileName = (String)st.nextElement();
			srcFileName = srcFileName.replaceAll("\\\\","/");
		}
		
		if ( st.hasMoreElements() ) {
			destFileName = (String)st.nextElement();
			destFileName = destFileName.replaceAll("\\\\","/");
		}
		
		if ( st.hasMoreElements() ) {
			diffResult = (String)st.nextElement();
		}
%>
	<tr>
		<td align="left" style="width:300px;">
		 <a href='#' onclick='javascript:getFileDetailContents("<%=srcFileName %>");'><%=srcFileName %></a>	
		</td >
		<td align="left" style="width:300px;">
		<a href='#' onclick='javascript:getFileDetailContents("<%=destFileName %>");'><%=destFileName %></a>	
		</td >	
		<td>
		<a href='#' onclick='javascript:getFileContents("<%=srcFileName %>", "<%=destFileName %>");'><%=diffResult %></a>	
		</td>
	</tr>
<%
	}
%>
</body>
</html>