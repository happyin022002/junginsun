<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2085.jsp
*@FileTitle  : Amendment History - Rate (Route Note)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2085Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri2085Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";

	String[] rtApplTpCd = null;		    //APLICATION
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgHngrBarTpCd = null;    	//BAR TYPE
	String[] bkgCnlTzCd = null;    		//CANAL
	String[] bkgEsvcTpCd = null;    	//B/I

    Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFARateProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2085Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
        rtApplTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
        payTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);      
        bkgHngrBarTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_HNGR_BAR_TP_CD"), false);  
        bkgCnlTzCd 	    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_CNL_TZ_CD"), false);
        bkgEsvcTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_ESVC_TP_CD"), false);  

    } catch (Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
	var rtApplTpCdComboValue = " |<%=rtApplTpCd[0]%>";
    var rtApplTpCdComboText = " |<%=rtApplTpCd[1]%>";

    var payTermCdComboValue = " |<%=payTermCd[0]%>";   
    var payTermCdComboText = " |<%=payTermCd[1]%>";

    var bkgHngrBarTpCdComboValue = " |<%=bkgHngrBarTpCd[0]%>";   
    var bkgHngrBarTpCdComboText = " |<%=bkgHngrBarTpCd[1]%>";
    
    var bkgCnlTzCdComboValue = " |<%=bkgCnlTzCd[0]%>";   
    var bkgCnlTzCdComboText = " |<%=bkgCnlTzCd[1]%>";
    
    var bkgEsvcTpCdComboValue = " |<%=bkgEsvcTpCd[0]%>";   
    var bkgEsvcTpCdComboText = " |<%=bkgEsvcTpCd[1]%>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if

        loadPage();
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업 -->
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>" id="svc_scp_cd" />
<input type="hidden" name="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(request.getParameter("cmdt_hdr_seq"))%>" id="cmdt_hdr_seq" />
<input type="hidden" name="rout_seq" value="<%=StringUtil.xssFilter(request.getParameter("rout_seq"))%>" id="rout_seq" />
<input type="hidden" name="note_conv_mapg_id" value="<%=StringUtil.xssFilter(request.getParameter(" note_conv_mapg_id"))%>" id="note_conv_mapg_id" />
<input type="hidden" name="cd" id="cd" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>Amendment History - Rate (Route Note)</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_close" 		id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
		
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">

	<div class="wrap_result">
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_data">
			<table class = "grid2">
				<colgroup>					
					<col width="100"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr>
						<th><b>Route Note</b></th>
						<td><textarea name="ta_note_ctnt" style="resize:none;width:100%;height:80px" readonly=""></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" id="mainTable">
			<h3 class="title_design pad_btm_4">Conversion</h3>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->		
	</div>	
</div>
</form>