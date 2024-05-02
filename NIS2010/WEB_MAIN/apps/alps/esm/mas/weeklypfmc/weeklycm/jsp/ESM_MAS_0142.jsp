<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0142.jsp
*@FileTitle : VVD Check List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2007.03.27 박은주  최초 생성
* 2009.10.15 박수훈 New FrameWork 적용[0142]
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	Logger log = Logger.getLogger("com.hanjin.apps.WeeklyPFMC.WeeklyCM");
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		log.error("Exception : " + e.toString());
	}
%>
<html>
<head>
<title>VVD Check List</title>
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
<input type="hidden" name="pagerows">

<input type="hidden" name="f_chkprd" value="<%= request.getParameter("f_chkprd")==null?"W":request.getParameter("f_chkprd") %>">
<input type="hidden" name="f_year"   value="<%= request.getParameter("f_year")==null?"2007":request.getParameter("f_year") %>">
<input type="hidden" name="f_fm_mon" value="<%= JSPUtil.getNull(request.getParameter("f_fm_mon")) %>">
<input type="hidden" name="f_to_mon" value="<%= JSPUtil.getNull(request.getParameter("f_to_mon")) %>">
<input type="hidden" name="f_fm_wk"  value="<%= request.getParameter("f_fm_wk")==null?"23":request.getParameter("f_fm_wk") %>">
<input type="hidden" name="f_to_wk"  value="<%= request.getParameter("f_to_wk")==null?"23":request.getParameter("f_to_wk") %>">

<input type="hidden" name="f_trd_cd" value="<%= JSPUtil.getNull(request.getParameter("f_seltrade")) %>">
<input type="hidden" name="f_rlane_cd" value="<%= JSPUtil.getNull(request.getParameter("f_selrlane")) %>">
<input type="hidden" name="f_slane_cd" value="<%= JSPUtil.getNull(request.getParameter("f_selslane")) %>">
<input type="hidden" name="f_seldir" value="<%= JSPUtil.getNull(request.getParameter("f_seldir")) %>">
<input type="hidden" name="f_ioc_cd" value="<%= JSPUtil.getNull(request.getParameter("f_selioc")) %>">
<input type="hidden" name="f_vsl_cd" value="<%= JSPUtil.getNull(request.getParameter("f_vsl_cd")) %>">
<input type="hidden" name="f_skd_voy_no" value="<%= JSPUtil.getNull(request.getParameter("f_skd_voy_no")) %>">
<input type="hidden" name="f_dir_cd" value="<%= JSPUtil.getNull(request.getParameter("f_dir_cd")) %>">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr>
    <td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; VVD Check List</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
				<!-- : ( Grid ) (E) -->

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->

    </td>
</tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Save" id="btn_Save">Save</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_Close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
			</table>
		</td></tr>
		</table>
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>
