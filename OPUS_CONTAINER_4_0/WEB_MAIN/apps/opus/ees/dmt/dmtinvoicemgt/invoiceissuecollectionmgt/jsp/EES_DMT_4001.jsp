<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_4001.jsp
*@FileTitle  : Invoice Creation & Issue
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");
	String today = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();


		event = (EesDmt4001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		today = eventResponse.getETCData("OFC_CURR_DAY");	//session office code
		
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="s_ofc_cd">
<input type="hidden" name="s_dmdt_trf_cd">
<input type="hidden" name="today_dt" value="<%=today %>">
<input type="hidden" name="s_cust_gubun">


	<!-- page(S) -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button><!--
			--><button type="button" class="btn_normal" name="btn_billing" id="btn_billing" onmouseover="btn_mouseover()">Billing</button><!--
			--><button type="button" class="btn_normal" name="btn_group_billing" id="btn_group_billing" onmouseout="btn_mouseout()">Group Invoice Creation</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>		
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
	<!--Page Title, Historical (E)-->

	<div class="wrap_search">
		<div class="opus_design_inquiry wFit" id="showMin" style="display: block">
	        <table> 
	            <colgroup>
	                <col width="50px" />
	                <col width="139px" />
	                <col width="67px" />
	                <col width="270px" />	                
	                <col width="65px" />
	                <col width="130px" />
	                <col width="105" />
	                <col width="*" />
	            </colgroup>
	            <tbody>
	                <tr>
	                    <th>Office</th>
		                <td><script type="text/javascript">ComComboObject('office',2,80,0,1,0,true);</script></td>
		                <th>Tariff type</th>
		               	<td><script type="text/javascript">ComComboObject('tariff_type',2,220,0,1,0,true);</script><!--
							--><button type="button" class="multiple_inq"></button></td>
		               	<th>Group by</th>
		               	<td><select name="s_group_by" style="width:120px;" class="input">
								<option value="1" selected>B/L No.(BKG No.)</option>
								<option value="2">CNTR No.</option>
							</select></td>
		               	<th>Charge Type</th>
		               	<td><select name="s_chg_type" style="width:75px;" class="input">
								<option value="A" selected>All</option>
								<option value="G">General</option>
								<option value="B">Balance</option>
							</select></td>
		           </tr>
				</table>
				<table style="width:900px"> 
	            <colgroup>
	                <col width="50px" />
	                <col width="70px" />
	                <col width="60px" />
	                <col width="100px" />	                
	                <col width="50px" />
	                <col width="100px" />
	                <col width="50px" />
	                <col width="50px" />
	                <col width="" />
	            </colgroup>
	            <tbody>
					<tr class="sm">	
						<td>&nbsp;<input type="radio" name="s_cont_type" id="s_cont_type_1" class="trans" checked onclick="condType_click()"><label for="s_cont_type_1">Date</label></td>
						<th>Confirmed Date</th>
						<td colspan="6">
							<input type="text" style="width:80px;" class="input1" name="fm_cfm_dt" id="fm_cfm_dt" maxlength="10" dataformat="ymd"  caption="Confirmed From Date">~&nbsp;<!--
							--><input type="text" style="width:80px;" class="input1" name="to_cfm_dt" id="to_cfm_dt" value='' maxlength="10" dataformat="ymd"  caption="Confirmed To Date" ><!--
							--><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button>							
						</td>												
						<td></td>
					</tr>
					<tr class="sm">
						<td>&nbsp;<input type="radio" name="s_cont_type" id="name="s_cont_type_2" class="trans" onclick="condType_click()"><label for="s_cont_type_2">CNTR</label></td>
						<th>BKG No.</th>
						<td><input type="text" name="s_bkg_no" dataformat="engup" style="width:100px;ime-mode;" class="input" value="" onKeyPress="DmtComKeyOnlyAlphabet('uppernum',',')"><!--
							--><button type="button" class="multiple_inq" name="btns_multisearch1" id="btns_multisearch1" onClick="openPopup('bkg_no')"></button></td>
						<th>B/L No.</th>
						<td><input type="text" name="s_bl_no" dataformat="engup" style="width:100px;ime-mode;" class="input" value="" onKeyPress="DmtComKeyOnlyAlphabet('uppernum',',')"><!--
							--><button type="button" class="multiple_inq" name="btns_multisearch2" id="btns_multisearch2" onClick="openPopup('bl_no')"></button></td>
						<th>CNTR No.</th>
						<td colspan="2"><input type="text" name="s_cntr_no" dataformat="engup" style="width:100px;ime-mode;" class="input" value="" onKeyPress="DmtComKeyOnlyAlphabet('uppernum',',')"><!--
							--><button type="button" class="multiple_inq" name="btns_multisearch3" id="btns_multisearch3" onClick="openPopup('cntr_no')"></button></td>
						<td></td>
						
					</tr>
				</table>
				<table style="width:900px"> 
	            <colgroup>
	                <col width="50px" />
	                <col width="288px" />
	                <col width="60px" />
	                <col width="184px" />	                
	                <col width="50px" />
	                    <col width="" />
	            </colgroup>
	            <tbody>
					<tr>						
						<th>Payer</th>
						<td><input type="text" name="s_cust_cd" style="width:65px;" dataformat="engup" class="input" caption="Payer" maxlength="8" minlength="8" style="236;" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"><!--
							--><button type="button" class="input_seach_btn" name="btns_cust_cd" id="btns_cust_cd"></button><!--							
							--><input type="text" name="s_cust_name" style="width:167px;" class="input2" readOnly></td>
						<th>S/C No.</th>
						<td><input type="text" name="s_sc_no" style="width:100px;" dataformat="engup" class="input" caption="S/C No" maxlength="9" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
						<th>RFA No.</th>
						<td><input type="text" name="s_rfa_no" style="width:100px;" dataformat="engup" class="input" caption="RFA No" maxlength="11" minlength="11" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">
						</td>	
																	
					
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script>ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>

</form>
