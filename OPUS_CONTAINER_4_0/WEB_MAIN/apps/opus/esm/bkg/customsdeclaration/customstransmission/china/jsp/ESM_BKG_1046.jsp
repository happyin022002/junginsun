<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1046.jsp
*@FileTitle  : China: Manifest Transmission
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg1046Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date" %>

<%
	EsmBkg1046Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	String strCnt_cd   = "";
	String strOff_cd   = "";

	String strPgmNo    = "";
	String strTransMode = "";
	String strLocNm    = "";
	boolean saveCsvFlg  = false;  // Save CSV 버튼 활성화여부
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.Customstransmission");

	String vvd  = "";
	String pol_cd  = "";
	String pod_cd  = "";
	String bkg_cgo_tp_cd  = "";
	String trans_type = "";
	String callGubun  = "";

	String date = DateTime.getFormatDate(new Date(), "yyyyMMdd") + DateTime.getShortTimeString();

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		strOff_cd = account.getOfc_cd();

		event = (EsmBkg1046Event) request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
		strTransMode = event.getTransMode();
		codeList = HttpUtil.makeXML(request,response);

		if("D".equals(strTransMode)){
			strLocNm = "POD";
		}else{
			strLocNm = "POL";
		}

		if(strCnt_cd.startsWith("CN")){  // 중국 내 지역 CSV 버튼 활성화 (홍콩 제외)
			if(!strOff_cd.startsWith("HKG")){
				saveCsvFlg = true;
			}
		}

		vvd     	  		= JSPUtil.getParameter(request, "vvd".trim(), "");
		pol_cd     			= JSPUtil.getParameter(request, "pol_cd".trim(), "");
		pod_cd     			= JSPUtil.getParameter(request, "pod_cd".trim(), "");
		bkg_cgo_tp_cd     	= JSPUtil.getParameter(request, "bkg_cgo_tp_cd".trim(), "");
		trans_type     		= JSPUtil.getParameter(request, "trans_type".trim(), "");
		callGubun     		= JSPUtil.getParameter(request, "callGubun".trim(), "");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var saveCsvFlg = <%=saveCsvFlg%>;
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cnt_cd" value="<%=strCnt_cd.substring(0,2)%>" id="cnt_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="loc_nm" value="<%=strLocNm%>" id="loc_nm" />
<input type="hidden" name="trans_mode" value="<%=strTransMode%>" id="trans_mode" />
<input type="hidden" name="gubun" id="gubun" />
<input type="hidden" name="curr_type" value="all" id="curr_type" />
<input type="hidden" name="code_list" value="<%=codeList%>" id="code_list" />
<input type="hidden" name="eta_flg" id="eta_flg" />
<input type="hidden" name="etd_flg" id="etd_flg" />
<input type="hidden" name="date" value="<%=date%>" id="date" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!--
	 --><button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Down Excel</button><!--
	 --><button type="button" class="btn_normal" name="btn_save_csv" id="btn_save_csv">Save CSV</button><!--
	 --><button type="button" class="btn_normal" name="btn_go_bl" id="btn_go_bl">Manifest(B/L)</button><!--
	 --><button type="button" class="btn_normal" name="btn_Transmit" id="btn_Transmit">Transmit Manifest</button>
		<table style="float:right; width:50px; margin-top:2px;margin-left:4px" >
			<tbody>
				<tr><td align="right">
				<% if( "D".equals(strTransMode)) { %>
					<script type="text/javascript">ComComboObject('msg_type', 1, 155, 1, 1);</script>
				<% }else{ %>
					<script type="text/javascript">ComComboObject('msg_type', 1, 120, 1, 1);</script>
				<% } %></td>
				</tr>
			</tbody>
		</table>
	</div>
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
		<table style="margin-top:4px !important;" >
		  <colgroup>
			<col width="60"/>
			<col width="90"/>
			<col width="112"/>
			<col width="70"/>
			<col width="150"/>
			<col width="150"/>
			<col width="100"/>
			<col width="150"/>
			<col width="90"/>
			<col width="170"/>
			<col width="*"/>
		  </colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd" id ="vvd" style="width:90px; ime-mode: disabled;" class="input1" dataformat="engup" maxlength="9" required fullfill caption="VVD" value="<%=vvd%>"></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol_cd" id  = "pol_cd" style="width:60px; ime-mode: disabled;" class="<%="POL".equals(strLocNm) ? "input1" : "input2" %>" dataformat="engup" maxlength="5" fullfill <%="POL".equals(strLocNm) ? "required" : "readonly" %> caption="POL" value="<%=pol_cd%>"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod_cd" id  = "pod_cd" style="width:60px; ime-mode: disabled;" class="<%="POD".equals(strLocNm) ? "input1" : "input2" %>" dataformat="engup" maxlength="5" fullfill <%="POD".equals(strLocNm) ? "required" : "readonly" %> caption="POD" value="<%=pod_cd%>"></td>
					<th>CGO TYPE</th>
					<td><select style="width:71px;" name="bkg_cgo_tp_cd" class="input1" <%="O".equals(strTransMode) ? "disabled" : "" %>>
					   <%if(callGubun.equals("ESM_BKG_0216")) { %>
						<option value=""  <%if(bkg_cgo_tp_cd.equals("")) out.print("selected"); %>>All</option>
						<option value="F" <%if(bkg_cgo_tp_cd.equals("F")) out.print("selected"); %>>Full</option>
						<option value="P" <%if(bkg_cgo_tp_cd.equals("P")) out.print("selected"); %>>Empty</option>
						<%}else{ %>
							<option value="">All</option>
							<option value="F" selected>Full</option>
							<option value="P">Empty</option>
						<%} %>
						</select>
					</td>

					<th class="sm">TRANS TYPE</th>
					<td class="sm pad_left_8">
					 <%if(callGubun.equals("ESM_BKG_0216")) { %>
					<input type="radio" class="trans" name="trans_type" id = "trans_type0" value="all" <%if(trans_type.equals("all")) out.print("checked"); %>><label for = "trans_type0">ALL</label><!--
					 --><input type="radio" class="trans" name="trans_type" id = "trans_type1" value="local" <%if(trans_type.equals("local")) out.print("checked"); %>><label for = "trans_type1">LOCAL</label><!--
					 --><input type="radio" class="trans" name="trans_type" id = "trans_type2" value="ts" <%if(trans_type.equals("ts")) out.print("checked"); %>><label for = "trans_type2">T/S</label>
					<%}else{ %>
					<input type="radio" class="trans" name="trans_type" value="all" id = "trans_type0" checked><label for = "trans_type0">ALL</label><!--
					 --><input type="radio" class="trans" name="trans_type" id = "trans_type1" value="local"><label for = "trans_type1">LOCAL</label><!--
					 --><input type="radio" class="trans" name="trans_type" id = "trans_type2" value="ts"><label for = "trans_type2">T/S</label>
					<%} %></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>

	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

	<div class="opus_design_inquiry wFit">
		<table >
		  <colgroup>
			<col width="60"/>
			<col width=150/>
			<col width="60"/>
			<col width="150"/>
			<col width="70"/>
			<col width="150"/>
			<col width="100"/>
			<col width="150"/>
			<col width="90"/>
			<col width="170"/>
			<col width="*"/>
		  </colgroup>
			<tbody>
				<tr>
					<th>Call Sign</th>
					<td><input type="text" name="call_sgn_no" id="call_sgn_no" style="width:110px;" class="input" disabled></td>
					<th>Pre. Port</th>
					<td><input type="text" name="pre_port" id="pre_port" style="width:60px;" class="input" disabled></td>
					<th>Next Port</th>
					<td><input type="text" name="nxt_port" id="nxt_port" style="width:60px;" class="input" disabled></td>
					<th>Send Date</th>
					<td><input type="text" name="snd_date"  id="snd_date" style="width:120px;" class="input" disabled></td>
					<td colspan="3"> </td>
				</tr>
				<tr>
					<th>ETA</th>
					<td><input type="text" name="vps_eta_dt"  id="vps_eta_dt" style="width:110px;" class="input" disabled></td>
					<th>ETB</th>
					<td><input type="text" name="vps_etb_dt" id="vps_etb_dt" style="width:110px;" class="input" disabled></td>
					<th>ETD</th>
					<td><input type="text" name="vps_etd_dt" id="vps_etd_dt" style="width:110px;" class="input" disabled></td>
					<th>Vessel Name</th>
					<td><input type="text" name="vsl_eng_nm" id="vsl_eng_nm" style="width:260px;" class="input" disabled></td>
					<td colspan="3"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_inquiry" style="font size:11">* Beijing Standard Time (GMT +08:00)</div>

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style = "display:none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<div class= "opus_design_inquiry">
		<table class="" style="height:35px;">
			<colgroup>
				<col width="5"/>
				<col width="80"/>
				<col width="100"/>
				<col width="80"/>
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td></td>
					<th>B/L Count</th>
					<td><input type="text" name="bl_cnt" id = "bl_cnt" style="width:80px;text-align:right;" class="input2" readonly></td>
					<th>CNTR Count</th>
					<td><input type="text" name="cntr_cnt" id = "cntr_cnt" style="width:80px;text-align:right;" class="input2" readonly></td>
				</tr>
			 </tbody>
		</table>
	</div>
</div>

</form>
<iframe name="download" id="download" style="display:none;width:1px;height:1px;" onreadystatechange="ComOpenWait(false);"></iframe>