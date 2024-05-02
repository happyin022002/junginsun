<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4012.jsp
*@FileTitle  : Outstanding Issue Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EES_DMT_4011HTMLAction"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4011Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    EesDmt4011Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB ResultSet list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    String strUsr_em = "";

    String tTftp2 = "";
    String tSheetp = "";
    String tIsof = "";
    String tPayc = "";
    String tBkgNo = "";
    String invno = "";
    String attyn = "";

    String mailContents =    "<br>"
                            +"Attached to this e-mail is a Demurrage / Detention Statement from NYK Line. <br>" 
                            +"If you have any difficulties or questions pertaining to the statement, <br>"
                            +"please contact our local branch office. <br>"
                            +"<br>"
                            +"NYK Line Co., Ltd <br>" 
                            +"<br>"
                            +"www.nyk.com <br>"  
                            +"<br>";


    Logger log = Logger.getLogger("com.clt.apps.eqtransportplannperform.eqtransportplannperform");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strUsr_em = account.getUsr_eml();
        event = (EesDmt4011Event)request.getAttribute("Event");
        tIsof = StringUtil.xssFilter((String)request.getParameter("isof"));
        tTftp2 = StringUtil.xssFilter((String)request.getParameter("tftp2"));
        tSheetp = StringUtil.xssFilter((String)request.getParameter("sheetp"));        
        tBkgNo = StringUtil.xssFilter((String)request.getParameter("bkgno"));
        tPayc = StringUtil.xssFilter((String)request.getParameter("payc"));
        invno = StringUtil.xssFilter((String)request.getParameter("invno"));
        attyn = StringUtil.xssFilter((String)request.getParameter("attyn"));

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




<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
    function setupPage(){
        loadPage();     
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />

<input type="hidden" name="h_usr_off" value="<%=strUsr_of%>" id="h_usr_off" />
<input type="hidden" name="invno" id="invno" />
<input type="hidden" name="tftp2" id="tftp2" />
<input type="hidden" name="creof" id="creof" />
<input type="hidden" name="sheetp" value="<%=tSheetp%>" id="sheetp" />
<input type="hidden" name="isof" value="<%=tIsof%>" id="isof" />
<input type="hidden" name="payc" value="<%=tPayc%>" id="payc" />
<input type="hidden" name="bkgno" value="<%=tBkgNo%>" id="bkgno" />

<input type="hidden" name="rd_fxeml_sys_cd" id="rd_fxeml_sys_cd" />
<input type="hidden" name="rd_fxeml_file_name" id="rd_fxeml_file_name" />
<input type="hidden" name="rd_fxeml_file_name2" id="rd_fxeml_file_name2" />
<input type="hidden" name="rd_fxeml_bat_flg" id="rd_fxeml_bat_flg" />
<input type="hidden" name="rd_fxeml_title" id="rd_fxeml_title" />
<input type="hidden" name="rd_fxeml_doc_tp" id="rd_fxeml_doc_tp" />
<input type="hidden" name="rd_fxeml_rd_param" id="rd_fxeml_rd_param" />
<input type="hidden" name="rd_fxeml_rd_param2" id="rd_fxeml_rd_param2" />
<input type="hidden" name="rd_fxeml_fax_no" id="rd_fxeml_fax_no" />
<input type="hidden" name="rd_fxeml_fax_sndr_id" id="rd_fxeml_fax_sndr_id" />
<input type="hidden" name="rd_fxeml_eml_sndr_nm" id="rd_fxeml_eml_sndr_nm" />
<input type="hidden" name="rd_fxeml_eml_sndr_add" value="<%= strUsr_em %>" id="rd_fxeml_eml_sndr_add" />
<input type="hidden" name="rd_fxeml_eml_sndr_fixed" id="rd_fxeml_eml_sndr_fixed" />
<input type="hidden" name="rd_fxeml_eml_rcvr_add" id="rd_fxeml_eml_rcvr_add" />
<input type="hidden" name="rd_fxeml_eml_atch_file" id="rd_fxeml_eml_atch_file" />
<input type="hidden" name="rd_fxeml_eml_templt" id="rd_fxeml_eml_templt" />
<input type="hidden" name="rd_fxeml_eml_tmplt_param" id="rd_fxeml_eml_tmplt_param" />
<input type="hidden" name="offcd" value="<%=tIsof%>" id="offcd" />
<input type="hidden" name="mailctnt" value="<%= mailContents %>" id="mailctnt" />

<div class="layer_popup_title">
	
	<div class="page_title_area clear">	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Outstanding Issue Preview</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_OTS_Print" id="btn_OTS_Print">OTS Print</button><!-- 
			--><button type="button" class="btn_normal" name="btn1_fax_send" id="btn1_fax_send">Fax Send</button><!-- 
			--><button type="button" class="btn_normal" name="btn1_email_send" id="btn1_email_send">Email Send</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!-- 
		 --></div>
		<!-- opus_design_btn(E) -->	
	</div>
	
</div>
	
<div class="layer_popup_contents">	
	<div class="wrap_result">
    	<div class="opus_design_RD" style="height:88%!important">
			<script type="text/javascript">rdViewerObject();</script>
    	</div>
		 <div style="position:relative;top:88%">
			<div class="opus_design_inquiry wFit">  <!-- no TAB  -->
				<table> 
						<tr>
	                        <th width="100px">Attention<th>
	                        <td width="170px"><input type="text" style="width:154px;" class="input2" name="atn_val" value="" readonly id="atn_val" /> </td>
	                        <th width="100px">Tel.<th>
	                        <td width="170px"><input type="text" style="width:150px;" class="input2" name="tel_val" value="" readonly id="tel_val" /> </td>
	                        <th width="40px">Fax<th>
	                        <td width="170px"><input type="text" style="width:150px;" class="input2" name="fax_val" value="" readonly id="fax_val" /> </td>
	                        <th width="40px">E-mail<th>
	                        <td width="*"><input type="text" style="width:180px;" class="input2" name="eml_val" value="" readonly id="eml_val" /> </td>
	                    </tr>
	                    <tr>
	                        <th>OTS Sheet<th>
	                        <td>Group by 
		                        <select style="width:101px;" class="input" name="cntrinvno2"  disabled>
		                        <option value="0" selected>INV No.</option>                        
		                        <option value="1">CNTR No.</option>
		                        </select>
	                        </td>
	                        <th>CNTR Rate Detail(s)<th>
	                        <td colspan="5"><input type="checkbox" value="" class="trans" name="attachYN" disabled  title="Attach CNTR Rate Detail(s) to OTS Invoice Sheet" <%if ("Y".equals(attyn)){ %> checked <% } %>>Attach</td>
	                    </tr>
				</table>
			</div>
		</div>
		<div class="opus_design_grid" id="mainTable2" style=display:none; >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>	
</form>


