<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0110.jsp
*@FileTitle : (New)Settlement Target
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.29
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.06.30 민정호
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0110Event"%>

<%
	FnsJoo0110Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String yyyyMM = JSPUtil.getKST("yyyy-MM");
	
	String joCrrCd = "";
	String trdCd   = "";
	String rlaneCd = "";
	String clzFlg  = "";
	String exeYrmon = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (FnsJoo0110Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		joCrrCd = eventResponse.getETCData("jo_crr_cd");
		trdCd   = eventResponse.getETCData("trd_cd");
		rlaneCd = eventResponse.getETCData("rlane_cd");
		clzFlg  = eventResponse.getETCData("estm_clz_flg");
		exeYrmon= eventResponse.getETCData("EXE_YRMON");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>JO Target Creation and Basic Slot Hire Settlement</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gJoCrrCd = "<%=joCrrCd%>";
var gTrdCd   = "<%=trdCd%>";
var gRlaneCd = "<%=rlaneCd%>";
var gClzFlg  = "<%=clzFlg%>";
var gYyyyMM  = "<%=yyyyMM%>";

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
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="code">
<input type="hidden" name="name">
<input type="hidden" name="super_cd1">
<input type="hidden" name="super_cd2">
<input type="hidden" name="lane_cd">
<input type="hidden" name="estm_cond_flg">
<input type="hidden" name="search_gubun">
<input type="hidden" name="pagerows">
<input type="hidden" name="trd_cd">
<input type="hidden" name="rlane_cd">
<input type="hidden" name="jo_crr_cd">
<input type="hidden" name="acct_cd">
<input type="hidden" name="jo_stl_sts_cd">
<input type="hidden" name="jo_stl_itm_cd">
<input type="hidden" name='exe_yrmon' value="<%=exeYrmon.substring(0,4)+"-"+exeYrmon.substring(4)%>">
<input type="hidden" name="search_gubun2" value="1">
<input type="hidden" name="page_no" value="1">
<input type="hidden" name="pagerows2" value="300000">
<input type="hidden" name="tot_page_cnt" value="1">

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
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						
						<td width="100">Revenue Month</td>
						<td width="200"><input type="text" name="rev_yrmon_fr" style="width:60;ime-mode:disabled" value="<%=yyyyMM%>" class="input"  maxlength="6" dataformat="ym" >
						<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;
						<input type="text" name="rev_yrmon_to" style="width:60;ime-mode:disabled" value="<%=yyyyMM%>" class="input" maxlength="6" dataformat="ym" >
						<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle"></td>

						<td width="300"><table class="search_sm" border="0" style="width:280;">
							<tr class="h23">
								<td width="50">Rev./Exp.</td>
								<td width=""class="noinput1">&nbsp;&nbsp;
								<input type="radio" value="R" name='re_divr_cd' class="trans" checked>&nbsp;&nbsp;Revenue&nbsp;&nbsp;
								<input type="radio"  value="E" name='re_divr_cd'  class="trans" >&nbsp;&nbsp;Expense</td>
							</tr>
							</table></td>
						
						<td width="38">VVD</td>
	                    <td><input type="text" name="vvd" style="width:90;text-align:left" class="input" value="" maxlength='10' dataformat="engup" style="ime-mode:disabled"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
							<td width="45">Item</td>
							<td width="120"><script language="javascript">ComComboObject('jo_stl_itm_cd2', 1, 110, 0, 1);</script></td>				
							<td width="45">Trade</td>
							<td width="100"><script language="javascript">ComComboObject('trd_cd2', 1, 70, 0, 0);</script></td>
							<td width="34">Lane</td>
							<td width="95"><script language="javascript">ComComboObject('rlane_cd2', 1, 70, 0, 0);</script></td>
							<td width="45">Carrier</td>
							<td width="95"><script language="javascript">ComComboObject('jo_crr_cd2', 1, 60, 0, 1);</script></td>																													
							<td width="190">
									<table class="search_sm" border="0" style="width:180">
									<tr class="h23">
										<td width="100%">&nbsp;<input type="checkbox" name="ous_yn" id="ous_yn" class="trans" value="N" unchecked>OUS&nbsp;&nbsp;
																	    <input type="checkbox" name="rf_yn" id="rf_yn" class="trans" value="N" unchecked>R/F&nbsp;
																        <input type="checkbox" name="dg_yn" id="dg_yn" class="trans" value="N" unchecked>OTH														        
										</td>
									</tr>
									</table>
							</td>
							<td width="*">
									<table class="search_sm" border="0" style="width:30">
									<tr class="h23">
										<td width="100%">&nbsp;<input type="checkbox" name="sublet_yn" id="sublet_yn" class="trans" value="N" unchecked>Sublet&nbsp;&nbsp;
										</td>
									</tr>
									</table>
							</td>					
					</tr>
				</table>		
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
				
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 			
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table> 			
			<!-- Grid (E) -->

			<!--  Grid_button (S) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btn_copy" name="btn_copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>				
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btn_add" name="btn_add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%"" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btn_delete" name="btn_delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn1_Retrieve" name="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn1_New" name="btn1_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn1_save" name="btn1_save" auth="C">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="180" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn1_sublet_save" name="btn1_sublet_save" auth="C">Sublet OUS/RF Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id=""btn1_Down_Excel name="btn1_Down_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- Copyright (S) -->
<!-- Copyright(E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>