﻿<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_039.jsp
*@FileTitle : Agent Commission Maintenance & Approval
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
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.Utils"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0039Event"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmAgt0039Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	DBRowSet rowSet = null; //DB ResultSet
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String userId = "";
	String ofcCd = "";
	String arOfcCd = "";
	String ar_ofc_cd = "";
	String agn_cd = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		ofcCd = account.getOfc_cd();

		event = (EsmAgt0039Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}

	//Retrieving A/R Office Code of Login User's division.
	arOfcCd = CodeUtil.getInstance().getCodeInfo("arOfcCd", ofcCd);

	//Combo Data : getCodeCombo('Tag Name','Init Value', 'Additional Properties', 'Biz name', 'Condition Code', 'Whole check', 'Additional Option')
	ar_ofc_cd = ComboUtil
			.getCodeCombo(
					"ar_ofc_cd",
					arOfcCd,
					" onChange='ar_ofc_cd_OnChange(this);' style='width:85', class='input1'",
					"arOfcCd", ofcCd, "&lt;&lt;select&gt;&gt;", "");
	//agn_cd = ComboUtil.getCodeCombo("agn_cd", ofcCd, " style='width:100'", "sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
	agn_cd = ComboUtil
			.getCodeCombo(
					"agn_cd",
					arOfcCd,
					" onChange='agn_cd_OnChange(this);' style='width:100', class='input1'",
					"sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
%>
<html>
<head>
<title>Agent Commission Request</title>
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

<script language="vbscript">
<!--
Dim dataArr()
Function CreateVBArray(rows,cols,skipStr)
'MsgBox(rows & "," & cols)
	ReDim dataArr(rows,cols)
	  For vbI = 0 To rows
		For vbJ = 0 To cols
		  dataArr(vbI, vbJ) = skipStr
		Next
	  Next
End Function

Function SetVBValue(row,col,value)
'MsgBox(row & "," & col & "," & value)
	dataArr(row,col) = value
End Function

Function GetVBValue(row,col)
'MsgBox(row & "," & col & "," & value)
	GetVBValue=dataArr(row,col)
End Function

Function GetVBArray()
	GetVBArray=dataArr
End Function
-->
</script>

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;"><input type="hidden" name="f_cmd"> <input type="hidden" name="iPage"> <input type="hidden" name="param1"><!-- ComboUtil에서 사용하는 codeItem --> <input type="hidden" name="param2"><!-- All Display 유무(Y, N, [All]) --> <input type="hidden" name="param3"><!-- Object Name --> <input type="hidden" name="param4"><!-- arOfcCd Code --> <input type="hidden" name="param5"><!-- BL No --> <!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td><!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) --> <!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom: 5;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td class="btn1_line"></td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_showdetail">Detail</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_reject">Reject</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_audit">Audit</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_cancel">Cancel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel">Down Excel</td>
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
		<!-- TABLE '#D' : ( Button : Main ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="5%">Office</td>
						<td width="14%"><%=ar_ofc_cd%></td>
						<td width="8%">Sub Office</td>
						<td width="15%">
						<div id="div_sbOfcCd"><%=agn_cd%></div>
						</td>
						<td width="5%">Status</td>
						<td width="27%"><select style="width: 105;" name="sts_cd" onchange="sts_cd_OnChange(this)">
							<option value="1" selected>Requested</option>
							<!-- RS,RM -->
							<option value="2">Audited</option>
							<!-- AS -->
							<option value="3">Approved</option>
							<!-- IF -->
							<option value="4">S/A</option>
							<!-- RS,RM -->
							<option value="5">Old</option>
							<!-- RS,RM -->
						</select></td>
						<td width="3%">Date</td>
						<td align="right"><input type="text" name="search_dt_fr" style="width: 75; ime-mode: disabled" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;<img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_fr"> ~ <input type="text" name="search_dt_to" style="width: 75; ime-mode: disabled;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;<img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_to"></td>
					</tr>
					<tr class="h23">
						<td colspan="1">VVD</td>
						<td colspan="1"><input type="text" name="vvd" style="width: 85; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="10"></td>
						<td colspan="1">B/L No.</td>
						<td colspan="5"><input type="text" name="bl" style="width: 100; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum');setBlNo(this);" maxlength="12"><img src="" width="2" height="1" border="0"><input type="text" name="bl_nos" style="width: 279; ime-mode: disabled;" onkeypress="setBlNos(this);" onKeyUp="setBlNos(this);"></td>
					</tr>

					<table class="search_in" border="0" cellpadding="0" cellspacing="0">
						<tr class="h23">

							<td width="235" class="stm"><strong>Check Option&nbsp;:</strong>&nbsp;start&nbsp;<input type="text" name="chkStart" style="width: 30; ime-mode: disabled;" onKeyPress="ComKeyOnlyNumber(this)" maxlength="5">&nbsp;-&nbsp;end&nbsp;<input type="text" name="chkEnd" style="width: 30; ime-mode: disabled;" onKeyPress="ComKeyOnlyNumber(this)" maxlength="5"></td>
							<td width="90">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="check_apply">Apply</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
									</td>
								</tr>
							</table>
							</td>
							<td width="93"></td>
							<td width="245" class="stm"><strong>Uncheck Option&nbsp;:</strong>&nbsp;start&nbsp;<input type="text" name="unchkStart" style="width: 30; ime-mode: disabled;" onKeyPress="ComKeyOnlyNumber(this)" maxlength="5">&nbsp;-&nbsp;end&nbsp;<input type="text" name="unchkEnd" style="width: 30; ime-mode: disabled;" onKeyPress="ComKeyOnlyNumber(this)" maxlength="5"></td>

							<td width="80">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="uncheck_apply">Apply</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
									</td>
								</tr>
							</table>
							</td>
							<td width="250"></td>

							</td>
						</tr>
					</table>
					</tr>
				</table>
				<table class="height_10">
					<tr>
						<td></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg_a"><!-- : ( Agent Commission Request ) (S) --> <!-- : ( grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( grid ) (E) --> <!-- : ( Agent Commission Request ) (E) --> <!-- <textarea name="sXml" cols="150" rows="10" ></textarea> --></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) --></td>
			</tr>
		</table>
		<!-- Outer Table (E)-->


		</form>
</body>

</html>

