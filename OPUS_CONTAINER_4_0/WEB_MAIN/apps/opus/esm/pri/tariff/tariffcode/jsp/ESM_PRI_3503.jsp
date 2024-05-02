<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3503.jsp
*@FileTitle  : Tariff Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.tariffcode.event.EsmPri3503Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri3503Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    
    String[] tariffCd = null;               //Tariff Code
        
    Logger log = Logger.getLogger("com.clt.apps.Tariff.TariffCode");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

        event = (EsmPri3503Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        //COMMBO LIST       
        tariffCd        = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    var tariffCdComboValue = " |<%=tariffCd[0]%>";
    var tariffCdComboText = " |<%=tariffCd[1]%>";

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
<input type="hidden" name="strusr_id" value="<%=strUsr_id %>">
<input type="hidden" name="trf_pfx_cd">
<input type="hidden" name="trf_no">

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
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
        <button type="button" class="btn_normal" name="btn_Down_Excel" id="btn_Down_Excel">Down Excel</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- inquiry_area(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
	    <!--  biz_1 (S) -->
	    <table>
	        <colgroup>
	            <col width="75px"  />
	            <col width="160px"  />
	            <col width="75px"  />
	            <col width=""      />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th>Tariff Code</th>
	                <td><script language="javascript">ComComboObject("tariff_cd", 2, 100, 0, 0, 0, false);</script></td>
	                <th>Tariff Name</th>
	                <td><input type="text" name="trf_nm" style="width:600px;" class="input2" value="" readonly></td>
	            </tr>
	        </tbody>
	    </table>
	    <!--  biz_1   (E) -->   
	</div>
</div>
<!-- inquiry_area(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
	    <script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->

</form>
