<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0153.jsp
*@FileTitle : Disposal Planning by Headquarter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : WanGyu Kim
*@LastVersion : 1.0
* 2009.08.02 WanGyu Kim
* 1.0 Creation 
=========================================================
* 2011.03.02 남궁진호 [CHM-201108450-01] 월선택Box를 분기로 변경
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.event.EesMnr0152Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0152Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.PlanManage.PlanMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm(); 
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();
		
		event = (EesMnr0152Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var strUsrId  = "<%=strUsr_id%>";
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
<input type="hidden" name="ho_ofc_cd">
<input type="hidden" name="mnr_office_level">
<input type="hidden" name="mnr_pln_ofc_cd" value="<%= currOfcCd.trim()%>">
<input type="hidden" name="cntr_tpsz_cd_seq">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>

	<!--Page Title, Historical (E)-->
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				
				<tr class="h23">
					<td width="55">&nbsp;EQ Type</td>
					<td width="125" style="padding-left:2"><script language="javascript">ComComboObject('eq_knd_cd', 1, 100, 1, 1);</script></td>					
					<td width="60">Plan Year</td>
					<td width="100"><input type="text" style="width:50;text-align:center"  class="input1"  name="mnr_pln_yr" dataformat="yyyy" maxlength="4"  required  fulfill>&nbsp;<img src="img/btns_calendar.gif"width="19" height="20" alt=""border="0" align="absmiddle" class="cursor" name="btn_Calendar"></td>
					<td width="45">Quarter</td>
					<td width="100"><script language="javascript">ComComboObject('mnr_pln_grp_no',1, 90 , 1, 1);</script></td>
					<td width="10">&nbsp;</td>
					<td width="65">Plan Date</td>
					<td width="115"><input type="text" style="width:90;text-align:center" class="input2" name="cre_dt" readonly></td>
					<td width="60">Plan User</td>
					<td width="115"><input type="text" style="width:90;" class="input2" name="cre_usr_id" value="<%=strUsr_id %>" readonly></td>
					<td width="45">Status</td>
					<td width=""><input type="text" style="width:90;" class="input2" name="status"  readonly></td>
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">Disposal Planning Summary</td>
			</tr>
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
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">Disposal Planning Detail Data</td>
				</tr>
			</table>
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->			
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_RowAdd">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>						
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_RowDel">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr>
					</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->


	<table class="height_10"><tr><td colspan="8"></td></tr></table>



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>