<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_0011.jsp
*@FileTitle : Agent Commission Detail & History for B/L
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.Utils" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil" %>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0011Event"%>

<%
	EsmAgt0011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//error from server
	DBRowSet rowSet1 = null;						//DB ResultSet
	DBRowSet rowSet2 = null;						//DB ResultSet
	DBRowSet rowSet3 = null;						//DB ResultSet
	DBRowSet rowSet4 = null;						//DB ResultSet
	String strErrMsg = "";							//error message
	int rowCount	 = 0;							//count of DB resultSET list
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	//String userId = "";
	String blNo  = "";
	String bkgNo = "";
	String agnCd = "";
	String ioBnd = "";
	String seq   = "";
	String arOfc = "";
	String sailArrDt = "";

	try {
		//SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	//userId = account.getUsr_id();

	   	event = (EsmAgt0011Event)request.getAttribute("Event");
	   	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
//			if (eventResponse != null) {
//				rowSet1 = eventResponse.getRs1();
//				rowSet2 = eventResponse.getRs2();
//				rowSet3 = eventResponse.getRs3();
//				rowSet4 = eventResponse.getRs4();
//				if(rowSet1 != null){
//					 rowCount = rowSet1.getRowCount();
//				} // end if
//			} // end if

			//Receiving parameters from ESM_AGT_0010 
			blNo  = JSPUtil.getParameter(request, "bl_no");
			bkgNo = JSPUtil.getParameter(request, "bkg_no");
			agnCd = JSPUtil.getParameter(request, "agn_cd");
			ioBnd = JSPUtil.getParameter(request, "io_bnd_cd");
			seq   = JSPUtil.getParameter(request, "ac_seq");
			arOfc = JSPUtil.getParameter(request, "ar_ofc_cd");
			sailArrDt = JSPUtil.getParameter(request, "sail_arr_dt");
		} // end else

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Agent Commission Detail &amp; History for B/L</title>
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

