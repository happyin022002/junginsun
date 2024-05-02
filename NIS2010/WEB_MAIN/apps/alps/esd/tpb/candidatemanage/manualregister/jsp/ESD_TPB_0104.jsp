<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TPB_0104.jsp
*@FileTitle : 3자구상 EAC 등록
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-05
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2008-09-17 O Wan-Ki  1.0 최초 생성
* 2009-08-05 Sun, CHOI 1.1 ALPS Migration 작업
=========================================================*/
%>	

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event.EsdTpb0104Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	EsdTpb0104Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CandidateManage.ManualRegister");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		//out.println(strUsr_id);
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		//cnt_cd = account.getCnt_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd)); //2009-05-08 : Office change기능 추가로 인해 cnt_cd는 session이 아닌  TPB 자체적으로 가져오도록 변경한다.

		event = (EsdTpb0104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code

%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
<!--

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {			
			ComShowMessage(errMessage);
		} // end if
		loadPage();

		_text_ChangeUpperCase(); // automatic change to uppercase
	}
//-->
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="iPage">
<input type="hidden" name="s_n3pty_if_tp_cd" value="S">
<input type="hidden" name="s_bil_tp_cd">
<input type="hidden" name="s_bkg_no">
<input type="hidden" name="s_bkg_no_split">
<input type="hidden" name="s_bl_no_chk">
<input type="hidden" name="s_bl_no">
<input type="hidden" name="s_bl_no_tp">
<input type="hidden" name="s_vsl_cd">
<input type="hidden" name="s_skd_voy_no">
<input type="hidden" name="s_skd_dir_cd">
<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_n3pty_ofc_cd">
<input type="hidden" name="s_src_vndr_cnt_cd">
<input type="hidden" name="s_src_vndr_seq">
<input type="hidden" name="s_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_rhq_cd" value="<%=rhq_cd%>">
<input type="hidden" name="s_cnt_cd" value="<%=cnt_cd%>">
<input type="hidden" name="s_sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="s_edate" value="<%=currentDay%>">
<input type="hidden" name="s_user_id" value="<%=strUsr_id%>">
<!--  <input type="hidden" name="s_eq_tp_cd">-->
<input type="hidden" name="s_eq_knd_cd">
<input type="hidden" name="s_eq_no">
<input type="hidden" name="s_if_amt">
<input type="hidden" name="s_reg_type" value="G">
<input type="hidden" name="s_jo_display" value="N"><%-- cannot be registerd in case of JO; Added By Sun, CHOI In 2009-10-15 --%>

<input type="hidden" name="isChecked" value="1">

