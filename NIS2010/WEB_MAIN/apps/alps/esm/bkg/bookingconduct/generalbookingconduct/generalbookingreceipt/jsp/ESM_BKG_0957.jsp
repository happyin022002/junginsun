<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0957.jsp
*@FileTitle : Code Creation Request Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.08.17 김병규
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0957Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0957Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingConduct.GeneralBookingReceipt");

	String bkgNo  = "";
	String blNo  = "";
	String blNoTp  = "";
	String blTpTd  = "";

	String shCustCntCd  = "";
	String shCustSeq  = "";
	String shCustTpCd  = "";
	String shCustNm  = "";
	String shCustAddr  = "";
	String shCustCtyNm  = "";
	String shCustSteCd  = "";
	String shCstmsDeclCntCd  = "";
	String shCustZipId  = "";
	String cnCustCntCd  = "";
	String cnCustSeq  = "";
	String cnCustTpCd  = "";
	String cnCustNm = "";
	String cnCustAddr  = "";
	String cnCustCtyNm  = "";
	String cnCustSteCd  = "";
	String cnCstmsDeclCntCd  = "";
	String cnCustZipId  = "";
	String cnCustFaxNo  = "";
	String cnCustEml  = "";
	String nfCustCntCd  = "";
	String nfCustSeq  = "";
	String nfCustTpCd  = "";
	String nfCustNm  = "";
	String nfCustAddr  = "";
	String nfCustCtyNm  = "";
	String nfCustSteCd  = "";
	String nfCstmsDeclCntCd  = "";
	String nfCustZipId  = "";
	String nfCustFaxNo  = "";
	String nfCustEml  = "";	

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		//event = (EsmBkg0957Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		blNo  = JSPUtil.getParameter(request, "bl_no");
		blNoTp  = JSPUtil.getParameter(request, "bl_no_tp");
		blTpTd  = JSPUtil.getParameter(request, "bl_tp_cd");
