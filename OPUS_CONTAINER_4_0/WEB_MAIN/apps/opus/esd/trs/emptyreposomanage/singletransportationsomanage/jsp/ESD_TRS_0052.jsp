﻿<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0052.js
*@FileTitle  : Empty Repo & EQ On/Off Hire
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.event.EsdTrs0012Event"%>

<%
	SignOnUserAccount account = null;
	EsdTrs0012Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;								  
	String selKIND = "";
	String selTRANSMODE = "";
	String optionStr = "000020:ALL:ALL";

	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.getFormatDate(DateTime.addDays(today, -15), "yyyyMMdd", "yyyy-MM-dd");
	String afterOneMonth = DateTime.getFormatDate(DateTime.addDays(today, 15), "yyyyMMdd", "yyyy-MM-dd");

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		selKIND  = JSPUtil.getCodeCombo("sel_kind", "01", "style='width:164'", "CD00812", 0, optionStr);
		selTRANSMODE  = JSPUtil.getCodeCombo("sel_transmode", "01", "style='width:164'", "CD00283", 0, optionStr);

		event = (EsdTrs0012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="cbstatus" id="cbstatus" />
<input type="hidden" name="hid_frmreqdate" id="hid_frmreqdate" />
<input type="hidden" name="hid_toreqdate" id="hid_toreqdate" />
<input type="hidden" name="hid_cntr_no" id="hid_cntr_no" />
<input type="hidden" name="hid_cntr_tpsz_cd" id="hid_cntr_tpsz_cd" />
<input type="hidden" name="frm_node_verify" id="frm_node_verify" />
<input type="hidden" name="eq_no_verify" id="eq_no_verify" />
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>" id="ctrl_ofc_cd" />
<input type="hidden" name="TRSP_SO_EQ_KIND" value="" id="TRSP_SO_EQ_KIND" />
<input type="hidden" name="page_type" value="U" id="page_type" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_new" 	 id="btn_new">New</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div id="MiniLayer" style="display:inline">
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry">
		<table>
			<colgroup>
				<col width="120"/>
				<col width="80"/>
				<col width="*"/>
		    </colgroup>
			<tr>
				<th>Work Order Issued</th>
				<td class="sm pad_left_4">
					<input type="radio" name="rad_wo_issued" class="trans" value="NO" onclick="fun_wosoChange('NO')" checked id="rad_wo_issued" /><label for = "rad_wo_issued">No</label>
					<input type="radio" name="rad_wo_issued" class="trans" value="YES" onclick="fun_wosoChange('YES')" id="rad_wo_issued1" /><label for = "rad_wo_issued1">Yes</label>
				</td>
				<td></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="120"/>
				<col width="255"/>
				<col width="82"/>
				<col width="82"/>
				<col width="*"/>
		    </colgroup>
			<tr>
				<th>Date</th>
				<td class="sm pad_left_4"><input type="radio" name="rad_date" class="trans" value="R" checked id="rad_date" />   Requested  <input type="radio" name="rad_date" value="S" class="trans" id="rad_date" />   Service Order Created  </td>
				<td class="sm pad_left_4"><input name="frm_reqdate" class="input1" type="text" style="width:75px;" value="<%=beforeOneMonth%>" maxlength="8" dataformat="ymd" onFocus="javascript:delHypen(this);" onblur="javascript:getHypen(this); getDateBetween(this);" id="frm_reqdate" /><!--  
				 --> ~ <!--
				  --><input name="to_reqdate" class="input1" type="text" style="width:74px;" value="<%=afterOneMonth%>" maxlength="8" dataformat="ymd" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onkeyup="javascript:doSearchEnter();" id="to_reqdate" /><!-- 
				 --><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
				<th>Kind</th>
				<td><%=selKIND%></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="120"/>
				<col width="100"/>
				<col width="90"/>
				<col width="188"/>
				<col width="95"/>
				<col width="*"/>
		    </colgroup>
			<tr>
				<th>From</th>
				<td>
				    <input name="frm_node" type="text" style="width:70px;" maxlength="5" onchange="getComboList(this, document.form.frm_yard, 'F');" onblur="setgetUpper(this);" id="frm_node" dataformat="engup" /><script type="text/javascript">ComComboObject('frm_yard', 1, 59, 0)</script><button type="button" class="input_seach_btn" name="btns_frmnode" id="btns_frmnode"></button>
				    <input name="search_fm_node" type="text" style="width:107px;" onchange="resetLocYard('FROM');" onblur="" id="search_fm_node"  dataformat="engup" otherchar=", "/><button type="button" id="btns_multi_search_fm_node" name="btns_multi_search_fm_node" class="multiple_inq ir"></button>
				</td>
				<th>To</th>
				<td>
					<input name="to_node" type="text" style="width:74px;" maxlength="5" onchange="getComboList(this, document.form.to_yard, 'T');" onblur="setgetUpper(this);" id="to_node" dataformat="engup" /><script type="text/javascript">ComComboObject('to_yard', 1, 60, 0);</script><button type="button" class="input_seach_btn" name="btns_tonode" id="btns_tonode"></button>
					<input name="search_to_node" type="text" style="width:107px;" onchange="resetLocYard('TO');" onblur="" id="search_to_node"  dataformat="engup" otherchar=", "/><button type="button" id="btns_multi_search_to_node" name="btns_multi_search_to_node" class="multiple_inq ir"></button>
				</td>
				<th>Trans Mode</th>
				<td><%=selTRANSMODE%></td>						
	  		</tr>
	  	</table>
	 	<div class="line_bluedot"></div>
	 	<table>
			<colgroup>
				<col width="120"/>
				<col width="100"/>
				<col width="95"/>
				<col width="100"/>
				<col width="108"/>
				<col width="*"/>
		    </colgroup>
		  	<tr>
				<th>Reference No.</th>
				<td><input type="text" style="width:133px;" value="" name="reference_no" onkeyup="javascript:doSearchEnter();" id="reference_no" dataformat="engup"  otherchar=","/><button type="button" id="btns_multirefno" name="btns_multirefno" class="multiple_inq ir"></button></td>
				<th>Booking No.</th>
				<td><input name="bkg_no" type="text" style="width:139px;" onkeyup="javascript:doSearchEnter();" onchange="checkDigit(this);" id="bkg_no" dataformat="engup"  otherchar=","/><button type="button" id="btns_multibkgno" name="btns_multibkgno" class="multiple_inq ir"></button></td>
				<th>Container No.</th>
				<td><input name="cntr_no" type="text" style="width:139px;" onkeyup="javascript:doSearchEnter();" onchange="checkDigit(this);" id="cntr_no" dataformat="engup"  otherchar=","/><button type="button" id="btns_multicntr" name="btns_multicntr" class="multiple_inq ir"></button></td>
			</tr>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
		<span id="id_woissue" style="display:inline"><!-- 
		--><button type="button" class="btn_normal" name="btng_sodelete" 	id="btng_sodelete">S/O Delete</button><!--
		--><button type="button" class="btn_normal" name="btng_downexcel1" 	id=btng_downexcel1>Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btng_fillincontainers" 	id="btng_fillincontainers">Fill in CNTR No.</button><!--
		--><button type="button" class="btn_normal" name="btng_verify" 	id=btng_verify>Verify</button><!--
		--><button type="button" class="btn_normal" name="btng_socreation1" 	id="btng_socreation1">S/O Correction</button><!--
		--><button type="button" class="btn_normal" name="btng_woissue1" 	id=btng_woissue1>W/O Issue</button>
		</span>
		<span id="id_woissueno" style="display:none"><!-- 
		--><button type="button" class="btn_normal" name="btng_downexcel1" 	id=btng_downexcel1>Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btng_fillincontainers" 	id="btng_fillincontainers">Fill in CNTR No.</button><!--
		--><button type="button" class="btn_normal" name="btng_verify" 	id=btng_verify>Verify</button><!--
		--><button type="button" class="btn_normal" name="btng_socreation1" 	id="btng_socreation1">S/O Correction</button>
		</span>
		</div>
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

<script type="text/javascript">ComSheetObject('sheet2');</script><!--W/O Issue-->
<script type="text/javascript">ComSheetObject('sheet3');</script><!-- CNTR verify  -->

</form>
<form name='woForm' method='POST'>
	<input type="hidden" name="trsp_so_ofc_cty_cd" id="trsp_so_ofc_cty_cd" />
	<input type="hidden" name="trsp_so_seq" id="trsp_so_seq" />
	<input type="hidden" name="eq_mode" id="eq_mode" />
	<input type="hidden" name="sysCommUiTitle" value="Issue" id="sysCommUiTitle" />
	<input type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order" id="sysCommUiNavigation" />
	<input type="hidden" name="pgmNo" value="ESD_TRS_0023" id="pgmNo" />
</form>
