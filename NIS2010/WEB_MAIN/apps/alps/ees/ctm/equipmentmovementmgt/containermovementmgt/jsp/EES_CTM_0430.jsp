<%--
 - Copyright(c) 2009 CyberLogitec
 - @FileName : ees_ctm_0430.jsp
 - @FileTitle : CNTR History Update
 - Open Issues :
 - Change history :
 - @LastModifyDate : 2015.09.22
 - @LastModifier : 김상현
 - @LastVersion : 1.1
 - 2009.05.08 우경민 1.0 Creation.
 - 2015.09.22 김상현 1.1 [CHM-201537939] Latest Bkg 항목 추가 및 Batch 건 data요청(Logic 추가)
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0430Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesCtm0430Event  event = null;         //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;    //서버에서 발생한 에러
	String strErrMsg = "";                 //에러메세지
	String usrOffice = "";                 // OFFICE CODE
	try {

		event = (EesCtm0430Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		usrOffice = account.getOfc_cd();
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}

	// Corr Reason
    String cnmvCorrRsn = JSPUtil.getIBCodeCombo("", "", "CD03488", 0, "");
	String cnmvCorrRsnCode = "";
	String cnmvCorrRsnValue = "";

	if (cnmvCorrRsn != null && cnmvCorrRsn.length() > 0) {
		cnmvCorrRsnCode = cnmvCorrRsn.substring(cnmvCorrRsn.indexOf("Code = \"") + 8, cnmvCorrRsn.lastIndexOf("\""));
		cnmvCorrRsnValue = cnmvCorrRsn.substring(cnmvCorrRsn.indexOf("Text = \"") + 8, cnmvCorrRsn.indexOf("\";"));
	}

	String cntrNo = (request.getParameter("cntrNo") == null)? "": request.getParameter("cntrNo");
	String chkDgt = (request.getParameter("chkDgt") == null)? "": request.getParameter("chkDgt");
	String tpSz = (request.getParameter("tpSz") == null)? "": request.getParameter("tpSz");
	String autoFlg = (request.getParameter("autoFlg") == null)? "": request.getParameter("autoFlg");

	// pop_mode
	String popMode = (request.getParameter("pop_mode") == null)? "N" : "Y";
%>
<html>
<head>
<title>CNTR History Update</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/apps/alps/ees/ctm/equipmentmovementmgt/containermovementmgt/script/common_0430.js"></script>
<script language="javascript">
	var cnmvCorrRsnCode = "<%=cnmvCorrRsnCode %>";
	var cnmvCorrRsnValue = "<%=cnmvCorrRsnValue %>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}

</script>
</head>
<!-- 개발자 작업	-->


<% if (popMode.equals("Y")) { %>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CNTR History Update</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

<% } else { %>

<body onLoad="setupPage();">
<form name="form">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->

<% } %>

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="p_date1">
<input type="hidden" name="usr_office" value="<%=usrOffice%>">
<input type="hidden" name="auto_flg" value="<%=autoFlg%>">

	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="90">Container No.</td>
					<td><input type="text" style="width:80;ime-mode:disabled;" tabindex="1" name="p_cntrno" class="input1" maxlength='10' value="<%=cntrNo%>">&nbsp;<input type="text" style="width:20;" maxlength="1" name="check_digit" tabindex="2" class="input" value="<%=chkDgt %>">&nbsp;<input type="text" style="width:26;" class="input" name="ctnr_tpsz_cd" value="<%=tpSz %>" readonly>&nbsp;</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->

		</td></tr>
		</table>

		<table class="height_8"><tr><td colspan="8"></td></tr></table>

		<table class="search">
       	<tr><td class="bg" style="height:465" valign="top">
				<!--  biz_2  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">VVD /BKG History</td></tr>
				</table>
				<!-- Grid 1 (S) -->

					<table width="100%" class="search"  id="mainTable">
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject("sheet1");</script>
							</td>
						</tr>
					</table>
						<!-- Grid 1(E) -->

						<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Movement History (Update)</td></tr>
				</table>
				<!-- Grid 2(S) -->

					<table width="100%" class="search"  id="mainTable">
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject("sheet2");</script>
							</td>
						</tr>
					</table>
						<!-- Grid2(E) -->
					<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_add">Row&nbsp;Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
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
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_history_open">Correction History</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td class="btn1_line"></td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn2_save">Save</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn2_downexcel">Down Excel</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td></tr>
		</table>
    	<!--Button (E) -->
	</td></tr>
</table>

<% if (popMode.equals("Y")) { %>

      <table class="height_5"><tr><td></td></tr></table>
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

	<script language="javascript">ComUploadObject('upload', '<%=session.getId() %>');</script>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>