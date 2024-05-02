<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0104.jsp
* @FileTitle : Inquire/Edit Daily-consumption & FO/DO By Lane
* Open Issues :
* Change history :
* @LastModifyDate : 2007-01-02
* @LastModifier : Park Eun Ju
* @LastVersion : 1.0
*  2007-01-02 Park Eun Ju
*  1.0 최초 생성
*=========================================================
* History :
* 2008.01.30 박은주 N200801230002 e-NIS/BSA 시스템 변경 요청
*                  Type Size(Sub-allocation)별로 판매/구매 및 Free allocation 기능 추가[104]
* 2008.02.27 박은주 N200801154874 주간 대상항차 기준 변경 관련 요청
*                  Year, Month, Week관련 화면변경
* 2009.03.16 김종열 N200903100130 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2008.05.07 박은주 R200804296325 css 파일 참조 확인 및 수정 요청	
* 2009.10.06 남궁진호 ALPS 전환작업  1.0 Creation
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
* 2011.04.04 이관샨 [CHM-201109933-01] 화면상 불필요한 선 정리 
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
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event.EsmBsa0104Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String header   = "";
	String prevWeek = "";
	String year     = "";
	String hSearchYN = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BSAManage.SPCManage");
	String xml = "";
    String opJob		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		CommonBsaRsVO retVo = (CommonBsaRsVO)eventResponse.getCustomData("retVo");
    	prevWeek =eventResponse.getETCData("prevWk");
        opJob = retVo.getStrTemp3();
		
		header = retVo.getStrTemp();
		year = JSPUtil.getNull(request.getParameter("txtYear"))==""?"0":JSPUtil.getNull(request.getParameter("txtYear"));
		
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Slot-info by VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var formObj = document.form;
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=header%>");
		
		if (ComParseInt("<%=year%>") <= 0){
	       	formObj.txtYear.value = ComGetNowInfo("yy");  
	        formObj.txtFmMonth.value = ComGetNowInfo("mm"); 
	        formObj.txtToMonth.value = ComGetNowInfo("mm"); 
	        formObj.txtFmMonth.value = ComLpad(formObj.txtFmMonth, 2, '0');
	        formObj.txtToMonth.value = ComLpad(formObj.txtToMonth, 2, '0');
	        
	        formObj.txtFmWeek.value = "<%=prevWeek%>";
	        formObj.txtToWeek.value = "<%=prevWeek%>";

	        setPeriod(formObj.txtToWeek);
       }
	}
