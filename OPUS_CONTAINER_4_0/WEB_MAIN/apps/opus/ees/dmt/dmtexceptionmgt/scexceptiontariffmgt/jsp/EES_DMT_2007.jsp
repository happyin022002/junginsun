<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2007.jsp
*@FileTitle  : S/C & RFA Exception Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
=========================================================*/
%>
  
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event.EesDmt2007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2007Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id	 = "";
	String strUsr_nm	 = "";
	String strOfc_cd	 = "";
	String strRhq_ofc_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt");
	String scNo 	= request.getParameter("sc_no") 	!= null ? (String)request.getParameter("sc_no") 	: "" ;
	String rfaNo 	= request.getParameter("rfa_no") 	!= null ? (String)request.getParameter("rfa_no") 	: "" ;
	String trfCd 	= request.getParameter("trf_cd") 	!= null ? (String)request.getParameter("trf_cd") 	: "" ;
	String caller 	= request.getParameter("caller") 	!= null ? (String)request.getParameter("caller") 	: "" ;
	
	boolean isPopup = caller.length() > 0;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	  = account.getUsr_id();
		strUsr_nm 	  = account.getUsr_nm();
		strOfc_cd 	  = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
		event = (EesDmt2007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="caller" value="<%= caller %>" id="caller" />
<input type="hidden" name="dmdt_trf_cd_list" id="dmdt_trf_cd_list" />
<!-- Parameter for searching status of S/C, Before -->
<input type="hidden" name="intg_cd_id" id="intg_cd_id" />
<!--  Parameter for searching Ref. Office -->
<input type="hidden" name="login_usr_id" value="<%=strUsr_id%>" id="login_usr_id" />
<input type="hidden" name="login_usr_nm" value="<%=strUsr_nm%>" id="login_usr_nm" />
<input type="hidden" name="login_ofc_cd" value="<%=strOfc_cd%>" id="login_ofc_cd" />
<input type="hidden" name="ref_ofc_cd" id="ref_ofc_cd" />
<input type="hidden" name="tmp_ofc_cd" id="tmp_ofc_cd" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<!--  Parameter for searching Coverage-->
<input type="hidden" name="cnt_cd" id="cnt_cd" />
<input type="hidden" name="rgn_cd" id="rgn_cd" />
<input type="hidden" name="ste_cd" id="ste_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<!-- Parameter for S/C & RFA Exception Inquiry -->
<input type="hidden" name="ver_sts_cd" id="ver_sts_cd" />
<input type="hidden" name="rqst_sts_cd" id="rqst_sts_cd" />
<input type="hidden" name="tariff" id="tariff" />
<input type="hidden" name="fm_dt" id="fm_dt" />
<input type="hidden" name="to_dt" id="to_dt" />
<input type="hidden" name="sc_no" id="sc_no" />
<input type="hidden" name="rfa_no" id="rfa_no" />
<input type="hidden" name="prop_no" id="prop_no" />
<input type="hidden" name="dar_no" id="dar_no" />
<input type="hidden" name="apvl_no" id="apvl_no" />
<input type="hidden" name="type" id="type" />
<input type="hidden" name="cond_tp" id="cond_tp" />
<input type="hidden" name="cust_cd" id="cust_cd" />
<input type="hidden" name="act_cust_cd" id="act_cust_cd" />
<!-- Parameter for subordinate items of S/C & RFA Exception Inquiry -->
<input type="hidden" name="sc_expt_ver_seq" id="sc_expt_ver_seq" />
<input type="hidden" name="sc_expt_grp_seq" id="sc_expt_grp_seq" />
<input type="hidden" name="rfa_expt_dar_no" id="rfa_expt_dar_no" />
<input type="hidden" name="rfa_expt_ver_seq" id="rfa_expt_ver_seq" />
<input type="hidden" name="rfa_rqst_dtl_seq" id="rfa_rqst_dtl_seq" />
<input type="hidden" name="rfa_expt_mapg_seq" id="rfa_expt_mapg_seq" /><!-- [2016.01.04] NYK Add -->
<input type="hidden" name="cvrg_cmb_seq" id="cvrg_cmb_seq" /><!-- [2016.01.04] NYK Add -->
<!-- Parameter for searching ustomer Name -->
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<!-- gotten Parameter from Popup Screen -->
<input type="hidden" name="opener_tariff" value="<%= trfCd %>" id="opener_tariff" />

<% if (isPopup) { %>
<div class="layer_popup_title">
<% } %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
 	
 	<!-- page_title(S) -->
 	<% if (isPopup) { %>
 	<h2 class="page_title"><span>S/C & RFA Exception Inquiry</span></h2>
	<% } else {	%> 	
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<% } %>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New"  		id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Minimize" 		id="btn_Minimize">Minimize</button><!--
		--><button type="button" class="btn_normal" name="btn_Detail" 	id="btn_Detail">Detail</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close" style="display:none;">Close</button><!-- 
	 --></div>
	<!-- opus_design_btn(E) -->
	
	<% if (!isPopup) { %>
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	<% } %>
</div>
<!-- page_title_area(E) -->
<% if (isPopup) { %>
</div>
<div class="layer_popup_contents">
<% } %>

<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div  id="conditionLayer" style="display:inline;">
	<div class="opus_design_inquiry wFit">
		<table class="search">
			<tbody>
				<colgroup>
					<col width="35">
					<col width="430">
					<col width="170">
					<col width="90">
					<col width="*">
			    </colgroup>
			    <tr>
					<th class="sm">Type</th>
					<td class="sm"><input type="checkbox" name="chkSC" id="chkSC" class="trans" checked onClick="checkType(this)">&nbsp;&nbsp;S/C&nbsp;&nbsp;<!-- 
					 --><script type="text/javascript">ComComboObject('combo1', 1, 80, 0, 1)</script><!-- 
					 --><button type="button" class="multiple_inq"></button><!--  
					 -->&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="chkRFA" id="chkRFA" class="trans" checked onClick="checkType(this)">&nbsp;RFA (Before BKG DAR)&nbsp;<!-- 
					 --><script type="text/javascript">ComComboObject('combo2', 1, 80, 0, 1)</script><!-- 
					 --><button type="button" class="multiple_inq"></button><!-- 
					 --></td>
					 <td></td>
					<th>Tariff Type</th>
					<td><script type="text/javascript">ComComboObject('combo3', 2, 250, 0, 1)</script><button type="button" class="multiple_inq"></button></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="opus_design_inquiry wFit sm">
		<table>
			<tbody>
				<colgroup>
					<col width="90px">
					<col width="60px">
					<col width="440px">
					<col width="85px">
					<col width="*">
			    </colgroup>
			    <tr>
					<td><input type="radio" name="cond_type" value="office" class="trans"checked onclick="condType_click()"><strong>Office</strong></td>
					<td class="stm">Ref. Office</td>
					<td class="stm"><script type="text/javascript">ComComboObject('combo4', 2, 205, 0, 1, 0,true)</script><!-- 
						 --><button type="button" class="multiple_inq"></button><!-- 
						 --><input type="checkbox" name="chkSubOfc" id="chkSubOfc" value="Y" class="trans" onClick="doInclSubOfc()">&nbsp;Incl. Sub Office<!-- 
					 --></td>
					<td class="stm">Effective Date</td>
					<td><!-- 
						 --><input type="text" name="ofcEffDtFm" id="ofcEffDtFm" style="width:80px;" class="input1" dataformat="ymd" maxlength="8" readonly>~&nbsp;<!-- 
						 --><input type="text" name="ofcEffDtTo" id="ofcEffDtTo" style="width:80px;" class="input1" dataformat="ymd" maxlength="8" readonly><!-- 
						 --><button type="button" class="calendar" name="btns_ofcCalendar" id="btns_ofcCalendar"></button><!-- 
					 --></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="90px">
					<col width="60px">
					<col width="95px">
					<col width="50px">
					<col width="115px">
					<col width="70px">
					<col width="110px">
					<col width="85px">
					<col width="*">
			    </colgroup>
			    <tr>
					<td><input type="radio" name="cond_type" value="coverage" class="trans" onclick="condType_click()"><strong>Coverage</strong></td>
					<td class="stm">Country</td>
					<td ><script type="text/javascript">ComComboObject('cboCountry', 2, 60, 0, 1)</script></td>
					<td class="stm"><span id="Region">Region</span></td>
					<td class="stm"><script type="text/javascript">ComComboObject('cboRegion', 2, 60 , 0, 0, 0, true)</script></td>
					<td class="stm">Location</td>
					<td class="stm"><input type="text" name="location" id="location" style="width:90px;ime-mode:disabled" class="input" dataformat="engup" maxlength="5" OnKeyUp="checkLocation()"></td>
					<td class="stm">Effective Date</td>
					<td><!-- 
						 --><input type="text" name="cvrgEffDtFm" id="cvrgEffDtFm" style="width:80px;" class="input1" dataformat="ymd" maxlength="8" readonly><span class="dash">~</span><!-- 
						 --><input type="text" name="cvrgEffDtTo" id="cvrgEffDtTo" style="width:80px;" class="input1" dataformat="ymd" maxlength="8" readonly><!-- 
						 --><button type="button" class="calendar" name="btns_cvrgCalendar" id="btns_cvrgCalendar"></button><!-- 
					 --></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="90px">
					<col width="60px">
					<col width="95px">
					<col width="50px">
					<col width="110px">
					<col width="70px">
					<col width="110px">
					<col width="50px">
					<col width="140px">
					<col width="60px">
					<col width="*">
			    </colgroup>
			    <tr>
					<td><input type="radio" name="cond_type" id="cond_type" value="dar" class="trans" onclick="condType_click()"><strong>DAR</strong></td>
					<td class="stm">S/C No.</td>
					<td><input type="text" name="sCNo" id="sCNo" value="<%= scNo %>" style="width:80px;ime-mode:disabled" class="input" dataformat="engup" maxlength="9"></td>
					<td class="stm">RFA No.</td>
					<td class="stm"><input type="text" name="rFANo" id="rFANo" value="<%= rfaNo %>" style="width:85px;ime-mode:disabled" class="input" dataformat="engup" maxlength="11"></td>
					<td class="stm">Proposal No.</td>
					<td class="stm"><input type="text" name="proposalNo" id="proposalNo" style="width:90px;ime-mode:disabled" class="input" dataformat="engup" maxlength="11"></td>
					<td class="stm">DAR No.</td>
					<td class="stm"><input type="text" name="darNo" id="darNo" style="width:115px;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
					<td class="stm">APVL No.</td>
					<td class="stm"><input type="text" name="approvalNo" id="approvalNo" style="width:120px;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="63px">
					<col width="*">
			    </colgroup>
			    <tr>
					<th>Customer</th>
					<td>
						<select name="custTp" id="custTp" style="width:80px;" class="input">
							<option value="" selected>ALL</option>
							<option value="CUST">Main</option>
							<option value="A/CUST">DEM/DET</option>
						</select>
						<input type="text" name="custCd" id="custCd" style="width:80px;ime-mode:disabled" class="input" dataformat="engup" maxlength="8">
						<!-- <img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" onClick="openWinSearchCustomer('cust_cd')"> -->
						<button type="button" class="input_seach_btn" onClick="openWinSearchCustomer('cust_cd')"></button>
						<input type="text" name="custNm" id="custNm" style="width:500px;" class="input2">
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
	
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!-- opus_design_grid(S) -->	
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:inline;margin-bottom:20px">
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		<div class="opus_design_inquiry">
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!-- layout_wrap(S) -->
			<% if (isPopup) { %>
			<div class="layout_wrap" style="margin-bottom:20px">
			<% } else { %>
			<div class="layout_wrap">
			<% } %>	
			    <div class="layout_vertical_2" style="width:39%;margin-right:2%;">
			    	<h3 class="title_design">Tiered Free Time</h3>
			    	<h3 style="height: 25px">&nbsp;</h3>
					<div class="opus_design_grid" id="mainTable">
						<script type="text/javascript">ComSheetObject('t1sheet2');</script>
					</div>
			    </div>
			    
			    <div class="layout_vertical_2" style="width: 59%;">
			    	<h3 class="title_design">Rate Adjustment</h3>
					<h3 class="pad_left_12">Currency</h3>
					<h3 style="position: relative;top: -5px;" class="pad_left_8"><input type="text" name="scCurrency" id="scCurrency" style="width:45px;text-align:center;" class="input2"></h3>
					<div class="opus_design_grid" id="mainTable">
						<script type="text/javascript">ComSheetObject('t1sheet3');</script>
					</div>
				</div>
			</div>
			
			<div class="layout_wrap">
			    <div class="layout_vertical_2" style="width: 39%;margin-right: 2%;">
				    <h3 class="title_design">Customer</h3>
				    <h3 style="position: relative;top: -5px;" class="pad_left_8"><input type="text" name="scCustType" id="scCustType" style="width:110px;" class="input2"></h3>
			        <!-- opus_design_grid(S) -->
			        <div class="opus_design_grid">
						<script type="text/javascript">ComSheetObject('t1sheet4');</script>
			        </div>
		       		 <!-- opus_design_grid(E) -->
				</div>		       		 

			    <div class="layout_vertical_2" style="width: 59%;">
			     	<h3 class="title_design">Commodity</h3>
			     	<h3 style="height: 25px">&nbsp;</h3>
			        <!-- opus_design_grid(S) -->
			        <div class="opus_design_grid">
						<script type="text/javascript">ComSheetObject('t1sheet5');</script>
			        </div>
				    <!-- opus_design_grid(E) -->
			    </div>
			</div>
			<!-- layout_wrap(E) -->
		</div>
	</div>
	
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none;">
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		<div class="opus_design_inquiry">
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
			    <div class="layout_vertical_2" style="width: 39%;margin-right: 2%;">
				    <h3 class="title_design">Multi Origin or Destination</h3>
				    <h3 style="height: 29px">&nbsp;</h3>
			        <!-- opus_design_grid(S) -->
			        <div class="opus_design_grid">
			        	<script type="text/javascript">ComSheetObject('t2sheet2');</script>
			        </div>
			        <!-- opus_design_grid(E) -->
			    </div>
			    
			    <div class="layout_vertical_2" style="width: 59%;">
			    	<h3 class="title_design">Rate Adjustment</h3>
			    	<h3 class="pad_left_12">Currency</h3>
			    	<h3 style="position: relative;top: -5px;" class="pad_left_8"><input type="text" name="rfaCurrency" id="rfaCurrency" style="width:45px;text-align:center;" class="input2"></h3>
					<!-- opus_design_btn (S) -->
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_Affiliate" id="btn_Affiliate">Affiliate</button>
					</div>
			        <!-- opus_design_grid(S) -->
			        <div class="opus_design_grid">
			        	<script type="text/javascript">ComSheetObject('t2sheet3');</script>
			        </div>
			        <!-- opus_design_grid(E) -->
			    </div>
			</div>
			<!-- layout_wrap(E) -->
			
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
			    <div class="layout_vertical_2" style="width: 39%;margin-right: 2%;">
				    <h3 class="title_design">Tiered Free Time</h3>
				    <h3 style="height: 29px">&nbsp;</h3>
			        <!-- opus_design_grid(S) -->
			        <div class="opus_design_grid">
			        	<script type="text/javascript">ComSheetObject('t2sheet4');</script>
			        </div>
			        <!-- opus_design_grid(E) -->
			    </div>
			    
			    <div class="layout_vertical_2" style="width: 59%;">
			    	<h3 class="title_design">Commodity</h3>
			    	<h3 style="height: 29px">&nbsp;</h3>
			    	<!-- opus_design_grid(S) -->
			        <div class="opus_design_grid">
			        	<script type="text/javascript">ComSheetObject('t2sheet5');</script>
			        </div>
			        <!-- opus_design_grid(E) -->
			    </div>
			</div>
			<!-- layout_wrap(E) -->
		</div>
	</div>
<!-- opus_design_grid(S) -->	
</div>

<% if (!isPopup) { %>
</div>
<% } %>

</form>