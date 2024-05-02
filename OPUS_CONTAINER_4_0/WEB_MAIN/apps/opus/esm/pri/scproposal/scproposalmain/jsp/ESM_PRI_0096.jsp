<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0096.jsp
*@FileTitle  : S/C Copy Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event.EsmPri0096Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0096Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCProposalMain");
	
	String propNo = null;
	String amdtSeq = null;
    String scNo = null;
    String custTp = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri0096Event)request.getAttribute("Event");
        propNo  = JSPUtil.getNull(request.getParameter("prop_no"));
        amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
        scNo    = JSPUtil.getNull(request.getParameter("sc_no"));
        custTp  = JSPUtil.getNull(request.getParameter("cust_tp"));
        
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
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
<input type="hidden" name="sc_no" value="<%=scNo %>" id="sc_no" />
<input type="hidden" name="cust_tp" value="<%=custTp %>" id="cust_tp" />
<!-- developer performance	-->
<!-- input type="hidden" name="cd" -->
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	    <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>S/C Copy Option</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_Ok" id="btn_Ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
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
					<col width="50">
					<col width="140">
					<col width="50">
					<col width="70">
					<col width="70">
					<col width="110">
					<col width="70">
					<col width="80">						
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>S/C No.</th>
						<td><input type="text" name="sc_no_fst" style="width:45px;text-align:center;" value="<%=(scNo.length() > 3)?scNo.substring(0,3):"" %>" class="input2" id="sc_no_fst" readonly="readonly"/> 
							<input type="text" name="sc_no_lst" style="width:60px;text-align:center;" value="<%=(scNo.length() > 3)?scNo.substring(3):"" %>" class="input2" id="sc_no_lst" readonly="readonly"/>
						</td>
						<th>AMD No.</th>
						<td><input type="text" name="amdt_seq" style="width:45px;text-align:center;" value="<%=amdtSeq%>" class="input2" readonly="readonly" id="amdt_seq" /></td>
						<th>Proposal No.</th>
						<td><input type="text" name="prop_no" style="width:90px;text-align:center;" value="<%=propNo%>" class="input2" readonly="readonly" id="prop_no" /></td>
						<th class="sm"><input type="checkbox" name="blpl_chk_frm" class="trans" id="blpl_chk_frm" /><label for="blpl_chk_frm">Boiler Plate</label></th> 
						<th class="sm"><input type="checkbox" name="afil_chk_frm" class="trans" id="afil_chk_frm" /><label for="afil_chk_frm">Affiliate</label></th>					
						<td></td>
					</tr>
				</tbody>
			</table>		
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="display:inline;">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
</form>