<%
/*=========================================================
 *Copyright(c) 20114 CyberLogitec
 *@FileName : EES_CGM_2213.jsp
 *@FileTitle : Status Creation for Bare MG.Set Reposition
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.14
 *@LastModifier : 김승만
 *@LastVersion : 1.0
 * 2014.10.14 김승만
 * 1.0 Creation
*--------------------------------------------------
=========================================================*/
%> 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm2213Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm2213Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.chassismgsetinventory");
	
	// to loc select box	
	String toLocSelectBox = JSPUtil.getCodeCombo("tostatus",  "","style='width:55;'","CD00259",0,"");
	//status
	String statusSelectBox = JSPUtil.getCodeCombo("status",  "","style='width:55;'","CD03323",0,"000001: :ALL");
	
    // 현재날짜
    String tempToPeriod = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
    // 1개월 이전날짜
    String tempFmPeriod = DateTime.addMonths(tempToPeriod, -1, "yyyy-MM-dd");
    
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesCgm2213Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
		//2013-07-09 조경완 Rold Code 하드코딩 대체 
		//if("SELCOE".equals(strOfc_cd)){
		//	tRole = "Authenticated";
		//}else{
		//	tRole = "Not Authenticated";
		//}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Status Creation for Bare MG.Set Reposion</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="eq_knd_cd" value="G">
<input type="hidden" name="eq_tpsz_cd" >
<input type="hidden" name="intg_cd_id" >
<input type="hidden" name="mgst_no" >
<input type="hidden" name="chss_no" >
<input type="hidden" name="cntr_no" >
<input type="hidden" name="vndr_seq" >
<input type="hidden" name="vndr_cd" >
<input type="hidden" name="yd_cd" > <!--  org, rtn yard 검색 용 -->
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
	
	
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
			<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
					<tr><td class="bg">
							<table class="search_in" border="0" cellpadding="0" cellspacing="0" style="width:900;">
								<tr class="h23">
								<td width="50">Status</td>
									<td width="80"><%= statusSelectBox %></td>
									<td width="60" >Location</td>
									<td width="160">
										<%= toLocSelectBox %>
										<input type="text" style="width:60;ime-mode:disabled;" name="tolocation"  maxlength=7 onKeyUp="javascript:upperCase_Num();">
										<img class="cursor" src="/hanjin/img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="toloc_btn">
									</td>	
									<td width="50" class="stm"><B>Period</B> </td>
									<td ><input type="text" style="width:75;" class="input" name="fromdate" value="<%=tempFmPeriod%>" required dataformat="ymd" maxlength="8" >&nbsp;~&nbsp;
										 <input type="text" style="width:75;" class="input" name="todate"   value="<%=tempToPeriod%>" required dataformat="ymd" maxlength="8" >&nbsp;
										 <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarto" >
									</td>				
								</tr>						
							</table>
						</td>
          			</tr>
				</table>
			
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
			<!-- Grid - 1 (E) -->	<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add" id="btn_add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowcopy" id="btn_rowcopy">Row&nbsp;Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete" id="btn_delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				<!--  biz_2  (E)  -->
			</td></tr>
		</table>
				
		</td></tr>
		</table>	
			
			
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel" >Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>