<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0018.jsp
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.15 김진일
* 1.0 Creation
* 
* History
* 2012.02.01 진마리아 CHM-201215859-01 전도금 비용 수정 기능 추가 요청건(spp로부터 입력받는 전도금을 alps 화면을 통해 수정하여 저장 가능하도록)
* 2012.03.09 진마리아 CHM-201216307-01 Canal invoice 화면 변경 및 File download 기능 개발
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.event.VopPso0018Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
	VopPso0018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vndrSeq = "";
	String vvd = "";
	String ydCd = "";
	String callSeq = "";
	String revYrmon = "";
	String row = "";
	String col = "";
	String sts = ""; //Status CD
	String dueDt = "";
	String trnsDt = "";
	String ofcCd = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.EstimateInvoiceAudit.CanalTransitFeeEstimate");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofcCd     = account.getOfc_cd();

		event = (VopPso0018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//Main 화면에서 설정된 request값을 가져온다.
		vndrSeq = StringUtil.xssFilter((String) request.getParameter("vndrSeq"));
		vvd	    = StringUtil.xssFilter((String) request.getParameter("vvd"));
		ydCd    = StringUtil.xssFilter((String) request.getParameter("ydCd"));
		callSeq = StringUtil.xssFilter((String) request.getParameter("callSeq"));
		revYrmon = StringUtil.xssFilter((String) request.getParameter("revYrmon"));
		row = StringUtil.xssFilter((String) request.getParameter("row"));
		col = StringUtil.xssFilter((String) request.getParameter("col"));
		sts = StringUtil.xssFilter((String) request.getParameter("sts"));
		dueDt = StringUtil.xssFilter((String) request.getParameter("dueDt"));
		trnsDt = StringUtil.xssFilter((String) request.getParameter("trnsDt"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Requested Advance Payment</title>
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
<input type="hidden" name="vndr_seq" value="<%=vndrSeq%>" />
<input type="hidden" name="vvd2" value="<%=vvd%>" />
<input type="hidden" name="yd_cd" value="<%=ydCd%>" />
<input type="hidden" name="call_seq" value="<%=callSeq%>" />
<input type="hidden" name="rev_yrmon" value="<%=revYrmon%>" />
<input type="hidden" name="row" value="<%=row%>" />
<input type="hidden" name="col" value="<%=col%>" />
<input type="hidden" name="trns_dt" value="<%=trnsDt%>" />
<input type="hidden" name="ofc_cd" value="<%=ofcCd%>" />
<input type="hidden" name="usr_nm" value="<%=strUsr_nm%>" />
<input type="hidden" name="rqst_amt_sum">
<input type="hidden" name="calc_amt_sum">
<input type="hidden" name="sts" value="<%=sts%>" />
<input type="hidden" name="inv_rgst_no" value="" />
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">
<input type="hidden"   name="com_mrdTitle" value="Requested Advance Payment">
<input type="hidden"   name="com_mrdBodyTitle" value="Requested Advance Payment">

<input type="hidden"   name="com_mrdSaveDialogFileExt" value="ppt">
<input type="hidden"   name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt">
<input type="hidden"   name="com_mrdSaveDialogFileName" value="Requested Advance Payment">
<input type="hidden"   name="com_mrdSaveDialogDir" value="">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Requested Advance Payment</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">VVD</td>
					<td width="150"><input readonly name="vvd" type="text" style="width:85;text-align:center" class="input2" value="<%=vvd%>"></td>
					<td width="70">INV No.</td>
					<td width="709"><input readonly name="inv_no" type="text" style="width:240;text-align:center" class="input2" value=""></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<% if(ydCd.equals("EGSUZT1")){ %>
					<td width="50">SCNT</td>
					<td width="150"><input readonly name="scnt" type="text" style="width:85;text-align:center" class="input2" value=""></td>
					<td width="70">SDR</td>
					<td width="120"><input readonly name="sdr" type="text" style="width:85;text-align:center" class="input2" value=""></td>
					<td width="35">Tier</td>
					<td width="125"><input readonly name="tier" type="text" style="width:85;text-align:center" class="input2" value=""></td>
					<td width="0"><input readonly name="cntr_pnm_capa" type="hidden"></td>
					<%} else { %>
					<td width="0"><input readonly name="scnt" type="hidden"><input readonly name="sdr" type="hidden"><input readonly name="tier" type="hidden"></td>
					<td width="100">Allowance TEU</td>
					<td width="100"><input readonly name="cntr_pnm_capa" type="text" style="width:80;text-align:center" class="input2" value=""></td>
					<%} %>
					<td width="70">Due Date</td>
					<% if(!sts.equals("10")){ %>
					<td width=""><input name="due_dt" type="text" dataformat="ymd" maxlength="8" style="ime-mode:disabled;width:70;text-align:center" class="input1" value="">&nbsp;<img class="cursor" name="btns_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<%} else { %>
					<td width=""><input readonly name="due_dt" type="text" maxlength="8" style="ime-mode:disabled;width:70;text-align:center" class="input2" value=""></td>
					<%} %>
					<td width=""></td>
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
					<table width="100%"  id="mainTable" style="display:none;"><!-- style="display:none;" -->
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
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
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_BankInformation">Bank&nbsp;Information</td>
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


</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    
		    	<% if(!sts.equals("10") && !sts.equals("12")){ %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="tb_btn_Save">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="tb_btn_Confirm">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<%} %>
				
				<% if(!sts.equals("12")){ %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="tb_btn_Reject">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Reject">Reject</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<%} %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ToCSR">To CSR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				 -->
				
				<% if(!sts.equals("12")){ %> 
				<td class="btn1_line"></td>	
				<%} %>
					
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>	
				
			</tr>
		</table></td>	
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>