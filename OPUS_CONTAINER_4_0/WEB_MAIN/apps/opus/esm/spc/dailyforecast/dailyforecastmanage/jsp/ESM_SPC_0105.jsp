<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0105.jsp
*@FileTitle  : Forecast History Direct Down Excel 
*@author     : CLT
*@version    : 1.0
*@since      : 2016/01/21
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
<%@ page import="com.clt.framework.component.util.StringUtil"%>	<!-- 20160217.ADD -->
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
	} catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
%>


<script type="text/javascript">	
	var ofc_cd = "<%=ofc_cd%>";	
	
	//20160211.ADD START, 소스품질..ㅋ
	var r_year        = "<%=StringUtil.xssFilter(request.getParameter("year"))== null?"":StringUtil.xssFilter(request.getParameter("year"))%>";
	var r_week        = "<%=StringUtil.xssFilter(request.getParameter("week"))== null?"":StringUtil.xssFilter(request.getParameter("week"))%>";
	var r_duration    = "<%=StringUtil.xssFilter(request.getParameter("duration"))== null?"":StringUtil.xssFilter(request.getParameter("duration"))%>";
	var r_salesOffice = "<%=StringUtil.xssFilter(request.getParameter("salesOffice"))== null?"":StringUtil.xssFilter(request.getParameter("salesOffice"))%>";
	//20160211.ADD END
	
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
	<h2 class="page_title" id="popup_title" name="popup_title"><span>Direct Down Excel</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Down Excel</button>
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
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<!-- 2014.08.06 김용습 - 탭변경시 정렬이 맞지 않게 되어 정렬 수정 -->
		<table>
			<tbody>
				<colgroup>
					<col width="1"/>
					<col width="140"/>
					<col width="30"/>
					<col width="100"/>
					<col width="100"/>
					<!-- 추가 -->
					<col width="70"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Start Week</th>
					<td><select class="input1" name="year" id="year" style="width:60px;"></select><select class="input1" name="week" id="week" style="width:50px;"></select></td>
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
					<td><script type="text/javascript">ComComboObject("trade", 2, 114, 0, 1);</script></td>
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
					<td><script type="text/javascript">ComComboObject("salesOffice", 2, 114, 0, 1);</script></td>
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
<div class="wrap_result" >		
	<div class="opus_design_grid clear" style="display:none">
		<table id="sheetControlDiv" style="width:200px;margin-right:-4px;float:right;margin-bottom:5px">
		    <tr><td align="right" class="gray"><span>Unit : TEU</span> &nbsp;<button type="button" class="btn_toggle_hide" name="maxi" id="maxi" sheetId="t1sheet2" type="N" onclick="toggleSheetSize('zoomarea0','zoomarea1','zoomarea3');" alt='Alt+↑'></button></td></tr>
		</table>
		<script type="text/javascript">ComSheetObject('t1sheet2');</script>
	</div>
</div>
</form>