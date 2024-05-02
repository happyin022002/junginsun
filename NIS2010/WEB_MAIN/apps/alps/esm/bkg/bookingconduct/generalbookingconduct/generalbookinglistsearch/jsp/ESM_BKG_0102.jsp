<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0102.jsp
*@FileTitle : Compulsory Firm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.26 김병규
* 1.0 Creation
2011.03.30 정선용 [CHM-201109338-01] Split 18-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0102Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg0102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String sXml      = "";	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc_cd   	= "";
	String StrRhq_ofc_cd    = "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingListSearch");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc_cd = account.getOfc_cd();
		StrRhq_ofc_cd = account.getRhq_ofc_cd();
		event = (EsmBkg0102Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}		
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);		

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Compulsory Firm</title>
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
<input type="hidden" name="sXml" value = "<%=sXml%>">
<input type="hidden" name="usr_ofc_cd" value = "<%=strUsr_ofc_cd%>">
<input type="hidden" name="rhq_ofc_cd" value = "<%=StrRhq_ofc_cd%>">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="30">VVD</td>
						<td width="250"><input type="text" name="bkg_vvd_cd" class="input1" style="width:80" value="" maxlength=9 dataformat="engupnum" style="ime-mode:disabled"  ><input type="radio" name="vsl_pre_post_cd" value="T" class="trans" checked>&nbsp;Trunk&nbsp;&nbsp;&nbsp;<input type="radio" name="vsl_pre_post_cd" value="1" class="trans">&nbsp;1st</td>
						<td width="40">POL</td>
						<td width="100"><input type="text" name="pol_cd" style="width:60" value="" class="input" maxlength=5 dataformat="engupnum" style="ime-mode:disabled"  ></td>
						<td width="30">POD</td>
						<td width="100"><input type="text"  name="pod_cd" style="width:60" value="" class="input" maxlength=5 dataformat="engupnum" style="ime-mode:disabled"  ></td>
						<td width="80">Rep. CMDT</td>
						<td width="100"><input type="text" name="rep_cmdt"  style="width:60" value="" class="input"></td>
						<td width="40">B.OFC</td>
						<td width="100"><input type="text" name="bkg_ofc_cd"  style="width:60" value="" class="input" maxlength=6 dataformat="engup" style="ime-mode:disabled"  ></td>
						<td width="40">L.OFC</td>
						<td width=""><input type="text"  name="ob_sls_ofc_cd" style="width:100%" value="" class="input" maxlength=6 dataformat="engup" style="ime-mode:disabled"  ></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90">Shipper Code</td>
						<td width="190"><input type="text" name="s_cust_cnt_cd"  class="input" style="width:30" value="" maxlength=2 dataformat="engup" style="ime-mode:disabled"  >&nbsp;<input type="text" name="s_cust_seq"  class="input" style="width:110" value="" maxlength=6 dataformat="num"></td>
						<td width="40">Name</td>
						<td width=""><input type="text" name="s_cust_nm"  style="width:370" value="" class="input" maxlength=50></td>
						<td width="80" align="right">BKG STS&nbsp;&nbsp;</td>
						<td width="68"><script language="javascript" >ComComboObject('bkg_sts_cd', 2, 40, 1, 0, 2)</script>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90">FWDR Code</td>
						<td width="190"><input type="text" name="f_cust_cnt_cd"  class="input" style="width:30" value="" maxlength=2 dataformat="engup" style="ime-mode:disabled"  >&nbsp;<input type="text" name="f_cust_seq"  class="input" style="width:110" value="" maxlength=6 dataformat="num"></td>
						<td width="40">Name</td>
						<td width=""><input type="text" name="f_cust_nm"  style="width:370" value=" " class="input" maxlength=50></td>
						<td width="120" align="right" id="id_aloc_sts_cd">Standby Status&nbsp;&nbsp;</td>
						<td width="68"><script language="javascript" >ComComboObject('aloc_sts_cd', 2, 40, 1, 0, 2)</script>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90">Booking No.</td>
						<td width="190"><input type="text" name="bkg_no"  class="input1" style="width:144" value="" maxlength=13 dataformat="engupnum" style="ime-mode:disabled"  ></td>
						<td width="100">Booking Period</td>
						<td width=""><input type="text" name="s_bkg_cre_dt"  style="width:80" value="" class="input1" maxlength=10 dataformat="ymd" >&nbsp;~&nbsp;<input type="text" name="e_bkg_cre_dt"  style="width:80" value="" class="input1" maxlength=10 dataformat="ymd" >&nbsp;<img class="cursor" name="btns_Calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="120" align="right" id="id_aloc_svc_cd">Service Type&nbsp;&nbsp;</td>
						<td width="68"><script language="javascript" >ComComboObject('aloc_svc_cd', 2, 40, 1, 0, 2)</script>
						</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
					
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->	
			</td></tr>
		</table>				
		
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
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_New">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td class="btn1_line"></td>
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_CompulsoryFirm">Compulsory Firm</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td>
							<table border="0" cellpadding="0" cellspacing="0" class="button" id="WaitToFirm">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Firm">Waiting&nbsp;->&nbsp;Firm</td>
								<td class="btn1_right"></td>
								</tr>
							</table>				
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="FirmToWait">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Waiting">Firm&nbsp;->&nbsp;Waiting</td>
									<td class="btn1_right"></td>
								</tr>
							</table>	
						</td> 
						
						<td id="btn_StandbyToFirm">
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="StandbyToFrim">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_StandbyToFirm">Standby&nbsp;->&nbsp;Firm</td>
									<td class="btn1_right"></td>
								</tr>
							</table>	
						</td> 
						<td id="btn_FirmToStandby">
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="StandbyToFrim">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_FirmToStandby">Firm&nbsp;->&nbsp;Standby</td>
									<td class="btn1_right"></td>
								</tr>
							</table>	
						</td> 
					</tr>
				</table>
			</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- Grid BG Box  (S) -->
<!--biz page (E)-->
<table class="height_10"><tr><td colspan="8"></td></tr></table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>