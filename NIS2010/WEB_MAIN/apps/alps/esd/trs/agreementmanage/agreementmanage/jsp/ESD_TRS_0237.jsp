<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0237.jsp
*@FileTitle : Agreement Confirm Authority
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.21
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 1.0 최초 생성
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0237Event"%>
<%
	SignOnUserAccount account = null; //Session 정보
	EsdTrs0237Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	String userId = "";
	String ofcCd = "";
	String userNm = "";
	String today = DateTime.getFormatString("yyyyMMdd");

	try {
		account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		ofcCd = account.getOfc_cd();
		userNm = account.getUsr_nm();

		event = (EsdTrs0237Event) request.getAttribute("Event");
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Agreement Correction</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  function setupPage(){
    loadPage();
  }
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" >
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="fm_account_usr_nm"	  value="<%=userNm%>">
<input type="hidden" name="fm_today"	  value="<%=today%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
      
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
        </table>
      </td></tr>
      </table>
      <!--Button (E) -->
  
      <!--biz page (S)-->
      <div id="MiniLayer" style="display:inline">
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                <td width="100">Confirm User Id.</td>
                <td width="120">
                  <input name=fm_cfm_usr_id type="text" style="width:72;"  value="" onBlur="setgetUpper(this);">
                </td>
                <td width="707"></td>
              </tr>
            </table>
            <!--  biz_1   (E) -->
          </td>
        </tr>
      </table>
      </div>
    
      <table class="height_8"><tr><td></td></tr></table>  
    </td>
  </tr>
</table>
    
<table class="height_8"><tr><td></td></tr></table>  

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;"> 
  <tr>
    <td>
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            
            <!-- TABLE '#D' : ( Grid ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Grid ) (E) -->
            
            <!-- : ( Button_ Sub ) (S) -->
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <!-- Repeat Pattern -->
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_rowadd" name="btng_rowadd">Add Row</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_delete" name="btng_delete">Delete Row</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_save" name="btng_save">Save</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <!-- Repeat Pattern -->
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <!-- : ( Button_ Sub ) (E) -->            
            
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<table class="height_10"><tr><td colspan="8"></td></tr></table>
</form>
</body>
</html>
