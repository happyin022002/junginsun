<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0018.jsp
*@FileTitle : Set Credit Ratio
*Open Issues :
*Change history :CSR No. R200804296329 내부 경로 변경
*@LastModifyDate : 2006-11-23
*                : 2008-05-06
*@LastModifier : Chilseo_Park
*              : 전윤주
*@LastVersion : 1.0
* 2006-11-23 Chilseo_Park
* 2008-05-06 전윤주
* 1.0 최초 생성
===========================================================
* History
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.09.04 박수훈 New FrameWork 적용
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.event.EsmCoa0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmCoa0018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	//sheet1에서 사용하는 변수
	String f_cost_yrmon = JSPUtil.getNullNoTrim(request.getParameter("f_cost_yrmon"));
	String f_cntr_tpsz_cd = JSPUtil.getNullNoTrim(request.getParameter("f_cntr_tpsz_cd"));
	
	Logger log = Logger.getLogger("com.hanjin.apps.EQBalance.EQBalance");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0018Event)request.getAttribute("Event");
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
<title>Set Credit Ratio</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();	
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input name="f_cost_yrmon" type="hidden" value="<%=f_cost_yrmon%>">
<input name="f_cntr_tpsz_cd" type="hidden" value="<%=f_cntr_tpsz_cd%>">

<!-- OUTER - POPUP (S)tart -->
  <table width="300" class="popup" cellpadding="10" border="0">
    <tr><td class="top"></td></tr>
    <tr><td valign="top">

			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Set Credit Ratio</td></tr>
			</table>
			<!-- : ( Title ) (E) -->


        <!-- : ( Search Options ) (S) -->
        <table class="search">
          <tr>
            <td class="bg">
              <!-- : ( Level Group ) (E) -->
              <table width="100%" id="mainTable">
                <tr>
                  <td>
                    <script language="javascript">ComSheetObject('sheet1');</script>
                  </td>
                </tr>
              </table>
              <!-- : ( Level Group ) (E) -->
            </td>
          </tr>
        </table>
        <!-- : ( Search Options ) (E) -->

      </td>
    </tr>
  </table>
  <!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="300" class="sbutton">
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
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>