<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3501.jsp
*@FileTitle  : Tariff General Information Creation &amp; Amendment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3501Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3501Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	String[] tariffCd       = null;				//Tariff Code
	String[] aproOfcCd		= null;		    	//Approval Office
	String[] trfBzcTpCd		= null;				//Tariff Type
	String[] trfBzcWgtUtCd	= null;				//Weight Ton Unit
	String[] trfBzcVolUtCd	= null;				//Volume Ton Unit
	String[] currCd			= null;				//Currency
//	String[] trfbzcstscd    = null;				//Status
	String[] srcinfocd		= null;				//Source
	String   trfPfxCd       = null;             //Setting using trfPfxCd from Inquiry
	String   trfNo          = null;             //Setting using trfNo from Inquiry
	String   amdtSeq        = null;             //Setting using amdtseq from Inquiry
		
	Logger log = Logger.getLogger("com.clt.apps.Tariff.TariffGeneralInformation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmPri3501Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		trfPfxCd = JSPUtil.getNull(request.getParameter("trfPfxCd"));
		trfNo = JSPUtil.getNull(request.getParameter("trfNo"));
		amdtSeq = JSPUtil.getNull(request.getParameter("amdtSeq"));
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//COMMBO LIST
		tariffCd        = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));
		aproOfcCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("APRO_OFC_CD"));
		trfBzcTpCd		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_BZC_TP_CD"));
		trfBzcWgtUtCd	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_BZC_WGT_UT_CD"));
		trfBzcVolUtCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_BZC_VOL_UT_CD"));
		currCd			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"),true ,"|","\t","getCd","getEtc1");
//		trfbzcstscd		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_BZC_STS_CD"));
		srcinfocd		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var tariffCdValue           = " |<%=tariffCd[0]%>";
	var tariffCdText            = " |<%=tariffCd[1]%>";
	var aproOfcCdComboValue     = " |<%=aproOfcCd[0]%>";
	var aproOfcCdComboText      = " |<%=aproOfcCd[1]%>";
	var trfBzcTpCdComboValue    = " |<%=trfBzcTpCd[0]%>";
	var trfBzcTpCdComboText     = " |<%=trfBzcTpCd[1]%>";
	var trfBzcWgtUtCdComboValue = " |<%=trfBzcWgtUtCd[0]%>";
	var trfBzcWgtUtCdComboText  = " |<%=trfBzcWgtUtCd[1]%>";
	var trfBzcVolUtCdComboValue = " |<%=trfBzcVolUtCd[0]%>";
	var trfBzcVolUtCdComboText  = " |<%=trfBzcVolUtCd[1]%>";
	var currCdComboValue 		= " |<%=currCd[0]%>";
	var currCdComboText  		= " |<%=currCd[1]%>";
	var srcInfoCdComboValue		= " |<%=srcinfocd[0]%>";
	var srcInfoCdComboText		= " |<%=srcinfocd[1]%>";


	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" 								id="f_cmd" />
<input type="hidden" name="pagerows" 							id="pagerows" />
<input type="hidden" name="strusr_id" value="<%=strUsr_id %>" 	id="strusr_id" />
<input type="hidden" name="strusr_nm" value="<%=strUsr_nm %>" 	id="strusr_nm" />
<input type="hidden" name="strofc_cd" value="<%=strOfc_cd %>" 	id="strofc_cd" />
<input type="hidden" name="trf_pfx_cd" value="<%=trfPfxCd %>" 	id="trf_pfx_cd" />
<input type="hidden" name="trf_no" value="<%=trfNo %>" id="trf_no" />
<input type="hidden" name="hid_amdt_seq" value="<%=amdtSeq %>" 	id="hid_amdt_seq" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_amend" 		id="btn_amend">Amend</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete" 		id="btn_delete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_request" 	id="btn_request">Request</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_approve" 	id="btn_approve">Approve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_publish" 	id="btn_publish">Publish</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_cancel" 		id="btn_cancel">Cancel</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- Hidden sheet for Transaction (S) -->
<div style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div> 
<!-- Hidden sheet for Transaction (E) -->

