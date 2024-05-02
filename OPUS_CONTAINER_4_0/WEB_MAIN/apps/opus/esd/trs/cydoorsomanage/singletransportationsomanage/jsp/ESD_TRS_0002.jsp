<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0002.jsp
*@FileTitle  : Service Order Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event"%>
<%
	SignOnUserAccount account = null; 
	EsdTrs0002Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	String selBOUND = "";
	String selTRANSMODE = ""; 
	String optionStr = "000020:ALL:ALL";
	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		selBOUND  = JSPUtil.getCodeCombo("sel_bound", "01", "style='width:60'", "CD00591", 0, optionStr);
		selTRANSMODE  = JSPUtil.getCodeCombo("sel_transmode", "01", "style='width:48'", "CD00283", 0, optionStr);
		event = (EsdTrs0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	<%=JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "01", "CD00283", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("dor_svc_tp_cd", "01", "CD00284", 0, "")%>
</script>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		loadPage();
	}
</script>


<form method="post" name="form" id="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="hid_frmdate" value="" id="hid_frmdate" />
<input type="hidden" name="hid_todate" value="" id="hid_todate" />
<input type="hidden" name="cbstatus" value="" id="cbstatus" />
<input type="hidden" name="old_ofc_cd" value="<%=account.getOfc_cd()%>" id="old_ofc_cd" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />

