<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0056.jsp
*@FileTitle  : QTA Edit_Office Add
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
<%@ page import="com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0056Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmCsq0056Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;//DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100";
    String bseYr       = "";
    String bseQtrCd    = "";
    String ofcVwCd     = "";
    String ofcVwNm     = "";
    String divPeriod   = "";

    String strUsr_id   = "";
    String strUsr_nm   = "";
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.csq.adjustment");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmCsq0056Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        bseYr     = JSPUtil.getNull(request.getParameter("f_bse_yr"));
        bseQtrCd  = JSPUtil.getNull(request.getParameter("f_bse_qtr_cd"));
        divPeriod = JSPUtil.getNull(request.getParameter("div_period"));
        ofcVwCd   = JSPUtil.getNull(request.getParameter("f_ofc_vw_cd"));

        if (ofcVwCd.equals("L")) {
            ofcVwNm = "Loading";
        } else if (ofcVwCd.equals("C")) {
            ofcVwNm = "Contract";
        }

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
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="f_bse_tp_cd" value="Q" id="f_bse_tp_cd" />
<input type="hidden" name="f_ofc_vw_cd" value="<%=ofcVwCd%>" id="f_ofc_vw_cd" />
<input type="hidden" name="f_trd_cd" value="IAS" id="f_trd_cd" />


<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>IAS Office Add Creation</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_Creation" id="btn_Creation" type="button">Creation</button><!--
			--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="85">
					<col width="75">
					<col width="80">
					<col width="95">
					<col width="160">
					<col width="80">
					<col width="95">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Year</th>
                        <td><input type="text" style="text-align:center; width:60px; ime-mode:disabled" name="f_bse_yr" id="f_bse_yr" class="input2" maxlength="20" readOnly value="<%=bseYr%>"></td>
                        <th>Quarter</th>
                        <td><input type="text" style="text-align:center; width:70px; ime-mode:disabled" name="f_bse_qtr_cd" id="f_bse_qtr_cd" class="input2" maxlength="20" readOnly value="<%=bseQtrCd%>"></td>
                        <td><div id="div_period"><%=divPeriod%></div></td>
                        <th>Office View</th>
                        <td><input type="text" style="text-align:center; width:90px; ime-mode:disabled" name="f_ofc_vw_nm" id="f_ofc_vw_nm" class="input2" maxlength="20" readOnly value="<%=ofcVwNm%>"></td>
                        <td></td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="85">
					<col width="75">
					<col width="80">
					<col width="95">
					<col width="50">
					<col width="110">
					<col width="80">
					<col width="95">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Sub Trade</th>
                        <td><script type="text/javascript">ComComboObject('f_sub_trd_cd', 1, 60, 1, 1)</script></td>
                        <th>Lane Bound</th>
                        <td><script type="text/javascript">ComComboObject('f_dir_cd', 1, 70, 1, 1)</script></td>
                        <th>R/Lane</th>
                        <td><script type="text/javascript">ComComboObject('f_rlane_cd', 1, 80, 1, 1)</script></td>
                        <th>RHQ</th>
                        <td><script type="text/javascript">ComComboObject('f_rhq_cd', 1, 90, 1, 1)</script></td>
                        <td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td id="sheet_unit" style="text-align: right;">[Unit: TEU, $]</td>
						</tr>
					</tbody>
				</table>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>