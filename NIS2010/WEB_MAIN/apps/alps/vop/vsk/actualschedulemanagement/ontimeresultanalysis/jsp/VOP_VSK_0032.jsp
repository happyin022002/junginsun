<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0032.jsp
*@FileTitle : On-Time Ratio
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.04
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2009.09.04 유혁
* 1.0 Creation
*
* History
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완4
* 2013.03.04 정상기   CHM-201323034    On-Time Delay Time에 따른 Reason/Remark 사유입력 체크로직 변경 및 조회조건 Update ID 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0032Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.actualschedulemanagement.ontimeresultanalysis");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0032Event)request.getAttribute("Event");
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
<title>On-Time Ratio</title>
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

<input type="hidden" name="sum_date">
<input type="hidden" name="inc_del_vsl" value="Y">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Lane Code</td>
					<td width="100">
						<input type="text" name="vsl_slan_cd" style="width:50;text-align:center;ime-mode:disabled" class="input" maxlength="3">&nbsp;<img src="img/btns_search.gif" name="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="80">Vessel Code</td>
					<td width="120">
						<input type="text" name="vsl_cd" style="width:60;text-align:center;ime-mode:disabled" class="input" maxlength="4">&nbsp;<img src="img/btns_search.gif" name="btns_search2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="35">Port</td>
					<td width="95">
						<input type="text" name="vps_port_cd" style="width:50;text-align:center;ime-mode:disabled" class="input" maxlength="5">&nbsp;<img src="img/btns_search.gif" name="btns_search3" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>		
					<td width="80">Carrier Code</td>
					<td width="120">
						<input type="text" name="crr_cd" style="width:60;text-align:center;ime-mode:disabled" class="input" maxlength="3">&nbsp;<img src="img/btns_search.gif" name="btns_search4" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>		
					<td width="100">On-time Option</td>
					<td width=""><input type="text" name="ontime_opt" style="width:35;text-align:right;ime-mode:disabled" size="2" maxlength="2" class="input" value="0"></td>		
				</tr>	
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Group</td>
					<td width="100"><select name="grp_id" style="width:72;" class="input1">
						<option value="A" >Port</option>
						<option value="B">VSL</option>
						<option value="C">Lane</option></select></td>
					<td width="80">Period 1</td>
					<td width="250">
						<input name="start_date1" type="text" caption="시작일1" dataformat="ym" style="width:60;text-align:center;" class="input1" maxlength="6" size="7" cofield="end_date1">&nbsp;<img src="img/btns_calendar.gif" name="btn_cal11" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						<input type="text" style="width:15;text-align:center;background-color:#f3f2f8;border:0px" value="~" readonly tabindex="-1">
						<input name="end_date1" type="text" caption="종료일1" dataformat="ym" style="width:60;text-align:center;" class="input1" maxlength="6" size="7" cofield="start_date1">&nbsp;<img src="img/btns_calendar.gif" name="btn_cal12" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="80">Period 2</td>
					<td width="">
						<input name="start_date2" type="text" caption="시작일2" dataformat="ym" style="width:60;text-align:center;" class="input" maxlength="6" size="7" cofield="end_date2">&nbsp;<img src="img/btns_calendar.gif" name="btn_cal21" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						<input type="text" style="width:15;text-align:center;background-color:#f3f2f8;border:0px" value="~" readonly tabindex="-1">
						<input name="end_date2" type="text" caption="종료일2" dataformat="ym" style="width:60;text-align:center;" class="input" maxlength="6" size="7" cofield="start_date2">&nbsp;<img src="img/btns_calendar.gif" name="btn_cal22" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					
						&nbsp;&nbsp;&nbsp;
						Updated ID
						&nbsp;
						<input name="upd_usr_id" type="text" style="width:95;text-align:left;" class="input" size="15" maxlength="20">
						
					</td>
					</tr>	
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70"></td>
					<td width="480">
						<table class="search_sm2" border="0" style="width:290;"> 
							<tr class="h23">
								<td width=""><input type="radio" name="delay_opt" value="E" class="trans" checked> Exclude of Consecutive Delay<br><input type="radio" name="delay_opt" value="I" class="trans"> Include of Consecutive Delay</td> 
							</tr>
						</table>
					</td>
					<td width="25"></td>
					<td width="">
						<table class="search_sm2" border="0" style="width:290;"> 
							<tr class="h23">
								<td width=""><input type="radio" name="ratio_opt" value="A" class="trans" checked> Arrival On-time Ratio<br><input type="radio" name="ratio_opt" value="D" class="trans"> Departure On-time Ratio</td> 
							</tr>
						</table>
					</td>
					</tr>	
				</table>
				
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				<!-- Grid (E) -->
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_DownExcel">Down&nbsp;Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
						
				<!--biz page (E)-->
	</td>
			</tr>
			</table>
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				
			</tr>
</table>	
    <!--Button (E) -->
	</td></tr>
</table>
</td></tr>
</table>
</form>
</body>
</html>
