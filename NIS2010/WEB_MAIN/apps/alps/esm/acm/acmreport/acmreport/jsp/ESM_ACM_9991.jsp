<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_ACM_9991.jsp
*@FileTitle : Estimated Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.06
*@LastModifier : 박다은
*@LastVersion : 1.0
* 2013.05.06 박다은
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmreport.acmreport.event.EsmAcm9991Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm9991Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMReport.ACMReport");

  try {
	    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    strUsr_id = account.getUsr_id();
	    strUsr_nm = account.getUsr_nm();
	    event = (EsmAcm9991Event)request.getAttribute("Event");
	    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	    if (serverException != null) {
	      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	    }

	    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	  } catch(Exception e) {
	    out.println(e.toString());
	  }
%>
<html>
<head>
<title>Estimated  Performance</title>
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


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:1002px">
  <tr>
    <td valign="top">


      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


      <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
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
                      <td class="btn1" name="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_uploadexcel">Load Excel</td>
						<td class="btn1_right"></td>
					</tr>
				  </table>
				</td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downexcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- Button (E) -->


      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg" valign="top">

            <!-- biz_1 (S) -->

              
              <table class="search" width="100%">
              <tr class="h23">
              
                <td align="left" valign="top">
                   <table border="0" cellpadding="0" cellspacing="0">
                      <tr class="h23">
                         <td>YRMON&nbsp;&nbsp;&nbsp;&nbsp;</td>
  						 <td><input name="yrmon" type="text" dataformat="ym" maxlength="6" required caption="YRMON" class="input1" style="width:55px;" tabindex="3">&nbsp;</td>
                         <td>&nbsp;&nbsp;</td>
                      </tr>
                   </table>
                </td>
              </tr>
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>


      <table class="height_8"><tr><td></td></tr></table>


      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_2 (S) -->
            <!-- Grid (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
              </tr>
            </table>
            
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <!-- Grid_button (S) -->
                  <table  border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn_add">Row Add</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                  <!-- Grid_button (E) -->
                </td>
              </tr>
            </table>

          </td>
        </tr>
      </table>
      <!-- biz page (E) -->


    </td>
  </tr>
</table>


</form>
</body>
</html>