<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0216.jsp
*@FileTitle  : China: Cross-Check & Download
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.event.EsmBkg0216Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date" %>
<%
	EsmBkg0216Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.Manifestlistdownload");
	String date = DateTime.getFormatDate(new Date(), "yyyyMMdd") + DateTime.getShortTimeString();

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		strOff_cd = account.getOfc_cd();

		event = (EsmBkg0216Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strPgmNo = request.getParameter("pgmNo");

/**
 * ESM_BKG_0216HTMLAction 으로 아래 로직 이동
 * 페이지 로딩 시 TRANS_MODE 확정

// China POL & POD Office 메뉴
if(pgmNo.endsWith("1")) {
	if(strCntCd.startsWith("CN")){  // 중국 내 지역 (홍콩 제외)
		if(strOffCd.startsWith("HKG")){
			event.setTransMode("O");
		}else{
			event.setTransMode("D");
		}
	} else {   // 중국 외 지역
		event.setTransMode("O");
	}
} else if(pgmNo.endsWith("2")){
// China Office O/B Only 메뉴
	event.setTransMode("P");
}
*/

		strTransMode = event.getTransMode();
		if ("D".equals(strTransMode)) {
			strLocNm = "POD";
		} else {
			strLocNm = "POL";
		}

//        if(strCnt_cd.startsWith("CN")){  // 중국 내 지역 CSV 버튼 활성화 (홍콩 제외)
//            if(!strOff_cd.startsWith("HKG")){
				saveCsvFlg = true;
//            }
//        }

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
			//showErrMessage(errMessage);
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
<input type="hidden" name="check_data_download" value="1" id="check_data_download" />
<input type="hidden" name="date" value="<%=date%>" id="date" />

<!-- page_title_area(S) -->
<div class="page_title_area clear" >
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		 --><button type="button" class="btn_normal" name="btn_save_as" id="btn_save_as">Down Excel</button><!--
		 --><button type="button" class="btn_normal" name="btn_save_csv" id="btn_save_csv">Save CSV</button><!--
		 --><button type="button" class="btn_normal" name="btn_down" id="btn_down">Data Download</button><!--
		 --><button type="button" class="btn_normal" name="btn_bkg_main" id="btn_bkg_main">Go To Booking</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
	<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<!-- page_title_area(E) -->

<div class= "wrap_search">
<!-- opus_design_inquiry (S) -->
<div class="opus_design_inquiry">
	<table style="width:900px">
		<colgroup>
			<col />
			<col />
			<col />
			<col />
			<col />
			<col />
			<col />
			<col />
			<col />
			<col />
			<col />
			<col />
		</colgroup>
		<tbody>
			 <tr>
				<th title="Vessel Voyage Direction">VVD 1</th>
				<td><input type="text" name="vvd" style="width:90px; ime-mode: disabled;" class="input1" dataformat="engup" maxlength="9" required fullfill caption="VVD 1"></td>
				<th title="Vessel Voyage Direction">VVD 2</th>
				<td><input type="text" name="vvd2" style="width:90px; ime-mode: disabled;" class="<%="POD".equals(strLocNm) ? "input" : "input2" %>" dataformat="engup" maxlength="9" fullfill <%="POD".equals(strLocNm) ? "" : "readOnly" %> caption="VVD 2"></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" name="pol_cd" style="width:60px; ime-mode: disabled;" class='<%="POL".equals(strLocNm) ? "input1" : "input2" %>' dataformat="engup" maxlength="5" fullfill <%="POL".equals(strLocNm) ? "required" : "readOnly" %> caption="POL"></td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" name="pod_cd" style="width:60px; ime-mode: disabled;" class='<%="POD".equals(strLocNm) ? "input1" : "input2" %>' dataformat="engup" maxlength="5" fullfill <%="POD".equals(strLocNm) ? "required" : "readOnly" %> caption="POD"></td>
				<th>CGO TYPE</th>
				<td><select style="width:71px;" name="bkg_cgo_tp_cd" class="input1" <%="O".equals(strTransMode) ? "disabled" : "" %>>
						<option value="">All</option>
						<option value="F" selected>Full</option>
						<option value="P">Empty</option>
					</select></td>
				<th>TRANS TYPE</th>
				<td><input type="radio" class="trans" name="trans_type" id="trans_type0" value="all" checked><label for="trans_type0">ALL</label>&nbsp;<!--
				--><input type="radio" class="trans" name="trans_type" id="trans_type1" value="local"><label for="trans_type1">LOCAL</label>&nbsp;<!--
				--><input type="radio" class="trans" name="trans_type" id="trans_type2" value="ts"><label for="trans_type2">T/S</label></td>
			</tr>
		</tbody>
	</table>
	<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
	<table style="width:900px">
		<colgroup>
			<col />
			<col />
			<col />
			<col />
			<col />
			<col />
			<col />
			<col />
		</colgroup>
		<tbody>
			<tr>
				<th>Call Sign</th>
				<td><input type="text" name="call_sgn_no" style="width:110px;" class="input" disabled id="call_sgn_no" /> </td>
				<th>Pre. Port</th>
				<td><input type="text" name="pre_port" style="width:60px;" class="input" disabled id="pre_port" /> </td>
				<th>Next Port</th>
				<td colspan="3"><input type="text" name="nxt_port" style="width:60px;" class="input" disabled id="nxt_port" /> </td>
			 </tr>
			 <tr>
				 <th>ETA</th>
				 <td><input type="text" name="vps_eta_dt" style="width:110px;" class="input" disabled id="vps_eta_dt" /> </td>
				 <th>ETB</th>
				 <td><input type="text" name="vps_etb_dt" style="width:110px;" class="input" disabled id="vps_etb_dt" /> </td>
				 <th>ETD</th>
				 <td><input type="text" name="vps_etd_dt" style="width:110px;" class="input" disabled id="vps_etd_dt" /> </td>
				 <th>Vessel Name</th>
				 <td><input type="text" name="vsl_eng_nm" style="width:230px;" class="input" disabled id="vsl_eng_nm" /> </td>
			 </tr>
		</tbody>
	  </table>

	</div>
	<!-- opus_design_inquiry (E) -->
</div>



<div class= "wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_data(S) -->
	<div class="opus_design_data " >
		<table>
			<colgroup>
				<col width="60" />
				<col width="335" />
				<col />
				<col width="60" />
				<col width="335" />
			</colgroup>
			 <tr>
				 <th>VVD 1</td>
				 <td>
					<div class= "wrap_search">
						<div class="opus_design_inquiry">
							<table>
								<colgroup>
									<col width="70" />
									<col width="90" />
									<col width="85" />
									<col width="90" />
								</colgroup>
								 <tr>
									 <th>B/L Count</th>
									 <td><input type="text" name="bl_cnt" id="bl_cnt" style="width:80px;text-align:right;" class="input2" readonly></td>
									 <th>CNTR Count</th>
									 <td><input type="text" name="cntr_cnt" id="cntr_cnt" style="width:80px;text-align:right;" class="input2" readonly></td>
								 </tr>
							 </table>
						</div>
					</div>
				</td>
				 <td>&nbsp;</td>
				 <th>VVD 2</td>
				 <td>
					<div class= "wrap_search">
						<div class="opus_design_inquiry">
							<table>
								<colgroup>
									<col width="70" />
									<col width="90" />
									<col width="85" />
									<col width="90" />
								</colgroup>
								 <tr>
									 <th>B/L Count</th>
									 <td><input type="text" name="bl_cnt_vvd2" id="bl_cnt_vvd2" style="width:80px;text-align:right;" class="input2" readonly></td>
									 <th>CNTR Count</th>
									 <td><input type="text" name="cntr_cnt_vvd2" id="cntr_cnt_vvd2" style="width:80px;text-align:right;" class="input2" readonly></td>
								 </tr>
							 </table>
						</div>
					</div>
				</td>
			 </tr>
		 </table>
	</div>
	<!-- opus_design_data(E) -->
</div>

</form>
<iframe name="download" id="download" style="display:none;width:1px;height:1px;" onreadystatechange="ComOpenWait(false);"></iframe>
