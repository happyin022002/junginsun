<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DOD_0013.jsp
*@FileTitle : Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.04
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.28 손진환
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
<%@ page import="com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.event.EesDod0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDod0013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strTitle			= "";
	
	Logger log		= Logger.getLogger("com.hanjin.apps.DodDropOff.DropOffCreation");

	String popup	= request.getParameter("popup")==null?"no":request.getParameter("popup");
	String opener	= request.getParameter("opener")==null?"":request.getParameter("opener");
	String bkg_no	= request.getParameter("bkg_no")==null?"":request.getParameter("bkg_no");
	String cntr_no	= request.getParameter("cntr_no")==null?"":request.getParameter("cntr_no");
	String drp_off_chg_mnl_flg = request.getParameter("drp_off_chg_mnl_flg")==null?"":request.getParameter("drp_off_chg_mnl_flg");
	String inv_cust = request.getParameter("inv_cust")==null?"":request.getParameter("inv_cust");
	String chkCnt	= request.getParameter("count")==null?"0":request.getParameter("count");
	int cnt			= Integer.parseInt(chkCnt);
	for(int i = 0;i < cnt; i++){
		
	}

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesDod0013Event)request.getAttribute("Event");
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
<title>Correction</title>

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

<%if(popup.equals("yes")) { %>
<body class="popup_bg" onLoad="setupPage();"> 
<% } else { %>
<body  onLoad="setupPage();">
<% } %>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="opener" value="<%=opener%>">
<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="drp_off_chg_mnl_flg" value="<%=drp_off_chg_mnl_flg%>">
<input type="hidden" name="cntr_no" value="<%=cntr_no%>">
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="inv_cust" value="<%=inv_cust%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type='hidden' name='AUTH_APRO_RQST_NO' value=''>
<input type="hidden" name="backendjob_key">		<!-- BackEndJob Key -->
<input type="hidden" name="backendjob_id">		<!-- BackEndJob 구분 ID -->

<!-- 개발자 작업	-->

<%if(popup.equals("yes")) { %>
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Correction</td></tr>
		</table>
<% } else { %>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
		</table>
<% } %>		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
				
		<table class="height_10"><tr><td></td></tr></table>

		<table class="search">
			<tr><td class="bg" valign="top">
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<table width="100%" id="hiddenTableAuth">
					<tr>
						<td>
					    	<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			
			<table class="height_8"><tr><td></td></tr></table>
			
			<!--Button (S) -->
				<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td><table border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_ar_inv">AR INV</td>
									<td class="btn2_right"></td>
									</tr>
								</table></td>
								<td><table border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_close">Close</td>
									<td class="btn2_right"></td>
									</tr>
								</table></td>
							</tr>
						</table>	
					</td></tr>
				</table>
		    <!--Button (E) -->
		    
		    </td></tr>
		</table>
	<!--biz page (E)-->
	
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>