<%=JSPUtil.getIncludeString(request) %>

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
	<%//@include file="/sys/common/menu/jsp/commonHeader.jsp"%>


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="90"><img class="nostar">EAC Type</td>
					<td width="250">
						<%//=JSPUtil.getCodeCombo("s_edn_tp_cd", "", "style='width:150', class='input1' required caption='EAC Type'", "CD00587", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
						<%=TPBUtils.getCodeCombo("s_edn_tp_cd", "", "style='width:150', class='input1'  required caption='EAC Type'", "CD00587", 0, "001: :&lt;&lt;Select&gt;&gt;|", "")%>
					</td>
					<td width="119" style="padding-left:4px;"><img class="nostar">Expense Type</td>
					<td width="270" style="padding-left:3px;">
						<%//=JSPUtil.getCodeCombo("s_n3pty_expn_tp_cd", "", "style='width:150', class='input1'  required caption='Expense Type' onchange='tpb_searchBillingCaseByExpenseType()'", "CD00578", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
						<%=TPBUtils.getCodeCombo("s_n3pty_expn_tp_cd", "", "style='width:150', class='input1'  onchange='changeBillingCase(this.form)' required caption='Expense Type'", "CD00580", 0, "001: :&lt;&lt;Select&gt;&gt;|", "")%>
					    <!--  <select class="input1" name="s_n3pty_expn_tp_cd" style="width:100;" required caption="Expense Type" onchange="changeBillingCase(this.form)">
							<option value=''>&lt;&lt;Select&gt;&gt;</option>
						</select>-->
					</td>
					<td width="91" style="padding-left:4px;"><img class="nostar">Billing Case</td>
					<td style="padding-left:4px;">
						<select class="input1" name="s_n3pty_bil_tp_cd" style="width:120;" required caption="Billing Case">
							<option value=''>&lt;&lt;Select&gt;&gt;</option>
						</select></td>
					</tr>
				</table>
				<table class="search_in" border="0"><tr><td class="line_bluedot"></td></tr></table>
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="90"><img class="nostar">Office</td>
					<td width="250" style="padding-left:1;"><input class="input1" type="text" style="width:99;"  required caption="Office" name="s_if_ofc_cd" maxlength="6" onblur="getTPBOffice(this.form,this)"></td>
					<td width="119"><img class="nostar" id="sp_inv_no_class">S/P Invoice No.</td>
					<td width="270"><input class="input1" type="text" style="width:129;" name="s_n3pty_src_no" required caption="S/P Invoice" maxlength="30"></td>
					<td width="90"><img class="nostar" id="sp_class">S/P</td>
					<td width=""><input class="input1" type="text" style="width:97;" name="s_src_vndr_no" maxlength="6" required caption="S/P"> <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty_v"></td>
					<!--
					<td width="80"><img class="star" id="amount_class">Currency</td>
					<td><%//= BizComUtil.getCodeCombo("s_curr_cd", "", "style='width:55' required  caption='Currency'", "CURR", 2, "0: :&lt;&lt;Select&gt;&gt;",sql_curr_cd) %>
						<input type="text" style="width:79;" name="s_if_amt" required caption="Amount" data_format="integer" onblur="this.value=tpb_format(this.value,'#,###.00');" onfocus="delete_Char(this,',')"></td>
					 -->
				</tr>
				<tr class="h23">
				    <td><img class="nostar" id="bkg_no_class">Booking No.</td>
					<td style="padding-left:1;"><input class="input1" type="text" style="width:99;" name="s_bkg_no_all" maxlength="13"></td>
					<td><img class="nostar">Bill of Lading No.</td>
					<td><input type="text" style="width:129;" name="s_bl_no_all" maxlength="12"></td>
					<td><img class="nostar">Currency</td>
					<td colspan="3">
						<select class="input1" style="width:101;" name="s_curr_cd" required caption="Currency">
							<option value="" selected>&lt;Select&gt;</option>
						</select>
					</td>
					<!--
					<td width="7%"><img class="nostar">EQ Type</td>
					<td><%//=JSPUtil.getCodeCombo("s_eq_tp_cd", "", "style='width:99'", "CD01132", 0, "001: :&lt;&lt;Select&gt;&gt;|")%></td>
					<td><img class="star" id="eq_no_class">EQ No.</td>
					<td>&nbsp;<input type="text" style="width:99;" name="s_eq_no" maxlength="11"> <input type="text" style="width:38;" name="s_eq_tpsz_cd" maxlength="4"></td>
					 -->
				</tr>
				<tr class="h23">
					<td><img class="nostar">Date</td>
					<td style="padding-left:1;"><input type="text" name="s_if_dt" style="width:76" value="<%=currentDay%>" data_format="ymd" caption='Date' OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"></td>
					<td><img class="nostar">VVD</td>
					<td><input type="text" style="width:129;" name="s_vvd" maxlength="9"> <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vvd"></td>
					<td><img class="nostar">Location</td>
					<td colspan="3"><input type="text" style="width:97;" name="s_yd_cd" maxlength="7"> <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_location"></td>
				</tr>
				<tr class="h23">
					<td><img class="nostar">3rd Party</td>
					<td colspan="7" style="padding-left:1;">
					<%//=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:75', class='input1' required caption='3rd Party'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
					<!--<input class="input1" type="text" style="width:70;" name="s_trd_party_val" maxlength="8" required caption="3rd Party" !readonly>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty"> <input class="input1" type="text" style="width:710;" name="s_trd_party_nm" readonly></td> -->
					<%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:75' class='input1' required  caption='3rd Party'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%> <input class="input1" type="text" style="width:70;" name="s_trd_party_val" maxlength="8" !readonly>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty"> <input class="input1" type="text" style="width:710;" name="s_trd_party_nm" readonly>
				</td>
				</tr>
				<tr class="h23">
					<td><img class="nostar">Remarks</td>
					<td colspan="7">
					<textarea name="s_if_rmk" class="input"  style="width:100%;height:70"  maxlength="1000"></textarea>
					</td></tr>
				<!-- 2009-03-05 임시제거 -->
				<!--
				<tr class="h23" style="height:30;">
					<td colspan="1"><img class="nostar">Relevant Document</td>
					<td colspan="7">&nbsp;<input type="hidden" style="width:30;" name="s_file_no">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_filesearch.gif" width="90" height="19" border="0" align="absmiddle"  name="btn_filesearch"></td>
				</tr>
				-->

				<tr class="h23">
					<td colspan="8">
						<table width="100%" id="mainTable">
							<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
						</table>

						<!-- : ( Button : Sub ) (S) -->
						<table width="100%" class="button">
							<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>

									<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btn_add" id="btn_add">Row&nbsp;Add&nbsp;</td>
										<td class="btn2_right"></td></tr></table></td>
									<!-- Repeat Pattern -->


									</tr>
								</table>
							</td></tr>
						</table>
				    	<!-- : ( Button : Sub ) (E) -->

					</td>
				</tr>

				</table>

				<!-- : ( Year ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>