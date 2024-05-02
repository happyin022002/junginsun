<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0162.jsp
*@FileTitle  : Office Add
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0162Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0162Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd 	    = "";
	
	String mqta_step_cd = JSPUtil.getParameter(request, "mqta_step_cd"	, "");
	String mqta_ver_no 	= JSPUtil.getParameter(request, "mqta_ver_no"	, "");
	String rhq_cd		= JSPUtil.getParameter(request, "rhq_cd"		, "");
	String bse_yr 		= JSPUtil.getParameter(request, "bse_yr"		, "");
	String bse_qtr_cd 	= JSPUtil.getParameter(request, "bse_qtr_cd"	, "");
	String trade_group	= JSPUtil.getParameter(request, "trade_group"	, "");
	String trd_cd 		= JSPUtil.getParameter(request, "trd_cd"		, "");
	String dir_cd 		= JSPUtil.getParameter(request, "dir_cd"		, "");
	
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.MonthlyQuotaAdjustmentRHQ");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();


		event = (EsmSaq0162Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<input type="hidden" name="mqta_step_cd" value="<%=mqta_step_cd%>" id="mqta_step_cd" />
<input type="hidden" name="mqta_ver_no" value="<%=mqta_ver_no%>" id="mqta_ver_no" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Office Add</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_rowadd" id="btn_rowadd">Row Add</button><!-- 
		     --><button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button><!-- 
    	     --><button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
    </div>
	 <!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		 <table> 
           <colgroup>
                <col width="50">
                <col width="100">
                <col width="80">
                <col width="100">
                <col width="100">
                <col width="*">
            </colgroup>
            <tbody>
              		 <tr>
							<th>Origin</th>
							<td><input style="width:60px;cursor:default;" class="input1" name="rhq_cd" id="rhq_cd" value="<%=rhq_cd%>" unselectable="on"></td>
							<th>Year</th>
							<td><input style="width:60px;cursor:default;" class="input1" name="bse_yr" id="bse_yr" value="<%=bse_yr%>" unselectable="on"></td>
							<th>Quarter</th>
							<td><input style="width:60px;cursor:default;" class="input1" name="bse_qtr_cd" id="bse_qtr_cd" value="<%=bse_qtr_cd%>" unselectable="on"></td>
						</tr>
						<tr>
							<th>Target Group</th>
							<td><input style="width:60px;cursor:default;" class="input1" name="trade_group" id="trade_group" value="<%=trade_group%>" unselectable="on"></td>
							<th>Trade</th>
							<td><input style="width:60px;cursor:default;" class="input1" name="trd_cd" id="trd_cd" value="<%=trd_cd%>" unselectable="on"></td>
							<th>Bound</th>
							<td><input style="width:60px;cursor:default;" class="input1" name="dir_cd" id="dir_cd" value="<%=dir_cd%>" unselectable="on"></td>
						</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >				
		 <script type="text/javascript">ComSheetObject('rhqAdjSheet');</script>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>