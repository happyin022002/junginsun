<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0742.jsp
*@FileTitle : B/L Rider
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.16 이진서
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.event.EsmBkg0742Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0742Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoBookingConduct.SpecialCargoRider");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0742Event)request.getAttribute("Event");
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
<title>B/L Rider</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="s_rgst_dt">
<input type="hidden" name="e_rgst_dt">


<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
	
	
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
		<!--Page Title, Historical (E)-->
	
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="620">
						
							<table class="search_sm2" border="0" width="580">
								<tr class="h23">
									<td width="35">Type</td>
									<td class="stm">
									<input type="radio" name ='ridr_tp_cd' value='D'  class="trans" checked>&nbsp;D/G Rider&nbsp;&nbsp;&nbsp;
									<input type="radio" name ='ridr_tp_cd' value='A'  class="trans">&nbsp;Awkward Rider&nbsp;&nbsp;&nbsp;
									<input type="radio" name ='ridr_tp_cd' value='B'  class="trans">&nbsp;Break Bulk Rider &nbsp;&nbsp;&nbsp;
									<input type="radio" name ='ridr_tp_cd' value='G'  class="trans">&nbsp;General&nbsp;&nbsp;&nbsp;
									<input type="radio" name ='ridr_tp_cd' value='C'  class="trans">&nbsp;Certificate
									</td>
								</tr>
							</table>
						
						</td>
						<td width="45">T/VVD</td>
						<td width="100"><input type="text" style="width:94;" value="" name ='vsl_cd' dataformat="uppernum"  maxlength="9"  fullfill caption="T/VVD" class="input1"></td>
						<td width="32">T/POL</td>
						<td width="70"><input type="text" style="width:60;" value="" name ='pol_cd' dataformat="uppernum"  maxlength="5" class="input"></td>
						<td width="32">T/POD</td>
						<td><input type="text" style="width:60;" value="" name ='pod_cd'  dataformat="uppernum" maxlength="5" class="input"></td></tr>
					<tr><td height="3"></td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90">Register Date</td>
						<td width="230" class="sm">
						<input type="text" name="vs_rgst_dt" style="width:80;" class="input1" value="" dataformat="ymd" caption="시작일" maxlength="10" size="10" style="ime-mode:disabled"  >&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;
						<input type="text" name="ve_rgst_dt" style="width:82;" class="input1" value="" dataformat="ymd" caption="종료일" maxlength="10" size="10"  style="ime-mode:disabled" >&nbsp;
						<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" onClick="callDatePop('ETD')">
						</td>
						<td width="92">Register Office</td>
						<td width="62"><input type="text" style="width:46;" value="" name ='rgst_ofc_cd' dataformat="uppernum"  maxlength="6" class="input"></td>
						<td width="72">Register By</td>
						<td width="76"><input type="text" style="width:60;" value="" name ='rgst_usr_id' dataformat="engnum" 	 maxlength="20" class="input"></td>
						<td width="92">Booking Office</td>
						<td width="62"><input type="text" style="width:46;" value="" name ='bkg_ofc_cd' dataformat="uppernum" 	 maxlength="6" class="input"></td>
						<td width="72">Sales Office</td>
						<td width="62"><input type="text" style="width:46;" value="" name ='ob_sls_ofc_cd' dataformat="uppernum" 	 maxlength="6" class="input"></td>
						<td width="32">Lane</td>
						<td align="right"><input type="text" style="width:35;" value="" name ='slan_cd' dataformat="uppernum" 		 maxlength="3" class="input"></td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90">Booking No.</td>
						<td width="230"><input type="text" style="width:97;" value="" name ='bkg_no'	 dataformat="uppernum" 	   caption="Booking No." class="input1"></td>
						<td width="92">B/L No.</td>
						<td width="211"><input type="text" style="width:100;" value="" name ='bl_no'	 dataformat="uppernum" 	 maxlength="12"  fullfill caption="B/L No."  class="input1"></td>
						<td width="91">Container No.</td>
						<td><input type="text" style="width:100;" value="" name ='cntr_no'		 dataformat="uppernum"  maxlength="14" class="input"></td>
						<td width="35">VVD</td>
						<td width="110"><input type="text" style="width:94;" value="" name ='pre_post_vsl_cd' dataformat="uppernum"  maxlength="9"  fullfill caption="VVD" class="input1"></td>
						</tr>
				</table>
				<!--  biz_1   (E) -->		
					
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
			
			
			<!-- Grid_2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid_2 (E) -->		
			
			</td></tr>
		</table>
		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
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
<!-- : ( Button : pop ) (E) -->
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>	
<!-- 개발자 작업  끝 -->
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</body>
</html>