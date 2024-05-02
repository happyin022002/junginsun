<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0028.jsp
*@FileTitle :  Container Status Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.17 이호선
* 1.0 Creation
* history 
* 2013.07.23 채창호 [CHM-201325661] ALPS Master-Master Inquiry 및 Status Update/Inquiry화면에서  컨테이너 번호 입력란 로직 변경
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EesMst0028Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.ContainerOnOffHire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMst0028Event)request.getAttribute("Event");
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="hid_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="mnr_sld_chk" value="N">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--top menu (S)-->
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
		<!-- Grid BG Box  (S) -->
     	<table class="search">
       	<tr><td class="bg">
		
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">CNTR No.</td>
					<td width="140"><input type="text" style="width:80;" class="input1" dataformat="engup" maxlength="10" name = "cntr_no" style="ime-mode:disabled;text-align:center;text-transform:uppercase;">&nbsp<input type="text" style="width:15;" class="input2"  name = "chk_dgt" dataformat="int" maxlength="1" value=""></td>
					<td width="50">Status</td>
					<td width="80"><input type="text" style="width:60;" class="input2"  readOnly value="" name = "aciac_div_cd" style="text-align:center"></td>
					<td width="45">TP/SZ</td>
					<td width="80"><input type="text" style="width:50;" class="input2"  readOnly value="" name = "cntr_tpsz_cd" style="text-align:center"></td>
					<td width="75">Lease Term</td>
					<td width="80"><input type="text" style="width:50;" class="input2"  readOnly value="" name = "lstm_cd" style="text-align:center"></td>
					<td width="60">ISO Code</td>
					<td width=""><input type="text" style="width:50;" class="input2"  readOnly value="" name = "cntr_tpsz_iso_cd" style="text-align:center"></td>
					</tr> <tr class="h23">
					<td width="">Ownership</td>
					<td width=""><input type="text" style="width:80;" class="input2"  readOnly value="" name = "ownr_co_cd" style="text-align:center"></td>
					<td width="">Current</td>
					<td width="" colspan="3"><input type="text" style="width:60;" class="input2"  readOnly value="" name = "cntr_use_co_cd" style="text-align:center"></td>
					<td width=""></td>
					<td width=""></td>
					<td width=""></td>
					</tr> 
				</table>
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
			<!-- Grid  (S) -->
														
			<table width="100%" id="mainTable" class="gridtitle">
			<tr>
				<td width="">Container Movement</td>					
			</tr>						
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
			</table> 

			<!-- Grid (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

			<!-- Grid  (S) -->
														
			<table width="100%"  id="mainTable" class="gridtitle">
			<tr>
				<td width="">Container Status</td>
			</tr>			     
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
			</table> 
			<!-- Grid (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:5;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
		    	<div id="div_reCreation" style="display:none">
		    	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="re_creation">Re-Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></div>
				</td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Master">Master</td>
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
