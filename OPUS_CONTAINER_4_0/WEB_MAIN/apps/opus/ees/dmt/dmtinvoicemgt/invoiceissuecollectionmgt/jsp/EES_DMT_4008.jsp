<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_4008.jsp
*@FileTitle  : Issued Invoice Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	String strRhq_ofc_cd= "";
	
	Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");
	
	String today = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();


		event = (EesDmt4008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		today = eventResponse.getETCData("OFC_CURR_DAY");	// date for session office code
		
		log.debug("###########################[ofc_curr_day]"+today);

	}catch(Exception e) {
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- Developer's task	-->
<input type="hidden" name="usr_trf_tp" id="usr_trf_tp" />
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>" id="usr_ofc_cd" />
<input type="hidden" name="s_payer_gubun" id="s_payer_gubun" />
<input type="hidden" name="s_dmdt_trf_cd" id="s_dmdt_trf_cd" />
<input type="hidden" name="s_dmdt_ar_if_cd" id="s_dmdt_ar_if_cd" />
<input type="hidden" name="s_dmdt_inv_sts_cd" id="s_dmdt_inv_sts_cd" />
<input type="hidden" name="s_issue_ofc" id="s_issue_ofc" />
<input type="hidden" name="s_inv_check" id="s_inv_check" />
<input type="hidden" name="intg_cd_id" value="CD01974" id="intg_cd_id" />
<input type="hidden" name="s_cust_gubun" id="s_cust_gubun" />
<input type="hidden" name="s_cust_cd" id="s_cust_cd" />
<input type="hidden" name="session_rhq_ofc_cd" value="<%=strRhq_ofc_cd%>" id="session_rhq_ofc_cd" />
<!-- searchCurrentDateByOffice -->
<input type="hidden" name="today_dt" value="<%=today %>" id="today_dt" />
<!-- subOfficeList -->
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="tmp_ofc_cd" id="tmp_ofc_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->

	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn_Minimize" id="btn_Minimize">Minimize</button><!--
			--><button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>						
	    </div>
	    <!-- opus_design_btn(E) -->
    
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->

</div>
<!-- page_title_area(E) -->

<!-- wrap_search_tab(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<div id="showMin" style="display: block">	
			<!--biz page (S)-->		
				<table> 
					<colgroup>
						<col width="80">
						<col width="200">
						<col width="60">
						<col width="140">
						<col width="100">
						<col width="200">
						<col width="60">
						<col width="160">
						<col width="*">
					</colgroup>
					<tr>
						<th>Tariff Type</th>
						<td><script type="text/javascript">ComComboObject('tariff_type',2,141,1,1);</script><button type="button" class="multiple_inq"></button></td>
						<th>A/R I/F</th>
						<td><script type="text/javascript">ComComboObject('ar_if',2,80,0,1,0,true);</script><% if( strRhq_ofc_cd.equals("NYCNA") || strRhq_ofc_cd.equals("SINHO") ) { %><button type="button" class="multiple_inq"></button><% } %></td>
						<th>Invoice Status</th>
						<td><script type="text/javascript">ComComboObject('invoice_status',2,135,0,1,0,true);</script><button type="button" class="multiple_inq"></button></td>
						<th>Group by</th>
						<td>
							<select name="s_group_by" style="width:150px;" class="input">
								<option value="1" selected>B/L No.(BKG No.)</option>
								<option value="2">CNTR No.</option>
							</select>
						</td>
						<td></td>
					</tr> 
				</table>
				<table > 
					<colgroup>
						<col width="68">
						<col width="70">
						<col width="250">
						<col width="70">
						<col width="220">
						<col width="80">
						<col width="60">
						<col width="53">
						<col width="*">
					</colgroup>
					<tr>
						<td class="sm"><input type="radio" name="ofc_inv_chk" id="ofc_inv_chk_1" class="trans" checked onclick="ofc_inv_click()"><label>OFC</label></td>
						<th class="sm">Issue Office</th>
						<td class="sm" style="padding-left:2"><script type="text/javascript">ComComboObject('office',2,80,0,1,0,true);</script><button type="button" class="multiple_inq"></button><input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans"><label>Incl.Sub Office</label></td>
						<th class="sm">Issued Date</th>
						<td class="sm"><input type="text" style="width:75px;" class="input1" name="s_issue_fm" maxlength="10" dataformat="ymd"  caption="Issued Date From">~&nbsp;<input type="text" style="width:75px;" class="input1" name="s_issue_to" value='' maxlength="10" dataformat="ymd" caption="Issued Date To"><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button></td>
						<th class="sm">INV Over Days</th>
						<td class="sm"><input type="text" name="s_inv_over" dataformat="int" maxlength="3" minnum='0' caption='F/Time Over Day' style="width:30px;text-align:right;" class="input" value="0"></td>
						<th class="sm">Issue ID</th>
						<td ><input type="text" name="s_issue_usr_id" style="width:75px" class="input" value=""><button type="button" class="input_seach_btn" name="btn_issue_usr" id="btn_issue_usr"></button></td>
					</tr>
				</table>	
				<table> 
					<colgroup>
						<col width="72">
						<col width="69">
						<col width="165">
						<col width="56">
						<col width="240">
						<col width="59">
						<col width="310">
						<col width="*">
					</colgroup>
					<tr>
						<td class="sm"><input type="radio" name="ofc_inv_chk" id="ofc_inv_chk_2" class="trans" onclick="ofc_inv_click()"><label for="ofc_inv_chk_2">INV</label></td>
						<th class="sm">Invoice No.</th>
						<td class="sm"><input type="text" style="width:80px" name="s_invoice_no" dataformat="engup" class="input" value=""><button type="button" class="multiple_inq" name="btns_multisearch1" id="btns_multisearch1"></button></td>
						<th class="sm">BKG No.</th>
						<td class="sm"><input type="text" name="s_bkg_no" dataformat="engup" style="width:177px" class="input" value=""><button type="button" class="multiple_inq" name="btns_multisearch2" id="btns_multisearch2"></button></td>
						<th class="sm">B/L No.</th>
						<td><input type="text" name="s_bl_no" dataformat="engup" style="width:300px" class="input" value=""><button type="button" class="multiple_inq" name="btns_multisearch3" id="btns_multisearch3"></button></td>
						<td></td>
					</tr>
				</table>						
				<table> 
					<colgroup>
						<col width="40">
						<col width="535">
						<col width="86">
						<col width="50">
						<col width="102">
						<col width="*">
					</colgroup>
					<tr>
						<th>Payer</th>
						<td><input type="text"  name="s_payer_cd" dataformat="engup" caption="Payer" maxlength="8" minlength="8" style="width:68px" class="input" value="" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"><!-- 
						 --><button type="button" class="input_seach_btn" name="btns_cust_cd" id="btns_cust_cd"></button><!-- 
						 --><input type="text" name="s_payer_nm" style="width:398px" class="input2" value="" readOnly></td>
						<th>S/C No.</th>
						<td><input type="text" name="s_sc_no" style="width:80px" dataformat="engup" class="input" caption="S/C No" maxlength="9" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
						<th>RFA No.</th>
						<td><input type="text" name="s_rfa_no" style="width:140px" dataformat="engup" class="input" caption="RFA No" maxlength="11" minlength="11" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
						<td></td>
					</tr>
				</table>
					<!--  biz_1   (E) -->
			</div>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search_tab(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >										
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->					
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->


<!-- Developer's task end  -->
</form>
