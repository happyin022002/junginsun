<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0104.jsp
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
	* 2007-12-14 김원섭
	* 1.0 최초 생성
	* 2010.07.08 Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가
*@LastModifyDate : 2009.08.28
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.28 한상훈
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2015.02.23 [CHM-201533936] Split13-사용자 표준환경 관련 - 버튼 공백대신 &nbsp;추가, combobox 처리
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0104Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	
	EsmSpc0104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.DailyForecast.Dailyforecastmanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd	 = event.getSignOnUserAccount().getOfc_cd();
	String ofc_tp_cd = "";
	
	if (serverException == null) {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		ofc_tp_cd = eventResponse.getETCData("ofc_tp_cd");
	}
%>

<html>
<head>
<title>dailyforecastmanage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	
	var ofc_cd = "<%=ofc_cd%>";
	var ofc_tp_cd = "<%=ofc_tp_cd%>";
	
	function setupPage(){
		loadPage();
	}
	
	
</script>
</head>

<body  onLoad="javascript:setupPage()">
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
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down&nbsp;Excel</td><td class="btn1_right"></td></tr></table></td>
							   <td>&nbsp;</td>
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
					<td width="85"><img class="nostar">Start Week</td>
					<td width="190">
						<select class="input1" name="year" style="width:60;" onchange="checkWeek();"></select>
						<select class="input1" name="week" style="width:40;"></select>
						
					</td>
					<td width="75"><img class="nostar">Duration</td>
					<td width="170" >
						<select class="input1" name="duration" size="1"></select>
					</td>
					<td colspan="2"  width="245">
						<input type="radio" class="trans" name="ioc" id="id_chk_ocn" value="O" checked>
						<label for="id_chk_ocn">OCN</label>
						<input type="radio" class="trans" name="ioc" id="id_chk_ipc" value="I">
						<label for="id_chk_ipc">IPC</label>
						<input type="radio" class="trans" name="ioc" id="id_chk_ts" value="T">
						<label for="id_chk_ts" align=left >TS</label>
					</td>
					<td width="60">VVD</td>
					<td width="138"><input class="input1" type="input" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);" onchange="vvdChanged();">
					</td>
				</tr>
				<tr class="h23">
					<td width="85"><img class="nostar">Trade</td>
					<td width="190" style="padding-left:2">
						<script language="JavaScript">ComComboObject("trade", 2, 104, 0, 1);</script>
					</td>
					<td width="75"><img class="nostar">Sub Trade</td>
					<td width="170" style="padding-left:2">
						<script language="JavaScript">ComComboObject("subTrade", 3, 80, 0, 0);</script>
					</td>
					<td width="75"><img class="nostar">Lane</td>
					<td width="170">
						<script language="JavaScript">ComComboObject("lane", 4, 70, 0, 1);</script>
					</td>
					<td width="60">Bound</td>
					<td width="138">
						<select name="bound" style="width:82;"></select>
					</td>

				</tr>
				<tr class="h23">
					<td width="85"><img class="nostar">RGN Office</td>
					<td width="190" style="padding-left:2;"><script language="JavaScript">ComComboObject("salesOffice", 2, 104, 0, 1);</script></td>
					<td width="75"><img class="nostar">Sub-Office</td>
					<td width="170" style="padding-left:2;"><script language="JavaScript">ComComboObject("subOffice", 2, 80, 0);</script></td>
					<td width="245" id="salesreppopup" colspan="2">
						<table>
							<tr class="h23">
								<td width="76"><img class="nostar">Sales&nbsp;Rep</td>
								<td><script language="JavaScript">ComComboObject("salesRep", 4, 70, 0);//initData_salesRep();</script></td>
							</tr>
						</table>
					</td>
					<td id="accountpopup" colspan="2">
						<table>
							<tr class="h23">
								<td width="60">Account</td>
								<td width="138"  style="padding-left:2"><script language="JavaScript">ComComboObject("acct", 4, 100, 1);</script></td>
							</tr>
						</table>
					</td>

				  </tr>

				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab" >
           	<tr><td><script language="javascript">ComTabObject('tab1')</script>
		</table>

		<!-- UI_ESM_SPC_104 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
