<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0548.jsp
*@FileTitle  : Wharfage Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0548Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0548Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	
	String sBound = "";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger
			.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0548Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
		
		sBound = (request.getParameter("bound")==null) ? "" : request.getParameter("bound");
		// cause Inbound / Outbound menu defferent
			String sPgmNo = (request.getParameter("pgmNo")==null) ? "" : request.getParameter("pgmNo");
		if ("".equals(sBound)) {
			if (sPgmNo.length() == 12) {
				sBound = "I";
			} else {
				sBound = "O";
			}
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
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
<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows"> 
<input type="hidden" name="frm_attr_ctnt2" id="frm_attr_ctnt2">
<input type="hidden" name="vsl_nm" id="vsl_nm">  
 <%
 	String keyAddr = (request.getParameter("keyAddr") == null) ? ""
 			: request.getParameter("keyAddr");
 %>
	<div class="page_title_area clear ">
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 	
			--><button type="button" class="btn_normal" name="btn_LocationCode" id="btn_LocationCode">Location Code</button><!-- 
			--><button type="button" class="btn_normal" name="btn_DataIF" id="btn_DataIF">Data I/F</button>	
		</div>
		<div class="location">
			<span id="navigation"></span>
		</div>
	</div>
<div class="wrap_search">	
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="110">
				<col width="40">
				<col width="90">
				<col width="40">
				<col width="150">
				<col width="60">
				<col width="160">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width: 77px; ime-mode: disabled" class="input1" name="vvd" id="vvd" dataformat="engup" maxlength="9" tabindex="1"></td>
				<th>Port</th>
				<td><input type="text" style="width:49px;ime-mode:disabled" class="input1" name="vps_port_cd" id="vps_port_cd" dataformat="engup" maxlength="5" tabindex="2"><!--  
					 --><input type="hidden" style="width: 49px;ime-mode: disabled" class="input1" name="port_cd" id="port_cd" dataformat="engup" maxlength="5">
				</td>
				<th>Bound</th>
				<td><select style="width: 100px;" class="input1" name="io_bnd_cd" id="io_bnd_cd" tabindex="3">							
						<option value="II" <%if("I".equals(sBound)) out.println("selected");%>>Inbound</option>
						<option value="OO" <%if("O".equals(sBound)) out.println("selected");%>>Outbound</option>
					</select>
					<input type="hidden" style="width: 49px;" class="input1" name="whf_bnd_cd" dataformat="ennup" maxlength="5">
				</td>
				<th>MRN No.</th>
				<td><input type="text" style="width: 110px;" class="input2" name="mrn_no" maxlength="22" readonly="readonly" tabindex="-1"></td>
				<th>Sailing Date</th>
				<td><input type="text" style="width: 80px;" class="input2" name="vps_dt" maxlength="10" dataformat="ymd" readonly="readonly" tabindex="-1"></td>
			</tr>
		</table>
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90">
				<col width="500">
				<col width="100">
				<col width="*">
			</colgroup>
			<tr>
				<th>호출부호</th>
				<td><input type="text" style="width: 107px;ime-mode:disabled" class="input" name="vsl_call_sgn_cd" maxlength="10" dataformat="engup" tabindex="4"></td>
				<th>하역회사</th>
				<td>
					<input type="text" style="width: 30px;ime-mode:disabled" class="input" name="unld_agn_cd1" maxlength="2" dataformat="engup" tabindex="10"><!-- 
				     -->&nbsp;-&nbsp; <input type="text" style="width: 20px;ime-mode:disabled" class="input" name="unld_agn_cd2" maxlength="1" dataformat="engup" tabindex="11"><!-- 
				     -->&nbsp;-&nbsp; <input type="text" style="width: 50px;ime-mode:disabled" class="input" name="unld_agn_cd3" maxlength="4" dataformat="engup" tabindex="12"><!-- 
				  --></td>
			</tr>
			<tr>
				<th>항코드</th>
				<td><input type="text" style="width: 107px;ime-mode:disabled" class="input" name="tml_cd" maxlength="3" tabindex="5"></td>
				<th>WHF 적용률</th>
				<td><input type="text" style="width: 126px; text-align: right;ime-mode:disabled" class="input" name="whf_rt" maxlength="8" dataformat="num" tabindex="13"></td>
			</tr>
			<tr>
				<th>입항 횟수</th>
				<td>
					<input type="text" style="width: 47px;ime-mode:disabled" class="input" name="arr_yr" maxlength="4" dataformat="engup" tabindex="6"><!-- 
					 -->&nbsp;-&nbsp; <input type="text" style="width: 47px;ime-mode:disabled" class="input" name="arr_tms_no" maxlength="3" dataformat="num" tabindex="7"><!-- 
				 --></td>
				<th>하역구분</th>
				<td class="stm"><!-- 
					 --><input type="radio" class="trans" name="unld_tp_cd" id="unld_tp_cd" value="1" checked="checked" tabindex="14"><label for="unld_tp_cd">일반</label><!-- 
					 --><input type="radio" class="trans" name="unld_tp_cd" id="unld_tp_cd" value="2" tabindex="15"><label for="unld_tp">기계</label>
				</td>
			</tr>
			<tr>
				<th>반출입 부두</th>
				<td><script type="text/javascript">ComComboObject('io_port_cd', 1, 140, 1, 0, 0, false, 8)</script></td>
				<th>납기일자</th>
				<td><input type="text" style="width: 127px;" class="input" name="whf_pay_dt" dataformat="ymd" maxlength="10" tabindex="16"></td>
			</tr>
			<tr>
				<th>할인률</th>
				<td><select style="width: 107px;ime-mode:disabled"name="whf_vol_dc_cd" tabindex="9">
					<option value="0" selected="selected">0%</option>
					<option value="1">20%</option>
					<option value="2">50%</option>
					<option value="3">80%</option>
					<option value="4">100%</option>
					<option value="7">30%</option>
				</select> <!-- input type="text" style="width:60px;" class="input" name="whf_vol_dc_cd" dataformat="engup"-->
				&nbsp;1.20%&nbsp;&nbsp;&nbsp;2.50%&nbsp;&nbsp;&nbsp;3.80%&nbsp;&nbsp;&nbsp;4.100%&nbsp;&nbsp;7.30%	할인
				</td>
				<th>항만</th>
				<td><input type="text" style="width: 127px;" class="input2" name="port_nm" readonly="readonly" maxlength="100" tabindex="17"></td>
			</tr>
		</table>
		<!--  biz_2  (S) --> 
	</div>
  </div>
  
  <div class="wrap_result">
	<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60">
				<col width="*">
			</colgroup>
			<tr>
				<th>LAST UPDATE:</th>
				<td><input type="text" style="width: 80px;" class="input2" name="upd_id" readonly="readonly"><!-- </td>
				<td> --><input type="text" style="width: 110px;" class="input2" name="upd_dt" readonly="readonly"></td>
			</tr>
		</table>
	</div>	
  </div>
</form>
