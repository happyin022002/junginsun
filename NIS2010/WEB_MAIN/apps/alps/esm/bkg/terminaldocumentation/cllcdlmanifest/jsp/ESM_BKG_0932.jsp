
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_0932.jsp
	 *@FileTitle : ESM_BKG_0932
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.07.10
	 *@LastModifier : 김승민
	 *@LastVersion : 1.0
	 * 2009.07.10 김승민
	 * 1.0 Creation
	 * -------------------------------------------------------
	 * History
	 * 2012.04.16 김경섭 [BKG][CHM-201217131-01] Load Summary by POD 기능 보완 요청 
	                                          - 부모창에 따라 DAO의 집계쿼리 변경: in parameter 추가
     * 2012.12.24 김보배 [CHM-201222011] [BKG] Load Summary by POD에 Special Stowage "MUPG" 추가 요청
     * 2012.12.24 김보배 [CHM-201222024] [BKG] Stowage code "MUPG" CLL  반영 요청
     * 2012.12.28 김보배 [CHM-201222025] [BKG] [Special Stowage Request Code] 간소화 및 HIDE CBF 미 반영 개정건
     * 2014.07.28 이한나 [CHM-201431212] Stowage : UDMX 추가에 따른 CLL 반영 요청
     * 2015.04.20 신영재 소스보안 결함 수정
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0932Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmBkg0932Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String inVvdCd = "";
	String inPolCd = "";
	String inPolYdCd = "";
	String inCllType = "";
	String inBkgStsCd = "";
	String inCntrCfmFlg = "";
	String inSortType = "";
	
	String popup_title = "";
	
	Logger log = Logger
			.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");

	String pgmNo = request.getParameter("pgmNo");
	try {
		
			if ("ESM_BKG_0951".equals(pgmNo)){
				popup_title = "Load Summary by POD_Block Stowage";
			} else {
				popup_title = "Container Loading List(KOREA)_Summary";
			}
		
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		inVvdCd = StringUtil.xssFilter(request.getParameter("inVvdCd")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inVvdCd"));
		inPolCd = StringUtil.xssFilter(request.getParameter("inPolCcd")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inPolCcd"));
		inPolYdCd = StringUtil.xssFilter(request.getParameter("inPolYdCd")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inPolYdCd"));
		inCllType = StringUtil.xssFilter(request.getParameter("inCllType")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inCllType"));
		inBkgStsCd = StringUtil.xssFilter(request.getParameter("inBkgStsCd")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inBkgStsCd"));
		inCntrCfmFlg = StringUtil.xssFilter(request.getParameter("inCntrCfmFlg")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inCntrCfmFlg"));
		inSortType = StringUtil.xssFilter(request.getParameter("inSortType")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inSortType"));

		event = (EsmBkg0932Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ESM_BKG_0932</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd"> <input
	type="hidden" name="pagerows"> <input type="hidden"
	name="in_vvd_cd" value="<%=inVvdCd%>"> <input type="hidden"
	name="in_pol_cd" value="<%=inPolCd%>"> <input type="hidden"
	name="in_pol_yd_cd" value="<%=inPolYdCd%>"> <input
	type="hidden" name="in_cll_type" value="<%=inCllType%>"> <input
	type="hidden" name="in_bkg_sts_cd" value="<%=inBkgStsCd%>"> <input
	type="hidden" name="in_cntr_cfm_flg" value="<%=inCntrCfmFlg%>">
<input type="hidden" name="in_sort_type" value="1">
<input type="hidden" name="in_ui_type" value="M"> <input
	type="hidden" name="in_by_type" value=""> <input type="hidden"
	name="set_to" value=""> <input type="hidden" name="set_fm"
	value=""> <!-- 개발자 작업	-->
<input type="hidden" name="in_pgm_no" value="<%=pgmNo%>">
<input type="hidden" name="vvd_cd" readonly>
<input type="hidden" name="un_loc_cd" readonly>
<input type="hidden" name="vps_etd_dt" readonly>
<input type="hidden" name="preview_vvd_cd" readonly>
<input type="hidden" name="preview_pol_cd" readonly>
<input type="hidden" name="preview_vps_etd" readonly>
	
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
		<table width="100%" border="0">
			<tr>
				<td height="79" class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp;<%=popup_title%></td>
			</tr>
		</table>
		<!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1 (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="35">TO :</td>
						<td width="750"><input type="text" style="width: 300;"
							class="input" name="setText1" dataformat="uppernum2"
							maxlength="80">&nbsp;<img src="img/btns_search.gif"
							width="19" height="20" alt="" border="0" align="absmiddle"
							class="cursor" onclick="popSelect()"></td>
						<!--td width="40">Date :</td>
						<td width=""><input type="text" style="width:100%;" class="input" value=" 2008-09-16  18:53:51"></td-->
					</tr>
					<tr class="h23">
						<td width="35">FM :</td>
						<td width="750"><input type="text" style="width: 300;"
							class="input" name="setText2" dataformat="uppernum2"
							maxlength="80">&nbsp;<img src="img/btns_search.gif"
							width="19" height="20" alt="" border="0" align="absmiddle"
							class="cursor" onclick="popSelect()"></td>
						<!--td width="40">Page :</td>
						<td width=""><input type="text" style="width:100%;" class="input" value=" 1 of 2"></td-->
					</tr>
				</table>

				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="35">VVD :</td>
						<td width="450"><input type="text" style="width: 300;"
							class="input2" value="" name="vvd_cd_nm" readonly></td>
						<td width="40">POL :</td>
						<td width="260"><input type="text" style="width: 80;"
							class="input2" value="" name="pol_cd_print" readonly></td>
						<td width="40">ETD :</td>
						<td width=""><input type="text" style="width: 100%;"
							class="input2" value="" name="vps_etd" readonly></td>
					</tr>

				</table>
				<!--  biz_1 (E) -->

				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>

						<td class="title_s">Loading Summary by
						<div id="1pod" style="display: inline;">POD</div>
						<div id="1apod" style="display: none;">A.POD</div>
						<div id="1mlb" style="display: none;">MLB</div>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="170"><input type="text" style="width: 150;"
							class="input2" value="  (excluded Void slot)" readonly></td>
						<td width=""><input type="text" style="width: 100;"
							class="input2" value=" POD : UN code" readonly></td>

					</tr>

				</table>
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 820;">
					<tr class="h23">
						<td>
						<table width="100%" class="grid2" id="mainTable">
							<tr>
								<td class="tr2_head2" width="117"><b>TOTAL(20'/40')</b></td>
								<td align="right" width="42"><input type="text"
									name="local_20" value="" size="2"
									style="width: 35; text-align: right; font-weight: bold"
									readonly></td>
								<td align="right" width="132"><input type="text"
									name="local_40" value="" size="2"
									style="width: 124; text-align: right; font-weight: bold"
									readonly></td>
								<td align="right" width="42"><input type="text"
									name="ts_20" value="" size="2"
									style="width: 35; text-align: right; font-weight: bold"
									readonly></td>
								<td align="right" width="132"><input type="text"
									name="ts_40" value="" size="2"
									style="width: 124; text-align: right; font-weight: bold"
									readonly></td>
								<td align="right" width="42"><input type="text"
									name="mt_20" value="" size="2"
									style="width: 35; text-align: right; font-weight: bold"
									readonly></td>
								<td align="right" width="132"><input type="text"
									name="mt_40" value="" size="2"
									style="width: 124; text-align: right; font-weight: bold"
									readonly></td>
								<td align="right" width="42"><input type="text"
									name="sm_20" value="" size="2"
									style="width: 35; text-align: right; font-weight: bold"
									readonly></td>
								<td align="right" width="132"><input type="text"
									name="sm_40" value="" size="2"
									style="width: 124; text-align: right; font-weight: bold"
									readonly></td>

							</tr>
							<tr>
								<td class="tr2_head2"><b>TOTAL(20'+40')</b></td>
								<td align="right" colspan="2"><input type="text"
									name="local" value="" size="2"
									style="width: 170; text-align: right; font-weight: bold"
									readonly></td>
								<td align="right" colspan="2"><input type="text" name="ts"
									value="" size="2"
									style="width: 170; text-align: right; font-weight: bold"
									readonly></td>
								<td align="right" colspan="2"><input type="text" name="mt"
									value="" size="2"
									style="width: 170; text-align: right; font-weight: bold"
									readonly></td>
								<td align="right" colspan="2"><input type="text" name="sm"
									value="" size="2"
									style="width: 170; text-align: right; font-weight: bold"
									readonly></td>
							</tr>
						</table>
						</td>

					</tr>
				</table>
				<!-- Grid (E) -->
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">Special Cargo Summary by
						<div id="2pod" style="display: inline;">POD</div>
						<div id="2apod" style="display: none;">A.POD</div>
						<div id="2mlb" style="display: none;">MLB</div>
						</td>
					</tr>
				</table>

				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>

				<!-- Grid (E) -->
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" style="width: 100%; background-color: white;"
					class="grid2">
					<tr class="tr2_head">
						<td width="70">Remarks</td>
						<td width=""><textarea name="remark" style="width: 100%"
							rows="5" dataformat="uppernum2"></textarea></td>
					</tr>

				</table>
				<table class="height_8">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="height_8">
					<tr>
						<td></td>
					</tr>
				</table>				
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">Special Stowage Request by
						<div id="3pod" style="display: inline;">POD</div>
						<div id="3apod" style="display: none;">A.POD</div>
						<div id="3mlb" style="display: none;">MLB</div>
						</td>
					</tr>
				</table>

				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>				
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>				
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet6');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->
			<table width="100%" class="grid2" id="mainTable" style="display:none"> 
			<tr>
				<td class="tr2_head2" width="35">D2	</td>
				<td width="30"><input type="text" name="local_d2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D4	</td>
				<td width="30"><input type="text" name="local_d4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D5</td>
				<td width="30"><input type="text" name="local_d5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D7	</td>
				<td width="30"><input type="text" name="local_d7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D8</td>
				<td width="30"><input type="text" name="local_d8" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D9	</td>
				<td width="30"><input type="text" name="local_d9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">DW	</td>
				<td width="30"><input type="text" name="local_dw" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">DX	</td>
				<td width="30"><input type="text" name="local_dx" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R2	</td>
				<td width="30"><input type="text" name="local_r2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R4</td>
				<td width="30"><input type="text" name="local_r4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R5	</td>
				<td width="30"><input type="text" name="local_r5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F2	</td>
				<td width="30"><input type="text" name="local_f2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F4	</td>
				<td width="30"><input type="text" name="local_f4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F5	</td>
				<td width="30"><input type="text" name="local_f5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
			<tr>
				<td class="tr2_head2">O2	</td>
				<td><input type="text" name="local_o2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O4		</td>
				<td><input type="text" name="local_o4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O5		</td>
				<td><input type="text" name="local_o5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">S2	</td>
				<td><input type="text" name="local_s2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">S4		</td>
				<td><input type="text" name="local_s4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">T2</td>
				<td><input type="text" name="local_t2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">T4		</td>
				<td><input type="text" name="local_t4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A2	</td>
				<td><input type="text" name="local_a2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A4		</td>
				<td><input type="text" name="local_a4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A5		</td>
				<td><input type="text" name="local_a5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">P2	</td>
				<td><input type="text" name="local_p2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">P4	</td>
				<td><input type="text" name="local_p4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">Z2	</td>
				<td><input type="text" name="local_z2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">Z4		</td>
				<td><input type="text" name="local_z4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				</tr>
			<tr>
				<td class="tr2_head2">D3	</td>
				<td><input type="text" name="local_d3" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">R9	</td>
				<td><input type="text" name="local_r9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2"  style="font-size:8">ETC		</td>
				<td><input type="text" name="local_etc" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
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
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td class="tr2_head2" colspan="2"><b>Total</b>	</td>
				<td colspan="2"><input type="text" name="local_totalTpSize" value="" size="9" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
			</table>
		<table width="" class="grid2" id="mainTable" style="display:none"> 
		 	<tr>
				<td class="tr2_head" width="37">Local		</td>
				<td width="32"><input type="text" name="local_local" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Full	</td>
				<td width="30"><input type="text" name="local_localFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Empty		</td>
				<td width="30"><input type="text" name="local_localEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head" width="35">T/S		</td>
				<td width="30"><input type="text" name="local_ts" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Full			</td>
				<td width="30"><input type="text" name="local_tsFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Empty		</td>
				<td width="30"><input type="text" name="local_tsEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head" width="35">WGT					</td>
				<td width="60"><input type="text" name="local_wgt" value="" size="15" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
		</table>
		 
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet7');</script>
						</td>
					</tr>
				</table> 	
				<table width="500"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet8');</script>
						</td>
					</tr>
				</table>
				<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet9');</script>
						</td>
					</tr>
				</table> 	
			<!-- Grid (E) -->
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet10');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->
			<table width="100%" class="grid2" id="mainTable" style="display:none"> 
			<tr>
				<td class="tr2_head2" width="35">D2	</td>
				<td width="30"><input type="text" name="ts_d2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D4	</td>
				<td width="30"><input type="text" name="ts_d4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D5</td>
				<td width="30"><input type="text" name="ts_d5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D7	</td>
				<td width="30"><input type="text" name="ts_d7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D8</td>
				<td width="30"><input type="text" name="ts_d8" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D9	</td>
				<td width="30"><input type="text" name="ts_d9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">DW	</td>
				<td width="30"><input type="text" name="ts_dw" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">DX	</td>
				<td width="30"><input type="text" name="ts_dx" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R2	</td>
				<td width="30"><input type="text" name="ts_r2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R4</td>
				<td width="30"><input type="text" name="ts_r4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R5	</td>
				<td width="30"><input type="text" name="ts_r5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F2	</td>
				<td width="30"><input type="text" name="ts_f2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F4	</td>
				<td width="30"><input type="text" name="ts_f4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F5	</td>
				<td width="30"><input type="text" name="ts_f5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
			<tr>
				<td class="tr2_head2">O2	</td>
				<td><input type="text" name="ts_o2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O4		</td>
				<td><input type="text" name="ts_o4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O5		</td>
				<td><input type="text" name="ts_o5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">S2	</td>
				<td><input type="text" name="ts_s2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">S4		</td>
				<td><input type="text" name="ts_s4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">T2</td>
				<td><input type="text" name="ts_t2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">T4		</td>
				<td><input type="text" name="ts_t4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A2	</td>
				<td><input type="text" name="ts_a2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A4		</td>
				<td><input type="text" name="ts_a4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A5		</td>
				<td><input type="text" name="ts_a5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">P2	</td>
				<td><input type="text" name="ts_p2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">P4	</td>
				<td><input type="text" name="ts_p4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">Z2	</td>
				<td><input type="text" name="ts_z2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">Z4		</td>
				<td><input type="text" name="ts_z4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				</tr>
			<tr>
				<td class="tr2_head2">D3	</td>
				<td><input type="text" name="ts_d3" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">R9	</td>
				<td><input type="text" name="ts_r9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2"  style="font-size:8">ETC		</td>
				<td><input type="text" name="ts_etc" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
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
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td class="tr2_head2" colspan="2"><b>Total</b>	</td>
				<td colspan="2"><input type="text" name="ts_totalTpSize" value="" size="9" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
			</table>
		<table width="" class="grid2" id="mainTable" style="display:none"> 
		 	<tr>
				<td class="tr2_head" width="37">Local		</td>
				<td width="32"><input type="text" name="ts_local" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Full	</td>
				<td width="30"><input type="text" name="ts_localFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Empty		</td>
				<td width="30"><input type="text" name="ts_localEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head" width="35">T/S		</td>
				<td width="30"><input type="text" name="ts_ts" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Full			</td>
				<td width="30"><input type="text" name="ts_tsFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Empty		</td>
				<td width="30"><input type="text" name="ts_tsEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head" width="35">WGT					</td>
				<td width="60"><input type="text" name="ts_wgt" value="" size="15" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
		</table>
		 
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet11');</script>
						</td>
					</tr>
				</table> 	
				<table width="500"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet12');</script>
						</td>
					</tr>
				</table>
				<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet13');</script>
						</td>
					</tr>
				</table> 	
			<!-- Grid (E) -->
			<!-- Grid (S) -->
			<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet14');</script>
						</td>
					</tr>
				</table>
				<!--  biz_2 (S) -->
			<table width="100%" class="grid2" id="mainTable" style="display:none"> 
			<tr>
				<td class="tr2_head2" width="35">D2	</td>
				<td width="30"><input type="text" name="preview_d2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D4	</td>
				<td width="30"><input type="text" name="preview_d4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D5</td>
				<td width="30"><input type="text" name="preview_d5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D7	</td>
				<td width="30"><input type="text" name="preview_d7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D8</td>
				<td width="30"><input type="text" name="preview_d8" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D9	</td>
				<td width="30"><input type="text" name="preview_d9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">DW	</td>
				<td width="30"><input type="text" name="preview_dw" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">DX	</td>
				<td width="30"><input type="text" name="preview_dx" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R2	</td>
				<td width="30"><input type="text" name="preview_r2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R4</td>
				<td width="30"><input type="text" name="preview_r4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R5	</td>
				<td width="30"><input type="text" name="preview_r5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F2	</td>
				<td width="30"><input type="text" name="preview_f2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F4	</td>
				<td width="30"><input type="text" name="preview_f4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F5	</td>
				<td width="30"><input type="text" name="preview_f5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
			<tr>
				<td class="tr2_head2">O2	</td>
				<td><input type="text" name="preview_o2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O4		</td>
				<td><input type="text" name="preview_o4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O5		</td>
				<td><input type="text" name="preview_o5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">S2	</td>
				<td><input type="text" name="preview_s2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">S4		</td>
				<td><input type="text" name="preview_s4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">T2</td>
				<td><input type="text" name="preview_t2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">T4		</td>
				<td><input type="text" name="preview_t4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A2	</td>
				<td><input type="text" name="preview_a2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A4		</td>
				<td><input type="text" name="preview_a4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A5		</td>
				<td><input type="text" name="preview_a5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">P2	</td>
				<td><input type="text" name="preview_p2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">P4	</td>
				<td><input type="text" name="preview_p4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">Z2	</td>
				<td><input type="text" name="preview_z2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">Z4		</td>
				<td><input type="text" name="preview_z4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				</tr>
			 <tr>
				<td class="tr2_head2">D3	</td>
				<td><input type="text" name="preview_d3" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">R9	</td>
				<td><input type="text" name="preview_r9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" style="font-size:8">ETC		</td>
				<td><input type="text" name="preview_etc" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>		
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
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>		
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>		
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>		
				<td class="tr2_head2" colspan="2"><b>Total</b>	</td>
				<td  colspan="2"><input type="text" name="preview_totalTpSize" value="" size="9" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
			</table>
		<table width="" class="grid2" id="mainTable" style="display:none"> 
		 	<tr>
				<td class="tr2_head" width="37">Local		</td>
				<td width="32"><input type="text" name="preview_local" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Full	</td>
				<td width="30"><input type="text" name="preview_localFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Empty		</td>
				<td width="30"><input type="text" name="preview_localEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head" width="35">T/S		</td>
				<td width="30"><input type="text" name="preview_ts" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Full			</td>
				<td width="30"><input type="text" name="preview_tsFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Empty		</td>
				<td width="30"><input type="text" name="preview_tsEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head" width="35">WGT					</td>
				<td width="40"><input type="text" name="preview_wgt" value="" size="10" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
		</table>
		<!--  biz_2  (E) -->
		<!-- Grid (E) -->

				<table class="height_8">
					<tr>
						<td></td>
					</tr>
				</table>				
				<table class="search" border="0" style="width: 979;">
					<tr class="stm">
						<td width="300">AB - Away from boiler</td>
						<td width="300">AF - Away from foodstuffs</td>
						<td width="">AL - Away from living quarters</td>
					</tr>
					<tr class="stm">
						<td width="300">BC - Block stowage</td>
						<td width="300">OD - On Deck stowage</td>
						<td width="">ODAB - On deck away from boiler</td>
					</tr>
					<tr class="stm">						
						<td width="300">OBSS - One bay STWG(ONLY SAMSUNG)</td>
						<td width="300">OLBS - Early Discharge (With value added SVC)</td>						
						<td width="">ODAL - On deck away from living quarters</td>
					</tr>
					<tr class="stm">
						<td width="300">ODBC - On deck block stowage</td>
						<td width="300">ODET - On Deck Except Top Stowage</td>
						<td width="">ODFT - On Deck For Flectank</td>
					</tr>
					<tr class="stm">
						<td width="300">ODHD - On deck for Hide</td>
						<td width="300">OP - On deck protected</td>
						<td width="">OT - On deck top</td>
					</tr>
					<tr class="stm">
						<td width="300">OTNO - On deck Top not overstow</td>
						<td width="300">PC - Pre caution</td>
						<td width="">PCOD - Pre caution on deck</td>
					</tr>
					<tr class="stm">
						<td width="300">TS - Top stowage</td>
						<td width="300">OLBP - Priority Early Discharge (Premium Express SVC)</td>
						<td width="">UD - Under Deck</td>
					</tr>	
					<tr class="stm">
						<td width="300">UT - Under deck top</td>
						<td width="300">UDAB - Under Deck away from heating source</td>
						<td width="">UW - Under waterline</td>
						
					</tr>	
					<tr class="stm">
						<td width="300">UTAB - Under deck top away from boiler</td>
						<td width="350">MUPG - Marble UP(Under deck protected) by general cargoes</td>
						<td width="">UDMX - Under Deck for AK only (Not for Dry)</td>
					</tr>	
					<tr class="stm">
						<td width="300">OLBL - Discharge (Only LG Electronics Inc)</td>
						<td width="350"></td>
						<td width=""></td>
					</tr>						

				</table>
				<!--  biz_2 (S) -->



				<!--  biz_2   (E) --></td>
			</tr>
		</table>


		<!--  Button(S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="">Summary</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td style="font-size: 8pt; font-family: Tahoma, Arial;"
							width="235" align="center"><input type="radio"
							name="in_by_type_temp" value="P" onClick="goBySearch('P')"
							class="trans" checked>&nbsp;By POD&nbsp;&nbsp;&nbsp;<!-- input
							type="radio" name="in_by_type_temp" value="A" class="trans"
							onClick="goBySearch('A');changeTitle('A')">&nbsp;By
						A.POD&nbsp;&nbsp;&nbsp;--><input type="radio" name="in_by_type_temp"
							value="M" class="trans" onClick="goBySearch('M')">&nbsp;By
						MLB&nbsp;&nbsp;&nbsp;<input type="radio" name="in_by_type_temp"
							value="T" class="trans" onClick="goBySearch('T')">&nbsp;By
						T/S VVD</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Print">Print</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Pdf_Print">PDF Print</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

					</tr>
				</table>
				</td>
			</tr>
		</table>

		<!-- Button_Sub (E) --></td>
	</tr>
</table>

<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close" onClick="self.close()">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>