<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4005.jsp
*@FileTitle : 3rd Party DEM/DET Collection Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.08.25 최성환
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.event.EesDmt4005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTInvoiceMgt.usdemurrageaudit");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();


		event = (EesDmt4005Event)request.getAttribute("Event");
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
<title>3rd Party DEM/DET Collection Audit</title>
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
<input type="hidden" name="button_mode">

<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>">

<input type="hidden" name="load_opt_input" value="1">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="fm_mvmt_yd_cd">
<input type="hidden" name="yd_cd1">

<input type="hidden" name="cntr_nos">

<!-- 개발자 작업	-->
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
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						
						<td width="40">Office</td>
						<td width="110">
						<script language="javascript">ComComboObject('combo1', 2, 70 , 0, 1)</script>
						</td>
						
						
						<td width="70">Tariff Type</td>
						<td width="110">
						<script language="javascript">ComComboObject('combo2', 2, 70 , 0, 1)</script>
						</td>
						
						<td width="80">Load Option </td>
						<td width="110">
						<select style="width:70;" class="input1" name="load_opt" onchange="load_opt_change();"> 
						<option value="1" selected>VVD CD</option>
						<option value="2">B/L No</option>
						<option value="3">BKG No</option>
						</select></td>
						
						<td width="70">From Yard </td>
						<td width="150"><input type="text" style="width:60;" class="input1" name="yd_cd" style="ime-mode:disabled;" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()">&nbsp;
						<script language="javascript">ComComboObject('combo3', 2, 60 , 0, 0);</script>
						</td>
						
						<td width="88">Result Option</td>
						<td width=""><select style="width:100;" class="input" name="result_opt" onchange="result_opt_change();"> 
						<option value="All" selected>All</option>
						<option value="Coincidence">Coincidence</option>
						<option value="Discrepancy">Discrepancy</option>
						</select></td>
					</tr>
				</table>
				<!--  biz_1  (E) -->
		
			</td></tr>
		</table>	
		<table class="height_8"><tr><td colspan="6"></td></tr></table>
		<table class="search"> 
       		<tr><td class="bg">
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
				<!--  	
				sheet(2)
				-->
				<!-- Grid  (e) -->
				<table class="height_2"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="45">Total </td>
						<td width="100" class="stm">CNTR&nbsp;&nbsp;<input type="text" name="tot_cntr" style="width:50;text-align:right;" class="input2" value=""></td>
						<td width="172"class="stm">AMT&nbsp;&nbsp;<input type="text" name="tot_amt" style="width:100;text-align:right;" class="input2" value=""></td>
						<td width="80">Coincidence</td>
						<td width="100" class="stm">CNTR&nbsp;&nbsp;<input type="text" name="c_cntr" style="width:50;text-align:right;" class="input2" value=""></td>
						<td width="175"class="stm">AMT&nbsp;&nbsp;<input type="text" name="c_amt" style="width:100;text-align:right;" class="input2" value=""></td>
						<td width="80">Discrepancy</td>
						<td width="100" class="stm">CNTR&nbsp;&nbsp;<input type="text" name="d_cntr" style="width:50;text-align:right;" class="input2" value=""></td>
						<td width=""class="stm">AMT&nbsp;&nbsp;<input type="text" name="d_amt" style="width:100;text-align:right;" class="input2" value=""></td>
					</tr>
				</table>
				
				
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
			
		</td></tr>
	</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_loadexcel">Load Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_audit">Audit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ofc" id="btn_ofc">by OFC</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_bkg">by BKG</td>
					<!--  <a href="http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/dmt/jsp/UI_DMT_3002.jsp" target="_blank">by BKG</a> -->
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cntr">by CNTR</td>
					<!--  <a href="http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/dmt/jsp/UI_DMT_3003.jsp" target="_blank">by CNTR</a> -->
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_group_billing">Group Invoice Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_mvmt">MVMT INQ</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</td></tr>
			</table>
	    <!--Button (E) -->
		</td></tr>
	</table>

<!-- Copyright (S) -->

<!-- Copyright(E)-->
<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>