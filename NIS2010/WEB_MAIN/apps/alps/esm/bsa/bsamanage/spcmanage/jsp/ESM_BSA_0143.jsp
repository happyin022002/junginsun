<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0143.jsp
* @FileTitle : HSlot-info by VVD(VESSELS)
* Open Issues :
* Change history :
* @LastModifyDate : 2007-07-02
* @LastModifier : Ari
* @LastVersion : 1.0
*  2007-07-02 Ari
*  1.0 최초 생성
*=========================================================
* History :
* 2008.02.27 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
*    변경사항 : Year, Month, Week관련 화면변경
* 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2009.10.09 남궁진호 ALPS 전환 1.0 Creation
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event.EsmBsa0143Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0143Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	//부모창 폼값
    String chkPrd  = "";
    String txtYear  = "";
	String txtFmMonth = "";
	String txtToMonth = "";
	String txtFmWeek = "";
	String txtToWeek = "";

	String selTrade = "";
	String selRlane = "";
	String selDir = "";
	String selIOC = "";

	String txtVsl_cd 	= "";
	String txtSkd_voy_no 	= "";
	String txtDir_cd = "";

	String isExcludZero = "";

	//선택된 로우 값
	String s_cost_yrmon = "";
	String s_trd_cd = "";
	String s_rlane_cd = "";
	String s_ioc_cd = "";
	String s_vsl_cd = "";
	String s_skd_voy_no = "";
	String s_skd_dir_cd = "";
	String xml = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.BSAManage.SPCManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0143Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		if(event != null) {
			chkPrd = JSPUtil.getNull(request.getParameter("chkPrd"));
			txtYear = JSPUtil.getNull(request.getParameter("txtYear"));
			txtFmMonth = JSPUtil.getNull(request.getParameter("txtFmMonth"));
			txtToMonth = JSPUtil.getNull(request.getParameter("txtToMonth"));
			txtFmWeek = JSPUtil.getNull(request.getParameter("txtFmWeek"));
			txtToWeek = JSPUtil.getNull(request.getParameter("txtToWeek"));

			selTrade = JSPUtil.getNull(request.getParameter("cobTrade"));
			selRlane = JSPUtil.getNull(request.getParameter("cobLane"));
			selDir = JSPUtil.getNull(request.getParameter("cobDir"));
			selIOC = JSPUtil.getNull(request.getParameter("cobIOC"));

			txtVsl_cd = JSPUtil.getNull(request.getParameter("txtVsl_cd"));
			txtSkd_voy_no = JSPUtil.getNull(request.getParameter("txtSkd_voy_no"));
			txtDir_cd = JSPUtil.getNull(request.getParameter("txtDir_cd"));

			isExcludZero = JSPUtil.getNull(request.getParameter("isExcludZero"));

			
			s_trd_cd = JSPUtil.getNull(request.getParameter("s_trd_cd"));
			s_rlane_cd = JSPUtil.getNull(request.getParameter("s_rlane_cd"));
			s_ioc_cd = JSPUtil.getNull(request.getParameter("s_ioc_cd"));
			s_vsl_cd = JSPUtil.getNull(request.getParameter("s_vsl_cd"));
			s_skd_voy_no = JSPUtil.getNull(request.getParameter("s_skd_voy_no"));
			s_skd_dir_cd = JSPUtil.getNull(request.getParameter("s_skd_dir_cd"));
		}

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Solt Information By VVD For Vessels</title>
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

