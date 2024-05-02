<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2049.jsp
*@FileTitle  : RFA Proposal & Amendment Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2049Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri2049Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFAProposalMain");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri2049Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
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
<input type="hidden" name="usr_id" value="<%=strUsr_id %>">
<!-- developer performance -->

<div class="page_title_area clear">
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
        --><button type="button" class="btn_normal" name="btn_Open" id="btn_Open">Open</button>
    </div>

    <div class="location">
        <span id="navigation"></span>
    </div>
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry">
	    <table>
	        <colgroup>
	            <col width="56px"  />
	            <col width="110px"  />
	            <col width="20px"      />	            
	            <col width="56px"  />
	            <col width=""      />
	        </colgroup>
	        <tbody>
	            <tr>
	                <td class="sm" colspan="2">
	                    <input type="radio" name="trans_tp_cd" value="R" class="trans" checked="checked" caption="Transfer Type" required>&nbsp;Received&nbsp;&nbsp;&nbsp;&nbsp;
	                    <input type="radio" name="trans_tp_cd" value="S" class="trans">&nbsp;Sent
	                </td>
	                <td colspan="3"></td>
	            </tr> 
	            <tr>
	                <th>Duration</th>
	                <td>
	                    <input type="text" style="width:75px;text-align:center;" name="eff_dt" cofield="exp_dt" value="" class="input1" caption="Effective Date" maxlength="10" dataformat="ymd" required><!--
	                    --><button type="button" class="calendar ir" name="btn_calendar1" id="btn_calendar1"></button>
	                <td></td>
	                <th>Through</th>
	                <td>
	                    <input type="text" style="width:75px;text-align:center;" name="exp_dt" cofield="eff_dt" value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required><!--
	                    --><button type="button" class="calendar ir" name="btn_calendar2" id="btn_calendar2"></button>
	                </td>
	            </tr>
	        </tbody>
	    </table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <script language="javascript">ComSheetObject('sheet2');</script>
	</div>
</div>

</form>
