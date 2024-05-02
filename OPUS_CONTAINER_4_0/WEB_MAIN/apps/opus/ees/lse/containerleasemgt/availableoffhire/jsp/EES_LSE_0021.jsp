<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0021.jsp
*@FileTitle  : Off-Hire CNTR List - Send to Lessor 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event.EesLse0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesLse0021Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();

		event = (EesLse0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="loc_case" value="<%= StringUtil.xssFilter(request.getParameter("h_loc_case")) %>" id="loc_case" />
<input type="hidden" name="loc_tp" value="<%= StringUtil.xssFilter(request.getParameter("h_loc_tp")) %>" id="loc_tp" />
<input type="hidden" name="loc_cd" value="<%= StringUtil.xssFilter(request.getParameter("h_loc_cd")) %>" id="loc_cd" />
<input type="hidden" name="port_cd" value="<%= StringUtil.xssFilter(request.getParameter("h_port_cd"))  %>" id="port_cd" />
<input type="hidden" name="slan_cd" value="<%= StringUtil.xssFilter(request.getParameter("h_slan_cd"))  %>" id="slan_cd" />
<input type="hidden" name="del_cd" value="<%= StringUtil.xssFilter(request.getParameter("h_del_cd"))  %>" id="del_cd" />
<input type="hidden" name="vvd_cd" value="<%= StringUtil.xssFilter(request.getParameter("h_vvd_cd"))  %>" id="vvd_cd" />
<input type="hidden" name="estm_tp" value="<%= StringUtil.xssFilter(request.getParameter("h_estm_tp"))  %>" id="estm_tp" />
<input type="hidden" name="str_estm_dt" value="<%= StringUtil.xssFilter(request.getParameter("h_str_estm_dt"))  %>" id="str_estm_dt" />
<input type="hidden" name="end_estm_dt" value="<%= StringUtil.xssFilter(request.getParameter("h_end_estm_dt"))  %>" id="end_estm_dt" />
<input type="hidden" name="lstm_cd" value="<%= StringUtil.xssFilter(request.getParameter("h_lstm_cd"))  %>" id="lstm_cd" />
<input type="hidden" name="cntr_tpsz_cd" value="<%= StringUtil.xssFilter(request.getParameter("h_cntr_tpsz_cd"))  %>" id="cntr_tpsz_cd" />
<input type="hidden" name="cnmv_sts_cd" value="<%= StringUtil.xssFilter(request.getParameter("h_cnmv_sts_cd"))  %>" id="cnmv_sts_cd" />
<input type="hidden" name="agmt_cty_cd" value="<%= StringUtil.xssFilter(request.getParameter("h_agmt_cty_cd"))  %>" id="agmt_cty_cd" />
<input type="hidden" name="agmt_seq" value="<%= StringUtil.xssFilter(request.getParameter("h_agmt_seq"))  %>" id="agmt_seq" />
<input type="hidden" name="vndr_seq" value="<%= StringUtil.xssFilter(request.getParameter("h_vndr_seq"))  %>" id="vndr_seq" />
<input type="hidden" name="used_dys" value="<%= StringUtil.xssFilter(request.getParameter("h_used_dys"))  %>" id="used_dys" />
<input type="hidden" name="free_dys" value="<%= StringUtil.xssFilter(request.getParameter("h_free_dys"))  %>" id="free_dys" />
<input type="hidden" name="min_onh_dys_tp" value="<%= StringUtil.xssFilter(request.getParameter("h_min_onh_dys_tp"))  %>" id="min_onh_dys_tp" />
<input type="hidden" name="curr_dt" value="<%= StringUtil.xssFilter(request.getParameter("h_curr_dt"))  %>" id="curr_dt" />
<input type="hidden" name="complex_pk" value="<%= StringUtil.xssFilter(request.getParameter("complex_pk"))  %>" id="complex_pk" />
<input type="hidden" name="complex_pk2" value="<%= StringUtil.xssFilter(request.getParameter("complex_pk2"))  %>" id="complex_pk2" />
<input type="hidden" name="from" value="<%= strUsr_eml %>" id="from" />
<input type="hidden" name="recipient" value="<%= strUsr_eml %>" id="recipient" />
<input type="hidden" name="rstr_usg_lbl" value="<%=  StringUtil.xssFilter(request.getParameter("rstr_usg_lbl")) %>" id="rstr_usg_lbl" />
<input type="hidden" name="cntr_no" value="<%=  StringUtil.xssFilter(request.getParameter("cntr_no")) %>" id="cntr_no" />
<input type="hidden" name="carbonCopy" value="" id="carbonCopy" />
<input type="hidden" name="blindCarbonCopy" value="<%= strUsr_eml %>" id="blindCarbonCopy" />
<input type="hidden" name="subject" value="Off-Hire Request <%= StringUtil.xssFilter(request.getParameter(" h_curr_dt")) %>" id="subject" />
<input type="hidden" name="fileKey" value="" id="fileKey" />
<input type="hidden" name="template" value="EES_LSE_0020_01T.html" id="template" />
<input type="hidden" name="argument" id="argument" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span id="titles">Available Off Hire Quantity (Detail inquiry) List</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_email" id="btn_email">Email</button><!-- 
	--><button type="button" class="btn_normal" name="btn_save"  id="btn_save">Save Only</button><!--  
	--><button type="button" class="btn_normal" name="btn_close"  	id="btn_close">Close</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->
</div>
<div class="wrap_result bg">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>


<%@include file="/bizcommon/include/common_opus.jsp" %>