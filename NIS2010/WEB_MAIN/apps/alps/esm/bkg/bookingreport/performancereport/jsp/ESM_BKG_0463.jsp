<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0463.jsp
*@FileTitle : bookringreport
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.10
*@LastModifier : 정선용
*@LastVersion : 1.0
* 1.0 Creation
* 2011.11.22 정선용 [CHM-201114286-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
* 2012.01.05 정선용 [CHM-201115236-01] DPCS S/I Turn Time Report 수정 요청
* 2012.11.21 조정민 [CHM-201220634] SI TURN TIME REPORT 계산식 변경 및 TURN TIME 항목 추가 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0463Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0463Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc= account.getOfc_cd();

		event = (EsmBkg0463Event)request.getAttribute("Event");
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
<title>SI Receiving List</title>
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
<form name="form">

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_ofc_cd" value=<%=strUsr_ofc%>>

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:98%;"> 
				<tr class="h23">
					<td>Period</td>
					<td width="350">
						<input type="text" name="fm_dt" style="width:75" value="" class="input1" style="ime-mode:disabled" dataformat="ymd" maxlength="10" size="10" >
						<input type="text" name="fm_tm" style="width:40" value="00:00" class="input1" dataformat="hm" caption="Period Start Time" maxlength="5" required>
						&nbsp;~&nbsp;
						<input type="text" name="to_dt"  style="width:75" class="input1" value="" dataformat="ymd" maxlength="10" size="10" >
						<input type="text" name="to_tm" style="width:40" value="23:59" class="input1" dataformat="hm" caption="Period End Time" maxlength="5" required>
						&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar"></td>
					
					<td >Region</td>
					<td><script language="javascript">ComComboObject("rgn_ofc_cd", 2, 100, 1, 0, 1);</script></td>		
					<td>BKG Office</td>
					<td><input type="text" name="bkg_ofc_cd" dataformat="engup" style="width:100" value="" class="input"></td>	
					<!-- <td>SI Type</td> 					
					<td><script language="javascript">ComComboObject("sr_amd_tp_cd", 1, 100, 1, 0, 1);</script></td> -->
				</tr>
				
				<tr class ="h23">
					<td>Input</td>
					<td><script language="javascript">ComComboObject("bl_doc_inp_flg",1,60,1,0,1);</script>&nbsp;&nbsp;
                        Rate&nbsp;&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject("bl_rt_flg",1,60,1,0,1);</script>&nbsp;&nbsp;&nbsp;&nbsp;
                        QA&nbsp;&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject("bl_aud_flg",1,60,1,0,1);</script>&nbsp;&nbsp;&nbsp;&nbsp;
                    </td>				
					<td>SI Type</td> 					
					<td><script language="javascript">ComComboObject("sr_amd_tp_cd", 1, 100, 1, 0, 1);</script></td>
					<td></td>
					<td></td>
				</tr>
				
				</table>
				
			</td></tr>
	</table>	
				<!--  biz_1   (E) -->
<table class="height_8"><tr><td></td></tr></table>
				<!-- Tab ) (S) -->
	     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
	       		<tr><td width="100%">
							<script language="javascript">ComTabObject('tab1')</script>
						</td></tr>
</table>
				<!-- Tab ) (E) --> 
				
<div id="tabLayer" style="display:inline">				
				<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable" style="display:none">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<table width="100%" class="search"  id="mainTable" style="display:none">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet2');</script></td>
							</tr>
						</table>
			<!-- Grid (E) -->
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			
</div>			
<!--TAB 1 (E) --> 

			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
		</table>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>