<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0078.jsp
*@FileTitle  : Terminal invoice CSR Creation - Tax Invoice
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%
	Exception serverException   = null;			//Server Exception
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet Count

	String tax_no1 = JSPUtil.getKST("yyyyMM");

	try {

	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

%>

<head>
<title>Terminal invoice CSR Creation -세금계산서</title>


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
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="tax_code" id="tax_code" />
<input type="hidden" name="comp_no" id="comp_no" />

<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>세금계산서 입력화면</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_ok_k" 	id="btng_ok_k">완료</button><!--
			--><button type="button" class="btn_normal" name="btng_cancel_k" id="btng_cancel_k">작업취소</button><!--
			--><button type="button" class="btn_normal" name="btng_new_k" id="btng_new_k">다시 입력</button><!--
			--><button type="button" class="btn_normal" name="btng_add_k" id="btng_add_k">추가</button><!--
			--><button type="button" class="btn_normal" name="btng_delete_k" id="btng_delete_k">삭제</button><!--
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
	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="115" />
					<col width="100" />
					<col width="40" />
					<col width="100" />
					<col width="70" />
					<col width="*" />
					<col width="45" />
					<col width="190" />
				</colgroup>
				<tbody>
					<tr>
						<th>Service Provider</th>
						<td><input type="text" name="vndr_seq_hdr" style="width:80px;" id="vndr_seq_hdr" /> </td>
						<th>세액</th>
						<td><input type="text" name="vat_amt_hdr" style="width:90px;text-align:right;" id="vat_amt_hdr" /> </td>
						<th>품의금액</th>
						<td><input type="text" name="total_amt_hdr" style="width:90px;text-align:right;" id="total_amt_hdr" /> </td>
						<th>Type</th>
						<td><label for="h_type1"><b>전자계산서</b></label><input type="checkbox" name="h_type1" value="ELECTRONIC" style="width:14px;" class="trans" onclick="checkType(this);" id="h_type1" />
							<label for="h_type2"><b>종이계산서</b></label><input type="checkbox" name="h_type2" id="h_type2" value="PAPER" style="width:14px;" class="trans" onClick="checkType(this);">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<table class="grid_2 wAuto">
			<colgroup>
				<col width="100" />
				<col width="135" />
				<col width="100" />
				<col width="65" />
				<col width="100" />
				<col width="90" />
				<col width="100" />
				<col width="*" />
			</colgroup>
        				<tr>
        					<th>세금계산서번호</th>
							<td colspan="2"><input type="text" name="tax_no1" maxlength="6" style="width:67px;" value="<%=tax_no1%>" onkeyup="isNum(this);" onkeydown="isNum(this);tes_chkInput(this);" onblur="validateDateObj(this);" id="tax_no1" /><!-- 
							 --><script type="text/javascript">ComComboObject('tax_no2',1, 80 , 0 )</script><!-- 
							 --><input type="text" name="tax_no3" maxlength="4" style="width:65px;" value="" id="tax_no3" /></td>

        					<th colspan="2">권번호</th>
							<td colspan="3"><input type="text" name="volume" style="width:70px;" value="" id="volume" />   권  <input type="text" name="ho" style="width:70px;" value="" id="ho" />   호</td>

        				</tr>
						<tr>
	     					<th>Tax구분</th>
	       					<td colspan="2">      <input type="radio" name="tax_flg" value="0" class="trans" disabled id="tax_flg1" /><label for="tax_flg1">개인</label>      <input type="radio" name="tax_flg" value="10" class="trans" checked="" id="tax_flg2" /><label for="tax_flg2">회사</label></td>
	       					<th colspan="2">매입세액불공제</th>
							<td colspan="3">      <input type="radio" name="tax_naid_flg" value="Y" class="trans" id="tax_naid_flg1" /><label for="tax_naid_flg1">Yes</label>      <input type="radio" name="tax_naid_flg" value="N" class="trans" checked="" id="tax_naid_flg2" /><label for="tax_naid_flg2">No</label></td>

        				</tr>
						<tr>
        					<th>흑/적자구분</th>
        					<td colspan="2">      <input type="radio" name="finance_flg" value="Y" class="trans" id="finance_flg1" /><label for="finance_flg1">흑자</label>      <input type="radio" name="finance_flg" value="N" class="trans" id="finance_flg2" /><label for="finance_flg2">적자</label>   </td>
        					<th colspan="2">고정자산여부</th>
							<td colspan="3">      <input type="radio" name="fa_flg" value="Y" class="trans" id="fa_flg1" /><label for="fa_flg1">Yes</label>      <input type="radio" name="fa_flg" value="N" class="trans" checked="" id="fa_flg2" /><label for="fa_flg2">No</label>   </td>


        				</tr>
						<tr>
        					<th>Tax Type</th>
        					<td colspan="2">      <input type="radio" name="tax_type" value="0" class="trans" id="tax_type1" /><label for="tax_type1">영세</label>      <input type="radio" name="tax_type" value="10" class="trans" id="tax_type2" /><label for="tax_type2">과세</label>   </td>
        					<th colspan="2">의제매출분</th>
							<td colspan="3">      <input type="radio" name="tax_nsl_flg" value="Y" class="trans" id="tax_nsl_flg1" /><label for="tax_nsl_flg1">Yes</label>      <input type="radio" name="tax_nsl_flg" value="N" class="trans" checked="" id="tax_nsl_flg2" /><label for="tax_nsl_flg2">No</label>   </td>


        				</tr>
						<tr>
        					<th>사업자등록번호</th>
        					<td colspan="2"><input type="text" name="comp_no1" maxlength="3" style="width:72px;" value="" onkeyup="isNum(this);tes_moveFocus(this, this.form.comp_no2, 3);" onkeydown="isNum(this);tes_chkInput(this);" id="comp_no1" />  - <input type="text" name="comp_no2" style="width:32px;" value="" maxlength="2" onkeyup="isNum(this);tes_moveFocus(this, this.form.comp_no3, 2);" onkeydown="isNum(this);tes_chkInput(this);" id="comp_no2" />  - <input type="text" name="comp_no3" style="width:72px;" value="" maxlength="5" onkeyup="isNum(this);" onkeydown="isNum(this);tes_chkInput(this);" onblur="taxInfo();" id="comp_no3" /> </td>
        					<th colspan="2">Vendor Code</th>
							<td colspan="3"><input type="text" name="vndr_seq" value="" style="width:100%;" id="vndr_seq" /> </td>

        				</tr>
						<tr>
        					<th>상호</th>
        					<td colspan="2"><input type="text" name="vndr_nm" style="width:100%;" value="" id="vndr_nm" /> </td>
        					<th colspan="2">대표자명</th>
							<td colspan="3"><input type="text" name="ceo_nm" style="width:100%;" value="" id="ceo_nm" /> </td>

        				</tr>
						<tr>
        					<th>업태</th>
        					<td colspan="2"><input type="text" name="bzct_nm" style="width:100%;" value="" id="bzct_nm" /> </td>
        					<th colspan="2">종목</th>
							<td colspan="3"><input type="text" name="bztp_nm" style="width:100%;" value="" id="bztp_nm" /> </td>

        				</tr>
						<tr>
        					<th>주소</th>
        					<td colspan="7"><input type="text" name="vndr_addr" style="width:100%;" value="" id="vndr_addr" /> </td>

        				</tr>
						<tr>
        					<th>발행일자</th>
        					<td><input type="text" name="inv_dt" maxlength="10" style="width:100%;" value="" onkeyup="isNum1(this);tes_isNumD(this,"Y");" onkeydown="isNum1(this);tes_isNumD(this,&quot;Y&quot;);" onblur="if(validateDateObj2(this)){checkInvDt(this);}" id="inv_dt" /> </td>
        					<th>공급가액</th>
							<td><input type="text" name="net_amt" style="width:100%;text-align:right;" value="" id="net_amt" /> </td>
        					<th>세액</th>
							<td><input type="text" name="vat_amt" style="width:100%;text-align:right;" value="" id="vat_amt" /> </td>
							<th>총합계</th>
							<td><input type="text" name="total_amt" style="width:100%;text-align:right;" value="" id="total_amt" /> </td>
        				</tr>
        		</table>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>


<DIV style="display:none">
<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
                       
</DIV>


  <Script type="text/javascript" for="sheet1" event="OnChange(Row,Col,Value)">
    		var net_amt  = 0;
     		var vat_amt  = 0;
     		var total_amt= 0;
     		var netArr = new Array();
     		var vatArr = new Array();
     		var minVatArr = new Array();
     		var maxVatArr = new Array();

				if(Col==4){
					if (!(document.form.vat_amt_hdr.value == 0 && document.form.tax_type[0].checked == true)){
						sheetObjects[0].CellValue2(Row, 5) = Math.round((parseFloat(sheetObjects[0].CellValue(Row,4)*100)/10)/100);
					}
				}

				if(Col==5){
						for(var i=0;i<sheetObjects[0].RowCount;i++){
								netArr[i] = sheetObjects[0].CellValue(i+1, 4);
								vatArr[i] = Math.round((parseFloat(sheetObjects[0].CellValue(i+1,4)*100)/10)/100);
								maxVatArr[i] = Math.round((parseFloat(sheetObjects[0].CellValue(i+1,4)*100)/10)/100)+10;
							  minVatArr[i] = Math.round((parseFloat(sheetObjects[0].CellValue(i+1,4)*100)/10)/100)-10;
						}

						if(maxVatArr[Row-1]<sheetObjects[0].CellValue(Row, 5) || minVatArr[Row-1]>sheetObjects[0].CellValue(Row, 5)){
								ComShowMessage("세액 변경 금액 기준을 초과 하였습니다. 다시 확인하세요.");
								sheetObjects[0].CellValue2(Row, 5) = Math.round((parseFloat(sheetObjects[0].CellValue(Row,4)*100)/10)/100);
						}
				}

     		//if(Col == 4 || Col == 5){
 				for(var i = 0;i<sheetObjects[0].RowCount;i++){
 					net_amt = parseFloat(sheetObjects[0].CellValue(i+1,4)*100)+parseFloat(net_amt);
					vat_amt = parseFloat(sheetObjects[0].CellValue(i+1,5)*100)+parseFloat(vat_amt);
 					total_amt = parseFloat(sheetObjects[0].CellValue(i+1,6)*100)+parseFloat(total_amt);
 				}
     		//}

        document.form.net_amt.value 			= tes_addComma(net_amt/100);
        document.form.vat_amt.value 			= tes_addComma(vat_amt/100);
        document.form.total_amt.value 		= tes_addComma(total_amt/100);
  </Script>