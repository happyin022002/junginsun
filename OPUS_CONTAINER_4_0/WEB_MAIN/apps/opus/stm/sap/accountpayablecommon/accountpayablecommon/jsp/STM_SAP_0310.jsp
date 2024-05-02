<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0310.js
*@FileTitle  : Create Credit Cards 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================
*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0310Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
    StmSap0310Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg    = "";   				//에러메세지

	String strUsr_id    = "";
	String strUsr_nm    = "";

	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (StmSap0310Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
  	function setupPage(){
		var errMessage = "<%=strErrMsg%>";

		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
  	
</script>

<form  name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="crd_cd_cmb_seq" id="crd_cd_cmb_seq" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
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
	            <col width="130"/>
	            <col width="*" />
            </colgroup>
             <tr>
                 <th>Card Number</th>
				 <td><input type="text" style="width:180px;" class="input1" name="crd_no" dataformat="engup" maxlength="19" id="crd_no"/><button type="button" id="btns_search_crdNo" name="btns_search_crdNo" class="input_seach_btn"></button></td>
             </tr>
         </table>
     </div>
     <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	 <div class="opus_design_inquiry wFit">      
		 <h3 class="title_design">Card Program</h3>
		 <table>
		 	<colgroup>
	            <col width="130"/>
	            <col width="*" />
            </colgroup>
		    <tr>
			    <th>Card Program Name</th>
				<td><input type="text" style="width:150px;" class="input1" name="crd_pgm_nm" maxlength="50" id="crd_pgm_nm"/></td>
			</tr>
		 </table>
		 
		 <table>
		 	<colgroup>
	            <col width="130"/>
	            <col width="360" />
	            <col width="110"/>
	            <col width="350" />
	            <col width="*"/>
            </colgroup>
			<tr>
			    <th>Card Program Code</th>
				<td><script type="text/javascript">ComComboObject('crd_pgm_cd', 2, 70, 0, 1, 0, false, 1);</script></td>
				<th>Card Program Type</th>
				<td><script type="text/javascript">ComComboObject('crd_tp_lu_cd', 1, 120, 0, 0, 0, false, 1);</script></td>
				<td></td>
			</tr>
		 </table>
		 
		 <table>
		 	<colgroup>
	            <col width="130"/>
	            <col width="365" />
	            <col width="112"/>
	            <col width="350" />
	            <col width="*"/>
            </colgroup>
			<tr>
			    <th>Card Currency</th>
			    <td><script type="text/javascript">ComComboObject('crd_pgm_curr_cd', 1, 70, 0, 1, 0, false, 1);</script></td>
				<th>Card Supplier No</th>
				<td><input type="text" style="width:60px;" class="input" name="vndr_no" maxlength="6" dataformat="engup" id="vndr_no" /><button type="button" id="btns_search_supplier" name="btns_search_supplier" class="input_seach_btn"></button><input type="text" style="width:220px;" class="input2" name="vndr_nm" maxlength="100" readonly id="vndr_nm" /></td></td>
				<td></td>
            </tr>
            <tr>
			    <th>Card Brand </th>
				<td><script type="text/javascript">ComComboObject('crd_brnd_lu_cd', 1, 120, 0, 1, 0, false, 1);</script></td>
			</tr>
		 </table>
		 
		 <table>
		 	<colgroup>
	            <col width="130"/>
	            <col width="*"/>
            </colgroup>
			<tr>
			    <th>Card COA</th>
				<td><input type="text" style="width:30px;" class="input2" name="coa_co_cd" dataformat="engup" maxlength="2" readonly id="coa_co_cd" /><input type="text" style="width:30px;" class="input2" name="coa_rgn_cd" dataformat="engup" maxlength="2" readonly id="coa_rgn_cd" /><input type="text" style="width:60px;" class="input2" name="coa_ctr_cd" dataformat="engup" maxlength="6" readonly id="coa_ctr_cd" /><input type="text" style="width:60px;" class="input2" name="coa_acct_cd" dataformat="engup" maxlength="6" readonly id="coa_acct_cd" /><input type="text" style="width:30px;" class="input2" name="coa_inter_co_cd" dataformat="engup" maxlength="2" readonly id="coa_inter_co_cd" /><input type="text" style="width:90px;" class="input2" name="coa_vvd_cd" dataformat="engup" maxlength="10" readonly id="coa_vvd_cd" /><button type="button" id="btns_search_coa" name="btns_search_coa" class="input_seach_btn"></button></td>
			</tr>
		 </table>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
    <div class="opus_design_inquiry wFit">
		 <h3 class="title_design">Cards</h3>
		 
		 <table>
		 	<colgroup>
	            <col width="130"/>
	            <col width="360" />
	            <col width="110"/>
	            <col width="350" />
	            <col width="*"/>
            </colgroup>
		    <tr>
			    <th>Card Member Name</th>
			    <td><input type="text" style="width:120px;" class="input1" name="crd_mbr_nm" maxlength="50" id="crd_mbr_nm" /></td>
			    <th>Department Name </th>
			    <td><input type="text" style="width:120px;" class="input" name="crd_dept_nm" maxlength="50" id="crd_dept_nm" /></td>
			    <td></td>
			</tr>
	        <tr>
			    <th>Card Receipt Office</th>
			    <td><input type="text" style="width:90px;" class="input1" name="crd_dtrb_ofc_cd" dataformat="engup" maxlength="6" id="crd_dtrb_ofc_cd" /><button type="button" id="btns_search_ofc" name="btns_search_ofc" class="input_seach_btn"></button></td>
            	<th>Distribution Date</th>
			    <td><input type="text" style="width:90px;" class="input1" name="crd_dtrb_dt"  dataformat="ymd" maxlength="10" id="crd_dtrb_dt" /><button type="button" id="btns_calDtrbDt" name="btns_calDtrbDt" class="calendar ir"></button></td>
			    <td></td>
			</tr>
		       <tr>
	        	<th>Inactive On </th>
	            <td><input type="text" style="width:90px;" class="input" name="crd_inact_dt" dataformat="ymd" maxlength="10" id="crd_inact_dt" /><button type="button" id="btns_calInactDt" name="btns_calInactDt" class="calendar ir"></button></td>
	            <th>Expiration Date </th>
	            <td><input type="text" style="width:90px;" class="input" name="crd_exp_dt"   dataformat="ymd" maxlength="10" id="crd_exp_dt" /><button type="button" id="btns_calExpDt" name="btns_calExpDt" class="calendar ir"></button></td>
	            <td></td>
	        </tr>
	     </table>
	     <table>
	     	<colgroup>
	            <col width="130"/>
	            <col width="*"/>
            </colgroup>
			<tr>
	            <th>Card Description</th>
	            <td><input type="text" style="width: 790px;" class="input" name="crd_desc" maxlength="100" id="crd_desc" /></td>
	        </tr>
	     </table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result" style="display: none;">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>