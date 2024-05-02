<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_0063.jsp
*@FileTitle  : CNTR repo execution feed back examine
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.event.EesEqr0063Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr0063Event  event = null;				    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			    //error from server
	String strErrMsg = "";							//error message
	int rowCount	 = 0;							//count of DB resultSET list

	try {
	 event = (EesEqr0063Event)request.getAttribute("Event");
	 serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

	String optionStr = "000000: :ALL";
	String fmType    = JSPUtil.getCodeCombo("fmType", "", "OnChange='displayType()' width='55'", "CD00242", 0, optionStr);
	String toType    = JSPUtil.getCodeCombo("toType", "", "OnChange='displayType()' width='55'", "CD00242", 0, optionStr);

	String fmTypeBy  = JSPUtil.getCodeCombo("fmTypeBy", "E", " style='width:80;'", "CD00265", 0, "");
	String toTypeBy  = JSPUtil.getCodeCombo("toTypeBy", "E", " style='width:80;'", "CD00265", 0, "");

	String item      = JSPUtil.getCodeCombo("item", "", "onChange='javascript:disPlayItem(document.form.item.options[document.form.item.selectedIndex].value)' style='width:90;'", "CD00253", 0, optionStr);

	//String tpsz      = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:54;'","CD00263",0,optionStr);
	String tpsz = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:54;'","CD01527",0,optionStr);
	CommonBC tpszUtil = new CommonBCImpl(); 	//Combo BOX

%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
<%//= JSPUtil.getIBCodeCombo("combo02", "01", "CD00830", 0, "")%> // tpsz ALL
<%//= JSPUtil.getIBCodeCombo("combo03", "01", "CD00751", 0, "")%> // DRY TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("combo04", "01", "CD00752", 0, "")%> // RFR TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("combo05", "01", "CD00828", 0, "")%> // OT  TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("combo06", "01", "CD00829", 0, "")%> // FR TYPE SIZE
<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszall", "", "", "", "", "")%>
<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszdry", "", "D", "", "", "")%>
<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszspc", "", "S", "", "", "")%>
<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszrb", "", "R", "", "", "")%>

<%= JSPUtil.getIBCodeCombo("reason",  "01", "CD00261", 0, "")%> // Reason TYPE

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script type="text/javascript">
   var gubun1 = "|"; // replace seperator
   var gubun2 = ",";
   // ------- type variable -------------- START
	var consTpsz      = replaceAll(tpszallText ,gubun1 , gubun2);
	var consTpszArr   = consTpsz.split(',');
	var consTpszDry   = replaceAll(tpszdryText ,gubun1 , gubun2);
	var consTpszSpc   = replaceAll(tpszspcText, gubun1, gubun2);
	var consTpszZrb   = replaceAll(tpszrbText, gubun1, gubun2);
	
	//var consTpszRfr   = replaceAll(combo04Code ,gubun1 , gubun2);
	//var consTpszOt    = replaceAll(combo05Code ,gubun1 , gubun2);
	//var consTpszFr    = replaceAll(combo06Code ,gubun1 , gubun2);
	// ------- type variable -------------- END
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<!-- headTitle for second sheet -->
<input type="hidden" name="headTitle" id="headTitle" />
<input type="hidden" name="oddtpsz" id="oddtpsz" />
<input type="hidden" name="adherenceNum" id="adherenceNum" />
<input type="hidden" name="woissuedNum" id="woissuedNum" />
<input type="hidden" name="perfRatioNum" id="perfRatioNum" />

<input type="hidden" name="gubun"  />        
<input type="hidden" name="gapmonth"  />     
<input type="hidden" name="editmonth"  />

<input type="hidden" name="fm_yrwk"  />   
<input type="hidden" name="to_yrwk"  />   
<input type="hidden" name="at_yrwk"  />        

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent"  name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
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
<div class= "wrap_search" id="zoomarea0">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
	            <col width="80">
	            <col width="640">
	            <col width="120">
	            <col width="*">
			</colgroup>
			<tbody>
				<tr>
						<th>From Location</th>
						<td>
							<%=fmType%><!-- 
							 --><input type="text" name="fmEccCd" id="fmEccCd" style="width:500px;ime-mode:disabled;" dataformat="engup" otherchar=","><!-- 
							 --><button type="button" class="input_seach_btn"  name="fmloc_btn"  id="fmloc_btn" ></button>
						<td><%=fmTypeBy %></td>
						<td>
							<input name="fmPlnSYr" id="fmPlnSYr" type="text" style="width:35px;ime-mode:disabled;" maxlength="4"  dataformat = "num"><!-- 
							 --><input name="fmPlnSWk" id="fmPlnSWk" type="text" style="width:23px;ime-mode:disabled;" maxlength="2"  dataformat = "num">~ <!--
                             --><input name="fmPlnEYr" id="fmPlnEYr" type="text" style="width:35px;ime-mode:disabled;" maxlength="4"  dataformat = "num"><!--
							 --><input name="fmPlnEWk" id="fmPlnEWk" type="text" style="width:23px;ime-mode:disabled;" maxlength="2"  dataformat = "num">
						</td>
					</tr>
			</tbody>
		</table>
		
		<table>
			<colgroup>
				<col width="15">
	            <col width="60">
	            <col width="600">
	            <col width="40">
	            <col width="120">
	            <col width="*">
			</colgroup>
			<tbody>
				<tr>	<td></td>
						<th>To Location</th>
						<td>
							<%=toType %><!--
							 --><input type="text" name="toEccCd" id="toEccCd" style="width:500px;ime-mode:disabled;"  dataformat="engup" otherchar=","><!-- 
							 --><button type="button" class="input_seach_btn" name="toloc_btn"  id="toloc_btn" ></button>
						<td>
						<td><%=toTypeBy %></td>
						
						<td>
							   <input name="toPlnSYr" id="toPlnSYr" type="text" style="width:35px;ime-mode:disabled;" maxlength="4"  dataformat = "num"><!-- 
							--><input name="toPlnSWk" id="toPlnSWk" type="text" style="width:23px;ime-mode:disabled;" maxlength="2"  dataformat = "num">~&nbsp;<!-- 
							--><input name="toPlnEYr" id="toPlnEYr" type="text" style="width:35px;ime-mode:disabled;" maxlength="4"  dataformat = "num"><!-- 
							--><input name="toPlnEWk" id="toPlnEWk" type="text" style="width:23px;ime-mode:disabled;" maxlength="2"  dataformat = "num">
						</td>
						<td></td>
					</tr>
			</tbody>
		</table>
		
		<table>
			<colgroup>
	            <col width="86">
	            <col width="100">
	            <col width="60">
	            <col width="150">
	            <col width="50">
	            <col width="100">
	            <col width="80">
	            <col width="70">
	            <col width="*">
			</colgroup>
			<tbody>
				<tr>
						<th>Item</th>
						<td><%=item%></td>
						<th>TP / SZ</th>
						<td><%=tpsz %><!-- 
							 --><script type="text/javascript">ComComboObject('cntrTpszCd' , 1 , 103, 1 )</script>
						</td>
						<th>Lane</th>
						<td>
							<input name="lane" type="text" name="lane"  id="lane" style="width:97px;ime-mode:disabled;" dataformat="engup"><!--  
							--><button type="button" class="input_seach_btn" name="btn_lane"  id="btn_lane"></button>
						</td>
						<th><input type="radio" class="trans" name="weeklyMonthly" id="weeklyMonthly" value="1" checked>&nbsp;Weekly</th>
						<th><input type="radio" class="trans" name="weeklyMonthly" id="weeklyMonthly" value="2">&nbsp;Monthly</th>
						<td></td>
					</tr>
			</tbody>
		</table>
		
		<table>
			<colgroup>
	            <col width="80">
	            <col width="70">
	            <col width="90">
	            <col width="159">
	            <col width="60">
	            <col width="70">
	            <col width="*">
			</colgroup>
			<tbody>
				<tr>

						<th>Adherence</th>
						<th><input type="radio" class="trans" name="adherence" id="adherence" value ="Z" onclick="displayORG(0)" checked>&nbsp;ORG / DST</th>
						<th><input type="radio" class="trans" name="adherence" id="adherence" value ="O" onclick="displayORG(1)">&nbsp;ORG Only </th>
						<th><input type="radio" class="trans" name="ratioVol" id="ratioVol" value="R" checked>&nbsp;Ratio</th>
						<th><input type="radio" class="trans" name="ratioVol" id="ratioVol" value="V">&nbsp;Vol.</th>
						<th><input name="ratioVolNum" id="ratioVolNum" type="text" style="width:45px;ime-mode:disabled;" dataformat = "num">% </th>
						<td><select name="ratioVolType" id="ratioVolType" style="width:97px;">
								<option value="U" selected>Up</option>
								<option value="D">Down</option>
							</select>
						</td>
						<th style="display:none">Feedback</th>
						<th style="display:none"><input type="radio" class="trans" name="frequency" id="frequency"  value ="F"  checked>&nbsp;Frequency</th>
						<th style="display:none"><input type="checkbox" name="feedback" id="feedback" class="trans">&nbsp;Feedback Only</th>
					</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result" id="zoomarea1">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn" id="sheetControlDiv">
		 	<button type="button" id="btn_up_1" class="btn_up mar_btm_4" sheetId="sheet1" name="btn_up_1" onclick="toggleSheetSize('zoomarea0','zoomarea2');"></button>
		</div>
		 <span id="mainTable"><script type="text/javascript">ComSheetObject('sheet1');</script></span>
	</div>
</div>
<div class="wrap_result" id="zoomarea2">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn" id="sheetControlDiv">
			<button type="button" id="btn_up_2" class="btn_up mar_btm_4" sheetId="sheet2" name="btn_up_2"  onclick="toggleSheetSize('zoomarea0','zoomarea1');"></button>
		</div>
		<span id="sheetControlDiv"><script type="text/javascript">ComSheetObject('sheet2');</script></span>
	</div>
</div>
<!-- Outer Table (E)-->
<iframe frameborder=0 width=0  name="periorIframe" id="periorIframe" scrolling="no" frameborder="0" width="0" height="30"/></iframe>
</form>