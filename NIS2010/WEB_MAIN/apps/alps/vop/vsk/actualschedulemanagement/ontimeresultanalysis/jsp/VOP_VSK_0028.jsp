<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0028.jsp
*@FileTitle : Report data Creation
*Open Issues :
*Change history : 
*@LastModifyDate : 2013.03.04
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2009.10.08 유혁  1.0 Creation
* History
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2012.08.14 진마리아 CHM-201219281-01 타선사 SKD에 대해 PAPAC, EGSUZ 입력필수항목 제외처리
* 2013.01.25 황태진    CHM-201322271-01 정시율 조회 조건 변경 및 멀티 저장 처리
* 2013.03.04 정상기   CHM-201323034    On-Time Delay Time에 따른 Reason/Remark 사유입력 체크로직 변경
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0028Event event 			= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 		serverException	= null;		//서버에서 발생한 에러
	String 			strErrMsg 		= "";		//에러메세지
	int 			rowCount	 	= 0;		//DB ResultSet 리스트의 건수

	String 			successFlag 	= "";
	String 			codeList  		= "";
	String 			pageRows  		= "100";

	String 			strUsr_id		= "";
	String 			strUsr_nm		= "";
	String 			header 			= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.actualschedulemanagement.ontimeresultanalysis");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopVsk0028Event)request.getAttribute("Event");
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
<title>test</title>
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
<input type="hidden" name="exist">
<input type="hidden" name="dlay_rsn_cd">
<input type="hidden" name="dlay_rsn_nm">
<input type="hidden" name="tmp_vsl_cd" value="">

<input type="hidden" name="conv_clpt_seq">
<input type="hidden" name="inc_del_vsl" value="Y">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;<span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="45">Month</td>
					<td width="100">
						<!--저장시 saved month 가 저장안되는 현상으로 id 부여 2015.01.06 -->
						<input type="text" id="m_act_inp_yrmon" name="act_inp_yrmon" dataformat="ym" caption="month" maxlength="6" size="10" cofield="act_inp_yrmon" style="width:60;text-align:center;" class="input1" value="" Readonly>&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" tabindex="3">
					</td>
					
					<td width="75">Lane Code</td>
					<td width="90"><input type="text" style="width:50;ime-mode:disabled;text-align:center" name="lan_cd" value = "" class="input1" maxlength="3" dataformat="uppernum" value="">&nbsp;<img src="img/btns_search.gif" name="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" tabindex="1">&nbsp;
					</td>
 	                <!--  td width="130">Direction
	                  <select name = "skd_dir_cd" style="width:50px;" tabindex="2">
	                    <option selected value=""> </option>
	                    <option value="E"> E</option>
	                    <option value="W"> W</option>
	                    <option value="S"> S</option>
	                    <option value="N"> N</option>
	                  </select>
	                </td-->
					<td width="30">VVD</td>   
					<td width="260" style="width: 180px">
					    <input type="text" name="vsl_cd" value = "" tabindex="4" maxlength="4" style="width:40;text-align:center;ime-mode:disabled;text-align:center;" class="input1">
						<input type="text" name="voy_no" value = "" tabindex="5" maxlength="4" style="width:37;text-align:center;ime-mode:disabled;text-align:center;" class="input1">
						<input type="text" name="dir_cd" value = "" tabindex="6" maxlength="1" style="width:20;text-align:center;ime-mode:disabled;text-align:center;" class="input1">
						<img class="cursor" name="btn_search2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="410">
						<table class="search_sm2" border="0" style="width:230;" > 
						<tr class="h23">
							<td>VSL OPR&nbsp;&nbsp;<input type="radio" name="act_crr_cd" class="trans" value="A" checked="checked">ALL&nbsp;<input type="radio" name="act_crr_cd" class="trans" value="H">SML&nbsp;<input type="radio" name="act_crr_cd" class="trans" value="O">Other</td>
						</tr>	
						</table>
					</td>
					</tr>
				</table>
				
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!--  grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--  grid   (E) -->
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
					<td class="btn1" id="btn_Retrieve" name="btn_Retrieve" type=" ">Retrieve</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td><td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				<td class="btn1_line"></td>
				<!-- 
				<td>
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				 -->
				<td>
					<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Update">Save</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				<!--  
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_VVD_Delete">VVD Delete</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				-->
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				<!-- 
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Calculation">Calculation</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Conversion">Conversion</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				 -->
				
					</tr>
				</table>
			</td></tr>
</table>	
    <!--Button (E) -->
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
