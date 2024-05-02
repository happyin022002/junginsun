<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_PRI_2041.js
*@FileTitle  : RFA  Amendment History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2041Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2041Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//Number of DB ResultSet List
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
    String rfaNo = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsrSrepCd     = "";
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFAProposalMain");
	String[] termType = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    strUsrSrepCd = account.getSrep_cd();
		event = (EsmPri2041Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        // Adding Logic extracting data from server when loading initial window ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		termType = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("termType"), false);
		
        rfaNo = request.getParameter("rfa_no_2043");
				
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var termTypeComboValue = " |<%=termType[0]%>";
    var termTypeComboText = " |<%=termType[1]%>";
    
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
<input type="hidden" name="in_usr_ofc_cd" value="<%=strUsr_ofc%>" id="in_usr_ofc_cd" />
<input type="hidden" name="in_usr_srep_cd" value="<%=strUsrSrepCd%>" id="in_usr_srep_cd" />
<input type="hidden" name="in_usr_nm" value="<%=strUsr_nm%>" id="in_usr_nm" />
<input type="hidden" name="prop_no" id="prop_no" />
<!--  Using when 2043 calls PopUp -->
<input type="hidden" name="rfa_no_2043" value="<%=StringUtil.xssFilter(rfaNo)%>" id="rfa_no_2043" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span>RFA Amendment History</span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="85px">
					<col width="180px">
					<col width="50px">
					<col width="86px">
					<col width="50px">
					<col width="230px">
					<col width="80px">
					<col width="170px">
					<col width="*">
			    </colgroup>
				<tr class="h23">
					<th>RFA No.</th>
					<td><input type="text" style="width:110px;text-align:center;" class="input1" name="rfa_no" id="rfa_no" dataformat="engup" maxlength="11" onKeyDown="ComKeyEnter('NextFocus')"></td>
					<th>AMD No.</th>
					<td><input type="text" style="width:40px;text-align:center;" class="input2" name="amdt_seq" id="amdt_seq" readonly></td>
					<th>Customer</th>
					<td><input type="text" style="width:220px;" class="input2" name="ctrt_pty_nm" id="ctrt_pty_nm" readonly></td>
					<th>Duration</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input2" name="ctrt_eff_dt" id="ctrt_eff_dt" readonly maxlength="10" dataformat="ymd">&nbsp;&nbsp;~&nbsp;&nbsp;
						<input type="text" style="width:80px;text-align:center;" class="input2" name="ctrt_exp_dt" id="ctrt_exp_dt" readonly maxlength="10" dataformat="ymd">
					</td>
					<td></td>
				</tr>
				<tr class="h23">
					<th>SVC Scope</th>
					<td colspan="5">
						<script type="text/javascript">ComComboObject('svc_scp_cd', 2, 57, 0 , 0, 0, false);</script><!-- 
						&nbsp; --><input type="text" style="width:550px;" class="input2" name="svc_scp_nm" id="svc_scp_nm" readonly caption="Service Scope Name"></td>
					<th>By Item</th>
					<td>
						<script type="text/javascript">ComComboObject('term_type_cd', 1, 81, 0 , 0, 0);</script>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<!-- <table class="line_bluedot"><tr><td colspan="6"></td></tr></table> -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->	
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<!-- iFrame (S) -->
	<div id="tabLayer" name="tabLayer" style="display:none">
		<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="420" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" name="tabLayer" style="display:none">
		<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="420" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" name="tabLayer" style="display:none">
		<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="420" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" name="tabLayer" style="display:none">
		<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="690" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" name="tabLayer" style="display:none">
		<iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="420" src="about:blank"></iframe>
	</div>               
	<div id="tabLayer" name="tabLayer" style="display:none">
		<iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="420" src="about:blank"></iframe>
	</div>         
	<div id="tabLayer" name="tabLayer" style="display:none">
		<iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="420" src="about:blank"></iframe>
	</div>     
	<div id="tabLayer" name="tabLayer" style="display:none">
		<iframe name="t8frame" id="t8frame" frameborder="0" scrolling="no" width="100%" height="550" src="about:blank"></iframe>
	</div>                                                          
	<!-- iFrame (E) -->
</div>
</form>