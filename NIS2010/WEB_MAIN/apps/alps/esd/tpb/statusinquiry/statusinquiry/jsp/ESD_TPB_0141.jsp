<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0141.jsp
*@FileTitle : Fax/E-mail Sending History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-17
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2015-04-17 KIM HYUN HWA	1.0	최초 생성
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0141Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	EsdTpb0141Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	
	String ofc_lvl 		= ""; 
	String rhq_cd 		= ""; 
	String ofc_cd 		= ""; 
	
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	Logger log = Logger.getLogger("com.hanjin.apps.StatusInquiry.StatusInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0141Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
	
%>
<html>
<head>
<title>Fax/E-mail Sending History Inquiry</title>
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
<!-- 개발자 작업	-->

<input type="hidden" name="iPage">

<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_n3pty_ofc_cd">

<input type="hidden" name="s_length_n3pty_bil_tp_cd">
<input type="hidden" name="s_cnt_cd">
<input type="hidden" name="s_trd_party_code">
<input type="hidden" name="s_h_vndr_cust_div_cd">

<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input type="hidden" name="s_usr_ofc_cd" value="<%=ofc_cd%>">

<input type="hidden" name="s_inquiryOnly_yn" value="Y">
<input type="hidden" name="sndrnmm">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- ______________________________________________ Start Page Navigation & Title -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
			<!-- |______________________________________________ End Page Navigation & Title -->
			<%//@include file="/sys/common/menu/jsp/commonHeader.jsp"%>


			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new" id="btn_new">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
	    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


			<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table class="search">
	       		<tr>
	       			<td class="bg">
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="92">Send&nbsp;Date</td>
								<td width="202"><input type="text" name="s_sdate" style="width:70" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>" data_format="ymd" required caption='Date' OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;&nbsp;~&nbsp;<input type="text" name="s_edate" style="width:70" value="<%=currentDay%>" data_format="ymd" required caption='Date' OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
								<td width="70">Invoice&nbsp;No.</td>
								<td width="145"><input type="text" style="width:130;" name="s_n3pty_inv_no" maxlength="11"></td>
								<td width="72">3rd&nbsp;Party</td>
								<td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:80'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
									<input type="text" style="width:75;" name="s_trd_party_val">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty">
								</td>
			                    <td width="65">Sender&nbsp;ID</td>
			                    <td width="">
			                        <input type="text" style="width:100;" value="" class="input" name="sndrid">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_sender_id" width="19" height="20" border="0" align="absmiddle">
			                    </td>
							</tr>
			
							<tr class="h23">
							    <td>Interface&nbsp;Type</td>
								<td>
									<select style="width:130;" class="input1" name="s_n3pty_if_tp_cd">
										<option value="S" selected>TPB</option>
										<option value="R" >Logistics Revenue</option>
									</select>
			                    </td>
								<td>RHQ</td>
								<td>
									<select style="width:80;" class="input1" name="s_if_rhq_cd" required caption="RHQ">
										<option value="" selected>&lt;&lt;Select&gt;&gt;</option>
									</select>
								</td>
								<td>Control&nbsp;Office</td>
								<td>
									<select style="width:75;" name="s_if_ctrl_cd" caption="Control Office" >
										<option value="" selected>ALL</option>
									</select>
								</td>
								<td>Office</td>
								<td>
									<select style="width:75;" name="s_if_ofc_cd">
										<option value="" selected>ALL</option>
									</select>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>


			<!-- TABLE '#D' : ( Grid ) (S) -->
     		<table class="search">
       			<tr>
       				<td class="bg">
						<table width="100%" id="mainTable">
			            	<tr>
			            		<td>
			                    	<script language="javascript">ComSheetObject('sheet1');</script>
			              		</td>
			              	</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Grid ) (E) -->

    	</td>
    </tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>