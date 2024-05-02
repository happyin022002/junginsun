<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2019_02.jsp
*@FileTitle  : RFA Proposal Inquiry - Location Group 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.event.EsmPri201902Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri201902Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] orgDestTpCd = null;	//ORI/DST
	String[] srcInfoCd = null;		//SOURCE
	String[] prcProgStsCd = null;	//STATUS
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCGroupLocationProposal");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri201902Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//COMMBO LIST
		orgDestTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("ORG_DEST_TP_CD"), false);
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";
	var orgDestTpCdComboValue = "<%=orgDestTpCd[0]%>";
    var orgDestTpCdComboText = "<%=orgDestTpCd[1]%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="prop_no" name="prop_no" type="hidden" />
<input id="amdt_seq" name="amdt_seq" type="hidden" />
<input id="svc_scp_cd" name="svc_scp_cd" type="hidden" />
<input id="grp_loc_seq" name="grp_loc_seq" type="hidden" />


	<!-- layout_wrap (S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width: 35%">
		        <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet1');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		    
		    <div class="layout_vertical_2" style="width: 5%; text-align: center; margin-top: 170px;">
				<button type="button" name="btn_rowadd1" id="btn_rowadd1" class="btn_right"></button>				
		    </div>
		    
		     <div class="layout_vertical_2" style="width: 60%">
		        <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
		            <script type="text/javascript">ComSheetObject('sheet2');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		</div>
	<!-- layout_wrap (E) -->
</form>
