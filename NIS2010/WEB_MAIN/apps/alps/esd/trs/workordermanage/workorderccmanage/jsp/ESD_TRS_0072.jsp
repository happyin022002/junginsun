<%--
/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_0072.jsp
 *@FileTitle : Transportation Report & Code
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.14
 *@LastModifier : 최 선
 *@LastVersion : 1.1
 * 2006.11.07 조풍연
 * 1.0 최초 생성
 *----------------------------------------------------------
 * History
 * 2010.12.14  최 선	1.1 [CHM-201007747] W/O CC 상 오류 수정요청
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.event.EsdTrs0072Event"%>
<%
	EsdTrs0072Event  			event 				= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 					serverException   	= null;		//서버에서 발생한 에러
	DBRowSet 					rowSet	  			= null;		//DB ResultSet
	String 						strErrMsg 			= "";		//에러메세지
	int 						rowCount	 		= 0;		//DB ResultSet 리스트의 건수

	SignOnUserAccount 			account 			= null;
	String 						loginUserId			= null;
	String 						loginUserCtrlOfcCd	= null;

	try {
		account				= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		loginUserId			= account.getUsr_id();
		loginUserCtrlOfcCd	= account.getOfc_cd();

		event = (EsdTrs0072Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Transportation Report & Code</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form 	method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"												>
<input 	type="hidden" name="SELECTED_VNDR_SEQ"									>
<input 	type="hidden" name="SELECTED_CTRL_OFC_CD"								>
<input 	type="hidden" name="SELECTED_LOC_CD"									>
<input 	type="hidden" name="LOGIN_USER_OFC_CD" 	value="<%=loginUserCtrlOfcCd%>"	>
<input 	type="hidden" name="LOGIN_USER_ID" 		value="<%=loginUserId%>"		>
<input	type="hidden" name="FAX_EMAIL_INDICATOR"								>
<input 	type="hidden" name="iPage"												>
<!--<input 	type="hidden" name="combo_svc_provider"									>-->	<!-- vendor name 조회용. 공통화 되면 변경될 수 있음. -->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->



		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve1">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
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
							<td width="16%">Service Provider Code</td>
							<td width="12%"><input  class="input1" name="combo_svc_provider" type="text" style="width:50;" maxlength="6" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_provider'></td>
							<td width="16%">Service Provider Name</td>
							<td width="22%" style="padding-left:3;"><input name="svc_provider"  type="text" style="width:150;" value="" readonly  class="input2"  title="This inputbox cant't write"></td>
							<td width="10%">Control Office</td>
							<td width="17%"><input name="control_office_cd" type="text" style="width:80;" value="" maxlength="6" onkeyup="upper(this)"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_control_office'></td>
							<td width="12%">Location</td>
							<td align="right"><input name="location_cd" type="text" style="width:80;" value="" maxlength="5"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_location'></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


					<!-- TABLE '#D' : ( Button : Main ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btn_retrieve2">Retrieve</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- TABLE '#D' : ( Button : Main ) (E) -->
					<table class="height_2"><tr><td></td></tr></table>

					<!-- : ( Grid ) (S) -->
					<table width="100%" id="MainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid ) (E) -->

		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="search" border="0">
						<tr>
							<td width="600">
								<!-- : ( Grid ) (S) -->
					<table width="100%" id="FaxTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>
								<!-- : ( Grid ) (E) -->
							</td>
							<td width="17"></td>
							<td width="600">

								<!-- : ( Grid ) (S) -->
					<table width="100%" id="EmailTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
		            </table>
								<!-- : ( Grid ) (E) -->


							</td>
						</tr>

					</table>


					<!-- : ( Grid ) (E) -->
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
							<td class="btn2_left"></td><td class="btn2" name="btn_fax_row_add">Fax Row Add</td><td class="btn2_right"></td>
							<td class="btn2_left"></td><td class="btn2" name="btn_eml_row_add">Email Row Add</td><td class="btn2_right"></td>
							<td class="btn2_left"></td><td class="btn2" name="btn_save">Save</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
			</td></tr>
		</table>
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>