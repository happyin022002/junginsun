<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0030.jsp
*@FileTitle : Slot Hire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.04 박희동
* 1.0 Creation
=========================================================*/%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0125Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsdSce0125Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce0125Event)request.getAttribute("Event");
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
<title>ESD_SCE_0125</title>
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
<input	type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value = "<%= strUsr_id %>">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_add" id="btn_add">Add</td><td class="btn1_right"></td></tr></table></td-->

							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
					<tr class="h23">

						<td width="40">TP ID</td>
						<td width="740">
							<input name="cust_trd_prnr_id" type="text" maxlength="20" value="" caption="TP ID" style="width:100;ime-mode:disabled"  dataformat="" >
							<input name="partnerName" type="text"   maxlength="50" style="width:300" value="" readonly>
						</td>
						<!-- td><table border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save_partner" id="btn_save_partner">Save</td><td class="btn1_right"></td></tr></table></td-->
					</tr>
					</table>

					<table class="search_in" border="0">
					<tr class="h23">

						<td width="50">POR</td>
						<td width="180">
							<input type="text" name="por_port_cd" value="" style="width:60" dataformat="engup"> <img onClick="openLocPopUp(true,'por_port_cd')" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
						<td width="30">POL</td>
						<td width="180">
							<input type="text" name="pol_port_cd" value="" style="width:60" dataformat="engup"> <img onClick="openLocPopUp(true,'pol_port_cd')" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
						</td>
						<td width="30">POD</td>
						<td width="180">
							<input type="text" name="pod_port_cd" value="" style="width:60" dataformat="engup"> <img onClick="openLocPopUp(true,'pod_port_cd')" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="35">DEL</td>
						<td width="">
							<input type="text" name="del_port_cd" value="" style="width:60" dataformat="engup"> <img onClick="openLocPopUp(true,'del_port_cd')" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		<!-- Tab BG Box  (S) -->
     	<table class="search">
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
			<table width="100%" class="search"  id="mainTable" >
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table> 

			<!--  Grid_button (S) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button" id="btnLayer" >
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowCopy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table> 
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html> 