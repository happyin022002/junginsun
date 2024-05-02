<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0136.jsp
*@FileTitle : Activity - TPB Closing
*Open Issues :
*Change history :
*@LastModifyDate : 2010-11-09
*@LastModifier : eunju, son
*@LastVersion : 1.1
* 2010-11-09 손은주  1.0 최초 생성
* 2010-11-18  손은주 [CHM-201006809-01][TPB] TPB Activity기간별 TPB 조회 기능 - office 관련 select box 수정
* 2010.11.19 손은주 [CHM-201006809-01]	[TPB] TPB Activity기간별 TPB 조회 기능 - RHQ 필수 조건수정
* 2010.11.22 손은주 [CHM-201006809-01]	[TPB] TPB Activity기간별 TPB 조회 기능 - History 수정
* 2010.12.09 손은주 [CHM-201007586-01]	[TPB] 미사용 소스 삭제
* 2011-02-21 손은주 [CHM-201108686-01][TPB] 실적 조회 화면 보완 - Activity기간별 TPB 조회 기능 검색 조건 수정
=========================================================*/%>
  
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0136Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String strErrMsg = "";						//에러메세지	
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";	
	String ofc_cd = "";
	String rhq_cd = "";
	String priv_cd = "";
	String ofc_lvl = "";
	
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
	priv_cd = JSPUtil.getNull( officeInfo[4] );
	
	String s_state = JSPUtil.getNull(request.getParameter("s_state"));
	//out.println(s_state);
	String p_sdate = "";
	String p_edate = "";
	p_sdate = DateTime.addMonths(currentDay, -1, "yyyy-MM-dd");
	p_edate = currentDay;
	
	if (p_sdate.length() > 7) {
		p_sdate = p_sdate.substring(0,4)+"-"+p_sdate.substring(5,7);
    }
	if (p_edate.length() > 7) {
		p_edate = p_edate.substring(0,4)+"-"+p_edate.substring(5,7);
    }
		
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="iPage">
<input type="hidden" name="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" value="<%=currentDay%>">
<input type="hidden" name="s_n3pty_no">
<input type="hidden" name="s_user_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input type="hidden" name="s_ctrl_ofc_cd" >
<input type="hidden" name="s_state" value="<%=s_state%>">

<!--* 2009-01-08 O Wan-Ki 1.2 Control Office 추가로 인한 Office별 Privilege 정보-->
<input type="hidden" name="priv_cd" value="<%=priv_cd%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


	<!-- ______________________________________________ Start Page Navigation & Title -->
	<!-- | -->	
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				
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
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0" bordercolor="red">
				<tr class="h23">
					<!-- <td rowspan="3" width="150" valign="top">[Closing]</td>-->
				    <td width="120"><img class="nostar">RHQ</td>
					<td width="200">
					
						<select style="width:90;" name="s_if_rhq_cd" OnChange="javascript:if_rhq_cd_OnChange();" required caption="RHQ">
							
						</select>
					</td>
					<td width="120"><img class="nostar" id="period_class">Closed Month</td>
					<td width="*">
					<input type="text" name="s_sdate" maxlength="7" style="width:60" value="<%=p_sdate%>" caption="Date" data_format="ym" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateMonthObj(this);">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">
					&nbsp;~&nbsp;
					<input type="text" name="s_edate" maxlength="7" style="width:60" value="<%=p_edate%>"  caption="Date" data_format="ym" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateMonthObj(this);">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
				</tr>
				<tr class="h23">
					<td width="120"><img class="nostar">Control Office</td>
					<td width="200"><!--	<select style="width:90;" name="s_if_ctrl_cd" required caption="Control Office"><option value="" selected>&lt;Select&gt;</option></select>-->
									
			<!-- | -->				<select style="width:90;" name="s_if_ctrl_cd" OnChange="javascript:if_ctrl_cd_OnChange();" caption="Control Office">
			<!-- | -->					
			<!-- | -->				</select>
					</td>
					<td width="120"><img class="nostar">Currency</td>
					<td width="*"><%=TPBUtils.getCodeCombo("s_curr_cd_tp", "", "style='width:60' ", "CD01382", 0, "", "")%>
					</td>
				</tr>
				<tr class="h23">
					<td width="120"><img class="nostar">Office</td>
					<td width="200"><select style="width:90;" name="s_if_ofc_cd" ></select>
					</td>
					<td width="90" ><input type="radio" name="s_if_type" value="S" class="trans" checked>TPB</td>
					<td width="" ><input type="radio" name="s_if_type" value="R" class="trans" >Logistics Revenue</td>

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
				<!--그리드안에 들어갈 버튼 입니다. Collection Activity 컬럼안에 들어갈 버튼 이미지입니다.
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