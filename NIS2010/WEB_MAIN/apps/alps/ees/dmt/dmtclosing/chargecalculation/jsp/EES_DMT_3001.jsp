<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_3001.jsp
*@FileTitle : Charge Calculation by Office & VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.05.21 황효근
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	
	String callFlag	= JSPUtil.getParameter(request, "call_flag", "M");
	String bodyProp = "";
	String tableProp = "";
	
	if (callFlag.equals("M")) {
		//Main 화면일 경우
		tableProp 	= "cellpadding='0' cellspacing='0' style='padding-top:2;padding-left:5;'";
	}
	else {
		//PopUp 화면일 경우 (callFlag == "P")
		bodyProp	= "class='popup_bg'";
		tableProp	= "class='popup' cellpadding='5'";
	}

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strUsr_ofc		= account.getOfc_cd();
		strUsr_Cnt_cd	= account.getCnt_cd();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();
		
		event = (EesDmt3001Event)request.getAttribute("Event");
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
<title>Charge Calculation by Office & VVD</title>
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

<body  <%=bodyProp%> onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="call_flag"			value="<%=callFlag%>">
<input type="hidden" name="usr_cnt_cd"			value="<%=strUsr_Cnt_cd%>">
<input type="hidden" name="usr_ofc_cd"			value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="ofc_cd"				value="<%=JSPUtil.getParameter(request, "ofc_cd", "")%>">
<input type="hidden" name="dmdt_trf_cd"			value="<%=JSPUtil.getParameter(request, "dmdt_trf_cd", "")%>">
<input type="hidden" name="dmdt_chg_sts_cd"		value="<%=JSPUtil.getParameter(request, "dmdt_chg_sts_cd", "")%>">
<input type="hidden" name="fm_mvmt_yd_cd">
<input type="hidden" name="to_mvmt_yd_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="fm_mvmt_dt">
<input type="hidden" name="to_mvmt_dt">
<input type="hidden" name="yd_cd1">
<input type="hidden" name="loc_cd">
<input type="hidden" name="loc_rhq_cd">
<input type="hidden" name="chk_yd_cd"			value="Y">
<input type="hidden" name="chk_loc_cd"			value="Y">

<input type="hidden" name="inact_sts_cd">
<input type="hidden" name="aft_dar_sts_cd"> <!-- 2016.07.12 Edit  -->

<input type="hidden" name="bkg_rcv_term_cd">
<input type="hidden" name="bkg_de_term_cd">
<input type="hidden" name="ch">
<input type="hidden" name="curr_cd">

<!-- 2016.08.02 EES_DMT_3104 수정에 의한 추가 -->
<input type="hidden" name="ui_id" value="EES_DMT_3001">	

