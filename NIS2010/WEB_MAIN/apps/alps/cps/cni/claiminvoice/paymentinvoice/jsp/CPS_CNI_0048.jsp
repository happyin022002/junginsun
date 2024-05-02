<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_0008.jsp
*@FileTitle : CSR Interface Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.16 함대성
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@page import="com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.event.CpsCni0048Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsCni0048Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= ""; 
	String cnt_cd 	 		= "";
	String inv_sub_sys_cd = "";
	
	inv_sub_sys_cd 			= JSPUtil.getParameter(request, "INV_SUB_SYS_CD".trim(), "");
	
	Logger log = Logger.getLogger("com.hanjin.apps.ConsultationSlipRequestMgt.ConsultationSlipRequestMgt");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    ofc_cd	  = account.getOfc_cd();
	    cnt_cd 	  = account.getCnt_cd();
	    
		event = (CpsCni0048Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String readonly_yn = null;
	String csr_no = null;
	readonly_yn = JSPUtil.getParameter(request,"readonly_yn".trim(),"");
	csr_no		= JSPUtil.getParameter(request,"csr_no".trim(),"");
%>


<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%><html>
<head>
<title>CSR Manager</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var cnt_cd = "<%=cnt_cd%>";	
	var readonly_yn = "<%=readonly_yn%>";	
	var ofc_cd = "<%=ofc_cd%>";	
	
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
<!-- 개발자 작업	-->
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="csr_no">
<input type="hidden" name="inv_sub_sys_cd" value="<%=inv_sub_sys_cd%>">
<input type="hidden" name="aproSeqKey">
<input type="hidden" name="apro_step" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(ofc_cd, inv_sub_sys_cd) %>">
<input type="hidden" name="clm_area_cd">
<input type="hidden" name="sXml" value="<%=xml%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
<input type="hidden" name="DB_DATE" value=''>
	<!--Page Title, Historical (S)-->
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">   
	        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>   
	    </table>   
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
						<tr class="h23">
						    <td width="30">Area</td>
                            <td width="70"><script language="javascript">ComComboObject("combo1", 2, 67, 1);</script></td>
							<td width="85">Invoice Office</td>
							<td width="80"><input name="ofc_cd" type="text" maxlength="6" style="width:60;text-align:center;center;ime-mode:disabled;" dataformat="engup" value="<%=ofc_cd%>"></td>
							
							<td width="30">Date</td>
							<td width="150">
							<select style="width:144;" name='dt_status'>
								<option value="AR">Approval Requested</option>
								<option value="AV">Approved or Disapproved</option>
								<option value="IU">I/F Status Updated</option>
							</select>
							</td>
						    <td width=""><input type="text" style="width:75;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8' class="input"  name="fm_eff_dt" value="">&nbsp;~&nbsp;<input type="text" style="width:75;text-align:center;ime-mode:disabled"  maxlength='8' dataformat="ymd" class="input" name="to_eff_dt" value="" >&nbsp;<img class="cursor" name="btns_Calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					   		</td>
					   		</tr>
					   		<tr class="h23">
							<td width="70">I/F Status</td>
							<td width="134">
							<select style="width:124;" name='if_status'>
								<option value="AL" selected>All</option>
								<option value="AR">Approval Requested</option>
								<option value="SD">Sending</option>
								<option value="DA">Disapproved</option>
								<option value="IE">I/F Error</option>
								<option value="RJ">A/P Rejected</option>
								<option value="SC">I/F Success</option>
								<option value="SP">Paid</option>
							</select>
							</td>
							<td width="50">CSR No.</td>
							<td width="" colspan="5"><input name="search_csr_no" type="text" dataformat="engup" maxlength="20" style="width:200;ime-mode:disabled;" value="<%=csr_no%>"  onBlur='this.value=this.value.trim();'></td>				
							<!--  biz_1   (E) -->
						</tr>
				</table> 
		</td></tr>
		</table>
		
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
			<table width="100%" class="search"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table> 			
			<!-- Grid (E) -->
			</td></tr>
		</table>
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn1_bg">
				<div id='btng_csrcancel_yn' style="display:inline">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_new">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_print">Down&nbsp;Excel</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_viewapprovalstep">View&nbsp;Approval&nbsp;Step</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_csrformat">CSR&nbsp;Format</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_invoicelistinquiry">Invoice&nbsp;List&nbsp;Inquiry</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>	
					</tr>
				</table>
				</div>       	
       		</td></tr>
		</table>
		  
</form>
<div style="display:none">
        <!-- Grid  (S) --> 
        <table width="100%" class="search"  id="mainTable"> 
            <tr>
                <td width="100%">
                <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
            </tr>
        </table>            
        <!-- Grid (E) -->
        
        <!-- Grid  (S) -->
        <table width="100%" class="search"  id="mainTable">
            <tr>
                <td width="100%">
                <script language="javascript">ComSheetObject('sheet3');</script>
                </td>
            </tr>
        </table>            
        <!-- Grid (E) --> 
</div>
</body>

</html>

