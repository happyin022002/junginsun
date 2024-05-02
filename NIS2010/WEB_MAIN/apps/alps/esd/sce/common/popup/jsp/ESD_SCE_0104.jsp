<%--
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_SCE_0104.jsp
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2008-04-21
*@LastModifier : YuJin
*@LastVersion : 1.0
* 1.0
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CommonPopUpManageEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.common.popup");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (CommonPopUpManageEvent)request.getAttribute("Event");
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
<title>Welcome to NMS!</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="modeVal" value="">
<input type="hidden" name="mode_only" value="">
<input type="hidden" name="cnt_cd" value="">
<input type="hidden" name="loc_cd" value="">
<input type="hidden" name="lcc_cd" value="">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">


    		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Location / Node Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

				<table class="search" border="0" style="width:717;">
				<tr class="h23"><td>
				<input type="radio" name ="selection" value ="location" class="trans" checked>&nbsp;Location
				<input type="radio" name ="selection" value ="node" class="trans">&nbsp;Node</td></tr>
				</table>

        <div id="location">
          <table class="search">
            <tr>
              <td class="bg">
                <table class="search" border="0" width="726">
                  <tr class="h23">
                    <td width="12%">Conti</td>
                    <td width="14%">
                      <input name="conti_cd" type="text" style="width:75" onKeyUp="javascript:upper(this);">
                    </td>
                    <td width="10%"><img class="nostar">Sub Conti</td>
                    <td width="14%">
                      <input name="sconti_cd" type="text" style="width:75" onKeyUp="javascript:upper(this);">
                    </td>
                    <td width="10%">Country</td>
                    <td width="13%">
                      <input name="cnt_cd_1" type="text" style="width:75" onKeyUp="javascript:upper(this);">
                    </td>
                    <td width="5%">State</td>
                    <td width="8%">
                      <input name="loc_state" type="text" style="width:61" onKeyUp="javascript:upper(this);">
                    </td>
                    <td width="">&nbsp;</td>
                  </tr>
                  <tr class="h23">
                    <td width="">Control Office</td>
                    <td width="">
                      <input name="loc_eq_ofc" type="text" style="width:75" onKeyUp="javascript:upper(this);">
                    </td>
                    <td width=""><img class="nostar">LOC Code</td>
                    <td width="">
                      <input name="loc_cd_1" type="text" style="width:75" onKeyUp="javascript:upper(this);">
                    </td>
                    <td width="10%">LOC Name</td>
                    <td colspan="3">
                      <input name="loc_nm" type="text" style="width:202">
                    </td>
                    <td>
                      <input name="chk_port_ind" type="checkbox" value="Y" class="trans">
                      Port Only</td>
                  </tr>
                </table>

                <table class="line_bluedot"><tr><td colspan="2"></td></tr></table>


                <!-- : ( Speed ) (S) -->
                <table border="0" style="width:100%; background-color:white;" class="grid2"  id="mainTable">
                 <tr>
                    <td>
                      <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                  </tr>
                </table>
                <!-- : ( Speed ) (E) -->

              </td>
            </tr>
          </table>
          <!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
        </div>
        <div id="node" style="display:none">
          <!-- : ( Title ) (S) -->
          <!-- : ( Title ) (E) -->
          <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
          <table class="search">
            <tr>
              <td class="bg">
                <table class="search" border="0" style="width:726;">
                  <tr class="h23">
                    <td width="8%">Country</td>
                    <td width="16%">
                      <input type="text" name="cnt_cd_2" style="width:75" onKeyUp="javascript:upper(this);">
                    </td>
                    <td width="11%">Location</td>
                    <td width="19%">
                      <input type="text" name="loc_cd_2" style="width:75" onKeyUp="javascript:upper(this);">
                    </td>
                    <td width="13%">Control Office</td>
                    <td width="13%">
                      <input type="text" name="ofc_cd" style="width:75" onKeyUp="javascript:upper(this);">
                    </td>
                  </tr>
                  <tr class="h23">
                    <td width="">Node</td>
                    <td width="">
                      <input type="text" name="node_cd" style="width:75" onKeyUp="javascript:upper(this);">
                    </td>
                    <td width="">Node Name</td>
                    <td colspan="3">
                      <input type="text" name="node_nm" style="width:307">
                    </td>
                    <td width="">
                      <table border="0"  class="search">
                        <tr class="h23">
                          <td width="">
                            <input type="radio" name="mode" value="yard" class="trans" onClick="javascript:modeVal.value=this.value;initSheet(sheetObjects[1],2);" checked>
                            &nbsp;Yard&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name="mode" value="zone" class="trans" onClick="javascript:modeVal.value=this.value;initSheet(sheetObjects[1],2);">
                            &nbsp;Zone</td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                </table>

                <table class="line_bluedot"><tr><td colspan="2"></td></tr></table>

                <!-- : ( Speed ) (S) -->
                <table border="0" style="width:100%; background-color:white;" class="grid2"  id="mainTable">
                  <tr>
                    <td>
                      <script language="javascript">ComSheetObject('sheet2');</script>
                    </td>
                  </tr>
                </table>
                <!-- : ( Speed ) (E) -->
              </td>
            </tr>
          </table>
          <!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
        </div>
      </td>
    </tr>
  </table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>
<%@include file="../../../common/commonpopup/include/common.jsp"%>