<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_0005.jsp
*@FileTitle : 계산서입력화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.09 함대성
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ComCsr0005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String tax_no1 = JSPUtil.getKST("yyyyMM");
	
	String userId  = "";
	String ofc_cd  = "";
	String cost_ofc_cd  = "";
	String usr_eml = "";	
	String usr_nm  = "";
	String cnt_cd  = "";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String inv_sub_sys_cd   = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.ConsultationSlipRequestMgt.ConsultationSlipRequestMgt");

	try {
		inv_sub_sys_cd 		= JSPUtil.getParameter(request, "inv_sub_sys_cd 	".trim(), "");
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
	    //userId=account.getUsr_id();
	    //userAuth=account.getAuth();	   
	    ofc_cd=account.getOfc_cd();
	    usr_eml=account.getUsr_eml();
	    cnt_cd =account.getCnt_cd();

		event = (ComCsr0005Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>계산서입력화면</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="bizcommon/csr/CoCsr.js"></script>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		insertValueEvi();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> 
<input type="hidden" name="iPage">
<input type="hidden" name="tax_code">
<input type="hidden" name="comp_no">  
<input type="hidden" name="inv_sub_sys_cd" value="<%=inv_sub_sys_cd%>">

<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;계산서입력화면</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		  
		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search" border="0" style="width:737;">

				<tr class="h23">
					<td width="50">S/P</td>
					<td width="140">&nbsp;<input type="text" name="vndr_seq_hdr" style="width:100"></td>
					<td width="70">품의금액</td>
					<td width="140"><input type="text" name="total_amt_hdr" style="width:100;text-align:right;"></td>
					<td width="50">Type</td>
					<td >&nbsp;전자계산서&nbsp;<input type="checkbox" name="attr_ctnt8" value="ELECTRONIC" class="trans" onClick="checkType(0);">&nbsp;&nbsp;종이계산서&nbsp;<input type="checkbox" name="attr_ctnt8" value="PAPER" class="trans" onClick="checkType(1);"></td>
				</tr>
				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->

		<table class="height_15"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options : Related COP Information  ) (S) -->
		<table class="search">
        	<tr><td class="bg_a">

        			<table border="0" class="grid2" style="width:737" background-color:white;>
        				<tr>
        					<td class="tr2_head" width="137">세금계산서번호</td>
        					<td width="200" colspan="2">
							
								<table class="search">
									<tr class="h23">
										<td width="33%"><input type="text" name="tax_no1" maxlength="6" style="width:67;" value="<%=tax_no1%>" onKeyUp='isNum(this);' onKeyDown='isNum(this);csr_chkInput(this);' onBlur='validateDateObj(this);'></td>
										<td width="33%"><script language="javascript">ComComboObject('tax_no2',2,70,0,0);</script></td>
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
        					<td colspan="2"><input type="text" name="comp_no1" maxlength="3" style="width:72;text-align:center;" value="" onKeyUp='isNum(this);csr_moveFocus(this, this.form.comp_no2, 3);' onKeyDown='isNum(this);csr_chkInput(this);'>&nbsp;-&nbsp;<input type="text" name="comp_no2" maxlength="2" style="width:32;text-align:center;" value="" onKeyUp='isNum(this);csr_moveFocus(this, this.form.comp_no3, 2);' onKeyDown='isNum(this);csr_chkInput(this);'>&nbsp;-&nbsp;<input type="text" maxlength="5" name="comp_no3" style="width:72;text-align:center;" value="" onKeyUp='isNum(this);' onKeyDown='isNum(this);csr_chkInput(this);' onblur='taxInfo();'></td>
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
        					<td width="100"><input type="text" name="inv_dt" maxlength="10" style="width:100;text-align:center;" value="" onKeyUp='isNum1(this);csr_isNumD(this,"Y");' onKeyDown='isNum1(this);csr_isNumD(this,"Y");' onBlur="if(validateDateObj2(this)){checkInvDt(this);}"></td>
        					<td class="tr2_head" width="100">공급가액</td>
							<td width="130" colspan="2"><input type="text" name="net_amt" style="width:130;text-align:right;" value=""></td>
        					<td class="tr2_head" width="100">총합계</td>
							<td width="170" colspan="2"><input type="text" name="total_amt" style="width:166;text-align:right;" value=""></td>
        				</tr>
        		</table> 
		<!-- TABLE '#D' : ( Search Options : Related COP Information) (E) -->

		<table class="height_15"><tr><td></td></tr></table>



		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
			<table width="100%" class="search"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script> 
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->

			<!--Button (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr><td class="btn1_bg">
				    <table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btng_ok_k">완료</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btng_cancel_k">작업취소</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btng_new_k">다시입력</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btng_add_k">추가</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btng_delete_k">삭제</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
						</tr>
					</table>
				</td></tr>
				</table>
		    <!--Button (E) --> 

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->






		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td></tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->





	</td></tr>

<tr><td class="bgdybottom_copy">
	</td></tr>
</table>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->

</form>
</body>

<!-- 개발자 작업  끝 -->
</html>
<!-- 
<DIV style="display:none"> 
		<table class="height_5"><tr><td></td></tr></table>

		<table width="50%" id="mainTable">
                  <tr><td>
                       <script language="javascript">comSheetObject('sheet2');</script>
                  </td></tr>
          </table>

		<table class="height_10"><tr><td></td></tr></table>
</DIV>	
 -->