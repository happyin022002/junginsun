<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0042.jsp
*@FileTitle : MNR Invoice Inquiry
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.09.16
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.16 함형석
* 1.0 Creation
* CHM-201535636 : Split01-EAC Auto Audit - TRS 설계 및 개발 요청 
  EAS MNR 자동심사에서 link되도록 수정 2015.07.02 박정민
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.event.EesMnr0042Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0042Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strRhq_ofc_cd         = "";
	Logger log = Logger.getLogger("com.hanjin.apps.test.test");
	
	String fromSys = ((request.getParameter("from_sys")==null )?"":request.getParameter("from_sys"));
	String invNo = ((request.getParameter("inv_no")==null )?"":request.getParameter("inv_no"));          
	String invOfcCd = ((request.getParameter("inv_ofc_cd")==null )?"":request.getParameter("inv_ofc_cd"));          
	String woNo = ((request.getParameter("wo_no")==null )?"":request.getParameter("wo_no"));          
	String invCfmDt = ((request.getParameter("inv_cfm_dt")==null )?"":request.getParameter("inv_cfm_dt"));          


	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();
		
		event = (EesMnr0042Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">   
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=strRhq_ofc_cd %>';
	
	function setupPage(){    
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>


<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="key_value">  
<input type="hidden" name="inv_sch_type_code">
<input type="hidden" name="input_date_type_code">
<input type="hidden" name="input_type_code">
<input type="hidden" name="mnr_inv_sts_cd">
<input type="hidden" name="from_sys" value="<%=fromSys%>">        	
<input type="hidden" name="param_inv_no" value="<%=invNo%>">
<input type="hidden" name="param_inv_ofc_cd" value="<%=invOfcCd%>">
<input type="hidden" name="param_wo_no" value="<%=woNo%>">
<input type="hidden" name="param_inv_cfm_dt" value="<%=invCfmDt%>">



<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
        <!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table> 
		<!--Page Title, Historical (E)-->        
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Date</td>
					<td width="103"><script language="javascript">ComComboObject('combo1',1, 102 , 0,1);</script></td>
					<td width="220"><input type="text" style="width:80" class="input1" name="from_dt" dataformat="ymd" cofield="to_dt">&nbsp;~&nbsp;<input type="text" style="width:80" class="input1" name="to_dt" dataformat="ymd" cofield="from_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar"></td>
					<td width="75">Input Type</td>
					<td width="108"><script language="javascript">ComComboObject('combo2',1, 90 , 0,0);</script></td>					
					<td width="55">Status</td>
					<td width="100"><script language="javascript">ComComboObject('combo3',1, 90 , 0,0);</script></td>
					<td width="55">INV OFC</td>
					<td width="65"><input type="text" style="width:55" class="input"  name="inv_ofc_cd" value="<%=strOfc_cd %>" maxlength="6" dataformat="engup">&nbsp;</td>
					<td width="60">W/O OFC</td>
					<td width=""><input type="text" style="width:55" class="input" name="cost_ofc_cd" dataformat="engup" maxlength="6" >&nbsp;</td>

				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="102">Service Provider</td>
					<td width="280"><input type="text" name="vndr_seq" style="width:57;text-align:center" class="input" maxlength="6" dataformat="engup">&nbsp;<img name="btn_provider_popup" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" name="vndr_lgl_eng_nm" style="width:178" class="input2" readOnly="true">
								</td>
					<td width="53">INV No.</td>
					<td width="140"><input type="text" style="width:97" dataformat="engup" class="input" name="inv_no">&nbsp;<img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btn_inv_no_multy"></td>
					<td width="55">W/O No.</td>
					<td width="150"><input type="text" style="width:90" dataformat="engup" class="input" name="inv_wo_no">&nbsp;<img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btn_wo_no_multy"></td>
					<td width="55">CSR No.</td>
					<td width="" style="padding-left:1"><input type="text" style="width:90" dataformat="engup" class="input" name="csr_no">&nbsp;<img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btn_csr_no_multy"></td>
				</tr>
				</table>
						
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>
		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s"> M&R Invoice List</td></tr>
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
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DetailRetrieve">Invoice Detail(s)</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
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
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">  M&R Invoice Detail Information</td></tr>
				</table>
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
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
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcelDtl">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
		<!--biz page (E)-->
	

	</td></tr>
		</table>
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
</form>
</body>
</html>
