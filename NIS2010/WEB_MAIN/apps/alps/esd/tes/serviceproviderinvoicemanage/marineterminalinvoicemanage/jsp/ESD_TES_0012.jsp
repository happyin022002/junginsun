<%--
/*=========================================================
*HIPLUSCARD
*@FileName : ESD_TES_0012.jsp
*@FileTitle : TerminalGSTInvoiceSummary
*Open Issues :
*Change history :
*@LastModifyDate : 2017-10-17
*@LastModifier : Lim Jin Young
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0012Event"%>

<%!
	 String tesMakeCode(String code, String splitKey){
	    if(code==null) 		code = "";
	    if(splitKey==null) 	splitKey = ""; 
	
		String [] 	tempArr 	= code.split(splitKey);
		String 		tempStr 	= "";
	
		if(tempArr!=null && tempArr.length>1){
			if(tempArr[0].lastIndexOf("<OPTION")!=-1){
				tempArr[0] = tempArr[0].substring(0,tempArr[0].lastIndexOf("<OPTION"));		
			}
			if(tempArr[1].indexOf("<OPTION")!=-1){	
				tempArr[1] = tempArr[1].substring(tempArr[1].indexOf("<OPTION"), tempArr[1].length());
			}
	
			tempStr = tempArr[0]+ tempArr[1];
		}
	
		if(tempStr.indexOf("<SELECT")==-1){
			tempStr="<SELECT name = 'tml_inv_sts_cd' width='150'> <OPTION  value=''> </OPTION>"+tempStr;
		}
		if(tempStr.indexOf("</SELECT>")==-1){
			tempStr=tempStr+"</SELECT>";
		}
		
		return tempStr;
}
%>
<%
	EsdTes0012Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	//ESD_TES_0012EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
//	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String ofcCd = "";


	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();
	   ofcCd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";

		event = (EsdTes0012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
//	eventResponse = (ESD_TES_0012EventResponse)request.getAttribute("EventResponse");
//	if (eventResponse != null) {
//		rowSet = eventResponse.getRs();
//		if(rowSet != null){
//			 rowCount = rowSet.getRowCount();
//		} // end if
//	} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}


	//3번째 파라메터가 "width='500'"TML_INV_RJCT_STS_CD
	String addRowBound = "10: ";
	String actionInvStatusBox = JSPUtil.getCodeCombo("tml_inv_sts_cd", 		"01", "width='150'","CD00172", 0, addRowBound);
	String actionRejStatusBox = JSPUtil.getCodeCombo("tml_inv_rjct_sts_cd", "01", "width='150'","CD00173", 0, addRowBound);
	String actionInvDateBox   = JSPUtil.getCodeCombo("inv_date_type",		"01", "width='100'","CD00763", 0, addRowBound);
	
	actionInvStatusBox = tesMakeCode(actionInvStatusBox, "EDI Received");
	actionRejStatusBox = tesMakeCode(actionRejStatusBox, "Auto Rejected");
	
	
	/** 2009-10-15 : [PJM-200900072] INVOICE 조회 조건 - 조회 화면 이동시 재조회하기 추가    **/
	String pre_cond_inv_no 				= request.getParameter("pre_cond_inv_no")!=null&&!request.getParameter("pre_cond_inv_no").trim().equals("")?request.getParameter("pre_cond_inv_no"):"";
	String pre_cond_inv_date_type 		= request.getParameter("pre_cond_inv_date_type")!=null&&!request.getParameter("pre_cond_inv_date_type").trim().equals("")?request.getParameter("pre_cond_inv_date_type"):"";
	String pre_cond_fm_prd_dt 			= request.getParameter("pre_cond_fm_prd_dt")!=null&&!request.getParameter("pre_cond_fm_prd_dt").trim().equals("")?request.getParameter("pre_cond_fm_prd_dt"):"";
	String pre_cond_to_prd_dt 			= request.getParameter("pre_cond_to_prd_dt")!=null&&!request.getParameter("pre_cond_to_prd_dt").trim().equals("")?request.getParameter("pre_cond_to_prd_dt"):"";
	String pre_cond_yd_cd 				= request.getParameter("pre_cond_yd_cd")!=null&&!request.getParameter("pre_cond_yd_cd").trim().equals("")?request.getParameter("pre_cond_yd_cd"):"";
	String pre_cond_vndr_seq 			= request.getParameter("pre_cond_vndr_seq")!=null&&!request.getParameter("pre_cond_vndr_seq").trim().equals("")?request.getParameter("pre_cond_vndr_seq"):"";
	String pre_cond_cost_ofc_cd 		= request.getParameter("pre_cond_cost_ofc_cd")!=null&&!request.getParameter("pre_cond_cost_ofc_cd").trim().equals("")?request.getParameter("pre_cond_cost_ofc_cd"):"";
	String pre_cond_inv_ofc_cd 			= request.getParameter("pre_cond_inv_ofc_cd")!=null&&!request.getParameter("pre_cond_inv_ofc_cd").trim().equals("")?request.getParameter("pre_cond_inv_ofc_cd"):"";
	String pre_cond_tml_inv_sts_cd 		= request.getParameter("pre_cond_tml_inv_sts_cd")!=null&&!request.getParameter("pre_cond_tml_inv_sts_cd").trim().equals("")?request.getParameter("pre_cond_tml_inv_sts_cd"):"";
	String pre_cond_csr_no 				= request.getParameter("pre_cond_csr_no")!=null&&!request.getParameter("pre_cond_csr_no").trim().equals("")?request.getParameter("pre_cond_csr_no"):"";
	String pre_cond_csr_status 			= request.getParameter("pre_cond_csr_status")!=null&&!request.getParameter("pre_cond_csr_status").trim().equals("")?request.getParameter("pre_cond_csr_status"):"";
	String pre_cond_tml_inv_rjct_sts_cd = request.getParameter("pre_cond_tml_inv_rjct_sts_cd")!=null&&!request.getParameter("pre_cond_tml_inv_rjct_sts_cd").trim().equals("")?request.getParameter("pre_cond_tml_inv_rjct_sts_cd"):"";
