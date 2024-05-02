<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0055.jsp
*@FileTitle : D/Dock Schedule Review - Graph
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.30 윤세영
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event.EsmFms0055Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0055Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutFleetManagement.TCharIODockSchedule");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EsmFms0055Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		log.error("err " + e.toString(), e);
	}
%>
<html>
<head>
<title>D/Dock Schedule Review - Graph</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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
<input type="hidden" name="snd_year"			>
<input type="hidden" name="trd_year"			>
<input type="hidden" name="flet_dck_svey_tp_nm"	>
<input type="hidden" name="reflection_nm"		>
<input type="hidden" name="usr_id"				value="<%=strUsr_id			%>" >

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
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">D/dock Schedule Review / Graph - Master</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<tr class="h23">
					<td width="90">Vessel Code</td>
					<td width="250"><input type="text" style="width:54;text-align:center;" class="input" value="" maxlength="4" name="vsl_cd" fullfill caption="Vessel Code" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vslpop" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:162;" class="input2" name="vsl_eng_nm" readonly value=""></td>
					<td width="50">Lane</td>
					<td width="140"><input type="text" style="width:50;text-align:center;" class="input" maxlength="3" name="lane_cd" caption="Lane" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_lanepop" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td width="80">Contract TP</td>
					<td width="110"><select name="flet_ctrt_tp_cd" style="width:80;"><option value="" selected>All</option></select></td>
					<td width="70">Vessel Size</td>
					<td><input type="text" name="vsl_dznd_capa_fr" style="width:60;text-align:right;ime-mode:disabled;" class="input" maxlength="5" dataformat="int" value="">&nbsp;&nbsp;~&nbsp;<input type="text" name="vsl_dznd_capa_to" style="width:60;text-align:right;ime-mode:disabled;" class="input" maxlength="5" dataformat="int" value="">&nbsp;</td></tr>
				<tr class="h23">
					<td>D/Dock TP</td>
					<td><select name="flet_dck_svey_tp_cd" style="width:223;" class="input1"><option value="" selected>All Types</option>
					<td>Duration</td>
					<td class="stm" colspan="3"><input type="text" name="fr_duration" style="width:50;text-align:center;ime-mode:disabled; " class="input1" maxlength="4" dataformat="yyyy" required fullfill caption="Duration">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btn_fr_duration"  width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" name="to_duration" style="width:50;text-align:center;ime-mode:disabled;" class="input1" maxlength="4" dataformat="yyyy" required fullfill caption="Duration">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btn_to_duration" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td>Owner</td>
					<td colspan="3" ><input type="text" style="width:141;" class="input2" name="ownr_nm" caption="Owner" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_ownerpop" width="19" height="20" alt="" border="0" align="absmiddle"><input type="hidden" name="ownr_seq"><input type="checkbox" name="btn_ownrclr" class="trans">
					</td></tr>
				<tr class="h23">
					<td colspan="6">Reflection of Phase in / out&nbsp;<select name="reflection_cd" style="width:138;" class="input1"><option value="I">Included</option>
							<option value="E" selected>Excluded</option></select></td></tr>
				
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_2  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">D/dock Schedule Review / Graph</td></tr>
				</table>
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
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SavetoFile">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr></table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>

<!------- Print용 Hidden RD Object Start -------->
<table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>