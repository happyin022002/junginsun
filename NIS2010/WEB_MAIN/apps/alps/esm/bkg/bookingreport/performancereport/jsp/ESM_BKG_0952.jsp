<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0952.jsp
*@FileTitle : TRO Status List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.10.15 이남경
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0952Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0952Event  event = null;			    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0952Event)request.getAttribute("Event");
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
<title>C/A Summary Report</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- opener 에서 넘겨받은 조건값 -->
<!-- input type="hidden" name="cre_from_dt">
<input type="hidden" name="cre_to_dt">
<input type="hidden" name="corr_from_dt">
<input type="hidden" name="corr_to_dt">
<input type="hidden" name="vvd" -->

<input type="hidden" name="ca_reson_m">
<input type="hidden" name="ca_reson_c">
<input type="hidden" name="ca_reson_g">
<input type="hidden" name="ca_reson_a">
<input type="hidden" name="ca_reson_o">
<input type="hidden" name="ca_class_1">
<input type="hidden" name="ca_class_2">
<input type="hidden" name="ca_class_3">
<input type="hidden" name="ca_kind_a">
<input type="hidden" name="ca_kind_b">
<input type="hidden" name="ca_kind_c">
<input type="hidden" name="ca_kind_d">
<input type="hidden" name="ca_kind_e">
<input type="hidden" name="ca_kind_f">
<input type="hidden" name="ca_kind_g">
<input type="hidden" name="ca_kind_h">
<input type="hidden" name="ca_kind_i">
<input type="hidden" name="ca_kind_j">
<input type="hidden" name="ca_kind_k">
<input type="hidden" name="ca_issue_off">
<input type="hidden" name="bkg_off">
<input type="hidden" name="del_off">
<input type="hidden" name="part">
<input type="hidden" name="contract_off">
<input type="hidden" name="ca_issue_staff">
<input type="hidden" name="off_disp_op_1">
<input type="hidden" name="off_disp_op_2">
<input type="hidden" name="off_disp_op_3">
<input type="hidden" name="off_disp_op_4">
<input type="hidden" name="off_disp_op_5">
<input type="hidden" name="off_disp_op_6">
<input type="hidden" name="por">
<input type="hidden" name="pol">
<input type="hidden" name="pod">
<input type="hidden" name="del">
<input type="hidden" name="other_op_1">
<input type="hidden" name="other_op_2">
<input type="hidden" name="other_op_3">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; C/A Summary Report</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       		<tr><td class="bg">
			
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<td width="85">Booking Date</td> 
				<td width="200"><input type="text" name="cre_from_dt" style="width:80;" value="" class="input2" readonly>&nbsp;~&nbsp;<input type="text" name="cre_to_dt" style="width:80;" value="" class="input2" readonly></td>	
				<td width="100">Correction Date </td>
				<td width="200"><input type="text" name="corr_from_dt" style="width:80;" value="" class="input2" readonly>&nbsp;~&nbsp;<input type="text" name="corr_to_dt" style="width:80;" value="" class="input2" readonly></td>	
				<td width="35">VVD</td> 
				<td width=""><input type="text" name="vvd" style="width:80;" value="" class="input2" readonly></td>	
				
			</tr>
			</table>
				
					
			
			
			<!--  biz_1   (E) -->
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!-- : ( Grid ) (E) -->	
		
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SummaryDownExcel">Summary Down Excel</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SaveListDownExcel">B/L List Down Excel</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
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

