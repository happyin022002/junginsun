<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0006.jsp
*@FileTitle : MSC Checking
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-20
*@LastModifier : choice
*@LastVersion : 1.0
* 2009-10-20 choice
* 1.0 최초 생성
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0006Event" %>



<%
	SignOnUserAccount account = null; //Session 정보
	EsdEas0006Event  event = null; //
	Exception serverException   = null; //서버에서 발생한 에러
	DBRowSet rowSet	  = null; //DB ResultSet
	String strErrMsg = ""; //에러메세지
	int rowCount	 = 0; //DB ResultSet 리스트의 건수

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdEas0006Event)request.getAttribute("Event");
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
<title>MSC Checking</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">
    function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
    }
</script>


<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="old_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="sel_ofc_cd" value="HAM">

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
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
									<!-- Repeat Pattern -->

								</tr></table>

						</td></tr>
					</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="80"><img class="nostar">TRO Office</td>
					<td width="270">
						<input name="ctrl_ofc_cd" type="text" style="width:67;" value="<%=account.getOfc_cd()%>" onChange="javascript:fun_officeText();" onKeyUp="chkField(this, 'eng', true, 13)" maxlength="5" >
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office" >
						<input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC
					</td>
					<td width="110"><input type="radio" name="search_choice" value="TROMON" class="trans" onClick="selectWhere();" >&nbsp;&nbsp;TRO Month</td>
					<td width=""><input type="text" style="width:70" name="tromonth" value="YYYYMM" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 6)" maxlength="6" ></td>
				</tr>
				<tr class="h23">
					<td width="80"><img class="nostar">Bound</td>
					<td width="270">
						<select style="width:90;" name="s_bnd" >&nbsp;
						<option value="A" selected>All</option>
						<option value="I">In</option>
						<option value="O">Out</option>
						</select>
					</td>
					<td width="110"><input type="radio" name="search_choice" value="TRODAT" class="trans" onClick="selectWhere();" >&nbsp;&nbsp;TRO Date</td>
					<td width=""><input type="text" style="width:70" name="fromtrodate" value="YYYYMMDD" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8); " maxlength="8" >&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:70" name="totrodate" value="YYYYMMDD" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8);" maxlength="8" ></td>
				</tr>


			</table>
				<!-- : ( Week ) (E) -->



			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->



		<table class="height_10"><tr><td></td></tr></table>



		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">



			<table class="height_10"><tr><td></td></tr></table>



							<table width="100%" id="mainTable">
                      <tr>
                      	<td>
                           <script language="javascript">ComSheetObject('sheet1');</script>
                      	</td>
                      </tr>
	            </table>
			<!-- : ( Grid : Week ) (E) -->




			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
<table class="height_10"><tr><td></td></tr></table>




    </td></tr>
</table>
<!-- Outer Table (E)-->

</body>
</html>
