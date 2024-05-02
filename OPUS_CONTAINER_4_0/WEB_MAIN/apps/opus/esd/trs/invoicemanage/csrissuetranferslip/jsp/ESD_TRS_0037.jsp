<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0037.jsp
*@FileTitle  : Transportion invoice CSR Creation - Statements
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0037Event"%>
<%
	EsdTrs0037Event  	event 					= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 				serverException	= null;		//Error occurred on the server
	String 						strErrMsg 				= "";		//Error message
	String 						sUserId 				= "";
	String						sCreOfcCd				= "";

	String 						tax_no1 		= JSPUtil.getKST("yyyyMM");
	tax_no1										= "";

	try {
	     SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	     sUserId		= account.getUsr_id();
	     sCreOfcCd	= account.getOfc_cd();

		event = (EsdTrs0037Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
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
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		insertValueEvi();
	}
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="wo_vndr_seq"	id="wo_vndr_seq">
<input type="hidden" name="iPage" id="iPage">
<input type="hidden" name ="cre_usr_id" id="cre_usr_id" value="<%=sUserId%>"		>
<input type="hidden" name ="cre_ofc_cd" id="cre_ofc_cd" value="<%=sCreOfcCd%>"		>

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>계산서입력화면</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btng_ok_k" id="btng_ok_k">완료</button><!--
			--><button type="button" class="btn_normal" name="btng_cancel_k" id="btng_cancel_k">작업취소</button><!--
			--><button type="button" class="btn_normal" name="btng_new_k" id="btng_new_k">다시입력</button><!--
			--><button type="button" class="btn_normal" name="btng_add_k" id="btng_add_k">추가</button><!--
			--><button type="button" class="btn_normal" name="btng_delete_k" id="btng_delete_k">삭제</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<th width="50">Vendor</th>
						<td width="130"><input type="text" class="input1" name="vndr_seq_hdr" style="width:100"></td>
						<th width="60">품의금액</th>
						<td width="130"><input type="text" class="input1" name="total_amt_hdr" style="width:100"></td>
						<th width="50">페이지</th>
						<td width="70"><input type="text" name="page" style="width:37" value="1" style="text-align:right;"></td>
						<th width="40">Type</th>
						<td>
							<input type="checkbox" id="electronic" name="electronic" value="" onClick="javascript:checkType();"><label for="electronic">전자계산서</label><!--
							--><input type="checkbox" id="paper" name="paper" value="" onClick="javascript:checkType();"><label for="paper">종이계산서</label>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="wrap_result">
		<div class="opus_design_grid" >
			<table border="0" class="grid2" style="width:100%;">
				<tr>
					<th width="150">세금계산서번호</th>
					<td width="200" colspan="2" style="padding-left:6;">
						<table style="border:0px !important; width:208px; " cellspacing="0" cellpadding="0">
							<tr>
								<td style="border:0px !important; width:62;"><input type="text" name="tax_no1" maxlength="6" style="width:100%;" value="<%=tax_no1%>" ></td>
								<td style="border:0px !important; width:73;"><script language="javascript">ComComboObject('tax_no2', 1, 69, 1)</script></td>
								<td style="border:0px !important;"><input type="text" name="tax_no3" maxlength="4" style="width:100%;" value=""></td>
							</tr>
						</table>
					</td>
					<th width="130" colspan="2">권번호</th>
					<td width="270" colspan="3" style="padding:0,6;"><input type="text" name="volume" style="width:70;" value="">권<input type="text" name="ho" style="width:70;" value="">호</td>
	
	  				</tr>
				<tr>
					<th>Tax구분</th>
					<td colspan="2" style="padding:0,6;">
						<input type="radio" name="tax_flg" id="tax_flg_P" value="" disabled><label for="tax_flg_P">개인</label><!--
		   				--><input type="radio" name="tax_flg" id="tax_flg_C" value="" checked><label for="tax_flg_C">회사</label>
					</td>
					<th colspan="2">흑/적자구분</th>
					<td colspan="3" style="padding:0,6;">
						<input type="radio" name="finance_flg" id="finance_flg_G" value="Y"><label for="finance_flg_G">흑자</label><!--
		   				--><input type="radio" name="finance_flg" id="finance_flg_D" value="N"><label for="finance_flg_D">적자</label>
					</td>
				</tr>
				<tr>
					<th>사업자등록번호</th>
					<td colspan="2" style="padding:0,6;">
					<input type="text" name="comp_no1" maxlength="3" style="width:72px;" value="" onKeyUp='moveFocus(this, this.form.comp_no2, 3);' >-<input type="text" name="comp_no2" maxlength="2" style="width:40px;" value="" onKeyUp='moveFocus(this, this.form.comp_no3, 2);' >-<input type="text" maxlength="5" name="comp_no3" style="width:73px;" value="" >
					</td>
					<th colspan="2">Vendor Code</th>
					<td colspan="3" style="padding:0,6;"><input type="text" name="vndr_seq" value="" style="width:100%;"></td>
				</tr>
				<tr>
					<th>상호</th>
					<td colspan="2" style="padding:0,6;"><input type="text" name="vndr_nm" style="width:100%;" value=""></td>
					<th colspan="2">대표자명</th>
					<td colspan="3" style="padding:0,6;"><input type="text" name="ceo_nm" style="width:100%;" value=""></td>
				</tr>
				<tr>
					<th>업태</th>
					<td colspan="2" style="padding:0,6;"><input type="text" name="bzct_nm" style="width:100%;" value=""></td>
					<th colspan="2">종목</th>
					<td colspan="3" style="padding:0,6;"><input type="text" name="bztp_nm" style="width:100%;" value=""></td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan="7" style="padding:0,6;"><input type="text"  name="vndr_addr" style="width:100%;" value=""></td>
				</tr>
				<tr>
					<th>발행일자</th>
					<td width="100" style="padding:0,6;"><input type="text" name="inv_dt" maxlength="10" style="width:100%;" value="" onKeyUp='ComIsNumber(this)' onKeyDown='ComIsNumber(this)' onBlur='BlurDate(this);'></td>
					<th width="100">공급가액</th>
					<td width="130" style="padding:0,6;" colspan="2"><input type="text" name="net_amt" style="width:100%;" value=""></td>
					<th width="100">총합계</th>
					<td width="170" style="padding:0,6;" colspan="2"><input type="text" name="total_amt" style="width:100%;" value=""></td>
				</tr>
			</table>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>
<div style="display:none">
	<div class="opus_design_grid" >
	        <script language="javascript">ComSheetObject('sheet2');</script>
	</div>
</div>