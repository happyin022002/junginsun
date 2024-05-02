<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0027.jsp
*@FileTitle : Actual SKD Input Ratio Inquiry (R/Lane)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.08.03 정진우
* 1.0 Creation
*
* History
* 2010.12.23 선CSR 진마리아 Actual SKD Input Ratio Report 로직 변경
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2011.08.09 김민아    CHM-201112647-01 Actual SKD input Ratio Tab 및 조회 로직 변경 요청
* 2013.09.05 정상기    CHM-201326469 [VSK] Actual SKD Input Ratio Report - 조회조건 OPR code 추가
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVsk0027Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0027Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ActualScheduleManagement.ActualScheduleMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0027Event)request.getAttribute("Event");
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
<title>Actual SKD Input Ratio Inquiry (R/Lane)</title>
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
<input type="hidden" name="pagerows" value="100">
<input type="hidden" name="page_no" value="1">
<input type="hidden" name="loc_cd">
<input type="hidden" name="country_cd">
<input type="hidden" name="rcv_dt">
<input type="hidden" name="rcv_seq">
<input type="hidden" name="inc_del_vsl" value="Y">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
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
						<td width="62">Period</td>
						<td width="265"><input type="text" name="fm_dt" dataformat="ymd" style="width:80;text-align:center;" class="input1" value="" maxlength="8" size="10">&nbsp;<img name="btn_cal1" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
										&nbsp;&nbsp;
									 	~
									 	&nbsp;&nbsp;
									 	<input type="text" name="to_dt" dataformat="ymd" style="width:80;text-align:center;" class="input1" value="" maxlength="8" size="10">&nbsp;<img name="btn_cal2" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
						</td>
						
						<td width="65">CTRL H/Q</td>
						<td width="170"><script language="javascript">ComComboObject('vskd_port_rhq_cd',1,80,1,0);</script>&nbsp;<script language="javascript">ComComboObject('sls_ofc_cd',1,70,1,0);</script></td>
						<td width="55">Port</td>
						<td width="175"><input type="text" name="vps_port_cd" style="width:50;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="5" onfocus="this.select();">&nbsp;<img name="btn_port" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<script language="javascript">ComComboObject('tml_cd',2,80,1,0);</script></td>
						<td width="60">Result</td>
						<td width=""><script language="javascript">ComComboObject('scs_flg',1,60,1,0);</script></td>
					</tr>	
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="220">
							<table border="0" style="width:;" class="search_sm2"> 
								<tr class="h23">
									<td width="">
										<input type="radio" name="vsl_svc_tp_cd" value="" class="trans" checked="checked">&nbsp;All&nbsp;
										<input type="radio" name="vsl_svc_tp_cd" value="T" class="trans">&nbsp;Trunk&nbsp;
										<input type="radio" name="vsl_svc_tp_cd" value="O" class="trans">&nbsp;Off-lane&nbsp;
									</td>
								</tr>
							</table>
						</td>
						
						<td width="30">OPR</td>
						<td width="95"><input type="text" name="crr_cd" style="width:45;text-align:center;ime-mode:disabled" class="input" maxlength="3">&nbsp;<img src="img/btns_search.gif" name="btns_search_crr" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						
						<td width="70">VVD</td>
						<td width="195"><input type="text" name="vsl_cd" style="width:50;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_voy_no" style="width:50;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_dir_cd" style="width:20;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="1" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_vvd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="68">IMO No.</td>
						<td width="180"><input type="text" name="lloyd_no" style="width:130;text-align:left;ime-mode:disabled;" class="input1" value="" maxlength="20" onfocus="this.select();"></td>
						<td width="65">Call Sign</td>
						<td width=""><input type="text" name="call_sgn_no" style="width:130;text-align:left;ime-mode:disabled;" class="input1" value="" maxlength="15" onfocus="this.select();"></td>
					</tr>	
				</table>
			</td></tr>
		</table>
				<!--  biz_1   (E) -->
		<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Tab ) (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
       		<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1');</script>
			</td></tr>
		</table>
		<!-- Tab ) (E) -->

