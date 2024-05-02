<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3013.jsp
*@FileTitle : Demand Note Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.18 최성환
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTInvoiceMgt.demandnotesend");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();


		event = (EesDmt3013Event)request.getAttribute("Event");
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
<title>Demand Note Issue</title>
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
<!-- main -->
<input type="hidden" name="usr_ofc_cd"			value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="dmdt_chg_sts_cd">
<input type="hidden" name="dmdt_chg_sts_cd_2">
<!-- date -->
<input type="hidden" name="yd_cd1">
<input type="hidden" name="loc_cd">
<!-- vvd cd -->

<input type="hidden" name="all_office">
<!-- cntr -->

<!-- option -->



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
       			<div id="sch_cond_div" style=display:block;>
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="40">Office </td>
						<td width="100" class="sm">
						<script language="javascript">ComComboObject('office', 2, 80, 0, 1, 0, true);</script>
						</td>
						<td width="70">Tariff type </td>
						<td width="85">
						<script language="javascript">ComComboObject('tariff_type', 2, 70, 0, 1);</script>
						</td>
						<td width="50">Status</td>
						<td width="170">
						<script language="javascript">ComComboObject('status',2,80,1,1);</script>
						&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="60">Group by </td>
						<td width="150">
						<select style="width:130;" name="grp_type" class="input">
							<option value="1" selected>B/L No.(BKG No.)</option>
							<option value="2">CNTR No.</option>
						</select>
						</td>
						<td width="95" id='td_gb'>G/B&nbsp;
						<select name="chg_type" style="width:50;" class="input">
						<option value="" selected>All</option>
						<option value="G">General</option>
						<option value="B">Balance</option>
						</select>
						</td>
						<td width="">&nbsp;
						<select name="day_type" style="width:110;font-weight:bold;background-color:#F3F2F8;" class="input">
						<option value="1" selected><b>F/T Over Day</b></option>
						<option value="2"><b>Staying Day</b></option>
						</select>&nbsp;
						<input type="text" style="width:40;" name="fx_ft_ovr_dys" dataformat="int" maxlength="3" caption='F/Time Over Day'  style="width:50;text-align:right" class="input" value="">
						</td>
					</tr>
				
				</table>
				
				
				
				<table class="search_sm2" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="">
						
				<table class="search" border="0" style="width:960;"> 
					<tr class="h23">
						<td width="85"><input type="radio" name="cond_type" value="date" class="trans"checked>Date</td>
						<td width="50" class="stm">Period</td>
						<td width="275">
						<!--  
						<input type="text" style="width:80;" class="input1" value=" 2008-10-19">&nbsp;<img src="img/btns_calendar.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;~&nbsp;<input type="text" style="width:80;" class="input1" value=" 2008-11-03">&nbsp;<img src="img/btns_calendar.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">
						-->
						<input type="text" style="width:80;" class="input1" name="fm_dt" maxlength="8" dataformat="ymd"  caption="From Date">&nbsp;~&nbsp;
						<input type="text" style="width:80;" class="input1" name="to_dt" maxlength="8" dataformat="ymd"  caption="To Date" >
						<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand" >
						</td>
						<td width="50" class="stm">Location</td>
						<td width="" class="sm">
						<input type="radio" name="loc_type" value="1" class="trans" checked>From Yard&nbsp;&nbsp;&nbsp;<input type="radio" name="loc_type" value="2" class="trans">POR/DEL&nbsp;
						
						<input type="text" name="yd_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" style="width:60;" class="input">&nbsp;
						<script language="javascript">ComComboObject('yd_cd2', 2, 45 , 0);</script>
						
						</td>
						</tr>
				</table>
				<table class="search" border="0" style="width:960;"> 
					<tr class="h23">
						<td width="85"><input type="radio" name="cond_type" value="vvd_cd"  class="trans">VVD CD</td>
						<td width="50" class="stm">VVD CD.</td>
						<td width="200" class="sm">
						<input type="text" name="vvd_cd" dataformat="engup"  maxlength="9"  style="width:100;" class="input" value="">
						</td>
						<td width="50" class="stm">Port</td>
						<td width="" class="stm">
						<input type="text" name="port_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" style="width:50;" class="input">&nbsp;<input type="checkbox" name="chk_all_office" value="Y" class="trans">All Office
						</td>
						</tr>
				</table>
				
				<table class="search" border="0" style="width:960;"> 
					<tr class="h23">
						<td width="85"><input type="radio" name="cond_type" value="cntr" class="trans">CNTR</td>
						<td width="50" class="stm">BKG No.</td>
						<td width="200" class="sm"><input type="text" name="bkg_no" dataformat="engup2" maxlength="" style="width:100;ime-mode:disabled;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_bkg_multisearch" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bkg_no')"></td>
						<td width="50" class="stm">B/L No.</td>
						<td width="150" class="stm"><input type="text" name="bl_no" dataformat="engup2" maxlength="" style="width:100;ime-mode:disabled;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_bl_multisearch" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bl_no')"></td>
						<td width="60" class="stm">CNTR No.</td>
						<td width="" class="stm"><input type="text" name="cntr_no" dataformat="engup2" maxlength=""  style="width:100;ime-mode:disabled;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_cntr_multisearch" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('cntr_no')"></td>
					</tr>
				</table>
				
					</td></tr>
				</table>
				

				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="80">Customer</td>
						<td width="205"><select name="cust_type" style="width:55;" class="input">
						<option value="" selected>ALL</option>
						<option value="P">Payer</option>
						<option value="S">SHPR</option>
						<option value="C">CNEE</option>
						<option value="N">NTFY</option>
						<option value="A">A/R</option>
						</select>&nbsp;<input type="text" name="cust_cd"  dataformat="engup"  maxlength=8  style="width:100;" class="input" caption="Customer Code"> <img src="img/btns_search.gif"	name="btns_search1" width="19"height="20"alt=""border="0" align="absmiddle"class="cursor" onClick="openPopup('cust_cd')"></td>
						<td width="104">Service Provider</td>
						<td width="150" class="stm"><input type="text" name="svc_provdr" maxlength="6"  dataformat="int" fulfill style="width:100;"  class="input" value="" caption="Service Provider"> <img src="img/btns_search.gif"	name="btns_search2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('svc_provdr')"></td>
						<td width="60">S/C No.</td>
						<td width="150" class="stm"><input type="text" name="sc_no" dataformat="engup" maxlength=20  style="width:100;"  class="input" value="" caption="S/C No."></td>
						<td width="60">RFA No.</td>
						<td width="" class="stm"><input type="text" name="rfa_no"  dataformat="engup" maxlength=11  style="width:100;" class="input" value="" caption="RFA No."></td>
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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_minimize">Minimize</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_demand" id="btn_demand">Demand
					</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_grp_demand" id="btn_grp_demand" title="Demand Note Issue by Tariff/Payer Group">Group Demand
					<!--  <a href="javascript:ComOpenWindow2('http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/dmt/jsp/UI_DMT_3108.jsp','p','scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=936,height=498,left=0,top=0');">Group Demand</a> -->
					</td>
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
	</td></tr>
</table>
<!-- Copyright (S) -->
<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>
<!-- Copyright(E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>