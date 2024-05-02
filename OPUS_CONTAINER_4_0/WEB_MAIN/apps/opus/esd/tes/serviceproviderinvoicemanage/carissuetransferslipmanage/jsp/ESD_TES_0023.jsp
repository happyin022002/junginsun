<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0023.jsp
*@FileTitle : Terminal invoice CSR Creation - Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/ 
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0023Event"%>
<%
	EsdTes0023Event  event = null;					//PDTO(Data Transfer Object including Parameters)
//	ESD_TES_0023EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//Server Exception
//	DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//Error Message
	int rowCount	 = 0;							//DB ResultSet Count
		
	String ofc_cd  = "";
	String cnt_cd = "";

	try {
 
	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();
	   ofc_cd=account.getOfc_cd(); 
	   cnt_cd =account.getCnt_cd();  
	   
		event = (EsdTes0023Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var cnt_cd = "<%=cnt_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
		document.form.inv_ofc_cd.focus();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="sel_ofc_cd">
<input type="hidden" name="is_valid_vndr_seq">
<input type="hidden" name="vndr_seq_hidden">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
	    --><button type="button" class="btn_normal" name="btng_detail" id="btng_detail">Detail</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
<div class="opus_design_inquiry wFit">		
	<table>
		<colgroup>
			<col width="90">
			<col width="95">
			<col width="105">
			<col width="105">
			<col width="65">
			<col width="100">
			<col width="*">
		</colgroup>
		<tbody>
			<tr>
			<th>Invoice Office</th> 
			<td><input name="inv_ofc_cd" id="inv_ofc_cd" type="text" maxlength="6" style="width:80px" value="<%=ofc_cd%>" onkeypress="enter();" class="input1" readonly></td>
			<th>Confirmed Date</th>
			<td><input name="inv_cfm_dt" id="inv_cfm_dt" type="text" maxlength="10" style="width:75px" value="" onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this);tes_isNumD(this,"Y");' onBlur='isDate1(this);' onkeypress="enter();"><button type="button" class="calendar" name="btns_calendar1" onkeypress="enter();"></button></td>
			<th>Interface</th>
			<td class ="sm"><!-- 
				 --><input type="radio" id="asanogb" name="asanogb" value="A/P" class="trans" checked onkeypress="enter();"><label for="asanogb">To A/P</label><!-- 
				 --><input type="radio" id="asanogb2" name="asanogb" value="ASA" class="trans" onkeypress="enter();" disabled><label for="asanogb2">To ASA</label></td>	
			<td></td>
			<td class="stm"></td>
			</tr>
		</tbody>
	</table>
	<table>
	<colgroup>
			<col width="90">
			<col width="*">
		</colgroup>
		<tbody>
		<tr>
			<th> Payment S/P</th>
			<td><input name="vndr_seq" id="vndr_seq" type="text" maxlength="6" style="width:80px" value="" onKeyUp='isNum(this);' onKeyDown='tes_chkInput(this);' onBlur=' this.value=tes_lpad(this.value,this.maxLength,"0"); validateVendorCode();' onkeypress="enter();"><button type="button" class="input_seach_btn" name="btn_vndr" id="btn_vndr"></button><input name="vndr_seq_name" id="vndr_seq_name" type="text" style="width:670px" readOnly onkeypress="enter();"></td>
		</tr>
		</tbody>
	</table>
</div>
</div>

<div class="wrap_result">
<div class="opus_design_grid">		
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	
	<div style="display:none">	
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</div>
<div class="header_fixed"></div>
</form>
