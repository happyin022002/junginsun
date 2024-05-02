<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_8102.jsp
*@FileTitle : Select Route
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.18 문동선
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.event.EsmPri8102Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri8102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String pol_port_cd      = "";
	String pod_port_cd      = "";
	Logger log = Logger.getLogger("com.hanjin.apps.specialcargoquotation.scqawkward");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri8102Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		pol_port_cd = JSPUtil.getParameter(request, "pol_port_cd" );
		pod_port_cd = JSPUtil.getParameter(request, "pod_port_cd" );

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
  
	// pop_mode
    String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
    String bb_flag = (request.getParameter("bb_flag")  == null)? "N": "Y";
%>
<html>
<head>
<title>Ocean Route List</title>
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
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Ocean Route List</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

<% } else { %>

<body onLoad="setupPage();">
<form name="form">
<table border="0" cellpadding="0" cellspacing="0" style="padding: 5 0 0 2;">
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
<input type="hidden" name="bb_flag" value="<%=bb_flag%>">

      <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_selection">Selection</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- Button (S) -->
      
      <table class="height_8"><tr><td colspan="8"></td></tr></table>
      
      <!-- biz_1 (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <table style="width:979">
              <tr class="h23">
                <td width="30">POL</td>
                <td width="95"><input type="text" style="width:65;" class="input" value="<%=pol_port_cd %>" maxlength="5" name="pol_port_cd" dataformat="engup"  >
                        <img class="cursor" src="img/btns_search.gif" name="btns_searchPol" width="19" height="20" border="0" align="absmiddle" tabindex=-1></td>
                <td width="70"></td>
                <td width="30">POD</td>
                <td width="95"><input type="text" style="width:65;" class="input" value="<%=pod_port_cd %>" maxlength="5" name="pod_port_cd" dataformat="engup" >
                        <img class="cursor" src="img/btns_search.gif" name="btns_searchPod" width="19" height="20" border="0" align="absmiddle" tabindex=-1></td>
                <td width="70"></td>
                <td width="600"></td>
                <!-- 
                <td width="60">T/S Port</td>
                <td width="95"><input type="text" style="width:65;" class="input" value="" maxlength="5" name="prm_tsport">
                        <img class="cursor" src="img/btns_search.gif" name="btns_searchTsport" width="19" height="20" border="0" align="absmiddle" tabindex=-1></td>
                <td width="70"></td>
                <td width="35">Lane</td>
                <td width="125"><input type="text" style="width:95;" class="input" value="" maxlength="5" name="prm_lane">
                        <img class="cursor" src="img/btns_search.gif" name="btns_searchLane" width="19" height="20" border="0" align="absmiddle" tabindex=-1></td>
                <td width="74"></td>
                <td width="35">Type</td>
                <td width="95"><select style="width:90;" class="input" name="prm_type" tabindex="1">
                  <option value="All" selected>All</option> 
                  <option value=""></option>
                  <option value=""></option>
                  </select></td>
                  -->
              </tr>
            </table>           
          </td>
        </tr>
      </table>
      <!-- biz_1 (E) -->

      <table class="height_8"><tr><td colspan="8"></td></tr></table>

      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <table class="search" border="0" id="mainTable" style="width:979"> 
              <tr class="h23">
                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>

    </td>
  </tr>
</table>

<% if (popMode.equals("Y")) { %>
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



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>