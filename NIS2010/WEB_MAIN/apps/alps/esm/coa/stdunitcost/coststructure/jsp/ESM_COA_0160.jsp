<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0160.jsp
*@FileTitle : Route Management for Agreement Restricion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.09.22 장영석
* 2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
	               CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2015.07.07 이윤정 [CHM-201536740] COA 내 화면의 조회 기능 (Retrieve, Down Excel)을 뺀 나머지 버튼들을 비활성화 요청 CSR
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.GetVariableheader2VO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	//헤더관련 변수 선언
	String hdCode = "";
	String hdText = "";
	//List<GetVariableheader2VO> GetVariableheader2VO = null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.CostStructure");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);	

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		Map<String,String> returnVal = new HashMap<String,String>();
		returnVal = eventResponse.getETCData();
		
		hdCode = returnVal.get("headerCode");
		hdText = returnVal.get("headerText");
		// 헤더 setting
	
		
	}catch(Exception e) {
		  log.error("Exception : " + e.toString());
	}
%>
<html>
<head>
<title>Route Management for Agreement Restricion</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage('<%=hdCode%>', '<%=hdText%>');
		btn_Retrieve.focus();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sRow" value="">
<input type="hidden" name="changeValue" value="">
<input type="hidden" name="code" value="<%=hdCode%>">
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
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

					</td></tr>
				</table>
              <!-- TABLE '#D' : ( Button : Main ) (E) -->

              <!-- TABLE '#D' : ( Search Options ) (S) -->
              <table class="search">
                <tr>
                  <td class="bg">
                    <!-- : ( Year ) (S) -->
                    <table class="search_in" border="0">
                      <tr class="h23">
						<td width="6%">Node</td>
						<td width="3%">1st</td>
						<td width="12%">
							<input type="text" style="width:70" name="f_1st"  value="" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >
						</td>
						<td width="3%">2nd</td>
						<td width="12%">
							<input type="text" style="width:70" name="f_2nd"  value="" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >
						</td>
						<td width="3%">3rd</td>
						<td width="12%">
							<input type="text" style="width:70" name="f_3td"  value="" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >
						</td>
						<td width="3%">4th</td>
						<td>
							<input type="text" style="width:70" name="f_4th"  value="" maxlength="7" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >
						</td>
                      </tr>
                    </table>
                    <!-- : ( Year ) (E) -->
                  </td>
                </tr>
              </table>
              <!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">
				<!-- : ( From Location ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( From Location ) (E) -->

				<!-- : ( Button : Grid ) (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<!-- Repeat Pattern -->
						<!--  
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_RowAdd" name="btng_RowAdd">Row Add</td><td class="btn2_right"></td></tr></table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_Save" name="btng_Save">Save</td><td class="btn2_right"></td></tr></table></td>
						-->
						<!-- Repeat Pattern -->


					</tr></table>
				</td></tr>
				</table>
				<!-- : ( Button : Grid ) (E) -->

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