<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2015.jsp
*@FileTitle : Dual Type Exception Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.08.24 이성훈
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.event.EesDmt2015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2015Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTExceptionMgt.DualTypeExceptionMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesDmt2015Event)request.getAttribute("Event");
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
<title>Dual Type Exception Inquiry</title>
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
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="dul_expt_eff_dt">
<input type="hidden" name="dul_expt_exp_dt">
<input type="hidden" name="dul_expt_delt_flg">
<!-- RFA(Before Booking CNTR/Cargo Type) 공통코드를 불러오기 위한 매개변수 -->
<input type="hidden" name="code1" value="CD02053">
<input type="hidden" name="code2" value="CD01963">
<!-- S/C CNTR/Cargo Type 공통코드를 불러오기 위한 매개변수 -->
<input type="hidden" name="intg_cd_id" value="CD01969">
<!-- Dual Type Exception Applied 조회를 위한 매개변수 -->
<input type="hidden" name="cust_cd">
<input type="hidden" name="dmdt_ctrt_expt_tp_cd">
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">
<input type="hidden" name="io_bnd_cd">
<input type="hidden" name="dmdt_cntr_cgo_tp_cd">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="cvrg_cnt_cd">
<input type="hidden" name="cvrg_rgn_ste_cd">
<input type="hidden" name="cvrg_loc_cd">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90">Customer</td>
						<td width="" style="padding-left:2"><script language="javascript">ComComboObject('combo1', 2, 90, 0, 0, 0, true)</script>&nbsp;<input type="text" name="custNm" style="width:350;" class="input2"></td>
						<td>&nbsp;Coverage&nbsp;&nbsp;&nbsp;</td>
						<td class="stm">Country</td>
						<td width="70" class="stm">&nbsp;<script language="javascript">ComComboObject('cboCountry', 2, 60 , 0, 0, 0, true)</script></td>
						<td class="stm" id="Region">Region</td>
						<td width="70" class="stm">&nbsp;<script language="javascript">ComComboObject('cboRegion', 2, 60 , 0, 0, 0, true)</script></td>
						<td class="stm">Location</td>
						<td class="stm">&nbsp;<input type="text" id="cvrg_location" name="cvrg_location" caption="Location" maxlength="5" fullfill style="width:70;" class="input" value="" dataformat="engup" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" OnKeyUp="checkLocation()"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="90">Effective Date</td>
						<td width="">
							<input type="text" name="effFmDt" style="width:70;" class="input" dataformat="ymd" maxlength="8" onfocus="setEffectiveToDate()">&nbsp;~
							<input type="text" name="effToDt" style="width:70;" class="input" dataformat="ymd" maxlength="8">&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar" width="19" height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td>Status&nbsp;</td>
						<td><select name="status" style="width:70;" class="input">
							<option value="" selected>ALL</option>
							<option value="Y">Deleted</option>
							<option value="N">Live</option>
							</select>&nbsp;</td>
						<td>Type&nbsp;</td>
						<td><select name="type" style="width:50;" class="input" onchange="javascript:refreshTypeCombo(this.value);">
							<option value="" selected>ALL</option>
							<option value="S">S/C</option>
							<option value="B">RFA</option>
							</select>&nbsp;</td>
						<td>Prop No.&nbsp;</td>
						<td><input type="text" name="prop_no" style="width:70;" class="input" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;</td>
						<td>Bound&nbsp;</td>
						<td><select name="bound" style="width:50;" class="input">
							<option value="" selected>ALL</option>
							<option value="I">I/B</option>
							<option value="O">O/B</option>
							</select>&nbsp;</td>
						<td>CNTR/Cargo Type&nbsp;</td>
						<td><script language="javascript">ComComboObject('cboCNTRCGO', 2, 90, 0, 0, 0, true)</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					</tr>					
				</table>
				<!--  biz_1  (E) -->
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="stm">&nbsp;*&nbsp;&nbsp;Effective Date: S/C or Before Booking DAR should be effective within this period to be applicable </td>
			<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_Detail" id="btn_Detail">Detail</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_DownExcel" id="btn_DownExcel">Down Excel</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>							
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>	
				
				<!--  biz_3  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Dual Type Exception Applied</td></tr>
				</table>
				<!--  biz_3   (E) -->
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
		
<!-- : ( Search Options ) (E) -->
 
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
					<td class="btn1" name="btn_MainDownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
					</table></td>
					</tr>
				</table>
				</td></tr>
			</table></td></tr>
</table>
    <!--Button (E) -->
	
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>