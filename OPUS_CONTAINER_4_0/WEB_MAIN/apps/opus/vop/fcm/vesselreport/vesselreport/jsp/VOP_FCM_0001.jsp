<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_0001.jsp
*@FileTitle : Vessel Report Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.12
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
* History 
* 2012.09.12 이혜민 CHM-201220162-01 [FCM] DSL Report 제거
* 2014.05.19 박다은 [CHM-201429883] [FCM] Departure Report Tap내 mail Function 신설 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.event.VopFcm0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.
	String fm_date = DateTime.addDays(DateTime.getDateString(),-7,"yyyy.MM.dd");
	String chk_date = DateTime.addDays(DateTime.getDateString(),-90,"yyyy.MM.dd");
	fm_date = fm_date.replace(".","-");
	chk_date = chk_date.replace(".","-");	
	Logger log = Logger.getLogger("com.clt.apps.vop.fcm.vesselreport.vesselreport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopFcm0001Event)request.getAttribute("Event");
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
<title>Fuel Consumption Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var gOfcCd = "<%=strOfc_cd%>";
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
<!-- 기본 필수 hidden -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 업무용 hidden -->
<input type="hidden" name="tmp_vsl_cd" value="">
<input type="hidden" name="tmp_crr_cd" value="">
<input type="hidden" name="inc_del_vsl" value="Y">
<input type="hidden" name="param_vsl_slan_cd">
<input type="hidden" name="param_vsl_cd">
<input type="hidden" name="param_vps_port_cd">
<input type="hidden" name="param_fm_dt">
<input type="hidden" name="param_to_dt">
<input type="hidden" name="chk_date" value="<%=chk_date%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="vsl_cd_arr">
<input type="hidden" name="date">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	
	<!-- Title, Navigation 고정 -->
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	
	<!-- 메인 화면 : biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
       	
       			<!-- 메인 조건부 : biz_1  (S) -->
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Period</td>
					<td class="stm">&nbsp;<input type="text" name="fm_dt" style="width:80;" class="input1" caption="Period FM" dataformat="ymd" size="10" maxlength="8" fulfill required>&nbsp;
					<img class="cursor" name="btns_calendarfm" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;&nbsp;&nbsp;<input type="text" name="to_dt" style="width:80;" class="input1" caption="Period To" dataformat="ymd" size="10" maxlength="8" fulfill required>&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarto"></td>
					<td width="40">&nbsp;Lane</td>
					<td width="100">
						<script language="javascript">ComComboObject('vsl_slan_cd',1,70,0,0);</script>
					</td>
					<td width="80">Vessel</td>
					<td width="100" class="stm"><script language="javascript">ComComboObject('vsl_cd',1,80,0,0);</script></td>
					<td width="30">Port</td>
					<td width="200"><script language="javascript">ComComboObject('vps_port_cd',1,80,0,0);</script></td>
					
					<td width="60">Direction</td>  
					<td width="50"><script language="javascript">ComComboObject('skd_dir_cd',1,50,0,0);</script></td>
				</table>
				
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_8"><tr><td colspan="8"></td></tr></table>	

		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 

<!--TAB Departure Report (S) -->
<div id="tabLayer" style="display:inline">
		
		<table class="search"> 
       	<tr><td class="bg">
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td>
								<table border="0">
									<tr>
										<td>
										<table width="380">
										<tr><td>&nbsp;</td></tr>
										<tr><td>
										<!--시트-->
										<script language="javascript">ComSheetObject('t1sheet1');</script></td></tr></table></td>
										<td><table style="width:8px; height:50;"><tr><td></td></tr></table></td>
										<td>
										<table width="245"><tr><td>Not Received</td></tr>
										<tr><td>																					
										<!--시트-->
										<script language="javascript">ComSheetObject('t1sheet2');</script></td></tr></table></td>
										<td><table style="width:8px;height:50;"><tr><td></td></tr></table></td>
										<td>
										<table width="345"><tr><td>Mismatched</td></tr>
										<tr><td>									
										<!--시트-->
										<script language="javascript">ComSheetObject('t1sheet3');</script></td></tr></table></td>
									</tr>
								</table>
								<table width="640" class="button" border="0" cellpadding="0" cellspacing="0" > 
		       						<tr><td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0"><tr>
										<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn2_mail">Mail</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
										</tr>
										</table>
									</td></tr>
								</table>
							</td>
						</tr>
					</table> 
				<!-- Grid (E) -->
			</td></tr>
		</table>	
	<!--biz page (E)-->
	
</div>
<!--TAB Departure Report (E) -->


<!--TAB Noon Report (S) -->
<div id="tabLayer" style="display:none">
		
		<table class="search"> 
       	<tr><td class="bg">
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td>
								<table>
									<tr>
										<td>
										<table width="360">
										<tr><td>&nbsp;</td></tr>
										<tr><td>
										<!--시트-->
										<script language="javascript">ComSheetObject('t2sheet1');</script></td></tr></table></td>
										<td><table style="width:8px;"><tr><td></td></tr></table></td>
										<td>
										<table width="275"><tr><td>Not Received</td></tr>
										<tr><td>																					
										<!--시트-->
										<script language="javascript">ComSheetObject('t2sheet2');</script></td></tr></table></td>
										<td><table style="width:8px;"><tr><td></td></tr></table></td>
										<td>
										<table width="335"><tr><td>Mismatched</td></tr>
										<tr><td>									
										<!--시트-->
										<script language="javascript">ComSheetObject('t2sheet3');</script></td></tr></table></td>
									</tr>
								</table>
							</td>
						</tr>
					</table> 
				<!-- Grid (E) -->
			</td></tr>
		</table>					
	<!--biz page (E)-->
	
</div>
<!--TAB Noon Report (E) -->

<!--TAB AB-Log (S) -->
<div id="tabLayer" style="display:none">
		
		<table class="search"> 
       	<tr><td class="bg">
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td>
								<table>
									<tr>
										<td>
										<table width="350">
										<tr><td>&nbsp;</td></tr>
										<tr><td>
										<!--시트-->
										<script language="javascript">ComSheetObject('t3sheet1');</script></td></tr></table></td>
										<td><table style="width:8px;"><tr><td></td></tr></table></td>
										<td>
										<table width="285"><tr><td>Not Received</td></tr>
										<tr><td>																					
										<!--시트-->
										<script language="javascript">ComSheetObject('t3sheet2');</script></td></tr></table></td>
										<td><table style="width:8px;"><tr><td></td></tr></table></td>
										<td>
										<table width="335"><tr><td>Mismatched</td></tr>
										<tr><td>									
										<!--시트-->
										<script language="javascript">ComSheetObject('t3sheet3');</script></td></tr></table></td>
									</tr>
								</table>
							</td>
						</tr>
					</table> 
				<!-- Grid (E) -->
			</td></tr>
		</table>					
	<!--biz page (E)-->
	
</div>
<!--TAB AB-Log (E) -->

<!--TAB ROB/Month End (S) -->
<div id="tabLayer" style="display:none">
		
		<table class="search"> 
       	<tr><td class="bg">
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td>
								<table>
									<tr>
										<td>
										<table width="350">
										<tr><td>&nbsp;</td></tr>
										<tr><td>
										<!--시트-->
										<script language="javascript">ComSheetObject('t4sheet1');</script></td></tr></table></td>
										<td><table style="width:8px;"><tr><td></td></tr></table></td>
										<td>
										<table width="285"><tr><td>Not Received</td></tr>
										<tr><td>																					
										<!--시트-->
										<script language="javascript">ComSheetObject('t4sheet2');</script></td></tr></table></td>
										<td><table style="width:8px;"><tr><td></td></tr></table></td>
										<td>
										<table width="335"><tr><td>Mismatched</td></tr>
										<tr><td>									
										<!--시트-->
										<script language="javascript">ComSheetObject('t4sheet3');</script></td></tr></table></td>
									</tr>
								</table>
							</td>
						</tr>
					</table> 
				<!-- Grid (E) -->
			</td></tr>
		</table>					
	<!--biz page (E)-->
	
</div>
<!--TAB ROB/Month End (E) -->

    
</td></tr>
</table>

  	
	<!-- 메인 화면 바깐쪽 화면 하단 버튼 부 -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>		
    <!--Button (E) -->
    
</form>			
</body>
</html>