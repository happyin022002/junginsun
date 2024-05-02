<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0018.jsp
*@FileTitle  : S/C Proposal Creation - G/L Copy Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event.EsmPri0018Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0018Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCProposalMain");

    String propNo = null;
    String amdtSeq = null;
    String scNo = null;
    String prcCustTpCd = null;
    String svcScpCd = null;
    String effDt = null;
    String expDt = null;
    String svcScpNm = null;

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri0018Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        SpScpGlineCopyVO vo = event.getSpScpGlineCopyVO();

        if (vo != null) {
            propNo = vo.getPropNo();
            amdtSeq = vo.getAmdtSeq();
            scNo = vo.getScNo();
            prcCustTpCd = vo.getPrcCustTpCd();
            svcScpCd = vo.getSvcScpCd();
            effDt = vo.getEffDt();
            expDt = vo.getExpDt();
        } else {
            propNo = "";
            amdtSeq = "";
            scNo = "";
            prcCustTpCd = "";
            svcScpCd = "";
            effDt = "";
            expDt = "";
        }

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        svcScpNm = (String)eventResponse.getCustomData("svcScpNm");
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
<input type="hidden" name="sc_no" value="<%=scNo %>" id="sc_no" />
<input type="hidden" name="prc_cust_tp_cd" value="<%=prcCustTpCd %>" id="prc_cust_tp_cd" />
<input type="hidden" name="eff_dt" value="<%=effDt %>" id="eff_dt" />
<input type="hidden" name="exp_dt" value="<%=expDt %>" id="exp_dt" />
<input type="hidden" name="cmdt_tpw_mst" id="cmdt_tpw_mst" />
<input type="hidden" name="cmdt_tpw_dtl" id="cmdt_tpw_dtl" />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Guideline Copy</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_OK" 	id="btn_OK">OK</button><!--
		--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
	--></div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="80" />
					<col width="110" />
					<col width="65" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
	                    <th>Proposal No.</th>
	                    <td colspan="3"><input type="text" name="prop_no" id="prop_no" style="width:96px;" class="input2" value="<%=propNo %>" readonly></td></tr>
	                <tr>
	                    <th>S/C No.</th>
	                    <td><input type="text" name="sc_no_f" id="sc_no_f" style="width:40px;" class="input2" value="<%=(scNo.length() == 9)?scNo.substring(0,3):"" %>" readonly><input type="text" name="sc_no_e"  id="sc_no_e" style="width:52px;" class="input2" value="<%=(scNo.length() == 9)?scNo.substring(3):"" %>" readonly></td>
	                    <th>AMD No.</th>
	                    <td><input type="text" name="amdt_seq" id="amdt_seq" style="width:90px;text-align:right;" class="input2" value="<%=amdtSeq %>" readonly></td>
	                </tr>
	                <tr>
	                    <th>SVC Scope</th>
	                    <td colspan="3"><input type="text" name="svc_scp_cd"  id="svc_scp_cd" style="width:96px;text-align:center" class="input2" value="<%=svcScpCd %>" readonly><input type="text" name="svc_scp_nm" id="svc_scp_nm" style="width:165px;" class="input2" value="<%=svcScpNm %>"></td>
	                </tr>
				</tbody>
			</table>
			<table class="sm">
				<colgroup>
					<col width="150" />
					<col width="*" />
				</colgroup>
				<tbody>
					 <tr>
	                    <td><input type="checkbox" name="frm_loc_chk" value="Y" class="trans" id="frm_loc_chk" /><label for="frm_loc_chk"> Location Group</label></td>
	                    <td><input type="checkbox" name="frm_goh_chk" value="Y" class="trans" id="frm_goh_chk" /><label for="frm_goh_chk"> GOH</label></td>
	                </tr>
	                <tr>
	                    <td><input type="checkbox" name="frm_cmdt_chk" value="Y" class="trans" id="frm_cmdt_chk" /><label for="frm_cmdt_chk"> Commodity Group</label></td>
	                    <td><input type="checkbox" name="frm_rate_chk" value="Y" class="trans" id="frm_rate_chk" /><label for="frm_rate_chk"> Rate</label></td>
	                </tr>
	                <tr>
	                    <td><input type="checkbox" name="frm_note_chk" value="Y" class="trans" id="frm_note_chk" /><label for="frm_note_chk"> Standard Note</label></td>
	                    <td></td>
	                </tr>
	                <tr>
	                    <td><input type="checkbox" name="frm_arb_org_chk" value="Y" class="trans" id="frm_arb_org_chk" /><label for="frm_arb_org_chk"> Origin Arbitrary</label></td>
	                    <td></td>
	                </tr>
	                <tr>
	                    <td><input type="checkbox" name="frm_arb_des_chk" value="Y" class="trans" id="frm_arb_des_chk" /><label for="frm_arb_des_chk"> Destination Arbitrary</label></td>
	                    <td class="opus_design_btn"><button class="btn_etc" id="btn_CheckAll" name="btn_CheckAll">Check&nbsp;All</button><button class="btn_etc" id="btn_UnCheckAll" name="btn_UnCheckAll" >UnCheck&nbsp;All</button></td>
                    </tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>