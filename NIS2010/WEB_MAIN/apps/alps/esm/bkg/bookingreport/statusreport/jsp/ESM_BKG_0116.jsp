<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0116.jsp
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.10 강동윤
* 1.0 Creation
* 2012.06.25 김기택 [CHM-201218292-01] C/M 화면 다운로드 데이터 양식 수정(B/L No, TP/SZ, Seal No 컬럼 분리)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0116Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0116Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg0116Event)request.getAttribute("Event");
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
<title>booking report</title>
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

<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="tab_tp" value="0">

<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="pol_yd_cd">
<input type="hidden" name="pod_yd_cd">
<input type="hidden" name="usr_id" value="<%= strUsr_id %>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

	<!--Page Title, Historical (E)-->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">VVD</td>
						<td width="160"><input type="text" name="vvd" style="width:114;" value="" class="input1" dataformat="engupnum" maxlength="9"></td>
						<td width="50">POL</td>
						<td width="105"><input type="text" name="pol_cd" style="width:60;" value="" dataformat="engupnum" maxlength="5">&nbsp;<input type="text" name="pol_nod_cd" style="width:20;" value="" dataformat="engupnum" maxlength="2" class="input"></td>
						<td width="30">POD</td>
						<td width="95"><input type="text"  name="pod_cd" style="width:60;" value="" dataformat="engupnum" maxlength="5">&nbsp;<input type="text" name="pod_nod_cd" style="width:20;" value="" dataformat="engupnum" maxlength="2" class="input"></td>
						<td width="60">R/D</td>
						<!-- td width="90"><input type="text"  name="rcv_term_cd" style="width:25;" value="" dataformat="engup" maxlength="1">&nbsp;<input type="text" name="de_term_cd" style="width:25;" value="" dataformat="engup" maxlength="1"></td -->
						<td width="90">&nbsp;<script language="javascript">ComComboObject('rcv_term_cd', 2, 40, true, '');</script>&nbsp;<script language="javascript">ComComboObject('de_term_cd', 2, 40, true, '');</script></td>
						<td width="68">BKG Office</td>
						<td width="112"><input type="text" name="bkg_ofc_cd" style="width:70;" value="" dataformat="engup" maxlength="6"></td>
						<td width="60">BKG Staff</td>
						<td width="" align="right"><input type="text" name="cre_usr_id" style="width:70;" value="" maxlength="20"></td>
					</tr>
					<tr class="h23">
						<td>CNTR No.</td>
						<td><input type="text" name="cntr_no" style="width:114;" value="" dataformat="engupnum" maxlength="12"></td>
						<td>BKG No.</td>
						<td colspan="3"><input name="bkg_no" type="text" style="width:120;" value="" dataformat="engupnum" maxlength="13"></td>
						<td>B/L No.</td>
						<td colspan="3"><input name="bl_no" type="text" style="width:120;" value="" dataformat="engupnum" maxlength="12"></td>
						<td>Sales Rep.</td>
						<td align="right"><input name="ob_srep_cd" type="text" style="width:70;" value="" dataformat="engupnum" maxlength="5"></td>
					</tr>
					<tr class="h23">
						<td>Shipper</td>
						<td colspan="8"><input type="text" name="cust_cnt_cd" style="width:30;" value="" dataformat="engup" maxlength="2">&nbsp;<input type="text" name="cust_seq" style="width:80;" value="" dataformat="int" maxlength="6">&nbsp;<input type="text" name="cust_nm" style="width:212;" value="" ></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->		
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		<!-- Tab (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
					<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td></tr>
			</table>
		<!-- Tab (E) -->

<!--TAB C/M (S) -->

<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<!-- Grid  (S) -->
			<table width="100%">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet1');</script>
					</td>
				</tr>
			</table>
			
			<!-- 2012.06.14 Excel Down Hidden Sheet 추가 -->
			<table width="100%">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet2');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->		
			<!--  biz_2 (S) -->
			<table class="search" border="0" width="100%"> 
					<tr class="h23">
						<td width="110" align="right">Total Package</td>
						<td width="120" align="left"><input type="text" name="tot_package" style="width:100; text-align:right;"  readonly></td>
						<td width="110" align="right">Total Weight</td>
						<td width="120" align="left"><input type="text" name="tot_weight" style="width:100; text-align:right;"  readonly></td>
						<td width="130" align="right">Total Measure(CBM)</td>
						<td width="120" align="left"><input type="text" name="tot_Measure" style="width:100; text-align:right;"  readonly></td>
						<td width="80" align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Print">Print</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr>
			</table>
			<!--  biz_2   (E) -->	
			</td></tr>
		</table>

</div>

<!--TAB C/M (E) -->


<!--TAB FAX (S) -->

<div id="tabLayer" style="display:inline">

		<table class="search" id="mainTable"> 
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
			
			
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"table border="0"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_FAX">Fax</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Print2">Print</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_CheckAll">Check All</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_UncheckAll">Uncheck All</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>					
				</tr>					
				</table>
				
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			
			</td></tr>
		</table>

</div>

<!--TAB FAX (E) -->
	
		<!--biz page (E)-->	
	</td></tr>
		</table>

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_SaveExcel">Down Excel</td>
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