</script>
</head>
<!-- 개발자 작업	-->
<iframe height="0" width="0" name="frmHidden"></iframe>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();document.form.txtYear.focus();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="flag">
<input type="hidden" name="header" value="<%= header %>">
<input type="hidden" name="param1"> <!-- Gubun   |   Methode Name   | codeItem     -->
<input type="hidden" name="param2"> <!-- Year    |   vsl_cd         | All          -->
<input type="hidden" name="param3"> <!--         |   skd_voy_no     | Methode Name -->
<input type="hidden" name="param4"> <!--         |   dir_cd         | trd_cd       -->
<input type="hidden" name="param5"> <!-- fmMonth |                  |              -->
<input type="hidden" name="param6"> <!-- toMonth |                  |              -->
<input type="hidden" name="param7"> <!-- fmWeek  |                  |              -->
<input type="hidden" name="param8"> <!-- toWeek  |                  |              -->
<input type="hidden" name="hSearchYN">
<input type="hidden" name="sXml" value="<%= xml %>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>			
					<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
					<% if("Y".equals(JSPUtil.getNull(request.getParameter("hSearchYN")))){ %>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
						<tr><td class="history"><img src="img/icon_history_dot.gif"  align="absmiddle">&nbsp;BSA > BSA Table > Manage BSA-VVD</td></tr>
						<tr><td class="title"><img src="img/icon_title_dot.gif" >&nbsp;&nbsp; Slot-info by VVD </td></tr>
						</table>
					<% } else { %>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
						<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
						<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
						</table>
					<% } %>
					<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

					<!-- TABLE '#D' : ( Button : Main ) (S) -->
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
							<tr><td class="btn1_bg">

									<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>


										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
										<!-- Repeat Pattern -->

									</tr></table>

							</td></tr>
					</table>
					<!-- TABLE '#D' : ( Button : Main ) (E) -->
					<!-- TABLE '#D' : ( Search Options ) (S) -->
					<table class="search">
						<tr>
							<td class="bg">
								<!-- : ( Year ) (S) -->
								<table class="search_in" border="0">
									<tr class="h23">
										<td width="655"><script language="javascript">initPeriod();</script></td>
										<td>Carriers with BSA only<input type="checkbox" name="isExcludZero" value="1" class="trans"></td>
									</tr>
								</table>
								<table class="search_in" border="0">
									<tr><td class="line_bluedot"></td></tr>
								</table>
								<table class="search_in" border="0">
									<tr class="h23">
										<td width="55" style="text-indent:7;">Trade</td>
										<td width="130"><script language="javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
										<td width="35">Lane</td>
										<td width="130"><div id="div_rLane"><script language="javascript">ComComboObject('cobLane', 1, 80 , 0 )</script></div></td>
										<td width="30">Dir.</td>
										<td width="130"><script language="javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
										<td width="30">IOC</td>
										<td width="130"><script language="javascript">ComComboObject('cobIOC', 1, 80 , 0 )</script></td>
										<td width="30">VVD</td>
										<td >
										<input type="text" size="4" name="txtVsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="moveTab(this, txtSkd_voy_no);" style="ime-mode:disabled">
										<input type="text" size="4" name="txtSkd_voy_no" maxlength="4" onKeyPress="ComKeyOnlyNumber(window);" onKeyUp="moveTab(this, txtDir_cd);" style="ime-mode:disabled">
										<input type="text" size="1" name="txtDir_cd"     maxlength="1" onKeyPress="ComKeyOnlyAlphabet('upper');"style="ime-mode:disabled">
										</td>
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
						<tr>
							<td class="bg">
							<table class="height_10"><tr><td></td></tr></table>
								<!-- : ( Option ) (S) -->
								<table class="search" border="0" style="width:100%;">
									<tr class="h23">
										<td width="80%" ><div id="div_opjob"></div></td>
										<td width="20%" align="right" valign="bottom" style="padding-right:1;">
									        <div id="div_zoom_in" style="display:inline"> <!-- absolute / relative -->
											<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
											</div>
											<div id="div_zoom_out" style="display:none">
											<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
											</div>
										</td>
									</tr>
								</table>
								<!-- : ( Option ) (E) -->
								<!-- table width="100%" class="search">
									<tr><td class="gray">(M.Ton/Day, USD/M.T)</td></tr>
								</table -->
								<!-- : ( POR ) (S) -->
								<table width="100%" id="mainTable">
									<tr>
										<td>
										<script language="javascript">ComSheetObject('sheet1');</script>
										</td>
									</tr>
								</table>
								<!-- : ( POR ) (E) -->
								<!-- : ( Button : Grid ) (S) -->
								<table width="100%" class="sbutton">
									<tr>
										<td wdith="50%" class="gray_tit" align="left">
											Vessel/Voy./BD Double Click : All detailed info. by VVD
											<br>
											Swap Notice Double Click : Swap info. by VVD
										</td>
										<td class="align">
											<table width="100%" class="button">
												<tr><td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>

														<!-- Repeat Pattern -->
														<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr><td class="btn2_left"></td><td class="btn2" name="btn_skdinquiry" id="btn_skdinquiry">SKD Inquiry</td>
														<td class="btn2_right"></td></tr></table></td>
														<!-- Repeat Pattern -->

														</tr>
													</table>
												</td></tr>
											</table>
										</td>
									</tr>
								</table>
								<!-- : ( Button : Grid ) (E) -->
							</td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Search Options ) (E) -->
    </td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--

	/**
	 * ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다.
	 */
	with(document.form){		
		var opJob = "<%=opJob%>";
		var arrOpJob = opJob.split("|$$|");
		
		var rdoStr = "";
        var rdoCode = arrOpJob[0].split("|");
        var rdoName = arrOpJob[1].split("|");

		if(rdoName != ""){
			for(i=0; i<rdoName.length-1; i++){
				rdoStr += "<input type='radio' value='"+rdoCode[i]+"' class='trans' name='rdoOpJob' onClick=\"chgOptionJob('"+rdoName[i]+"');\">&nbsp;"+rdoName[i]+"&nbsp;&nbsp;&nbsp;&nbsp;";
			}
		}else{
			rdoStr += "<input type='radio' value='007' class='trans' name='rdoOpJob' onClick=\"chgOptionJob('BSA');\">&nbsp;BSA&nbsp;&nbsp;&nbsp;&nbsp;";
			rdoStr += "<input type='radio' value='008' class='trans' name='rdoOpJob' onClick=\"chgOptionJob('Weight Per TEU');\">&nbsp;Weight Per TEU&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		div_opjob.innerHTML = rdoStr;
		rdoOpJob[0].checked=true;
		//div_perf.style.display = "none";
		<% if(event != null) {%>
	    txtYear.value       = "<%= JSPUtil.getNull(request.getParameter("txtYear")) == null ? "" : JSPUtil.getNull(request.getParameter("txtYear")) %>";
	    txtFmWeek.value     = "<%= JSPUtil.getNull(request.getParameter("txtFmWeek"))==null?"":JSPUtil.getNull(request.getParameter("txtFmWeek")) %>";
	    txtToWeek.value     = "<%= JSPUtil.getNull(request.getParameter("txtToWeek"))==null?"":JSPUtil.getNull(request.getParameter("txtToWeek")) %>";
	    cobTrade.value      = "<%= JSPUtil.getNull(request.getParameter("selTrade"))==null?"":JSPUtil.getNull(request.getParameter("selTrade")) %>";
	    cobLane.value      = "<%= JSPUtil.getNull(request.getParameter("selRlane"))==null?"":JSPUtil.getNull(request.getParameter("selRlane")) %>";
	    cobDir.value        = "<%= JSPUtil.getNull(request.getParameter("selDir"))==null?"":JSPUtil.getNull(request.getParameter("selDir")) %>";
	    cobIOC.value        = "<%= JSPUtil.getNull(request.getParameter("selIOC"))==null?"":JSPUtil.getNull(request.getParameter("selIOC")) %>";
	    txtVsl_cd.value     = "<%= JSPUtil.getNull(request.getParameter("txtVsl_cd"))==null?"":JSPUtil.getNull(request.getParameter("txtVsl_cd")) %>";
	    txtSkd_voy_no.value = "<%= JSPUtil.getNull(request.getParameter("txtSkd_voy_no"))==null?"":JSPUtil.getNull(request.getParameter("txtSkd_voy_no")) %>";
	    txtDir_cd.value     = "<%= JSPUtil.getNull(request.getParameter("txtDir_cd"))==null?"":JSPUtil.getNull(request.getParameter("txtDir_cd")) %>";
	    hSearchYN.value     = "<%= JSPUtil.getNull(request.getParameter("hSearchYN")) == null ? "" : JSPUtil.getNull(request.getParameter("hSearchYN")) %>";
	    <%}%>
	}
-->
</SCRIPT>