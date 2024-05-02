<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0028.jsp
*@FileTitle  : USA 404 EDI Status Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event"%>
<%
	SignOnUserAccount account = null;
	EsdTrs0028Event  event = null;
	Exception serverException   = null;			
	String strErrMsg = "";						
	String today = DateTime.getFormatDate(DateTime.getFormatString("yyyyMMdd"), "yyyyMMdd", "yyyy-MM-dd");
	String beforeOneMonth = DateTime.getFormatDate(DateTime.addDays(DateTime.getFormatString("yyyyMMdd"), -30), "yyyyMMdd", "yyyy-MM-dd");
	String selStatus = "";
	String selEdiKind = "";
	String selFullEmpty = "";
	String selBnd = "";
	String selLimInq = "";
	String userId  = "";
	String optionStr = "000020:ALL:ALL";
	String selThrough = ""; //Through
	
	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		selStatus = JSPUtil.getCodeCombo("sel_status", "C", "style=width:142px", "CD00908", 0, optionStr);
		selEdiKind = JSPUtil.getCodeCombo("sel_edi_kind", "01", "style=width:142px", "CD00868", 0, optionStr);
		selFullEmpty = JSPUtil.getCodeCombo("sel_full_empty", "01", "style=width:148px", "CD00136", 0, optionStr);
		selBnd = JSPUtil.getCodeCombo("sel_bnd", "01", "style=width:56", "CD00592", 0, optionStr);
		selLimInq = JSPUtil.getCodeCombo("sel_Limit_inq", "01", "style=width:173", "CD00922", 0, optionStr);
		selThrough = JSPUtil.getCodeCombo("rad_through", "01", "style=width:79 onChange= 'onChange_through(this);'", "CD00934", 0, optionStr);
		
		event = (EsdTrs0028Event)request.getAttribute("Event");
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
<script type="text/javascript">
	<%=JSPUtil.getIBCodeCombo("auto_xpt_sys_cd", "01", "CD00850", 0, "")%>
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="hid_frmdate" value="" id="hid_frmdate" />
<input type="hidden" name="hid_todate" value="" id="hid_todate" />
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>" id="ctrl_ofc_cd" />
<input type="hidden" name="user_id" value="<%=account.getUsr_id()%>" id="user_id" />
<input type="hidden" name="hid_rad_date" id="hid_rad_date" />
<input type="hidden" name="hid_rad_vendor" id="hid_rad_vendor" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
<!-- page_title(S) -->
<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
<div class="opus_design_btn">
	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
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
 	<!-- wrap_search(S) -->  
	<div class="wrap_search">
	<!-- opus_design_inquiry (S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80">
				<col width="220">
				<col width="120">
				<col width="200">
				<col width="120">
				<col width="200">
				<col width="120">
				<col width="*">
			</colgroup>
			<tbody>
			<tr>
				<th>Date</th>
				<td class="sm pad_left_4"><input type="radio" class="trans" name="rad_date" id="rad_date2" value="DS" checked><label for="rad_date2">Service Order Create</label><!--  
					--><input type="radio" class="trans" name="rad_date" value="DB" id="rad_date1"><label for="rad_date1">EDI Send</label></td>
				<td></td>
				<td class="sm"><input name="frm_plandate" type="text" class="input1" style="width:75px" value="<%=beforeOneMonth%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);  getDateBetween(this);">~&nbsp;<!-- 
				   --><input name="to_plandate" type="text" class="input1" style="width:75px" value="<%=today%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();"><!-- 
				   --><button type="button" name="btns_calendar" id="btns_calendar"  class="calendar ir"></button></td>
				<th>Through</th>
				<td><%=selThrough%></td>
				<th>Unplanned</th>
				<td><select name = "unplanned">	<!-- 
			     --><option  value="ALL"> ALL</option><!-- 
			     --><option  value="Y"> Y</option><!-- 
			     --><option  value="N"> N</option><!-- 
			     --></select>
			     </td>
			     <td><input type="checkbox" name="edi_history" id="edi_history" value="H" class="trans"><label for="edi_history">Incl. Historical Data</label></td>
			</tr>
			<tr>
				<th>Status</th>
				<td><%=selStatus%></td>
				<th>Full / Empty</th>
				<td><%=selFullEmpty%></td>
				<th>Bound</th>
				<td><%=selBnd%></td>
				<th>Booking Attached</th>
				<td><select name="sel_Bkgatch" style="width:51px;"><!-- 
				 --><option value="ALL" selected>ALL</option><!-- 
				 --><option value="Y">Y</option><!-- 
				 --><option value="N">N</option><!-- 
				 --></select></td>
			</tr>
			<tr>
				<th>Rail Origin</th>
				<td><input name="frm_node" type="text" style="width:43px;" maxlength="5" onChange="getComboList(this, frm_yard, 'F');" dataformat="engup"><!-- 
				 --><script type="text/javascript">ComComboObject('frm_yard', 1, 66, 0)</script><!-- 
				 --><button type="button" name="btns_frmnode" id="btns_frmnode"  class="input_seach_btn"></button></td>				
				<th>Rail Destination</th>
				<td><input name="to_node" type="text" style="width:45px;" maxlength="5" onChange="getComboList(this, to_yard, 'T');" dataformat="engup"><!-- 
				 --><script type="text/javascript">ComComboObject('to_yard', 1, 70, 0)</script><!-- 
				 --><button type="button" name="btns_tonode" id="btns_tonode"  class="input_seach_btn"></button></td>
				<th>Limit of Inquiry</th>
				<td><%=selLimInq%></td>
				<th>Reference No</th>
				<td><input name="ref_no" id="ref_no" type="text" style="width:133px;" dataformat="engup" otherchar="," onKeyup="javascript:doSearchEnter();" onChange="javascript:this.value=cntrCheckDigit(this.value);"><!-- 
				 --><button type="button" name="btns_multirefno" id="btns_multirefno"  class="multiple_inq ir"></button>
				</td>
			</tr>
			<tr>
				<th>EDI Kind</th>
				<td><%=selEdiKind%> </td>
				<th>POD</th>
				<td><input id="pod_cd"  	name="pod_cd" 	  type="text" style="width:57px;" maxlength="5" dataformat="engup" /><!--  
				 --><input id="pod_nod_cd"  name="pod_nod_cd" type="text" style="width:30px;" maxlength="2"  dataformat="engup" /><!--  
				 --><button type="button" class="input_seach_btn" name="btn_pod" id="btn_pod"></button>
				 </td>
				<th>Service Provider</th>				
                <td colspan="3">
	                <input type="radio" class="trans" name="rad_vendor" value="V1" onClick="javascript:do_railroad('W');" checked><label for="rad_vendor">Rail Road</label><!-- 
	             --><input type="radio" class="trans" name="rad_vendor" value="V2" onClick="javascript:do_railroad('R');"><label for="rad_vendor">WRS</label>
                	<div id="SV" style="display:none"><!-- 
                 	--><input name="combo_svc_provider" type="text" style="width:90px;" value="" maxlength="6" onBlur="vendor_blur();"><!-- 
                 	--><input type="text" name="trsp_so_vndr_no" style="width:175px;" readonly value="" class="input2"><!-- 
                 	--><button type="button" name="btns_vendor" id="btns_vendor"  class="input_seach_btn"></button>                   						
					</div>
					<div id="SV" style="display:inline;text-align: left;" ><!-- 
					 --><script type="text/javascript">ComComboObject('sel_railroad',2, 90 , 1 )</script><!-- 
					 --><input name="rail_road_name" type="text" style="width:205px;" readonly class="input2" id="rail_road_name" />
					</div>
				</td>
			</tr>
			<tr>
				<th>T.VVD</th>
				<td><input name="trunk_vvd" id="trunk_vvd" type="text" style="width:84px" onKeyup="javascript:doSearchEnter();" dataformat="engup" otherchar=","><!-- 
				 --><button type="button" name="btns_multivvd" id="btns_multivvd"  class="multiple_inq ir"></button><!-- 
				 --><button type="button" name="btns_tvvd" id="btns_tvvd"  class="input_seach_btn"></button></td>				
				<th>Booking No.</th>
				<td><input name="bkg_no"  id="bkg_no" type="text" style="width:92px;" onKeyup="javascript:doSearchEnter();" dataformat="engup" otherchar=","><!-- 
				 --><button type="button" name="btns_multibkg" id="btns_multibkg"  class="multiple_inq ir"></button></td>				
				<th>B/L No.</th>
				<td><input name="bill_no" id="bill_no" type="text" style="width:120px;" onKeyup="javascript:doSearchEnter();" dataformat="engup" otherchar=","><!-- 
				 --><button type="button" name="btns_multibl" id="btns_multibl"  class="multiple_inq ir"></button></td>	
				<th>Container No.</th>
				<td><input name="cntr_no" id="cntr_no" type="text" style="width:133px;" dataformat="engup" otherchar="," onKeyup="javascript:doSearchEnter();" onChange="javascript:this.value=cntrCheckDigit(this.value);"><!-- 
				 --><button type="button" name="btns_multicntr" id="btns_multicntr"  class="multiple_inq ir"></button></td>
			</tr>
		</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry (E) -->
	</div>
	<!-- wrap_search(E) -->   	 	
 </div>

<!-- wrap_result(S) -->  
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		<!-- Content -->
			<button type="button" class="btn_normal" name="btng_cancellationedisend" id="btng_cancellationedisend">Cancellation EDI Send</button><!-- 
			 --><button type="button" class="btn_normal" name="btng_404edisend" id="btng_404edisend">404 EDI Send</button><!-- 
			 --><button type="button" class="btn_normal" name="btng_rebill" id="btng_rebill">Rebill</button><!-- 
			 --><button type="button" class="btn_normal" name="btng" id="btng">Rail Yard EDI Info Creation&amp;Correction</button><!-- 
			 --><button type="button" class="btn_normal" name="btng_frustrate" id="btng_frustrate">Frustrate</button><!-- 
			 --><button type="button" class="btn_normal" name="btng_confirmationmsg" id="btng_confirmationmsg">Confirmation MSG Send</button><!-- 
			 --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>			 			 
		</div>
		<!-- opus_design_btn(e) -->
		
		<script type="text/javascript">ComSheetObject('sheet');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->  
	


</form>
<script type="text/javascript">
	document.form.combo_svc_provider.style.visibility = "hidden";
	document.form.trsp_so_vndr_no.style.visibility = "hidden";
	document.form.btns_vender.style.visibility = "hidden";
</script>