<input type="hidden" name="FM_LOC_CONTI_CD" value="" id="FM_LOC_CONTI_CD" />
<input type="hidden" name="BOUND_CD" value="" id="BOUND_CD" />
<input type="hidden" name="CNEE_CUST_CNT_CD" value="" id="CNEE_CUST_CNT_CD" />
<input type="hidden" name="CNEE_CUST_SEQ" value="" id="CNEE_CUST_SEQ" />
<input type="hidden" name="SHPR_CUST_CNT_CD" value="" id="SHPR_CUST_CNT_CD" />
<input type="hidden" name="SHPR_CUST_SEQ" value="" id="SHPR_CUST_SEQ" />
<input type="hidden" name="DOOR_NOD_CD" value="" id="DOOR_NOD_CD" />
<input type="hidden" name="TRSP_SO_EQ_KIND" value="" id="TRSP_SO_EQ_KIND" />
<input type="hidden" name="prnt_ofc_cd" value="" id="prnt_ofc_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<input name="ui_conti_cd" type="hidden" value="E">
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" id="btn_retrieve" name="btn_retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" id="btn_new" name="btn_new">New</button><!--
		--><button class="btn_normal" type="button" id="btn_minimize" name="btn_minimize">Minimize</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search" id="MiniLayer">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="150"/>
				<col width="50"/>
				<col width="100"/>
				<col width="80"/>
				<col width="*" />	
	   		</colgroup> 
	          <tr>
				<th>Date</th>
				<td class="sm pad_left_4"><input type="radio" name="rad_dateSep" id="rad_dateSep1" class="trans" value="P" checked>&nbsp;<label for="rad_dateSep1">Planned Departure</label>&nbsp;<input type="radio" name="rad_dateSep" id="rad_dateSep2" value="D" class="trans">&nbsp;<label for="rad_dateSep2">Door Arrival</label>&nbsp;<input type="radio" name="rad_dateSep" id="rad_dateSep3" value="R" class="trans">&nbsp;<label for="rad_dateSep3">Rail Creation</label></td>
				<td class="sm"><input id="frm_plandate" name="frm_plandate" type="text" class="input1" style="width:75px;" value="" maxlength="8" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this); getDateBetween(this);" dataformat="ymd"/><span class="dash">~</span><input id="to_plandate" name="to_plandate" type="text" class="input1" style="width:75px;" value="" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();" dataformat="ymd" ><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
			    <th>CY/Door</th>
			    <td><SELECT name = "cydoor_div" style='width:70px' onChange="getCostModeCombo(sel_costmode);" ><OPTION  value="CY">CY</OPTION><OPTION  value="DR">DOOR</OPTION></SELECT></td>
				<td><input type="checkbox" name="unplan_shuttle" value="" class="trans" onclick="javascript:fun_checkcbox('01');" id="unplan_shuttle" /><strong> <label for="unplan_shuttle">Unplanned</label></strong><!-- 
				 --><input type="checkbox" name="tro_unconfirm_dr" value="" class="trans" onclick="javascript:fun_checkcbox('03');" id="tro_unconfirm_dr" /><strong> <label for="tro_unconfirm_dr">Provision</label></strong>
				</td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="80"/>
				<col width="150"/>
				<col width="50"/>
				<col width="196"/>
				<col width="50"/>
				<col width="106"/>
				<col width="100"/>
				<col width="*" />				
	   		</colgroup> 
		    <tr>
				<th>Bound</th>
				<td><%=selBOUND%></td>
				<th>Cost Mode</th>
				<td><script type="text/javascript">ComComboObject('sel_costmode', 1, 138, 1)</script></td>
				<th>Trans Mode</th>
				<td><%=selTRANSMODE%></td>
				<th>Service Order Office </th>
				<td><input name="ctrl_so_office" id="ctrl_so_office" type="text" style="width:79px;" value="<%=account.getOfc_cd()%>" onchange="javascript:fun_officeText();" id="ctrl_so_office"  dataformat="engup"/><button type="button" id="btns_office" name="btns_office" class="input_seach_btn"></button> <input type="checkbox" name="chk_office" value="Y" class="trans" onclick="javascript:fun_chkOffice();" id="chk_office" /> Incl. Sub OFC</td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="180"/>
				<col width="100"/>
				<col width="130"/>
				<col width="50"/>
				<col width="156"/>
				<col width="50"/>
				<col width="100"/>
				<col width="130"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th>From</th>
				<td><input name="search_fm_loc" type="text" style="width:60px;" maxlength="5" dataformat="engup" onchange="getComboList(this, search_fm_yard, 'F');" id="search_fm_loc" /><script type="text/javascript">ComComboObject('search_fm_yard', 1, 45, 0)</script><button type="button" id="btns_frmnode" name="btns_frmnode" class="input_seach_btn"></button></td>
				<td><input name="search_fm_node" type="text" style="width:107px;" onchange="resetLocYard('FROM');" onblur="" id="search_fm_node"  dataformat="engup" otherchar=", "/><button type="button" id="btns_multi_search_fm_node" name="btns_multi_search_fm_node" class="multiple_inq ir"></button></td>
				<th>Via </th>
				<td><input name="search_via_loc" type="text" style="width:60px;" maxlength="5" dataformat="engup" onchange="getComboList(this, search_via_yard, 'V');" id="search_via_loc" /><script type="text/javascript">ComComboObject('search_via_yard', 1, 45, 0);</script><button type="button" id="btns_vianode" name="btns_vianode" class="input_seach_btn"></button></td>
				<th>To </th>
				<td><input name="search_to_loc" type="text" style="width:60px;" maxlength="5" dataformat="engup" onchange="getComboList(this, search_to_yard, 'T');" id="search_to_loc" /><script type="text/javascript">ComComboObject('search_to_yard', 1, 53, 0);</script><button type="button" id="btns_tonode" name="btns_tonode" class="input_seach_btn"></button></td>
				<td><input name="search_to_node" type="text" style="width:107px;" onchange="resetLocYard('TO');" onblur="" id="search_to_node"  dataformat="engup" otherchar=", "/><button type="button" id="btns_multi_search_to_node" name="btns_multi_search_to_node" class="multiple_inq ir"></button></td>
				<th>Door </th>
				<td><input name="search_door_loc" type="text" style="width:80px;" maxlength="5" dataformat="engup" onchange="getComboList(this, search_door_yard, 'D');" id="search_door_loc" /><script type="text/javascript">ComComboObject('search_door_yard', 1, 45, 0)</script><button type="button" id="btns_dorloc" name="btns_dorloc" class="input_seach_btn"></button><!-- 
				 --><input name="zip_code" type="text" style="width:107px;" id="zip_code"  dataformat="engup" otherchar=", "/><button type="button" id="btns_multizipcode" name="btns_multizipcode" class="multiple_inq ir"></button></td>
			</tr>
		</table>
	</div>
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="120"/>
				<col width="50"/>
				<col width="230"/>
				<col width="120"/>
				<col width="50"/>
				<col width="120"/>
				<col width="80"/>
				<col width="50"/>
				<col width="*" />
	   		</colgroup> 
			<tr>
				<th>T.VVD</th>
				<td><input name="trunk_vvd" type="text" style="width:84px;" value="" dataformat="engup" id="trunk_vvd"  otherchar=","/><button type="button" id="btns_multivvd" name="btns_multivvd" class="multiple_inq ir"></button><button type="button" id="btns_tvvd" name="btns_tvvd" class="input_seach_btn"></button></td>
				<th>F.VVD</th>						
				<td class="sm pad_left_4"><input type="radio" name="feeder_vvd" class="trans" value="A" checked id="feeder_vvd1" /><label for="feeder_vvd1"> All </label><input type="radio" name="feeder_vvd" class="trans" value="I" id="feeder_vvd2" /><label for="feeder_vvd2"> In VVD </label><input type="radio" name="feeder_vvd" class="trans" value="O" id="feeder_vvd3" /> <label for="feeder_vvd3">Out VVD</label> </td>
				<td><input name="txt_feeder_vvd" type="text" style="width:70px;" dataformat="engup" id="txt_feeder_vvd"  otherchar=","/><button type="button" id="btns_multifvvd" name="btns_multifvvd" class="multiple_inq ir"></button><button type="button" id="btns_fvvd" name="btns_fvvd" class="input_seach_btn"></button></td>					
				<th>Port</th>
				<td class="sm"><input type="radio" name="port_io" class="trans" value="A" checked id="port_io" onclick="port_io_click(this);" /><label for="port_io">All</label><input type="radio" name="port_io" class="trans" value="I" id="port_io" onclick="port_io_click(this);" /><label for="port_io">In</label><input type="radio" name="port_io" class="trans" value="O" id="port_io" onclick="port_io_click(this);" /><label for="port_io">Out</label></td>
				<td><input name="port_cd" type="text" style="width:55px;" id="port_cd" dataformat="engup" maxlength="5" /><input name="port_nm" type="text" style="width:93px;" id="port_nm" readonly /><button type="button" id="btns_port" name="btns_port" class="input_seach_btn"></button></td>
				<th>ECC</th>
                <td><input id = "ecc_cd" name = "ecc_cd" type = "text" class = "input" style="width:107px;" onchange="toUpperCase(this)" onfocus="fun_Focus(this)" onkeyup="toUpperCase(this)" maxlength="5" dataformat="engup" otherchar=","><button type="button" id="btns_multi_ecc_cd" name="btns_multi_ecc_cd" class="multiple_inq ir"></button><button type = "button" class = "input_seach_btn" id="btns_ecc_cd" name="btns_ecc_cd"></button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="80"/>
				<col width="155"/>
				<col width="50"/>
				<col width="138"/>
				<col width="85"/>
				<col width="160"/>
				<col width="50"/>
				<col width="100"/>
				<col width="100"/>
				<col width="90"/>
				<col width="*" />				
	   		</colgroup> 
			<tr>
				<th>Booking No.</th>
				<td><input name="bkg_no" type="text" value="" style="width:113px;" dataformat="engup" id="bkg_no"  otherchar=","/><button type="button" id="btns_multibkg" name="btns_multibkg" class="multiple_inq ir"></button></td>
				<th>B/L No. </th>
				<td><input name="bill_no" type="text" style="width:94px;" dataformat="engup" id="bill_no"  otherchar=","/><button type="button" id="btns_multibl" name="btns_multibl" class="multiple_inq ir"></button></td>
				<th>Container No.</th>
				<td><input name="cntr_no" type="text" style="width:98px;" dataformat="engup" onchange="javascript:this.value=multiCntrChkDgt(this.value);" id="cntr_no"  otherchar=","/><button type="button" id="btns_multicntr" name="btns_multicntr" class="multiple_inq ir"></button></td>
				<th>Contract No.</th>
				<td class="sm pad_left_4"><input type="radio" name="contract_tp_cd" id="contract_tp_cd1" class="trans" value="S" checked>&nbsp;<label for='contract_tp_cd1'>S/C</label>&nbsp;<input type="radio" name="contract_tp_cd" id="contract_tp_cd2" class="trans" value="R">&nbsp;<label for='contract_tp_cd2'>RFA</label>&nbsp;</td>
				<td class="sm"><input name="contract_no" type="text" style="width:107px;" dataformat="engup" id="contract_no" /><button type="button" id="btns_contract" name="btns_contract" class="input_seach_btn"></button></td>
				<th>EQ TP/SZ</th>
				<td><script type="text/javascript">ComComboObject("eq_tpsz_cd", 2, 60, 1, 0);</script>
				<input type="hidden" name="temp_eq_tpsz_cd" id="temp_eq_tpsz_cd">
				</td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
			<button class="btn_normal" type="button" id="btng_officetransfer" name="btng_officetransfer">Office Transfer</button><!--
			--><button class="btn_normal" type="button" id="btng_multipleapply" name="btng_multipleapply">Multiple Apply</button><!--
			--><button class="btn_normal" type="button" id="btng_downexcel1" name="btng_downexcel1">Down Excel</button><!--
			--><button class="btn_normal" type="button" id="btng_offhireverify" name="btng_offhireverify">Off Hire Verify</button><!--
			--><button class="btn_normal" type="button" id="btng_candidatedelete" name="btng_candidatedelete">Candidate Delete</button><!--
			--><button class="btn_normal" type="button" id="btng_socreation1" name="btng_socreation1">S/O Creation</button><!--
			--><button class="btn_normal" type="button" id="btng_woissue1" name="btng_woissue1">W/O Issue</button><!--
			--></div>
			<!-- opus_design_btn (E) -->
		 <script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		<script type="text/javascript">ComSheetObject('rtnsheet');</script>
	</div>
</div>
</form>
<form name='woForm' method='POST'>
	<input type='hidden' name='trsp_so_ofc_cty_cd'>
	<input type='hidden' name='trsp_so_seq'>
	<input type='hidden' name='eq_mode'>
	<input	type="hidden" name="sysCommUiTitle" value="Issue">
	<input	type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
	<input type="hidden" name="pgmNo" value="">
	<input type="hidden" name="parentPgmNo" value="">
</form>
