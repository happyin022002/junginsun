<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESS_MNR_0136.jsp
*@FileTitle : MNR Regional Tariff Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.07.20 김완규
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0136Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0136Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String rhqOfcCd         = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		rhqOfcCd  = account.getRhq_ofc_cd();
	   
		event = (EesMnr0136Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		// 2015.02.11 [CHM-201534100] 한국지역 조직도 setting 요청 CSR에 따라 변경
		// MDM_ORGANIZATION 조직 TREE 문제
		if("SELSC".equals(strOfc_cd)){
			strOfc_cd = "SELIB";
		}
		if("TYOSC".equals(strOfc_cd)){
			strOfc_cd = "TYOIB";
		}


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
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=rhqOfcCd %>';

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
<input type="hidden" name="ar_hd_qtr_ofc_cd">
<input type="hidden" name="rqst_ofc_cd">
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Approval">Approval</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Reject">Reject</td>
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
					<td width="80">Regional HQ</td>
					<td width="110" style="padding-left:3"><script language="javascript">ComComboObject('cbRegionalHq', 2, 75, 0, 1);</script></td>
					<td width="75">Tariff Office</td>
					<td width="320" style="padding-left:3"><script language="javascript">ComComboObject('cbAgmtOffice', 2, 70, 0, 1);</script></td>
					<td width="100">Tariff Status</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('cbTariffStatus', 1, 165, 1, 1);</script></td>
				</tr>
				<tr class="h23">
					<td>EQ Type </td>
					<td width="" style="padding-left:3"><script language="javascript">ComComboObject('cbEqType', 1, 75, 1, 1);</script></td>
					
					<td>S/P Code</td>
					<td><input type="text" name="vndr_seq" style="width:70;text-align:center" class="input"  dataformat="engup" maxlength="6">&nbsp;<img src="img/btns_search.gif" name="provider_popup" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" name="vndr_nm" style="width:180" class="input2" readOnly="true"></td>
					<td width="">Effective Period</td>
					<td width="">
					<input type="text" name="eff_dt_fr" style="width:50;text-align:center" class="input" maxlength="4" dataformat="yyyy">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="eff_dt_fr_cal" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~
					<input type="text" name="eff_dt_to" style="width:50;text-align:center" class="input" maxlength="4" dataformat="yyyy">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="eff_dt_to_cal" width="19" height="20" alt="" border="0" align="absmiddle">
					</td>
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
					<td class="btn2" name="btn_DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
										
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_TariffDetailInfo">Tariff Detail(s) Info.</td>
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
