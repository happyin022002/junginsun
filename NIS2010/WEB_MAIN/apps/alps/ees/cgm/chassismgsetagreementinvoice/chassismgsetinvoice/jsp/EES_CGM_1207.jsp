<%
/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EES_CGM_1207.jsp
 *@FileTitle : Neutral Pool(ZP) Invoice Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.03.26
 *@LastModifier : 이영헌
 *@LastVersion : 1.0
 * 2013.03.26 이영헌
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1207Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1207Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");
	String xml = HttpUtil.makeXML(request,response);
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
	   
		event = (EesCgm1207Event)request.getAttribute("Event");
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
<title>Rental Payable Invoice Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		document.form.ofc_cd.value = "<%=ofc_cd%>";
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="eq_knd_cd" value="Z">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="intg_cd_id">
<input type="hidden" name="vndr_seq">

<input type="hidden" name="pay_inv_seq">
<input type="hidden" name="local_date">
<input type="hidden" name="inv_eff_dt">

<!-- 개발자 작업	-->
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
					<td width="74">Cost Office</td>
					<td width="95"><input type="text" name="cost_ofc_cd" dataformat="engup" maxlength="6" style="width:60;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_office" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="79">Cost Month</td>
					<td width="95"><input type="text" name="cost_yrmon" dataformat="ym" maxlength="6" style="width:60;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_cost_yrmon" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="80">Lessor Code</td>
					<td width="397"><input type="text" name="p_vndr_seq" dataformat="int" maxlength="6" style="width:70;text-align:center;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_vndr" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup2">&nbsp;<input type="text" name="vndr_lgl_eng_nm" readonly style="width:288;ime-mode:disabled" class="input2" value=""></td>
					<td width="47">Option</td>
					<td><script language="javascript">ComComboObject('chss_mgst_inv_sts_cd', 1, 118, 0, 0, 0, false);</script></td>
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

				<table class="height_5"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="67">Issue Date</td>
					<td width="160"><input type="text" name="inv_iss_dt" dataformat="ymd" maxlength="8" style="width:80;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_inv_iss_dt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"><!--&nbsp;/&nbsp;<input type="text" name="inv_eff_dt" readonly style="width:80;ime-mode:disabled" class="input2" value=""--></td>
					<td width="60">RCV Date</td>
					<td width="160"><input type="text" name="inv_rcv_dt" dataformat="ymd" maxlength="8" style="width:80;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_inv_rcv_dt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="60">Pay Term</td>
					<td width=""><input name="gen_pay_term_cd" type="text" readonly style="width:80" class="input2" value=""></td>
				</tr> 
				</table>
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Invoice Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Cancel">Cancel</td>
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
	
<!-- hidden 처리 (S)-->
<div style="display:none">
<script language="javascript">ComSheetObject('sheet3');</script>
</div>
<!-- hidden 처리 (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>