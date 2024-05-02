<%/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_COA_0121.jsp
*@FileTitle : Bound Switch
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.31
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 1.0 Creation
* =========================================================
* History
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0121Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0121Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.WeeklyPFMC.WeeklyCM");
	String v_trd_cd = null;
	String selRlane = null;
	String costUseTpCd = null;
	String costUseTpCdC = "C";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		costUseTpCd = request.getParameter("cost_use_tp_cd");
		event = (EsmCoa0121Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}		

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Bound Switch</title>
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
<!-- 개발자 작업	-->
<input type='hidden' name='cost_use_tp_cd' value="<%=costUseTpCd %>">
<table>
<tr><td>
<table width="<%=costUseTpCdC.equals(costUseTpCd)?600:530%>" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr>
    <td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="/hanjin/img/alps/ico_t1.gif" width="20" height="12">Lane Bound Switch</td></tr>
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
</td></tr>
<tr><td>
<!-- OUTER - POPUP (E)nd -->
<tr><td>
<table class="height_10"><tr><td></td></tr></table> </td></tr>
<!-- : ( Button : Sub ) (S) -->
<tr><td>
		<table width="100%" class="sbutton" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="popup">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Rowadd" name="btn_Rowadd">Row Add</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Save" name="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>

                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Close" name="btn_Close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <!-- Repeat Pattern -->
              </tr>
            </table>

          </td>
        </tr>
		</table>
<!-- : ( Button : Sub ) (E) -->
</td></tr></table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>