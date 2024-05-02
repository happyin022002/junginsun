<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VOP_VSK_0030.jsp
*@FileTitle : 
*Open Issues :
*Change history : 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* History
=========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0030Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0030Event event 			= null;		//PDTO(Data Transfer Object including Parameters)
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

		event = (VopVsk0030Event)request.getAttribute("Event");
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
						<td width="75">Period</td>
						<td width="235">
							<input type="text" name="drw_fm_dt" dataformat="ym" caption="시작년월" maxlength="6" size="10" cofield="drw_fm_dt" style="width:60;text-align:center;" class="input1" value="" readonly="readonly">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar_s" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;~&nbsp;
							<input type="text" name="drw_to_dt" dataformat="ym"  caption="종료년월" maxlength="6" size="10" cofield="drw_to_dt" style="width:60;text-align:center;" class="input1" value="" readonly="readonly">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar_e" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						<td width="580">
							<table class="search" border="0" style="width:230;" > 
							<tr class="h23">
								<td width="75">VSL OPR</td><td><input type="radio" name="drw_crr_cd" class="trans" value="A" checked="checked">ALL&nbsp;<input type="radio" name="drw_crr_cd" class="trans" value="H">SML&nbsp;<input type="radio" name="drw_crr_cd" class="trans" value="O">Other</td>
							</tr>	
							</table>
						</td>
						<td>&nbsp;</td>				
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;height:6;"><tr><td></td></tr></table> 
				
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="77">Port Pair</td>
						<td width="228"><script language="javascript">ComComboObject('drw_pol_cd',1,80,1);</script>&nbsp; ~ &nbsp;<script language="javascript">ComComboObject('drw_pod_cd',1,80,1);</script></td>
						
						<td width="80">Lane Code</td>
						<td width="110"><input type="text" style="width:50;ime-mode:disabled;text-align:center" name="drw_slan_cd" value = "" class="input1" maxlength="3" dataformat="uppernum" value="">&nbsp;<img src="img/btns_search.gif" name="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" tabindex="1">&nbsp;</td>
	 	                <td width="75">Design TEU </td>
	 	                <td width="80">
	 	                 <select name = "drw_teu" style="width:50px;" tabindex="2">
		                    <option selected value=""> </option> 
		                    <option value="10000"> 10000</option>
		                    <option value="20000"> 20000</option>
		                    <option value="30000"> 30000</option>
		                    <option value="40000"> 40000</option>
		                  </select>
		                </td>
		                	<!-- td  width="120"><script language="javascript">ComComboObject('teu',1,60,0,1);</script></td-->
						<td width="35">Option</td>   
						<td width="260" style="width: 180px">
						    <input type="text" name="drw_opt" value = "" tabindex="4" maxlength="3" style="width:40;text-align:center;ime-mode:disabled;text-align:center;" class="input1">&nbsp;hrs&nbsp;
						</td>
						<td>&nbsp;</td>
					</tr>
				</table>
				
				 
				<table class="search" border="0" style="width:979;"><tr><td colspan="8"></td></tr></table>
				
				<!--  grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!--  grid   (E) -->
				<!--biz page (E)-->
				<!-- Report Information (S) -->
					<table class="search" border="0"><tr><td class="height_8"></td></tr></table>
					<table border="0" style="width:100%; background-color:white;" class="grid2"> 
						<tr>
							<td width="80" class="tr2_head2">Total</td>
							<td width="65"><input type="text" style="width:100%;text-align:right;" class="noinput" name="tot" value="" readOnly="readonly"></td> 
							<td width="85" class="tr2_head2">On-Time</td>
							<td width="65"><input type="text" style="width:100%;text-align:right;" class="noinput" name="tot_ontime" value="" readOnly="readonly"></td>
							<td width="80" class="tr2_head2">Delay</td>
							<td width="65"><input type="text" style="width:100%;text-align:right;" class="noinput" name="tot_delay" value="" readOnly="readonly"></td>
							<td width="90" class="tr2_head2">Skip</td>
							<td width="65"><input type="text" style="width:100%;text-align:right;" class="noinput" name="tot_skip" value="" readOnly="readonly"></td>
							<td width="85" class="tr2_head2">On-Time Ratio</td>
							<td width="65"><input type="text" style="width:100%;text-align:right;" class="noinput" name="tot_ratio" value="" readOnly="readonly"></td>
							<td width="100" class="tr2_head2">AVG. Delay(hrs)</td>
							<td width="65"><input type="text" style="width:100%;text-align:right;" class="noinput" name="tot_avg" value="" readOnly="readonly"></td>
						</tr>
					</table>
				<!-- Report Information (E) -->
				</td>
			</tr>
			</table>
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" id="btn_Retrieve" name="btn_Retrieve" type=" ">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_New">New</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Save">Save</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>	
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Delete">Delete</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td class="btn1_line"></td> 					
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_PortSetUp">Port Setup</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_TradeSetUp">Trade Setup</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_DownExcel">Down Excel</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
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
