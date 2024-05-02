<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1164.jsp
*@FileTitle  : Feeder BL Print(Russia)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.HTMLUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.event.EsmBkg1164Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%
     EsmBkg1164Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
	String strOfc_cd = "";
	String strCnt_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.customsdeclaration.manifestListDownload.russia");
    List<BkgComboVO> bkg_sts_cd = null;
    List<BkgComboVO> bkg_cust_tp_cd = null;
    List<BkgComboVO> fax_sts_cd = null;
    List<BkgComboVO> eml_sts_cd = null;

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

         event = (EsmBkg1164Event)request.getAttribute("Event") ; /* user commang:phi.tran */
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>" id="strUsr_id" />
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>" id="strOfc_cd" />
<input type="hidden" name="strCnt_cd" value="<%=strCnt_cd%>" id="strCnt_cd" />
<!-- 조회조건 -->
<input type="hidden" name="bl_tp_cd" id="bl_tp_cd" />
<input type="hidden" name="vsl_cd" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />
<input type="hidden" name="pol_cd" id="pol_cd" />
<input type="hidden" name="pod_cd" id="pod_cd" />
<input type="hidden" name="bkg_ofc_cd" id="bkg_ofc_cd" />
<input type="hidden" name="doc_usr_id" id="doc_usr_id" />
<input type="hidden" name="bkg_sts_cd" id="bkg_sts_cd" />
<input type="hidden" name="bkg_cust_tp_cd" id="bkg_cust_tp_cd" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="cust_nm" id="cust_nm" />
<input type="hidden" name="obl_iss_ofc_cd" id="obl_iss_ofc_cd" />
<input type="hidden" name="obl_iss_usr_id" id="obl_iss_usr_id" />
<input type="hidden" name="ob_sls_ofc_cd" id="ob_sls_ofc_cd" />
<input type="hidden" name="ob_srep_cd" id="ob_srep_cd" />
<input type="hidden" name="bkg_no" id="bkg_no" />
<input type="hidden" name="bl_no" id="bl_no" />
<input type="hidden" name="bl_obrd_dt_from" id="bl_obrd_dt_from" />
<input type="hidden" name="bl_obrd_dt_to" id="bl_obrd_dt_to" />
<input type="hidden" name="obl_iss_dt_from" id="obl_iss_dt_from" />
<input type="hidden" name="obl_iss_dt_to" id="obl_iss_dt_to" />
<input type="hidden" name="fax_proc_sts_cd" id="fax_proc_sts_cd" />
<input type="hidden" name="eml_proc_sts_cd" id="eml_proc_sts_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_down_excel" 			id="btn_down_excel">Down Excel</button><!-- 			
	 --></div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
			
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="60" />
					<col width="110" />
					<col width="110" />
					<col width="120" />
					<col width="100" />
					<col width="90" />
					<col width="100" />
					<col width="100" />
					<col width="180" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
		                <th class="sm">Type</th>
		                <td class="sm">
		                  <input type="radio" id="t1_rdo_bl_tp_cd_1" name="tp_cd" value="F" class="trans" checked/><label for="t1_rdo_bl_tp_cd_1">Full</label><!-- 
		               --><input type="radio" id="t1_rdo_bl_tp_cd_2" name="tp_cd" value="P" class="trans"><label for="t1_rdo_bl_tp_cd_2">Empty</label>
		                </td>
			          <th title="Vessel Voyage Direction">VVD</th>
			          <td><input type="text" name="t1_txt_vvd" style="width:90px;" value="" class="input1" caption="VVD" minlength="9" maxlength="9" dataformat="engup" id="t1_txt_vvd" /> </td>
			          <th>V.POL</th>
			          <td><input type="text" name="t1_txt_pol" style="width:65px;" value="" class="input1" caption="POL" minlength="2" maxlength="5" dataformat="engup" id="t1_txt_pol" /> </td>
			          <th>V.POD</th>
			          <td><input type="text" name="t1_txt_pod" style="width:65px;" value="" class="input1" caption="POD" minlength="2" maxlength="5" dataformat="engup" id="t1_txt_pod" /> </td>
		                <td class="sm" style="padding-left:8px">
		                  <input type="radio" id="t1_rdo_date_flg_1" name="t1_rdo_date_flg" value="OnBoard" class="trans" checked="" /><label for="t1_rdo_date_flg_1">On Board</label><!-- 
		                   --><input type="radio" id="t1_rdo_date_flg_2" name="t1_rdo_date_flg" value="Issue" class="trans" /><label for="t1_rdo_date_flg_2">B/L Issue</label>
		                </td>
		                <td>
		                  <input type="text" name="t1_txt_date_from" style="width:73px;" value="" class="input" caption="From Date" maxlength="10" dataformat="ymd" id="t1_txt_date_from" />~ <input type="text" name="t1_txt_date_to" id="t1_txt_date_to" style="width:73px" value="" class="input" caption="To Date" maxlength="10" dataformat="ymd"><!-- 
		                   --><button type="button" id="t1_btn_calendar" name="t1_btn_calendar" class="calendar ir"></button>
		                </td>
			        </tr>
				</tbody>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="60" />
					<col width="120" />
					<col width="100" />
					<col width="120" />
					<col width="100" />
					<col width="90" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
			          <th>BKG No.</th>
			          <td><input type="text" name="t1_txt_bkg_no" style="width:110px;" value="" class="input" caption="BKG No." minlength="11" maxlength="13" dataformat="engup" id="t1_txt_bkg_no" /></td>
			          <th>B/L No.</th>
			          <td><input type="text" name="t1_txt_bl_no" style="width:110px;" value="" class="input" caption="B/L No." minlength="12" maxlength="12" dataformat="engup" id="t1_txt_bl_no" /></td>
			          <th>Sales OFC</th>
			          <td><input type="text" name="t1_txt_ob_sls_ofc_cd" style="width:80px;" value="" class="input" caption="Sales Office" maxlength="6" dataformat="engupetc" id="t1_txt_ob_sls_ofc_cd" /></td>
			          <th>Sales Rep.</th>
			          <td><input type="text" name="t1_txt_ob_srep_cd" style="width:65px;" value="" class="input" caption="Sales Rep." maxlength="5" dataformat="engupetc" id="t1_txt_ob_srep_cd" /></td>
			        </tr>
				</tbody>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_edit_cust_info" 		id="btn_edit_cust_info">Edit Customer</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Print" 			id="btn_Print">Print</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_PDFPrint" 			id="btn_PDFPrint">PDF</button><!-- 
		 --></div>
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>				

</form>


<form name="form2" method="POST">
<input type="hidden" name="bkg_no" id="bkg_no" />
<input type="hidden" name="param_ui_id" id="param_ui_id" />
</form>

<form name="form3" method="post">
  <input type="hidden" name="pop_mode" id="pop_mode" />
  <input type="hidden" name="display" id="display" />
  <input type="hidden" name="func" id="func" />
  <input type="hidden" name="row" id="row" />
  <input type="hidden" name="col" id="col" />
  <input type="hidden" name="sheetIdx" id="sheetIdx" />
  <input type="hidden" name="bkg_no" id="bkg_no" />
  <input type="hidden" name="bl_no" id="bl_no" />
  <input type="hidden" name="sh_cust_nm" id="sh_cust_nm" />
  <input type="hidden" name="sh_cust_addr" id="sh_cust_addr" />
  <input type="hidden" name="cn_cust_nm" id="cn_cust_nm" />
  <input type="hidden" name="cn_cust_addr" id="cn_cust_addr" />
  <input type="hidden" name="nf_cust_nm" id="nf_cust_nm" />
  <input type="hidden" name="nf_cust_addr" id="nf_cust_addr" />
  <input type="hidden" name="ex_cust_nm" id="ex_cust_nm" />


</form>