<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_9074.jsp
*@FileTitle  : Volume Adjustment PopUp
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/02
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
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

	Exception serverException   = null;
	String strErrMsg = "";
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd">
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


<!-- OUTER - POPUP (S)tart -->

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Revised Vol.(Volume Adjustment)</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<script language="javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
</div>
<div class="header_fixed"></div>
</form>
