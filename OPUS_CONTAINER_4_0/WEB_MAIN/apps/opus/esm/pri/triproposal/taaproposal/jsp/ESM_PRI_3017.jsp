<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_3017.jsp
*@FileTitle  : TAA Creation & Amendment [Amend]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/03
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.taaproposal.event.EsmPri3017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String taaNo = null;
    String amdtSeq = null;
    String effDt = null;
    String expDt = null;
    int iAmdtSeq = 0;
    
	Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TAAProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	    taaNo   = JSPUtil.getNull(request.getParameter("taa_no"));
	    amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
	    effDt   = JSPUtil.getNull(request.getParameter("eff_dt"));
	    expDt   = JSPUtil.getNull(request.getParameter("exp_dt"));
	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
    var amdtSeq = "<%=amdtSeq%>";
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
<input type="hidden" name="amdt_seq">
<input type="hidden" name="old_eff_dt" value="<%=effDt %>">
<input type="hidden" name="old_exp_dt" value="<%=expDt %>">
 

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>TAA Creation & Amendment [Amend]</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_OK" id="btn_OK">OK</button><!-- -->
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" width="100%">
                <tr class="h23">
                    <th width="55">TAA  No.</th>
                    <td class="100"><input type="text" name="taa_no" style="width:80;text-align:center;" class="input2" readonly="readonly" value="<%=taaNo %>"></td>
                    <th width="55">AMD  No.</th>
                    <td class=""><input type="text" name="old_amdt_seq" style="width:35;text-align:center;" class="input2" readonly="readonly" value="<%=amdtSeq %>"></td>
                </tr>
                <tr class="h23">
                    <th width="95">AMD Duration</th>
                    <td class=""><input type="text" caption="Effective date" name="eff_dt" cofield="exp_dt" maxlength="10" dataformat="ymd" style="width:80;text-align:center;" class="input1" required> 
								 <span class="dash">~</span>
                        		 <input type="text" caption="Expiration date" name="exp_dt" cofield="eff_dt" maxlength="10"  dataformat="ymd" style="width:80;text-align:center;" class="input1" required>
                         	 	 <button class="calendar ir" name="btns_calendar" id="btns_calendar" type="button"></button>
                   </td>
                </tr>
      		</table>	
		</div>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>

</form>