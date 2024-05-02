<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_3002.jsp
*@FileTitle : Charge Calculation by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.06.13 황효근
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_Cnt_cd	= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTClosing.ChargeCalculation");
	
	// 팝업 페이지로 호출시 받아오는 파라미터 값들
	String bkgNo		= JSPUtil.getParameter(request, "bkg_no", "");
	String blNo			= JSPUtil.getParameter(request, "bl_no", "");
	String dmdtTrfCd	= JSPUtil.getParameter(request, "dmdt_trf_cd", "");
	String dmdtChgStsCd	= JSPUtil.getParameter(request, "dmdt_chg_sts_cd", "");
	String callFlag		= JSPUtil.getParameter(request, "call_flag", "M");
	String bkgFlg		= JSPUtil.getParameter(request, "bkg_flg", "N");
	
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
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Cnt_cd = account.getCnt_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();

		event = (EesDmt3002Event)request.getAttribute("Event");
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
<title>Charge Calculation by Booking</title>
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
<input type="hidden" name="usr_cnt_cd"			value="<%=strUsr_Cnt_cd%>">
<input type="hidden" name="call_flag"			value="<%=callFlag%>">
<input type="hidden" name="dmdt_trf_cd"			value="<%=dmdtTrfCd%>">
<input type="hidden" name="dmdt_chg_sts_cd"		value="<%=dmdtChgStsCd%>">
<input type="hidden" name="est_mk">
<input type="hidden" name="sch_chg_sts">
<input type="hidden" name="ar_act_cd">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="rhq_ofc_cd">
<input type="hidden" name="backendjob_key">		<!-- BackEndJob Key -->
<input type="hidden" name="backendjob_id">		<!-- BackEndJob 구분 ID -->

<input type="hidden" name="bkg_flg"				value="<%=bkgFlg%>">
<input type="hidden" name="bkg_rcv_term_cd">
<input type="hidden" name="bkg_de_term_cd">
<input type="hidden" name="ch">
<input type="hidden" name="curr_cd">
<input type="hidden" name="fm_mvmt_yd_cd">
<input type="hidden" name="to_mvmt_yd_cd">

