<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0321.jsp
*@FileTitle : MR Storage Calculation - Cost Calculation(Free Day)
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9012602
*@LastVersion : 1.0
* 2015-02-06 9012602 			1.0	최초 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.expnaud.tesaud.event.EsdEas0321Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	EsdEas0321Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.eas.expnaud.tesaud.TesAudBC");
	
	String ofc_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	String selBOUND = "";
	String optionStr = "000020::";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		ofc_cd = account.getOfc_cd();
		
		event = (EsdEas0321Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		selBOUND  = JSPUtil.getCodeCombo("bnd_cd", "01", "style='width:60'", "CD00591", 0, optionStr);
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	//3번째 파라메터가 "width='500'"TML_INV_RJCT_STS_CD
	String addRowBound = "10: ";
	String actionInvStatusBox = JSPUtil.getCodeCombo("tml_inv_sts_cd", 		"01", "width='70'","CD00172", 0, addRowBound);
	String actionInvDateBox   = JSPUtil.getCodeCombo("inv_date_type",		"01", "width='70'","CD00763", 0, addRowBound);
	
%>
<html>
<head>
<title>JO TPB Process Inquiry</title>
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
<form name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="iPage">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">

<input type="hidden" name="command_h">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="respb_ofc_cd">
<input type="hidden" name="calc_cost_grp_cd" value="SP">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

	<!-- ______________________________________________ Start Page Navigation & Title -->
	<!-- | -->
	<!-- | -->	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
	<!-- |______________________________________________ End Page Navigation & Title -->


	<!-- ______________________________________________ Start Main Button -->
	<!-- | -->
	<!-- | -->	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
	<!-- |______________________________________________ End Main Button -->


	<!-- ______________________________________________ Start Search Option -->
		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="90">Storage Type</td>
					<td width="110"><script language="javascript">ComComboObject('tml_inv_tp_cd', 1, 100, 0, 0);</script></td>
					<td width="90">Invoice Date</td>
					<td width="420" colspan="3"><%=actionInvDateBox%>&nbsp;<input type="text" name="fm_prd_dt" style="width:75" value="" maxlength=10 class="input1" onKeyUp='isNum1(this);' onKeyDown='chkInput(this);' OnBlur='obj_blur();' OnFocus='obj_focus();'>
					<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">
					~&nbsp;<input type="text" name="to_prd_dt" style="width:75" value="" maxlength=10 class="input1" onKeyUp='isNum1(this);' onKeyDown='chkInput(this);' onBlur='obj_blur();'  OnFocus='obj_focus();'>
					<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
					</td>
				</tr>
				<tr class="h23">	
					<td width="80">Yard Code</td>
					<td width="110"><input type="text" style="width:75" name="yd_cd" maxlength=7 class="input1" onKeyUp='upper(this);' onBlur='yd_cd_change();' onKeyPress='enterCheck("retrieveEvent");'>
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_yard">
					</td>
					<td !width="90"> S/P Code</td>
					<td width="200"><input type="text" style="width:50" value="" maxlength=6 name="vndr_seq" onKeyUp='chkInput(this);isNum(this);' onBlur='vender_change();'>
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vndr">
						<input type="hidden" name="vndr_seq_hidden" value=''><input type="hidden" name="is_valid_vndr_seq" value=''><input type="hidden" name="vndr_seq_deltflg" value=''><input type="text" style="width:100" name="vndr_seq_name" class="input2" readonly="readonly">
					</td>
					<td width="110">Cost Office</td>
					<td width="110"><input type="text" style="width:57" maxlength=6 onKeyUp='chkInput(this);upper(this);isAlpha(this);' onBlur='costOffice_change();' name="cost_ofc_cd" onKeyPress='enterCheck("retrieveEvent");'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cost_ofc_cd">
					<td !width="80">Invoice OFC</td>
					<td !width="120"><input type="text" style="width:75" maxlength=6 onKeyUp='isAlpha(this);chkInput(this);upper(this);' onBlur='invoiceOffice_change();' name="inv_ofc_cd" onKeyPress='enterCheck("retrieveEvent");'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_inv_ofc_cd"></td>
				</tr>
					
				<tr class="h23">
					<td  width="90">Invoice STS</td>
					<td><%=actionInvStatusBox%></td>
					<td width="114">Cost Code Type</td>
					<td colspan="3"><script language="javascript">ComComboObject('lgs_cost_cd',1, 120 , 0, 0)</script></td>
					<td width="" colspan="2"><input type="checkbox" name="calc_tp_cd" value="Y" class="trans">Manual Input Only</td>
				</tr>
				
				</table> 
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->

	<!-- |______________________________________________ End Search Option -->


	<table class="height_10"><tr><td></td></tr></table>

	<!-- ______________________________________________ Start Result Grid -->
	<!-- | -->
	<!-- | -->	<table class="search"><tr><td class="bg">
	<!-- | -->
	<!-- | -->		<table width="100%" id="mainTable">
	<!-- | -->			<tr>
	<!-- | -->				<td>
	<!-- | -->					<script language="javascript">ComSheetObject('sheet1');</script>
	<!-- | -->				</td>
	<!-- | -->			</tr>
	<!-- | -->		</table>
	<!-- | -->
	<!-- | -->	</td></tr></table>
	<!-- |______________________________________________ End Result Grid -->



    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>