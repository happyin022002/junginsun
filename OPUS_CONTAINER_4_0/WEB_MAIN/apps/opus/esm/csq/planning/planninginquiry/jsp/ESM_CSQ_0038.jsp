<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0038.jsp
*@FileTitle  : 
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.planning.planninginquiry.event.EsmCsq0038Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCsq0038Event  event = null;					//PDTO(Data Transfer Object including Parameters) 
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.planning.planninginquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCsq0038Event)request.getAttribute("Event");
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
		loadPage(true);
	}
</script>
<form name="form">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_accent" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button>
	</div>
	<!-- opus_design_btn (E) -->
	
	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="f_bse_tp_cd" value="Q" id="f_bse_tp_cd" />
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <table>
            <colgroup>
                <col width="46" />
                <col width="70" />
                <col width="51" />
                <col width="60" />
                <col width="175" />
                <col width="80" />
                <col width="90" />
                <col width="85" />
                <col width="105" />
                <col width="50" />
                <col width="85" />
                <col width="40" />
                <col width="*" />
            </colgroup>
            <tbody>
                <tr>
                   <th>Year</th>
                   <td><script type="text/javascript">ComComboObject('f_bse_yr', 1, 100, 1, 1)</script></td>
                   <th>Quarter</th>
                   <td><script type="text/javascript">ComComboObject('f_bse_qtr_cd', 1, 80, 1, 1)</script></td>
                   <td><div id="div_period"></div></td>
                   <th>Office View</th>
                   <td><script type="text/javascript">ComComboObject('f_ofc_vw_cd', 1, 100, 1, 1)</script></td>
                   <th>Office Level</th>
                   <td><script type="text/javascript">ComComboObject('f_ofc_lvl', 1, 100, 1, 1)</script></td>
                   <th><div id="div_rhq">RHQ</div></th>
				   <td><script type="text/javascript">ComComboObject('f_rhq_cd', 1, 70, 1)</script></td>
               	   <th><div id="div_ofc">Office</div></th>
				   <td><script type="text/javascript">ComComboObject('f_rgn_ofc_cd', 1, 70, 1)</script></td>
                </tr>
			</tbody>
		</table>
		<table>
			<colgroup>
                <col width="45" />
                <col width="100" />
                <col width="50" />
                <col width="90" />
                <col width="60" />
                <col width="105" />
                <col width="85" />
                <col width="120" />
                <col width="*" />
            </colgroup>
			<tbody>
                <tr>
               	 	<th>Month</th>
					<td><input type="text" style="text-align:center;" class="input" size="3" maxlength="2" dataformat="num" name="f_fm_mon"><!--  
						--><label>~</label><!--  
						-->&nbsp;<input type="text" style="text-align:center;" class="input" size="3" dataformat="num" maxlength="2" name="f_to_mon"></td>
					<th>Trade</th>
					<td><script type="text/javascript">ComComboObject('f_trd_cd', 1, 80, 1)</script></td>
					<th>R/Lane</th>
					<td><script type="text/javascript">ComComboObject('f_rlane_cd', 1, 100, 1 )</script></td>
					<th>Lane Bound</th>
					<td><script type="text/javascript">ComComboObject('f_dir_cd', 1, 100, 1 )</script></td>
					<th></th>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>  

<div class="wrap_result"> 
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
      	<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<td style="text-align:right;">[Unit: TEU, $, TEU/$]</td>
					</tr>
				</tbody>
			</table>
		</div>
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
</form>