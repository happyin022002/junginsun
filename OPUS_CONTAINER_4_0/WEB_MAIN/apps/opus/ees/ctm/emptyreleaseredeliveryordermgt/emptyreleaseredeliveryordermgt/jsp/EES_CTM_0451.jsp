<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0451.jsp
*@FileTitle  : Release/Re-delivery Order
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
  Exception serverException = null;    //error from server
  String strErrMsg = "";               //error message
  int rowCount = 0;                    //DB ResultSet List count

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.EmptyReleaseRedeliveryOrderMgt.EmptyReleaseRedeliveryOrderMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
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
<input type="hidden" name="unload_flag" value="reset">
<!-- developer job -->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title"><span>Release/Re-delivery Order</span></h2>
        <!-- page_title(E) -->
            
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
    <div class="wrap_result">
        <div class="opus_design_inquiry">
            <table width="737px"  height="440px" >
                <tr>
                </tr>
            </table>

            <table width="737px" class="line_bluedot"><tr><td colspan="6"></td></tr></table>

            <table width="737px">
                <tr>
                    <td width="100px"><button type="button" class="btn_etc" name="btn_print" id="btn_print">Print Only</button></td>
                    <td width="150px"></td>
                    <td width="40px">Status</td>
                    <td width="100px">
                        <select style="width:80px;" class="input" name="issue_flag" id="issue_flag">
                            <option value="R" selected>Resend</option>
                            <option value="R">Correction</option>
                            <option value="C">Cancel</option>
                        </select>
                    </td>
                    <td width="250px">
                        <input type="radio" class="trans" name="issue_type" id="issue_type1" value="P" checked><label for="issue_type1">Printer</label><!--
                        --><input type="radio" class="trans" name="issue_type" id="issue_type2" value="F"><label for="issue_type2">Fax</label><!--
                        --><input type="radio" class="trans" name="issue_type" id="issue_type3" value="E"><label for="issue_type3">E-mail</label><!--
                        --><input type="radio" class="trans" name="issue_type" id="issue_type4" value="D"><label for="issue_type4">EDI</label>
                    </td>
                    <td width="100px"><button type="button" class="btn_etc" name="btn_confirm" id="btn_confirm">Confirm</button></td>
                </tr>
            </table>
        </div>
    </div>
</div>

</form>
