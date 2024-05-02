<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0058.jsp
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : * 2013.11.21
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2013.11.21 신자영
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0058Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Calendar"%>

<%
	EsmSpc0058Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpaceAllocationManage.SpaceControlManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0058Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		String popup_vvd        = (request.getParameter("vvd") == null)? ""  : request.getParameter("vvd");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Space Utilization Inquiry VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		
		<%
		Calendar c = Calendar.getInstance();
		
		int year = c.get(Calendar.YEAR);
		String text_year = year + "";
		
		int week = c.get(Calendar.WEEK_OF_YEAR) - 1;
		String text_week = "";
		
		if (week < 10) {
			text_week = "0" + week;
		} else {
			text_week = week + "";
		}
		%>

		<%

        if(event != null){ 
        	
            String year1 = event.getConditionVO().getYear1();
            String week1 = event.getConditionVO().getWeek1();
            String lane  = event.getConditionVO().getLane();
            String bound = event.getConditionVO().getBound();
            String vvd   = event.getConditionVO().getVvd();
            String popup_vvd = (request.getParameter("vvd") == null)? ""  : request.getParameter("vvd");

            if(year1 == ""){
            	year1 = text_year;
            }
            if(week1 == ""){
            	week1 = text_week;
            }
        %>
            var formObject = document.form;
	        formObject.year1.value = "<%=year1%>";
	        formObject.week1.value = "<%=week1%>";
	        formObject.lane.Code   = "<%=lane%>";
	        formObject.bound.value = "<%=bound%>";
       		formObject.in_vvd.value= "<%=popup_vvd%>";
        	
				var rtn = getVVDInfo(formObject.in_vvd.value);
            	var tmp_vvd        = getEtcDataFromXml(rtn, "vvd").split("|");
            	var tmp_cost_yrwk  = getEtcDataFromXml(rtn, "costYrwk").split("|");
            	var tmp_rlane_cd   = getEtcDataFromXml(rtn, "rlaneCd").split("|");
            	
            	
            	if (tmp_vvd[0] == "") {
            		ComShowMessage(getMsg("SPC90199", "VVD Input"));
            		formObject.in_vvd.value ="";
            		formObject.in_vvd.focus();
            		return;
            	} else {
            	 	formObject.year1.value = tmp_cost_yrwk[0].substring(0,4);
					formObject.week1.value = tmp_cost_yrwk[0].substring(4,6);	            	
					formObject.lane.Code   = tmp_rlane_cd[0];
					formObject.bound.value = tmp_vvd[0].substring(8);

					in_vvd_chk = true; // lane값이 변해서 get vvd를 타기때문에 초기화된 in_vvd_chk를 다시 in_vvd에서 호출된것으로 바꾸어줌
					getVVD(tmp_vvd[0]); // VVD Input의 event때문에 호출하였음.
            	}
            	
	        if("<%=vvd%>"!=""){
	        	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
         <% } %>
		}
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="void_flg" value="N">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<% if("Y".equals(JSPUtil.getNull(request.getParameter("popupcheck")))){ %>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">	
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" > Space Utilization Inquiry VVD </td></tr>
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
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new" alt="Alt+N">New</td><td class="btn1_right"></td></tr></table></td>

								<td class="btn1_line"></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>

					</td></tr>
				</table>
				<!-- TABLE '#D' : ( Button : Main ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg">
						
						<table border="0" class="search_in">
							<tr class="h23">
								<td width="80"><img class="nostar">Start Week</td>
								<td width="130">
									<select class="input1" name="year1" style="width:60;" onChange="getVVD('');checkWeek();"></select>
									<select class="input1" name="week1" style="width:40;" onChange="getVVD('');"></select>
								    
								</td>
								<td width="45"><img class="nostar">Lane</td>
								<td width="80">
									<script language="JavaScript">ComComboObject("lane", 4, 65, 0, 1);</script>
								</td>
								<td width="65"><img class="nostar">Bound</td>
								<td width="50">	
									<select name="bound" class="input1"  style="width:50;" onChange="getVVD('');"></select>
								</td>
								<td width="40"><img class="nostar">VVD</td>
								<td width="120"><select class="input1" style="width: 100;" name="vvd" id="vvd">
									            <option value=""></option>
								</td>	
								<td width="80">Relative VVD</td>
								<td width="">&nbsp;<input type="text" name="re_vvd"	size="12" readonly></td>
								<td width ="80" align="center">VVD Input</td>
								<td ><input type="text" dataformat="engup" name="in_vvd" style="width: 90;"	maxlength="9" class="input1"></td>
								
								<!--input type="checkbox" value="1" name="f_void_flg" onClick="setVoidFlg();">Void Calculation -->
							</tr>
						</table>
						
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->
				<table class="height_10"><tr><td></td></tr></table>

				<!-- TABLE '#D' : ( Tab ) (S) -->
				<table class="tab">
					<tr>
						<td><script language="javascript">ComTabObject('tab1')</script></td>
					</tr>
				</table>

<!-- TABLE '#D' : ( Tab ) (E) --> <!-- UI_ESM_SPC_0045 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline"><!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg">

						<table class="height_10"><tr><td></td></tr></table>

						<table class="search" border="0">
							<tr class="h23">
								<td><input type="radio" value="F" name="dataSelect"	class="trans" onclick="changeTitle2();" checked>F'cast + BKG&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    <input type="radio" value="B" name="dataSelect" class="trans" onclick="changeTitle2();">BKG&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    <input type="radio" value="A" name="dataSelect" class="trans" onclick="changeTitle2();">Alloc. +BKG&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    <input type="radio" value="M" name="dataSelect" class="trans" onclick="changeTitle2();">Alloc
								</td>
								<!-- 
								<td><input type="checkbox" value="1" name="f_void_flg" onClick="setVoidFlg();">Void Calculation</td>
								-->
							</tr>
						</table>
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->
</div>

				<!-- UI_ESM_SPC_0045 : THIS IS 2st TAB -->
<div id="tabLayer" style="display:none"><!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr><td class="bg">

					    <table class="height_10"><tr><td></td></tr></table>

						<table class="search" border="0">
							<tr class="h23">
								<td><input type="radio" value="F" name="dataSelect1" class="trans" onclick="changeTitle1();" checked>F'cast	+ BKG&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    <input type="radio"	value="B" name="dataSelect1" class="trans" onclick="changeTitle1();">BKG&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    <input type="radio" value="A" name="dataSelect1" class="trans" onclick="changeTitle1();">Alloc. +BKG&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    <input type="radio" value="M" name="dataSelect1" class="trans" onclick="changeTitle1();">Alloc
								</td>
							</tr>
						</table>
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet2');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
					</td></tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->
</div>

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>