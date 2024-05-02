<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7006.jsp
*@FileTitle  : Fax/E-mail Sending History 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt7006Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EesDmt7006Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    String strUsr_lc        = "";
    String jspno = "";
    String invoice = "";
    String selectOpt = "";
    String payerCd = "";
    String selectType = "";
    Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");
    
    String bodyProp = "";
	String tableProp = "";
	String tdProp = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strUsr_lc = account.getCnt_cd();

        jspno      = JSPUtil.getParameter( request , "jspno"      , "EES_DMT_7006" );
        invoice    = JSPUtil.getParameter( request , "invoice"    , ""             );
        selectOpt  = JSPUtil.getParameter( request , "selectOpt"  , "1"            );
        payerCd    = JSPUtil.getParameter( request , "payerCd"    , ""             );
        selectType = JSPUtil.getParameter( request , "selectType" , ""             );
        
        
        if (jspno.equals("EES_DMT_7006")) {
    		//in case of Main
    		tableProp 	= "cellpadding='0' cellspacing='0' style='padding-top:2;padding-left:5;'";
    		tdProp		= "btn1_bg";
    	}
    	else {
    		//in case of PopUp
    		bodyProp	= "class='popup_bg'";
    		tableProp	= "class='popup' cellpadding='5'";
    		tdProp		= "btn3_bg";
    	}

        event = (EesDmt7006Event)request.getAttribute("Event");
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
<input type="hidden" name="pagerows">
<input type="hidden" name="sndoffc">
<input type="hidden" name="h_user_office"  value="<%= strUsr_of %>"  >
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_of %>">
<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd">
<input type="hidden" name="sndrnmm">
<input type="hidden" name="tempuser">
<input type="hidden" name="seloptt">

<input type="hidden" name="h_jspno"      value= "<%= jspno      %>">
<input type="hidden" name="h_invoice"    value= "<%= invoice    %>">
<input type="hidden" name="h_selectOpt"  value= "<%= selectOpt  %>">
<input type="hidden" name="h_payerCd"    value= "<%= payerCd    %>">
<input type="hidden" name="h_selectType" value= "<%= selectType %>">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <% if (!jspno.equals("EES_DMT_7006")) { %> 
    <h2 class="page_title"><span>Fax/E-mail Sending History</span></h2>
    <% }else{ %>
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<% } %>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--  
		--><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button><!--  
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
		<% if (!jspno.equals("EES_DMT_7006")) { %> 
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!-- 
		<% } %>-->
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	 <% if (jspno.equals("EES_DMT_7006")) { %> 
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<% } %>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit" id="sch_cond_div" style=display:block;>
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table class="search">
	    	<colgroup>
	            <col width="120" />
	            <col width="80" />
	            <col width="100" />
	            <col width="98" />
	            <col width="130" />
	            <col width="68" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
	                <th style="text-align:left"><input type="radio" value="0" class="trans" name="selectOpt" id="selectOpt1" checked onclick="obj_click();"><label for="selectOpt1">Date</label></th>
	                <td class="stm">Sent Date</td>
	                <td class="stm"><!-- 
	                    --><input type="text" name="sndfrdt" id="sndfrdt" dataformat="ymd" style="width:80px" class="input1" onblur="obj_blur()" onfocus="obj_focus()">~&nbsp;<!-- 
	                    --><input type="text" name="sndtodt" id="sndtodt" dataformat="ymd" style="width:80px" class="input1" cofield="sndfrdt" onblur="obj_blur()" onfocus="obj_focus()"><!-- 
	                    --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button><!-- 
	                --></td>
	                <td class="stm" style="text-align:right">Sent Office</td>
	                <td><script type="text/javascript">ComComboObject('office',1,80,0,1,0,true);</script><button type="button"  class="multiple_inq ir" name="btns_sntoff" id="btns_sntoff"></button><!-- 
	                --></td> 
	                <td style="text-align:right">Sender ID</td>
	                <td><!-- 
	                    --><input type="text" style="width:100px;" value="" class="input" name="sndrcdd"><!-- 
	                    --><button type="button" class="input_seach_btn" name="btns_sender_cd" id="btns_sender_cd"></button><!-- 
	                --></td>
	            </tr>
	       </tbody>
		</table>
	    <table class="search">
	    	<colgroup>
	            <col width="120" />
	            <col width="80" />
	            <col width="100" />
	            <col width="70" />
	            <col width="130" />
	            <col width="68" />
	            <col width="" />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th style="text-align:left"><input type="radio" value="1" class="trans" name="selectOpt" id="selectOpt2" onclick="obj_click();"><label for="selectOpt2">Invoice</label></th>
	                <td class="stm">Invoice No.</td>
	                <td colspan="5"><!-- 
	                    --><input type="text" style="width:388px;" dataformat="engup" value="" class="input2" name="invoice" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" readOnly><!-- 
	                    --><button type="button"  class="multiple_inq ir" name="btns_inv_no" id="btns_inv_no"></button><!-- 
	                --></td>
	         </tr>
	     	</tbody>
	     </table>
	     <table>
	    	<colgroup>
	            <col width="120" />
	            <col width="80" />
	            <col width="70" />
	            <col width="87" />
	            <col width="68" />
	            <col width="*" />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th style="text-align:left"><input type="radio" value="2" class="trans" name="selectOpt" id="selectOpt3" onclick="obj_click();"><label for="selectOpt3">Demand / OTS</label></th>
	                <td>Payer</td>
	              	<td><input type="text" name="payercd" id="payercd" style="width:80px;" dataformat="engup" class="input2" caption="Payer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" onblur="obj_blur2()" readOnly><!-- 
	              		--><button type="button" class="input_seach_btn" name="btns_payer_cd" id="btns_payer_cd"></button><!-- 
	              		--><input type="text" name="payernm" style="width:303px;" class="input2" readOnly><!--
	              	--></td>
	      			<td style="text-align:right">Sheet Type</td>
	                <td >
	                  <select style="width:100px;" name="shttppp">
	                      <option value="A" selected></option>
	                      <option value="D">Demand Note</option>
	                      <option value="G">Group Demand</option>
	                      <option value="O">OTS Invoice</option>
	                  </select>
	                </td>			
	                <td></td>                                       
				</tr>
			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->

</form>