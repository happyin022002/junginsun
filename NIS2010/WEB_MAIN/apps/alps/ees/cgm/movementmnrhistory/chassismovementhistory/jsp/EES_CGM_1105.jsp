<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1105.jsp
*@FileTitle : 개별 Chassis Movement 조회 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.26 최민회
* 1.0 Creation
*--------------------------------------------------
* History
* 2015.04.28 Chang Young Kim [CHM-201534113] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.event.EesCgm1105Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm1105Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String form_day         = "";
	String to_day		    = ""; 
	String eqNo             = "";
	
	String strOfc_id = "";
 
 
	Logger log = Logger.getLogger("com.hanjin.apps.MovementMnrHistory.ChassisMovementHistory");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfc_id = account.getOfc_cd();
	      
		
		
		event = (EesCgm1105Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		eqNo   		= StringUtil.xssFilter(request.getParameter("eq_no"));
		to_day      = StringUtil.xssFilter(request.getParameter("to_day"));
		
		
		form_day  = DateTime.getDateString().replace(".","");  
		if(to_day == null || to_day.trim().equals("")){
			to_day = DateTime.addDays(form_day.replace(".",""),-120);
		}
		
		if(eqNo == null){
			eqNo="";
		}
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
<title>Movement Inquiry by Chassis</title>
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
 
<form name="form" onkeyup="ComKeyEnter('search');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="calend1" value="<%=form_day%>">
<input type="hidden" name="calend2" value="<%=to_day%>">
<input type="hidden" name="s_usr_id" value="<%=strUsr_id %>" >
<input type="hidden" name="s_ofc_id" value="<%=strOfc_id %>" >


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
					<td width="70">Chassis No. </td>
					<td width="120"><input type="text" style="width:90;ime-mode:disabled" dataformat="engup" class="input1" name="eq_no" value="<%=eqNo%>" maxlength="10"></td>
					<td width="50">Period</td>
					<td width="" colspan="5">
					   <input type="text" style="width:80;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8' class="input"  name="str_mvmt_dt" value="">&nbsp;
					    ~&nbsp;
					   <input type="text" style="width:80;text-align:center;ime-mode:disabled"  maxlength='8' dataformat="ymd" class="input" value="" name="end_mvmt_dt">&nbsp;
					   <img class="cursor" name="btns_Calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				<tr class="h23">
					<td width="">Type/Size </td>
					<td width=""><input type="text" style="width:90;text-align:center;" class="input2" name="eq_tpsz_cd" value="" readonly="readonly"></td>
					<td width="">Term</td>
					<td width="110"><input type="text" style="width:80;text-align:center;" class="input2"  name="agmt_lstm_cd" value=""  value="" readonly="readonly"></td>
					<td width="33">Pool</td>
					<td width="120"><input type="text" style="width:70;text-align:center;" class="input2"  name="chss_pool_cd"  value="" readonly="readonly"></td>
					<td width="90">On-hire Date</td>
					<td width="120"><input type="text" style="width:80;text-align:center;" class="input2"   name="onh_dt"  value="" readonly="readonly"></td>
					<td width="50">Status</td>
					<td width=""><input type="text" style="width:80;text-align:center;" class="input2"   name="aciac_div_cd"  value="" readonly="readonly"></td>
				</tr>
			</table>
			
				<!--  biz_1  (E) -->
		</td></tr>
		</table>
			
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">
				<!--  biz_2  (S)  -->
				
				 <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Chassis Movement History</td></tr>
                </table>
				<!-- Grid 1 (S) -->
			    
				<table width="100%"  id="mainTable"> 
				   
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>  
				
			<!-- Grid 1(E) -->
			<table class="height_8"><tr><td></td></tr></table>
			<!-- Grid 2 (S) -->
			     <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Chassis Attach/Detach History</td></tr>
                </table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>  
				
			<!-- Grid 2(E) -->
				<!--  biz_2  (E)  -->
			</td></tr>
		</table>
				
		
			
		
						
				
		</td></tr>
		</table>	
			
			
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>