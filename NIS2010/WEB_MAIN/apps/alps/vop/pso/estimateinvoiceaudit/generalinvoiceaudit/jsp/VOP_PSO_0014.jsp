<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0014.jsp
*@FileTitle : Invoice Creation N' Audit 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.24
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2009.08.28 김진일
* 1.0 Creation
*
* History
* 2010.11.24 이석준 CHM-201007129-01 Inovoice 데이타는 Deleted Vendor로 생성되지 않도록 함.
* 2014.08.05 이성훈 CHM-201430972 	[PSO] Invoice내 Exchanage Rate 칼럼 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0014Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCntCd 		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EstimateInvoiceAudit.GeneralInvoiceAudit");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCntCd  = account.getCnt_cd();


		event = (VopPso0014Event)request.getAttribute("Event");
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
<title>Invoice Creation N' Audit </title>
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
<input type="hidden" name="vsl_cd" />
<input type="hidden" name="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" />
<input type="hidden" name="cost_cd" />
<input type="hidden" name="acct_cd" />
<input type="hidden" name="vndr_seq" />
<input type="hidden" name="isdelete" />
<input type="hidden" name="cnt_cd" value="<%=strCntCd %>"/>
<input type="hidden" name="usr_id" value="<%=strUsr_id %>"/>
<input type="hidden" name="ttl_loc_amt" value=""/>
<input type="hidden" name="updateflag" value="" />
<input type="hidden" name="iss_cty_cd" value="" />
<input type="hidden" name="so_seq" value="" />
<input type="hidden" name="cost_ofc_cd" value="" />
<input type="hidden" name="pso_chg_sts_cd" value="" />
<input type="hidden" name="io_flag" value="" />
<input type="hidden" name="rowIdx" value="" />

<input type="hidden" name="net_amt" value="" />				<!-- [2010.04.07:jmh] add -->
<input type="hidden" name="ddt_amt" value="" />				<!-- [2010.04.07:jmh] add -->
<input type="hidden" name="spdeleted" value="" />			<!-- [2010.11.24:ryu] add -->
<input type="hidden" name="mnl_inp_xch_rt" value=" "/>		<!-- [2014.07.29:lsh] add -->

<!-- grid row 단위 계산 시 필요한 manual 값 파라미터 -->
<input type="hidden" name="night" value="" />
<input type="hidden" name="holiday" value="" />
<input type="hidden" name="boat" value="" />
<input type="hidden" name="tugrope" value="" />
<input type="hidden" name="buoy" value="" />
<input type="hidden" name="sanitation" value="" />
<input type="hidden" name="barge" value="" />
<input type="hidden" name="inspection" value="" />
<input type="hidden" name="newservice" value="" />
<input type="hidden" name="arrtp" value="" />
<input type="hidden" name="deptp" value="" />
<input type="hidden" name="arrnt" value="" />
<input type="hidden" name="depnt" value="" />
<input type="hidden" name="arrtuh" value="" />
<input type="hidden" name="deptuh" value="" />
<input type="hidden" name="arrlh" value="" />
<input type="hidden" name="deplh" value="" />   
<input type="hidden" name="usdhrs" value="" />   
<input type="hidden" name="copilot" value="" />  
<input type="hidden" name="baf_rt" value="" />  


