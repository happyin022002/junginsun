<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0024.jsp
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
	* 2006-10-09 kyungae park
	* 1.0
	* 2008-11-17 임옥영/서관영 CSR:N200811140005/N200811130019
	* - 단축키 추가(ESM_SPC_022, 024, 028, 056, 070)
	* 2008-02-27 최윤성 CSR:N200902250050
	* - rhq Combo를 Select box로 변경하면서 option 값 변경
*@LastModifyDate : 2009.08.19
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.19 한상훈
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmSpc0024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmSpc0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	boolean isAdmin = false;
	String rhq_cd   = "";
	String aq_cd    = "";
	String rgn_cd   = "";
	String ofc_cd   = event.getSignOnUserAccount().getOfc_cd();
	
	if (serverException == null) {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		isAdmin = eventResponse.getETCData("adm").equals("Y");		
		rhq_cd  = eventResponse.getETCData("rhq_cd");	
		aq_cd   = eventResponse.getETCData("aq_cd");	
		rgn_cd  = eventResponse.getETCData("rgn_ofc_cd");		
		ofc_cd  = eventResponse.getETCData("ofc_cd");		
		
		if(rhq_cd.equals(ofc_cd) || aq_cd.equals(ofc_cd)){
			ofc_cd = "";
		} else if(!rgn_cd.equals(ofc_cd)) {
			ofc_cd = rgn_cd;
		}
	}
	
	if(isAdmin) {
		ofc_cd = "";
	}
	
%>
<html>
<head>
<title>spacecontrolinquiry</title>
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
					<td width="50"><img class="nostar">Type</td>
					<td class="stm" width="200">
						<span style="display:none;"><input type="radio" name="type" value="M" class="trans">Monthly</span>
						<input type="radio" name="type" value="2" class="trans" checked>D-7
						<input type="radio" name="type" value="1" class="trans">D-2
					</td>
					<td width="50"><img class="nostar">Year</td>
					<td width="150">
						<select class="input1" name="year" style="width:60;" onchange="checkWeek();"></select>
					</td>
					<td width="55"><img class="nostar">Month</td>
					<td width="150">
						<select class="input1" name="month" style="width:60;" onchange="changePeriod();"></select>
					</td>
					<td width="50"><img class="nostar">Week</td>
					<td width="140">
						<select class="input1" name="week" style="width:70;" onchange="changePeriod();"></select>
					</td>
					<td width="60"><img class="nostar">Bound</td>
					<td width="120">
						<select name="bound" style="width:50;" class="input"></select>
					</td>
					<td width=""></td>
					<td width=""></td>
				</tr>
				<tr class="h23">
					<td width="50"><img class="nostar">RHQ</td>
					<td width="200">
						<SELECT class="input1" name="rhq" <%=isAdmin?"":"disabled" %>>
							<option></option>
							<option value="SHARC" <%=rhq_cd.equals("SHARC")? "selected":"" %>>SHARC</option>
							<option value="SINRS" <%=rhq_cd.equals("SINRS")? "selected":"" %>>SINRS</option>
							<option value="NYCRA" <%=rhq_cd.equals("NYCRA")? "selected":"" %>>NYCRA</option>
							<option value="HAMRU" <%=rhq_cd.equals("HAMRU")? "selected":"" %>>HAMRU</option>
							<option value="SHARC,SINRS">SHARC, SINRS</option>
						</SELECT>
					<td width="50"><img class="nostar">Office</td>
					<td width="150"><input type="text" name="office" style="width:60;" value="<%=ofc_cd%>"<%=ofc_cd.equals("")?"":" disabled" %> maxlength=6 onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
					<td width="55"><img class="nostar">Trade</td>
					<td width="150" style="padding-left:2;">
						<script language="JavaScript">ComComboObject("trade", 2, 60, 0, 0);</script>
					</td>
					<td width="50"><img class="nostar">Lane</td>
					<td width="140" style="padding-left:2;">
						<script language="JavaScript">ComComboObject("lane", 4, 70, 0, 0);</script>
					</td>
					<td width="40"><img class="nostar">VVD</td>
					<td width=""><input class="input1" type="input" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tab1')</script>
		</table>

		<!-- UI_ESM_SPC_028 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_5"><tr><td></td></tr></table>

				<table class="" border="0" width="100%">
				<tr class="h23">
					<td>(WK <span id="sheet1_wk"></span>)</td>
					<td align="right">(Unit : TEU)</td>
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

				<table class="height_5"><tr><td></td></tr></table>

				<table class="" border="0" width="100%">
				<tr class="h23">
					<td>
						<table class="" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>Data Selection</td>
							<td><input type="checkbox" name="ofcCheck" id="" class="trans" checked onclick="dataSelectionByTradeByOffice();"></td>
							<td>ByOffice</td>
							</tr>
						</table>
					</td>
					<td align="right">(Unit : TEU)</td>
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

<!-- UI_ESM_SPC_028_T2 : THIS IS 3st TAB-->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_5"><tr><td></td></tr></table>

				<table class="" border="0" width="100%">
				<tr class="h23">
					<td></td>
					<td align="right">(Unit : TEU)</td>
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

<!-- UI_ESM_SPC_028_T2 : THIS IS 2st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_5"><tr><td></td></tr></table>

				<table class="" border="0" width="100%">
				<tr class="h23">
					<td></td>
					<td align="right">(Unit : TEU)</td>
					</tr>
				</table>

				<!-- : ( POR ) (S) -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t1sheet4');</script>
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

				<table class="height_5"><tr><td></td></tr></table>

				<table class="" border="0" width="100%">
				<tr class="h23">
					<td></td>
					<td align="right">(Unit : TEU)</td>
					</tr>
				</table>

				<!-- : ( POR ) (S) -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t1sheet5');</script>
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
