<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3013.jsp
*@FileTitle  : Demand Note Issue
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";	
	
	Logger log = Logger.getLogger("com.clt.apps.DMTInvoiceMgt.demandnotesend");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EesDmt3013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
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
<!-- main -->
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>" id="usr_ofc_cd" />
<input type="hidden" name="usr_trf_tp" id="usr_trf_tp" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd" />
<input type="hidden" name="dmdt_chg_sts_cd" id="dmdt_chg_sts_cd" />
<input type="hidden" name="dmdt_chg_sts_cd_2" id="dmdt_chg_sts_cd_2" />
<!-- date -->
<input type="hidden" name="yd_cd1" id="yd_cd1" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<!-- vvd cd -->
<input type="hidden" name="all_office" id="all_office" />
<input type="hidden" name="fm_dt" id="fm_dt" />
<input type="hidden" name="to_dt" id="to_dt" />

	<!-- page(S) -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_demand" id="btn_demand" onmouseover="obj_mouseover()" onmouseout="obj_mouseout()">Demand</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_grp_demand" id="btn_grp_demand" title="Demand Note Issue by Tariff/Payer Group" >Group Demand</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>						
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
	<!--Page Title, Historical (E)-->
<!-- Developer's task	-->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
    <div id="sch_cond_div" style=display:block;>
	<table>
	<colgroup>
			<col width="40">				
			<col width="40">	
			<col width="92">			
			<col width="35">				
			<col width="40">				
			<col width="129">				
			<col width="100">				
			<col width="65">				
			<col width="110">						
			<col width="*">			
	   </colgroup> 
	   <tbody> 
		<tr>
			<th>Office </th>
			<td><script type="text/javascript">ComComboObject('office', 2, 80, 0, 1, 0, true);</script></td>
			<th>Tariff type </th>
			<td><script type="text/javascript">ComComboObject('tariff_type', 2, 70, 0, 1);</script></td>
			<th>Status</th>
			<td><script type="text/javascript">ComComboObject('status01', 2, 80, 1, 1);</script><button type="button" class="multiple_inq ir"></button>
			<th>Group by </th>
			<td><select style="width:130px;" name="grp_type" id="grp_type" class="input">
				<option value="1" selected>B/L No.(BKG No.)</option><!-- 
				 --><option value="2">CNTR No.</option>
			</select>
			</td>
			<td id='td_gb' onmouseover="obj_mouseover()" onmouseout="obj_mouseout();">G/B&nbsp;
				<select name="chg_type" id="chg_type" style="width:50px;" class="input">
					<option value="" selected>All</option><!-- 
					 --><option value="G">General</option><!-- 
					 --><option value="B">Balance</option>
				</select>
			</td>
			<td>
			<select name="day_type" id="day_type" style="width:110px;font-weight:bold;background-color:#F3F2F8;" class="input">
				<option value="1" selected><b>F/T Over Day</b></option>
				<option value="2"><b>Staying Day</b></option>
			</select>
			<input type="text" style="width:40px;" name="fx_ft_ovr_dys" dataformat="num" maxlength="3" caption="F/Time Over Day" class="input" value="" id="fx_ft_ovr_dys" />
			</td>
		</tr>
	</tbody>
	</table>
	<table>
		<colgroup>
			<col width="110">				
			<col width="80">				
			<col width="322">				
			<col width="58">				
			<col width="50">				
			<col width="50">							
			<col width="*">					
	   </colgroup> 
	   <tbody> 
		<tr>
			<th class="sm" style="text-align:left;"><input type="radio" name="cond_type" value="date" class="trans" checked="" onclick="condType_click()" onblur="obj_blur()" id="cond_type" /> Date</th>
			<td class="sm">Period</td>
			<td class="sm"><input type="text" style="width:80px;" class="input1" name="fm_mvmt_dt1" dataformat="ymd" caption="From Date" id="fm_mvmt_dt1" />~ <input type="text" style="width:80px;" class="input1" name="to_mvmt_dt1" dataformat="ymd" caption="To Date" id="to_mvmt_dt1" /><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
			<td class="sm">Location</td>
			<td class="sm" colspan="3"><input type="radio" name="loc_type" value="1" class="trans" checked="" onclick="locType_click()" id="loc_type" /><label for ="loc_type">From Yard</label><!-- 
				 --><input type="radio" name="loc_type" value="2" class="trans" onclick="locType_click()"><label for ="yd_cd">POR/DEL</label><!-- 
				  --><input type="text" name="yd_cd" dataformat="engup" maxlength="5" onkeyup="obj_keyup()" style="width:60px;" class="input" id="yd_cd" /><!-- 
				  --><script type="text/javascript">ComComboObject('yd_cd2', 2, 45 , 0);</script>
			</td>
		</tr>
		<tr>
			<th class="sm" style="text-align:left;"><input type="radio" name="cond_type" value="vvd_cd" class="trans" onclick="condType_click()" onblur="obj_blur()" id="cond_type" /> VVD CD</th>
			<td class="sm">VVD CD.</td>
			<td class="sm"><input type="text" name="vvd_cd" dataformat="engup" maxlength="9" style="width:100px;" class="input" value="" id="vvd_cd" /></td>
			<td class="sm" style="text-align:right">Port&nbsp;</td>
			<td class="sm" colspan="3"><input type="text" name="port_cd" dataformat="engup" maxlength="5" onkeyup="obj_keyup()" style="width:50px;" class="input" id="port_cd" /><input type="checkbox" name="chk_all_office" id="chk_all_office" value="Y" class="trans" onclick="chkAllOffice_click()">All Office</td>
		</tr>
		<tr>
			<th class="sm" style="text-align:left;"><input type="radio" name="cond_type" value="cntr" class="trans" onclick="condType_click()" onblur="obj_blur()" id="cond_type" /> CNTR</th>
			<td class="sm">BKG No.</td>
			<td class="sm"><input type="text" name="bkg_no" dataformat="engup" style="width:100px;ime-mode:disabled;" class="input" value="" id="bkg_no" /><button type="button" id="btns_bkg_multisearch" name="btns_bkg_multisearch" class="multiple_inq ir" onClick="openPopup('bkg_no')"></button></td>
			<td class="sm" style="text-align:right">B/L No.</td>
			<td class="sm"><input type="text" name="bl_no" dataformat="engup" style="width:100px;ime-mode:disabled;" class="input" value="" id="bl_no" /><button type="button" id="btns_bl_multisearch" name="btns_bl_multisearch" class="multiple_inq ir" onClick="openPopup('bl_no')"></button></td>
			<td class="sm">CNTR No.</td>
			<td class="sm"><input type="text" name="cntr_no" dataformat="engup" style="width:100px;ime-mode:disabled;" class="input" value="" id="cntr_no" /><button type="button" id="btns_cntr_multisearch" name="btns_cntr_multisearch" class="multiple_inq ir" onClick="openPopup('cntr_no')"></button></td>
		</tr>
		</tbody>
	</table>
	<table>
		<colgroup>
			<col width="50" />				
			<col width="50" />				
			<col width="50" />				
			<col width="162" />				
			<col width="50" />				
			<col width="135" />				
			<col width="60" />				
			<col width="*" />					
	   </colgroup> 
	   <tbody> 
		<tr>
			<th>Customer</th>
			<td><select name="cust_type" style="width:55px;" class="input">
				<option value="" selected>ALL</option><!-- 
				 --><option value="P">Payer</option><!-- 
				 --><option value="S">SHPR</option><!-- 
				 --><option value="C">CNEE</option><!-- 
				 --><option value="N">NTFY</option><!-- 
				 --><option value="A">A/R</option>
				</select><input type="text" name="cust_cd"  dataformat="engup"  maxlength=8  style="width:100px;" class="input" caption="Customer Code"><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"  onClick="openPopup('cust_cd')"></button></td>
			<th>Service Provider</th>
			<td><input type="text" name="svc_provdr" maxlength="6" dataformat="num" fulfill="" style="width:100px;" class="input" value="" caption="Service Provider" id="svc_provdr" /><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn" onClick="openPopup('svc_provdr')"></button></td>
			<th style="text-align:left">S/C No.</th>
			<td><input type="text" name="sc_no" dataformat="engup" maxlength="20" style="width:100px;" class="input" value="" caption="S/C No." id="sc_no" /> </td>
			<th>RFA No.</th>
			<td><input type="text" name="rfa_no" dataformat="engup" maxlength="11" style="width:100px;" class="input" value="" caption="RFA No." id="rfa_no" /> </td>
		</tr>
		</tbody>
		</table>
		</div>
</div>
</div>

<div class="wrap_result">				
<div class="opus_design_grid" id="mainTable" >										
		<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
				<!-- opus_design_grid(E) -->
</div>
<!-- Copyright (S) -->
<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>
<!-- Copyright(E)-->

<!-- Developer's task end -->
</form>
