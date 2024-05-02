<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0163.jsp
*@FileTitle : US Inbound Cost Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.09.30 장영석
* 1.0 Creation
=========================================================
* History
* 2010.06.14 윤진영 CHM-200901719 UI표준처리 오픈시 마우스 포커싱
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.11.01 최성민 [CHM-201114173-01] CNTR BIZ PFMC Analysis report 화면 수정
*=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.MultiDimensionRPT.LogisticsRPT");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		  log.error("Exception : " + e.toString());
	}
%>
<html>
<head>
<title>US Inbound Cost Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		document.form.f_from.focus();
	}
</script>
</head>

<body  onLoad="setupPage();">

<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


                        <!-- TABLE '#D' : ( Search Options ) (S) -->
                        <table class="search">
                            <tr>
                                <td class="bg">

                                	<!-- : ( By Office ) (S) -->
                                	<table class="search_in" border="0">
                                    	<tr class="h23">
                                    		<td width="50">In/Out</td>
                                    		<td width="140">
                                    		    <SELECT style='width:110' name="f_inout" class="input1">
                                        			<OPTION value="I">Inbound</OPTION>
                                        			<OPTION value="O">Outbound</OPTION>
                                    			</SELECT>
                                			</td>
                                    		<td width="70">BKG Term</td>
                                    		<td width="190">
                                    		    <SELECT style='width:110' name="f_group" class="input1">
                                        			<OPTION value="Door">Door</OPTION>
                                        			<OPTION value="CY">CY</OPTION>
                                    			</SELECT>
                                			</td>
                                    		<td width="40">From</td>
                                    		<td width="130">
                                    			<input type="text" class="input1" style="width:58;ime-mode:disabled;" name="f_from" value="" maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
                                          <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_ficonsearch3" onClick="openLocationCode('getF_from');">
                                    		</td>
                                    		<td width="25">To</td>
                                    		<td><input type="text" class="input1" style="width:58;ime-mode:disabled;" name="f_to" value="" maxlength="5" onKeyUp="" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
                                    			<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="f_icon_search4" onClick="openLocationCode('getF_to');">
                                    		</td>
                                		</tr>
                                	</table>
                                	<!-- : ( By Office ) (E) -->
                                </td>
                            </tr>
                        </table>
                        <!-- TABLE '#D' : ( Search Options ) (E) -->

                        <table class="height_10"><tr><td></td></tr></table>

                        <!-- TABLE '#D' : ( Search Options ) (S) -->
                        <table class="search">
                            <tr>
                                <td class="bg">


                                    <!-- : ( RHQ ) (S) -->
                                    <table width="100%" id="mainTable">
                                        <!-- tr>
                                            <td align="right" valign="bottom">
                                                <div id="div_zoom_in1" style="display:inline">
                                                    <img class="cursor" src="/hanjin/img/bu_prev01.gif" height="11" border="0" name="btns_buzoomin1" alt="Zoom in(+)">
                                                </div>
                                                <div id="div_zoom_out1" style="display:none">
                                                    <img class="cursor" src="/hanjin/img/bu_next01.gif" height="11" border="0" name="btns_buzoomout1" alt="Zoom out(-)">
                                                </div>
                                            </td>
                                        </tr -->
                                        <tr>
                                            <td>
                                                <script language="javascript">ComSheetObject('sheet1');</script>
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- : ( RHQ ) (E) -->


									<table class="search" border="0">
									<tr><td height="18"><img src="/hanjin/img/ico_star.gif" border="0" hspace="3" align="absmiddle"><strong>Remark</strong></td></tr>
									<tr><td style="padding-left:11;" class="sm">
										<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
										This screen is only showing the average cost of location level,<br>
										&nbsp;&nbsp;&nbsp;&nbsp;please check "Pre CM/OP simulation" screen for precise cost elements.<br>
										<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
										TTL Cost = Railage + Truckage + MT Trans Cost<br>
										<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
										Railage : Port ~ Rail Hub<br>
										&nbsp;&nbsp;&nbsp;&nbsp;Truckage : Inland Point ~ Rail Hub<br>
										&nbsp;&nbsp;&nbsp;&nbsp;MT Trans Cost  : Port ~ Rail Hub (for MT)<br></td></tr>
										</table>


                                </td>
                            </tr>
                        </table>
                        <!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>

</body>
</html>

<!-- 개발자 작업  끝 -->
