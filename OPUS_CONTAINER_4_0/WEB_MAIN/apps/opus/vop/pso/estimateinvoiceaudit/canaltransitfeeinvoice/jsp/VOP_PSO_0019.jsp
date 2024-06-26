<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : vop_pso_0019.jsp
*@FileTitle  : Requested Actual Invoice
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.event.VopPso0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vndrSeq = "";
	String vvd = "";
	String ydCd = "";
	String callSeq = "";
	String revYrmon = "";
	String row = "";
	String col = "";
	String sts = ""; //Status CD
	String trnsDt = "";
	
	Logger log = Logger.getLogger("com.clt.apps.EstimateInvoiceAudit.CanalTransitFeeInvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//Getting request from Main
		vndrSeq 	= StringUtil.xssFilter((String) request.getParameter("vndrSeq"));
		vvd	    	= StringUtil.xssFilter((String) request.getParameter("vvd"));
		ydCd    	= StringUtil.xssFilter((String) request.getParameter("ydCd"));
		callSeq 	= StringUtil.xssFilter((String) request.getParameter("callSeq"));
		revYrmon 	= StringUtil.xssFilter((String) request.getParameter("revYrmon"));
		row 		= StringUtil.xssFilter((String) request.getParameter("row"));
		col 		= StringUtil.xssFilter((String) request.getParameter("col"));
		sts 		= StringUtil.xssFilter((String) request.getParameter("sts"));
		trnsDt 		= StringUtil.xssFilter((String) request.getParameter("trnsDt"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<title>Requested Actual Invoice</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vndr_seq" value="<%=vndrSeq%>" />
<input type="hidden" name="vvd" value="<%=vvd%>" />
<input type="hidden" name="yd_cd" value="<%=ydCd%>" />
<input type="hidden" name="call_seq" value="<%=callSeq%>" />
<input type="hidden" name="rev_yrmon" value="<%=revYrmon%>" />
<input type="hidden" name="rqst_amt_sum">
<input type="hidden" name="calc_amt_sum">
<input type="hidden" name="row" value="<%=row%>" />
<input type="hidden" name="col" value="<%=col%>" />
<input type="hidden" name="sts" value="<%=sts%>" />
<input type="hidden" name="inv_rgst_no" value="" />

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Requested Actual Invoice</span></h2>
		
		<div class="opus_design_btn">
			 <button type="button" class="btn_normal" name="btn_Reject" id="btn_Reject">Reject</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
				<tr class="h23">
					<th width="50px">VVD</th>
					<td width="100px"><input readonly type="text" style="width:85;text-align:center" class="input2" value="<%=vvd%>"></td>
					<th width="130px">SCNT</th>
					<td width="160px"><input readonly name="scnt" type="text" style="width:85;text-align:center" class="input2" value=""></td>
					<th width="30px">SDR</th>
					<td width="150px"><input readonly name="sdr" type="text" style="width:60;text-align:center" class="input2" value=""><button type="button" id="btn_sdr" name="btn_sdr" class="input_seach_btn" title="Exchange Rate Archives by Month"></button></td>
					<th width="30px">Tier</th>
					<td width="125px"><input readonly name="tier" type="text" style="width:60;text-align:center" class="input2" value=""></td>
					<th width="90px">Transit Date</th>
					<td width=""><input type="text" style="width:80;text-align:center" class="input2" value="<%=trnsDt%>"></td>
				</tr>
				<tr class="h23">
					<th width="">INV No.</th>
					<td width=""><input name="inv_no" type="text" style="width:240;text-align:center" class="input2" value=""></td>
					<th width="">Limit Time Surcharge</th>
					<td width="" colspan="7"><input name="limit" type="text" style="width:60;text-align:center" class="input2" value=""></td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
			<div class="opus_design_grid">
				
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
				</div>
				<!-- opus_grid_btn(E) -->
			
			
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>
