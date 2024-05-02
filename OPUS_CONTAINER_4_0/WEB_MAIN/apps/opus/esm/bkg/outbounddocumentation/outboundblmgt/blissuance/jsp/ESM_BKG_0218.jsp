<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0218.jsp
*@FileTitle  :  Draft B/L &amp; Waybill (Fax / E-Mail)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.HTMLUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0218Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%
    EsmBkg0218Event  event = null;              //PDTO(Data Transfer Object including Parameters)
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
	String blPrnChgTpCd = "";
    Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentation");
    List<BkgComboVO> bkg_sts_cd = null;
    List<BkgComboVO> bkg_cust_tp_cd = null;
    List<BkgComboVO> fax_sts_cd = null;
    List<BkgComboVO> eml_sts_cd = null;
    
	StringBuffer fileDir = new StringBuffer();
	String home = System.getProperty("user.home");
	if (home !=null) fileDir.append(home);
	String separator = System.getProperty("file.separator");
	if (separator !=null) fileDir.append(separator);    

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

        event = (EsmBkg0218Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

     	// getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        bkg_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_sts_cd");
        bkg_cust_tp_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_cust_tp_cd");
        fax_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("fax_sts_cd");
        eml_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("eml_sts_cd");
        blPrnChgTpCd = (String) eventResponse.getCustomData("bl_prn_chg_tp_cd");

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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="strUsr_id" id="strUsr_id" value="<%=strUsr_id%>">
<input type="hidden" id="strOfc_cd" name="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="strCnt_cd" id="strCnt_cd" value="<%=strCnt_cd%>">

<input type="hidden" name="bl_tp_cd" id="bl_tp_cd">
<input type="hidden" name="vsl_cd" id="vsl_cd">
<input type="hidden" name="skd_voy_no" id="skd_voy_no">
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd">
<input type="hidden" name="pol_cd" id="pol_cd">
<input type="hidden" name="pod_cd" id="pod_cd">
<input type="hidden" name="bkg_ofc_cd" id="bkg_ofc_cd">
<input type="hidden" name="doc_usr_id" id="doc_usr_id">
<input type="hidden" name="bkg_sts_cd" id="bkg_sts_cd">
<input type="hidden" name="bkg_cust_tp_cd" id="bkg_cust_tp_cd">
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd">
<input type="hidden" name="cust_seq" id="cust_seq">
<input type="hidden" name="cust_nm" id="cust_nm">
<input type="hidden" name="obl_iss_ofc_cd" id="obl_iss_ofc_cd">
<input type="hidden" name="obl_iss_usr_id" id="obl_iss_usr_id">
<input type="hidden" name="ob_sls_ofc_cd" id="ob_sls_ofc_cd">
<input type="hidden" name="ob_srep_cd" id="ob_srep_cd">
<input type="hidden" name="bkg_no" id="bkg_no">
<input type="hidden" name="bl_no" id="bl_no">
<input type="hidden" name="bl_obrd_dt_from" id="bl_obrd_dt_from">
<input type="hidden" name="bl_obrd_dt_to" id="bl_obrd_dt_to">
<input type="hidden" name="obl_iss_dt_from" id="obl_iss_dt_from">
<input type="hidden" name="obl_iss_dt_to" id="obl_iss_dt_to">
<input type="hidden" name="fax_proc_sts_cd" id="fax_proc_sts_cd">
<input type="hidden" name="eml_proc_sts_cd" id="eml_proc_sts_cd">
<!--appending by tab2-->
<input type="hidden" name="sc_no" id="sc_no">
<input type="hidden" name="eta_dt_from" id="eta_dt_from">
<input type="hidden" name="eta_dt_to" id="eta_dt_to">
<!--appending by remark popup-->
<input type="hidden" name="inter_rmk" id="inter_rmk">

<input type="hidden" name="edt_ntc_knd_cd" id="edt_ntc_knd_cd">
<input type="hidden" name="edt_bkg_no_list" id="edt_bkg_no_list">
<input type="hidden" name="edt_to_eml" id="edt_to_eml">
<input type="hidden" name="edt_cc_eml" id="edt_cc_eml">
<input type="hidden" name="edt_from_eml" id="edt_from_eml">
<input type="hidden" name="edt_subject" id="edt_subject">
<input type="hidden" name="edt_contents" id="edt_contents">
<input type="hidden" name="bl_prn_chg_tp_cd" value="<%=blPrnChgTpCd%>">

<%-- <%@include file="/apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %> --%>

<!-- page_title_area(S) -->
<div class="page_title_area clear">
<!-- page_title(S) -->
<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_down_excel" id="btn_down_excel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
	<span id="navigation"></span>
	</div>
</div>

<!-- page_title_area(E) -->
<div class="wrap_search_tab">
</div>
<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!--Inbound (S-1)  -->
<div id="tabLayer" style="display:inline">

	<!-- wrap_result(S) -->	      
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">	
	 <table>
 			<colgroup>
 				<col width="40"> 				
 				<col width="207">
 				<col width="90">
 				<col width="80">
 				<col width="65">
 				<col width="60">
 				<col width="65">
 				<col width="87">
 				<col width="60">
 				<col width="93">
 				<col width="60">
 				<col width="95">
 				<col width="44">
 				<col width="*">
 			</colgroup>
	        <tr>
               <th class="sm">Type</th>
               <td class="sm"><!--
               --><input type="radio" id="t1_rdo_bl_tp_cd_1" name="t1_rdo_bl_tp_cd" value="D" class="trans" onclick="out_change_radio();" checked><label for="t1_rdo_bl_tp_cd_1">Draft</label><!--
               --><input type="radio" id="t1_rdo_bl_tp_cd_2" name="t1_rdo_bl_tp_cd" value="W" class="trans" onclick="out_change_radio();"><label for="t1_rdo_bl_tp_cd_2">Waybill</label><!--
               --><input type="radio" id="t1_rdo_bl_tp_cd_3" name="t1_rdo_bl_tp_cd" value="C" class="trans" onclick="out_change_radio();"><label for="t1_rdo_bl_tp_cd_3">Copy Waybill</label>                	     
               </td>
	          <th title="Vessel Voyage Direction">VVD</th>
	          <td><input type="text" name="t1_txt_vvd" style="width:86px" value="" class="input1" caption="VVD" minlength="9" maxlength="9" dataformat="engup"></td>
	          <th title="Port of Loading">POL</th>
	          <td><input type="text" name="t1_txt_pol" style="width:60px" value="" class="input1" caption="POL" minlength="2" maxlength="5" dataformat="engup"></td>
	          <th title="Port of Discharging">POD</th>
	          <td><input type="text" name="t1_txt_pod" style="width:60px" value="" class="input" caption="POD" minlength="2" maxlength="5" dataformat="engup"></td>
	          <th>BKG OFC</th>
	          <td><input type="text" name="t1_txt_bkg_ofc" style="width:60px" value="" class="input" caption="Booking Office" maxlength="5" dataformat="engup"></td>
	          <th>BKG Staff</th>
	          <td><input type="text" name="t1_txt_doc_usr_id" style="width:60px" value="" class="input" caption="Booking Staff" maxlength="20"></td>
	          <th>Status</th>
	          <td><%=HTMLUtil.getComboString("t1_slt_bkg_sts_cd", "width:60px;", "", "","","All", bkg_sts_cd)%></td>
	        </tr>
	        <tr>
	          <th>Customer</th>
	          <td><%=HTMLUtil.getComboString("t1_slt_bkg_cust_tp_cd", "width:40%;", "", "","","All", bkg_cust_tp_cd)%><!--
	          --><input type="text" name="t1_txt_cust_seq1" class="input" caption="Customer Nation" maxlength="2" dataformat="enguponly" style="width:30px;" value=""><!--
	          --><input type="text" name="t1_txt_cust_seq2" class="input" caption="Customer Seq" maxlength="6" dataformat="engup" style="width:50px;margin-left:1;" value=""><!--
	          --><input type="text" name="t1_txt_cust_nm" class="input" caption="Customer Name" maxlength="30" dataformat="engup" style="width:60px;" value=""></td>
	          <th>B/L OFC</th>
	          <td><input type="text" name="t1_txt_obl_iss_ofc_cd" style="width:60px" value="" class="input" caption="B/L Office" maxlength="6" dataformat="enguponly"></td>
	          <th>B/L Staff</th>
	          <td><input type="text" name="t1_txt_obl_iss_usr_id" style="width:60px" value="" class="input" caption="B/L Staff" maxlength="10"></td>
	          <th>Sales OFC</th>
	          <td><input type="text" name="t1_txt_ob_sls_ofc_cd" style="width:60px" value="" class="input" caption="Sales Office" maxlength="6" dataformat="enguponly"></td>
	          <th>Sales Rep.</th>
	          <td><input type="text" name="t1_txt_ob_srep_cd" style="width:60px" value="" class="input" caption="Sales Rep." maxlength="5" dataformat="engup"></td>
	        </tr>
	      </table>
	     
	      <table class="mar_btm_4">
	      	<colgroup> 	
 				<col width="280">
 				<col width="25">
 				<col width="180"> 				
 				<col width="230">
 				<col width="82">
 				<col width="80">
 				<col width="73">
 				<col width="*">
 			</colgroup>
	        <tr>	
                <td class="sm"><input type="radio" id="t1_rdo_bkg_bl_1" name="t1_rdo_bkg_bl" value="BKG" class="trans mar_left_8"><!--
                --><label for="t1_rdo_bkg_bl_1"><b>BKG No.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label><!--
                --><input type="radio" id="t1_rdo_bkg_bl_2" name="t1_rdo_bkg_bl" value="BL" class="trans" checked><!--
                --><label for="t1_rdo_bkg_bl_2"><b>B/L No.</b></label><!--
                --><input type="text" name="t1_txt_bkg_no" style="width:103px;display:none" value="" class="input" caption="BKG No." minlength="11" maxlength="13" dataformat="engup"><!--
                --><input type="text" name="t1_txt_bl_no" style="width:103px" value="" class="input" caption="B/L No." minlength="10" maxlength="12" dataformat="engup"></td>
                <td></td>
                <td class="sm"><input type="radio" id="t1_rdo_date_flg_1" name="t1_rdo_date_flg" value="OnBoard" class="trans mar_left_8" checked><!--
                --><label for="t1_rdo_date_flg_1"><b>On Board</b></label><!--
                --><input type="radio" id="t1_rdo_date_flg_2" name="t1_rdo_date_flg" value="Issue" class="trans"><!--
                --><label for="t1_rdo_date_flg_2"><b>B/L Issue</b></label></td>
                <td class="sm"><input type="text" name="t1_txt_date_from" style="width:80px" value="" class="input" caption="From Date" maxlength="10" dataformat="ymd"><!--
                --> ~  <input type="text" name="t1_txt_date_to" style="width:80px" value="" class="input" caption="To Date" maxlength="10" dataformat="ymd"><!--
                --><button type="button" class="calendar ir" name="t1_btn_calendar" id="t1_btn_calendar"></button>                  </td>
		        <th>Fax Sent</th>
		        <td><%=HTMLUtil.getComboString("t1_slt_fax_proc_sts_cd", "width:68px;", "", "","","All", fax_sts_cd)%></td>
		        <th>E-mail Sent</th>
		        <td><%=HTMLUtil.getComboString("t1_slt_eml_proc_sts_cd", "width:72px;", "", "","","All", eml_sts_cd)%></td>
	        </tr>
	      </table>
	      <table>
	      	<colgroup> 	
	      		<col width="98">
	      		<col width="594">			
 				<col width="*">
 			</colgroup>
	        <tr style="height:28px">
	          <th class="sm">Freight Option</th>
	          <td class="sm"><input type="checkbox" id="t1_chk_opt1" name="t1_chk_opt1" value="Y" class="trans" onclick="onCheck(this);" checked><label for="t1_chk_opt1">All</label>&nbsp;&nbsp;&nbsp;<!--
	          --><input type="checkbox" id="t1_chk_opt2" name="t1_chk_opt2" value="Y" class="trans" onclick="onCheck(this);"><label for="t1_chk_opt2">Collect</label>&nbsp;&nbsp;&nbsp;<!--
	          --><input type="checkbox" id="t1_chk_opt3" name="t1_chk_opt3" value="Y" class="trans" onclick="onCheck(this);"><label for="t1_chk_opt3">Prepaid</label>&nbsp;&nbsp;&nbsp;<!--
	          --><input type="checkbox" id="t1_chk_opt4" name="t1_chk_opt4" value="Y" class="trans" onclick="onCheck(this);"><label for="t1_chk_opt4">No Charge</label>&nbsp;&nbsp;&nbsp;<!--
	          --><input type="checkbox" id="t1_chk_opt5" name="t1_chk_opt5" value="Y" class="trans" onclick="onCheck(this);"><label for="t1_chk_opt5">Freight As Arranged</label>&nbsp;&nbsp;&nbsp;<!--
	          --><input type="checkbox" id="t1_chk_opt_hidden" name="t1_chk_opt_hidden" value="" class="trans" onclick="onCheck(this);">&nbsp;<label for="t1_chk_opt_hidden">Hidden Option</label></td>
	           <td></td>
	        </tr>
	        <td></td>
	      </table>
	</div>

<!-- opus_design_inquiry (E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_normal" name="btn_print_t1sht1" id="btn_print_t1sht1">Print</button><!--
		--><button type="button" class="btn_normal" name="btn_preview_t1sht1" id="btn_preview_t1sht1">Preview</button><!--
		--><button type="button" class="btn_normal" name="btn_faxemail_t1sht1" id="btn_faxemail_t1sht1">Edit Fax/E-mail</button><!--
		--><button type="button" class="btn_normal" name="btn_assign_t1sht1" id="btn_assign_t1sht1">Assign BKG Agent E-mail</button><!--
		--><button type="button" class="btn_normal" name="btn_remark_t1sht1" id="btn_remark_t1sht1">Remark(s)</button><!--
		--><button type="button" class="btn_normal" name="btn_manifest_t1sht1" id="btn_manifest_t1sht1">Manifest(US)</button><!--
		--><button type="button" class="btn_normal" name="btn_fax_t1sht1" id="btn_fax_t1sht1">Fax</button><!--
		--><button type="button" class="btn_normal" name="btn_email_t1sht1" id="btn_email_t1sht1">E-mail</button><!--
		--><button type="button" class="btn_normal" name="btn_groupemail_t1sht1" id="btn_groupemail_t1sht1">Group E-mail</button><!--
		--><button type="button" class="btn_normal" name="btn_EmailEdit_t1sht1" id="btn_EmailEdit_t1sht1">E-mail (Edit)</button><!--
		--></div>
		<!-- opus_design_btn(e) -->
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_data(S) -->
	<div class="opus_design_data wFit">
		<table class="grid2" >
		<colgroup>
			<col width="50">
			<col width="80">
			<col width="80">
			<col width="80">
			<col width="80">
			<col width="70">
			<col width="80">
			<col width="70">
			<col width="80">
			<col width="70">
			<col width="*">
		</colgroup>
        <tr>
          <th>Fax</th>
          <th>B/L Total</th>
          <td><input type="text" name="faxBlTotal1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Fax Total</th>
          <td><input type="text" name="faxTotal1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Success</th>
          <td><input type="text" name="faxSuccess1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Sending</th>
          <td><input type="text" name="faxSending1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Un-sent</th>
          <td><input type="text" name="faxUnSent1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
        </tr>
        <tr>
          <th>E-mail</th>
          <th>B/L Total</th>
          <td><input type="text" name="emlBlTotal1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>E-mail Total</th>
          <td><input type="text" name="emlTotal1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Success</th>
          <td><input type="text" name="emlSuccess1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Sending</th>
          <td><input type="text" name="emlSending1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Un-sent</th>
          <td><input type="text" name="emlUnSent1" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
        </tr>
      </table>

	<!-- opus_design_data(E) -->
	         
</div>
<!--Inbound (E-1)  -->
</div>
<!--##########################################  -->


<!--TAB Inbound(S-2) -->
    <div id="tabLayer" style="display:none">
    	<!-- wrap_result(S) -->

		<!-- opus_design_inquiry (S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="30">
					<col width="130">
					<col width="95">
					<col width="247">
					<col width="76">
					<col width="123">
					<col width="50">
					<col width="88">
					<col width="68">
					<col width="*">
				</colgroup>
		        <tr>
	                <th class="sm">Type</th>
		            <td class="sm"><!--
		            --><input type="radio" id="t2_rdo_bl_tp_cd_1" name="t2_rdo_bl_tp_cd" value="D" class="trans" onclick="inb_change_radio();" checked ><!--
		            --><label for="t2_rdo_bl_tp_cd_1">N/N Copy</label><!--
		            --><input type="radio" id="t2_rdo_bl_tp_cd_2" name="t2_rdo_bl_tp_cd" value="W" class="trans" onclick="inb_change_radio();"><!--
		            --><label for="t2_rdo_bl_tp_cd_2">Waybill</label></td>
		          	<th>ETA Date</th>
		          	<td><input type="text" name="t2_txt_date_from" style="width:73px" value="2008-10-10" class="input1" caption="ETA From Date" maxlength="10" dataformat="ymd"><!--
		          	-->~ <input type="text" name="t2_txt_date_to" style="width:73px" value="2008-10-10" class="input1" caption="ETA To Date" maxlength="10" dataformat="ymd"><!--
		          	--><button type="button" class="calendar ir" name="t2_btn_calendar" id="t2_btn_calendar"></button></td>
		          	<th title="Vessel Voyage Direction">VVD</th>
		          	<td><input type="text" name="t2_txt_vvd" style="width:85px" value="HJPO0009E" class="input" caption="VVD" minlength="9" maxlength="9" dataformat="engup"></td>
		         	<th title="Port of Discharging">POD</th>
		         	<td><input type="text" name="t2_txt_pod" style="width:70px" value="KRPUS" class="input1" caption="POD" minlength="2" maxlength="5" dataformat="engup"></td>
		        	<th title="Port of Loading">POL</th>
		         	<td><input type="text" name="t2_txt_pol" style="width:55px" value="BEANR" class="input" caption="POL" minlength="2" maxlength="5" dataformat="engup"></td>
		        </tr>
		      </table>
		      
		      
		      <table>
		      	<colgroup>
					<col width="55">
					<col width="118">
					<col width="105">
					<col width="242">
					<col width="55">
					<col width="70">
					<col width="170">
					<col width="*">
				</colgroup>
		        <tr>
		          	<th>S/C No.</th>
		          	<td><input type="text" name="t2_txt_sc_no" caption="S/C No." maxlength="20" dataformat="engup" style="width:108px;" class="input" value="AEN001"></td>
		          	<th>Customer</th>
		          	<td><%=HTMLUtil.getComboString("t2_slt_bkg_cust_tp_cd", "width:90;", "", "","","All", bkg_cust_tp_cd)%><!--
		          	--><input type="text" name="t2_txt_cust_seq1" class="input" caption="Customer Nation" maxlength="2" dataformat="enguponly" style="width:30px;" value=""><!--
		          	--><input type="text" name="t2_txt_cust_seq2" class="input" caption="Customer Seq" maxlength="6" dataformat="engup" style="width:50px;margin-left:1;" value=""><!--
		          	--><input type="text" name="t2_txt_cust_nm" class="input" caption="Customer Name" maxlength="30" dataformat="engup" style="width:60px;" value=""></td>
		          	<th>B/L No.</th>
		          	<td><input type="text" name="t2_txt_bl_no" style="width:102px" class="input" caption="B/L No." minlength="10" maxlength="12" dataformat="engup"></td>
		          	<td><input type="radio" id="t2_rdo_date_flg_1" name="t2_rdo_date_flg" value="OnBoard" class="trans" checked><label for="t2_rdo_date_flg_1"><b>On Board</b></label><input type="radio" id="t2_rdo_date_flg_2" name="t2_rdo_date_flg" value="Issue" class="trans"><label for="t2_rdo_date_flg_2"><b>B/L Issue</b></label></td>
		          	<td><input type="text" name="t2_txt_date_from2" style="width:72px" value="2008-10-10" class="input" caption="From Date" maxlength="10" dataformat="ymd">~ <input type="text" name="t2_txt_date_to2" style="width:72px" value="2008-10-10" class="input" caption="To Date" maxlength="10" dataformat="ymd"><button type="button" class="calendar ir" name="t2_btn_calendar2" id="t2_btn_calendar2"></button>		                		            </td>
		        </tr>
		      </table>
		      
		      
		      <table>
		      	<colgroup>
					<col width="98">
					<col width="590">
					<col width="75">
					<col width="83">
					<col width="80">
					<col width="*">
				</colgroup>
		        <tr>
                  <th class="sm">Freight Option</th>
		          <td class="sm"><!--
		          --><input type="checkbox" id="t2_chk_opt1" name="t2_chk_opt1" value="Y" class="trans" onclick="onCheck(this);" checked><label for="t2_chk_opt1">All</label>&nbsp;&nbsp;&nbsp;<!--
		          --><input type="checkbox" id="t2_chk_opt2" name="t2_chk_opt2" value="Y" class="trans" onclick="onCheck(this);"><label for="t2_chk_opt2">Collect</label>&nbsp;&nbsp;&nbsp;<!--
		          --><input type="checkbox" id="t2_chk_opt3" name="t2_chk_opt3" value="Y" class="trans" onclick="onCheck(this);"><label for="t2_chk_opt3">Prepaid</label>&nbsp;&nbsp;&nbsp;<!--
		          --><input type="checkbox" id="t2_chk_opt4" name="t2_chk_opt4" value="Y" class="trans" onclick="onCheck(this);"><label for="t2_chk_opt4">No Charge</label>&nbsp;&nbsp;&nbsp;<!--
		          --><input type="checkbox" id="t2_chk_opt5" name="t2_chk_opt5" value="Y" class="trans" onclick="onCheck(this);"><label for="t2_chk_opt5">Freight As Arranged</label>&nbsp;&nbsp;&nbsp;<!--
		          --><input type="checkbox" id="t2_chk_opt_hidden" name="t2_chk_opt_hidden" value="" class="trans" onclick="onCheck(this);"><!--
		          --><label for="t2_chk_opt_hidden">Hidden Option</label></td>
		          <th>Fax Sent</th>
		          <td><%=HTMLUtil.getComboString("t2_slt_fax_proc_sts_cd", "width:68;", "", "","","All", fax_sts_cd)%></td>
		          <th style="text-align:left">E-mail Sent</th>
		          <td><%=HTMLUtil.getComboString("t2_slt_eml_proc_sts_cd", "width:68;", "", "","","All", eml_sts_cd)%></td>
		        </tr>
   			</table>
		</div>

		<!-- opus_design_inquiry (E) -->
	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_normal" name="btn_print_t2sht1" id="btn_print_t2sht1">Print</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_preview_t2sht1" id="btn_preview_t2sht1">Preview</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_faxemail_t2sht1" id="btn_faxemail_t2sht1">Edit Fax/E-mail</button><!-- 				
				 --><button type="button" class="btn_normal" name="btn_remark_t2sht1" id="btn_remark_t2sht1">Remark(s)</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_fax_t2sht1" id="btn_fax_t2sht1">Fax</button><!-- 				
				 --><button type="button" class="btn_normal" name="btn_email_t2sht1" id="btn_email_t2sht1">E-mail</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_groupemail_t2sht1" id="btn_groupemail_t2sht1">Group E-mail</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_EmailEdit_t2sht1" id="btn_EmailEdit_t2sht1">E-mail (Edit)</button>			
			</div>
			<!-- opus_design_btn(e) -->
		<!-- opus_design_grid(E) -->
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		
		<!-- opus_design_data(S) -->
<div class="opus_design_data wFit">
	<table class="grid2">
		<colgroup>
			<col width="50">
			<col width="80">
			<col width="80">
			<col width="80">
			<col width="80">
			<col width="70">
			<col width="80">
			<col width="70">
			<col width="80">
			<col width="70">
			<col width="*">
		</colgroup>
        <tr>
          <th>Fax</th>
          <th>B/L Total</th>
          <td><input type="text" name="faxBlTotal2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Fax Total</th>
          <td><input type="text" name="faxTotal2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Success</th>
          <td><input type="text" name="faxSuccess2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Sending</th>
          <td><input type="text" name="faxSending2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Un-sent</th>
          <td><input type="text" name="faxUnSent2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
        </tr>
        <tr>
          <th>E-mail</th>
          <th>B/L Total</th>
          <td><input type="text" name="emlBlTotal2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>E-mail Total</th>
          <td><input type="text" name="emlTotal2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Success</th>
          <td><input type="text" name="emlSuccess2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Sending</th>
          <td><input type="text" name="emlSending2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
          <th>Un-sent</th>
          <td><input type="text" name="emlUnSent2" style="width:100%;text-align:right" class="noinput" value="" readOnly></td>
        </tr>
      </table>

</div>
<!-- opus_design_data(E) -->


</div>
<!--TAB Inbound(E-2) -->	
	
<input type="hidden" name="com_mrdPath" id="com_mrdPath">
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" id="com_mrdSaveDialogDir" value="<%=fileDir.toString()%>">
<input type="hidden" name="com_mrdSaveDialogFileName" id="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" id="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" id="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle">
<input type="hidden" name="com_zoomIn" id="com_zoomIn">
<input type="hidden" name="com_isBatch" id="com_isBatch" value="N">

<!-- <div class="opus_design_RD rd_hidden">  -->
<!-- 	 <script type="text/javascript">rdViewerObject();</script> -->
<!-- </div>	 -->
</div>
<div id="bkg_mrd_path"></div>
<div id="bkg_mrd_param"></div>
</form>

<!--form name="form2" method="post">
  <input type="hidden" name="bl_tp_cd">
  <input type="hidden" name="bkg_no">
  <input type="hidden" name="bl_no">
  <input type="hidden" name="fax_no">
  <input type="hidden" name="email">
  <input type="hidden" name="form_remark">
  <input type="hidden" name="form_level">
  <input type="hidden" name="form_hiddeData">
</form-->

<form name="form3" method="post">
  <input type="hidden" name="pop_mode" id="pop_mode">
  <input type="hidden" name="display" id="display">
  <input type="hidden" name="func" id="func">
  <input type="hidden" name="row" id="row">
  <input type="hidden" name="col" id="col">
  <input type="hidden" name="sheetIdx" id="sheetIdx">
  <input type="hidden" name="bkg_no" id="bkg_no">
  <input type="hidden" name="bl_no" id="bl_no">
  <input type="hidden" name="ok_hidden" id="ok_hidden">
  <input type="hidden" name="send_hidden" id="send_hidden">
  <input type="hidden" name="form_type" id="form_type">
  <input type="hidden" name="form_dataOnly" id="form_dataOnly">
  <input type="hidden" name="form_manifest" id="form_manifest">
  <input type="hidden" name="form_hiddeData" id="form_hiddeData">
  <input type="hidden" name="form_mainOnly" id="form_mainOnly">
  <input type="hidden" name="form_level" id="form_level">
  <input type="hidden" name="form_remark" id="form_remark">
  <input type="hidden" name="form_Cntr" id="form_Cntr">
  <input type="hidden" name="form_CorrNo" id="form_CorrNo">
  <input type="hidden" name="form_his_cntr" id="form_his_cntr">
  <input type="hidden" name="form_his_bkg" id="form_his_bkg">
  <input type="hidden" name="form_his_mkd" id="form_his_mkd">
  <input type="hidden" name="form_his_xpt" id="form_his_xpt">
  <input type="hidden" name="form_his_bl" id="form_his_bl">
  <input type="hidden" name="rp" id="rp">
  <input type="hidden" name="ntc_knd_cd" id="ntc_knd_cd">
</form>

<form name="form4" method="post">
  <input type="hidden" name="f_cmd" id="f_cmd">
  <input type="hidden" name="bkg_no" id="bkg_no">
</form>


