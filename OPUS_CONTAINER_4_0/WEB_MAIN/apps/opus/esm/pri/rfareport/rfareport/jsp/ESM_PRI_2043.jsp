<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : ESM_PRI_2043.jsp
*@FileTitle :  RFA List Inquiry
*@author : CLT
*@version : 1.0
*@since : 2014.05.15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfareport.rfareport.event.EsmPri2043Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri2043Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from Server
    String strErrMsg = "";                      //Error Message
    int rowCount     = 0;                       //Number of DB ResultSet List

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    String[] svcScpCds = null;
    String[] customerCodes = null;
    String[] customerTypes = null;

    Logger log = Logger.getLogger("com.clt.apps.RFAReport.RFAReport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri2043Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // Adding Logic extracting data from server when loading initial window ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        // Generating Scope Combo Data
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // Generating customerCode Combo Data
        // customerCodes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("customerCode"), true , "|", "\t", "getCode", "getName");
        // Generating customerType Combo Data
        customerTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("customerType"), false , "|", "\t", "getCode", "getName");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">

    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";

    //var customerCodeComboValue = "customerCodes[0]";
    //var customerCodeComboText = "customerCodes[1]>";

    var customerTypeComboValue = "|<%=customerTypes[0]%>";
    var customerTypeComboText = "|<%=customerTypes[1]%>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<!--  Definition to check Office Code Validation -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<!--  Definition to check Office Code Validation -->
<input type="hidden" name ="ofc_cd" value="">
<!-- Form Hidden -->
<input type="hidden" name ="etc1" value="">
<input type="hidden" id="searchParam" name="eff_dt">
<input type="hidden" id="searchParam" name="exp_dt">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
	    --><button type="button" class="btn_normal" name="btn_viewrfa" id="btn_viewrfa">View RFA</button><!--
	    --><button type="button" class="btn_normal" name="btn_viewamdhistory" id="btn_viewamdhistory">View AMD History</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->
<div class="wrap_search">
<div class="opus_design_inquiry">		
	<table>
        <tr class="h23">
            <th width="75px">SVC Scope</th>
            <td width="392px"><script language="javascript">ComComboObject('svc_scp_cd', 2, 99, 0, 1, 0, false);</script>&nbsp;<input type="text" name="svc_scp_nm" style="width:229px" class="input2" readonly></td>
            <td class="search_sm2">
                <table class="search_sm2" border="0" >
                <tr class="h23">
                    <th width="110px"><input type="radio" name="rdoDate" value="2" class="trans" checked>&nbsp;RFA EFF Date</th>
                    <td width="250px">
                        <input type="text" class="input1" style="width:78px;text-align:center;" caption="RFA Effective Date From" name="eff_date_from" cofield="eff_date_to" dataformat="ymd" maxLength="10" minlength="8"><!--  
                        --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>~
                        <!--<img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19px" height="20px" border="0" align="absmiddle">-->
                        <input type="text" class="input1" style="width:78px;text-align:center;" caption="RFA Effective Date To" name="eff_date_to" cofield="eff_date_from" dataformat="ymd" maxLength="10" minlength="8"><!-- 
                        --><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button>
                        <!--<img class="cursor" name="btns_calendar2" src="img/btns_calendar.gif" width="19px" height="20px" border="0" align="absmiddle">-->
                    </td>
                    <th width="110px"><input type="radio" name="rdoDate" value="1" class="trans">&nbsp;Access Date</th>
                    <td width=""><input type="text" style="width:78px;text-align:center;" name="access_date" class="input" dataformat="ymd" maxLength="10" minlength="8" caption="Access Date"><!-- 
                    --><button type="button" class="calendar ir" name="btns_calendar3" id="btns_calendar3"></button>
                    <!--<img src="img/btns_calendar.gif" class="cursor" name="btns_calendar3" width="19px" height="20px" border="0" align="absmiddle">--></td>
                </tr>
                </table>

            </td>
        </tr>
    </table>
	<table>
       <tr class="h23">
           <!-- td width="90">
              <script language="javascript">ComComboObject('customer_code', 2, 85, 0, 0, 0, false);</script>
           </td-->
           <th width="75px">Customer<input type="hidden" value="C" name="customer_code"></th>
           <td width="407px">
              <input type="text" class="input" style="width:40px;text-align:center;ime-mode:disabled;" dataformat="engup" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd" caption="Customer Code"><!-- 
               --><input type="text" class="input" style="width:55px;text-align:center;ime-mode:disabled;" dataformat="num" name="ctrt_cust_seq" id="ctrt_cust_seq" maxlength="6" caption="Customer Code"><!--
               --><button type="button" class="input_seach_btn" name="btn_ctrt_cust" id="btn_ctrt_cust"></button>
               <!--<img class="cursor" src="img/btns_search.gif" width="19px" height="20px" border="0" align="absmiddle" name="btn_ctrt_cust">-->
              <input type="text" style="width:200px;text-align:left;" class="input2"  name="ctrt_pty_nm"  readonly=true>
           </td>
           <th width="95px">Customer Type</th>
           <td><script language="javascript">ComComboObject('prc_ctrt_cust_tp_cd', 1, 83, 0, 0, 0, false);</script></td>
       </tr>
    </table>
	<table>
       <tr class="h23">
           <th width="75px">RFA No.</th>
           <td width="124px"><input type="text" class="input" style="width:99px;text-align:center;ime-mode:disabled" name="rfa_no" dataformat="engup" maxLength="11"></td>

           <th width="100px">Request Office</th>
           <td width="174px">
              <nobr>
              <input type="text" name="prop_scp_ofc_cd" style="width:75px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="6"><!-- 
              --><button type="button" class="input_seach_btn" name="req_off_cd" id="req_off_cd"></button>
              <!--<img class="cursor" src="img/btns_search.gif" width="19px" height="20px" border="0" align="absmiddle" name="ComOpenPopupWithTarget">-->
              </nobr>
           </td>
           <th width="96px">Sales Rep.</th>
           <!-- td><script language="javascript">ComComboObject('prop_scp_srep_cd', 2, 51, 0, 0, 0, false);</script>&nbsp;<input type="text" name="prop_scp_srep_nm" style="width:355;" class="input2" readonly></td-->
           <td><input type="text" name="prop_scp_srep_cd" style="width:83px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="5"></td>
       </tr>
    </table>
</div>
</div>
<!-- 검색영역 -->
<div class="wrap_result">
<!-- 시트영역 -->
<div class="opus_design_grid">		
	<script language="javascript">ComSheetObject('sheet1');</script>
</div>
<!-- 시트영역 -->


<div style="display: none">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>
</div>
</form>