%>
<html>
<head>
<title>TerminalInvoiceSummary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	var ofc_cd = '<%=JSPUtil.getNull(ofcCd)%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		
		var actionInvStatusBox	= '';

		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
//### =========================================================================
//### 탭을 사용하는 화면인 경우 추가한다.
		// InitTab();
//### =========================================================================
		loadPage();
	}
</script>

</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="DB_DATE"					value="">
<input type="hidden" name="tml_inv_tp_cd"			value="">
<input type="hidden" name="is_valid_yd_cd"			value="">
<input type="hidden" name="yd_cd_hidden"			value="">
<input type="hidden" name="yd_cd_deltflg"			value="">
<input type="hidden" name="yd_cd_name"				value="">

<input type="hidden" name="is_valid_cost_ofc_cd"	value="">
<input type="hidden" name="cost_ofc_cd_hidden"		value="">
<input type="hidden" name="cost_ofc_cd_deltflg"		value="">
<input type="hidden" name="is_valid_inv_ofc_cd"		value="">
<input type="hidden" name="inv_ofc_cd_hidden"		value="">
<input type="hidden" name="inv_ofc_cd_deltflg"		value="">

<input type="hidden" name="tml_edi_so_ofc_cty_cd"	value="">
<input type="hidden" name="tml_edi_so_seq"			value="">
<input type="hidden" name="sndr_id"					value="">
<input type="hidden" name="tml_inv_edi_seq"			value="">
<input type="hidden" name="edi_rcv_rule_mn_seq"		value="">

<input type="hidden" name="edi_inv_conv_result_msg"			value="">

<!--	2009-10-15 : [PJM-200900072] INVOICE 조회 조건 - 조회 화면 이동시 재조회하기 추가    -->
<!--	Invoice 조회 화면에서 이동해 왔을 경우 바로 다시 Invoice 조회 화면으로 돌아갔을때 이전 조회 조건들로 자동 조회하기 위한 값들. ( 2009-10-15 )	-->
<input name="pre_cond_inv_no" 				type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_no)%>">
<input name="pre_cond_inv_date_type" 		type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_date_type)%>">
<input name="pre_cond_fm_prd_dt" 			type="hidden" value="<%=JSPUtil.getNull(pre_cond_fm_prd_dt)%>">
<input name="pre_cond_to_prd_dt" 			type="hidden" value="<%=JSPUtil.getNull(pre_cond_to_prd_dt)%>">
<input name="pre_cond_yd_cd" 				type="hidden" value="<%=JSPUtil.getNull(pre_cond_yd_cd)%>">
<input name="pre_cond_vndr_seq" 			type="hidden" value="<%=JSPUtil.getNull(pre_cond_vndr_seq)%>">
<input name="pre_cond_cost_ofc_cd" 			type="hidden" value="<%=JSPUtil.getNull(pre_cond_cost_ofc_cd)%>">
<input name="pre_cond_inv_ofc_cd" 			type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_ofc_cd)%>">
<input name="pre_cond_tml_inv_sts_cd" 		type="hidden" value="<%=JSPUtil.getNull(pre_cond_tml_inv_sts_cd)%>">
<input name="pre_cond_csr_no" 				type="hidden" value="<%=JSPUtil.getNull(pre_cond_csr_no)%>">
<input name="pre_cond_csr_status" 			type="hidden" value="<%=JSPUtil.getNull(pre_cond_csr_status)%>">
<input name="pre_cond_tml_inv_rjct_sts_cd" 	type="hidden" value="<%=JSPUtil.getNull(pre_cond_tml_inv_rjct_sts_cd)%>">

