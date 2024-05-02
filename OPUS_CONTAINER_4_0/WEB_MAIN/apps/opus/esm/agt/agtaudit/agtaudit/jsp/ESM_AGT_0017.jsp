<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_017.jsp
*@FileTitle : Agent Commission AP Interface
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
<%@ page import="com.clt.apps.opus.esm.agt.common.Utils"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0017Event"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
EsmAgt0017Event event = null; //PDTO(Data Transfer Object including Parameters)
Exception serverException = null; //error from server
DBRowSet rowSet = null; //DB ResultSet
String strErrMsg = ""; //error message
int rowCount = 0; //count of DB resultSET list

	String ofcCd = "";
	String arOfcCd = "";
	String offsetFlag = "";
	String ar_ofc_cd = "";
	String agn_cd = "";
	String asa_no = "";
	String vendor = "";
	String aproStep = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		ofcCd = account.getOfc_cd();

		event = (EsmAgt0017Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}

	//Retrieving A/R Office Code of Login User's division.
	arOfcCd = CodeUtil.getInstance().getCodeInfo("arOfcCd", ofcCd);
	offsetFlag = CodeUtil.getInstance().getOffsetFlag(arOfcCd);

	//Combo Data : getCodeCombo('Tag Name','Init Value', 'Additional Properties', 'Biz name', 'Condition Code', 'Whole check', 'Additional Option')
	ar_ofc_cd = ComboUtil.getCodeCombo("ar_ofc_cd", arOfcCd, " onChange='ar_ofc_cd_OnChange(this);' style='width:85', class='input1'", "arOfcCd", ofcCd, "&lt;&lt;select&gt;&gt;", "");
	//agn_cd = ComboUtil.getCodeCombo("agn_cd", ofcCd, " style='width:100'", "sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
	agn_cd = ComboUtil.getCodeCombo("agn_cd",arOfcCd," onChange='agn_cd_OnChange(this);' style='width:100', class='input1'", "sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
	asa_no		= ComboUtil.getCodeCombo("cbAsaNo",		"",			" onChange='asa_no_OnChange();' style='width:400'", "asaNo", "", "", "");

	//aproStep =  com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(ofcCd,"AGT");
	String cost_ofc_cd = "";
	String inv_sub_sys_cd = "";
	cost_ofc_cd 		= JSPUtil.getParameter(request, "cost_ofc_cd 			".trim(), "");	
	inv_sub_sys_cd		= JSPUtil.getParameter(request, "inv_sub_sys_cd			".trim(), "");
%>

<html>
<head>
<title>Agent Commission AP Actual Interface</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
RdReport = "/opuscntr/apps/opus/esm/agt/common/jsp/ESM_AGT_RDReport.jsp" ; 
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
<input type="hidden" name="param1"> <!-- codeItem used in ComboUtil -->
<input type="hidden" name="param2"> <!-- All Display (Y, N, [All]) -->
<input type="hidden" name="param3"> <!-- Object Name -->
<input type="hidden" name="param4"> <!-- arOfcCd Code -->
<input type="hidden" name="param5"> <!-- search flag -->
<input type="hidden" name="param6"> <!-- Detail Grid Retrieve Approval No -->
<input type="hidden" name="comm_apro_no">
<input type="hidden" name="offsetFlag" value="<%= offsetFlag %>">	<!-- Optional A/R Office -->
<input type="hidden" name="h_csrNo"> <!-- grid Optional csrNo -->
<input type="hidden" name="ofcCd" value="<%= ofcCd %>"> <!-- Login User Office-->
<input type="hidden" name="aproStep" value="<%= aproStep %>"> <!-- Login Approval user  -->
<input type="hidden" name="aproSeqKey" value="<%//=com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(cost_ofc_cd, inv_sub_sys_cd) %>">
<input type="hidden" name="exp_type" value="G">

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
                                                                                <tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

                                                                        <td class="btn1_line"></td>

                                                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn1_left"></td><td class="btn1" name="btn_request">Approval</td><td class="btn1_right"></td></tr></table></td>
                                                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn1_left"></td><td class="btn1" name="btn_cancel">Cancel</td><td class="btn1_right"></td></tr></table></td>

                                                                        <td class="btn1_line"></td>

                                                                        <!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn1_left"></td><td class="btn1" name="btn_print">Print</td><td class="btn1_right"></td></tr></table></td-->
                                                                        <!-- Repeat Pattern -->

                                                                </tr></table>

                                                        </td></tr>
                                                </table>
						<!-- TABLE '#D' : ( Button : Main ) (E) -->

						<!-- TABLE '#D' : ( Search Options ) (S) -->
                                                <table class="search">
                                                        <tr>
                                                                <td class="bg">
                                                                        <table class="search_in" border="0">
                                                                                <tr class="h23">
                                                                                        <td width="7%">Office</td>
                                                                                        <td width="16%"><%= ar_ofc_cd %></td>
                                                                                        <td width="8%">Sub Office</td>
                                                                                        <td width="19%"><div id="div_sbOfcCd"><%= agn_cd %></div></td>
                                                                                        <td width="5%" >Status</td>
                                                                                        <td width="19%">
                                                                                                <SELECT name="if_option"  style="width:80" onChange="if_option_OnChange(this);">
                                                                                                        <OPTION value="AS" selected>Audited</OPTION>
                                                                                                        <OPTION value="IF">Approved</OPTION>
                                                                                                </SELECT>
                                                                                        </td>
                                                                                        <td width="3%" >Date</td>
                                                                                        <td align="right" class="stm">
                                                                                                <input type="text" style="width:75" maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" name="search_dt_fr"><img src="" width="2" height="1" border="0"><img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_fr">&nbsp;~&nbsp;<input type="text" style="width:75" maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" name="search_dt_to"><img src="" width="2" height="1" border="0"><img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_to">
                                                                                        </td>
                                                                                </tr>
                                                                                <tr class="h23">
                                                                                        <td colspan="1">EFF Date</td>
                                                                                        <td colspan="1">
                                                                                                <input type="text" class="input1"style="width:85" maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" name="inv_dt"><img src="" width="2" height="1" border="0"><img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_inv_dt">
                                                                                        </td>
                                                                                        <td colspan="1">ASA No.</td>
                                                                                        <td colspan="5"><div id="div_asaNo"><%= asa_no %></div></td>
                                                                                </tr>
                                                                                <tr class="h23">
                                                                                        <td colspan="1">VAT (%)</td>
                                                                                        <td colspan="1"><input type="text" style="width:85;text-align:right" maxlength = "8" name="inv_tax_rt" value="0.00" onfocus="invTaxRt_onfocus(this)" onblur="invTaxRt_validate(this)"></td>
                                                                                        <td colspan="1">Vendor</td>
                                                                                        <td colspan="5"><input type="text" class="input2" style="width:400;" name="txVendor" value="<%= vendor %>" disabled></td>

                                                                                </tr>
                                                                        </table>
                                                                        <!-- table class="search_in" border="0">
                                                                        <tr><td colspan="5"><table class="line_bluedot"><tr><td></td></tr></table></td></tr>
                                                                             <tr class="h23">
                                                                                        <td width="11%">Expiration Type</td>
                                                                                        <td align="left">
                                                                                                <SELECT name="exp_type"  style="width:80" onChange="exp_type_OnChange(this);">
                                                                                                        <OPTION value="G" selected>General</OPTION>
                                                                                                        <OPTION value="E">Exception</OPTION>
                                                                                                </SELECT>
                                                                                        </td>
                                                                                </tr>
                                                                        </table-->
																		<table class="search_in" border="0" cellpadding="0" cellspacing="0">
																			<tr class="h23">
													
																				<td width="230" class="stm"><strong>Check Option&nbsp;:</strong>&nbsp;start&nbsp;<input type="text" name="chkStart" style="width: 30; ime-mode: disabled;" onKeyPress="ComKeyOnlyNumber(this)" maxlength="5">&nbsp;-&nbsp;end&nbsp;<input type="text" name="chkEnd" style="width: 30; ime-mode: disabled;" onKeyPress="ComKeyOnlyNumber(this)" maxlength="5"></td>
																				<td width="83">
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
																				<td width="100"></td>
																				<td width="245" class="stm"><strong>Uncheck Option&nbsp;:</strong>&nbsp;start&nbsp;<input type="text" name="unchkStart" style="width: 30; ime-mode: disabled;" onKeyPress="ComKeyOnlyNumber(this)" maxlength="5">&nbsp;-&nbsp;end&nbsp;<input type="text" name="unchkEnd" style="width: 30; ime-mode: disabled;" onKeyPress="ComKeyOnlyNumber(this)" maxlength="5"></td>
													
																				<td width="83">
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
																				<td width="252"></td>
													
																				</td>
																			</tr>
																		</table>
					</tr>
				</table>
                                                                </td>
                                                        </tr>
                                                </table>
                                            
						<!-- TABLE '#D' : ( Search Options ) (E) -->
						<table class="height_10"><tr><td></td></tr></table>
						<!-- TABLE '#D' : ( Search Options ) (S) -->
						<table class="search">
							<tr>
								<td class="bg">

									<!-- : ( Agent Commission AP Interface ) (S) -->
									<!-- : ( grid ) (S) -->
                                                                        <table width="100%" class="search">
                                                                                <tr>
                                                                                        <td class="gray_tit"><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Master</td>
                                                                                        <td class="btn2_bg" align="right" style="padding-bottom:3;">


                                                                                                <!-- : ( Button : Sub ) (S) -->
                                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                                <tr>
																										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                                        <tr><td class="btn2_left"></td><td class="btn2" name="btng_downexcel1">Down Excel</td><td class="btn2_right"></td></tr></table></td>
                                                                                                        <!-- Repeat Pattern -->


                                                                                                </tr>
                                                                                                </table>
                                                                                                <!-- : ( Button : Sub ) (S) -->


                                                                                        </td>
                                                                                </tr>
                                                                        </table>
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject('sheet1');</script></td>
										</tr>
									</table>
                                                                        <table width="100%" class="search">
                                                                                <tr>
                                                                                        <td class="gray_tit"><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Detail</td>
                                                                                        <td class="btn2_bg" align="right" style="padding-bottom:3;">


                                                                                                <!-- : ( Button : Sub ) (S) -->
                                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                                <tr>

                                                                                                        <!-- Repeat Pattern -->
                                                                                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                                        <tr><td class="btn2_left"></td><td class="btn2" name="btng_downexcel2">Down Excel</td><td class="btn2_right"></td></tr></table></td>
                                                                                                        <!-- Repeat Pattern -->


                                                                                                </tr>
                                                                                                </table>
                                                                                                <!-- : ( Button : Sub ) (S) -->


                                                                                        </td>
                                                                                </tr>
                                                                        </table>
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject('sheet2');</script></td>
										</tr>
									</table>
									<!-- : ( grid ) (E) -->
									<!-- : ( Button : Sub ) (S) -->
									<table width="100%" class="sbutton">
										<tr>
											<td class="align">
												<table class="sbutton">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<!-- : ( Button : Sub ) (E) -->
									<!-- : ( Agent Commission AP Interface ) (E) -->
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



