<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_bkg_0549.jsp
*@FileTitle : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0549Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0549Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0549Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">

<%
	String vvd  = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String whfPolCd = (request.getParameter("whf_pol_cd") == null)? "":request.getParameter("whf_pol_cd");
	String whfBndCd = (request.getParameter("whf_bnd_cd") == null)? "":request.getParameter("whf_bnd_cd");
	String mrnNo = (request.getParameter("mrn_no") == null)? "":request.getParameter("mrn_no");
%>

<input type="hidden" name="mrn_no" value="<%=mrnNo %>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;Wharfage Vessel Information - Data Interface</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">

	<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table class="search" border="0" style="width:466px;">
			<tr class="h23">
				<th width="23px">VVD</th>
				<td width="90px"><input type="text" style="width:80px;ime-mode:disabled" class="input1" name="vvd" id= "vvd" value="<%=vvd %>" dataformat="engup" maxlength="9"></td>
				<th width="30px">Port</th>
				<td width="60px"><input type="text" style="width:50px;" class="input1" name="whf_pol_cd" id="whf_pol_cd" value="<%=whfPolCd %>" dataformat="engup" maxlength="5"></td>
				<th width="52px">Bound</th>
				<td width=""><select style="width:95px;" class="input1" id="whf_bnd_cd" name="whf_bnd_cd">
					<option value="OO" <%= ("OO".equals(whfBndCd) ? "selected=\"selected\"":"") %>>Outbound</option>
					<option value="II" <%= ("II".equals(whfBndCd) ? "selected=\"selected\"":"") %>>Inbound</option>
					</select>
				</td>
			</tr>
		</table>
	</div>
  </div>

  <div class="wrap_result">
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_inquiry">
		<table width="100%" class="search" border="0">
			<tr class="h23">
				<td width="33px">Total</td>
				<td width="190px"><input type="text" style="width:80px;text-align:right" class="input2" name="total" readonly="readonly" ></td>
				<td width="30px">OK</td>
				<td width="170px"><input type="text" style="width:80px;text-align:right" class="input2" name="ok" readonly="readonly" ></td>
				<td width="25px">Fail</td>
				<td width="*"><input type="text" style="width:80px;text-align:right" class="input2" name="fail" readonly="readonly" ></td>
			</tr>
		</table>
	</div>
</div>

</div>


</form>
