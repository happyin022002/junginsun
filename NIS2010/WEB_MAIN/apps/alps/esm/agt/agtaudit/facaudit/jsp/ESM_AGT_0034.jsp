<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_034.jsp
*@FileTitle : Agent Commission AP Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-30
*@LastModifier : Jung-Hyung, Kim
*@LastVersion : 1.0
* 2007-01-30 Jung-Hyung, Kim
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.event.EsmAgt0034Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.CodeUtil" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil" %>

<%
	EsmAgt0034Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//에러메세지
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수

	String userId = "";
	String cbOfcCd = "";

	try {
		event = (EsmAgt0034Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
		} // end else

	}catch(Exception e) {
		out.println(e.toString());
	}

	//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
	cbOfcCd = ComboUtil.getCodeCombo("cbOfcCd", "", " onChange='cbOfcCd_OnChange(this)' style='width:85'", "facOfcCd", "", "&lt;&lt;select&gt;&gt;", "");
%>

<html>
<head>
<title>FAC AP Actual Interface</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="param1">	 <!-- Detail Grid 조회를 위한 F.Forwarder -->
<input type="hidden" name="param2">	 <!-- Detail Grid 조회를 위한 CSR No -->
<input type="hidden" name="h_csrNo"> <!-- grid에서 선택된 csrNo -->


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
						<table width="100%" class="button">
							<tr>
								<td class="align">
									<table class="button">
										<tr>
											<td><img class="cursor" src="/hanjin/img/button/btn_retrieve.gif"  width="66" height="20" border="0" name="btn_retrieve"></td>
											<td><img class="cursor" src="/hanjin/img/button/btn_interfacetoap.gif" width="118" height="20" border="0" name="btn_interfacetoap"></td>
										    <td><img class="cursor" src="/hanjin/img/button/btn_cancel.gif" 	width="65" height="19" border="0" name="btn_cancel"></td>
											<td><img class="cursor" src="/hanjin/img/button/btn_downexcel.gif" width="84" height="20" border="0" name="btn_downexcel"></td>
											<td><img class="cursor" src="/hanjin/img/button/btn_print.gif"     width="66" height="20" border="0" name="btn_print"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- TABLE '#D' : ( Button : Main ) (E) -->

						<!-- TABLE '#D' : ( Search Options ) (S) -->
						<table class="search">
							<tr>
								<td class="bg_a">
									<table class="search_in" border="0">
										<tr class="h23">
											<td width="6%"><img class="star">Office</td>
											<td width="15%"><%= cbOfcCd %></td>
											<td width="8%">I/F Option</td>
											<td width="20%">
												<select style="width:110;" name="ifOpt" onchange="ifOpt_OnChange(this)">
													<option value="BF" selected>Before</option>
													<option value="NC">Not Condition</option>
													<option value="IF">Interfaced</option>
												</select>
											</td>
											<td width="8%">I/F Count</td>
											<td>
												<SELECT name="ifCnt" onChange="ifCnt_OnChange()">
													<OPTION value="SEL" selected>사용자선택건</OPTION>
													<OPTION value="100">100건</OPTION>
													<OPTION value="300">300건</OPTION>
													<OPTION value="500">500건</OPTION>
												</SELECT>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table class="height_10"><tr><td></td></tr></table>
						<!-- TABLE '#D' : ( Search Options ) (E) -->

						<!-- TABLE '#D' : ( Search Options ) (S) -->
						<table class="search">
							<tr>
								<td class="bg_a">

									<!-- : ( FAC AP Interface ) (S) -->
									<!-- : ( grid ) (S) -->
									<table width="100%" class="search">
										<tr>
											<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Master</td>
										</tr>
									</table>
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject('sheet1');</script></td>
										</tr>
									</table>
									<table width="100%" class="search">
										<tr>
											<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Detail</td>
										</tr>
									</table>
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject('sheet2');</script></td>
										</tr>
									</table>
									<!-- : ( grid ) (E) -->
									<!-- : ( FAC AP Interface ) (E) -->
								</td>
							</tr>
						</table>
						<!-- TABLE '#D' : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>

</html>
<!-- PRINT (S)tart -->
<DIV style="display:none">
<!-- : ( Grid : AP_INV_HDR ) (S) -->
<table width="100%" id="mainTable">
	<tr>
		<td><script language="javascript">ComSheetObject('sheet3');</script></td>
	</tr>
</table>
<!-- : ( Grid : AP_INV_HDR ) (E) -->

<!-- : ( Grid : AP_INV_DTRB ) (S) -->
<table width="100%" id="mainTable">
	<tr>
		<td><script language="javascript">ComSheetObject('sheet4');</script></td>
	</tr>
</table>
<!-- : ( Grid : AP_INV_DTRB ) (E) -->
</DIV>
<!-- PRINT (E)nd -->




