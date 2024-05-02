<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0654.jsp
*@FileTitle : RFA Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.21 김병규
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0654Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg0654Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingSearch");
	
	String bkgNo = "";
	String sCustCntCd = "";
	String sCustSeq = "";
	String cCustCntCd = "";
	String cCustSeq = "";
	String porCd = "";
	String delCd = "";
	String calllFunc = "";
	String bkgVvd = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0654Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		sCustCntCd  = JSPUtil.getParameter(request, "s_cust_cnt_cd");
		sCustSeq  = JSPUtil.getParameter(request, "s_cust_seq");
		cCustCntCd  = JSPUtil.getParameter(request, "c_cust_cnt_cd");
		cCustSeq  = JSPUtil.getParameter(request, "c_cust_seq");
		porCd  = JSPUtil.getParameter(request, "por_cd");
		delCd  = JSPUtil.getParameter(request, "del_cd");
		calllFunc  = JSPUtil.getParameter(request, "func");
		bkgVvd  = JSPUtil.getParameter(request, "bkg_vvd");		
		

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RFA Search</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="por_cd" value="<%=porCd%>">
<input type="hidden" name="del_cd" value="<%=delCd%>">
<input type="hidden" name="bkg_vvd" value="<%=bkgVvd%>">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;RFA No Search</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td>
						<table class="search_sm2" border="0" style="width:500;"> 
						<tr class="h23">
							<td width="30">SHPR</td> 
							<td width=""><input type="text" name="s_cust_cnt_cd" style="width:30" class="input1" value="<%=sCustCntCd %>" style="ime-mode:disabled"  maxlength=2 dataformat="engup">
							  <input type="text" name="s_cust_seq" style="width:58" class="input" value="<%=sCustSeq %>"style="ime-mode:disabled"  maxlength=6 dataformat="int">
							  <input type="text" name="s_cust_nm" style="width:220" class="input" value="" maxlength=40 style="ime-mode:disabled"  maxlength=2 dataformat="engupspace">
							  <img class="cursor" src="img/btns_search.gif" name="btn_Shpr"  width="19" height="20" border="0" align="absmiddle"></td>
					
						</tr>
						<tr class="h23">
							<td width="30">CNEE</td> 
							<td width="" class="stm"><input type="text" name="c_cust_cnt_cd" style="width:30" class="input1" value="<%=cCustCntCd %>"style="ime-mode:disabled"  maxlength=2 dataformat="engup">
				            <input type="text" name="c_cust_seq" style="width:58" class="input" value="<%=cCustSeq %>"style="ime-mode:disabled"  maxlength=6 dataformat="int">
				            <input type="text" name="c_cust_nm" style="width:220" class="input" value="" maxlength=40 style="ime-mode:disabled"  maxlength=2 dataformat="engupspace">
				            <img class="cursor" src="img/btns_search.gif" name="btn_Cnee" width="19" height="20" border="0" align="absmiddle">
				            Any match<input type="checkbox" name="include_flag" class="trans" value="Y"></td>
				
						</tr>
						</table>
					</td>
					<td width="50" valign="top" style="padding-top:4;">Scope</td>
					<td width="35" valign="top">
						 <input type="text" name="svc_scp_cd" style="width:30" class="input" value=""  style="ime-mode:disabled"  maxlength=3 dataformat="etc">
					</td>	 
					<td width="" valign="top">
						<script language="javascript" >ComComboObject('svc_scp_cd_list', 2, 195, 1, 0, 1)</script>
					</td>
				</tr>
				<tr class="h23">
					<!-- 	<td width="120">
						<table border="0" style="width:100;" class="search_sm2"> 
							<tr class="h23">
								<td class="sm">
									<input type="checkbox" name="include_flag" class="trans"  value="Y">&nbsp;Any match</td></tr>
							</table> 
					</td>-->
<!-- 					<td width="45">TRI No.</td>
					<td width=""  colspan=2><input type="text" name="tri_no" style="width:124" class="input" value="" maxlength=13 dataformat="int" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td> -->
				</tr>
				</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				
				<!-- : ( Grid ) (E) -->	
				<table class="search" border="0" style="width:797;"> 
				<tr class="stm">
					<td width=""> * S - Shipper, C - Consignee, N - Notify</td> 
				</tr></table>
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Select">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Rfa">RFA Inquiry</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line">
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
