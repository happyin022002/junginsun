<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_3001.jsp
*@FileTitle  : Outstanding Adjustment 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%> 
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event.StmSar3001Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	SignOnUserAccount account = null; //Session Information
    StmSar3001Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.AccountReceivableCollectSC");

	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

 		event = (StmSar3001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
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

<link href="css/opus_contents.css" rel="stylesheet" type="text/css">
<link href="css/opus_menu.css" rel="stylesheet" type="text/css">

<form id="form" name="form">
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
		--><button class="btn_normal" name="btn_Reverse" id="btn_Reverse" type="button">Reverse</button><!--
		--><button class="btn_normal" name="btn_view_accounting" id="btn_view_accounting" type="button">View Accounting</button>
		</div>
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
				<col width="73"/>
				<col width="200"/>
				<col width="70"/>
				<col width="100"/>
				<col width="150"/>
				<col width="70"/>
				<col width="*"/>
			</colgroup>
              <tr>
                <th>Adjust Date</th>
                <td><input type="text" style="width:100px; text-align:center" name="adj_dt" dataformat="ymd" maxlength="10" class="input1" id="adj_dt" /><button type="button" id="btns_adj_cal" name="btns_adj_cal" class="calendar ir"></button></td>
                <td><input type="radio" name="adj_tp" value="S" id="adj_tp1" class="trans" onclick="change_event_radio();"/><label for="adj_tp1"><strong>Same Type</strong></label></td>
                <td><script type="text/javascript">ComComboObject('adj_tp_cd', 2, 80, 1, 1);</script></td>
                <td><input type="radio" name="adj_tp" value="I" id="adj_tp2" class="trans" checked onclick="change_event_radio();"/><label for="adj_tp2"><strong>Individual Type By B/L</strong></label></td>
                <th>Office</th>
                <td><script type="text/javascript">ComComboObject('ots_ofc_cd', 1, 80, 1, 1);</script></td>
              </tr>
              <tr>
              	<th>Adjust No</th>
                <td><input type="text" style="width:150px;" name="adj_no" class="input" dataformat="engup" maxlength="25" id="adj_no" /> </td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
         </table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	
	<!-- layout_wrap (S) -->
	<div class="layout_wrap">
	    <div class="layout_flex_fixed" style="width:450px">
	        <div class="opus_design_grid">
		        <table>
					<colgroup>
						<col width="70"/>
						<col width="250"/>
						<col width="*"/>
					</colgroup>
					<tbody>
			            <tr>
			               <th id="bl_label" name="bl_label" class="pad_btm_4">B/L No</th>
			               <td id="bl_inp" class="pad_btm_4"><input type="text" style="width: 100px;" class="input" name="bl_no" dataformat="engup" maxlength="13" id="bl_no" />
			               <button type="button" class="btn_etc" id="btn_otsadd" name="btn_otsadd">OTS Add</button></td>
			               <th id="inv_label" name="inv_label" style="display: none;" class="pad_btm_4">Inv No</th>
			               <td id="inv_inp" style="display: none;" class="pad_btm_4"><input type="text" style="width: 114px;" class="input" name="inv_no" dataformat="engup" maxlength="15" id="inv_no" />
			               <button type="button" class="btn_etc" id="btn_otsadd" name="btn_otsadd">OTS Add</button></td>
			               <td><div class="opus_design_btn"><button type="button" class="btn_normal" id="btn_rowdelete_hdr" name="btn_rowdelete_hdr">Row Delete</button></div></td>
			            </tr>
			          </tbody>
		      	</table>
	            <script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    
	    <div class="pad_left_8 layout_flex_fixed"  style=" width: 90px;padding-top:50px;">
	    	<script type="text/javascript">ComComboObject('dtl_adj_tp_cd', 2, 80, 1, 1);</script>
	    </div>
	    
	    <div class="layout_flex_flex" style="padding-left:548px; float:right;">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	            <div class="opus_design_btn">
					<button type="button" class="btn_normal" id="btn_rowdelete_dtl" name="btn_rowdelete_dtl">Row Delete</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	        <!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry"> 
		        <table>
		              <tr>
			                <td><h3 class="title_design">Remark</h3></td>
			                <td align="right"><b>Reverse</b>&nbsp;<input type="text" style="width:100px;" name="rvs_flg" class="input2" readonly id="rvs_flg" /></td>
		              </tr>
		            
	            </table>
	            <table>
		              <tr>
		              	  <td><textarea name="adj_rmk" id="adj_rmk" style="width: 100%;resize:none;" class="textarea2" maxlength="90"></textarea></td>
		              </tr>
	            </table>
	            
       <table class="line_bluedot"><tr><td colspan="6"></td></tr></table> 
	            <table>
	            	<colgroup>
	            		<col width="60"/>
	            		<col width="110"/>
	            		<col width="60"/>
	            		<col width="110"/>
	            		<col width="50"/>
	            		<col width="*"/>
	            	</colgroup>
		              <tr>
			                <th>AP office</th>
			                <td><input type="text" style="width:60px;" name="ap_ofc_cd" class="input2" dataformat="enguponly" maxlength="6" id="ap_ofc_cd" /><button type="button" id="btns_ap_ofc_cd" name="btns_ap_ofc_cd" class="input_seach_btn"></button></td>
			                <th>ASA No</th>
			                <td><script type="text/javascript">ComComboObject('asa_no', 2, 100, 1, 0);</script></td>
			                <th>Vendor</th>
			                <td><input type="text" style="width:60px;" name="vndr_no" class="input2" dataformat="num" maxlength="6" id="vndr_no" /><button type="button" id="btns_vndr_no" name="btns_vndr_no" class="input_seach_btn"></button></td>
		              </tr>
		               <tr>
			                <th>CUR</th>
			                <td><script type="text/javascript">ComComboObject('ap_curr_cd', 1, 83, 0, 1);</script></td>
			                <th>Amount </th>
			                <td><input type="text" style="width:100px;text-align:right" name="ap_crs_curr_amt" class="input2" dataformat="float" maxlength="12" pointcount="3" maxnum="99999999.999" readonly id="ap_crs_curr_amt" /> </td>
			                <th>Ex. diff</th>
			                <td><input type="text" style="width:100%;text-align:right" name="gain_and_lss_amt" class="input2" dataformat="float" maxlength="12" pointcount="3" maxnum="99999999.999" readonly id="gain_and_lss_amt" /> </td>
		              </tr>
	            </table>
	            <table>
		              <tr>
		               	 <td><h3 class="title_design mar_top_12">AP Remark</h3></td>
		              </tr>
		              <tr>
		               	 <td><textarea name="ap_rmk" id="ap_rmk" cols="5" rows="" style="width:100%; resize:none;" class="input1" maxlength="90"></textarea></td>
		              </tr>
	            </table>
	         </div>
	         <!-- opus_design_inquiry(E) -->
	    </div>
	</div>
	<!-- layout_wrap (E) -->
</div>

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="search_tp" value="0" id="search_tp" />
<input type="hidden" name="adjt_ofc_cd" id="adjt_ofc_cd" />
<input type="hidden" name="rhq_cd" id="rhq_cd" />
<input type="hidden" name="ots_smry_cd" id="ots_smry_cd" />
<input type="hidden" name="ots_cd" id="ots_cd" />
<input type="hidden" name="rep_ots_ofc_cd" id="rep_ots_ofc_cd" />
<input type="hidden" name="adjt_tp_cd" id="adjt_tp_cd" />
<input type="hidden" name="adjt_unapy_flg" id="adjt_unapy_flg" />
<input type="hidden" name="ofc_entr_lvl_cd" id="ofc_entr_lvl_cd" />
<input type="hidden" name="adjt_curr_cd" id="adjt_curr_cd" />
<input type="hidden" name="dp_prcs_knt" id="dp_prcs_knt" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="acct_ctnt" value="ADJ" id="acct_ctnt" />
<input type="hidden" name="acct_ctnt2" value="OADJ" id="acct_ctnt2" />
<input type="hidden" name="acct_ctnt4" value="DFLT" id="acct_ctnt4" />
<input type="hidden" name="adj_tj_tp_cd" value="ADJ" id="adj_tj_tp_cd" />
<input type="hidden" name="ots_ofc_cd_xml" id="ots_ofc_cd_xml" value=""/>
<input type="hidden" name="curr_cd_chg" id="curr_cd_chg" />
<input type="hidden" name="adj_tj_tp_key_cd" value="ADJKEY" id="adj_tj_tp_key_cd" />
<input type="hidden" name="tmp_adj_dt" value="" id="tmp_adj_dt" />
<!-- Input Box for MI/ML Limit Amount Check -->
<input type="hidden" name="misc_ofc_cd" id="misc_ofc_cd" />
<input type="hidden" name="misc_tp_cd" id="misc_tp_cd" />
<input type="hidden" name="misc_amt" id="misc_amt" />
<input type="hidden" name="misc_xch_rt_dt" id="misc_xch_rt_dt" />
<input type="hidden" name="misc_curr_cd" id="misc_curr_cd" />

</form>