<!--TAB R/Lane (S) -->

<div id="tabLayer" style="display:inline">

				<!--  biz_2  (S) -->
	<table class="search"> 
       	<tr><td class="bg">
				<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet1');</script>
					</td>
				</tr>
			</table>
				<!-- Grid (E) -->
		</td></tr>
	</table>

	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_t1Retrieve">Retrieve</td>
									<td class="btn1_right"></td></tr>
							</table></td>
						<!-- 	
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_t1RLaneRegist">R/Lane Regist</td>
									<td class="btn1_right"></td></tr>
							</table>
						</td>
						 -->
					</tr>
				</table>
			</td>
		</tr>
	</table>
    <!--Button (E) -->

</div>

<!--TAB R/Lane (E) -->


<!--TAB Input Ratio (S) -->

<div id="tabLayer" style="display:none">

				<!--  biz_2  (S) -->
	<table class="search"> 
       	<tr><td class="bg">				
				<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet1');</script>
					</td>
				</tr>
			</table>
				<!-- Grid (E) -->
						
				<!--  biz_2   (E) -->
		</td></tr>
	</table>

	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		<tr>
			<td class="btn1_bg">
	    		<table border="0" cellpadding="0" cellspacing="0">
	    			<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t2Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td><td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t2New">New</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td class="btn1_line"></td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t2DownExcel">Down Excel</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
    <!--Button (E) -->

</div>

<!--TAB Input Ratio (E) -->


<!--TAB Detail (S) -->

<div id="tabLayer" style="display:none">

				<!--  biz_2  (S) -->
	<table class="search"> 
       	<tr><td class="bg">
       		<!-- 
			<table style="width:100%"> 
				<tr class="h23">
					<td width="70%"></td>
					<td width="30%">
						<table style="width:150" border="0" class="search" align="right"> 
							<tr class="h23">
								<td width="90">Option Hours</td>
								<td width="" align="center"><input type="text" name="opt_hrs" style="width:50;ime-mode:disabled;text-align:center;" class="input" value="0" maxlength="2"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			 -->
				<!-- Grid  (S) -->
			<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t3sheet1');</script>
					</td>
				</tr>
			</table>
				<!-- Grid (E) -->
						
				<!--  biz_2   (E) -->
		</td></tr>
	</table>

	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		<tr>
			<td class="btn1_bg">
	    		<table border="0" cellpadding="0" cellspacing="0">
	    			<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t3Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t3New">New</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td class="btn1_line"></td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t3DownExcel">Down Excel</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
    <!--Button (E) -->

</div>

<!--TAB Detail (E) -->


<!--TAB Uncompleted Report (S) -->

<div id="tabLayer" style="display:none">

				<!--  biz_2  (S) -->
	<table class="search"> 
       	<tr><td class="bg">				
				<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t4sheet1');</script>
					</td>
				</tr>
			</table>
				<!-- Grid (E) -->
						
				<!--  biz_2   (E) -->
		</td></tr>
	</table>

	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		<tr>
			<td class="btn1_bg">
	    		<table border="0" cellpadding="0" cellspacing="0">
	    			<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t4Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t4New">New</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td class="btn1_line"></td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t4DownExcel">Down Excel</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
    <!--Button (E) -->

</div>

<!--TAB Uncompleted Report (E) -->
<!--TAB EDI SKD Monitoring (S) -->

<div id="tabLayer" style="display:none">

				<!--  biz_2  (S) -->
	<table class="search"> 
       	<tr><td class="bg">				
				<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t5sheet1');</script>
					</td>
				</tr>
			</table>
				<!-- Grid (E) -->
						
				<!--  biz_2   (E) -->
		</td></tr>
	</table>

	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		<tr>
			<td class="btn1_bg">
	    		<table border="0" cellpadding="0" cellspacing="0">
	    			<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t5Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t5New">New</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td class="btn1_line"></td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t5DownExcel">Down Excel</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t5Retry">Retry</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" style="display: none">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
    <!--Button (E) -->

</div>

<!--TAB EDI SKD Monitoring (E) -->
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>