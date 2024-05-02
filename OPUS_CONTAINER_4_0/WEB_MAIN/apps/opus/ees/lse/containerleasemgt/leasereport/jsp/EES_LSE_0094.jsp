<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0094.jsp
*@FileTitle  : Sub Lease Out Container Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0094Event"%>
<%@ page import="com.clt.apps.opus.ees.lse.lsecommon.LSEUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0094Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String strUsr_ofc       = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.leasereport");

	String[] cntrUseCoCd = null;		    //cntr_use_co_cd

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strUsr_ofc= account.getOfc_cd();

		event = (EesLse0094Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="hcond_params" id="hcond_params" />
<input type="hidden" name="hcond_lstm_cd" id="hcond_lstm_cd" />
<input type="hidden" name="hcond_tpsz_cd" id="hcond_tpsz_cd" />
<input type="hidden" name="hcond_vndr_seq" id="hcond_vndr_seq" />
<input type="hidden" name="hcond_loc_cd" id="hcond_loc_cd" />
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>" id="usr_ofc_cd">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_New" id="btn_New" >New</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="121">				
				<col width="190">				
				<col width="138">				
				<col width="176">
				<col width="162">					
				<col width="*">				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<td><input type="checkbox" name="total_flg" value="Y" class="trans">Summary Total</td>
					<td class="sm pad_left_4"><input type="radio" name="lst_sts_flg" value="01" class="trans" checked> Inventory <!-- 
					 --><input type="radio" name="lst_sts_flg" value="02" class="trans"> Lease Out Result</td>
					<th>CNTR STS</th>
					<td style="padding-left:2;">
						<select name="cntr_sts_cd" style="width:150px;" class="input1"><!-- 
						 --><option value="SBO" selected>Sub Lease Out</option><!-- 
							 --><option value="MUO">Mis Use Out</option><!-- 
							 --><option value="(SB|MU)O">Sub & Mis Use Out</option><!-- 
							 --><option value="SBI">Sub Lease Return</option><!-- 
							 --><option value="MUI">Mis Use Return</option><!-- 
							 --><option value="(SB|MU)I">Sub & Mis Use Return</option></select>
					</td>
					<th>Own Ship</th>
					<td>
						<select name="lstm_soc_tp" style="width:90px;" class="input1"><!-- 
						 --><option value="01">Incl SOC</option><!-- 
							 --><option value="02" selected>Excl SOC</option><!-- 
							 --><option value="03">SOC Only</option>
						</select>
					</td>
		   		</tr>
		   </tbody>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<colgroup>
				<col width="90" />				
				<col width="300" />				
				<col width="60" />				
				<col width="270" />
				<col width="77" />					
				<col width="*" />				
		   </colgroup> 
			<tr class="h23">
				<th>Out Location</th>
				<td><select name="loc_tp"><!-- 
				 --><option value="0">All (by RCC)</option><!-- 
				 --><option value="1">All (by Country)</option><!-- 
				 --><option value="2">RCC (by LCC)</option><!-- 
				 --><option value="3">LCC (by SCC)</option><!-- 
				 --><option value="4">SCC (by Yard)</option><!-- 
				 --><option value="5">Country (by Country)</option></select><!-- 
				 --><input type="text" name="loc_cd" caption="Out Location" style="width:98px;text-align:center;" class="input2" value="" maxlength="5" dataformat="engup" readonly><!-- 
				  --><button type="button" name="btns_search" id="btns_search"  class="input_seach_btn"></button></td>
				<th>Period</th>
				<td style="padding-left:2;"><!-- 
				 --><input type="text" name="str_evnt_dt" caption="Start Duration" style="width:80px;ime-mode:disabled;text-align:center;" class="input" value="" maxlength="10" dataformat="ymd" !cofield="end_evnt_dt"><!-- 
				  --> ~ <!-- 
				   --><input type="text" name="end_evnt_dt" caption="End Duration" style="width:80px;ime-mode:disabled;text-align:center;" class="input" value="" maxlength="10" dataformat="ymd" !cofield="str_evnt_dt"><!-- 
				    --><button type="button" name="btns_calendar" id="btns_calendar"  class="calendar ir"></button></td>
				<th>T/Using Days</th>
				<td style="padding-left:2;"><input type="text" name="onh_free_dys" caption="Free Days" style="width:80px;text-align:right" value="" class="input" maxlength="5" dataformat="num"> Or Over</td>
			</tr>
		</table>
		
		<table>
			<colgroup>
				<col width="90" />				
				<col width="300" />				
				<col width="60" />				
				<col width="*" />				
		   </colgroup>
			<tr class="h23">
				<th>Out AGMT No.</th>
				<td>
					<input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:40px;text-align:center;" class="input2" value="HHO" readonly><!-- 
					 --><input type="text" caption="AGMT No." name="agmt_seq" style="width:56px;" class="input" value="" maxlength="6" dataformat="num"><!-- 
					  --><button type="button" name="btns_search2" id="btns_search2"  class="input_seach_btn"></button><!-- 
					   --><input type="text" name="ref_no" style="width:142px" class="input2" readonly></td>
				<th>Lessee</th>
				<td colspan="3" style="padding-left:2;">
					<input type="text" name="vndr_seq" caption="Lessee" style="width:85px;text-align:center;" class="input" value="" maxlength="6" dataformat="num"><!-- 
					 --><button type="button" name="btns_search3" id="btns_search3"  class="input_seach_btn"></button><!-- 
					  --><input type="text" name="vndr_abbr_nm" caption="Lessee" style="width:107px;text-align:center;"  class="input2" value="" readonly><!-- 
					   --><input type="text" name="vndr_nm" caption="Lessor." style="width:198px"  class="input2" value="" readonly></td>
			</tr>
		</table>
		
		<table>	
			<colgroup>
				<col width="90" />				
				<col width="300" />				
				<col width="60" />
				<col width="280" />				
				<col width="60" />				
				<col width="200" />	        
                <col width="60" />              
                <col width="*" /> 			
		   </colgroup>
			<tr class="h23">
				<th>Lease Term</th>
				<td><script type="text/javascript" >ComComboObject('combo1', 1, 277, 1);</script><input type="hidden" name="lstm_cd" value="" ></td>
				<th>TP/SZ</th>
				<td><script type="text/javascript" >ComComboObject('combo2', 1, 228, 1 );</script><input type="hidden" name="cntr_tpsz_cd" value="" >&nbsp;</td>
				<th>Full & MTY</th>
				<td><select name="cntr_full_flg" style="width:79px;" class="input"><!-- 
				 --><option value="" selected>All</option><!-- 
				  --><option value="Y">Full</option><!-- 
				   --><option value="N">MTY</option><!-- 
				    --></select></td>
				 <th>Auth No.</th>
                 <td><input type="text" caption="Auth No." name="cntr_onh_auth_no" id="cntr_onh_auth_no" style="width:150px;" class="input" value="" maxlength="20"></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<table width="100%">
    			<tr><td width="10">&nbsp;</td><td id="dcondTD" style="color:gray;">&nbsp;</td></tr>
</table>
    		
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_accent" name="btn_more" id="btn_more">More</button><!-- 
			 --><button class="btn_normal" name="btn_DownExcel2" id="btn_DownExcel2" type="button">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
</form>