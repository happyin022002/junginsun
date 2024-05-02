<%
/* 
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2040.jsp
*@FileTitle  : RFA Proposal Creation [Amend]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2040Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	String rfaNo  = request.getParameter("sRfaNo");
	String amdtSeq = request.getParameter("sAmdtSeq");
	String propNo = request.getParameter("sPropNo");
	String sDurDt = request.getParameter("sSdurDt");
	String eDurDt = request.getParameter("sEdurDt");
	String effDt = request.getParameter("sEffDt");
	
	sDurDt = sDurDt.replace("-", "");
	sDurDt=sDurDt.substring(0, 4) + "-" + sDurDt.substring(4, 6) + "-" + sDurDt.substring(6, 8);
	
	eDurDt = eDurDt.replace("-", "");
	eDurDt=eDurDt.substring(0, 4) + "-" + eDurDt.substring(4, 6) + "-" + eDurDt.substring(6, 8);
	
	String nwDur= "";
	EsmPri2040Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFAProposalMain");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri2040Event)request.getAttribute("Event");
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
<input type="hidden" name="sDurDt" value="<%=StringUtil.xssFilter(sDurDt)%>" id="sDurDt" />
<input type="hidden" name="eDurDt" value="<%=StringUtil.xssFilter(eDurDt)%>" id="eDurDt" />
<input type="hidden" name="new_dur" value="<%=nwDur%>" id="new_dur" />
<!-- page_title_area(S) -->

<!-- layer_popup_title(S) -->
 <div class="layer_popup_title">
	<div class="page_title_area clear">	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>RFA Proposal Creation [Amend]</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_OK" id="btn_OK" type="button">OK</button>
			<button class="btn_accent" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->		
	</div>
</div>
<!-- layer_popup_title(E) -->

<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
	<!-- wrap_result(S) -->
	<div class="wrap_result">
	<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="80" />
						<col width="190" />
						<col width="120" />
						<col width="50" />
						<col width="50" />
						<col width="*" />
					</colgroup>
					<tr class="h23">
						<th>RFA No.</th>
						<td><input type="text" style="width:106px;text-align:center;" class="input2" name="rfa_no" value="<%=StringUtil.xssFilter(rfaNo) %>" id="rfa_no" /></td>
						<th>AMD No.</th>
						<td><input type="text" style="width:40px;text-align:center;" class="input2" name="amdt_seq" value="<%=StringUtil.xssFilter(amdtSeq)%>" id="amdt_seq" /></td>
						<th>Proposal No.</th>
						<td><input type="text" style="width:100px;text-align:center;" class="input2" name="prop_no" value="<%=StringUtil.xssFilter(propNo) %>" id="prop_no" /></td>
					</tr>
				</tbody>
			</table>
				<table>
				<tbody>
					<colgroup>
						<col width="80" />
						<col width="190" />
						<col width="120" />
						<col width="80" />
						<col width="*" />
					</colgroup>
					<tr class="h23">
						<th>Duration</th>
						<td><input type="text" style="width:80px;text-align:center;" class="input2" name="sdur_dt" value="<%=StringUtil.xssFilter(sDurDt) %>" maxlength="10" dataformat="ymd" readonly="true" id="sdur_dt" />~ <input type="text" style="width:80px;text-align:center;" class="input2" name="edur_dt" value="<%=StringUtil.xssFilter(eDurDt) %>" maxlength="10" dataformat="ymd" readonly="true" id="edur_dt" />
						<th>New Duration</th>
						<td id="new_ctrt_dt"><input type="text" id="ctrt_eff_dt" style="width:80px;text-align:center;" class="input2" name="ctrt_eff_dt" value="<%=StringUtil.xssFilter(sDurDt) %>" maxlength="10" dataformat="ymd" readonly="true" /><input type="text" id="exp_dt" style="width:80px;text-align:center;" class="input1" name="exp_dt" value="<%=StringUtil.xssFilter(eDurDt) %>" maxlength="10" dataformat="ymd" tabindex="1" /><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
						<td></td>
					</tr>
				</tbody>
			</table>
				<table>
				<tbody>
					<colgroup>
						<col width="80" />
						<col width="190" />
						<col width="120" />
						<col width="*" />
					</colgroup>
					<tr class="h23">
						<th>Possible EFF</th>
						<td><input type="text" style="width:80px;text-align:center;" class="input2" name="pos_eff_dt" value="<%=StringUtil.xssFilter(effDt) %>" maxlength="10" dataformat="ymd" readonly="true" id="pos_eff_dt" />~ <input type="text" style="width:80px;text-align:center;" class="input2" name="pos_exp_dt" value="<%=StringUtil.xssFilter(eDurDt) %>" maxlength="10" dataformat="ymd" readonly="true" id="pos_exp_dt" /> </td>
						<th>AMD EFF</th>
						<td><input type="text" style="width:80px;text-align:center;" class="input1" name="eff_dt" value="" maxlength="10" dataformat="ymd" tabindex="2" id="eff_dt" /><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
					</tr>	
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
</div>
<!-- layer_popup_contents(E) -->
</form>