<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2098.jsp
*@FileTitle : Payable Charge Audit Result & Payable Amount Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.08.21 김창식
* 1.0 Creation
*--------------------------------------------------
* History
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2098Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm2098Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");
	
	String vndrSeq = "";
	String costYrmon = "";
	String chgCreSeq = "";
	String lseChgStsCd = "";
	
	String costYrmonDtSeq = "";
	String costYrmonSeq = "";
	String agmtOfcCtyCd = "";
	String agmtSeq      = "";
	String agmtRefNo    = "";
	String invNo        = "";	
		
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCgm2098Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		/*
		vndrSeq 		= request.getParameter("vndr_seq");
		costYrmon 		= request.getParameter("cost_yrmon");
		chgCreSeq 		= request.getParameter("chg_cre_seq");
		lseChgStsCd 	= request.getParameter("lse_chg_sts_cd");
		costYrmonDtSeq 	= request.getParameter("cost_yrmon_dtseq");
		costYrmonSeq 	= request.getParameter("cost_yrmon_seq");
		agmtOfcCtyCd 	= request.getParameter("agmt_ofc_cty_cd");
		agmtSeq      	= request.getParameter("agmt_seq");
		agmtRefNo    	= request.getParameter("agmt_ref_no");
		invNo        	= request.getParameter("inv_no");	
		*/
		
		vndrSeq 		= StringUtil.xssFilter(request.getParameter("vndr_seq"));
		costYrmon 		= StringUtil.xssFilter(request.getParameter("cost_yrmon"));
		chgCreSeq 		= StringUtil.xssFilter(request.getParameter("chg_cre_seq"));
		lseChgStsCd 	= StringUtil.xssFilter(request.getParameter("lse_chg_sts_cd"));
		costYrmonDtSeq 	= StringUtil.xssFilter(request.getParameter("cost_yrmon_dtseq"));
		costYrmonSeq 	= StringUtil.xssFilter(request.getParameter("cost_yrmon_seq"));
		agmtOfcCtyCd 	= StringUtil.xssFilter(request.getParameter("agmt_ofc_cty_cd"));
		agmtSeq      	= StringUtil.xssFilter(request.getParameter("agmt_seq"));
		agmtRefNo    	= StringUtil.xssFilter(request.getParameter("agmt_ref_no"));
		invNo        	= StringUtil.xssFilter(request.getParameter("inv_no"));		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Charge Audit Result & Payable Amount Confirm</title>
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
<input type="hidden" name ="lse_chg_sts_cd" value="<%=lseChgStsCd %>">
<input type="hidden" name="inv_dt" value="">

<input type="hidden" name="cost_yrmon_seq" 	value="<%=costYrmonSeq%>"> 	<!-- from parent screen -->
<input type="hidden" name="parent_cost_yrmon_seq" 	value="<%=costYrmonSeq%>"> 	<!-- from parent screen -->
<input type="hidden" name="parent_agmt_ofc_cty_cd" 	value="<%=agmtOfcCtyCd%>"> 	<!-- from parent screen -->
<input type="hidden" name="parent_agmt_seq" 		value="<%=agmtSeq%>"> 		<!-- from parent screen -->
<input type="hidden" name="parent_agmt_ref_no" 		value="<%=agmtRefNo%>"> 	<!-- from parent screen -->
<input type="hidden" name="parent_inv_no" 			value="<%=invNo%>"> 		<!-- from parent screen -->

<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Charge Audit Result & Payable Amount Confirm</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	<!--Page Title, Historical (S)-->
		<!--table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;Equipment Management > M.G.Set > Lease > Invoice > Payable Charge Audit Result & S/O Creation</span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Payable Charge Audit Result & S/O Creation</span></td></tr>
		</table-->
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<tr class="h23">
					<td width="45">Lessor</td>
					<td width="420"><input name="vndr_seq" type="text" style="width:60;text-align:center" readonly class="input2" value="<%=vndrSeq %>" >&nbsp;<input name="vndr_lgl_eng_nm" readonly type="text" style="width:300;" readonly class="input2" value=""></td>
					<td width="80">Cost Month</td>
					<td><input name="cost_yrmon" type="text" style="width:70;text-align:center" readonly class="input2" value="<%=costYrmon %>"></td>
					<!-- 
					<td width="80">Issue Date</td>
					<td><input name="inv_dt" type="text" maxlength="8" dataformat="ymd" style="width:80;ime-mode:disabled;text-align:center" class="input" value="">&nbsp;<img name="btns_inv_dt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1"></td>
					-->
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			
			<table class="height_8"><tr><td></td></tr></table>
	
			<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1');</script>
						
					</td></tr>
			</table>
			<!-- Tab ) (E) -->

		
