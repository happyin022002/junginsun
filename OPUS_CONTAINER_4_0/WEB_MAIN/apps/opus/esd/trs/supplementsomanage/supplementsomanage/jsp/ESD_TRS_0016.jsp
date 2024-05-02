﻿<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0016.jsp
*@FileTitle  : Service Order Creation -Supplement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.event.EsdTrs0016Event"%>

<%
	EsdTrs0016Event  			event 			= null;	
	Exception 					serverException	= null;		
	DBRowSet 					rowSet	  		= null;
	String 						strErrMsg 		= "";		
	int 						rowCount	 	= 0;		
	String today 		= DateTime.getFormatString("yyyyMMdd");
	String userId  		= "";
	String selCOSTMODE 	= "";
	String selTRANSMODE = "";
	String selBOUND 	= "";
	String optionStr 	= "000020:ALL:ALL";
	String eq_ctrl 		= "";
	String eq_ctrl_1 	= "";

	String selCntrSize = "";

	selBOUND  			= JSPUtil.getCodeCombo("sel_boundmode"	, "01"	, " onChange='bound_OnChange_1(this);' style='width:70'"	, "CD00591", 0, optionStr);
	selCOSTMODE  		= JSPUtil.getCodeCombo("sel_costmode"	, "01"	, " onChange='bound_OnChange_2(this);' style='width:140'"	, "CD00744", 0, optionStr);
	selTRANSMODE  		= JSPUtil.getCodeCombo("sel_transmode"	, "01"	, " onChange='bound_OnChange_3(this);' style='width:70'"	, "CD00283", 0, optionStr);
    selCntrSize  = JSPUtil.getCodeCombo("cntr_size", "01", "style=width:60", "CD00937", 0, optionStr);
	try {
	   	SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId						= account.getUsr_id();
	   	eq_ctrl						= account.getOfc_cd();
	   	eq_ctrl_1					= eq_ctrl.substring(0, 3);
		event = (EsdTrs0016Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">

	<%= JSPUtil.getIBCodeCombo("way_type", "", "CD00929", 0, "")		%>
	<%=	BizComUtil.getIBCodeCombo("curr_cd", "01", "CURR", 1, " |")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>


<form  method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="form_cre_usr_id" value="<%=userId%>" id="form_cre_usr_id" />
<input type="hidden" name="form_usr_ofc_cd" value="<%=eq_ctrl%>" id="form_usr_ofc_cd" />
<input type="hidden" name="cre_ofc_cd" value="<%=eq_ctrl%>" id="cre_ofc_cd" />
<input type="hidden" name="cre_ofc_cd_1" value="<%=eq_ctrl_1%>" id="cre_ofc_cd_1" />
<input type="hidden" name="cre_usr_id" value="<%=userId%>" id="cre_usr_id" />
<input type="hidden" name="cre_dt_val" value="<%=today%>" id="cre_dt_val" />
<input type="hidden" name="upd_usr_id" value="<%=userId%>" id="upd_usr_id" />
<input type="hidden" name="upd_dt" value="<%=today%>" id="upd_dt" />
<input type="hidden" name="hid_kind" value="AS" id="hid_kind" />
<input type="hidden" name="hid_eq_radio" value="U" id="hid_eq_radio" />
<input type="hidden" name="hid_boundmode" id="hid_boundmode" />
<input type="hidden" name="hid_costmode" id="hid_costmode" />
<input type="hidden" name="hid_transmode" id="hid_transmode" />
<input type="hidden" name="hid_provider" id="hid_provider" />
<input type="hidden" name="hid_from_node" id="hid_from_node" />
<input type="hidden" name="hid_via_node" id="hid_via_node" />
<input type="hidden" name="hid_to_node" id="hid_to_node" />
<input type="hidden" name="hid_dor_node" id="hid_dor_node" />
<input type="hidden" name="hid_from_date" id="hid_from_date" />
<input type="hidden" name="hid_to_date" id="hid_to_date" />
<input type="hidden" name="hid_period" id="hid_period" />
<input type="hidden" name="hid_tp_sz" id="hid_tp_sz" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_reset" 			id="btn_reset">Reset</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_minimize" 			id="btn_minimize">Minimize</button>				
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class="wrap_search" id="MiniLayer" name="MiniLayer">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100"/>
				<col width="200"/>
				<col width="*"/>							
		   	</colgroup> 
			<!-- <tr>
				<th>Kind</th>
				<td><input name="btns_radio_kind" type="radio" value="A" class="trans" onclick="change_val();" checked id="btns_radio_kind" /> For Additional Surcharge <input name="btns_radio_kind" type="radio" value="B" class="trans" onclick="change_val();" id="btns_radio_kind" /> For Retroactive Rate</td>
				<td></td>
			</tr> -->
		</table>
		<table>
			<colgroup>
				<col width="100"/>
				<col width="420"/>
				<col width="102"/>				
				<col width="*"/>							
		   	</colgroup>
			<tr>
				<th>Date</th>
				<td>
					<SELECT style="width:132px" name = "sel_period" id = "sel_period">
						<option  value="S">S/O Creation</option>
						<option  value="W">W/O Issue</option>
						<option  value="I">Invoice Confirm</option>
						<option  value="P">Planned Departure</option>	
						<option  value="D">Door Arrival</option></SELECT><!-- 
					 --><input name="from_date" type="text" style="width:70px;"id="from_date" maxlength="8" dataformat="ymd" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this); getDateBetween(this);" />~ <!-- 
					 --><input name="to_date" type="text" style="width:70px;" id="to_date" maxlength="8"  dataformat="ymd" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" /><!-- 
					 --><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button>
				</td>
				<th>Service Provider</th>
				<td><input type="text" name="combo_svc_provider" style="width:100px;" onchange="getTextVendorSeq(sheetObjects[0], document.form, this.value)" onkeyup="enterCheck(this)" id="combo_svc_provider"  dataformat="engup"/><input name="svc_provider" type="text" style="width:183px;" value="" readonly class="input2" title="This inputbox cant't write" id="svc_provider" /><button type="button" class="input_seach_btn" name='btng_provider' id='btng_provider'></button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100"/>
				<col width="150"/>
				<col width="100"/>
				<col width="198"/>
				<col width="50"/>
				<col width="*"/>							
		   	</colgroup>
			<tr>
				<th>Bound</th>
				<td><%=selBOUND%></td>
				<th>Cost Mode</th>
				<td><%=selCOSTMODE%></td>
				<th>Trans Mode</th>
				<td><%=selTRANSMODE%></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="222"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="*"/>							
		   	</colgroup>
			<tr>
				<th>From</th>
				<td><input name="search_fm_loc" type="text" style="width:70px;" maxlength="5" onfocus="fun_Focus(this)" onchange="getComboList(this, search_fm_yard, 'F');" onblur="" id="search_fm_loc"  dataformat="engup"/><script type="text/javascript">ComComboObject('search_fm_yard', 1, 40, 0)</script><button type="button" name="btns_frmnode" id="btns_frmnode" class="input_seach_btn"></button></td>
				<th>Via</th>
				<td><input name="search_via_loc" type="text" style="width:70px;" maxlength="5" onfocus="fun_Focus(this)" onchange="getComboList(this, form.search_via_yard, 'V');" onblur="" id="search_via_loc" dataformat="engup" /><script type="text/javascript">ComComboObject('search_via_yard', 1, 43, 0)</script><button type="button" name="btns_vianode" id="btns_vianode" class="input_seach_btn"></button></td>
				<th>To</th>
				<td><input name="search_to_loc" type="text" style="width:70px;" maxlength="5" onfocus="fun_Focus(this)" onchange="getComboList(this, form.search_to_yard, 'T');" onblur="" id="search_to_loc"  dataformat="engup"/><script type="text/javascript">ComComboObject('search_to_yard', 1, 48, 0)</script><button type="button" name="btns_tonode" id="btns_tonode" class="input_seach_btn"></button></td>
				<th>Door</th>
				<td><input name="search_door_loc" type="text" style="width:70px;" maxlength="5" onfocus="fun_Focus(this)" onchange="getComboList(this, form.search_door_yard, 'D');" onblur="" id="search_door_loc"  dataformat="engup"/><script type="text/javascript">ComComboObject('search_door_yard', 1, 45, 0)</script><button type="button" name="btns_dorloc" id="btns_dorloc" class="input_seach_btn"></button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="222"/>
				<col width="50"/>
				<col width="*"/>							
		   	</colgroup>
			<tr>
				<th>T. VVD</th>
				<td><input name="vvdnumber" type="text" style="width:114px;" onchange="setgetUpper(this)" id="vvdnumber"  dataformat="engup" otherchar=","/><button type="button" class="multiple_inq ir" onclick="so_OnPopupClick('VVD', 'T.VVD');"></button></td>
				<th>Booking No.</th>
				<td><input name="bkgnumber" type="text" style="width:117px;" onfocus="fun_Focus(this)" onchange="setgetUpper(this)" id="bkgnumber"  dataformat="engup" otherchar=","/><button type="button" class="multiple_inq ir" onclick="so_OnPopupClick('BKG','BKG No.');"></button></td>
				<th>B/L No.</th>
				<td><input name="blnumber" type="text" style="width:122px;" onfocus="fun_Focus(this)" id="blnumber"  dataformat="engup" otherchar=","/><button type="button" class="multiple_inq ir" onclick="so_OnPopupClick('BL','BL No.');"></button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100"/>
				<col width="250"/>
				<col width="100"/>
				<col width="120"/>
				<col width="120"/>
				<col width="50"/>
				<col width="*"/>							
		   	</colgroup>
			<tr>
				<th>Equipment No.</th>			
				<td  class="pad_4 sm"><input name="btns_radio_eq" type="radio" value="A" class="trans" onclick="change_eq_val();checkDigit();" checked id="btns_radio_eq" /> Container  <input name="btns_radio_eq" type="radio" value="B" class="trans" onclick="change_eq_val();" id="btns_radio_eq" /> Chassis  <input name="btns_radio_eq" type="radio" value="C" class="trans" onclick="change_eq_val();" id="btns_radio_eq" /> Genset</td>
				<td><input name="eqnumber" type="text" style="width:117px;" onfocus="fun_Focus(this)" onchange="checkDigit(this);" id="eqnumber"  dataformat="engup" otherchar=","/><button type="button" id="btn_eq_no" name="btn_eq_no" class="multiple_inq ir"></button></td>
	           	<th>Type / Size</th>
				<td><SELECT name="tp_sz" id="tp_sz" style="width:70px;"><OPTION Value="ALL">ALL</option></Select></td>
				<th>Reference No.</th>
				<td><input name="refnumber" type="text" style="width:100px;" onchange="setgetUpper(this)" id="refnumber"  dataformat="engup"/></td>
	
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100"/>
				<col width="100"/>
				<col width="99"/>
				<col width="198"/>
				<col width="75"/>
				<col width="*"/>							
	   		</colgroup>
			<tr>
				<th>Service Order No.</th>
				<td><input name="sonumber" type="text" style="width:108px;" onfocus="fun_Focus(this)" onchange="setgetUpper(this)" id="sonumber"  dataformat="engup" otherchar=","/><button type="button" class="multiple_inq ir" onclick="so_OnPopupClick('SO','S/O No.');"></button></td>
				<th>Work Order No.</th>
				<td><input name="wonumber" type="text" style="width:117px;" onfocus="fun_Focus(this)" onchange="setgetUpper(this)" id="wonumber" dataformat="engup" otherchar="," /><button type="button" class="multiple_inq ir" onclick="so_OnPopupClick('WO','W/O No.');"></button></td>
				<th>Invoice No.</th>
				<td><input name="invnumber" type="text" style="width:93px;" id="invnumber" dataformat="engupetc" /><button type="button" class="multiple_inq ir" onclick="so_OnPopupClick('INV','Invoice No.');"></button>
			</tr>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
		<button class="btn_accent" type="button"  id="btng_surchargeapply" name="btng_surchargeapply">Surcharge Apply</button><!--
		--><button class="btn_normal" type="button" id="btng_downexcel" name="btng_downexcel">Down Excel</button><!--
		--><button class="btn_normal" type="button" id="btng_socreation" name="btng_socreation">S/O Creation</button><!--
		--><button class="btn_normal" type="button"  id="btng_woissue" name="btng_woissue">W/O Issue</button>
		</div>
		<!-- opus_design_btn (E) -->
		 <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid"><script type="text/javascript">ComSheetObject('sheet2');</script></div>
	<div class="opus_design_grid"><script type="text/javascript">ComSheetObject('sheet3');</script></div>
</div>

</form>

<form name='woForm' method='POST'>
	<input type='hidden' name='trsp_so_ofc_cty_cd'>
	<input type='hidden' name='trsp_so_seq'>
	<input type='hidden' name='eq_mode'>
	<input type="hidden" name="sysCommUiTitle" value="Issue">
	<input type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
	<input type="hidden" name="pgmNo" value="">
	<input type="hidden" name="parentPgmNo" value="">
</form>

<form NAME='scgForm' method='POST'>
<input type="hidden" name="unique_cd" id="unique_cd" />
<input type="hidden" name="open_mode" id="open_mode" />
<input type="hidden" name="step_cd" id="step_cd" />
<input type="hidden" name="main_row" id="main_row" />
<input type="hidden" name="sheet_arr_no" id="sheet_arr_no" />
<input type="hidden" name="ofc_cty_cd" id="ofc_cty_cd" />
<input type="hidden" name="so_seq" id="so_seq" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="cgo_tp_cd" id="cgo_tp_cd" />
<input type="hidden" name="multi_ofc_cty_cd" id="multi_ofc_cty_cd" />
<input type="hidden" name="multi_so_seq" id="multi_so_seq" />
<input type="hidden" name="multi_cgo_tp_cd" id="multi_cgo_tp_cd" />
<input type="hidden" name="check_row" id="check_row" />
<input type="hidden" name="scg_ind_cd" id="scg_ind_cd" />
</form>