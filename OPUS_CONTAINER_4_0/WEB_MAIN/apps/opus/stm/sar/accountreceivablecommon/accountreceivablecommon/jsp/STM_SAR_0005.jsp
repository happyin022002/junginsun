<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName:   STM_SAR_0005.jsp
*@FileTitle  : Receipt Bank Account Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar0005Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	StmSar0005Event  event = null; 				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	List<String> rhqOfcList = null;
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon");
	
	String sysCurrdate = JSPUtil.getKST("yyyy-MM-dd");
	String sysStartDate = JSPUtil.getKST("yyyy-MM") + "-01";
	
	String rct_tp_cd = StringUtil.xssFilter(request.getParameter("rct_tp_cd"));
	if(rct_tp_cd == null){
		rct_tp_cd = "";
	}
	
	String rct_ofc_cd = StringUtil.xssFilter(request.getParameter("rct_ofc_cd"));
	if(rct_ofc_cd == null){
		rct_ofc_cd = "";
	}
	
	String bank_ctrl_cd = StringUtil.xssFilter(request.getParameter("bank_ctrl_cd"));
	if(bank_ctrl_cd == null){
		bank_ctrl_cd = "";
	}
	
	String fm_rct_dt = StringUtil.xssFilter(request.getParameter("fm_rct_dt"));
	if(fm_rct_dt == null){
		fm_rct_dt = "";
	}
	
	String to_rct_dt = StringUtil.xssFilter(request.getParameter("to_rct_dt"));
	if(to_rct_dt == null){
		to_rct_dt = "";
	}
	
	String dep_fr_dt = StringUtil.xssFilter(request.getParameter("dep_fr_dt"));
	if(dep_fr_dt == null){
		dep_fr_dt = "";
	}
	
	String dep_to_dt = StringUtil.xssFilter(request.getParameter("dep_to_dt"));
	if(dep_to_dt == null){
		dep_to_dt = "";
	}
	
	String rct_sts_cd = StringUtil.xssFilter(request.getParameter("rct_sts_cd"));
	if(rct_sts_cd == null){
		rct_sts_cd = "";
	}
	
	String rct_unpay_sts_flg = StringUtil.xssFilter(request.getParameter("rct_unpay_sts_flg"));
	if(rct_unpay_sts_flg == null){
		rct_unpay_sts_flg = "";
	}
	
	String ui_type = StringUtil.xssFilter(request.getParameter("ui_type"));
	if(ui_type == null){
		ui_type = "";
	}
	
	String local_curr_cd = (StringUtil.xssFilter(request.getParameter("local_curr_cd")) == null)? "" : StringUtil.xssFilter(request.getParameter("local_curr_cd"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
		event = (StmSar0005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="rct_tp_cd" value="<%=rct_tp_cd%>" id="rct_tp_cd" />
<input type="hidden" name="rct_ofc_cd" value="<%=rct_ofc_cd%>" id="rct_ofc_cd" />
<input type="hidden" name="bank_ctrl_cd" value="<%=bank_ctrl_cd%>" id="bank_ctrl_cd" />

<input type="hidden" name="rct_dt_fm" value="<%=fm_rct_dt%>" id="rct_dt_fm" />
<input type="hidden" name="rct_dt_to" value="<%=to_rct_dt%>" id="rct_dt_to" />
<input type="hidden" name="rct_dps_dt_fm" value="<%=dep_fr_dt%>" id="rct_dps_dt_fm" />
<input type="hidden" name="rct_dps_dt_to" value="<%=dep_to_dt%>" id="rct_dps_dt_to" />
<input type="hidden" name="rct_sts_cd" value="<%=rct_sts_cd%>" id="rct_sts_cd" />
<input type="hidden" name="rct_unpay_sts_flg" value="<%=rct_unpay_sts_flg%>" id="rct_unpay_sts_flg" />
<input type="hidden" name="ui_type" value="<%=ui_type%>" id="ui_type" />
<input type="hidden" name="local_curr_cd" id="local_curr_cd"  value="<%=local_curr_cd%>" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Receipt Bank Account</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_OK" id="btn_OK" type="button">Apply</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="120">
				<col width="*">
			</colgroup>
			<tbody>
				<tr class="h23">
                  <th>Bank Account Code</th>
                  <td><input type="text" style="width:200px;" class="input" name="bank_acct_nm" id="bank_acct_nm"></td>
                </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>