<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1061.jsp
*@FileTitle  : Empty Repo Result
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.event.EesEqr1061Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1061Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	String strErrMsg = "";								 
	int rowCount	 = 0;						//DB ResultSet 

	try {
		event = (EesEqr1061Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

	String optionStr = "000000:ALL:ALL";
	String optionStr1 = "000000: : ";

	String fmType    = JSPUtil.getCodeCombo("fmType", "", "width='55'", "CD00242", 0, optionStr);
	String toType    = JSPUtil.getCodeCombo("toType", "", "width='55'", "CD00242", 0, optionStr);

	String fmTypeBy  = JSPUtil.getCodeCombo("fmTypeBy", "E", " style='width:80;'", "CD00265", 0, "");
	String toTypeBy  = JSPUtil.getCodeCombo("toTypeBy", "E", " style='width:80;'", "CD00265", 0, "");

	String tpsz = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:55;'","CD00263",0,optionStr);
%>
<script type="text/javascript">
	// mode (Truck, Rail, Water)
	<%= JSPUtil.getIBCodeCombo("item",    "01", "CD00566", 0, "")%>
	// Type Size
	<%= JSPUtil.getIBCodeCombo("tpszall", "01", "CD00244", 0, "")%> // ALL TYPE SIZE
	<%= JSPUtil.getIBCodeCombo("tpszdry", "01", "CD00751", 0, "")%> // DRY TYPE SIZE
	<%= JSPUtil.getIBCodeCombo("tpszrfr", "01", "CD00752", 0, "")%> // RFR TYPE SIZE
	<%= JSPUtil.getIBCodeCombo("tpszot",  "01", "CD00753", 0, "")%> // OT  TYPE SIZE
	<%= JSPUtil.getIBCodeCombo("tpszfr",  "01", "CD00754", 0, "")%> // FR  TYPE SIZE

    // ------- type  -------------- START
    var consTpsz      = replaceAll(tpszallText, "|", ",");
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = replaceAll(tpszdryText, "|", ",");
    var consTpszRfr   = replaceAll(tpszrfrText, "|", ",");
    var consTpszOt    = replaceAll(tpszotText,  "|", ",");
    var consTpszFr    = replaceAll(tpszfrText,  "|", ",");
    // ------- type  -------------- END

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		// InitTab();
		loadPage();
	}
</script>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="tpszall" value="" id="tpszall" />
<input type="hidden" name="tpcnt" value="" id="tpcnt" />
<input type="hidden" name="transmode" value="" id="transmode" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button">Empty Repo Result</button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new" >New</button><!--
		--><button class="btn_normal" type="button" name="btn_downexcel" id="btn_downexcel" >Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70">				
				<col width="100">				
				<col width="70">				
				<col width="195">				
				<col width="*">				
		   </colgroup> 
		   <tbody>
		   		<tr>
				 	<th>Period</th>
                    <td><select name="period" id="period" onChange="changeFmDateMaxLength(this);" style="width:90px;"><!--
                    --><option value="Day" selected>yyyymmdd</option><!--
                    --><option value="Week" >yyyyww</option><!--
                    --><option value="Month" >yyyymm</option></select></td>
                     <td><input name="fmdate" value="" type="text" style="width:75px;ime-mode:disabled;" dataformat="num" id="fmdate" />~ <!--
                        --><input name="todate" value="" type="text" style="width:75px;ime-mode:disabled;" maxlength="8" dataformat="num" id="todate" /> </td>
                     <th>Mode</th>
                     <td><script type="text/javascript">ComComboObject('item' , 1, 150, 1 )</script></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="70">				
				<col width="100">				
				<col width="75">				
				<col width="60">				
				<col width="60">				
				<col width="60">				
				<col width="*">				
		   </colgroup> 
		   <tbody>
		   		<tr>
				 	  <th>Fm LOC</th>
                      <td><%=fmType %><input type="text" name="fmloc" id="fmloc" style="width:60px;ime-mode:disabled;" value="" dataformat="engup"><!--
                      --><button type="button" id="fmloc_btn" name="fmloc_btn" class="input_seach_btn" tabindex="-1"></button></td>
                      <th>To LOC</th>
                      <td><%=toType %><input type="text" name="toloc" style="width:60px;ime-mode:disabled;" value="" dataformat="engup" id="toloc" /><!--
                      --><button type="button" id="toloc_btn" name="toloc_btn" class="input_seach_btn" tabindex="-1"></button></td>
                      <th>TP/SZ</th>
                      <td><%=tpsz%></td>
                      <td><script language="javascript">ComComboObject('cntrtpszcd' , 1 , 220, 1 )</script></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
<!-- Outer Table (E)-->
<iframe frameborder="0" width="0"  name="037iframe" scrolling="no" frameborder="0" width="0" height="0"></iframe>

<!-- 주차 -->
<!-- iframe frameborder=0 width=0  name="F037iframe" scrolling="no" frameborder="0" width="0" height="0"/-->
<iframe frameborder="0" width="0"  name="periorIframe" scrolling="no" frameborder="0" width="0" height="0"/></iframe>
</form>