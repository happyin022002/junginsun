
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_1073.jsp
	 *@FileTitle : Customer EDI ID Inquiry
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg1073Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1073Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String grp_id = JSPUtil.getNull(request.getParameter("grp_id")); ;
	String edi_id = JSPUtil.getNull(request.getParameter("edi_id")); ;
	String grp_nm = JSPUtil.getNull(request.getParameter("grp_nm")); ;
	
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1073Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
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

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="svc_scp_cd" value="">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Customer EDI ID Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="100">Customer Code</td>
						<td>
								<input type="input" name="cnt_cd"   value=""  style="width:30;ime-mode:disabled"  maxlength='2' dataformat='engup' class="input">
								<input type="input" name="cust_seq" value=""  style="width:70;ime-mode:disabled"  maxlength='6' dataformat='num' class="input">
						</td>
					</tr>
					<tr><td height='3'></td></tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="80">Group ID</td>
						<td width='120'>
								<input type="input" name="grp_id"   value="<%=grp_id %>"  style="width:90;ime-mode:disabled"  maxlength='10' dataformat='engupnum' class="input">
						</td>
						<td width="70">TP/EDI ID</td>
						<td>
								<input type="input" name="edi_id"   value="<%=edi_id %>"  style="width:100;ime-mode:disabled"  maxlength='20' dataformat='engupnum' class="input">
						</td>
						<td width="80">Group Name</td>
						<td>
								<input type="input" name="grp_nm"   value="<%=grp_nm %>"  style="width:200;ime-mode:disabled"  maxlength='100' dataformat='custname' class="input">
						</td>						
					</tr>
				</table>
				
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%" style='padding-top:10px'>
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
	
</td></tr>
</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve" >Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Select">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			

</form>
</body>
</html>
 <%@include file="/bizcommon/include/common_alps.jsp"%>
