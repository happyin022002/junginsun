<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2036.jsp
*@FileTitle : Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.12.28 조재성
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2036Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm2036Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd              = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EesCgm2036Event)request.getAttribute("Event");
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
<title>Invoice Inquiry</title>
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
<input type="hidden" name ="eq_knd_cd" value="G">
<input type="hidden" name="ofc_cd" value='<%=ofc_cd %>'>
<input type="hidden" name="intg_cd_id" >
<input type="hidden" name="usr_id" value='<%=strUsr_id %>'>
<input type="hidden" name="pay_inv_seq" >

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
	
	
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">&nbsp;Invoice Date</td>
					<td width="390" style="padding-left:2">
					<script language="javascript">ComComboObject('cost_yrmon', 1, 110, 1, 1, 1, true);</script>
					&nbsp;<input type="text" name="inv_fm_date" dataformat="ymd" maxlength='8' style="width:80;text-align:center" class="input1" value="">&nbsp;<img class="cursor" name="btns_Calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
					~&nbsp;<input type="text" name="inv_to_date" dataformat="ymd" maxlength='8' style="width:80;text-align:center" class="input1" value="">&nbsp;<img class="cursor" name="btns_Calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					
					<td width="90">Invoice Office</td>
					<td width="136"><input type="text" name="cost_ofc_cd" style="width:60;text-align:center;ime-mode:disabled" dataformat="engup" maxlength="6" value="">&nbsp;<img name="btns_office" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="105">Creation User ID</td>
					<td width=""><input type="text" name="cre_usr_id" style="width:90;text-align:center" maxlength='20' value="<%=strUsr_id %>">
					<!--
					&nbsp;
					<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					 -->
					
				</tr> 
				</table>				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
                    <td width="85">&nbsp;S. Provider</td>
					<td width=""><input type="text" name="vndr_seq" dataformat="eng" style="width:60;text-align:center" class="input" value="">
					<img src="img/btns_search.gif" name="btns_vndr" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					<input type="text" name="vndr_nm" style="width:455" class="input2" value=""></td>
					
				</tr> 
				</table>				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="655">			
						<table class="search_sm2" border="0" style="width:629;"> 
						<tr class="h23">
							<td width="80">INV/CSR No.</td>
							<td width="130" class="stm">
							<input type="radio" name="inv_csr_no_chk" value="inv_no" class="trans">Invoice&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="inv_csr_no_chk" value="csr_no" class="trans">CSR</td>
							<td width=""><input type="text" name="inv_csr_no" style="width:300;ime-mode:disabled" dataformat="engup" maxlength="300" class="input" value="">&nbsp;
							<!-- 
							<img src="img/btns_multisearch.gif" onClick="so_OnPopupClick('SO No.');" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
							 -->
							</td>
						</tr> 
						</table>
					</td>
					<td width="45">Status</td>
					<td width="">
					    <script language="javascript">ComComboObject('inv_status', 2, 200, 1, 1, 1, true);</script>
					</td>
					
				</tr> 
				</table>			
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Main</td></tr>
				</table>
					
				<!-- Grid - Main (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid - Main (E) -->	

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Detail</td></tr>
				</table>
					
				<!-- Grid - Detail (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				<!-- Grid - Detail (E) -->	

			</td></tr>
		</table>
		<!--biz page (E)-->


		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
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


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>