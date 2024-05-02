<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0013.jsp
*@FileTitle : TerminalInvoiceSummary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0013Event"%>

<%!
	 String tesMakeCode(String code, String splitKey){
	    if(code==null){
	    	code = "";
	    }
	    
	    if(splitKey==null){
	    	splitKey = "";
	    } 
	
		String [] 	tempArr 	= code.split(splitKey);
		String tempStr 	= "";
	
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
	EsdTes0013Event  event = null;						//PDTO(Data Transfer Object including Parameters)
	//ESD_TES_0013EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;					//Server Exception
//	DBRowSet rowSet	  = null;							//DB ResultSet
	String strErrMsg = "";								//Error Message
	int rowCount	 = 0;								//DB ResultSet Count
	String ofcCd = "";
	String cntCd = "";

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	//userId=account.getUsr_id();
	   	//userAuth=account.getAuth();
		ofcCd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";
		cntCd = account.getCnt_cd();

		event = (EsdTes0013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			//	eventResponse = (ESD_TES_0013EventResponse)request.getAttribute("EventResponse");
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

	String addRowBound = "10: ";
	String actionInvStatusBox = JSPUtil.getCodeCombo("tml_inv_sts_cd", 		"01", "width='150'","CD00172", 0, addRowBound);
	String actionRejStatusBox = JSPUtil.getCodeCombo("tml_inv_rjct_sts_cd", "01", "width='150'","CD00173", 0, addRowBound);
	String actionInvDateBox   = JSPUtil.getCodeCombo("inv_date_type",		"01", "width='100'","CD00763", 0, addRowBound);
	
	actionInvStatusBox = tesMakeCode(actionInvStatusBox, "EDI Received");
	actionRejStatusBox = tesMakeCode(actionRejStatusBox, "Auto Rejected");	
	
	/** 2009-10-15 : [PJM-200900072] INVOICE Inquiry conditions - retrieving in case of sucessful Inquiry page  **/
	String pre_cond_inv_no 				= request.getParameter("pre_cond_inv_no")!=null&&!request.getParameter("pre_cond_inv_no").trim().equals("")?request.getParameter("pre_cond_inv_no"):"";
	String pre_cond_inv_date_type 		= request.getParameter("pre_cond_inv_date_type")!=null&&!request.getParameter("pre_cond_inv_date_type").trim().equals("")?request.getParameter("pre_cond_inv_date_type"):"";
	String pre_cond_fm_prd_dt 			= request.getParameter("pre_cond_fm_prd_dt")!=null&&!request.getParameter("pre_cond_fm_prd_dt").trim().equals("")?request.getParameter("pre_cond_fm_prd_dt"):"";
	String pre_cond_to_prd_dt 			= request.getParameter("pre_cond_to_prd_dt")!=null&&!request.getParameter("pre_cond_to_prd_dt").trim().equals("")?request.getParameter("pre_cond_to_prd_dt"):"";
	String pre_cond_yd_cd 				= request.getParameter("pre_cond_yd_cd")!=null&&!request.getParameter("pre_cond_yd_cd").trim().equals("")?request.getParameter("pre_cond_yd_cd"):"";
	String pre_cond_vndr_seq 			= request.getParameter("pre_cond_vndr_seq")!=null&&!request.getParameter("pre_cond_vndr_seq").trim().equals("")?request.getParameter("pre_cond_vndr_seq"):"";
	String pre_cond_cost_ofc_cd 			= request.getParameter("pre_cond_cost_ofc_cd")!=null&&!request.getParameter("pre_cond_cost_ofc_cd").trim().equals("")?request.getParameter("pre_cond_cost_ofc_cd"):"";
	String pre_cond_inv_ofc_cd 			= request.getParameter("pre_cond_inv_ofc_cd")!=null&&!request.getParameter("pre_cond_inv_ofc_cd").trim().equals("")?request.getParameter("pre_cond_inv_ofc_cd"):"";
	String pre_cond_tml_inv_sts_cd 		= request.getParameter("pre_cond_tml_inv_sts_cd")!=null&&!request.getParameter("pre_cond_tml_inv_sts_cd").trim().equals("")?request.getParameter("pre_cond_tml_inv_sts_cd"):"";
	String pre_cond_csr_no 				= request.getParameter("pre_cond_csr_no")!=null&&!request.getParameter("pre_cond_csr_no").trim().equals("")?request.getParameter("pre_cond_csr_no"):"";
	String pre_cond_csr_status 			= request.getParameter("pre_cond_csr_status")!=null&&!request.getParameter("pre_cond_csr_status").trim().equals("")?request.getParameter("pre_cond_csr_status"):"";
	String pre_cond_tml_inv_rjct_sts_cd = request.getParameter("pre_cond_tml_inv_rjct_sts_cd")!=null&&!request.getParameter("pre_cond_tml_inv_rjct_sts_cd").trim().equals("")?request.getParameter("pre_cond_tml_inv_rjct_sts_cd"):"";
%>

<script language="javascript">
	var ofc_cd = '<%=JSPUtil.getNull(ofcCd)%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		
		var actionInvStatusBox	= '';

		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="text" style="display:none"  name="f_cmd">
<input type="text" style="display:none"  name="iPage">
<input type="text" style="display:none"  name="DB_DATE"					value="">
<input type="text" style="display:none"  name="tml_inv_tp_cd"			value="">
<input type="text" style="display:none"  name="is_valid_yd_cd"			value="">
<input type="text" style="display:none"  name="yd_cd_hidden"			value="">
<input type="text" style="display:none"  name="yd_cd_deltflg"			value="">
<input type="text" style="display:none"  name="yd_cd_name"				value="">

<input type="text" style="display:none"  name="is_valid_cost_ofc_cd"	value="">
<input type="text" style="display:none"  name="cost_ofc_cd_hidden"		value="">
<input type="text" style="display:none"  name="cost_ofc_cd_deltflg"		value="">
<input type="text" style="display:none"  name="is_valid_inv_ofc_cd"		value="">
<input type="text" style="display:none"  name="inv_ofc_cd_hidden"		value="">
<input type="text" style="display:none"  name="inv_ofc_cd_deltflg"		value="">

<!--	2009-10-15 : [PJM-200900072] INVOICE Inquiry conditions - retrieving in case of sucessful Inquiry page    -->
<!--	Invoice previous values ( 2009-10-15 )	-->
<input name="pre_cond_inv_no" 				type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_inv_no)%>">
<input name="pre_cond_inv_date_type" 		type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_inv_date_type)%>">
<input name="pre_cond_fm_prd_dt" 			type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_fm_prd_dt)%>">
<input name="pre_cond_to_prd_dt" 			type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_to_prd_dt)%>">
<input name="pre_cond_yd_cd" 				type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_yd_cd)%>">
<input name="pre_cond_vndr_seq" 			type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_vndr_seq)%>">
<input name="pre_cond_cost_ofc_cd" 			type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_cost_ofc_cd)%>">
<input name="pre_cond_inv_ofc_cd" 			type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_inv_ofc_cd)%>">
<input name="pre_cond_tml_inv_sts_cd" 		type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_tml_inv_sts_cd)%>">
<input name="pre_cond_csr_no" 				type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_csr_no)%>">
<input name="pre_cond_csr_status" 			type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_csr_status)%>">
<input name="pre_cond_tml_inv_rjct_sts_cd" 	type="text" style="display:none"  value="<%=JSPUtil.getNull(pre_cond_tml_inv_rjct_sts_cd)%>">

