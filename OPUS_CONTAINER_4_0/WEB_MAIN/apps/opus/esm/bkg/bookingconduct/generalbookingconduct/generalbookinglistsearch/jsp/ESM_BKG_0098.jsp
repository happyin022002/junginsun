<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0098.jsp
*@FileTitle  : Booking Receipt Notice (Fax/E-Mail)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0098Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %> 
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>

<%
	EsmBkg0098Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String strCnt_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingListSearch");
	String rtnOfcCd = null;
	List<BkgComboVO> bkg_sts_cd = null;
	List<BkgComboVO> bkg_kind = null;
	List<BkgComboVO> bkg_cust_tp_cd = null;
	List<BkgComboVO> fax_sts_cd = null;
	List<BkgComboVO> eml_sts_cd = null;
	StringBuffer fileDir = new StringBuffer();
	
	String home = System.getProperty("user.home");
	if (home != null){
	 	fileDir.append(home);
	}
	String separator = System.getProperty("file.separator");
	if (separator != null){
	 	fileDir.append(separator);
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

		event = (EsmBkg0098Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		rtnOfcCd = (String) eventResponse.getCustomData("rtn_ofc_cd");
		bkg_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_sts_cd");
		bkg_kind = (List<BkgComboVO>) eventResponse.getCustomData("bkg_kind");
		bkg_cust_tp_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_cust_tp_cd");
		fax_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("fax_sts_cd");
		eml_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("eml_sts_cd");

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

<form name="form" id="form">

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="strCnt_cd" value="<%=strCnt_cd%>">
<input type="hidden" name="mrd" value="<%=("China".equals(JSPUtil.getNull(rtnOfcCd))?"ESM_BKG_5005C":"ESM_BKG_5005G")%>">
<input type="hidden" name="rtn_ofc_cd" value="<%=rtnOfcCd%>">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=fileDir.toString()%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle" value="Booking Receipt Notice">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle" value="Booking Receipt Notice">
<input type="hidden" name="com_zoomIn">
<input type="hidden" name="com_isBatch" value="N">
<input type="hidden" name="edt_ntc_knd_cd">
<input type="hidden" name="edt_bkg_no_list">
<input type="hidden" name="edt_to_eml">
<input type="hidden" name="edt_cc_eml">
<input type="hidden" name="edt_from_eml">
<input type="hidden" name="edt_subject">
<input type="hidden" name="edt_contents">
<input type="hidden" name="defaultSort" value="Y">
<input type="hidden" name="custBody" >
<input type="hidden" name="btnTp" >


<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
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
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
					<col width="60">
					<col width="210">
					<col width="82">
					<col width="90">
					<col width="80">
					<col width="170">
					<col width="1">
					<col width="120">
					<col width="103">
					<col width="1">
					<col width="*">
				</colgroup>
				<tbody>
				<tr>
						<th>BKG DT</th>
						<td><input type="text" style="width:75px" maxlength="10" class="input1" name="bkg_from_dt" id="bkg_from_dt" caption="BKG DT" dataformat="ymd">~ <input type="text" style="width:75px" maxlength="10" class="input1" name="bkg_to_dt" id="bkg_to_dt" caption="BKG DT" dataformat="ymd"><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
						<th>BKG Office</th>
						<td><input type="text" name="bkg_ofc_cd" id="bkg_ofc_cd" maxlength="6" dataformat="engup" style="width:70px;" value="<%=strOfc_cd%>" class="input"></td>
						<th>BKG Staff</th>
						<td><input type="text" name="bkg_staff" id="bkg_staff" maxlength="20" style="ime-mode:disabled" style="width:70px;" value="" class="input"></td>
						<th>BKG Status</th>
						<td><%=HTMLUtil.getComboString("bkg_status", "width:70px;", "", "","","All", bkg_sts_cd)%></td>
						<th>BKG Kind</th>
						<td><%=HTMLUtil.getComboString("bkg_kind", "width:100px;", "", "","","All", bkg_kind)%></td>
						<th><label for="edi_hld_flg">Show Auto EDI Hold also</label><input type="checkbox" name="edi_hld_flg" id="edi_hld_flg" value="Y" /></th>
				</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="60">
					<col width="110">
					<col width="62">
					<col width="90">
					<col width="50">
					<col width="100">
					<col width="50">
					<col width="50">
					<col width="40">
					<col width="72">
					<col width="50">
					<col width="60">
					<col width="163">
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd" id="vvd" maxlength="9" dataformat="engup" style="width:100px;" value="" class="input1"></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol_cd" id="pol_cd" maxlength="5" dataformat="engup" style="width:50px;" value="" class="input"><!-- 
						 --><input type="text" name="pol_yd_cd" id="pol_yd_cd" maxlength="2" dataformat="engup" style="width:25px;" value="" class="input"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod_cd" id="pod_cd" maxlength="5" dataformat="engup" style="width:50px;" value="" class="input"><!-- 
						 --><input type="text" name="pod_yd_cd" id="pod_yd_cd" maxlength="2" dataformat="engup" style="width:25px;" value="" class="input"></td>
					<th title="Place of Receipt">POR</th>
					<td><input type="text" name="por_cd" id="por_cd" maxlength="5" dataformat="engup" style="width:50px;" value="" class="input"></td>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text" name="del_cd" id="del_cd" maxlength="5" dataformat="engup" style="width:50px;" value="" class="input"></td>
					<th>Sales Office</th>
					<td><input type="text" name="sales_ofc" id="sales_ofc" maxlength="6" dataformat="engup" style="width:50px;" value="" class="input"></td>
					<th>Sales Rep.</th>
					<td><input type="text" name="sales_rep" id="sales_rep" maxlength="5" dataformat="engup" style="width:70px;" value="" class="input"></td>
					<td></td>
				</tr>
			</tbody>
			</table>
			<table>
				<colgroup>
					<col width="60">
					<col width="110">
					<col width="60">
					<col width="250">
					<col width="200">
					<col width="142">
					<col width="50">
					<col width="*">
				</colgroup>
				<tbody>
				<tr>
					<th>BKG No.</th>
					<td>
						<input type="text" name="bkg_no" id="bkg_no" maxlength="13" dataformat="engup" style="width:100px;" value="" class="input1">
						<button type="button" class="multiple_inq ir" style="background: url(./style/images/theme_default/sprite_common.png) -98px -157px no-repeat; background-color:#fff;" name="btn_multBkgNo" id="btn_multBkgNo"></button>
					</td>
					<th>Customer</th>
					<td><%=HTMLUtil.getComboString("cust_tp_cd", "width: 100px;", "", "","","All", bkg_cust_tp_cd)%><input type="text" name="cust_cnt_cd" id="cust_cnt_cd" maxlength="2" dataformat="engup" style="width:30px;" value=""><input type="text" name="cust_seq" id="cust_seq" maxlength="6" dataformat="engup" style="width:50px;" value=""><input type="text" name="cust_nm" id="cust_nm" maxlength="50" dataformat="eng" style="width:130px;" value=""></td>
					<th colspan="4" style="text-align:left;">Fax Status <%=HTMLUtil.getComboString("fax_proc_sts_cd", "width:100px;", "", "","","All", fax_sts_cd)%>
					E-mail Status <%=HTMLUtil.getComboString("eml_proc_sts_cd", "width:100px;", "", "","","All", eml_sts_cd)%>
					Full Return Yard <input type="text" name="full_rtn_yd_cd" id="full_rtn_yd_cd" maxlength="7" dataformat="engup" style="width:100px;" value="" class="">
					</th>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- layout_wrap (S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Print" 	id="btn_Print">Print</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Preview" 	id="btn_Preview">Preview</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_EditFaxEmail" 	id="btn_EditFaxEmail">Edit Fax/E-mail</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_AssignEmail" 	id="btn_AssignEmail">Assign BKG Agent E-mail</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_EditRemark" 	id="btn_EditRemark">Edit Remark(s)</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_EditCCT" 	id="btn_EditCCT">Edit CCT</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Fax" 	id="btn_Fax">Fax</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Email" 	id="btn_Email">E-mail</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_GroupEmail" 	id="btn_GroupEmail">Group E-mail</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_EmailEdit" 	id="btn_EmailEdit">E-mail (Edit)</button>
			 <button type="button" class="btn_normal" name="btn_EmailCust" 	id="btn_EmailCust">Customer Notification</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<br/>
		<div class="opus_design_data wFit">
			<table class="grid2"> 
				<colgroup>
					<col width="55">
					<col width="90">
					<col width="120">
					<col width="90">
					<col width="120">
					<col width="90">
					<col width="120">
					<col width="90">
					<col width="120">
					<col width="90">
					<col width="*">
				</colgroup>
				<tbody>
				<tr>
					<th>Fax</th>
					<th>BKG Total</th>
					<td><input type="text" name="fax_bkg_total" id="fax_bkg_total" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
					<th>Fax Total</th>
					<td><input type="text" name="fax_total" id="fax_total" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
					<th>Success</th>
					<td><input type="text" name="fax_success" id="fax_success" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
					<th>Sending</th>
					<td><input type="text" name="fax_send" id="fax_send" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
					<th>Un-sent</th>
					<td><input type="text" name="fax_unsent" id="fax_unsent" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
				</tr>
				<tr>
					<th>E-mail</th>
					<th>BKG Total</th>
					<td><input type="text" name="eml_bkg_total" id="eml_bkg_total" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
					<th>E-mail Total</th>
					<td><input type="text" name="eml_total" id="eml_total" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
					<th>Success</th>
					<td><input type="text" name="eml_success" id="eml_success" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
					<th>Sending</th>
					<td><input type="text" name="eml_send" id="eml_send" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
					<th>Un-sent</th>
					<td><input type="text" name="eml_unsent" id="eml_unsent" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>

<!-- layout_wrap (E) -->

	<div>
		<table width="300px" class="button" border="0" cellpadding="0" cellspacing="0"> 
				<tr><td>If you want to receive email copy, please go to “Setup -> Client Default” and select “Receiving mail copy option”</td></tr>
		</table>
	</div>
</div>
<div id='layList' style='position:absolute; z-index:999; display:none; background-color: white;'> <!-- background-color: #d4f6ff; -->
	<table>
		<tr>
			<td>
				<label style="margin-right: 0px;">Rows : </label>
				<label style="margin-right: 0px;" id="rows">000</label>
				<label style="margin-right: 0px;">/</label>
				<label>100</label>
			</td>
		</tr>
	</table>
	<textarea id="mult_bkg_no" name="mult_bkg_no" placeholder="Booking No." class="multi_value mar_none" style="top:0; text-transform: uppercase; width:145px; height: 140px;"></textarea>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>

</form>
<form name="form3" id="form3" method="post">
    <input type="hidden" name="pop_mode">
    <input type="hidden" name="display">
    <input type="hidden" name="func">
    <input type="hidden" name="row">
    <input type="hidden" name="col">
    <input type="hidden" name="sheetIdx">
	<input type="hidden" name="bkg_no">
	<input type="hidden" name="bl_no">
	<input type="hidden" name="ok_hidden">
	<input type="hidden" name="send_hidden">     
	<input type="hidden" name="form_type">
	<input type="hidden" name="form_dataOnly">
	<input type="hidden" name="form_manifest">
	<input type="hidden" name="form_hiddeData">
	<input type="hidden" name="form_mainOnly">
	<input type="hidden" name="form_level">
	<input type="hidden" name="form_remark">
	<input type="hidden" name="form_Cntr">     
	<input type="hidden" name="form_CorrNo">
	<input type="hidden" name="form_his_cntr">
	<input type="hidden" name="form_his_bkg">
	<input type="hidden" name="form_his_mkd">
	<input type="hidden" name="form_his_xpt">
	<input type="hidden" name="form_his_bl">
	<input type="hidden" name="rp">       
    <input type="hidden" name="ntc_knd_cd">
</form>
<form name="form4" id="form4" method="post">
    <input type="hidden" name="row">
    <input type="hidden" name="col">
</form>
<form name="form5" id="form5" method="post">
  <input type="hidden" name="f_cmd">
  <input type="hidden" name="bkg_no">
</form>