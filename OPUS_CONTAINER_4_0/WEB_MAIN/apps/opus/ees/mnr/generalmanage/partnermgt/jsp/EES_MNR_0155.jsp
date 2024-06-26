<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0155.jsp
*@FileTitle  : Disposal Buyer Management 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.event.EesMnr0155Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0155Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String currOfcCd		= "";
	String strRhq_ofc_cd    = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		currOfcCd       = account.getOfc_cd();
		strRhq_ofc_cd   = account.getRhq_ofc_cd();
	   
		event = (EesMnr0155Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var rhqOfcCd  = '<%=strRhq_ofc_cd.trim() %>';
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
<input type="hidden" name="f_gubuns" id="f_gubuns"  value="">
<input type="hidden" name="mnr_prnr_cre_seq" id="mnr_prnr_cre_seq" value="">
<input type="hidden" name="ctrl_ofc_cd" id="ctrl_ofc_cd"  value="">
<input type="hidden" name="cre_dt" id="cre_dt"  value="">
<input type="hidden" name="mnr_grp_tp_cd" id="mnr_grp_tp_cd" value="DSP">
<input type="hidden" name="mnr_prnr_tp_cd" id="mnr_prnr_tp_cd" value=""> <!-- S - Service Provider B - Buyer -->
<input type="hidden" name="mnr_prnr_sts_cd" id="mnr_prnr_sts_cd"> <!--status save 시-->
<input type="hidden" name="upd_dt" id="upd_dt"> 
<input type="hidden" name="edi_id" id="edi_id"> 
<input type="hidden" name="mnr_prnr_locl_lang_nm" id="mnr_prnr_locl_lang_nm"> 
<input type="hidden" name="bzet_addr" id="bzet_addr"> 
<input type="hidden" name="mnr_payr_cnt_cd" id="mnr_payr_cnt_cd"> 
<input type="hidden" name="mnr_payr_seq" id="mnr_payr_seq"> 
<input type="hidden" name="mnr_prnr_capi_amt" id="mnr_prnr_capi_amt"> 
<input type="hidden" name="mnr_prnr_abbr_nm" id="mnr_prnr_abbr_nm"> 
<input type="hidden" name="intl_phn_no" id="intl_phn_no"> 
<input type="hidden" name="intl_fax_no" id="intl_fax_no"> 
<input type="hidden" name="trsm_mod_cd" id="trsm_mod_cd"> 
<input type="hidden" name="file_seq" id="file_seq"> 
<input type="hidden" name="pagerows" id="pagerows"> 
<input type="hidden" name="sp_ptal_pwd" id="sp_ptal_pwd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
	 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
	   --><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_remove" 	id="btn_remove">Delete</button><!-- 
	     -->
<!-- 	     <button type="button" class="btn_normal" name="btn_reject"  	id="btn_reject">Reject</button> -->
	     <!-- 
	      --><button type="button" class="btn_normal" name="btn_confirm" 	id="btn_confirm">Confirm</button><!-- 
	       --><button type="button" class="btn_normal" name="btn_expire" 	id="btn_expire">Expire</button>	
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
			<tr>
				<th width="60">Buyer Type</th>
				<td width="60"><script type="text/javascript">ComComboObject('combo_in_mnr_prnr_knd_cd',2, 100 , 1, 0,0,false,1);</script><!-- 
				 --><input type="hidden" name="in_mnr_prnr_knd_cd" id="in_mnr_prnr_knd_cd"></td>
				<th width="60">Status</th>
				<td width="60"><script type="text/javascript">ComComboObject('combo_in_mnr_prnr_sts_cd',2, 80 , 1, 0,0,false,1);</script>
					<input type="hidden" name="in_mnr_prnr_sts_cd" id="in_mnr_prnr_sts_cd"></td>
				<th width="60">Period</th>
				<td><!-- 
				 --><input type="text" name="fromcal" id="fromcal" style="width:80px;" class="input1" dataformat="ymd"  caption="From Date">~ <!-- 
				  --><input type="text" name="tocal" id="tocal" style="width:80px;" class="input1" dataformat="ymd"  caption="To Date" ><!-- 
				   --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
		        </td>
		   	</tr> 
		</table>	
	</div>
<!-- opus_design_inquiry(E) --> 
</div>

<div class="wrap_result">
<!-- layout_wrap(S) -->
	<div class="layout_wrap">
		<!-- layout_vertical_2(S) -->
		<div class="layout_flex_flex" style="padding-right:668px">
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
	<!-- layout_vertical_2(E) -->
	<!-- layout_vertical_2(S) -->
		<div class="layout_flex_fixed" style="width:660px;float:right!important">
			<div class="opus_design_inquiry">
				<table>
					<tbody>
						<tr><td colspan="2"><h3 class="title_design">Basic Information</h3></td></tr>
						<tr>
							<th>Company Name</th>
							<td><input type="text" name="mnr_prnr_lgl_eng_nm" id="mnr_prnr_lgl_eng_nm" style="width:140px" title="" class="input2" style="ime-mode:disabled" maxlength="100">
							</td>
							<th >Customer</th>
							<td colspan="3"><!-- 
							 --><input type="text" name="mnr_prnr_cnt_cd" id="mnr_prnr_cnt_cd" style="width:35px" maxlength="2" class="input1" dataformat="engup"><!-- 
							  --><input type="text" name="mnr_prnr_seq" id="mnr_prnr_seq" style="width:55px" value="" class="input1" maxlength="9" dataformat="num"><!-- 
							   --><button type="button" name="btn_customer" id="btn_customer" class="input_seach_btn"></button><!-- 
							    --><input type="text" name="mnr_prnr_cnt_nm" id="mnr_prnr_cnt_nm" style="width:151px" value="" class="input2" readonly title="">
							</td>
						</tr>
						<tr>
							<th width="40">Buyer Type</th>
							<td width="80"><script type="text/javascript">ComComboObject('combo_mnr_prnr_knd_cd',2, 140 , 1, 1,0,false,1);</script><!-- 
							 --><input type="hidden" name="mnr_prnr_knd_cd" id="mnr_prnr_knd_cd"></td>
							<th width="40">Buyer Detail</th>
							<td width="50"><script type="text/javascript">ComComboObject('combo_mnr_prnr_knd_dtl_cd',2, 100 , 1, 1,0,false,1);</script><!-- 
							 --><input type="hidden" name="mnr_prnr_knd_dtl_cd" id="mnr_prnr_knd_dtl_cd"></td>
							<th width="40">Status</th>
							<td><input type="text" name="mnr_prnr_sts_nm" id="mnr_prnr_sts_nm" value="" class="input2" readonly style="width:105px"></td>
						</tr>
						<tr>
							<th>Business  Category</th>
							<td><input name="bzct_nm" id="bzct_nm" type="text" style="width:140px" value="" class="input" style="ime-mode:disabled" maxlength="200" ></td>
							<th style="padding-left: 9px;">Business Type</th>
							<td><input name="bztp_nm" id="bztp_nm" type="text" style="width:100px" value="" class="input" style="ime-mode:disabled" maxlength="100"></td>
							<th>Employee</th>
							<td><input type="text"  name="empe_knt" id="empe_knt"  style="width:105px;text-align:right" value="" class="input" dataformat="int"  maxlength="5"></td>
						</tr>
						<tr>
							<th>Owner</th>
							<td><input type="text"  name="ownr_nm" id="ownr_nm" style="width:140px;text-align:left" value="" class="input" style="ime-mode:disabled" maxlength="100"></td>
							<th>Register No.</th>
							<td><input type="text"  name="biz_rgst_no" id="biz_rgst_no" style="width:100px;text-align:left" value="" class="input" style="ime-mode:disabled" maxlength="30"></td>
							<th>Zip/Post</th>
							<td><input type="text"  name="zip_cd" id="zip_cd" style="width:105px;text-align:left" value="" class="input" style="ime-mode:disabled" maxlength="10"></td>
						</tr>
						<tr>
							<th>P.I.C Tel.</th>
							<td><input type="text" name="phn_no" id="phn_no" style="width:140px;text-align:left" value="" class="input" style="ime-mode:disabled" maxLength="20"></td>
							<th>P.I.C Fax</th>
							<td><input type="text" name="fax_no" id="fax_no" style="width:100px;text-align:left" value="" class="input" style="ime-mode:disabled" maxLength="20"></td>
							<th>P.I.C Email</th>
							<td><input type="text" name="mnr_prnr_eml" id="mnr_prnr_eml" style="width:105px;text-align:left" value="" class="input" style="ime-mode:disabled" maxLength="200"></td>
						</tr>
						<tr>
							<th>Bill To.</th>
							<td colspan="5"><input type="text" name="mnr_bil_to_nm" id="mnr_bil_to_nm" style="width:539px;" value="" class="input" style="ime-mode:disabled" maxLength="200"></td>
						</tr>
						<tr>
							<th>Address</th>
							<td colspan="5"><input type="text" name="mnr_prnr_addr" id="mnr_prnr_addr" style="width:539px;" value="" class="input" style="ime-mode:disabled" maxLength="200"></td>
						</tr>
						<tr>
							<th>Effective</th>  
							<td colspan="2"><!-- 
							 --><input type="text"  style="width:100px;text-align:center" class="input" name="eff_dt" id="eff_dt" dataformat="ymd" maxLength="10">~<!-- 
							  --> <input type="text"  style="width:100px;text-align:center" class="input" name="exp_dt" id="exp_dt" dataformat="ymd" maxLength="10"><!-- 
							   --><button type="button" class="calendar ir" name="btn_calendar2" id="btn_calendar2"></button>										
							</td>
							<td><input type="checkbox" name="mnr_shop_flg" id="mnr_shop_flg"><label for="mnr_shop_flg">M&R Shop</label></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tbody>
						<tr>
							<td colspan="2"><h3 class="title_design">Account Information of Control Office( Office Account)</h3></td>
						</tr>
						<tr>
							<th width="70">Bank Name</th>
							<td width="170"><input type="text" name="bank_nm" id="bank_nm" style="width:220px" value="" class="input" style="ime-mode:disabled" maxLength="50"></td>
							<th width="40">Deposit Info</th>
							<td>
								<script type="text/javascript">ComComboObject('combo_dpt_desc',2, 200 , 1, 0,0,false,1);</script>
								<input type="hidden" name="dpt_desc" id="dpt_desc">
							</td>
						</tr>
						<tr>
							<th>Account No.</th>
							<td><input type="text" name="bank_acct_no" id="bank_acct_no" style="width:220px" value="" class="input" style="ime-mode:disabled" maxLength="30"></td>
							<th rowspan="2">Remark(s)</th>
							<td rowspan="2"><textarea name="mnr_prnr_rmk" id="mnr_prnr_rmk" style="width:200px;height:57px;"  style="ime-mode:disabled" maxLength="4000"></textarea></td>
						</tr>
						<tr> 
							<th >Swift Code</th>
							<td><input type="text" name="mnr_swift_no" id="mnr_swift_no" style="width:220px;ime-mode:disabled" value="" class="input" maxLength="50"></td>
						</tr>
						<tr>
							<th>Pay Term</th> 
							<td><input type="text" style="width:40px;text-align:right" name="pay_term_dys" id="pay_term_dys" value="" class="input" maxlength="3" dataformat="num"></td>
							<th>P.Method</th>
							<td  colspan="2"> 
								<script type="text/javascript">ComComboObject('combo_pay_mzd_cd',2, 110 , 1, 0,0,false,1);</script>
								<input type="hidden" name="pay_mzd_cd" id="pay_mzd_cd">
							</td> 
						</tr>
					</tbody>
				</table>
			</div>
			<div class="opus_design_grid" style="width:660px;">
				<h3 class="title_design">Control Office & Buyer Contact Info</h3>
		   		<!-- opus_design_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button>
					<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
				</div>
				<!-- opus_design_btn(E) -->
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
	</div>
</div>
<!-- layout_vertical_2(E) -->
<!-- layout_wrap(E) -->

</form>