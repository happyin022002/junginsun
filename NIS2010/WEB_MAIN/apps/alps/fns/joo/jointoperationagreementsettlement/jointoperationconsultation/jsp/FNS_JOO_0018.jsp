<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fn_joo_0018.jsp
*@FileTitle : AP CSR Creation Evidence PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.15 박희동
* 1.0 Creation
-----------------------------------------------------------
* History
* 2010.10.04 이준범[CHM-201006190-01] Evidence를 클릭하면 나오는 pop-up 화면에서 발행일자 칼럼의 defalut 값을
* -. 현행 : 해당 CSR 발행일
* -. 세금계산서 번호 컬럼에 찍히는 月의 말일을 (휴일여부 관계 없음)
* defalut 값으로 지정
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationConsultation");
	
	String csrNo    = request.getParameter("csrNo")   ==null?"" :request.getParameter("csrNo");
	String vndrSeq  = request.getParameter("vndrSeq") ==null?"" :request.getParameter("vndrSeq");
	String editable = request.getParameter("editable")==null?"Y":request.getParameter("editable");
	String splyAmt  = request.getParameter("splyAmt") ==null?"0":request.getParameter("splyAmt");
	//넘겨받은 한글이 깨지는 현상을 막기 위함
	request.setCharacterEncoding("euc-kr");
	String rowdata  = request.getParameter("rowdata") ==null?"" :request.getParameter("rowdata");

	String ofcList = "";
	String sysdate = JSPUtil.getKST("yyyyMMdd");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
		ofcList = eventResponse.getETCData("ofc_list");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>AP CSR Creation Evidence PopUp</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

