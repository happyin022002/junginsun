<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0109.jsp
*@FileTitle : Invoice Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki 			1.0	 최초 생성
* 2009-09-14 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0109Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0109Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd = "";
	String cnt_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProcessManage.InvoiceManage");
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	ofc_cd = account.getOfc_cd();
	cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd));

/*
	try {
	   	//SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdTpb0109Event)request.getAttribute("Event");
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
	
	String readOnlyYn = "";
	String s_state = "";
	readOnlyYn = JSPUtil.getNull( request.getParameter("ReadOnlyYn") );
	s_state = JSPUtil.getNull( request.getParameter("s_state") );
	//out.println(s_state);
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
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="iPage">
<input type="hidden" name="ReadOnlyYn" value=<%=readOnlyYn%>>
<input type="hidden" name="state" value=<%=s_state%>>
<input type="hidden" name="onchange_flag">
<input type="hidden" name="ibflag">
<input type="hidden" name="s_cnt_cd" value="<%=cnt_cd %>">


<!-- Outer Table (S)-->
	<!-- ______________________________________________ Start Page Navigation & Title -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr>
			<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
		</tr>
		<tr>
			<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
		</tr>
	</table>
	<!-- |______________________________________________ End Page Navigation & Title -->
	

	<table width="100%" border="0">
		<tr>
			<td class="top"></td>
		</tr>
		<tr>
			<td valign="top">
	
				<!-- TABLE '#D' : ( Button : Main ) (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr>
						<td class="btn1_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td>
					</tr>
				</table>
		    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
		
				<!-- : ( Search Options :  ) (S) -->
		     	<table class="search" border="0">
		       		<tr>
		       			<td class="bg">
							<table class="height_10">
								<tr>
									<td></td>
								</tr>
							</table>
		
							<table>
								<tr>
									<td>
										<table class="search" border="0">
											<tr class="h23">
												<td width="100">Office</td>
												<td width="100"><input type="text" class="input2" style="width:55;" name="s_inv_iss_ofc_cd" readOnly value=<%=ofc_cd%>></td>
												<td width="100"></td>
												<td width="100"></td>
												<td id="t_vat" style="display:inline" width="120">&nbsp;VAT Rate</td>
												<td id="s_vat" class="sm" width=""><input type="text" style="width:55;ime-mode:disabled;" name="vat_xch_rt" maxlength="15" dir="rtl"> %</td>
											</tr>
											<tr class="h23">
												<td width="100">Company Name</td>
												<td width="300" colspan="3"><input type="text" style="width:280;" value="SM LINE CORPORATION" onblur="ComChkLenByByte(this,50,'Company Name')" name="co_nm" maxlength="50"></td>
												<td width="120">"Bill To" Location</td>
												<td><%=JSPUtil.getCodeCombo("bil_to_loc_div_cd", "", "style='width:71'", "CD00871", 0, "001: :&lt;&lt;Select&gt;&gt;")%></td>
											</tr>
											<tr class="h23">
												<td width="100">Office Address</td>
												<td width="" colspan="5"><input type="text" style="width:570;" onblur="ComChkLenByByte(this,200,'Office Address')" name="ofc_addr" maxlength="200"></td>
											</tr>
											<tr class="h23">
												<td width="100">Tel No.</td>
												<td width="" colspan="5"><input type="text" style="width:280;" name="ofc_phn_no" maxlength="20"></td>
											</tr>
											<tr class="h23">
												<td width="100">Fax No.</td>
												<td width="" colspan="5"><input type="text" style="width:280;" name="ofc_fax_no" maxlength="20"></td>
											</tr>
											<tr class="h23">
												<td width="100"></td>
												<td width="" colspan="5"></td>
											</tr>
										</table>
									</td>
									<td>
										<table id="ida_info" class="search" border="0">
											<tr class="h23">
												<td width="120">State Code</td>
												<td width=""><input type="text" class="input2" style="width:55;" name="ida_ste_cd" readOnly value=""></td>
											</tr>
											<tr class="h23">
												<td width="120">GSTIN/UIN</td>
												<td width=""><input type="text" class="input2" style="width:180;" name="ida_gst_rgst_no" readOnly value=""></td>
											</tr>
											<tr class="h23">
												<td width="120">PAN No.</td>
												<td width=""><input type="text" class="input2" style="width:180;" name="ida_pan_no" readOnly value=""></td>
											</tr>
											<tr class="h23">
												<td width="120">Bank Account No.</td>
												<td width=""><input type="text" class="input2" style="width:180;" name="ida_bank_acct_no" readOnly value=""></td>
											</tr>
											<tr class="h23">
												<td width="120">IFSC Code</td>
												<td width=""><input type="text" class="input2" style="width:180;" name="ida_ifsc_cd" readOnly value=""></td>
											</tr>
											<tr class="h23">
												<td width="120">CIN No.</td>
												<td width=""><input type="text" class="input2" style="width:180;" name="ida_tax_cin_no" readOnly value=""></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
				
							<table class="search" border="0" width="100%">
								<tr class="h23">
									<td width="95">Remark 1</td>
									<td width=""><textarea type="text" style="width:100%" rows="11" name="inv_rmk1" onblur="ComChkLenByByte(this,4000,'Remark 1')"></textarea></td>
								</tr>
								<tr class="h23">
									<td width="95">Remark 2</td>
									<td width=""><textarea type="text" style="width:100%" rows="11" name="inv_rmk2" onblur="ComChkLenByByte(this,4000,'Remark 2')"></textarea></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<!-- : ( Search Options :  ) (E) -->
			</td>
		</tr>
	</table>
<!-- Outer Table (E)nd -->
<div style="display:inline">
	<table width="100%" id="mainTable">
             <tr><td>
                    <script language="javascript">ComSheetObject('sheet1');</script>
             </td></tr>
	</table>
</div>

<!-- : ( Button : Sub ) (S) -->

	<table class="height_5">
		<tr>
			<td></td>
		</tr>
	</table>

<!-- : ( Button : Sub ) (S) -->
	<table width="100%"  class="sbutton"  >
		<tr>
			<td  style="padding:0px; text-align:center; padding:0; background-color:#EFEFF6; height:28; vertical-align:middle;text-align:center;" >
				<table border="0" cellpadding="0" cellspacing="0">
				    <tr>
						<!-- Repeat Pattern -->
						<% if ( !readOnlyYn.equals("N") ) { %>
						<td><table border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
						<% } %>
						
						<% if (s_state.equals("Y")){ %>
							<td><table border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
						<% } %> 
						<!-- Repeat Pattern -->
		 			</tr>
				</table>
			</td>
		</tr>
	</table> 
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>
