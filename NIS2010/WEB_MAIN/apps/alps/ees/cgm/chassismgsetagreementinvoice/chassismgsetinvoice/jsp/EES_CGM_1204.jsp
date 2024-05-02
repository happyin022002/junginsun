<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1204.jsp
*@FileTitle : CPS Payable Charge Creation-Invoice Import
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.12
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.03.12 조경완
* 1.0 Creation
* -------------------------------------------------------------
* history
* 2015-04-02 Chang Young Kim
*  [CHM-201431711] COPS Charge Creation - Charge Audit Result & Payable Amount Confirm
* 2015.04.28 Chang Young Kim [CHM-201534113] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1204Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm1204Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");
	
	/*
	String vndrSeq 		= request.getParameter("vndr_seq");
	String costYrmon 	= request.getParameter("cost_yrmon");
	String chgCreSeq 	= request.getParameter("chg_cre_seq");
	String chssPoolCd 	= request.getParameter("chss_pool_cd");
	String agmtOfcCtyCd = request.getParameter("agmt_ofc_cty_cd");
	String agmtSeq 		= request.getParameter("agmt_seq"); 
	String agmtRefNo 	= request.getParameter("agmt_ref_no"); 
	*/
	
	String vndrSeq 		= StringUtil.xssFilter(request.getParameter("vndr_seq"));
	String costYrmon 	= StringUtil.xssFilter(request.getParameter("cost_yrmon"));
	String chgCreSeq 	= StringUtil.xssFilter(request.getParameter("chg_cre_seq"));
	String chssPoolCd 	= StringUtil.xssFilter(request.getParameter("chss_pool_cd"));
	String agmtOfcCtyCd = StringUtil.xssFilter(request.getParameter("agmt_ofc_cty_cd"));
	String agmtSeq 		= StringUtil.xssFilter(request.getParameter("agmt_seq")); 
	String agmtRefNo 	= StringUtil.xssFilter(request.getParameter("agmt_ref_no")); 
	String agmtVerNo 	= StringUtil.xssFilter(request.getParameter("agmt_ver_no")); 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCgm1204Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<title>CPS Payable Charge Creation-Invoice Import</title>
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
<input type="hidden" name="pagerows">
<input type="hidden" name ="eq_knd_cd" value="">
<input type="hidden" name ="chg_cre_seq" value="<%=chgCreSeq %>">
<input type="hidden" name ="agmt_ofc_cty_cd" value="<%=agmtOfcCtyCd %>">
<input type="hidden" name ="agmt_seq" value="<%=agmtSeq %>">
<input type="hidden" name ="inv_ref_no" value="<%=agmtRefNo %>">
<input type="hidden" name ="agmt_ver_no" value="<%=agmtVerNo %>">
<input type="hidden" name ="backendjob_key" value="">
<input type="hidden" name ="vrfy_scs_flg">
<input type="hidden" name ="intg_cd_id">
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Import & Audit</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
	<!--Page Title, Historical (S)-->
		<!--table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;Equipment Management > Chassis > Lease > Invoice > Invoice Import & Audit</span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Import & Audit</span></td></tr>
		</table-->
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S)  -->
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Charge Creation</td></tr>
			</table>	
			<table width="100%" class="search" > 
			<tr class="h23">
					<td width="43">Lessor</td>
					<td width="300"><input type="text" name="vndr_seq" readonly style="width:55;text-align:center" class="input2" value="<%=vndrSeq %>">&nbsp;<input type="text" name="vndr_lgl_eng_nm" readonly style="width:231;" class="input2" value=""></td>
					<td width="70">Pool Name</td>
					<td width="300"><input type="text" name="chss_pool_cd" readonly style="width:55;text-align:center" class="input2" value="<%=chssPoolCd %>">&nbsp;<input type="text" name="chss_pool_nm" readonly style="width:231;" class="input2" value=""></td>
					<td width="60">Currency</td>
					<td width="70"><input type="text" name="curr_cd" readonly style="width:40;ime-mode:disabled;text-align:center" class="input2" value="USD">&nbsp;<!--img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"--></td>
					<td width="45">Month</td>
					<td><input type="text" name="cost_yrmon" readonly style="width:60;text-align:center" class="input2" value="<%=costYrmon %>"></td>
				</tr>
			</table>
			
			<table class="line_bluedot" border="0"><tr><td colspan="6" ></td></tr></table>	
			
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Invoice File Import</td>
					<td width="90"><b>Invoice Type</b></td>
                    <td width="140"><script language="javascript">ComComboObject('cmb_inv_tp', 1, 120, 1);</script></td>
                    <td width="120"><b>Original Invoice No</b></td>
					<td width="180"><input type="text" name="org_inv_no" style="width:160;" class="input1" dataformat="engup" maxlength="20" required caption="Original Invoice No"></td>
					<td width="80"><b>Invoice No</b></td>
					<td width="160"><input type="text" name="inv_no" style="width:160;" class="input1" dataformat="engup" maxlength="20" required caption="Invoice No"></td>
					</tr>
			</table>
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
						<td class="btn2" name="btn_Loadexcel">Load&nbsp;Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Downexcel">Down&nbsp;Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
<!--						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">-->
<!--						<tr><td class="btn2_left"></td>-->
<!--						<td class="btn2" name="btn_Audit">Verify</td>-->
<!--						<td class="btn2_right"></td>-->
<!--						</tr>-->
<!--						</table></td>-->
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				<!--  biz_1  (E)  -->
			</td></tr>
		</table>
		
	<table class="height_5"><tr><td></td></tr></table>
		
		</td></tr>
		</table>	
				
	<!--biz page (E)-->

	<!-- : ( Button : pop ) (S) -->
	<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
		
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
			    	<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Audit">Audit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close">Close</td>
						<td class="btn1_right">
					</tr></table></td>
				</tr>
			</table></td></tr>
			</table> 
	    <!--Button (E) -->
		</td></tr>
	</table>
	<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>