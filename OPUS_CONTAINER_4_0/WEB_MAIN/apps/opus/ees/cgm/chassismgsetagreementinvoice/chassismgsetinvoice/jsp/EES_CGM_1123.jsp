<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1123.jsp
*@FileTitle  : Co-Op Pool Payable Charge Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeMGTVO"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1123Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1123Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	DBRowSet rowSet = null;						//DB ResultSet
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String actoinflag = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		event = (EesCgm1123Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		document.form.ofc_cd.value = "<%=ofc_cd%>";
		loadPage();
	}
</script>

<form name="form2"><input id="sXml" name="sXml" value="<%=xml.replace(" \"","'") %>" type="hidden" /></form>
<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="eq_knd_cd" name="eq_knd_cd" value="Z" type="hidden" />
<input id="actionflag" name="actionflag" type="hidden" />
<input id="ofc_cd" name="ofc_cd" type="hidden" />
<input id="agmt_lstm_cd" name="agmt_lstm_cd" value="CP" type="hidden" />
<input id="inv_no" name="inv_no" type="hidden" />
<input id="pay_inv_seq" name="pay_inv_seq" type="hidden" />
<input id="chss_mgst_inv_knd_cd" name="chss_mgst_inv_knd_cd" value="CP" type="hidden" />
<input id="chss_mgst_inv_sts_cd" name="chss_mgst_inv_sts_cd" type="hidden" />
<input id="agmt_ofc_cty_cd" name="agmt_ofc_cty_cd" type="hidden" />
<input id="agmt_seq" name="agmt_seq" type="hidden" />
<input id="agmt_ver_no" name="agmt_ver_no" value="1" type="hidden" />
<input id="chss_pool_cd" name="chss_pool_cd" type="hidden" />
<input id="curr_cd" name="curr_cd" type="hidden" />
<input id="chg_smry_amt" name="chg_smry_amt" type="hidden" />
<input id="inv_smry_amt" name="inv_smry_amt" type="hidden" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Confirm" id="btn_Confirm">P. Amt Confirm</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Invoice Delete</button>
		
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
					<col width="20" />
					<col width="30" />
					<col width="292" />
					<col width="30" />
					<col width="208" />
					<col width="30" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Cost Month</th>
					<td><input id="cost_yrmon" name="cost_yrmon" dataformat="ym" style="width: 80px;" class="input1" value="" maxlength="7" type="text" /><button class="calendar ir" name="btns_cost_yrmon" id="btns_cost_yrmon" type="button"></button></td>
					<th>Cost Office</th>
					<td><input id="cost_ofc_cd" name="cost_ofc_cd" dataformat="engup" maxlength="6" style="width: 100px;" class="input1" value="" type="text" /><button class="input_seach_btn" name="btns_office" id="btns_office" type="button"></button></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>Invoice No.</th>
					<td><script type="text/javascript">ComComboObject('combo_inv', 1, 150, 0, 1, 0, true);</script></td>
					<th>Agreement No.</th>
					<td><script type="text/javascript">ComComboObject('combo_agmt', 4, 123, 1, 1, 0, false);</script></td>
					<th>Pool Name</th>
					<td><script type="text/javascript">ComComboObject('combo_pool', 1, 100, 0);</script></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="10" />
					<col width="30" />
					<col width="300" />
					<col width="30" />
					<col width="400" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Vendor Code</th>
					<td><input id="vndr_seq" name="vndr_seq" style="width: 150px;" class="input2" value="" readonly type="text" /> </td>
					<th>Vendor Name</th>
					<td><input id="vndr_lgl_eng_nm" name="vndr_lgl_eng_nm" style="width: 380px;" class="input2" value="" readonly type="text" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- layout_wrap (S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_2 mar_rgt_12" style="width: 49%">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	            <script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>    

	    
	    <div class="opus_design_data">
		    <div class="layout_vertical_2" style="width:50%">
		        <table class="grid_2"> 
		        	<tr class="tr2_head">
		        		<th>Remark</th>
		        	</tr>
					<tr>
						<td><textarea name="diff_rmk" id="diff_rmk" style="width: 100%; height: 270px; ime-mode:disabled"></textarea></td>
					</tr>
				</table>	
		    </div>
	    </div>
	</div>
	<!-- layout_wrap (E) -->
</div>

<!-- opus_design_grid(S) -->
    <div class="opus_design_grid" style="display: none;">
        <script type="text/javascript">ComSheetObject('sheet2');</script>
    </div>
<!-- opus_design_grid(E) -->
</form>