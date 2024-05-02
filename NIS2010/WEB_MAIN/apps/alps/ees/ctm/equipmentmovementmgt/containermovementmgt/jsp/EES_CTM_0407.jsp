<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0407.jsp
*@FileTitle : Domestic MVMT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.07.20 우경민
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0407Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0407Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCtm0407Event)request.getAttribute("Event");
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
<title>Domestic MVMT</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<table border="0" cellpadding="0" cellspacing="0" style="padding: 5 0 0 2;">
	<tr><td valign="top">

      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="50">Status</td>
					<td width="100"><select style="width:50;" class="input1" name="p_status" tabindex="1">
						<option value="CP" selected>CP</option>
						<option value="CO">CO</option>
						<option value="CI">CI</option>
						<option value="CD">CD</option>
						<option value="CM">CM</option>
						<option value="CE">CE</option>
						<option value="CT">CT</option>
						</select></td>
					<td width="70">Origin Yard</td>
					<td width="200"><input type="text" style="width:45;ime-mode:disabled" maxlength="5" class="input1" name="p_yard1" tabindex="2">&nbsp;<script language="javascript">ComComboObject('p_yard2', 2, 40 , 0, '', 2, 0, 3)</script></td>
					<td width="70">Event date</td>
					<td colspan="4"><input type="text" style="width:75;ime-mode:disabled" maxlength="10" class="input1" tabindex="4" name="p_date">&nbsp;<img src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Calendar1">
						<input type="text" style="width:50;ime-mode:disabled" maxlength="5" class="input1" tabindex="5" name="p_time">
						<input type="hidden" style="width:112;ime-mode:disabled" maxlength="16" class="input1" name="p_date0">
					</td></tr>

				</table>
				<!--  biz_1   (E) -->

		</td></tr>
		</table>

		<table class="height_8"><tr><td colspan="8"></td></tr></table>

		<table class="search">
       	<tr><td class="bg" style="height:463" valign="top">
				<!--  biz_2  (S) -->

				<!-- Grid  (S) -->
					<table width="100%" class="search"  id="mainTable">
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet');</script>
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
						<td class="btn2" name="btn_add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_loadExcel">Load Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</td></tr>
			</table>
				</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				<!--  biz_2   (E) -->
				</td></tr>
			</table>

	<!--biz page (E)-->


	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
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