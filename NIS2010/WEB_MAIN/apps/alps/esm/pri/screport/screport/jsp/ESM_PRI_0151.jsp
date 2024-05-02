<%/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_0151.jsp
*@FileTitle : Korea MOF Filing (Formatted)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0151Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0151Event  event = null;
	Exception serverException   = null;
	String strErrMsg = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsmPri0151Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			log.debug(serverException);
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Korea MOF Filing (Formatted)</title>
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
<input type="hidden" name="date_by">
<input type="hidden" name="jb_id">
<input  type="hidden" name="prop_ofc_cd">
<input  type="hidden" name="prop_srep_cd">

<input type="hidden" name="strUsr_nm" value="<%=strUsr_nm %>">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
     	<tr><td class="btn1_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
	    <tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Retrieve">Retrieve</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_new">New</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Downlist">Down List</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
		</tr>
		</table>
	</td></tr>
	</table>
    <!--Button (E) -->
    
	<!--Page Title, Historical (E)-->
	
	<table class="search" border="0"> 
		<tr><td class="bg">
		<!--  biz_1  (S) -->
		
			<table class="search_sm" border="0" > 
				<tr class="h23">
				<td width="70">Date By</td>
				
				<!-- Search Date Type -->
				<td width="200" class="stm" style="font-size:12;" id="rdoTpCd">
				<input type="radio" name="date_by_rdo" value="1" class="trans" checked>&nbsp;<span id="inq_tp_cd1">Filed (SC) / Approved (RFA)</span>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="date_by_rdo" value="2" class="trans">&nbsp;<span id="inq_tp_cd1">Effective</span>&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td width="10">&nbsp;</td>
				
				<!-- Duration -->
				<td><input type="text" caption="Filing From Date" style="width:75;text-align:center;" class="input1" name="f_eff_dt" cofield="f_exp_dt" dataformat="ymd" maxLength="10" minlength="8">
				&nbsp;~&nbsp;
				<input type="text" caption="Filing To Date" style="width:75;text-align:center;" class="input1" name="f_exp_dt" cofield="f_eff_dt" dataformat="ymd" maxLength="10" minlength="8">
				<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle"></td>
				
				<td width="20">&nbsp;</td>
				<td width="220">
					<span style="width: 100px;">Contract Type&nbsp;&nbsp;</span>
					<script language="javascript">ComComboObject('f_ctrt_tp', 2, 111, 0, 1);</script>
					<span style="width: 100px;">Req. Office&nbsp;&nbsp;</span>
					<script language="javascript">ComComboObject('prop_ofc_cd_multi', 2, 111, 0, 0);</script>
				</td>
				
				<td width="200">
					<span style="width: 76px;">APVL OFC&nbsp;&nbsp;</span>
					<nobr>
					<input type="text" name="apvl_ofc" style="width:70;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="6"> <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTarget">
					</nobr>
					<span style="width: 80px;">Req. Staff</span>
					<script language="javascript">ComComboObject('prop_srep_cd_multi', 2, 93, 0, 0);</script>
				</td>
				
				<td style="height:20px;"></td>
				<td><td width="40" class="stm"><input type="checkbox" name="hidden_use_flg" value="Y" class="trans"></td>
				</tr>
			</table>
		
		<!--  biz_1   (E) -->
		</td></tr>
	</table>
	
	<table class="height_8"><tr><td colspan="8"></td></tr></table>
 	
	<table class="search"> 
       	<tr><td class="bg">	
				
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
	
	<!--biz page (S)-->
	
	</td></tr>
</table>

<div style="display: none">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>