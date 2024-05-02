<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CIM_2001.jsp
*@FileTitle : OSCAR Booking Information Inquiry
*@author     : PARK YOUNG JIN
*@version    : 1.0
*@since      : 2015/07/09
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOffice_cd		= "";

	String optionStr = "";	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOffice_cd = account.getOfc_cd();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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
<input type="hidden" name="h_bkg_no" value="" id="h_bkg_no" />
<input type="hidden" name="p_cntrno" value="" id="p_cntrno" />
<input type="hidden" name="h_cntrno" value="" id="h_cntrno" />
<input type="hidden" name="check_digit" value="" id="check_digit" />
<input type="hidden" name="p_date1" value="" id="p_date1" />
<input type="hidden" name="p_date2" value="" id="p_date2" />
<input type="hidden" name="input_cntr_sts_evnt_dt" value="" id="input_cntr_sts_evnt_dt" />
<input type="hidden" name="usr_id" id="usr_id" value="<%=strUsr_id %>" />
<input type="hidden" name="office_cd" id="office_cd" value="<%=strOffice_cd %>" />
<input type="hidden" name="input_cntr_sts_cd" id="input_cntr_sts_cd" value="RPC" />
<input type="hidden" name="pop_cntr_no" id="pop_cntr_no" value="" />
<!-- 개발자 작업	-->

<!-- 제목 -->
<div class="page_title_area clear">
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_minimize" 		id="btn_minimize">Maximize</button><!--
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Close</button>
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
			<col width="70" />
			<col width="280" />
			<col width="70" />
			<col width="130" />
			<col width="100" />
			<col width="100" />
			<col width="*" />
		</colgroup>
		<tbody>
		<tr>
			<th>Container No.</th>
			<td>
			<span style="display:" id="cntr_txt"><input type="text" name="o_cntr_no" dataformat="engup" maxlength="11" style="width:130px;ime-mode:disabled;" class="input" value="" id="o_cntr_no"  onchange="javascript:cntr_change();" /></span><!-- 
			 --><span style="display:none"  id="cntr_combo"><script type="text/javascript" >ComComboObject('s_cntr_no', 1, 130, 1 );</script></span><!-- 
			 --><span><button type="button" class="multiple_inq ir" id="btn_popup1" name="btn_popup1"></button></span><!-- 
			  --><span><input type="button" value="Search EDI Error"  id="btn_popup2" name="btn_popup2" style="cursor:pointer;background-color: #FFFFFF;padding: 0px 9px 3px;
			  font-size: 7px; line-height: 13px;margin: 0 0 1px 0px;color:#0082EC!important;border-radius: 1px;font-weight:bold"></input></span></td>
            <th>BKG No.</th>
            <td><input type="text" name="s_bkg_no" id="s_bkg_no" dataformat="engup" maxlength="13" style="width:100px;ime-mode:disabled;" class="input" value=""></td>
            <th>MVMT Event Date</th>
            <td>
               <input type="text"  style="width:80px;text-align:center;" class="input1" name="s_event_date1"  id="s_event_date1" dataformat="ymd">~<!-- 
                --><input type="text" style="width:80px; text-align:center;" class="input1" name="s_event_date2" id="s_event_date2" dataformat="ymd"><!-- 
                --><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button><!-- 
            --></td>
            <td></td>
  		</tr> 
  		</tbody>
		</table>
	</div>	
