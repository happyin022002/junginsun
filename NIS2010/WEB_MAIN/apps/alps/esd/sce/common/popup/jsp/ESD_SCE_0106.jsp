<%--
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_SCE_0106.jsp
*@FileTitle : Notified Subscriber - Search Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2008-04-21
*@LastModifier : YuJin
*@LastVersion : 1.0
* 1.0
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%

	CommonPopUpManageEvent event = null;
	SignOnUserAccount account = null; 						//Session 정보
	Exception serverException = null;					 	//서버에서 발생한 에러
	DBRowSet rowSet = null;							   		//DB ResultSet
	String strErrMsg = "";									//에러메세지
	int rowCount	 = 0;								  	//DB ResultSet 리스트의 건수
  //String strUsrNm = "";&&&소스품질주석처리

	//String sofccd = request.getParameter("ctrl_ofc_cd") == null ? "" : request.getParameter("ctrl_ofc_cd");&&&소스품질주석처리
	//String selfccd = request.getParameter("sel_ofc_cd") == null ? "" : request.getParameter("sel_ofc_cd");&&&소스품질주석처리

	//System.out.println("\n sofccd :" + sofccd.toString() );&&&소스품질주석처리
	//System.out.println("\n selfccd :" + selfccd.toString() );&&&소스품질주석처리

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (CommonPopUpManageEvent)request.getAttribute("Event");
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
<title>Welcome to NMS!</title>
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
<input    type="hidden" name="f_cmd">


<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Country</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

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
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<table class="search" border="0" style="width:100%">
						<tr class="h23">
							<td width="65">Continent</td>
							<td width="90"><select name="conti_cd" style="width:65;">
								<option value="N" selected>All</option>
								<option value="A">ASIA</option>
								<option value="E">EUROPE</option>
								<option value="F">AFRICA</option>
								<option value="M">AMERICA</option>
							</select></td>
							<td width="95">Sub Continent</td>
							<td width="180"><select name="sub_conti_cd" style="width:150;">
								<option value="N" selected>All</option>
								<option value="AE">SOUTH EAST ASIA</option>
								<option value="AF">FAR EAST ASIA</option>
								<option value="AM">MIDDLE EAST ASIA</option>
								<option value="AO">OCEANIA</option>
								<option value="AW">SOUTH WEST ASIA</option>
								<option value="EC">SCANDINAVIA EUROPE</option>
								<option value="EE">EAST EUROPE</option>
								<option value="EN">NORTH EUROPE</option>
								<option value="ES">SOUTH EUROPE</option>
								<option value="FC">CENTRAL AFRICA</option>
								<option value="FE">EAST AFRICA</option>
								<option value="FN">NORTH AFRICA</option>
								<option value="FS">SOUTH AFRICA</option>
								<option value="FW">WEST AFRICA</option>
								<option value="MC">CENTRAL AMERICA</option>
								<option value="MN">NORTH AMERICA</option>
								<option value="MS">SOUTH AMERICA</option>
							</select></td>
							<td width="50">Country</td>
							<td width="89"><input name="cnt_cd" type="text" value="" dataformat="engup" style="width:64; text-transform:uppercase;" onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)"></td>
							<td width="90">Country Name</td>
							<td width=""><input name="cnt_nm" type="text" value="" dataformat="engup" style="width:100; text-transform:uppercase;"></td>
						</tr>
					</table>


					<table class="height_10"><tr><td></td></tr></table>

				<!-- : ( Speed ) (S) -->
				<table border="0" style="width:100%; background-color:white;" class="grid2"  id="mainTable">
				<tr>
					<td>
                      <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                 </tr>
				 </table>
				<!-- : ( Speed ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->


</body>
</html>
<%@include file="../../../common/commonpopup/include/common.jsp"%>