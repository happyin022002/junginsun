<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0004.jsp
*@FileTitle : C/H Auditing - TRO vs. AR Rev
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil" %>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0004Event" %>



<%
	SignOnUserAccount account = null; //Session 
	EsdEas0004Event  event = null; //
	Exception serverException   = null; //error from server
	DBRowSet rowSet	  = null; //DB ResultSet
	String strErrMsg = ""; //error message
	int rowCount	 = 0; //count of DB resultSET list

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdEas0004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>C/H Auditing - TRO vs. AR Rev</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">
    function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}

		loadPage();

       /*****************************************************************/
    }
</script>


<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="old_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="sel_ofc_cd" value="HAM">

<input type="hidden" name="somonth" value="YYYYMM">
<input type="hidden" name="invmonth" value="YYYYMM">
<input type="hidden" name="d_type">

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
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

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
	       	<tr>
	       		<td class="bg">
						<!-- : ( Week ) (S) -->
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="80"><%//<img class="nostar">%>TRO Office</td>
									<td width="270">
										<input name="ctrl_ofc_cd" type="text" style="width:67;" value="<%=account.getOfc_cd()%>" onChange="javascript:fun_officeText();" onKeyUp="chkField(this, 'eng', true, 13)" maxlength="50" >
										<img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="19" border="0" align="absmiddle" name="btns_office" >
										<input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC
									</td>
									<td width="95"><input type="radio" name="search_choice" value="SODAT" class="trans" onClick="selectWhere();" >&nbsp;&nbsp;TRO Date</td>
									<td width="240" class="stm"><input type="text" style="width:70" name="fromsodate" value="YYYYMMDD" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8); " maxlength="8" >&nbsp;~&nbsp;<input type="text" style="width:70" name="tosodate" value="YYYYMMDD" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8);" maxlength="8" ></td>
									<td width="90"></td>
									<td width="203" class="stm"></td>
								</tr>
							</table>
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="80"><%//<img class="nostar">%>Type</td>
									<td width="270">
										<select style="width:90;" name="s_type">
										<option value="A" selected>All</option>
										<option value="U">UnMatch</option>
										<option value="M">Match</option>
										</select>
									</td>
									<td width="95"><input type="radio" name="search_choice" value="BKGNO" class="trans" onClick="selectWhere();" >&nbsp;&nbsp;BKG NO.</td>
									<td width="240" class="stm"><input type="text" style="width:95" name="bkgno" value="" onClick="selectText(this);" onKeyUp="chkField(this, 'eng_num', true, 13)" maxlength="13" ></td>
									<td width="90"><input type="radio" name="search_choice" value="VVDNO" class="trans" onClick="selectWhere();" >&nbsp;&nbsp;V.V.D</td>
									<td width=""><input type="text" style="width:85" name="vvdno" value="" onClick="selectText(this);" onKeyUp="chkField(this, 'eng_num', true, 9)"  maxlength="9" ></td>
								</tr>
							</table>
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="80"><%//<img class="nostar">%>Bound</td>
									<td width="270">
										<select style="width:90;" name="s_bnd" >
										<option value="A" selected>All</option>
										<option value="I">In</option>
										<option value="O">Out</option>
										</select>
									</td>
									<td width="95"><input type="radio" name="search_choice" value="BLNO" class="trans" onClick="selectWhere();" >&nbsp;&nbsp;B/L NO.</td>
									<td width=""><input type="text" style="width:95" name="blno" value="" onClick="selectText(this);" onKeyUp="chkField(this, 'eng_num', true, 12)" maxlength="12" ></td>
								</tr>
							</table>
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="135"><%//<img class="nostar">%>Detailed C/H Type.</td>
									<td>
										<DIV id="ScriptDiv" >
											<select style="width:210;" name="s_dtltype" >&nbsp;
												<OPTION value="OI-0" selected >No Select</OPTION>
												<OPTION value="OI-1" >1.Canceled BKG</OPTION>
												<OPTION value="OI-6" >2.Frustrated Haul</OPTION>
												<OPTION value="OI-2" >3.Port CY ===> Door</OPTION>
												<OPTION value="OI-3" >4.Port Door ===> Inland</OPTION>
												<OPTION value="OI-4" >5.Different Inland Door</OPTION>
												<OPTION value="OI-5" >6.All[O/I-1,2,3,4,5]</OPTION>
											</select>
										</DIV>
									</td>
								</tr>
							</table>
						<!-- : ( Week ) (E) -->
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->


			<table class="height_10"><tr><td></td></tr></table>
	     	<table class="search" border="0">
	       	<tr>
	       		<td class="bg">

					<table width="100%" id="mainTable">
					<tr>
						<td>
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
					</table>
				</td>
			</tr>
			</table>
    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