<table width="100%" border="0" <%=tableProp%> >
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<script language="javascript">DmtComPageTitle(<%=(callFlag.equals("P")?"true":"false")%>);</script>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<table class="search"> 
       		<tr><td class="bg">
       		<div id="sch_cond_div" style=display:block;>
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:900;"> 
					<tr class="h23">
						<td width="40">Office </td>
						<td width="40">
						<script language="javascript">ComComboObject('office',2,80,0,1,0,true);</script>
						</td>
						<td width="70">Tariff Type </td>
						<td width="90"><script language="javascript">ComComboObject('tariff_type',2,85,1,1);</script>
						</td>
						<td width="45">Status</td>
						<td width="80"><script language="javascript">ComComboObject('status',2,80,1,1);</script>
						</td>
						<td width="80">Charge Type</td>
						<td width="80"><select name="chg_type" style="width:80;" class="input">
						<option value="" selected>All</option>
						<option value="G">General</option>
						<option value="B">Balance</option>
						</select></td>
						<td width="100">F/Time Over Day </td>
						<td width="60"><input type="text" name="fx_ft_ovr_dys" dataformat="int" maxlength="3" minnum='0' caption='F/Time Over Day'  style="width:50;text-align:right" class="input" value="0"></td>
						<td id="tdUC" width="20">UC</td>
						<td width="45"><select name="uclm_flg" style="width:40;" class="input">
						<option value="ALL" selected>All</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td>
					</tr>
				
				</table>
				
				<table class="search_sm2" border="0" style="width:100%;"> 
					<tr class="h23"><td>
			
				<table class="search" border="0" style="width:750;"> 
					<tr class="h23">
						<td width="80"><input type="radio" name="cond_type" value="date" class="trans" checked>Date</td>
						<td width="50" class="stm">Period</td>
						<td width="245">
							<input type="text" style="width:80;" class="input1" name="fm_mvmt_dt1" maxlength="8" dataformat="ymd"  caption="Period From Date">&nbsp;~&nbsp;
							<input type="text" style="width:80;" class="input1" name="to_mvmt_dt1" maxlength="8" dataformat="ymd"  caption="Period To Date" >&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar" width="19" height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="50" class="stm">Yard</td>
						<td width="" class="sm"><input type="radio" name="yard_fmto" value="yard_fm"  checked class="trans">From&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="yard_fmto" 
							value="yard_to" class="trans">To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="yd_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" 
							style="width:49;" class="input">&nbsp;
							<script language="javascript">ComComboObject('yd_cd2', 2, 45 , 0);</script></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="80"><input type="radio" name="cond_type" value="vvd_cd" class="trans">VVD CD</td>
						<td width="50" class="stm">VVD CD</td>
						<td width="245" class="sm"><input type="text" name="vvd_cd" dataformat="engup"  maxlength="9"  style="width:80;" class="input" value=""></td>
						<td width="45" class="stm">Port</td>
						<td width="140" class="stm"><input type="text" name="tmnl_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" style="width:50;" class="input" value="">&nbsp;
						<!--<script language="javascript">ComComboObject('tmnl_cd2', 2, 60 , 0);</script>--></td>
						<td width="62" class="stm">DEM Type</td>
						<td width="130" class="stm"><select name="dem_type" style="width:98;" class="input">
						<option value="" selected>All</option>
						<option value="I">Intransit </option>
						<option value="L">Local</option>
						</select></td>
						<td width="" class="stm"><input type="checkbox" name="bypodeta" value="vvd_cd" class="trans">by POD ETA</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="80"><input type="radio" name="cond_type" value="cntr" class="trans">CNTR</td>
						<td width="50" class="stm">BKG No.</td>
						<td width="245" class="sm"><input type="text" name="bkg_no" dataformat="engup2" maxlength="" style="width:100;ime-mode:disabled;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif"
							name="btns_multisearch1" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bkg_no')"></td>
						<td width="45" class="stm">B/L No.</td>
						<td width="140" class="stm"><input type="text" name="bl_no" dataformat="engup2" maxlength="" style="width:100;ime-mode:disabled;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif"
							name="btns_multisearch2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bl_no')"></td>
						<td width="60" class="stm" >CNTR No.</td>
						<td width="131" class="stm" style="padding-left:2"><input type="text" name="cntr_no" dataformat="engup2" maxlength=""  style="width:98;ime-mode:disabled;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif"
							name="btns_multisearch3" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('cntr_no')"></td>
						<td width="" class="stm"><input type="checkbox" name="bypodeta" value="cntr" class="trans">by POD ETA</td>
					</tr>
				</table>
				
				</td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="45">Customer</td>
						<td width="160"><select name="cust_type" style="width:60;" class="input">&nbsp;<option value="" selected>ALL</option>
						<option value="P">Payer</option>
						<option value="S">SHPR</option>
						<option value="C">CNEE</option>
						<option value="N">NTFY</option>
						<option value="A">A/R</option>
						</select>&nbsp;<input type="text" name="cust_cd"  dataformat="engup"  maxlength=8  style="width:65;" class="input" caption="Customer Code">&nbsp;<img src="img/btns_search.gif"
							name="btns_search1" width="19"height="20"alt=""border="0" align="absmiddle"class="cursor"	onClick="openPopup('cust_cd')"></td>
						<td width="10">S/P</td>
						<td width="75" class="stm"><input type="text" name="svc_provdr" maxlength="6"  dataformat="int" fulfill style="width:50;"  class="input" value="" caption="Service Provider">&nbsp;<img src="img/btns_search.gif"
							name="btns_search2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('svc_provdr')"></td>
						<td width="47">S/C No.</td>
						<td width="85" class="stm" style="padding-left:2"><input type="text" name="sc_no" dataformat="engup" maxlength=20  style="width:85;"  class="input" value="" caption="S/C No."></td>
						<td width="50">RFA No.</td>
						<td width="85" class="stm"><input type="text" name="rfa_no"  dataformat="engup" maxlength=11  style="width:85;" class="input" value="" caption="RFA No."></td>
						<td width="89">Display Option</td>
						<td width="182"><script language="javascript">ComComboObject('opt_item_list',1,182,1);</script></td>
						<td width="46"></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="93" class="stm">Inactive No.</td>
						<td width="180" class="stm"><input type="text" name="inact_no" dataformat="engup2" maxlength="" style="width:140;ime-mode:disabled;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif"
							name="btns_multisearch4" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('inact_no')"></td>
						<td width="125">Inactive Status</td>
						<td width="" class="sm"><script language="javascript">ComComboObject('inact_sts',1,180,0,0,0,true);</script></td>
						
						<!-- 2016.07.12 Edit -->
						<td width="125">AFT DAR Status</td>
						<td width="" class="sm"><script language="javascript">ComComboObject('aft_dar_sts',1,180,0,0,0,true);</script></td>
						<!-- 2016.07.12 Edit -->
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
				
				<!-- Hidden Grid  (S) -->
				<table width="100%"  id="mainTable2" style=display:none;>
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->
				
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
					
	

	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
	
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:2;"> 
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
					<td class="btn1" name="btn_Confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Demand">Demand</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_GRPDemand">GRP Demand</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Billing">Billing</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_GRPINVCreation">GRP INV Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OFCTrans">OFC Trans</a></td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ByETA" id="btn_ByETA">by ETA</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>					
		</tr>
		</table>
    <!--Button (E) -->
    <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
	    		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Inactive Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DelReqCancel" id="btn_DelReqCancel">Inactive REQ Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td-->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ByBKG">by BKG</td>
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
					<td class="btn1" name="btn_ExceptionInq">Exception Inq.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
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

	</td></tr>
</table>

<!-- : ( Button : pop ) (S) -->
<div id="btnCloseLayer" style="display:none">
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
    	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
			</table>
		</td></tr>
	</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
</div>
<!-- : ( Button : pop ) (E) -->

<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>