<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_6005.jsp
*@FileTitle  : Summary Report by Customer 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt6005Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt6005Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTPerformanceAnalysis.ChargeCalculationReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strUsr_ofc		= account.getOfc_cd();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();


		event = (EesDmt6005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="usr_ofc_cd" name="usr_ofc_cd" value="<%=strUsr_ofc%>" type="hidden" />
<input id="usr_rhq_ofc_cd" name="usr_rhq_ofc_cd" value="<%=strRhq_ofc_cd%>" type="hidden" />
<input id="cnt_cd" name="cnt_cd" type="hidden" />
<input id="loc_cd" name="loc_cd" type="hidden" />
<input id="ofc_cd" name="ofc_cd" type="hidden" />
<input id="tmp_ofc_cd" name="tmp_ofc_cd" type="hidden" />
<input id="dmdt_trf_cd" name="dmdt_trf_cd" type="hidden" />
<input id="start_dt" name="start_dt" type="hidden" />
<input id="end_dt" name="end_dt" type="hidden" />
<input id="s_cust_gubun" name="s_cust_gubun" type="hidden" />
<input id="s_cust_cd" name="s_cust_cd" type="hidden" />
<input id="head_office" name="head_office" value="<%=ConstantMgr.getHeadOfficeCode()%>" type="hidden" />

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Minimize" id="btn_Minimize">Minimize</button><!--
		--><button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry">
	<div id="sch_cond_div" style=display:block;>
	<!--  MiniLayer (S) -->
    	<table class="mar_btm_4">
    	  <colgroup>
            <col width="100" />
            <col width="215" />
            <col width="85" />
            <col width="215" />
            <col width="85" />
            <col width="150" />
            <col width="*" />
	      </colgroup>
			<tr>
				<th>To MVMT Date</th>
				<td><!-- 
					 --><input type="text" name="fm_dt" dataformat="ymd" style="width:76px;" class="input1">~ <!-- 
					 --><input type="text" name="to_dt" dataformat="ymd" style="width:76px;" class="input1"><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td>
				<th>Tariff type</th>
				<td><script type="text/javascript">ComComboObject('tariff_type',2,218,1,1,0,false);</script><button type="button" class="multiple_inq"></button></td>
				<th class="sm">Currency</th>
				<td class="sm"><input type="radio" name="curr_flg" id="curr_flg1" value="U" class="trans" checked><label for="curr_flg1">USD</label>&nbsp;&nbsp;&nbsp;<input type="radio" name="curr_flg" id="curr_flg2" value="L" class="trans"><label for="curr_flg2">Local</label></td>
				<td></td>
			</tr>
		</table>
		
    	<table class="mar_btm_4 sm">    	  
    	 <colgroup>
            <col width="90" />
            <col width="90" />
            <col width="100" />
            <col width="172" />
            <col width="*" />
	     </colgroup>
			<tr>
				<th><input type="radio" name="sch_flg" id="sch_flg" value="SC" class="trans" checked><label for="sch_flg">S/C No.</label></th>
				<th><input type="radio" name="sch_flg" id="sch_flg2" value="RFA" class="trans"><label for="sch_flg2">RFA No.</label></th>
				<td><input type="text" name="sc_rfa_no"  dataformat="engup" maxlength='20' style="width:98px;" class="input1"><button type="button" class="multiple_inq" id="btns_multisearch" name="btns_multisearch"></button></td>
				<th><input type="radio" name="sch_flg" value="CTRT" class="trans">&nbsp;Contract Office</th>
				<td><input type="text" name="ctrt_ofc" dataformat="engup" maxlength='6' style="width:85px;" class="input"><button type="button" class="input_seach_btn" name="btns_ctrt_ofc" id="btns_ctrt_ofc"></button></td>
			</tr>
    	</table>
    	
    	<table class="mar_btm_4 sm">
    	   <colgroup>
              <col width="92" />
              <col width="*" />
		    </colgroup>
			<tr>
				<th><input type="radio" name="sch_flg" value="CUST" class="trans">&nbsp;Customer</th>
				<td colspan="4"><input type="text" name="cust_cd" dataformat="engup" style="width:68px;" class="input"><button type="button" class="input_seach_btn" id="btns_customer" name="btns_customer"></button><input type="text" name="cust_nm" readonly style="width:408px;" class="input2"></td>
			</tr>
    	</table>
    	
    	<table>
    	 <colgroup>
            <col width="100" />
            <col width="50" />
            <col width="85" />
            <col width="95" />
            <col width="85" />
            <col width="180" />
            <col width="*" />
		 </colgroup>
			<tr>
				<th>Coverage</th>
				<td class="stm">Location</td>
				<td><input type="text" name="cvr_cd" dataformat="engup" maxlength='5' style="width:63px;" class="input"></td>
				<th>DEM/DET Office</th>
				<td><input type="radio" name="ofc_flg" id="ofc_flg" value="R" class="trans" checked><label for="ofc_flg">RHQ</label><input type="radio" name="ofc_flg" id="ofc_flg2" value="O" class="trans"><label for="ofc_flg2">Office</label></td>
				<td><script  type="text/javascript">ComComboObject('office',1,75,0,0,0,true);</script><button type="button" class="multiple_inq"></button></td>
				<td><input type="checkbox" name="chk_sub_ofc" id="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans"><label for="chk_sub_ofc">Incl. Sub Office</label></td>					   
			</tr>
    	</table>
    	    	
    	<table>
    	  <colgroup>
            <col width="100" />
            <col width="50" />
            <col width="85" />
            <col width="30" />
            <col width="85" />
            <col width="30" />
            <col width="85" />
            <col width="30" />
            <col width="130" />
            <col width="80" />
            <col width="130" />
            <col width="*" />
		   </colgroup>
			<tr>
				<th>BKG Location</th>
				<td class="stm">POR</td>
				<td><input type="text" name="por_cd" dataformat="engup" maxlength='5' style="width:63px;" class="input"></td>
				<td class="stm">POL</td>
				<td><input type="text" name="pol_cd" dataformat="engup" maxlength='5' style="width:63px;" class="input"></td>
				<td class="stm">POD</td>
				<td><input type="text" name="pod_cd" dataformat="engup" maxlength='5' style="width:63px;" class="input"></td>
				<td class="stm">DEL</td>
				<td><input type="text" name="del_cd" dataformat="engup" maxlength='5' style="width:63px;" class="input"></td>
				<th>S. TTL Level</th>
				<td><select name="sttl_lvl" id="sttl_lvl" style="width:120px;" class="input"><!-- 
					 --><option value="4" selected>Coverage</option><!-- 
					 --><option value="3">DEM/DET Office</option><!-- 
					 --><option value="2">Tariff</option><!-- 
					 --><option value="1">S/C & RFA No</option><!-- 
					 --></select><!-- 
				 --></td>
				<td><input type="checkbox" name="incl_dc" id="incl_dc" value="Y" class="trans" checked><label for="incl_dc"><b>Incl. D/C Column</b></label></td>
			</tr>
    	</table>
	</div>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script  type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->

</form>