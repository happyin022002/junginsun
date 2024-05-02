<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0415.jsp
*@FileTitle : bookringreport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.10 강동윤 
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0415Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0415Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkg0415Event)request.getAttribute("Event");
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
<!-- 개발자 작업	-->
<input type="hidden" name="pfm_by_queue_cd">
<input type="hidden" name="sel_group">
<input type="hidden" name="list_atnd_usr_id">
<input type="hidden" name="usr_ofc_cd" value=<%=strUsr_ofc%>>

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>

		<!--Page Title, Historical (E)--> <!--Button (E) --> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="60" align="left">&nbsp;Doc OFC&nbsp;</td>
						<td width="140"><script language="javascript">ComComboObject('dpcs_ofc_cd', 1, 100, '');</script></td>
						
						<td width="50">Period</td>
						<td width="330">
							<input type="text" name="from_dt" style="width: 80" value="" class="input1" dataformat="ymd" caption="Period Start Date" maxlength="10" style="ime-mode:disabled" required cofield="to_dt"> 
							<input type="text" name="from_mt" style="width: 40" value="00:00" class="input1" dataformat="hm" caption="Period Start Time" maxlength="5" required> &nbsp;~&nbsp;
							<input type="text" name="to_dt" style="width: 80" value="" class="input1" dataformat="ymd" caption="Period End Date" maxlength="10" style="ime-mode:disabled" required cofield="from_dt"> 
							<input type="text" name="to_mt" style="width: 40" value="23:59" class="input1" dataformat="hm" caption="Period End Time" maxlength="5" required>&nbsp;
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_period">
						</td>

						<td width="45">Region</td>
						<td width="140"><script language="javascript">ComComboObject("region",2,100,1,0,1);</script></td>

						<td width="50">User ID</td>
						<td width="130"><input type="text" style="width: 120; ime-mode: disabled" class="input" value="" name="atnd_usr_id" maxlength='100'></td>

					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--  biz_1   (E) -->
		<table class="line_bluedot">
			<tr>
				<td colspan="8"></td>
			</tr>
		</table>
		<!-- Tab ) (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td width="100%"><script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
		<!-- Tab ) (E) -->

		<div id="tabLayer" style="display: inline">
		<table class="search">
			<tr>
				<td class="bg"><!-- Grid  (S) -->
				<table width="100%" class="search" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>					
					<tr>
						<td>* Remark : For detailed information, double click above columns.</td>
					</tr>
				</table>
				<!-- Grid (E) --> <!-- Grid  (S) -->
				<table width="100%" class="search" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --> <!-- Grid  (S) -->
				<table width="100%" class="search" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --></td>
			</tr>
		</table>
		</div>
		<!--TAB 1 (E) --> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 5;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_DownExcel_Summary">Down&nbsp;Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		
<!--Button (E) -->	
    	
	<table class="height_3"><tr><td></td></tr></table>
	
	<!--  -->
	<table class="search">
     <tr>
       <td class="bg">	
	
	
			<!-- Grid  (S) -->
			<!-- Tab1 (S) -->
			<table width="100%"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
				</tr>
			</table>
			<!-- : ( Grid ) (E) -->
			
	        <!-- Tab1 (E) -->
        </td>
      </tr>
	    </table>
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0"
		cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
		<tr>
			<td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
					<table border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_DownExcel_dtl">Down&nbsp;Excel</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	<!--Button (E) --> <!-- 1 (E) -->


</td></tr>
</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>