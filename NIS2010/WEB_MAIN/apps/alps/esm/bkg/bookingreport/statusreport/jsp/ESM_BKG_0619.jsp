<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0619.jsp
*@FileTitle : Outbound Container Movement Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.01 김기종
* 1.0 Creation
* 2011.11.22 변종건 [CHM-201113464-01] 동일 CNTR가 다른 VVD로 Double Booking시-IRR조기 감지 Report시스템 구축
* 2012.04.12 변종건 [CHM-201217103-01] O/B CNTR MVMT Status > Summary by yard/ type /size 탭에도 trade/ sub trade/ lane 옵션 추가
* 2013.02.25 김진주 [CHM-201322909] [O/B Container movement status] multiple office 기능 추가 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0619Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0619Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.StatusReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0619Event)request.getAttribute("Event");
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
<title>Outbound Container Movement Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="O/B Container Movement Status">
<input type="hidden" name="com_mrdBodyTitle" value="O/B Container Movement Status">
<input type="hidden" name="combo_flg" value="">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->   
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title" style=&quot;color:red&quot;>&nbsp;O/B Container Movement Status</span></td>
			</tr>
		</table>
			<!--Page Title, Historical (E)-->
	
			<!--biz page (S)-->
			<table class="search"> 
       			<tr>
       				<td class="bg">	
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="33">VVD</td>
									<td width="350" >
										<input type="text" name="vvd_sig" dataformat="engupnum" maxlength="9" class="input" style="width:80;" value="" onChange="javascript:searchLane(this);">&nbsp;
										<input type="text" name="slan_cd" dataformat="engup" maxlength="3" class="input2" style="width:35;" value="" readonly>&nbsp;
										<input type="text" name="vvd_idx" dataformat="engup" maxlength="3" class="input2" style="width:18;" value="" readonly>&nbsp;
										<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="javascript:getVvds();">&nbsp;
										<script language="javascript">ComComboObject('vvd', 1, 150, true, '');</script>
									</td>	
									<!-- >input type="text" name="vvd_cd1"  style="width:100;" class="input1" value="" style="ime-mode:disabled" dataformat="engupnum"  caption="VVD" maxlength="9" fullfill required >
									<img class="cursor" src="img/alps/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="javascript:getVvds();"-->
								<td width="90">
									<table class="search" border="0" style="width:130;"> 
										<tr class="h23">
											<td width="60">L/T
											
<div id="bkgOfcList" style="position: absolute; display: none;" >
	<table width="130" border="0"  cellpadding="0" cellspacing="0" >
		<tr>
			<td width = "100%"><script language="javascript">ComSheetObject('multiOfc');</script></td>
		</tr>
	</table>
	<table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
		<tr><td class="btn2_left"></td>
			<td class="btn2" id="ofc_list_add" name="ofc_list_add">&nbsp;Add&nbsp;</td>
			<td class="btn2_right"></td>
			<td class="btn2_left"></td>
			<td class="btn2" id="ofc_list_del" name="ofc_list_del">Del</td>
			<td class="btn2_right"></td>
			<td class="btn2_left"></td>
			<td class="btn2" id="ofc_list_ok" name="ofc_list_ok">OK</td>
			<td class="btn2_right"></td>
		</tr>
	</table>
