<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0006.jsp
*@FileTitle : Ex. Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.04.24 박정진
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0006Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
//	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
//	String successFlag = "";
//	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.ARInvoiceExRateMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (FnsInv0006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	String vvdCd      = request.getParameter("vvvcd") == null ? "" : request.getParameter("vvvcd").replace(" ","");
	String portCd     = request.getParameter("port_cd") == null ? "" : request.getParameter("port_cd").replace(" ","");
	String loclCurrCd = request.getParameter("locl_curr_cd")== null ? "" : request.getParameter("locl_curr_cd").replace(" ","");
	String svcScpCd   = request.getParameter("svc_scp_cd") == null ? "" : request.getParameter("svc_scp_cd").replace(" ","");
	String ioBndCd    = request.getParameter("io_bnd_cd") == null ? "" : request.getParameter("io_bnd_cd").replace(" ","");
%>
<html>
<head>
<title>Invoice Inquiry by Good Date</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<%
	if(vvdCd.equals("") && loclCurrCd.equals("")){
%>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="view_vvd_cd" value="<%=vvdCd%>">
<input type="hidden" name="view_port_cd" value="<%=portCd%>">
<input type="hidden" name="view_locl_curr_cd" value="<%=loclCurrCd%>">
<input type="hidden" name="view_svc_scp_cd" value="<%=svcScpCd%>">
<input type="hidden" name="view_io_bnd_cd" value="<%=ioBndCd%>">

<input type="hidden" name="from_dt" value="">
<input type="hidden" name="to_dt" value="">

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
<%
	}
	else {
%>
<body class="popup_bg" onload="javascript:setupPage();">
<form name="form">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 
<input type="hidden" name="view_vvd_cd" value="<%=vvdCd%>">
<input type="hidden" name="view_port_cd" value="<%=portCd%>">
<input type="hidden" name="view_locl_curr_cd" value="<%=loclCurrCd%>">
<input type="hidden" name="view_svc_scp_cd" value="<%=svcScpCd%>">
<input type="hidden" name="view_io_bnd_cd" value="<%=ioBndCd%>">

<input type="hidden" name="from_dt" value="">
<input type="hidden" name="to_dt" value="">

 
<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="540" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Ex. Rate Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%
	}
%>
		<!--biz page (S)-->
		<table class="search">
		<tr>
			<td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="95">Ex. Rate Type&nbsp;</td>
					<td width="220" style="padding-left:2"><script language="javascript">ComComboObject('xch_rt_tp_cd', 1, 140, 1);</script></td>
					<td width="80">Charge Cur&nbsp;</td>
					<td width="160"><input name="chg_curr_cd" type="text" dataformat="engup" style="width:40" class="input" value="" maxlength="3"></td>
					<td width="80">Local Cur&nbsp;</td>
					<td width="" colspan="3"><input name="locl_curr_cd" type="text" dataformat="engup" style="width:40" class="input" value="" maxlength="3"></td>
				</tr>
				<tr class="h23">
					<td width="">VVD&nbsp;</td>
					<td width=""><input name="vvd_cd" type="text" dataformat="engup" style="width:139" class="input" value="" minlength="9" maxlength="9"></td>
					<td width="">Port&nbsp;</td>
					<td width=""><input name="port_cd" type="text" dataformat="engup" style="width:60" class="input" value="" maxlength="5"><% if(vvdCd.equals("") && loclCurrCd.equals("")) {%>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_port"><%} %></td>
					<td width="">Scope&nbsp;</td>
					<td width="160" style="padding-left:2"><script language="javascript">ComComboObject('svc_scp_cd', 1, 65, 0);</script></td>
					<td width="40">Bound&nbsp;</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('io_bnd_cd', 1, 65, 1);</script></td>
				</tr>
				<tr class="h23">
					<td width="">Customer&nbsp;</td>
					<td width=""><input name="cust_cnt_cd" type="text" style="width:25;" value="" class="input" maxlength="2" dataformat="engup">&nbsp;-&nbsp;<input name="cust_seq" type="text" style="width:50;" value="" class="input" maxlength="6" dataformat="num"></td>
					<td width="">Date&nbsp;</td>
					<td width=""  colspan="5">
					<div id="Date_A" style="display:inline">
						<input type="text" name="from_day" dataformat="ymd" required maxlength="8" style="width:75" class="input1" caption="start date" cofield="to_day"><% if(vvdCd.equals("") && loclCurrCd.equals("")) {%>&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"><%} %>&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" name="to_day" dataformat="ymd" required maxlength="8" style="width:75" class="input1" caption="end date" cofield="from_day">&nbsp;<% if(vvdCd.equals("") && loclCurrCd.equals("")) {%><img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"><%} %>
					</div>
					<div id="Date_B" style="display:none">
						<input type="text" name="from_month" dataformat="ym" required maxlength="6" style="width:75" class="input1" caption="start date" cofield="to_month"><% if(vvdCd.equals("") && loclCurrCd.equals("")) {%>&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar3"><%} %>&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" name="to_month" dataformat="ym" required maxlength="6" style="width:75" class="input1" caption="end date" cofield="from_month">&nbsp;<% if(vvdCd.equals("") && loclCurrCd.equals("")) {%><img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar4"><%} %>
					</div>
					</td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>
				<!-- Grid (E) -->
			</td>
		</tr>
		</table>
		<!-- Tab BG Box(E) -->
		<!--biz page (E)-->
<%
	if(vvdCd.equals("") && loclCurrCd.equals("")){
%>
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_new">New</td>
							<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_downExcel">Down Excel</td>
							<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_print">Print</td>
							<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
				</table>
				<!--Button (E) -->
<%
	}
	else {
%>
				<!-- : ( Button : Sub ) (S) -->
				<table width="100%" class="sbutton">
				<tr>
					<td height="71" class="popup">
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
						<tr>
							<td class="btn3_bg">
		    					<table border="0" cellpadding="0" cellspacing="0">
		    					<tr>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
											<td class="btn1_right"></td>
										</tr>
										</table>
									</td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- : ( Button : Sub ) (E) -->
<%
	}
%>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
<!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>