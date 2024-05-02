<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0029.js
*@FileTitle  : Cargo Flow Map
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");
	String xml = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim1029Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
		document.form.froms.focus();
	}
    
    
function revForm(type) {
  if (type == "on") {
    document.getElementById("layer1").style.display = "";
  } else if (type == "off") {
    document.getElementById("layer1").style.display = "none"; 
  }
}
</script>

<form name="form">
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="etcDataValue" value="" id="etcDataValue" />
<input type="hidden" name="etcChk" value="" id="etcChk" />
<input type="hidden" name="fromz" id="fromz" />
<input type="hidden" name="toz" id="toz" />
<input type="hidden" name="inquiryLevel" id="inquiryLevel" />
<input type="hidden" name="inquiryWise1" id="inquiryWise1" />
<input type="hidden" name="inquiryWise2" id="inquiryWise2" />
<input type="hidden" name="location" id="location" />
<input type="hidden" name="location2" id="location2" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
			--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Period</th>
                    <td><select style="width:130px;" class="input1" name="period" id="period" ><option value="M" selected>Month(YYYY-MM)</option><option value="W">Week(YYYY-WW)</option></select></td>
                    <td><input type="text" style="width:55px;" class="input1" value="" name="froms" caption="FM" required="" dataformat="ym" maxlength="6" id="froms" /><input type="text" style="width:55px;" class="input1" value="" name="tos" caption="TO" required="" dataformat="ym" maxlength="6" id="tos" /></td>
					<th class="sm">TP/SZ</th>
                    <td class="sm"><input type="radio" class="trans" checked="" name="tpsz" value="A" onclick="rdTypeSel(this.value)" onkeypress="testAlert()" id="tpsz" /><label>All</label><input type="radio" class="trans" name="tpsz" value="D" onclick="rdTypeSel(this.value)" onkeypress="testAlert()" id="tpsz" /><label>DRY</label><input type="radio" class="trans" name="tpsz" value="S" onclick="rdTypeSel(this.value)" onkeypress="testAlert()" id="tpsz" /><label>SPCL</label><input type="radio" class="trans" name="tpsz" value="R" onclick="rdTypeSel(this.value)" onkeypress="testAlert()" id="tpsz" /><label>Reefer</label><select style="width:100px;" class="input" name="rdtype" id="rdtype" disabled><option value="I" selected>Incl R/D</option><option value="E"         >Excl R/D</option><option value="O"         >Only R/D</option></select></td>
                    <td></td>
				</tr> 
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="50px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td>
						<table style="width:400px;" class="sm"> 
							<tr>
								<td rowspan="2" width="100px" class="pad_left_8"><strong>Direction Wise</strong><br><select style="width:88px;" class="input" name="directionWise" id="directionWise" onchange="setText('R');"><option value="F" selected>From</option><option value="T">To</option><option value="L">Loc-Loc</option></select></td>
								<td><span id="ff">From</span></td>
								<td width="90px"><select style="width:82px;" class="input" name="startloc" id="startloc" onchange="setSubCombo();"><option value="R" selected>RCC</option><option value="L">LCC</option><option value="E">ECC</option><option value="S">SCC</option><option value="C">Country</option><option value="P">POL</option></select></td>
	                            <td width="165px">    
	                                <div id = "div_loc" style = "display:" ><input type="text" style="width:51px;" size="5" class="input" dataformat="engup" name="locationf1" value="" maxlength="5" id="locationf1" /></div>
	                                <div id = "div_loc2" style = "display:none" >
	                                <input type="text" style="width:120px;" size="5" class="input" dataformat="engup" name="locationf2" value="" id="locationf2" />
	                                <button type="button" id="btn_floc_cd" name="btn_floc_cd" class="input_seach_btn"></button>
	                                </div>
	                                <div id = "div_cnty" style = "display:none" ><input type="text" size="2" class="input" dataformat="engup" style="ime-mode:disabled" name="country" value="" maxlength="2" id="country" /></div>
	                            </td>
	                        </tr>
							<tr>
								<td><span id="tt">To</span></td>
								<td width="90px"><select style="width:82px;" class="input" name="endloc" id="endloc" ><option value="R" selected>RCC</option><option value="L">LCC</option><option value="E">ECC</option><option value="S">SCC</option><option value="C">Country</option><option value="P">POD</option></select></td>
								<td width="165px">    
	                                <div id = "div_loc3" name = "div_loc3" style = "display:none" >
	                                <input type="text" style="width:120px;" size="5" class="input" dataformat="engup" name="locationt2" value="" id="locationt2" />
	                                <button type="button" id="btn_tloc_cd" name="btn_tloc_cd" class="input_seach_btn"></button>
	                                </div>
	                                <div id = "div_cnty2" style = "display:none" >
	                                <input type="text" size="2" class="input" dataformat="engup" style="ime-mode:disabled" name="country2" value="" maxlength="2" id="country2" />
	                                </div>
	                            </td>
							</tr>
						</table>
					</td>
					<td> 
						<table style="width:229px;" > 
							<tr>
								<th> S.O.C</th>
								<td width="120px" valign="top">
			                        <select style="width:100px;" class="input" name="soc" >
			                            <option value="E" selected>Exclude</option>
			                            <option value="I"         >Include</option>
			                            <option value="O"         >Only </option>
			                        </select>
			                    </td>
								<td></td>
							</tr>
						</table>
					</td>
                    <td></td>
				</tr> 
			</tbody>
		</table>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- wrap_area(E) -->
<!-- result_area(E) -->		
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id = "tr_from_to" style = "display:">
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<div class="opus_design_grid" id = "tr_loc_loc" style = "display:none">
			<script type="text/javascript">ComSheetObject('t1sheet2');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->			
</form>
