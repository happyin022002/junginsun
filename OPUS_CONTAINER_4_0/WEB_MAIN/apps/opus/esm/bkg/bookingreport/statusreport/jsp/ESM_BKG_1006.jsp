
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_1006.jsp
	 *@FileTitle : DPCS: Amend Reason Detail
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate :
	 *@LastModifier :
	 *@LastVersion : 1.0
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1006Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1006Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1006Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
	  String bkg_no   = JSPUtil.getParameter(request,"bkg_no"); 
	  String sr_knd_cd  = JSPUtil.getParameter(request,"sr_kind_cd"); 
	  String sr_no    = JSPUtil.getParameter(request,"sr_no"); 
	  String pnd_flg  = JSPUtil.getParameter(request,"pnd_flg"); 
	  String src_cd   = JSPUtil.getParameter(request,"src_cd"); 
	  String sr_crnt_info_cd = JSPUtil.getParameter(request,"sr_crnt_info_cd"); 
	  String sr_crnt_sts_cd  = JSPUtil.getParameter(request,"sr_crnt_sts_cd"); 
	  String ui_id           = JSPUtil.getParameter(request,"ui_id"); 
%>
<html>
<head>
<title>DPCS : Amend Reason Detail</title>
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

<body onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="bkg_no"      value="<%=bkg_no%>">
	<input type="hidden" name="sr_knd_cd"      value="<%=sr_knd_cd%>">
	<input type="hidden" name="sr_no"      value="<%=sr_no%>">

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;DPCS: Amend Reason Detail

</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
		<table class="search_sm" border="0" style="width:579;"> 
		<tr class="h23">
			<td rowspan="6" width="70" valign="top">Carrier </td>
			<td class="stm" width="230"><input type="checkbox" value="" class="trans" name="mis_typ">&nbsp;&nbsp;Mis-Typing</td>
			<td rowspan="6" width="90" valign="top">Merchant  </td>
			<td class="stm" width=""><input type="checkbox" value="" class="trans" name="dat_mis">&nbsp;&nbsp;Data Missing</td>
		</tr>
		<tr class="h23">
			<td class="stm" width=""><input type="checkbox" value="" class="trans" name="wro_dat_inp">&nbsp;&nbsp;Wrong Data Input</td>
			<td class="stm" width=""><input type="checkbox" value="" class="trans" name="unc_fax">&nbsp;&nbsp;Unclear Fax</td>
		</tr>
		<tr class="h23">
		  	<td class="stm" width=""><input type="checkbox" value="" class="trans" name="mis_rat_sc">&nbsp;&nbsp;Mis-Rating(S/C)</td>
			<td class="stm" width=""><input type="checkbox" value="" class="trans" name="bl_dat_cha">&nbsp;&nbsp;B/L Data Change</td>
		</tr>
		<tr class="h23">
			<td class="stm" width=""><input type="checkbox" value="" class="trans" name="mis_rat_rfa">&nbsp;&nbsp;Mis-Rating(RFA)</td>
			<td class="stm" width=""><input type="checkbox" value="" class="trans" name="cod">&nbsp;&nbsp;COD</td>
		</tr>
		<tr class="h23">
			<td class="stm" width=""><input type="checkbox" value="" class="trans" name="sal">&nbsp;&nbsp;Sales</td>
			<td class="stm" width=""><input type="checkbox" value="" class="trans" name="spl">&nbsp;&nbsp;Split/Combine</td>
		</tr>	
		<tr class="h23">
			<td class="stm" width=""><input type="checkbox" value="" class="trans" name="fo_err">&nbsp;&nbsp;FO Error</td>
			<td class="stm" width=""></td>
		</tr>
		</table>
				
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

					<table width="100%" class="button" border="0" cellpadding="0"
						cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
						<tr>
							<td class="btn3_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
													<table width="72" border="0" cellpadding="0" cellspacing="0"
														class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_Close">Close</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
											</td>
										</tr>
									</table>
							<!--Button (E) --></td>
						</tr>
					</table>
			</td>
		</tr>
	</table>					
		<!-- : ( Button : pop ) (E) -->

<!-- Developer Work End -->
</form>
<div style="display:none">
<table width="100%"  id="mainTable">
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>
</div>
</body>
</html>
<%@include file="/bizcommon/include/common_opus.jsp"%>