<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0107.jsp
*@FileTitle : TPB Group Remaking
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-04
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki  1.0 최초 생성
* 2009-09-04 Sun, CHOI 1.1 ALPS Migration
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.event.EsdTpb0107Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0107Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProcessManage.OutstandingGroupmanage");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0107Event)request.getAttribute("Event");
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
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		//alert("InitTab");
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//alert("loadPageEND");
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="iPage">
<input type="hidden" name="s_bkg_no">
<input type="hidden" name="s_bkg_no_split">
<input type="hidden" name="s_bl_no_chk">
<input type="hidden" name="s_bl_no">
<input type="hidden" name="s_bl_no_tp">
<input type="hidden" name="s_vsl_cd">
<input type="hidden" name="s_skd_voy_no">
<input type="hidden" name="s_skd_dir_cd">
<%--
<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_n3pty_ofc_cd">
--%>
<input type="hidden" name="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" value="<%=currentDay%>">
<input type="hidden" name="s_n3pty_no">
<input type="hidden" name="s_dao_n3pty_no">
<input type="hidden" name="s_h_ots_sts_cd">
<input type="hidden" name="s_trd_party_code">
<input type="hidden" name="s_h_vndr_cust_div_cd">
<input type="hidden" name="s_h_n3pty_inv_no">
<input type="hidden" name="s_cfm_dt">
<input type="hidden" name="s_cfm_dt_prev">
<input type="hidden" name="s_cfm_dt_last">
<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input type="hidden" name="s_user_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_user_id" value="<%=strUsr_id%>">



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
		<%//include file="/sys/common/menu/jsp/commonHeader.jsp"%>


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
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
				<table class="search_in" border="0" bordercolor="red">
				<tr class="h23">
				    <td width="115"><img class="nostar" id="period_class">Period</td>
					<td width="330">
						<input type="text" name="s_sdate" style="width:70" value="<%=DateTime.addMonths(currentDay, -1, "yyyy-MM-dd")%>" caption="Date" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;&nbsp;~&nbsp;
						<input type="text" name="s_edate" style="width:70" value="<%=currentDay%>"  caption="Date" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;
						<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
					</td>
					<td width="90"><img class="nostar">RHQ</td>
					<td width="260"><select class="input1" style="width:90;" name="s_if_rhq_cd" required caption="RHQ">
						<option value="" selected>&lt;Select&gt;</option>
						</select></td>
					<td width="60"><img class="nostar"> Office</td>
					<td><select class="input1" style="width:100;" name="s_if_ofc_cd" required caption="Office">
						<option value="" selected>&lt;Select&gt;</option>
						</select>
					</td>
				</tr>
				<tr class="h23">
					<td><img class="nostar">Expense Type</td>
					<td>
						<%=JSPUtil.getCodeCombo("s_n3pty_src_sub_sys_cd", "", "style='width:162'", "CD00580", 0, "001: :ALL|")%>
						<select name="s_n3pty_bil_tp_cd" style="width:150;">
							<option value=''>&lt;&lt;Select&gt;&gt;</option>
						</select>
					</td>
					<td><img class="nostar">3rd Party</td>
					<td colspan="3">
						<%//=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:90'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
						<!--<input type="text" style="width:70;" name="s_trd_party_val" maxlength="8">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty">-->
						<%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:90'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%> <input type="text" style="width:70;" name="s_trd_party_val" maxlength="8" !readonly>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty">					
					</td>
				</tr>
				<tr class="h23">
					<td><img class="nostar">VVD</td>
					<td><input type="text" style="width:95" name="s_vvd" maxlength="9">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vvd"></td>
					<td><img class="nostar">Booking No.</td>
					<td><input type="text" style="width:164" name="s_bkg_no_all" maxlength="13" onblur="getBLNo(this.form,this,'s_')"></td>
					<td><img class="nostar">B/L No.</td>
					<td><input type="text" style="width:100" name="s_bl_no_all" maxlength="12"></td>
				</tr>
				<tr class="h23">
					<td><img class="nostar">Equipment No.</td>
					<td><input type="text" style="width:95" name="s_eq_no" maxlength="11"></td>
					<td><img class="nostar">TPB No</td>
					<td colspan="3"><input type="text" style="width:164" name="s_n3pty_no_search" maxlength="14"></td>
				</tr>
				</table>

				<table border="0">
				<tr class="h23">
					<td width="117"><img class="nostar">Candidate</td>
					<td width="">

						<table class="sm" border="0" style="height:20; width:162; background-color: #E9E9E9;">
							<tr class="h23">
								<td align="center" >
								<input type="radio" name="s_candidate_include_flag" value="I" style="border:0;">Include&nbsp;&nbsp;&nbsp;
								<input type="radio" name="s_candidate_include_flag" value="E" style="border:0;" checked>Exclude
								</td>
							</tr>
						</table>

					</td>
				</tr>
				</table>

				<!-- : ( Year ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Grid ) (S) -->
     	<table class="search">
       	<tr><td class="bg">



				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
		              <tr><td>
		                     <script language="javascript">ComSheetObject('sheet1');</script>
		              </td></tr>
				</table>
				<!--�׸���ȿ� �� ��ư �Դϴ�. Collection Activity �÷��ȿ� �� ��ư �̹����Դϴ�.
				<img class="cursor" src="/hanjin/img/button/btng_collectionactivity.gif" width="113" height="19" border="0">-->
				<!-- : ( POR ) (E) -->

				<!-- : ( Button : Grid ) (S) -->
				<!-- table width="100%" class="sbutton">
		       	<tr><td class="align">

				    <table class="sbutton">
					<tr><td class="bt"><img class="cursor" src="/hanjin/img/button/btng_detail.gif" width="65" height="19" border="0" name="btng_detail"></td></tr>
					</table>

				</td></tr>
				</table -->
		    	<!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>