<!--TAB Coincidence (S) -->

<div id="tabLayer" style="display:inline">
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet1');</script>
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
						<td class="btn2" name="btn_coin_back">Back.>></td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downExcel">Down&nbsp;Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<table class="height_10"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="220">Charge Amount : <input type="text" name="pay_chg_smry_amt" readonly style="width:80;text-align:right;" class="input2" value=""></td>
					<td width="220">Payable Amount : <input type="text" name="inv_smry_amt" readonly style="width:80;text-align:right;" class="input2" value=""></td>
					<td width="180">Sales Tax  : <input type="text" name="tax_smry_amt" readonly style="width:80;text-align:right;" class="input2" value=""></td>
					<td width="">Credit : <input type="text" name="cr_smry_amt" readonly style="width:80;text-align:right;" class="input2" value=""></td>
				</tr>
			</table>

			</td></tr>
		</table>
		
			
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->

</div>

<!--TAB Coincidence (E) -->


<!--TAB Discrepancy (S) -->

<div id="tabLayer" style="display:none">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet1');</script>
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
						<td class="btn2" name="btn_coin">Coin.<<</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downExcel">Down&nbsp;Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<table class="height_10"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="220">Charge Amount : <input type="text" name="lse_chg_amt" readonly style="width:80;text-align:right;" class="input" value=""></td>
					<td width="220">Invoice Amount : <input type="text" name="inv_lse_chg_amt" readonly style="width:80;text-align:right;" class="input" value=""></td>
					<td style="color:red">Difference : <input type="text" name="diff" readonly style="width:80;text-align:right;color:red" class="input" value=""></td>
				</tr>
			</table>

				
			
	</td></tr>
</table>

	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->

</div>

<!--TAB Discrepancy (E) -->


<!--TAB NIS Only (S) -->

<div id="tabLayer" style="display:none">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t3sheet1');</script>
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
						<td class="btn2" name="btn_downExcel">Down&nbsp;Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<table class="height_10"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="220">Charge Amount : <input type="text" name="lse_chg_amt2" readonly style="width:80;text-align:right;" class="input" value=""></td>
					<td width="220">Invoice Amount : <input type="text" name="inv_lse_chg_amt2" readonly style="width:80;text-align:right;" class="input" value=""></td>
					<td style="color:red">Difference : <input type="text" name="diff2" readonly style="width:80;text-align:right;color:red" class="input" value=""></td>
				</tr>
			</table>
				
			
			</td></tr>
		</table>
		
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->

</div>

<!--TAB NIS Only (E) -->


<!--TAB Invoice Only (S) -->

<div id="tabLayer" style="display:none">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t4sheet1');</script>
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
						<td class="btn2" name="btn_coin">Coin.<<</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downExcel">Down&nbsp;Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
           <table class="height_10"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="220">Charge Amount : <input type="text" name="lse_chg_amt3" readonly style="width:80;text-align:right;" class="input" value=""></td>
					<td width="220">Invoice Amount : <input type="text" name="inv_lse_chg_amt3" readonly style="width:80;text-align:right;" class="input" value=""></td>
					<td style="color:red">Difference : <input type="text" name="diff3" readonly style="width:80;text-align:right;color:red" class="input" value=""></td>
				</tr>
			</table>
				
			
			</td></tr>
		</table>

	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->

</div>

<!--TAB Invoice Only (E) -->
 <table class="height_5"><tr><td></td></tr></table>	
</td></tr>
</table>	
   
	
	<!-- : ( Button : pop ) (S) -->
	<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
		
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_soCreate">Payable Amount Confirm</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_remove">Delete</td>
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
			</table> </td></tr>
			</table> 
	    <!--Button (E) -->
		
		
	<!-- : ( Button : pop ) (E) -->
	
<!-- 개발자 작업  끝 -->

<div id="hiddenLayer" style="display:none">
	<script language="javascript">ComSheetObject('sheet1');</script>  
</div>
<div id="hiddenLayer" style="display:none">
    <script language="javascript">ComSheetObject('t1sheet1_tmp');</script>  
</div>
<div id="hiddenLayer" style="display:none">
    <script language="javascript">ComSheetObject('t2sheet1_tmp');</script>  
</div>
<div id="hiddenLayer" style="display:none">
    <script language="javascript">ComSheetObject('t4sheet1_tmp');</script>  
</div>
</form>
</body>
</html>