</div>
											</td>
											
											<td class="stm">
											
												<input type="checkbox" name="chk_lt_type" value="L" class="trans" >Local&nbsp;&nbsp;&nbsp;
												<input type="checkbox" name="chk_lt_type" value="T" class="trans" >T/S&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
										</tr>
									</table>
								</td>
								<td width="30">POL</td>
								<td width="65"><input type="text" name="pol_cd" style="width:45;" class="input1" value="" style="ime-mode:disabled" dataformat="engupnum"  caption="POL" maxlength="5"  ></td>
								<td width="30">POR</td>
								<td width="65"><input type="text" name="por_cd" style="width:45;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum"  caption="POR" maxlength="5" ></td>  
								<td width="70">R/D Term</td>
								<td width="">
									<script language="javascript" >ComComboObject('rcv_term_cd', 1, 65, 1)</script>&nbsp;&nbsp;
									<!--<select name="rcv_term_cd" style="width:45;">
									<option value="0" selected>Y</option>
									<option value="1"></option>
									</select>
									-->
									&nbsp;
									<script language="javascript" >ComComboObject('de_term_cd', 1, 65, 1)</script>
									<!--<select name="de_term_cd" style="width:45;">
									<option value="0" selected>Y</option>
									<option value="1"></option>
									</select>
									--></td> 
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="55">BKG OFC</td>
								<td width="210" class="stm">
								<input type="text" name="bkg_ofc_cd"  style="width:65;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="BKG OFC" >
								<img src="img/alps/button/btns_multisearch.gif" align="absmiddle"  style="cursor:hand" name="btn_multi_ofc">
								(<input type="checkbox" name="ofc_inc_sub" value="Y" class="trans">Including Sub)
								</td> 
								<td width="40">Period</td>
								<td width=""><select name="period_flg" style="width:80;">
									<option value="B" selected>BKG Date</option>
									<option value="E">ETA Date</option>
									</select></td> 
								<td width="210">
									<input type="text" name="bkg_dt_fr" style="width:75;" class="input" value=""  dataformat="ymd" caption="BKG Start Date" maxlength="10" cofield="bkg_dt_to">
									~
									<input type="text" name="bkg_dt_to" style="width:75;" class="input" value=""    dataformat="ymd" caption="BKG End Date" maxlength="10" cofield="bkg_dt_fr">
									<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('BKG_DATE')"></td> 
								<td width="74">BKG Status</td>
								<td width="77">
									<script language="javascript">ComComboObject('bkg_sts_cd', 1, 65, 0,0,0);</script><!--
									
									<select name="bkg_sts_cd" style="width:65;">
									<option value="0" selected></option>
									<option value="1">All</option>
									</select>
								--></td> 
								<td width="60">BKG Kind</td>
								<td width="80">
									<script language="javascript">ComComboObject('xter_bkg_rqst_cd', 1, 65, 0,0,0);</script>
									<!--<select name="xter_bkg_rqst_cd"  style="width:65;">
									<option value="0" selected></option>
									<option value="1">All</option>
									</select>
								--></td> 
								<td width="70">EQ Confirm</td>
								<td width=""><select name="cntr_cfm_flg" style="width:40;">
									<option value="" selected>All</option>
									<option value="Y">Y</option>
									<option value="N">N</option>
									</select></td> 
								
							</tr>
						</table>
				
				
						<table style="height:5;"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="80">Cargo Type</td>
								<td width="200">
								<script language="javascript">ComComboObject('bkg_cgo_tp_cd', 1, 180, 0,0,0);</script>
								<!--<select name="bkg_cgo_tp_cd" style="width:65;">
									<option value="0" ></option>
									<option value="1"selected>All</option>
									<option value="1">Full</option>
									<option value="1">Empty</option>
									</select>
								--></td> 
								<td width="130">
									<input type="checkbox" name="chk_inc_clm"  value="Y" class="trans" onClick="chkIncClm()">Incl. CLM Info.</td> 
								<td width="65">Customer</td>
								<td width="270">
									<script language="javascript">ComComboObject('cust_tp_cd', 1, 90, 0,0,0);</script>&nbsp;
									<input type="text" name="cust_cnt_cd" style="width:30;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Country Code" maxlength="2" fullfill>
									<input type="text" name="cust_seq" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="num"  caption="Cust Seq" maxlength="6">
									<input type="text" name="cust_nm" style="width:70;" class="input" value="" style="ime-mode:disabled"  dataformat='custname' maxlength="20">
								</td>
								
								<td width="77">O/C Status</td>	 
								<td width="60"><select name="cnmv_sts_cd" style="width:50;">
									<option value="" selected>All</option>
									<option value="Y">Y</option>
									<option value="N">N</option>
									</select></td>
								<td width=""><input type="checkbox" name="chk_dup_vvd"  value="D" class="trans">Dup. VVD</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="55">Trade</td>
								<td width="80"><script language="javascript">ComComboObject("trd_cd", 2, 60, 0, 0, 0);</script></td>
								<td width="75">Sub Trade</td>
								<td width="80"><script language="javascript">ComComboObject("sub_trd_cd", 3, 50, 0, 0, 1);</script></td>
								<td width="42">Lane</td>
								<td width="100"><script language="javascript">ComComboObject("rlane_cd", 4, 75, 0, 0, 2, false);</script></td>
								<td width="50">Pre VVD</td>
								<td width="100"><input type="text" name="pre_1_vvd" style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum"  caption="Pre VVD" maxlength="9" fullfill></td> 
								<td width="50">Pre POL</td>
								<td width="70"><input type="text" name="pre_1_pol_cd" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum"  caption="Pre POL" maxlength="5" fullfill></td> 
								<td width="30">Yard</td>
								<td width=""><input type="text" name="org_yd_cd" style="width:55;" class="input" value="" style="ime-mode:disabled" dataformat="engupnum"  caption="Yard" maxlength="7" ></td> 
							</tr>
						</table>
					</td>
				</tr>
			</table>
	
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
	
			<!-- Tab ) (S) -->
   			<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
     			<tr>
     				<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td>
				</tr>
			</table>
			<!-- Tab ) (E) --> 
			<!--TAB  (S) -->
			
			<div id="tabLayer" style="display:inline">		
			<!-- Tab BG Box ) (S) -->		
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<!-- Grid  (S) -->
						<table width="920"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<!--  Button_Sub (S) -->
						
						<table width="100%" class="button" >
				       		<tr>
				       			<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="sButtonTable">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_EQHistory" id="btn_EQHistory">EQ History</td>
														<td class="btn2_right"></td>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_COP" id="btn_COP">COP</td>
														<td class="btn2_right"></td>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_CLM" id="btn_CLM">CLM</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="sButtonTable">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_Preview">Preview & Print</td>
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
			<!--TAB  (E) -->
			
			<!-- Grid BG Box  (S) -->
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
											<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_DownExcel">Down Excel</td>
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
			<!--biz page (E)-->
		</td>
	</tr>
</table>
	

<!-- 개발자 작업  끝 -->
</form>

<!-- 레포트  팝업  -->
<form name="form2" method="post">
    <input type="hidden" name="rfn">
    <input type="hidden" name="mrd">
    <input type="hidden" name="title">
    <input type="hidden" name="rp">
    <input type="hidden" name="rv">
</form>


</body>
</html>