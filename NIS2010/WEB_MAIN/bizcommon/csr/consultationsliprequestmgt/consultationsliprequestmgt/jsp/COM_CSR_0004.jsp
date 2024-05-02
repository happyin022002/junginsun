<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_0004.jsp
*@FileTitle : 세금계산서입력화면
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
<%@ page import="com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ComCsr0004Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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

	String inv_cfm_dt = ""; 
	String vndr_seq = "";
	String vndr_seq_name = ""; 	
	String cnt_inv = "";
	String curr_cd = "";
	String total_amt = "";
	String asanogb = "";
	String pay_group_cd = "";
	String iss_dt = "";
	String rcv_dt = "";
	String gen_pay_term_cd = "";
	String gen_pay_term_desc = "";
	String payment_due_dt = "";
	String pay_term_tp_cd = "";		
	//모듈
	String inv_sub_sys_cd = "";
	
	inv_cfm_dt 			= JSPUtil.getParameter(request, "inv_cfm_dt 		".trim(), "");	
	vndr_seq 			= JSPUtil.getParameter(request, "vndr_seq 			".trim(), "");
	vndr_seq_name 		= JSPUtil.getParameter(request, "vndr_seq_name      ".trim(), ""); 		
	cnt_inv 			= JSPUtil.getParameter(request, "cnt_inv 			".trim(), "");
	curr_cd 			= JSPUtil.getParameter(request, "curr_cd          	".trim(), ""); 
	total_amt 			= JSPUtil.getParameter(request, "total_amt 			".trim(), "");
	asanogb 			= JSPUtil.getParameter(request, "asanogb 			".trim(), "");	
	pay_group_cd 		= JSPUtil.getParameter(request, "pay_group_cd 		".trim(), "");	
	iss_dt 				= JSPUtil.getParameter(request, "iss_dt          	".trim(), ""); 
	rcv_dt 				= JSPUtil.getParameter(request, "rcv_dt          	".trim(), ""); 
	gen_pay_term_cd 	= JSPUtil.getParameter(request, "gen_pay_term_cd 	".trim(), "");
	gen_pay_term_desc 	= JSPUtil.getParameter(request, "gen_pay_term_desc	".trim(), "");
	payment_due_dt 		= JSPUtil.getParameter(request, "payment_due_dt 	".trim(), "");	
	pay_term_tp_cd 		= JSPUtil.getParameter(request, "pay_term_tp_cd 	".trim(), "");	
	cost_ofc_cd 		= JSPUtil.getParameter(request, "cost_ofc_cd 		".trim(), "");
	
	inv_sub_sys_cd 		= JSPUtil.getParameter(request, "inv_sub_sys_cd 	".trim(), "");
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ConsultationSlipRequestMgt.ConsultationSlipRequestMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
	    //userId=account.getUsr_id();
	    //userAuth=account.getAuth();	   
	    ofc_cd=account.getOfc_cd();
	    usr_eml=account.getUsr_eml();
	    cnt_cd =account.getCnt_cd();

		event = (ComCsr0004Event)request.getAttribute("Event");
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
<title>세금계산서입력화면</title>
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
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;세금계산서입력화면</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		  
		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search" border="0" style="width:737;">

				<tr class="h23">
					<td width="40">S/P</td>
					<td width="115">&nbsp;<input type="text" name="vndr_seq_hdr" style="width:90"></td>
					<td width="40">세액</td>
					<td width="125"><input type="text" name="vat_amt_hdr" style="width:100;text-align:right;"></td>
					<td width="60">품의금액</td>
					<td width="125"><input type="text" name="total_amt_hdr" style="width:100;text-align:right;"></td>
					<td width="40">Type</td>
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
        					<td colspan="2">
        						<input type="text" name="comp_no1" style="width:72;text-align:center;" value="" maxlength="3" onFocus='this.select();' onKeyUp='isNum(this);obj_moveFocus(this, this.form.comp_no2, 3);' onKeyDown='isNum(this);csr_chkInput(this);'>&nbsp;-&nbsp;
        						<input type="text" name="comp_no2" style="width:32;text-align:center;" value="" maxlength="2" onFocus='this.select();' onKeyUp='isNum(this);obj_moveFocus(this, this.form.comp_no3, 2);' onKeyDown='isNum(this);csr_chkInput(this);' >&nbsp;-&nbsp;
        						<input type="text" name="comp_no3" style="width:72;text-align:center;" value="" maxlength="5" onFocus='this.select();' onKeyUp='isNum(this);' onKeyDown='isNum(this);csr_chkInput(this);' onblur='taxInfo();'></td>	<!-- onblur='taxInfo();' -->
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
        					<td width="100"><input type="text" name="inv_dt" maxlength="10" style="width:100;text-align:center;" value="" onKeyUp='isNum1(this);csr_isNumD(this,"Y");' onKeyDown='isNum1(this);csr_isNumD(this,"Y");' onBlur="if(validateDateObj2(this)){checkInvDt(this);}"></td>
        					<td class="tr2_head" width="100">공급가액</td>
							<td width="65"> <input type="text" name="net_amt" style="width:65;text-align:right;" value=""></td>
        					<td class="tr2_head" width="65">세액</td>
							<td width="90"> <input type="text" name="vat_amt"  style="width:90;text-align:right;" value=""></td>
							<td class="tr2_head" width="70">총합계</td>
							<td width="110"> <input type="text" name="total_amt"  style="width:102;text-align:right;" value=""></td>
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
<DIV style="display:none"> 
		<!-- Grid  (S) -->
		<table width="100%" class="search"  id="mainTable"> 
			<tr>
				<td width="100%">
				<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table> 			
		<!-- Grid (E) -->
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
								showErrMessage("세액 변경 금액 기준을 초과 하였습니다. 다시 확인하세요.");						
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
     		    		
        document.form.net_amt.value 		= csr_addComma(net_amt/100);
        document.form.vat_amt.value 		= csr_addComma(vat_amt/100);
        document.form.total_amt.value 		= csr_addComma(total_amt/100); 
  </Script> 