<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0019.jsp
*@FileTitle : Vessel SKD & Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.13 김기종
* 1.0 Creation
==========================================================
	 History
	* 2013.03.25 김태경 [CHM-20132554] Vessel Schedule  Inquiry 조회 보완 요청 - Multi Lane 클릭시 복수의 Lane 을 선택 할수 있도록 보완
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vsl_cd		= "";
	String pol_cd		= "";
	String pod_cd		= "";
	
	String screenName		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingCommon.BookingUtil");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		vsl_cd =  JSPUtil.getParameter(request, "vvd");
		pol_cd =  JSPUtil.getParameter(request, "pol_cd");
		pod_cd =  JSPUtil.getParameter(request, "pod_cd");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");
		
		log.debug("vsl_cd"+vsl_cd);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Vessel SKD & Code Inquiry</title>
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
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->

<%
	if (screenName.indexOf("POP") > 0){
%>	


<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<table width="100%" class="popup" cellpadding="10" border="0"> 	
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Vessel SKD &amp; Code Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%	}else{ %>


<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<table width="100%" class="popup" cellpadding="0" border="0" style="padding-top: 2; padding-left: 5;"> 
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
<%	} %>	
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table border="0" > 
				<tr class="h23">
					<td width="40">Lane</td>
					<td width="118" style='padding-left:2px'>
						<script language="javascript" >ComComboObject('slan_cd', 1, 100, 0)</script>
						<script language="javascript" for="slan_cd" Event='OnBlur()'>checkKeyInSlanCd(document.form.slan_cd);</script></td>
					<td width="30">VVD</td>
					<td style="padding-right:135px"><input type="text" name="vsl_cd" style="width:80;" class="input" value="<%=vsl_cd %>" style="ime-mode:disabled" dataformat="uppernum" caption="VVD" maxlength="9" >&nbsp;<img src="img/btns_search.gif" name="btn_0B2pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td> 
					<td style="padding-right:5px">Vessel Name</td>
					<td width="200"><input type="text" style="width:190;ime-mode:disabled" class="input" name="vsl_eng_nm" maxlength="50" value="" tabindex="2"></td> 
					<td>OLD</td>
					<td width="130"><input type="checkbox" name="old_tick" value="Y" class="trans" checked></td></tr>
			    </table>
			    <table border="0">
				<tr class="h23">
					<td width="40">POL</td>
					<td width="120"><input type="text" name="vps_port_pol" style="width:80;" class="input" value="<%=pol_cd %>" style="ime-mode:disabled" dataformat="engup" caption="POL" maxlength="5"></td>
					<td width="30">ETD</td>
					<td width="238">
					<input type="text" name="pf_etd_from_dt" style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="ymd" caption="ETD START DATE" maxlength="10" >&nbsp;&nbsp;~&nbsp;&nbsp;
					<input type="text" name="pf_etd_to_dt" style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="ymd" caption="ETD END DATE" maxlength="10" >
						<img src="img/btns_calendar.gif" align="absmiddle" style="cursor:hand" onClick="callDatePop('ETD')">
					</td>
					<td width="30">POD</td>
					<td width="130">
					<input type="text" name="vps_port_pod" style="width:80;" class="input" value="<%=pod_cd %>" style="ime-mode:disabled" dataformat="engup" caption="POL" maxlength="5"></td>
					<td width="30">ETB</td>
					<td>
					<input type="text" name="pf_etb_from_dt" style="width:80;" class="input" value="" dataformat="ymd" caption="ETB START DATE" maxlength="10" >&nbsp;&nbsp;~&nbsp;&nbsp;
					<input type="text" name="pf_etb_to_dt"  style="width:80;" class="input" value="" dataformat="ymd" caption="ETB END DATE" maxlength="10" >
					<img src="img/btns_calendar.gif" align="absmiddle" style="cursor:hand" onClick="callDatePop('ETB')">
					</td></tr> 
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
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

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
<%
	if (screenName.indexOf("POP") > 0){
%>	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton" >
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>		
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_select">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
			<td class="btn1_line"></td>	
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<%
	}else{
%>	
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>	


<%
	}
