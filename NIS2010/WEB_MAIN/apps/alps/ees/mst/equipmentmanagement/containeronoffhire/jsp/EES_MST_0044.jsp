<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0044.jsp
*@FileTitle : Container Master Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.07.23 이호선
* 1.0 Creation
* =========================================================
* 2010.07.14 남궁진호 CNTR TYPE SIZE 수정 할수 없도록 변경 유저요청
* 2010.12.27 진마리아 [CHM-201007809-01] OWN CNTR Creation화면에서 Unit Type에 DF/UF추가 및 Full Name 표기
* 2013.07.23 채창호 [CHM-201325661] ALPS Master-Master Inquiry 및 Status Update/Inquiry화면에서  컨테이너 번호 입력란 로직 변경
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0044Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EesMst0044Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.ContainerOnOffHire");
	String cntr_no = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMst0044Event)request.getAttribute("Event");
		cntr_no = (String)JSPUtil.getParameter(request ,"cntr_no".trim(), "");
		if (cntr_no == null) cntr_no ="";
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
<title>::</title>
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
<input type="hidden" name="head_cntr_tpsz_cd" value=""> 
<input type="hidden" name="cntr_tpsz_cd_h" value="">
<input type="hidden" name="vndr_abbr_nm_h" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
			<table class="search"> 
			<tr><td class="bg" style="height:505;" valign="top">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">CNTR No.</td>
					<td width="180"><input type="text" style="width:80;text-align:center;text-transform:uppercase;ime-mode:disabled;" class="input1" dataformat="engup" maxlength="10" onKeyPress="ComKeyOnlyAlphabet('uppernum');" name = "cntr_no" value="<%=cntr_no%>">&nbsp;<input type="text" style="width:15;" class="input2"  value="" name = "chk_dgt" maxlength="1" dataformat="int" value="">&nbsp;<input type="text" style="width:50;" class="input2"  readOnly value="" name = "aciac_div_cd" style="text-align:center">&nbsp;</td>
					<td width="40">TP/SZ</td>
					<td width="60"><input type="text" style="width:40;" class="input2"  readOnly value="" name = "cntr_tpsz_cd" style="text-align:center"></td>
					<!--<td width="60"><script language="javascript" >ComComboObject('cntr_tpsz_cd', 1, 40, 1, 0, 0, false);</script></td>-->
					<td width="60">ISO Code</td>
					<td width="80"><input type="text" style="width:38;" class="input2"  readOnly value="" name = "cntr_tpsz_iso_cd" style="text-align:center"></td>
					<td width="55">Material</td>
					<td width="155">
					<select style="width:127;" class="input1" name="cntr_mtrl_cd">
					    <option value="" selected></option> 
						<option value="SS">Stainless Steel</option>
						<option value="SU">Steel (Unspecified)</option>
						<option value="AU">Aluminum</option>
						</select></td>
					<td width="75">Tare Weight</td>
					<td width="" class="sm"><input type="text" style="width:50;" class="input2"  readOnly value="" name = "tare_wgt" style="text-align:right"> KG&nbsp;&nbsp;&nbsp;<input type="text" style="width:50;" class="input2"  readOnly value="" name = "tare_wgt_lbs" dataformat="int" style="text-align:right"> LBS<input type="hidden" name = "cntr_spec_no"></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Lease Term</td>
					<td width="182"><input type="text" style="width:80;" class="input2"  readOnly value="" name = "sub_lstm_cd" style="text-align:center"></td>
					<td width="126">Owner Lease Term</td>
					<td width="110"><input type="text" style="width:70;" class="input2"  readOnly value="" name = "lstm_cd" style="text-align:center"></td>
					<td width="58">Current</td>
					<td width="155"><input type="text" style="width:125;" class="input2"  readOnly value="" name = "cntr_use_co_cd" style="text-align:center"></td>
					<td width="74">Ownership</td>
					<td><input type="text" style="width:124;" class="input2"  readOnly value="" name = "ownr_co_cd" style="text-align:center"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Manufacturer&nbsp</td>
					<td width="81"><script language="javascript">ComComboObject('vndr_abbr_nm',2,75,1,0,0,false);</script></td>
					<td width="279"><input type="text" style="width:224;" class="input2"  readOnly value="" name = "vndr_lgl_eng_nm" style="text-align:left"></td>
					<td width="114">Manufacture Date</td>
					<td width="150"><input type="text" style="width:100;" class="input"  dataformat="ymd" name = "mft_dt" style="text-align:center">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="cal_img" style="cursor:hand" onClick="func_calendar('calendarPopup1')"></td>
					<td width=""> <input type="checkbox" class="trans" name="d2_payld_flg" onClick="return false">D2 H/P</td>
				</tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="87">Reefer Unit</td>
					<td width=""><!--<input type="text" style="width:80;" class="input2"  readOnly value="" name = "rf_tp_cd" style="text-align:center">-->
					<!--<select style="width:50;" class="input1" name="rf_tp_cd">
					    <option value="" selected></option> 
						<option value="C">&nbsp&nbspCA</option>
						<option value="H">&nbsp&nbspHU</option>
						<option value="M">&nbsp&nbspMG</option>
					</select>-->
					<script language="javascript">ComComboObject('rf_tp_cd',1,170,1,0,0,false);</script>
					</td>				
				</tr>
				</table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<div style="display: none;"><script language="javascript">ComSheetObject('sheet1');</script></div>
						</td>
					</tr>
				</table>				
				<!--  biz_1  (E) -->

			</td></tr>
			</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>
	</td></tr>
</table>
</form>
</body>
</html>
