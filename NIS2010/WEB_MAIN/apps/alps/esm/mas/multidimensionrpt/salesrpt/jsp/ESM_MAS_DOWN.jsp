<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0060.jsp
*@FileTitle : 점소 Weekly 비정형 실적 분석 RPT 조회1
*Open Issues :
*@LastModifyDate : 2010.05.28
*@LastModifier : 송호진
*@LastVersion : 1.0
*=========================================================
* History
* 2016.03.31 김성욱 엑셀 다운로드용
*=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.common.Utils"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event.EsmMas0060Event"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.*"%>
<%
    String fname = Utils.iif(request.getParameter("fname")==null, "cc.xls", request.getParameter("fname"));

    try {

    }catch(Exception e) {
        out.println(e.toString());
    }

%>
<html>
<head>
<title>Inquiry by Customized Condition</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	
    function setupPage(){
        var errMessage = "";
        
        loadPage(col_desc, col_nm);
    }
</script>
</head>
<body >
<%
// ServletContext context = getServletContext(); // 서블릿에 대한 환경정보를 가져옴
String saveFolder = "C:\\dev\\work_alps_new\\NIS2010_DIM\\WEB_MAIN\\sample";
// 실제 파일이 저장되어 있는 폴더의 경로
String realFolder = saveFolder;//context.getRealPath(saveFolder);
// 다운받을 파일의 전체 경로를 filePath에 저장
String filePath = realFolder + "\\" + fname;

try{
 // 다운받을 파일을 불러옴
 File file = new File(filePath);
 if( !file.exists()) out.println(filePath + ". file not found");
 byte b[] = new byte[4096];
 
 response.reset();
	response.setContentType("application/octet-stream");
	
	response.setHeader("Content-Disposition", "attatchment; filename = " + fname);
	response.setHeader("Content-Length", String.valueOf((int)file.length()));
	
	FileInputStream is = new FileInputStream(filePath);
	ServletOutputStream sos = response.getOutputStream();
	
	int numRead;
	while((numRead = is.read(b,0,b.length)) != -1){
		sos.write(b,0,numRead);
	}
	
	sos.flush();
	sos.close();
	is.close();
 
} catch(Exception e){
	e.printStackTrace();
}
%>
</body>
</html>