%>	
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<%@include file="/bizcommon/include/common_alps.jsp"%>
	
<SCRIPT LANGUAGE="javascript">	
	// 부모창의 function을 호출
	//@ 2014.10.07  추가 된 칼럼으로 기존에 리턴 받아서 처리하던 화면에서 버그 발생을 피하기 위해,
	//               callParentFunc2 JSP에 추가 함
	function callParentFunc2() {
		<%
		/*
			String func  = request.getParameter("func");
			String strDisplay = request.getParameter("display");
			String strPopOpt  = null;
			String popKind	  = null;
			
			// Sheet에서 팝업 호출시, Target이 되는 Cell의 row/col 정보
			String row = request.getParameter("row");
			String col = request.getParameter("col");	
			String sheetIdx = request.getParameter("sheetIdx");
			
			//@ 상위 변수 include file에 존재 함.
			*/
			if("none".equals(strDisplay)) {
				popKind = "none";
			} else {
				if(strDisplay != null && strDisplay.length() >= 3) {
					strPopOpt = strDisplay.substring(0,3);
				}
				
				if(strPopOpt != null) {
					if("0,1".equals(strPopOpt)) {
						popKind = "checkbox";
					} else if("1,0".equals(strPopOpt)) {
						popKind = "radio";
					} else if("0,0".equals(strPopOpt)) {
						popKind = "row";
					} 
				}
			}
			
			if(func == null || func.equals("")) {
		%>
				window.close();
				return;
		<%
			}
		%>
			
		var sheetObj = sheetObjects[0];
    	
    	var checkRows = sheetObj.CheckedRows("radio");
		if(checkRows == 0) {
			ComShowCodeMessage("COM12114", "row");
  			return ;
  		} 
		
		var rArray = new Array(); //행데이터를 담고 있는 배열
		var cArray = null; //열데이터를 담고 있는 배열
        //SaveName이 "radio"인 행에서만 체크된 행의 번호를 읽어온다.
        var checkedRows = sheetObj.FindCheckedRow("radio");
        var arrRow = checkedRows.split("|");
        var colsCnt = sheetObj.LastCol + 1;
        for (var i = 0; i < arrRow.length -1; i++){
	  			cArray = new Array();
  				var cIdx = 0;//칼럼 idx
	  			for(var j=0; j < colsCnt; j++) {
	  				
	  				//@ 2014.10.07 crr_cd,2014.11.03 vsl_eng_nm 추가 된 칼럼들로 인해, 기존에 리턴 받아서 처리하던 화면에서 버그 발생을 피하기 위함. 
	  				if("crr_cd" == sheetObj.ColSaveName(j) || "vsl_eng_nm" == sheetObj.ColSaveName(j) ){
	  					continue;
	  				}
                	cArray[cIdx] = sheetObj.CellValue(arrRow[i], j);
                	cIdx++;
                }
                rArray[i] = cArray;
  		}
		// 모달창인 경우는 window 객체로부터 opener를 획득
		if(!opener)
			opener = window.dialogArguments;
		
		try {
			<%
				if(func != null && !func.equals("")) {					
					if(row != null && col != null) {
						if(sheetIdx != null && sheetIdx != "") {
			%>
							opener.<%= func %>(rArray, <%=row%>, "<%=col%>", <%=sheetIdx%>);
							window.close();
			<%
						} else {
			%>
							opener.<%= func %>(rArray, <%=row%>, "<%=col%>");
							window.close();
			<%
						}
					} else {
			%>
						opener.<%= func %>(rArray);
						window.close();
			<%
					}
				}
			%>
		}
		catch(e) {
		 	ComShowCodeMessage("COM12111");
		}
	}
	</SCRIPT>	