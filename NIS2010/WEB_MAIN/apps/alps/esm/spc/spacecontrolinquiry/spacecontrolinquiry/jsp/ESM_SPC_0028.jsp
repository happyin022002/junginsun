<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0028.jsp
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
	* 2008-03-26 김원섭
	* CSR : N200803190014   T/S allocation 관련 SPC 화면 수정
	*    - 상단 Sheet에 Alloc TS 컬럼 추가
	*    - 하단 Tab/Sheet 추가
	* 2008-11-17 임옥영/서관영 CSR:N200811140005/N200811130019
	* - 단축키 추가(ESM_SPC_022, 024, 028, 056, 070)
*@LastModifyDate : 2009.10.12
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.12 한상훈
* 1.0 Creation
* 2010.06.22 Lee Sang-Yong : 프로젝트 CHM-201004171  53ft(DW,DX) 추가
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.07.31 차상영 [CHM-201431081] SPC Allocation Control Option 추가 보완
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
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	
    String pop_vvd = JSPUtil.getParameter(request, "vvd"   , "");
    String pop_ofc = JSPUtil.getParameter(request, "office", "");
    
    EsmSpc0028Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0028Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	boolean isAdmin     = true;
	String rhq_cd       = "";
	String rgn_cd       = "";
	String ofc_cd       = event.getSignOnUserAccount().getOfc_cd();
	
	if (serverException == null) {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		isAdmin = eventResponse.getETCData("adm").equals("Y");		
		rhq_cd  = eventResponse.getETCData("rhq_cd");	
		rgn_cd  = eventResponse.getETCData("rgn_ofc_cd");	
		ofc_cd  = eventResponse.getETCData("ofc_cd");
	}
	
	if(!rhq_cd.equals("") && rgn_cd.equals("")){
		isAdmin = true;
	}
	
	if(isAdmin){
		ofc_cd = "";
	}
%>
<html>
<head>
<title>Inquiry by Sub Office</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var pop_vvd = "<%=pop_vvd%>";
    var pop_ofc = "<%=pop_ofc%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		document.form.year1.focus();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
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
					<td colspan="3" width="500">
						<select class="input1" name="year1" style="width:60;" onchange="checkWeek1();"></select>
						<select class="input1" name="week1" style="width:50;"></select>&nbsp;~&nbsp;
						<select class="input1" name="year2" style="width:60;" onchange="checkWeek2();"></select>
						<select class="input1" name="week2" style="width:50;"></select>						
					</td>
					<td width="35">VVD</td>
					<td width="220"><input class="input1" type="text" name="only_vvd" maxlength="9" style="width:80;" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
					<td width="50">Office</td>
					<td width="" colspan="3"><input class="input1" type="text" name="sales_office" style="width:80;" value="<%=ofc_cd%>"<%=isAdmin?"":" disabled" %> maxlength=6 onkeypress="eventKeyChangeChar(UPPER_CASE);"onchange="checkValue();"></td>
				</tr>
				<tr class="h23">
					<td width="55"><img class="nostar">Trade</td>
					<td width="300" style="padding-left:2">
						<script language="JavaScript">ComComboObject("trade", 2, 115, 0, 0);</script>
					</td>
					<td  width="70">Sub Trade</td>
					<td width="180">
						<script language="JavaScript">ComComboObject("subtrade", 3, 50, 0, 0);</script>
					</td>
					<td width="35">Lane</td>
					<td width="220" style="padding-left:2">
						<script language="JavaScript">ComComboObject("lane", 4, 80, 0, 0);</script>
					</td>
					<td width="50">Bound</td>
					<td>
						<select name="bound" style="width:80;"></select>
					</td>
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
		                        <tr><td align="right" class="gray"><span>Unit : TEU</span> &nbsp; <img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="sheet1" type="N" onclick="toggleSheetSize();" alt='Alt+↑'></td></tr>
				            </table>

							<!-- : ( grid ) (S) -->

        					<table width="100%" id="mainTable">
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
           	<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
		</table>

		<!-- TABLE '#D' : ( Tab ) (E) -->

