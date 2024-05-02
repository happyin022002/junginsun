<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0419.jsp
*@FileTitle : VL/VD EDI Test Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.31 우경민
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0419Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0419Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementFinder");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCtm0419Event)request.getAttribute("Event");
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
<title>VL/VD EDI Test Result</title>
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
<style>
 .Obj1 {background:#C9FD86}
 .Obj2 {background:#FFFFFF}
</style>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg" style="height:516" valign="top">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="40">T/VVD</td>
					<td width="100"><input type="text" style="width:80;" class="input1" name="vls_cd" maxlength="9" tabindex="1"></td>
					<td width="30">Port</td>
					<td width="70"><input type="text" style="width:50;" class="input1" name="pol_cd" maxlength="5" tabindex="2"></td>
					<td width="180">
						<table class="search_sm2" border="0" style="width:150;">
							<tr class="h23">
								<td width="40">MVMT</td>
								<td class="stm"><input type="radio" value="VL" name="flgrslt" class="trans" checked> VL&nbsp;&nbsp;<input type="radio" value="VD" name="flgrslt" class="trans"> VD</td>
							</tr>
						</table>
					</td>
					<td width="50">ETA/ETD </td>
					<td><input type="text" style="width:120;" class="input2" name="eta_etd" readonly></td>
				</tr>
				</table>

				<table class="line_bluedot"><tr><td></td></tr></table>


				<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="400" valign="top">


					<table class="search" border="0">
						<tr><td colspan="8" style="height:8;"></td></tr>
						<tr><td class="title_h"></td>
						<td class="title_s">Booking container List</td></tr>
					</table>
				<!-- Grid  (S) -->
				<table width="400"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->

			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downexcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_detail">MVMT Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->


					</td>
					<td width="239" valign="top">

					<br><br>
					<table class="search" border="0" style="width:230;">
					<tr class="h23">
						<td width="20"></td>
						<td width="60"><input type="text" style="width:50;text-align:right" class="input" name="u1"></td>
						<td width="80"><table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_unmatch">Unmatch</td>
							<td class="btn2_right"></td>
							</tr></table>
						</td>
						<td><input type="text" style="width:50;text-align:right" class="input" name="u2"></td>
					</tr>
					<tr class="h23">
						<td width="20"></td>
						<td width="60"><input type="text" style="width:50;text-align:right;" class="input" name="m1"></td>
						<td width="80"><table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_match">Match</td>
							<td class="btn2_right"></td>
							</tr></table>
						</td>
						<td><input type="text" style="width:50;text-align:right;" class="input" name="m2"></td>
					</tr>
					<tr class="h23">
						<td width="20"></td>
						<td width="60"><input type="text" style="width:50;text-align:right;" class="Obj1" name="l1"></td>
						<td width="80"><table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_total">Total</td>
							<td class="btn2_right"></td>
							</tr></table>
						</td>
						<td><input type="text" style="width:50;text-align:right;" class="Obj1" name="l2"></td>
					</tr>

					</table>


					</td>
					<td width="340" valign="top">



					<table class="search" border="0">
						<tr><td colspan="8" style="height:8;"></td></tr>
						<tr><td class="title_h"></td>
						<td class="title_s">Movement(EDI)</td></tr>
					</table>
				<!-- Grid  (S) -->
				<table width="360"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->

			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_edimsg">EDI MSG</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_detail2">MVMT Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->


					</td>
				</tr>
				</table>
				<!--  biz_2   (E) -->


				<!--  biz_3  (E) -->
				</td></tr>
			</table>
	<!--biz page (E)-->
	</td></tr>
		</table>

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
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