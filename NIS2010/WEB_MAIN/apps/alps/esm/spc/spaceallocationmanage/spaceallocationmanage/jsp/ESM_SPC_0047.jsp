<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0047.jsp
*@FileTitle : spaceallocationmanage
*Open Issues :
*@LastModifyDate : 2009.09.03
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.03 한상훈
* 1.0 Creation
*Change history :
* 2006-11-22 김원섭 1.0 최초 생성
* 2008-02-28 김원섭 CSR : N200802260009   Load target만 있는 office 조회 - Data Selection 영역의 Text label 기능 추가
* 2008-04-02 서관영 CSR : N200803280003  e-NIS 본사 및 RHQ Alloc. 화면 개발요청 - 하단 Control Option 좌측 VVD,Week,Loadable(TEU) 컬럼 추가
* 2008-10-29 임옥영 CSRNO:N200810240577 단축키설정 form태그에 spcKeyAction('ESM_SPC_047') 추가
* 2008-11-13 임옥영 CSR:N200811120012 -단축키 추가사항 반영(toggle 및 적용 화면추가, focus)
* 2010.07.05 CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171- [프로젝트] 53FT 관련 필드 추가
* 2011.08.05 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 - 주차별 CMB 항목 조회되도록 수정
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2012.01.02 김종준 [CHM-201110709-01] OP/OC/VL  추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2015.03.24 박은주 [CHM-201534916] Allocation by HO/RHQ 의 Edit기능에 Yield Group추가 요청 ->Sync 옵션추가(Control option 과 동일하게 적용 시켜줌)
* 2015.06.03 김성욱 Edit 기능에 Async 기능 추가, Control Option Reg의 By Aloc등 9개 항목 Reset
* 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
* 2015.07.02 김성욱 Compulsory Firm 버튼 용어 SB BKG Firm 으로 변경 
* 2015.07.14 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
* 2016.05.18 최성민 Double Callling Route(Port/Tmnl)에 대한 물량집계 및 병목상 Logic 보완 사항 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0047Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0047Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;		//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.SpaceAllocationManage.SpaceAllocationManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0047Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	boolean isAdmin = false;
	String ofc_cd   = event.getSignOnUserAccount().getOfc_cd();
	
	if (serverException == null) {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		isAdmin = eventResponse.getETCData("adm").equals("Y");
		ofc_cd  = eventResponse.getETCData("rhq_cd");
	}
	
	if(isAdmin){
		ofc_cd = "";
	}
	String popup_vvd        = (request.getParameter("vvd") == null)? ""  : request.getParameter("vvd");
	String popup_year       = (request.getParameter("year") == null)? "": request.getParameter("year");
	String popup_week       = (request.getParameter("week") == null)? ""  : request.getParameter("week");
	String popup_duration   = (request.getParameter("duration") == null)? ""  : request.getParameter("duration");
	String popup_flg        = (request.getParameter("popup_flg") == null)? "N" : "Y";	
