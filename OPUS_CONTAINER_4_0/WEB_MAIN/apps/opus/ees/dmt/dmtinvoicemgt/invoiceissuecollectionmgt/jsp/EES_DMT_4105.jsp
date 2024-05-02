<%
/*========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved
*@FileName   : EES_DMT_4105.jsp
*@FileTitle  : Remark(s)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4105Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    EesDmt4105Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB ResultSet list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    String tInvno = "";
    String tJspno = "";

    Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesDmt4105Event)request.getAttribute("Event");
        tInvno = (String)request.getParameter("invno");
        tJspno = (String)request.getParameter("jspno");

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // in loading page, Get data from server.
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="tinvno" value="<%=StringUtil.xssFilter(tInvno)%>" id="tinvno" />
<input type="hidden" name="tjspno" value="<%=StringUtil.xssFilter(tJspno)%>" id="tjspno" />
<input type="hidden" name="rmrk" id="rmrk" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Remark(s)</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
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
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th><span id="dmt4105"></span></th>
               		<td><input type="text" style="width:100px;" class="input2" value="<%= StringUtil.xssFilter(tInvno) %>" name="invno" id="invno" readOnly></td>
		   		</tr>
		   </tbody>
		</table>
		 <table class="grid_2"> 
                   <tr>
                   		<th style="text-align:center" colspan="2">Remark(s) on Sheet</th>
                   	</tr>
                   <tr>
	                   <td class="input1" style="text-align:center" valign="middle">1</td>
	                   <td class="input1"><input type="text" style="width:100%;font-family: Courier New;" class="noinput1" value="" name="remark01" id="remark01" maxlength="85" required></td>
                   </tr>
                   <tr>
	                   <td class="input1" style="text-align:center" valign="middle">2</td>
	                   <td class="input1"><input type="text" style="width:100%;font-family: Courier New;" class="noinput1" value="" name="remark02" id="remark02" maxlength="85" required></td>
                   </tr>
          </table> 
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		
		<script type="text/javascript">ComSheetObject('sheet1',0,0);</script>	
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>         

