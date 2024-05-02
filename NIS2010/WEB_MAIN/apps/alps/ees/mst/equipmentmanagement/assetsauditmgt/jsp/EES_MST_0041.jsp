<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MST_0041.jsp
*@FileTitle : Asset inquiry by Year
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.08.12 민정호
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
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.event.EesMst0041Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0041Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentOperationPlan.ContainerSupplyDemandPlan");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMst0041Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
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
<input type="hidden" name="eq_knd_cd" value="U">
<input type="hidden" name="head_cntr_tpsz_cd" value="">
<input type="hidden" name="fm_prd" value="">
<input type="hidden" name="to_prd" value="">
<input type="hidden" name="sel_mnfr_yr">
<input type="hidden" name="sel_fm_prd">
<input type="hidden" name="sel_to_prd">
<input type="hidden" name="sel_cntr_tpsz_cd">
<input type="hidden" name="sel_lstm_cd">
<input type="hidden" name="sel_cntr_pfx_cd">
<input type="hidden" name="sel_fm_ser_no">
<input type="hidden" name="sel_to_ser_no">
<input type="hidden" name="sel_mftr_vndr_seq">
<input type="hidden" name="sel_loc_tp_cd">
<input type="hidden" name="sel_loc_cd">
<input type="hidden" name="sel_col_nm">

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
			<td width="75">&nbsp;Company</td>
			<td width="290"><input type="text" style="width:45;" class="input2" value="SML" Readonly name="ownr_co_cd" style="text-align:center"></td>
			<td width="75">&nbsp;Period</td>
			<td width="250"><input type="text" style="width:60" class="input" value="" maxlength="6" name="fm_prd1" dataformat="ym" style="text-align:center">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;<input type="text" style="width:60" class="input" value="" maxlength="6" name="to_prd1" dataformat="ym" style="text-align:center">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
			<td width="75">&nbsp;Location</td>
			<td width="">
				<select style="width:60;" class="input" name="loc_tp_cd">
				<option value="ALL" selected>&nbsp&nbspALL</option>
				<option value="RCC">&nbsp&nbspRCC</option>
				<option value="LCC">&nbsp&nbspLCC</option>
				<option value="SCC">&nbsp&nbspSCC</option>
				</select>&nbsp;<input type="text" style="width:81;" value="" name="loc_cd" class="input2" maxlength="5" dataformat="engup" readonly="true" style="ime-mode:disabled;text-align:center">
			    <img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="ComOpenPopupWithTargetLoc">			
			</td>
			</tr>					 
			<tr class="h23">
			<td width="90">&nbsp;Serial Range</td>
			<td width="290">			
				<input type="text" style="width:45;" value="" name="cntr_pfx_cd" class="input" maxlength="4" dataformat="engup" style="ime-mode:disabled;text-align:center">&nbsp;<input type="text" style="width:60" class="input" value="" name="fm_ser_no" maxlength="6" dataformat="int" style="ime-mode:disabled;text-align:center">&nbsp;~&nbsp;<input type="text" style="width:55" class="input" value="" name="to_ser_no" maxlength="6" dataformat="int" style="ime-mode:disabled;text-align:center">&nbsp;<input type="text" style="width:50" class="input2" value="" name="range_count" readonly style="text-align:center">			
			</td>
			<td width="75">&nbsp;Lease Term</td>
			<td width="250">
				<select style="width:84;" class="input" name="lstm_cd">
				<option value="ALL" selected>ALL Own</option>
				<option value="OW">OW</option>
				<option value="LP">LP</option>
				<option value="OL">OL</option>
				<option value="AL">ALL Lease</option>
				<option value="LT">LT</option>
				<option value="ST">ST</option>
				</select>			
			</td>
			<td width="75">&nbsp;TP/SZ</td>
			<td width="" style="padding-left:2">
				<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 170, 1);</script>		
				<div style="display: none;"><input type="text" name="chk_cntr_tpsz_cd" style="width:150" value="" class="input" readonly></div>					
			</td>
			</tr>		
			<tr class="h23">
			<td width="90">&nbsp;Manufacturer</td>
			<td width="" colspan="5" style="padding-left:2"><script language="javascript">ComComboObject('mftr_vndr_seq',2,110,0,0,1);</script></td>								
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
			</td></tr>
		</table>
		
    <div id="tabLayer" style="display:none">
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">	
		<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
		<!-- Grid (E) -->			
		
		</td></tr>
	</table>
    </div>
    		
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
     <!-- 개발자 작업  끝 -->
</form>
</body>
</html>