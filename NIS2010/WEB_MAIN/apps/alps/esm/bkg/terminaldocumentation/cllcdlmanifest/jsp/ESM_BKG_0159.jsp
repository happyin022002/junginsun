<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0159.jsp
*@FileTitle : ESM_BKG_0159
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
*--------------------------------------------------------
* history
* 2011.02.21 김영철 [CHM-201108462-01] GOH 체크 후 조회 시 해당 항목만 조회(조회 그리드 Special Cargo 항목에 "Hanger" Text 보여줌)
* 2014.08.11 이한나 [CHM-201431533] NE6 SHA Block Stowage 관련 CLL/CDL 화면 보완 요청
* 2015.02.09 이한나 [CHM-201533845] CLL/CDL 메뉴에 Calling sequence 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0159Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0159Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");
	String whereGubun = request.getParameter("pgmNo");
	//String whereGubun = (String)request.getAttribute("UI_NUMBER");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0159Event)request.getAttribute("Event");
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
<title>ESM_BKG_0159</title>
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
<input type="hidden" name="in_list_type">
<input type="hidden" name="in_cntr_match">
<input type="hidden" name="in_pol_ts">
<input type="hidden" name="in_pod_ts">
<input type="hidden" name="in_cntr_cfm_flg">
<input type="hidden" name="in_bkg_cgo_tp_cd_temp">
<input type="hidden" name="vvd_nkm">
<input type="hidden" name="un_loc_cd">
<input type="hidden" name="vps_eta_dt">
<input type="hidden" name="vps_etd_dt">
<input type="hidden" name="vps_etb_dt">
<input type="hidden" name="in_order_by_type">
<input type="hidden" name="in_ofc_cd_type">
<input type="hidden" name="in_including_type">
<input type="hidden" name="key">
<input type="hidden" name="fax">
<input type="hidden" name="email">
<input type="hidden" name="vessel_name">
<input type="hidden" name="ofcCd" value="<%=strOfc_cd%>">

