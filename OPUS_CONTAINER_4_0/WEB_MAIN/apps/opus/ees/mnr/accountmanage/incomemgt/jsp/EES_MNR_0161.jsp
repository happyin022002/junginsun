<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0161.js
*@FileTitle  : Disposal Invoice Issue & Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.event.EesMnr0161Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0161Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strRhq_ofc_cd         = "";
	Logger log = Logger.getLogger("com.clt.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();
		
		event = (EesMnr0161Event)request.getAttribute("Event");
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

<!-- common use in MNR -->     
<script language="javascript">   
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=strRhq_ofc_cd %>';
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="key_value" id="key_value">  
<input type="hidden" name="usr" id="usr" value="<%=strUsr_id %>">
<input type="hidden" name="ar_hd_qtr_cd" id="ar_hd_qtr_cd">
<input type="hidden" name="ofc_cd" id="ofc_cd">
<input type="hidden" name="inv_search_tp" id="inv_search_tp">
<input type="hidden" name="from_dt" id="from_dt">
<input type="hidden" name="to_dt" id="to_dt">
<input type="hidden" name="mnr_ord_seq" id="mnr_ord_seq">
<input type="hidden" name="vndr_seq" id="vndr_seq">
<input type="hidden" name="inv_sch_type_code" id="inv_sch_type_code">
<input type="hidden" name="mnr_inv_sts_cd" id="mnr_inv_sts_cd">
<input type="hidden" name="rcv_inv_seq" id="rcv_inv_seq">
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments">
<input type="hidden" name="com_mrdPath" id="com_mrdPath">
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle">
<input type="hidden" name="cancel_yn" id="cancel_yn">
<input type="hidden" name="mnr_grp_tp_cd" id="mnr_grp_tp_cd">
<input type="hidden" name="mnr_prnr_tp_cd" id="mnr_prnr_tp_cd">
<input type="hidden" name="conv_dp_prcs_knt" id="conv_dp_prcs_knt">
<input type="hidden" name="mnr_prnr_knd_cd" id="mnr_prnr_knd_cd">
<input type="hidden" name="g_real_amt" id="g_real_amt">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_New_All" id="btn_New_All">New</button>
		<button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button>
		<button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Delete</button>
		<button type="button" class="btn_normal" name="btn_Confirm" 	id="btn_Confirm">Confirm</button>
		<button type="button" class="btn_normal" name="btn_Preview" 	id="btn_Preview">Invoice Preview</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

	<!-- page_title_area(E) -->

	<!-- opus_design_inquiry(S) -->
	
<!-- opus_design_inquiry(E) -->
<!-- layout_wrap(S) -->
<div class="wrap_search_tab" style="overflow:hidden" >
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 715px;">
		<div class="opus_design_grid" style="width: 510px;">
			<!-- opus_design_btn(S) -->
			<h3 style="margin-bottom:0" class="title_design">Invoice List</h3>
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_New" id="btn_New">New</button>
				<button type="button" class="btn_normal" name="btn_Retrieve"  	id="btn_Retrieve">Retrieve</button>
			</div>
			<!-- opus_design_btn(E) -->
		</div>
		<div>
			<div class="opus_design_inquiry" style="float: left;width: 190px;">
				<table> 
					<tr>
						<th width="35" style="text-align: left">KIND</th>
						<td width="120"><script type="text/javascript">ComComboObject('combo_kind',1, 100 , 1,1);</script></td>
					</tr>
					<tr id="buyerTp">
						<th width="35" style="text-align: left">Buyer Type</th>
						<td width="120"><script type="text/javascript">ComComboObject('combo_buyer_type',1, 100 , 1,1);</script></td>
					</tr>								
				</table>
			</div>
			<!-- Select Tab [ Disposal No ] (S) -->
			<div class="opus_design_inquiry" id="selectLayer" style="display:inline; width: 340px;float: left">
				<table> 
					<tr>
						<th width="75" style="text-align: left">App Date</th>
						<td width=""><input type="text" name="t1_from_dt" id="t1_from_dt" style="width:80px;" class="input1" dataformat="ymd"  caption="From Date"><input type="text" name="t1_to_dt" id="t1_to_dt" style="width:80px;" class="input1" dataformat="ymd"  caption="To Date" ><button type="button" class="calendar ir" name="btn_t1_calendar" id="btn_t1_calendar"></button></td>
					</tr>
					<tr>
						<th>Disposal No.</th>
						<td><input name="t1_mnr_ord_seq" id="t1_mnr_ord_seq" type="text" style="width:221px;" dataformat="engup" otherchar="-,"><!--
						--><button type="button" class="multiple_inq ir" name="btn_t1_req_multy" id="btn_t1_req_multy"></button></td>
					</tr>
					<tr>
						<th style="text-align: left">Buyer</th>
						<td>
						<input type="text" name="t1_mnr_prnr_cnt_cd" id="t1_mnr_prnr_cnt_cd" style="width:25px" value="" maxlength=2 class="input" dataformat="engup"><!--
 --><input type="text" name="t1_mnr_prnr_seq" id="t1_mnr_prnr_seq" style="width:55px" value="" class="input" maxlength=9 dataformat="num"><!--
						--><button type="button" name="btn_t1_provider_popup" id="btn_t1_provider_popup" class="input_seach_btn"></button><!--
						--><input type="text" name="t1_mnr_prnr_cnt_nm" id="t1_mnr_prnr_cnt_nm" style="width:133px" value="" class="input2" readonly title="">
						</td>
					</tr>
				</table>	
			</div>
			
			<div>
				<table class="opus_design_inquiry" id="selectLayer1" style="display:none; width: 350px;float: left">
					<colgroup>
						<col width="75" />
						<col width="75" />
						<col width="75" />
						<col width="75" />
						<col width="75" />
						<col width="*" />
					</colgroup> 
					<tr>
						<th width="75" style="text-align: left">INV Date&nbsp;</th>
						<td><input name="t2_from_dt" id="t2_from_dt" type="text" style="width:99px" class="input" dataformat="ymd"><!-- 
							 --><input name="t2_to_dt" id="t2_to_dt" type="text" style="width:99px" class="input" dataformat="ymd"><!-- 
							 --><button type="button" class="calendar ir" name="btn_t2_calendar" id="btn_t2_calendar"></button>
						</td>
					</tr>
					<tr>
						<th style="text-align:left">INV No.&nbsp;</th>
						<td><input name="t2_mnr_ord_seq" id="t2_mnr_ord_seq" type="text" style="width:221px;" dataformat="engup" ><!-- 
							 --><button type="button" class="multiple_inq ir" id="btn_t2_req_multy" name="btn_t2_req_multy"></button>
						</td>
					</tr>
					<tr>
						<th style="text-align: left">Buyer&nbsp;</th>
						<td><input type="text" name="t2_mnr_prnr_cnt_cd" id="t2_mnr_prnr_cnt_cd" style="width:25px" value="" maxlength=2 class="input" dataformat="engup"><!-- 
							 --><input type="text" name="t2_mnr_prnr_seq" id="t2_mnr_prnr_seq" style="width:55px" value="" class="input" maxlength=9 dataformat="engup"><!-- 
							 --><button type="button" name="btns_search1" id="btn_t2_provider_popup" name="btn_t2_provider_popup" class="input_seach_btn"></button><!-- 
							 --><input type="text" name="t2_mnr_prnr_cnt_nm" id="t2_mnr_prnr_cnt_nm" style="width:133px" value="" class="input2" readonly title="">
						</td>
					</tr>
				</table>	
			</div>
						
			<div class="opus_design_grid" id="selectLayer2" style="width:680px; ">
				<script type="text/javascript">ComSheetObject('t1sheet1');</script>
				<!-- opus_design_btn(E) -->
				<div style="float: right;margin-top: 5px;">
					<button type="button" class="btn_etc" name="btn_t1_DetailRetrieve" id="btn_t1_DetailRetrieve">Detail Retrieve</button>
				</div>
				<!-- opus_design_btn(E) -->
			</div>
			<div class="opus_design_grid" id="selectLayer3" style="display:none;width:680px">
				<script type="text/javascript">ComSheetObject('t2sheet1');</script>
				<!-- opus_design_btn(E) -->
				<div style="float: right;margin-top: 5px;">
					<button type="button" class="btn_etc" name="btn_t2_DetailRetrieve" id="btn_t2_DetailRetrieve">Detail Retrieve</button>
				</div>
				<!-- opus_design_btn(E) -->
			</div>
			<!-- Select Tab [ Disposal No ] (E) -->
		</div>
	</div>
     <!-- layout_vertical_2(E) -->
     
	 <!-- layout_vertical_2(S) -->    
     <div class="layout_vertical_2" style="width: 500px;">
     <h3 class="title_design">Invoice Information</h3>
    	<div class="opus_design_inquiry" style="padding-left: 0px">
		<table>
			<tbody>
				<colgroup>
					<col width="72" />
					<col width="200" />
					<col width="100" />
					<col width="*" />
				</colgroup> 
				<tr>
					<th style="text-align: left">Invoice No.</th>
					<td><input name="input_inv_no" id="input_inv_no" type="text" style="width:140px;" maxlength="20" class="input2" readOnly="true" dataformat="engup" ></td>
					<th style="padding-right: 10px;">Invoice Status</th>
					<td><input name="inv_status" id="inv_status" type="hidden" style="width:100px;" class="input2" readOnly="true"><!-- 
						 --><script type="text/javascript">ComComboObject('combo_status',1, 100 , 1,3);</script>
					</td>
				</tr>
			</tbody>
			</table>	
			<table>
				<colgroup>
					<col width="72" />
					<col width="235" />
					<col width="65" />
					<col width="*" />
				</colgroup>  
				<tr>
					<th style="text-align: left">Invoice DT</th>
					<td>
						<input name="inv_dt" id="inv_dt" type="text" style="width:70px;" class="input1" dataformat="ymd"><!--
						 <img name="btn_inv_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						 --><button type="button" class="calendar ir" name="btn_inv_dt" id="btn_inv_dt"></button>
					</td>
					<th>Due DT</th>
					<td>
						<input name="inv_due_dt" type="text" style="width:72px;"  class="input1" dataformat="ymd"><!--
						
						--><button type="button" class="calendar ir" name="btn_due_dt" id="btn_due_dt"></button>
					</td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="72">
					<col width="75">
					<col width="75">
					<col width="95">
					<col width="89">
					<col width="*">
				</colgroup>
				<tr>
					<th style="text-align: left">Currency</th>
					<td><input name="curr_cd" id="curr_cd" type="text" style="width:70px;" class="input2" readOnly="true"></td>
					<th>INV Office</th>
					<td><input name="iss_ofc_cd" id="iss_ofc_cd" type="text" style="width:80px;" class="input2" readOnly="true"></td>
					<th>Reference No.</th>
					<td><input name="ref_no" id="ref_no" type="text" style="width:65px;" class="input" maxlength="50" dataformat="engup"></td>
				</tr>
			</table>
			<table> 
				<colgroup>
					<col width="72">
					<col width="*">
				</colgroup>
				<tr>
					<th style="text-align: left">Buyer</th>
					<td><input name="buyer_cd" id="buyer_cd" type="text" style="width:70px;" class="input2" readOnly="true"><!-- 
						 --><input name="buyer_nm" id="buyer_nm"  type="text" style="width:226px;" class="input2" readOnly="true"><!-- 
						 --><input name="buyer_type" id="buyer_type" type="text" style="width:98px;" class="input2" readOnly="true">
					</td>
				</tr>
			</table>
			<table> 
				<colgroup>
					<col width="72"/>
					<col width="225"/>
					<col width="95"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th style="text-align: left">Bank Name</th>
					<td><input name="bank_nm" id="bank_nm" type="text" style="width:212px;" class="input2" ></td>
					<th>Bank Account</th>
					<td><input name="bank_acct_no" id="bank_acct_no" type="text" style="width:82px;" class="input2" ></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="72"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th style="text-align: left">Bill to</th>
					<td colspan="5"><input name="mnr_bil_to_nm" id="mnr_bil_to_nm" type="text" style="width:402px;" class="input2" readOnly="true" ></td>
				</tr>
			</table>						
			<table> 
				<colgroup>
					<col width="72"/>
					<col width="95"/>
					<col width="60"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th style="text-align: left">INV AMT</th>
					<td><input name="amt" id="amt" type="text" style="width:80px; text-align:right;" readOnly="true" class="input2" dataformat="float" ></td>
					<th style="padding-right: 15px;">W.H.Tax</th>
					<td><input name="wht" id="wht" type="text" style="width:84px; text-align:right;" class="input" dataformat="float"></td>
				</tr> 
			</table>
			<table>
				<colgroup>
					<col width="72"/>
					<col width="92"/>
					<col width="60"/>
					<col width="*"/>
					<col width="77"/>
					<col width=""/>
				</colgroup>	
				<tr> 
					<th style="text-align: left">V.A.Tax</th> 
					<td><input name="vat" id="vat" type="text" style="width:80px; text-align:right;" readOnly="true" class="input2" dataformat="float"></td>
					<th style="padding-right: 15px;">Tax Rate</th> 	 	 	
					<td><input name="vat_xch_rt" id="vat_xch_rt" type="text" style="width:40px; " class="input" dataformat="float" pointcount="3"></td>
					<th>EX.Rate</th>
					<td><input name="chg_xch_rt" id="chg_xch_rt" type="text" style="width:60px; text-align:right;" class="input" dataformat="float"><script type="text/javascript">ComComboObject('chg_curr_cd',2, 50 , 1,0);</script></td>
				</tr>		
			</table>  				
			<table>
				<colgroup>
					<col width="72"/>
					<col width="170"/>
					<col width="70"/>
					<col width="*"/>
				</colgroup>	 							
				<tr>	  
					<th style="text-align: left">G.Amount</th>
					<td><input name="g_amt" id="g_amt" type="text" style="width:155px; text-align:right;" class="input2" readOnly="true" dataformat="float"></td>
					<th style="padding-right: 23px;">G.Amount<br>(VAT Only)</th>
					<td><input name="g_vat_curr_amt" id="g_vat_curr_amt" type="text" style="width:148px; text-align:right;" class="input2" readOnly="true" dataformat="float"></td>
				</tr>		
			</table> 
			<table>
				<colgroup>
					<col width="72"/>
					<col width="*"/>
				</colgroup>		
				<tr>
					<th style="text-align: left">Remark(s)</th>
					<td><input name="mnr_inv_rmk" id="mnr_inv_rmk" type="text" style="width:402px;" class="input" maxlength="4000"></td>
				</tr>							
			</table>
     	</div>
	</div>
     <!-- layout_vertical_2(E) -->
</div>
<!-- layout_wrap(E) -->
<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->
<div class="opus_design_grid">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Store" id="btn_Store">Verify</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Del"  	id="btn_Del">Row Del</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
	<div name="tabLayer" id="tabLayer" >
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>	
	</div>

	<div name="tabLayer" id="tabLayer" style="display:none">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</div>
</form>