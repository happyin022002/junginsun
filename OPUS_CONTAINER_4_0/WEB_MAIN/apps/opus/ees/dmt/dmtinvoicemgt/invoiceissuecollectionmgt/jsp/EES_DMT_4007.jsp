<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_4007.js
*@FileTitle  : Manual Invoice Report by Office - Detail(s)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4007Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    EesDmt4007Event  event = null;               //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB ResultSet list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    
    String tIssoff = "";
    String tJspno = "";
    String tFmdt = "";
    String tTodt = "";
    String tOfcFlg = "";
    String tOffice = "";
    String tReason = "";
    String selcur = "";
    
    Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();


        event = (EesDmt4007Event)request.getAttribute("Event");
        tIssoff = StringUtil.xssFilter((String)request.getParameter("issoff"));
        tJspno = StringUtil.xssFilter((String)request.getParameter("jspno"));
        tFmdt = StringUtil.xssFilter((String)request.getParameter("fmdt"));
        tTodt = StringUtil.xssFilter((String)request.getParameter("todt"));
        tOfcFlg = StringUtil.xssFilter((String)request.getParameter("ofcflg"));
        tOffice = StringUtil.xssFilter((String)request.getParameter("office"));
        tReason = StringUtil.xssFilter((String)request.getParameter("reason"));
        selcur = StringUtil.xssFilter((String)request.getParameter("selcur"));
        
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="tJspno" value="<%=tJspno%>" id="tJspno" />
<input type="hidden" name="h_user_office" value="<%= strUsr_of %>" id="h_user_office" />
<input type="hidden" name="fm_dt" value="<%= tFmdt   %>" id="fm_dt" />
<input type="hidden" name="to_dt" value="<%= tTodt   %>" id="to_dt" />
<input type="hidden" name="ofc_flg" value="<%= tOfcFlg %>" id="ofc_flg" />
<input type="hidden" name="office" value="<%= tOffice %>" id="office" />
<input type="hidden" name="reasoncd" value="<%= tReason %>" id="reasoncd" />
<input type="hidden" name="selcur" value="<%= selcur %>" id="selcur" />
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Manual Invoice Report by Office – Detail(s)</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_detail" 	id="btn_detail">Detail</button><!--
				--><button type="button" class="btn_normal" name="btn_downexcel" 		id="btn_downexcel">Down Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_close"  		id="btn_close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
			<!-- page_location(S) -->
			<div class="location">
				<span id="navigation"></span>
			</div>
			<!-- page_location(E) --> 
		</div>
	</div>
		<!-- page_title_area(E) -->
	<!-- opus_design_grid(S) -->
	<div class = "layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="60"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>INV Q'tye</th>
						<td> <input type="text" name="invqtybox"  id="invqtybox" style="width:50px;text-align:right" class="input2" value="" readOnly></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_grid(E) -->	
	</div>

</form>   