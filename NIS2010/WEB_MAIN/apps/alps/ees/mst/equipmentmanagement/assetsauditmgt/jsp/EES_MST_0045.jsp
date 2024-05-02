<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0045.jsp
*@FileTitle : Container Average Using  Days
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.09.17 이호선
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.event.EesMst0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0045Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.AssetsAuditMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMst0045Event)request.getAttribute("Event");
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
<title></title>
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
<input type="hidden" name="yrstr">
<input type="hidden" name="head_cntr_tpsz_cd" value=""> 
<input type="hidden" name="head_pur_list" value="">
<input type="hidden" name="qtycnt" value="">
<input type="hidden" name="cntr_tpsz_cd_h" value="">
<input type="hidden" name="vndr_abbr_nm_h" value="">
<input type="hidden" name="man_year_h" value="">
<input type="hidden" name="lstm_cd_h" value="">

<!-- print 조회용 파리미터 -->
<input type='hidden' name='prt_cntr_tpsz_cd'>
<input type='hidden' name='prt_pur_list'>


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
		<!-- Grid BG Box  (S) -->
     	<table class="search">
       	<tr><td class="bg" style="height:515;" valign="top">
		
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="320" colspan="2">
						<table class="search_sm2" border="0" style="width:300;"> 
						<tr class="h23">
						<td width="90">EQ Type</td>
                   		 <td class="stm"><input type="radio" value="U" class="trans" checked name="eq_knd_cd">Container&nbsp;&nbsp;&nbsp;<input type="radio" value="Z" class="trans" name="eq_knd_cd">Chassis&nbsp;&nbsp;&nbsp;<input type="radio" value="G" class="trans" name="eq_knd_cd">M.G.Set</td>
						</tr>
						</table>
					</td>
					<td width="320" colspan="2">
						<table class="search_sm2" border="0" style="width:300;"> 
						<tr class="h23">
					<td width="100">Report Type</td>
                    <td class="stm"><input type="radio" value="A" class="trans" checked name="report_type">All&nbsp;&nbsp;&nbsp;<input type="radio" value="O" class="trans" name="report_type">Active&nbsp;&nbsp;&nbsp;<input type="radio" value="X" class="trans" name="report_type">Inactive</td>
					</tr>
					</table>
					</td>
					<td width="110">Lease Term</td>
					<td width="">
						<script language="javascript">ComComboObject('lstm_cd', 1, 150, 1);</script>
						<div style="display: none;"><input type="text" name="chk_lstm_cd" style="width:150" value="" class="input" readonly></div>
					</td>
				
				<tr class="h23">
					<td width="70">&nbsp;TP/SZ</td>
					<td width="">
						<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 231, 1);</script>
						<div style="display: none;"><input type="text" name="chk_cntr_tpsz_cd" style="width:150" value="" class="input" readonly></div>
					</td>
					<td width="100">&nbsp;Manufacturer</td>
					<td width="">
						<script language="javascript">ComComboObject('vndr_abbr_nm', 2, 198, 1);</script>
						<div style="display: none;"><input type="text" name="chk_vndr_abbr_nm" style="width:150" value="" class="input" readonly></div>
					</td>
					<td width="110">Manufacture Year</td>
					<td>
						<script language="javascript">ComComboObject('man_year', 1, 150, 1);</script>
						<div style="display: none;"><input type="text" name="chk_man_year" style="width:150" value="" class="input" readonly></div>
					</td>					
				</tr>
				</table>
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
			

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downexcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
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
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>