<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_SAQ_0078.jsp
*@FileTitle  : Base Data Preparation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/15
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0078Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0078Event event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;  	//error from server
	String strErrMsg = "";					//error message
	int rowCount	 = 0;					//count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.MonthlyQuotaCreation");

	try {
	   	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmSaq0078Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
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
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="mqta_mdl_ver_no">
	
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_interface" id="btn_interface">COA I/F</button><!--
		    -->	<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		    -->	<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--		  
		    -->	<button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Confirm</button><!--	
		    -->	<button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Cancel Confirmation</button><!--	
		    -->	<button type="button" class="btn_normal" name="btn_notify" id="btn_notify">Notify</button>	
		</div>
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
		<div class= "opus_design_inquiry ">
			<table>
				<tbody>
					<colgroup>
						<col width="35px"/>
						<col width="110px"/>
						<col width="55px"/>
						<col width="110px"/>
						<col width="43px"/>
						<col width="110px"/>
						<col width="50px"/>
						<col width="110px"/>
						<col width="40px"/>
						<col width="150px"/>
						<col width="35px"/>
						<col width="60px"/>
						<col width="*"/>
					</colgroup>
					<th>Year</th>
					<td><select class="input1" id="year" name="year" style="width:60px;"></td>
					<th>Quarter</th>
					<td><select class="input1" id="bse_qtr_cd" name="bse_qtr_cd" style="width:60px;"></select></td>
					<th>Trade</th>
					<td><script language="JavaScript">ComComboObject("trade", 2, 60, 0, 0);</script></td>
					<th>Bound</th>
					<td><select class="input" id="bound" name="bound" style="width:60px;"></select></td>
					<th>Lane</th>
					<td><script language="JavaScript">ComComboObject("search_lane", 4, 100, 0, 0, 2);</script></td>
					<th>IOC</th>
					<td><select name="ioc" id="ioc" class="input" style="width:80px;"><!--
							--><option value=""></option><!--
							--><option value="O">OCN</option><!--
							--><option value="I">IPC</option><!--
							--><option value="T">TS</option>
						</select>
					</td>
					<td></td>
				</tbody>	
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">		
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn">
				<button class="btn_normal" name="btng_ofcVerify" id="btng_ofcVerify" type="button">Office Verify</button><!--
				--><button class="btn_normal" name="btng_ofcAdjust" id="btng_ofcAdjust" type="button">Office Adjust</button><!--
				--><button class="btn_normal" name="btng_laneAdjust" id="btng_laneAdjust" type="button">Lane Adjust</button><!--
				--><button class="btn_normal" name="btng_CPBAdjust" id="btng_CPBAdjust" type="button">CPB Adjust</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</form>
