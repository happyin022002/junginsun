<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0001.jsp
*@FileTitle : EQ Operation Trend (Inventory Trend)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.13 김종준
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0073Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0073Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerSupplyDemandForecast.CNTRInventoryReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
	   
		event = (EesCim0073Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//MVMT Status 멀티콤보 
	    String temp_cnmv_sts_cd = JSPUtil.getIBCodeCombo("", "", "CD02086", 0, "");
	    if(temp_cnmv_sts_cd != null && temp_cnmv_sts_cd.length() > 8) {
	    	cnmv_sts_cd = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Code = \"")+8, temp_cnmv_sts_cd.lastIndexOf("\""));
	    	cnmv_sts_nm = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Text = \"")+8, temp_cnmv_sts_cd.indexOf("\";")); 
	    }						
	    
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<LINK href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet"/>
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
    function setupPage(){
	    loadPage("<%=cnmv_sts_cd%>", "<%=cnmv_sts_nm%>");
    }

</script>

<body  onLoad="setupPage();">


<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> 
<input type="hidden" name="head_cntr_tpsz_cd" value=""> 

<!-- print 조회용 파리미터 -->
<input type='hidden' name='prt_cntr_tpsz_cd'>
<input type='hidden' name='prt_full_flg'>
<input type='hidden' name='prt_cntr_hngr_rck_cd'>
<input type='hidden' name='prt_cntr_hngr_rck_cd_o'>
<input type='hidden' name='prt_cntr_hngr_rck_cd_r'>
<input type='hidden' name='prt_cntr_hngr_bar_atch_knt'>
<input type='hidden' name='prt_disp_flg'>
<input type='hidden' name='prt_d2_payld_flg'>
<input type='hidden' name='prt_cnmv_sts_cd'>
<input type='hidden' name='prt_dmg_flg'>
<input type='hidden' name='prt_cntr_no'>
<input type='hidden' name='prt_cntr_use_co_cd'>
<input type='hidden' name='prt_lstm_cd'>
<input type='hidden' name='prt_soc_cd'>
<input type='hidden' name='prt_chk_cntr_tpsz_cd'>
<input type="hidden" name="prt_cnt_cd"  value="<%=strCnt_cd%>" >
<input type="hidden" name="inquiryLevel" value="">
<input type="hidden" name="location" value="">
<input type="hidden" name="loc_by" value="">
<input type="hidden" name="bat_flg" value="">
<input type="hidden" name="pre_bat_wk" value="">
<input type="hidden" name="ths_wk" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->

	<!--Button (S) -->
	<tr><td valign="top">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
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
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Signal">Signal</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Location by</td>
					<td width="250">
						<select style="width:115;" name="loc_type_code" class="input" ><!-- LOC_TYPE_CODE -->
							<option value="1" selected>ALL (by RCC)</option>
							<option value="3">RCC (by LCC)</option>
							<option value="8">RCC (by ECC)</option>
							<option value="4">LCC (by ECC)</option>
							<!-- loc_cd -->
						</select> 
						<input type="text" class="input2" name="loc_cd" readOnly=true style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill size="5" maxlength="5" fulfill  style="width:82;" class="input" value="">&nbsp;<!-- USNYC --><img class="cursor" src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle">
						<input type='text' name='focus_loc_cd' style="width:0" >					
					</td>
					<td>
					<table class="search_sm2" border="0"> 
						<tr class="h23">
							<td width="170">Period(YYYY-WW)
							  <input type="text" name="period" class="input2" readOnly=true style="ime-mode:inactive" style="width:58;" class="input" value="">
							</td>
						</tr>
					</table>
					
					</td>
				</tr> 
				</table>       	
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">TP/SZ</td>
					<td width="470">
						<select style="width:115;" name="tp_cd" class="input" ><!-- LOC_TYPE_CODE -->
							<option value="1" selected>ALL</option>
							<option value="2">DRY</option>
							<option value="3">RER</option>
							<option value="4">SPCL</option>
							<!-- loc_cd -->
						</select> 
						<input type="text" name="tpList" readOnly=true style="ime-mode:inactive" style="width:307;" class="input2" value="D2,D4,D5,D7,R2,R5,R9,O2,O4,F2,F4">					
					</td>
					<td width="160">DMG&nbsp;&nbsp;  
					    <select name="dmg_flg" style="width:100;" class="input">
						   <option value="" selected>Include</option>
						   <option value="N">Exclude</option>
						   <option value="Y">Only</option>
						</select>
					</td>
					<td>
					<table class="search_sm2" border="0"> 
						<tr class="h23">
							<td width="130">S.O.C&nbsp;&nbsp;
							  <input type="text" class="input2" readOnly=true style="ime-mode:inactive" style="width:80;" class="input" value="Exclude">
							</td>
						</tr>
					</table>
					</td>
				</tr> 
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!-- Grid  (S) -->
			
			
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->

			<!--  Grid_button (S) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>
</form>

</body>
</html>
