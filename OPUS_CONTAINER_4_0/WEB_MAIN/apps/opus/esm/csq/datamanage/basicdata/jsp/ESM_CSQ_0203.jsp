<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0203.jsp
*@FileTitle  : POL-POD Management for IAS Sector_Add-Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/05
=========================================================*/	
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0203Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String p_bse_tp_cd  = JSPUtil.getParameter(request, "f_bse_tp_cd", "");
	String p_bse_yr     = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");

	EsmCsq0203Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.specialkpi.planning");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCsq0203Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="p_bse_tp_cd" value="<%= p_bse_tp_cd%>" id="p_bse_tp_cd" />
<input type="hidden" name="f_trd_cd" id="f_trd_cd" value="IAS"/> 
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>POL-POD Management for IAS Sector_Add Creation</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_Creation" id="btn_Creation" type="button">Creation</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50" />				
				<col width="70" />				
				<col width="80" />				
				<col width="70" />				
				<col width="80" />				
				<col width="200" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<td class="sm pad_left_8"><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cd_y" class="trans" value="Y" disabled="disabled"><label for="f_bse_tp_cd_y"><strong>Yearly</strong></label></td>
		   			<th>Year</th>
					<td><input type="text" name="f_bse_yr" style="width:70px;text-align:center;ime-mode:disabled;" readonly class="input2" value="<%= p_bse_yr%>" id="f_bse_yr" /> </td>
					<th><div id="div_qtr">Quarter</div></th>
					<td><input type="text" name="f_bse_qtr_cd" style="width:70px;text-align:center;ime-mode:disabled;" readonly class="input2" value="<%= p_bse_qtr_cd%>" id="f_bse_qtr_cd" /> </td>
					<td><div id="div_period"></div></td>
		   		</tr>
				<tr>
					<td class="sm pad_left_8"><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cd_q" class="trans" value="Q"><label for="f_bse_tp_cd_q"><strong>Quarterly</strong></label></td>
					<th>Sub Trade</th>
					<td><script type="text/javascript">ComComboObject('f_sub_trd_cd', 1, 70, 1, 1)</script></td>
					<th>R/Lane</th>
					<td><script type="text/javascript">ComComboObject('f_rlane_cd', 1, 70, 1, 1)</script></td>
					<th> </th>
                    <td> </td>
				</tr>
		   </tbody>
		</table>
		</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="sheetLayer" name="sheetLayer">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>