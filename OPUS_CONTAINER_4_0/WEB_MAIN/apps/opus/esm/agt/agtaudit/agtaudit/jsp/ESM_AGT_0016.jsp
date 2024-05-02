<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_016.jsp
*@FileTitle : Other Commission Approval
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
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.Utils" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil" %>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0016Event"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmAgt0016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
//	ESM_AGT_016EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//error from server
//	DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//error message
	int rowCount	 = 0;							//count of DB resultSET list

	 
	String ofcCd = "";
	String arOfcCd = "";
	String cbArOfcCd = "";
	String cbSbOfcCd = "";
	String successFlag = "";
	
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.AGTAudit.AGTAudit");
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofcCd = account.getOfc_cd();

	   	event = (EsmAgt0016Event)request.getAttribute("Event");
	   	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} 
		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}

	//Retrieving A/R Office Code of Login User's division.
	arOfcCd = CodeUtil.getInstance().getCodeInfo("arOfcCd", ofcCd);
	
	//Combo Data : getCodeCombo('Tag Name','Init Value', 'Additional Properties', 'Biz name', 'Condition Code', 'Whole check', 'Additional Option') 
//	cbArOfcCd = ComboUtil.getCodeCombo("cbArOfcCd", arOfcCd, " onChange='cbArOfcCd_OnChange(this);' style='width:85'", "arOfcCd", ofcCd, "&lt;&lt;select&gt;&gt;", "");
	cbArOfcCd = ComboUtil.getCodeCombo("ar_ofc_cd", arOfcCd, " onChange='cbArOfcCd_OnChange(this);' style='width:85', class='input1'", "arOfcCd", ofcCd, "&lt;&lt;select&gt;&gt;", "");
//	cbSbOfcCd = ComboUtil.getCodeCombo("cbSbOfcCd", arOfcCd, " onChange='cbSbOfcCd_OnChange(this);' style='width:85'", "sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
	cbSbOfcCd = ComboUtil.getCodeCombo("s_agn_cd", arOfcCd, " onChange='cbSbOfcCd_OnChange(this);' style='width:85', class='input1'", "sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
%>
<html>
<head>
<title>Other Commission Approval</title>
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
<input type="hidden" name="param1"> <!-- Optional A/R Office -->
<input type="hidden" name="param2"> <!-- Insert Apply Date -->
<input type="hidden" name="param3">	<!-- Grid Vendor -->
<input type="hidden" name="param4">	<!-- Grid Name -->
<input type="hidden" name="param5">	<!-- Grid Office -->
<input type="hidden" name="param6"> <!-- Grid City -->
<input type="hidden" name="param7"> <!-- Grid Center -->
<input type="hidden" name="param8"> <!-- Grid Curr -->
<input type="hidden" name="param9"> <!-- Grid xchRt -->



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
                                                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn1_left"></td>
                                                                                <td class="btn1" name="btn_retrieve">Retrieve</td>
                                                                                <td class="btn1_right"></td>
                                                                                </tr>
                                                                        </table></td>
                                                                        <td class="btn1_line"></td>
                                                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn1_left"></td>
                                                                                <td class="btn1" name="btn_save">Save</td>
                                                                                <td class="btn1_right"></td>
                                                                                </tr>
                                                                        </table></td>
                                                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn1_left"></td>
                                                                                <td class="btn1" name="btn_reject">Reject</td>
                                                                                <td class="btn1_right"></td>
                                                                                </tr>
                                                                        </table></td>
                                                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn1_left"></td>
                                                                                <td class="btn1" name="btn_audit">Audit</td>
                                                                                <td class="btn1_right"></td>
                                                                                </tr>
                                                                        </table></td>
                                                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn1_left"></td>
                                                                                <td class="btn1" name="btn_cancel">Cancel</td>
                                                                                <td class="btn1_right"></td>
                                                                                </tr>
                                                                        </table></td>
                                                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn1_left"></td>
                                                                                <td class="btn1" name="btn_downexcel">Down Excel</td>
                                                                                <td class="btn1_right"></td>
                                                                                </tr>
                                                                        </table></td>
                                                                </tr>
                                                                </table>
                                                </td></tr>
                                               </table>
						<!-- TABLE '#D' : ( Button : Main ) (E) -->

						<!-- TABLE '#D' : ( Search Options ) (S) -->
						<table class="search">
							<tr>
								<td class="bg">
									<table class="search_in" border="0">
										<tr class="h23">
											<td width="4%">Office</td>
											<td width="14%"><%= cbArOfcCd %></td>
											<td width="7%">Sub Office</td>
											<td width="13%"><div id="div_sbOfcCd"><%= cbSbOfcCd %></div></td>
											<td width="5%">Status</td>
											<td width="14%">
												<select style="width:90;" name="sts_cd">
													<option value="0" selected>All</option>	<!-- RS,RM,AS,IF -->
													<option value="1">Requested</option>	<!-- RS,RM -->
													<option value="2">Audited</option>				<!-- AS -->
													<option value="3">Approved</option>				<!-- IF -->
												</select>
											</td>
											<td width="7%">Exp. Type</td>
											<td width="14%">
												<SELECT name="exp_type"  style="width:80" onChange="expType_OnChange(this);">
													<OPTION value="G" selected>General</OPTION>
													<OPTION value="E">Exception</OPTION>
												</SELECT>
											</td>
											<td width="10%">Subject Month</td>
											<td width="6%"><input type="text" class="input1" style="width:55" maxlength="7" dataformat="ym"  OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" value="" name="comm_yrmon"></td>
											<td class="sm" align="right">(YYYY-MM)</td>
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
								<td class="bg">

									<!-- : ( Other Commission Approval ) (S) -->
									<table class="height_5"><tr><td></td></tr></table>

									<!-- : ( grid ) (S) -->
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject('sheet1');</script></td>
										</tr>
									</table>
									<!-- : ( grid ) (E) -->
									<!-- : ( Other Commission Approval ) (E) -->

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

