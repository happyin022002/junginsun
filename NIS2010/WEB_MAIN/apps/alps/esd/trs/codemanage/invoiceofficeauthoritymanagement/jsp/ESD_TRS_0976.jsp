<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0976.jsp
*@FileTitle : Invoice Office Authority Management
*Open Issues :
*Change history :
*@LastModifyDate : 2011-11-09
*@LastModifier : 유선오
*@LastVersion : 1.0
* 1.0 최초 생성
-------------------------------------------------------------------
* History
* 2011.11.09 유선오 1.0 [CHM-201114273][TRS] Invoice 권한등록 프로그램 개발
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.codemanage.invoiceofficeauthoritymanagement.event.EsdTrs0976Event"%>
<%

    SignOnUserAccount account = null; //Session 정보
	EsdTrs0976Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;		
	String userId  = "";//DB ResultSet 리스트의 건수
	String today = DateTime.getFormatString("yyyyMMdd");
	//SignOnUserAccount account = null;

	try {

		   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		   userId=account.getUsr_id();


			event = (EsdTrs0976Event)request.getAttribute("Event");
               if (serverException != null) {
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}
		}catch(Exception e) {
			out.println(e.toString());
		}
	%>
	<html>
	<head>
	<title>Invoice Office Authority Management</title>
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
	<form method="post" name="form" onSubmit="return false;">
	<input	type="hidden" name="f_cmd">	
	<input type="hidden" name="hid_cre_date" value="<%=today%>">
	<input type="hidden" name="hid_cre_usr_id" value="<%=userId%>">
	

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Authority</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						
					
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve" onKeyup='enterCheck(this)'>Retrieve</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->



			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<!-- invoice office code search -->
	<table class="search">
	<tr>
	<td class="bg">
		<table class="search_in" border="0">
			<tr class="h23">
            	<td width="92">Invoice Office</td>
				<td class="sm"><input type="text" name='inv_ofc_cd' style="width: 74;"
				     value=""  onChange='getTextInvOfcCd(sheetObjects[0], document.form, this.value)'
					onKeyup='enterCheck(this)' onBlur='value_upper(this)'> 
					<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20"
	            	border="0" align="absmiddle" name='btns_office'>&nbsp;</td>


				<td width="43">Office</td>
				<td class="sm"><input type="text" name='ofc_cd' style="width: 74"
				onChange='getTextOfcCd(sheetObjects[0], document.form, this.value)'
					onKeyup='enterCheck(this)' onBlur='value_upper(this)'>
				    <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" 
				    border="0" align="absmiddle" name="btng_office">&nbsp;</td>
             </tr>
		</table>
		</td>
		</tr>
		</table>
		<table class="height_10"><tr><td></td></tr></table>
		
		<table class="search" border="0">
			<tr>
				<td class="bg">

				<table width="100%" id="mainTable">
					<tr>
						<td><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				</td>
				</tr>
				</table>


		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" id="btng_del" name="btng_del">Delete</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" id="btng_rowadd" name="btng_rowadd">Row
								Add</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" id="btng_save" name="btng_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_close" id="btn_close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<!-- Repeat Pattern -->
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
	</td></tr>
	</table>
	<!-- Outer Table (E)-->



	</form>
	</body>
	</html>
