<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_1113.jsp
 *@FileTitle : Historical Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.08.03
 *@LastModifier : 김상수
 *@LastVersion : 1.22
 *
 * 2009.08.24 조재성
 *     1.0 Creation
 *
 * 2010.08.03 김상수
 *     [CHM-201004960-01] Genset Ineventory Logic error 수정건
 *         : [EES_CGM_1113] UI에 RCC멀티콤보 기능 및 조회조건 추가 by 김상수
 *
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1113Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1113Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetInventory");

	String xml = HttpUtil.makeXML(request,response);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1113Event)request.getAttribute("Event");
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
<title>Historical Report</title>
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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="loc_cd">
<input type="hidden" name="yd_cd">
<input type="hidden" name="inq_fm_dys">
<input type="hidden" name="inq_to_dys">
<input type="hidden" name="eq_spec_no">
<input type="hidden" name="plnyr">
<input type="hidden" name="plnwk">
<input type="hidden" name="plnmon">
<input type="hidden" name="wkstdt">
<input type="hidden" name="wkenddt">
<input type="hidden" name="cntr_psn_sts_cd">
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_rcc_cd">
<input type="hidden" name="eq_orz_cht_lcc_cd">
<input type="hidden" name="eq_orz_cht_scc_cd">
<input type="hidden" name="eq_orz_cht_us_flag">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">



		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:2;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

        <!--  biz_1  (S) -->
        <table class="search" border="0" style="width:979;">
          <tr class="h23">
            <td align="right">Report&nbsp;</td>
            <td style="padding-left:2;"><script language="javascript">ComComboObject("report_type", 1, 150, 1, 1, 1, true, 1);</script></td>
            <td align="right">Container Status&nbsp;</td>
            <td style="padding-left:2;"><script language="javascript">ComComboObject("cnmv_sts_cd", 1, 150, 0, 0, 1, true);</script></td>
            <td colspan="4">&nbsp;</td>
          </tr>
          <tr class="h23">
            <td align="right">RCC&nbsp;</td>
            <td style="padding-left:2;"><script language="javascript">ComComboObject("crnt_rcc_cd", 1, 150, 0, 1, 1, true, 3);</script></td>
            <td align="right">LCC&nbsp;</td>
            <td style="padding-left:2;"><script language="javascript">ComComboObject("crnt_lcc_cd", 1, 150, 0, 1, 1, true, 4);</script>
              <!-- IBMultiCombo의 탭 이동 버그로 인하여 0px Input을 추가 -->
              <input name="temp" id="temp" type="text" style="width:0px;" class="input" tabindex="5"></td>
            <td align="right">SCC&nbsp;</td>
            <td style="padding-left:2;"><script language="javascript">ComComboObject("crnt_scc_cd", 1, 150, 0, 1, 1, true, 6);</script></td>
            <td align="right">Yard&nbsp;</td>
            <td><input type="text" name="crnt_yd_cd" dataformat="engup" style="width:130;ime-mode:disabled" class="input" tabindex="7">&nbsp;<img name="btns_crnt_yd_cd" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
          </tr>
          <tr class="h23">
            <td align="right">Period&nbsp;</td>
            <td colspan="7" style="padding-left:2;"><script language="javascript">ComComboObject("period_type", 1, 80, 1, 1, 1, true, 8);</script>&nbsp;&nbsp;&nbsp;
            <input name="disp_fm_dys" id="disp_fm_dys" dataformat="ymd" maxlength='8' type="text" style="width:75;text-align:center;" class="input1" tabindex="9">&nbsp;<img name="btns_Calendar1" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~
            <input name="disp_to_dys" id="disp_to_dys" dataformat="ymd" maxlength='8' type="text" style="width:75;text-align:center;" class="input1" tabindex="10">&nbsp;<img name="btns_Calendar2" id="btns_Calendar2" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
          </tr>
        </table>
        <!--  biz_1   (E) -->

		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg">


			<!-- Grid  (S) -->
			<table width="504"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->

			</td></tr>
		</table>
		<!--biz page (E)-->


	</td></tr>
		</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>