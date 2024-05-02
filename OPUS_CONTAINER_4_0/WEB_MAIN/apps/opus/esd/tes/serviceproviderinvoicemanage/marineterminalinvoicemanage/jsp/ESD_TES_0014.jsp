<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0014.jsp
*@FileTitle : Terminal Invoice Detail Retrieve
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
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0014Event"%>
<%
	EsdTes0014Event  event = null;						//PDTO(Data Transfer Object including Parameters)
	//ESD_TES_0014EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;					//Server Exception
	DBRowSet rowSet	  = null;							//DB ResultSet
	String strErrMsg = "";								//Error Message
	int rowCount	 = 0;								//DB ResultSet Count
	String ofcCd = "";


	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();
	   ofcCd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";

		event = (EsdTes0014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
	/*
	eventResponse = (ESD_TES_0014EventResponse)request.getAttribute("EventResponse");
	if (eventResponse != null) {
		rowSet = eventResponse.getRs();
		if(rowSet != null){
			 rowCount = rowSet.getRowCount();
		} // end if
	} // end if
	*/
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}


	//3번째 파라메터가 "width='500'"TML_INV_RJCT_STS_CD
	String addRowBound = "10: ";
	String actionInvDateBox   = JSPUtil.getCodeCombo("inv_date_type", "01", "width='100'", "CD01364", 0, addRowBound);
//64", 0, addRowBound);
%>

<script type="text/javascript">
	var ofc_cd = '<%=JSPUtil.getNull(ofcCd)%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";

		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="DB_DATE"					value="">
<input type="hidden" name="tml_inv_tp_cd"			value="">
<input type="hidden" name="is_valid_yd_cd"			value="">
<input type="hidden" name="yd_cd_hidden"			value="">
<input type="hidden" name="yd_cd_deltflg"			value="">
<input type="hidden" name="yd_cd_name"				value="">
<input type="hidden" name="yd_cd"					value="">

<input type="hidden" name="is_valid_cost_ofc_cd"	value="">
<input type="hidden" name="cost_ofc_cd_hidden"		value="">
<input type="hidden" name="cost_ofc_cd_deltflg"		value="">
<input type="hidden" name="is_valid_inv_ofc_cd"		value="">
<input type="hidden" name="inv_ofc_cd_hidden"		value="">
<input type="hidden" name="inv_ofc_cd_deltflg"		value="">
<input type="hidden" name="cost_code"		value="">
<input type="hidden" name="cntr_sty_code"		value="">


<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent"  name="btn_retrieve" id="btn_retrieve">Retrieve</button>
	    <button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
	    <button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
