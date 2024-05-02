<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3007.jsp
*@FileTitle  : TAA Creation & Amendment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.taaproposal.event.EsmPri3007Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>

<%
	EsmPri3007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String usrId = null;
	String usrSrepCd = null;
	String usrOfcCd	 = null;
    String condTaaNo = null;
    String[] svcScpCds = null;
    String[] svcScpTrfs = null;
	Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TAAProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		usrId = account.getUsr_id();
		usrSrepCd = account.getSrep_cd();
		usrOfcCd = account.getOfc_cd();

		event = (EsmPri3007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        condTaaNo = JSPUtil.getNull(request.getParameter("cond_taa_no"));
        // Service Scope Combo Data 
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        
        svcScpTrfs = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"),false ,"|","\t","getCd","getEtc4"); 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var svcScpComboValue = "|<%=svcScpCds[0]%>";
    var svcScpComboText = " \t |<%=svcScpCds[1]%>";
    
    var svcScpTrfsValue = "<%=svcScpTrfs[0]%>";
    var svcScpTrfsText  = "<%=svcScpTrfs[1]%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" 								id="f_cmd" />
<input type="hidden" name="pagerows" 							id="pagerows" />
<input type="hidden" name="usr_id" value="<%=usrId %>" 			id="usr_id" />
<input type="hidden" name="usr_srep_cd" value="<%=usrSrepCd %>" id="usr_srep_cd" />
<input type="hidden" name="usr_ofc_cd" value="<%=usrOfcCd %>" 	id="usr_ofc_cd" />
<input type="hidden" name="old_svc_scp_cd" 						id="old_svc_scp_cd" />
<input type="hidden" name="taa_prop_no" 						id="taa_prop_no" />
<input type="hidden" name="cond_taa_no" value="<%=condTaaNo %>" id="cond_taa_no" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id=btn_Retrieve>Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New"  			id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Amend" 			id="btn_Amend">Amend</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_Confirm" 		id="btn_Confirm">Confirm</button><!--
		--><button type="button" class="btn_normal" name="btn_ConfirmCancel" 	id="btn_ConfirmCancel">Confirm Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_Cancel" 			id="btn_Cancel">Cancel</button>	
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
			<colgroup>
				<col width="90">
				<col width="130">
				<col width="60">
				<col width="70">
				<col width="60">
				<col width="270">
				<col width="60">
				<col width="70">
				<col width="*">
		    </colgroup>
		    <tbody>
			<tr>
                <th>TAA No.</th>
                <td><input type="text" caption="TAA Number" name="taa_no" id="taa_no" maxlength="12" style="width:90px;ime-mode:disabled;text-align:center;" dataformat="engup" class="input"><button type="button" class="input_seach_btn" name="btn_taa_no" id="btn_taa_no"></button></td>
                <th>AMD  No.</th>
                <td><script type="text/javascript">ComComboObject('amdt_seq', 2, 60, 1, 0, 0, false);</script></td>
                <th>Duration</th>
                <td><input type="text" style="width: 80px; text-align:center;" class="input1" caption="Effective date" name="eff_dt" id="eff_dt" coffield="exp_dt" maxlength="10" dataformat="ymd" required="required" />~&nbsp;
					<input type="text" style="width: 80px; text-align:center;" class="input1" caption="Expiration date" name="exp_dt" id="exp_dt" cofield="eff_dt" maxlength="10" dataformat="ymd" required="required" />
                	<button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button></td>
                <th>Confirmation</th>
                <td><input type="text" name="cfm_nm" id="cfm_nm" style="width:70px;text-align:center;" class="input2" readonly="readonly"></td>
                <td></td>
            </tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry "><table class="line_bluedot"><tr><td></td></tr></table></div>
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="90">
					<col width="400">
					<col width="*">
			    </colgroup>
				<tr>
	                <th>Service Scope</th>
	                <td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 90, 0, 1, 0, false);</script><input name="svc_scp_nm" id="svc_scp_nm" type="text" style="width:393px;text-align:left;" class="input2" readonly="readonly" caption="Service Scope"></td>
	                <td></td>
	            </tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="90">
					<col width="260">
					<col width="70">
					<col width="30">
					<col width="30">
					<col width="90">
					<col width="*">
			    </colgroup>
				<tr>
	                <th>Customer</th>
	                <td><input type="text" style="width: 30px;" dataformat="engup" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd" id="ctrt_cust_cnt_cd" class="input1" caption="Customer Code" required><input type="text" style="width: 55px;" dataformat="num" name="ctrt_cust_seq" id="ctrt_cust_seq" maxlength="6" class="input1" caption="Customer Sequence" required><button type="button" class="input_seach_btn" name="btn_ctrt_cust" id="btn_ctrt_cust"></button><input type="text" style="width: 187px;" name="ctrt_cust_nm" id="ctrt_cust_nm" readonly="readonly" class="input2"></td>
	                <th>Sales Rep.</th>
	                <td><script type="text/javascript">ComComboObject('respb_srep_cd', 3, 80, 0, 1);</script><input type="text" style="width:200px;text-align:left;" name="respb_srep_nm" id="respb_srep_nm" readonly="readonly" class="input2"></td>
	                <th>Office</th>
	                <td><input type="text" name="respb_sls_ofc_cd" id="respb_sls_ofc_cd" dataformat="engup" readonly="readonly" style="width:78px;text-align:left;" class="input2" caption="Request Office Code" required></td>
	                <td></td>
	            </tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
<!-- opus_design_grid(S) -->	
<div style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<div class="opus_design_grid">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_RowAdd" 		id=btn_RowAdd>Row Add</button>
		<button type="button" class="btn_accent" name="btn_RowDelete" 	id="btn_RowDelete">Delete</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
	<div class="opus_design_data">
		<table class="grid2" style="width:100%;">
	        <tr class="tr2_head">
	            <th width="25%" style="font-weight: bold">Origin</th>
	            <th width="25%" style="font-weight: bold">Origin Via</th>
	            <th width="25%" style="font-weight: bold">Destination Via</th>
	            <th width="25%" style="font-weight: bold">Destination </th>
	        </tr>
	        <tr class="input2">
	            <td><textarea name="org_pnt_loc_nm" style="width:100%; height:95px;resize:none;" class="textarea2" readonly="readonly"></textarea></td>
	            <td><textarea name="org_via_port_nm" style="width:100%; height:95px;resize:none;" class="textarea2" readonly="readonly"></textarea></td>
	            <td><textarea name="dest_via_port_nm" style="width:100%; height:95px;resize:none;" class="textarea2" readonly="readonly"></textarea></td>
	            <td><textarea name="dest_pnt_loc_nm" style="width:100%; height:95px;resize:none;" class="textarea2" readonly="readonly"></textarea></td>	
	        </tr>
	    </table>
	</div>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>