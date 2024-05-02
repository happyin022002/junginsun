<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0104.js
*@FileTitle  : Forecast History 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0104Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	
	EsmSpc0104Event  event    = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.DailyForecast.Dailyforecastmanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
%>


<script type="text/javascript">	
	var ofc_cd = "<%=ofc_cd%>";	
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  		id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab" id="zoomarea0">
	<div class= "opus_design_inquiry wFit">
		<!-- 2014.08.06 김용습 - 탭변경시 정렬이 맞지 않게 되어 정렬 수정 -->
		<table>
			<tbody>
				<colgroup>
					<col width="1"/>
					<col width="170"/>
					<col width="30"/>
					<col width="120"/>
					<col width="150"/>
					<!-- 추가 -->
					<col width="100"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Start Week</th>
					<td><select class="input1" name="year" id="year" style="width:78px;"></select><select class="input1" name="week" id="week" style="width:60px;"></select></td>
					<th>Duration</th>
					<td><select class="input1" name="duration" id="duration" size="1"></select></td>
					<!-- <td colspan="2"> -->
					<td><input type="radio" class="trans" name="ioc" id="id_chk_ocn" value="O" checked="" /><label for="id_chk_ocn">OCN</label><!--
						--><input type="radio" class="trans" name="ioc" id="id_chk_ipc" value="I" /><label for="id_chk_ipc">IPC</label><!--
						--><input type="radio" class="trans" name="ioc" id="id_chk_ts" value="T" /><label for="id_chk_ts" align="left">TS</label>
					</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input class="input1" type="text"  style="width:80px;" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" dataformat="engup" onchange="vvdChanged();" id="vvd" /></td>
				</tr>
				<tr>
					<th>Trade</th>
					<td><script type="text/javascript">ComComboObject("trade", 2, 142, 0, 1);</script></td>
					<th>Sub Trade</th>
					<td><script type="text/javascript">ComComboObject("subTrade", 3, 80, 0, 0, 1);</script></td>					
					<td><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lane</b> 
						<script type="text/javascript">ComComboObject("lane", 4, 70, 0, 1, 2);</script>
					</td>
					<th>Bound</th>
					<td><select name="bound" id="bound" style="width:80px;"></select></td>
				</tr>
				<tr>
					<th>RGN Office</th>
					<td><script type="text/javascript">ComComboObject("salesOffice", 2, 142, 0, 1);</script></td>
					<th>Sub-Office</th>
					<td><script type="text/javascript">ComComboObject("subOffice", 2, 80, 0);</script></td>
					<!-- td id="salesreppopup1" name="salesreppopup1">Sales Rep&nbsp;</td -->
					<td id="salesreppopup1" style="padding-left:1px"><b>Sales Rep</b>
						<script type="text/javascript">ComComboObject("salesRep", 4, 70, 0);</script>
					</td>
					<th><div id="accountpopup1">Account</div></th>
					<td><div id="accountpopup2">
						<input name="customer" type="text" style="width:80px;ime-mode:disabled;" maxlength="8"  dataformat="engup" value="" onchange="return customer_OnChange();" onkeypress="return customer_OnKeyPress();" onkeydown="return customer_OnKeyDown();" id="customer" /><!-- 
						 --><button type="button" id="btn_popup_customer" name="btn_popup_customer" class="input_seach_btn"></button>
						<input name="customerNm" type="hidden" style="width:275px;" value="" readonly="" tabindex="-1" id="customerNm" />
						<input name="customerCo" type="hidden" style="width:30px;" value="" id="customerCo" />
						<input name="customerCd" type="hidden" style="width:60px;" value="" id="customerCd" />
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab sm" id="zoomarea1">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" name="tabLayer" style="display:inline">
		<div class="opus_design_inquiry" id="zoomarea2">
			<!-- 2014.08.06 김용습 - 정렬이 망가져 디자인 수정 -->
			<table>
				<colgroup>
					<col width="103"/>
					<col width="20"/>
					<col width="1"/>
					<col width="1"/>
					<col width="20"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<td>
						Data Selection : 
					</td>
					<td>
						<input type="hidden" class="trans" name="chkDs1OFC" id="ds1OFC"  checked onclick="return changeDataSelection1();" ><label for="ds1OFC"></label><!--
						--><input  type="checkbox" class="trans" name="chkDs1POL" id="ds1POL"   onclick="return changeDataSelection1();" ><label for="ds1POL">POL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					</td>
					<td id="divDs1POD">
						<input type="checkbox" class="trans" name="chkDs1POD" id="ds1POD"   onclick="return changeDataSelection1();" >
					</td>
					<td id="divDs1POD">
						<label for="ds1POD">POD</label>
					</td>
					<td>
						<input type="hidden" class="trans" name="chkDs1OTH" id="ds1OTH" onclick="return changeDataSelection1();" ><label for="ds1OTH"></label><!--
						--><input type="checkbox" class="trans" name="chkDs1HC" id="ds1HC" onclick="return changeDataSelection1();" ><label for="ds1HC">HC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><!--
						--><input type="checkbox" class="trans" name="chkDs145" id="ds145" onclick="return changeDataSelection1();" ><label for="ds145">45&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><!--
						--><input type="checkbox" class="trans" name="chkDs153" id="ds153" onclick="return changeDataSelection1();" ><label for="ds153">53'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><!--
						--><input type="checkbox" class="trans" name="chkDs1RF" id="ds1RF" onclick="return changeDataSelection1();" ><label for="ds1RF">RF&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><!--
						--><input type="checkbox" class="trans" name="chkDs1WT" id="ds1WT" onclick="return changeDataSelection1();"><label for="ds1WT">WT&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					</td>
					<td>
				</tr>
			</table>
		</div>
		<div class="opus_design_grid clear" >
			<table id="sheetControlDiv" style="width:200px;margin-right:-4px;float:right;margin-bottom:5px">  
			    <tr><td align="right" class="gray"><span>Unit : TEU</span> &nbsp;<button type="button" class="btn_toggle_hide" name="maxi" id="maxi" sheetId="t1sheet1" type="N" onclick="toggleSheetSize('zoomarea0','zoomarea1','zoomarea2');" alt='Alt+↑'></button></td></tr>
			</table>
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
	</div>
	<div id="tabLayer" name="tabLayer" style="display:none">
		<div class="opus_design_inquiry" id="zoomarea3">
			<!-- 2014.08.06 김용습 - 정렬이 망가져 디자인 수정 -->
			<!-- <table>
				<colgroup>
					<col width="120"/>
					<col width="40"/>
					<col width="20"/>
					<col width="40"/>
					<col width="40"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<td>Data Selection : </td>
					<td><input type="hidden" class="trans" name="chkDs2OFC" id="ds2OFC"  checked onclick="return changeDataSelection();"><label for="ds2OFC"></label>
					<input  type="hidden" class="trans" name="chkDs2POL" id="ds2POL" checked  onclick="return changeDataSelection();"><label for="ds2POL"></label>
					<input type="checkbox" class="trans" name="chkDs2Account" id="ds2Account"  onclick="return changeDataSelection();"><label for="ds2Account">Account</label></td>
					<td id="divDs2POD"><input type="checkbox" class="trans" name="chkDs2POD" id="ds2POD"   onclick="return changeDataSelection();"></td>
					<td id="divDs2POD"><label for="ds2POD">POD</label></td>
					<td><input type="hidden" class="trans" name="chkDs2OTH" id="ds2OTH" onclick="return changeDataSelection();"><label for="ds2OTH"></label>
					<input type="checkbox" class="trans" name="chkDs2HC" id="ds2HC" onclick="return changeDataSelection();"><label for="ds2HC">HC</label>
					<input type="checkbox" class="trans" name="chkDs245" id="ds245" onclick="return changeDataSelection();"><label for="ds245">45</label>
					<input type="checkbox" class="trans" name="chkDs253" id="ds253" onclick="return changeDataSelection();"><label for="ds253">53'</label>
					<input type="checkbox" class="trans" name="chkDs2RF" id="ds2RF" onclick="return changeDataSelection();"><label for="ds2RF">RF</label>
					<input type="checkbox" class="trans" name="chkDs2WT" id="ds2WT" onclick="return changeDataSelection();"><label for="ds2WT">WT</label></td>
				</tr>
			</table> -->
			<table>
				<colgroup>
					<col width="30"/>
					<col width="20"/>
					<col width="1"/>
					<col width="1"/>
					<col width="20"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<td>
						Data Selection : 
					</td>
					<td>
						<input type="hidden" class="trans" name="chkDs2OFC" id="ds2OFC"  checked onclick="return changeDataSelection(this);"><label for="ds2OFC"></label><!--
						--><input  type="hidden" class="trans" name="chkDs2POL" id="ds2POL" checked  onclick="return changeDataSelection(this);"><label for="ds2POL"></label><!--
						--><input type="checkbox" class="trans" name="chkDs2Account" id="ds2Account"  onclick="return changeDataSelection(this);" checked disabled><label for="ds2Account">Account&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					</td>
					<td id="divDs2POD">
						<input type="checkbox" class="trans" name="chkDs2POD" id="ds2POD"   onclick="return changeDataSelection(this);" checked disabled>
					</td>
					<td id="divDs2POD">
						<label for="ds2POD">POD</label>
					</td>
					<td>
						<input type="hidden" class="trans" name="chkDs2OTH" id="ds2OTH" onclick="return changeDataSelection(this);"><label for="ds2OTH"></label><!--
						--><input type="checkbox" class="trans" name="chkDs2HC" id="ds2HC" onclick="return changeDataSelection(this);"><label for="ds2HC">HC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><!--
						--><input type="checkbox" class="trans" name="chkDs245" id="ds245" onclick="return changeDataSelection(this);"><label for="ds245">45&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><!--
						--><input type="checkbox" class="trans" name="chkDs253" id="ds253" onclick="return changeDataSelection(this);"><label for="ds253">53'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><!--
						--><input type="checkbox" class="trans" name="chkDs2RF" id="ds2RF" onclick="return changeDataSelection(this);"><label for="ds2RF">RF&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><!--
						--><input type="checkbox" class="trans" name="chkDs2WT" id="ds2WT" onclick="return changeDataSelection(this);"><label for="ds2WT">WT&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					</td>
					<td><button type="button" class="btn_normal" name="btn_directDown"  		id="btn_directDown">Direct Excel</button>	
					</td>
				</tr>
			</table>
		</div>
		<div class="opus_design_grid clear" >
			<table id="sheetControlDiv" style="width:200px;margin-right:-4px;float:right;margin-bottom:5px">
			    <tr><td align="right" class="gray"><span>Unit : TEU</span> &nbsp;<button type="button" class="btn_toggle_hide" name="maxi" id="maxi" sheetId="t1sheet2" type="N" onclick="toggleSheetSize('zoomarea0','zoomarea1','zoomarea3');" alt='Alt+↑'></button></td></tr>
			</table>
			<script type="text/javascript">ComSheetObject('t1sheet2');</script>
		</div>
	</div>
</div>
</form>