<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0927.jsp
*@FileTitle  : B/L Preview 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0927Event"%>
<%@ page import="org.apache.log4j.Logger"%>


<%
	EsmBkg0927Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLIssuance");
	String bkg_no = "";
	String bl_no = "";
	String bl_tp_cd = "";
	String manifest = "";
	String fax_no = "";
	String email = "";
	String form_level = "";
	String form_hiddeData = "";
	String form_corr_no = ""; // B/L history key
	String form_remark = ""; // Draft B/L의 Remark
	String bl_prn_chg_tp_cd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();
		event = (EsmBkg0927Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		bkg_no         = JSPUtil.getParameter(request,"bkg_no"        ,"" );
		bl_no          = JSPUtil.getParameter(request,"bl_no"         ,"" );
		bl_tp_cd       = JSPUtil.getParameter(request,"bl_tp_cd"      ,"" );
		manifest       = JSPUtil.getParameter(request,"form_manifest" ,"N");
		fax_no         = JSPUtil.getParameter(request,"fax_no"        ,"" );
		email          = JSPUtil.getParameter(request,"email"         ,"" );
		form_corr_no   = JSPUtil.getParameter(request,"form_corr_no"  ,"" );
		form_hiddeData = JSPUtil.getParameter(request,"form_hiddeData","N");
		form_remark    = JSPUtil.getParameter(request,"form_remark"   ,"" );  // JSPUtil.n2Br(str) JSPUtil.replace(form_remark, "\r\n", "|$$|")
		form_level     = JSPUtil.getParameter(request,"form_level"    ,"1");
		bl_tp_cd = !"W".equalsIgnoreCase(bl_tp_cd) && !"D".equalsIgnoreCase(bl_tp_cd) ? "" : bl_tp_cd;
		bl_prn_chg_tp_cd = (String)eventResponse.getETCData("bl_prn_chg_tp_cd");
		bl_prn_chg_tp_cd = "".equals(bl_prn_chg_tp_cd) ? "1" : bl_prn_chg_tp_cd;
		log.debug("----------------->3");
	} catch(Exception e) {	
		out.println(e.toString());
	}
%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if 
		
		$('<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_Print"  	id="btn_Print">Print</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_BlPrint" 	id="btn_BlPrint">B/L Print</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_Fax"		id="btn_Fax">Fax</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_Email"    id="btn_Email">E-mail</button>').appendTo("#btnArea");
        
        $('#btn_Email').after($('#btn_Close'));
		
        document.getElementById("title").innerHTML = "B/L Preview";
		
		loadPage();
	}
</script>


