<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0086.jsp
*@FileTitle : Tax Evidence
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.03 정윤태
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0086Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0086Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0086Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
	
	String csrNo = JSPUtil.replaceForHTML(request.getParameter("csr_no"));
%>

<html>
<head>
<title>Tax Evidence</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="csr_no" value="<%=csrNo%>">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Tax Evidence  </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				
				<table class="search" border="0" style="width:880;"> 
				<tr class="h23">
					<td width="110">&nbsp;&nbsp;세금계산서 번호</td>
					<td width="530"><input type="text" style="width:60;text-align:center;" class="input1" name="tax_inv_yrmon" maxlength="6" readonly>
						<select style="width:180;" class="input1" name="ofc_cd">
						</select><!-- &nbsp;<input type="text" style="width:150;" class="input2" name="ofc_nm"> -->
					</td>
					<td width="105">
						<table class="search_sm" border="0" style="width:250;"> 
							<tr class="h23">
								<td width="109">Type</td>
								<td width="" class="noinput1"><input type="radio" class="trans" name="tax_iss_cd" disabled>전자 &nbsp;<input type="radio" class="trans" name="tax_iss_cd" disabled>종이</td>
							</tr>
						</table>
						<table class="height_2"><tr><td></td></tr></table>
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:880;"> 
				<tr class="h23">
					<td width="640">
						<table class="search_sm" border="0" style="width:250;"> 
							<tr class="h23">
								<td width="105">Tax 구분</td>
								<td width="" class="noinput1"><input type="radio" class="trans" name="tax_vat_tp_cd" value="1" disabled>개인 &nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="tax_vat_tp_cd" value="2" checked disabled>회사 </td>
							</tr>
						</table>
					</td>
					<td width="">
						<table class="search_sm" border="0" style="width:250;"> 
							<tr class="h23">
								<td width="110">매입세액불공제</td>
								<td width="" class="stm"><input type="radio" class="trans" name="tax_naid_flg" value="Y" disabled>Yes &nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="tax_naid_flg" value="N" checked disabled>No </td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:880;"> 
				<tr class="h23">
					<td width="640">
						<table class="search_sm" border="0" style="width:250;"> 
							<tr class="h23">
								<td width="105">흑/적자  구분</td>
								<td width="" class="noinput1"><input type="radio" class="trans" name="tax_div_cd" value="1" checked disabled>흑자 &nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="tax_div_cd" value="2" disabled>적자 </td>
							</tr>
						</table>
					</td>
					<td width="">
						<table class="search_sm" border="0" style="width:250;"> 
							<tr class="h23">
								<td width="110">고정자산여부</td>
								<td width="" class="stm"><input type="radio" class="trans" name="fa_flg" value="Y" disabled>Yes &nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="fa_flg" value="N" checked disabled>No </td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:880;"> 
				<tr class="h23">
					<td width="640">
						<table class="search_sm" border="0" style="width:250;" id="l_evid_tp_cd" style="display:''"> 
							<tr class="h23">
								<td width="105">Tax Type</td>
								<td width="" class="stm"><input type="radio" class="trans" name="tax_pl_cd" value="1" disabled>영세 &nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="tax_pl_cd" value="2" checked disabled>과세 </td>
							</tr>
						</table>
					</td>
					<td width="">
						<table class="search_sm" border="0" style="width:250;"> 
							<tr class="h23">
								<td width="110">의제매출분</td>
								<td width="" class="stm"><input type="radio" class="trans" name="tax_nsl_flg" value="Y" disabled>Yes &nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="tax_nsl_flg" value="N" checked disabled>No </td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:880;"> 
				<tr class="h23">
					<td width="110">&nbsp;&nbsp;사업자 등록 번호</td>
					<td width="530"><input type="text" style="width:138;text-align:center;" class="input1" name="spl_rgst_no" maxlength="13" readonly></td>
					<td width="110">사업자명 </td>
					<td width=""><input type="text" style="width:128;" class="input2" name="ownr_nm" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:880;"> 
				<tr class="h23">
					<td width="50">&nbsp;&nbsp;상호</td>
					<td width="530"><input type="text" style="width:450;" class="input2" name="co_nm" readonly></td>
					<td width="110">&nbsp;</td>
					<td width="">&nbsp;</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:880;"> 
				<tr class="h23">
					<td width="50">&nbsp;&nbsp;업태</td>
					<td width="500"><input type="text" style="width:450;" class="input2" name="bzct_nm" readonly></td>
					<td width="49">종목</td>
					<td width=""><input type="text" style="width:278;" class="input2" name="bztp_nm" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:880;"> 
				<tr class="h23">
					<td width="50">&nbsp;&nbsp;주소</td>
					<td width="530"><input type="text" style="width:450;" class="input2" name="spl_addr" readonly></td>
					<td width="110">&nbsp;</td>
					<td width="">&nbsp;</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:880;"> 
				<tr class="h23">
					<td width="50">&nbsp;&nbsp;발행일 </td>
					<td width="300"><input type="text" style="width:80;text-align:center;" class="input1" name="iss_dt" maxlength="8" readonly>&nbsp;</td>
					<td width="60">공급가액 </td>
					<td width="140"><input type="text" style="width:90;text-align:right" class="input2" name="spl_amt" readonly></td>
					<td width="49">세액 </td>
					<td width="130"><input type="text" style="width:90;text-align:right" class="input2" name="tax_amt" readonly></td>
					<td width="50">총합계 </td>
					<td width=""><input type="text" style="width:96;text-align:right" class="input2" name="total_amt" readonly></td>
				</tr>
				</table>
				
				<table class="line_bluedot" style="width:880;"><tr><td></td></tr></table>
				<!--  biz_2  (S) -->
				<!-- Grid  (S) -->
					<table width="880"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
						<!-- Grid (E) -->
				
				<!--  biz_2   (E) -->
				
				
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
	<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
			</td></tr>
		</table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
				</tr>
        </table></td>
				
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
</form>			
</body>
</html>