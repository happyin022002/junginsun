<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_CIM_0061.jsp
*@FileTitle : EQ Balance Report Inquiry
*Open Issues : 장비 과부족현황 Mailing (2014.03 ~ 2014.04)
*Change history :
*@LastModifyDate : 2014.04.03
*@LastModifier : Kim Chang Young
*@LastVersion : 1.0
* 2014.04.03 Kim Chang Young
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
<%@ page import="com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0061Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0061Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strOfc_cd = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.LongstayingUnclaimEQMgt.LongstayingUnclaimEQFlagging");
	
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strOfc_cd = account.getOfc_cd();
		
		event = (EesCim0061Event)request.getAttribute("Event");
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
<title>EQ Balance Report Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="rcc_cd" value="">
<input type="hidden" name="page_type" value="">
<input type="hidden" name="accnt_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="send_flag" value="">

<!--  MAS에서 호출하기 위하여 PARAM 전송 부분 추가(2016.04.22) -->
<input type="hidden" name="mas_rhq" value="<%=request.getParameter("mas_rhp") %>">
<input type="hidden" name="mas_ecc" value="<%=request.getParameter("mas_ecc") %>">
<!-- MAS 끝 -->

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
		<tr><td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
				<td class="btn1" name="btn_downexcel">Down Excel</td>
				<td class="btn1_right"></td>
				</tr>
			</table>
		</td></tr>
		</table>
	</td></tr>
	</table>
	<!--Button (E) -->
	
	<!--biz page (S)-->
	<table class="search" id="mainTable"> 
		<tr><td class="bg">
		<!--  Search Condition (S) -->
		<table class="search" border="0" style="width:100%;">
		<tr class="h23">
			<td width="40">RHQ</td>
			<td width="130">
				<!-- comboid, iColCnt(콤보리스트에 컬럼의 개수), iWidth, iStyle(0=편집가능, 1=편집불가능), iCss(input=0 input1=1 input1_1=2 input2=3 input2_1=4) -->
				<script language="javascript">ComComboObject('rhq_cd', 1, 100, 1, 1);</script>
			</td>
			<td width="176">Period Week(YYYY-WW)</td>
			<td width=160>
				<input type="text" class="input1" name="fm_week" style="ime-mode:disabled;width:54;" dataformat="yw" maxlength="6">&nbsp~&nbsp
				<input type="text" class="input1" name="to_week" style="ime-mode:disabled;width:54;" dataformat="yw" maxlength="6">
			</td>
			<td width="85">Sub-Conti</td>
			<td width="190">
				<script language="javascript">ComComboObject('sconti_cd', 2, 160, 1, 0);</script>
			</td>
			<td width="35">LCC</td>
			<td width="100">
				<script language="javascript">ComComboObject('lcc_cd', 1, 70, 1, 0);</script>
			</td>
			<td width="35">ECC</td>
			<td width="100">
				<script language="javascript">ComComboObject('ecc_cd', 1, 70, 1, 0);</script>
			</td>
			<td width="">&nbsp</td>
		</tr>
		</table>	
		<!--  Search Condition (E) -->	
		</td></tr>
	</table>
	<!-- biz page (E) -->
	
	<table class="height_8"><tr><td></td></tr></table>
	
	<!-- Grid (S) -->
	<table class="search"> 
		<tr><td class="bg">
		<table width="100%" class="search"  id="mainTable"> 
			<tr><td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
			</td></tr>
		</table>
		</td></tr>
	</table>
	<!-- Grid (E) -->
	
	</td></tr>
</table>
</form>
</body>
</html>
