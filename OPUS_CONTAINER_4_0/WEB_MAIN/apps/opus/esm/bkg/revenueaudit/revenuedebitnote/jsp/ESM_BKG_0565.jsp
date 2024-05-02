<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0565.jsp
*@FileTitle  : RDN Performance Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0565Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmBkg0565Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //DB ResultSet List count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_office_cd = "";
    //String strUsr_office_nm = "";
    
    String[] rhqs = null;
    String[] resp = null;
    
    Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.RevenueDebitNote");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        strUsr_office_cd =  account.getOfc_cd();
        //strUsr_office_nm =  account.getOfc_eng_nm();

        event = (EsmBkg0565Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // rhq
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
      //resp
        resp = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("resp"));

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";
    var respComboValue = "<%=resp[0]%>";
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- combo -->
<input type="hidden" name="cd"   value=""> 
<input type="hidden" name="etc1" value="">
<input type="hidden" name="etc2" value="">
<input type="hidden" name="etc3" value="">
<!-- rdn status cd -->
<input type="hidden" name="rdn_sts_cd" value="">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
        --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
        --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down&nbsp;Excel</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- inquiry_area(S) -->
<div class="opus_design_inquiry">
    <!--  biz_1 (S) -->
    <table>
        <colgroup>
            <col width="30px"  />
            <col width="50px"  />
            <col width="75px"  />
            <col width="85px"  />
            <col width="75px"  />
            <col width="105px" />
            <col width="75px"  />
            <col width="110px" />
            <col width="75px"  />
            <col width="95px"  />
            <col width=""      />
        </colgroup>
        <tbody>
            <tr>
                <th colspan="2">Receipt RHQ</th>
                <td><script type="text/javascript"> ComComboObject('rct_rhq_cd', 1, 70, 0, 0, 0, false);</script></td>
                <th>Receipt Office</th>
                <td><script type="text/javascript"> ComComboObject('rct_ofc_cd', 1, 70, 0, 0, 0, false);</script></td>
                <th>Responsible RHQ</th>
                <td><script type="text/javascript"> ComComboObject('respb_rhq_cd', 1, 70, 0, 0, 0, false);</script></td>
                <th>Responsible Office</th>
                <td><script type="text/javascript"> ComComboObject('respb_ofc_cd', 1, 70, 0, 0, 0, false);</script></td>
                <th>RDN Issue Date</td>
                <td>
                    <input name="rdn_iss_dt_from" type="text" style="width:75px;text-align:center;"  value="" class="input1" caption="From Date" maxlength="10" dataformat="ymd">
                    <button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>~
                    <input name="rdn_iss_dt_to" type="text" style="width:75px;text-align:center;"  value="" class="input1" caption="To Date" maxlength="10" dataformat="ymd">
                    <button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button>
                </td>
            </tr> 
            <tr style="height:30px">
                <th></th>
                <th class="sm">Status</th>
                <td class="sm" colspan = "7">
                    <input name="all"           type="checkbox" value="ALL" class="trans" checked onClick="checkAll();">&nbsp;ALL&nbsp;&nbsp;
                    <input name="rdn_sts_check" type="checkbox" value="IS" class="trans" checked onClick="checkItem();" checked>&nbsp;Issued&nbsp;&nbsp;
                    <input name="rdn_sts_check" type="checkbox" value="AC" class="trans" onClick="checkItem();" checked>&nbsp;Accepted&nbsp;&nbsp;
                    <input name="rdn_sts_check" type="checkbox" value="RR" class="trans" onClick="checkItem();" checked>&nbsp;Revise Requested&nbsp;&nbsp;
                    <input name="rdn_sts_check" type="checkbox" value="RV" class="trans" onClick="checkItem();" checked>&nbsp;Revised&nbsp;&nbsp;
                    <input name="rdn_sts_check" type="checkbox" value="CR" class="trans" onClick="checkItem();" checked>&nbsp;Cancel Requested&nbsp;&nbsp;
                    <input name="rdn_sts_check" type="checkbox" value="ST" class="trans" onClick="checkItem();" checked>&nbsp;Settled&nbsp;&nbsp;
                    <input name="rdn_sts_check" type="checkbox" value="CL" class="trans" onClick="checkItem();" checked>&nbsp;Canceled
                </td>
                <td colspan = "2"></td>
            </tr>
        </tbody>
    </table>
    <!--  biz_1   (E) -->   
</div>
<!-- inquiry_area(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
	  	 	<script type="text/javascript">ComSheetObject('sheet0');</script>
	    	<p class="mar_btm_8">Currency : USD</p>
	    	<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
