<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0078.jsp
*@FileTitle : Terminal invoice CSR Creation -세금계산서
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-12-28 jongbaemoon
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

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
<html>
<head>
<title>Terminal invoice CSR Creation -세금계산서</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="tax_code">
<!-- <input type="hidden" name="compNo"> 밑에 있는걸로 바꿈 2009.11.19 pch --> 
<input type="hidden" name="comp_no">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;세금계산서 입력화면</td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search" border="0" width="100%" >

				<tr class="h23">
					<td width="115"><img class="nostar">Service Provider</td>
					<td width="100">&nbsp;<input type="text" name="vndr_seq_hdr" style="width:80"></td>
					<td width="40"><img class="nostar">세액</td>
					<td width="100"><input type="text" name="vat_amt_hdr" style="width:90;text-align:right;"></td>
					<td width="70"><img class="nostar">품의금액</td>
					<td width=""><input type="text" name="total_amt_hdr" style="width:90;text-align:right;"></td>
					<td width="45"><img class="nostar">Type</td>
					<td width="190">전자계산서 <input type="checkbox" name="h_type1" value="ELECTRONIC" style="width:14;" class="trans" onClick="checkType(this);">&nbsp;
								          종이계산서 <input type="checkbox" name="h_type2" value="PAPER" style="width:14;" class="trans" onClick="checkType(this);">
					</td>
					
				</tr>
				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options : Related COP Information  ) (S) -->
		<table class="search">
        	<tr><td class="bg">

        			<table border="0" class="grid2" width="100%" background-color:white;>
        				<tr>
        					<td class="tr2_head" width="137">세금계산서번호</td>
        					<td width="200" colspan="2">

								<table class="search">
									<tr class="h23">
										<td width="33%"><input type="text" name="tax_no1" maxlength="6" style="width:67;" value="<%=tax_no1%>" onKeyUp='isNum(this);' onKeyDown='isNum(this);tes_chkInput(this);' onBlur='validateDateObj(this);'></td>
										<td width="33%"><script language="javascript">ComComboObject('tax_no2',1, 80 , 0 )</script></td>
										<td><input type="text" name="tax_no3" maxlength="4" style="width:65;" value=""></td>
									</tr>
								</table>

							</td>
        					<td class="tr2_head" width="130" colspan="2">권번호</td>
							<td width="260" colspan="3"><input type="text" name="volume" style="width:70;" value="">&nbsp;&nbsp;권&nbsp;&nbsp;<input type="text" name="ho" style="width:70;" value="">&nbsp;&nbsp;호</td>

        				</tr>
						<tr>
     					<td class="tr2_head">Tax구분</td>
        					<td colspan="2"><input type="radio" name="tax_flg" value="0" class="trans" disabled>&nbsp;개인&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="tax_flg" value="10" class="trans" checked>&nbsp;회사&nbsp;</td>
        					<td class="tr2_head" colspan="2">매입세액불공제</td>
							<td colspan="3"><input type="radio" name="tax_naid_flg" value="Y" class="trans">&nbsp;Yes&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="tax_naid_flg" value="N" class="trans" checked>&nbsp;No&nbsp;</td>

        				</tr>
						<tr>
        					<td class="tr2_head">흑/적자구분</td>
        					<td colspan="2"><input type="radio" name="finance_flg" value="Y" class="trans">&nbsp;흑자&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="finance_flg" value="N" class="trans">&nbsp;적자&nbsp;</td>
        					<td class="tr2_head" colspan="2">고정자산여부</td>
							<td colspan="3"><input type="radio" name="fa_flg" value="Y" class="trans">&nbsp;Yes&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="fa_flg" value="N" class="trans" checked>&nbsp;No&nbsp;</td>


        				</tr>
						<tr>
        					<td class="tr2_head">Tax Type</td>
        					<td colspan="2"><input type="radio" name="tax_type" value="0" class="trans">&nbsp;영세&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="tax_type" value="10" class="trans">&nbsp;과세&nbsp;</td>
        					<td class="tr2_head" colspan="2">의제매출분</td>
							<td colspan="3"><input type="radio" name="tax_nsl_flg" value="Y" class="trans">&nbsp;Yes&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="tax_nsl_flg" value="N" class="trans" checked>&nbsp;No&nbsp;</td>


        				</tr>
						<tr>
        					<td class="tr2_head">사업자등록번호</td>
        					<td colspan="2"><input type="text" name="comp_no1" maxlength="3" style="width:72;" value="" onKeyUp='isNum(this);tes_moveFocus(this, this.form.comp_no2, 3);' onKeyDown='isNum(this);tes_chkInput(this);'>&nbsp;-&nbsp;<input type="text" name="comp_no2" style="width:32;" value="" maxlength="2" onKeyUp='isNum(this);tes_moveFocus(this, this.form.comp_no3, 2);' onKeyDown='isNum(this);tes_chkInput(this);' >&nbsp;-&nbsp;<input type="text" name="comp_no3" style="width:72;" value="" maxlength="5" onKeyUp='isNum(this);' onKeyDown='isNum(this);tes_chkInput(this);' onblur='taxInfo();'></td>
        					<td class="tr2_head" colspan="2">Vendor Code</td>
							<td colspan="3"><input type="text" name="vndr_seq" value="" style="width:270;"></td>

        				</tr>
						<tr>
        					<td class="tr2_head">상호</td>
        					<td colspan="2"><input type="text" name="vndr_nm" style="width:196;" value=""></td>
        					<td class="tr2_head" colspan="2">대표자명</td>
							<td colspan="3"><input type="text" name="ceo_nm" style="width:270;" value=""></td>

        				</tr>
						<tr>
        					<td class="tr2_head">업태</td>
        					<td colspan="2"><input type="text" name="bzct_nm" style="width:196;" value=""></td>
        					<td class="tr2_head" colspan="2">종목</td>
							<td colspan="3"><input type="text" name="bztp_nm" style="width:270;" value=""></td>

        				</tr>
						<tr>
        					<td class="tr2_head">주소</td>
        					<td colspan="7"><input type="text" name="vndr_addr" style="width:614;" value=""></td>

        				</tr>
						<tr>
        					<td class="tr2_head">발행일자</td>
        					<td width="100"> <input type="text" name="inv_dt" maxlength="10" style="width:100;" value="" onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='isNum1(this);tes_isNumD(this,"Y");' onBlur="if(validateDateObj2(this)){checkInvDt(this);}"></td>
        					<td class="tr2_head" width="100">공급가액</td>
							<td width="65"> <input type="text" name="net_amt" style="width:65;text-align:right;" value=""></td>
        					<td class="tr2_head" width="65">세액</td>
							<td width="90"> <input type="text" name="vat_amt"  style="width:90;text-align:right;" value=""></td>
							<td class="tr2_head" width="70">총합계</td>
							<td width="110"> <input type="text" name="total_amt"  style="width:102;text-align:right;" value=""></td>
        				</tr>
        		</table>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Related COP Information) (E) -->

		<table class="height_10"><tr><td></td></tr></table>



		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">

			<table class="height_10"><tr><td></td></tr></table>

			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
			<!-- : ( Grid : Week ) (E) -->


			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
						<tr><td class="btn2_bg" class="align">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_ok_k" id="btng_ok_k">완료</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_cancel_k" id="btng_cancel_k">작업취소</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_new_k" id="btng_new_k">다시 입력</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_add_k" id="btng_add_k">추가</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_delete_k" id="btng_delete_k">삭제</td>
									<td class="btn2_right"></td></tr></table></td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td></tr>
					</table>
	    	<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_10"><tr><td></td></tr></table>

</form>
</body>
</html>
<DIV style="display:none">
		<table class="height_5"><tr><td></td></tr></table>
		<!--grid start-->

		<table width="50%" id="mainTable">
                  <tr><td>
                       <script language="javascript">ComSheetObject('sheet2');</script>
                  </td></tr>
          </table>

		<!--grid end-->

		<table class="height_10"><tr><td></td></tr></table>
</DIV>


  <Script Language="javascript" for="sheet1" event="OnChange(Row,Col,Value)">
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
