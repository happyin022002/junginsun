
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0432.jsp
	 *@FileTitle : B/L Perf. by Volume-I (by Region-User Group)
	 *Open Issues : ESM_BKG_0432 화면
	 *Change history :
	 *@LastModifyDate : 2011.05.30
	 *@LastModifier : jsy
	 *@LastVersion : 1.0
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0432Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0432Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingCorrection.BdrCorrection");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strOfc_cd = account.getOfc_cd();
		
		event = (EsmBkg0432Event) request.getAttribute("Event");
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Perf. By Volumn-Overall Region & Group</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="sel_region"> 
<input type="hidden" name="sel_group">
<input type="hidden" name="usr_ofc_cd" value=<%=strOfc_cd%>>

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5; padding-right: 5;">
	<tr>
		<td valign="top">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>


		<!--biz page (S)--> <!-- 1 (S) -->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1 (S) -->
				<table class="search" border="0" style="width: 100%;">
					<tr>
						<td height="3"></td>
					</tr>
					<tr class="h23">
						<td width="70" align="left">&nbsp;Doc OFC&nbsp;</td>
						<td width="150"><script language="javascript">ComComboObject('dpcs_ofc_cd', 1, 100, '');</script></td>
            
						<td width="50">Period</td>
						<td width="360">
							<input type="text" name="from_dt" style="width: 80" value="" class="input1" dataformat="ymd" caption="Period Start Date" maxlength="10" style="ime-mode:disabled" required cofield="to_dt"> 
							<input type="text" name="from_mt" style="width: 40" value="00:00" class="input1" dataformat="hm" caption="Period Start Time" maxlength="5" required>&nbsp;~&nbsp;
							<input type="text" name="to_dt" style="width: 80" value="" class="input1" dataformat="ymd" caption="Period End Date" maxlength="10" style="ime-mode:disabled" required cofield="from_dt"> 
							<input type="text" name="to_mt" style="width: 40" value="23:59" class="input1" dataformat="hm" caption="Period End Time" maxlength="5" required>&nbsp;
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_period">
						</td>
						<td width="60" align="right">Region&nbsp;</td>
						<td>
							<script language="javascript">ComComboObject("region",2,85,1,0,1);</script>
						</td>
						<td width="80"  align="right">User ID&nbsp;</td>
						<td>
							<input type="text" style="width: 100; ime-mode: disabled" class="input" value="" name="atnd_usr_id" maxlength='20'>
						</td>
						<td width="60"></td>
						<td><!-- input type="text" style="width:75;ime-mode:disabled" class="input" value="" name="vvd_cd" maxlength='9' dataformat='engupnum'--></td>


					</tr>
				</table>

				<table class="search" border="0" style="width: 100%;">
					<tr>
						<td height="3"></td>
					</tr>
					<tr class="h23">
						<td width="430">
						<table class="search_sm2" border="0" style="width: 409">
							<tr class="h23">
								<td width="205">Perform by Queue:</td>
								<td width="" class="stm">
									<input type="radio" value="A" class="trans" name="pfm_by_queue_cd" checked>ALL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" value="ID" class="trans" name="pfm_by_queue_cd">Input&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" value="RD" class="trans" name="pfm_by_queue_cd">Rate&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" value="AD" class="trans" name="pfm_by_queue_cd">QA</td>
								<td width=""></td>
								<td></td>
							</tr>
						</table>
						</td>
						<td width="60"></td>
						<td><!-- <input type="text" style="width:150;ime-mode:disabled" class="input" value="" name="atnd_usr_id" maxlength='20'> --></td>
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
		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
				<table class="search">
					<tr>
						<td><!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
					<tr>
						<td>* Remark : For detailed information, double click above columns.</td>
					</tr>
						</table>
						<!-- : ( Grid ) (E) --></td>
					</tr>
				</table>
				<!-- Tab1 (E) --> <!--  biz_1   (E) --></td>
			</tr>
		</table>
		
		<!-- : ( Button : pop ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_DownExcel_Summary">Down Excel</td>
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

		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>

		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
				<table class="search">
					<tr>
						<td><!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) --></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_down_excel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --> <!-- 개발자 작업  끝 -->
</td>
</tr>
</table>		
</form>
</body>
</html>

