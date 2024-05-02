<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0091.jsp
*@FileTitle : Agreement No. Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0091Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0091Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerLeaseAgreementRegistration.AgreementRegistration");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesLse0091Event)request.getAttribute("Event");
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
<title>Agreement No. Selection</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="lstm_cd">
<input type="hidden" name="h_agmt_act_flg" value="<%= JSPUtil.getParameter(request, "h_agmt_act_flg") %>">
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Lease Agreement No. Selection</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

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
                      <td class="btn1" name="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_New">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button (E) -->

      <!--biz page (S)-->
      <table class="search" id="mainTable">
        <tr>
          <td class="bg">
            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:100%;">
              <tr class="h23">
                <td width="100">Agreement No.</td>
                <td width="150"><input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:35;text-align:center;" class="input2" value="HHO" readonly>&nbsp;<input type="text" name="agmt_seq" caption="AGMT No." style="width:50;text-align:center;" class="input" maxlength="6" dataformat="int"></td>
                <td width="100">Active Flag</td>
                <td width="90">
                	<select name="agmt_act_flg" caption="Active Flag" style="width:75;">
						<option value="" selected>ALL</option>
						<option value="A">Active</option>
						<option value="I">Inactive</option>
					</select>
				</td>
                <td width="45">Office</td>
                <td width="115"><input type="text" name="ofc_cd" caption="Office" style="width:55;ime-mode:disabled;" class="input" maxlength="6" dataformat="engup">&nbsp;<img src="img/btns_search.gif" name="btn_Office" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                <td width="90">Lease Term</td>
                <td width=""><script language="javascript">ComComboObject('combo1', 1, 50, 0);</script></td>
              </tr>
              <tr class="h23">
                <td>Contract No.</td>
                <td><input type="text" name="ref_no" caption="Contract No." style="width:124;ime-mode:disabled;" class="input" dataformat="eng"></td>
                <td>Lessor Name</td>
                <td colspan="3"><input type="text" name="vndr_lgl_eng_nm" caption="Lessor Name" style="width:210;ime-mode:disabled;" class="input" !dataformat="eng"></td>
                <td>Lessor ABBR</td>
                <td><input type="text" name="vndr_abbr_nm" caption="Lessor ABBR" style="width:120;ime-mode:disabled;" class="input" !dataformat="eng"></td>
              </tr>
            </table>
            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
            <!--  biz_1   (E) -->

            <!-- Grid  (S) -->
            <table width="100%"  id="sheetTable">
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- Grid (E) -->
          </td>
        </tr>
      </table>
      <!--biz page (E)-->
      <table class="height_5"><tr><td></td></tr></table>
    </td>
  </tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_OK">OK</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button (E) -->
    </td>
  </tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>