</div>
<div class="wrap_result">
	
	<div class="layout_wrap">
		 <div class="layout_vertical_2" style ="width: 51%;">
		 <div>
		 	<table>
		 		<tr>
		 			<td style="width:50%"><h3 style="margin-bottom:0" class="title_design">Booking Information</h3></td>
		 			<td style="width:50%;text-align:right"><button type="button" style="background-color: #27415d;float: right;padding: 0px 9px 4px;font-size: 7px; line-height: 13px;margin: 0 0 1px 0px;letter-spacing: -.2px;color:#fff!important;border-radius: 1px;" 
		 			name="btn_save2" id="btn_save2">CYC Status Change</button></td>
		 		</tr>
		 	</table>
		 </div>
		 	
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>	
		 </div>
		 <div class="layout_vertical_2" align="center" style = "width: 1%">
		<div style="width: 150px;">&nbsp;</div>
		</div>
		 <div class="layout_vertical_2" style ="width: 48%;">
		 	<h3 style="margin-bottom:0" class="title_design">Vessel Information</h3>
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>	
		 </div>
	</div>
	<div class="layout_wrap">
		<div>
		 	<table>
		 		<tr>
		 			<td style="width:50%"><h3 style="margin-bottom:0" class="title_design">Container Information</h3></td>
		 			<td style="width:50%;text-align:right"><button type="button" style="background-color: #27415d;padding: 0px 9px 4px;font-size: 7px; line-height: 13px;margin: 0 0 1px 0px;letter-spacing: -.2px;color:#fff!important;border-radius: 1px;" 
		 			name="btn_cycle" id="btn_cycle"> Cycle No Update. </button><!-- 
		 			 --><button type="button" style="background-color: #27415d;padding: 0px 9px 4px;font-size: 7px; line-height: 13px;margin: 0 0 1px 4px;letter-spacing: -.2px;color:#fff!important;border-radius: 1px;" name="btn_master" id="btn_master">Master</button>
		 			 <button type="button" style="background-color: #27415d;padding: 0px 9px 4px;font-size: 7px; line-height: 13px;margin: 0 0 1px 0px;letter-spacing: -.2px;color:#fff!important;border-radius: 1px;" 
		 			name="btn_ctn_status" id="btn_ctn_status">Container Status Update</button>
		 			</td>
		 			<!-- <td style="text-align:center"></td>
		 			<td style="width:7%;text-align:right"></td> -->
		 		</tr>
		 	</table>
		 </div>
			
		<div class="opus_design_grid" >
				<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>

	
	
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab sm">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	
	
	
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
			<div style="float:left;padding:0;text-align:left">
				<table border="1">
		<tbody>
			<colgroup>
				<!-- <col width="80px" />
				<col width="115px" /> -->
				<col width="40px" />
				<col width="140px" />
				<col width="40px" />
				<col width="370px" />
				<col width="40px" />
			</colgroup>
			<tr>
				<!-- <th style="padding:0px 0px 5px 0px;">Status Code</th>
				<td style="padding:0px 0px 5px 0px;">
					<select style="width: 120px; text-align:center;" class="input1" name="input_cntr_sts_cd" id="input_cntr_sts_cd">
						<option value="RPC" selected>Force Transfer</option>
					</select>
				</td> -->
				<th style="padding:0px 0px 5px 0px;">Date</th>
				<td style="padding:0px 0px 5px 0px;"><input style="width: 100px;text-align:center;" class="input1" dataformat="ymd" name="input_cntr_sts_evnt_dt2" id="input_cntr_sts_evnt_dt2" style="ime-mode:disabled" maxlength="10" style="text-align:center"><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button></td>
				<th style="padding:0px 0px 5px 0px;">Yard</th>
				<td style="padding:0px 0px 5px 0px;"><input type="text" id="input_onh_yd_cd" style="width: 105px;text-align:center;" class="input1" dataformat="engup" name="input_onh_yd_cd" maxlength="7" /><!-- 
				--><button type="button" class="input_seach_btn" name="ComOpenPopupWithTarget1" id="ComOpenPopupWithTarget1" ></button><!-- 
				--><input type="text" id="yd_cd_nm" style="width: 225px;" class="input2" readonly value=""  name="yd_cd_nm" /></td>
				<td>
				<div class="opus_design_btn"><button type="button" class="btn_accent" name="btn_save1" id="btn_save1"  style="width:100px;">Force Transfer</button></div>
				</td>
			</tr>
		</tbody>
	</table>
			</div>
			<div class="opus_design_btn"><!--  
				--><button type="button" class="btn_accent" name="btn_add" id="btn_add">Row Add</button><!--
				--><button type="button" class="btn_accent" name="btn_delete" id="btn_delete">Row Delete</button><!--   
				--><button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button><!--
				--><button type="button" class="btn_accent" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--    
			--></div>
				<script type="text/javascript">ComSheetObject('sheet4');</script>
				
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet5');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet6');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet7');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<div style="display:none"><script type="text/javascript">ComSheetObject('sheet8');</script></div>
</div>

</form>