<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0034.jsp
*@FileTitle : Terminal invoice CSR Creation -세금계산서
*Open Issues :
*Change history :
*@LastModifyDate : 2010-07-08
*@LastModifier : kimjin
*@LastVersion : 1.1
* 2009-10-01 kimjin    1.0 최초 생성
* 2010-07-08 Sun, Choi 1.1 발행일자 포맷 하이픈 추가
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0034Event"%>
<%
	EsdTrs0034Event  			event 				= null;			//PDTO(Data Transfer Object including Parameters)
	Exception 					serverException   	= null;			//서버에서 발생한 에러
	String 						strErrMsg 			= "";			//에러메세지
	String 						sUserId 			= "";
	String						sCreOfcCd			= null;
	String 						tax_no1 			= JSPUtil.getKST("yyyyMM");

	try {

	     SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	     sUserId					= account.getUsr_id();
	     sCreOfcCd					= account.getOfc_cd();

		event 						= (EsdTrs0034Event)request.getAttribute("Event");

		serverException 			= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Transportion invoice CSR Creation -세금계산서</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		insertValueEvi();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"									>
<input type="hidden" name="iPage"									>
<input type="hidden" name="tax_code"								>
<input type="hidden" name="wo_vndr_seq"								>
<input type="hidden" name ="cre_usr_id" value="<%=sUserId%>"		>
<input type="hidden" name ="cre_ofc_cd" value="<%=sCreOfcCd%>"		>


<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="806" border="0" >
		<tr><td height="79" class="title"><img src="img/alps/ico_t1.gif" width="20" height="12">세금계산서입력화면 </td></tr>
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
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="50">Vendor</td>
					<td width="130"><input type="text" class="input1" name="vndr_seq_hdr" style="width:110"></td>
					<td width="35">세액</td>
					<td width="130"><input type="text" class="input1" name="vat_amt_hdr" style="width:110"></td>
					<td width="60">품의금액</td>
					<td width="150"><input type="text" class="input1" name="total_amt_hdr" style="width:110"></td>
					<td width="50">페이지</td>
					<td width="80"><input type="text" name="page" class="input" style="width:37; " value="1"></td>
					<td width="50">Type</td>
					<td>
					<input type="checkbox" name="electronic" value="" class="checkbox" onClick="javascript:checkType();">&nbsp;전자계산서&nbsp;
					<input type="checkbox" name="paper" value="" class="checkbox" onClick="javascript:checkType();">&nbsp;종이계산서
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

        			<table border="0" class="grid2" style="width:972; background-color:white;">
        				<tr>
        					<td class="tr2_head">세금계산서번호</td>
        					<td colspan="3" valign="center" cellspacing="0">

        						<table border="0" cellspacing="0" cellpadding="0">
        							<tr>
        								<td>
        									&nbsp;<input type="text" name="tax_no1" maxlength="6" style="width:61;" value="<%=tax_no1%>" >
        								</td>
        								<td>
        									&nbsp;<script language="javascript">ComComboObject('tax_no2', 1, 69, 1)</script>
        								</td>
        								<td>
        									&nbsp;<input type="text" name="tax_no3" maxlength="4" style="width:50;" value="">
        								</td>
        							</tr>
        						</table>
        					</td>
        					<td class="tr2_head" colspan="1">권번호</td>
							<td colspan="3">&nbsp;<input type="text" name="volume" style="width:70;" value="">&nbsp;&nbsp;권&nbsp;&nbsp;<input type="text" name="ho" style="width:70;" value="">&nbsp;&nbsp;호</td>

        				</tr>
						<tr>
        					<td class="tr2_head">Tax구분</td>
        					<td colspan="3">&nbsp;<input type="radio" name="tax_flg" value="0" class="trans" disabled>&nbsp;개인&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="tax_flg" value="10" class="trans" checked>&nbsp;회사&nbsp;</td>
        					<td class="tr2_head" colspan="1">매입세액불공제</td>
							<td colspan="3">&nbsp;<input type="radio" name="tax_naid_flg" value="Y" class="trans">&nbsp;Yes&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="tax_naid_flg" value="N" class="trans" checked>&nbsp;No&nbsp;</td>

        				</tr>
						<tr>
        					<td class="tr2_head">흑/적자구분</td>
        					<td colspan="3">&nbsp;<input type="radio" name="finance_flg" value="Y" class="trans" >&nbsp;흑자&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="finance_flg" value="N" class="trans" >&nbsp;적자&nbsp;</td>
        					<td class="tr2_head" colspan="1">고정자산여부</td>
							<td colspan="3">&nbsp;<input type="radio" name="fa_flg" value="Y" class="trans">&nbsp;Yes&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="fa_flg" value="N" class="trans" checked>&nbsp;No&nbsp;</td>


        				</tr>
						<tr>
        					<td class="tr2_head">Tax Type</td>
        					<td colspan="3">&nbsp;<input type="radio" name="tax_type" value="0" class="trans">&nbsp;영세&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="tax_type" value="10" class="trans">&nbsp;과세&nbsp;</td>
        					<td class="tr2_head" colspan="1">의제매출분</td>
							<td colspan="3">&nbsp;<input type="radio" name="tax_nsl_flg" value="Y" class="trans">&nbsp;Yes&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="tax_nsl_flg" value="N" class="trans" checked>&nbsp;No&nbsp;</td>


        				</tr>
						<tr>
        					<td class="tr2_head">사업자등록번호</td>
        					<td colspan="3">
        						&nbsp;<input type="text" name="comp_no1" maxlength="3" style="width:72;" value="" onKeyUp='moveFocus(this, this.form.comp_no2, 3);' >
        						&nbsp;-&nbsp;<input type="text" name="comp_no2" style="width:32;" value="" maxlength="2" onKeyUp='moveFocus(this, this.form.comp_no3, 2);' >
        						&nbsp;-&nbsp;<input type="text" name="comp_no3" style="width:72;" value="" maxlength="5" >
        					</td>
        					<td class="tr2_head" colspan="1">Vendor Code</td>
							<td colspan="3">&nbsp;<input type="text" name="vndr_seq" value="" style="width:97%;"></td>

        				</tr>
						<tr>
        					<td class="tr2_head">상호</td>
        					<td colspan="3">&nbsp;<input type="text" name="vndr_nm" style="width:98%;" value=""></td>
        					<td class="tr2_head" colspan="1">대표자명</td>
							<td colspan="3">&nbsp;<input type="text" name="ceo_nm" style="width:97%;" value=""></td>

        				</tr>
						<tr>
        					<td class="tr2_head">업태</td>
        					<td colspan="3">&nbsp;<input type="text" name="bzct_nm" style="width:98%;" value=""></td>
        					<td class="tr2_head" colspan="1">종목</td>
							<td colspan="3">&nbsp;<input type="text" name="bztp_nm" style="width:97%;" value=""></td>

        				</tr>
						<tr>
        					<td class="tr2_head">주소</td>
        					<td colspan="7">&nbsp;<input type="text" name="vndr_addr" style="width:99%;" value=""></td>

        				</tr>
						<tr>
        					<td width="130" class="tr2_head">발행일자</td>
        					<td width="130">&nbsp;<input type="text" name="inv_dt" maxlength="10" style="width:94%;" value="" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyUp='ComIsNumber(this);' onKeyDown='ComIsNumber(this);' onBlur='BlurDate(this);'></td>
        					<td width="80" class="tr2_head">공급가액</td>
							<td width="130">&nbsp;<input type="text" name="net_amt" style="width:94%;" value=""></td>
        					<td width="130" class="tr2_head">세액</td>
							<td width="130">&nbsp;<input type="text" name="vat_amt"  style="width:94%;" value=""></td>
							<td width="80" class="tr2_head">총합계</td>
							<td>&nbsp;<input type="text" name="total_amt"  style="width:94%;" value=""></td>
        				</tr>
        		</table>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Related COP Information) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">



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
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btng_ok_k" name="btng_ok_k">완료</td><td class="btn2_right"></td></tr></table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btng_cancel_k" name="btng_cancel_k">작업취소</td><td class="btn2_right"></td></tr></table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btng_new_k" name="btng_new_k">다시입력</td><td class="btn2_right"></td></tr></table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btng_add_k" name="btng_add_k">추가</td><td class="btn2_right"></td></tr></table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btng_delete_k" name="btng_delete_k">삭제</td><td class="btn2_right"></td></tr></table></td>
					<!-- Repeat Pattern -->


				</tr></table>
			</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->



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