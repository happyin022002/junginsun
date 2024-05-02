<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0003.jsp
*@FileTitle : Request Actual Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	ExpSpp0003Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//The count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String vndrSeq = "";
	String vvd = "";
	String vslNm = "";
	String ydCd = "";
	String callSeq = "";
	String revYrmon = "";
	String trnsDt = "";	
	String diffRmk = "";
	
	String vslCd = "";
	String skdVoyNo = "";
	String skdDirCd = "";
	
	Logger log = Logger.getLogger("com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (ExpSpp0003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//Getting the set request value from the main page.
		vndrSeq 	= (String) request.getParameter("vndrSeq");  //"100870";  //
		vvd	    	= (String) request.getParameter("vvd");  //"HJAA0002E";  //
		vslNm   	= (String) request.getParameter("vslNm");  //"HANJIN ATLANTA";  //
		ydCd    	= (String) request.getParameter("ydCd");  //"EGSUZT1";  //
		callSeq 	= (String) request.getParameter("callSeq");  //"2";  //
		revYrmon 	= (String) request.getParameter("revYrmon");  //"200905";  //
		trnsDt 		= (String) request.getParameter("trnsDt");  //"20090502";  //
		diffRmk 	= (String) request.getParameter("diffRmk");  //"Rejected";  //
		
		vslCd = vvd.substring(0,4);
		skdVoyNo = vvd.substring(4,8);
		skdDirCd = vvd.substring(8);		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Actual Invoice Request</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	//ComDebug("<%=vndrSeq+"/"+vvd+"/"+ydCd+"/"+callSeq+"/"+revYrmon%>");
		
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
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<!-- The value from the opener  -->
<input type="hidden" name="vndr_seq" value="<%=vndrSeq%>" />
<input type="hidden" name="vvd" value="<%=vvd%>" />
<input type="hidden" name="yd_cd" value="<%=ydCd%>" />
<input type="hidden" name="call_seq" value="<%=callSeq%>" />
<input type="hidden" name="ntc_yrmon" value="<%=revYrmon%>" />
<input type="hidden" name="diff_rmk" value="<%=diffRmk%>" />
<!-- Saving ADV Payment Status value after retrieving -->
<input type="hidden" name="cnl_tz_proc_sts_cd" />

<input type="hidden" name="cnl_tz_bztp_cd" value="I" />
<input type="hidden" name="vsl_cd" value="<%=vslCd%>" />
<input type="hidden" name="skd_voy_no" value="<%=skdVoyNo%>" />
<input type="hidden" name="skd_dir_cd" value="<%=skdDirCd%>" />

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Actual Invoice Request</td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
       	
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">VVD</td>
					<td width="200"><input name="vvdText" type="text" style="width:180;text-align:center;" class="input2" value="<%=vslNm+" "+skdVoyNo+skdDirCd%>" readonly></td>
					<td width="120">Invoice Rev. Month</td>
					<td width="125"><input name="rev_yrmon" type="text" dataformat="ym" maxlength="6" style="ime-mode:disabled;width:80;text-align:center;" class="input" value="<%=revYrmon%>">
					<img class="cursor" name="btns_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="125">Invoice TTL Amount</td>
					<td width="100"><input name="ttl_amt" type="text" dataformat="float" maxlength="15" pointcount="2" style="width:80;text-align:center" class="input"></td>
					<td width="80">Transit Date</td>
					<td width=""><input name="trns_dt" type="text"  style="width:80;text-align:center;" class="input2" value="<%=trnsDt%>" readonly></td>					
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">SCNT</td>
					<td width="125"><input name="suz_net_tong_wgt" type="text" dataformat="float" maxlength="9" pointcount="2" style="width:85;text-align:center" class="input"></td>
					<td width="30">SDR</td>
					<td width="100"><input name="locl_xch_rt" type="text" dataformat="float" maxlength="8" pointcount="5" style="width:80;text-align:center" class="input"></td>
					<td width="30">Tier</td>
					<td width="100"><input name="tr_vol_val" type="text" dataformat="int" maxlength="1" style="width:60;text-align:center" class="input"></td>
					<td width="120">Limit Surcharge Amt</td>
					<td width="100"><input name="scg_rt_amt" type="text" dataformat="float" maxlength="10" style="width:60;text-align:center" class="input">%</td>
					<td width="120">Allowance TEU</td>
					<td width=""><input name="cntr_pnm_capa" type="text" dataformat="float" maxlength="18" pointcount="3" style="width:80;text-align:center" class="input2" readonly></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!--  biz_2  (S) -->

				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
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
					<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_DownExcel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->				
				
				<!--  biz_2   (E) -->
				
			</td></tr>
		</table>
	
	<!--biz page (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Request" id="btn_Request">Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	

	</td></tr>
</table>

</form>
</body>
</html>