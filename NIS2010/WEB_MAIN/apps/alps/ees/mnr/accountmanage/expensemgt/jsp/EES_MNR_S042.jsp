<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S042.jsp
*@FileTitle : MNR Invoice Inquiry
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.09.21
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.21 함형석
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.event.EesMnrS042Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnrS042Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String strVndr_seq		= "";
	String strVndr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();
		
		event = (EesMnrS042Event)request.getAttribute("Event");
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
<title>&nbsp;Invoice Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--MNR 공용 사용  -->       
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



<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
        <!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
					    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Inquiry</td></tr>
		</table> 
		<!--Page Title, Historical (E)-->        
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
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
				<table class="search" border="0" style="width:979"> 
				<tr class="h23">
					<td width="80">Date</td>
					<td width="102"><script language="javascript">ComComboObject('combo1',1, 100 , 0,1);</script></td>
					<td width="300"><input type="text" style="width:80" class="input1" name="from_dt">&nbsp;~&nbsp;<input type="text" style="width:80" class="input1" name="to_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar"></td>
    				<td width="65">Status</td>
					<td width="140"><script language="javascript">ComComboObject('combo3',1, 100 , 0,0);</script></td>
					<td width="65">INV OFC</td>
					<td width=""><input type="text" style="width:90" class="input2" readOnly="true" name="user_ofc_cd" value="<%=strOfc_cd %>">&nbsp;</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979"> 
				<tr class="h23">
					<td width="80">S/Provider</td>
					<td width="220"><input type="text" name="vndr_seq" style="width:57;text-align:center" class="input2" value="<%=strVndr_seq %>" readOnly="true">&nbsp;<input type="text" name="vndr_lgl_eng_nm" style="width:121" class="input2" value="<%=strVndr_nm %>" readOnly="true">
								</td>
					<td width="55">INV No.</td>
					<td width="127"><input type="text" style="width:80" dataformat="engup" class="input" name="inv_no">&nbsp;<img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btn_inv_no_multy"></td>
					<td width="65">W/O No.</td>
					<td width="140"><input type="text" style="width:80" dataformat="engup" class="input" name="inv_wo_no">&nbsp;<img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btn_wo_no_multy"></td>
					<td width="65">CSR No.</td>
					<td width=""><input type="text" style="width:70" dataformat="engup" class="input" name="csr_no">&nbsp;<img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btn_csr_no_multy"></td>
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
					<td class="btn2" name="btn_DetailRetrieve">Inv&nbsp;Detail(s)</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcel">Down&nbsp;Excel</td>
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

			</td></tr>
		</table>
		<!--biz page (E)-->
	

	</td></tr>
		</table>
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
</form>
</body>
</html>
