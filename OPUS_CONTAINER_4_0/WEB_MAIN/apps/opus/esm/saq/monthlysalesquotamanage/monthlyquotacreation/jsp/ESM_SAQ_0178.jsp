<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName  : ESM_SAQ_0178.jsp
*@FileTitle  : COA I/F Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/16
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0178Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0178Event event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;		//error from server
	String strErrMsg = "";					//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.MonthlyQuotaCreation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSaq0178Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
  var sFunc = '<%=JSPUtil.getParameter(request, "func")%>';
  var iSheetIdx = '<%=JSPUtil.getParameter(request, "sheetIdx")%>';
  var iRow = '<%=JSPUtil.getParameter(request, "row")%>';
  var iCol = '<%=JSPUtil.getParameter(request, "col")%>';

  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pagerows">
<input type="hidden" name="h_yr1">
<input type="hidden" name="h_yr2">
<input type="hidden" name="h_yr3">
<input type="hidden" name="h_ver_no">
<input type="hidden" name="h_sel_div">
<input type= "hidden" name ="h_months">
<input type= "hidden" name ="stat_mon">
<input type= "hidden" name = "h_year">
<input type= "hidden" name = "h_mon">
<input type= "hidden" name = "h_mon2">
<input type= "hidden" name = "h_mon3">

