<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0958.jsp
*@FileTitle : Booking QTY Update Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.19 김영출
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0958Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0958Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentation");

	String bkg_pck_qty   = "";
	String bkg_pck_unit  = "";
	String bkg_wgt_qty   = "";
	String bkg_wgt_unit  = "";
	String bkg_meas_qty  = "";
	String bkg_meas_unit = "";

	String cm_pck_qty    = "";
	String cm_pck_unit   = "";
	String cm_wgt_qty    = "";
	String cm_wgt_unit   = "";
	String cm_meas_qty   = "";
	String cm_meas_unit  = "";
	String sub_title  = "";

	String var_pck_qty   = "";
	String var_wgt_qty   = "";
	String var_meas_qty  = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0958Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		bkg_pck_qty   = JSPUtil.getParameter(request, "bkg_pck_qty"  , "");
		bkg_pck_unit  = JSPUtil.getParameter(request, "bkg_pck_unit" , "");
		bkg_wgt_qty   = JSPUtil.getParameter(request, "bkg_wgt_qty"  , "");
		bkg_wgt_unit  = JSPUtil.getParameter(request, "bkg_wgt_unit" , "");
		bkg_meas_qty  = JSPUtil.getParameter(request, "bkg_meas_qty" , "");
		bkg_meas_unit = JSPUtil.getParameter(request, "bkg_meas_unit", "");
		cm_pck_qty    = JSPUtil.getParameter(request, "cm_pck_qty"   , "");
		cm_pck_unit   = JSPUtil.getParameter(request, "cm_pck_unit"  , "");
		cm_wgt_qty    = JSPUtil.getParameter(request, "cm_wgt_qty"   , "");
		cm_wgt_unit   = JSPUtil.getParameter(request, "cm_wgt_unit"  , "");
		cm_meas_qty   = JSPUtil.getParameter(request, "cm_meas_qty"  , "");
		cm_meas_unit  = JSPUtil.getParameter(request, "cm_meas_unit" , "");
		sub_title  	  = JSPUtil.getParameter(request, "sub_title" 	 , "");

		bkg_pck_qty   = ("".equals(bkg_pck_qty)  || "null".equals(bkg_pck_qty))  ? "0" : bkg_pck_qty;
		bkg_wgt_qty   = ("".equals(bkg_wgt_qty)  || "null".equals(bkg_wgt_qty))  ? "0" : bkg_wgt_qty;
		bkg_meas_qty  = ("".equals(bkg_meas_qty) || "null".equals(bkg_meas_qty)) ? "0" : bkg_meas_qty;

		cm_pck_qty    = ("".equals(cm_pck_qty)   || "null".equals(cm_pck_qty))   ? "0" : cm_pck_qty;
		cm_wgt_qty    = ("".equals(cm_wgt_qty)   || "null".equals(cm_wgt_qty))   ? "0" : cm_wgt_qty;
		cm_meas_qty   = ("".equals(cm_meas_qty)  || "null".equals(cm_meas_qty))  ? "0" : cm_meas_qty;

		var_pck_qty   = String.valueOf(Float.parseFloat(bkg_pck_qty)  - Float.parseFloat(cm_pck_qty));
		var_wgt_qty   = String.valueOf(Float.parseFloat(bkg_wgt_qty)  - Float.parseFloat(cm_wgt_qty));
		var_meas_qty  = String.valueOf(Float.parseFloat(bkg_meas_qty) - Float.parseFloat(cm_meas_qty));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking QTY Update Pop-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Total Booking Quantity Update</td></tr>
		</table>
		<!--table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table-->
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

			<table class="search">
       		<tr><td class="bg">
			<table class="search" border="0" style="width:100%;">
				<tr class="h23">
				<td width="66" align="center"><img class="cursor" src="img/btns_help.gif" width="19" height="20" border="0" align="absmiddle"></td>
				<td>Do you want to update total Package, Weight & Measure of Booking according to C/M quantity?</td>
				</tr>
		</table>
		<table class="height_10"><tr><td></td></tr></table>
		<table border="0" style="width:100%;" class="grid2">
					<tr class="tr2_head2"><td width="25%"></td>
						<td colspan="2" width="25%">Package		</td>
						<td colspan="2" width="25%">Weight		</td>
						<td colspan="2">Measure	</td></tr>
					<tr><td class="tr2_head2" align="center">Booking	</td>
						<td align="right" id="bkg_pck_qty"><%=bkg_pck_qty%></td>
						<td align="left" id="bkg_pck_unit"><%=bkg_pck_unit%></td>
						<td align="right" id="bkg_wgt_qty"><%=bkg_wgt_qty%></td>
						<td align="left" id="bkg_wgt_unit"><%=bkg_wgt_unit%></td>
						<td align="right" id="bkg_meas_qty"><%=bkg_meas_qty%></td>
						<td align="left" id="bkg_meas_unit"><%=bkg_meas_unit%></td>
					</tr>
					<tr><td class="tr2_head2" align="center"><%=sub_title%></td>
						<td align="right" id="cm_pck_qty"><%=cm_pck_qty%></td>
						<td align="left" id="cm_pck_unit"><%=cm_pck_unit%></td>
						<td align="right" id="cm_wgt_qty"><%=cm_wgt_qty%></td>
						<td align="left" id="cm_wgt_unit"><%=cm_wgt_unit%></td>
						<td align="right" id="cm_meas_qty"><%=cm_meas_qty%></td>
						<td align="left" id="cm_meas_unit"><%=cm_meas_unit%></td>
					</tr>
					<tr><td class="tr2_head2" align="center">Variance		</td>
						<td align="right" id="var_pck_qty" <%if((Float.parseFloat(bkg_pck_qty)-Float.parseFloat(cm_pck_qty))==0) {out.print("style=\"color:blue;\"");}else{out.print("style=\"color:red;\"");}%>><%=var_pck_qty%></td>
						<td align="left" id="var_pck_unit"></td>
						<td align="right" id="var_wgt_qty" <%if((Float.parseFloat(bkg_wgt_qty)-Float.parseFloat(cm_wgt_qty))==0)  {out.print("style=\"color:blue;\"");}else{out.print("style=\"color:red;\"");}%>><%=var_wgt_qty%></td>
						<td align="left" id="valr_wgt_unit"></td>
						<td align="right" id="var_meas_qty" <%if((Float.parseFloat(bkg_meas_qty)-Float.parseFloat(cm_meas_qty))==0)  {out.print("style=\"color:blue;\"");}else{out.print("style=\"color:red;\"");}%>><%=var_meas_qty%></td>
						<td align="left" id="var_meas_unit"></td>
					</tr>
				</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table>

<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Yes">Yes</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_No">No</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>