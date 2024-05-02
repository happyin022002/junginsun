<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0123.jsp
*@FileTitle : Invoice Sheet Set
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-26
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-10-23 Kim Jin-seung 		1.0  최초 생성
* 2009-10-26 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0123Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0123Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StatusInquiry.PerformanceInquiry");
	
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	
/*
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTpb0123Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
*/
	String ofc_cd = null;

	String readOnlyYn = "";
	String s_state = "";
	readOnlyYn = JSPUtil.getNull( request.getParameter("ReadOnlyYn") );
	s_state = JSPUtil.getNull( request.getParameter("s_state") );
	if ( !readOnlyYn.equals("N") ) {
		ofc_cd = account.getOfc_cd();
	} else {
		ofc_cd = JSPUtil.getNull( request.getParameter("s_sheet_set_ofc_cd") );
	}
	

%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="iPage">
<input type="hidden" name="ReadOnlyYn" value=<%=readOnlyYn%>>
<input type="hidden" name="iPage">

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
<% if (s_state.equals("Y")){ %>
<!-- OUTER - POPUP (S)tart -->
	<table width="100%" class="popup" cellpadding="10" border="0">
		<tr><td class="top"></td></tr>
		<tr><td valign="top">
		
	<!-- ______________________________________________ Start Page Navigation & Title -->
	
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> JO TPB Invoice Setting</td></tr>
		</table>
	<!-- |______________________________________________ End Page Navigation & Title -->
	
	
			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr><td class="btn1_bg">
	
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
	
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
	
							</tr></table>
	
					</td></tr>
			</table>
	    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
	
			<!-- : ( Search Options :  ) (S) -->
	     	<table class="search" border="0">
	       	<tr><td class="bg">
	
				<table class="height_10"><tr><td></td></tr></table>
	
				<!-- : ( Invoice No. ) (S) -->
				<table class="search" border="0">
				<tr class="h23">
					<td width="">Office</td>
					<td width="" style="padding-left:3;"><input type="text" style="width:55;" name="s_inv_iss_ofc_cd" readonly value=<%=ofc_cd%>></td>
					<td width="">&nbsp;VAT Rate</td>
					<td class="sm"><input type="text" style="width:55;" name="s_vat_xch_rt" maxlength="15" dir="rtl"> %</td>
				</tr>
				<tr class="h23">
					<td width="98">Company Name</td>
					<td width="277" style="padding-left:3;"><input type="text" style="width:250;" value="SM LINE CORPORATION" onblur="ComChkLenByByte(this,50,'Company Name')" name="s_co_nm" maxlength="50"></td>
					<td width="111">"Bill To" Location</td>
					<td><%=JSPUtil.getCodeCombo("s_bil_to_loc_div_cd", "", "style='width:71'", "CD00871", 0, "001: :&lt;&lt;Select&gt;&gt;")%></td>
				</tr>
				</table>
	
				<table class="search" border="0">
					<tr class="h23">
						<td width="98">Office Address</td>
						<td width=""><input type="text" style="width:459;" onblur="ComChkLenByByte(this,200,'Office Address')" name="s_ofc_addr" maxlength="200"></td></tr>
					<tr class="h23">
						<td width="98">Tel No.</td>
						<td width=""><input type="text" style="width:459;" name="s_ofc_phn_no" maxlength="20"></td></tr>
					<tr class="h23">
						<td width="98">Fax No.</td>
						<td width=""><input type="text" style="width:459;" name="s_ofc_fax_no" maxlength="20"></td></tr>
					<tr><td class="line_bluedot" colspan="2"></td></tr>
				</table>
	
				<table class="search" border="0">
				<tr class="h23">
					<td width="98">Remark 1</td>
					<td width="" style="padding-left:2;"><textarea type="text" style="width:459" rows="5" name="s_inv_rmk1" onblur="ComChkLenByByte(this,4000,'Remark 1')"></textarea></td></tr>
				<tr class="h23">
					<td width="98">Remark 2</td>
					<td width="" style="padding-left:2;"><textarea type="text" style="width:459" rows="10" name="s_inv_rmk2" onblur="ComChkLenByByte(this,4000,'Remark 2')"></textarea></td></tr>
				</table>
	
				<!-- : ( Invoice No. ) (E) -->
	
				</td></tr>
			</table>
			<!-- : ( Search Options :  ) (E) -->
	
	</td></tr>
	</table>
<!-- OUTER - POPUP (E)nd -->

<%} else{ %>
<!-- Outer Table (S)-->
	<!-- ______________________________________________ Start Page Navigation & Title -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!-- |______________________________________________ End Page Navigation & Title -->
	

	<table width="100%" border="0">
		<tr><td class="top"></td></tr>
		<tr><td valign="top">
		
			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr><td class="btn1_bg">
	
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
	
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
	
							</tr></table>
	
					</td></tr>
			</table>
	    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
	
			<!-- : ( Search Options :  ) (S) -->
	     	<table  width="100%" class="search" border="0">
	       	<tr><td class="bg">
	
				<table class="height_10"><tr><td></td></tr></table>
	
				<!-- : ( Invoice No. ) (S) -->
				<table class="search" border="0">
					<tr class="h23">
						<td width="">Office</td>
						<td width="" style="padding-left:3;">
							<input type="text" style="width:55;" name="s_inv_iss_ofc_cd" readonly value=<%=ofc_cd%>/>
						</td>						<td width="">&nbsp;VAT Rate</td>
						<td class="sm"><input type="text" style="width:55;" name="s_vat_xch_rt" maxlength="15" dir="rtl"> %</td>
					</tr>
					<tr class="h23">
						<td width="98">Company Name</td>
						<td width="277" style="padding-left:3;"><input type="text" style="width:250;" value="SM LINE CORPORATION" onblur="ComChkLenByByte(this,50,'Company Name')" name="s_co_nm" maxlength="50"></td>
						<td width="111">"Bill To" Location</td>
						<td><%=JSPUtil.getCodeCombo("s_bil_to_loc_div_cd", "", "style='width:71'", "CD00871", 0, "001: :&lt;&lt;Select&gt;&gt;")%></td>
					</tr>
					
				</table>
				<table class="search" border="0">
					<tr class="h23">
						<td width="98">Office Address</td>
						<td width="" style="padding-left:3;">
							<input type="text" style="width:459;" onblur="ComChkLenByByte(this,200,'Office Address')" name="s_ofc_addr" maxlength="200">
						</td>
					</tr>
					<tr class="h23">
						<td width="98">Tel No.</td>
						<td width="" style="padding-left:3;"><input type="text" style="width:459;" name="s_ofc_phn_no" maxlength="20"></td>
					</tr>
					<tr class="h23">
						<td width="98">Fax No.</td>
						<td width="" style="padding-left:3;"><input type="text" style="width:459;" name="s_ofc_fax_no" maxlength="20"></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr><td class="line_bluedot" colspan="2"></td></tr>
				</table>
				<table class="search" border="0">
					<tr class="h23">
						<td width="98">Remark 1</td>
						<td width="" style="padding-left:2;"><textarea type="text" style="width:100%" rows="5" name="s_inv_rmk1" onblur="ComChkLenByByte(this,4000,'Remark 1')"></textarea></td></tr>
					<tr class="h23">
						<td width="98">Remark 2</td>
						<td width="" style="padding-left:2;"><textarea type="text" style="width:100%" rows="10" name="s_inv_rmk2" onblur="ComChkLenByByte(this,4000,'Remark 2')"></textarea></td></tr>
				</table>
	
				<!-- : ( Invoice No. ) (E) -->
	
				</td></tr>
			</table>
			<!-- : ( Search Options :  ) (E) -->
	
	</td></tr>
	</table>
<!-- Outer Table (E)nd -->
<%}%>



<table class="height_10"><tr><td></td></tr></table>

		<div style="display:none">
				<table width="100%" id="mainTable">
		              <tr><td>
		                     <script language="javascript">ComSheetObject('sheet1');</script>
		              </td></tr>
				</table>
		</div>



<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<% if ( !readOnlyYn.equals("N") ) { %>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<% } %>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
</td></tr></table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>