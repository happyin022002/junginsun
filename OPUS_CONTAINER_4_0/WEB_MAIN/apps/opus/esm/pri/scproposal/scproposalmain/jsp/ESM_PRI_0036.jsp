<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0036.jsp
*@FileTitle  : Amendment Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event.EsmPri0036Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	String sc_no  = request.getParameter("sc_no");
	String sEffDt = request.getParameter("sEffDt");
	String sExpDt = request.getParameter("sExpDt");

	EsmPri0036Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";

	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCProposalMain");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsmPri0036Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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
<input type="hidden" name="sEffDt" value="<%=StringUtil.xssFilter(sEffDt)%>" id="sEffDt" />
<input type="hidden" name="sExpDt" value="<%=StringUtil.xssFilter(sExpDt)%>" id="sExpDt" />
<input type="hidden" name="org_prop_no" value="<%=strUsr_ofc%>" id="org_prop_no" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	    <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Amendment Request</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			 <button type="button" class="btn_accent" name="btn_ok" id="btn_ok">OK</button>
			 <button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit"> 	
			<table>
				<colgroup>
					<col width="50" />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">S/C No.</th>
					    <td><input type="text" style="width:165px;" readonly name="sc_no" readonly value="<%=StringUtil.xssFilter(sc_no)%>" class="input2" id="sc_no" /></td>
					</tr>
					<tr>
						<th scope="row">Duration</th>
					    <td><input type="text" style="width:75px;" name="ctrt_eff_dt" readonly class="input2" maxlength="10" dataformat="ymd" caption="Effective date" cofield="ctrt_exp_dt" id="ctrt_eff_dt" /><span class="dash">~</span><input type="text" style="width:75px;" name="ctrt_exp_dt" readonly class="input2" maxlength="10" dataformat="ymd" caption="Expiration date" cofield="ctrt_eff_dt" id="ctrt_exp_dt" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid pad_top_15" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
</form>