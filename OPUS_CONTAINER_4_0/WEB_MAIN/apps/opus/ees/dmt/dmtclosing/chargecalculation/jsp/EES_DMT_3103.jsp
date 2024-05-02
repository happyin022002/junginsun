<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3103.jsp
*@FileTitle  : Correction Save History 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3103Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3103Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTClosing.ChargeCalculation");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		event = (EesDmt3103Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="login_cnt_cd" name="login_cnt_cd" value="<%=strCnt_cd%>" type="hidden" />
<input id="svr_id" name="svr_id" value="<%=JSPUtil.getParameter(request, " svr_id", "") %>" type="hidden" />
<input id="cntr_cyc_no" name="cntr_cyc_no" value="<%=JSPUtil.getParameter(request, " cntr_cyc_no", "") %>" type="hidden" />
<input id="dmdt_chg_loc_div_cd" name="dmdt_chg_loc_div_cd" value="<%=JSPUtil.getParameter(request, " dmdt_chg_loc_div_cd", "") %>" type="hidden" />
<input id="chg_seq" name="chg_seq" value="<%=JSPUtil.getParameter(request, " chg_seq", "") %>" type="hidden" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Correction Save History</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Close" name="btn_Close" class="btn_accent">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table style="width:  880px;">
			<colgroup>
				<col width="50"/>
				<col width="120"/>
				<col width="45"/>
				<col width="50"/>
				<col width="50"/>
				<col width="45"/>
				<col width="50"/>
				<col width="40"/>
				<col width="45"/>
				<col width="50"/>
				<col width="70"/>
				<col width="45"/>
				<col width="50"/>
				<col width="120"/>
				<col width="45"/>
				<col width="50"/>
				<col width="120"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>CNTR No.</th>
					<td><input id="cntr_no" name="cntr_no" value="<%=JSPUtil.getParameter(request, " cntr_no", "") %>" readonly="readonly" style="width: 90px;" class="input2"><input id="cntr_tpsz_cd" name="cntr_tpsz_cd" value="<%=JSPUtil.getParameter(request, " cntr_tpsz_cd", "") %>" readonly="readonly" style="width: 25px;" class="input2"></td>
					<td></td>
					<th>Tariff Type</th>
					<td><input id="dmdt_trf_cd" name="dmdt_trf_cd" value="<%=JSPUtil.getParameter(request, " dmdt_trf_cd", "") %>" readonly="readonly" style="width: 45px;" class="input2" value=""></td>
					<td></td>
					<th id="tdGB">G/B</th>
					<td><input id="chg_type" name="chg_type" value="<%=JSPUtil.getParameter(request, " chg_type", "") %>" readonly="readonly" style="width: 20px;" class="input2" value=""></td>
					<td></td>
					<th>Office</th>
					<td><input id="ofc_cd" name="ofc_cd" value="<%=JSPUtil.getParameter(request, " ofc_cd", "") %>" readonly="readonly" style="width: 50px;" class="input2" value=""></td>
					<td></td>
					<th>BKG No.</th>
					<td><input id="bkg_no" name="bkg_no" value="<%=JSPUtil.getParameter(request, " bkg_no", "") %>" readonly="readonly" style="width: 105px;" class="input2" value=""></td>
					<td></td>
					<th>B/L No.</th>
					<td><input id="bl_no" name="bl_no" value="<%=JSPUtil.getParameter(request, " bl_no", "") %>" readonly="readonly" style="width: 100px;" class="input2" value=""></td>
					<td></td>
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
	
	<div class="opus_design_data">
	<table style="width: 880px; border: 1" class="grid_2"> 
		<tr>
			<th><strong>Remark(s)</strong></th>
			<td><textarea id="corr_his_rmk" name="corr_his_rmk" readonly="readonly" style="width: 780; height: 50px" class="textarea2"></textarea></td>
		</tr>
	</table>
</div>
</div>

<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>
</form>