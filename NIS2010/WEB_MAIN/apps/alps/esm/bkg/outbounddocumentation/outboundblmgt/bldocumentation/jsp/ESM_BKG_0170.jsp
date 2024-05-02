<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0170.jsp
*@FileTitle : Container Copy And Move
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.11 김영출
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0170Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0170Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentation");

	String bkg_no = "";
	String cntr_nos = "";
	String cntr_vols = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0170Event)request.getAttribute("Event");
		bkg_no = event.getBkgNo();
		cntr_nos = event.getCntrNo();
		cntr_vols = event.getCntrVol();

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
<title>Container Copy And Move</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//
		callback_func = '<%=JSPUtil.getParameter(request, "func", "")%>';
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!--input type="hidden" name="bkg_no" value="<%=bkg_no%>"-->
<input type="hidden" name="cntr_nos" value="<%=cntr_nos%>">
<input type="hidden" name="cntr_vols" value="<%=cntr_vols%>">

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Container Copy &amp; Move</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!--biz page (S)-->
		<table class="search"  width="300">
       		<tr><td class="bg">
			
				<table class="search_sm2" border="0" style="width:280;"> 	
				<tr class="h23">
					<td width="80"><input type="radio" name="radio_gubun" value="C" class="trans" checked >&nbsp;Copy</td>
					<td width="80"><input type="radio" name="radio_gubun" value="M" class="trans">&nbsp;Move</td>
				</tr>
			    </table>
			    <table class="height_5"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:100%;"> 						
				<tr class="h23">
				<td width="160">&nbsp;&nbsp;Source Booking No.</td>
					<td><input type="text" style="ime-mode:disabled;width:100%;" name="bkg_no" value="<%=bkg_no%>" class="input2" readOnly></td>
				 </tr>
				</table> 
				
				<table class="height_5"><tr><td></td></tr></table>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Add">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Del">Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
					</td></tr>
				</table>
				<!-- Button_Sub (E) -->
				<table class="height_5"><tr><td></td></tr></table>
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr class="tr2_head">
					<td width="40%">Original Vol.</td>
					<td class="input2" id="cntr_no" width="35%" rowspan=2></td>
					<td class="input2" id="td_org_vol" width="25%"></td>
				</tr>
				<tr class="tr2_head">
					<td>Partial Total</td>
					<td class="input2" id="td_sum_vol"></td>
				</tr>
				</table>						
		</td></tr></table>
		<!--biz page (E)-->

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Apply">Apply</td>
					<td class="btn1_right">
				</tr></table></td>
			<td class="btn1_line"></td>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>

			</tr>
		</table>
    	<!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>