<input type="hidden" size="200" name="com_mrdPath" value="apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0783.mrd">
<input type="hidden" size="200" name="com_mrdArguments" value="">
<input type="hidden" size="200" name="com_mrdTitle" value="Container Loading/Discharging List_Print">
<input type="hidden" size="200" name="com_mrdBodyTitle" value="<span style=&quot;color:red&quot;>Container Loading/Discharging List_Print</span>">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--top menu (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				
				
				
				<!--  biz_2  (S) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="840">
					<table style="width:100%;">
					<tr class="h23">
						<td width="235">
							<table border="0" style="width:230;" class="search_sm2"> 
								<tr class="h23">
								<td width="60">List Type</td>
					   	 		<td width="185"class="stm"><input type="radio" name="in_list_type_temp" value=""class="trans" onClick="clickListType(0);" <%if(whereGubun.equals("ESM_BKG_0159-1")){%>checked<%}%>>Loading&nbsp;&nbsp;<input type="radio" value="" name="in_list_type_temp" onClick="clickListType(1);" class="trans" <%if(whereGubun.equals("ESM_BKG_0159-2")){%>checked<%}%>>Discharging</td></tr>
							</table>
							</td>
						<td width="260">
							<table border="0" style="width:245;" class="search_sm2"> 
								<tr class="h23">
					   	 		<td width="180"><input type="radio" name="in_ofc_cd_type_temp" class="trans" checked>Booking&nbsp;&nbsp;<input type="radio" name="in_ofc_cd_type_temp" value=""class="trans">Sales Office</td>
								<td><input type="text" style="width:50;" class="input" name="in_ofc_cd" value="" maxlength="6" dataformat="upper" style="ime-mode:disabled"></td></tr>
							</table>
						</td>
						<td width="100">Booking Status</td>
						<td width="70">
						<select style="width:50;" class="input" name="in_bkg_sts_cd">
						<option value="A" selected>All</option>
						<option value="F">F</option>
						<option value="W">W</option>
						</select></td>
						<td width="75">Cargo Type</td>
						<td width=""><script language="javascript">ComComboObject('in_bkg_cgo_tp_cd', 2, 60, 1, 0, 2);</script></td>
					<tr>
					</table>
					<table style="width:100%;" border="0">
					<tr class="h23">
						<td width="35">&nbsp;VVD</td>
						<td width="140">
							<input type="text" style="width:100;" name="in_vvd_cd" class="input1" value="" dataformat="engupspecial" style="ime-mode:disabled">
							<img class="cursor" src="img/alps/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="javascript:getVvds();">
						</td>
						<td width="30">POL</td>
						<td width="90"><input type="text" id="pod_cd" style="width:50;" name="in_pol_cd" value ="" class="<%if(whereGubun.equals("ESM_BKG_0159-1")){%>input1<%}else{%>input<%}%>" value="" maxlength="5" dataformat="upper" style="ime-mode:disabled">&nbsp;<input type="text" id="pod_yd_cd" style="width:30;" class="<%if(whereGubun.equals("ESM_BKG_0159-1")){%>input1<%}else{%>input<%}%>" name="in_pol_yd_cd" value="" maxlength="2" dataformat="uppernum" style="ime-mode:disabled"></td>
						<td width=""><span id="span_polSplit" style="display:none;">
							<select name="pol_split_no" class="input" style="width:35px;">
								<option value="" selected></option>
								<% for (int k=1; k<=5; k++) { %>
									<option value="<%=k%>"><%=k%></option>
								<% } %>
							</select></span>
						</td>
						<td width="120" class="stm">(<input type="checkbox" value=""class="trans" name="in_pol_ts1">Local<input type="checkbox" value=""class="trans" name="in_pol_ts2">T/S)</td>
						<td width="30">POD</td>
						<td width="90"><input type="text" id="pol_cd" style="width:50;" class="<%if(whereGubun.equals("ESM_BKG_0159-1")){%>input<%}else{%>input1<%}%>" name="in_pod_cd" value="" maxlength="5" dataformat="upper" style="ime-mode:disabled">&nbsp;<input type="text" id="pol_yd_cd" style="width:30;" class="<%if(whereGubun.equals("ESM_BKG_0159-1")){%>input<%}else{%>input1<%}%>" value="" name="in_pod_yd_cd" maxlength="2" dataformat="uppernum" style="ime-mode:disabled"></td>
						<td width=""><span id="span_podSplit" style="display:none;">
							<select name="pod_split_no" class="input" style="width:35px;">
								<option value="" selected></option>
								<% for (int k=1; k<=5; k++) { %>
									<option value="<%=k%>"><%=k%></option>
								<% } %>
							</select></span>
						</td>
						<td width="120" class="stm">(<input type="checkbox" value=""class="trans" name="in_pod_ts1">Local<input type="checkbox" value=""class="trans" name="in_pod_ts2">T/S)</td>
						<td width="60">EQ TP/SZ</td>
						<td width=""><script language="javascript">ComComboObject('in_cntr_tpsz_cd', 2, 60, 1, 0, 2);</script></td>
					</tr>
					</table>
					<table style="width:100%;" border="0">
					<tr class="h23">
					<td width="35">&nbsp;POR</td>
					<td width="70"><input type="text" style="width:50;" class="input" name="in_por_cd" value="" maxlength="5" dataformat="upper" style="ime-mode:disabled"></td>
					<td width="25">DEL</td>
					<td width="70"><input type="text" style="width:50;" class="input" name="in_del_cd" value="" maxlength="5" dataformat="upper" style="ime-mode:disabled"></td>
					<td width="60">R/D Term</td>
					<td width="135"><script language="javascript">ComComboObject('in_rcv_term_cd', 2, 60, 1, 0, 2);</script>
								&nbsp;<script language="javascript">ComComboObject('in_de_term_cd', 2, 60, 1, 0, 2);</script></td>
					<td width="85">Service Mode</td>
					<td width="172"><script language="javascript">ComComboObject('in_org_trns_svd_mod_cd', 2, 80, 1, 0, 2);</script>
								&nbsp;<script language="javascript">ComComboObject('in_dest_trns_svc_mod_cd', 2, 80, 1, 0, 2);</script></td>
					
						<td width="28">SCC</td>
						<td width=""><input type="text" style="width:60;" class="input" name="in_scc_cd" value="" maxlength="5" dataformat="upper" style="ime-mode:disabled"></td>
					     
					 
						<td width=""><input type="checkbox" value="Y" class="trans" name="thai_ofc">Thai Ofc</td>
					
					</tr>
					</table>

				</td>
				<td width="" valign="baseline">
					
					<!--  biz_2  (S) -->
					
					<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">Container Status</td></tr>
					</table>
						
					<table border="0" style="width:100%; background-color:white;" class="grid2"> 
					<tr class="h23">
						<td width="60$%"class="tr2_head2">Confirm</td>
						<td width="%"align="center"><input type="checkbox" value=""class="trans" checked name="in_cntr_cfm_flg1"> Y&nbsp;&nbsp;<input type="checkbox" value=""class="trans" checked name="in_cntr_cfm_flg2">&nbsp;N</td>
						</tr>
					<tr class="h23">
						<td width=""class="tr2_head2">CNTR#<br> Non Match</td>
						<td width=""align="center"><input type="checkbox" value=""class="trans"  name="in_cntr_match_temp" <%if(!whereGubun.equals("ESM_BKG_0159-1")){%>Disabled<%}%>><!-- input type="radio" value=""class="trans" checked name="in_cntr_match_temp">Y&nbsp;&nbsp;<input type="radio" value=""class="trans" name="in_cntr_match_temp">&nbsp;N--></td>
						</tr>
					</table>
				<!--  biz_2  (E) -->	
				
				<table class="search" border="0"><tr><td class="height_8"></td></tr></table>
			</td></tr></table>
			
			<table style="width:100%;" border="0">
				<tr class="h23">
					                                      <td width=""><table border="0" style="width:700;" class="search_sm2"> 
                                             <tr class="h23">
                                             <td width="82">Special Cargo</td>
                                          <td width="" class="sm">
                                          <input type="checkbox" value="Y" class="trans" name="in_dcgo_flg">Danger
                                          &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_rc_flg">Reefer
                                          &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_awk_cgo_flg">Awkward
                                          &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_bb_cgo_flg">Break Bulk
                                          &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_stwg_cd">Stowage
                                          &nbsp;<input type="checkbox" value="Y" class="trans" name="in_hot_de_flg" style="display:none;">
                                          <input type="checkbox" value="Y" class="trans" name="in_rd_cgo_flg">Reefer Dry
                                          &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_soc_flg">SOC
                                          &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_prct_flg">Pre-caution
                                          &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_hngr_flg">GOH
                                          </td>                                     
                                          </tr></table></td>
                                      <td width="5"></td>
                                      <td width=""><table border="0" style="width:160;" class="search_sm2"> 
                                             <tr class="h23">
                                             <td class="sm">&nbsp;Including Partial Container&nbsp;<input type="checkbox" value="Y" class="trans" name="in_including_type_temp" checked></td>
                                          </tr></table></td>
                                      <td width="3"></td>
                                      <td width="">StandBy</td>
                                      <td width="50">
                                             <select style="width:60;" class="input" name="in_bkg_aloc_sts_cd">
                                             <option value="A" selected>ALL</option>
                                             <option value="F" >F-Firm</option>
                                             <option value="S">S-Standby</option>
                                             </select>
                                      </td>

				<tr>
			</table>
			
				<!--  biz_2   (E) -->		
				
	
			<table class="line_bluedot"><tr><td></td></tr></table>
		
		
				
			
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					
					<table width="100%"  id="mainTable2" style="display:none">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>	
					
					<table width="100%"  id="mainTable3" style="display:none">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table>
					
					<table width="100%"  id="mainTable3" style="display:none">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet4');</script>
							</td>
						</tr>
					</table>	
					
					<table width="100%"  id="mainTable3" style="display:none">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet5');</script>
							</td>
						</tr>
					</table>	
					
					<table width="100%"  id="mainTable6"  style="display:none">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet6');</script>
							</td>
						</tr>
					</table>			
			<!-- Grid (E) -->
			
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
			<!--  biz_3  (S) -->
			<table width="100%" class="grid2" id="mainTable"> 
			<tr>
				<td class="tr2_head2" width="35">D2	</td>
				<td width="30"><input type="text" name="d2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D4	</td>
				<td width="30"><input type="text" name="d4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D5</td>
				<td width="30"><input type="text" name="d5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D7	</td>
				<td width="30"><input type="text" name="d7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D8</td>
				<td width="30"><input type="text" name="d8" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D9	</td>
				<td width="30"><input type="text" name="d9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">DW	</td>
				<td width="30"><input type="text" name="dw" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">DX	</td>
				<td width="30"><input type="text" name="dx" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R2	</td>
				<td width="30"><input type="text" name="r2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R4</td>
				<td width="30"><input type="text" name="r4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R5	</td>
				<td width="30"><input type="text" name="r5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F2	</td>
				<td width="30"><input type="text" name="f2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F4	</td>
				<td width="30"><input type="text" name="f4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F5	</td>
				<td width="30"><input type="text" name="f5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
			<tr>
				<td class="tr2_head2">O2	</td>
				<td><input type="text" name="o2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O4		</td>
				<td><input type="text" name="o4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O5		</td>
				<td><input type="text" name="o5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O7		</td>
				<td><input type="text" name="o7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">S2	</td>
				<td><input type="text" name="s2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">S4		</td>
				<td><input type="text" name="s4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">T2</td>
				<td><input type="text" name="t2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">T4		</td>
				<td><input type="text" name="t4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A2	</td>
				<td><input type="text" name="a2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A4		</td>
				<td><input type="text" name="a4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A5		</td>
				<td><input type="text" name="a5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">P2	</td>
				<td><input type="text" name="p2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">P4	</td>
				<td><input type="text" name="p4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">20'	</td>
				<td><input type="text" name="total20" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				
				</tr>
			</table>
		<table width="" class="grid2" id="mainTable"> 
		 	<tr>
		 		<td class="tr2_head2" width="37">40'		</td>
				<td><input type="text" name="total40" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="37">Full		</td>
				<td width="32"><input type="text" name="full" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Empty	</td>
				<td width="30"><input type="text" name="empty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Local		</td>
				<td width="30"><input type="text" name="local" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">T/S		</td>
				<td width="30"><input type="text" name="ts" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Est.					</td>
				<td width="40"><input type="text" name="ewgt" value="" size="10" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="45">Weight					</td>
				<td width="40"><input type="text" name="wgt" value="" size="10" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="55">Measure				</td>
				<td width="40"><input type="text" name="measure" value="" size="10" style="text-align:center;font-weight:bold" readonly></td>	
				<td class="tr2_head2" colspan="2"><b>Total</b>	</td>
				<td colspan="2"><input type="text" name="totalTpSize" value="" size="9" style="text-align:center;font-weight:bold" readonly></td>			
			</tr>
		</table>
				<table class="height_5"><tr><td colspan="8"></td></tr></table>
			<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr class="h23" class="sm">
					<td width="50"class="tr2_head2" rowspan="2">Block<br>Stowage</td>
					<td width=""class="tr2_head2">HJI</td>
					<td width=""align="center" class="sm"><input type="text" name="hji" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">KK4</td>
					<td width=""align="center" class="sm"><input type="text" name="kk4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">KK6</td>
					<td width=""align="center" class="sm"><input type="text" name="kk6" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">KX1</td>
					<td width=""align="center" class="sm"><input type="text" name="kx1" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">KX5</td>
					<td width=""align="center" class="sm"><input type="text" name="kx5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">LAX</td>
					<td width=""align="center" class="sm"><input type="text" name="lax" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">LB1</td>
					<td width=""align="center" class="sm"><input type="text" name="lb1" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">LB2</td>
					<td width=""align="center" class="sm"><input type="text" name="lb2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">LB3</td>
					<td width=""align="center" class="sm"><input type="text" name="lb3" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">LB4</td>
					<td width=""align="center" class="sm"><input type="text" name="lb4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">LBT</td>
					<td width=""align="center" class="sm"><input type="text" name="lbt" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">LGB</td>
					<td width=""align="center" class="sm"><input type="text" name="lgb" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">SE1</td>
					<td width=""align="center" class="sm"><input type="text" name="se1" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					</tr>
				<tr class="h23" class="sm">
					<td width=""class="tr2_head2">SEA</td>
					<td width=""align="center" class="sm"><input type="text" name="sea" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">VA1</td>
					<td width=""align="center" class="sm"><input type="text" name="va1" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">VAN</td>
					<td width=""align="center" class="sm"><input type="text" name="van" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">HOT</td>
					<td width=""align="center" class="sm"><input type="text" name="hot" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">SH1</td>
					<td width=""align="center" class="sm"><input type="text" name="sh1" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">SH2</td>
					<td width=""align="center" class="sm"><input type="text" name="sh2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2">SHA</td>
					<td width=""align="center" class="sm"><input type="text" name="sha" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2"></td>
					<td width=""align="center" class="sm"></td>
					<td width=""class="tr2_head2"></td>
					<td width=""align="center" class="sm"></td>
					<td width=""class="tr2_head2"></td>
					<td width=""align="center" class="sm"></td>
					<td width=""class="tr2_head2"></td>
					<td width=""align="center" class="sm"></td>
					<td width=""class="tr2_head2"></td>
					<td width=""align="center" class="sm"></td>
					<td width=""class="tr2_head2"></td>
					<td width=""align="center" class="sm"></td>
				
					</tr>
				</table>
				<table class="height_5"><tr><td colspan="8"></td></tr></table>
				
				<table border="0" style="width:%; background-color:white;" class="grid2"> 
				<tr class="h23" class="sm">
				
	       		<td class="tr2_head2" width="150">Full Containers Without VGM</td>
	       		<td class="tr2_head2" width="35">Total</td>
				<td width="30"><input type="text" name="no_vgm_total" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
	       		<td class="tr2_head2" width="35">Local		</td>
				<td width="30"><input type="text" name="no_vgm_local" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">T/S		</td>
				<td width="30"><input type="text" name="no_vgm_ts" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				</tr></table>
				
				
				
			<!--  biz_3  (E) -->
		<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
	       		<table border="0" cellpadding="0" cellspacing="0">
				<tr>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_ediDownload">EDI Download</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_cllForEdi">CLL for EDI</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						
						
						<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_edi">EDI</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_faxemail">Fax/E-mail</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_sort">Sort</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		</td></tr>
	</table>	
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
	</td></tr>
		</table>
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		   		<!--  td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_multiretrieve">Multi Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_downExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="TAO/ODCY">TAO/ODCY</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
</form>
</body>
</html>