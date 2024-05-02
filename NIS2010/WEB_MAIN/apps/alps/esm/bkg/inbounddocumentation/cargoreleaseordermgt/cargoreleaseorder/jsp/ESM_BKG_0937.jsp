<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0937.jsp
*@FileTitle : Cargo Release Order_E-D/O inquiry _Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.08.26 임진영
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0937Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0937Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoReleaseOrderMgtSC.CargoReleaseOrderBC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0937Event)request.getAttribute("Event");
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
<title>Receiver Info.</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Receiver Info.</span></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="60">&nbsp;&nbsp;D/O No.</td> 
					<td width="120"><input type="text" name="do_no" style="width:100;text-align:left;" class="input1" value="<%=JSPUtil.getNull(request.getParameter("do_no"))%>" maxlength="12" dataformat="eng" style="ime-mode:disabled"></td>
					<td id="div_multi_cntr" width="100">Multi-Container</td> 
					<td width=""><select style="width:110;" class="input1" name = "multi_cntr_no" onchange="fnMoveTrucker(this.value)"></select></td>
				</tr>
				</table>
		</td>
		</tr>
		</table>
		
		<!-- Tab ) (S) -->
     	<table class="height_10"><tr><td></td></tr></table>
				<!-- Tab (S) -->
				 <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td width="100%">
							<script language="javascript">ComTabObject('tab1')</script>
						</td>
					</tr>
				</table>
		<!-- Tab ) (E) -->

	<!--  Tab_1 (S) -->
	<div id="tabLayer" style="display:inline">
		<table class="search"> 
       		<tr><td class="bg">
				<table class="grid2" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="120" class="tr2_head">D/O Receiver</td> 
					<td colspan="3"><input type="text" name = "rcvr_cnee_nm" style="width:100%" class="input" value="" maxlength="100"></td>
				</tr>
				<tr class="h23">
					<td width="120" class="tr2_head">E-Mail Address</td> 
					<td width="200"><input type="text" name = "rcvr_eml" style="width:100%" class="input" value="" maxlength="50"></td>
					<td width="80" class="tr2_head">Fax No.</td> 
					<td width=""><input type="text" name = "rcvr_fax_no" style="width:100%" class="input" value="" maxlength="20" onKeyPress="ComKeyOnlyNumber(this,'-');" style="ime-mode:disabled"></td>
				</tr>
				<tr class="h23">
					<td width="" class="tr2_head">Phone No.</td> 
					<td><input type="text" name = "rcvr_phn_no" style="width:100%" class="input" value="" maxlength="30" onKeyPress="ComKeyOnlyNumber(this,'-');" style="ime-mode:disabled"></td>
					<td class="noinput2"></td> 
					<td width="" class="noinput2"></td>
				</tr>
				</table>
			</td></tr>
		</table>
	</div>
	<!--  Tab_1 (E) -->

	<!--  Tab_2 (S) -->
	<div id="tabLayer" style="display:none">
		<table class="search"> 
       		<tr><td class="bg">
				<table class="grid2" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="120" class="tr2_head">Trucker</td> 
						<td colspan="3"><input type="text" name = "trkr_nm" style="width:100%" class="input" value="" maxLength="200"></td>
					</tr>
					<tr class="h23">
						<td width="120" class="tr2_head">Phone No.</td> 
						<td width="200"><input type="text" name = "trkr_phn_no" style="width:100%" class="input" value="" maxLength="20" onKeyPress="ComKeyOnlyNumber(this,'-');" style="ime-mode:disabled"></td>
						<td width="80" class="tr2_head">MRN No.</td> 
						<td width=""><input type="text" name = "trkr_mvmt_ref_no" style="width:100%" class="input" value="" maxLength="30"></td>
					</tr>
					<tr class="h23">
						<td width="" class="tr2_head">Empty Return Yard</td> 
						<td><input type="text" name = "trkr_mty_rtn_yd_cd" style="width:100%" class="input" value="" maxLength="7" caption="Empty Return Yard" fullfill="true"></td>
						<td class="noinput2"></td> 
						<td width="" class="noinput2"></td>
					</tr>
				</table>
			</td></tr>
		</table>
	</div>
	<!--  Tab_2 (E) -->

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
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Mail_Send">Mail Send</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Fax_Send">Fax Send</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr></table>
    <!--Button (E) -->
	</td></tr>
</table>
</td>
</tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- Grid  (S) -->
<table width="600"  id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
			<script language="javascript">ComSheetObject('sheet2');</script>
			<script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>
</table>
<!-- Grid (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>