<!-- UI_ESM_SPC_028 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table width="100%" border="0">
				<tr>
				<td>
					<table class="search" border="0">
					<tr class="h23">
						<td width="35">VVD</td>
						<td width="120"><input type="text" name="vvd" style="width:80;" value="" readonly></td>
						<td style="display:;" id="controlDiv" width="105" nowrap>Control Option</td>
						<td style="display:;" id="controlDiv" nowrap>
							<span style="display:none;"><input type="checkbox" value="" class="trans" checked name="chkVolume" disabled>Volume&nbsp;&nbsp;&nbsp;</span>
							<select name="chkPort" disabled><option value="O">Office</option><option value="L">POL</option><option value="D">POL/POD</option><option value="T">Dest</option></select>&nbsp;&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkD2" disabled>D2&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkD4" disabled>D4&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkHC40" disabled>HC&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkHC45" disabled>45'&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chk53FT" disabled>53'&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkRFR" disabled>RF<!-- Reefer-->&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkRD" disabled>RD&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkWGT" disabled>Weight
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
					</tr>
					<tr class="h23">
						<td colspan="2"></td>
						<td width="105" nowrap>Data Selection</td>
						<td colspan="2" nowrap>
						<table><tr><td>
							<input type="checkbox" value="" class="trans" checked name="chkPol" id="chkPol1" onclick="return controlTrees();"><label for="chkPol1">POL</label>&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkPod" id="chkPod1" onclick="return controlTrees();"><label for="chkPod1">POD</label>&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkTYP" id="chkTYP1" onclick="return selectChange();"><label for="chkTYP1">TP/SZ</label>
							<input type="checkbox" value="" class="trans" checked name="chkWT" id="chkWT1" onclick="return selectChange();"><label for="chkWT1">Weight</label>
							<input type="checkbox" value="" class="trans" name="chkCMB" id="chkCMB" onclick="return selectChange();"><label for="chkCMB">Weekly CMB</label>			
							<input type="checkbox" value="" class="trans" checked name="chkLocalIpi" id="chkLocalIpi" onclick="return controlTrees();"><label for="chkLocalIpi">Local/IPI</label>&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkAcct" id="chkAcct" onclick="return controlTrees();"><label for="chkAcct">Account</label>&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkDest" id="chkDest" onclick="return controlTrees();"><label for="chkDest">Dest</label>&nbsp;&nbsp;
						</td></tr></table>

						</td>
					</tr>
					</table>
				</td>
				<td align="right" valign="top" class="gray"><span>Unit : TEU,Ton</span> &nbsp; <img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="t1sheet1" type="N" onclick="toggleSheetSize();" alt='Alt+↓'></td>
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

<!-- UI_ESM_SPC_028_T2 : THIS IS 2st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table width="100%" border="0">
				<tr>
				<td>
					<table class="" border="0">
					<tr class="h23">
						<td width="35">VVD</td>
						<td width="120"><input type="text" name="vvd" style="width:80;" value="" readonly></td>
						<td width="105" nowrap>Data Selection</td>
						<td width="500" nowrap>
							<input type="radio" value="" class="trans" checked name="chkPolPodS" id="chkPolPodS1" onclick="return changePolPod();"><label for="chkPolPodS1">POL</label>&nbsp;&nbsp;&nbsp;
							<input type="radio" value="" class="trans" name="chkPolPodS" id="chkPolPodS2" onclick="return changePolPod();"><label for="chkPolPodS2">POD</label>&nbsp;&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkTYP" id="chkTYP2" onclick="return selectChange();"><label for="chkTYP2">TP/SZ</label>
							<input type="checkbox" value="" class="trans" checked name="chkWT" id="chkWT2" onclick="return selectChange();"><label for="chkWT2">Weight</label>
							<input type="checkbox" value="" class="trans" name="chkCMB" id="chkCMB" onclick="return selectChange();"><label for="chkCMB">Weekly CMB</label>
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
					</tr>
					</table>
				</td>
				<td align="right" valign="top" class="gray"><span>Unit : TEU,Ton</span> &nbsp; <img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="t1sheet2" type="N" onclick="toggleSheetSize();" alt='Alt+↓'></td>
				</tr>
				</table>
				<!-- : ( POR ) (S) -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t1sheet2');</script>
                        </td></tr>
		            </table>


				<!-- : ( POR ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</div>

<!-- UI_ESM_SPC_028_T2 : THIS IS 3st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table width="100%" border="0">
				<tr>
				<td>
					<table class="" border="0">
					<tr class="h23">
						<td width="35">VVD</td>
						<td width="120"><input type="text" name="vvd" style="width:80;" value="" readonly></td>
						<td width="105" nowrap>Data Selection</td>
						<td width="500" nowrap>
							<input type="radio" value="" class="trans" checked name="chkPolPodC" id="chkPolPodC1" onclick="return changePolPod();"><label for="chkPolPodC1">POL</label>&nbsp;&nbsp;&nbsp;
							<input type="radio" value="" class="trans" name="chkPolPodC" id="chkPolPodC2" onclick="return changePolPod();"><label for="chkPolPodC2">POD</label>&nbsp;&nbsp;&nbsp;
							<input type="checkbox" value="" class="trans" checked name="chkTYP" id="chkTYP3" onclick="return selectChange();"><label for="chkTYP3">TP/SZ</label>
							<input type="checkbox" value="" class="trans" checked name="chkWT" id="chkWT3" onclick="return selectChange();"><label for="chkWT3">Weight</label>
							<input type="checkbox" value="" class="trans" name="chkCMB" id="chkCMB" onclick="return selectChange();"><label for="chkCMB">Weekly CMB</label>
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
					</tr>
					</table>
				</td>
				<td align="right" valign="top" class="gray"><span>Unit : TEU,Ton</span> &nbsp; <img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="t1sheet3" type="N" onclick="toggleSheetSize();" alt='Alt+↓'></td>
				</tr>
				</table>
				<!-- : ( POR ) (S) -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t1sheet3');</script>
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