<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_1018.jsp
*@FileTitle  : Owner’s Account
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0018Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOInvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms0018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Adding Logic extracting data from server when loading initial window ..
//		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		log.error(e.getMessage(),e);
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="searchType" id="searchType">
 <!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		   --><button type="button" class="btn_normal" name="btn_saveToFile" id="btn_saveToFile">Down Excel</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_autoFilter" id="btn_autoFilter">Auto Matching Balance Filter</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

 <div class= "wrap_search">
	<!-- opus_design_inquiry (S) -->
	<div class= "opus_design_inquiry wFit">
		<h3 class="title_design">Owner's Account - Master</h3>
		<table class="search_in">
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="130"/>
					<col width="100"/>
					<col width="110"/>
					<col width="120"/>
					<col width="*">
				</colgroup> 
				<tr>
					<th>Effective Date</th>
					<td><input type="text" name="eff_dt1" class="input1" dataformat="ymd" required="" fullfill="" caption="Effective Date From" style="width:80px;text-align:center;ime-mode:disabled;" value="" id="eff_dt1" /><!--  
						--><button type="button" id="btn_effDt1" name="btn_effDt1" class="calendar ir"></button>&nbsp;~&nbsp;&nbsp;<!--  
						--><input type="text" name="eff_dt2" class="input1" dataformat="ymd" required="" fullfill="" cofield="eff_dt1" caption="Effective Date To" style="width:80px;text-align:center;ime-mode:disabled;" value="" id="eff_dt2" /><!--  
						--><button type="button" id="btn_effDt2" name="btn_effDt2" class="calendar ir"></button></td>
					<th>FMS Approval</th>
					<td><select name="aproFlg" id="aproFlg" style="width:100px;">
							<option value="" selected>All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select></td>
					<th>DR/CR Matching</th>
					<td width=""><select name="stlFlg" id="stlFlg" style="width:90px;">
						<option value="" selected>All</option>
						<option value="Y">Matched</option>
						<option value="N">Unmatched</option>
						</select>
					</td>
				</tr>
				<tr >
					<th>Vessel Code</th>
					<td width="255">
						<input type="text" name="vsl_cd" style="width:57px;text-align:center;ime-mode:disabled" class="input" maxlength="4" fullfill="" caption="Vessel Code" id="vsl_cd" /><!--  
						--><button type="button" name="btn_vslPop" id="btn_vslPop" class="input_seach_btn" onClick="openPopup('cust_cd')"></button><!--  
						--><input type="text" style="width:140px;" class="input2" name="vsl_eng_nm" id="vsl_eng_nm" readonly><!--  
						--><input type="checkbox" name="btn_vslCdClr" class="trans" id="btn_vslCdClr" />
					</td>
					<th>Location</th>
					<td>
						<input type="text" name="loc_cd" style="width:56px;text-align:center;ime-mode:disabled" class="input" maxlength="5" fullfill="" caption="Location" id="loc_cd" /><!--  
						--><button type="button" name="btn_locPop" id="btn_locPop" class="input_seach_btn" onClick="openPopup('cust_cd')"></button><!--  
						--><input type="text" name="loc_nm" id="loc_nm" style="width:150px;" class="input2" readonly><!--  
						--><input type="checkbox" name="btn_locCdClr" class="trans" id="btn_locCdClr" />
					</td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry (E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class= "opus_design_inquiry"><h3 class="title_design">Owner's account Billing to owner</h3></div>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet');</script>
	</div>	
	
	<div class= "opus_design_inquiry"><h3 class="title_design">Owner's account cancelled slip from Local</h3></div>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>	
	<div class= "opus_design_inquiry">	
		<table>
			<tbody>
				<colgroup>
					<col width="150px"/>
					<col width="10px"/>
					<col width="10px"/>
					<col width="10px"/>
					<col width="*">
				</colgroup> 
			 	<tr >
					<th>Balanced Match Amount</th>
					<th>&nbsp;</th>
					<td><input type="text" name="plusSum" style="width:100px;text-align:right;" class="input2" dataformat="float" value="0" readonly id="plusSum" /> </td>
					<th>&nbsp;</th>
					<td><input type="text" name="minusSum" style="width:100px;text-align:right;" class="input2" dataformat="float" value="0" readonly id="minusSum" /> </td>
				</tr>
			</tbody>
		</table>	
	</div>
</div>
</form>