<div class="wrap_result">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="100">
					<col width="150">
					<col width="80">
					<col width="130">
					<col width="*">
			    </colgroup>
				<tr>
					<td colspan="4" style="text-align:left; color:blue;">
	                <img class="cursor" src="/opuscntr/img/opus/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">
	                <u><a href="#" onclick="javascript:goCodeCreation();" class="blue">Code Creation</a></u> 
					</td>
					<td></td>
				</tr>
				<tr>
					<th>Tariff Code</th>
					<td><script type="text/javascript">ComComboObject("tariff_cd", 2, 129, 0, 1, 0, false);</script></td>
					<th>Tariff Name</th>
					<td><input type="text" name="trf_nm" id="trf_nm" style="width:640px;" class="input2" value="" readonly></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="100">
					<col width="260">
					<col width="50">
					<col width="91">
					<col width="50">
					<col width="90">
					<col width="50">
					<col width="130">
					<col width="60">
					<col width="*">
			    </colgroup>
				<tr>
					<th>Organization</th>
					<td><input type="text" name="trf_orz_nm" id="trf_orz_nm" maxlength="100" style="width:250px;" class="input2" value="" readonly></td>
					<th>Type</th>
					<td><input type="text" name="trf_orz_tp_nm" id="trf_orz_tp_nm" maxlength="20" style="width:60px; text-align:center" class="input2" value="" readonly></td>
					<th>Amend No.</th>
					<td><input type="text" name="amdt_seq" id="amdt_seq" style="width:65px; text-align:center" class="input2" value="" readonly></td>
					<th>Status</th>
					<td><input type="text" name="trf_bzc_sts_cd" id="trf_bzc_sts_cd" style="width:95px; text-align:center" class="input2" value="" readonly></td>
					<th>Inland Rates</th>
					<td><input type="text" name="trf_inlnd_flg" id="trf_inlnd_flg" style="width:55px; text-align:center" class="input2" value="" readonly></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>

	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Publishing Information</h3>
		
		<table>
			<tbody>
				<colgroup>
					<col width="100">
					<col width="140">
					<col width="90">
					<col width="150">
					<col width="100">
					<col width="150">
					<col width="81">
					<col width="130">
					<col width="*">
			    </colgroup>
				<tr>
					<th>Creation Date</th>
					<td><input type="text" name="cre_dt" id="cre_dt" maxlength="10" dataformat="ymd" style="width:130px; text-align:center;" class="input2" readonly></td>
					<th>Effective Date</th>
					<td><input type="text" name="eff_dt" id="eff_dt" maxlength="10" dataformat="ymd" style="width:130px; text-align:center;" class="input1" value=""  caption="Effective Date">
						<!-- <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar1"> -->
						<button type="button" class="calendar" name="btns_calendar1" id="btns_calendar1"></button></td>
					<th>Expiration Date</th>
					<td><input type="text" name="exp_dt" id="exp_dt" maxlength="10" dataformat="ymd" style="width:130px; text-align:center;" class="input" value="">
						<!-- <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar2"> -->
						<button type="button" class="calendar" name="btns_calendar2" id="btns_calendar2"></button></td>
					<th>Publish Date</th>
					<td><input type="text" name="pub_dt" id="pub_dt" maxlength="10" dataformat="ymd" style="width:122px; text-align:center;" class="input2" value="" readonly></td>
					<td></td>
				</tr>	
				<tr class="h23">
					<th>Request Office</th>
					<td><input type="text" name="rqst_ofc_cd" id="rqst_ofc_cd" style="width:130px; text-align:center;" class="input2" value="<%=strOfc_cd %>" readonly></td>
					<th>Creation Staff</th>
					<td><input type="text" name="cre_usr_id" id="cre_usr_id" style="width:130px; text-align:center;" class="input2" value="<%=strUsr_id %>" readonly></td>
					<th>Approval Office</th>
					<td colspan="3"><script type="text/javascript">ComComboObject('apro_ofc_cd', 2, 130, 0, 1);</script></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>

	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Tariff Type / Measurement / Currency Information</h3>
		<table>
			<tbody>
				<colgroup>
					<col width="100">
					<col width="140">
					<col width="90">
					<col width="80">
					<col width="85">
					<col width="100">
					<col width="80">
					<col width="85">
					<col width="81">
					<col width="130">
					<col width="*">
			    </colgroup>
				<tr>
					<th>Tariff Type</th>
					<td><script type="text/javascript">ComComboObject('trf_bzc_tp_cd', 2, 130, 0, 1);</script></td>
					<th>Weight Ton</th>
					<td><input type="text" name="trf_bzc_wgt" id="trf_bzc_wgt" maxlength="14" pointcount="3" dataformat="float" style="width:77px; text-align:right;" class="input1" value="" caption="Weight Ton"></td>
					<td><script type="text/javascript">ComComboObject('trf_bzc_wgt_ut_cd', 2, 50, 0, 1);</script></td>
					<th>Volume Ton</th>
					<td><input type="text" name="trf_bzc_vol_qty" id="trf_bzc_vol_qty" maxlength="13" pointcount="3" dataformat="float" style="width:77px; text-align:right;" class="input1" value="" caption="Volume Ton"></td>
					<td><script type="text/javascript">ComComboObject('trf_bzc_vol_ut_cd', 2, 50, 0, 1);</script></td>
					<th>Currency</th>
					<td><script type="text/javascript">ComComboObject('curr_cd', 2, 122, 0, 1);</script></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Publishing Office</h3>
		<table>
			<tbody>
				<colgroup>
					<col width="100">
					<col width="140">
					<col width="90">
					<col width="100">
					<col width="50">
					<col width="106">
					<col width="50">
					<col width="110">
					<col width="100">
					<col width="*">
			    </colgroup>
				<tr class="h23">
					<th>Contact</th>
					<td><input type="text" name="pub_cntc_pson_nm" id="pub_cntc_pson_nm" maxlength="50" style="width:130px;" class="input1" value="" style="ime-mode:disabled" caption="Contact"></td>
					<th>Address</th>
					<td colspan="5"><input type="text" name="pub_ofc_addr" id="pub_ofc_addr" maxlength="200" style="width:402px;" class="input1" value="" style="ime-mode:disabled" caption="Address"></td>
					<th>Phone</th>
					<td><input type="text" name="pub_ofc_phn_no" id="pub_ofc_phn_no" maxlength="20" dataformat="num" otherchar="-" style="width:122px;" class="input1" value="" style="ime-mode:disabled" caption="Phone"></td>
				</tr>	
				<tr class="h23">
					<th>City</th>
					<td><input type="text" name="pub_ofc_cty_nm" id="pub_ofc_cty_nm" maxlength="20" style="width:130px;" class="input1" value="" style="ime-mode:disabled" caption="City"></td>
					<th>State</th>
					<td><input type="text" name="pub_ofc_ste_cd" id="pub_ofc_ste_cd" maxlength="2"  dataformat="enguponly" style="width:85px;" class="input" value="" style="ime-mode:disabled" caption="State"></td>
					<th>Zip Code</th>
					<td><input type="text" name="pub_ofc_zip_cd" id="pub_ofc_zip_cd" maxlength="10" dataformat="num" style="width:85px;" class="input" value="" style="ime-mode:disabled" caption="Zip Code"></td>
					<th>Country</th>
					<td><input type="text" name="pub_ofc_cnt_nm" id="pub_ofc_cnt_nm" maxlength="20" style="width:92px;" class="input1" value="" style="ime-mode:disabled" caption="Country"></td>
					<th>Fax</th>
					<td><input type="text" name="pub_ofc_fax_no" id="pub_ofc_fax_no" maxlength="20" dataformat="num" otherchar="-" style="width:122px;" class="input" value="" style="ime-mode:disabled" caption="Fax"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>

	<!-- layout_wrap(S) -->
	<div class="layout_wrap"">
		<h3 class="title_design">Tariff Scope</h3>
		
	    <div class="layout_vertical_2 pad_rgt_8">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">            
				<div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_rowadd1" 		id="btn_rowadd1">Row Add</button><!-- 
					 --><button type="button" class="btn_accent" name="btn_rowdelete1" 		id="btn_rowdelete1">Delete</button><!-- 
					 --><button type="button" class="btn_accent" name="btn_amend1" 			id="btn_amend1">Amend</button><!-- 
					 --><button type="button" class="btn_accent" name="btn_amendcancel1" 	id="btn_amendcancel1">Amend Cancel</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    
	    
	    <div class="layout_vertical_2">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	            <div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_rowadd2" 		id="btn_rowadd2">Row Add</button><!-- 
					 --><button type="button" class="btn_accent" name="btn_rowdelete2" 		id="btn_rowdelete2">Delete</button><!-- 
					 --><button type="button" class="btn_accent" name="btn_amend2" 			id="btn_amend2">Amend</button><!-- 
					 --><button type="button" class="btn_accent" name="btn_amendcancel2" 	id="btn_amendcancel2">Amend Cancel</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet3');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	</div>
</div>
<!-- layout_wrap(E) -->
</form>