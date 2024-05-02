<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0120.jsp
* @FileTitle : Carrier's Register
* Open Issues :
* Change history :
* @LastModifyDate : 2006-12-18
* @LastModifier : Kim Jong Beom
* @LastVersion : 1.0
*  2006-12-18 Kim Jong Beom
*  1.0 최초 생성
=========================================================
' History :
' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2009.09.29 남궁진호 ALPS 전환작업2 1.0 Creation
* 2009.11.18 남궁진호 CHM-200901152
*                  : Carrier Code의 MDM 통합관리에 따른 추가기능 제거 
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0120Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0120Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String bsa_op_cd ="";
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BSAManage.BSAManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0120Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		bsa_op_cd = JSPUtil.getNull(request.getParameter("bsa_op_cd"));

		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Carrier's Infomation</title>
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

<body onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bsa_op_cd" value="<%=bsa_op_cd%>">
<input type="hidden" name="param1"> <!-- Gubun   |  Method Name -->
<input type="hidden" name="param2"> <!-- Carrier |  crr_cd      -->

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Carrier's Register</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
		<table class="search">
		<tr>
			<td class="bg">
				<!-- : ( Speed ) (S) -->
				<table width="100%" id="mainTable">
				<tr>
					<td><script language="javascript">ComSheetObject('sheet1');</script></td>
				</tr>
				</table>
				<!-- : ( Speed ) (E) -->
			</td>
		</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

	</td>
</tr>
</table>

<!-- OUTER - POPUP (E)nd -->

<!-- : ( Button : Sub ) (S) -->
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_ok" id="btn_ok">OK</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close" id="btn_close">Close</td>
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
    </td>
  </tr>
</table>
<!-- : ( Button : Sub ) (E) -->
<!-- : ( Button : Sub ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<SCRIPT LANGUAGE="javascript">
<!--
      /* 
        ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다. 
      */
     with(document.form)
      {
       }
-->
</SCRIPT>
<%@ include file="/bizcommon/include/common_alps.jsp" %>