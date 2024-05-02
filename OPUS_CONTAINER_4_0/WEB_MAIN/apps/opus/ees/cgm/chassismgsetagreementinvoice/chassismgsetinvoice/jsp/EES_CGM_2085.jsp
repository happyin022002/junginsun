<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2085.jsp
*@FileTitle : Invoice Import & Audit
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2085Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm2085Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");
	
	String vndrSeq = StringUtil.xssFilter(request.getParameter("vndr_seq"));
	String costYrmon = StringUtil.xssFilter(request.getParameter("cost_yrmon"));
	String chgCreSeq = StringUtil.xssFilter(request.getParameter("chg_cre_seq"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCgm2085Event)request.getAttribute("Event");
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
<script language="javascript">
$("html").addClass("layer_popup_document").prepend("<button type='button' class='pop_close ir' onclick='ComClosePopup();' onmouseup='opener.closeSearch();'>Close</button>");
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name ="eq_knd_cd" value="">
<input type="hidden" name ="chg_cre_seq" value="<%=chgCreSeq %>">
<input type="hidden" name="vrfy_scs_flg">
<!-- developer working -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title" style="padding-left: 0px;"><span>Invoice Import & Audit</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_New" 	id="btn_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn_Agreemapping" id="btn_Agreemapping">Agreement Matching</button><!--
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<h3 class="title_design mar_btm_8">Charge Creation</h3>
			<table>
				<colgroup>
					<col width="50" />
					<col width="470" />
					<col width="60" />
					<col width="70" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Lessor</th>
						<td><input type="text" name="vndr_seq" readonly style="width:70px;text-align:center" class="input2" value="<%=vndrSeq %>" id="vndr_seq" /><input type="text" name="vndr_lgl_eng_nm" readonly style="width:350px;" class="input2" value="" id="vndr_lgl_eng_nm" /></td>
						<th>Currency</th>
						<td><input type="text" name="curr_cd" readonly style="width:40px;ime-mode:disabled;text-align:center" class="input2" value="USD" id="curr_cd" /></td>
						<th>Month</th>
						<td><input type="text" name="cost_yrmon" readonly style="width:60px;text-align:center" class="input2" value="<%=costYrmon %>" id="cost_yrmon" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
	</div>
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<h3 class="title_design mar_btm_8">Invoice File Import</h3>
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Loadexcel" 	id="btn_Loadexcel">Load Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_Downexcel" id="btn_Downexcel">Down Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_Audit" id="btn_Audit">Verify</button><!--
			--></div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>