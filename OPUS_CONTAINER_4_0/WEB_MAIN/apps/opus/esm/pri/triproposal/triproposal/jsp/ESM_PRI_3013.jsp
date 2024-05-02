<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_PRI_3013.jsp
*@FileTitle : TRI Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.triproposal.event.EsmPri3013Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri3013Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//server error
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String[] srchTrfCd	= null;
	String[] srchRatUtCd= null;
	String[] ratUtCd	= null;
	
	Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TRIProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		srchTrfCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("trfCd"),true);
		srchRatUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),true);
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
	var srchTrfComboValue = " |<%=srchTrfCd[0]%>";
	var srchTrfComboText = " |<%=srchTrfCd[1]%>";
	var srchRatUtComboValue = " |<%=srchRatUtCd[0]%>";
	var srchRatUtComboText = " |<%=srchRatUtCd[1]%>";
	var ratUtCdValue = " |<%=ratUtCd[0]%>";
	var ratUtCdText = " |<%=ratUtCd[1]%>";
		
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
<input type="hidden" name="srch_trf_pfx_cd">
<input type="hidden" name="srch_trf_no">
<input type="hidden" name="trf_pfx_cd">
<input type="hidden" name="trf_no">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->
<div class="wrap_search">
	<div class="opus_design_inquiry">		
		<table class="search" border="0">
			<tbody>
				<colgroup>
					<col width="70">
					<col width="65">
					<col width="60">
					<col width="65">
					<col width="58">
					<col width="65">
					<col width="70">
					<col width="70">
					<col width="142">
					<col width="130">
					<col width="65">
					<col width="110">
					<col width="76">
					<col width="*">
				</colgroup>
				<tr>
					<th>Tariff Code</th>
					<td colspan="7"><script type="text/javascript">ComComboObject("srch_trf_cd", 2, 87, 0, 1, 0, false);</script><!--  
						--><input name="srch_trf_nm" id="srch_trf_nm" type="text" style="width:384px;" class="input2" value="" readonly caption="Tariff Code"></td>
					<th>Access Date</th>
					<td><input type="text" name="srch_acs_dt" style="width:80px;text-align:center;" class="input1" caption="Access Date" dataformat="ymd" maxLength="10" minlength="8" required><!--  
						--><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button>
						<!-- <img src="img/btns_calendar.gif" name="btns_calendar" width="19px" height="20px" alt="Access Date" border="0" align="absmiddle" class="cursor"> --></td>
					<th>Commodity </th>
					<td colspan="3"><input type="text" name="srch_cmdt_cd" id="srch_cmdt_cd" style="width:70px;text-align:center;" class="input" dataformat="num" maxlength="6" fullfill caption="Commodity Code"><!--  
						--><button type="button" class="input_seach_btn" name="srch_btn_srch_cmdt" id="srch_btn_srch_cmdt"></button><!--  
						--><input name="srch_cmdt_nm" id="srch_cmdt_nm" type="text" style="width:150px;" class="input2" value=""></td>
				</tr>
				<tr>
					<th>Origin</th>
					<td><input type="text" name="srch_org_rout_pnt_loc_nm" id="srch_org_rout_pnt_loc_nm" style="width:65px;text-align:center;" class="input" dataformat="enguponly" maxlength="5" caption="Origin"></td>
					<th>Origin Via</th>
					<td><input type="text" name="srch_org_rout_via_port_nm" id="srch_org_rout_via_port_nm" style="width:65px;text-align:center;" class="input" dataformat="enguponly" maxlength="5" caption="Origin Via."></td>
					<th>Dest. Via</th>
					<td><input type="text" name="srch_dest_rout_via_port_nm" id="srch_dest_rout_via_port_nm" style="width:65px;text-align:center;" class="input" dataformat="enguponly" maxlength="5" caption="Dest Via."></td>
					<th>Destinaion</th>
					<td><input type="text" name="srch_dest_rout_pnt_loc_nm" id="srch_dest_rout_pnt_loc_nm" style="width:65px;text-align:center;" class="input" dataformat="enguponly" maxlength="5" caption="Destination"></td>
					<th>Tariff Rate Item(TRI)</th>
					<td><input type="text" name="srch_tri_no" id="srch_tri_no" style="width:110px;text-align:center;" class="input" dataformat="num" maxlength="15" caption="Tariff Rate Item"></td>
					<th>TAA No.</th>
					<td><input type="text" name="srch_taa_no" id="srch_taa_no" style="width:110px;text-align:center;" class="input" dataformat="engup" maxlength="10" caption="TAA Number"></td>
					<th>Per</th>
					<td><script type="text/javascript">ComComboObject('srch_rat_ut_cd', 2, 60, 1, 0);</script></td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table style="width:979px;">
			<tbody>
				<colgroup>
					<col width="130">
					<col width="*">
				</colgroup>
				<tr class="h23">
					<th style="text-align:left;">Additional Option</th>
					<td><input type="checkbox" name="srch_chk_taa_no" value="Y" class="trans"> TAA Number</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
	<div class="opus_design_grid">	
		<div class="opus_design_btn">
		   <button type="button" class="btn_normal" name="btn_conversion" id="btn_conversion">Tariff Formula Rule</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		
		<div  id="tempTable" style="display:none;"> 
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>	
	</div>
</div>
<!-- 시트영역 -->

</form>
