<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0029.jsp
*@FileTitle  : Tax Evidence
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0029Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log = Logger.getLogger("com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0029Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}

	String evidTpCd 	= StringUtil.xssFilter(request.getParameter("evid_tp_cd"));
	String tmpYrmon 	= StringUtil.xssFilter(request.getParameter("tax_inv_yrmon"));
	String temp1		= tmpYrmon.substring(0,4);
	String temp2		= tmpYrmon.substring(4,6);
	String taxInvYrmon	= temp1+"-"+temp2.toString();
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

<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<input type="hidden" name="evid_tp_cd" value="<%=evidTpCd%>" id="evid_tp_cd" />


<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Tax Evidence</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_confirm" 	id="btn_confirm">Confirm</button><!--
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id=btn_close>Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table class="wAuto">
				<colgroup>
					<col width="*" />
					<col width="*" />
					<col width="*" />
					<col width="*" />
					<col width="*" />
					<col width="*" />
					<col width="*" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>세금계산서 번호</th>
						<td><input type="text" style="width:60px;text-align:center;" class="input1" name="tax_inv_yrmon" id="tax_inv_yrmon" maxlength="6" value=<%=taxInvYrmon%> dataformat="ym"     caption="Tax Inv Yrmon"   /><button type="button" id="tax_inv_yrmon_cal" name="tax_inv_yrmon_cal" class="calendar ir"></button>
							<select style="width:180px;" class="input1" name="ofc_cd" id="ofc_cd">
							</select>
						</td>
						<th class="sm">Type</th>
						<td class="sm"><input type="radio" class="trans" name="tax_iss_cd" value="ELECTRONIC" id="tax_iss_cd" /><label for="tax_iss_cd">전자</label><input type="radio" class="trans" name="tax_iss_cd" value="PAPER" id="tax_iss_cd" /><label for="tax_iss_cd">종이</label></td>
						<td colspan="4"></td>
					</tr>
					<tr>
						<th>Tax 구분</th>
						<td><input type="radio" class="trans" name="tax_vat_tp_cd" value="1" id="tax_vat_tp_cd" /><label for="tax_vat_tp_cd">개인</label><input type="radio" class="trans" name="tax_vat_tp_cd" value="2" checked id="tax_vat_tp_cd" /><label for="tax_vat_tp_cd">회사</label></td>
						<th>매입세액불공제</th>
						<td colspan="5"><input type="radio" class="trans" name="tax_naid_flg" value="Y" disabled id="tax_naid_flg" /><label for="tax_naid_flg">Yes</label><input type="radio" class="trans" name="tax_naid_flg" value="N" checked disabled id="tax_naid_flg" /><label for="tax_naid_flg">No</label></td>
					</tr>
					<tr>
						<th>흑/적자  구분</th>
						<td><input type="radio" class="trans" name="tax_div_cd" value="1" checked onclick="gridReset();" id="tax_div_cd" /><label for="tax_div_cd">흑자</label><input type="radio" class="trans" name="tax_div_cd" value="2" onclick="gridReset();" id="tax_div_cd" /><label for="tax_div_cd">적자</label></td>
						<th>고정자산여부</th>
						<td colspan="5"><input type="radio" class="trans" name="fa_flg" value="Y" disabled id="fa_flg" /><label for="fa_flg">Yes</label><input type="radio" class="trans" name="fa_flg" value="N" checked disabled id="fa_flg" /><label for="fa_flg">No</label></td>
					</tr>
					<tr>
						<span id="l_evid_tp_cd">
							<th>Tax Type</th>
							<td><input type="radio" class="trans" name="tax_pl_cd" value="1" onclick="gridReset();" id="tax_pl_cd" /><label for="tax_pl_cd">영세</label><input type="radio" class="trans" name="tax_pl_cd" value="2" checked onclick="gridReset();" id="tax_pl_cd" /><label for="tax_pl_cd">과세</label></td>
						</span>
						<th>의제매출분</th>
						<td colspan="5"><input type="radio" class="trans" name="tax_nsl_flg" value="Y" disabled id="tax_nsl_flg" /><label for="tax_nsl_flg">Yes</label><input type="radio" class="trans" name="tax_nsl_flg" value="N" checked disabled id="tax_nsl_flg" /><label for="tax_nsl_flg">No</label></td>
					</tr>
					<tr>
						<th>사업자 등록 번호</th>
						<td><input type="text" style="width:138px;text-align:center;" class="input1" name="spl_rgst_no" maxlength="13" dataformat="saupja" required  caption="Spl Rgst No" id="spl_rgst_no" /> </td>
						<th>사업자명 </th>
						<td colspan="5"><input type="text" style="width:128px;" class="input2" name="ownr_nm" readonly id="ownr_nm" /> </td>
					</tr>
					<tr>
						<th>상호</th>
						<td colspan="7"><input type="text" style="width:450px;" class="input2" name="co_nm" readonly id="co_nm" /> </td>
					</tr>
					<tr>
						<th>업태</th>
						<td><input type="text" style="width:450px;" class="input2" name="bzct_nm" readonly id="bzct_nm" /> </td>
						<th>종목</th>
						<td colspan="5"><input type="text" style="width:278px;" class="input2" name="bztp_nm" readonly id="bztp_nm" /> </td>
					</tr>
					<tr>
						<th>주소</th>
						<td colspan="7"><input type="text" style="width:450px;" class="input2" name="spl_addr" readonly id="spl_addr" /> </td>
					</tr>
					<tr>
						<th>발행일 </th>
						<td><input type="text" style="width:80px;text-align:center;" class="input1" name="iss_dt" dataformat="ymd" required="" fullfill="" caption="Iss Date" id="iss_dt" />  <button type="button" id="iss_dt_cal" name="iss_dt_cal" class="calendar ir"></button></td>
						<th>공급가액 </th>
						<td><input type="text" style="width:90px;text-align:right" class="input2" name="spl_amt" readonly id="spl_amt" /> </td>
						<th>세액 </th>
						<td><input type="text" style="width:90px;text-align:right" class="input2" name="tax_amt" readonly id="tax_amt" /> </td>
						<th>총합계 </th>
						<td><input type="text" style="width:96px;text-align:right" class="input2" name="total_amt" readonly id="total_amt" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_rowAdd" 	id="btn_rowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_rowDel" id="btn_rowDel">Row Del</button><!--
			--></div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>			