<input type="hidden" name="bl_no"  			value="<%=blNo%>">	<!-- Receiving parameters from ESM_AGT_0010 : B/L No -->
<input type="hidden" name="bkg_no" 			value="<%=bkgNo%>">	<!-- : Booking Number -->
<input type="hidden" name="agn_cd" 			value="<%=agnCd%>">	<!-- : Agent Code -->
<input type="hidden" name="io_bnd_cd" 		value="<%=ioBnd%>">	<!-- : I/O Bound -->
<input type="hidden" name="ac_seq"   		value="<%=seq%>"> 	<!-- : Seq -->
<input type="hidden" name="ar_ofc_cd" 		value="<%=arOfc%>">	<!-- : A/R Office Code -->
<input type="hidden" name="sail_arr_dt" 	value="<%=sailArrDt%>">	<!-- : Sail Arrive Date -->

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="/opuscntr/img/icon_title_dot.gif" align="absmiddle">&nbsp; Detail &amp; History for B/L</td>
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
			<table class="height_10"><tr><td></td></tr></table>
			<!-- Grid BG (S) -->
		 	<table class="search">
	   			<tr>
	   				<td class="bg">
						<!-- Grid Table (S) -->
						<table class="search" border="0">
							<tr class="h23">
								<td width="363" valign="top">
									<!-- : ( Calculation History ) (S) -->
									<table class="search">
										<tr>
											<td class="gray_tit"><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">&nbsp;Calculation History</td>
										</tr>
										<tr><td height="5"></td></tr>
									</table>
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject('sheet1');</script></td>
										</tr>
									</table>
									<!-- : ( Calculation History ) (E) -->
									<table class="height_10"><tr><td></td></tr></table>
									<!-- : ( Commission Detail Amount ) (S) -->
									<table class="search">
										<tr>
											<td class="gray_tit"><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">&nbsp;Commission Detail Amount</td>
										</tr>
										<tr><td height="5"></td></tr>
									</table>
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject('sheet2');</script></td>
										</tr>
									</table>
									<!-- : ( Commission Detail Amount ) (E) -->
								</td>
								<td width="20"></td>
								<td valign="top">
									<!-- : ( Basic Information ) (S) -->
									<table class="search">
										<tr>
											<td class="gray_tit"><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">&nbsp;Basic Information</td>
										</tr>
										<tr><td height="5"></td></tr>
									</table>
									<table border="0" style="width:100%; " class="grid2">
										<tr align="center">
											<td width="22%" class="tr2_head">B/L No.</td>
											<td width="28%"><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="bl_no_text"></td>
											<td width="22%" class="tr2_head">POR</td>
											<td width="28%"><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="por"></td>
										</tr>
										<tr align="center">
											<td class="tr2_head">BKG No.</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="bkg_no_text"></td>
											<td class="tr2_head">POL</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="pol"></td>
										</tr>
										<tr align="center">
											<td class="tr2_head">Vendor</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="vendor"></td>
											<td class="tr2_head">PRE</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="pre"></td>
										</tr>
										<tr align="center">
											<td class="tr2_head">Agreement</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="agmt_no"></td>
											<td class="tr2_head">POST</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="post"></td>
										</tr>
										<tr align="center">
											<td class="tr2_head">Office</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="agn_cd_text"></td>
											<td class="tr2_head">POD</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="pod"></td>
										</tr>
										<tr align="center">
											<td class="tr2_head">Trunk VVD</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="trk_vvd"></td>
											<td class="tr2_head">DEL</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="del"></td>
										</tr>
										<tr align="center">
											<td class="tr2_head">Trunk Lane</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="trk_slane"></td>
											<td class="tr2_head">Gross Rev.</td>
											<td><input class="trans" type="text" style="width:95;text-align:right" readOnly="true" name="gross"></td>
										</tr>
										<tr align="center">
											<td class="tr2_head">Feeder VVD</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="fdr_vvd"></td>
											<td class="tr2_head">PPD OFT</td>
											<td><input class="trans" type="text" style="width:95;text-align:right" readOnly="true" name="oft_ppd"></td>
										</tr>
										<tr align="center">
											<td class="tr2_head">S/C No.</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="sc_no"></td>
											<td class="tr2_head">CCT OFT</td>
											<td><input class="trans" type="text" style="width:95;text-align:right" readOnly="true" name="oft_cct"></td>
										</tr>
										<tr align="center">
											<td class="tr2_head">RFA No.</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="rfa_no"></td>
											<td class="tr2_head">PPD Charge</td>
											<td><input class="trans" type="text" style="width:95;text-align:right" readOnly="true" name="charge_ppd"></td>
										</tr>
										<tr align="center">
											<td class="tr2_head">SVC SCP</td>
											<td><input class="trans" type="text" style="width:95;text-align:center" readOnly="true" name="svc_scp"></td>
											<td class="tr2_head">CCT Charge</td>
											<td><input class="trans" type="text" style="width:95;text-align:right" readOnly="true" name="charge_cct"></td>
										</tr>
									</table>
									<!-- : ( Basic Information ) (E) -->
									<table height="14"><tr><td></td></tr></table>
									<!-- : ( TP/SZ QTY) (S) -->
									<table class="search">
										<tr>
											<td class="gray_tit"><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">&nbsp;TP/SZ QTY</td>
										</tr>
										<tr><td height="5"></td></tr>
									</table>
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject('sheet3');</script></td>
										</tr>
									</table>
									<!-- : ( TP/SZ QTY ) (E) -->
								</td>
							</tr>
						</table>
						<!-- Grid Table (S) -->
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
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_deductiondetail" id="btn_deductiondetail">Deduction Detail</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close" id="btn_close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
<div id="div1" STYLE="LEFT:300;TOP:240;visibility: hidden;">
<script language="javascript">ComSheetObject('sheet4');</script>
</div>
</form>
</body>
</html>
