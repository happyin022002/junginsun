<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0030.jsp
*@FileTitle : Target VVD 
*Open Issues :
*Change history :
	' 2008.02.15 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
	'    변경사항 : Year, Month, Week관련 화면변경
	' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
	' 2009.03.16 김종열 N200903100130 VVD Code에 영문 외 숫자도 입력가능하게 수정
	' 2009.05.18 배진환 N200905130071 - MAS_조회 조건 입력 관련 수정
	' 2009.09.04박수훈 New FrameWork 적용
*@LastModifyDate : 2009.08.31
*@LastModifier : 박수훈
*@LastVersion : 1.0
=========================================================
* History
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.02.10 최성민 Ticket ID:CHM-201108533-01 Search Validation 수정 및 소스정리
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String xml = "";
	Logger log = Logger.getLogger("com.hanjin.apps.WeeklyPFMC.WeeklyCM");
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
	} catch(Exception e) {
		log.error("Exception : " + e.toString());
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Target VVD </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var formObj = document.form;
		
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<iframe height="0" width="0" name="frmHidden2"></iframe>
<form method="post" name="form"  onKeyUp="ComKeyEnter();" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="iPage">
<input type="hidden" name="f_flag">
<input type="hidden" name="f_sRow">
<input type="hidden" name="chkPrevCre" value="N">
<input type="hidden" name="sXml" value="<%=xml%>"> 

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- Button (S) -->
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
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
					<tr class="h23">
						<td colspan="8"><script language="javascript">masPeriod1();</script></td>
						<td>VVD</td>
						<td colspan="4">
							<input type="text" size="4" name="f_vsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:60;" >
							<input type="text" size="4" name="f_skd_voy_no" maxlength="4" onKeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:60;" >
							<input type="text" size="1" name="f_skd_dir_cd" maxlength="1" onKeyPress="ComKeyOnlyAlphabet('upper');" style="ime-mode:disabled; width:30;" ></td>
					</tr>
					<tr><td class="line_bluedot" colspan="12"></td></tr>
					<tr class="h23">
						<td width="50" style="text-indent:7;">Trade</td>
						<td width="130">&nbsp;<script language="javascript">ComComboObject('f_trd_cd',1, 70 , 0 )</script></td>
						<td width="50">R/Lane</td>
						<td width="130"><div id="div_rLane">&nbsp;<script language="javascript">ComComboObject('f_rlane_cd',1, 80 , 0 )</script></div></td>
						<td width="50">S/Lane</td>
						<td width="130"><div id="div_sLane">&nbsp;<script language="javascript">ComComboObject('f_slan_cd',1, 80 , 0 )</script></div></td>
						<td width="60">Direction</td>
						<td width="120">&nbsp;<script language="javascript">ComComboObject('f_dir_cd',1, 50 , 0 )</script></td>
						<td width="25">IOC</td>
						<td width="110">&nbsp;<script language="javascript">ComComboObject('f_ioc_cd',1, 50 , 0 )</script></td>
						<td><input type="checkbox" name="f_del" value="Y" class="trans" >&nbsp;Deleted Data</td>
					</tr>
				</table>
				<!-- : ( Year ) (E) -->

			</td>
		</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
				<tr><td align="right" valign="bottom">
				        <div id="div_zoom_in" style="display:inline"> <!-- absolute / relative -->
						<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
						</div>
						<div id="div_zoom_out" style="display:none">
						<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
						</div>
					</td>
				</tr>
                   <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
	            </table>
				<!-- : ( POR ) (E) -->

				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btn_SkdInquiry" name="btn_SkdInquiry">SKD Inquiry</td><td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->

			</td></tr>
		</table>
		<!-- Button (S) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
