<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0086.js
*@FileTitle  : Tax Evidence 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0086Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0086Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmFms0086Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		log.error(e.getMessage(),e);
	}
	String csrNo = StringUtil.xssFilter(request.getParameter("csr_no"));
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


<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="usr_id" name="usr_id" value="<%=strUsr_id%>" type="hidden" />
<input id="csr_no" name="csr_no" value="<%=csrNo%>" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear wFit">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Tax Evidence</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_close" name="btn_close" class="btn_accent">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table class="search" style="width: 880px;">
			<colgroup>
				<col width="70"/>
				<col width="200"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup>
			<tr class="h23">
				<th>세금계산서 번호</th>
				<td><input id="tax_inv_yrmon" style="width:60px; text-align:center;" class="input1" name="tax_inv_yrmon" maxlength="6" readonly type="text" /><select style="width: 180px;" class="input1" name="ofc_cd" id="ofc_cd"></select></td>
				<th>Type</th>
				<td><input id="tax_iss_cd" class="trans" name="tax_iss_cd" disabled="disabled" type="radio" /> 전자  <input id="tax_iss_cd" class="trans" name="tax_iss_cd" disabled="disabled" type="radio" /> 종이</td>
			</tr>
		</table>
		
		<table class="search" style="width: 880px;"> 
			<colgroup>
				<col width="95"/>
				<col width="235"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup>
			<tr class="h23">
				<th>Tax 구분</th>
				<td><input id="tax_vat_tp_cd" class="trans" name="tax_vat_tp_cd" value="1" disabled="disabled" type="radio" /> 개인    <input id="tax_vat_tp_cd" class="trans" name="tax_vat_tp_cd" value="2" checked disabled="disabled" type="radio" /> 회사 </td>
				<th>매입세액불공제</th>
				<td><input id="tax_naid_flg" class="trans" name="tax_naid_flg" value="Y" disabled="disabled" type="radio" /> Yes    <input id="tax_naid_flg" class="trans" name="tax_naid_flg" value="N" checked disabled="disabled" type="radio" /> No </td>
			</tr>
		</table>
		
		<table class="search" style="width: 880px;"> 
			<colgroup>
				<col width="95"/>
				<col width="235"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup>
			<tr class="h23">
				<th>흑/적자  구분</th>
				<td><input id="tax_div_cd" class="trans" name="tax_div_cd" value="1" checked disabled="disabled" type="radio" /> 흑자    <input id="tax_div_cd" class="trans" name="tax_div_cd" value="2" disabled="disabled" type="radio" /> 적자 </td>
				<th>고정자산여부</th>
				<td><input id="fa_flg" class="trans" name="fa_flg" value="Y" disabled="disabled" type="radio" /> Yes    <input id="fa_flg" class="trans" name="fa_flg" value="N" checked disabled="disabled" type="radio" /> No </td>	
			</tr>
		</table>
		
		<table class="search" style="width: 880px;"> 
			<colgroup>
				<col width="95"/>
				<col width="235"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup>
			<tr class="h23">
				<th>Tax Type</th>
				<td><input id="tax_pl_cd" class="trans" name="tax_pl_cd" value="1" disabled="disabled" type="radio" /> 영세    <input id="tax_pl_cd" class="trans" name="tax_pl_cd" value="2" checked disabled="disabled" type="radio" /> 과세 </td>
				<th>의제매출분</th>
				<td><input id="tax_nsl_flg" class="trans" name="tax_nsl_flg" value="Y" disabled="disabled" type="radio" /> Yes    <input id="tax_nsl_flg" class="trans" name="tax_nsl_flg" value="N" checked disabled="disabled" type="radio" /> No </td>
			</tr>
		</table>
		
		<table class="search" style="width: 880px;"> 
			<tr class="h23">
				<th>사업자 등록 번호</th>
				<td><input id="spl_rgst_no" style="width:138px;text-align:center;" class="input1" name="spl_rgst_no" maxlength="13" readonly type="text" /> </td>
				<th>사업자명 </th>
				<td><input id="ownr_nm" style="width:128px;" class="input2" name="ownr_nm" readonly type="text" /> </td>
			</tr>
			<tr class="h23">
				<th>상호</th>
				<td><input id="co_nm" style="width:450px;" class="input2" name="co_nm" readonly type="text" /> </td>
				<th> </th>
				<th> </th>
			</tr>
			<tr class="h23">
				<th>업태</th>
				<td><input id="bzct_nm" style="width:450px;" class="input2" name="bzct_nm" readonly type="text" /> </td>
				<th>종목</th>
				<td><input id="bztp_nm" style="width:278px;" class="input2" name="bztp_nm" readonly type="text" /> </td>
			</tr>
			<tr class="h23">
				<th>주소</th>
				<td><input id="spl_addr" style="width:450px;" class="input2" name="spl_addr" readonly type="text" /> </td>
				<th> </th>
				<th> </th>
			</tr>
		</table>
		
		<table class="search" style="width: 880px;"> 
			<colgroup>
				<col width="99"/>
				<col width="100"/>
				<col width="80"/>
				<col width="129"/>
				<col width="50"/>
				<col width="80"/>
				<col width="55"/>
				<col width="*"/>
			</colgroup>
			<tr class="h23">
				<th>발행일 </th>
				<td><input id="iss_dt" style="width:80px;text-align:center;" class="input1" name="iss_dt" maxlength="8" readonly type="text" />  </td>
				<th>공급가액 </th>
				<td><input id="spl_amt" style="width:90px;text-align:right" class="input2" name="spl_amt" readonly type="text" /> </td>
				<th>세액 </th>
				<td><input id="tax_amt" style="width:90px;text-align:right" class="input2" name="tax_amt" readonly type="text" /> </td>
				<th>총합계 </th>
				<td><input id="total_amt" style="width:120px;text-align:right" class="input2" name="total_amt" readonly type="text" /> </td>
			</tr>
		</table>
		
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>			