<!--  Add ofc_cd permission-->
<input type="text" style="display:none"  name="no_ofc_cd">
<input type="text" style="display:none"  name="no_yd_cd">
<input type="text" style="display:none"  name="act_tp" value="INV">
<input type="text" style="display:none"  name="auth_ofc_cd" value="">
<input type="text" style="display:none"  name="cre_ofc_cd" value="<%=JSPUtil.getNull(ofcCd)%>">
<input type="text" style="display:none" name="cntCd" id="cntCd" value="<%=JSPUtil.getNull(cntCd)%>">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
	    <button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>	  
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->
<div class='wrap_search'>
	<div class="opus_design_inquiry wFit">		
		<!-- : ( Week ) (S) -->
		<table class="search_in" border="0">
	
		<tr class="h23">
			<th width="90px" class="align_left"><!-- img class="nostar" -->Invoice NO</th>
			<td width="160px"><input type="text" style="width:106px" name="inv_no" maxlength="30" onKeyUp='ComIsAlphabet(this);upper(this);' onKeyPress='enterCheck("retrieveEvent");'></td>
			<th width="100px" class="align_left"><!-- img class="nostar" -->Invoice Date</th>
			<td width="" colspan="5">
				<%=actionInvDateBox%><!-- 
			 	--><input type="text" name="fm_prd_dt" style="width:75px" value="" maxlength=10 onKeyUp='isNum1(this);tes_isNumD(this,"Y");tes_moveFocus(this, to_prd_dt, 10);' onKeyDown='chkInput(this);'><!-- 
			 	--><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>~<!-- 
			 	--><input type="text" name="to_prd_dt" style="width:75px" value="" maxlength=10 onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='chkInput(this);' onBlur='chkPeriod();'><!-- 
			 	--><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button>
			</td>
		</tr>	
	
		<tr class="h23">
			<th class="align_left"><!-- img class="nostar" -->Yard Code</th>
			<td>
				<input type="text" style="width:77px" name="yd_cd" maxlength=7 onKeyUp='upper(this);' onBlur='validateYardCode();' onKeyPress='enterCheck("retrieveEvent");'><!-- 
				 --><button type="button" name="btn_yard" id="btn_yard" class="input_seach_btn"></button>
		  	</td>
			<th class="align_left"><!-- img class="nostar" -->S/P Code</th>
			<td>
				<input type="text" style="width:91px" name="vndr_seq" value="" maxlength="6" onKeyUp='chkInput(this);isNum(this);' onBlur='this.value=tes_lpad(this.value,this.maxLength,"0"); validateVNDRCode();' onKeyPress='enterCheck("retrieveEvent");'><!--
				--><button type="button" name="btn_vndr" id="btn_vndr" class="input_seach_btn"></button><!-- 
			    --><input type="text" style="width:210px" name="vndr_seq_name" id="vndr_seq_name" value="" readonly><!-- 
			    --><input type="text" style="display:none"  name="vndr_seq_hidden" id="vndr_seq_hidden" value=''><!-- 
			    --><input type="text" style="display:none"  name="is_valid_vndr_seq" id="is_valid_vndr_seq" value=''><!-- 
			    --><input type="text" style="display:none"  name="vndr_seq_deltflg" id="vndr_seq_deltflg" value=''>
			</td>
			<th class="align_left"><!-- img class="nostar" -->Cost Code</th>
			<td width="440px"><script type="text/javascript">ComComboObject("cost_code", 1, 300, 0, 0)</script>
			</td>			
		</tr>
		</table>
	
		<table class="search_in" border="0">
		<tr class="h23">
			<th width="90px" class="align_left"><!-- img class="nostar" -->Cost Office</th>
			<td width="160px">
				<input type="text" style="width:77px" maxlength=6 onKeyUp='chkInput(this);upper(this);isAlpha(this);' onBlur='validateCostOFCCode();' name="cost_ofc_cd" id="cost_ofc_cd" onKeyPress='enterCheck("retrieveEvent");'><!--
				--><button type="button" name="btn_cost_ofc_cd" id="btn_cost_ofc_cd" class="input_seach_btn"></button> 
			</td>
			<th width="100px" class="align_left"><!-- img class="nostar" -->Invoice OFC</th>
			<td width="340px">
				<input type="text" style="width:91px" maxlength=6 onKeyUp='isAlpha(this);chkInput(this);upper(this);' onBlur='validateInvOFCCode();' name="inv_ofc_cd" onKeyPress='enterCheck("retrieveEvent");'><!-- 
				--><button type="button" name="btn_inv_ofc_cd" id="btn_inv_ofc_cd" class="input_seach_btn"></button>
			<th width="72px" class="align_left">Invoice STS</th>
			<td><%=actionInvStatusBox%></td>
		<tr class="h23">
			<th width="90" class="align_left"><!-- img class="nostar" -->CSR NO</th>
			<td width="160" ><input type="text" style="width:106px" name="csr_no" maxlength=20 onKeyPress='enterCheck("retrieveEvent");'></td>
			<th width="100" class="align_left"><!-- img class="nostar" -->CSR STS</th>
			<td width="340" >
				<select style="width:120px;" name='csr_status'>
					<option value="AL" selected>All</option>
					<option value="PC">Processing</option>
					<option value="AR">Approval Requested</option>
					<option value="IE">I/F Error</option>
					<option value="RJ">Rejected</option>
					<option value="SC">I/F Success</option>
					<option value="DA">Disapproved</option>
				</select>
			</td>
			<th width="70px" style="padding-left:0" class="align_left">Reject &nbsp;STS</th>
			<td><%=actionRejStatusBox%></td>
		</tr>
		</table>
		<!-- : ( Week ) (E) -->
	</div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class='wrap_result'>
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<!-- Content -->				
			<button type="button" class="btn_normal" name="btng_toinvcorrection" id="btng_toinvcorrection">To Inv. Correction</button><!--
			--><button type="button" class="btn_normal" name="btng_cntrlist" id="btng_cntrlist">CNTR List</button><!--
			--><button type="button" class="btn_normal" name="btng_delete" id="btng_delete">Delete</button><!--
			--><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Execl</button><!--
			--><button type="button" class="btn_normal" name="btng_print" id="btng_print" style="display:none;">Print</button><!--
			--><button type="button" class="btn_normal" name="btng_rejectlift" id="btng_rejectlift">Reject Lift</button>
		</div>
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- 시트영역 -->

</form>
