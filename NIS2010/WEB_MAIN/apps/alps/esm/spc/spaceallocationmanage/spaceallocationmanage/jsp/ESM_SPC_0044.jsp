<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0044.jsp
*@FileTitle : Allocation Control by Main Office
*Open Issues :
*@LastModifyDate : 2009.09.15
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.15 한상훈
* 1.0 Creation
*Change history :
* 1.0 최초 생성
* 2008-02-20 김원섭 CSR : N200802180011   Control Option 적용대상 변경 - Data Selection의 text에 label 기능 추가
* 2008-10-29 임옥영 CSRNO:N200810240577 단축키설정 form태그에 spcKeyAction('ESM_SPC_044') 추가
* 2008-11-13 임옥영 CSR:N200811120012 -단축키 추가사항 반영(toggle 및 적용 화면추가, focus)
* 2010. 03. 05 CHOI.Y.S - Booking Creation 화면에서 Inquiry by Sub Office 화면 Pop-up 사용 처리 로직 추가
* 2010.06.22 CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - [프로젝트] 53FT 관련 필드 추가
* 2010.08.27 이행지 [CHM-201005552-01] Allocation Control by Main Office 화면 Remark 기능 보완 - Remark 가능한 Office인지 체크하기
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.04.25 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - CMB Trend 추가
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
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
<%@ page import="com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0044Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String pop_vvd = JSPUtil.getParameter(request, "vvd"   , "");
	String pop_ofc = JSPUtil.getParameter(request, "office", "");

	EsmSpc0044Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
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


		event = (EsmSpc0044Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	boolean isAdmin = false;
	String rhq_cd   = "";
	String ofc_cd   = event.getSignOnUserAccount().getOfc_cd();
	String rmkFlg   = "N";
	
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
	if (serverException == null) {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		isAdmin = eventResponse.getETCData("adm").equals("Y");
		rhq_cd  = eventResponse.getETCData("rhq_cd");
		ofc_cd  = eventResponse.getETCData("rgn_ofc_cd");
		rmkFlg  = eventResponse.getETCData("rmkFlg");
	}
	
	if(rhq_cd.equals("SHARC") && ofc_cd.equals("")){
		isAdmin = true;
	}
%>
<html>
<head>
<title>spaceallocationmanage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var pop_vvd = "<%=pop_vvd%>";
    var pop_ofc = "<%=pop_ofc%>";
    var rmkFlg  = "<%=rmkFlg%>";
    
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
<form name="form" onsubmit="return false;" onKeyDown="spcKeyAction('ESM_SPC_0044');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="acctCtrl" value="N">
<!-- 개발자 작업	-->
<input type="hidden" name="uiname" value="ESM_SPC_0044">
<input type="hidden" name="pol_dbl_port_chk">

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
				<table class="search_in" border="0"">
				<tr class="h23">
					<td width="90"><img class="nostar">Start Week</td>
					<td width="170" style="padding-left:1">
						<select class="input1" name="year" style="width:60;" onchange="checkWeek();"></select>
						<select class="input1" name="week" style="width:40;"></select>
					</td>
					<td width="80"><img class="nostar">Duration</td>
					<td width="150" style="padding-left:1">
						<select name="duration" class="input1" size="1"></select>
					<!-- input type="text" name="duration" style="width:40;" maxlength="1" value="5" --></td>
					<td width="50"><img class="nostar">VVD</td>
					<td width="140"><input class="input1" type="input" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
					<td width="60"></td>
					<td width="130"></td>
					<td width="45"></td>
					<td></td>
				</tr>
				<tr class="h23">
					<td width="90"><img class="nostar">Trade</td>
					<td width="170" style="padding-left:3">
						<script language="JavaScript">ComComboObject("trade", 2, 60, 0, 1);</script>
					</td>
					<td width="80"><img class="nostar">Sub Trade</td>
					<td width="150" style="padding-left:3">
						<script language="JavaScript">ComComboObject("subtrade", 3, 50, 0, 0);</script>
					</td>
					<td width="50"><img class="nostar">Lane</td>
					<td width="140" style="padding-left:2">
						<script language="JavaScript">ComComboObject("lane", 4, 82, 0, 0);</script>
					</td>
					<td width="60"><img class="nostar">Bound</td>
					<td width="125">
						<select name="bound" style="width:50;"></select>
					</td>
					<td width="50"><img class="nostar">Origin</td>
					<td><input class="input1" type="text" size="5" value="<%=ofc_cd %>" name="office" id="office"<%=isAdmin?"":"disabled" %> onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
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
				<table border="0" style="width:100%;">
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="115"><input type="text" style="width:80; text-align:center;"   value="" readonly  id="idTxtVVD"></td>
					<td width="26">WK</td>
					<td width="95"><input type="text" style="width:60; text-align:center;"   value="" readonly id="idTxtWeek"></td>
					<td style="display:;" id="controlDiv" width="115" nowrap><img class="nostar">Control Option</td>
					<td width="100%">
						<table border="0">
						<tr>
						<td align="left" style="display:;" id="controlDiv" width="100%" nowrap>
							<span style="display:none;"><input type="checkbox" value="" class="trans" checked name="chkVolume" id="chkVolume" disabled><label for="chkVolume">Volume&nbsp;&nbsp;&nbsp;</label></span>
							<select name="chkPort" disabled><option value="O">Office</option><option value="L">POL</option><option value="D">POL/POD</option><option value="T">DEST</option></select>&nbsp;&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkD2" id="chkD2" disabled><label for="chkD2">D2'</label>
							<input type="checkbox" value="" class="trans" checked name="chkD4" id="chkD4" disabled><label for="chkD4">D4'</label>
							<input type="checkbox" value="" class="trans" checked name="chkHC" id="chkHC" disabled><label for="chkHC">HC</label>
							<input type="checkbox" value="" class="trans" checked name="chk45" id="chk45" disabled><label for="chk45">45'</label>
							<input type="checkbox" value="" class="trans" checked name="chk53" id="chk53" disabled><label for="chk53">53'</label>
							<input type="checkbox" value="" class="trans" checked name="chkRFR" id="chkRFR" disabled><label for="chkRFR">Reefer</label>
							<input type="checkbox" value="" class="trans" checked name="chkDFR" id="chkDFR" disabled><label for="chkDFR">RD</label>
							<input type="checkbox" value="" class="trans" checked name="chkWGT" id="chkWGT" disabled><label for="chkWGT">Weight</label>
							<input type="checkbox" value="" class="trans" checked name="chkIPI" id="chkIPI" disabled><label for="chkIPI">Local/IPI</label>
						    <input type="checkbox" value="" class="trans" checked name="chkAccount" id="chkAccount" disabled><label for="chkAccount">Account</label>
							<input type="checkbox" value="" class="trans" checked name="chkYG" id="chkYG" disabled><label for="chkYG">YieldGroup</label>
							<input type="checkbox" value="" class="trans" checked name="chkFX" id="chkFX" disabled><label for="chkFX">Fixed</label>
						    </td>
						</tr>
						</table>
					</td>
					<td align="right" width="">
						<span id="sheetControlDiv" style=""><img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="sheet2" type="N" onclick="toggleSheetSize();" alt='Alt+↓'></span>
					</td>
				</tr>
				</table>
				<table style="width:100%;">
				<tr class="h23">
					<td align="left" width="100" nowrap>Data Selection</td>
					<td align="left" nowrap>
						<input type="checkbox" value="" class="trans" checked name="chkOfc" id="chkOfc" onclick="return changeSelection();"><label for="chkOfc">Office</label>&nbsp;&nbsp;&nbsp;
						<input type="checkbox" value="" class="trans" checked name="chkPol" id="chkPol" onclick="return changeSelection();"><label for="chkPol">POL</label>&nbsp;&nbsp;&nbsp;
						<span id="divChkPOD"><input type="checkbox" value="" class="trans" checked name="chkPod" id="chkPod" onclick="return changeSelection();"><label for="chkPod">POD</label>&nbsp;&nbsp;&nbsp;</span>
						<span id="divChkDEST"><input type="checkbox" value="" class="trans" checked name="chkDest" id="chkDest" onclick="return changeSelection();"><label for="chkDest">DEST</label>&nbsp;</span>
						<span id="divChkOCN"><input type="checkbox" value="" class="trans" checked name="chkOCN" id="chkOCN" onclick="return changeSelection();"><label for="chkOCN">OCN</label>&nbsp;&nbsp;&nbsp;</span>
						<span id="divChkIPC"><input type="checkbox" value="" class="trans" checked name="chkIPC" id="chkIPC" onclick="return changeSelection();"><label for="chkIPC">IPC</label>&nbsp;&nbsp;&nbsp;</span>
						<span id="divChkTS"><input type="checkbox" value="" class="trans" checked name="chkTS" id="chkTS" onclick="return changeSelection();"><label for="chkTS">T/S</label>&nbsp;&nbsp;&nbsp;</span>
						<span id="divChkMT"><input type="checkbox" value="" class="trans" checked name="chkEQ" id="chkEQ" onclick="return changeSelection();"><label for="chkEQ">MT</label>&nbsp;&nbsp;&nbsp;</span>
						<input type="hidden" value="" class="trans" checked name="chkTYP" id="chkTYP" onclick="return changeSelection();"><label for="chkTYP"></label>
						<input type="checkbox" value="" class="trans" name="chkTYP_ALL" id="chkTYP_ALL" onclick="return changeSelection();"><label for="chkTYP_ALL">TP/SZ</label>
						<input type="checkbox" value="" class="trans" checked name="chkWT" id="chkWT" onclick="return changeSelection();"><label for="chkWT">Weight</label>
						<span><input type="hidden" value="" class="trans" name="chkUSG" id="chkUSG" onclick="return changeSelection();"><label for="chkUSG"></label></span>
						<span><input type="checkbox" value="" class="trans" name="chkTREND" id="chkTREND" onclick="return changeSelection();"><label for="chkTREND">CMB Trend</label></span>
						<span><input type="checkbox" value="" class="trans" name="chkWKCMB" id="chkWKCMB" onclick="return changeSelection();"><label for="chkWKCMB">Weekly CMB</label></span>
						<span><input type="checkbox" value="" class="trans" name="chkCNTRMOVE" id="chkCNTRMOVE" onclick="return changeSelection();"><label for="chkCNTRMOVE">CNTR Movement</label></span>
						<span><input type="hidden" value="" class="trans" name="chkCUS" id="chkCUS" onclick="return changeSelection();"><label for="chkCUS"></label></span>
						<!-- CHECK OPTION 추가 --> 
						<span><input type="checkbox" value="" class="trans" checked name="chkIPI_O" id="chkIPI_O" onclick="return changeSelection();"><label for="chkIPI_O">Local/IPI</label></span>
						<span><input type="checkbox" value="" class="trans" checked name="chkAccount_O" id="chkAccount_O" onclick="return changeSelection();"><label for="chkAccount_O">Account</label></span>	
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
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_load_ofc" id="btng_load_ofc">Status by Load Office</td><td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_temp" id="btng_temp" alt="Temporary input">Temporary Input</td><td class="btn2_right"></td></tr></table></td>
								<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_bottleneck" id="btng_bottleneck" alt="Alt+B">Bottle Neck Check</td><td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_skd" id="btng_skd" alt="Alt+K">SKD Inquiry</td><td class="btn2_right"></td></tr></table></td>
								<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_bsa" id="btng_bsa" alt="Alt+M">BSA Management</td><td class="btn2_right"></td></tr></table></td>
								<td style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_copymodel" id="btng_copymodel">Copy Model</td><td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_season_grp" id="btng_season_grp">Yield Group</td><td class="btn2_right"></td></tr></table></td>
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
