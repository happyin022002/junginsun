<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1023.jsp
*@FileTitle : Vessel Stowage Plan Transmit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12 
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.12 김도완
* 1.0 Creation
*-------------------------------------------------------
* History
* 2011.10.13 김봉균 [CHM-201112452-01] 미세관 RECEIVE 데이터 중 CUSRES 반영 요청
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg1023Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1023Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	String strPgmNo = "";
	String strCustoms = "";
	
	try{
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1023Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null){
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
		polCd  = JSPUtil.getParameter(request, "pol_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");		
		strPgmNo = JSPUtil.getParameter(request, "pgmNo");
		
		if ( "ESM_BKG_1122".equals(strPgmNo) || "ESM_BKG_1023".equals(strPgmNo) ) {
			strCustoms = "US";
		} else { 
			strCustoms = "CA";
		}
		
	}catch (Exception e){
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1){
			//showErrMessage(errMessage);
		}// end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="pageno" value="<%=strPgmNo%>">
<input type="hidden" name="customs" value="<%=strCustoms%>">
<input type="hidden" name="gscd">
<input type="hidden" name="lastpol">
<input type="hidden" name="lpol_clpt_ind_seq">
<input type="hidden" name="vps_port_cd">
<input type="hidden" name="clpt_ind_seq">
<input type="hidden" name="hidden_vvd">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
    
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
			
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New"      id="btn_New">New</button> 
		<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		<button type="button" class="btn_normal" name="btn_Transmit"   id="btn_Transmit">Transmit</button>
		<button type="button" class="btn_normal" name="btn_AmsReport"   id="btn_AmsReport">Go to AMS Report</button>
    </div>
    <!-- opus_design_btn(E) -->
    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <table>
	      <tbody>
	        <colgroup>
	        	<col width="60">
	        	<col width="100">
	        	<col width="90">
	        	<col width="110">
	        	<col width="50">
	        	<col width="53">
	        	<col width="72">
	        	<col width="35">
	        	<col width="50">
	        	<col width="119">
	        	<col width="50">
	        	<col width="50">
	        	<col width="*">
	        </colgroup>
				<tr>
					<td class = "sm"><input type="radio" name="allerror" id="allerror" value="ALL" class="trans" checked><label>All</label></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width: 80px; ime-mode:disabled;" class="input1" value="" name="vvd" id="vvd" dataformat="engup" required maxlength="9" fullfill caption="VVD"> </td>
					<th>Last Foreign POL</th>
					<td><script type="text/javascript">ComComboObject("disp_lastpol", 1, 80, 1, 1);</script> </td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol" maxlength="5" style="width:50px;ime-mode:disabled;" value="" class="input" dataformat="engup" id="pol" /> </td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod" maxlength="5" style="width:50px;ime-mode:disabled;" value="" class="input" dataformat="engup" id="pod" /> </td>
					<th>Container Operator</th>
					<td><input type="text" name="cntropr" maxlength="3" style="width:40px;ime-mode:disabled;" value="" class="input" dataformat="engup" id="cntropr" /> </td>
					<th><span id="excludeca_text">Exclude Canada Import</span></th>
					<td><input type="checkbox" name="excludeca" id="excludeca" value="EXCLUDECA" class="trans"></td> 
				</tr>
			</tbody>
		</table>
		<table>
	      <tbody>
	        <colgroup>
	        	<col width="60">
	        	<col width="323">
	        	<col width="116">
	        	<col width="50">
	        	<col width="120">
	            <col width="*">
	        </colgroup>
				<tr>
					<td class = "sm"><input type="radio" name="allerror" value="ERR" class="trans"><label>Error</label></td>
					<th>Vessel Name <input type="text" name="vsl_eng_nm"  id="vsl_eng_nm" style="width:215px;" class="input2" value="" readonly></th> 
					<th>Voyage</th>
					<td><input type="text" name="vsl_voy" id="vsl_voy" style="width:50px; text-align:center" class="input2" value="" readonly></td> 
					<th>Vessel Operator</th>
					<td><input type="text" name="crr_cd"  id="crr_cd" style="width:40px; text-align:center" class="input2" value="" readonly></td> 
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	    <!-- opus_grid_left(S)-->
	 </div>
	<!-- opus_design_grid(E) -->
</div>
</form>