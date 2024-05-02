<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0219.jsp
*@FileTitle : Performance by S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.01
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.12.01 최종혁
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
<%@ page import="com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0219Event"%>

<%
	EsdEas0219Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String ofc_cd 	    = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  =	account.getUsr_id();
		ofc_cd 	= account.getOfc_cd();

		event = (EsdEas0219Event)request.getAttribute("Event");
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
<title>Expense Audit case Registration</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	<%= JSPUtil.getIBCodeCombo("s_eac_expn_tp_cd", "", "CD03352", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("s_eac_tp_cd", "", "CD00587", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("s_eac_rsn_cd", "", "CD03338", 0, "")%>
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ofc_cd" 		value="<%=ofc_cd%>" >
<input type="hidden" name="hq_ofc_use_flg" value="Y">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">	
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
			
		<!--Button (S) -->
	    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_downexcel">Down Excel</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--Button (E) -->
		 
		<!--biz page (S)-->
		<table class="search" > 
       	<tr><td class="bg">		
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="100">Office Type</td>
					<td width="110" style="padding-left:1;">
						<script language="javascript">ComComboObject('s_ofc_tp_cd',1,100,1,1,0);</script>
					</td>
				
					<td width="80">RHQ</td>
					<td width="110" style="padding-left:1;">
						<script language="javascript">ComComboObject('s_rhq_ofc_cd',1,100,1,0,0);</script>
					</td>
					
					<td width="120">Audit Office</td>
					<td width="130" style="padding-left:0;">
						<script language="javascript">ComComboObject('s_ofc_cd',1,100,0,0,0);</script>
					</td>
					
					<td width="120">Audit Month</td>
					<td width="190">
						<input type="text" name="s_eac_yrmon_fm" dataformat="ym" maxlength="7" size="10"  style="width:60; text-align:center;" class="input1" value="">&nbsp;<img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"> ~
						<input type="text" name="s_eac_yrmon_to" dataformat="ym" maxlength="7" size="10"  style="width:60; text-align:center;" class="input1" value="">&nbsp;<img name="btns_calendar_e" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">						
					</td>
					<td width="19"></td>
				</tr>
			</table>
							
			<table ><tr><td></td></tr></table>
					
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="100">Expense Type</td>
					<td width="110" style="padding-left:1;">
						<script language="javascript">ComComboObject('s_eac_expn_tp_cd',1,100,0,0,0);</script>
					</td>
				
					<td width="80">EAC Type</td>
					<td width="110" style="padding-left:1;">
						<script language="javascript">ComComboObject('s_eac_tp_cd',1,100,1,0,0);</script>
					</td>
					
					<td width="120">Action type</td>
					<td width="130" style="padding-left:0;">
						<script language="javascript">ComComboObject('s_eac_rsn_cd',1,100,1,0,0);</script>
					</td>
					
					<td width="122">Ranking</td>
					<td width="188" style="padding-left:0;">
						<script language="javascript">ComComboObject('s_rnk_div_cd',1,100,1,1,0);</script>
					</td>
					<td width="19"></td>
				</tr>
			</table>
			
			<table ><tr><td></td></tr></table>
							
			</td>
		</tr>
	</table>

	<table class="height_5"><tr><td></td></tr></table>
	<!-- Grid BG Box  (S) -->
	<table class="search" id="mainTable">
	 	<tr><td class="bg" valign="top">
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
<!-- Grid BG Box  (E) -->

<!-- 개발자 작업  끝 -->
			</td>
		</tr>
	</table>
</form>
</body>
</html>