<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0104.jsp
*@FileTitle  : Guideline Route Note Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event.EsmPri0104Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.syscommon.common.table.PriSgRtCmdtRnoteVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0104Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    String svcScpCd    = null;
    String glineSeq    = null;
    String prcCustTpCd = null;
    String cmdtHdrSeq  = null;
    String routSeq     = null;

    StringBuffer itemComboText = new StringBuffer();
    StringBuffer itemComboValue = new StringBuffer();
    StringBuffer scgComboText = new StringBuffer();
    StringBuffer scgComboValue = new StringBuffer();
    Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCRateGuideline");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri0104Event)request.getAttribute("Event");

        PriSgRtCmdtRnoteVO vo = event.getPriSgRtCmdtRnoteVO();

        if (vo != null) {
            svcScpCd    = vo.getSvcScpCd();
            glineSeq    = vo.getGlineSeq();
            prcCustTpCd = vo.getPrcCustTpCd();
            cmdtHdrSeq  = vo.getCmdtHdrSeq();
            routSeq     = vo.getRoutSeq();
        } else {
            svcScpCd    = "";
            glineSeq    = "";
            prcCustTpCd = "";
            cmdtHdrSeq  = "";
            routSeq     = "";
        }

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        List<CodeInfo> item = (List<CodeInfo>)eventResponse.getCustomData("item");

        // Item Combo Data 생성
        if (item != null && item.size() > 0) {
            int dataCount = item.size();
            CodeInfo[] vos = new CodeInfo[dataCount];
            item.toArray(vos);
            itemComboText.append(" |");
            itemComboValue.append(" |");
            for (int i = 0; i < dataCount; i++) {
                if (i != 0) {
                    itemComboText.append("|");
                    itemComboValue.append("|");
                }
                //itemComboText.append(vos[i].getCode()).append("\t").append(vos[i].getName());
                itemComboText.append(vos[i].getName());
                itemComboValue.append(vos[i].getCode());
            }
        }

        List<RsltCdListVO> surcharge = (List<RsltCdListVO>)eventResponse.getCustomData("surcharge");

        // Surcharge Combo Data 생성
        if (surcharge != null && surcharge.size() > 0) {
            int dataCount = surcharge.size();
            RsltCdListVO[] vos = new RsltCdListVO[dataCount];
            surcharge.toArray(vos);
            scgComboText.append(" \t |");
            scgComboValue.append(" |");
            for (int i = 0; i < dataCount; i++) {
                if (i != 0) {
                    scgComboText.append("|");
                    scgComboValue.append("|");
                }
                scgComboText.append(vos[i].getNm());
                scgComboValue.append(vos[i].getCd());
            }
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
    var itemComboText = "<%=itemComboText.toString()%>";
    var itemComboValue = "<%=itemComboValue.toString()%>";
    var scgComboText = "<%=scgComboText.toString()%>";
    var scgComboValue = "<%=scgComboValue.toString()%>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="svc_scp_cd"  id="svc_scp_cd"   value="<%=svcScpCd    %>">
<input type="hidden" name="gline_seq"   id="gline_seq"   value="<%=glineSeq    %>">
<input type="hidden" name="prc_cust_tp_cd" id="prc_cust_tp_cd" value="<%=prcCustTpCd %>">
<input type="hidden" name="cmdt_hdr_seq" id="cmdt_hdr_seq"  value="<%=cmdtHdrSeq  %>">
<input type="hidden" name="rout_seq"   id="rout_seq"   value="<%=routSeq     %>">
<input type="hidden" name="isEditable" id="isEditable" value="<%=StringUtil.xssFilter(request.getParameter("isEditable"))%>">
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Guideline Route Note Creation</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Ok" 	id="btn_Ok">OK</button> 
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button> 
			<button type="button" class="btn_normal" name="btn_RowCopy" 	id="btn_RowCopy">Row Copy</button> 
			<button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>