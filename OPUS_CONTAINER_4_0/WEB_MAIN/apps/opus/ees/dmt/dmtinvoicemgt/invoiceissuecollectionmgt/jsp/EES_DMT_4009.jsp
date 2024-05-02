<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_4009.jsp
*@FileTitle  : OTS Inquiry by Customer & Issue(Outstanding Inquiry by Customer & Issue)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt4009Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    String strRhq_of = "";
    String strUsr_em = "";
    Logger log = Logger.getLogger("com.clt.apps.DMTInvoiceMgt.InvoiceIssueCollectionMgt");
    
    String mailContents =    "<br>"
                            +"Attached to this e-mail is a Demurrage / Detention Statement from NYK Line. <br>" 
                            +"If you have any difficulties or questions pertaining to the statement, <br>"
                            +"please contact our local branch office. <br>"
                            +"<br>"
                            +"NYK Line Co., Ltd <br>" 
                            +"<br>"
                            +"www.nyk.com <br>"  
                            +"<br>";
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
       strRhq_of = account.getRhq_ofc_cd();
       strUsr_em = account.getUsr_eml();
       
        event = (EesDmt4009Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // Retrieving the parameter values ​​for calls to pop-up page ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
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
<input type="hidden" name="isof">
<input type="hidden" name="tftp">
<input type="hidden" name="arif">
<input type="hidden" name="cutp">
<input type="hidden" name="h_user_office" value="<%= strUsr_of %>">
<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd">
<input type="hidden" name="chk_payer">
<input type="hidden" name="chk_payer2">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="usr_trf_tp">

<input type="hidden" name="h_rhq_off" value="<%=strRhq_of%>">

<input type="hidden" name="ofc_cd">

<input type="hidden" name="tftp2">
<input type="hidden" name="invno">
<input type="hidden" name="sheetp">

<!-- E-mail or facsimile transmission before judging sheet set lookup queries presence -->
<input type="hidden" name="issoff" value="<%=strUsr_of%>">
<input type="hidden" name="trftpp">
<input type="hidden" name="shttpp" value="O">

<!-- E-mail or facsimile transmission -->
<input type="hidden" name="rd_fxeml_sys_cd"         > <!-- DMT //-->
<input type="hidden" name="rd_fxeml_file_name"      > <!-- only RD FILE NAME *.mrd //-->
<input type="hidden" name="rd_fxeml_bat_flg"        > <!-- N //-->
<input type="hidden" name="rd_fxeml_title"          > <!-- title //-->
<input type="hidden" name="rd_fxeml_doc_tp"         > <!-- I : Invoice D : Demend G : GroupDemand O : OTS //-->
<input type="hidden" name="rd_fxeml_rd_param"       > <!-- RD REPORT PARAMETER //-->
<input type="hidden" name="rd_fxeml_fax_no"         > <!-- RECIEVER FAX NO ex) NAME:5336  //-->
<input type="hidden" name="rd_fxeml_fax_sndr_id"    > <!-- SENDER ID //-->
<input type="hidden" name="rd_fxeml_eml_sndr_nm"    > <!-- EMAIL SENDER NAME  //-->
<input type="hidden" name="rd_fxeml_eml_sndr_add" value="<%= strUsr_em %>"> <!-- SENDER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_rcvr_add"   > <!-- RECIEVER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_atch_file"  > <!-- ATTACH FILE NAME //-->
<input type="hidden" name="rd_fxeml_eml_templt"     > <!-- C:/sitectx/OPUSCNTR/APP-INF/config/template/mailtemplate/ TEMPLETE FILE mail main content //-->
<input type="hidden" name="rd_fxeml_eml_tmplt_param"> <!-- MAILETEMPLETE PARAM ex) name;mjchang|message;DMT EMAIL SEND TEST //-->
<input type="hidden" name="offcd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="mailctnt" value="<%= mailContents %>">

<input type="hidden" name="paycMail">
<input type="hidden" name="paynMail">
<input type="hidden" name="tarfMail">
<input type="hidden" name="h_usr_off" value="<%=strUsr_of%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->

	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn1_retrieve" id="btn1_retrieve">Retrieve</button><!--
			  --><button type="button" class="btn_normal" name="btn1_new" id="btn1_new">New</button><!-- 
			  --><button type="button" class="btn_normal" name="btn1_detail" id="btn1_detail">Detail</button><!-- 
			  --><button type="button" class="btn_normal" name="btn1_fax_send" id="btn1_fax_send">Fax Send</button><!-- 
			  --><button type="button" class="btn_normal" name="btn1_email_send" id="btn1_email_send">Email Send</button><!-- 
			  --><button type="button" class="btn_normal" name="btn1_excel" id="btn1_excel">Down Excel</button>						
	    </div>
	    <!-- opus_design_btn(E) -->
    
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->

