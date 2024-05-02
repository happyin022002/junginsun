<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0136.jsp
*@FileTitle  : Merchant Haulage Application Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0136Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0136Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.FullReleaseOrderBC");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0136Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");		
	}catch(Exception e) {
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->



<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Merchant Haulage Application Inquiry</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
	--></div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60" />
					<col width="200" />
					<col width="35" />
					<col width="200" />
					<col width="60" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr class="h23">
						<th>MRN No.</th>
						<td><input type="text" style="width:100px" align="absmiddle" class="input2" value="<%=JSPUtil.getNull(request.getParameter("edo_rqst_no").substring(0, 11))%>" readonly></td>
						<th>MSN</th>
						<td><input type="text" style="width:100px" align="absmiddle" class="input2" value="<%=JSPUtil.getNull(request.getParameter("edo_rqst_no").substring(11))%>" readonly></td> 
						<th>승인 선사</th>
						<td><input type="text" style="width:100px;" align="absmiddle" class="input2" value="<%=ConstantMgr.getScacCode()%>" readonly></td>			
					</tr> 
				</tbody>
			</table>
			<h3 class="title_design">Master B/L No.</h3>
			<table class="grid_2 wAuto">
				<colgroup>
					<col width="150" />
					<col width="100" />
					<col width="200" />
					<col width="100" />
					<col width="100" />
					<col width="200" />
				</colgroup>
				<tbody>
					<tr>
						<th>B/L No.</th>
						<td colspan="2"><input type="text" name="bl_no" style="width:100%;" class="noinput2" value="" readonly id="bl_no" /> </td>
						<td colspan="3"></td>
						</tr>

					<tr>
						<th>항차</th>
						<td colspan="2"><input type="text" name="skd_nm" style="width:100%;" class="noinput2" value="" readonly id="skd_nm" /> </td>
						<th>입항 일자</th>
						<td colspan="2"><input type="text" name="vsl_arr_dt" style="width:100%;" class="noinput2" value="" readonly id="vsl_arr_dt" /> </td>
					</tr>

					<tr>
						<th>선박명</th>
						<td colspan="2"><input type="text" name="edo_vsl_nm" style="width:100%;" class="noinput2" value="" readonly id="edo_vsl_nm" /> </td>
						<th>신청 일시</th>
						<td colspan="2"><input type="text" name="edo_rct_dt" style="width:100%;" class="noinput2" value="" readonly id="edo_rct_dt" /> </td>
					</tr>

					<tr>
						<th>신청자</th>
						<td><input type="text" name="ms_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly id="ms_pty_rgst_no" /> </td>
						<td><input type="text" name="ms_pty_nm" style="width:100%;" class="noinput2" value="" readonly id="ms_pty_nm" /> </td>
						<th>확인 일시 </th>
						<td colspan="2"><input type="text" style="width:100%;" class="noinput2" value=" " readonly /> </td>
					</tr>

					<tr>
						<th>승인운송사</th>
						<td><input type="text" name="ga_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly id="ga_pty_rgst_no" /> </td>
						<td><input type="text" name="ga_pty_nm" style="width:100%;" class="noinput2" value="" readonly id="ga_pty_nm" /> </td>
						<th>승인 일시 </th>
						<td colspan="2"><input type="text" name="edo_ack_dt_a" style="width:100%;" class="noinput2" value="" readonly id="edo_ack_dt_a" /> </td>
					</tr>
					<tr>
						<th>자가/자선 구분</th>
						<td colspan="2"><input type="text" name="own_trsp_cd" style="width:100%;" class="noinput2" value="" readonly id="own_trsp_cd" /> </td>
						<th>거부 일시 </th>
						<td colspan="2"><input type="text" name="edo_ack_dt_r" style="width:100%;" class="noinput2" value="" readonly id="edo_ack_dt_r" /> </td>
					</tr>
					<tr>
						<th>품명</th>
						<td colspan="2"><input type="text" name="gds_desc1" style="width:100%;" class="noinput2" value="" readonly id="gds_desc1" /> </td>
						<th>User ID</th>
						<td colspan="2"><input type="text" name="edo_ack_usr_id" style="width:100%;" class="noinput2" value="" readonly id="edo_ack_usr_id" /> </td>
					</tr>
					<tr>
						<th></th>
						<td colspan="2"><input type="text" name="gds_desc2" style="width:100%;" class="noinput2" value="" readonly id="gds_desc2" /> </td>
						<td colspan="3" rowspan="2"></td>
					</tr>
					<tr>
						<th></th>
						<td colspan="2"><input type="text" name="gds_desc3" style="width:100%;" class="noinput2" value="" readonly id="gds_desc3" /> </td>
					</tr>
					<tr>
						<th></th>
						<td colspan="2"><input type="text" name="gds_desc4" style="width:100%;" class="noinput2" value="" readonly id="gds_desc4" /> </td>
						<th>도착지</th>
						<td><input type="text" name="bd_arr_area_no" style="width:100%;" class="noinput2" value="" readonly id="bd_arr_area_no" /> </td>
						<td><input type="text" name="bd_arr_area_vndr_nm" style="width:100%;" class="noinput2" value="" readonly id="bd_arr_area_vndr_nm" /> </td>
					</tr>
					 <tr>
						<th>출발지</th>
						<td><input type="text" name="bd_dep_area_no" style="width:100%;" class="noinput2" value="" readonly id="bd_dep_area_no" /> </td>
						<td><input type="text" name="bd_dep_area_vndr_nm" style="width:100%;" class="noinput2" value="" readonly id="bd_dep_area_vndr_nm" /> </td>
						<th>도착지명</th>
						<td colspan="2"><input type="text" name="bd_arr_area_nm" style="width:100%;" class="noinput2" value="" readonly id="bd_arr_area_nm" /> </td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<h3 class="title_design">신청업체</h3>
			<table class="grid_2 wAuto"> 
				<colgroup>
					<col width="150" />
					<col width="300" />
					<col width="100" />
					<col width="300" />
				</colgroup>
				<tbody>
					<tr>
						<th>상호</th>
						<td><input type="text" name="ms_pty_nm2" style="width:100%;" class="noinput2" value="" readonly id="ms_pty_nm2" /> </td>
						<th>담당자명</th>
						<td><input type="text" name="ms_pty_cntc_pson_nm" style="width:100%;" class="noinput2" value="" readonly id="ms_pty_cntc_pson_nm" /> </td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="ms_phn_no" style="width:100%;" class="noinput2" value="" readonly id="ms_phn_no" /> </td>
						<td colspan="2" rowspan="2"></td>
					</tr>
					<tr>
						<th>요청사항 </th>
						<td><input type="text" name="diff_rmk" style="width:100%;" class="noinput2" value="" readonly id="diff_rmk" /> </td>
					</tr>
				</tbody>
			</table> 
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<h3 class="title_design">실화주</h3>
			<table class="grid2 wAuto"> 
				<colgroup>
					<col width="150" />
					<col width="300" />
					<col width="100" />
					<col width="300" />
				</colgroup>
				<tr>
					<th>상호</th>
					<td><input id="as_pty_nm" name="as_pty_nm" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
					<th>사업자번호</th>
					<td><input id="as_pty_rgst_no" name="as_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
				</tr>
				<tr>
					<th>대표자</th>
					<td><input id="as_pty_rep_nm" name="as_pty_rep_nm" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
					<th>연락처</th>
					<td><input id="as_phn_no" name="as_phn_no" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
				</tr>
				<tr>
					<th rowspan="3">주소</th>
					<td><input id="as_pty_addr1" name="as_pty_addr1" style="width:100%;" class="noinput2" value="" readonly type="text" /></td>
					<td colspan="2" rowspan="3"></td>
				</tr>
				<tr>
					<td><input id="as_pty_addr2" name="as_pty_addr2" style="width:100%;" class="noinput2" value="" readonly type="text" /></td>
				</tr>
				<tr>
					<td><input id="as_pty_addr3" name="as_pty_addr3" style="width:100%;" class="noinput2" value="" readonly type="text" /></td>
				</tr>
			</table> 
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<h3 class="title_design">자가운송업체</h3>
			<table class="grid2 wAuto"> 
				<colgroup>
					<col width="150" />
					<col width="300" />
					<col width="100" />
					<col width="300" />
				</colgroup>
				<tr>
					<th>상호</th>
					<td><input id="ga_pty_nm2" name="ga_pty_nm2" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
					<th>업체부호</th>
					<td><input id="ga_pty_rgst_no2" name="ga_pty_rgst_no2" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
				</tr>
				<tr>
					<th>담당자</th>
					<td><input id="ga_pty_cntc_pson_nm" name="ga_pty_cntc_pson_nm" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
					<th>연락처</th>
					<td><input id="ga_phn_no" name="ga_phn_no" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<h3 class="title_design">수하인</h3>
			<table class="grid2 wAuto"> 
				<colgroup>
					<col width="150" />
					<col width="300" />
					<col width="100" />
					<col width="300" />
				</colgroup>
				<tr>
					<th> 상호 </th>
					<td><input id="cn_pty_nm" name="cn_pty_nm" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
					<th>사업자번호</th>
					<td><input id="cn_pty_rgst_no" name="cn_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input id="cn_pty_addr1" name="cn_pty_addr1" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
					<td colspan="2" rowspan="3"></td>
				</tr>
				<tr>
					<th></th>
					<td><input id="cn_pty_addr2" name="cn_pty_addr2" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
				</tr>
				<tr>
					<th></th>
					<td><input id="cn_pty_addr3" name="cn_pty_addr3" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
				</tr>
			</table> 
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<h3 class="title_design">통지처</h3>
			<table class="grid2 wAuto">
				<colgroup>
					<col width="150" />
					<col width="300" />
					<col width="100" />
					<col width="300" />
				</colgroup> 
				<tr>
					<th> 상호 </th>
					<td><input id="ni_pty_nm" name="ni_pty_nm" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
					<th>사업자번호</th>
					<td><input id="ni_pty_rgst_no" name="ni_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input id="ni_pty_addr1" name="ni_pty_addr1" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
					<td colspan="2" rowspan="3"></td>
				</tr>
				<tr>
					<th></th>
					<td><input id="ni_pty_addr2" name="ni_pty_addr2" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
				</tr>
				<tr>
					<th></th>
					<td><input id="ni_pty_addr3" name="ni_pty_addr3" style="width:100%;" class="noinput2" value="" readonly type="text" /> </td>
				</tr>
			</table> 
		</div>
	</div>		
	<input type='hidden' name ='frm_edo_rqst_no' id ='frm_edo_rqst_no' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_no"))%>">
	<input type='hidden' name ='frm_edo_tp_cd' id ='frm_edo_tp_cd' value = "<%=JSPUtil.getNull(request.getParameter("edo_tp_cd"))%>">
	<input type='hidden' name ='frm_edo_rqst_seq_5jn' id ='frm_edo_rqst_seq_5jn' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_seq_5jn"))%>">
	<input type='hidden' name ='frm_edo_rqst_seq_5jm' id ='frm_edo_rqst_seq_5jm' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_seq_5jm"))%>">
	<input type='hidden' name ='frm_edo_rqst_seq_5jk' id ='frm_edo_rqst_seq_5jk' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_seq_5jk"))%>">
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
				<script type="text/javascript">ComSheetObject('sheet2');</script>
				<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>


<%@include file="/bizcommon/include/common_opus.jsp"%>