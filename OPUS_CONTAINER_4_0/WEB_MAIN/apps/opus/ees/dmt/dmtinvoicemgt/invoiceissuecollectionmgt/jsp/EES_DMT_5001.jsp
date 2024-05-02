<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_5001.jsp
*@FileTitle  : A/R Interface Status Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt5001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTInvoiceMgt.invoiceissuecollectionmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();


		event = (EesDmt5001Event)request.getAttribute("Event");
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" 				id="f_cmd">
<input type="hidden" name="pagerows" 			id="pagerows">
<input type="hidden" name="button_mode" 		id="button_mode">
<input type="hidden" name="tab_order" 			id="tab_order">
<input type="hidden" name="init_flg" 			id="init_flg">

<input type="hidden" name="usr_ofc_cd" 			id="usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_ofc_cd_t2" 		id="usr_ofc_cd_t2" value="<%=strUsr_ofc%>">
<input type="hidden" name="ofc_cd" 				id="ofc_cd">
<input type="hidden" name="ofc_cd_t1" 			id="ofc_cd_t1">
<input type="hidden" name="ofc_cd_t2" 			id="ofc_cd_t2">

<input type="hidden" name="usr_trf_tp" 			id="usr_trf_tp">
<input type="hidden" name="ofc_tp" 				id="ofc_tp">
<input type="hidden" name="dmdt_trf_cd" 		id="dmdt_trf_cd">
<input type="hidden" name="s_cust_gubun" 		id="s_cust_gubun">
<input type="hidden" name="s_cust_cd" 			id="s_cust_cd">
<input type="hidden" name="s_cust_gubun_t2" 	id="s_cust_gubun_t2">
<input type="hidden" name="s_cust_cd_t2" 		id="s_cust_cd_t2">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_detail" 	id="btn_detail">Detail</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search_tab">
</div>
<!-- opus_tab_btn(S) -->
<div class="wrap_result">
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>

<!-- opus_tab_btn(E) -->

<!-- opus_design_grid(S) -->	
<div class="opus_design_grid " name="tabLayer" id="tabLayer"">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="70"/>
					<col width="310"/>
					<col width="60"/>
					<col width="230"/>
					<col width="80"/>
					<col width="200"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Office</th>
					<td>
						<select name="r_office" id="r_office" style="width:90px;" class="input" >
							<option value="1"  selected>A/R I/F</option>
							<option value="2">Issue</option>
						</select><!-- 
						 --><script type="text/javascript">ComComboObject('office', 2, 80, 0, 1, 0, true);</script><!-- &nbsp;
						 --><button type="button" class="multiple_inq"></button><!-- 
						 --><input type="checkbox" name="chk_sub_ofc" id="chk_sub_ofc" value="Y" class="trans" onClick="doInclSubOfc()">&nbsp;<lable for="chk_sub_ofc">Incl. Sub Office</lable>
					</td>
					<th>I/F Date</th>
					<td >
						<input type="text" name="fm_dt" 	id="fm_dt" style="width:80px;" class="input1" dataformat="ymd"  caption="From Date">~&nbsp;<!-- 
						 --><input type="text" name="to_dt" 	id="to_dt" style="width:80px;" class="input1" dataformat="ymd"  caption="To Date" ><!-- 
						<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:pointer" >
						 --><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button>
					</td>
					<th>Tariff Type</th>
					<td>
						<script type="text/javascript">ComComboObject('tariff_type', 2, 156, 0, 1);</script><!-- &nbsp;
						 --><button type="button" class="multiple_inq"></button>
					</td>
					<td></td>					
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="70"/>
					<col width="320"/>
					<col width="60"/>
					<col width="220"/>
					<col width="200"/>
					<col width="200"/>
					<col width="*"/>
			    </colgroup>
				<tr >
					<th>Customer</th>
					<td  colspan="5"><select name="cust_type" id="cust_type" style="width:90px;" class="input">
							<option value="P" selected>Payer</option>
							<option value="S">SHPR</option>
							<option value="C">CNEE</option>
							<option value="N">NTFY</option>
						</select><!-- 
						 --><input type="text" name="cust_cd" 	id="cust_cd" style="width:80px;" dataformat="engup" class="input" caption="Customer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('engup')" ><!-- 
						<img src="img/btns_search.gif" name="btns_search1" width="19"height="20"alt=""border="0"align="absmiddle" class="cursor" onClick="openPopup('cust_cd')">
						 --><button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1" onClick="openPopup('cust_cd')"></button><!-- 
						 --><input type="text" name="cust_nm" 	id="cust_nm" style="width:660px;" class="input2" readOnly>
						<!-- Customer //-->
					</td>
					<td></td>
				</tr> 
			</tbody>
		</table>
	</div>
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>
<div class="opus_design_grid " name="tabLayer" id="tabLayer">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="280"/>
					<col width="80"/>
					<col width="273"/>
					<col width="50"/>
					<col width="90"/>
					<col width="50"/>
					<col width="90"/>
					<col width="*"/>
			    </colgroup>
				<tr >
					<th>A/R Office</th>
					<td>
						<script type="text/javascript">ComComboObject('office_t2', 2, 80, 0, 1, 0, true);</script><!-- &nbsp;
						<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">
						 --><button type="button" class="multiple_inq"></button><!-- 
						 --><input type="checkbox" name="chk_sub_ofc_t2" id="chk_sub_ofc_t2" value="Y" class="trans" onClick="doInclSubOfcT2()">&nbsp;<lable for="chk_sub_ofc_t2">Incl. Sub Office</lable>
					</td>					
					<th>I/F Date</th>
					<td >
						<input type="text" name="fm_dt_t2" id="fm_dt_t2" style="width:80px;" class="input1" dataformat="ymd"  caption="From Date">~&nbsp;<!-- 
						 --><input type="text" name="to_dt_t2" id="to_dt_t2" style="width:80px;" class="input1" dataformat="ymd"  caption="To Date" ><!-- 
						<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:pointer" > --><!-- 
						 --><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button>
					</td>
					<th>Charge</th>
					<td>
						<select name="chg_cd" id="chg_cd" style="width:51px;" class="input1">
							<option value="" selected>All</option>
							<option value="DEM">DEM</option>
							<option value="DET">DET</option>
						</select>
					<th>Bound</th>
					<td>
						<select name="io_bnd_cd" id="io_bnd_cd" style="width:86px;" class="input1">
							<option value="" selected>All</option>
							<option value="O">Outbound</option>
							<option value="I">Inbound</option>
						</select>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="710"/>
					<col width="80"/>
					<col width="100"/>
					<col width="*"/>
			    </colgroup>
				<tr >
					<th>A/R Actual Cust.</th>
					<td>
						<input type="text" name="act_cust_cd" id="act_cust_cd" style="width:80px;" dataformat="engup" class="input" caption="Customer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" ><!--  
						<img src="img/btns_search.gif" name="btns_search1" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('act_cust_cd')">
						 --><button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1" onClick="openPopup('act_cust_cd')"></button><!-- 
						 --><input type="text" name="act_cust_nm" id="act_cust_nm" style="width:622px;" class="input2" readOnly>
					</td>
					<th>Type</th>
					<td>
						<select name="type" id="type" style="width:86px;" class="input">
							<option value="" selected>All</option>
							<option value="BKG">BKG</option>
							<option value="MRI">MRI</option>
						</select>
					</td>
					<td> </td>
				</tr>  
			</tbody>
		</table>
	</div>
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>