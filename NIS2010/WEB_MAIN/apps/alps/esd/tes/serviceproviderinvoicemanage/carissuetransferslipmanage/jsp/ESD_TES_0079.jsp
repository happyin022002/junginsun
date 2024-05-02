<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_079.jsp
*@FileTitle : Terminal invoice CSR Creation -계산서
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
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0079Event"%>
<%
	EsdTes0079Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

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
<html>
<head>
<title>Terminal invoice CSR Creation -계산서</title>
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<!-- <input type="hidden" name="compNo"> 밑에 있는걸로 바꿈 2009.11.19 pch --> 
<input type="hidden" name="comp_no">
<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;계산서입력화면</td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button">
       	<tr><td class="align">


		</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->




		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search" border="0" width="100%">

				<tr class="h23">
					<td width="115"><img class="nostar">Service Provider</td>
					<td width="140">&nbsp;<input type="text" name="vndr_seq_hdr" style="width:100"></td>

					<td width="70"><img class="nostar">품의금액</td>
					<td width=""><input type="text" name="total_amt_hdr" style="width:100;text-align:right;"></td>
					<td width="50"><img class="nostar">Type</td>
					<td width="220">전자계산서 <input type="checkbox" name="h_type1" value="ELECTRONIC" style="width:14;" class="trans"  onClick="checkType(this);">&nbsp;
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
							<td width="270" colspan="3"><input type="text" name="volume" style="width:70;" value="">&nbsp;&nbsp;권&nbsp;&nbsp;<input type="text" name="ho" style="width:70;" value="">&nbsp;&nbsp;호</td>

        				</tr>
						<tr>
        					<td class="tr2_head">Tax구분</td>
        					<td colspan="2"><input type="radio" value="tax_flg" class="trans" value="" disabled>&nbsp;개인&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="tax_flg" class="trans" value="" checked>&nbsp;회사&nbsp;</td>
        					<td class="tr2_head" colspan="2">흑/적자구분</td>
							<td colspan="3"><input type="radio" name="finance_flg" value="Y" class="trans">&nbsp;흑자&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="finance_flg" value="N" class="trans">&nbsp;적자&nbsp;</td>

        				</tr>
						<tr>
        					<td class="tr2_head">사업자등록번호</td>
        					<td colspan="2"><input type="text" name="comp_no1" maxlength="3" style="width:72;" value="" onKeyUp='isNum(this);tes_moveFocus(this, this.form.comp_no2, 3);' onKeyDown='isNum(this);tes_chkInput(this);'>&nbsp;-&nbsp;<input type="text" name="comp_no2" maxlength="2" style="width:32;" value="" onKeyUp='isNum(this);tes_moveFocus(this, this.form.comp_no3, 2);' onKeyDown='isNum(this);tes_chkInput(this);'>&nbsp;-&nbsp;<input type="text" maxlength="5" name="comp_no3" style="width:72;" value="" onKeyUp='isNum(this);' onKeyDown='isNum(this);tes_chkInput(this);' onBlur='taxInfo();'></td>
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
        					<td colspan="7"><input type="text"  name="vndr_addr" style="width:612;" value=""></td>

        				</tr>
						<tr>
        					<td class="tr2_head">발행일자</td>
        					<td width="100"><input type="text" name="inv_dt" maxlength="10" style="width:100;" value="" onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='isNum1(this);tes_isNumD(this,"Y");' onBlur="if(validateDateObj2(this)){checkInvDt(this);}"></td>
        					<td class="tr2_head" width="100">공급가액</td>
							<td width="130" colspan="2"><input type="text" name="net_amt" style="width:130;text-align:right;" value=""></td>
        					<td class="tr2_head" width="100">총합계</td>
							<td width="170" colspan="2"><input type="text" name="total_amt" style="width:166;text-align:right;" value=""></td>
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
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_ok" id="btng_ok">완료</td>
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


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

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