/*		
		shCustCntCd  = JSPUtil.getParameter(request, "sh_cust_cnt_cd");
		shCustSeq  = JSPUtil.getParameter(request, "sh_cust_seq");
		shCustTpCd  = JSPUtil.getParameter(request, "sh_cust_tp_cd");
		shCustNm  = JSPUtil.getParameter(request, "sh_cust_nm");
		shCustAddr  = JSPUtil.getParameter(request, "sh_cust_addr");
		shCustCtyNm  = JSPUtil.getParameter(request, "sh_cust_cty_nm");
		shCustSteCd  = JSPUtil.getParameter(request, "sh_cust_ste_cd");
		shCstmsDeclCntCd  = JSPUtil.getParameter(request, "sh_cstms_decl_cnt_cd");
		shCustZipId  = JSPUtil.getParameter(request, "sh_cust_zip_id");
		cnCustCntCd  = JSPUtil.getParameter(request, "cn_cust_cnt_cd");
		cnCustSeq  = JSPUtil.getParameter(request, "cn_cust_seq");
		cnCustTpCd  = JSPUtil.getParameter(request, "cn_cust_tp_cd");
		cnCustNm = JSPUtil.getParameter(request, "cn_cust_nm");
		cnCustAddr  = JSPUtil.getParameter(request, "cn_cust_addr");
		cnCustCtyNm  = JSPUtil.getParameter(request, "cn_cust_cty_nm");
		cnCustSteCd  = JSPUtil.getParameter(request, "cn_cust_ste_cd");
		cnCstmsDeclCntCd  = JSPUtil.getParameter(request, "cn_cstms_decl_cnt_cd");
		cnCustZipId  = JSPUtil.getParameter(request, "cn_cust_zip_id");
		cnCustFaxNo  = JSPUtil.getParameter(request, "cn_cust_fax_no");
		cnCustEml  = JSPUtil.getParameter(request, "cn_cust_eml");
		nfCustCntCd  = JSPUtil.getParameter(request, "nf_cust_cnt_cd");
		nfCustSeq  = JSPUtil.getParameter(request, "nf_cust_seq");
		nfCustTpCd  = JSPUtil.getParameter(request, "nf_cust_tp_cd");
		nfCustNm  = JSPUtil.getParameter(request, "nf_cust_nm");
		nfCustAddr  = JSPUtil.getParameter(request, "nf_cust_addr");
		nfCustCtyNm  = JSPUtil.getParameter(request, "nf_cust_cty_nm");
		nfCustSteCd  = JSPUtil.getParameter(request, "nf_cust_ste_cd");
		nfCstmsDeclCntCd  = JSPUtil.getParameter(request, "nf_cstms_decl_cnt_cd");
		nfCustZipId  = JSPUtil.getParameter(request, "nf_cust_zip_id");
		nfCustFaxNo  = JSPUtil.getParameter(request, "nf_cust_fax_no");
		nfCustEml  = JSPUtil.getParameter(request, "nf_cust_eml");		
*/		
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Code Creation Request Popup</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="bl_no" value="<%=blNo%>">
<input type="hidden" name="bl_no_tp" value="<%=blNoTp%>">
<input type="hidden" name="bl_tp_cd" value="<%=blTpTd%>">
<input type="hidden" name="sh_cust_cnt_cd" value="<%=shCustCntCd%>">
<input type="hidden" name="sh_cust_seq" value="<%=shCustSeq%>">
<input type="hidden" name="sh_cust_tp_cd" value="<%=shCustTpCd%>">
<input type="hidden" name="sh_cust_nm" value="<%=shCustNm%>">
<input type="hidden" name="sh_cust_addr" value="<%=shCustAddr%>">
<input type="hidden" name="sh_cust_cty_nm" value="<%=shCustCtyNm%>">
<input type="hidden" name="sh_cust_ste_cd" value="<%=shCustSteCd%>">
<input type="hidden" name="sh_cstms_decl_cnt_cd" value="<%=shCstmsDeclCntCd%>">
<input type="hidden" name="sh_cust_zip_id" value="<%=shCustZipId%>">
<input type="hidden" name="cn_cust_cnt_cd" value="<%=cnCustCntCd%>">
<input type="hidden" name="cn_cust_seq" value="<%=cnCustSeq%>">
<input type="hidden" name="cn_cust_tp_cd" value="<%=cnCustTpCd%>">
<input type="hidden" name="cn_cust_nm" value="<%=cnCustNm%>">
<input type="hidden" name="cn_cust_addr" value="<%=cnCustAddr%>">
<input type="hidden" name="cn_cust_cty_nm" value="<%=cnCustCtyNm%>">
<input type="hidden" name="cn_cust_ste_cd" value="<%=cnCustSteCd%>">
<input type="hidden" name="cn_cstms_decl_cnt_cd" value="<%=cnCstmsDeclCntCd%>">
<input type="hidden" name="cn_cust_zip_id" value="<%=cnCustZipId%>">
<input type="hidden" name="cn_cust_fax_no" value="<%=cnCustFaxNo%>">
<input type="hidden" name="cn_cust_eml" value="<%=cnCustEml%>">
<input type="hidden" name="nf_cust_cnt_cd" value="<%=nfCustCntCd%>">
<input type="hidden" name="nf_cust_seq" value="<%=nfCustSeq%>">
<input type="hidden" name="nf_cust_tp_cd" value="<%=nfCustTpCd%>">
<input type="hidden" name="nf_cust_nm" value="<%=nfCustNm%>">
<input type="hidden" name="nf_cust_addr" value="<%=nfCustAddr%>">
<input type="hidden" name="nf_cust_cty_nm" value="<%=nfCustCtyNm%>">
<input type="hidden" name="nf_cust_ste_cd" value="<%=nfCustSteCd%>">
<input type="hidden" name="nf_cstms_decl_cnt_cd" value="<%=nfCstmsDeclCntCd%>">
<input type="hidden" name="nf_cust_zip_id" value="<%=nfCustZipId%>">
<input type="hidden" name="nf_cust_fax_no" value="<%=nfCustFaxNo%>">
<input type="hidden" name="nf_cust_eml" value="<%=nfCustEml%>">
<!-- Groupmail시 반영될 Hidden --> 
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_to">
<input type="hidden" name="gw_cc">
<input type="hidden" name="gw_template"  value="ESM_BKG_0957_01T.html">
<input type="hidden" name="gw_args" value="bkgno;">
<input type="hidden" name="gw_args" value="blno;">
<input type="hidden" name="gw_args" value="podCd;">
<input type="hidden" name="gw_args" value="delCd;">
<input type="hidden" name="gw_args" value="reqcontents;">
<input type="hidden" name="gw_args" value="caution;">


<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Code Creation Request Pop-up</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			<table class="search_sm" border="0" style="width:100%;"> 
				<tr class="h23">
				<td align="center">Select customers to be requested.</td>
				</tr>
				<tr>
				<td><input type="checkbox" name="shipper" value="Y" class="trans">&nbsp;&nbsp;Shipper</td>
				</tr>
				<tr>
				<td><input type="checkbox" name="consignee" value="Y" class="trans" >&nbsp;&nbsp;Consignee</td>
				</tr>
				<tr>
				<td><input type="checkbox"  name="notify" value="Y" class="trans">&nbsp;&nbsp;Notify</td>
				</tr>
		</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

	</td></tr>
</table> 
<!-- <table width="100%" class="popup" cellpadding="10" border="0"> 

</table> -->	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		<tr><td valign="top">
			<table class="search"><tr class="h23">
				<td><input type="checkbox" name="cfm_flg" value="Y" class="trans">I confirm that I just sent a Code Creation<br>&nbsp;&nbsp;&nbsp;&nbsp;Request via mail.</td> 
      		</tr></table>
		</td></tr>
		
		<tr><td class="btn3_bg">       	
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Send">Send</td>
					<td class="btn1_right"></td>
				</tr></table></td>
								
				<td><table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Confirm">Confirm</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<table width="50%"  id="mainTable">
	<tr>
		<td width="50%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>			
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>