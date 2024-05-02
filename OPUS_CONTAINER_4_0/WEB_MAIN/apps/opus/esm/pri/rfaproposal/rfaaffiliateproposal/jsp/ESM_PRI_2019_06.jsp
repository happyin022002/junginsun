<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2019_06.jsp
*@FileTitle : RFA Proposal Inquiry - Affiliate
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.event.EsmPri201906Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri201906Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//Number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.RFAAffiliateProposal");

	String propNo = "";
	String amdtSeq = "";
	String rfaNo = "";
	String ctrtExpDt = "";
	String ctrtEffDt = "";
	String condPropNo = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri201906Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");	
		rfaNo = request.getParameter("sRfaNo");
		ctrtExpDt = request.getParameter("sCtrtExpDt");
		ctrtEffDt = request.getParameter("sCtrtEffDt");
		condPropNo = request.getParameter("cond_prop_no");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
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

<input type="hidden" name="cd">
<input type="hidden" name="cond_prop_no" value="<%= StringUtil.xssFilter(condPropNo) %>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>RFA Proposal Inquiry - Affiliate</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button> 
			<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		 	<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->


<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- inquiry_area(S) -->
		<div class="opus_design_inquiry">   <!-- no TAB  -->
			<table> 
				<colgroup>
					<col width="50px" />
					<col width="120px" />
					<col width="55px" />
					<col width="70px" />
					<col width="80px" />
					<col width="110px" />
					<col width="50px" />
					<col width="150px" />
					<col width="" />
				</colgroup>
				<tbody>
					<tr>
						<th>RFA No.</th>
						<td>
						<input type="text" name="rfaNo" style="width:100px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(rfaNo)%>" readonly>&nbsp;
						</td>
						<th>AMD No.</th>
						<td><input type="text" name="amdt_seq" style="width:50px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(amdtSeq) %>" readonly></td> 
						<th>Proposal No.</th>
						<td><input type="text" name="prop_no" style="width:90px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(propNo)%>" readonly></td>
						<th>Duration</th>
						<td><input type="text" name="hdr_eff_dt" style="width:85px;text-align:center;" class="input2" caption="Eff Date" maxlength="10" dataformat="ymd" value="<%=StringUtil.xssFilter(ctrtEffDt)%>" readonly>&nbsp;~&nbsp;
							<input type="text" name="hdr_exp_dt" style="width:85px;text-align:center;" class="input2" caption="Expire Date" maxlength="10" dataformat="ymd" value="<%=StringUtil.xssFilter(ctrtExpDt)%>" readonly>
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- inquiry_area(E) -->

	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<!-- opus_grid_design_btn(S) -->
			
			<script language="javascript">ComSheetObject('sheet1');</script>
			
			<!-- opus_grid_design_btn(E) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
<!-- popup_contens_area(E) -->
</div>
</form>