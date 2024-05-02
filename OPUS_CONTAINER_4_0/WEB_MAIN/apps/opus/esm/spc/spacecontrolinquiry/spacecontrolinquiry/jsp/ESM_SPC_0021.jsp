<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0021.jsp
*@FileTitle  : Daily Forecast Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Spacecontrolinquiry.Spacecontrolinquiry");
	String ofc_cd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		ofc_cd = event.getSignOnUserAccount().getOfc_cd();
		

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Daily Forecast Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="chkview" id="chkview" />
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button><!--	
		--><button type="button" class="btn_normal" name="btn_downexcel" 		id="btn_downexcel">Down Excel</button>
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
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>					
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="*"/>
					
			    </colgroup>
				<tr>
					<th>Start Week</th>
					<td><select class="input1" name="year" id="year" style="width:80px;"></select><!--
						--><select class="input1" name="week1" id="week1" style="width:60px;"></select>
					</td>
					<th>Duration</th>
					<td>
						<select class="input1" name="duration"  style="width:80px;"" id="duration" size="1"></select>
					</td>
					<th>Trade</th>
					<td>
						<script  type="text/javascript">ComComboObject("trade", 2, 80, 0, 1);</script>
					</td>
					<th>Bound</th>
					<td>
						<select name="bound" id="bound" style="width:80px;"></select>
					</td>
				</tr>		
				<tr>
					<th>RHQ</th>
					<td><script  type="text/javascript">ComComboObject("rhq", 2, 145, 0, 1);</script></td>
					<th>Area</th>
					<td><input name="area" type="text" style="width:80px;ime-mode:disabled;" maxlength="6" onkeypress="eventKeyChangeChar(UPPER_CASE);" id="area" dataformat="engup"/></td>
					<th>Office</th>
					<td><input type="text" name="sales_office" style="width:80px;" maxlength="6" onkeypress="eventKeyChangeChar(UPPER_CASE);" onchange="checkValue('office');" id="sales_office" dataformat="engup"/><!--  
						--><button type="button" id="btn_popup_office" name="btn_popup_office" class="input_seach_btn"></button>
					</td>
					<th>Port</th>
					<td><input name="pol_cd" type="text" style="width:80px;ime-mode:disabled;" value="" maxlength="5" onkeypress="eventKeyChangeChar(UPPER_CASE);" onchange="checkValue('pol');" id="pol_cd" dataformat="engup"/><!-- 
					 --><button type="button" id="btn_popup_pol_cd" name="btn_popup_pol_cd" class="input_seach_btn"></button>
					</td>
				</tr>
				<tr style="display:none;">
					<td colspan="8"><input type="checkbox" value="P" class="trans" name="chkViewP" id="chkViewP" onclick="changetitle();">Port View<!-- 
					 --><input type="checkbox" value="L" class="trans" name="chkViewL" id="chkViewL">Local Week
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab sm">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:inline">
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="1"/>
						<col width="100"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Item</th>
						<td><select class="input1" style="width:100px;" name="item1" id="item1" onChange="changeColum1(this);"><option value="1" selected>Vol/Teu.</option></select></td>
						<th>Sub Trade</th>
						<td><script  type="text/javascript">ComComboObject("subtrade1", 3, 50, 0, 0, 1);</script></td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>
	
	
	<div id="tabLayer" style="display:none">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="1"/>
						<col width="100"/>
						<col width="80"/>
						<col width="60"/>
						<col width="40"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Item</th>
						<td><select class="input1" style="width:100px;" name="item2" id="item2" onChange="changeColum2(this);"><option value="1" selected>Vol/Teu.</option></select></td>
						<th>Sub Trade</th>
						<td><script  type="text/javascript">ComComboObject("subtrade2", 3, 50, 0, 0, 1);</script></td>
						<td><input type="checkbox" value="" name="check_office" class="trans" onclick="changeTitle2(this);" id="check_office" />Office
						<td  id="check_alloc_div" name="check_alloc_div" ><input type="checkbox" value="" name="check_alloc" class="trans" checked="" onclick="showAlloc2(this);" id="check_alloc" />  Allocation</td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>
	
	
	
	<div id="tabLayer" style="display:none">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="1"/>
						<col width="100"/>
						<col width="80"/>
						<col width="60"/>
						<col width="40"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Item</th>
						<td><select class="input1" style="width:100px;" name="item3" id="item3" onChange="changeColum3(this);"><option value="1" selected>Vol/Teu.</option></select></td>
						<th>Sub Trade</th>
						<td><script  type="text/javascript">ComComboObject("subtrade3", 3, 50, 0, 0, 1);</script></td>
						<td><input type="checkbox" value="" name="check_office2" class="trans" onclick="changeTitle3(this);" id="check_office2" />  Office</td>
						<td  id="check_alloc_div2" name="check_alloc_div2" ><input type="checkbox" value="" name="check_alloc2" class="trans" checked="" onclick="showAlloc3(this);" id="check_alloc2" />  Allocation</td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer" style="display:none">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<td>Sub Trade</td>
						<td><combo:SubTrade name="subtrade4" id="subtrade4" style="width:50;" options="0//||ALL" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
