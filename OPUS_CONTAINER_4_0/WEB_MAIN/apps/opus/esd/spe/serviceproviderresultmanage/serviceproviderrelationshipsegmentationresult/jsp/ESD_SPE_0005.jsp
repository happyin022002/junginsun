<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SPE_0005.jsp
*@FileTitle : SRS Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.event.EsdSpe0005Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.event.EsdSpe0001Event"%>
<%@ page import="com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
	EsdSpe0005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//The count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ServiceProviderResultManage.ServiceProviderRelationshipSegmentationResult");
	
	List<SearchEGIdAllListVO> egidList = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSpe0005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		egidList = eventResponse.getRsVoList() ;

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>SRS Analysis Result</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		<%
		int cnt = egidList.size();
		String[] temp = new String[cnt];
		
		for(int j=0; j<cnt; j++){
			SearchEGIdAllListVO vo = egidList.get(j);
			temp[j] = vo.getEgId();
				
		} 
		%>
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

					<table class="search_in" border="0">
						<tr class="h23">
							<td>EG ID</td>
							<td colspan="2">
								<select name="f_eg_id" style="width:160" caption="EG ID">
								<option value="" selected>&lt;&lt; select &gt;&gt;</option>
									<%					
										for(int j=0; j<cnt; j++){
											SearchEGIdAllListVO vo = egidList.get(j);
											String egId = vo.getEgId();
								
											String sel = null;
											if(j==0){
												sel = "select";
											}else{
												sel = "";
											}
									%>					
										<option value="<%=egId%>" <%=sel%>><%=egId%></option>
									<%}%>	
								</select></td>
								<%
									Calendar cal = Calendar.getInstance();
									java.text.DateFormat df = new SimpleDateFormat("yyyy");
									String nowYear = df.format(cal.getTime());
								%>
							<td>Year</td>
							<td><select name="f_ev_yr" style="width:70" required caption="Year" class="input1">
												<option value="2007" <% if("2007".equals(nowYear)) out.println("selected"); %>>2007</option>
												<option value="2008" <% if("2008".equals(nowYear)) out.println("selected"); %>>2008</option>
												<option value="2009" <% if("2009".equals(nowYear)) out.println("selected"); %>>2009</option>
												<option value="2010" <% if("2010".equals(nowYear)) out.println("selected"); %>>2010</option>
												<option value="2011" <% if("2011".equals(nowYear)) out.println("selected"); %>>2011</option>
												<option value="2012" <% if("2012".equals(nowYear)) out.println("selected"); %>>2012</option>
												<option value="2013" <% if("2013".equals(nowYear)) out.println("selected"); %>>2013</option>
												<option value="2014" <% if("2014".equals(nowYear)) out.println("selected"); %>>2014</option>
												<option value="2015" <% if("2015".equals(nowYear)) out.println("selected"); %>>2015</option>
												<option value="2016" <% if("2016".equals(nowYear)) out.println("selected"); %>>2016</option>
												<option value="2017" <% if("2017".equals(nowYear)) out.println("selected"); %>>2017</option>
								</select></td>

						</tr>
						<tr class="h23">
							<td width="80">EG Choicer</td>
							<td width="53" class="stm" style="padding-left:3;">Level 1</td>
							<td width="177">
								<select name="f_eg_rhq_cd" style="width:104"   caption="Level 1">
												<option value="" selected>&lt;&lt; select &gt;&gt;</option>
												<option value="NYC">NYC</option>
												<option value="HAM">HAM</option>
												<option value="SHA">SHA</option>
												<option value="SIN">SIN</option>
								</select></td>
							<td width="68" class="stm">Level 2</td>
							<td width="180"><input type="text"  name="f_eg_cty_cd" style="width:125" maxlength="3" onKeyPress="ComKeyOnlyAlphabet('upper');"></td>
							<td width="50" class="stm">Level 3</td>
							<td><select name="f_svc_cate_cd" style="width:125"    caption="Level 3">
												<option value="" selected>&lt;&lt; select &gt;&gt;</option>
												<option value="TR"> Truck</option>
												<option value="RL"> Rail</option>
												<option value="CY"> ODCY</option>
												<option value="TM"> Terminal</option>
												<option value="WT"> Water</option>
												<option value="EQ"> EQ M&amp;R</option>
								</select></td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="80">S/P Code</td>
							<td width="233"><input type="text" class="input2" style="width:160" name="f_vndr_seq" readOnly> <img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_sp"></td>
							<td width="68">S/P Name</td>
							<td><input type="text" class="input2" style="width:100%" name="f_vndr_abbr_nm" readOnly></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


					<!-- Grid : Week (S) -->
					<table width="100%" id="mainTable">
					       <tr><td>
					           <script language="javascript">ComSheetObject('sheet1');</script>
					       </td></tr>
					</table>
					<!-- Grid : Week (E) -->

					<!--  Button_Sub (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<!--<tr><td class="btn2_left"></td><td class="btn2" id="btn_save" name="btn_save">Save</td><td class="btn2_right"></td></tr></table></td>-->
								<!-- Repeat Pattern -->

							</tr></table>
						</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->


				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>