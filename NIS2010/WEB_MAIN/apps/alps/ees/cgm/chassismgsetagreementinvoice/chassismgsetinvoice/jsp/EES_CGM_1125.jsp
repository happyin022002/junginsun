<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1125.jsp
*@FileTitle : Estimated Pool Chassis Expense(Co-Pool N/P)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.17 최민회
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1125Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm1125Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1125Event)request.getAttribute("Event");
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
<title>Estimated Pool Chassis Expense(Co-Pool N/P)</title>
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
<form name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="chss_pool_tp_cd" value='CP'>
<input type="hidden" name="chss_pool_cd">
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
		
		<!-- Tab (S) Hire,  Other Exp,  Payment Term,  Redelivery,  CP file up, Certi File up,-->
     		
		<!-- Tab  (E) -->
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
		
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">Year</td>
					<td width="130"><input type="text" style="width:60;ime-mode:disabled" dataformat="yyyy"  maxlength="4" class="input1" name="year" value="">
					              <img name="btns_Calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="">
						<table class="search_sm2" border="0" style="width:640;"> 
							<tr class="h23">
								<td width="80">&nbsp;Pool Type</td>
								<td class="stm"><input type="radio" class="trans" name="chss_pool" onclick="javascript:title_chk(1)" checked>Co-Pool&nbsp;&nbsp;&nbsp;
								                <input type="radio" name="chss_pool" class="trans" onclick="javascript:title_chk(2)">NP&nbsp;&nbsp;&nbsp; 
						<script language="javascript">ComComboObject('chss_pool_co_cd', 1, 420, 1, 1, 1, true);</script></td>
							</tr> 
						</table>
				</tr> 
			</table>
			
			<table class="line_bluedot"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:;"> 
			<tr class="h23">
			<td width="681">
			<div id="tabLayer" style="display:inline">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Co-Pool</td>
				</tr>
				</table>
			</div>
			<div id="tabLayer" style="display:none">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">NP</td>
				</tr>
				</table>
			</div>
			</td>
			<td>
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">	
				<td width="66">Currency</td>
				<td width=""><input type="text" style="width:50;ime-mode:disabled;text-align:center" dataformat="eng"  name="curr_cd" class="input" value="USD" maxlength="3"></td>
				</tr> 
				</table>
			</td>
				<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject1('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			
			
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
		</td>
				</tr>
			</table>
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" ID ="btn_retrieve">Retrieve</td>
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!--  chungpa 20100428 report popup removed.
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Report">Report</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				 -->

				
		</tr>
		</table></td>
		</tr>
		</table>
    <!--Button (E) -->
		</td></tr>
</table>
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>