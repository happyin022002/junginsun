<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0034.jsp
*@FileTitle  :  B/L Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0034Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg0034Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";
	String strBlNo		  = "";
	String strBkgNo		 = "";
	String strVvd		   = "";
	String strPod		   = "";
	String strEta		   = "";
	String strPgmNo		 = "";
	String strOffice		= "";
	String mainPage = "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
		event = (EsmBkg0034Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strBlNo = request.getParameter("bl_no");
		strBkgNo = JSPUtil.getNull(request.getParameter("bkg_no"));
		if(strBlNo == null) {
			strBlNo = "";
			strVvd = JSPUtil.getNull(request.getParameter("vvd"));
			strPod = JSPUtil.getNull(request.getParameter("pod"));
			strEta = JSPUtil.getNull(request.getParameter("eta"));
			if(!"".equals(strEta) && strEta.length() > 8){
				StringBuffer sb = new StringBuffer();
				sb.append(strEta.substring(0,4)).append("-");
				sb.append(strEta.substring(4,6)).append("-");
				sb.append(strEta.substring(6,8)).append(" ");
				sb.append(strEta.substring(9,11)).append(":");
				sb.append(strEta.substring(11));
				strEta = sb.toString();
			}
		}
		strPgmNo = request.getParameter("pgmNo");
		strOffice = "ESM_BKG_0034-01".equals(strPgmNo) ? "Origin" : "US";
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var strCntCd = "<%=strCnt_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" value="<%=pageRows %>" id="pagerows" />
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="tab_no" value="0" id="tab_no" />
<input type="hidden" name="office" value="<%=strOffice %>" id="office" />
<input type="hidden" name="bl_no" value="<%=StringUtil.xssFilter(strBlNo)%>" id="bl_no" />
<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(strBkgNo)%>" id="bkg_no" />
<input type="hidden" name="bl_tp_cd" id="bl_tp_cd" />
<input type="hidden" name="trnk_bdr_flg" id="trnk_bdr_flg" />
<input type="hidden" name="cstms_clr_cd" id="cstms_clr_cd" />
<input type="hidden" name="locl_trns_cd" id="locl_trns_cd" />
<input type="hidden" name="bak_bl_no" id="bak_bl_no" />
<input type="hidden" name="vps_eta_dt" id="vps_eta_dt" />
<input type="hidden" name="full_mty_cd" id="full_mty_cd" />
<input type="hidden" name="diff_rmk" id="diff_rmk" />
<input type="hidden" name="hbl_cnt" id="hbl_cnt" />
<input type="hidden" name="bl_cnt" id="bl_cnt" />
<input type="hidden" name="page_gubun" value="ESM_BKG_0034" id="page_gubun" />
<input type="hidden" name="open_tab" value="<%= (request.getParameter("open_tab") == null) ? "" : request.getParameter("open_tab") %>">
<!-- saving User authority of modification -->
<input type="hidden" name="bl_vvd" id="bl_vvd" />
<input type="hidden" name="bl_pod" id="bl_pod" />
<input type="hidden" name="bl_del" id="bl_del" />
<input type="hidden" name="bl_cstms" id="bl_cstms" />
<input type="hidden" name="bl_hub" id="bl_hub" />
<input type="hidden" name="bl_fpo" id="bl_fpo" />
<input type="hidden" name="bl_mib" id="bl_mib" />
<input type="hidden" name="bl_ptt" id="bl_ptt" />
<input type="hidden" name="bl_ftz" id="bl_ftz" />
<input type="hidden" name="bl_div" id="bl_div" />
<input type="hidden" name="div_cd" id="div_cd" />
<input type="hidden" name="div_ind" id="div_ind" />
<%if(!mainPage.equals("true")){%>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Manifest Details by B/L</span></h2>
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_del" id="btn_del" type="button">Delete</button><!--
		--><button class="btn_normal" name="btn_reactivate" id="btn_reactivate" type="button">Reactivate</button><!--
		--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button><!--
		--><span id="btn_div_dp"><button class="btn_normal" name="btn_div" id="btn_div" type="button">DIV</button></span><!--
		--><button class="btn_normal" name="btn_view" id="btn_view" type="button">View Receive File</button><!--
		--><button class="btn_normal" name="btn_transmit" id="btn_transmit" type="button">Transmit AI</button><!--
		--><button class="btn_normal" name="btn_trans_ptt" id="btn_trans_ptt" type="button">Transmit PTT</button><!--
		--><button class="btn_normal" name="btn_trans_isf" id="btn_trans_isf" type="button">Transmit ISF</button>
		<%--=JSPUtil.getCodeCombo("sel_isf_act_cd", "", "", "CD20041", 0, "")--%>
		<!-- <select name="sel_isf_act_cd">
			<option value="A">A:Add</option>
			<option value="D">D:Delete</option>
			<option value="R">R:Replace</option>
		</select>
		 -->
		<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
</div>
<%}else{%>
<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_del" id="btn_del" type="button">Delete</button><!--
		--><button class="btn_normal" name="btn_reactivate" id="btn_reactivate" type="button">Reactivate</button><!--
		--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button><!--
		--><span id="btn_div_dp"><button class="btn_normal" name="btn_div" id="btn_div" type="button">DIV</button></span><!--
		--><button class="btn_normal" name="btn_view" id="btn_view" type="button">View Receive File</button><!--
		--><button class="btn_normal" name="btn_transmit" id="btn_transmit" type="button">Transmit AI</button><!--
		--><button class="btn_normal" name="btn_trans_ptt" id="btn_trans_ptt" type="button">Transmit PTT</button><!--
		--><button class="btn_normal" name="btn_trans_isf" id="btn_trans_isf" type="button">Transmit ISF</button>
		<%--=JSPUtil.getCodeCombo("sel_isf_act_cd", "", "", "CD20041", 0, "")--%>
		<!-- <select name="sel_isf_act_cd">
			<option value="A">A:Add</option>
			<option value="D">D:Delete</option>
			<option value="R">R:Replace</option>
		</select>
		 -->
		</div>
		<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">
	<!-- location 내용 동적생성 (별도 코딩 불필요) -->
	<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<%}%>

<%if(!mainPage.equals("true")){%><div class="layer_popup_contents" style="margin-bottom:-100px;"><%}%>
<!-- Wrap_Search_area(S) -->
<div class="wrap_search_tab">
		<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50px">
				<col width="120px">
				<col width="50px">
				<col width="50px">
				<col width="30px">
				<col width="100px">
				<col width="130px">
				<col width="50px">
				<col width="50px">
				<col width="30px">
				<col width="30px">
				<col width="30px">
				<col width="30px">
				<col width="30px">
				<col width="30px">
				<col width="30px">
				<col width="30px">
				<col width="50px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>B/L No.</th>
					<td><input type="text" name="bl_nos" id="bl_nos" style="width:115px; ime-mode: disabled;" class="input1" dataformat="engup" maxlength="13" required caption="B/L No." value="<%=StringUtil.xssFilter(strBlNo)%>">&nbsp;
					<th>Filer</th>
					<td><input type="text" name="cstms_file_tp_cd" style="width:25px;text-align:center;" readonly class="input2" id="cstms_file_tp_cd" /> </td>
					<td><span id="mf_sts_cd"></span><input type="hidden" name="mf_sts_code" id="mf_sts_code" /></td>
					<th>Entry Type&nbsp;</th>
					<td><script type="text/javascript">ComComboObject('combo_t_cd', 1, 100, 1, 0, 0);</script></td>
					<td>Empty&nbsp;<input type="checkbox" name="full_mty_chk" class="trans" disabled="" id="full_mty_chk" /> </td>
					<th>Stage</th>
					<td><input type="text" name="cstms_mf_tp_cd" style="width:30px;text-align:center;text-indent:0px" readonly class="input2" id="cstms_mf_tp_cd" /> </td>
					<th>ISF</th>
					<td><input type="text" name="isf_act_cd" style="width:20px;" readonly class="input2" id="isf_act_cd" /> </td>
					<th>F</th>
					<td><input type="text" name="frt_clt_flg" style="width:20px;" readonly class="input2" id="frt_clt_flg" /> </td>
					<th>O</th>
					<td><input type="text" name="obl_rdem_flg" style="width:20px;" readonly class="input2" id="obl_rdem_flg" /> </td>
					<th>C</th>
					<td width=""><script type="text/javascript">ComComboObject('combo_c_cd', 2, 40, 1, 0);</script>&nbsp;<span id="cgor_team_cd"></span></td>
					<td></td>
				</tr>
				<tr>
					<th>M.B/L</th>
					<td><input type="text" name="mbl_no" style="width:115px;" class="input2" readonly id="mbl_no" /></td>
					<th>T.BDR</th>
					<td><input type="text" name="trnk_bdr_flg" style="width:25px;text-align:center;" readonly class="input2" id="trnk_bdr_flg" /> </td>
					<td></td>
					<th>Original File No.</th>
					<td colspan="13"><input type="text" name="pre_mf_no" id="pre_mf_no" style="width:100px;" class="input" dataformat="eng" maxlength="12"></td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<table>
			<colgroup>
				<col width="50px">
				<col width="125px">
				<col width="55px">
				<col width="50px">
				<col width="57px">
				<col width="38px">
				<col width="55px">
				<col width="50px">
				<col width="55px">
				<col width="50px">
				<col width="110px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd" style="width:115px; ime-mode: disabled" readonly class="input2" dataformat="engup" maxlength="9" fullfill="" caption="VVD" value="<%=strVvd%>" id="vvd" />  <input type="hidden" name="vsl_eng_nm" style="width:120px;" readonly class="input2" id="vsl_eng_nm" /> </td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol_cd" style="width:50px; ime-mode: disabled" readonly class="input2" dataformat="engup" maxlength="5" fullfill="" caption="POL" id="pol_cd" /> </td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod_cd" style="width:50px; ime-mode: disabled" readonly class="input2" dataformat="engup" maxlength="5" fullfill="" caption="POD" value="<%=strPod%>" id="pod_cd" /> </td>
					<th>ETA</th>
					<td><input type="text" name="vps_eta_dt2" style="width:130px; ime-mode: disabled" readonly class="input2" value="<%=strEta%>" id="vps_eta_dt2" /> </td>
					<th title="Place of Delivery">DEL</th>
					<td> <input type="text" name="del_cd" style="width:60px; ime-mode: disabled" readonly class="input2" dataformat="engup" maxlength="5" fullfill="" caption="DEL" id="del_cd" /> </td>
					<th title="Place of Delivery">Customs Loc</td>
					<td> <input type="text" name="cstms_loc_cd" style="width:60px; ime-mode: disabled" readonly class="input2" dataformat="engup" maxlength="5" fullfill="" caption="Customs Loc" id="cstms_loc_cd" /> </td>
					<th>HUB</th>
					<td><input type="text" name="hub_loc_cd" style="width:55px; ime-mode: disabled" readonly class="input2" dataformat="engup" maxlength="5" fullfill="" caption="HUB" id="hub_loc_cd" /> </td>
					<th>L.USA</th>
					<td><input type="text" name="usa_lst_loc_cd" style="width:55px;  ime-mode: disabled" class="input" dataformat="engup" maxlength="5" fullfill="" caption="L.USA" id="usa_lst_loc_cd" /> </td>
					<th>F.POD</th>
					<td><input type="text" name="f_pod" style="width:55px;  ime-mode: disabled" class="input2" dataformat="engup" maxlength="5" fullfill="" caption="F.POD" id="f_pod" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="80">
				<col width="64">
				<col width="50px">
				<col width="58px">
				<col width="50px">
				<col width="40px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="50px">
				<col width="70px">
				<col width="80px">
				<col width="50px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Actual Filing VVD</th>
					<td><input type="text" name="act_file_vvd" style="width:62px; ime-mode: disabled;" class="input2" dataformat="eng" maxlength="9" caption="Actual Filing VVD" id="act_file_vvd" /> </td>
					<th>Customs</th>
					<td><input type="text" name="customs" style="width:50px; ime-mode: disabled" readonly class="input2" dataformat="eng" maxlength="5" fullfill="" caption="Customs" id="customs" /> </td>
					<th>P/MIB No</th>
					<td><input type="text" name="ibd_trsp_no" style="width:130px;" readonly class="input2" dataformat="eng" maxlength="17" caption="P/MIB No." id="ibd_trsp_no" /> </td>
					<th>Type</th>
					<td><input type="text" name="ibd_tp_cd" style="width:55px;" readonly class="input2" id="ibd_tp_cd" /> </td>
					<th>R/D Term</th>
					<td><input type="text" name="rcv_term_cd" style="width:20px;text-align:center;" readonly class="input2" id="rcv_term_cd" /><!--
					   --><input type="text" name="de_term_cd" style="width:20px;text-align:center;" readonly class="input2" id="de_term_cd" /> </td>
					<th>FTZ</th>
					<td>
						<script type="text/javascript">ComComboObject('free_trd_zn_flg', 1, 40, 1, 3);</script>
					</td>
					<th>PTT Firms Code</th>
					<td width="">
						<input type="text" name="ptt_frm_cd" style="width:55px;" class="input" id="ptt_frm_cd" maxlength="4" dataformat="engup"/>
					</td>
					<td  style="padding-right:9px"><div class="opus_design_btn"><button class="btn_etc" name="btn_edit" id="btn_edit" type="button">Edit</button></div></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="50px">
				<col width="130px">
				<col width="50px">
				<col width="50px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr >
					<th>Q'ty</th>
					<td><input type="text" name="pck_qty" style="width:70px;text-align:right;direction:rtl;" class="input" dataformat="num" maxlength="7" caption="Q'ty" id="pck_qty" /><!--
					  --><input type="text" name="ams_pck_tp_cd" style="width:42px;text-align:center;" class="input" dataformat="eng" maxlength="3" caption="Q'ty Code" id="ams_pck_tp_cd" /></td>
					<th>WGT</th>
					<td><input type="text" name="cgo_wgt" style="width:105px;text-align:right;direction:rtl;" class="input" dataformat="float" maxlength="15" caption="WGT" id="cgo_wgt" />
						<!-- <input type="text" name="wgt_ut_cd" style="width:38px;text-align:center;" class="input" dataformat="eng" maxlength="3" caption="WGT Code" id="wgt_ut_cd" /> -->
						<script language="javascript">ComComboObject('wgt_ut_cd', 1, 60, 1, 3);</script>
					</td>
					<td style="text-align: right"><div>
		<button class="btn_normal" name="btn_customer" id="btn_customer" type="button">Customer Master</button><!--
		--><button class="btn_normal" name="btn_container" id="btn_container" type="button">Container</button><!--
		--><button class="btn_normal" name="btn_cm" id="btn_cm" type="button">C/M</button><!--
		--><button class="btn_normal" name="btn_blcharge" id="btn_blcharge" type="button">B/L Charge</button><!--
	--></div></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>

	<!-- opus_design_btn (S) -->

	<!-- opus_design_btn (E) -->
</div>
<!-- Wrap_Search_area(E) -->

<!-- Tab ) (S) -->
<div class="wrap_result">
		<div class="opus_design_tab sm">
		<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		<!-- iFrame (S) -->
		<div id="tabLayer" style="display:none">
		<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="470" src="about:blank"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
		<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="410" src="about:blank"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
		<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="410" src="about:blank"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
		<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="410" src="about:blank"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
		<iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="410" src="about:blank"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
		<iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="410" src="about:blank"></iframe>
		</div>
		<div id="tabLayer" style="display:none">
		<iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="410" src="about:blank"></iframe>
		</div>
		<!-- iFrame (E) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t0sheet1');</script>
		</div>
</div>
<!-- Tab ) (E) -->
<%if(!mainPage.equals("true")){	%></div><%}%>
</form>
</body>