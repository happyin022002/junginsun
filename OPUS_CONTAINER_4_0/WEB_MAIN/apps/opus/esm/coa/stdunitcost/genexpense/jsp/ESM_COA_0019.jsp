<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_COA_0019.jsp
*@FileTitle  : General Expense 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.genexpense.event.EsmCoa0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String curYrMon			= "";
	String colsYrMon		= "";
	Logger log = Logger.getLogger("com.clt.apps.STDUnitCost.GenExpense");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		curYrMon = eventResponse.getETCData("YRMON");
		colsYrMon = eventResponse.getETCData("COL_YRMON");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form method="post" name="form" id="form" onSubmit="return false;" onKeyDown="ComKeyEnter();" >
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="cur_yrmon" id="cur_yrmon" value="<%=curYrMon%>">
<input type="hidden" name="cols_yrmon" id="cols_yrmon" value="<%=colsYrMon%>">

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_normal" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
			<button type="button" class="btn_accent" name="btn_Create"	id="btn_Create">Create</button>
		<!--
		
		--><button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>YYYY-MM</th>
					<td><input type="text" name="cost_yrmon" id="cost_yrmon" class="input1" style="width:60px;" dataformat="ym" value="<%=curYrMon%>" maxlength="7" onKeyPress="ComKeyOnlyNumber(window)" onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="addDash(this , 4);"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	
	<div class="opus_design_grid" id="mainTable" name="mainTable">
		<h3 class="title_design">General Expense</h3><br>
		<div align="right" class="mar_btm_4">(USD)</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" name="mainTable" style="width: 49%;">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
<!-- opus_design_grid(E) -->

<!-- layout_wrap (S) -->
 <div class="opus_design_inquiry">
 <div class="layout_wrap">
	<!-- opus_design_grid(S) -->
     <div class="opus_design_grid">
     <!-- SJH.20141229.ADD -->
     	<div class="layout_vertical_2" style="width: 49%;margin-right: 2%;">
			<table>
				<tbody>
					<colgroup>
						<col width="*" />
						<col width="30" />
						<col width="120" />
					</colgroup>
					<tr>
						<td><h3 class="title_design">Vessel Unit Cost Inquiry</h3></td>
	     				<td></td>
	     				<td style="text-align:right">
				        	<div class="opus_design_btn">        	
				        	 	
				     		 	<!-- <button type="button" class="btn_accent" name="btn_Save1"  id="btn_Save1">Save</button> -->
							</div>   
							(USD/Day) 
	     				</td>
	     				
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="layout_vertical_2" style="width: 49%;">
        	<div class="opus_design_btn" style="float: right">
     			 <button type="button" class="btn_accent" name="btn_Rowadd2" id="btn_Rowadd2">Row Add</button>
			 </div>
		</div>
		
	 </div>
     <div class="layout_vertical_2" style="width: 49%;margin-right: 2%;">
         <div class="opus_design_grid">
             <script type="text/javascript">ComSheetObject('sheet3');</script>
         </div>
         <!-- opus_design_grid(e) -->
     </div>
     <div class="layout_vertical_2" style="width: 49%">
         <!-- opus_design_grid(S) -->
         <div class="opus_design_grid">
    		<script type="text/javascript">ComSheetObject('sheet4');</script>
         </div>
         <!-- opus_design_grid(e) -->
     </div>
 </div>
 </div>
 </div>
<!-- layout_wrap (e) -->
</form>