</div>
<!-- page_title_area(E) -->


	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">    
	    	<table class="search"> 
	            <tr><td>               
	                <table class="search" border="0" style="width:979px;"> 
	                    <tr class="h23">
	                        <th width="80px">Issue Office</th>
	                        <td width="310px" class="stm" style="padding-left:2;">
	                            <script type="text/javascript">ComComboObject('combo2',2,80,0,1)</script><!--
	                            --><button type="button" class="multiple_inq"></button><!--                            
	                            --><input type="checkbox" name="chk_sub_ofc" value="Y" class="trans" onClick="doInclSubOfc()"><!--
	                            --><label>Incl. Sub Office</label>
	                        </td>
	                        <th width="70px">Tariff Type </th>
	                        <td width="">
	                            <script type="text/javascript">ComComboObject('combo1', 2, 240, 0, 1)</script><!--
	                            --><button type="button" class="multiple_inq"></button>
	                        </td>
				        <th width="160px" class="stm">
				            Group by&nbsp;
				            <select style="width:100px;" class="input" name="cntrinvno">
					            <option value="0" selected>INV No</option>                
					            <option value="1">CNTR No.</option>
					        </select>
					    </th>                        
	                    </tr>                
	
	                    <tr class="h23">
	                        <th width="80px">Issued Date</th>
	                        <td width="310px">
	                            <input type="text" style="width:80px;" class="input1" value="" name="frdt" required dataformat="ymd" maxlength="8">~&nbsp;<!--
	                            --><input type="text" style="width:80px;" class="input1" value="" name="todt" required dataformat="ymd" maxlength="8"><!--
	                            --><button type="button" class="calendar" name="btns_calendarto"  id="btns_calendarfm"></button>                            
	                        </td>
	                        <th width="70px">A/R I/F</th>
	                        <td width="">
	                            <script type="text/javascript">ComComboObject('combo3',2,240,1,1)</script>
	                            <% if( strRhq_of.equals("NYCNA") || strRhq_of.equals("SINHO") ) { %>                            	
	                            	<button type="button" class="multiple_inq"></button>
	                            <% } %>
	                        </td>
	                        <td></td>
	                    </tr>
	                </table>
	                <!--  biz_1  (E) -->
	                
	                <table class="search" border="0" style="width:979px;"> 
	                    <tr class="h23">
	                        <th width="80px">Payer</th>
	                        <td width="">
	                        <table border="0" cellpadding="0" cellspacing="0">
	                        <tr>
	                        	<td colspan="2">
								<input type="text" name="payc" style="width:80px;" dataformat="engup" class="input" caption="Payer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" ><!--											
								--><button type="button" class="input_seach_btn" name="btns_payer_cd" id="btns_payer_cd"></button><!--
								--><input type="text" name="payn" style="width:433px;" class="input2" readOnly>
								</td>
							</tr>
							</table>                        
	                        </td>
	                    </tr> 
	                </table>
	                
	                <table class="search" border="0" style="width:979px;"> 
	                    <tr class="h23">
	                        <th width="82px">Customer </th>
	                        <td width="490px">
	                        <script type="text/javascript">ComComboObject('combo4', 1, 80 , 1,1)</script><!--
	                        --><button type="button" class="multiple_inq"></button><!--
	                        --><input type="text" name="cuno" style="width:70px;" dataformat="engup" class="input" caption="Customer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" ><!--
	                        --><button type="button" class="input_seach_btn" name="btns_cust_cd" id="btns_cust_cd"></button><!--                        
	                        --><input type="text" name="cude" style="width:240px;" class="input2" readOnly>
	
	                        </td>
	                        <th width="50px">S/C No.</th>
	                        <td width="140px"><input type="text" style="width:100px;;" class="input" value="" name="scno" dataformat="engup" maxlength="9"></td>
	                        <th width="50px">RFA No.</th>
	                        <td width=""><input type="text" style="width:100px;;" class="input" value="" name="rfan" dataformat="engup" maxlength="11"></td>
	                    </tr>
	                </table>
	         </td></tr>
	        </table>
		</div>
	</div>    
  
  	<div class="wrap_result">          
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" >										
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->					
		</div>
		<!-- opus_design_grid(E) -->                                
	</div>           
<!-- opus_design_inquiry(E) -->   

</form>