var gVndrSeq  = "<%=vndrSeq%>";
var gCsrNo    = "<%=csrNo%>";
var gOfcList  = "<%=ofcList%>";
var gEditable = "<%=editable%>";
var gSysdate  = "<%=sysdate%>";
var gSplyAmt  = <%=splyAmt%>;
var gRowdata  = "<%=rowdata%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="csr_no" value="<%=csrNo%>">
<input type="hidden" name="code">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbspAP CSR Creation - Evidence 입력 POP UP</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
	<!--biz page (S)-->
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			
				<table border="0" style="width:100%;" class="grid2">
						<tr>
					 		<td width="100" class="tr2_head">세금계산서 번호</td>
							 <td width="300"><input type="text" style="width:60" class="input2" name="tax_inv_yrmon" dataformat="ym" onkeyup="taxBillNo_keyup()" >&nbsp;
					<script language="javascript">ComComboObject('ofc_cd',2,70,0,1);</script>
					&nbsp;<input type="hidden" style="width:62" class="input2" name="tax_ser_no"></td>
							<td width="100" class="tr2_head">권 번호</td>
							 <td width=""><input type="text" style="width:80" class="input2" name="kwon" readOnly>&nbsp;권&nbsp;<input type="text" style="width:80" class="input2" name="ho" readOnly>&nbsp;호</td>
						
							
						</tr>
						<tr>
					 		<td class="tr2_head">Tax 구분</td>
							<td width="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="1" class="trans" name="tax_div_cd" checked disabled> &nbsp;&nbsp;개인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" value="2" class="trans" name="tax_div_cd" disabled>&nbsp;&nbsp;회사</td>
							<td class="tr2_head">매입세액불공제</td>
							<td width=""><input type="radio" value="Y" class="trans" name="tax_naid_flg" checked disabled>&nbsp;&nbsp; YES&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" value="N" class="trans" name="tax_naid_flg" disabled>&nbsp;&nbsp; NO </td>
						</tr>
						<tr>
					 		<td class="tr2_head">흑/적자 구분</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="B" class="trans" name="tax_pl_cd" checked> &nbsp;&nbsp;흑자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" value="R" class="trans" name="tax_pl_cd">&nbsp;&nbsp;적자</td>
						    <td class="tr2_head">고정자산여부</td>
							<td width=""><input type="radio" value="Y" class="trans" name="fa_flg" checked disabled> &nbsp;&nbsp;YES&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" value="N" class="trans" name="fa_flg" disabled> &nbsp;&nbsp;NO </td>
						
						
						</tr>
						<tr>
					 		<td class="tr2_head">Tax Type</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="1" class="trans" name="tax_vat_tp_cd" checked disabled> &nbsp;&nbsp;영세&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="2" class="trans" name="tax_vat_tp_cd" disabled> &nbsp;&nbsp;과세</td>
						    <td class="tr2_head">의제매출분</td>
							<td><input type="radio" value="Y" class="trans" name="tax_nsl_flg" checked disabled> &nbsp;&nbsp;YES &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="N" class="trans" name="tax_nsl_flg" disabled> &nbsp;&nbsp;NO </td>
						</tr>
						<tr>
					 		<td class="tr2_head">세금계산서 발행 구분</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="ELECTRONIC" class="trans" name="doc_evid_tp_cd"> &nbsp;&nbsp;전자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="PAPER" class="trans" name="doc_evid_tp_cd"> &nbsp;&nbsp;종이</td>
						    <td class="tr2_head">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
					 		<td class="tr2_head">사업자등록번호</td>
							<td width="" class="noinput2"><input type="text" style="width:100%" class="noinput2" name="spl_rgst_no" dataformat="saupja" readOnly></td>
						    <td class="tr2_head">VNDR Code </td>
							<td width="" class="noinput2"><input type="text" style="width:100%" class="noinput2" name="vndr_seq" value="<%=vndrSeq%>" readOnly></td>
						</tr>
						<tr>
					 		<td class="tr2_head">상&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;호</td>
							<td width="" class="noinput2"><input type="text" style="width:100%" class="noinput2" name="co_nm" readOnly></td>
						    <td class="tr2_head">대표자명</td>
							<td width="" class="noinput2"><input type="text" style="width:100%" class="noinput2" name="ownr_nm" readOnly></td>
						</tr>
						<tr>
					 		<td class="tr2_head">업&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;태</td>
							<td width="" class="noinput2"><input type="text" style="width:100%" class="noinput2" name="bzct_nm" readOnly></td>
						    <td class="tr2_head">종&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목 </td>
							 <td class="noinput2"><input type="text" style="width:100%" class="noinput2" name="bztp_nm" readOnly></td>
						</tr>
						<tr>
					 		<td class="tr2_head">주&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소</td>
							<td colspan="3" class="noinput2"><input type="text" style="width:100%" class="noinput2" name="spl_addr" readOnly></td>
						</tr>
						</table>
					
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="60">&nbsp;&nbsp;발행일자</td>
					<td width="100"><input type="text" style="width:80" class="input" name="iss_dt" dataformat="ymd" maxlength="8"></td>
					<td width="35">환율</td>
					<td width="100"><input type="text" style="width:80;text-align:right" class="input2" name="jo_xch_rt" dataformat="float"></td>
					<td width="60">공급가액</td>
					<td width="100"><input type="text" style="width:120;text-align:right" class="input2" name="spl_amt" dataformat="float" readOnly></td>
					<td width="35">세액</td>
					<td width="100"><input type="text" style="width:80;text-align:right" class="input2" name="tax_amt" dataformat="float" readOnly></td>
					<td width="50">총 합계</td>
					<td width=""><input type="text" style="width:180;text-align:right" class="input2" name="ttl_amt" dataformat="float" readOnly></td>
					</tr>  
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
						<tr>
							<td width="100%">
							<!--Grid-->
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
						<tr>
							<td width="100%">
							<!--Grid-->
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
			<!-- Grid (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<table class="height_5"><tr><td></td></tr></table>
	<!--biz page (E)-->
	<!--Button (S) -->
		</td></tr>
		</table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="171" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
					<% if ("Y".equals(editable)){ %>
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Confirm</td>
					<td class="btn1_right"></td>
					<% }else{ %>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<%}%>
			</tr></table>
			</td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
					<% if ("Y".equals(editable)){ %>
					<td class="btn1_left"></td>					
					<td class="btn1" name="btn_cancel">Cancel</td>
					<td class="btn1_right"></td>
					<% }else{ %>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<%}%>
			</tr></table>
			</td>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table></td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<%@include file="/bizcommon/include/common_nis2010.jsp"%>
 <!-- 개발자 작업  끝 -->
 </form>
</body>
</html>
