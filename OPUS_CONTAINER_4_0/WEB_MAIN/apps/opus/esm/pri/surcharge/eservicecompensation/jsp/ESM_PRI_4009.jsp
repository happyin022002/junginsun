<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4009.jsp
*@FileTitle  : E-Service Compensation Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
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
<%@ page import="com.clt.apps.opus.esm.pri.surcharge.eservicecompensation.event.EsmPri4009Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri4009Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    String[] svcScpCds = null;
    String[] origins = null;
    String[] dests = null;
    String[] charges = null;
    String[] curs = null;
    String[] ctrtTypeArr = null;
    Logger log = Logger.getLogger("com.clt.apps.Surcharge.Eservicecompensation");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (EsmPri4009Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        // scope Combo Data 
        svcScpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("svcScpCd"));
        // orign Combo Data 
        origins = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("origin"));
        // dest Combo Data 
        dests = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dest"));
        // charge Combo Data 
        charges = PRIUtil.getValueObject2StringArray((List<RsltCompensationChargeComboListVO>)eventResponse.getCustomData("charge"), true , "|", "\t", "getChgCd", "getChgNm");
        // cur Combo Data 
        curs = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cur"));
        // Contract Type Combo Data 
        ctrtTypeArr = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contract"),true ,"|","\t","getCode","getName");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    var svcScpCdComboValue = " |<%=svcScpCds[0]%>";
    var svcScpCdComboText = " |<%=svcScpCds[1]%>";
    var originComboValue = " |<%=origins[0]%>";
    var originComboText = " |<%=origins[1]%>";
    var destComboValue = " |<%=dests[0]%>";
    var destComboText = " |<%=dests[1]%>";
    var chargeComboValue = " |<%=charges[0]%>";
    var chargeComboText = " |<%=charges[1]%>";
    var curComboValue = " |<%=curs[0]%>";
    var curComboText = " |<%=curs[1]%>";
    var ctrtTypeCode = "|<%=ctrtTypeArr[0]%>";
    var ctrtTypeText = "|<%=ctrtTypeArr[1]%>";
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

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
		   <colgroup>
		   		<col width="50"/>
		   		<col width="150"/>
		   		<col width="50"/>
		   		<col width="150"/>
		   		<col width="50"/>
		   		<col width="150"/>
		   		<col width="50"/>
		   		<col width="150"/>
		   		<col width="*"/>
		   </colgroup>
           <tr>
               <th>RFA No.</th>
               <td><input type="text" name="sc_no" style="width:90px;text-align:center;" class="input" dataformat="engup" maxlength="11" minlength="9" caption="RFA No" id="sc_no" /> </td>
               <th>Contract Type</th>
               <td><script type="text/javascript">ComComboObject('prc_ctrt_tp_cd', 2, 82, 0, 0, 1, false);</script></td>
               <th>Service Scope</th>
               <td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 82, 0, 0, 0, false);</script><input type="text" name="svc_scp_nm" style="width:240;" class="input2" caption="Service Scope" readonly></td>
               <td></td>
               <td></td>
               <td></td> 
           </tr>
           <tr>
               <th>Charge</th>
               <td><script type="text/javascript">ComComboObject('chg_cd', 2, 90, 0, 0, 0, false);</script></td>
               <th>Origin</th>
               <td><script type="text/javascript">ComComboObject('org_rgn_cd', 2, 82, 0, 0, 0, false);</script></td>
               <th>Dest.</th>
               <td><script type="text/javascript">ComComboObject('dest_rgn_cd', 2, 82, 0, 0, 0, false);</script></td>
               <th>Access Date</th>
               <td><input type="text" name="eff_dt" style="width:80px;text-align:center;" class="input" dataformat="ymd" maxlength="10" minlength="8" caption="Effective Date" id="eff_dt" /><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
               <td></td>
           </tr>
       </table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_del" id="btn_del" type="button">Delete</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>