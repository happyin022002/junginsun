<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9240Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsdTes9240Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String param_name = null;
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);


		event = (EsdTes9240Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
		
	}
	
	String tml_so_ofc_cty_cd = request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String tml_so_seq	= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";
	String tml_so_dtl_seq	= request.getParameter("tml_so_dtl_seq")!=null&&!request.getParameter("tml_so_dtl_seq").equals("")?request.getParameter("tml_so_dtl_seq"):"";
	String calc_tp_cd	= request.getParameter("calc_tp_cd")!=null&&!request.getParameter("calc_tp_cd").equals("")?request.getParameter("calc_tp_cd"):"";
	String vndr_seq = request.getParameter("vndr_seq")!=null&&!request.getParameter("vndr_seq").equals("")?request.getParameter("vndr_seq"):"";
	String inv_no	= request.getParameter("inv_no")!=null&&!request.getParameter("inv_no").equals("")?request.getParameter("inv_no"):"";
	String param_lgs_cost_cd	= request.getParameter("param_lgs_cost_cd")!=null&&!request.getParameter("param_lgs_cost_cd").equals("")?request.getParameter("param_lgs_cost_cd"):"";
	String param_cntr_tpsz_cd	= request.getParameter("param_cntr_tpsz_cd")!=null&&!request.getParameter("param_cntr_tpsz_cd").equals("")?request.getParameter("param_cntr_tpsz_cd"):"";
	String param_dcgo_clss_cd	= request.getParameter("param_dcgo_clss_cd")!=null&&!request.getParameter("param_dcgo_clss_cd").equals("")?request.getParameter("param_dcgo_clss_cd"):"";
	String param_rc_flg	= request.getParameter("param_rc_flg")!=null&&!request.getParameter("param_rc_flg").equals("")?request.getParameter("param_rc_flg"):"";
	String ot_a_lgs_cost_cd	= request.getParameter("ot_a_lgs_cost_cd")!=null&&!request.getParameter("ot_a_lgs_cost_cd").equals("")?request.getParameter("ot_a_lgs_cost_cd"):"";
	String calcTerminalComboItems = request.getParameter("calcTerminalComboItems")!=null&&!request.getParameter("calcTerminalComboItems").equals("")?request.getParameter("calcTerminalComboItems"):"";
	String cntr_tpsz_cd	= request.getParameter("cntr_tpsz_cd")!=null&&!request.getParameter("cntr_tpsz_cd").equals("")?request.getParameter("cntr_tpsz_cd"):"";
	String cntr_sty_cdCode	= request.getParameter("cntr_sty_cdCode")!=null&&!request.getParameter("cntr_sty_cdCode").equals("")?request.getParameter("cntr_sty_cdCode"):"";
	String sheet_curr_row	= request.getParameter("sheet_curr_row")!=null&&!request.getParameter("sheet_curr_row").equals("")?request.getParameter("sheet_curr_row"):"";
	String fm_prd_dt	= request.getParameter("fm_prd_dt")!=null&&!request.getParameter("fm_prd_dt").equals("")?request.getParameter("fm_prd_dt"):"";
	String to_prd_dt	= request.getParameter("to_prd_dt")!=null&&!request.getParameter("to_prd_dt").equals("")?request.getParameter("to_prd_dt"):"";
	String yd_cd	= request.getParameter("yd_cd")!=null&&!request.getParameter("yd_cd").equals("")?request.getParameter("yd_cd"):"";
%>
<html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
    	var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
    }
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="sheet_curr_row" value='<%=sheet_curr_row%>'>
<input type="hidden" name="tml_so_ofc_cty_cd" value='<%=tml_so_ofc_cty_cd%>'>
<input type="hidden" name="tml_so_seq" value='<%=tml_so_seq%>'>
<input type="hidden" name="tml_so_dtl_seq" value='<%=tml_so_dtl_seq%>'>
<input type="hidden" name="calc_tp_cd" value='<%=calc_tp_cd%>'>
<input type="hidden" name="vndr_seq" value='<%=vndr_seq%>'>
<input type="hidden" name="inv_no" value='<%=inv_no%>'>
<input type="hidden" name="param_lgs_cost_cd" value='<%=param_lgs_cost_cd%>'>
<input type="hidden" name="param_cntr_tpsz_cd" value='<%=param_cntr_tpsz_cd%>'>
<input type="hidden" name="param_dcgo_clss_cd" value='<%=param_dcgo_clss_cd%>'>
<input type="hidden" name="param_rc_flg" value='<%=param_rc_flg%>'>
<input type="hidden" name="ot_a_lgs_cost_cd" value='<%=ot_a_lgs_cost_cd%>'>
<input type="hidden" name="calcTerminalComboItems" value='<%=calcTerminalComboItems%>'>
<input type="hidden" name="cntr_tpsz_cd" value='<%=cntr_tpsz_cd%>'>
<input type="hidden" name="cntr_sty_cdCode" value='<%=cntr_sty_cdCode%>'>
<input type="hidden" name="cntr_sty_cd" value='<%=cntr_sty_cdCode%>'>
<input type="hidden" name="fm_prd_dt" value='<%=fm_prd_dt%>'>
<input type="hidden" name="to_prd_dt" value='<%=to_prd_dt%>'>
<input type="hidden" name="search_bkg_no">
<input type="hidden" name="rowId">
<input type="hidden" name="cntr_no">
<input type="hidden" name="yd_cd" value='<%=yd_cd%>'>

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Revised Vol.(Volume Adjustment)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr>
       		<td class="bg">

				<table class="height_10"><tr><td></td></tr></table>

				<!-- : ( Seq. ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
		            </table>
				<!-- : ( Seq. ) (E) -->
				<table width="100%" class="sbutton">
       				<tr>
       					<td class="align">
	       				<div id="div_manual_mode_button" style="display:none;">
						<table class="sbutton">
			    			<tr>
			    				<td class="bt">
			    					<img class="cursor" src="/hanjin/img/button/btng_rowdel.gif" width="65" height="19" border="0" name="btn_rowdel">
			    					<img class="cursor" src="/hanjin/img/button/btng_rowadd.gif" width="65" height="19" border="0" name="btn_rowadd">
			    				</td>
							</tr>
						</table>
						</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="600" class="sbutton">
		<tr><td class="popup" valign="middle">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg" valign="middle">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern 
					<td><div id="div_manual_mode_button" style="display:none;">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_rowadd" id="btn_rowadd">Row Add</td><td class="btn1_right"></td></tr>
						</table></div>
					</td>
					-->				
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>

</body>
</html>

<div id="div_manual_mode_hidden" style="display:none; width:40%">
<script language="javascript">ComSheetObject('manual_mode_hidden');</script>
</div>