<!-- 2016.08.02 EES_DMT_3104 수정에 의한 추가 -->
<input type="hidden" name="ui_id" value="EES_DMT_3002">


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
       		
       			<div id="mini_div" style=display:block;>
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">BKG No.</td>
						<td width="120"><input type="text" name="bkg_no" value="<%=bkgNo%>" dataformat="engup" maxlength="13"  caption="BKG No."  style="width:110;" class="input1" value=""></td>
						<td width="50">B/L No. </td>
						<td width="120"><input type="text" name="bl_no" value="<%=blNo%>" dataformat="engup" maxlength="12"   caption="B/L No."  style="width:110;" class="input1" value=""></td>
						<td width="70">Tariff Type</td>
						<td width="80"><script language="javascript">ComComboObject('tariff_type',2,65,1,1);</script></td>
						<td width="47">Status</td>
						<td width="130"><script language="javascript">ComComboObject('status',2,100,1,1);</script>&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="35">RHQ</td>
						<td width="80"><script language="javascript">ComComboObject('rhq_ofc',2,70,1,1);</script></td>
						<td id="tdUC" width="20">UC</td>
						<td width="45"><select name="uclm_flg" style="width:40;" class="input">
						<option value="ALL" selected>All</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td>
						<td width="" class="stm"><input type="checkbox" name="bypodeta" value="booking" class="trans">by POD ETA</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">VVD CD</td>
						<td width="130"><input type="text" name="vvd_cd"  maxlength="9" style="width:110;" class="input2" value="" readonly></td>
						<td width="30">ATA</td>
						<td width="130"><input type="text" name="vps_eta_dt"  style="width:80;" class="input2" value="" caption="ATA" readonly></td>
						<td width="30">ATB</td>
						<td width="130"><input type="text" name="vps_etb_dt"  style="width:80;" class="input2" value="" caption="ATB" readonly></td>
						<td width="30">ATD</td>
						<td width="130"><input type="text" name="vps_etd_dt"  style="width:80;" class="input2" value="" caption="ATD" readonly></td>
						<td width="60">Pre Port</td>
						<td width="100"><input type="text" name="pre_rly_port_cd"  style="width:60;" class="input2" readonly></td>
						<td width="65">Post Port</td>
						<td width=""><input type="text" name="pst_rly_port_cd" style="width:60;" class="input2" readonly></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">POR</td>
						<td width="130"><input type="text" name="por_cd" style="width:110;" class="input2" readonly></td>
						<td width="30">POL</td>
						<td width="130"><input type="text" name="pol_cd" style="width:80;" class="input2" readonly></td>
						<td width="30">POD</td>
						<td width="130"><input type="text" name="pod_cd" style="width:80;" class="input2" readonly></td>
						<td width="30">DEL</td>
						<td width="130"><input type="text" name="del_cd" style="width:80;" class="input2" readonly></td>
						<td width="60">R/D</td>
						<td width="100"><input type="text" name="rd_term_cd" style="width:60;" class="input2" readonly></td>
						<td width="65">&nbsp; </td>
						<td width="">&nbsp;</td>
					</tr>
				</table>
				
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="480">
						
						<table class="grid2" border="0" style="width:480;"> 
							<tr class="h23">
								<td class="tr2_head" width="50">SHPR</td>
								<td width="68" class="noinput2"><input type="text" name="shipper_cd"  readonly style="width:66;" class="noinput2"></td>
								<td width="" class="noinput2"><input type="text" name="shipper_nm" readonly style="width:350;" class="noinput2" ></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head" width="50">CNEE</td>
								<td width="68" class="noinput2"><input type="text" name="cnee_cd" readonly style="width:66;" class="noinput2" ></td>
								<td width="" class="noinput2"><input type="text" name="cnee_nm" readonly style="width:350;" class="noinput2" ></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head" width="50">NTFY</td>
								<td width="68" class="noinput2"><input type="text" name="ntfy_cd" readonly style="width:66;" class="noinput2" ></td>
								<td width="" class="noinput2"><input type="text" name="ntfy_nm"  readonly style="width:350;" class="noinput2" ></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head" width="50">S/P</td>
								<td width="68" class="noinput2"><input type="text" name="svc_provdr_cd" readonly style="width:66;" class="noinput2" ></td>
								<td width="" class="noinput2"><input type="text" name="svc_provdr_nm"  readonly  style="width:350;" class="noinput2"></td>
							</tr>
						</table>
						
						</td>
						<td width="19">&nbsp;&nbsp;&nbsp;</td>
						<td width="480">
						
						<table class="grid2" border="0" style="width:480;" style="border-bottom:1px solid #E8EFF9;"> 
							<tr class="h23">
								<td width="50"	class="tr2_head">S/C No.</td>
								<td width="90" class="noinput2"><input type="text" name="sc_no" style="width:88;" class="noinput2" readonly></td>
								<td width="60"	class="tr2_head">RFA No.</td>
								<td width="90"	class="noinput2"><input type="text" name="rfa_no" value="" style="width:87;" class="noinput2" readonly></td>
								<td width="75"	class="tr2_head" >A/Customer</td>
								<td width=""	class="noinput2"><input type="text" name="acust" style="width:75;" class="noinput2" readonly></td>
							</tr><tr class="h23">
								<td width="50" class="tr2_head">CMDT</td>
								<td width="90" class="noinput2"><input type="text" name="cmdt_cd" style="width:87;" class="noinput2" readonly></td>
								<td width="" class="noinput2" colspan="4"><input type="text" name="cmdt_nm" style="width:300;" class="noinput2" readonly></td>
							</tr>
						</table>
						<table class="grid2" border="0" style="width:480;" style="border-bottom:1px solid #E8EFF9;"> 
							<tr class="h23">
								<td width="90" class="tr2_head">Rep.CMDT</td>
								<td width="50" class="noinput2"><input type="text" name="rep_cmdt_cd" style="width:48;" class="noinput2" readonly></td>
								<td class="noinput2" width=""><input type="text" name="rep_cmdt_nm"  style="width:320;" class="noinput2" value="" readonly></td>
							</tr>
						</table>
						<table class="grid2" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="50" class="tr2_head">S/Office</td>
								<td width="90" class="noinput2"><input type="text" name="sls_ofc_cd" style="width:88;" class="noinput2" readonly></td>
								<td width="60"  class="tr2_head" id='tdROffice'>R/Office </td>
								<td width="60"  class="noinput2"><input type="text" name="rlse_ofc" style="width:100%;" class="noinput2" readonly></td>
								<td width="50" class="noinput2"><input type="text" name="d_o" style="width:100%;" class="noinput2" readonly></td>
								<td width="25" class="noinput2"><input type="text" name="partial" style="width:100%;text-align:center;" class="noinput2" readonly></td>
								<td width="" class="noinput2"><input type="text" name="rlse_dt" style="width:100%;" class="noinput2" readonly></td>
							</tr>
						</table>
						
						</td>
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
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="70">CNTR Q'TY</td>
					<td width="50"><input type="text" name="cntr_qty" style="width:40;text-align:right;"  class="input2" readonly ></td>
					<td width="110">Total Billable AMT </td>
					<td width="250"><input type="text" name="bzc_trf_curr_cd"  value="" style="width:30;" class="input2" readonly >&nbsp;<input type="text" name="tot_bil_amt"  style="width:170;text-align:right;" class="input2" readonly></td>
					<td>
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			      	 	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr class="h23">
								<td width="60" id="tdDRDate">D/R Date</td>
								<td width="120"><input type="text" name="dr_dt" dataformat="ymd" maxlength="8" caption="D/R Date"  style="width:80;" class="input">&nbsp;<img src="img/btns_calendar.gif" 
									name="btns_calendar" width="19" height="20" alt="Delivery & Return Date" border="0" align="absmiddle"class="cursor"></td>
								
								<td><table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_PreCal" id="btn_PreCal">Pre Cal.</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_DRSave">D/R Save</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_Balance">Balance Creation</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
							</tr></table>
					</td></tr>
					</table>
					</td>
			    	<!-- Button_Sub (E) -->
				</tr>
				</table>
		</td></tr>
	</table>
	<!-- : ( Search Options ) (E) -->
	
<!-- Tab BG Box  (S) -->
<!--biz page (E)-->
	


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
					<td class="btn1" name="btn_Billing">Billing</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OFCTrans">OFC Trans</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Inactive Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DelReqCancel" id="btn_DelReqCancel">Inactive REQ Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				 -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ByETA" id='btn_ByETA'>by ETA</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		   </tr>
		</table>
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Recalc">Charge Recalculation</td>
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
					<td class="btn1" name="btn_ROInfo" id="btn_ROInfo">R/O Info.</td>
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