<iframe height="0" width="0" name="frmHidden"></iframe>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="iPage"> <!-- 부모창의 폼값 --> <!-- 부모창 sheet 선택 값 -->
	<input type="hidden" name="param1"> <!-- Gubun   |   Methode Name   | codeItem     -->
	<input type="hidden" name="param2"> <!-- Year    |   vsl_cd         | All          -->
	<input type="hidden" name="param3"> <!--         |   skd_voy_no     | Methode Name -->
	<input type="hidden" name="param4"> <!--         |   dir_cd         | trd_cd       -->
	<input type="hidden" name="param5"> <!-- fmMonth |                  |              -->
	<input type="hidden" name="param6"> <!-- toMonth |                  |              -->
	<input type="hidden" name="param7"> <!-- fmWeek  |                  |              -->
	<input type="hidden" name="param8"> <!-- toWeek  |                  |              -->
	<input type="hidden" name="sXml" value="<%= xml %>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Slot Information By VVD For Vessels</td></tr>
			</table>
			<!-- : ( Title ) (E) -->

		<!-- : ( Title ) (S) -->

				<!-- TABLE '#D' : ( Button : Main ) (S) -->
				<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
							<td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

							</tr>
						</table>
					</td></tr>
				</table>
				<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- : ( Title ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->

		<table class="search">
			<tr>
				<td class="bg"><!-- : ( Year ) (S) -->
				<table class="search" border="0" style="width:737;">
					<tr class="h23">
						<td colspan="8"><script language="javascript">initPeriod2();</script></td>
						<td colspan="2">Carriers with BSA only&nbsp;<input type="checkbox" name="isExcludZero" value="1" class="trans"
						onKeyUp="moveTab(this, selTrade)" checked></td>
					</tr>
					<tr><td class="line_bluedot" colspan="10"></td></tr>
					<tr class="h23">
						<td width="5%" style="text-indent:7;">Trade</td>
						<td width="10%"><script language="javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
						<td width="5%" style="text-indent:7;">Lane</td>
						<td width="14%"><div id="div_rLane"><script language="javascript">ComComboObject('cobLane', 1, 80 , 0 )</script></div></td>
						<td width="5%">Dir.</td>
						<td width="13%"><script language="javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
						<td width="5%">IOC</td>
						<td width="18%"><script language="javascript">ComComboObject('cobIOC', 1, 70 , 0 )</script></td>
						<td width="5%">VVD</td>
						<td >
						<input type="text" size="4" name="txtVsl_cd"     value="<%=s_vsl_cd%>" maxlength="4" onKeyPress="onlyEng();" onKeyUp="moveTab(this, txtSkd_voy_no);" style="ime-mode:disabled">
						<input type="text" size="4" name="txtSkd_voy_no" value="<%=s_skd_voy_no%>" maxlength="4" onKeyDown="onlyNumber(window);" onKeyUp="moveTab(this, txtDir_cd);" style="ime-mode:disabled">
						<input type="text" size="1" name="txtDir_cd"     value="<%=s_skd_dir_cd%>" maxlength="1" onKeyPress="onlyEng();" style="ime-mode:disabled">
						</td>
					</tr>
			</table>
			<!-- : ( Year ) (E) -->
			</td>
		</tr>
		</table>

		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>
            <!-- : ( Search Options ) (S) -->
            <table class="search">
               <tr>
                    <td class="bg">
                        <!-- : ( Grid ) (S) -->
                        <table width="100%" id="mainTable">
		            		<tr>
						    <td align="right" valign="bottom">
								<div id="div_zoom_in" style="display:inline">
								<img class="cursor" src="/hanjin/img/bu_prev01.gif" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
								</div>
								<div id="div_zoom_out" style="display:none">
								<img class="cursor" src="/hanjin/img/bu_next01.gif" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
								</div>
							</td>
							</tr>
                            <tr>
                                <td>
                                <script language="javascript">ComSheetObject('sheet');</script>
                                </td>
                            </tr>
                        </table>
                        <!-- : ( Grid ) (E) -->
                    </td>
                </tr>
            </table>
            <!-- : ( Search Options ) (E) -->
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
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->
				</tr>
				</table>
				</td></tr>
			</table>
			</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
    /**
     * ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다.
     */
	with(document.form){
		<% if(event != null) {
			   int tmp = 0;
		       if(chkPrd.equals("M")) {
		    	   tmp = 1;
		       }
		%>
	    chkPrd["<%=tmp%>"].checked  =true;
	    txtYear.value       = "<%= txtYear %>";
	    txtFmMonth.value     = "<%= txtFmMonth %>";
	    txtToMonth.value     = "<%= txtToMonth %>";
	    txtFmWeek.value     = "<%= txtFmWeek %>";
	    txtToWeek.value     = "<%= txtToWeek %>";
	    <%}%>
	}
-->
</SCRIPT>