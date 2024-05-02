<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0495.jsp
*@FileTitle : T/S List by 1st VSL & 2nd VSL T/S Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.02 최영희
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0495Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 

<%
	EsmBkg0495Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TransshipmentMgt.TransshipmentMgt");
    

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0495Event)request.getAttribute("Event");
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
<title>T/S List by 1st VSL & 2nd VSL T/S Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="disc_load_cd">
<input type="hidden" name="arrblno">
<input type="hidden" name="vsl_Nm">
<input type="hidden" name="param">
<input type="hidden" name="sys_app" value="BKG">
<input type="hidden" name="mrd" value="ESM_BKG_0877.mrd">
<input type="hidden" name="batch_no" value="N">
<input type="hidden" name="chkport">
<input type="hidden" name="chkvvd">
<input type="hidden" name="vvd">
<input type="hidden" name="rdtitle">
<input type="hidden" name="vps_dt_flag">
 

<!-- 개발자 작업	-->
<!--Page Title, Historical (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top"> 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!--Page Title, Historical (E)-->
	
	
		<!--biz page (S)-->
		<table class="search" > 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="75">&nbsp;&nbsp;Relay Port</td>
					<td width="125"><input type="text" style="width:60;" class="input1" value="" name="loc_cd" maxlength="5" dataformat="engup">&nbsp;<input type="text" style="width:30;" class="input" value="" name="loc_yd_cd" maxlength="7" dataformat="engup"></td>
					<td width="90"><input type="radio" class="trans" checked name="search_kind_cd" value="A">ETA<input type="radio" class="trans" checked name="search_kind_cd" value="E">ETD</td>
					<td width="120"><input type="text" style="width:80;" value="" class="input1" name="vps_etd_dt" dataformat="ymd">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_calendar"></td>
					<td width="30">VVD</td>
					<td width="115"> 
					    <!--<select style="width:95;" class="input1" name="vvd" >&nbsp; 
						</select>-->
						<script language="javascript">ComComboObject('vvdList', 1, 95, 0, 0,0,true);</script>
					</td>
					<td width="30">POL</td>
					<td width="110"><input type="text" style="width:80;" class="input" value="" name="pol_cd" maxlength="5" dataformat="engup"></td>
					<td width="30">POD</td>
					<td width="110"><input type="text" style="width:80;" class="input" value="" name="pod_cd" maxlength="5" dataformat="engup"></td>
					<td align="right">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Ts_Summary">T/S Summary</td>
							<td class="btn2_right"></td>
							</tr>
							</table> 
					</td>
				</tr>
				</table>
						
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="410"><table border="0" style="width:310;" class="search_sm2"> 
						<tr class="h23">
							<td width="71"><input type="radio" class="trans" name="search_kind_cd" value="D">Duration</td>
							<td><input type="text" style="width:80;" class="input1" value="" dataformat="ymd" name="dur_from">&nbsp;&nbsp;~&nbsp&nbsp;<input type="text" style="width:80;" class="input1" value="" dataformat="ymd" name="dur_to">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_Duration"></td></tr>
						</table>
					</td>
					<td width="30">OOP</td>
					<td width="110"><input type="text" style="width:20;" class="input" value="" name="op_cd" maxlength="2" dataformat="engup"></td>
					<td width="350">
						<table border="0" style="width:340;" class="search_sm2"> 
						<tr class="h23">
							<td width="70">&nbsp;&nbsp;&nbsp;Special</td>
							<td width="" class="sm">
							<input type="radio" class="trans" name="special" value="All">&nbsp;All&nbsp;&nbsp;
							<input type="radio" class="trans" name="special" value="DG">&nbsp;D/G&nbsp;&nbsp;
							<input type="radio" class="trans" name="special" value="RF">&nbsp;R/F&nbsp;&nbsp;
							<input type="radio" class="trans" name="special" value="AK">&nbsp;A/K&nbsp;&nbsp;
							<input type="radio" class="trans" name="special" value="ST">&nbsp;S/T&nbsp;&nbsp;
							<input type="radio" class="trans" name="special" value="RD">&nbsp;R/D&nbsp;&nbsp;
							<input type="radio" class="trans" name="special" value="SO">&nbsp;SOC</td></tr>
						</table>
					</td>
					
					<td width="">
						<table border="0" style="width:110;" class="search_sm2"> 
						<tr class="h23">
							<td width="100" class="sm">
							<input type="radio" class="trans" checked name="special" value="SD">&nbsp;Special + Dry</td></tr>
						</table>						
					</td>
					</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		
		<!-- Tab (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
					<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td></tr>
			</table>
		<!-- Tab (E) -->

<!--TAB Discharging (S) -->

<div id="tabLayer" style="display:inline">		
		
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
			
			<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t1sheet1');</script>
							</td>
						</tr>
					</table>
			<!-- Grid (E) -->	
			<table class="search" border="0" width="100%"> 
					<tr class="h23">
						<td width="110" align="right">Total 20'</td>
						<td width="120" align="left"><input type="text" name="tot_20_1" style="width:100; text-align:right;"  readonly></td>
						<td width="110" align="right">Total 40'</td>
						<td width="120" align="left"><input type="text" name="tot_40_1" style="width:100; text-align:right;"  readonly></td>
						<td width="130" align="right">Grand Weight</td>
						<td width="" class="stm" align="left"><input type="text" name="tot_weight_1" style="width:100; text-align:right;"  readonly>&nbsp;TON</td>						
						</tr>
			</table>
				
		</td></tr>
		</table>

</div>

<!--TAB Loading (E) -->


<!--TAB Loading (S) -->

<div id="tabLayer" style="display:none">		
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->		 
			<table class="search" border="0" width="100%"> 
					<tr class="h23">
						<td width="110" align="right">Total 20'</td>
						<td width="120" align="left"><input type="text" name="tot_20_2" style="width:100; text-align:right;"  readonly></td>
						<td width="110" align="right">Total 40'</td>
						<td width="120" align="left"><input type="text" name="tot_40_2" style="width:100; text-align:right;"  readonly></td>
						<td width="130" align="right">Grand Weight</td>
						<td width="" class="stm" align="left"><input type="text" name="tot_weight_2" style="width:100; text-align:right;"  readonly>&nbsp;TON</td>						
						</tr>
			</table>
			</td></tr>
		</table>

</div>

<div id="tabLayer" style="display:none">	
		
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
			
			<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t3sheet1');</script>
							</td>
						</tr>
					</table>
			<!-- Grid (E) -->	
			
				
		</td></tr>
		</table>

</div>

<!--TAB Loading (E) -->

		<!--biz page (E)-->
		
		
	</td></tr>
		</table>
	

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_CheckAll" id="btn_CheckAll">Check All</td>
					<td class="btn1" name="btn_UnCheckAll" id="btn_UnCheckAll">UnCheck All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Fax">Fax</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_EMail">E-mail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_FaxNoEMail">Fax/E-mail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> 
				<td><input type="text" style="width:120;" class="input" value="" name="faxmail" maxlength="50"></td>  
				</tr>
			</table>
		</td></tr>
		<tr>
		<td height="0" width="0">
			<script language="javascript">comRdObject('report1');</script>
			</td>
		</tr>
		</table>
    	<!--Button (E) -->
		
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>