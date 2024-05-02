<%--
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0153.jsp
*@FileTitle : Dwell Reason Update by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.19
*@LastModifier : 손은주
*@LastVersion : 1.0
* 2011.07.19 손은주
* 1.0 최초 생성
*----------------------------------------------------------
* History

=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0140Event" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchDwellVO" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
EsdSce0140Event  event = null;				//PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;			//서버에서 발생한 에러
String strErrMsg = "";								 //에러메세지
int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

SignOnUserAccount account= null;
try {

   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	event = (EsdSce0140Event)request.getAttribute("Event");
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
<title>Dwell Reason Update by VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<body onLoad="setupPage();">
<form name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="usr_id" value="<%=account.getUsr_id() %>">
<input type="hidden" name="usr_ofc_cd" value="<%=account.getOfc_cd() %>">
<input type="hidden" name="usr_nm" value="<%=account.getUsr_nm() %>">

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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
        <tr>
          <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <!--biz page (S)-->
      <table class="search">
        <tr>
          <td class="bg"><!-- biz_1  (S) -->
            <table class="search_in" border="0" style="width:979;">
              <tr class="h23">
              	<td width="60">&nbsp;Port</td>
                <td width="108"><input type="text" name="port_cd" caption="Port" style="width:80;" class="input1" value="" dataformat="engup" onKeyUp="ComChkObjValid(this)" maxlength="5"></td>
                <td width="70"><input type="radio" name="sch_part" class="trans" checked onClick="chk_schPart(this);" value="eta">ETA</td>
                <td width="260">&nbsp;
                  <input type="text" name="fr_eta_dt" style="width:80;" class="input1" value="" maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">
                  &nbsp;~&nbsp;
                  <input type="text" name="to_eta_dt"style="width:80;" class="input1" value="" maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">
                  <img src="img/btns_calendar.gif" width="19" height="20" align="absmiddle" name="btns_calendar"></td>
                <td width="110"><input type="radio" name="sch_part" class="trans" onClick="chk_schPart(this);" value="vvd">VVD Code</td>
                <td width="115">&nbsp;
                  <input type="text" name="vvd_cd" style="width:80;" class="input2" value="" dataformat="engupnum" maxlength="9">&nbsp;</td>
                <td width="*">&nbsp;</td>
                  
              </tr>
            </table></td>
        </tr>
      </table>
      
      <table class="height_10"><tr><td></td></tr></table>
		
		
      <!--biz page (E)--></td>
  </tr>
</table>
<!--Sheet (S) -->
<table class="search" border="0">
	<tr>
		<td class="bg">
		<table width="98%" height="0" id="mainTable">
			<tr>
				<td width="98%"><script language="javascript">ComSheetObject("sheet1");</script>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<!--Sheet (E) -->
</form>
</body>
</html>