<form name="form" id="form"> 
    <input type="hidden" name="f_cmd" id="f_cmd"/>
    <input type="hidden" name="pagerows" id="pagerows">
    <input type="hidden" name="strOfc_cd" id="strOfc_cd" value="<%=strOfc_cd%>">
    <input type="hidden" name="strCnt_cd" id="strCnt_cd" value="<%=strCnt_cd%>">
    <input type="hidden" name="first_bkg_no" id="first_bkg_no" value="<%=bkg_no%>">
    <input type="hidden" name="first_bl_no" id="first_bl_no" value="<%=bl_no%>">
    <input type="hidden" name="strUsr_id" id="strUsr_id" value="<%=strUsr_id%>">
    <input type="hidden" name="manifest" id="manifest" value="<%=manifest%>">
    <input type="hidden" name="bl_tp_cd_param" id="bl_tp_cd_param" value="<%=bl_tp_cd%>">
    <input type="hidden" name="form_corr_no" id="form_corr_no" value="<%=form_corr_no%>">
    <input type="hidden" name="form_remark" id="form_remark" value="<%=form_remark%>">
    <input type="hidden" name="org_bkg_no" id="org_bkg_no" value="<%=bkg_no%>">
    <input type="hidden" name="bl_prn_chg_tp_cd" id="bl_prn_chg_tp_cd" value="<%=bl_prn_chg_tp_cd%>"/>

    <!-- B/L Type Start -->
    <input type="hidden" name="form_type" id="form_type" value="">
    <!-- B/L Type End -->

    <!-- Charge Type Start -->
    <!-- <input type="hidden" name="form_Rate" value="1"> -->
    <input type="hidden" name="form_level" id="form_level" value="<%=form_level%>">
    <!-- Charge Type End -->

    <!-- Container Type Start -->
    <input type="hidden" name="form_Cntr" id="form_Cntr" value="1">
    <!-- Container Type End -->

    <input type="hidden" name="fax_no" id="fax_no" value="<%=fax_no%>">
    <input type="hidden" name="email" id="email" value="<%=email%>">

	<!-- N/N signed copy flag -->
    <input type="hidden" name="bl_cpy_esig_flg" id="bl_cpy_esig_flg">

    <!-- RD Start -->
    <input type="hidden" name="zratio" id="zratio" value="">
    <!-- RD End -->

    <input type="hidden" name="eventSrc" id="eventSrc" value="onload">
    <!-- Pop up setting-->
    <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
    <!-- Pop up setting -->
    <%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
    <div class="wrap_search_tab">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
    <!-- search table(S) -->
    <table class="wInherit">
        <colgroup>
            <col width="40" />
            <col width="310" />
            <col width="85" />
            <col width="120" />
            <col width="50" />
            <col width="110" />
            <col />
        </colgroup>
        <tbody>
            <tr>
                <th scope="row" class="sm">Type</th>
                <td class="sm">
                    <input type="radio" name="bl_tp_cd" value="" id="bl_tp_cd_1"><!-- 
                 --><label for="bl_tp_cd_1">N/N Copy</label><!-- 
                 --><input type="radio" name="bl_tp_cd" value="W" id="bl_tp_cd_2"><!-- 
                 --><label for="bl_tp_cd_2">Waybill</label><!-- 
                 --><input type="radio" name="bl_tp_cd" value="D" id="bl_tp_cd_3"><!-- 
                 --><label for="bl_tp_cd_3">Draft B/L</label>
                </td>
                <th scope="row">Booking No.</th>
                <td><input type="text" name="bkg_no" id="bkg_no" style="width:110px;" value="<%=bkg_no%>" maxlength="13" dataformat="engup" /></td>
                <th scope="row">B/L No.</th>
                <td><input type="text" name="bl_no" id="bl_no" style="width:110px;" class="input" value="<%=bl_no%>" maxlength="13" dataformat="engup" /></td>
                <td>
                    <label for="hiddenData"><strong>Display Hidden Data</strong></label>
                    <input type="checkbox" name="hiddenData" id="hiddenData" value="Y" <%="Y".equalsIgnoreCase(form_hiddeData) ? " checked" : "" %> />
                </td>
            </tr>
            <tr>
                <th scope="row" class="sm">Print</th>
                <td class="sm pad_btm_8">
                    <input type="checkbox" name="bl_face" id="bl_face" value="Y" /><!-- 
                 --><label for="bl_face">B/L Face</label><!-- 
                 --><input type="checkbox" name="bl_rider" id="bl_rider" value="Y" /><!-- 
                 --><label for="bl_rider">Rider</label><!-- 
                 --><input type="checkbox" name="bl_houseD" id="bl_houseD" value="Y" /><!-- 
                 --><label for="bl_houseD">NVO H/B(D)</label><!-- 
                 --><input type="checkbox" name="bl_houseS" id="bl_houseS" value="Y" /><!-- 
                 --><label for="bl_houseS">NVO H/B(S)</label>
                </td>
                <th scope="row" class="sm">Charge</th>
                <td class="sm" colspan="4">
                <%--
                    <input type="radio" name="rdo_form_level" id="rdo_form_level1" value="1" <%="1".equalsIgnoreCase(form_level) ? "checked":""%> /><!-- 
                 --><label for="rdo_form_level1">All</label><!--
                 --><input type="radio" name="rdo_form_level" id="rdo_form_level2" value="5" <%="5".equalsIgnoreCase(form_level) ? "checked":""%> /><!--
                 --><label for="rdo_form_level2">Collect</label><!--
                 --><input type="radio" name="rdo_form_level" id="rdo_form_level3" value="4" <%="4".equalsIgnoreCase(form_level) ? "checked":""%> /><!--
                 --><label for="rdo_form_level3">Prepaid</label><!--
                 --><input type="radio" name="rdo_form_level" id="rdo_form_level4" value="6" <%="6".equalsIgnoreCase(form_level) ? "checked":""%> /><!--
                 --><label for="rdo_form_level4">No Charge</label><!--
                 --><input type="radio" name="rdo_form_level" id="rdo_form_level5" value="3" <%="3".equalsIgnoreCase(form_level) ? "checked":""%> /><!--
                 --><label for="rdo_form_level5">Freight As Arranged</label>
                --%>
                    <input type="radio" name="rdo_form_level" id="rdo_form_level1" value="1" <%="1".equalsIgnoreCase(bl_prn_chg_tp_cd) ? "checked":""%> /><!-- 
                 --><label for="rdo_form_level1">All</label><!--
                 --><input type="radio" name="rdo_form_level" id="rdo_form_level2" value="5" <%="5".equalsIgnoreCase(bl_prn_chg_tp_cd) ? "checked":""%> /><!--
                 --><label for="rdo_form_level2">Collect</label><!--
                 --><input type="radio" name="rdo_form_level" id="rdo_form_level3" value="4" <%="4".equalsIgnoreCase(bl_prn_chg_tp_cd) ? "checked":""%> /><!--
                 --><label for="rdo_form_level3">Prepaid</label><!--
                 --><input type="radio" name="rdo_form_level" id="rdo_form_level4" value="6" <%="6".equalsIgnoreCase(bl_prn_chg_tp_cd) ? "checked":""%> /><!--
                 --><label for="rdo_form_level4">No Charge</label><!--
                 --><input type="radio" name="rdo_form_level" id="rdo_form_level5" value="3" <%="3".equalsIgnoreCase(bl_prn_chg_tp_cd) ? "checked":""%> /><!--
                 --><label for="rdo_form_level5">Freight As Arranged</label>
                </td>
            </tr>
            <tr>
                <td colspan="7" class="align_right">
                    <img src="img/btns_plus.gif" name="btn_RD_ZoomOut" id="btn_RD_ZoomOut" style="width:18px;height:18px;cursor:pointer" />
					<img src="img/btns_minus.gif" name="btn_RD_ZoomIn" id="btn_RD_ZoomIn" style="width:18px;height:18px;cursor:pointer" />
                    <img src="img/btns_back_1.gif" name="btn_RD_FirstPage" id="btn_RD_FirstPage" style="width:18px;height:18px;cursor:pointer" />
                    <img src="img/btns_back.gif" name="btn_RD_PreviousPage" id="btn_RD_PreviousPage" style="width:18px;height:18px;cursor:pointer" />
                    <img src="img/btns_next.gif" name="btn_RD_NextPage" id="btn_RD_NextPage" style="width:18px;height:18px;cursor:pointer" />
                    <img src="img/btns_next_1.gif" name="btn_RD_LastPage" id="btn_RD_LastPage" style="width:18px;height:18px;cursor:pointer" />
                </td>
            </tr>
        </tbody>
    </table>
    <!-- search table(E) -->
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result" style="height:500px">
 <!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
	<!-- 	<script type="text/javascript">ComTabObject('tab1', null, 880, 25, true)</script> -->
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_tab(E) -->
	
     <!-- opus_design_RD(S) -->
	<div class="opus_design_grid" id="tabLayer"> 
		 <iframe id="rdframe1" name="rdframe1" width="875px" height="538px" src="COM_RD_FRAME_01.do"></iframe>
		 <iframe id="rdframe2" name="rdframe2" width="875px" height="538px" src="COM_RD_FRAME_02.do"></iframe>
		 <iframe id="rdframe3" name="rdframe3" width="875px" height="538px" src="COM_RD_FRAME_03.do"></iframe>
		 <iframe id="rdframe4" name="rdframe4" width="875px" height="538px" src="COM_RD_FRAME_04.do"></iframe>
		 <iframe id="rdframe5" name="rdframe5" class="hiddenFrame" width="875px" height="538px" src="COM_RD_FRAME_05.do"></iframe>
	</div>
    <!-- opus_design_RD(E) -->
	
	<!-- opus_design_grid(S) -->
	<div>	
		<div class="opus_design_grid" style="display:none;">
			<script type="text/javascript">ComSheetObject('sheet_search');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<%if(!mainPage.equals("true")){	%></div><%}%>

