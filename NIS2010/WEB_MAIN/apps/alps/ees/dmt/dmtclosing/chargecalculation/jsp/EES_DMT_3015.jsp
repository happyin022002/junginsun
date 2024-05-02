<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_3015.jsp
*@FileTitle : OP-MT Detention Inquiry
*Open Issues :
*Change history : 
*@LastModifyDate : 2012.07.23
*@LastModifier : Kim Hyun Hwa
*@LastVersion : 1.0
* 2012.07.23 Kim Hyun Hwa
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3015Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsr_Cnt_cd	= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTClosing.ChargeCalculation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strUsr_ofc		= account.getOfc_cd();
		strUsr_Cnt_cd	= account.getCnt_cd();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();

		event = (EesDmt3015Event)request.getAttribute("Event");
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
<title>Charge Inquiry by Office Or VVD</title>
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
<input type="hidden" name="usr_ofc_cd"			value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_cnt_cd"			value="<%=strUsr_Cnt_cd%>">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="dmdt_chg_sts_cd">
<input type="hidden" name="fm_mvmt_dt">
<input type="hidden" name="to_mvmt_dt">
<input type="hidden" name="loc_cd">
<input type="hidden" name="chk_yd_cd" value="Y"> 
<input type="hidden" name="chk_loc_cd" value="Y">


<!-- 지정 화면 Access 권한 정보 조회용  -->
<input type="hidden" name="role_permit">
<input type="hidden" name="role_auth">


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
       		<div id="sch_cond_div" style=display:inline;>
				<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="115" ><input type="radio" name="cond_type" value="bkg" class="trans">BKG No.</td>
						<td width="140" class="sm"><input type="text" name="bkg_no" dataformat="engup2" maxlength="13" style="width:120;ime-mode:disabled;" class="input" value=""></td>
					    <td width="605"></td>
					    
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
					    <td width="103"> <input type="radio" name="cond_type" value="ofc" class="trans" checked>Office </td>
						<td width="201">
						<script language="javascript">ComComboObject('office',2,80,0,1,0,true);</script>&nbsp;
						<!-- <img src="img/btns_multisearch.gif"  width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"> --> 
						<input type="checkbox" 	name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans">Incl. Sub Office</td>
						</td>
						  <td width="50" class="stm">Period</td>
						<td width="215">
							<input type="text" style="width:80;" class="input1" name="fm_mvmt_dt1" maxlength="8" dataformat="ymd"  caption="Period From Date">&nbsp;~&nbsp;
							<input type="text" style="width:80;" class="input1" name="to_mvmt_dt1" maxlength="8" dataformat="ymd"  caption="Period To Date" >&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar1" width="19" height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="46" class="stm">Status</td>
						<td width="148"><script language="javascript">ComComboObject('status1',2,110,1,1);</script>&nbsp;<img src="img/btns_multisearch.gif"
							width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
					    <td width="80"> <input type="radio" name="cond_type" value="loc" class="trans" >MT.Loc/Yard</td>
						<td width="197">
						<input type="text" name="yd_cd" dataformat="engup" maxlength="7" 
							style="width:85;" class="input">
						</td>
						<td width="50" class="stm">Period</td>
						<td width="210">
							<input type="text" style="width:80;" class="input1" name="fm_mvmt_dt2" maxlength="8" dataformat="ymd"  caption="Period From Date">&nbsp;~&nbsp;
							<input type="text" style="width:80;" class="input1" name="to_mvmt_dt2" maxlength="8" dataformat="ymd"  caption="Period To Date" >&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar2" width="19" height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="45" class="stm">Status</td>
						<td width="145"><script language="javascript">ComComboObject('status2',2,110,1,1);</script>&nbsp;<img src="img/btns_multisearch.gif"
							width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
					</tr>
					<!--</table>-->
				
				<!--<table class="search" border="0" style="width:100%;"> -->
					<tr class="h23">
						<td width="80"><input type="radio" name="cond_type" value="cntr" class="trans">CNTR No.</td>
						<td width="197" class="sm"><input type="text" name="cntr_no" dataformat="engup2" maxlength="" style="width:120;ime-mode:disabled;" class="input" value=""></td>
					    <td width="50" class="stm">Period</td>
						<td width="210">
							<input type="text" style="width:80;" class="input1" name="fm_mvmt_dt3" maxlength="8" dataformat="ymd"  caption="Period From Date">&nbsp;~&nbsp;
							<input type="text" style="width:80;" class="input1" name="to_mvmt_dt3" maxlength="8" dataformat="ymd"  caption="Period To Date" >&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar3" width="19" height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="45" class="stm">Status</td>
						<td width="145"><script language="javascript">ComComboObject('status3',2,110,1,1);</script>&nbsp;<img src="img/btns_multisearch.gif"
							width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
					</tr>
				</table>
				
					<!--  biz_1  (E) -->
			
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				</div>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				<!-- Grid  (e) -->
				
			
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
			
	</td></tr>
		</table>
			
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
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
					<td class="btn1" name="btn_Minimize">Minimize</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DelReqCancel">Inactive REQ Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ByCNTR">by CNTR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_MVMTInq">MVMT Inq.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	</td></tr>
</table>
	

<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>