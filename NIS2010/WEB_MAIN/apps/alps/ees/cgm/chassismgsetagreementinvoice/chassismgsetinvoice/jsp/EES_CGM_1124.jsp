<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1124.jsp
*@FileTitle : Neutral Pool Payable Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.08.21 김창식
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1124Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	EesCgm1124Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
	   
		event = (EesCgm1124Event)request.getAttribute("Event");
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
<title>Neutral Pool Payable Charge Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		document.form.ofc_cd.value = "<%=ofc_cd%>";
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">

<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name ="eq_knd_cd" value="G">
<input type="hidden" name="actionflag">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="agmt_lstm_cd" value="NP">

<input type="hidden" name="inv_no">
<input type="hidden" name="pay_inv_seq">
<input type="hidden" name="chss_mgst_inv_knd_cd" value="CP">
<input type="hidden" name="chss_mgst_inv_sts_cd">
<input type="hidden" name="agmt_ofc_cty_cd">
<input type="hidden" name="agmt_seq">
<input type="hidden" name="agmt_ver_no" value="1">
<input type="hidden" name="curr_cd">
<input type="hidden" name="chg_smry_amt">
<input type="hidden" name="inv_smry_amt">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">


				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="83">Cost Month</td>
					<td width="209"><input type="text" name="cost_yrmon" dataformat="ym" maxlength="6" style="width:80" class="input1" value="">&nbsp;<img name="btns_cost_yrmon" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="98">Cost Office</td>
					<td width="210"><input type="text" name="cost_ofc_cd" dataformat="engup" maxlength="6" style="width:80" class="input1" value="">&nbsp;<img name="btns_office" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="120"><!-- Invoice Issue Date -->&nbsp;</td>
					<td><!-- input type="text" name="inv_dt" dataformat="ymd" maxlength="8" style="width:74;text-align:center;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_inv_dt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"--></td>
					
				</tr> 
				<tr class="h23">
					<td width="">Invoice No.</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('combo_inv', 1, 150, 0, 1, 0, true);</script></td>
					<td width="">Agreement No.</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('combo_agmt', 4, 150, 1, 1, 0, false);</script></td>
					<td width="">&nbsp;</td>
					<td width="">&nbsp;</td>
				</tr> 
				</table>			
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="83">Vendor Code</td>
					<td width="210"><input type="text" name="vndr_seq" style="width:150;" class="input2" value="" readonly></td>
					<td width="97">Vendor Name</td>
					<td><input type="text" name="vndr_lgl_eng_nm" style="width:428;" class="input2" value="" readonly></td>
				</tr> 
				</table>				<!--  biz_1   (E) -->

		</td></tr></table>	
		<table class="height_8"><tr><td></td></tr></table>	
		<!-- 1 (E) -->

		
		<!-- 2 (S) -->
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
				
			<!-- grid box (S) -->
			<table class="search" style="width:979">
			<tr><td valign="top" width="50%" style="padding-right:10px;" rowspan="2">	
					
					<!-- Expense Detail  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!-- Expense Detail (E) -->	
					<!-- Basic Rate (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
						<td width="65">Max. Rate</td>
						<td width="230"><input type="text" name="pool_max_rt_amt" dataformat="float" maxlength="8" class="input" value=""></td>
						<td width="65">Min. Rate</td>
						<td><input type="text" name="pool_min_rt_amt" dataformat="float" maxlength="8" class="input" value=""></td></tr>
				</table>
					<!-- Basic Rate (E) -->								
				</td>
				
				<td valign="top" width="50%" style="padding-left:10px;">	
					<!-- Remark (S) -->
					<table border="0" style="width:100%; background-color:white;" class="grid2"> 
					<tr class="tr2_head">
						<td>Remark</td></tr>
					<tr><td style="padding:0;"><textarea name="diff_rmk" style="width:100%; height:115;ime-mode:disabled"></textarea></td></tr>
					</table>		
					<!-- Remark (E) -->	
								
				</td></tr>
			</table>
			<!-- grid box (E) -->
			
			
		</td></tr>
		</table>			
		<!-- 2 (E) -->
		
		<!--biz page (E)-->

	
	
	</td></tr>
		</table>
	

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New" id="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm" id="btn_Confirm">P. Amt Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete" id="btn_Delete">Invoice Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->	

<!-- hidden 처리 (S)-->
<div style="display:none">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<!-- hidden 처리 (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>