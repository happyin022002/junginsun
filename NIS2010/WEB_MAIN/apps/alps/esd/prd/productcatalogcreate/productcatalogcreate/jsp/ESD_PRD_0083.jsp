<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0083.jsp
*@FileTitle : Product Catalog 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 이재위
*@LastVersion : 1.0
* 2010.01.18 이재위
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0083Event"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdPrd0083Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
 
	//Logger log = Logger.getLogger("com.hanjin.apps.ProductCatalogManage.ProductCatalogManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdPrd0083Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
 
		DefaultViewAdapter adapter = new DefaultViewAdapter();   
 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to nis2010!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<!-- link href="/css/nis2010_menu.css" rel="stylesheet" type="text/css"-->
<!--link href="/css/nis2010_contents.css" rel="stylesheet" type="text/css"-->
 
<script language="javascript">
    function setupPage(){  
	    loadPage();
    }
</script>
<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd" value="<%=JSPUtil.getParameter(request, "f_cmd") %>">
<input type="hidden" name="pctl_no" value="<%=JSPUtil.getParameter(request, "pctl_no") %>">
<input type="hidden" name="callFunc" value="<%=JSPUtil.getParameter(request, "func") %>">
<input type="hidden" name="valRmk" value="">

<table width="590" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0">
				<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Optimal Route Validation Check </td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<table class="height_10">
			<tr><td>&nbsp;&nbsp;You just have selected the route with more t/s port or more cost than the optimal route in &nbsp;</td></tr>
			<tr><td>&nbsp; the first row. Please select the one reason for using of the route among the reasons below. &nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
		</table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table width="100%"  id="mainTable"> 
						<tr class="h23"><input type="radio" class="trans" name="valChkRadio" id="valChkR1" value="S" checked="checked" />Space Shortage</tr>
						<tr class="height_10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Over Space Lane/VVD : 
										<input type="text" name="valRmk1" maxlength="100" style="width:280;" value="" />&nbsp;)</tr>
						<tr class="h23"><input type="radio" class="trans" name="valChkRadio" id="valChkR2" value="P" />Port Skip</tr>
						<tr class="height_10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Skipped Port/Lane : 
										<input type="text" name="valRmk2" maxlength="100" style="width:300;" value="" />&nbsp;)</tr>
						<tr class="h23"><input type="radio" class="trans" name="valChkRadio" id="valChkR3" value="V" />VSL Phase Out</tr>
						<tr class="height_10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Phased Port/Lane : 
										<input type="text" name="valRmk3" maxlength="100" style="width:300;" value="" />&nbsp;)</tr>
						<tr class="h23"><input type="radio" class="trans" name="valChkRadio" id="valChkR4" value="R" />Customer Request</tr>
						<tr class="h23">&nbsp;</tr>
						<tr class="h23"><input type="radio" class="trans" name="valChkRadio" id="valChkR5" value="C" />Customs Problems</tr>
						<tr class="h23">&nbsp;</tr>
						<tr class="h23"><input type="radio" class="trans" name="valChkRadio" id="valChkR6" value="E" />Clerical Error</tr>
						<tr class="h23">&nbsp;</tr>
						<tr class="h23"><input type="radio" class="trans" name="valChkRadio" id="valChkR7" value="Z" />The Others</tr>
						<tr class="height_10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(
										<input type="text" name="valRmk4" maxlength="100" style="width:400;" value="" />&nbsp;)</tr>
					</table> 
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

<script language="javascript">ComSheetObject('sheet1');</script>

    </td></tr>
</table>
<!-- Outer Table (E)-->

<table class="height_10"><tr><td></td></tr></table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Select</td><td class="btn1_right"></td>
						<td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr>
					</table></td>
					<!-- Repeat Pattern -->
				</tr>
				</table>
				</td></tr>
			</table>
		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->


</form>			
</body>
</html>
