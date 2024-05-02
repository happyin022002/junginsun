<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0061.jsp
*@FileTitle  : S/C Retrieval 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
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
<%@ page import="com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0061Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0061Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_srep      = "";
	String strProp_no 		= "";
	String strAmdt_seq 		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCReport.SCReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_srep = account.getSrep_cd();
		strProp_no 	= request.getParameter("prop_no");
		strAmdt_seq 	= request.getParameter("amdt_seq");
		event = (EsmPri0061Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(strProp_no)%>">
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(strAmdt_seq)%>">
<input type="hidden" name="hd_scp_tp_cd" value="A">
<input type="hidden" name="pagerows">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>&nbsp;Print</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
			<!-- <button type="button" class="btn_normal" name="btn_saveas" id="btn_saveas">Save As</button> -->
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<div id="sch_cond_div" style=display:block;>
				<table>
					<colgroup>
			            <col width="55" />
			            <col width="130" />
			            <col width="60" />
			            <col width="70" />
			            <col width="120" />
			            <col width="200" />
			            <col width="100" />
			            <col width="70" />
			            <col width="100" />
			            <col width="" />
					</colgroup>
					<tbody>
						<tr>
							<th>S/C No.</th>
							<td><input type="text" style="width:110px; text-align:center;" name="sc_no" readonly=true class="input2"></td>
							<th>AMD No.</th>
							<td><input type="text" style="width:40px; text-align:center;" name="amd_seq" readonly=true class="input2"></td> 
							<th>S/C Effective Date</th>
							<td><input type="text" caption="Duration" name="ctrt_eff_dt" dataformat="ymd" style="width:80px; text-align:center;" readonly=true class="input2" >&nbsp;~&nbsp;
										   <input type="text" caption="Duration" name="ctrt_exp_dt" dataformat="ymd" style="width:80px; text-align:center;" readonly=true class="input2" ></td>
							<th>Contract Office</th>
							<td><input type="text" style="width:65px; text-align:center;" name="prop_ofc_cd"  readonly=true class="input2"></td>
							<th>Customer Type</th>
							<td><input type="text" style="width:25px; text-align:center;" name="prc_ctrt_cust_tp_cd" readonly=true class="input2"></td>
						</tr>
						<tr>
							<!-- <td class="sm"><button type="button" id="btn_search" name="btn_search" class="btn_etc" >Search</button></td>-->
							<td colspan="9" height="30px">
								&nbsp;<input type="radio" class="trans" name="scp_tp_cd" value="A" onClick="scp_tp_cd_OnChange(this);" checked>
								All contents including expired data&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" class="trans" name="scp_tp_cd" value="E" onClick="scp_tp_cd_OnChange(this);">
								Effective contents only
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="wrap_result">
		<div class="opus_design_grid" style="height=0px;"><script language="javascript">ComSheetObject('sheet1');</script></div>
		<div class="opus_design_RD"><script language="javascript">rdViewerObject();</script></div>
		<div style="height=0px;"><script type="text/javascript" for=report1 event="ReportFinished();">ReportFinished();</script></div>
	</div>
</div>

</form>