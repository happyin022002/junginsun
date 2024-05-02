<%
/*=========================================================
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3001.jsp
*@FileTitle  : Charge Calculation by Office & VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3001Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsr_Cnt_cd	= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTClosing.ChargeCalculation");
	
	String callFlag	= JSPUtil.getParameter(request, "call_flag", "M");
	String bodyProp = "";
	String tableProp = "";
	
	if (callFlag.equals("M")) {
		//in case of Main
		tableProp 	= "cellpadding='0' cellspacing='0' style='padding-top:2;padding-left:5;'";
	}
	else {
		//in case of PopUp (callFlag == "P")
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

		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- Developer's task	-->
<input type="hidden" name="call_flag" value="<%=callFlag%>" id="call_flag" />
<input type="hidden" name="usr_cnt_cd" value="<%=strUsr_Cnt_cd%>" id="usr_cnt_cd" />
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>" id="usr_ofc_cd" />
<input type="hidden" name="usr_rhq_ofc_cd" value="<%=strRhq_ofc_cd%>" id="usr_rhq_ofc_cd" />
<input type="hidden" name="usr_trf_tp" id="usr_trf_tp" />
<input type="hidden" name="ofc_cd" id="ofc_cd"				value="<%=JSPUtil.getParameter(request, "ofc_cd", "")%>">
<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd"			value="<%=JSPUtil.getParameter(request, "dmdt_trf_cd", "")%>">
<input type="hidden" name="dmdt_chg_sts_cd" id="dmdt_chg_sts_cd"		value="<%=JSPUtil.getParameter(request, "dmdt_chg_sts_cd", "")%>">
<input type="hidden" name="fm_mvmt_yd_cd" id="fm_mvmt_yd_cd" />
<input type="hidden" name="to_mvmt_yd_cd" id="to_mvmt_yd_cd" />
<input type="hidden" name="pol_cd" id="pol_cd" />
<input type="hidden" name="pod_cd" id="pod_cd" />
<input type="hidden" name="fm_mvmt_dt" id="fm_mvmt_dt" />
<input type="hidden" name="to_mvmt_dt" id="to_mvmt_dt" />
<input type="hidden" name="yd_cd1" id="yd_cd1" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="loc_rhq_cd" id="loc_rhq_cd" />
<input type="hidden" name="chk_yd_cd" value="Y" id="chk_yd_cd" />
<input type="hidden" name="chk_loc_cd" value="Y" id="chk_loc_cd" />
<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="backendjob_id" id="backendjob_id" />
<input type="hidden" name="head_office" value="<%=ConstantMgr.getHeadOfficeCode()%>" id="head_office" /><!-- HEAD OFFICE -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New"  		id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Minimize" 		id="btn_Minimize">Minimize</button><!--
		--><button type="button" class="btn_accent" name="btn_Recalc" 	id="btn_Recalc">Charge Recalculation</button><!--
		--><button type="button" class="btn_normal" name="btn_Confirm" 	id="btn_Confirm">Confirm</button><!--
		--><button type="button" class="btn_normal" name="btn_Demand" 		id="btn_Demand">Demand</button><!-- 
		--><button type="button" class="btn_normal" name="btn_GRPDemand" 	id="btn_GRPDemand">GRP Demand</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Billing" 		id="btn_Billing">Billing</button><!-- 
		--><button type="button" class="btn_normal" name="btn_GRPINVCreation" 		id="btn_GRPINVCreation">GRP INV Creation</button><!-- 
		--><button type="button" class="btn_normal" name="btn_OFCTrans" 		id="btn_OFCTrans">OFC Trans</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Delete" 		id="btn_Delete">Delete</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ByETA" 		id="btn_ByETA">by ETA</button><!-- 
		--><button type="button" class="btn_accent" name="btn_ByBKG" 	id="btn_ByBKG">by BKG</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ByCNTR"  		id="btn_ByCNTR">by CNTR</button><!-- 
		--><button type="button" class="btn_normal" name="btn_MVMTInq" 		id="btn_MVMTInq">MVMT Inq.</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ExceptionInq" 	id="btn_ExceptionInq">Exception Inq.</button><!-- 
		--><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button><!-- 
		--><a name="btnCloseLayer" id="btnCloseLayer" style="display:none"><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button></a>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry" id="sch_cond_div" style=display:block;>
		<table class="search">
			<tbody>
				<colgroup>
					<col width="40px">
					<col width="120px">
					<col width="70px">
					<col width="150px">
					<col width="50px">
					<col width="150px">
					<col width="80px">
					<col width="120px">
					<col width="110px">
					<col width="*">
			    </colgroup>
				<tr class="h23">
					<th>Office </th>
					<td><script type="text/javascript">ComComboObject('office',2,80,0,1,0,true);</script></td>
					<th>Tariff Type </th>
					<td><script type="text/javascript">ComComboObject('tariff_type',2,100,1,1);</script><!-- <img src="img/btns_multisearch.gif" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"> --><button type="button" class="multiple_inq"></button></td>
					<th>Status</th>
					<td><script type="text/javascript">ComComboObject('combo_status',2,80,1,1);</script><!-- <img src="img/btns_multisearch.gif" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"> --><button type="button" class="multiple_inq"></button></td>
					<th>Charge Type</th>
					<td><select name="chg_type" id="chg_type" style="width:80px;" class="input"><option value="" selected>All</option><option value="G">General</option><option value="B">Balance</option></select></td>
					<th>F/Time Over Day </th>
					<td><input type="text" name="fx_ft_ovr_dys" id="fx_ft_ovr_dys" dataformat="num" maxlength="3" minnum='0' caption='F/Time Over Day'  style="width:50px;text-align:right" class="input" value="0"></td>
				</tr>
			</tbody>
		</table>
		<table class="search">
			<tbody>
				<colgroup>
					<col width="80px">
					<col width="50px">
					<col width="250px">
					<col width="50px">
					<col width="140px">
					<col width="*">
			    </colgroup>
				<tr class="h23">
					<td class="sm"><input type="radio" name="cond_type" id="cond_type" value="date" class="trans" checked><strong>Date</strong></td>
					<td class="sm">Period</td>
					<td class="sm"><input type="text" style="width:80px;" class="input1" name="fm_mvmt_dt1" id="fm_mvmt_dt1" dataformat="ymd"  caption="Period From Date">&nbsp;~&nbsp;<input type="text" style="width:80px;" class="input1" name="to_mvmt_dt1" id="to_mvmt_dt1" dataformat="ymd"  caption="Period To Date" ><!-- <img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20"alt=""border="0"align="absmiddle"class="cursor"> --><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
					<td class="sm">Yard</td>
					<td class="sm"><input type="radio" name="yard_fmto" value="yard_fm"  checked class="trans">From&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="yard_fmto" value="yard_to" class="trans">To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="yd_cd" id="yd_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" style="width:49px;" class="input">&nbsp;<script type="text/javascript">ComComboObject('yd_cd2', 2, 45 , 0);</script></td>
					<td class="sm"></td>
				</tr>
			</tbody>
		</table>
		<table class="search">
			<tbody>
				<colgroup>
					<col width="80px">
					<col width="50px">
					<col width="250px">
					<col width="50px">
					<col width="135px">
					<col width="65px">
					<col width="137px">
					<col width="*">
			    </colgroup>
				<tr class="h23">
					<td class="sm"><input type="radio" name="cond_type" id="cond_type" value="vvd_cd" class="trans"><strong>VVD CD</strong></td>
					<td class="sm">VVD CD</td>
					<td class="sm"><input type="text" name="vvd_cd" id="vvd_cd" dataformat="engup"  maxlength="9"  style="width:80px;" class="input" value=""></td>
					<td class="sm">Port</td>
					<td class="sm"><input type="text" name="tmnl_cd" id="tmnl_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" style="width:50px;" class="input" value=""></td>
					<td class="sm">DEM Type</td>
					<td class="sm"><select name="dem_type" id="dem_type" style="width:98px;" class="input"><option value="" selected>All</option><option value="I">Intransit </option><option value="L">Local</option></select></td>
					<td class="sm"><input type="checkbox" name="bypodeta" id="bypodeta" value="vvd_cd" class="trans">by POD ETA</td>
				</tr>
			</tbody>
		</table>
		<table class="search">
			<tbody>
				<colgroup>
					<col width="80px">
					<col width="50px">
					<col width="250px">
					<col width="50px">
					<col width="140px">
					<col width="60px">
					<col width="135px">
					<col width="*">
			    </colgroup>
				<tr class="h23">
					<td class="sm"><input type="radio" name="cond_type" id="cond_type" value="cntr" class="trans"><strong>CNTR</strong></td>
					<td class="sm">BKG No.</td>
					<td class="sm"><input type="text" name="bkg_no" id="bkg_no" dataformat="engup" maxlength="13" style="width:100px;ime-mode:disabled;" class="input" value=""><!-- <img src="img/btns_multisearch.gif" name="btns_multisearch1" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bkg_no')"> --><button type="button" class="multiple_inq" name="btns_multisearch1" id="btns_multisearch1" onClick="openPopup('bkg_no')"></button></td>
					<td class="sm">B/L No.</td>
					<td class="sm"><input type="text" name="bl_no" id="bl_no" dataformat="engup" maxlength="13" style="width:100px;ime-mode:disabled;" class="input" value=""><!-- <img src="img/btns_multisearch.gif" name="btns_multisearch2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bl_no')"> --><button type="button" class="multiple_inq" name="btns_multisearch2" id="btns_multisearch2" onClick="openPopup('bl_no')"></button></td>
					<td class="sm" >CNTR No.</td>
					<td class="sm"><input type="text" name="cntr_no" id="cntr_no" dataformat="engup" maxlength="14"  style="width:98px;ime-mode:disabled;" class="input" value=""><!-- <img src="img/btns_multisearch.gif" name="btns_multisearch3" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('cntr_no')"> --><button type="button" class="multiple_inq" name="btns_multisearch3" id="btns_multisearch3" onClick="openPopup('cntr_no')"></button></td>
					<td class="sm"><input type="checkbox" name="bypodeta" id="bypodeta" value="cntr" class="trans">by POD ETA</td>
				</tr>
			</tbody>
		</table>
		<table class="search">
			<tbody>
				<colgroup>
					<col width="63px">
					<col width="257px">
					<col width="110px">
					<col width="150px">
					<col width="50px">
					<col width="140px">
					<col width="60px">
					<col width="*">
			    </colgroup>
				<tr class="h23">
					<th>Customer</th>
					<td><select name="cust_type" id="cust_type" style="width:63px;" class="input">
							<option value="" selected>ALL</option>
							<option value="P">Payer</option>
							<option value="S">SHPR</option>
							<option value="C">CNEE</option>
							<option value="N">NTFY</option>
							<option value="A">A/R</option>
						</select><!-- 
						 --><input type="text" name="cust_cd" id="cust_cd"  dataformat="engup"  maxlength=8  style="width:100px;" class="input" caption="Customer Code"><!-- <img src="img/btns_search.gif" name="btns_search1" width="19"height="20"alt=""border="0" align="absmiddle"class="cursor"	onClick="openPopup('cust_cd')"> --><button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1" onClick="openPopup('cust_cd')"></button>
					</td>
					<th>Service Provider</th>
					<td class="stm"><input type="text" name="svc_provdr" id="svc_provdr" maxlength="6"  dataformat="num" fulfill style="width:100px;"  class="input" value="" caption="Service Provider"><!-- <img src="img/btns_search.gif" name="btns_search2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('svc_provdr')"> --><button type="button" class="input_seach_btn" name="btns_search2" id="btns_search2" onClick="openPopup('svc_provdr')"></button></td>
					<th>S/C No.</th>
					<td class="stm"><input type="text" name="sc_no" id="sc_no" dataformat="engup" maxlength=20  style="width:98px;"  class="input" value="" caption="S/C No."></td>
					<th>RFA No.</th>
					<td class="stm"><input type="text" name="rfa_no" id="rfa_no"  dataformat="engup" maxlength=11  style="width:100px;" class="input" value="" caption="RFA No."></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->	

<!-- opus_design_grid(S) -->
<div class="wrap_result">	
	<div class="opus_design_grid" name="mainTable" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" name="mainTable1" id="mainTable1" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->

<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>
</form>