<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0451.jsp
 *@FileTitle : history pop up
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.08.25
 *@LastModifier : jsy
 *@LastVersion : 1.0
 * 2011.08.25 jsy
 * 1.0 Creation
 * --------------------------------------------------------
 * 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0451Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0451Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String srNo 		= JSPUtil.getNullNoTrim(StringUtil.xssFilter(request.getParameter("sr_no")));
	String faxLogRefNo 	= JSPUtil.getNullNoTrim(StringUtil.xssFilter(request.getParameter("fax_log_ref_no")));

	
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0451Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	
	
%>
<html>
<head>
<title>Si Auto History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		var formObj = document.form;
		formObj.sr_no.value 			= "<%= srNo %>";
		formObj.fax_log_ref_no.value 	= "<%= faxLogRefNo %>";

		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();" >
<form name="form">

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sr_no">
<input type="hidden" name="fax_log_ref_no">
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Si Auto History</td></tr>
		</table>
	<!-- : ( Title ) (E) -->

	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<!-- 
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">SI No.</td>
					<td width="150"><input type="text" name="sr_no" style="width:110" value="" dataformat="engupnum" maxlength="12" readonly ></td>
					<td width="90">Ref No.</td>
					<td width="150"><input type="text" name="fax_log_ref_no" style="width:100" value="" readonly></td>
				</tr>
				</table>
				 -->
				 
 	
				
				<!--  biz_1   (E) -->
												
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				
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
			
    <table class="height_5"><tr><td></td></tr></table>
	
		</td></tr>
			</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton" >
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0"	cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
<!-- 
							
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_del">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_open">Open SR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_sitrans">Send to sitrans</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				  
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transfer">Transfer to DC</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
							
				<td class="btn1_line"></td>	
 -->

 				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>
