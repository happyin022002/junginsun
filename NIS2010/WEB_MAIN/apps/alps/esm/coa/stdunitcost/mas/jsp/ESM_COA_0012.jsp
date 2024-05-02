<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0012.jsp
*@FileTitle : ABC (PA) / STP Cost (RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.08.04 전윤주
* 1.0 Creation

* History
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.03.12 박상희 N200903040144 상단 new 버튼 이미지 교체 
* 2009.08.31 전윤주 New Framework 적용
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.05.13 김민아 [CHM-201110694-01] COA Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
2012.08.27 이석준[CHM-201219844-01]   ABC(PA)/STP Cost(RA)화면에 Month Copy 기능 추가 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.common.Utils"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
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
	String strOfc_cd		= "";
	String strTeam_cd		= "";
	
	GeneralEventResponse eventResponse =  null;
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.MAS");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			strTeam_cd = JSPUtil.getNull(eventResponse.getETCData("strTeam_cd"));
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ABC (PA) / STP Cost (RA) </title>
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
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="v_ofc_cd" value="<%=strOfc_cd %>">
<!-- 개발자 작업	-->
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
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td class="btn1_line"></td>
<!-- 
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btng_save" name="btn_Save">Save</td><td class="btn1_right"></td></tr></table></td>
		        <td> 
	                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                    <tr>
	                      <td class="btn1_left"></td>
	                      <td class="btn1" id="btn_Month_Copy" name="btn_Month_Copy">Month Copy</td>
	                      <td class="btn1_right"></td>
	                    </tr>
	                  </table>
	            </td>
	             -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
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
					<td width="62">YYYY-MM</td>
					<td width="130"><input type="text" name="f_cost_yrmon" style="width:70" class="input1" value="" maxlength="6" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(window);" onBlur="addDash(this , 4);" onFocus="this.value=ComReplaceStr(this.value, '-', '');" onKeyUp="ComKeyEnter('LengthNextFocus');"></td>
					<td width="56">Country</td>
					<td width="115"><input type="text" style="width:50;" name="f_svc_trns_prc_cnt_cd" maxlength="2" onKeyUp="ComKeyEnter('LengthNextFocus');"  value=""  style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper');"></td>
					<td width="40">Office</td>
					<td width="150"><input type="text" style="width:90;" name="f_ofc_cd" maxlength="6" onKeyUp="ComKeyEnter('LengthNextFocus');" value=""  style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper');"></td>
					<td width="53">Activity</td>
					<td>
						<script language="javascript">ComComboObject('f_ofc_act_cd',1, 350 , 1 )</script>
					</td>
                </tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s" style="padding-bottom:0;padding-top:0;">Branch Sales Cost Inquiry</td>
					<td class="gray" rowspan="2" style="vertical-align:top;">(USD)</td></tr>
				</table>
				<!-- : ( POR ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
				<!-- : ( POR ) (E) -->
		</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		

</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>