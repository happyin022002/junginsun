
<%@page import="com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event.StmSar5002Event"%>
<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_5002.jsp
*@FileTitle  : Agent Statement of Account Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
    StmSar5002Event event = null;               //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;           //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    
    String strUsr_id = "";
    String strUsr_nm = "";
    String strUsr_ofc_cd = "";
    String strUsr_ofc_tp_cd = "";
    Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivableoutstanding.AccountReceivableOutstandingSC");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_ofc_cd = account.getOfc_cd();
        strUsr_ofc_tp_cd = account.getOfc_tp_cd();
       
        event = (StmSar5002Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
                
    } catch(Exception ex) {
        log.error("err " + ex.toString(), ex);
    }
    
%>


<script type="text/javascript">

    var strUsr_id = "<%=strUsr_id%>";
    var strUsr_nm = "<%=strUsr_nm%>";
    var strUsr_ofc_cd = "<%=strUsr_ofc_cd%>";

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
<input type="hidden" name="agn_cd" id="agn_cd" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="asa_no" id="asa_no" />
<input type="hidden" name="backendjob_key">
<input type="hidden" name="login_user_ofc_tp_cd" id="login_user_ofc_tp_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_find" id="btn_find">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New ASA</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_creation" id="btn_creation">ASA Creation</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_finish" id="btn_finish">Finish</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_reopen" id="btn_reopen">Reopen</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_approve" id="btn_approve">Approve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_view_accounting" id="btn_view_accounting">View Accounting</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="60"/>
			<col width="200"/>
			<col width="300"/>
			<col width="*" />
		</colgroup>
		<tbody>
		 	<tr>
	            <th>ASA No.</th>
	    		<td><input type="text" name="asa_no_ctnt1" style="width:40px;text-align: center;" class="input2" readonly="readonly" id="asa_no_ctnt1" />- <input type="text" name="asa_no_ctnt2" maxlength="3" style="width:40px;text-align: center;" class="input1" dataformat="num" id="asa_no_ctnt2" /><input type="text" name="asa_no_ctnt3" maxlength="4" style="width:40px;text-align: center;" class="input1" dataformat="num" id="asa_no_ctnt3" /></td>
	            <th>Agent Code</th>
	            <td><script type="text/javascript">ComComboObject('combo1', 1, 80, 1, 0, 0, true);</script></td>
           </tr>
		   <tr>
	            <th>Period From</th>
	            <td><input type="text" name="asa_prd_fm_dt" style="width:100px;text-align: center" class="input2" readonly="readonly" dataformat="ymd" id="asa_prd_fm_dt" /><!-- 
	                --><button type="button" id="btn_asa_prd_fm_dt" name="btn_asa_prd_fm_dt" class="calendar ir"></button><b>~ TO</b>&nbsp;<input type="text" name="asa_prd_to_dt" maxlength="8" style="width:100px;text-align: center;" readonly="readonly" class="input2" dataformat="ymd" id="asa_prd_to_dt" /><!-- 
	                --><button type="button" id="btn_asa_prd_to_dt" name="btn_asa_prd_to_dt" class="calendar ir"></button></td>
	           <th>ASA Currency</th>
	  		   <td><input type="text" name="curr_cd" id="curr_cd" style="width:79px;" class="input2" readonly="readonly"/></td>
           </tr>
         </tbody>
        </table>
     </div>
 </div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class= "opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="110"/>
			<col width="160"/>
			<col width="150"/>
			<col width="50"/>
			<col width="200"/>
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
                <th>Previous ASA No</th>
                <td><input type="text" name="pre_asa_no" readonly="readonly" style="width:100px;text-align: center;" class="input2" id="pre_asa_no" /> </td>
                <th>Actual Balance For This ASA</th>
                <td><input type="text" name="act_bal_amt" readonly="readonly" style="width:100px;text-align: right;" class="input2" id="act_bal_amt" /> </td>
                <th>Finish Date</th>
                <td><input type="text" name="asa_fsh_dt" readonly="readonly" style="width:140px;" class="input2" id="asa_fsh_dt" /> </td>
			</tr>
			<tr>
                <th>Prepared By</th>
                <td><input type="text" name="asa_fsh_usr_id" readonly="readonly" style="width:100px;" class="input2" id="asa_fsh_usr_id" /> </td>
                <th>Approval By</th>
                <td><input type="text" name="asa_apro_usr_id" readonly="readonly" style="width:150px;" class="input2" id="asa_apro_usr_id" /> </td>
                <th>RHQ Approve Date</th>
                <td><input type="text" name="asa_apro_dt" readonly="readonly" style="width:140px;" class="input2" id="asa_apro_dt" /> </td>
			</tr>
       </tbody>
     </table>
  </div>
 </div>
 </form>