%>
<html>
<head>
<title>spaceallocationmanage</title>
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
<form name="form" onsubmit="return false;" onKeyDown="spcKeyAction('ESM_SPC_0047');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="uiname" value="ESM_SPC_0047">
<input type="hidden" name="acctCtrl" value="N">
<input type="hidden" name="all_pol">
<input type="hidden" name="pol_dbl_port_chk">
<input type="hidden" name="popup_flg"   value="<%= popup_flg%>">
<input type="hidden" name="popup_vvd"   value="<%= popup_vvd%>">
<input type="hidden" name="popup_year" value="<%= popup_year%>">
<input type="hidden" name="popup_week"   value="<%= popup_week%>">
<input type="hidden" name="popup_duration"   value="<%= popup_duration%>">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new" alt="Alt+N">New</td><td class="btn1_right"></td></tr></table></td>

							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save" alt="Alt+S">Save</td><td class="btn1_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr>
					<td>
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="90"><img class="nostar">Start Week</td>
								<td width="143" style="padding-left:1">
									<select class="input1" name="year" style="width:60;" onchange="checkWeek();"></select>
									<select class="input1" name="week" style="width:40;"></select>
								</td>
								<td width="80"><img class="nostar">Duration</td>
								<td width="150">
								<select class="input1" name="duration" size="1"></select>
								<!-- input type="text" name="duration" style="width:40;" maxlength="1" value="5" --></td>
								<td width="50"><img class="nostar">VVD</td>
								<td width="152"><input class="input1" type="input" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
								<td width="130"><img class="nostar">Forecast Qty View</td>
								<td><select name="fcast"><option value="1">F'cast + BKG</option><option value="2">F'cast only</option><option value="3">BKG only</option></select>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table class="search_in" border="0">
							<tr class="h23">
							<td width="90"><img class="nostar">Rep. Trade</td>
							<td width="140" style="padding-left:3">
								<script language="JavaScript">ComComboObject("trade", 2, 60, 0, 1);</script>
							</td>
							<td width="80"><img class="nostar">Sub Trade</td>
							<td width="150" style="padding-left:3">
								<script language="JavaScript">ComComboObject("subtrade", 3, 50, 0, 1);</script>
							</td>
							<td width="50"><img class="nostar">Lane</td>
							<td width="150">
								<script language="JavaScript">ComComboObject("lane", 4, 82, 0, 0);</script>
							</td>
							<td width="60"><img class="nostar">Bound</td>
							<td width="120">
								<select name="bound" style="width:50;"></select>
							</td>
							<td width="55"><img class="nostar">Origin</td>
							<td><select class="input1" name="office" id="office"<%=isAdmin?"":"disabled" %>><option value=""></option><option value="NYCRA"<%=ofc_cd.equals("NYCRA")?" selected":""%>>NYCRA</option><option value="HAMRU"<%=ofc_cd.equals("HAMRU")?" selected":""%>>HAMRU</option></select>
							</td>
							</tr>
						</table>
					</td>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

					<table width="100%" id="sheetControlDiv" style="">
                        <tr><td align="right"><img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="sheet1" type="N" onclick="toggleSheetSize();" alt='Alt+↑'></td></tr>
		            </table>

			<!-- : ( grid ) (S) -->

					<table width="100%" id="mainTable1">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>

			<!-- : ( grid ) (E) -->

			</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<table border="0">
				<tr class="h23">
					<td width="26">VVD</td>
					<td width="80"><input type="text" style="width:80; text-align:center;" value="" readonly  id="idTxtVVD"></td>
					<td width="26" align='right'>WK</td>
					<td width="65"><input type="text" style="width:60; text-align:center;" value="" readonly id="idTxtWeek"></td>
					<td width="60"  width="105" >Loadable</td>
					<td width="65"><input type="text"  style="width:60; text-align:center;" value="" readonly  name="fm_load" id="idTxtLoadable"></td>
				 	<td width="105" style="display:;" id="controlDiv"nowrap><img class="nostar">Control Option</td>
					<td width="800">
						<table border="0">
						<tr>
						<td align="left" style="display:;" id="controlDiv" width="680" nowrap>
							<span style="display:none;"><input type="checkbox" value="" class="trans" checked name="chkVolume" id="chkVolume" disabled><label for="chkVolume">Volume</label></span>
							<select name="chkPort" style="width:70px" disabled><option value="O">Office</option><option value="L">POL</option><option value="D">POL/POD</option><option value="T">DEST</option></select>
							<input type="checkbox" value="" class="trans" checked name="chkD2" id="chkD2" disabled><label for="chkD2">D2'</label>
							<input type="checkbox" value="" class="trans" checked name="chkD4" id="chkD4" disabled><label for="chkD4">D4'</label>
							<input type="checkbox" value="" class="trans" checked name="chkHC" id="chkHC" disabled><label for="chkHC">HC</label>
							<input type="checkbox" value="" class="trans" checked name="chk45" id="chk45" disabled><label for="chk45">45'</label>
							<input type="checkbox" value="" class="trans" checked name="chk53" id="chk53" disabled><label for="chk53">53'</label>
							<input type="checkbox" value="" class="trans" checked name="chkRFR" id="chkRFR" disabled><label for="chkRFR">RF</label>
							<input type="checkbox" value="" class="trans" checked name="chkDFR" id="chkDFR" disabled><label for="chkDFR">RD</label>
							<input type="checkbox" value="" class="trans" checked name="chkWGT" id="chkWGT" disabled><label for="chkWGT">WT</label>
							<input type="checkbox" value="" class="trans" checked name="chkIPI" id="chkIPI" disabled><label for="chkIPI">Local/IPI</label>
						    <input type="checkbox" value="" class="trans" checked name="chkAccount" id="chkAccount" disabled><label for="chkAccount">Account</label>
							<input type="checkbox" value="" class="trans" checked name="chkYG" id="chkYG" disabled><label for="chkYG">YieldGroup</label>
							<input type="checkbox" value="" class="trans" checked name="chkFX" id="chkFX" disabled><label for="chkFX">Fixed</label>
						</td>
						<td align="left" width="130" id="controlOptionButton1">
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr><td class="btn1_bg">
											<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn1_left"></td><td class="btn1" name="btng_controlEdit" id="btng_controlEdit" alt="Alt+I">Edit</td><td class="btn1_right"></td></tr></table></td>
												<!-- Repeat Pattern -->
											</tr></table>
									</td></tr>
							</table>
						</td>
						<td align="left" width="130" nowrap style="display:none;" id="controlOptionButton2">
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr><td class="btn1_bg">

											<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn1_left"></td><td class="btn1" name="btng_controlSave" id="btng_controlSave" alt="Alt+S">Save</td><td class="btn1_right"></td></tr></table></td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn1_left"></td><td class="btn1" name="btng_controlCancel" id="btng_controlCancel" alt="Alt+X">Cancel</td><td class="btn1_right"></td></tr></table></td>
												<!-- Repeat Pattern -->

											</tr></table>

									</td></tr>
							</table>

						</td>

						</tr>
						</table>
					</td>
					<td align="right">
						<span id="sheetControlDiv" style=""><img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="sheet2" type="N" onclick="toggleSheetSize();" alt='Alt+↓'></span>
					</td>
				</tr>
				</table>
				<table style="width:100%;">
				<tr class="h23">
					<td align="left" nowrap width="100">
						Data Selection
					</td>
					<td align="left" colspan="3" nowrap>
						<span><input type="checkbox" value="" class="trans" checked name="chkPol" id="chkPol" onclick="return changeSelection();"><label for="chkPol">POL</label>&nbsp;</span>
						<span id="divChkPOD"><input type="checkbox" value="" class="trans" checked name="chkPod" id="chkPod" onclick="return changeSelection();"><label for="chkPod">POD</label>&nbsp;</span>
						<span id="divChkDest"><input type="checkbox" value="" class="trans" checked name="chkDest" id="chkDest" onclick="return changeSelection();"><label for="chkDest">DEST</label>&nbsp;</span>
						<span id="divChkOCN"><input type="checkbox" value="" class="trans" checked name="chkOCN" id="chkOCN" onclick="return changeSelection();"><label for="chkOCN">OCN</label>&nbsp;</span>
						<span id="divChkIPC"><input type="checkbox" value="" class="trans" checked name="chkIPC" id="chkIPC" onclick="return changeSelection();"><label for="chkIPC">IPC</label>&nbsp;</span>
						<span id="divChkTS"><input type="checkbox" value="" class="trans" checked name="chkTS" id="chkTS" onclick="return changeSelection();"><label for="chkTS">T/S</label>&nbsp;</span>
						<span id="divChkMT"><input type="checkbox" value="" class="trans" checked name="chkEQ" id="chkEQ" onclick="return changeSelection();"><label for="chkEQ">MT</label>&nbsp;</span>
						<input type="hidden" value="" class="trans" checked name="chkTYP" id="chkTYP" onclick="return changeSelection();"><label for="chkTYP"></label>
						<input type="checkbox" value="" class="trans" name="chkTYP_ALL" id="chkTYP_ALL" onclick="return changeSelection();"><label for="chkTYP_ALL">TP/SZ</label>
						<input type="checkbox" value="" class="trans" checked name="chkWT" id="chkWT" onclick="return changeSelection();"><label for="chkWT">WGT</label>
						<span><input type="checkbox" value="" class="trans" name="chkTREND" id="chkTREND" onclick="return changeSelection();"><label for="chkTREND">CMB Trend</label></span>
						<span><input type="checkbox" value="" class="trans" name="chkWKCMB" id="chkWKCMB" onclick="return changeSelection();"><label for="chkWKCMB">Weekly CMB</label></span>
						<span><input type="checkbox" value="" class="trans" name="chkCNTRMOVE" id="chkCNTRMOVE" onclick="return changeSelection();"><label for="chkCNTRMOVE">CNTR Movement</label></span>
						<span><input type="checkbox" value="" class="trans" checked name="chkIPI_O" id="chkIPI_O" onclick="return changeSelection();"><label for="chkIPI_O">Local/IPI</label></span>
						<span><input type="checkbox" value="" class="trans" checked name="chkAccount_O" id="chkAccount_O" onclick="return changeSelection();"><label for="chkAccount_O">Account</label></span>	
					    <span><input type="checkbox" value="" class="trans" name="allPol" id="allPol" onclick="chkAllPol()"><label for="allPol">ALL POL</label></span>
                        
						<span style="display:none"><input type="checkbox" value="" class="trans" checked name="chkOfc" id="chkOfc" onclick="return changeSelection();"><label for="chkOfc">Office</label>&nbsp;</span>
						<span><input type="hidden" value="" class="trans" name="chkUSG" id="chkUSG" onclick="return changeSelection();"><label for="chkUSG"></label></span>
						<span><input type="hidden" value="" class="trans" name="chkCUS" id="chkCUS" onclick="return changeSelection();"><label for="chkCUS"></label></span>
						<span style="display:none"><input type="checkbox" value="" class="trans" name="chkBKGF" id="chkBKGF" onclick="return changeSelection();"><label for="chkBKGF">Booking(Firm)</label></span>
					</td>
				</tr>
				</table>

				<table width="100%" id="mainTable2">
                    <tr><td>
                         <script language="javascript">ComSheetObject('sheet2');</script>
                    </td></tr>
	            </table>

				<!-- : ( Grid :  ) (E) -->


    			<!-- : ( Button : Sub ) (S) -->
    			<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_cmpl_firm" id="btng_cmpl_firm">SB BKG Firm</td><td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_cust_grp" id="btng_cust_grp" alt="Alt+C">Lane Status</td><td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"> 
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_copy" id="btng_copy" alt="Alt+C">Alloc Copy&Paste</td><td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_temp" id="btng_temp" alt="Temporary input">Temporary Input</td><td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_bottleneck" id="btng_bottleneck" alt="Alt+B">Bottle Neck Check</td><td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_skd" id="btng_skd" alt="Alt+K">SKD Inquiry</td><td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_bsa" id="btng_bsa" alt="Alt+M">BSA Management</td><td class="btn2_right"></td></tr></table></td>
								<td style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_copymodel" id="btng_copymodel">Copy Model</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td></tr>
			</table>
    			<!-- : ( Button : Sub ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
