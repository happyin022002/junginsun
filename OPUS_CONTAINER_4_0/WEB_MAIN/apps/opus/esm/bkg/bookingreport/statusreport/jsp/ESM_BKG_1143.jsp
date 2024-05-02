<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1143.jsp
*@FileTitle  : Manifest Data Input Cross-Check (General)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1143Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1143Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.StatusReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1143Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">


<input type="hidden" name="vsl_cd" id="vsl_cd">
<input type="hidden" name="skd_voy_no" id="skd_voy_no">
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd">
<input type="hidden" name="tab_item" id="tab_item">
<input type="hidden" name="pol_yd_cd" id="pol_yd_cd">
<input type="hidden" name="pod_yd_cd" id="pod_yd_cd">
<input type="hidden" name="master_tot" id="master_tot">
<input type="hidden" name="houser_tot" id="houser_tot">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_SaveExcel" 	id="btn_SaveExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<tr>
						<th style="width:50px;">VVD</th>
						<td style="width:80px;"><input type="text" name="vvd" id="vvd" style="width:80px;" value="" dataformat="engup" maxlength="9" class="input1"></td>
						<th style="width:50px;">POL</th>
						<td style="width:80px;"><input type="text" name="pol_cd" id="pol_cd" style="width:50px;" value="" dataformat="engup" maxlength="5"  class="input1"><!--
						 --><input type="text" name="pol_nod_cd" id="pol_nod_cd" style="width:20px;" value="" dataformat="engup" maxlength="2" class="input"></td>
						<th style="width:30px;">POD</th>
						<td style="width:80px;"><input type="text" name="pod_cd" id="pod_cd" style="width:50px;" value="" dataformat="engup" maxlength="5"><!-- 
						 --><input type="text" name="pod_nod_cd" id="pod_nod_cd" style="width:20px;" value="" dataformat="engup" maxlength="2" class="input"></td>
						<th style="width:30px;">Shipper</th>
						<td style="width:110px;"><input type="text" name="cust_cnt_cd" id="cust_cnt_cd" style="width:30px;" value="" dataformat="enguponly" maxlength="2"><!-- 
						 --><input type="text" name="cust_seq" id="cust_seq" style="width:80px;" value="" dataformat="num" maxlength="6"></td>
						<th style="width:30px;">US Filer</th>
						<td style="width:80px;"><script type="text/javascript">ComComboObject('usa_cstms_file_cd', 2, 70, true, 0);</script></td>
						<th style="width:10px;">CA Filer</th>
						<td style="width:80px;"><script type="text/javascript">ComComboObject('cnd_cstms_file_cd', 2, 70, true, 0);</script></td>
						<th class="sm pad_left_4" style="width:80px;">
							<input type="radio" name="chk_err" id="chk_err" class="trans" value="1" checked>&nbsp;All&nbsp;&nbsp;
							<input type="radio" name="chk_err" id="chk_err" class="trans" value="0" >&nbsp;Error
						</th>
						<td></td>
					</tr>
					<tr class="h23">
						<th style="text-align: left;">Booking Office</th>
						<td><input type="text" name="bkg_ofc_cd" id="bkg_ofc_cd" style="width:60px;" value="" dataformat="enguponly" maxlength="6"></td>
						<th style="text-align: left;">Booking Staff</th>
						<td><input type="text" name="cre_usr_id" id="cre_usr_id" style="width:60px;" value="" maxlength="20"></td>
						<th style="text-align: left;">B/L Office</th>
						<td><input type="text" name="obl_iss_ofc_cd" id="obl_iss_ofc_cd" style="width:60px;" value="" dataformat="enguponly" maxlength="6"></td>
						<th style="text-align: left;">B/L Staff</th>
						<td><input type="text" name="obl_iss_usr_id" id="obl_iss_usr_id" style="width:70px;" value="" maxlength="20"></td>
						<th style="text-align: left;">Sales Rep.</th>
						<td><input name="ob_srep_cd" id="ob_srep_cd" type="text" style="width:70px;" value="" dataformat="engup" maxlength="5"></td>
						<td colspan="3"><td>
						<td></td>
					</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab" >   
<!-- 	<span id="tab_tot">Total : </span> -->
	<script type="text/javascript">ComTabObject('tab1');</script>
</div>
<!-- opus_tab_btn(E) -->
<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" style="display:none" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>
<div class="opus_design_grid clear" style="display:none" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>

</form>