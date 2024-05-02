<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0045.jsp
*@FileTitle  : Refund Invoice File Import
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%

	String strErrMsg = "";								 //에러메세지
	String userId = "";
	String ofcId = "";
	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofcId=account.getOfc_cd();

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("trsp_cost_dtl_mod_cd", "01", "CD00744", 0, " |")%>
	<%=JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "01", "CD00283", 0, " |")%>
	<%=BizComUtil.getIBCodeCombo("eq_tpsz", "01", "CNTRTPSZ", 1, " |")%>
	<%=BizComUtil.getIBCodeCombo("ch_tpsz", "01", "CHASSIS", 1, " |")%>
	<%=BizComUtil.getIBCodeCombo("gn_tpsz", "01", "GENSET", 1, " |")%>

</script>
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

<form name="form">
<input type="hidden" name="f_cmd">
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Refund Invoice File Import</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_apply" id="btn_apply">Apply</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btng_select" id="btng_select">Select</button>
					<button type="button" class="btn_normal" name="btng_verify" id="btng_verify">Verify</button>
					<button type="button" class="btn_normal" name="btng_toggle" id="btng_toggle">Toggle</button>
				</div>
			</div>
			
			<script language="javascript">ComSheetObject('sheet1');</script>
<!-- 			<script language="javascript">ComSheetObject('sheet2');</script> -->
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->




</form>