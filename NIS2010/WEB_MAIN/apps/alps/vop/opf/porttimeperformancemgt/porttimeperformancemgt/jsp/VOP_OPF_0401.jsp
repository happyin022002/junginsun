<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VOP_OPF_0401.jsp
*@FileTitle : Port Time Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.03
* 1.0 Creation
* 2012.01.16 김민아 [CHM-201215697-01] Port Time Reduction관리 시스템 개발(1차)
* 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
* 2012.03.19 김민아 [CHM-201216890-01] Port Time Reduction project (2차) 수정사항 (Direction, 2nd Call추가)
* 2012.06.08 허철용 [CHM-201217512-01] PTRP 화면에 Dashboard 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event.VopOpf0401Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0401Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	String rhqOfcCd = "";
	String strOfc_cd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		//rhqOfcCd = account.getRhq_ofc_cd();
		strOfc_cd = account.getOfc_cd();

		event = (VopOpf0401Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		rhqOfcCd = eventResponse.getETCData("RHQ_OFC_CD");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Port Time Performance Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var frDt = ComGetDateAdd('<%=JSPUtil.getKST("yyyy-MM-dd")%>', "M", -3);
	var toDt = "<%=JSPUtil.getKST("yyyy-MM-dd")%>";
	var rhqOfcCd = "<%=rhqOfcCd%>";
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
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">&nbsp;Duration</td>
					<td width="220"><input type="text" name="fr_dt" style="width:80; text-align:center;" class="input1" dataformat="ymd" maxlength="8" caption="From to Date">&nbsp;~&nbsp;<input type="text" name="to_dt" style="width:80; text-align:center;" class="input1" dataformat="ymd" maxlength="8" caption="To Date">&nbsp;<img src="img/btns_calendar.gif" id="btns_period" name="btns_period" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="55"> KPI Year</td>
					<td width="120"><script language="javascript">ComComboObject('kpi_tgt_yr', 1, 60, 1, 1);</script>&nbsp;
									<script language="javascript">ComComboObject('kpi_ver_seq', 1, 40, 1, 1);</script></td>
					<td width="30">RHQ</td>
					<td width="85"><script language="javascript">ComComboObject('rhq_ofc_cd', 1, 70, 1);</script></td>
					<td width="30">Port</td>
					<td width="90"><input type="text" name="port_cd" style="width:48;ime-mode:disabled; text-align:center;" class="input" dataformat="engup" maxlength="5" caption="Port">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absbottom" id="btns_port" name="btns_port"></td>
					<td width="30">Lane</td>
					<td width="90"><input type="text" name="slan_cd" style="width:40;ime-mode:disabled; text-align:center;" class="input" dataformat="engup" maxlength="3" caption="Lane">&nbsp;<img src="img/btns_search.gif" id="btns_slan" name="btns_slan" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="40">KPI/PFMC</td>
					<td width="">
							<table class="search_sm2" border="0" style="width:120;"> 
							<tr>
							<td width="" class="input" style="font-size:12;">
							<!-- 
							&nbsp;
							<input type="radio" class="trans" name="gubun" value="" checked>ALL&nbsp;&nbsp;&nbsp;
							<input type="radio" class="trans" name="gubun" value="KPI">&nbsp;KPI&nbsp;&nbsp;&nbsp;
							<input type="radio" class="trans" name="gubun" value="PERF">Performance
							 -->
								<script language="javascript">ComComboObject('gubun', 1, 120, 1);</script>
								
							</td>
							</tr>
							</table>	
					</td>
				</tr>	
				</table>
	<!--  biz_1   (E) -->			
			</td>
			</tr>	
			</table>
				
				
		
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	<table width="100%"  class="search"> 
       	<tr><td class="bg">
				<!-- Grid (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
	</td></tr>
	</table>
	<!-- Grid BG Box  (S) -->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_new" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	              <tr>
	                <td class="btn1_left"></td>
	                <td class="btn1" name="btn_save">Except. Save</td>
	                <td class="btn1_right"></td>
	              </tr>
	            </table></td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_dashboard" name="btn_dashboard">Dashboard</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--biz page (E)-->
	
	</td></tr>
	</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>