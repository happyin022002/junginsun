<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_5101.jsp
*@FileTitle : Hold Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5101Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    EesDmt5101Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB ResultSet list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String strUsr_of = "";
    String strUsr_dt = "";
    
    String invoiceNo = "";
    
    Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strUsr_dt = account.getCre_dt();


        event = (EesDmt5101Event)request.getAttribute("Event");
        invoiceNo = StringUtil.xssFilter((String)request.getParameter("invoiceNo"));
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
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
<input type="hidden" name="holdReasn">


<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	
	<h2 class="page_title"><span>&nbsp;Hold Reason Entry</span></span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn1_save" id="btn1_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_close"  	id="btn1_close">Close</button>
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
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">    
	    	<table>
			<tbody>
				<colgroup>
					<col width="70"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Invoice No.  </th>
                        <td><input type="text" style="width:420;" class="input2" value="<%= invoiceNo %>" name="invoiceNo" readOnly></td>
				</tr>
			</tbody>
		</table>
		</div>
	</div>    
	
<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div  class="opus_design_inquiry wFit">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	<table>
		<tbody>
			<colgroup>
				<col width="55px"/>
				<col width="100%"/>
		    </colgroup>
			<tr>
				<th>Remark(s)</th>
         		<td><textarea cols="" rows="3" name="holdRemrk"></textarea> </td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="320"/>
				<col width="*"/>
		    </colgroup>
			<tr>
				<td>
                    <input type="text" style="width:75;" class="input2" value="<%=strUsr_dt%>" Name="holdYear" readOnly><!--
                 --><input type="text" style="width:75;" class="input2" value="<%=strUsr_of%>" Name="holdOffc" readOnly><!--
                 --><input type="text" style="width:150;" class="input2" value="<%=strUsr_nm%>" Name="holdUser" readOnly>
                </td>
			</tr>
		</tbody>
	</table>
	
</div>
<!-- opus_tab_btn(E) -->
</div>
</form>

