<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DOD_0001.jsp
*@FileTitle : Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
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
<%@ page import="com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.event.EesDod0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDod0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd      = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.DodDropOff.DropOffCreation");

	String popup	= request.getParameter("popup")==null?"no":request.getParameter("popup");
	String bkg_no	= request.getParameter("bkg_no")==null?"":request.getParameter("bkg_no");
	String cntr_no	= request.getParameter("cntr_no")==null?"":request.getParameter("cntr_no");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesDod0001Event)request.getAttribute("Event");
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
<title>Invoice Creation & Correction</title>
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
<input type="hidden" name="popup" value="<%=popup%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="pagerows">
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
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Creation & Correction</td></tr>
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
	
	<!-- TABLE '#D' : ( Button : Main ) (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		<tr><td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" id = "ibtn_retrieve2" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve2" id="btn_retrieve2">Retrieve-IMSI</td><td class="btn1_right"></td></tr></table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->
				</tr>
			</table>
		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Button : Main ) (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       		<tr><td class="bg">

				<!-- Condition (S)-->
				<table class="search" border="0" style="width:500;"> 
					<tr class="h23">
						<td width="85">&nbsp;&nbsp;Office</td>
						<td>
							<input type="text" name="ofc_cd" style="width:100;text-align:center;ime-mode:disabled;" class="input2" maxlength="5" dataformat="engup" required fullfill caption="OFC" value="<%=strOfc_cd%>" readonly >&nbsp;
						</td>
						<td width="100">&nbsp;&nbsp;DEL</td>
						<td>	
							<input type="text" name="del_cd" style="width:100;text-align:center;ime-mode:disabled;" class="input" maxlength="5" dataformat="engup" required fullfill caption="DEL" >&nbsp;
						</td>
					</tr>
				</table>

				<table class="search" border="0" style="width:700;"> 
					<tr class="h23">
						<td width="85">&nbsp;&nbsp;BKG No.</td>
						<td>
							<input type="text" name="bkg_no" style="width:100;text-align:center;ime-mode:disabled;" class="input" maxlength="12" dataformat="engup" required fullfill caption="BKG" value="<%=popup.equals("yes")?bkg_no:"" %>">&nbsp;
						</td>
						<td width="100">&nbsp;&nbsp;Special CUST</td>
						<td>
							<input type="text" name="s_cust_cd" style="width:80;text-align:center;ime-mode:disabled;" class="input" maxlength="8" dataformat="engup" required fullfill caption="Customer" >&nbsp;
						</td>
						<td><img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btn_customer"></td>
						<td>
							<input type="text" name="s_cust_nm" style="width:130;text-align:center;ime-mode:disabled;" class="input2" readonly caption="Customer" >&nbsp;
						</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:500;"> 
					<tr class="h23">
						<td width="85">&nbsp;&nbsp;CNTR No.</td>
						<td>
							<input type="text" name="cntr_no" style="width:100;text-align:center;ime-mode:disabled;" class="input" maxlength="11" dataformat="engup" required fullfill caption="CNTR" value="">&nbsp;
						</td>
						<td width="100">&nbsp;&nbsp;Return CY</td>
						<td>
							<input type="text" name="cntr_rtn_yd_cd" style="width:100;text-align:center;ime-mode:disabled;" class="input" maxlength="7" dataformat="engup" required fullfill caption="RTN CY" >&nbsp;
						</td>
					</tr>
				</table>
				<!-- Condition (E)-->
			</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>

		<table class="search">
			<tr><td class="bg" valign="top">
			<!-- Grid  (S) -->
				<table width="100%"	id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<table width="100%" id="hiddenTable">
					<tr>
						<td>
					    	<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<table width="100%" id="hiddenTableAuth">
					<tr>
						<td>
					    	<script language="javascript">ComSheetObject('sheet3');</script>
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
									<td class="btn2" name="btn_correction">Correction</td>
									<td class="btn2_right"></td>
									</tr>
								</table></td>
								<td><table border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_save">Save</td>
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