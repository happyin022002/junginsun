<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3011.jsp
*@FileTitle : Deleted Charge Report by Office - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.17 황효근
* 1.0 Creation
2011.08.11 김경섭[CHM-201112592-01][DMT]Deleted Charge Report by Office 화면 보완 3010 > 3011조회시 Office 다중조회 가능토록함.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt3011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTPerformanceAnalysis.ChargeCalculationReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();
		

		event = (EesDmt3011Event)request.getAttribute("Event");
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
<title>Inactivated Charge Report by Office - Detail(s)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		/* modal창에서 post 방식으로 받음*/
		form.ofc_cd_delt_rsn_cd_list.value = window.dialogArguments["ofc_cd_delt_rsn_cd_list"];
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<div id='dbug'></div>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<!-- 개발자 작업	-->
<input type="hidden" name="dt_flg"			        value="<%=JSPUtil.getParameter(request, "dt_flg", "")%>">
<input type="hidden" name="fm_dt"		        	value="<%=JSPUtil.getParameter(request, "fm_dt", "")%>">
<input type="hidden" name="to_dt"			        value="<%=JSPUtil.getParameter(request, "to_dt", "")%>">
<input type="hidden" name="grp_flg"			        value="<%=JSPUtil.getParameter(request, "grp_flg", "")%>">
<input type="hidden" name="ofc_cd"			        value="<%=JSPUtil.getParameter(request, "ofc_cd", "")%>">
<input type="hidden" name="del_cd"			        value="<%=JSPUtil.getParameter(request, "del_cd", "")%>">
<input type="hidden" name="ofc_cd_delt_rsn_cd_list"	value="">
<input type="hidden" name="usr_rhq_ofc_cd"	        value="<%=strRhq_ofc_cd%>">

<!-- 지정 화면 Access 권한 정보 조회용  -->
<input type="hidden" name="role_permit">
<input type="hidden" name="role_auth">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Inactivated Charge Report by Office– Detail(s)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 <table class="search"> 
       		<tr><td class="bg">				
				
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
				
				<table class="search" border="0" style="width:466;"> 
				<tr class="h23">
					<td width="70">CNTR Q'ty</td>
					<td width=""><input type="text" name="cntr_qty" style="width:50;text-align:right;" class="input2" readonly></td>
					</tr>
				</table>
				
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			
		
	    	<!-- Button_Sub (E) -->
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
		    <tr>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ByBKG">By BKG</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ByCNTR">By CNTR</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			<td class="btn1_line"></td>
			<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr></table></td>
			
			</tr></table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>