<!-- ofc_cd 별로 권한제어시 추가 -->
<input type="hidden" name="no_ofc_cd">
<input type="hidden" name="no_yd_cd">
<input type="hidden" name="act_tp" value="INV">
<input type="hidden" name="auth_ofc_cd" value="">
<input type="hidden" name="cre_ofc_cd" value="<%=JSPUtil.getNull(ofcCd)%>">
<input type="hidden" name="cre_ofc_cd2" value="<%=JSPUtil.getNull(ofcCd)%>">

<input type="hidden" name="sub_ofc_cd1" value="">
<input type="hidden" name="sub_ofc_cd2" value="">
<input type="hidden" name="ofc_cd" value="">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>





		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     	     	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td>
								<div id="EDILayer01" style="display:none">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_EDIinvoiceview" id="btn_EDIinvoiceview">EDI Invoice View</td>
								<td class="btn1_right"></td></tr></table>
								</div>
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btng_downexcel" id="btng_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="90"><img class="nostar">Invoice No.</td>
					<td width="230"><input type="text" style="width:180" name="inv_no" maxlength="30"  onKeyPress='enterCheck("retrieveEvent");'></td>
					<td width="100"><img class="nostar">Invoice Date</td>
					<td width="450"><%=actionInvDateBox%>&nbsp;<input type="text" name="fm_prd_dt" style="width:75" value="" maxlength=10 onKeyUp='isNum1(this);tes_isNumD(this,"Y");tes_moveFocus(this, to_prd_dt, 10);' onKeyDown='chkInput(this);'>
					<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">
					~&nbsp;<input type="text" name="to_prd_dt" style="width:75" value="" maxlength=10 onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='chkInput(this);' onBlur='chkPeriod();'>
					<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					<td width="52"><img class="nostar">Hold</td>
					<td><input type="checkbox" name="hld_flg" value="Y" class="trans"></td>
					</tr>


				<tr class="h23">
					<td><img class="nostar">CSR No.</td>
					<td><input type="text" style="width:180" name="csr_no" maxlength=20 onKeyPress='enterCheck("retrieveEvent");'></td>					
					<td><img class="nostar">S/P Code</td>
					<td colspan="3"><input type="text" style="width:91" value="" maxlength=6 name="vndr_seq" onKeyUp='chkInput(this);isNum(this);' onBlur='validateVNDRCode();' onKeyPress='enterCheck("retrieveEvent");'>
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vndr">
						<input type="hidden" name="vndr_seq_hidden" value=''><input type="hidden" name="is_valid_vndr_seq" value=''><input type="hidden" name="vndr_seq_deltflg" value=''><input type="text" style="width:215" name="vndr_seq_name" value="" readonly>
					</td></tr>
				</table>

				<table class="search_in" border="0">
				<tr class="h23">
					<td width="90"><img class="nostar">Cost Office</td>
					<td width="230" class="stm"><input type="text" style="width:77" maxlength=6 onKeyUp='chkInput(this);upper(this);isAlpha(this);' onBlur='validateCostOFCCode();' name="cost_ofc_cd" onKeyPress='enterCheck("retrieveEvent");'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cost_ofc_cd">&nbsp;<input name="sub_office1" type="checkbox" value="" class="trans" onClick="javascript:getSubOffice1();">&nbsp; Incl. Sub OFC</td>									
					<td width="100"><img class="nostar">Invoice Office</td>
					<td width="340" class="stm"><input type="text" style="width:91" maxlength=6 onKeyUp='isAlpha(this);chkInput(this);upper(this);' onBlur='validateInvOFCCode();' name="inv_ofc_cd" value="<%=ofcCd%>" onKeyPress='enterCheck("retrieveEvent");'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_inv_ofc_cd">&nbsp;<input name="sub_office2" type="checkbox" value="" class="trans" onClick="javascript:getSubOffice2();">&nbsp;Incl. Sub OFC</td>
					<td width="100"><img class="nostar">Invoice Status</td>
					<td><%=actionInvStatusBox%></td>					
				<tr class="h23">
					<td><img class="nostar">Yard Code</td>
					<td><input type="text" style="width:77" name="yd_cd" maxlength=7 onKeyUp='upper(this);' onBlur='validateYardCode();' onKeyPress='enterCheck("retrieveEvent");'>	
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_yard">				
					<td><img class="nostar">CSR Status</td>
					<td>
						<select style="width:114;" name='csr_status'>
							<option value="AL" selected>All</option>
							<option value="PC">Processing</option>
							<option value="AR">Approval Requested</option>
							<option value="IE">I/F Error</option>
							<option value="RJ">Rejected</option>
							<option value="SC">I/F Success</option>
							<option value="DA">Disapproved</option>
						</select>
					</td>
					<td width="100" style="padding-left:0"><img class="nostar">Reject Status</td>
					<td><%=actionRejStatusBox%></td>
				</tr>
				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">

			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
			<!-- : ( Grid : Week ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>