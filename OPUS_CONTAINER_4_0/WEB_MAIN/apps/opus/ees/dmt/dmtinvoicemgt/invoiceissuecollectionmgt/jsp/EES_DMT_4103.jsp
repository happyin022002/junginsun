<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4103.jsp
*@FileTitle  : Sheet Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4103Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    EesDmt4103Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB ResultSet list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String strUsr_of = "";
	String[] arrUsrAuth = null;
	String sec_invoice	= "Y";	//setting button authority of Save, Cancel, A/R I/F
	int i_cnt = 0;
    
    String tIsof = "";
    String tJspno = "";
    String tTftp = "";
    String invoice_issue = "";
    
    Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
		arrUsrAuth	= account.getUserAuth();	//COM_USR_ROLE_MTCH의 USR_ROLE_CD
		StringBuffer sb = new StringBuffer();
		
		// check authority- Role of login User - DMT01, DMT02, DMT03, DMT04
		//					no authority: disply alert "You have no authority to XXXX!" 
		if(arrUsrAuth == null){
			log.debug("[USER_AUTH] null");
			sec_invoice = "N";
		}else{
			log.debug("[USER_AUTH] "+arrUsrAuth.length);
			for(int i = 0; i < arrUsrAuth.length; i++) {
				//test
				sb.append(arrUsrAuth[i]).append("===");
				
				if(arrUsrAuth[i].equals("DMT01") 
						|| arrUsrAuth[i].equals("DMT02") 
						|| arrUsrAuth[i].equals("DMT03")
						|| arrUsrAuth[i].equals("DMT04"))
				{
					i_cnt++;
				}
			}
			if(i_cnt == 0 ){
				sec_invoice = "N";
			}
		}
		
		log.debug("[USER_AUTH]"+sb.toString());



        event = (EesDmt4103Event)request.getAttribute("Event");
        tIsof = StringUtil.xssFilter((String)request.getParameter("issoff"));
        tJspno = StringUtil.xssFilter((String)request.getParameter("jspno"));
        tTftp = StringUtil.xssFilter((String)request.getParameter("tftp"));
        invoice_issue   = JSPUtil.getParameter(request,"invoice_issue","1");
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<input type="hidden" name="tIsof" id="tIsof"  value="<%=tIsof %>">
<input type="hidden" name="tJspno" id="tJspno" value="<%=tJspno%>">
<input type="hidden" name="tTftp" id="tTftp" value="<%=tTftp%>">
<input type="hidden" name="invoice_issue" id="invoice_issue" value="<%=invoice_issue%>">
<input type="hidden" name="h_user_office" id="h_user_office" value="<%= strUsr_of %>">
<input type="hidden" name="sec_invoice"  id="sec_invoice" value="<%=sec_invoice %>"><!-- invoice saving authority -->
<input type="hidden" name="selectRowNumUp" id="selectRowNumUp" value="2">
<input type="hidden" name="selectRowNumDw" id="selectRowNumDw" value="2">


	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Sheet Option</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			   <button class="btn_accent" type="button" name="btn_save" id="btn_save">Save</button><!--
			--><button class="btn_normal" type="button" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->


	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="20" />				
					<col width="*" />				
			   </colgroup> 
				<tbody>
					<tr>
		               <th>Issue Office</th>
		               <td><input type="text" style="width:70px;text-align:center;" class="input2" value="<% if ( invoice_issue.equals("2") ) { %><%=tIsof%><% } else { %><%=strUsr_of%><% } %>" name="isof" id="isof" readOnly></td>
	               </tr>
				</tbody>
			</table>			
	    </div>	
	</div>
	
	<div class="wrap_result">
	    <h3 class="title_design mar_top_8" id="titleLayer">Payer</h3>
			<table class="grid_2">
				<colgroup>
					<col width="90" />
					<col width="90" />	
					<col width="90" />	
					<col width="*" />
			   </colgroup> 
				<tbody>
					<tr>
	                    <th width="18%"><b>“To” Location</b></th>
	                    <td width=200px>
	                        <select style="width:90px;" class="input" name="toloca" id="toloca">
	                            <option value="L" selected>Left</option>
	                            <option value="R">Right</option>
	                        </select>in Sheet
	                    </td>
	                    <th width="18%"><b>Cust. Ref.</b></th>
	                    <td width=200px>
	                        <select style="width:90px;" class="input" name="cusref" id="cusref">
	                            <option value="Y" selected>Include</option>
	                            <option value="N">Exclude</option>
	                        </select>in Sheet
	                    </td>
	                </tr>
	                <tr>
	                    <th><b>Tel. & Fax</b></th>
	                    <td width=200px>
	                        <select style="width:90px;" class="input" name="telfax" id="telfax">
	                            <option value="Y" selected>Include</option>
	                            <option value="N">Exclude</option>
	                        </select>in Sheet
	                    </td>
	                    <th><b>Cust. VAT No.</b></th>
	                    <td width=200px>
	                        <select style="width:90px;" class="input" name="cusvat" id="cusvat">
	                            <option value="Y">Include</option>
	                            <option value="N" selected>Exclude</option>
	                        </select>in Sheet
	                    </td>
	                </tr>
				</tbody>
			</table>
			
		<!-- opus_design_inquiry(E) -->
	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid"  id="mainTable">
			<h3 class="title_design" id="titleLayer">Credit Term</h3>
			<div class="opus_design_btn"> 
				<button class="btn_normal" type="button"  name="btn2_rowadd01" id="btn2_rowadd01">Row Add</button>
				<button class="btn_normal" type="button"  name="btn2_rowdel01" id="btn2_rowdel01">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- opus_design_grid(E) -->
		</div>
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_data">
			<h3 class="title_design" id="titleLayer">Amount</h3>
			<table class="grid_2">
				<tbody>
					<tr>
	                    <th width="110px"><b>D/C by AMT or %</b></th>
	                    <td colspan="4">
	                        <select style="width:85px;" class="input" name="dcamtr" id="dcamtr">
	                        <option value="Y">Include</option>
	                        <option value="N" selected>Exclude</option>
	                        </select>&nbsp;in Sheet</td>
	                    
	                </tr>            
	                <tr>
	                    <th><b>Tax Rate</b></th>
	                    <td width="10%"><input type="text" style="width:100%;text-align:right" class="noinput" value="0" name="taxrto" dataformat="float" maxlength="6" pointcount="3"></td>
	                    <td width="15%"><input type="text" style="width:100%;text-align:right" class="noinput" value=" %" readOnly></td>
	                    <th><b>Tax Rate & VAT Amount</b></th>
	                    <td width=150px>
	                        <select style="width:90px;" class="input" name="rtovat" id="rtovat">
	                            <option value="Y" selected>Include</option>
	                            <option value="N">Exclude</option>
	                        </select>in Sheet
	                    </td>
	                </tr>
				</tbody>
			</table>
			
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<div class="opus_design_grid"  id="mainTable">
			<h3 class="title_design" id="titleLayer">Customized Title</h3>
			<div class="opus_design_btn"> 
				<button class="btn_normal" type="button"  name="btn2_rowadd02" id="btn2_rowadd02">Row Add</button>
				<button class="btn_normal" type="button"  name="btn2_rowdel02" id="btn2_rowdel02">Row Delete</button>
			</div>
			 <script type="text/javascript">ComSheetObject('sheet2');</script>
		<!-- opus_design_grid(E) -->
		</div>
   </div>
	
</form>