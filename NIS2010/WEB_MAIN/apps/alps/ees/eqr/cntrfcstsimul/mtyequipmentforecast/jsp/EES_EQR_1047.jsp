<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1047.jsp
*@FileTitle : MTY Balance Repo Out
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.18
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.05.18 나상보
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1047Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1047Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String title = "";
	String locGrpCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesEqr1047Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		title = "MTY Balance Repo Out";
		
		if("E".equals(event.getAttribute("loc_grp_cd"))){
			locGrpCd = "ECC";
		}else if("L".equals(event.getAttribute("loc_grp_cd"))){
			locGrpCd = "LCC";
		}else if("S".equals(event.getAttribute("loc_grp_cd"))){
			locGrpCd = "SCC";
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
<%= JSPUtil.getIBCodeCombo("trspModCd", "01", "CD03235", 0, "")%> // trsp_mod_cd

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>
 


<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="loc_grp_cd"  value="<%=event.getAttribute("loc_grp_cd") %>">
<input type="hidden" name="loc_cd"  value="<%=event.getAttribute("loc_cd") %>">
<input type="hidden" name="fcast_yrwk"  value="<%=event.getAttribute("fcast_yrwk") %>">
<input type="hidden" name="inp_yrwk"  value="<%=event.getAttribute("inp_yrwk") %>">
<input type="hidden" name="cre_seq" >
<input type="hidden" name="save_option"  value="<%=event.getAttribute("save_flag") %>">
<input type="hidden" name="tpsz_flag"  value="<%=JSPUtil.getParameter(request, "tpsz_flag") %>">

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
					<td width="35"><%= locGrpCd %></td>
					<td width="10">:</td>
					<td width="100"><%=event.getAttribute("loc_cd") %></td>
					<td width="834"></td>
				</tr>
			</table>
			<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable">
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_RowAdd">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>


					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Delete">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr></table>
			</td></tr>
			</table>
			<!-- Button_Sub (E) -->
			
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
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
				</tr></table></td>
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
