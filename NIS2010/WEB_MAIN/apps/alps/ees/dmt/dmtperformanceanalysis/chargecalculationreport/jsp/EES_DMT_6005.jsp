<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_6005.jsp
*@FileTitle : Summary Report by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.29 황효근
* 1.0 Creation
* 2011.03.31 김태균 [CHM-201109290-01] Split 12-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt6005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt6005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTPerformanceAnalysis.ChargeCalculationReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strUsr_ofc		= account.getOfc_cd();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();


		event = (EesDmt6005Event)request.getAttribute("Event");
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
<title>Summary Report by Customer</title>
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
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="start_dt">
<input type="hidden" name="end_dt">
<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd">
<input type="hidden" name="cost_yrmon">
<input type="hidden" name="fm_aply_dt">
<input type="hidden" name="to_aply_dt">

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
       			<div id="sch_cond_div" style=display:block;>
       		
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						
						<td width="110" class="stm">
						<select name="opt_date" style="width:110;" class="input" onChange="optDate(this.value)">
						<option value="MVMT_DT" selected>To MVMT Date</option>
						<option value="APP_DT">Applicable Date</option>
						<option value="REV_MON">R. Month</option>
						</select>
						</td>
						
						<td>
						<div id="mvmtDt" style="display:inline">
						<table class="search" border="0">
						  <tr class="h23">
						  	<td width="200">
							<input type="text" style="width:70;" class="input1" name="fm_dt" maxlength="8" dataformat="ymd" style="text-align:center" caption="Period From Date">&nbsp;~
							<input type="text" style="width:70;" class="input1" name="to_dt" maxlength="8" dataformat="ymd" style="text-align:center"  caption="Period To Date" >&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
							</tr>
							</table>
						</div>
						<div id="appDt" style="display:none">
						<table class="search" border="0" >
						<tr class="h23">
							<td width="200">
							<input type="text" style="width:70;" class="input1" name="fm_aply_dt1" maxlength="8" dataformat="ymd" style="text-align:center" caption="Period From Date">&nbsp;~
							<input type="text" style="width:70;" class="input1" name="to_aply_dt1" maxlength="8" dataformat="ymd" style="text-align:center"  caption="Period To Date" >&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar1" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
							</tr>
						</table>	
						</div>
						<div id="revMon" style="display:none">
							<table class="search" border="0">
							<tr>
							<td width="200">
							<input type="text" style="width:70;" class="input1" name="cost_yrmon1" maxlength="8" style="text-align:center" dataformat="ym"  caption="Period To Date" >&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
							</tr>
							</table>
						</div>
						</td>
						
						<td width="76">Tariff Type </td>
						<td width="268"><script language="javascript">ComComboObject('tariff_type',2,218,1,1,0,false);</script>&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td>
							<table class="search_sm2" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="70">&nbsp;&nbsp;&nbsp;Currency</td>
								<td class="stm"><input type="radio" name="curr_flg" value="U" class="trans" checked> USD&nbsp;&nbsp;&nbsp;<input type="radio" name="curr_flg" value="L" class="trans">Local</td>
							</tr>
							</table>
						</td>
					</tr>
				</table>
				
				
				
				
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search_sm2" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="">
						
				<table class="search" border="0" style="width:960;"> 
					<tr class="h23">
						<td width="82"><input type="radio" name="sch_flg" value="SC" class="trans" checked>&nbsp;S/C No.</td>
						<td width="80"><input type="radio" name="sch_flg" value="RFA" class="trans">&nbsp;RFA No.</td>
						<td width="193"><input type="text" name="sc_rfa_no"  dataformat="engnum2" maxlength='20' style="width:98;" class="input1">&nbsp;<img src="img/btns_multisearch.gif" name="btns_multisearch" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="130">Contract Office</td>
						<td width="135"><input type="text" name="ctrt_ofc" dataformat="engup" maxlength='6' style="width:85;" class="input">&nbsp;<img src="img/btns_search.gif" name="btns_ctrt_ofc" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="" class="sm">&nbsp;</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:960;"> 
					<tr class="h23">
						<td width="60">Customer</td>
						<td width="50"><input type="radio" name="cust_flg" value="CUST" class="trans" checked onclick="cust_click()">&nbsp;CUST</td>
						<td width="60"><input type="radio" name="cust_flg" value="BKG" class="trans" onclick="cust_click()">&nbsp;BKG</td>
						<td width=""><script language="javascript">ComComboObject('cust_type', 1, 80 , 1)</script> 
                        &nbsp;<input type="text" name="cust_cd" dataformat="engnum" style="width:68;" class="input">&nbsp;<img src="img/btns_search.gif" name="btns_customer" width="19" height="20" alt=""border="0"align="absmiddle"class="cursor">&nbsp;<input type="text" name="cust_nm" readonly style="width:408;" class="input2"></td>
					</tr>
				</table>
			</td></tr>
			</table>
			<table class="search" border="0" style="width:960;"> 
				<tr class="h23">
					<td width="90">Coverage</td>
					<td width="50" class="stm">Location</td>
					<td width="245"><input type="text" name="cvr_cd" dataformat="engnum" maxlength='5' style="width:63;" class="input"></td>
					<td width="100">DEM/DET Office</td>
					<td width="122" class="sm"><input type="radio" name="ofc_flg" value="R" class="trans" checked>&nbsp;RHQ&nbsp&nbsp&nbsp<input type="radio" name="ofc_flg" value="O" class="trans">&nbsp;Office</td>
					<td width="98"><script language="javascript">ComComboObject('office',1,75,0,0,0,true);</script>&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
					<td width="" class="sm"><input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans">Incl. Sub Office</td>
					<!-- 
			   	 		2017.07.04 : 2017.CSR #1386: [DMT] Report 내 조회 기능 추가 요청
			   	 		Monthly Invoiced & Collection by Office 메뉴에 존재하는 'Incl. CNTR Column' 체크 유/무 기능을 동일하게 추가 요청 드립니다.
			        	(Summary Report by Customer 에 존재하는 Incl. D/C column과는 별개)					
					 -->
					<td width="">&nbsp;&nbsp;&nbsp;<input type="checkbox" name="incl_cntr" value="Y" class="trans" checked>Incl. CNTR Column</td>
				</tr>
			</table>	
			<table class="search" border="0" style="width:960;"> 
				<tr class="h23">
					<td width="90">BKG Location</td>
					<td width="50" class="stm">POR</td>
					<td width="85"><input type="text" name="por_cd" dataformat="engnum" maxlength='5' style="width:63;" class="input"></td>
					<td width="30" class="stm">POL</td>
					<td width="85"><input type="text" name="pol_cd" dataformat="engnum" maxlength='5' style="width:63;" class="input"></td>
					<td width="30" class="stm">POD</td>
					<td width="85"><input type="text" name="pod_cd" dataformat="engnum" maxlength='5' style="width:63;" class="input"></td>
					<td width="30" class="stm">DEL</td>
					<td width="120"><input type="text" name="del_cd" dataformat="engnum" maxlength='5' style="width:63;" class="input"></td>
					<td width="80">S. TTL Level</td>
					<td width="130"><select name="sttl_lvl" style="width:120;" class="input">
						<option value="4" selected>Coverage</option>
						<option value="3">DEM/DET Office</option>
						<option value="2">Tariff</option>
						<option value="1">S/C & RFA No</option>
						</select></td>
					<td width=""><input type="checkbox" name="incl_dc" value="Y" class="trans" checked>Incl. D/C Column</td>
				</tr>
			</table>
			</div>		
			<!--  biz_1  (E) -->
			
			
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
					<td class="btn1" name="btn_Detail">Detail</td>
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


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>