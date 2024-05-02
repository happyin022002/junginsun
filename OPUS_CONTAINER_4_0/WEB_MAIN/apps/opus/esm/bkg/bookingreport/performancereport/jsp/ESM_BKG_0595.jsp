<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0595.jsp
*@FileTitle  : Freight & Charge Summary Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0595Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0595Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0595Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--
	--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!--
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="100"/>
				<col width="80"/>
				<col width="100"/>
				<col width="80"/>
				<col width="80"/>
				<col width="60"/>
				<col width="*" />
		    </colgroup>
		    <tbody>
				<tr>
					<th>Booking No.</th>
					<td><input type="text" style="width:100px;" name="bkg_no" value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="Booking No." maxlength="13"></td>
					<th>B/L No.</th>
					<td><input type="text" style="width:110px;" name="bl_no" value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="B/L No." maxlength="13"  fullfill></td>
					<th>Lane</th>
					<td><input type="text" style="width:60px;" name="slan_cd" value="" class="input" style="ime-mode:disabled" dataformat="enguponly" caption="Lane" maxlength="3"  fullfill></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:90px;" name="vvd_cd" value="" class="input1" style="ime-mode:disabled" dataformat="engup" caption="VVD CD" maxlength="9" required fullfill></td></tr>
				<tr>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:60px;" name="pol_cd"  value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="POL" maxlength="5"  fullfill>&nbsp;(<input type="checkbox" name="pre_rly_port_cd" class="trans">&nbsp;Local)</td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:60px;" name="pod_cd"  value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="POD" maxlength="5"  fullfill>&nbsp;(<input type="checkbox" name="pst_rly_port_cd"  class="trans">&nbsp;Local)</td>
					<th title="Place of Receipt">POR</th>
					<td><input type="text" style="width:60px;" name="por_cd"  value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="POR" maxlength="5"  fullfill></td>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text" style="width:60px;" name="del_cd"  value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="DEL" maxlength="5"  fullfill></td>
				</tr>
				<tr>
					<th>Sales Office</th>
					<td><input type="text" style="width:60px;" name="ob_sls_ofc_cd"  value="" class="input" style="ime-mode:disabled" dataformat="enguponly" caption="Sales Office" maxlength="5"  fullfill></td>
					<td></td>
					<td></td>				
					<th>Booking Office</th>
					<td><input type="text" style="width:60px;" name="bkg_ofc_cd"  value="" class="input" style="ime-mode:disabled" dataformat="enguponly" caption="Booking Office" maxlength="5"  fullfill></td>
					<td></td>
					<td></td>				
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
			 	<colgroup>
			 		<col width="80"/>
					<col width="300"/>
					<col width="80"/>
					<col width="60"/>
					<col width="200"/>
					<col width="*" />
			    </colgroup>
				<tr>
					<th class="sm">Customer</th>
					<td class="sm"><!--
					--><input type="checkbox" name="cust_tp_cd" 	value= "S" class="trans">&nbsp;SHPR&nbsp;&nbsp;<!--
					--><input type="checkbox" name="cust_tp_cd" 	value= "C" class="trans">&nbsp;CNEE&nbsp;&nbsp;<!--
					--><input type="checkbox" name="cust_tp_cd" 	value= "N" class="trans">&nbsp;NTFY&nbsp;&nbsp;<!--
					--><input type="checkbox" name="cust_tp_cd" 	value= "A" class="trans">&nbsp;ANFY&nbsp;&nbsp;<!--
					--><input type="checkbox" name="cust_tp_cd" 	value= "F" class="trans">&nbsp;FWDR&nbsp;&nbsp;<!--
					--><input type="text" style="width:25px;" name="cust_cnt_cd"  value="" class="input" style="ime-mode:disabled" dataformat="engup" caption="Country" maxlength="2" ><!--
					--><input type="text" style="width:60px;" name="cust_seq" value="" class="input" style="ime-mode:disabled" dataformat="num" caption="Cust" maxlength="6"><!--
					--><button type="button" id="btn_ComEns041Pop" name="btn_ComEns041Pop" class="input_seach_btn"></button><!--
					--></td>
					<td></td>
					<th class="sm">Special</th>
					<td class="sm"><!--
					--><input type="checkbox" name="dcgo_flg" 		value= "Y"  class="trans">&nbsp;DG&nbsp;&nbsp;<!--
					--><input type="checkbox" name="rc_flg"   		value= "Y"  class="trans">&nbsp;RF&nbsp;&nbsp;<!--
					--><input type="checkbox" name="awk_cgo_flg" 	value= "Y"  class="trans">&nbsp;AK&nbsp;&nbsp;<!--
					--><input type="checkbox" name="bb_cgo_flg" 	value= "Y"  class="trans">&nbsp;BB&nbsp;&nbsp;<!--
					--><input type="checkbox" name="rd_cgo_flg" 	value= "Y"  class="trans">&nbsp;RD<!--
					--></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="180"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="200"/>
					<col width="100"/>
					<col width="*" />
			    </colgroup>
				<tr>
					<th>Commodity</th>
					<td><!--
					--><input type="text" style="width:35px;" name="rep_cmdt_cd" value="" class="input" style="ime-mode:disabled" dataformat="num" caption="Rep. Commodity Code" maxlength="4"><!--
					--><input type="text" style="width:60px;" name="cmdt_cd" value="" class="input" style="ime-mode:disabled" dataformat="num" caption="Commodity Code" maxlength="6"><!--
					--><button type="button" class="input_seach_btn" name="btn_CommodityPop" id="btn_CommodityPop"></button><!--
					--></td>
					<th>E/Q Type/Size</th>
					<td><script type="text/javascript">ComComboObject('cntr_tpsz_cd', 2, 40, 0,0,0);</script></td>
					<th>Freight Charge Type</th>
					<td><script type="text/javascript">ComComboObject('frt_chg_tp_cd', 2, 170, 0,0,1,false);</script></td>
					<th>Revenue Class</th>
					<td><script type="text/javascript">ComComboObject('chg_rev_tp_cd', 2, 190, 0,0,1);</script></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->	
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100">
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Sorting Priority</th>
					<td><select name="sorting_priority" style="width:120px;"><!--
						--><option value="" selected></option><!--
						--><option value="VB.SLAN_CD">Lane</option><!--
						--><option value="VB.POR_CD">POR</option><!--
						--><option value="VB.DEL_CD">DEL</option><!--
						--><option value="VB.POL_CD">Booking's POL</option><!--
						--><option value="VB.POD_CD">Booking's POD</option><!--
						--><option value="VB.PRE_POL_CD">Pre's POL</option><!--
						--><option value="VB.PRE_POD_CD">Pre's POD</option><!--
						--><option value="VB.POST_POL_CD">Post's POL</option><!--
						--><option value="VB.POST_POD_CD">Post's POD</option><!--
						--><option value="VB.CMDT_CD">Commodity</option><!--
						--><option value="BKG_RATE.RAT_UT_CD">E/Q Type/Size</option><!--
						--><option value="VB.BKG_OFC_CD">Booking Office</option><!--
						--><option value="VB.OB_SLS_OFC_CD">Sales Office</option><!--
						--><option value="VB.CONSIGNEE">Shipper</option><!--
						--><option value="VB.CONSIGNEE">Consignee</option><!--
						--><option value="VB.NTFY">Notify</option><!--
						--><option value="VB.FFDR">F/Forwarder</option><!--
						--><option value="VB.TRUNK_POL">Trunk's POL</option><!--
						--><option value="VB.TRUNK_POD">Trunk's POD</option><!--
						--><option value="VB.BKG_NO">BKG_NO</option><!--
						--></select></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
	    	
<!-- 개발자 작업  끝 -->
</form>