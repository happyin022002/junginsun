<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0104.jsp
*@FileTitle : Container Type Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.14
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.14 김봉균
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event.EsmAcm0104Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0104Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  
  String row = "";  // Sheet에서 팝업 호출시, Target이 되는 Cell의 row 정보
  String col = "";  // Sheet에서 팝업 호출시, Target이 되는 Cell의 col 정보
  String cntrTp = "";  // Sheet에서 팝업 호출시, Target이 되는 Cell의 Value
  Logger log = Logger.getLogger("com.hanjin.apps.ACMSetup.ACMSetup");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0104Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    row = JSPUtil.getParameter(request, "row");
    col = JSPUtil.getParameter(request, "col");
    cntrTp = JSPUtil.getParameter(request, "fac_spcl_cntr_tp_ctnt");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>
<head>
<title>Container TP/SZ Selection</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<input type="hidden" name="row" value="<%=row%>">
<input type="hidden" name="col" value="<%=col%>">
<input type="hidden" name="cntrTp" value="<%=cntrTp%>">
<input type="hidden" name="chg_ddct_grp_id"><!-- Sheet1의 Group Name -->

<table width="350"  class="popup" border="0" cellpadding="10">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">

      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <td class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">Container Type Selection</td>
      </table>
      <!-- Page Title, Historical (E) -->
      
      <table class="height_8"><tr><td></td></tr></table>
      
      <!-- biz page (S) -->
      <table class="search" border="0" style="width:300;">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_1 (S) -->
            <!-- Grid_1 (S) -->
            <table width="300" id="mainTable1">
              <tr>
                <td><script language="javascript">ComSheetObject("sheet1");</script></td>
              </tr>
            </table>
            <!-- Grid_1 (E) -->
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>
      <!-- biz page (E) -->
      
      <!-- Button (S) -->
      <table class="height_8"><tr><td></td></tr></table>
	  <table width="100%" class="sbutton">
	    <tr>
		  <td>
	        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	          <tr>
	            <td class="btn3_bg">
	              <table border="0" cellpadding="0" cellspacing="0">
	   				<tr>		
					  <td>
					    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						  <tr>
						    <td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">OK</td><td class="btn1_right"></td>
						  </tr>
						</table>
					  </td>
					  <td class="btn1_line"></td>
					  <td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						  <tr>
							<td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td>
							<td class="btn1_right"></td>
						  </tr>
						</table>
					  </td>
					</tr>
				  </table>
	            </td>
	          </tr>
	        </table>
	      </td>
	    </tr>
	  </table>
      <!-- Button (E) -->

    </td>
  </tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>
