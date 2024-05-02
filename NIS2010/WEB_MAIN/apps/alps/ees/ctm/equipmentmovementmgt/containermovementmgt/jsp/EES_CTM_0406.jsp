<%
/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_ctm_0406.jsp
*@FileTitle : International MVMT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.06.12 우경민
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0406Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0406Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementMgt");
	String strEnddate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCtm0406Event)request.getAttribute("Event");
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
<title>International MVMT</title>
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
					<td width="140"><select style="width:55;" class="input1" name="p_status" tabindex="1">
						<option value="OP" selected>OP</option>
						<option value="OC">OC</option>
						<option value="VL">VL</option>
						<option value="VD">VD</option>
						<option value="IC">IC</option>
						<option value="ID">ID</option>
						<option value="MT">MT</option>
						<option value="EN">EN</option>
						<option value="TN">TN</option>
						<option value="TS">TS</option>
						</select></td>
					<td width="70">Origin Yard</td>
					<td width="60" style="padding-top:1;"><input type="text" style="width:55;text-align:center;ime-mode:disabled" maxlength="5" class="input1" name="p_yard1" tabindex="2"></td>
					<td width="110"><script language="javascript">ComComboObject('p_yard2', 2, 50 , 0, '', 2, 0, 3)</script></td>
					<td width="70">Event date</td>
					<td><input type="text" style="width:75;ime-mode:disabled" maxlength="10" class="input1" tabindex="4" name="p_date">&nbsp;<img src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Calendar1">
						<input type="text" style="width:50;ime-mode:disabled" maxlength="5" class="input1" tabindex="5" name="p_time">
						<input type="hidden" style="width:112;ime-mode:disabled" maxlength="16" class="input1" name="p_date0">
					</td></tr>
			</table>
			<table class="search" border="0" style="width:979;" id="condHidden" style="display:none">
				<tr class="h23">
					<td width="50">VVD CD</td>
					<td width="140"><input type="text" style="width:80;ime-mode:disabled" maxlength="9" class="input" name="p_vvd" tabindex="6"> <!-- <input type="text" style="width:46;ime-mode:disabled" maxlength="4" class="input" name="p_vvd1_1" tabindex="6">&nbsp;<input type="text" style="width:40;ime-mode:disabled" maxlength="4" class="input" name="p_vvd1_2" tabindex="7">&nbsp;<input type="text" maxlength="1" style="width:20;ime-mode:disabled" class="input" name="p_vvd1_3" tabindex="8">--></td>
					<td width="30">POL</td>
					<td width="90"><input type="text" style="width:50;ime-mode:disabled" maxlength="5" class="input" name="p_pol" tabindex="7"></td>
					<td width="30">POD</td>
					<td width="90"><input type="text" style="width:50;ime-mode:disabled" maxlength="5" class="input" name="p_pod" tabindex="8"></td>
					<td width="30">F/M</td>
					<td style="padding-left:2"><select style="width:60;"class="input" name="p_type1" tabindex="9">
						<option value="" selected>ALL</option>
						<option value="F">Full</option>
						<option value="M">Empty</option>
						</select></td>
					<td><input type="hidden" style="width:60;"class="input" name="p_type2"></td>
					<!--
					<td width="70">Local T/S</td>
					<td><select style="width:60;"class="input" name="p_type3">
						<option value="" selected>ALL</option>
						<option value="N">Local</option>
						<option value="Y">T/S</option>
						</select></td> -->
				</table>
				<!--  biz_1   (E) -->

		</td></tr>
		</table>

		<table class="height_8"><tr><td colspan="8"></td></tr></table>

		<table class="search">
       	<tr><td class="bg" style="height:470" valign="top" id="sheetFr">
				<!--  biz_2  (S) -->

				<!-- Grid  (S) -->
					<table width="100%" class="search"  id="mainTable">
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet');</script>
							<div id='hiddenGrid' style='display:none'><script language="javascript">ComSheetObject('sheet0');</script></div>
							</td>
						</tr>
					</table>
						<!-- Grid (E) -->
					<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr>
            <td>
				<table class="search" border="0">
					<tr class="h23">
						<td align="right">Diff.Check Digit</td>
						<td style="padding-left:4;padding-top:3">
							<input type="text" style="width:90; ime-mode:disabled;" class="input" maxlength="11" tabindex="10" name="p_cntrno">
						</td>
              		</tr>
				</table>
				</td>
	       	  <td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_add">Row&nbsp;Add</td>
								<td class="btn2_right"></td>
							</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td>
									<img src="img/btns_multisearch.gif" name="btn_multi_add" width="19" height="20" border="0" align="absmiddle" class="cursor">
								</td>
							</tr>
							</table>
						</td>
						<td>&nbsp;</td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_select">Select CNTR</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_qty">QTY Check</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td id="condPreCheck" style="display:none"><table width="100%" border="0" cellpadding="0"  cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_pre">PreCheck</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td id="btnExcel" style="display:"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_loadExcel">LoadExcel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downExcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				<!--  biz_2   (E) -->
				</td></tr>
			</table>
			<div id="checkDigitHint" name="checkDigitHint" style="position:absolute; z-index:99; width:750px; font-size:12px; font-family:Tahoma,verdana,arial,dotum,gulim;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				For container having incorrect check digit, insert it into column "Diff.Check Digit" and then update movement.
			</div>
	<!--biz page (E)-->


	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" id="condSearch" style="display:none" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>

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