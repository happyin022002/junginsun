<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESS_MNR_S171.jsp
*@FileTitle : MNR Tariff Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.12.24 김완규
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnrS171Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnrS171Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strVndr_seq	= "";
	String strVndr_nm	= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	=	account.getUsr_id();
		strUsr_nm 	= 	account.getUsr_nm();
		strVndr_seq	= 	account.getOfc_eng_nm();
		strVndr_nm 	= 	account.getOfc_krn_nm();
		
	   
		event = (EesMnrS171Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       

<script language="javascript">
    var strVndrSeq	= "<%=strVndr_seq%>";
    var strVndrNm	= "<%=strVndr_nm%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<!-- 개발자 작업	-->
<input type="hidden" name="f_cmd">
<input type="hidden" name="eq_knd_cd">
<input type="hidden" name="mnr_trf_sts_cd">
<input type="hidden" name="pagerows">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td>
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
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
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">S/P Code</td>
					<td width="240"><input type="text" name="vndr_seq" style="width:60;text-align:center" class="input2" readOnly="true">&nbsp;<input type="text" name="vndr_nm" style="width:150" class="input2" readOnly="true"></td>
					<td width="55">EQ Type</td>
					<td width="100"><script language="javascript">ComComboObject('cbEqType', 1, 80, 1, 1);</script></td>
					<td width="100">Effective Period</td>
					<td width="185">
					<input type="text" name="eff_dt_fr" style="width:50;text-align:center" class="input" maxlength="4" dataformat="yyyy">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="eff_dt_fr_cal" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~
					<input type="text" name="eff_dt_to" style="width:50;text-align:center" class="input" maxlength="4" dataformat="yyyy">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="eff_dt_to_cal" width="19" height="20" alt="" border="0" align="absmiddle">
					</td>
					<td width="80">Tariff Status</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('cbTariffStatus', 1, 150, 1, 1);</script></td>
				</tr> 
				</table>			
				<!--  biz_1   (E) -->

		</td></tr>
		</table>	
		<!-- 1 (E) -->
		
		<!-- 2 (S) -->		
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid - 1 (E) -->
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
										
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_TariffDetailInfo">Tariff&nbsp;Detail(s)&nbsp;Info.</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
										
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)-->
	
	</td></tr>
		</table>


</form>
</body>
</html>
