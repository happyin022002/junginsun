<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0022.jsp
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.06 한상훈
* 1.0 Creation
=========================================================
* History
* 2011.05.19 최성민 [CHM-201110711-01] Inquiry by Trade 화면 보완
* - TAGLIB를 MULTICOMBO로 변경 작업
* - RHQ에 SHARC,SINRS를 1ROW로 추가
* - DEL radio box 추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2015.02.24 김성욱, Yield Group 버튼 깨짐(IE11) - &nbsp;추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0022Event"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.common.SPCUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0022Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	String tYear			= "";
	String tWeek			= "";
	
	boolean isAdmin = true;
	String[] arrYear = null;	//Year
	String[] arrWeek = null;	//week
	String[] arrRHQ = null;		//RHQ
	String[] arrTrade = null;	//Trade
	String[] arrSubTrade = null;//SubTrade
	String[] arrRLane = null;	//RLane
	String[] arrBound = null;	//Bound
	String[] arrOcnIpc = null;	//Ocn/Ipc
	
	
	
	Logger log = Logger.getLogger("com.hanjin.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0022Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		if (serverException == null) {
			isAdmin = eventResponse.getETCData("adm").equals("Y");		
			strOfc_cd  = eventResponse.getETCData("rhq_cd");
		}
		
		//COMMBO LIST	
		arrYear			= SPCUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("YEAR"), false);
		arrWeek			= SPCUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("WEEK"), false);
		arrRHQ			= SPCUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RHQ"), false);
		arrBound		= SPCUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BOUND"), false);
		arrOcnIpc		= SPCUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("OCNIPC"), false);
		arrTrade		= SPCUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRADE"), true);
		
		//SubTrade,Rlane 인경우는 쿼리에 '|'문자가 포함되어 있기 때문에 Row구분자를 바꿈(디폴트는 '|'문자임)
		arrSubTrade		= SPCUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SUBTRADE"), false, "@", "|");
		arrRLane		= SPCUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RLANE"), false, "@", "|");
		
		tYear 			= eventResponse.getETCData("T_YEAR");
		tWeek 			= eventResponse.getETCData("T_WEEK");
	}catch(Exception e) {
		out.println(e.toString());
	}	
%>
<html>
<head>
<title>Inquiry by Trade</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var arrYearComboCd = "<%=arrYear[0]%>";
	var arrYearComboNm = "<%=arrYear[1]%>";
	
	var arrWeekComboCd = "<%=arrWeek[0]%>";
	var arrWeekComboNm = "<%=arrWeek[1]%>";
	
	var arrRHQComboCd = "<%=arrRHQ[0]%>";
	var arrRHQComboNm = "<%=arrRHQ[1]%>";

	var arrTradeComboCd = "<%=arrTrade[0]%>";
	var arrTradeComboNm = "<%=arrTrade[1]%>";

	var arrSubTradeComboCd = "<%=arrSubTrade[0]%>";
	var arrSubTradeComboNm = "<%=arrSubTrade[1]%>";

	var arrRLaneComboCd = "<%=arrRLane[0]%>";
	var arrRLaneComboNm = "<%=arrRLane[1]%>";

	var arrBoundComboCd = "<%=arrBound[0]%>";
	var arrBoundComboNm = "<%=arrBound[1]%>";

	var arrOcnIpcComboCd = "<%=arrOcnIpc[0]%>";
	var arrOcnIpcComboNm = "<%=arrOcnIpc[1]%>";
	
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
<input type="hidden" name="t_year" value="<%= tYear%>">
<input type="hidden" name="t_week" value="<%= tWeek%>">
<input type="hidden" name="t_ofc_cd" value="<%= strOfc_cd%>">
<input type="hidden" name="t_enable" value="<%= isAdmin%>">
<!-- 개발자 작업	-->

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
				<tr class="h23">
					<td width="55"><img class="nostar">Period</td>
					<td width="347">
						<script language="javascript">ComComboObject("year1", 1, 60, 1, 1, 0, false);</script>&nbsp;
						<script language="javascript">ComComboObject("week1", 1, 50, 1, 1, 0, false);</script>&nbsp;~&nbsp;
						<script language="javascript">ComComboObject("year2", 1, 60, 1, 1, 0, false);</script>&nbsp;
						<script language="javascript">ComComboObject("week2", 1, 50, 1, 1, 0, false);</script>
					</td>
					<td width="40">RHQ</td>
					<td width="160"><script language="javascript">ComComboObject("rhq_txt", 1, 120, 0, 1, 0, false);</script></td>
					<td width="50">VVD</td>
					<td width="160"><input class="input1" type="text" name="only_vvd" value="" maxlength="9" style="width:80;" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
					<td colspan="2"></td>
					
				</tr>
				</table>
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="55"><img class="nostar">Trade</td>
					<td width="150"><script language="javascript">ComComboObject("trade", 2, 60, 0, 0, 0, false);</script></td>
					<td  width="75">Sub Trade</td>
					<td width="120"><script language="javascript">ComComboObject("subtrade", 3, 50, 0, 0, 1, false);</script></td>
					<td width="42">Lane</td>
					<td width="160"><script language="javascript">ComComboObject("lane", 4, 75, 0, 0, 2, false);</script></td>
					<td width="52">Bound</td>
					<td width="160"><script language="javascript">ComComboObject("bound", 1, 80, 0, 0, 0, false);</script></td>
					<td width="60">OCN/IPC</td>
					<td><script language="javascript">ComComboObject("onc_ipc", 1, 80, 0, 0, 0, false);</script></td>
				</tr>
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

		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tab1')</script>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->


