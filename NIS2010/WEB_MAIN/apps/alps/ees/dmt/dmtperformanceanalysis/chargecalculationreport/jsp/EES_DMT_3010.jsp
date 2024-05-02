<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3010.jsp
*@FileTitle : Deleted Charge Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.15 황효근
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt3010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTPerformanceAnalysis.ChargeCalculationReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id	= account.getUsr_id();
		strUsr_nm	= account.getUsr_nm();
		strUsr_ofc	= account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();


		event = (EesDmt3010Event)request.getAttribute("Event");
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
<title>Inactivated Charge Report by Office</title>
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


<!-- 개발자 작업	-->
<input type="hidden" name="usr_ofc_cd"			value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<table class="search"> 
       		<tr><td class="bg">
       		<div id="sch_cond_div" style=display:block;>
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="610">
						
						<table class="search_sm2" border="0" style="width:580;"> 
							<tr class="h23">
								<td width="120">Period </td>
								<td width="220" class="stm"><input type="radio" name="dt_flg" value="F" class="trans" checked>&nbsp;&nbsp;From Date&nbsp;&nbsp;&nbsp;<input type="radio" name="dt_flg" value="D" class="trans">&nbsp;&nbsp;Inactivated Date</td>
								<td width="">
								<input type="text" name="fm_dt" maxlength="8" dataformat="ymd" style="width:80;" class="input1">&nbsp;~
								<input type="text" name="to_dt" maxlength="8" dataformat="ymd" style="width:80;" class="input1">
								<img src="img/btns_calendar.gif" name="btns_calendar" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
							</tr>
						</table>
						
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="610">
						
						<table class="search_sm2" border="0" style="width:580;">
							<tr class="h23">
								<td width="120">DEM/DET Office </td>
								<td width="140" class="stm"><input type="radio" name="ofc_flg" value="R" class="trans" checked>&nbsp;&nbsp;RHQ&nbsp;&nbsp;&nbsp;<input type="radio" name="ofc_flg" value="O" class="trans">&nbsp;&nbsp;Office</td>
								<td width="" class="stm"><script language="javascript">ComComboObject('office',1,80,0,1,0,true);</script>&nbsp;<img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<input 
									type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans">&nbsp;Incl. Sub Office</td>
							</tr>
						</table>
						</td>
						<td width="60">Group by</td>
						<td><select name="grp_flg" style="width:80;" class="input">
						<option value="O" selected>Office</option>
						<option value="R">RHQ</option>
						</select></td>
						</tr>
				</table>		
						
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="130">&nbsp;Inactivated Reason </td>
						<td width="440"><select name="del_cd" style="width:275;" class="input"></select></td>
						<td width="100">Specific Reason</td>
						<td width=""><select name="spec_cd" style="width:275;" class="input"></select></td>
					</tr>
				</table>
				
					</td></tr>
				</table>
				
				<!--  biz_1  (E) -->
				
				<table class="heignt_2"><tr><td colspan="6"></td></tr></table>
			</div>
				
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid  (e) -->
				
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
					
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Minimize">Minimize</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Detail">Detail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>