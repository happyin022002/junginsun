<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0961.jsp
*@FileTitle  : Service Provider Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0023Event"%>

<%
	EsdTrs0023Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error occurred on the server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //Error message
	int rowCount	 = 0;								  //List the number of DB ResultSet

	SignOnUserAccount account = null;

	try {

		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0023Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	//* 1.9 CHM-200900431 Customer Code 입력가능요청(09.08.24)
    String wo_radio = JSPUtil.getNull(request.getParameter("wo_radio"));
    String cust_cd = JSPUtil.getNull(request.getParameter("cust_cnt_cd_seq"));

%>

<script type="text/javascript">
<%//= JSPUtil.getIBCodeCombo("po_way_type", "", "CD00929", 0, "")%>
<%= JSPUtil.getIBCodeCombo("sp_type", "", "CD00919", 0, "")%>
<%=BizComUtil.getIBCodeCombo("default_curr", "01", "CURR", 1, " |")%>
<%= JSPUtil.getIBCodeCombo("ft_receiving", "", "CD00936", 0, " ")%>
<%= JSPUtil.getIBCodeCombo("ft_delivery", "", "CD00936", 0, " ")%>
<%= JSPUtil.getIBCodeCombo("spcl_cgo_cntr_tp_cd",     "", "CD01507", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}

</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="WY_TP_CD" id="WY_TP_CD" />
<input type="hidden" name="SP_TP_CD" id="SP_TP_CD" />
<input type="hidden" name="VNDR_CD" id="VNDR_CD" />
<input type="hidden" name="BASIS_DT" id="BASIS_DT" />
<input type="hidden" name="WTR_RCV_TERM" id="WTR_RCV_TERM" />
<input type="hidden" name="WTR_DE_TERM" id="WTR_DE_TERM" />
<input type="hidden" name="wo_radio" value="<%=wo_radio%>" id="wo_radio" />
<input type="hidden" name="CUST_CNT_CD" id="CUST_CNT_CD" />
<input type="hidden" name="CUST_SEQ" id="CUST_SEQ" />
<input type="hidden" name="cust_cnt_cd_seq" value="<%=cust_cd%>" id="cust_cnt_cd_seq" />
<input type="hidden" name="combo_svc_provider" id="combo_svc_provider" />
<input type="hidden" name="form_cre_usr_id" value="<%=account.getUsr_id()%>" id="form_cre_usr_id" />
<input type="hidden" name="form_usr_ofc_cd" value="<%=account.getOfc_cd()%>" id="form_usr_ofc_cd" />

<!-- 2015.02.10    Hyungwook Choi -->
<input type="hidden" id="custCode" name="custCode" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Service Provider Select</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_ok" id="btn_ok">OK</button><!--
		--><button class="btn_normal" type="button" name="btn_close" id="btn_close">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="hiddenTable">
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
