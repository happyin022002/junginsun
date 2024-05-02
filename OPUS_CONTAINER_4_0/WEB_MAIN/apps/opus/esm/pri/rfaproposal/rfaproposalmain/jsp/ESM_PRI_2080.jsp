<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2080.jsp
*@FileTitle  : RFA Proposal Creation [G/L Copy]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2080Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri2080Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFAProposalMain");

    String propNo = null;
    String amdtSeq = null;
    String rfaNo = null;
    String svcScpCd = null;
    String effDt = null;
    String expDt = null;
    String svcScpNm = null;

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2080Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        RpScpGlineCopyVO vo = event.getRpScpGlineCopyVO();

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        svcScpNm = (String)eventResponse.getCustomData("svcScpNm");
        propNo = JSPUtil.getNull(request.getParameter("prop_no"));
        amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
        rfaNo = JSPUtil.getNull(request.getParameter("rfa_no"));
        svcScpCd = JSPUtil.getNull(request.getParameter("svc_scp_cd"));
        effDt = JSPUtil.getNull(request.getParameter("eff_dt"));
        expDt = JSPUtil.getNull(request.getParameter("exp_dt"));
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
<input type="hidden" name="eff_dt" value="<%=effDt %>" id="eff_dt" />
<input type="hidden" name="exp_dt" value="<%=expDt %>" id="exp_dt" />
<!-- 개발자 작업 -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Guideline Copy</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_OK" 	id="btn_OK">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button><!--  
		--></div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents" style="overflow:auto; overflow:hidden;">
	<div class= "wrap_result">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="80" />
					<col width="100" />
					<col width="105" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
	                    <th>Proposal No.</th>
	                    <td colspan="3"><input type="text" name="prop_no" style="width:92px;text-align:center;" class="input2" value="<%=propNo %>" readonly="readonly" id="prop_no" /> </td>
	                <tr>
	                    <th>RFA No.</th>
	                    <td><input type="text" name="rfa_no" style="width:92px;text-align:center;" class="input2" value="<%=rfaNo %>" readonly="readonly" id="rfa_no" /> </td>
	                    <th>AMD No.</th>
	                    <td><input type="text" name="amdt_seq" style="width:90px;text-align:right;" class="input2" value="<%=amdtSeq %>" readonly="readonly" id="amdt_seq" /> </td>
	                </tr>
	                <tr>
	                    <th>SVC Scope</th>
	                    <td colspan="3"><input type="text" name="svc_scp_cd" style="width:92px;text-align:center;" class="input2" value="<%=svcScpCd %>" readonly="readonly" id="svc_scp_cd" /><input type="text" name="svc_scp_nm" style="width:200px;" class="input2" value="<%=svcScpNm %>" id="svc_scp_nm" /> </td>
	                </tr>
				</tbody>
			</table>
			<table class="sm">
				<colgroup>
					<col width="80" />
					<col width="100" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
	                    <td class="pad_left_8"><input type="checkbox" name="frm_loc_chk" value="Y" class="trans " id="frm_loc_chk" /><label for="frm_loc_chk">Location Group</label></td>
	                    <td><input type="checkbox" name="frm_arb_org_chk" value="Y" class="trans" id="frm_arb_org_chk" /><label for="frm_arb_org_chk">Origin Arbitrary</label></td>
	                </tr>
	                <tr>
	                    <td class="pad_left_8"><input type="checkbox" name="frm_cmdt_chk" value="Y" class="trans" id="frm_cmdt_chk" /><label for="frm_cmdt_chk">Commodity Group</label></td>
	                    <td><input type="checkbox" name="frm_arb_des_chk" value="Y" class="trans" id="frm_arb_des_chk" /><label for="frm_arb_des_chk">Destination Arbitrary</label></td>
	                </tr>
	                <tr>
	                    <td class="pad_left_8"><input type="checkbox" name="frm_rate_chk" value="Y" class="trans" id="frm_rate_chk" /><label for="frm_rate_chk">Rate</label></td>
	                    <td>
	                    	<div class="opus_design_btn">
	                    		<button type="button" class="btn_etc" name="btn_CheckAll" 	id="btn_CheckAll">Check All</button><!-- 
	                    		 --><button type="button" class="btn_etc" name="btn_UnCheckAll" 	id="btn_UnCheckAll">UnCheck All</button><!-- 
	                    	 --></div>
	                    </td>
				</tbody>
			</table>	
		</div>
	
		<div class="opus_design_grid clear" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>				
</div>
</form>