<!-- 개발자 작업 -->
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title" id="popup_title" name="popup_title"><span>COA I/F Creation</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" 	name="btn_interface" 	id="btn_interface">Interface</button><!--
			--><button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<!-- <div class="location">
			<span id="navigation"></span>
		</div> -->
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="80px" />					
					<col width="35px" />
					<col width="110px" />
					<col width="55px" />
					<col width="110px" />
					<col width="" />
				</colgroup>
				<tbody>
					<tr>
						<td style="color:#532FC3; font-weight:bold;padding-left:0px;">
							<input type="radio" class="trans" id="sel_div" name="sel_div" value ="Q" checked>Quarter Select
						</td>
						<th>Year</th>
						<td>
							<select class="input1" id="year" name="year" style="width:60px;"></select>
						</td>
						<th>Quarter</th>
						<td>
							<select class="input1" id="qtr_cd" name="qtr_cd" style="width:60px;"></select>
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
			
			<div class="opus_design_grid"><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
			
			<table>
				<colgroup>
					<col width="159px" />
					<col width="300px" />
					<col width="" />
				</colgroup>
				<tbody>
					<tr>
						<td style="color:#532FC3; font-weight:bold;padding-left:0px;">
							<input type="radio" class="trans" id="sel_div" name="sel_div" value ="Y">Cost Year Month Select
						</td>
						<td colspan="2"></td>						
					</tr>
					<tr>
						<td class="gray_tit" style="font-weight:bold; padding:10px 0px 5px 3px;">Selected Cost Year Month</td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td colspan="2">
							<div>
							<textarea name="slct_yrmon" style="width:459px; height:34" class="input2" readOnly></textarea>
							</div>
						</td>
						<td></td>
					</tr>
					
				</tbody>			
			</table>
			<table>
				<colgroup>
					<col width="35px" />
					<col width="80px" />
					<col width="100px" />					
					<col width="10px" />
					<col width="10px" />
					<col width="10px" />
					<col width="10px" />
					<col width="10px" />
					<col width="10px" />
					<col width="10px" />
					<col width="10px" />
					<col width="10px" />
					<col width="10px" />
					<col width="10px" />
					<col width="10px" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Year</th>
						<td>
							<input type="text" class="input2"style="width:50px; font-weight:bold; text-align:center" maxlength="10" readOnly name="yr1">
						</td>
						<th>Month</th>
						<td><input type="checkbox" name="yr101" class="trans" onClick="chkMon()" value="01">1</td>                                                     
						<td><input type="checkbox" name="yr102" class="trans" onClick="chkMon()" value="02">2</td>                                                     
	                    <td><input type="checkbox" name="yr103" class="trans" onClick="chkMon()" value="03">3</td>                                                                              
	                    <td><input type="checkbox" name="yr104" class="trans" onClick="chkMon()" value="04">4</td>                                                                              
	                    <td><input type="checkbox" name="yr105" class="trans" onClick="chkMon()" value="05">5</td>                                                                              
	                    <td><input type="checkbox" name="yr106" class="trans" onClick="chkMon()" value="06">6</td>                                                                              
	                    <td><input type="checkbox" name="yr107" class="trans" onClick="chkMon()" value="07">7</td>                                                                              
	                    <td><input type="checkbox" name="yr108" class="trans" onClick="chkMon()" value="08">8</td>                                                                              
	                    <td><input type="checkbox" name="yr109" class="trans" onClick="chkMon()" value="09">9</td>                                                                              
	                    <td><input type="checkbox" name="yr110" class="trans" onClick="chkMon()" value="10">10</td>                                                                             
	                    <td><input type="checkbox" name="yr111" class="trans" onClick="chkMon()" value="11">11</td>                                                                             
	                    <td><input type="checkbox" name="yr112" class="trans" onClick="chkMon()" value="12">12</td>
	                    <td></td>
					</tr>
					<tr>
						<th>Year</th>
						<td>
							<input type="text" class="input2"style="width:50px; font-weight:bold; text-align:center" maxlength="10" readonly name="yr2">
						</td>
						<th>Month</th>
						<td><input type="checkbox" name="yr201" class="trans" onClick="chkMon()" value="01">1</td>                                                                              
                      	<td><input type="checkbox" name="yr202" class="trans" onClick="chkMon()" value="02">2</td>                                                                              
                      	<td><input type="checkbox" name="yr203" class="trans" onClick="chkMon()" value="03">3</td>                                                                              
                      	<td><input type="checkbox" name="yr204" class="trans" onClick="chkMon()" value="04">4</td>                                                                              
	                    <td><input type="checkbox" name="yr205" class="trans" onClick="chkMon()" value="05">5</td>                                                                              
                      	<td><input type="checkbox" name="yr206" class="trans" onClick="chkMon()" value="06">6</td>                                                                              
                      	<td><input type="checkbox" name="yr207" class="trans" onClick="chkMon()" value="07">7</td>                                                                              
                      	<td><input type="checkbox" name="yr208" class="trans" onClick="chkMon()" value="08">8</td>                                                                              
                      	<td><input type="checkbox" name="yr209" class="trans" onClick="chkMon()" value="09">9</td>                                                                              
                      	<td><input type="checkbox" name="yr210" class="trans" onClick="chkMon()" value="10">10</td>                                                                             
                      	<td><input type="checkbox" name="yr211" class="trans" onClick="chkMon()" value="11">11</td>                                                                             
                      	<td><input type="checkbox" name="yr212" class="trans" onClick="chkMon()" value="12">12</td>  
	                    <td></td>
					</tr>
					<tr>
						<th>Year</th>
						<td>							
							<input type="text" class="input2"style="width:50px; font-weight:bold; text-align:center" maxlength="10" readonly name="yr3">							
						</td>
						<th>Month</th>
						<td><input type="checkbox" name="yr301" class="trans" onClick="chkMon()" value="01">1</td>                                                                              
                      	<td><input type="checkbox" name="yr302" class="trans" onClick="chkMon()" value="02">2</td>                                                                              
                      	<td><input type="checkbox" name="yr303" class="trans" onClick="chkMon()" value="03">3</td>                                                                              
                      	<td><input type="checkbox" name="yr304" class="trans" onClick="chkMon()" value="04">4</td>                                                                              
                      	<td><input type="checkbox" name="yr305" class="trans" onClick="chkMon()" value="05">5</td>                                                                              
                      	<td><input type="checkbox" name="yr306" class="trans" onClick="chkMon()" value="06">6</td>                                                                              
                      	<td><input type="checkbox" name="yr307" class="trans" onClick="chkMon()" value="07">7</td>                                                                              
                      	<td><input type="checkbox" name="yr308" class="trans" onClick="chkMon()" value="08">8</td>                                                                              
                      	<td><input type="checkbox" name="yr309" class="trans" onClick="chkMon()" value="09">9</td>                                                                              
                      	<td><input type="checkbox" name="yr310" class="trans" onClick="chkMon()" value="10">10</td>                                                                             
	                    <td><input type="checkbox" name="yr311" class="trans" onClick="chkMon()" value="11">11</td>                                                                             
    	                <td><input type="checkbox" name="yr312" class="trans" onClick="chkMon()" value="12">12</td>
	                    <td></td>
					</tr>				
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="wrap_result" style ="display : none">
		<div class="opus_design_grid clear" id="memo_sheet1_td">
				<script type="text/javascript">ComSheetObject('memo_sheet1');</script>
		</div>
	</div>			
<!-- 개발자 작업 끝 -->
</div>
</form>