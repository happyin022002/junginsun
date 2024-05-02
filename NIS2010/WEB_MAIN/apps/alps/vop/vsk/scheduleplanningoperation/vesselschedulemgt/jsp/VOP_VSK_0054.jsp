<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0054.jsp
*@FileTitle : LRS SKD Creation(CCA)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.07.08 유혁
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0054Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0054Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.scheduleplanningoperation.vesselschedulemgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0054Event)request.getAttribute("Event");
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
<title>LRS SKD Creation(CCA)</title>
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


<body  onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="op_type">
<input type="hidden" name="vsl_cd" value="">
<input type="hidden" name="tmp_vsl_slan_cd" value="">
<input type="hidden" name="pf_svc_tp_cd" value="">
<input type="hidden" name="slan_stnd_flg" value="Y">
<input type="hidden" name="stnd_pf_svc_tp_cd">

<input type="hidden" name="skdDirCd1">
<input type="hidden" name="skdDirCd2">
<input type="hidden" name="svc_dur_dys">
<input type="hidden" name="initVslCnt">

<%// 화면이 Feeder 용인 경우 vsl_svc_tp_cd는 "F", 그렇지 않은 경우는 "T" 이다.%>
<input type="hidden" name="vsl_svc_tp_cd" value="F">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="979" border="0" cellpadding="0" cellspacing="0" class="title">
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
					<td width="90"><input  name="vsl_slan_cd" type="text" style="width:37;text-align:center;ime-mode:disabled" class="input1" maxLength="3" tabindex="1">
					<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_search1"></td>
					<td width="60">End Date</td>   
					<td width="140">
						<input type="text" name="end_date" style="width:80;text-align:center" class="input1" dataformat="ymd"  tabindex="2" maxLength="8" size="10" >
						<img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="65">Frequency</td>
					<td width="50"><input type="text" name="brth_itval_dys" style="width:22;text-align:right;"  class="input" tabindex="4" ></td>
					<td width="50">VSL No.</td>
					<td width=""><input type="text" name="vsl_cnt" style="width:22;text-align:right;"  class="input" maxlength="2" tabindex="5"></td>
					</tr>
				</table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" > <!-- border="0" style="width:979;">  --> 
				<tr class="h23">
					<td width="780">
					<table width="700"  id="mainTable"> 
						<tr>
							<td>
								<script language="javascript">ComSheetObject1('sheet1');</script>
							</td>
						</tr>
					</table> 
					
				</td></tr>
				</table>
				
			</td></tr>	
		</table>
	<!--  biz_1   (E) -->
	
	<table class="height_8"><tr><td></td></tr></table>
		
	<table class="search"> 
       	<tr><td class="bg">
				<!--  grid  (S) -->
					<table width="100%" id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table> 
				<!--  grid   (E) -->
				<!--  grid  (S) -->
		
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table> 
			
		<!--  grid   (E) -->
		<!--biz page (E)-->
		</td></tr>
	</table>
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Simulation" name="btn_Simulation">Simulation</td>
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
</form>
</body>
</html>