<!-- 검색영역 -->
<div class="opus_design_inquiry">		
			<!-- : ( Week ) (S) -->
			
					<table border="0">
						<tr class="h23">							
							<th width="70px"><!-- img class="nostar" --> Invoice DT</th>
							<td width="90px"><%=actionInvDateBox%></td>
							<td width="100px"><input type="text" style="width:75px" value="" name= "fm_prd_dt" maxlength=10 onKeyUp='isNum1(this);tes_isNumD(this,"Y");tes_moveFocus(this, to_prd_dt, 10);' onKeyDown='chkInput(this);'><!-- 
							--><!-- <img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19px" height="20px" border="0" align="absmiddle" name="btns_calendar1"> --><!-- 
							--><button type="button" class="calendar" name="btns_calendar1" id="btns_calendar1"></button>~</td>
							<td width="*" colspan="3"><input type="text" style="width:75px" value="" name ="to_prd_dt" maxlength=10   onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='chkInput(this);' onBlur='chkPeriod();'><!-- 
							--><!-- <img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19px" height="20px" border="0" align="absmiddle" name="btns_calendar2"> --><!-- 
							--><button type="button" class="calendar" name="btns_calendar2" id="btns_calendar2"></button></td>
						</tr>
					</table>				
					<table class="search" border="0">
						<tr class="h23">
							<th width="70px"><!-- img class="nostar" --> Yard Code</th>
							<td width="48px"><!-- 
							--><input type="text" style="width:60px" name="loc_cd" id="loc_cd" maxlength=5 onKeyUp='upper(this);getNodeCodeCombo(this);'><!-- 
							--><script type="text/javascript">ComComboObject('nod_cd', 1, 46, 0 ,0,0)</script><!-- 
							--><!-- <img class="cursor" src="/opuscntr/img/button/btns_search.gif"  name="btn_yard" width="19px" height="20px" border="0" align="absmiddle"> --><!--
							 --><button type="button" class="input_seach_btn" name="btn_yard" id="btn_yard"></button>
							</td>

							<!--
							<td><input type="text" style="width:50" name="loc_cd" maxlength=5 onKeyUp='upper(this);getNodeCodeCombo(this);'><script language="javascript">ComComboObject('nod_cd', 1, 45, 0)</script>
							<img class="cursor" src="/opuscntr/img/button/btns_search.gif"  name="btn_yard" width="19" height="20" border="0" align="absmiddle">
							</td>
							-->
							<th width="272px">Service Provider Code</th>
							<td  width="100px"><input type="text" name="vndr_seq" style="width:115px" value="" maxlength=6 onKeyUp='chkInput(this);isNum(this);' onBlur='validateVNDRCode();'><!-- 
							--><!-- <img class="cursor" src="/opuscntr/img/button/btns_search.gif" name="btn_vndr" width="19px" height="20px" border="0" align="absmiddle"> --><!-- 
							--><button type="button" class="input_seach_btn" name="btn_vndr" id="btn_vndr"></button></td>
							<td  width="*"><input type="text" style="width:300px" name="vndr_seq_name" id="vndr_seq_name" value=""><input type="hidden" name="vndr_seq_hidden" value=''><input type="hidden" name="is_valid_vndr_seq" value=''><input type="hidden" name="vndr_seq_deltflg" value=''>
							</td>
						</tr>
					</table>				
					<table class="search" border="0">
						<tr class="h23">
							<th width="70px"><!-- img class="nostar" --> Cost Office</th>
							<td width="273px">
							     <input type="text" name="cost_ofc_cd" id="cost_ofc_cd" style="width:110px" onKeyUp='chkInput(this);upper(this);isAlpha(this);' onBlur='validateCostOFCCode();'><!-- 
							     --><!-- <img class="cursor" src="/opuscntr/img/button/btns_search.gif" name="btn_cost_ofc_cd" width="19px" height="20px" border="0" align="absmiddle"> --><!-- 
							     --><button type="button" class="input_seach_btn" name="btn_cost_ofc_cd" id="btn_cost_ofc_cd"></button>
							</td>
							<th width="142px">Invoice Office</th>
							<td width="230px"><input type="text" name="inv_ofc_cd" onKeyUp='isAlpha(this);chkInput(this);upper(this);' onBlur='validateInvOFCCode();' style="width:115px"><!-- 
							--><!-- <img class="cursor" src="/opuscntr/img/button/btns_search.gif" name="btn_inv_ofc_cd" width="19px" height="20px" border="0" align="absmiddle"> --><!--
							 --><button type="button" class="input_seach_btn" name="btn_inv_ofc_cd" id="btn_inv_ofc_cd"></button></td>
							<th width="50px"><!-- img class="nostar" -->VVD</th>
							<td><input typ="text" style="width:162px" name="vvd" onKeyUp='ComIsAlphabet(this);upper(this);'  maxlength=9 onKeyDown='ComIsAlphabet(this);upper(this);'></td>
							<th width="50px"><!-- img class="nostar" -->Service Lane</th>
							<td><input typ="text" style="width:162px" name="lane_cd" onKeyUp='ComIsAlphabet(this);upper(this);'  maxlength=3 onKeyDown='ComIsAlphabet(this);upper(this);'></td>
						</tr>
					</table>				
					<table class="search sm" border="0" style="width:250px; height:30px">
						<tr class="h23">
							<th width="70px"><!-- img class="nostar" --> Cost Type</th>
							<td width=""  class="stm">ALL <input type="checkbox" value="" desc="ALL" class="trans" name="cost_tp" id="cost_tp"  onclick="initCheckBox()">
																				TP <input type="checkbox" value="" desc="TP" class="trans" name="cost_tp" id="cost_tp" onclick="cost_tpOnclick()">
																				SV <input type="checkbox" value="" desc="SV" class="trans" name="cost_tp" id="cost_tp"  onclick="cost_tpOnclick()">
																				TM <input type="checkbox" value="" desc="TM" class="trans" name="cost_tp" id="cost_tp"  onclick="cost_tpOnclick()">
																				SR <input type="checkbox" value="" desc="SR" class="trans" name="cost_tp" id="cost_tp"  onclick="cost_tpOnclick()">
																				CG <input type="checkbox" value="" desc="CG" class="trans" name="cost_tp" id="cost_tp"  onclick="cost_tpOnclick()">
																				ET <input type="checkbox" value="" desc="ET" class="trans" name="cost_tp" id="cost_tp"  onclick="cost_tpOnclick()"><!--
																				FL<input type="checkbox" value="" desc="F" class="trans" name="cntr_tp" >
																				MT<input type="checkbox" value="" desc="M" class="trans" name="cntr_tp" >
																				</td>-->
								</td>
								<!--<td width="450"  class="stm">ALL<input type="checkbox" value="" desc="'ALL'" class="trans" name="cost_tp">
																				TP<input type="checkbox" value="" desc="'TP'" class="trans" name="cost_tp">
																			SV<input type="checkbox" value="" desc="'SV'" class="trans" name="cost_tp">
																				TM<input type="checkbox" value="" desc="'TM'" class="trans" name="cost_tp">
																				SR<input type="checkbox" value="" desc="'SR'" class="trans" name="cost_tp">
																				CG<input type="checkbox" value="" desc="'CG'" class="trans" name="cost_tp">
																				ET<input type="checkbox" value="" desc="'ET'" class="trans" name="cost_tp">
																				FL<input type="checkbox" value="" desc="'F'" class="trans" name="cntr_tp">
																				MT<input type="checkbox" value="" desc="'M'" class="trans" name="cntr_tp"></td>
								</td>
								-->
								<!--<td width="66">Volume</td>
								<td width="138" class="stm">Show<input type="radio" name="vol_show_mode" value="Y" class="trans" onclick="vol_show_mode_sts()">
															Hide<input type="radio" name="vol_show_mode" value="N" class="trans" onclick="vol_show_mode_sts()"></td>
								-->

						</tr>
					</table>				
					<table class="search sm" style="width:316px; height:30px" >
						<tr class="h23">
							<th width="60px"><!-- img class="nostar" --> Full/Empty</th>
							<td width="375px"  class="stm">FL <input type="checkbox" value="" desc="F" class="trans" name="cntr_tp" id="cntr_tp">
								MT <input type="checkbox" value="" desc="M" class="trans" name="cntr_tp" id="cntr_tp">
							</td>
							<th width="70px"><!-- img class="nostar" -->Volume</th>
							<td width="" class="stm">Show <input type="radio" name="vol_show_mode" value="Y" class="trans" onclick="vol_show_mode_sts()">
							 Hide <input type="radio" name="vol_show_mode" value="N" class="trans" onclick="vol_show_mode_sts()"></td>
						</tr>
					</table>				
			<!-- : ( Week ) (E) -->
</div>
<!-- 검색영역 -->
</div>

<div class="wrap_result">
<!-- 시트영역 -->
<div class="opus_design_grid" id="SearchLayer1" style="display:none">		
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- 시트영역 -->
<!-- 시트영역 -->
<div class="opus_design_grid" id="SearchLayer2" style="display:inline">		
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- 시트영역 -->
</div>
</form>
