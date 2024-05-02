<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_5002.jsp
*@FileTitle  : Invoice Interface to A/R
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt5002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd    = "";
	Logger log = Logger.getLogger("com.clt.apps.DMTInvoiceMgt.invoiceissuecollectionmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();


		event = (EesDmt5002Event)request.getAttribute("Event");
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

<script language="javascript">
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
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="rhq_ofc_cd" value="<%=strRhq_ofc_cd%>">

<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="ofc_tp">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="chk_hold">

<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->

	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button><!--
			--><button type="button" class="btn_normal" name="btn_detail" id="btn_detail">Detail</button><!--
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


<!-- opus_design_inquiry(S) -->
<div class="wrap_search ">
	<div class="opus_design_inquiry wFit" id="sch_cond_div" style=display:block;>		
		<table> 
			<colgroup>
				<col width="90px" />
				<col width="50px" />
				<col width="200px" />
				<col width="90px" />
				<col width="125px" />
				<col width="90px" />
				<col width="" />
				<col />
			</colgroup>
			<tbody>
       		<tr style="height:33px">
				<th>
					Issue Office
				</th>
				<td>
					<script type="text/javascript">ComComboObject('office', 2, 80, 0, 1, 0, true);</script>
				</td>
				<th>
					Tariff type 
				</th>
				<td colspan="4">
					<script type="text/javascript">ComComboObject('tariff_type', 2, 250, 0, 1);</script>
					<input type="hidden" name="chk_hold_box" value="" class="trans">
				</td>
			</tr>
			<tr class="sm" style="height:31px;">
				<th style="text-align:left;padding-left:20px"><input type="radio" id="radion_01" value="date" name="cond_type" id="cond_type" checked onclick="condType_click()"/><!--
					--><label for="radion_01" >Date</label>
				</th>
				<td style="text-align:right">
					Issued Date
				</td>
				<td colspan="5">
					<input type="text" style="width:84px;ime-mode:disabled;" class="input" tabindex="1" name="fm_dt" dataformat="ymd" caption="From Date">~&nbsp;<!--
                  --><input type="text" style="width:85px;ime-mode:disabled;" class="input"  tabindex="2" name="to_dt" dataformat="ymd" caption="To Date"><!--
                  --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
				</td>
			</tr>
			<tr class="sm" style="height:31px">
				<th style="text-align:left;padding-left:20px"><input type="radio" id="radion_02" value="inv" name="cond_type" onclick="condType_click()"/><!--
					--><label for="radion_02" style="padding-right:5px; !important;">INV</label>
				</th>
				<td style="text-align:right">
					INV No.
				</td>
				<td>
					<input type="text" name="inv_no" dataformat="engup" otherchar="," style="width:177px;ime-mode:disabled;" class="input" value=""><!--
					--><button type="button" class="multiple_inq ir"  name="btns_inv_multisearch" onClick="openPopup('inv_no')"></button>
				</td>
				<th>
				 	BKG No.
				</th>
				<td>
					<input type="text" name="bkg_no" dataformat="engup" otherchar="," style="width:100px;ime-mode:disabled;" class="input" value=""><!--
					--><button type="button" class="multiple_inq ir"  name="btns_bkg_multisearch" onClick="openPopup('bkg_no')"></button>
				</td>
				<th>
					B/L No.
				</th>
				<td>
					<input type="text" name="bl_no" dataformat="engup" otherchar="," style="width:100px;ime-mode:disabled;" class="input" value=""><!--
					--><button type="button" class="multiple_inq ir"  name="btns_bl_multisearch" onClick="openPopup('bl_no')"></button>
				</td>
			</tr>
			<tr style="height:33px">
				<th>
					Payer
				</th>
				<td colspan="6">
					<input type="text" name="cust_cd" style="width:69px;" dataformat="engup" class="input" caption="Customer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"><!--
					--><button type="button" class="input_seach_btn"  name="btns_search1" onClick="openPopup('cust_cd')"></button><!--  
					--><input type="text" name="cust_nm" style="width:654px;" class="input2" readOnly>
				</td>
			</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid">										
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>

</div>

</form>
