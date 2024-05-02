<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_ACM_0117.js
*@FileTitle  : FF Compensation Details & History for B/L
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.event.EsmAcm0117Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0117Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMAudit.AGNCommAudit");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0117Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<script type="text/javascript">
// 공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("grpTp", "", "CD00888", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ffCmpnDiv", "", "CD00598", 0, "")%>
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
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>FF Compensation Details & History for B/L</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
				--><button type="button" class="btn_normal" name="btn_Close"  		id="btn_Close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<div class="layer_popup_contents">
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class="layout_wrap">
			<div class="layout_flex_fixed pad_right_8" style="float: left;"> 
				<div class= "opus_design_inquiry wFit">
					<table>
						<colgroup>
							<col width="100"/>
							<col width="110"/>
							<col width="50"/>
							<col width="150"/>
							<col width="*"/>
					    </colgroup>
					    <tbody>
						<tr>
							<th>B/L</th>
			                <td><input type="text" name="bl_no" dataformat="engup" maxlength="12" class="input1" value="<%=JSPUtil.getParameter(request, " bl_no") %>" id="bl_no"  style="width:100px;text-align:center;ime-mode:disabled;" tabindex="1"></td>
			                <th>Booking No.</th>
			                <td colspan="2"><input type="text" name="bkg_no" dataformat="engup" maxlength="13" class="input1" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" id="bkg_no"  style="width:100px;text-align:center;ime-mode:disabled;" tabindex="2"></td>
						</tr>
						<tr>
							<th>ETD DT</th>
	                		<td colspan="4"><input type="text" name="vsl_dep_dt" class="input2" style="width:100px;text-align:center;" readonly id="vsl_dep_dt" /> </td>
	                	</tr>	
	                	<tr>
	                		<th>Shipper</th>
	               			<td colspan="4"><input type="text" name="shpr_cnt_seq" class="input2" style="width:100px;text-align:center;" readonly id="shpr_cnt_seq" /><input type="text" name="shpr_nm" class="input2" style="width:424px;" readonly id="shpr_nm" /> </td>
	                  	</tr>
	                  	<tr>
	                  	   <th>F.Frwder / Vendor</th>
	               		  <td colspan="4"><input type="text" name="ff_cnt_seq" class="input2" style="width:100px;text-align:center;" readonly="" id="ff_cnt_seq" /><!-- 
	               		  --><input type="text" name="vndr_cnt_seq" class="input2" style="width:100px;text-align:center;" readonly="" id="vndr_cnt_seq" /><!-- 
	               		  --><input type="text" name="ff_nm" class="input2" style="width:320px;" readonly="" id="ff_nm" />
	                     </td>
	                  </tr>
	                  <tr>
		                  <th>T.VVD</th>
		                  <td><input type="text" name="comm_vsl" class="input2" style="width:100px;text-align:center;" readonly id="comm_vsl" /> </td>
		                  <th>Route</th>
		                 <td colspan="2">
		                  <input type="text" name="por_cd" class="input2" style="width:74px;text-align:center;" readonly="" id="por_cd" /><!-- 
		                  --><input type="text" name="pol_cd" class="input2" style="width:73px;text-align:center;" readonly="" id="pol_cd" /><!-- 
		                  --><input type="text" name="pod_cd" class="input2" style="width:73px;text-align:center;" readonly="" id="pod_cd" /><!-- 
		                  --><input type="text" name="del_cd" class="input2" style="width:74px;text-align:center;" readonly="" id="del_cd" />
		                </td>
	                  </tr>
	                  <tr>
	                    <th>REF No.</th>
		                <td><input type="text" name="ff_ref_no" class="input2" style="width:100px; text-align:center;" readonly id="ff_ref_no" /> </td>
		                <th>FMC</th>
		                <td colspan="2"><input type="text" name="fmc_no" class="input2" style="width:154px;text-align:center;" readonly id="fmc_no" /> </td>
	                  </tr>
	                  <tr>
	                  	<th>SC / RFA No.</th>
		                <td colspan="2"><input type="text" name="sc_rfa_no" class="input2" style="width:204px;" readonly id="sc_rfa_no" /></td>
		                <th>Kind</th>
		                <td><input type="text" name="ff_knd_cd" class="input2" style="width:157px;text-align:center;" readonly id="ff_knd_cd" /> </td>
	                  </tr>
	                 
					</tbody>
				</table>
			</div>
			</div>
			<div class="layout_flex_fixed" style="width: 220px; float: left"> 
				<div class="opus_design_grid clear" >
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
			</div>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
