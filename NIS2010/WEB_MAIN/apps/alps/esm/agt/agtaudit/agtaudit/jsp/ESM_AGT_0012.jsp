<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_012.jsp
*@FileTitle : Agent Commission Deduction Details for B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-14
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2006-12-14 Junghyung_kim
* 1.0 최초 생성
*2009-09-21 : Ho-Jin Lee : Alps 전환
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.Utils" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.event.EsmAgt0012Event"%>
<%
	EsmAgt0012Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	DBRowSet rowSet1 = null;						//DB ResultSet
	DBRowSet rowSet2 = null;						//DB ResultSet
	DBRowSet rowSet3 = null;						//DB ResultSet
	DBRowSet rowSet4 = null;						//DB ResultSetgrsnetOcnRev
	String strErrMsg = "";							//에러메세지
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String userId = "";
	String blNo  = "";
	String bkgNo = "";
	String agnCd = "";
	String ioBnd = "";
	String seq   = "";
	String arOfc = "";
	String saDt = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId = account.getUsr_id();

	   	event = (EsmAgt0012Event)request.getAttribute("Event");
	   	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
/*			
			if (eventResponse != null) {
				rowSet1 = eventResponse.getRs1();
				rowSet2 = eventResponse.getRs2();
				rowSet3 = eventResponse.getRs3();
				rowSet4 = eventResponse.getRs4();
				if(rowSet1 != null){
					 rowCount = rowSet1.getRowCount();
				} // end if
			} // end if
*/
			//ESM_AGT_010 화면에서 넘어온 파라미터를 받는다.
			blNo  = JSPUtil.getParameter(request, "blNo");
			bkgNo = JSPUtil.getParameter(request, "bkgNo");
			agnCd = JSPUtil.getParameter(request, "agnCd");
			ioBnd = JSPUtil.getParameter(request, "ioBnd");
			seq   = JSPUtil.getParameter(request, "seq");
			arOfc = JSPUtil.getParameter(request, "arOfc");
			saDt = JSPUtil.getParameter(request, "saDt");
		} // end else

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Agent Commission Detail & History for B/L</title>
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
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<input type="hidden" name="bl_no"  value="<%=blNo%>">	<!-- ESM_AGT_011 화면에서 넘어온 파라미터 : B/L No -->
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">	<!-- : Booking Number -->
<input type="hidden" name="agn_cd" value="<%=agnCd%>">	<!-- : Agent Code -->
<input type="hidden" name="io_bnd_cd" value="<%=ioBnd%>">	<!-- : I/O Bound -->
<input type="hidden" name="ac_seq"   value="<%=seq%>"> 	<!-- : Seq -->
<input type="hidden" name="ar_ofc_cd" value="<%=arOfc%>">	<!-- : A/R Office Code -->
<input type="hidden" name="sail_arr_dt" value="<%=saDt%>">	<!-- : A/R Office Code -->
<!-- OUTER - POPUP (S)tart -->
<table width="1000" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Deduction Details for B/L</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- Search BG (S) -->
		 	<table class="search">
			   	<tr>
			   		<td class="bg">
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">B/L No.</td>
								<td width="250"><input type="text" style="width:120;" class="input2" readOnly="true" value="<%= blNo %>"></td>
								<td width="60">BKG No.</td>
								<td><input type="text" style="width:120;" class="input2" readOnly="true" value="<%= bkgNo %>"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- Search BG (E) -->
			<table class="height_10">
				<tr><td></td></tr>
			</table>
			<!-- Grid BG (S) -->
	 		<table class="search">
	   			<tr>
	   				<td class="bg">
						<!-- Grid Table (S) -->
						<table class="search" border="0">
							<tr>
								<td width="600" valign="top">
									<!-- : ( Rating ) (S) -->
									<table class="search">
										<tr>
											<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">&nbsp;Rating</td>
										</tr>
										<tr><td height="5"></td></tr>
									</table>
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject('sheet1');</script></td>
										</tr>
									</table>
									<!-- : ( Rating ) (E) -->
									<table class="height_10"><tr><td></td></tr></table>
									<!-- : ( Total ) (S) -->
									<table class="search">
										<tr>
											<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">&nbsp;Total</td>
										</tr>
										<tr><td height="5"></td></tr>
									</table>
									<table border="0" class="search">
										<tr>
											<td width="292" valign="top">
												<!-- : ( Total Grid 1 ) (S) -->
												<table width="100%" id="mainTable">
								  					<tr>
								  						<td><script language="javascript">ComSheetObject('sheet2');</script></td>
								  					</tr>
												</table>
												<!-- : ( Total Grid 1 ) (E) -->
											</td>
											<td width="15"></td>
											<td width="293" valign="top">
												<!-- : ( Total Grid 2 ) (S) -->
												<table width="100%" id="mainTable">
								  					<tr>
								  						<td><script language="javascript">ComSheetObject('sheet3');</script></td>
								  					</tr>
												</table>
												<!-- : ( Total Grid 2 ) (E) -->
											</td>
										</tr>
									</table>
									<!-- : ( Total ) (E) -->
								</td>
								<td width="15"></td>
								<td valign="top">
									<!-- : ( Deducted Chrage ) (S) -->
									<table class="search">
										<tr>
											<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">&nbsp;Deducted Charge</td>
										</tr>
										<tr><td height="5"></td></tr>
									</table>
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject('sheet4');</script></td>
										</tr>
									</table>
									<!-- : ( Deducted Chrage ) (E) -->
									<table class="height_10"><tr><td></td></tr></table>
									<!-- : ( Deducted Transportation Cost ) (S) -->
									<table class="search">
										<tr>
											<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">&nbsp;Deducted Transportation Cost</td>
										</tr>
										<tr><td height="5"></td></tr>
									</table>
									<table width="100%" id="mainTable" >
										<tr>
											<td><script language="javascript">ComSheetObject('sheet5');</script></td>
										</tr>
									</table>
									<!-- : ( Deducted Transportation Cost ) (E) -->
									<!-- Gross/Net Hidden -->
									<table style="hidden;" id="mainTable" >
										<tr>
											<td><script language="javascript">ComSheetObject('sheet6');</script></td>
										</tr>
									</table>
									<!-- Gross/Net Hidden -->
								</td>
							</tr>
						</table>
						<!-- Grid Table (S) -->
						<table class="search">
							<tr><td class="line_bluedot"></td></tr>
						</table>
						<table border="0" align="right">
							<tr class="h23">
								<td width="75">Gross&nbsp;/&nbsp;Net</td>
								<td width="80"><input type="text" class="input2" style="width:35;text-align:right" readOnly="true" name="grsnetcd"></td>
								<td width="125">Net Ocean Revenue</td>
								<td><input type="text" class="input2" style="width:75;text-align:right" readOnly="true" name="grsnetOcnRev"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- Grid BG (S) -->
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- : ( Button : pop ) (E) -->
		</td>
	</tr>
</table>
</form>
</body>
</html>
