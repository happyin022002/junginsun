<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_2048.jsp
*@FileTitle  : RFA Guideline Creation - Arbitrary[Load Excel]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.event.EsmPri2048Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo.RsltPriRgArbKeyVO" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2048Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//server error
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String svcScpCd		= "";
	String glineSeq		= "";
	String orgDestTpCd		= "";

	//COMBO CODE
	String[] rcvDeTermCd = null;    	//TERM
	String[] prcTrspModCd = null;    	//TRANS. MODE
	String[] prcCgoTpCd = null;    		//CARGO TYPE
	String[] ratUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	
	String templateKey = null;
	
	Logger log = Logger.getLogger("com.clt.apps.RFAGuideline.RFAArbitraryChargeGuideline");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri2048Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		RsltPriRgArbKeyVO rsltPriRgArbKeyVO = event.getRsltPriRgArbKeyVO();		
		if(rsltPriRgArbKeyVO != null) {
			glineSeq = rsltPriRgArbKeyVO.getGlineSeq();
			svcScpCd = rsltPriRgArbKeyVO.getSvcScpCd();
			orgDestTpCd = rsltPriRgArbKeyVO.getOrgDestTpCd();
		}
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
        rcvDeTermCd			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RCV_DE_TERM_CD"), false);
        prcTrspModCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_TRSP_MOD_CD"), false);
        prcCgoTpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_CGO_TP_CD"), false);
        ratUtCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RAT_UT_CD"), false);      
        currCd 				= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);   
        
        // Excel Template File Key
        templateKey = (String)eventResponse.getCustomData("templateKey");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
    var rcvDeTermCdComboValue = " |<%=rcvDeTermCd[0]%>";   
    var rcvDeTermCdComboText = " |<%=rcvDeTermCd[1]%>";
    
    var prcTrspModCdComboValue = " |<%=prcTrspModCd[0]%>";   
    var prcTrspModCdComboText = " |<%=prcTrspModCd[1]%>";
    
    var prcCgoTpCdComboValue = " |<%=prcCgoTpCd[0]%>";
    var prcCgoTpCdComboText = " |<%=prcCgoTpCd[1]%>";
       
    var ratUtCdComboValue = " |<%=ratUtCd[0]%>";   
    var ratUtCdComboText = " |<%=ratUtCd[1]%>";
    
    var currCdComboValue = "<%=currCd[0]%>";   
    var currCdComboText = "<%=currCd[1]%>";
     
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd %>">
<input type="hidden" name="gline_seq" value="<%=glineSeq %>">
<input type="hidden" name="org_dest_tp_cd" value="<%=orgDestTpCd %>">
<input type="hidden" name="cd" >

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>RFA Guideline Creation - Arbitrary [Load Excel]</span></h2>
		
		<div class="opus_design_btn">
			  <button type="button" class="btn_normal" name="btn_Template" id="btn_Template">Template</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_file" id="btn_file">Open File</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_check" id="btn_check">Check</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents" style="overflow:auto; overflow:hidden;">
	<div class="wrap_result">
		<div class="opus_design_inquiry">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
<!-- Grid (S) -->
<div style="display:block;">
	<table id="mainTable"> 
		<tr>
			<td>
				<script language="javascript">ComSheetObject('sheet2');</script>
			</td>
		</tr>
	</table>
</div>	
<!-- Grid (E) -->

</form>

<form name="downform" action="/opuscntr/FileDownload" method="post" target="downifm">
	<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>
<iframe name="downifm" style="display:none;"></iframe>
