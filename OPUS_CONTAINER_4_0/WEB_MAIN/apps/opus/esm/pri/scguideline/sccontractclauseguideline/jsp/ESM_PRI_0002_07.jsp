<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0002_07.jsp
*@FileTitle : SC Guideline Contract Clause Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.event.EsmPri000207Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri000207Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//Number of DB ResultSet List
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] noteClssCd = null;			//NOTE CLASSIFICATION CODE
	String[] chgCd = null;				//SURCHARGE
	
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCContractClauseGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri000207Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Adding Logic extracting data from server when loading initial window ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		noteClssCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("NOTE_CLSS_CD"), false);
		chgCd 				= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHG_CD"), false);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	var noteClssCdComboValue = " |<%=noteClssCd[0]%>";
    var noteClssCdComboText = " |<%=noteClssCd[1]%>";
    
	var chgCdComboValue = " |<%=chgCd[0]%>";
    var chgCdComboText = " |<%=chgCd[1]%>";
    
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
<input type="hidden" name="svc_scp_cd" value="" id="svc_scp_cd" />
<input type="hidden" name="gline_seq" value="" id="gline_seq" />
<input type="hidden" name="ctrt_cluz_seq" value="" id="ctrt_cluz_seq" />
<input name="cd" type="hidden" value="" id="cd" />
<input name="etc1" type="hidden" value="" id="etc1" />
<input name="etc2" type="hidden" value="" id="etc2" />
<input name="etc3" type="hidden" value="" id="etc3" />
<input name="etc4" type="hidden" value="" id="etc4" />
<input name="etc5" type="hidden" value="" id="etc5" />



<!-- <div class="wrap_result"> -->
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
		<div class="layout_vertical_2"  style = "width: 37%">	
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="mainTable" >		
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	
		<div class="layout_vertical_2" style="width: 3%; text-align: center; margin-top: 170px;">
		    <button type="button" class="btn_right"></button>
	    </div>
   
		<!-- opus_design_grid(S) -->
		<div class="layout_vertical_2" style = "width: 60%">	
			<div class="opus_design_grid" id="mainTable" >	
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
<!-- </div> -->
</form>