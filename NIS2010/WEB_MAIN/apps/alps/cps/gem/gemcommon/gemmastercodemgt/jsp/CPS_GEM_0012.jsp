<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : cps_gem_0012.jsp
	 *@FileTitle : Foreign Exchange Rate Inquiry
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.07
	 *@LastModifier : 최정미
	 *@LastVersion : 1.0
	 * 2009.05.07 최정미
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
<%@ page import="com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0012Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem0012Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOBunkerRegister");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (CpsGem0012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<html>
<head>
<title>Foreign Exchange Rate Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(year){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage(year);
	}
</script>
</head>

<body onLoad="setupPage('<%=DateTime.getYear()%>');">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- 개발자 작업 -->
<input type="hidden" name="curr_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">Exchange Rate</td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="60">This Year</td>
						<td width="120"><input type="text" style="text-align:center; width: 45;" class="input" name="acct_xch_rt_yrmon" maxlength="4" required fullfill minnum="1900" maxnum="2050" caption="This Year">&nbsp;<img src="img/btns_calendar.gif" name="acct_xch_rt_yrmon_cal" width="19" height="20" border="0" align="absmiddle" class="cursor"></td>
						<td width="120">1USD : KRW &ndash;&gt; 1 :</td>
						<td width="120"><input type="text" style="width: 80;" class="input2" name="usd_krw_xch_rt" readonly style="text-align:right;ime-mode:disabled"  dataformat="float" maxlength="11" minnum="0"  maxnum="999999.9999" pointcount="4" caption="USD : KRW" value=""></td>
						<td width="60">Currency</td>
						<td width="">
						<script language="javascript">ComComboObject("combo1", 2, 100, 1, 0, 0, true);</script>&nbsp;<img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle">
						</td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--  biz_1  (E) -->

				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
					</tr>
				</table>
				<!-- Grid (E) -->
				</td>
			</tr>
		</table>
		
		<!-- Grid BG Box  (S) --> 
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_DownExcel">Down Excel</td>
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
		<!--biz page (E)-->
		</td>
	</tr>
	<tr><td height="5"></td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>