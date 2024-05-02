<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0381.jsp
 *@FileTitle : Arrival Notice Send
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0381Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0381Event event 	= null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; // error from server
	String strErrMsg 				= ""; // error message
	int rowCount 					= 0; // count of DB resultSET list

	String successFlag 			= "";
	String codeList 				= "";
	String pageRows 				= "100";

	String strUsr_id 				= "";
	String strUsr_nm 				= "";
	String strUsr_email 			= "";
	String strOfc_cd 				= "";
	String strCnt_cd 				= "";

	String code 					= "";
	String value 					= "";

	Logger log 						= Logger.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");

	String parAutoSearchFlg 	= JSPUtil.getParameter(request,			"autoSearchFlg");
	String parVvd 					= JSPUtil.getParameter(request, "vvd");
	String parVpsEtaDtStart 	= JSPUtil.getParameter(request,			"vps_eta_dt_start");
	String parVpsEtaDtEnd 		= JSPUtil.getParameter(request,			"vps_eta_dt_end");
	String parPodCd 				= JSPUtil.getParameter(request, "pod_cd");
	String parDelCd 				= JSPUtil.getParameter(request, "del_cd");
	String parPolCd 				= JSPUtil.getParameter(request, "pol_cd");
	String parBlNo 					= JSPUtil.getParameter(request, "bl_no");
	String parOfcCd 				= JSPUtil.getParameter(request, "ofc_cd");
	String parSchTp 				= JSPUtil.getParameter(request, "sch_tp");

	String parTsFlg 				= JSPUtil.getParameter(request, "ts_flg");
	String parCustCntCd 		= JSPUtil.getParameter(request, "cust_cnt_cd");
	String parCustSeq 			= JSPUtil.getParameter(request, "cust_seq");
	String parCustNm 			= JSPUtil.getParameter(request, "cust_nm");

	String parCustRefNo = JSPUtil.getParameter(request, "cust_ref_no");
	String parSNo = JSPUtil.getParameter(request, "sc_no");

	String parEvalFlg = JSPUtil.getParameter(request, "is_validated");


	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_email = account.getUsr_eml();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

		event = (EsmBkg0381Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");
		code = eventResponse.getETCData("code");
		value = eventResponse.getETCData("value");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
		
		<script type="text/javascript">
			var strUsr_id    = "<%=strUsr_id%>";
			var strUsr_nm    = "<%=strUsr_nm%>";
			var strUsr_email = "<%=strUsr_email%>";
			var strOfc_cd    = "<%=strOfc_cd%>";
			var strCnt_cd    = "<%=strCnt_cd%>";


			var parAutoSearchFlg = "<%=parAutoSearchFlg%>";
			var parVvd   = "<%=parVvd%>";
			var parVpsEtaDtStart = "<%=parVpsEtaDtStart%>";
			var parVpsEtaDtEnd = "<%=parVpsEtaDtEnd%>";
			var parPodCd = "<%=parPodCd%>";
			var parDelCd = "<%=parDelCd%>";
			var parPolCd = "<%=parPolCd%>";
			var parBlNo  = "<%=parBlNo%>";
			var parOfcCd = "<%=parOfcCd%>";
			var parSchTp = "<%=parSchTp %>";

			var parTsFlg = "<%=parTsFlg %>";
			var parCustCntCd = "<%=parCustCntCd %>";
			var parCustSeq = "<%=parCustSeq %>";
			var parCustNm = "<%=parCustNm %>";

			var parCustRefNo = "<%=parCustRefNo %>";
			var parSNo = "<%=parSNo %>";

			var parEvalFlg = "<%=parEvalFlg %>";

			var evtCode = "<%=code %>|";
			var evtValue = "<%=value %>|";


			function setupPage(){
				var errMessage = "<%=strErrMsg%>";
				if (errMessage.length >= 1) {
					showErrMessage(errMessage);
				} // end if

				$('<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
				$('<button type="button" class="btn_normal" name="btn_fax"  	id="btn_fax">Fax</button>').appendTo("#btnArea");
				$('<button type="button" class="btn_normal" name="btn_email" 	id="btn_email">E-Mail</button>').appendTo("#btnArea");
				$('<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>').appendTo("#btnArea");
				$('<button type="button" class="btn_normal" name="btn_preview"  id="btn_preview">Preview</button>').appendTo("#btnArea");
				$('<button type="button" class="btn_normal" name="btn_Print"  	id="btn_Print">Print</button>').appendTo("#btnArea");
				$('<button type="button" class="btn_normal" name="btn_template" id="btn_template">Template</button>').appendTo("#btnArea");
				$('<button type="button" class="btn_normal" name="btn_setup"  	id="btn_setup">A/N Setup</button>').appendTo("#btnArea");
				$('<button type="button" class="btn_normal" name="btn_history"  id="btn_history">History</button>').appendTo("#btnArea");
				$('<button type="button" class="btn_normal" name="btn_goto_invoice" id="btn_goto_invoice" style="display:none">Go to Invoice</button>').appendTo("#btnArea");

				$('#btn_goto_invoice').after($('#btn_Close'));

				document.getElementById("title").innerHTML = "Arrival Notice Send";

				loadPage();

			}
		</script>
		<script>
		<%=OfficeCodeMgr.getOfficeCodeListToJS("000004", "BKG")%>
		</script>

		<form name="form" id="form">
			<input name="f_cmd" type="hidden" />
			<input type="hidden" name="pagerows" value="<%=pageRows%>">
			<input type="hidden" name="keys">


			<!-- RD 부분  -->
			<input type="hidden" name="com_mrdPath">
			<input type="hidden" name="com_mrdArguments">

			<input type="hidden" size="200" name="com_mrdSaveDialogDir">
			<input type="hidden" size="200" name="com_mrdSaveDialogFileName">
			<input type="hidden" size="200" name="com_mrdSaveDialogFileExt">
			<input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit">

			<input type="hidden" name="com_mrdTitle">
			<input type="hidden" name="com_mrdDisableToolbar">
			<input type="hidden" name="com_mrdBodyTitle">

	<!-- : ( Title ) (S) -->
	 <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
	<!-- : ( Title ) (E) -->

	<!-- popup_contens_area(S) -->
	<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
	<div class="wrap_search_tab">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<table>
				<colgroup>
					<col width="60" />
					<col width="110" />
					<col width="80" />
					<col width="120" />
					<col width="60" />
					<col width="70" />
					<col width="40" />
					<col width="25" />
					<col width="40" />
					<col width="60" />
					<col width="40" />
					<col width="70" />
					<col width="80" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th class="sm"><input type="radio" value="V" class="trans" name="sch_tp" id="rdo0"><label for="rdo0">VVD</label></th>
						<td class="sm"><input type="text" style="width:100px;" class="input1" name="vvd" id="vvd" caption="VVD" maxlength="9" size="9" style="ime-mode:disabled" dataformat="engup" onFocus="form.sch_tp[0].checked=true;"></td>
						<th class="sm"><input type="radio" value="D" name="sch_tp" id="rdo1"class="trans" checked="true"><label for="rdo1">POD ETA</label></th>
						<td class="sm"><input type="text" style="width:75px" dataformat="ymd" minlength="8" maxlength="8" class="input1" caption="Duration Start Date" id="vps_eta_dt_start" name="vps_eta_dt_start" style="width:100px;ime-mode:disabled" onFocus="form.sch_tp[1].checked=true;"><span class="dash">~</span><!--
							--><input type="text" style="width:75px" dataformat="ymd" minlength="8" maxlength="8" class="input1" id="vps_eta_dt_end" name="vps_eta_dt_end" caption="Duration End Date" style="ime-mode:disabled" onFocus="form.sch_tp[1].checked=true;"><!--
							--><button type="button" class="calendar ir" name="eta_dt_end" id="eta_dt_end"></button>
						</td>
						<th class="sm">POD</th>
						<td class="sm"><input type="text" style="width: 50px;" class="input1" id="pod_cd" name="pod_cd" caption="POD" maxlength="5" style="ime-mode:disabled" dataformat="engup" fullfill /></td>
						<th class="sm">T/S</th>
						<td class="sm"><input type="checkbox" value="Y" id="ts_flg" name="ts_flg" caption="T/S"/ class="trans"></td>
						<th class="sm">DEL</th>
						<td class="sm"><input type="text" style="width: 50px;" class="input" id="del_cd" name="del_cd" caption="DEL" minlength="2" maxlength="5" style="ime-mode:disabled" dataformat="engup" ></td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" style="width: 60px;" class="input" id="pol_cd" name="pol_cd" caption="POL" minlength="5" maxlength="5" style="ime-mode:disabled" dataformat="engup" ></td>
						<th class="sm"><input type="radio" value="B"  class="trans" name="sch_tp" id="rdo3"><label for="rdo3">B/L No.</label></th>
						<td class="sm"><input type="text" style="width: 95px;" class="input1" name="bl_no" caption="B/L No." maxlength="12" style="ime-mode:disabled" dataformat="engup" onFocus="form.sch_tp[2].checked=true;"></td>
						<td></td>
					</tr>
			 </tbody>
		</table>
		<table>
			<colgroup>
					<col width="60" />
					<col width="130" />
					<col width="80" />
					<col width="120" />
					<col width="80" />
					<col width="180" />
					<col width="60" />
					<col width="111" />
					<col width="60" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Evaluated</th>
						<td>
							 <select id="is_validated" name="is_validated" style="width:100px">
								  <option value="Y">Yes</option>
								  <option value="N">No</option>
								  <option value="">All</option>
							  </select>
						</td>
						<th>Customer Code</th>
						<td>
							<input type="text" style="width: 30px;" class="input" id="cust_cnt_cd" name="cust_cnt_cd" caption="Customer Code" fullfill style="ime-mode:disabled" dataformat="enguponly" onKeyUp="fncNextFocusByMax(this,2,cust_seq);" size="2" maxlength="2" /><!--
							 --><input type="text" style="width: 50px;" class="input" id="cust_seq" name="cust_seq" caption="Customer Code" maxlength="6" style="ime-mode:disabled" dataformat="num" onBlur="fncCustSeqBlur(this)" />
						</td>
						<th>Customer Name</th>
						<td><input type="text" style="width: 150px;" class="input" id="cust_nm" name="cust_nm" caption="Customer Name" dataformat="enguponly" otherchar=" " maxlength="500"/></td>
						<th>P/O No.</th>
						<td><input type="text" style="width: 80px;" class="input" id="cust_ref_no" name="cust_ref_no" caption="P/O No." maxlength="500" style="ime-mode:disabled" /></td>
						<th><span id="search_sc_title">S/C No.</span></th>
						<td><div id="search_sc"><input type="text" style="width: 110px;" class="input" name="sc_no" caption="S/C No." maxlength="11" style="ime-mode:disabled" dataformat="engup" onKeyUp="fncNextFocusByMax(this,3,c_no);"><!--
							 --></div></td>
					</tr>
				</tbody>
			</table>
			<!-- 조회영역2 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->

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
		<div class="opus_design_grid" >
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
				<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_normal" name="btn_group_by_code" id="btn_group_by_code">Grouping by Code</button><!--
				 --><button type="button" class="btn_normal" name="btn_group_sc" id="btn_group_sc">Grouping by S/C</button><!--
				 --><button type="button" class="btn_normal" name="btn_multi_contact" id="btn_multi_contact">Multi-Contact</button>
			</div>
			<!-- opus_design_btn(E) -->

		</div>
		<!-- opus_design_grid(E) -->

		<!--TAB File1 (S) -->
		<div id="tabLayer" style="display:inline">
			<div class="opus_design_grid"  id="receivedTabSCTariffLayer" style="display:block">
				<!-- <h3>S/C Exception Tariff</h3> -->

				<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
				<script language="javascript">ComSheetObject('t1sheet1');</script><!--W/O Issue-->
				<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
		</div>
		<!--TAB File1 (E) -->

		<!-- opus_design_grid(S) -->
		<!--<div class="opus_design_RD rd_hidden">-->
		<!--	<script type="text/javascript">rdViewerObject('report1')</script>-->
		<!--</div>-->

		<div class="opus_design_grid rd_hidden" hidden="true">
			<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
		</div>
	</div>

<!-- Developer's task   -->
	<%if(!mainPage.equals("true")){	%></div><%}%>
</form>