<SCRIPT LANGUAGE="javascript">
<!--
      /* 
        ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다. 
      */
      with(document.form)
      {
        <%
        if(event.getCaSummaryReportInVO() != null){   
        	String creFromDt    = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCreFromDt());
        	String creToDt      = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCreToDt());
        	String corrFromDt   = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCorrFromDt());
        	String corrToDt     = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCorrToDt());
        	String vvd          = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getVvd());
        	String caResonM     = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaReasonM());
        	String caResonC     = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaReasonG());
        	String caResonG     = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaReasonG());
        	String caResonA     = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaReasonA());
        	String caResonO     = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaReasonO());
        	String caClass1     = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaClass1());
        	String caClass2     = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaClass2());
        	String caClass3     = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaClass3());
        	String caKindA      = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaKindA());
        	String caKindB      = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaKindB());
        	String caKindC      = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaKindC());
        	String caKindD      = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaKindD());
        	String caKindE      = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaKindE());
        	String caKindF      = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaKindF());
        	String caKindG      = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaKindG());
        	String caKindH      = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaKindH());
        	String caKindI      = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaKindI());
        	String caKindJ      = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaKindJ());
        	String caKindK      = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaKindK());
        	String caIssueOff   = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaIssueOff());
        	String bkgOff       = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getBkgOff());
        	String delOff       = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getDelOff());
        	String part         = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getPart());
        	String contractOff  = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getContractOff());
        	String caIssueStaff = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getCaIssueStaff());
        	String offDisOp1    = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getOffDisOp1());
        	String offDisOp2    = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getOffDisOp2());
        	String offDisOp3    = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getOffDisOp3());
        	String offDisOp4    = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getOffDisOp4());
        	String offDisOp5    = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getOffDisOp5());
        	String offDisOp6    = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getOffDisOp6());
        	String por          = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getPor());
        	String pol          = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getPol());
        	String pod          = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getPod());
        	String del          = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getDel());
        	String otherOp1     = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getOtherOp1());
        	String otherOp2     = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getOtherOp2());
        	String otherOp3     = JSPUtil.getNullNoTrim(event.getCaSummaryReportInVO().getOtherOp3()); 
        %>    
	        eval("cre_from_dt").value      = "<%=creFromDt%>";
	        eval("cre_to_dt").value        = "<%=creToDt%>";
	        eval("corr_from_dt").value     = "<%=corrFromDt%>";
	        eval("corr_to_dt").value       = "<%=corrToDt%>";
	        eval("vvd").value              = "<%=vvd%>";
	        eval("ca_reson_m").value       = "<%=caResonM%>";
	        eval("ca_reson_c").value       = "<%=caResonC%>";
	        eval("ca_reson_g").value       = "<%=caResonG%>";
	        eval("ca_reson_a").value       = "<%=caResonA%>";
	        eval("ca_reson_o").value       = "<%=caResonO%>";
	        eval("ca_class_1").value       = "<%=caClass1%>";
	        eval("ca_class_2").value       = "<%=caClass2%>";
	        eval("ca_class_3").value       = "<%=caClass3%>";	        
	        eval("ca_kind_a").value        = "<%=caKindA%>";
	        eval("ca_kind_b").value        = "<%=caKindB%>";
	        eval("ca_kind_c").value        = "<%=caKindC%>";
	        eval("ca_kind_d").value        = "<%=caKindD%>";
	        eval("ca_kind_e").value        = "<%=caKindE%>";
	        eval("ca_kind_f").value        = "<%=caKindF%>";
	        eval("ca_kind_g").value        = "<%=caKindG%>";
	        eval("ca_kind_h").value        = "<%=caKindH%>";
	        eval("ca_kind_i").value        = "<%=caKindI%>";
	        eval("ca_kind_j").value        = "<%=caKindJ%>";
	        eval("ca_kind_k").value        = "<%=caKindK%>";
	        eval("ca_issue_off").value     = "<%=caIssueOff%>";
	        eval("bkg_off").value          = "<%=bkgOff%>";
	        eval("del_off").value          = "<%=delOff%>";
	        eval("part").value             = "<%=part%>";
	        eval("contract_off").value     = "<%=contractOff%>";
	        eval("ca_issue_staff").value   = "<%=caIssueStaff%>";
	        eval("off_disp_op_1").value    = "<%=offDisOp1%>";
	        eval("off_disp_op_2").value    = "<%=offDisOp2%>";
	        eval("off_disp_op_3").value    = "<%=offDisOp3%>";
	        eval("off_disp_op_4").value    = "<%=offDisOp4%>";
	        eval("off_disp_op_5").value    = "<%=offDisOp5%>";
	        eval("off_disp_op_6").value    = "<%=offDisOp6%>";
	        eval("por").value              = "<%=por%>";
	        eval("pol").value              = "<%=pol%>";
	        eval("pod").value              = "<%=pod%>";
	        eval("del").value              = "<%=del%>";
	        eval("other_op_1").value       = "<%=otherOp1%>";
	        eval("other_op_2").value       = "<%=otherOp2%>";
	        eval("other_op_3").value       = "<%=otherOp3%>";
        <% } %>
       }
-->
</SCRIPT>
