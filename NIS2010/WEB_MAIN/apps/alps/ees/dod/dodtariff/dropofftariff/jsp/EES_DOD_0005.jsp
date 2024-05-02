<%
/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EES_DOD_0005.js
 *@FileTitle : Drop Off Tariff Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.11.02
 *@LastModifier : YOON, Yong-Sang
 *@LastVersion : 1.0
 * 2015.11.02 YOON, Yong-Sang
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
<%@ page import="com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.event.EesDod0005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDod0005Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesDod0005Event)request.getAttribute("Event");
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
<title>CBF for Own Booking (Creation)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var userId = '<%=strUsr_id%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onload="javascript:setupPage();">

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="TRSP_SO_EQ_KIND" 	value="">
<input type="hidden" name="s_trf_div_cd" 	value="">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">	
	<tr>
		<td valign="top">
		
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_New" id="btn_New">New</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_Excel" id="btn_Excel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							
							<!-- Repeat Pattern -->
						</tr></table>
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->
			<!--biz page (S)-->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:940;">
							<tr class="h23">
								<td width="90">Country</td>
								<td width="90">
									<input name="s_cnt_cd" type="text" class="input" value="" caption="Country"  maxlength="2" dataformat="engup" style="width:25px;ime-mode:disabled">
								</td>
								<td width="100">Effective Date</td>
								<td width="220">
									<input type="text" style="width:80;text-align:center;" class="input" size="8" maxlength="10"  onKeyPress='ComKeyOnlyNumber(window);' onKeyUp="pointAutoMove(this.value);" onKeyDown="dod_isNumD(this, 'Y');" onBlur="dod_validateDateObj(this);" name="s_frm_eff_dt"  dataformat="ymd" cofield="s_to_eff_dt" caption="start date">
									~&nbsp;<input type="text" style="width:80;text-align:center;" class="input" size="8" maxlength="10" onKeyPress='ComKeyOnlyNumber(window);' onKeyDown="dod_isNumD(this, 'Y');" onBlur="dod_validateDateObj(this);" name="s_to_eff_dt"  dataformat="ymd" cofield="s_frm_eff_dt" caption="end date">
									<img src="img/btns_calendar.gif" class="cursor" name="btn_Calendar" width="19" height="20" alt="" border="0" align="absmiddle" >
								</td>
								<td width="110" class="spcLayer" style="visibility:hidden;" colspan='4'>Actual Customer</td>
								<td width="270" class="spcLayer" style="visibility:hidden;" colspan='3'>
									<input class="input" name="s_cust_cd" type="text" style="width:85 ; text-transform:uppercase;" dataformat="engup" value="">
									<input class="input2" name="s_cust_nm" type="text" style="width:147" value="" dataformat="engup" readonly>
									<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='btn_customer' >
								</td>
							</tr>
							<tr class="h23">
								<td>RTN-Location</td>
								<td><input name="s_rtn_loc_cd" type="text" style="width:60;text-align: center;ime-mode:disabled" maxlength="5" dataformat="engup"></td>						
								<td>Yard</td>
								<td style="padding:2;">
									<script language="javascript">ComComboObject('s_yd_sfx_cd', 1, 48, 0);</script>									
								</td>
								<td class="spcLayer" style="visibility:hidden;"><input type="radio" class="trans"  name="s_no_type" value="S" checked>
								<td class="spcLayer" style="visibility:hidden;">S/C No.</td>
								<td class="spcLayer" style="visibility:hidden;"><input type="radio" class="trans"  name="s_no_type" value="R">
								<td class="spcLayer" style="visibility:hidden;">RFA No.</td>
								<td width="135" class="spcLayer" style="visibility:hidden;"><input name="s_no" type="text" style="width:85;text-align: center;ime-mode:disabled" maxlength="10" dataformat="engup"></td>
								<td width="40" class="spcLayer" style="visibility:hidden;">Exemption</td>
								<td width="20" class="spcLayer" style="visibility:hidden;"><input type="checkbox" class="trans"  name="s_trf_expt_flg"></td>							
							</tr>
						</table>
					</td>
				</tr>
			</table>		
			
   			<table class="height_8"><tr><td></td></tr></table>
			<!-- Tab (S) -->
    			<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
			<!-- Tab (E) -->			
			<!--  Tab_1 (S) -->
			<div id="tabLayer" style="display:inline">
    					<table class="search">
        					<tr>
					<td class="bg" valign="top">		
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t1sheet1');</script>
								</td>					
							</tr>
						</table>
						<!-- Grid (E) -->
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
    									<tr>
    										<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									    <tr>														
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_rowadd" id="btn_rowadd">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>		
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_rowcopy" id="btn_rowcopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_Delete">Row Del</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_Save">Save</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_expire">No Use</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
 								<!-- Button_Sub (E) --> 
					</td>
				</tr>
			</table>
						</div>
			<!--  Tab_1 (E) -->			
			<!--  Tab_2 (S) -->
			<div id="tabLayer" style="display:none">
		        <table class="search">
		            <tr>
						<td class="bg" valign="top">
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t2sheet1');</script>
									</td>
								</tr>
							</table>
							<!--  Button_Sub (S) -->
							<table width="100%" class="button"> 
			       				<tr>
			       					<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
										    <tr>															
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_rowadd2" id="btn_rowadd2">Row Add</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_rowcopy2" id="btn_rowcopy2">Row Copy</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_Delete2">Row Del</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_Save2">Save</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_expire2">No Use</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
			    			<!-- Button_Sub (E) --> 
						</td>
					</tr>
				</table>
		    </div>						
						<!--  Tab_2 (E) -->
			<!-- Tab BG Box(E) -->
			<!--biz page (E)-->
			<table class="height_10"><tr><td></td></tr></table>
		</td>
	</tr>
</table>
<table width="100%" style="display:none"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet99');</script>
		</td>
	</tr>
</table> 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>