<!-- UI_ESM_SPC_022 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table width="100%" border="0">
				<tr>
				<td width="700">
				<table class="search">
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="130"><input type="text" name="vvd1" style="width:80;" value="" readonly></td>
					<td width="75">Sales Origin</td>
					<td width="180" class="stm"><input type="radio" name="rhq_gso1" value="RHQ" class="trans" onclick="changeTitle_Colum('1');" checked>Area/RHQ&nbsp;<input type="radio" name="rhq_gso1" value="GSO" class="trans" onclick="changeTitle_Colum('1');" >Office</td>
					<td width=""><input type="checkbox" name="weight1" value="1" class="trans" checked onclick="changeTitle1('1', this);">Weight&nbsp;
					             <input type="checkbox" name="type1" value="1" class="trans" onclick="changeTitle2('1', this);">TP/SZ
					             <input type="checkbox" name="cmb1" value="1" class="trans" onclick="changeTitle3('1', this);">Weekly CMB&nbsp;
					</td>
					</tr>
				</table>
				</td>
				<td width="130">
					<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_season_grp" id="btng_season_grp">Yield&nbsp;Group</td><td class="btn2_right"></td></tr></table></td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td></tr>
					</table>
				</td>
				<td width="" class="gray">Unit : TEU,Ton</td>
				<td align="right"><img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="t1sheet1" type="N" onclick="toggleSheetSize();" alt='Alt+↓'></td>
				</tr>
				</table>


				<!-- : ( POR ) (S) -->

        					<table width="100%" id="mainTable">
                                <tr><td>
                                     <script language="javascript">ComSheetObject('t1sheet1');</script>
                                </td></tr>
        		            </table>


				<!-- : ( POR ) (E) -->




			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</div>

<!-- UI_ESM_SPC_022_T1 : THIS IS 2st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table width="100%">
				<tr>
				<td>
				<table class="search" border="0">
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="100"><input type="text" name="vvd2" style="width:80;" value="" readonly></td>
					<td width="75">Sales Origin</td>
					<td width="125" class="stm"><input type="radio" name="rhq_gso2" value="RHQ" class="trans" onclick="changeTitle_Colum('2');" checked>RHQ
					                            <input type="radio" name="rhq_gso2" value="GSO" class="trans" onclick="changeTitle_Colum('2');">Office</td>
					<td width="60">POL/POD/DEL</td>
					<td width="160" class="stm">
						<input type="radio" name="pol_pod2" value="POL" class="trans" onclick="changeTitle_Colum('2');" checked>POL
						<input type="radio" name="pol_pod2" value="POD" class="trans" onclick="changeTitle_Colum('2');">POD
						<input type="radio" name="pol_pod2" value="DEL" class="trans" onclick="changeTitle_Colum('2');">DEL</td>
					<td width=""><input type="checkbox" name="weight2" value="1" class="trans" checked onclick="changeTitle1('2', this);">Weight
					             <input type="checkbox" name="type2" value="1" class="trans" onclick="changeTitle2('2', this);">TP/SZ
					             <input type="checkbox" name="cmb2" value="1" class="trans" onclick="changeTitle3('2', this);">Weekly CMB</td>
					<td width="" class="gray">Unit : TEU,Ton</td></tr>
				</table>
				</td>
				<td align="right"><img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="t2sheet1" type="N" onclick="toggleSheetSize();" alt='Alt+↓'></td>
				</tr>
				</table>

				<!-- : ( POR ) (S) -->

        					<table width="100%" id="mainTable">
                                <tr><td>
                                     <script language="javascript">ComSheetObject('t2sheet1');</script>
                                </td></tr>
        		            </table>


				<!-- : ( POR ) (E) -->




			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</div>

