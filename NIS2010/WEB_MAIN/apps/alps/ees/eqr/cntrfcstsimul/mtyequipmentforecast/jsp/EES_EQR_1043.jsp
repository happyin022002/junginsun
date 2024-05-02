<%/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1043.jsp
*@FileTitle : OP/MG Forecast Log
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.20
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2009.08.11 신용찬
* 1.0 Creation
* 2013.02.21 신용찬 [CHM-201323022]    OP/MG FCST HISTORY 화면생성(버튼)
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1043Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1043Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String repoPlnWrwk 	= ""; 
	String repoPlnWrwkView = ""; // 화면표현
	String inpYrwk      = "";
	String fcastYrwk 	= "";
	String fcastYrwkView= "";    // 화면표현
	String locGrpCd 	= "";
	String locCd    	= "";
	String tpCD         = "";
	String title 		= "";
	String locLevel     = "";
	String searchFlag   = "";
	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EesEqr1043Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		repoPlnWrwk = (String)event.getAttribute("repo_pln_yrwk");
		if(!repoPlnWrwk.equals("")) repoPlnWrwkView = repoPlnWrwk.substring(0, 4) + "-" + repoPlnWrwk.substring(4, 6);
		
		inpYrwk     = (String)event.getAttribute("inp_yrwk");
		fcastYrwk 	= (String)event.getAttribute("fcast_yrwk");
		if(!fcastYrwk.equals("")) fcastYrwkView = fcastYrwk.substring(4, 6);
		locGrpCd 	= (String)event.getAttribute("loc_grp_cd");
		locCd    	= (String)event.getAttribute("loc_cd");
		tpCD        = (String)event.getAttribute("tp_cd");	
		searchFlag  = (String)event.getAttribute("search_flag");	
		
		if("1".equals(tpCD)) title = "MG Input History";
		else				 title = "OP Input History";		
		
		if("E".equals(locGrpCd)){
			locLevel = "ECC";
		}else if("L".equals(locGrpCd)){
			locLevel = "LCC";
		}else if("S".equals(locGrpCd)){
			locLevel = "SCC";
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title><%=title%></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">

<input type="hidden" name="loc_cd"     	  value=<%=locCd %>>
<input type="hidden" name="inp_yrwk"   	  value=<%=inpYrwk %>>
<input type="hidden" name="fcast_yrwk" 	  value=<%=fcastYrwk %>>
<input type="hidden" name="repo_pln_yrwk" value=<%=repoPlnWrwk %>>
<input type="hidden" name="loc_grp_cd"    value=<%=locGrpCd %>>
<input type="hidden" name="tp_cd"         value=<%=tpCD %>>
<input type="hidden" name="search_flag"   value=<%=searchFlag %>>

		 				   
<!-- OUTER - POPUP (S)tart -->

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<%=title%></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">
       		<table class="search" border="0" style="width:979;"> 
       			<tr class="h23">
       				<td  align="center">Balance Report ID : <%=repoPlnWrwkView %>, &nbsp;Week : <%=fcastYrwkView %> </td>				
				</tr>
			</table>

			<!-- Grid  (S) -->
			<table width="100%" class="search"  id="mainTable">
				<tr class="h23">
					<td width="145" align="left"><%=locLevel %> : <%=locCd %></td>
					<td align="left"></td>
				</tr>
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>

				

			<!-- Grid (E) -->

			</td></tr>
		</table>
		<!--biz page (E)-->		
<table class="height_5"><tr><td colspan="8"></td></tr></table>
</td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>
