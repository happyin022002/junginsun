<%@page import="java.io.IOException"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="com.hanjin.framework.component.attachment.file.upload.FileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- %
	File file = new File("D:/utility/apache-maven-3.0.3-bin.zip");
	FileInputStream fileInputStream = new FileInputStream(file);
	ByteArrayOutputStream bos = new ByteArrayOutputStream();
    byte[] buf = new byte[1024 * 8];
    try {
        for (int readNum; (readNum = fileInputStream.read(buf)) != -1;) {
            bos.write(buf, 0, readNum); //no doubt here is 0
        }
    } catch (IOException ex) {
    }
    byte[] bytes = bos.toByteArray();

	FileUpload fileUpload = new FileUpload();
	out.print(fileUpload.doUpload(bytes, "test.txt", "COM"));
%-->

</body>
</html>