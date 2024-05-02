<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_4034.jsp
*@FileTitle : Percent Base CHG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.02
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.09.02 송호진
* 1.0 Creation
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.event.EsmPri4034Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>

<%
	EsmPri4034Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String inlandFlag = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String trfInlndFlg     = null;				//combo에 셋팅해줄 값
	
	String[] scgCd = null;

	Logger log = Logger.getLogger("com.clt.apps.Tariff.TariffCode");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (EsmPri4034Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		scgCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("surchargeList"), true);
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Tariff Code Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var scgCdValue = " |<%=scgCd[0]%>";
    var scgCdText = " |<%=scgCd[1]%>";
    
 	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td class="bg">
					<table class="search" border="0">
						<tr class="h23">
							<td width="90">Access Date</td>
							<td width="150"><input type="text" style="width:80;text-align:center;" class="input" name="acs_dt" maxlength="10" dataformat="ymd" value="">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_calendar1"></td>
						</tr>
					</table>
				</td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td style="display:none" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td id="save_td" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="edit_td"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_edit">Edit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg" width="45%" valign="top">
				<!--grid (s)-->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--grid 1 button (S)-->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" 	class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_rowadd1">Row Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">									
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_rowdelete1">Row Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table> 
				</td>
				<!--grid 1 button (E)-->
				<td width="5%" align="center"><img src="img/btn_add.gif"
					width="26" height="26" alt="" border="0" align="absmiddle">&nbsp;</td>
				<td class="bg" width="50%">
				
				<!--grid 2 (s)-->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				<!--grid 2 (E)--> 
				</table>
				<!--grid button (S)-->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">									
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_rowadd2">Row Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">									
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_rowdelete2">Row Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>								
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">	
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_downExcel">Down Excel</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_loadExcel">Load Excel</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>

				<!--grid 2 button (E)--></td>
			</tr>
		</table>
	
	<!--  biz_1   (E) -->
	
	</td></tr>
</table>

	<table class="height_10"><tr><td colspan="8"></td></tr></table>


</form>
</body>
</html>