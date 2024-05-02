<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_INV_0079.jsp
 *@FileTitle : Unmatched Revenue VVD Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 최우석
 *@LastVersion : 1.0
 * 2009.10.07 최우석
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0079Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0079Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
//	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
//	String successFlag = "";
//	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
//	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceCorrection");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (FnsInv0079Event)request.getAttribute("Event");
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
<title>Unmatched Revenue VVD Inquiry</title>
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

<body  onLoad="setupPage();" onUnLoad="closeOpenWait();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="batchJobID">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--biz page (S)-->
		<table class="search"> 
       		<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="60">I/F Date</td>
						<td width="300"><input type="text" name="from_dt" style="width:80;text-align:center;" class="input1" value="" maxlength="8" dataformat="ymd" required fullfill caption="From I/F Date" cofield="to_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btn_fromDt" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" name="to_dt" style="width:80;text-align:center;" class="input1" value="" maxlength="8" dataformat="ymd" required fullfill cofield="from_dt" caption="To I/F Date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btn_toDt" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="56">BKG I/F</td>   
						<td width="100"><select style="width:67;" name="bkg_if_flg">
							<option value="" selected>All</option>
							<option value="Y">Yes</option>
							<option value="N">No</option>
							</select></td>
						<td width="">
						
						<!--Button (S) -->
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       				<tr><td class="btn2_bg">
				  			  	<table border="0" cellpadding="0" cellspacing="0">
					    			<tr>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_run">Run</td>
										<td class="btn2_right"></td>
										</tr>
									</table></td>
							
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_interface">Interface From Booking</td>
										<td class="btn2_right"></td>
										</tr>
									</table></td>
									</tr>
								</table>
							</td></tr>
						</table>
	    				<!--Button (E) -->
						</td>   
					</tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				
				<!-- Grid (S) -->
				<table width="100%" class="search"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet');</script>
						</td>
					</tr>
				</table> 			
				<!-- Grid (E) -->
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
		<!--biz page (E)-->
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrive">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_new">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_downExcel">Down&nbsp;Excel</td>
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

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>