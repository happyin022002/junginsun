<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0006.jsp
*@FileTitle : Canada Export EDI Transmit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0006Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	boolean isCA_Usr 		= false;
	String strCnt_cd		= "CA";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.customstransmission");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0006Event)request.getAttribute("Event");
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
<title>Canada ACI: Manifest Transmit</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var today = "<%=JSPUtil.replace(DateTime.getDateString(),".","-")%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage(<%=isCA_Usr%>);
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cnt_cd" value="<%=strCnt_cd%>">
<input type="hidden" name="error_data">
<input type="hidden" name="terminal_auto_snd">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">

<!--Page Title, Historical (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
</table>
<!--Page Title, Historical (E)-->

<!--biz page (S)-->


<table class="search">
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="120"><input type="text" style="width:90;ime-mode:disabled" class="input1" name="vvd_cd" maxlength="9" dataformat="eng" minlength="9" caption="VVD" required value=""></td> 
					<td width="30">POL</td>
					<td width="90"><input type="text" style="width:50;ime-mode:disabled" class="input1" required name="pol_cd" maxlength="5" dataformat="eng" minlength="5" caption="POL"  value=""></td> 
					<td width="30">POD</td>
					<td width="90"><input type="text" style="width:50;ime-mode:disabled" name="pod_cd" maxlength="5" dataformat="eng" minlength="5" caption="POD" value=""></td>
					<td width="60">LANE</td>
					<td width="80"><input type="text" style="width:50;ime-mode:disabled" name="lane" maxlength="5" dataformat="eng" minlength="5" caption="LANE"></td>
					<td  align="right">
					
						<table class="search_sm" border="0" width="400">
							<tr class="h23">
								<td width="120"><input type="checkbox" name="gubun" class="trans"></td>
								<td width="50%">&nbsp;Vessel A.T.D.<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Actual Time of Departure)</td>
								<td width="40%">&nbsp;POL
									<input type="text" class="input1" style="width:50;ime-mode:disabled" name="atd_pod_cd" maxlength="5" dataformat="eng" minlength="5" caption="Vessel A.T.D POL" required></td>
							</tr>
							<tr class="h23">
								<td></td>
								<td class="stm" colspan="2">
			                        <input type="text"
			                        style="width: 75; ime-mode: disabled" class="input1" value="" required disabled
			                        dataformat="ymd" name="atd_from_dt" maxlength="10" caption="ATD Date" cofield="atd_to_dt">
			                        <input type="text" name="atd_from_tm" maxlength="5" style="width:40" dataformat="hm" value="00:00" class="input1" disabled>
			                        ~ <input type="text"
			                        style="width: 75; ime-mode: disabled" class="input1" value="" required disabled
			                        dataformat="ymd" name="atd_to_dt" maxlength="10" caption="ATD Date" cofield="atd_from_dt">
			                        <input type="text" name="atd_to_tm" maxlength="5" style="width:40" value="23:59" class="input1" disabled>
			                        <img src="img/btns_calendar.gif" width="19" height="20" border="0" dataformat="hm" align="absmiddle" class="cursor" name="btn_calendar">
								</td>
							</tr>
						</table>

					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table class="height_8"><tr><td colspan="8"></td></tr></table>
		
<table class="search" id="mainTable"> 
	<tr>
		<td class="bg">
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<div style="display:none">
	<script language="javascript">ComSheetObject('sheet3');</script>
</div>        
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	<tr>
		<td class="btn1_bg">
    		<table border="0" cellpadding="0" cellspacing="0">
    			<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_downexcel">Down Excel</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_editbl">Booking History</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_terminal">Terminal EDI</td>
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

<!-- 본문끝 -->
		</td>
	</tr>
</table>
<!-- 본문끝 -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>