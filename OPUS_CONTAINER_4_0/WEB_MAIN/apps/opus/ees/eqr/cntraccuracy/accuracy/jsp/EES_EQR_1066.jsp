<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1066.jsp
*@FileTitle  : Loading Trend by Lane
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.event.EesEqr1066Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1066ConditionVO"%>


<%
	EesEqr1066Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		event = (EesEqr1066Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		EesEqr1066ConditionVO conditionVO = new EesEqr1066ConditionVO();
		conditionVO = event.getEesEqr1066ConditionVO();
		
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
<script type="text/javascript">
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
<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd">
	<input type="hidden" name="cntr_tpsz_cd"  id="cntr_tpsz_cd" 	value="">
	<input type="hidden" name="h_ofc_tp_cd"  id="h_ofc_tp_cd" 	value="<%=strOfcTpCd%>">	
	<input type="hidden" name="h_ofc_cd" id="h_ofc_cd" 		value="<%=strOfc_cd%>">	
	<input type="hidden" name="h_eta_fm_dt" id="h_eta_fm_dt" 	value="<%=strEtaFmDt%>">	
	<input type="hidden" name="h_eta_to_dt" id="h_eta_to_dt" 	value="<%=strEtaToDt%>">
	<input type="hidden" name="h_fm_wk" id="h_fm_wk" 		value="<%=strFmWk%>">
	<input type="hidden" name="h_to_wk"  id="h_to_wk" 		value="<%=strToWk%>">
	<input type="hidden" name="h_rcc_cd" id="h_rcc_cd" 		value="<%=strRccCd%>">
	<input type="hidden" name="usr_id" id="usr_id" 			value="<%=strUsr_id%>">
	
	<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
	
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
	            <col width="95">
	            <col width="190">
	            <col width="105">
	            <col width="200">
	            <col width="70">
	            <col width="50">
	            <col width="50">
	            <col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th><input type="radio" name="dt_tp_cd" id="dt_tp_cd" class="trans" value="W" OnClick="chg_dt_tp();" checked>&nbsp;Week</th>
					<td>
						<input type="text" name="fm_wk" id="fm_wk" class="input" style="width:80px" dataformat="yw" maxlength="6" onFocus="form_focus();"  onBlur="form_blur();">~ <!--  
						 --><input type="text" name="to_wk" id="to_wk" class="input" style="width:80px" dataformat="yw" maxlength="6" onFocus="form_focus();"  onBlur="form_blur();" >
					</td>
					<th>Trade</th>
					<td>
						<script type="text/javascript">ComComboObject("trade", 2, 200, 0, 0);</script>
					</td>
					<th>Sub Trade</th>
					<td>
						<script type="text/javascript">ComComboObject("subtrade", 4, 97, 0, 0);</script>
					</td>
					<th>Lane</th>
					<td>
						<script type="text/javascript">ComComboObject("lane", 4,188, 0, 0);</script>
					</td>
				</tr>
			</tbody>
		</table>
		
		<table>
			<colgroup>
	            <col width="95">
	            <col width="200">
	            <col width="85">
	            <col width="200">
	            <col width="50">
	            <col width="100">
	            <col width="50">
	            <col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th><input type="radio" name="dt_tp_cd"  id="dt_tp_cd" class="trans" value="D"  OnClick="chg_dt_tp();">&nbsp;ETA Date</th>
					<td>
						<input type="text" name="eta_fm_dt" id="eta_fm_dt" class="input" style="width:80px" dataformat="ymd" maxlength="8" onFocus="form_focus();"  onBlur="form_blur();" >~ <!--  
						 --><input type="text" name="eta_to_dt" id="eta_to_dt" class="input" style="width:80px" dataformat="ymd" maxlength="8" onFocus="form_focus();"  onBlur="form_blur();" ><!-- 
						 --><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button>
					</td>
					<th>POL Location</th>
					<td>
						<select class="input" name="rcc_cd" id="rcc_cd" onChange="change_rcc()">
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
						--><input type="text" class="input" name="loc_cd" id="loc_cd" dataformat="engup" size="5" maxlength="5" fulfill size="5" onBlur="form_blur();"  style="width:53px;" value="" ><!-- 
						--><button type="button" class="input_seach_btn"  name="btn_loc_cd" id="btn_loc_cd" ></button>
					</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td>
						<input type="text" name="vvd_cd" id="vvd_cd" class="input" style="width:95px"  maxlength="9" onFocus="form_focus();"  onChange="form_blur();" >
					</td>
					<th>TP/SZ</th>
					<td><%= tyszSelectBox %><!-- 
						 --><script type="text/javascript">ComComboObject('tpsztype' , 1, 100, 1 )</script>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
	            <col width="90">
	            <col width="60">
	            <col width="90">
	            <col width="75">
	            <col width="95">
             	<col width="150">
	            <col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Data Selection :</th>
					<th><input type="checkbox" name="wgt"  id="wgt" class="trans" onClick="form_data_selection();" checked>&nbsp;Weight</th>
					<th><input type="checkbox" name="pln" id="pln" class="trans" onClick="form_data_selection();" checked>&nbsp;MT Plan(A)</th>
					<th><input type="checkbox" name="dif" id="dif" class="trans" onClick="form_data_selection();" checked>&nbsp;Diff(A-B)</th>
					<th><input type="checkbox" name="bkg" id="bkg" class="trans" onClick="form_data_selection();" checked>&nbsp;Full Booking</th>
					<th><input type="checkbox" name="avg" id="avg" class="trans" onClick="form_data_selection();" checked>&nbsp;Average Performace</th>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		 <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>