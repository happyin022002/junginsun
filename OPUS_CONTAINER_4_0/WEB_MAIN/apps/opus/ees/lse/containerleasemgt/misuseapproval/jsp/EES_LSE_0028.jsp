<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0028.js
*@FileTitle  : Mis Use In & Out Approval
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
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.event.EesLse0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>

<%
	EesLse0028Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesLse0028Event)request.getAttribute("Event");
		strCur_dt = EesLse0028Event.getCurrentDate("yyyy-MM-dd");
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
function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} else if("SELCOE" != "<%= strOfc_cd %>") {
			//ComShowCodeMessage("LSE01035");
			//document.location.href = LSE_INIT_BODY_PAGE;
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="rqst_no" id="rqst_no" />
<input type="hidden" name="apro_no" id="apro_no" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_retrive" id="btn_retrive">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button></div>
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
				<col width="80">
				<col width="210">
				<col width="120">
				<col width="110">
				<col width="100">
				<col width="60">
				<col width="120">
				<col width="*">
			</colgroup>
			<tr>
				<th>Request No.</th>
				<td><script type="text/javascript">ComComboObject('combo1', 1, 212, 1, 3);</script></td>
				<th>Approval OFC</th>
				<td><input type="text" name="apro_ofc_cd" caption="Approval OFC" style="width:60px;text-align:center;" value="SINHO" class="input2" readonly id="apro_ofc_cd" /></td>
				<th>Approval User ID</th>
				<td><input type="text" name="apro_usr_id" caption="Approval User ID" style="width:90px;text-align:center;color:blue;cursor:hand;" value="<%= strUsr_id %>" class="input2" readonly id="apro_usr_id" /></td>
				<th>Approval Date</th>
				<td><input type="text" name="apro_dt" caption="Approval Date" style="width:80px;text-align:center;" value="<%= strCur_dt %>" class="input2" readonly id="apro_dt" /></td>
			</tr>
			<tr>
				<th>Return SCC</th>
				<td><!--  
				--><input type="text" name="n1st_ref_ofc_cd" style="width:50px;text-align:center;" value="" class="input2" dataformat="engup" readonly id="n1st_ref_ofc_cd" /><!--  
				--><input type="text" name="n2nd_ref_ofc_cd" style="width:50px;text-align:center;" value="" class="input2" dataformat="engup" readonly id="n2nd_ref_ofc_cd" /><!--  
				--><input type="text" name="n3rd_ref_ofc_cd" style="width:50px;text-align:center;" value="" class="input2" dataformat="engup" readonly id="n3rd_ref_ofc_cd" /><!--  
				--><input type="text" name="n4th_ref_ofc_cd" style="width:50px;text-align:center;" value="" class="input2" dataformat="engup" readonly id="n4th_ref_ofc_cd" /><!--  
				--><input type="hidden" name="ref_ofc_cd" caption="Return Loc." style="width:170px;" value="" class="input2" readonly id="ref_ofc_cd" />
				</td>
				<th>Request OFC</th>
				<td><input type="text" name="rqst_ofc_cd" caption="Request OFC" style="width:60px;text-align:center;" value="" class="input2" readonly id="rqst_ofc_cd" /></td>
				<th>Request User ID</th>
				<td><input type="text" name="rqst_usr_id" caption="Request User ID" style="width:90px;text-align:center;color:blue;" value="" class="input2" readonly id="rqst_usr_id" /></td>
				<th>Request Date</th>
				<td><input type="text" name="rqst_dt" caption="Request Date" style="width:80px;text-align:center;" value="" class="input2" readonly id="rqst_dt" /></td>
			</tr>
			<tr>
				<th>Total CNTR</th>
				<td><input type="text" name="cntr_cnt" caption="Total CNTR" style="width:50px;text-align:right;" value="" class="input2" readonly id="cntr_cnt" /></td>
				<th>Currency</th>
				<td><input type="text" name="curr_cd" caption="Currency" style="width:60px;text-align:center;" value="" class="input2" readonly id="curr_cd" /></td>
				<th class="sm">Approval Case</th>
				<td class="sm"><input type="radio" name="mss_rqst_io_mod_cd" value="O" class="trans" disabled="" id="mss_rqst_io_mod_cd" /> MUO   <input type="radio" name="mss_rqst_io_mod_cd" value="I" class="trans" disabled="" id="mss_rqst_io_mod_cd" />   MUI</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result" >
	<div class="opus_design_gird" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_data">
		<table class="grid_2">
			<colgroup>
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th style="text-align:center;">Request<br>&nbsp;Remark(s)</th>
				<td style="text-align:center;"><textarea name="diff_rmk" caption="Request Remarks" rows="5" style="width:100%;height:70px;resize:none;" class="noinput2" readonly></textarea></td>
			</tr>
			<tr>
				<th style="text-align:center;" >Approval<br>&nbsp;Remark(s)</th>
				<td style=" text-align:center;"><textarea name="apro_rmk" caption="Approval Remarks" rows="5" style="width:100%;height:70px;resize:none;"></textarea></td>
			</tr>
		</table>
		
	</div>
</div>

<div style="display:none">
	<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>

</form>