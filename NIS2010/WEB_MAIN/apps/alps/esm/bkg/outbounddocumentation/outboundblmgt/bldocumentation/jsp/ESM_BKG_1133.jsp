<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1133.jsp
*@FileTitle : Container And Booking Comparison
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.14
*@LastModifier : won joo cho
*@LastVersion : 1.0
* 2011.10.14 won joo cho
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg1133Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1133Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentationCM");
	
	String bkgNo      = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1133Event)request.getAttribute("Event");
		//bkgNo      = event.getBkgNo();
		
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
<title>Bangladesh Shipment Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->


	
	<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!-- : ( Search Options ) (S) -->
 			<!--biz page-1 (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0" style="width: 979;"> 
				<tr class="h23">
					<td width="50">Lane</td>
					<td width="80"><input type="text" style="width: 50;" class="input" dataformat="engupnum" maxlength="3" name="slan_cd" value="" tabindex="30"></td>
					<td width="40">VVD</td>
					<td width="100"><input type="text" style="width: 90;" class="input1" dataformat="engupnum" maxlength="9" name="vvd_cd" value="" tabindex="30"></td>
					<td width=40>POL</td>
					<td width="80"><input type="text" style="width: 60;" class="input1" name="pol_cd" maxlength="5" dataformat="engupnum" value="" tabindex="32"></td>
					<td width="80">Upload Date</td>
					<td width="100"><input type="text" style="width: 80;" class="input" dataformat="int" name="cre_dt" maxlength="8" value="" tabindex="33"></td>
					<td width="80">Uploaded by</td>
					<td width=""><input type="text" style="width: 100;"  style="ime-mode:disabled" class="input" dataformat="engupspecial" name="cre_usr_id" maxlength="20" value="" tabindex="34"></td>
				    <td width="80">Booking No.</td>
					<td width=""><input type="text" style="width: 100;"  style="ime-mode:disabled" class="input" dataformat="engupnum" name="bkg_no" maxlength="30" value="" tabindex="35"></td>
				</tr>	
					</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				
				<!-- : ( Grid ) (E) -->	
				

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="button"> 
	       	<tr>
	       	<td class="btn2_bg" style="text-align:left;">
	       		<table border="0" cellpadding="0" cellspacing="0">
	       			<tr>	
						
						
					</tr>
				</table>
	       	</td>
	       	<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_chk_all" id="btn_chk_all">Check All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_uncheckall">Uncheck</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						</tr>
						</table></td>
  					</tr>			
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" id="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_upload">Upload File</td>
						<td class="btn1_right"></td>
						</tr>
						</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>