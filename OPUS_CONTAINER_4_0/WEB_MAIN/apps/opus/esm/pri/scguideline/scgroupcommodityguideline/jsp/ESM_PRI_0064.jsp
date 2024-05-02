<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0064.jsp
*@FileTitle  : Surcharge Group Commodity Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.event.EsmPri0064Event"%>
<%@ page import="com.clt.syscommon.common.table.PriSgGrpCmdtVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0064Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String svcScpCd = null;
    String glineSeq = null;
    String prcCustTpCd = null;
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGroupCommodityGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0064Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

        PriSgGrpCmdtVO vo = event.getPriSgGrpCmdtVO();
        
        if (vo != null) {
            svcScpCd = vo.getSvcScpCd();
            glineSeq = vo.getGlineSeq();
            prcCustTpCd = vo.getPrcCustTpCd();
        } else {
            svcScpCd = "";
            glineSeq = "";
            prcCustTpCd = "";
        }
		 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
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
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd" value="<%=svcScpCd %>">
<input type="hidden" name="gline_seq" id="gline_seq"  value="<%=glineSeq %>">
<input type="hidden" name="prc_cust_tp_cd" id="prc_cust_tp_cd" value="<%=prcCustTpCd %>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Surcharge Group Commodity Select</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_Ok" id="btn_Ok">OK</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_CheckAll" id="btn_CheckAll">Check All</button><!-- 
		 --><button type="button" class="btn_accent" name="btn_UncheckAll" id="btn_UncheckAll">Uncheck All</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>