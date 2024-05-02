<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1021.jsp
*@FileTitle : Lease Agreement List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.19 김창식
* 2009.09.22 조재성 print
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1021Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	EesCgm1021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	String strOfc_id   = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_id = account.getOfc_cd();
	   
		event = (EesCgm1021Event)request.getAttribute("Event");
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
<title>Lease Agreement List Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
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

<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name ="ofc_cd" value="">

<!-- Form Hidden -->
<input type="hidden" name ="intg_cd_id" value="">
<input type="hidden" name ="eq_knd_cd" value="Z">
<input type="hidden" name ="eff_flag" value="">
<input type="hidden" name ="agmt_no" value="">
<input type="hidden" name="s_usr_id" value="<%=strUsr_id %>" >
<input type="hidden" name="s_ofc_id" value="<%=strOfc_id %>" >


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
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Office</td>
					<td width="150">&nbsp;<input type="text" name="agmt_iss_ofc_cd" dataformat="engup" maxlength="6" style="width:78;text-align:center;ime-mode:disabled" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1" name="ComOpenPopupWithTarget1"></td>
					<td width="250">
						<table class="search_sm2" border="0"  style="width:90%;">
							<tr class="h23">
								<td width="60">Effective</td>
								<td class="stm"><input name="eff_flag_yes" id="eff_flag_yes" type="radio" value="" class="trans">Yes&nbsp;&nbsp;<input name="eff_flag_no" type="radio" value="" class="trans">No&nbsp;&nbsp;<input name="eff_flag_all" type="radio" value="" class="trans" checked>All&nbsp;&nbsp;</td>
							</tr>
						</table>
					</td>
					<td width="110">Agreement Date</td>
					<td width="399"><input name="agmt_dt_fr" type="text" dataformat="ymd" maxlength="8" style="width:78;text-align:center;ime-mode:disabled" class="input" value="">&nbsp;~&nbsp;<input type="text" name="agmt_dt_to" dataformat="ymd" maxlength="8" style="width:78;text-align:center;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_Calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>  </tr>
				<tr class="h23">
					<td>Lease Term</td>
					<td>&nbsp;<script language="javascript">ComComboObject('agmt_lstm_cd', 1, 78, 0, 0, 0, false);</script></td>
					<td colspan="3">&nbsp;Lessor&nbsp;&nbsp;<input type="text" name="vndr_seq" dataformat="num" style="width:102;ime-mode:disabled" class="input" value="">&nbsp;<input type="text" name="vndr_lgl_eng_nm" style="width:402;ime-mode:disabled" class="input2" value="" readonly>&nbsp;<img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup2" name="ComOpenPopupWithTarget2"></td>  </tr>
				</table>
				
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
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
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_VersionDetails">Version&nbsp;Details</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
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

</form>
<!-- 개발자 작업  끝 -->
</body>
</html>