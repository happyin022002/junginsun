<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0219.jsp
*@FileTitle  : M&R Simple WO File Import Pop_Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0219Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0219Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");

	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();

		event = (EesMnr0219Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}       

		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {   
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";
    var self_usr_nm = "<%=strUsr_nm%>";
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
<input type="hidden" name="retfld" id="retfld" />
<input type="hidden" name="eq_type" value="" id="eq_type" />
<input type="hidden" name="mnr_grp_tp_cd" value="" id="mnr_grp_tp_cd" />
<input type="hidden" name="mnr_wo_tp_cd" value="" id="mnr_wo_tp_cd" />

<input type="hidden" name="agmt_ofc_cty_cd" value="" id="agmt_ofc_cty_cd" />
<input type="hidden" name="agmt_seq" value="" id="agmt_seq" />
<input type="hidden" name="agmt_ver_no" value="" id="agmt_ver_no" />
<input type="hidden" name="cost_ofc_cd" value="" id="cost_ofc_cd" />
<input type="hidden" name="vndr_seq" value="" id="vndr_seq" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>M&R Simple WO File Import</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_new" id="btn_new" type="button">New</button><!--
			--><button class="btn_normal" name="btn_FileImport" id="btn_FileImport" type="button">Load Excel</button><!--
			--><button class="btn_normal" name="btn_ok" id="btn_ok" type="button">Ok</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />				
					<col width="100" />				
					<col width="70" />				
					<col width="100" />				
					<col width="100" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			<th><nobr>EQ Type </nobr></th>
			   			<td><input type="text" name="eq_knd_cd_text" style="width:100px;" class="input2" readonly id="eq_knd_cd_text" /><!--
						--><input type="hidden" name="eq_knd_cd" id="eq_knd_cd" /></td>
						<th><nobr>Cost Type </nobr></th>
						<td><input type="text" name="cost_cd_text" style="width:100px;" class="input2" readonly id="cost_cd_text" /><!--
						--><input type="hidden" name="cost_cd" id="cost_cd" /></td>
						<th><nobr>Service Sub Type </nobr></th>
						<td><script type="text/javascript">ComComboObject('combo_cost_dtl_cd',2, 200 , 1, 1,0,false,1);</script><!--
						--><input type="hidden" name="cost_dtl_cd" id="cost_dtl_cd" /></td>
			   		</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Save" id="btn_Save" type="button">Verify</button><!--
			--><button class="btn_normal" name="btn_RowAdd" id="btn_RowAdd" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_RowDel" id="btn_RowDel" type="button">Row Del</button><!--
			--></div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<div class="opus_design_data">
				<table>
					<colgroup>
						<col width="*"/>												
					</colgroup> 			
					<tbody>				
						<tr>
							<td><h3 class="title_design">Simple Work Order File Format</h3></td>									
						</tr>				
					</tbody>
				</table>
				<table class="grid_2 wAuto">
					<colgroup>
						<col width="110" />
						<col width="110" />
						<col width="110" />
					</colgroup>
					<tbody>
						<tr>
							<th><strong>EQ No.</strong></th>
							<th><strong>Yard</strong></th>
							<th><strong>Work Date</strong></th>
						</tr>
						<tr>
							<td><input type="text" style="width:100%;text-align:center;" class="noinput" value="HLCU0523724" /></td>
							<td><input type="text" style="width:100%;text-align:center;" class="noinput" value="KRPUSY1" /></td>
							<td><input type="text" style="width:100%;text-align:center;" class="noinput" value="2008-10-12" /></td>
						</tr>
					</tbody>
				</table>
			</div>	
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<!-- layer_popup_contents(E) -->
</form>
<%@include file="/bizcommon/include/common_opus.jsp" %>