<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_Delete" id="btn_del">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm">Confirm</td>
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
					<td width="65">&nbsp;S/P Code</td>
					<td width="110"><input type="text" name="spcode" dataformat="int" maxlength="6" style="width:60;text-align:center;ime-mode:disabled;" class="input1" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td width="75">S/P Name</td>
					<td width="255"><input type="text" name="spname" style="width:220;text-align:left;" class="input2" value="" readonly></td>
					<td width="50" id="td_inv_no">INV No.</td>
					<td width=""><input name="inv_no" type="text" style="width:200;text-align:left;ime-mode:disabled;" class="input1" value="" maxlength="20"></td>
					<td width="30" align="right"><div style="display:none">Credit Memo&nbsp;<input name="credit_memo" style="border:none;" type="checkbox"></div></td>
					<td width="130" align="right">Transfer Slip&nbsp;<input name="trnsf_slp" style="border:none;" type="checkbox"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!--  biz_2  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="480" valign="top">
					<!--  biz_2_1  (S) -->
						<table class="search_sm2" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="74">TMNL</td>
								<td width="130">
									<select id="sel_yd_cd" name="yd_cd" style="width:85" class="input1" onChange="displayTmnlNm(this);">
									</select>
									<!-- 
									<option value="1">111111</option>
									<input name="tmnl_cd" type="text" style="width:60" class="input1" value="EGSUZ">&nbsp;
									<select name="tmnl_yd_cd" style="width:45;" class="input1">
									<option value="T1" selected>T1</option>
									<option value="1"></option>
									</select>
									 -->
								</td>
								<td width="110">TMNL Name</td>
								<td width="" colspan="3"><input name="tmnl_nm" type="text" style="width:220;text-align:left;" class="input2" value="" readonly>&nbsp;</td>
							</tr>
							<tr class="h23">
								<td>Cost OFC</td>
								<td width="">
									<input name="cost_ofc" type="text" style="width:60;text-align:center" class="input1" value="PUSCOV" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_search_cost_ofc" width="19" height="20" alt="" border="0" align="absmiddle">
									<!-- img class="cursor" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" -->
								</td>
								<td width="">INV. Office</td>
								<td width=""><input type="text" name="inv_ofc_cd" style="width:80;text-align:center;" class="input2" value="<%=strOfc_cd%>" readonly>&nbsp;</td>
							<!-- /tr  -->
							<!-- tr class="h23"  -->
								<td width="">Currency</td>
								<td width="">
									<select id="sel_curr_cd" name="curr_cd" style="width:60;text-align:center;" class="input1" onChange="changeInvCurrCd();">
										<!-- 
										<option value="0" selected>USD</option>
										<option value="1">KRW</option>
										<option value="2">KSD</option>
										<option value="3">URO</option>
										 -->
									</select>
								</td>
							</tr>
						</table>
					</td>
					<td width="19">&nbsp;&nbsp;</td>
					<td width="480" valign="top">
						<table class="search_sm2" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="85" nowrap>TTL INV. Amt</td>
								<td width="100" nowrap><input name="inv_amt" type="text" style="width:90;text-align:right;ime-mode:disabled;" class="input1" dataformat="float" caption="Invoice Amount" maxlength="20"  size="7"   pointcount="2" value=""></td>
								<td width="60" align="right">V.A.T.&nbsp;</td>
								<td width="100"><input name="vat" type="text" style="width:90;text-align:right;ime-mode:disabled;" class="input"  dataformat="float" caption="V.A.T" maxlength="20"  size="7"   pointcount="2" value=""></td>
								<td width="70" align="right" title="Withholding Tax">W/T&nbsp;</td>
								<td width=""><input name="whld_tax" type="text" style="width:90;text-align:right;ime-mode:disabled;" class="input"  dataformat="float" caption="Withholding Tax" title="Withholding Tax" maxlength="20"  size="7"   pointcount="2" value=""></td>
							</tr>
							<tr class="h23">
								<td width="">Issue Date</td>
								<td width="" colspan="2"><input onChange="alert('onChange');" name="iss_dt" type="text" style="width:80;text-align:center;" class="input1" value="" dataformat="ymd" maxlength="8"  size="10">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar_s" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="" align="right">Receive Date&nbsp;</td>
								<td width="" colspan="2"><input name="rcv_dt" type="text" style="width:80;text-align:center;" class="input1" value="" dataformat="ymd" maxlength="8"  size="10">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar_r" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<!-- tr class="h23">
								<td width="">Effective Date</td>
								<td width=""><input name="eff_dt" type="text" style="width:80" class="input1" value="" dataformat="ymd" maxlength="8"  size="10">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar_e" width="19" height="20" border="0" align="absmiddle"></td>
							</tr  -->
						</table>
					</td>
				</tr>
				</table>
				<!--  biz_2   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!--  biz_3  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="979" valign="top">
					<!-- td width="480" valign="top" -->
					<!--  biz_3_1  (S) -->
						<table class="search_sm2" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="35">VVD</td>
								<td width="135"><input name="vvdband" type="text" readonly style="width:105;text-align:center;" class="input2" value="">&nbsp;</td>
								
								<td width="30">ATD</td>
								<td width="215"><input name="atd" type="text" readonly style="width:140;text-align:center;" class="input2" value="">&nbsp;
								
								<td width="">AMT (VVD/TTL)&nbsp;&nbsp;<input type="text" name="calc_amt_vvd" readonly style="width:150;text-align:right;" class="input2" dataformat="float" pointcount="2" value=" ">&nbsp;/&nbsp;<input type="text" name="calc_amt_ttl" readonly style="width:150;text-align:right;" class="input2" dataformat="float" pointcount="2" value=" "></td>
							</tr>
						</table>
					<!--  biz_3_1  (E) -->
					</td>
					
				
				</tr>
				</table>
				<!--  biz_3   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				
				
				<!--  biz_2  (S) -->
				
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
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDelete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Calculation">Calculation</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
						
				<!--  biz_2   (E) -->
			
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
						
			<!--  biz_5   (S) -->	
			<table class="search" border="0" width="100%"> 
				<tr class="h23">
					<td width="100%" valign="top">
					<!--  biz_5_1  (S) -->
						<table class="search_sm2" border="0" style="width:100%;"> 
							<tr class="h23">
								<td valign="middle" width="120">Add Information :</td>
								<td width="" class="stm"><input name="cbx_night" type="checkbox"  value="" class="trans"/> Night&nbsp;&nbsp;
								<input name="cbx_holiday" type="checkbox"  value="" class="trans"/>Holiday&nbsp;&nbsp;
								<input name="cbx_boat" type="checkbox"  value="" class="trans"/>Boat&nbsp;&nbsp;
								<input name="cbx_tugrope" type="checkbox"  value="" class="trans"/>TUG Rope&nbsp;&nbsp;
								<input name="cbx_buoy" type="checkbox"  value="" class="trans"/>Buoy&nbsp;&nbsp;
								<input name="cbx_sanitation" type="checkbox"  value="" class="trans"/>Sanitation&nbsp;&nbsp;
								<input name="cbx_barge" type="checkbox"  value="" class="trans"/>Barge&nbsp;&nbsp;
								<input name="cbx_inspection" type="checkbox"  value="" class="trans"/>Inspection&nbsp;&nbsp;
								<input name="cbx_newservice" type="checkbox" value="" class="trans"/>New Service&nbsp;&nbsp;
								<input name="cbx_copilot" type="checkbox" value="" class="trans"/>Co-Pilot</td>
							</tr>
						</table>
					<!--  biz_5_1  (E) -->
					</td>
				</tr>
			</table>
			<!--  biz_5   (E) -->
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>

			<table width="100%"  id="mainTable" style="display:none;"><!-- Dummy Sheet -->	
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table>
				
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
	
	</td></tr>
</table>
<!-- Copyright (S)
<table class="copy">
<tr><td class="familysite">&nbsp;
		<select name="sitelink" id="sitelink" class="select_family" onChange="javascript:go_sitelink(this);">
       	<option selected>&nbsp;&nbsp;  -- Family Site --  &nbsp;&nbsp;</option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
   		</select>
	</td>
	<td class="copy"><img src="img/img_bottom_logo.gif" width="460" height="16" alt="" border="0"></td></tr>
</table>
Copyright(E)-->

<iframe id="dvPopup" src="apps/alps/vop/pso/estimateinvoiceaudit/generalinvoiceaudit/jsp/popupcontent.html" style="display:none;position:absolute;">
</iframe>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>