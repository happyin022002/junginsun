<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1025.jsp
*@FileTitle  : Loading Trend by Lane
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================*/
%>     
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.event.EesEqr1025Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1025ConditionVO"%>


<%
	EesEqr1025Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						//DB ResultSet 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd 		= "";
	String strEtaFmDt 		= "";
	String strEtaToDt 		= "";
	String strFmWk 			= "";
	String strToWk 			= "";
	String strRccCd 		= "";
	String strOfcTpCd 		= "";
	String optionStr 		= "000001: :ALL|000002:N:NONE";
	String mainPage 		= "";  //GUIDELINE CREATION/INQUERY TRUE : GUIDELINE CREATION, FALSE : GUIDELINE INQUERY

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesEqr1025Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		EesEqr1025ConditionVO conditionVO = new EesEqr1025ConditionVO();
		conditionVO = event.getEesEqr1025ConditionVO();
		
		strEtaFmDt 	= conditionVO.getEtaFmDt();
		strEtaToDt 	= conditionVO.getEtaToDt();
		strFmWk 	= conditionVO.getFmWk();
		strToWk 	= conditionVO.getToWk();
		strRccCd 	= conditionVO.getRccCd();
		strOfcTpCd  = conditionVO.getOfcTpCd();
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}

	// TP/SZ Select 
	String tyszSelectBox = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:82;'","CD00263",0,optionStr);
	// Location Type Code Select 
	String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd","","onChange='javascript:locTpcdChange(document.form.loc_tp_cd.options[document.form.loc_tp_cd.selectedIndex].value)' ","CD03052",0,"000001: :ALL");

%>
<script language="javascript">

    var tpszallText = "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszallCode = "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszdryText = "D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode = "D2|D4|D5|D7";
    var tpszrfrText = "R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode = "R2|R5|R9";
    var tpszotText  = "O2|O4|O5|S2|S4"; // OT  TYPE SIZE CD00753
    var tpszotCode  = "O2|O4|O5|S2|S4";
    var tpszfrText  = "F2|F4|F5|A2|A4"; // FR  TYPE SIZE CD00754
    var tpszfrCode  = "F2|F4|F5|A2|A4";	
	
    var consTpsz      = "D2,D4,D5,D7,R2,R5,R9,O2,O4,O5,S2,S4,F2,F4,F5,A2,A4";
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = "D2,D4,D5,D7";
    var consTpszRfr   = "R2,R5,R9";
    var consTpszOt    = "O2,O4,O5,S2,S4";
    var consTpszFr    = "F2,F4,F5,A2,A4";


	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		
		parent.window.moveTo(0,0);
		var screen_width = window.screen.width
		var screen_height = (window.screen.height)-30;
		parent.window.resizeTo(screen_width,screen_height);
		
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cntr_tpsz_cd" 	value="">
<input type="hidden" name="h_ofc_tp_cd" 	value="<%=strOfcTpCd%>">	
<input type="hidden" name="h_ofc_cd" 		value="<%=strOfc_cd%>">	
<input type="hidden" name="h_eta_fm_dt" 	value="<%=strEtaFmDt%>">	
<input type="hidden" name="h_eta_to_dt" 	value="<%=strEtaToDt%>">
<input type="hidden" name="h_fm_wk" 		value="<%=strFmWk%>">
<input type="hidden" name="h_to_wk" 		value="<%=strToWk%>">
<input type="hidden" name="h_rcc_cd" 		value="<%=strRccCd%>">
<input type="hidden" name="usr_id" 			value="<%=strUsr_id%>">
	
