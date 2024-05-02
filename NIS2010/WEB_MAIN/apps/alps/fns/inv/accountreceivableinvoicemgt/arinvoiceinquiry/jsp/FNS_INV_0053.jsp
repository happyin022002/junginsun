<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0053.jsp
*@FileTitle : Invoice Issue Inquiry by Invoice No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.27 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0053Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (FnsInv0053Event)request.getAttribute("Event");
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
<title>Invoice Issue Inquiry by Invoice No</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="ofc">
<input type="hidden" name="inv_tp_cd">
<input type="hidden" name="dp_prcs_knt_local" value="0">
<input type="hidden" name="dp_prcs_knt" value="0">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> 
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> 
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr> 
		</table> 
		<!--Page Title, Historical (E)--> 
		
		<!--biz page (S)-->
		<table class="search"> 
       	<tr>
       		<td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="88" align="">Invoice No&nbsp;</td>   
					<td width="170"><input name="inv_no" type="text" style="width:130;" class="input1" value="" dataformat="engup" maxlength="17"></td>
					<td width="72" align="">Issue Date&nbsp;</td>   
					<td width="180"><input name="iss_dt" type="text" style="width:85;" class="input2" value="" readonly tabIndex="-1"></td>
					<td width="38" align="">Office&nbsp;</td>  
					<td width=""><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 0);</script></td>
				</tr>
				</table>		
				<!-- biz_1  (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!-- biz_2  (S) -->
				<table class="search" border="0" style="width:100%;"> 	
				<tr class="h23">
					<td width="88" align="">Actual Cust.</td>   
					<td width="635"><input name="act_cust_cnt_cd" type="text" style="width:35;" class="input2" value="" maxlength="2" readonly tabIndex="-1">&nbsp;<input name="act_cust_seq" type="text" style="width:60;" class="input2" value="" maxlength="6" readonly tabIndex="-1">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust">&nbsp;<input name="cust_lgl_eng_nm" type="text" style="width:352;" class="input2" value="" readonly tabIndex="-1">&nbsp;<input name="cust_rgst_no" type="text" style="width:114;" class="input2" value="" readonly tabIndex="-1"></td>
					<td width="88" align="">Invoice Cust</td>   
					<td width=""><input name="inv_cust_cnt_cd" type="text" style="width:27;" class="input2" value="" maxlength="2" readonly tabIndex="-1">&nbsp;<input name="inv_cust_seq" type="text" style="width:54;" class="input2" value="" maxlength="6" readonly tabIndex="-1"></td>
				</tr>
				</table>	
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="88" align="">CRD Limit</td>   
					<td width="260"><input name="cr_curr_cd" type="text" style="width:35;" class="input2" value="" maxlength="3" readonly tabIndex="-1">&nbsp;<input name="cr_amt" type="text" style="width:99;text-align:right" class="input2" value="" maxlength="6" readonly tabIndex="-1"></td>
					<td width="85" align="">Credit Term&nbsp;</td>   
					<td width="30" align="" class="stm">O/B</td>
					<td width="45"><input name="ob_cr_term_dys" type="text" style="width:35;text-align:right" class="input2" value="" maxlength="5" readonly tabIndex="-1"></td>
					<td width="30" align="" class="stm">I/B</td>
					<td width="185"><input name="ib_cr_term_dys" type="text" style="width:35;text-align:right" class="input2" value="" maxlength="5" readonly tabIndex="-1"></td>
					<td width="88" align="">Credit Office</td>   
					<td width=""><input name="cr_clt_ofc_cd" type="text" style="width:85;" class="input2" value="" maxlength="6" readonly tabIndex="-1"></td>
				</tr>
				</table>		
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="88" align="">Local VVD</td>   
					<td width="260"><input name="vvd" type="text" style="width:138;" class="input2" value="" maxlength="9" readonly tabIndex="-1"></td>
					<td width="85" align="">Scope</td>   
					<td width="105"><input name="svc_scp_cd" type="text" style="width:65;" class="input2" value="" maxlength="3" readonly tabIndex="-1"></td>
					<td width="40" align="">Bound</td>   
					<td width="145"><input name="io_bnd_cd" type="text" style="width:55;" class="input2" value="" maxlength="3" readonly tabIndex="-1"></td>
					<td width="88" align="">S/A Date</td>   
					<td width=""><input name="sail_arr_dt" type="text" style="width:85;" class="input2" value="" readonly tabIndex="-1"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="88" align="">Trunk VVD&nbsp;</td>   
					<td width="150"><input name="trunk_vvd" type="text" style="width:138;" class="input2" value="" maxlength="9" readonly tabIndex="-1"></td>
					<td width="45" align="right">Lane&nbsp;</td>   
					<td width="65"><input name="slan_cd" type="text" style="width:38;" class="input2"  value="" maxlength="3" readonly tabIndex="-1"></td>
					<td width="85" align="">Invoice Curr.</td>   
					<td width="290"><input name="locl_curr_cd" type="text" style="width:65;" class="input2" value="" maxlength="3" readonly tabIndex="-1"></td>
					<td width="88" align="">Due Date</td>   
					<td width=""><input name="due_dt" type="text" style="width:85;" class="input2" value="" readonly tabIndex="-1"></td>
				</tr>
				</table>	
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="88" align="">Description&nbsp;</td>   
					<td width=""><input name="inv_rmk" type="text" style="width:808;" class="input2" value="" readonly tabIndex="-1"></td>
					</tr>
				</table>		
				<!-- biz_2  (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:100%;"> 	
				<tr class="h23">
					<td width="100%">
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable1"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
						</table>			
						<!-- Grid (E) -->
					</td>
				</tr>
				</table> 
				<!--table class="search" border="0" style="width:100%;">
				<tr class="h23" align="right">
					<td width="">&nbsp;</td>
					<td width="430">
						<table width="90%"  id="mainTable2"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
						</table>			
					</td>
				</tr>
				</table--> 
				<!--biz page (E)-->		
			</td>
		</tr>
		</table>	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
       		<td class="btn1_bg">
		    	<table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					
					<td><table id="tbl_split_check" width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_split_chk">Split Inv. Chk</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--Button (E) -->
	</td>
</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>