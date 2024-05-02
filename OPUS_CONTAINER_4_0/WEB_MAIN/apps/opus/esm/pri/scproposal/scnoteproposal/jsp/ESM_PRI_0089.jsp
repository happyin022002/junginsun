<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0089.jsp
*@FileTitle  : Guideline Clause & Standard Wording List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.event.EsmPri0089Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltCtrtCluzListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0089Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String propNo = null;
    String amdtSeq = null;
    String svcScpCd = null;
    String noteClssCd = null;
    String chgCd = null;
    StringBuffer itemComboText = new StringBuffer();
    StringBuffer itemComboValue = new StringBuffer();
    //StringBuffer scgComboText = new StringBuffer();
    //StringBuffer scgComboValue = new StringBuffer();
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCNoteProposal");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0089Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        
        RsltCtrtCluzListVO vo = event.getRsltCtrtCluzListVO();
		
        if (vo != null) {
            propNo = vo.getPropNo();
            amdtSeq = vo.getAmdtSeq();
            svcScpCd = vo.getSvcScpCd();
            noteClssCd = vo.getNoteClssCd();
            chgCd = vo.getChgCd();
        } else {
            propNo = "";
            amdtSeq = "";
            svcScpCd = "";
            noteClssCd = "";
            chgCd = "";
        }
        
		 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        List<CodeInfo> item = (List<CodeInfo>)eventResponse.getCustomData("item");
        
        // Item Combo Data creation
        if (item.size() > 0) {
            int dataCount = item.size();
            CodeInfo[] vos = new CodeInfo[dataCount];
            item.toArray(vos);
    
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

        /*List<RsltCdListVO> surchage = (List<RsltCdListVO>)eventResponse.getCustomData("surchage");

        // Sub-continent Combo Data 
        if (surchage.size() > 0) {
            int dataCount = surchage.size();
            RsltCdListVO[] vos = new RsltCdListVO[dataCount];
            surchage.toArray(vos);
            
            for (int i = 0; i < dataCount; i++) {
                if (i != 0) {
                    scgComboText.append("|");
                    scgComboValue.append("|");
                }
                //scgComboText.append(vos[i].getCd()).append("\t").append(vos[i].getNm());
                scgComboText.append(vos[i].getNm());
                scgComboValue.append(vos[i].getCd());
            }
        }*/

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
    var itemComboText = "<%=itemComboText.toString()%>";
    var itemComboValue = "<%=itemComboValue.toString()%>";

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
<input type="hidden" name="prop_no" value="<%=propNo %>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=amdtSeq %>" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd %>" id="svc_scp_cd" />
<input type="hidden" name="note_clss_cd" value="<%=noteClssCd %>" id="note_clss_cd" />
<input type="hidden" name="chg_cd" value="<%=chgCd %>" id="chg_cd" />
 
<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
			<h2 class="page_title"><span>Guideline Clause & Standard Wording List</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		    <button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result"> 
		<div class="opus_design_grid" id="mainTable">
			<h3 class="title_design pad_btm_8">Guideline</h3>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		 <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
		<div class="opus_design_grid" id="mainTable">
			<h3 class="title_design pad_btm_8">Standard Wording</h3>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>	
</div>
</form>