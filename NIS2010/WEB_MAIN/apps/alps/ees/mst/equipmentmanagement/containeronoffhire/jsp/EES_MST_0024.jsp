<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0024.jsp
*@FileTitle : Container Status Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.07.27 이호선
* 1.0 Creation
=========================================================
* 2010.07.05 남궁진호 - st_cd ComboList에 SRO,SRI 추가
*  2013.03.13 채창호    [CHM-201323498-01] ALPS Maater-Status에서 SOC 장비의 OC/OP상태에서 Movement XX 처리 로직 Upgarde  요청
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EesMst0024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.ContainerOnOffHire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMst0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	// pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>
<html>
<head>
<title>::</title>
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
<% if (popMode.equals("Y")) { %>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Container Status Creation - LSO/SBO/SBI/MUO/MUI</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

<%} else{ %>
<body  onLoad="setupPage();">
<form name="form">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
<%} %>
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="hidden_curdate">
<input type="hidden" name="hid_cntr_no">	
	<!--biz page (S)-->
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg" style="height:515;" valign="top">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Status Code</td>
					<td width="170"><select style="width:70;" class="input1" name="st_cd" style="text-align:center">
						<option value="0" selected >LSO</option>
						<option value="1" >SBO</option>
						<option value="2" >SBI</option>
						<option value="3" >MUO</option>
						<option value="4" >MUI</option>
						<option value="5" >SRO</option>
						<option value="6" >SRI</option>
						<option value="7" >XX(SOC)</option>
						</select></td>
					<td width="80">Date</td>
					<td width="150"><input type="text" style="width:80" class="input1" dataformat="ymd" name="hire_date" maxlength="10" style="text-align:center">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="cal_img" style="cursor:hand" onClick="func_calendar('calendarPopup1')"></td>
					<td width="55">Yard</td>
					<td width=""><input type="text" style="width:104" class="input1" dataformat="engup" name="sts_evnt_yd_cd" style="ime-mode:disabled;text-align:center" maxlength="7">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTargetYard">&nbsp;<input type="text" style="width:225" class="input2" ReadOnly value="" name="yd_cd_nm" style="ime-mode:disabled"></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">AGMT No.</td>
					<td width="170"><input type="text" style="width:30" class="input" dataformat="engup" name="agmt_cty_cd" maxlength="3" value="HHO" style="ime-mode:disabled">&nbsp;<input type="text" style="width:80" class="input" dataformat="engup" name="agmt_seq" style="ime-mode:disabled;text-align:center" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTargetAgmtNo"></td>
					<td width="80">Contract No.</td>
					<td width="150"><input type="text" style="width:103" class="input2" dataformat="engup" value="" ReadOnly name="ref_no" maxlength="12" style="text-align:LEFT"></td>
					<td width="55">Lessor</td>
					<td><input type="text" style="width:50" class="input2"  name="vndr_seq" dataformat="engup" ReadOnly maxlength="6">&nbsp;<input type="text" style="width:50" ReadOnly class="input2" name="vndr_abbr">&nbsp;<input type="text" style="width:248" class="input2" name="vndr_nm" readonly style="text-align:LEFT"></td>
					<td width=""></td>
					<td width=""></td>
				</tr> 
				<!--<tr class="h23">
					<td>DPP Free day</td>
					<td><input type="text" style="width:50" class="input2" name="dpp_free_dy"></td>
				</tr>--> 
			</table>
			
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						<div style="display: none"><script language="javascript">ComSheetObject('sheet2');</script></div>       						
						<div style="display: none"><script language="javascript">ComSheetObject('sheet3');</script></div>
						<!--<script language="javascript">ComSheetObject('sheet2');</script>--> 							
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->		


			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_master">&nbsp;&nbsp;&nbsp;Master&nbsp;&nbsp;&nbsp;</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downexcel">Format Down</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_loadexcel">Load Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>							
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
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
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
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
<% if (popMode.equals("Y")) { %>
      <!-- : ( Button : pop ) (S) -->
      <table width="100%" class="sbutton">
        <tr>
          <td height="71" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
              <tr>
                <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn1_left"></td>
                            <td class="btn1" name="btn_close">Close</td>
                            <td class="btn1_right"></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!-- : ( Button : pop ) (E) -->

<% } %>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