</form>

<form name="form2" id="form2">
<input type="hidden" name="bkg_no" id="bkg_no">
<input type="hidden" name="form_manifest" id="form_manifest">
<input type="hidden" name="form_hiddeData" id="form_hiddeData">
<input type="hidden" name="form_remark" id="form_remark">
<!-- HTML5 RD USER CHECK -->
<input type="hidden" name="html5_rd_flg" id="html5_rd_flg" /> 
</form>

<form name="form3" id="form3" method="post"><!-- 0221 팝업 -->
  <input type="hidden" name="pop_mode" id="pop_mode">
  <input type="hidden" name="display" id="display">
  <input type="hidden" name="func" id="func">
  <input type="hidden" name="row" id="row">
  <input type="hidden" name="col" id="col">
  <input type="hidden" name="sheetIdx" id="sheetIdx">
  <input type="hidden" name="bkg_no" id="bkg_no" value="<%=bkg_no%>">
  <input type="hidden" name="bl_no" id="bl_no" value="<%=bl_no%>">
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
  <input type="hidden" name="fax_no" id="fax_no">
  <input type="hidden" name="email" id="email">
  <input type="hidden" name="ui_id" id="ui_id">
  <input type="hidden" name="fax_email" id="fax_email">
  <input type="hidden" name="html5_rd_flg" id="html5_rd_flg">
</form>