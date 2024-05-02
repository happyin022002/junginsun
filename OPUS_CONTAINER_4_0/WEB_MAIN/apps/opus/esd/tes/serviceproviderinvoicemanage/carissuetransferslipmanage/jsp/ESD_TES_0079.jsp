<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0079.jsp
*@FileTitle  : Terminal invoice CSR Creation - Bills
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0079Event"%>
<%
	EsdTes0079Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet Count

	String tax_no1 = JSPUtil.getKST("yyyyMM");

	try {

	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();

		event = (EsdTes0079Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end else
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
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		insertValueEvi();
	}
</script>
<form name="form" >
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="comp_no" id="comp_no" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>계산서입력화면</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	      <button class="btn_accent" type="button"  name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_data">
		<table>
			<tbody>
				<colgroup>
					<col width="100">
					<col width="130">
					<col width="60">
					<col width="130">
					<col width="60">
					<col width="*">
				</colgroup>
				<tr>
					<th>Service Provider</th>
					<td><input type="text" name="vndr_seq_hdr" id="vndr_seq_hdr" style="width:100px"></td>
					<th>품의금액</th>
					<td><input type="text" name="total_amt_hdr" id="total_amt_hdr" style="width:100px;text-align:right;"></td>
					<th>Type</th>
					<td>
						전자계산서 <input type="checkbox" name="h_type1" id="h_type1" value="ELECTRONIC" style="width:14px;" class="trans"  onClick="checkType(this);">&nbsp;&nbsp;
						종이계산서 <input type="checkbox" name="h_type2" id="h_type2" value="PAPER" style="width:14px;" class="trans" onClick="checkType(this);">
					</td>
				</tr>
			</tbody>
		</table>
		<table class="grid2">
			<tbody>
				<colgroup>
					<col width="140">
					<col width="100">
					<col width="120">
					<col width="100">
					<col width="120">
					<col width="*">
				</colgroup>
				<tr>
     				<th>세금계산서번호</th>
					<td colspan="2">
						<input type="text" name="tax_no1" id="tax_no1" maxlength="6" style="width:67px;" value="<%=tax_no1%>" onKeyUp='isNum(this);' onKeyDown='isNum(this);tes_chkInput(this);' onBlur='validateDateObj(this);'><!-- 
						 --><script type="text/javascript">ComComboObject('tax_no2',1, 80 , 0 )</script><!-- 
						 --><input type="text" name="tax_no3" id="tax_no3" maxlength="4" style="width:65px;" value="">
					</td>
     				<th>권번호</th>
					<td colspan="3">
						<input type="text" name="volume" id="volume" style="width:70px;" value="">권 <input type="text" name="ho" id="ho" style="width:70px;" value="">호
					</td>
      			</tr>
				<tr>
    				<th>Tax구분</th>
    				<td colspan="2">
    					<input type="radio" value="tax_flg" class="trans" value="" disabled>&nbsp;개인 <input type="radio" value="tax_flg" class="trans" value="" checked>&nbsp;회사
    				</td>
    				<th>흑/적자구분</th>
					<td colspan="3">
						&nbsp;<input type="radio" name="finance_flg" id="radio_finance_flg" value="Y" class="trans"><label for="radio_finance_flg">흑자</label>
						<input type="radio" name="finance_flg" id="radio_finance_flg1" value="N" class="trans"><label for="radio_finance_flg1">적자</label>
					</td>
      			</tr>
				<tr>
     				<th>사업자등록번호</th>
     				<td colspan="2">
   						<input type="text" name="comp_no1" id="comp_no1" maxlength="3" style="width:72px;" value="" onKeyUp='isNum(this);tes_moveFocus(this, this.form.comp_no2, 3);' onKeyDown='isNum(this);tes_chkInput(this);'>- <!-- 
   						 --><input type="text" name="comp_no2" id="comp_no2" maxlength="2" style="width:32px;" value="" onKeyUp='isNum(this);tes_moveFocus(this, this.form.comp_no3, 2);' onKeyDown='isNum(this);tes_chkInput(this);'>-&nbsp;<!-- 
   						 --><input type="text" maxlength="5" name="comp_no3"  id="comp_no3" style="width:72px;" value="" onKeyUp='isNum(this);' onKeyDown='isNum(this);tes_chkInput(this);' onBlur='taxInfo();'>
   					</td>
     				<th>Vendor Code</th>
					<td colspan="3"><input type="text" name="vndr_seq" id="vndr_seq" value="" style="width:270px;"></td>
      			</tr>
				<tr>
     				<th>상호</th>
     				<td colspan="2"><input type="text" name="vndr_nm" id="vndr_nm" style="width:196px;" value=""></td>
     				<th>대표자명</th>
					<td colspan="3"><input type="text" name="ceo_nm" id="ceo_nm" style="width:270px;" value=""></td>
      			</tr>
				<tr>
     				<th>업태</th>
     				<td colspan="2"><input type="text" name="bzct_nm" id="bzct_nm" style="width:196px;" value=""></td>
     				<th>종목</th>
					<td colspan="3"><input type="text" name="bztp_nm" id="bztp_nm" style="width:270px;" value=""></td>
      			</tr>
				<tr>
      				<th>주소</th>
      				<td colspan="7"><input type="text"  name="vndr_addr" id="vndr_addr" style="width:612px;" value=""></td>
      			</tr>
				<tr>
					<th>발행일자</th>
					<td>
						<input type="text" name="inv_dt" id="inv_dt" maxlength="10" style="width:100px;" value="" onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='isNum1(this);tes_isNumD(this,"Y");' onBlur="if(validateDateObj2(this)){checkInvDt(this);}">
					</td>
					<th>공급가액</th>
					<td><input type="text" name="net_amt" id="net_amt" style="width:130px;text-align:right;" value=""></td>
     				<th>총합계</th>
					<td><input type="text" name="total_amt" id="total_amt" style="width:150px;text-align:right;" value=""></td>
     			</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid"  id="mainTable">
		<div class="opus_design_btn">
		     	<button type="button" class="btn_normal" name="btng_ok" id="btng_ok">완료</button><!-- 
			 --><button type="button" class="btn_normal"  name="btng_cancel_k" id="btng_cancel_k">작업취소</button><!-- 
			 --><button type="button" class="btn_normal"  name="btng_new_k" id="btng_new_k">다시 입력</button><!-- 
			 --><button type="button" class="btn_normal"  name="btng_add_k" id="btng_add_k">추가</button><!-- 
			 --><button type="button" class="btn_normal"  name="btng_delete_k" id="btng_delete_k">삭제</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<div style="display:none">
           <script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>	
</form>