<table width="100%">
				<tr>
				<td>
					<table cellpadding="0" cellspacing="0">
					<tr>
					<td width="90">Data Selection : </td>
					<td width="5"></td>
					<td><input type="hidden" class="trans" name="chkDs1OFC" id="ds1OFC"  checked onclick="return changeDataSelection1();"></td><td><label for="ds1OFC"></label></td>
					<td width="5"></td>
					<td><input  type="checkbox" class="trans" name="chkDs1US" id="ds1US"   onclick="return changeDataSelection1();"></td><td><label for="ds1US">IPI/Local</label></td>
					<td width="5" id="divDs1US"></td>
					<td><input  type="checkbox" class="trans" name="chkDs1POL" id="ds1POL"   onclick="return changeDataSelection1();"></td><td><label for="ds1POL">POL</label></td>
					<td width="5" id="divDs1POD"></td>
					<td id="divDs1POD"><input type="checkbox" class="trans" name="chkDs1POD" id="ds1POD"   onclick="return changeDataSelection1();"></td><td id="divDs1POD"><label for="ds1POD">POD</label></td>
					<td width="5"></td>
					<td id="divDs1Dest"><input type="checkbox" class="trans" name="chkDs1Dest" id="ds1Dest"   onclick="return changeDataSelection1();"></td><td id="divDs1Dest"><label for="ds1Dest">DEST</label></td>
					<td width="5"></td>
					<td><input type="hidden" class="trans" name="chkDs1OTH" id="ds1OTH" onclick="return changeDataSelection1();"></td><td><label for="ds1OTH"></label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs1D2" id="ds1D2" onclick="return changeDataSelection1();"></td><td><label for="ds1D2">D2</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs1D4" id="ds1D4" onclick="return changeDataSelection1();"></td><td><label for="ds1D4">D4</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs1HC" id="ds1HC" onclick="return changeDataSelection1();"></td><td><label for="ds1HC">HC</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs145" id="ds145" onclick="return changeDataSelection1();"></td><td><label for="ds145">45</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs153" id="ds153" onclick="return changeDataSelection1();"></td><td><label for="ds153">53'</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs1RF" id="ds1RF" onclick="return changeDataSelection1();"></td><td><label for="ds1RF">RF</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs1RD" id="ds1RD" onclick="return changeDataSelection1();"></td><td><label for="ds1RD">RD</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs1WT" id="ds1WT" onclick="return changeDataSelection1();"></td><td><label for="ds1WT">WT</label></td>
					<td width="5"></td>
					
					<td width="25" style="display:none;" id="divDs1MDL"><input type="checkbox" class="trans" name="chkDs1MDL" id="ds1MDL" onclick="return changeDataSelection();"></td>
					<td style="display:none;" id="divDs1MDL"><label for="ds1MDL">Model</label></td>

					</tr></table>
				</td>
				<td align="right" id="sheetControlDiv">
					<img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="t1sheet1" type="N" onclick="toggleSheetSize();">
				</td>
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

				<table width="100%">
				<tr>
				<td>
					<table cellpadding="0" cellspacing="0">
					<tr>
					<td width="90">Data Selection : </td>
					<td width="5"></td>
					<td><input type="hidden" class="trans" name="chkDs2OFC" id="ds2OFC"  checked onclick="return changeDataSelection();"></td><td><label for="ds2OFC"></label></td>
					<td width="5"></td>
					<td><input  type="checkbox" class="trans" name="chkDs2US" id="ds2US"   onclick="return changeDataSelection();"></td><td><label for="ds2US">IPI/Local</label></td>
					<td width="5" id="divDs2US"></td>
					<td><input type="checkbox" class="trans" name="chkDs2Account" id="ds2Account"  onclick="return changeDataSelection();"></td><td><label for="ds2Account">Account</label></td>
					<td width="5" id="divDs2POD"></td>
					<td><input  type="hidden" class="trans" name="chkDs2POL" id="ds2POL" checked  onclick="return changeDataSelection();"></td><td><label for="ds2POL"></label></td>
					<td width="5"></td>
					<td id="divDs2POD"><input type="checkbox" class="trans" name="chkDs2POD" id="ds2POD"   onclick="return changeDataSelection();"></td><td id="divDs2POD"><label for="ds2POD">POD</label></td>
					<td width="5"></td>
					<td id="divDs2Dest"><input type="checkbox" class="trans" name="chkDs2Dest" id="ds2Dest"   onclick="return changeDataSelection();"></td><td id="divDs2Dest"><label for="ds2Dest">DEST</label></td>
					<td width="5"></td>
					<td><input type="hidden" class="trans" name="chkDs2OTH" id="ds2OTH" onclick="return changeDataSelection();"></td><td><label for="ds2OTH"></label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs2D2" id="ds2D2" onclick="return changeDataSelection();"></td><td><label for="ds2D2">D2</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs2D4" id="ds2D4" onclick="return changeDataSelection();"></td><td><label for="ds2D4">D4</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs2HC" id="ds2HC" onclick="return changeDataSelection();"></td><td><label for="ds2HC">HC</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs245" id="ds245" onclick="return changeDataSelection();"></td><td><label for="ds245">45</label></td>
					<td width="5">
					<td><input type="checkbox" class="trans" name="chkDs253" id="ds253" onclick="return changeDataSelection();"></td><td><label for="ds253">53'</label></td>
					<td width="5">
					<td><input type="checkbox" class="trans" name="chkDs2RF" id="ds2RF" onclick="return changeDataSelection();"></td><td><label for="ds2RF">RF</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs2RD" id="ds2RD" onclick="return changeDataSelection();"></td><td><label for="ds2RD">RD</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs2WT" id="ds2WT" onclick="return changeDataSelection();"></td><td><label for="ds2WT">WT</label></td>
					<td width="5"></td>
					
					<td width="25" style="display:none;" id="divDs2MDL"><input type="checkbox" class="trans" name="chkDs2MDL" id="ds2MDL" onclick="return changeDataSelection();"></td>
					<td style="display:none;" id="divDs2MDL"><label for="ds2MDL">Model</label></td>

					</tr></table>
				</td>
				<td align="right" id="sheetControlDiv">
					<img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="t1sheet2" type="N" onclick="toggleSheetSize();">
				</td>
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

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>