<!-- UI_ESM_SPC_022_T2 : THIS IS 3st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table width="100%">
				<tr>
				<td width="780">
				<table class="search" border="0">
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="95"><input type="text" name="vvd3" style="width:80;" value="" readonly></td>
					<td width="68">Sales Org</td>
					<td width="110" class="stm"><input type="radio" name="rhq_gso3" value="RHQ" class="trans" onclick="changeTitle_Colum('3');" checked>RHQ
					                            <input type="radio" name="rhq_gso3" value="GSO" class="trans" onclick="changeTitle_Colum('3');">Office</td>
					<td width="57">POL/POD/DEL</td>
					<td width="153" class="stm">
						<input type="radio" name="pol_pod3" value="POL" class="trans" onclick="changeTitle_Colum('3');" checked>POL
						<input type="radio" name="pol_pod3" value="POD" class="trans" onclick="changeTitle_Colum('3');">POD
						<input type="radio" name="pol_pod3" value="DEL" class="trans" onclick="changeTitle_Colum('3');">DEL</td>
					<td width=""><input type="checkbox" name="weight3" value="1" class="trans" checked onclick="changeTitle1('3', this);">Weight
								 <input type="checkbox" name="type3" value="1" class="trans" onclick="changeTitle2('3', this);">TP/SZ
								 <input type="checkbox" name="cmb3" value="1" class="trans" onclick="changeTitle3('3', this);">Weekly CMB
								 </td>
					</tr>
				</table>
				</td>
				<td width="100">
					<table width="100%" class="button" border="0">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_season_grp" id="btng_season_grp">Yield&nbsp;Group</td><td class="btn2_right"></td></tr></table></td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td></tr>
					</table>
				</td>
				<td width="" class="gray">Unit : TEU,Ton</td>
				
				<td align="right"><img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="t3sheet1" type="N" onclick="toggleSheetSize();" alt='Alt+↓'></td>
				</tr>
				</table>
				<!-- : ( POR ) (S) -->

				<table width="100%" id="mainTable">
                       <tr><td>
                            <script language="javascript">ComSheetObject('t3sheet1');</script>
                       </td></tr>
	            </table>
				<!-- : ( POR ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
	</div>

<!-- UI_ESM_SPC_022_T2 : THIS IS 4st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table width="100%">
				<tr>
				<td>
				<table class="search" border="0">
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="100"><input type="text" name="vvd4" style="width:80;" value="" readonly></td>
					<td width="75">Sales Origin</td>
					<td width="125" class="stm"><input type="radio" name="rhq_gso4" value="RHQ" class="trans" onclick="changeTitle_Colum('4');" checked>RHQ
					                            <input type="radio" name="rhq_gso4" value="GSO" class="trans" onclick="changeTitle_Colum('4');">Office</td>
					<td width="60">POL/POD/DEL</td>
					<td width="160" class="stm">
						<input type="radio" name="pol_pod4" value="POL" class="trans" onclick="changeTitle_Colum('4');" checked>POL
						<input type="radio" name="pol_pod4" value="POD" class="trans"onclick="changeTitle_Colum('4');">POD
						<input type="radio" name="pol_pod4" value="DEL" class="trans" onclick="changeTitle_Colum('4');">DEL</td>
					<td width=""><input type="checkbox" name="weight4" value="1" class="trans" checked onclick="changeTitle1('4', this);">Weight
								 <input type="checkbox" name="type4" value="1" class="trans" onclick="changeTitle2('4', this);">TP/SZ
								 <input type="checkbox" name="cmb4" value="1" class="trans" onclick="changeTitle3('4', this);">Weekly CMB
								 </td>
					<td width="" class="gray">Unit : TEU,Ton</td></tr>
				</table>
				</td>
				<td align="right"><img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="t4sheet1" type="N" onclick="toggleSheetSize();" alt='Alt+↓'></td>
				</tr>
				</table>
				<!-- : ( POR ) (S) -->

				<table width="100%" id="mainTable">
                       <tr><td>
                            <script language="javascript">ComSheetObject('t4sheet1');</script>
                       </td></tr>
	            </table>
				<!-- : ( POR ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
	</div>

				
</td></tr>
</table>
<!-- Outer Table (E)-->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
