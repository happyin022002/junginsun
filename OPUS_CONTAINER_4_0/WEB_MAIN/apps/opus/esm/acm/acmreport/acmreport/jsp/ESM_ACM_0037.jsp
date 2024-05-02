<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0037.jsp
*@FileTitle  : Commission Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmreport.acmreport.event.EsmAcm0037Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0037Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMReport.ACMReport");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0037Event)request.getAttribute("Event");
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
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- 개발자 작업 -->


<input type="hidden" name="bl_no" id="bl_no"><!-- Multi B/L No -->
<input type="hidden" name="report_item" id="report_item">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
<div class="wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
	                <th width="80">Office</th>
	                <td width="135"><select name="ar_ofc_cd" id="ar_ofc_cd" required="" caption="Office" class="input1" style="width:95px;"></select></td>
	                <th width="80">Sub Office</th>
	                <td width="80"><select name="agn_cd" id="agn_cd" required="" caption="Sub Office" class="input1" style="width:95px;"></select></td>
	                <th width="80">Status</th>
	                <td width="80"><%=JSPUtil.getCodeCombo("sts_option", "", "style='width:90px;'", "CD03039", 0, "")%></td>
	                <th width="80">Date</th>
	                <td>
	                	<input name="fm_dt" type="text" dataformat="ymd" maxlength="8" required="" caption="From Date" cofield="to_dt" class="input1" style="width:80px;" id="fm_dt" />~
	                	<input name="to_dt" type="text" dataformat="ymd" maxlength="8" required="" caption="To Date" cofield="fm_dt" class="input1" style="width:80px;" id="to_dt" />
	                	<button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button>
	                </td>
	             </tr>
	             <tr>
	                <th>Bound</th>
	                <td><%=JSPUtil.getCodeCombo("io_bnd_cd", "", "style='width:95px;'", "CD03037", 0, " ")%></td>
	                <th>Trade</th>
	                <td><select name="s_trd_cd" id="s_trd_cd" style="width:95px;"></select></td>
	                <th>Lane</th>
	                <td><select name="s_rlane_cd" id="s_rlane_cd" style="width:90px;"></select></td>
	                <th>Direction</th>
	                <td><%=JSPUtil.getCodeCombo("s_dir_cd", "", "style='width:80px;'", "CD00593", 0, " ")%></td>
	              </tr>
	              <tr>
	                <th title="Vessel Voyage Direction">VVD</th>
	                <td><input name="comm_vvd" id="comm_vvd" type="text" dataformat="engup" maxlength="9" style="width:95px;"></td>
	                <th>Audit No.</th>
	                <td><input name="aud_no" id="aud_no" type="text" dataformat="engup" maxlength="20" style="width:95px;"></td>
	                <th>Booking Office</th>
	                <td><input name="bkg_ofc_cd" id="bkg_ofc_cd" type="text" dataformat="engup" maxlength="6" style="width:90px;"><button type="button" name="btn_bkg_ofc_popup" id="btn_bkg_ofc_popup" class="input_seach_btn" onClick="openPopup('cust_cd')"></button></td>
	                <th>Sales Office</th>
	                <td><input name="ob_sls_ofc_cd" id="ob_sls_ofc_cd" type="text" dataformat="engup" maxlength="6" style="width:80px;"><button type="button" name="btn_ob_sls_ofc_popup" id="btn_ob_sls_ofc_popup" class="input_seach_btn" onClick="openPopup('cust_cd')"></button></td>
	              </tr>
	              <tr>
	            	<th>B/L No.</th>           
				   	<td id="memo_sheet1_td">
	               		<div id="memo_sheet1_div"><script type="text/javascript">ComSheetObject("memo_sheet1");</script></div>
	               	</td>
	               	<td>
	               		<button type="button" class="btn_etc" name="btn2_bl_no" id="btn2_bl_no" >Multi B/L No</button></div>
	               	</td>
	               	<td width="30"></td>  
	                <th>POR/POL</th>
	                <td><input name="por_cd" id="por_cd" type="text" dataformat="engup" maxlength="5" style="width:50px;">/ <input name="pol_cd" id="pol_cd" type="text" dataformat="engup" maxlength="5" style="width:50px;"></td>
	                <th>POD/DEL</th>
	                <td><input name="pod_cd" id="pod_cd" type="text" dataformat="engup" maxlength="5" style="width:50px;">/ <input name="del_cd" id="del_cd" type="text" dataformat="engup" maxlength="5" style="width:50px;"></td>
	              </tr>
				</tbody>
			</table>
		</div>
</div>
<div class="wrap_result">
	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab" >		
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_tab(E) -->
	<div id="tabLayer" style="display:inline">
		<div class="opus_design_grid clear" >		
			<div class= "grid_option_left">
				<table>
					<tbody>
						<colgroup>
							<col width="150px"/>
							<col width="*" />
						</colgroup>
						<tr>
							<th>Customized RPT Form</th>
							<td><select name="slct_itm_fom_seq" id="slct_itm_fom_seq" style="width:110px;"></select><!-- 
							--><button type="button" name="btn_rpt_itm_popup" id="btn_rpt_itm_popup" class="input_seach_btn" onClick="openPopup('cust_cd')"></button><!-- 
							--></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div style="height: 35px;">&nbsp;</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<div id="tabLayer" style="display:none">	
		<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>
</form>
