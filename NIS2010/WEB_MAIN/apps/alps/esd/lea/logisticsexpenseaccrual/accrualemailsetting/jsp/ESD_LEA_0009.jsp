<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0009.jsp
*@FileTitle : Accrual Mail Setting
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.09
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.09 Jeon Jae Hong
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
<%@ page import="com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.event.EsdLea0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdLea0009Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LogisticsExpenseAccrual.AccrualEmailSetting");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdLea0009Event)request.getAttribute("Event");
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
<title>Accrual Mail Setting</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
	loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="iPage">
<input type="hidden" name="frm_mail_div"> <!-- Batch or Interface Mail 구분 -->
<input type="hidden" name="frm_save_div" value="N"> <!-- 저장여부 -->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

	<!--Button_L (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
       	<tr><td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_settingapply" name="btn_settingapply">Setting Apply</td><td class="btn1_right"></td></tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_mailsendtest" name="btn_mailsendtest">Mail Send Test</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->
			</tr></table>
		</td></tr>
	</table>
	<!--Button_L (E) -->

	<!-- TABLE '#D' : ( Tab ) (S) -->
    	<table class="tab">
      	<tr><td><script language="javascript">ComTabObject('tab1')</script>
      	<!--img src="/hanjin/img/sub_tab.gif" alt="" width="755" height="23" border="0"--></td></tr>
	</table>
	<!-- TABLE '#D' : ( Tab ) (E) -->

	<!-- TABLE '#D' : ( Search Options ) (S) -->
   	<table class="search">
	<tr><td class="bg">
		<div id="tabLayer" style="display:inline">

		<!--  Button_Sub (S) -->
		<table width="935" class="button">
			<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_parameter" name="btn_parameter">Parameter</td><td class="btn2_right"></td></tr></table></td>
					<!-- Repeat Pattern -->
				</tr></table>
			</td></tr>
		</table>
		  	<!-- Button_Sub (E) -->

		<!-- : ( Seq. ) (S) -->
		<table class="search_in" border="0">
			<tr class="h23">
				<td width="70">From</td>
				<td width="530" style="padding-left:1;"><input type="text" name="frm_bat_fm_eml" style="width:450;" maxlength="30" valid="1" desc= "From" onBlur="lea_comm_CheckEmail(this)";></td>
				<td width="110">Auto Mail Send</td>
				<td><select style="width:100;" name="frm_bat_snd_flg" valid="0" desc="Mail Send" >
					<option value="Y" selected>Yes</option>
					<option value="N">No</option>
					</select></td>
			</tr>
		</table>
		<table class="search_in" border="0">
			<tr class="h23">
				<td width="70">To</td>
				<td style="padding-left:1;"><input type="text" name="frm_bat_to_eml" style="width:740;" maxlength="200"  valid="1" desc= "To" onKeyUp="lea_getLenByByte(this,document.form.frm_bat_to_eml_len);" onBlur="lea_comm_CheckEmail(this)";>&nbsp;<input type="text" class="transgray" style="width:7;" value="(" readonly><input type="text" class="transgray" name="frm_bat_to_eml_len" style="width:23;text-align:right;" readonly>&nbsp;<input type="text" class="transgray" style="width:80;" value="/ 200 Bytes )" readonly></td>
			</tr>
			<tr class="h23">
				<td>CC</td>
				<td style="padding-left:1;"><input type="text" name="frm_bat_cc_eml" style="width:740;"  maxlength="200"  valid="0" desc="CC" onKeyUp="lea_getLenByByte(this,document.form.frm_bat_cc_eml_len);"  onBlur="lea_comm_CheckEmail(this)";>&nbsp;<input type="text" class="transgray" style="width:7;" value="(" readonly><input type="text" class="transgray" name="frm_bat_cc_eml_len" style="width:23;text-align:right;" readonly>&nbsp;<input type="text" class="transgray" style="width:80;" value="/ 200 Bytes )" readonly></td>
			</tr>
			<tr class="h23">
				<td>Subject</td>
				<td style="padding-left:1;"><input type="text" name="frm_bat_subj_nm" style="width:862;"  maxlength="500" valid="1" desc= "Subject" onblur="lea_validParameterValue(this);"></td>
			</tr>
			<tr class="h23">
				<td></td>
				<td><textarea name="frm_bat_ctnt" style="width:862;" cols="133" rows="10"  maxlength="4000" valid="1" desc="Contents" onblur="lea_validParameterValue(this);"></textarea></td>
			</tr>
		</table>
		<!-- : ( Seq. ) (E) -->		
		</div>

		<div id="tabLayer" style="display:none">

		<!--  Button_Sub (S) -->
		<table width="935" class="button">
		<tr><td class="btn2_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_parameter2" name="btn_parameter2">Parameter</td><td class="btn2_right"></td></tr></table></td>
				<!-- Repeat Pattern -->
			</tr></table>
		</td></tr>
		</table>
		
		<!-- Button_Sub (E) -->
		
		<!-- : ( Seq. ) (S) -->
		<table class="search_in" border="0">
			<tr class="h23">
				<td width="70">From</td>
				<td width="530" style="padding-left:1;"><input type="text" name="frm_if_fm_eml" style="width:450;"  maxlength="30" valid="0" desc= "From" onBlur="lea_comm_CheckEmail(this)";></td>
				<td width="110">Auto Mail Send</td>
				<td><select style="width:100;" name="frm_if_snd_flg" valid="0" desc="Mail Send">
					<option value="Y" selected>Yes</option>
					<option value="N">No</option>
					</select></td>
			</tr>
		</table>
		<table class="search_in" border="0">
			<tr class="h23">
				<td width="70">To</td>
				<td style="padding-left:1;"><input type="text" name="frm_if_to_eml" style="width:740;"  maxlength="200" valid="0" desc= "To"  onKeyUp="lea_getLenByByte(this,document.form.frm_if_to_eml_len);" onBlur="lea_comm_CheckEmail(this)";>&nbsp;<input type="text" class="transgray" style="width:7;" value="(" readonly><input type="text" class="transgray" name="frm_if_to_eml_len" style="width:23;text-align:right;" readonly>&nbsp;<input type="text" class="transgray" style="width:80;" value="/ 200 Bytes )" readonly></td>
			</tr>
			<tr class="h23">
				<td>CC</td>
				<td style="padding-left:1;"><input type="text" name="frm_if_cc_eml" style="width:740;" maxlength="200"   valid="0" desc="CC" onKeyUp="lea_getLenByByte(this,document.form.frm_if_cc_eml_len);" onBlur="lea_comm_CheckEmail(this)";>&nbsp;<input type="text" class="transgray" style="width:7;" value="(" readonly><input type="text" class="transgray" name="frm_if_cc_eml_len" style="width:23;text-align:right;" readonly>&nbsp;<input type="text" class="transgray" style="width:80;" value="/ 200 Bytes )" readonly></td>
			</tr>
			<tr class="h23">
				<td>Subject</td>
				<td style="padding-left:1;"><input type="text" name="frm_if_subj_nm" style="width:862;" maxlength="500" valid="0" desc= "Subject"  onblur="lea_validParameterValue(this);"></td>
			</tr>
			<tr class="h23">
				<td></td>
				<td><textarea name="frm_if_ctnt" style="width:862;" cols="133" rows="10"  maxlength="4000" valid="0" desc="Contents"  onblur="lea_validParameterValue(this);"></textarea></td>
			</tr>
		</table>
		<!-- : ( Seq. ) (E) -->
		</div>
	</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->

	<table class="height_10"><tr><td></td></tr></table>
	<!-- TABLE '#D' : ( Search Options ) (S) -->
	<table class="search">
	 	<tr><td class="bg">
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">Mail Server Enviroment</td></tr>
			<tr><td class="height_5"></td></tr>
			</table>

			<!-- : ( Year ) (S) -->
			<table class="search_in" border="0">
			<tr class="h23">
				<td width="70">IP</td>
				<td width="220"><input type="text" style="width:130;" name="frm_eml_svr_ip" valid="1" desc= "IP" maxlength="15" value="203.246.130.40" onKeyUp="lea_com_isNumPeriod(this);" ></td>
				<td width="40">Port</td>
				<td><input type="text" style="width:40;" name="frm_port_no" maxlength="2" valid="1" desc= "Port" value="25" onKeyUp="lea_comm_isNumberMessage(this,2);"></td></tr>
			</table>
			<!-- : ( Year ) (E) -->
		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

<div id="hidden_sheets1" style="display:none">
<!-- : ( Grid ) (S) -->
<table width="100%"  id="mainTable">
	<tr><td>
		 <script language="javascript">ComSheetObject('sheet1');</script>
	</td></tr>
</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>