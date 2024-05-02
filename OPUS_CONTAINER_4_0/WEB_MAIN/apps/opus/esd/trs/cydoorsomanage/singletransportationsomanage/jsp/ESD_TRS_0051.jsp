<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0051.jsp
*@FileTitle  : CY & Door 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
--%>
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
	String selCOSTMODE = "";
	String selTRANSMODE = "";
	String selMVMTSTS = "";
	String optionStr = "000020:ALL:ALL";
	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		selBOUND  = JSPUtil.getCodeCombo("sel_bound", "01", "style='width:70'", "CD00591", 0, optionStr);
		selCOSTMODE  = JSPUtil.getCodeCombo("sel_costmode", "01", "style='width:140'", "CD00594", 0, optionStr);
		selTRANSMODE  = JSPUtil.getCodeCombo("sel_transmode", "01", "style='width:70'", "CD00283", 0, optionStr);
		selMVMTSTS  = JSPUtil.getCodeCombo("cnmv_sts_cd", "01", "style='width:60'", "CD00252", 0, "000020::");

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
		} // end if
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="hid_frmdate" value="" id="hid_frmdate" />
<input type="hidden" name="hid_todate" value="" id="hid_todate" />
<input type="hidden" name="hid_bkg" value="" id="hid_bkg" />
<input type="hidden" name="cbstatus" value="" id="cbstatus" />
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

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_minimize"  		id="btn_minimize">Minimize</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(ES) -->
</div>
<!-- page_title_area(E) -->
<div id="MiniLayer" style="display:inline">
	<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="120"/>
						<col width="80"/>
						<col width="140"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Work Order Issued</th>
						<td class="sm pad_left_8"><input type="radio" name="rad_wo_issued" class="trans" value="NO" onclick="fun_wosoChange('NO')" checked id="rad_wo_issued" /><label for = "rad_wo_issued">No</label><!--   
												 --><input type="radio" name="rad_wo_issued" value="YES" class="trans" onclick="fun_wosoChange('YES')" id="rad_wo_issued1" /><label for = "rad_wo_issued1">Yes</label></td>
						<th>Service Provider</th>
						<td colspan="10"><input name="combo_svc_provider" type="text" style="width:85px;" value="" maxlength="6" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)'  id="combo_svc_provider" dataformat="num"/><!--							
							--><input type="text" name="svc_provider" style="width:474px;" class="input2" value="" readonly id="svc_provider" /><button type="button" class="input_seach_btn" name="btns_vender" id="btns_vender"></button></td>
					</tr>
				</tbody>
			</table>
						
			<table>
				<tbody>
					<colgroup>
						<col width="120"/>
						<col width="300"/>
						<col width="130"/>
						<col width="*"/>
				    </colgroup>
					<tr><td colspan="4"></td></tr>	
					<tr>
						<th>Date</th>
						<td class="sm pad_left_8"><input type="radio" name="rad_dateSep" class="trans" value="P" checked onclick="javascript:fun_datesep('P');" id="rad_dateSep" /><label for = "rad_dateSep">Planned Departure </label><input type="radio" name="rad_dateSep" value="D" class="trans" onclick="javascript:fun_datesep('D');" id="rad_dateSep1" /><label for = "rad_dateSep1">Door Arrival</label>  <input type="radio" name="rad_dateSep" value="S" class="trans" onclick="javascript:fun_datesep('S');" id="rad_dateSep2" /><label for = "rad_dateSep2">Service Order Created</label>  <input type="radio" name="rad_dateSep" value="W" class="trans" disabled onclick="javascript:fun_datesep('W');" id="rad_dateSep3" /><label for = "rad_dateSep3">Work Order Issue</label></td>
						<td class="sm pad_left_8"><input name="frm_plandate" type="text" style="width:80px;" value="" maxlength="8" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this); getDateBetween(this);" id="frm_plandate" dataformat="ymd" />~ <input name="to_plandate" type="text" style="width:80px;" value="" maxlength="8" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);" onkeyup="javascript:doSearchEnter();" id="to_plandate" dataformat="ymd" /><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			
			<table>
				<tbody>	
					<colgroup>
						<col width="120"/>
						<col width="160"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Bound</th>
						<td><%=selBOUND%></td>
						<th>Cost Mode</th>
						<td><%=selCOSTMODE%></td>
						<th>Trans Mode</th>
						<td><%=selTRANSMODE%></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th>From</th>
						<td>
						    <input name="search_fm_loc" type="text" style="width:70px;" maxlength="5" onchange="getComboList(this, search_fm_yard, 'F');"  id="search_fm_loc" dataformat="engup" /><!--
						 --><script type="text/javascript">ComComboObject('search_fm_yard', 1, 43, 0)</script><!-- 
						 --><button type="button" class="input_seach_btn" name="btns_frmnode" id="btns_frmnode"></button>
						    <input name="search_fm_node" type="text" style="width:107px;" onchange="resetLocYard('FROM');" onblur="" id="search_fm_node"  dataformat="engup" otherchar=", "/><button type="button" id="btns_multi_search_fm_node" name="btns_multi_search_fm_node" class="multiple_inq ir"></button>
						</td>
						<th>Via</th>
						<td><input name="search_via_loc" type="text" style="width:90px;" maxlength="5" onchange="getComboList(this, search_via_yard, 'V');"  id="search_via_loc" dataformat="engup" /><!--
							--><script type="text/javascript">ComComboObject('search_via_yard', 1, 40, 0)</script><!-- 
							 --><button type="button" class="input_seach_btn" name="btns_vianode" id="btns_vianode"></button></td>
						<th>To</th>
						<td colspan="2">
						    <input name="search_to_loc" type="text" style="width:77px;" maxlength="5" onchange="getComboList(this, search_to_yard, 'T');"  id="search_to_loc"  dataformat="engup" /><!--
						 --><script type="text/javascript">ComComboObject('search_to_yard', 1, 40, 0)</script><!-- 
						 --><button type="button" class="input_seach_btn" name="btns_tonode" id="btns_tonode"></button>
						    <input name="search_to_node" type="text" style="width:107px;" onchange="resetLocYard('TO');" onblur="" id="search_to_node"  dataformat="engup" otherchar=", "/><button type="button" id="btns_multi_search_to_node" name="btns_multi_search_to_node" class="multiple_inq ir"></button>
						</td>
						<th>Door</th>
						<td><input name="search_door_loc" type="text" style="width:57px;" maxlength="5" onchange="getComboList(this, search_door_yard, 'D');"  id="search_door_loc" dataformat="engup" /><!--
							--><script type="text/javascript">ComComboObject('search_door_yard', 1, 40, 0)</script><!--
							 --><button type="button" class="input_seach_btn" name="btns_dorloc" id="btns_dorloc"></button><!--
							--><input name="zip_code" type="text" style="width:52px;" onchange="" onblur="" id="zip_code" dataformat="engup"  otherchar=", "/><!-- 
							 --><button type="button" id="btns_multizipcode" name="btns_multizipcode" class="multiple_inq ir"></button></td>
					</tr>
					<tr class="line_bluedot" style="height:15px"><td colspan="9"></td></tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="120"/>
						<col width="130"/>
						<col width="104"/>
						<col width="130"/>
						<col width="86"/>
						<col width="100"/>
						<col width="104"/>
						<col width="130"/>
						<col width="90"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>T.VVD</th>
						<td><input name="trunk_vvd" type="text" style="width:71px;" value="" onkeyup="javascript:doSearchEnter();" onblur="setgetUpper(this);" id="trunk_vvd" dataformat="engup"  otherchar=","/><button type="button" id="btns_multivvd" name="btns_multivvd" class="multiple_inq ir"></button><button type="button" id="btns_tvvd" name="btns_tvvd" class="input_seach_btn"></button></td>
						<th>Booking No.</th>
						<td><input name="bkg_no" type="text" style="width:100px;" onkeyup="javascript:doSearchEnter();" onblur="setgetUpper(this);" id="bkg_no" dataformat="engup"  otherchar=","/><button type="button" id="btns_multibkg" name="btns_multibkg" class="multiple_inq ir"></button></td>
						<th>Bill Of Lading No.</th>
						<td><input name="bill_no" type="text" style="width:120px;" onkeyup="javascript:doSearchEnter();" onblur="setgetUpper(this);" id="bill_no" dataformat="engup"  otherchar=","/><button type="button" id="btns_multibl" name="btns_multibl" class="multiple_inq ir"></button></td>
						<th>Container No.</th>
						<td><input name="cntr_no" type="text" style="width:105px;" onkeyup="javascript:doSearchEnter();" onchange="javascript:this.value=multiCntrChkDgt(this.value);" onblur="setgetUpper(this);" id="cntr_no" dataformat="engup"  otherchar=","/><button type="button" id="btns_multicntr" name="btns_multicntr" class="multiple_inq ir"></button></td>
			            <th>Slot Ref No.</th>
			            <td>
			                <input id="cntr_slt_no" name="cntr_slt_no" type="text" style="width:100px;" dataformat="engup" otherchar=","><!-- 
			                --><button type="button" name="btns_cntr_slt_no" id="btns_cntr_slt_no" class="multiple_inq ir"></button>
			            </td>
					</tr>
					<tr>
						<th>Service Order No.</th>
						<td><input name="so_no" type="text" style="width:100px;" value="" onkeyup="javascript:doSearchEnter();" onblur="setgetUpper(this);" id="so_no" dataformat="engup"  otherchar=","/><button type="button" id="btns_multisono" name="btns_multisono" class="multiple_inq ir"></button></td>
						<th>Work Order No.</th>
						<td><input name="wo_no" type="text" style="width:100px;" onkeyup="javascript:doSearchEnter();" disabled onblur="setgetUpper(this);" id="wo_no" dataformat="engup"  otherchar=","/><button type="button" id="btns_multiwono" name="btns_multiwono" class="multiple_inq ir" disabled></button></td>
						<th>Port</th>
						<td colspan="3"> 
							<input type="radio" name="port_io" class="trans" value="A" checked id="port_io" onclick="port_io_click(this);" /><label for="port_io">All</label><input type="radio" name="port_io" class="trans" value="I" id="port_io" onclick="port_io_click(this);" /><label for="port_io">In</label><input type="radio" name="port_io" class="trans" value="O" id="port_io" onclick="port_io_click(this);" /><label for="port_io">Out</label>
						    <input name="port_cd" type="text" style="width:55px;" id="port_cd" dataformat="engup" maxlength="5" /><input name="port_nm" type="text" style="width:93px;" id="port_nm" readonly /><button type="button" id="btns_port" name="btns_port" class="input_seach_btn"></button></td>
						<th>Latest MVMT STS</th>
						<td><%=selMVMTSTS %></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
	
	<div class="opus_design_btn">
	<span id="id_woissue" style="display:inline"><!--
			--><button type="button" class="btn_normal" name="btng_offhireverify" 	id="btng_offhireverify">Off Hire Verify</button><!--
			--><button type="button" class="btn_normal" name="btng_sodelete" 	id="btng_sodelete">S/O Delete</button><!--
			--><button type="button" class="btn_normal" name="btng_containerselect" 	id="btng_containerselect">Container Select</button><!--
			--><button type="button" class="btn_normal" name="btng_multipleapply" 	id="btng_multipleapply">Multiple Apply</button><!--
			--><button type="button" class="btn_normal" name="btng_downexcel1" 	id="btng_downexcel1">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btng_socreation1" 	id="btng_socreation1">S/O Correction</button><!--
			--><button type="button" class="btn_normal" name="btng_woissue1" 	id="btng_woissue1">W/O Issue</button><!--
			--></span><span id="id_woissueno" style="display:none"><!--
			--><button type="button" class="btn_normal" name="btng_containerselect" 	id="btng_containerselect">Container Select</button><!--
			--><button type="button" class="btn_normal" name="btng_downexcel1" 	id="btng_downexcel1">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btng_socreation1" 	id="btng_socreation1">S/O Correction</button><!--
			--></span>
	</div>	
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->

<script type="text/javascript">ComSheetObject('sheet2');</script>

<script type="text/javascript">ComSheetObject('t4sheet1');</script>

<script type="text/javascript">ComSheetObject('rtnsheet');</script>
</form>


<form name='woForm' method='POST'>
	<input type="hidden" name="trsp_so_ofc_cty_cd" id="trsp_so_ofc_cty_cd" /><!--
	--><input type="hidden" name="trsp_so_seq" id="trsp_so_seq" /><!--
	--><input type="hidden" name="eq_mode" id="eq_mode" /><!--
	--><input type="hidden" name="sysCommUiTitle" value="Issue" id="sysCommUiTitle" /><!--
	--><input type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order" id="sysCommUiNavigation" /><!--
	--><input type="hidden" name="pgmNo" value="" id="pgmNo" /><!--
	--><input type="hidden" name="parentPgmNo" value="">
</form>
