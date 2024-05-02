<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0166.jsp
*@FileTitle  : VVD Mapping - VVD Select
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
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0166Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0166Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd 	    = "";
	
	String mqtaRlseVerNo = JSPUtil.getParameter(request, "mqtaRlseVerNo", "");
	String year        = JSPUtil.getParameter(request, "year"       , "");
	String qtr_cd      = JSPUtil.getParameter(request, "quarter"    , "");
	String trd_cd      = JSPUtil.getParameter(request, "trade"      , "");
	String dir_cd      = JSPUtil.getParameter(request, "bound"      , "");
	String rlane       = JSPUtil.getParameter(request, "rlane"      , "");
	
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.monthlyquotacfmadjustment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();


		event = (EsmSaq0166Event)request.getAttribute("Event");
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
<input type="hidden" name="rlane" value="<%=rlane%>" id="rlane" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>VVD Mapping - VVD Select</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_ok" id="btn_ok">OK</button><!-- 
    	     --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
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
							<td><input class="input1" style="width:80px;cursor:default;" name="ofcCd" id="ofcCd" value="<%=loginOfcCd%>" unselectable="on"></td>
							<th>Year</th>
							<td><input class="input1" style="width:80px;cursor:default;" name="year" id="year" value="<%=year%>" unselectable="on"></td>
							<th>Quarter</th>
							<td><input class="input1" style="width:80px;cursor:default;" name="bse_qtr_cd" id="bse_qtr_cd" value="<%=qtr_cd%>" unselectable="on"></td>
						</tr>
						<tr>
							<th>Release Version</th>
							<td><input class="input1" style="width:80px;cursor:default;" name="mqtaRlseVerNo" id="mqtaRlseVerNo" value="<%=mqtaRlseVerNo%>" unselectable="on"></td>
							<th>Trade</th>
							<td><input class="input1" style="width:80px;cursor:default;" name="trd_cd" id="trd_cd" value="<%=trd_cd%>" unselectable="on"></td>
							<th>Bound</th>
							<td><input class="input1" style="width:80px;cursor:default;" name="dir_cd" id="dir_cd" value="<%=dir_cd%>" unselectable="on"></td>
						</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<table style="margin-bottom:10px"> 
           <colgroup>
                <col width="100">
                <col width="70">
                <col width="*">
            </colgroup>
            <tbody>
              		 <tr>
							<th>Lane</th>
							<td><select name="rlane_cd" id="rlane_cd" style="width:70px"></select></td>
							<td><button type="button" class="btn_etc" id="btn_go_retrieve" name="btn_go_retrieve">Go</button></td>
						</tr>
			</tbody>
		</table>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >				
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>