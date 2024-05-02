<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_5003.jsp
*@FileTitle : Invoice Interface to A/R - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.09 최성환
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt5003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strCnt_cd 		= "";

	//Parameter
	String ofc_cd		= "";
	String dmdt_trf_cd	= "";
	String chk_hold		= "";
	String cond_type	= "";
	String fm_dt		= "";
	String to_dt		= "";
	String inv_no		= "";
	String bkg_no		= "";
	String bl_no		= "";
	String sh_cust_cd	= "";
	String sh_cust_nm	= "";
	String sh_inv_curr_cd = "";
	String hold_auth	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTInvoiceMgt.invoiceissuecollectionmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();


		event = (EesDmt5003Event)request.getAttribute("Event");		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		ofc_cd		= JSPUtil.getParameter(request,"ofc_cd");
		dmdt_trf_cd	= JSPUtil.getParameter(request,"dmdt_trf_cd");
		chk_hold	= JSPUtil.getParameter(request,"chk_hold");
		cond_type	= JSPUtil.getParameter(request,"cond_type");
		fm_dt		= JSPUtil.getParameter(request,"fm_dt").replaceAll("-","");
		to_dt		= JSPUtil.getParameter(request,"to_dt").replaceAll("-","");
		inv_no		= JSPUtil.getParameter(request,"inv_no");
		bkg_no		= JSPUtil.getParameter(request,"bkg_no");
		bl_no		= JSPUtil.getParameter(request,"bl_no");
		sh_cust_cd	= JSPUtil.getParameter(request,"sh_cust_cd");
		sh_cust_nm	= JSPUtil.getParameter(request,"sh_cust_nm");
		sh_inv_curr_cd	= JSPUtil.getParameter(request,"sh_inv_curr_cd");
		hold_auth	= JSPUtil.getParameter(request,"hold_auth");
		
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Invoice Interface to A/R - Detail</title>

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
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>">

<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="dmdt_trf_cd" value="<%=dmdt_trf_cd%>">
<input type="hidden" name="chk_hold" value="<%=chk_hold%>">
<input type="hidden" name="cond_type" value="<%=cond_type%>">
<input type="hidden" name="fm_dt" value="<%=fm_dt%>">
<input type="hidden" name="to_dt" value="<%=to_dt%>">
<input type="hidden" name="inv_no" value="<%=inv_no%>">
<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="bl_no" value="<%=bl_no%>">
<input type="hidden" name="sh_cust_cd" value="<%=sh_cust_cd%>">
<input type="hidden" name="sh_cust_nm" value="<%=sh_cust_nm%>">
<input type="hidden" name="sh_inv_curr_cd" value="<%=sh_inv_curr_cd%>">

<input type="hidden" name="hold_auth" value="">

<input type="hidden" name="success_yn" value="">




<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Interface to A/R - Detail

</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
	
	
	<table class="search"> 
       		<tr><td class="bg">
				
				<table class="search" border="0" style="width:899;"> 
					<tr class="h23">
						<td width="44">Payer  </td>
						<td width=""><input type="text" style="width:70;" class="input2" value="<%=sh_cust_cd %>" readOnly>&nbsp;
						<input type="text" style="width:500;;" class="input2" value="<%=sh_cust_nm %>" readOnly></td>
						
					</tr>
				</table>
				<!--  biz_1  (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				
				<!-- Grid  (e) -->
				<table class="height_8"><tr><td></td></tr></table>
		
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Selected Total</td></tr>
				</table>
		
				<table class="search" border="0" style="width:899;"> 
					<tr class="h23">
						<td width="60">INV Q’ty </td>
						<td width="90"><input type="text" name="inv_qty" style="width:60;;" class="input2" value=""  readOnly>
						<td width="70">Billing AMT</td>
						<td width="200"><input type="text" name="inv_chg_amt"  style="width:150;text-align:right" class="input2" value=""  readOnly></td>
						<td width="60">Tax AMT</td>
						<td width="200"><input type="text" name="tax_amt" style="width:150;text-align:right" class="input2" value=""  readOnly></td>
						<td width="80">Payable AMT</td>
						<td width=""><input type="text" name="inv_amt" style="width:100%;text-align:right" class="input2" value=""  readOnly></td>
						
						
						
					</tr>
				</table>
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
 
			
	<table class="height_5"><tr><td></td></tr></table>
			
					
					
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
<!-- : ( Search Options ) (E) -->



<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
<%
	if(hold_auth.equals("Y")){
%>		    
		    	<td>
		    	<!-- hold버튼 권한 확인함 -->
		    	<div id="hold_auth_div" style=display:block;>
		    	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_hold">Hold</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</div>
				<!-- hold버튼 권한 확인함 //-->
				</td>
<%
	}
%>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_arif">A/R I/F</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_detail">Detail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
				
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>