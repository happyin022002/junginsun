<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2039.jsp
*@FileTitle  : RFA Proposal Creation - Draft
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
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
<%@ page import="com.clt.apps.opus.esm.pri.rfareport.rfareport.event.EsmPri2039Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2039Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//Number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_srep      = "";
	String strProp_no 		= "";
	String strAmdt_seq 		= "";
	Logger log = Logger.getLogger("com.clt.apps.RFAReport.RFAReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_srep = account.getSrep_cd();
		strProp_no 	= request.getParameter("prop_no");
		strAmdt_seq 	= request.getParameter("amdt_seq");
		event = (EsmPri2039Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
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
<input type="hidden" name="usr_srep_cd" value="<%=StringUtil.xssFilter(strUsr_srep)%>" id="usr_srep_cd" />
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(strProp_no)%>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(strAmdt_seq)%>" id="amdt_seq" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Print</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<table> 
				<tbody>
					<tr>
						<th width="40">RFA No.</th>
						<td width="150">
							<input type="text" style="width:100px; text-align:center;" name="rfa_no" id="rfa_no" readonly class="input2">
							<input type="text" style="width:40px; text-align:center;" name="amdt_seq_t" id="amdt_seq_t" readonly class="input2">
						</td> 
						<th width="85">Proposal No.</th>
						<td width="100"><input type="text" caption="Proposal No" name="prop_no_t" id="prop_no_t" style="width:100px; text-align:center;" readonly class="input2"></td>
						<th width="310">Type</th>
					    <td width="200">
							&nbsp;
							<input type="radio" value="1" name="ret_tp_rdo" id="ret_tp_rdo1" checked><label for="ret_tp_rdo1">All Items</label>
							<input type="radio" value="2" name="ret_tp_rdo" id="ret_tp_rdo2" ><label for="ret_tp_rdo2">Amended Items</label>
							&nbsp;
						</td>
						<!-- <td><button type="button" class="btn_etc" name="btn_search" style="margin-bottom:0px" id="btn_search">Search</button></td> -->
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
		<div class="opus_design_RD">
			<script language="javascript">rdViewerObject();</script>
		</div>
	</div>
</div>
</form>