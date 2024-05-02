<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0027.jsp
*@FileTitle  : Mis Use In & Out Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0095Event"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.event.EesLse0027Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>

<%
	EesLse0027Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCur_dt		= "";
	String strUsr_off_cd    = "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseAgreementRegistration.AgreementRegistration");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strUsr_off_cd = account.getOfc_cd();

		event = (EesLse0027Event)request.getAttribute("Event");
		strCur_dt = EesLse0027Event.getCurrentDate("yyyy-MM-dd");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
<%=OfficeCodeMgr.getOfficeCodeListToJS("000001", "LSE")%>
<%=ConstantMgr.getBaseLocationCodeToJS()%>
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
<input type="hidden" name="usr_ofc_cd" id="usr_ofc_cd" value="<%= strUsr_off_cd %>">
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_New" id="btn_New">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100">
				<col width="240">
				<col width="95">
				<col width="100">
				<col width="120">
				<col width="*">
			</colgroup>
			<tr>
				<th>Request No.</th>
				<td><input type="text" name="rqst_no" caption="Request No." style="width:160px;" value="" class="input2" readonly id="rqst_no" /></td>
				<th>Request OFC</th>
				<td><input type="text" name="rqst_ofc_cd" caption="Request OFC" style="width:80px;text-align:center;" value="<%= strOfc_cd %>" class="input2" readonly id="rqst_ofc_cd" /></td>
				<th>Request User ID</th>
				<td><input type="text" name="rqst_usr_id" caption="Request User ID" style="width:88px;text-align:center;color:blue;cursor:hand;" value="<%= strUsr_id %>" class="input2" readonly id="rqst_usr_id" /></td>
			</tr>
			<tr>
				<th>Approval OFC</th> 	
				<td><input type="text" name="apro_ofc_cd" caption="Approval OFC" style="width:90px;text-align:center;" value="SINHO" class="input2" readonly id="apro_ofc_cd" /></td>
				<th class="sm">Request Case</th>
				<td class="sm"><input type="radio" name="mss_rqst_io_mod_cd" value="O" class="trans" checked id="mss_rqst_io_mod_cd" />&nbsp;MUO&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="mss_rqst_io_mod_cd" value="I" class="trans" id="mss_rqst_io_mod_cd" />&nbsp;MUI&nbsp;&nbsp;&nbsp;</td>
				<th>Date</th>
				<td><input type="text" name="rqst_dt" caption="Date" style="width:88px;text-align:center;" value="<%= strCur_dt %>" class="input2" readonly id="rqst_dt" /></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100">
				<col width="440">
				<col width="134">
				<col width="*">
			</colgroup>
			<tr>
				<th>Return SCC</th>
				<td><input type="text" name="rtrn_loc" caption="Return SCC" style="width:60px;text-align:center;ime-mode:disabled;" value="" class="input" maxlength="5" dataformat="engup" id="rtrn_loc" /><!--  
				--><button type="button" id="btns_search" name="btns_search" class="input_seach_btn"></button><!--  
				--><input type="text" name="n1st_ref_ofc_cd" style="width:50px;text-align:center;" value="" class="input" maxlength="5" dataformat="engup" id="n1st_ref_ofc_cd" /><!--  
				--><input type="text" name="n2nd_ref_ofc_cd" style="width:50px;text-align:center;" value="" class="input" maxlength="5" dataformat="engup" id="n2nd_ref_ofc_cd" /><!--  
				--><input type="text" name="n3rd_ref_ofc_cd" style="width:50px;text-align:center;" value="" class="input" maxlength="5" dataformat="engup" id="n3rd_ref_ofc_cd" /><!--  
				--><input type="text" name="n4th_ref_ofc_cd" style="width:50px;text-align:center;" value="" class="input" maxlength="5" dataformat="engup" id="n4th_ref_ofc_cd" /><!--  
				--></td>
				<th>Currency</th>
				<td><input type="text" name="curr_cd" caption="Currency" style="width:59px;text-align:center;" value="" class="input" maxlength="3" dataformat="enguponly" id="curr_cd" /><!-- 
				 --><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="sheetTable">
		<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--  
	--><button type="button" class="btn_normal" name="btn_Delete"  	id="btn_Delete">Row Delete</button><!--  
	--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_data">
		<table class="grid_2">
			<colgroup>
				<col width="90">
				<col width="*">
			</colgroup>
			<tr>
				<th>Remark(s)</th>
				<td><textarea name="diff_rmk" id="diff_rmk" caption="Remarks" rows="5" style="width:100%;height:70px;resize:none;"></textarea></td>
			</tr>
		</table>
	</div>
</div>
<div style="display:none">
	<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>
</form>