<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0054.jsp
*@FileTitle  : Portion Adjustment by RHQ_Figure Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/05
=========================================================*/	
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0052Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmCsq0052Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;//DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100";
    String trdCd       = "";
    String rlaneCd     = "";
    String dirCd       = "";
    String ofcCd       = "";
    String bseYr       = "";
    String bseQtrCd    = "";
    String bound       = "";
    String ofcVwCd     = "";
    String ofcVwNm     = "";
    String bseTpCd     = "";
    String divPeriod   = "";
    String obDivCd     = "";
    String obDivNm     = "";

    String strUsr_id   = "";
    String strUsr_nm   = "";
    Logger log = Logger.getLogger("com.clt.apps.datamanage.basicdata");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmCsq0052Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        trdCd     = JSPUtil.getNull(request.getParameter("f_trd_cd"));
        rlaneCd   = JSPUtil.getNull(request.getParameter("f_rlane_cd"));
        dirCd     = JSPUtil.getNull(request.getParameter("f_conv_dir_cd"));
        ofcCd     = JSPUtil.getNull(request.getParameter("f_rgn_ofc_cd"));
        bseYr     = JSPUtil.getNull(request.getParameter("f_bse_yr"));
        bseQtrCd  = JSPUtil.getNull(request.getParameter("f_bse_qtr_cd"));
        divPeriod = JSPUtil.getNull(request.getParameter("div_period"));
        bseTpCd   = JSPUtil.getNull(request.getParameter("f_bse_tp_cd"));
        ofcVwCd   = JSPUtil.getNull(request.getParameter("f_ofc_vw_cd"));
        obDivCd   = JSPUtil.getNull(request.getParameter("f_ob_div_cd"));

        if (ofcVwCd.equals("L")) {
            ofcVwNm = "Loading";
        } else if (ofcVwCd.equals("C")) {
            ofcVwNm = "Contract";
        }
        if (obDivCd.equals("O")) {
            obDivNm = "O/B";
        } else if (obDivCd.equals("N")) {
            obDivNm = "N.O/B";
        } else {
            obDivNm = obDivCd;
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
<input type="hidden" name="f_bse_tp_cd" value="<%=bseTpCd%>" id="f_bse_tp_cd" />
<input type="hidden" name="f_ofc_vw_cd" value="<%=ofcVwCd%>" id="f_ofc_vw_cd" />
<input type="hidden" name="f_ob_div_cd" value="<%=obDivCd%>" id="f_ob_div_cd" />
<input type="hidden" name="f_gubun" value="RHQ" id="f_gubun" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Portion Adjustment by RHQ_Figure Inquiry</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table class="search">
				<colgroup>
					<col width="50">				
					<col width="80">				
					<col width="50">				
					<col width="80">
					<col width="80">				
					<col width="80">
					<col width="50">
					<col width="50">
					<col width="80">
					<col width="50">				
					<col width="*">				
			   	</colgroup>
			   	<tbody>
			   		<tr>
	                    <th>Year</th>
	                    <td><input type="text" style="text-align:center; width:50px; ime-mode:disabled" name="f_bse_yr" class="input2" maxlength="20" readonly value="<%=bseYr%>" id="f_bse_yr" /> </td>
	                    <th>Quarter</th>
	                    <td><input type="text" style="text-align:center; width:50px; ime-mode:disabled" name="f_bse_qtr_cd" class="input2" maxlength="20" readonly value="<%=bseQtrCd%>" id="f_bse_qtr_cd" /> </td>
	                    <td colspan="2"><div id="div_period"><%=divPeriod%></div></td>
	                    <th>Office View</th>
	                    <td><input type="text" style="text-align:center; width:70px; ime-mode:disabled" name="f_ofc_vw_nm" class="input2" maxlength="20" readonly value="<%=ofcVwNm%>" id="f_ofc_vw_nm" /> </td>
			            <td></td>                   
	                </tr>
	                <tr>
	                     <th>Trade</th>
	                     <td><input type="text" style="text-align:center; width:50px; ime-mode:disabled" name="f_trd_cd" class="input2" maxlength="20" readonly value="<%=trdCd%>" id="f_trd_cd" /> </td>
	                     <th>R/Lane</th>
	                     <td><input type="text" style="text-align:center; width:50px; ime-mode:disabled" name="f_rlane_cd" class="input2" maxlength="20" readonly value="<%=rlaneCd%>" id="f_rlane_cd" /> </td>
	                     <th>Trade Bound</th>
	                     <td><input type="text" style="text-align:center; width:55px; ime-mode:disabled" name="f_conv_dir_cd" class="input2" maxlength="20" readonly value="<%=dirCd%>"></td>
	                     <th>N.OB/OB</th>
	                     <td><input type="text" style="text-align:center; width:70px; ime-mode:disabled" name="f_ob_div_nm" class="input2" maxlength="20" readonly value="<%=obDivNm%>" id="f_ob_div_nm" /> </td>
	                 	 <td></td>
	                 	 <td></td>
	                 	 <td></td>
	                 </tr>
			   </tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid">
			<div class="opus_design_inquiry">
				<table>
					<tr>
						<td style="text-align:right;">[Unit : TEU, $]</td>
					</tr>
				</table>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>