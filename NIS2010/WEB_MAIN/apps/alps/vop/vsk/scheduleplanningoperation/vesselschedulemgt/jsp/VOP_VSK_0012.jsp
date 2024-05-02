<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0012.jsp
*@FileTitle : Long Range SKD  Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.01 유혁
* 1.0 Creation
*
* History
* 2010.12.27 진마리아 CHM-201007036 Down Excel Format 변경 요청건
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2011.08.09 진마리아 CHM-201111568-01 [VOP-VSK] LRS SKD inquiry 화면 및 로직 수정 요청건
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0012Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0012Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String eml 				= "";
	String popYn			= "";
	String selectYn		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.scheduleplanningoperation.vesselschedulemgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		eml = account.getUsr_eml();


		event = (VopVsk0012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		popYn	= request.getParameter("pop_mode") == null ? "N" : "Y";
		selectYn	= request.getParameter("select_mode") == null ? "N" : "Y";

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Long Range SKD  Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var conds = {
		pop_yn : "<%=popYn%>",
		select_yn : "<%=selectYn%>"
	}

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

<!--  개발자작업 -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_slan_cd">
<input type="hidden" name="tmp_vsl_slan_cd">
<input type="hidden" name="tmp_vsl_cd">

<input type="hidden" name="com_subject">
<input type="hidden" name="com_content">
<input type="hidden" name="com_from" value="<%=eml%>">

<input type="hidden" name="pop_yn" value="<%=popYn %>">
<input type="hidden" name="select_yn" value="<%=selectYn %>">

<input type="hidden" name="inc_del_vsl" value="Y">

<% if(popYn.equals("Y")){ %>
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Long Range SKD  Inquiry  </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	</td></tr>
</table>
<% }else{ %> 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
<% } %>
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
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
				<td>
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td>
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_EMail">E-Mail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- 
				<td class="btn1_line"></td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SendMail">Send Mail</td>
					<td class="btn1_right"></td>
				</tr>
				</table></td>
				-->
				</tr>
				</table>
			</td></tr>
		</table>	
    	<!--Button (E) -->
    	
    	<!--biz page 1 (S)-->
		<table class="search">
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="70">Period</td>   
					<td width="632">
						<input type="text" name="start_year" style="width:40;text-align:center;" class="input1" value="" tabindex="2" maxlength="4" dataformat="yyyy">
						<img class="cursor" name="btns_back1" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle">
						<img class="cursor" name="btns_next1" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<select name="start_qt" style="width:45;" class="input1" tabindex="3" >
						<option value="1">1/4</option>
						<option value="2">2/4</option>
						<option value="3">3/4</option>
						<option value="4">4/4</option></select>&nbsp<input type="text" name="start_date" style="width:80;text-align:center;" class="input1" dataformat="ymd" caption="시작일" tabindex="4" maxlength="8" size="10" cofield="end_date">
						<img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
						
						 <input type="text" style="width:15;text-align:center;background-color:#f3f2f8;border:0px" value="~" readonly tabindex="-1">
						 
						<input type="text" name="end_year" style="width:40;text-align:center;" class="input1" tabindex="5" maxlength="4" dataformat="yyyy">
						<img class="cursor" name="btns_back2" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle">
						<img class="cursor" name="btns_next2" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<select name="end_qt" style="width:45;" class="input1" tabindex="6">
						<option value="1">1/4</option>
						<option value="2">2/4</option>
						<option value="3">3/4</option>
						<option value="4">4/4</option></select>&nbsp;<input type="text" name="end_date" style="width:80;text-align:center" class="input1" dataformat="ymd" caption="종료일" tabindex="7" maxlength="8" size="10" cofield="start_date"> <img class="cursor" name="btns_calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
						</td>
					<td width="90">Created Date</td>
					<td width="200" align="right"><input type="text" name="cre_dt" style="width:110;text-align:center"  class="input2" value="" readonly>&nbsp;<input type="text" name="cre_usr_id" style="width:80;text-align:center" class="input2"  value="" readonly></td>
					<td width="0">&nbsp;</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="70">Lane Code</td>   
					<td width="100">
						<span id="span_vsl_slan_cd_1" style="display:block">
							<input type="text" name="vsl_slan_cd_1" style="width:40;text-align:center;ime-mode:disabled" class="input" tabindex="1" maxlength="3">
							<img class="cursor" name="btns_search1" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
						</span>
						<span id="span_vsl_slan_cd_2" style="display:none">
							<select name="vsl_slan_cd_2" tabindex="1"></select>
						</span>
					</td>
					<td width="74">Vessel Code</td>   
					<td width="99">
					<input type="text" name="vsl_cd" style="width:45;text-align:center;ime-mode:disabled" value="" class="input" tabindex="8" maxlength="4">
					<img class="cursor" name="btns_search2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					
					<td width="359">
						<table border="0" style="width:160;" class="search_sm2"> 
						<tr class="h23">
						<td width="3"></td>
						<td width="150">
						<input name="unit_tp" type="radio" value="1" class="trans">By Port&nbsp;<input name="unit_tp" type="radio" value="2" class="trans" checked>By Yard
						</td>
						</tr></table>
					</td>
					<!-- <td width="80">Port/Yard</td>
					<td width="200"><input name="unit_tp" type="radio" value="1" class="trans">By Port&nbsp;<input name="unit_tp" type="radio" value="2" class="trans" checked>By Yard</td>
 					
					<td width="20"></td>-->	
					<td width="90">Updated Date</td>
					<td width="200" align="right"><input type="text" name="upd_dt" style="width:110;text-align:center"  class="input2" value="" readonly>&nbsp;<input type="text" name="upd_usr_id" style="width:80;text-align:center" class="input2"  value="" readonly></td>
					<td width="0">&nbsp;</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
			</td></tr>	
		</table>
		<!--biz page 1 (E)-->
				
		<table class="height_8"><tr><td></td></tr></table>
		
		<!--biz page  2(S)-->
		<table class="search"> 
       	<tr><td class="bg">
       	
			<div id="sheet_div" style="width:100%">
				<table width="100%">
					<tr><td style="background-color: yellow;text-align: center;height:18;width:50">Delay</td>
					<td style="width:5">&nbsp;</td><td style="background-color: lightgreen;text-align: center;width:50">Skip</td>
					<td style="width:5">&nbsp;</td><td style="background-color: gray;text-align: center;width:50">Reverse</td>
					<td style="width:350">&nbsp;</td><td style="text-align:center;width:65;font-weight:bold">Phase out Reason</td>
					<td style="width:5">&nbsp;</td><td style="background-color: CYAN;text-align: center;width:60">Dock</td>
					<td style="width:5">&nbsp;</td><td style="background-color: red;text-align: center;width:60">Redelivery</td>
					<td style="width:5">&nbsp;</td><td style="background-color: brown;text-align: center;width:60">Idling</td>
					<td style="width:5">&nbsp;</td><td style="background-color: orange;text-align: center;width:60">Other</td>
					<td>&nbsp;</td><td align="right">
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
				    </td></tr>
				</table>
				<table class="height_10"><tr><td></td></tr></table>
			</div>
				
			
				
			<!--  biz_1  (S) -->
			<!--  Remark Grid  -->
			<table width="100%"  id="mainTable">
			<tr><td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
			</td></tr>
			</table>	
			<!--  biz_1   (E) -->
			
       		<!--  biz_1  (S) -->
			<!--  Remark Grid  -->
			<table width="100%"  id="mainTable">
			<tr><td width="100%">
			<script language="javascript">ComSheetObject('sheet2');</script>
			</td></tr>
			</table>	
			<!--  biz_1   (E) -->
			
						<!--  biz_1  (S) -->
			<!--  Remark Grid  -->
			<table width="100%"  id="mainTable">
			<tr><td width="100%">
			<script language="javascript">ComSheetObject('sheet3');</script>
			</td></tr>
			</table>	
			<!--  biz_1   (E) -->
				
		</td></tr>
		</table>
		<!--biz page  2(S)-->
	
	</td></tr>
</table>

<div id="popLayer" style="display:none">
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
      		<tr><td class="btn3_bg">
	    	<table border="0" cellpadding="0" cellspacing="0">
	    	<tr>
			<%
				if("Y".equals(selectYn)){ 
			%>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_OK">OK</td>
				<td class="btn1_right"></td>
				</tr>	</table>
			</td>
			<%	} %>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Close">Close</td>
				<td class="btn1_right"></td>
				</tr></table>
			</td></tr>
			</table>
		</td></tr>
	</table>
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</div>

</form>
</body>
</html>