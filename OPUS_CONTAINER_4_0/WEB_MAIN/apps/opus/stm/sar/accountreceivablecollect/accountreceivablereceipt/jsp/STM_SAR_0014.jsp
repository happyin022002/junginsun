<%/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   STM_SAR_0014.jsp
*@FileTitle  : Receipt User Search Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	StmSar0014Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	
	String fmRctDt = "";
	String toRctDt = "";
	String fmRctDpsDt = "";
	String toRctDpsDt = "";
	
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.AccountReceivableCollectSC");
		
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSar0014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		fmRctDt 	= StringUtil.xssFilter(request.getParameter("fm_rct_dt"));
		toRctDt 	= StringUtil.xssFilter(request.getParameter("to_rct_dt"));
		fmRctDpsDt 	= StringUtil.xssFilter(request.getParameter("fm_rct_dps_dt"));
		toRctDpsDt 	= StringUtil.xssFilter(request.getParameter("to_rct_dps_dt"));

		fmRctDt 	= fmRctDt==null?"":fmRctDt;
		toRctDt 	= toRctDt==null?"":toRctDt;
		fmRctDpsDt 	= fmRctDpsDt==null?"":fmRctDpsDt;
		toRctDpsDt 	= toRctDpsDt==null?"":toRctDpsDt;
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
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
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="fm_rct_dt" id="fm_rct_dt"  value="<%=fmRctDt%>"  >
<input type="hidden" name="to_rct_dt" id="to_rct_dt"   value="<%=toRctDt%>" > 
<input type="hidden" name="fm_rct_dps_dt" id="fm_rct_dps_dt" value="<%=fmRctDpsDt%>" > 
<input type="hidden" name="to_rct_dps_dt" id="to_rct_dps_dt" value="<%=toRctDpsDt%>" > 

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">Receipt User Search</h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_ok" id="btn_ok" type="button">OK</button><!--
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
				<col width="10">
				<col width="*">
			</colgroup>
			<tbody>
				<tr class="h23">
                  <th>Find</th>
                  <td><input type="text" style="width:200px;" class="input" value="" name="usr_id" id="usr_id"></td>
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