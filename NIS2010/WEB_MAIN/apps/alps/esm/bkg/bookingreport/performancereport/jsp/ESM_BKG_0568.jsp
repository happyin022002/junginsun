<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0568.jsp
*@FileTitle : C/A Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.22 강동윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0568Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.HashMap" %>

<%
	EsmBkg0568Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_cnt		= "";
	
	String navigation 		= "";
	String description		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	String vvdCd = "";
	String podCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		//strUsr_cnt= account.getCnt_cd();
		
		event = (EsmBkg0568Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		  description = (String) request.getAttribute("UI_DESCRIPTION");
		  navigation = ((String) request.getAttribute("UI_NAVIGATION")).substring(10);

		
		if (navigation.indexOf("US") > -1){
			
			strUsr_cnt = "US";
		}else if (navigation.indexOf("Canada") > -1){
			
			strUsr_cnt = "CA";
		}else{
			
			strUsr_cnt = "KR";
		}

        vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>C/A Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		document.form.pod_cd.focus();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="bkg_no">
<input type="hidden" name="bl_no2">
<input type="hidden" name="corr_no">
<input type="hidden" name="cnt_cd" value="<%= strUsr_cnt %>">
<input type="hidden" name="from_dt">
<input type="hidden" name="to_dt">
<input type="hidden" name="manifest">
<input type="hidden" name="vvd2">
<input type="hidden" name="pol">
<input type="hidden" name="pod">

<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

	<!--Page Title, Historical (E)-->
		
		
		<!-- Grid BG Box  (S) -->
		
     		<table class="search"> 
       		<tr><td class="bg">
			<!--  biz_1  (S) -->
				
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="120"><input type="radio" name="pk_tp" value="date" class="trans" checked>C/A Issue Date</td>
					<td width="290"><input type="text" name="from_date" style="width:70" class="input1" value=""  maxlength="10" size="10" dataformat="ymd" onClick="javascript:changeTP('0')" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<input type="text" name="from_time" style="width:40" class="input1" value=""  maxlength="5" size="5" onClick="javascript:changeTP('0')" OnBeforeDeactivate="ComAddSeparator(this,'hm')" OnBeforeActivate="ComClearSeparator(this,'hm')">&nbsp;<!-- img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" -->~&nbsp;<input type="text" name="to_date" style="width:70" class="input1" value=""  maxlength="10" size="10" dataformat="ymd" onClick="javascript:changeTP('0')" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<input type="text" name="to_time" style="width:40" class="input1" value=""  maxlength="5" size="5" onClick="javascript:changeTP('0')" OnBeforeDeactivate="ComAddSeparator(this,'hm')" OnBeforeActivate="ComClearSeparator(this,'hm')">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar"></td>
					<td width="40"><input type="radio" name="pk_tp" value="vvd" class="trans">VVD</td>
					<td width="90"><input type="text" name="vvd" dataformat="engupnum" maxlength="9" style="width:80" class="input1" value="<%=vvdCd%>" onClick="javascript:changeTP('1')"></td> 
					<td width="25">POD</td>
					<td width="50"><input type="text" name="pod_cd" dataformat="engup" maxlength="5" style="width:45;" class="input1" value="<%=podCd%>"></td>
					<% if (strUsr_cnt == "KR") { %>
					<td width="90"><input type="checkbox" name="pod_tp" value="VVD" class="trans" >Inc. T/S</td>
					<% }else{ %>
					<td width="10"></td>
					<% } %>
					<td width="25">DEL</td>
					<td width="60"><input type="text" name="del_cd" dataformat="engup" maxlength="5" style="width:45;" class="input" value="" onClick="javascript:changeTP('1')"></td>
					<td width="70"><input type="radio" name="pk_tp" value="bl" class="trans">B/L No</td>
					<td width=""><input type="text" name="bl_no" dataformat="engupnum" maxlength="12" style="width:100" class="input1" value="" onClick="javascript:changeTP('2')"></td> 				
					</tr> 
				</table>				
				
		</td> </tr> 
		</table>	
				<!--  biz_1   (E) -->
			
				<table class="height_8"><tr><td></td></tr></table>
				<!-- Tab (S) -->
     	
		<!-- Tab (E) -->
				
				<table class="search" border="0" style="width:100%;"> 
       		<tr><td class="bg">
			
				<table class="search" style="width:100%;">
					<tr><td width="890"></td><td class="btn2_line"></td>
				<td><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_ListPrint"><a href="javascript:ComOpenWindow2('http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/bkg/jsp/UI_BKG_0569.jsp','p','scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=400,height=392,left=0,top=0');">C/A KIND Details</a></td>
					<td class="btn2_right"></td>
					</tr>
				</table></td></tr></table>
			<table class="height_2"><tr><td></td></tr></table>
				<!--Grid (s)-->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!--Grid (E)-->
						<table class="height_8"><tr><td></td></tr></table>
				
				<!--Grid2 (S)-->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!--Grid2 (E)-->
						
						<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_BLInquiry">B/L Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_CntrInquiry">CNTR Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel2">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_print2">Preview</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
		</td></tr>
		</table>
	<!--biz page (E)-->
	<!--Button (S) -->
		<table class="height_10"><tr><td></td></tr></table>
    <!--Button (E) -->
	</td></tr>
</table>

<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CheckAll">Check All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_UncheckAll">Uncheck All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="">Preview  Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td -->
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>