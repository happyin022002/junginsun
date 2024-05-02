<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0100.jsp
*@FileTitle : CSR I/F Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	String ofc_cd = "";
	String cnt_cd  = "";
	
	try {
	   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   ofc_cd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";
	   cnt_cd = account.getCnt_cd()!=null&&!account.getCnt_cd().equals("")?account.getCnt_cd():"";
	}catch(Exception e) {
		out.println(e.toString());
	}

	String readOnlyYn 	= null;
	String csrNo 		= null;
	readOnlyYn 			= JSPUtil.getParameter(request,"READONLY_YN".trim(),"");
	csrNo				= JSPUtil.getParameter(request,"CSR_NO".trim(),"");
	
%>
<script language="javascript">
	var cnt_cd = "<%=cnt_cd%>";
	var READONLY_YN = "<%=readOnlyYn%>";
	var OFC_CD = "<%=ofc_cd%>";
    function setupPage(){
	    loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="csr_no">
<input type="hidden" name="DB_DATE" value=''>
<input type="hidden" name="aproSeqKey">
<input type="hidden" name="apro_step">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	    <div id='btng_csrcancel_yn' style="display:inline">
	    	--><button type="button" class="btn_normal" name="btng_print" id="btng_print">Down Excel</button><!--
	    	--><!--<button type="button" class="btn_normal" name="btng_editapprovalstep" id="btng_editapprovalstep">Edit Approval Step</button>--><!--
	    	--><button type="button" class="btn_normal" name="btng_viewapprovalstep" id="btng_viewapprovalstep">View Approval Step</button><!--
	    	--><button type="button" class="btn_normal" name="btng_csrformat" id="btng_csrformat">CSR Format</button><!--
	    	--><button type="button" class="btn_normal" name="btng_invoicelistinquiry" id="btng_invoicelistinquiry">Invoice List Inquiry</button><!--
	    	--><button type="button" class="btn_normal" name="btng_csrcancel" id="btng_csrcancel">CSR Cancel</button>
	    </div>
	    <div id='btng_csrcancel_yn' style="display:none">
	    	--><button type="button" class="btn_normal" name="btng_print" id="btng_print">Print</button>
	    	--><button type="button" class="btn_normal" name="btng_editapprovalstep" id="btng_editapprovalstep">Edit Approval Step</button><!--
	    	--><button type="button" class="btn_normal" name="btng_viewapprovalstep" id="btng_viewapprovalstep">View Approval Step</button><!--
	    	--><button type="button" class="btn_normal" name="btng_csrformat" id="btng_csrformat">CSR Format</button><!--
	    	--><button type="button" class="btn_normal" name="btng_invoicelistinquiry" id="btng_invoicelistinquiry">Invoice List Inquiry</button>
	    </div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
<!-- 검색영역 -->
<div class="opus_design_inquiry wFit">		
	<table>
		<tr class="h23"><th width="1"><img class="nostar">Invoice OFC</th>
			<td width="95px"><input name="ofc_cd" type="text" maxlength=6 style="width:80px" class="input1" value="<%=ofc_cd%>" onKeyUp='tes_isApNum(this); this.value=this.value.toUpperCase();' onKeyDown='tes_chkInput(this); this.value=this.value.toUpperCase();' readonly></td>
			<th width="29px">Date</th>
			<td width="159px">
			<select style="width:150px;" name='dt_status'>
				<option value="AR">Approval Requested</option>
				<option value="AV">Approved or Disapproved</option>
				<option value="IU">I/F Status Updated</option>			
			</select><!-- 
			--><input name="fm_eff_dt" type="text" style="width:75" maxlength=10 value="" onKeyUp='tes_isNumD(this,"Y"); tes_moveFocus(this,this.form.to_eff_dt,10);' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='validateDateObj(this);'><!-- 
			--><button type="button" class="calendar" name="btns_calendar1"></button>
			~
			<input name="to_eff_dt" type="text" style="width:75" maxlength=10 value="" onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='validateDateObj(this);'><!-- 
			--><button type="button" class="calendar" name="btns_calendar2"></button>
			<th width="65px">I/F Status</th>
			<td width="158px">
			<select style="width:140px;" name='if_status'>
				<option value="AL" selected>All</option>
				<option value="AR">Approval Requested</option>
				<option value="SD">Sending</option>
				<option value="DA">Disapproved</option>
				<option value="IE">I/F Error</option>
				<option value="RJ">A/P Rejected</option>
				<option value="SC">I/F Success</option>
			</select>
			</td>
			<th width="">CSR No.</th>
			<td width=""><input name="search_csr_no" type="text" maxlength=20 style="width:100px" value="<%=csrNo%>" onKeyPress='tes_enterCheck("retrieve");' onBlur='this.value=this.value.trim();'></td>
		</tr>
	</table>
</div>
<!-- 검색영역 -->
</div>

<div class="wrap_result">
	<!-- 시트영역 -->
	<div class="opus_design_grid">	
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- 시트영역 -->
</div>
</form>

<DIV style="display:none;">
	 <script language="javascript">ComSheetObject('sheet2');</script>
	 <script language="javascript">ComSheetObject('sheet3');</script>
</DIV>