<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0518.jsp
*@FileTitle : B/L Inquiry by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.17 이수빈
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

<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0518Event"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0518Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//서버에서 발생한 에러
	String strErrMsg 			= "";	//에러메세지
	int rowCount	 			= 0;	//DB ResultSet 리스트의 건수

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";
	String strUsr_id	= "";
	String strUsr_nm	= "";
	
	String strCntrNo	= "";

	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CustomsReport");
	
	String vvdCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0518Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strCntrNo = JSPUtil.getNullNoTrim(request.getParameter("cntr_no"));
		vvdCd = JSPUtil.getNullNoTrim(request.getParameter("vvd"));
	
		if ("".equals(vvdCd)) vvdCd  = JSPUtil.getParameter(request, "vvd_cd"); 
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Inquiry by Container</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="javascript:setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bl_no">

<!-- 개발자 작업	-->
<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %> 

<!--table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
        <!--Page Title, Historical (S)--
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">B/L Inquiry by Container</span></td></tr>
        </table>
        <!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="88">Container No.</td>
					<td width="150"><input type="text" name="cntr_no" style="width:107; ime-mode: disabled;" class="input1" value="<%=strCntrNo%>"
                        dataformat="eng" maxlength="11" fullfill caption="Container No."></td>
					<td width="25">VVD</td>
					<td width="150"><input type="text" name="vvd" style="width:90; ime-mode: disabled;" class="input" value="<%=vvdCd%>"
                        dataformat="eng" maxlength="9" fullfill caption="VVD"></td>
                    <td width="70">B/L Type</td>
					<td width=""><select name="bl_type" class="input">
						<option value="0" selected>ALL</option>
						<option value="1">Master B/L</option>
						<option value="2">House B/L</option></select>
					</td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
					
				
				<!--  biz_1   (E) -->
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
			</td></tr>
		</table>
	<!-- Grid BGHNBR0038E Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BLInquiry">B/L Inquiry</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	
<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %> 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>