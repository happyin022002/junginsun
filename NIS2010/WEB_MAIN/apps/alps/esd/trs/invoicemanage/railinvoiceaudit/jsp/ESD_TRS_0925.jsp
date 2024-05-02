<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0925.jsp
*@FileTitle : USA Rail Invoice 등록 및 Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-08
*@LastModifier : chkong
*@LastVersion : 1.0
* 2006-10-13 chkong
* 1.0 최초 생성
* ----------------------------------------------------------
* History
* 2011.11.10 김종호 : [CHM-201114435][TRS] US Rail invoice 화면 일부 기능 수정요청
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0925Event"%>
<%
	EsdTrs0925Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String userId = "";
	SignOnUserAccount account = null;
	try {

	   account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   //userAuth=account.getAuth();

		event = (EsdTrs0925Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	String mode = JSPUtil.getNull(request.getParameter("mode"));
	String sel_sheet_idx = JSPUtil.getNull(request.getParameter("sel_sheet_idx"));
%>
<html>
<head>
<title>USA Rail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("inv_curr_cd", "", "CD00884", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cgo_tp_cd"  , "", "CD00748", 0, "")%>
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
<input type="hidden" name="eq_no">
<input type="hidden" name="wbl_dt">
<input type="hidden" name="rail_road_code">
<input type="hidden" name="mode" value='<%=mode%>'>
<input type="hidden" name="sel_sheet_idx" value='<%=sel_sheet_idx%>'>
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">


<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Re - Audit</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr><td class="bg">

					<table width="100%"  border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="48%">
								<table class="search" border="0">
									<tr>
										<td class="title_h"></td>
										<td class="title_s" style="padding-bottom:0;">&nbsp;Re-Audit List </td>
									</tr>
								</table>
								<!-- : ( Grid ) (S) -->
								<table width="100%" id="mainTable">
            			              <tr><td>
            			                     <script language="javascript">ComSheetObject('sheet1');</script>
            			              </td></tr>
            				    </table>
								<!-- : ( Grid ) (E) --></td>
							<td width="50%" style="padding-left:15;">
								<table class="search" border="0"">
									<tr>
										<td class="title_h"></td>
										<td class="title_s" style="padding-bottom:0;">&nbsp;CLM History </td>
									</tr>
								</table>
								<!-- : ( Grid ) (S) -->
								<table width="100%" id="mainTable">
            			              <tr><td>
            			                     <script language="javascript">ComSheetObject('sheet2');</script>
            			              </td></tr>
            				    </table>
								<!-- : ( Grid ) (E) --></td>
						</tr>
					</table></td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>


		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0">
						<tr>
							<td class="title_h"></td>
							<td class="title_s" style="padding-bottom:0;">&nbsp;Invoice</td>
						</tr>
					</table>
					<!-- : ( Node / Link ) (S) -->
					<table width="100%" id="mainTable">
            		      <tr><td>
            		           <script language="javascript">ComSheetObject('sheet3');</script>
            		      </td></tr>
            		</table>
					<!-- : ( Node / Link ) (E) --></td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>


		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0">
						<tr>
							<td class="title_h"></td>
							<td class="title_s" style="padding-bottom:0;">&nbsp;Billing</td>
						</tr>
					</table>


					<!-- : ( Node / Link ) (S) -->
					<table width="100%" id="mainTable">
            			  <tr><td>
            			  <script language="javascript">ComSheetObject('sheet4');</script>
            			  </td></tr>
           	    </table>
					<!-- : ( Node / Link ) (E) --></td>


			</tr>
		</table>

	</td>
</tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<%
					if(!mode.equals("search")){
				%>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_apply" id="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></td>
				<%
					}
				%>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
			</table>

		</td></tr>
		</table>
<!-- : ( Button : Sub ) (E) -->
	</td></tr>
</table>

</form>

</body>
</html>
