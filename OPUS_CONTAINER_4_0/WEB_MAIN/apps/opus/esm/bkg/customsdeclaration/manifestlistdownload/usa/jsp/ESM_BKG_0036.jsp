<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0036.jsp
*@FileTitle  : B/L Inquiry: C/M Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0036Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0036Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String strCntCd			= "";
    String strBlNo          = "";
    String strBdrFlg		= "";
    String strVvd           = "";
    String strPod           = "";
    String strEta           = "";

    //String strPgmNo         = "";
    //String strOffice        = "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0036Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strCntCd = JSPUtil.getNullNoTrim(request.getParameter("cnt_cd"));
		strBlNo  = JSPUtil.getNullNoTrim(request.getParameter("bl_no"));
		strBdrFlg = JSPUtil.getNullNoTrim(request.getParameter("trnk_bdr_flg"));
        strVvd = JSPUtil.getNullNoTrim(request.getParameter("vvd"));
        strPod = JSPUtil.getNullNoTrim(request.getParameter("pod_cd"));
        strEta = JSPUtil.getNullNoTrim(request.getParameter("vps_eta_dt2"));
        strEta = strEta.length() > 10 ? strEta.substring(0,10) : strEta;

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cntr_no" id="cntr_no" />
<input type="hidden" name="tpsz_cd" id="tpsz_cd" />
<input type="hidden" name="sheet_id" id="sheet_id" />

<input type="hidden" name="cnt_cd" value="<%="".equals(strCntCd) ? "US" : strCntCd%>">
<input type="hidden" name="bdr_flg" value="<%=strBdrFlg%>" id="bdr_flg" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Manifest Details by B/L : C/M Information</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		--><button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button><!-- 		
		--><button type="button" class="btn_normal" name="btn_copy" 			id="btn_copy">Copy C/M</button><!-- 		
		--><button type="button" class="btn_normal" name="btn_clm" 			id="btn_clm">CLM Inquiry</button><!-- 		
		--><button type="button" class="btn_normal" name="btn_close" 			id="btn_close">Close</button><!-- 		
	--></div>
	<!-- opus_design_btn(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="20"/>
				<col width="200"/>
				<col width="30"/>
				<col width="30"/>
				<col width="100"/>
				<col width="100"/>
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr class="h23">
		            <th>B/L No</th>
		            <td><input type="text" name="bl_no" style="width:100; ime-mode: disabled;" class="input1" dataformat="eng" maxlength="12" required caption="B/L No." value="<%=strBlNo%>"></td>
		            <td><span id="mf_sts"></span></td>
		            <td><span id="cstms_clr_tp_cd"></span></td>
		            <td>Freight : <span id="f_flg"></span></td>
		            <td>O.B/L : <span id="o_flg"></span></td>
		            <td>Customs : <span id="c_flg"></span></td>
            	</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">	
	
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40"/>
				<col width="80"/>
				<col width="40"/>
				<col width="50"/>
				<col width="40"/>
				<col width="80"/>
				<col width="40"/>
				<col width="80"/>
				<col width="60"/>
				<col width="80"/>
				<col width="40"/>
				<col width="80"/>
				<col width="40"/>
				<col width="*" />				
			</colgroup> 
			<tbody>
				 <tr class="h23">
		            <th title="Vessel Voyage Direction">VVD</th>
		            <td><input type="text" name="vvd" style="width:80px; ime-mode:disabled;" readonly class="input2" dataformat="eng" maxlength="9" fullfill caption="VVD" value="<%=strVvd%>"></td>
		            <th title="Port of Discharging">POD</th>
		            <td><input type="text" name="pod_cd" style="width:50px; ime-mode:disabled;" readonly class="input2" dataformat="eng" maxlength="5" fullfill caption="POD" value="<%=strPod%>"></td>
		            <th>ETA</th>
		            <td><input type="text" name="vps_eta_dt" style="width:80px; ime-mode:disabled;" readonly class="input2" value="<%=strEta%>"></td>
		            <th title="Port of Loading">POL</th>
		            <td><input type="text" name="pol_cd" style="width:50px; ime-mode:disabled;" readonly class="input2" dataformat="eng" maxlength="5" fullfill caption="POL"></td>
		            <th title="Place of Delivery">DEL</th>
		            <td><input type="text" name="del_cd" style="width:50px; ime-mode:disabled;" readonly class="input2" dataformat="eng" maxlength="5" fullfill caption="DEL"></td>
		            <th>L.USA</th>
		            <td><input type="text" name="usa_lst_loc_cd" style="width:50px; ime-mode:disabled;" readonly class="input2" dataformat="eng" maxlength="5" fullfill caption="L.USA"></td>
		            <th>Stage</th>
		            <td><input type="text" name="cstms_mf_tp_cd" style="width:30px; ime-mode:disabled; text-indent:6" readonly class="input2"></td>
            	</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="40">
				<col width="80">
				<col width="40">
				<col width="300">
				<col width="60">
				<col width="180">
				<col width="60">
				<col width="*">				
			</colgroup>
			<tbody>
				 <tr class="h23">
		            <th>Q'ty</th>
		            <td width=""><input type="text" name="pck_qty" style="width:38px;ime-mode:disabled;text-align:right;" readonly class="input2" dataformat="int" maxlength="7" caption="Q'ty"><!-- 
		                --><input type="text" name="ams_pck_tp_cd" style="width:38px; ime-mode:disabled; text-align:center;" readonly class="input2" dataformat="eng" maxlength="3" caption="Q'ty Code"></td>
		            <th>WGT</th>
		            <td><input type="text" name="cgo_wgt" style="width:135px; ime-mode: disabled;text-align:right" readonly class="input2" dataformat="float" maxlength="12" caption="WGT"><!-- 
		                --><input type="text" name="wgt_ut_cd" style="width:38px; ime-mode:disabled; text-align:center;" readonly class="input2" dataformat="eng" maxlength="3" caption="WGT Code"></td>
		            <th>P/MIB No.</th>
		            <td><input type="text" name="ibd_trsp_no" style="width:105px; ime-mode:disabled;" readonly class="input2" dataformat="eng" maxlength="17" caption="P/MIB No."></td>
		            <th>Type</th>
		            <td><input type="text" name="ibd_trsp_tp_cd" style="width:30px; ime-mode:disabled; text-indent:6px" readonly class="input2" dataformat="eng" maxlength="17" caption="Type"></td>
            	</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_grid">			
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_add" 		id="btn_add">Row Add</button>
			<button type="button" class="btn_normal" name="btn_del" 			id="btn_del">Row Delete</button>		
		</div>
		<!-- opus_design_btn(E) -->		
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">
				<col width="150">
				<col width="50">
				<col width="*">							
			</colgroup>
			<tbody>
				 <tr class="h23">
	                <th>Total PKG</th>
	                <td ><input type="text" name="tot_pkg" style="width:100px;text-align:right" readonly class="input2"></td>
	                <th>Total WGT</th>
	                <td><input type="text" name="tot_wgt" style="width:100px;text-align:right" readonly class="input2"></td>
	            </tr>
			</tbody>
		</table>
	</div>
</div>
</form>
