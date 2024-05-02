<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_2007.jsp
*@FileTitle : Irregular Inquiry
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
<%@ page import="com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.event.EsdTes2007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes2007Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.GuaranteeManage.IrregularManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsdTes2007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// To initialize the imported data extracted from the server loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="DB_DATE" id="DB_DATE"		value="" >
<input type="hidden" name="is_valid_gnte_cust_cd">
<input type="hidden" name="gnte_cust_cd_hidden">
<input type="hidden" name="cre_ofc_cd" id="cre_ofc_cd"	value="<%=strOfc_cd%>">
<input type="hidden" name="usr_id" 		value="<%=strUsr_id%>">

<!-- DEPART Validation Check Use -->
<input type="hidden" name="is_valid_ofc_cd">
<input type="hidden" name="ofc_cd" id="ofc_cd">
<%--  Temporary Cost Office Code --%>
<input type="hidden" name="yd_cd" value='___'>

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_guarantee" id="btn_guarantee">Guarantee</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_irregular" id="btn_irregular">Irregular</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table border="0">
			<tr class="h23">
				<th width="120px">Reference Number</th>
				<td width="150px"><!--
				--><input type="text" style="width:100px" name="irr_no" id="irr_no" maxlength="12" OnKeyUp="isApNum2(this)"><!--
				--><button type="button" class="input_seach_btn" name="btn_refno"></button>
				</td>
				<th width="80px">Office Code</th>
				<td width="80px"><input type="text" style="width:70px" name="cost_ofc_cd" value="<%=strOfc_cd%>" maxlength="6" OnKeyUp='tes_isApNum(this);upper(this);' OnBlur='validateDeptNo();'></td>
				<th width="60px">USER ID</th>
				<td width="85px"><input type="text" style="width:75px" name="cre_usr_id" id="cre_usr_id"  maxlength="20"></td>
				<th width="40px">Type</th>
				<td width="80px">
					<select name="gnte_tp_cd" id="gnte_tp_cd">
						<option value=""></option>
						<option value="ST">Storage</option>
						<option value="FL">Flip</option>
						<option value="CY">Other</option>
					</select>
				</td>
				<th width="90px">Creation Date</th>
				<td width="" class="stm">
					<input type="text" style="width:75px" name="fm_cre_dt" id="fm_cre_dt" maxlength="10" class="input1" dataformat="ymd" onKeyUp='tes_isNumD(this,"Y"); tes_moveFocus(this,this.form.to_cre_dt,10);' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' OnBlur='this.value=ComGetMaskedValue(this.value, "ymd");'><button type="button" class="calendar" name="btns_calendar1"></button><!--
					-->~&nbsp;<input type="text" style="width:75px" name="to_cre_dt" id="to_cre_dt" maxlength="10" class="input1" dataformat="ymd" onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' OnBlur='this.value=ComGetMaskedValue(this.value, "ymd");'><button type="button" class="calendar" name="btns_calendar2"></button>
				</td>
			</tr>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_inquiry wFit">
		<table class="search_in" border="0" style='display:none'>
			<tr class="h23">
				<td width="105px" align='right'>Total Count&nbsp;</td>
				<td width="150px" align='left'><input type="text" style="width:100px" name="ttl_cnt" class="input2" readonly></td>
				<td width="105px" align='right'>Total Amount&nbsp;</td>
				<td width="150px" align='left'><input type="text" style="width:100px" name="ttl_amt" class="input2" readonly></td>
				<td width="500px"></td>
			</tr>
		</table>
	</div>
</div>
<div class="header_fixed"></div>
<!-- <div style='display:'>
Header Info Grid  (S)
<table width="100%"  id="mainTable">
	<tr>
		<td width="100%">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table>
Header Info Grid (E)

</div> -->

<!-- Outer Table (E)-->

</form>