<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table> 
			<tbody>
				<tr>
					<td width="15"></td>
					<td width="80" style="text-align:left">
						<input type="radio" id="dt_tp_cd_W" name="dt_tp_cd" value="W" OnClick="chg_dt_tp();" checked><label for="dt_tp_cd_W"><strong>Week</strong></label>
					</td>
					<td width="210">
						<input type="text" id="fm_wk" name="fm_wk" class="input" style="width:80px" dataformat="yw" maxlength="6" onFocus="form_focus();"  onBlur="form_blur();" onKeyPress= "form_keypress();"> 
						~ 
						<input type="text" id="to_wk" name="to_wk" class="input" style="width:80px" dataformat="yw" maxlength="6" onFocus="form_focus();"  onBlur="form_blur();" onKeyPress= "form_keypress();">
					</td>
					<th width="85">Trade</th>
					<td width="210">
						<script language="JavaScript">ComComboObject("trade", 2, 200, 0, 0);</script>
					</td>
					<th width="70">Sub Trade</th>
					<td width="105">
						<script language="JavaScript">ComComboObject("subtrade", 4, 97, 0, 0);</script>
					</td>
					<th width="40">Lane</th>
					<td>
						<script language="JavaScript">ComComboObject("lane", 4,188, 0, 0);</script>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="text-align:left">
						<input type="radio" id="dt_tp_cd_D" name="dt_tp_cd" value="D"  OnClick="chg_dt_tp();"><label for="dt_tp_cd_D"><strong>ETA Date</strong></label>
					</td>
					<td>
						<input type="text" id="eta_fm_dt" name="eta_fm_dt" class="input" style="width:80px" dataformat="ymd" maxlength="8" onFocus="form_focus();"  onBlur="form_blur();" onKeyPress= "form_keypress();"> 
						~ 
						<input type="text" id="eta_to_dt" name="eta_to_dt" class="input" style="width:80px" dataformat="ymd" maxlength="8" onFocus="form_focus();"  onBlur="form_blur();" onKeyPress= "form_keypress();"><!--
						--><button type="button" class="calendar" id="btns_calendar" name="btns_calendar" id="btns_calendar"></button>
					</td>
					<th>POL Location</th>
					<td>
						<select class="input" name="rcc_cd" onChange="change_rcc()">
							<option value="" selected>ALL</option>
							<option value="CNSHA">CNSHA</option>
							<option value="HKHKG">HKHKG</option>
							<option value="TWTPE">TWTPE</option>
							<option value="KRSEL">KRSEL</option>
							<option value="JPTYO">JPTYO</option>
							<option value="SGSIN">SGSIN</option>
							<option value="DEHAM">DEHAM</option>
							<option value="USNYC">USNYC</option>											
						</select><!--
						--><%= locSelectBox %><!--
						--><input type="text" class="input" id="loc_cd" name="loc_cd" dataformat="engup" size="5" maxlength="5" fulfill size="5" onBlur="form_blur();" style="width:53;" value="" ><!--
						--><button type="button" class="input_seach_btn" id="btn_loc_cd" name="btn_loc_cd" disabled></button>
					</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td>
						<input type="text" name="vvd_cd" class="input" style="width:95px"  maxlength="9" onFocus="form_focus();"  onChange="form_blur();" onKeyPress= "form_keypress();">
					</td>
					<th>TP/SZ</th>
					<td><%= tyszSelectBox %><!--
						--><script language="javascript">ComComboObject('tpsztype' , 1, 100, 1 )</script>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
					<th width="105">Data Selection :</th>
					<td> 
						<input type="checkbox" id="wgt" name="wgt" onClick="form_data_selection();" checked><label for="wgt">Weight</label><!--
						--><input type="checkbox" id="pln" name="pln" onClick="form_data_selection();" checked><label for="pln">MT Plan(A)</label><!--
						--><input type="checkbox" id="dif" name="dif" onClick="form_data_selection();" checked><label for="dif">Diff(A-B)</label><!--
						--><input type="checkbox" id="bkg" name="bkg" onClick="form_data_selection();" checked><label for="bkg">Full Booking</label><!--
						--><input type="checkbox" id="avg" name="avg" onClick="form_data_selection();" checked><label for="avg">Average Performance</label>
					</td>
				</tr>
	        </tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	

</form>