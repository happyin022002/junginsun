<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1026.jsp
*@FileTitle  : Discharging Result
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
<%@ page import="com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.event.EesEqr1026Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1026ConditionVO"%>


<%
	EesEqr1026Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						//DB ResultSet 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd 		= "";
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

		event = (EesEqr1026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		EesEqr1026ConditionVO conditionVO = new EesEqr1026ConditionVO();
		conditionVO = event.getEesEqr1026ConditionVO();
		
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
	String tyszSelectBox = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:80px;'","CD00263",0,optionStr);
	// Location Type Code Select 
	String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd","","onChange='javascript:locTpcdChange(document.form.loc_tp_cd.options[document.form.loc_tp_cd.selectedIndex].value)' style='width:70px;'","CD03052",0,"000001: :ALL");

%>
<script  type="text/javascript">

    var tpszallText = "D2|D4|D5|D7|R2|R5|R9|O2|O4|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszallCode = "D2|D4|D5|D7|R2|R5|R9|O2|O4|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszdryText = "D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode = "D2|D4|D5|D7";
    var tpszrfrText = "R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode = "R2|R5|R9";
    var tpszotText  = "O2|O4|S2|S4"; // OT  TYPE SIZE CD00753
    var tpszotCode  = "O2|O4|S2|S4";
    var tpszfrText  = "F2|F4|F5|A2|A4"; // FR  TYPE SIZE CD00754
    var tpszfrCode  = "F2|F4|F5|A2|A4";	
	
    var consTpsz      = "D2,D4,D5,D7,R2,R5,R9,O2,O4,S2,S4,F2,F4,F5,A2,A4";
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = "D2,D4,D5,D7";
    var consTpszRfr   = "R2,R5,R9";
    var consTpszOt    = "O2,O4,S2,S4";
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
<input type="hidden" id="h_ofc_tp_cd" name="h_ofc_tp_cd" value="<%=strOfcTpCd%>">	
<input type="hidden" id="h_ofc_cd" name="h_ofc_cd" value="<%=strOfc_cd%>">	
<input type="hidden" id="h_fm_wk" name="h_fm_wk" value="<%=strFmWk%>">
<input type="hidden" id="h_to_wk" name="h_to_wk" value="<%=strToWk%>">
<input type="hidden" id="h_rcc_cd" name="h_rcc_cd" value="<%=strRccCd%>">
<input type="hidden" id="usr_id" name="usr_id" 	value="<%=strUsr_id%>">

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
					<th width="50">Week</th>
					<td width="150">
						<input type="text" id="fm_wk" name="fm_wk" class="input1" style="width:55px" dataformat="yw" maxlength="6" onFocus="form_focus();"  onBlur="form_blur();" onKeyPress= "form_keypress();"><!-- 
						-->~&nbsp;<input type="text" id="to_wk" name="to_wk" class="input1" style="width:55px" dataformat="yw" maxlength="6" onFocus="form_focus();"  onBlur="form_blur();" onKeyPress= "form_keypress();">
					</td>
					<th width="85">Trade</th>
					<td width="210">
						<script  type="text/javascript">ComComboObject("trade", 2, 210, 0, 0);</script>
					</td>
					<th width="70">Sub Trade</th>
					<td width="105">
						<script  type="text/javascript">ComComboObject("subtrade", 4, 200, 0, 0);</script>
					</td>
					<th width="40">Lane</th>
					<td>
						<script  type="text/javascript">ComComboObject("lane", 4, 200, 0, 0, 2);</script>
					</td>
				</tr>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td>
						<input type="text" id="vvd_cd" name="vvd_cd" class="input" style="width:125px"  maxlength="9" onFocus="form_focus();"  onblur="form_blur();"  dataformat="engup">
					</td>
					<th>POD Location</th>
					<td>
						<select class="input" id="rdd_cd" name="rcc_cd" disabled="disabled" onChange="change_rcc()">
							<option value="">ALL</option>
							<option value="CNSHA">CNSHA</option>
							<option value="HKHKG">HKHKG</option>
							<option value="TWTPE">TWTPE</option>
							<option value="KRSEL">KRSEL</option>
							<option value="JPTYO">JPTYO</option>
							<option value="SGSIN">SGSIN</option>
							<option value="DEHAM">DEHAM</option>
							<option value="USNYC" selected >USNYC</option>												
						</select><!--
						--><%= locSelectBox %><!--
						--><input type="text" class="input" id="loc_cd" name="loc_cd" dataformat="engup" size="5" maxlength="5" fulfill size="5" onBlur="form_blur();" style="width:57px;" value="" ><!--
						--><button type="button" class="input_seach_btn" id="btn_loc_cd" name="btn_loc_cd"></button>
					</td>
					<th>TP/SZ</th>
					<td colspan="2"><%= tyszSelectBox %><!--
						--><script  type="text/javascript">ComComboObject('tpsztype' , 1, 116, 1 )</script>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script  type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
				
</form>