<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0009.jsp
*@FileTitle  : Agent Commission CSR Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.event.EsmAcm0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0009Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  String vendor = "";
  String aproStep = "";
  String inv_sub_sys_cd = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMApproval.AGNCommApproval");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0009Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  aproStep =  com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(strOfc_cd,"AGT");
  inv_sub_sys_cd		= JSPUtil.getParameter(request, "inv_sub_sys_cd".trim(), "");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>

<script type="text/javascript" src="rpt/script/common_rd.js"></script>
<script type="text/javascript">
  // 공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("ofcChr", "", "CD03015", 0, "")%>
<%=JSPUtil.getIBCodeCombo("effDiv", "", "CD03014", 0, "")%>
<%=JSPUtil.getIBCodeCombo("xchRtDivLvl", "", "CD03020", 0, "")%>
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
<!-- 개발자 작업 -->

<input name="ofc_cd" id="ofc_cd" type="hidden" value="<%=strOfc_cd%>"><!-- 로그인 한 사용자의 ofc_cd -->
<input name="aud_no" type="hidden" id="aud_no" />
<input name="csr_no" type="hidden" id="csr_no" />
<input name="vvd_cd" type="hidden" id="vvd_cd" />
<input name="bl_no" type="hidden" id="bl_no" />
<input type="hidden" name="h_csr_no" id="h_csr_no" />
<input type="hidden" name="aproSeqKey" id="aproSeqKey" value="<%=com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(strOfc_cd, inv_sub_sys_cd) %>">


<!-- page_title_area(S) -->
<div class="page_title_area">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		 --><button type="button" class="btn_normal" name="btn_approval_request" id="btn_approval_request">Approval Request</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_audit_reject" id="btn_audit_reject">Audit Reject</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_print" id="btn_print">CSR Print</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->


<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90"/>
				<col width="100"/>
				<col width="80"/>
				<col width="100"/>
				<col width="141"/>
				<col width=250"/>
				<col width="60"/>
				<col width="*" />
			</colgroup>
			<tbody>
               <tr>
                 <th>Office</th>
                 <td><select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:120px;" tabindex="1"></select></td>
                 <th>Sub Office</th>
                 <td><select name="agn_cd" id="agn_cd" required caption="Sub Office" class="input1" style="width: 120px;" tabindex="2"></select></td>
                 <th>Commission Status&nbsp;</th>
                 <td width="300"><%=JSPUtil.getCodeCombo("ac_sts_cd", "", "tabindex='3' style='width:125px;'", "CD03088", 0, "")%></td>
                 <th>Date</th>
                  <td><!-- 
                  --><input name="date_div_disp" type="text" class="input2" style="width:100px;" readonly="" id="date_div_disp" /><!-- 
                  --><input name="date_fm" type="text" dataformat="ymd" maxlength="8" required="" caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="5" id="date_fm" /><!--
                  --><span class="dash">~</span><!--  
                  --><input name="date_to" type="text" dataformat="ymd" maxlength="8" required="" caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="6" id="date_to" /><!-- 
                  --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button>
                 </td>
              </tr>
         </tbody>
	</table>
	<table>
		<colgroup>
			<col width="90" />
			<col width="335" />
			<col width="140" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
           		<th>Invoice Date</th>
             	<td><input type="text" class="input1" style="width:85px;" maxlength="10" dataformat="ymd" onbeforedeactivate="ComAddSeparator(this)" onbeforeactivate="ComClearSeparator(this)" name="inv_dt" id="inv_dt" /><button type="button" id="btn_inv_dt" name="btn_inv_dt" class="calendar ir"></button></td>
	 		 	<th>ASA No</th>
		 	 	<td><select name="asa_no" id="asa_no" style="width: 300px;" tabindex="2"></select></td>
		  	</tr>
		</tbody>
	</table>
	<table>
		<colgroup>
			<col width="90" />
			<col width="335" />
			<col width="140" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
                <th>VAT(%)</th>
                <td><input type="text" style="width:80px;text-align:right" maxlength="8" name="inv_tax_rt" value="0.00" onfocus="invTaxRt_onfocus(this)" onblur="invTaxRt_validate(this)" id="inv_tax_rt" />
                </td>
                <th>Vendor</th>
                <td width="313"><input type="text" class="input2" style="width:300px;" name="vendor_name" disabled id="vendor_name" /></td>
             	<th>Check</th>
                <td> 
                <input name="slct_start" type="text" dataformat="num" maxlength="5" style="width:41px;" tabindex="9"  id="slct_start" />~&nbsp; 
                <input name="slct_end"   type="text" dataformat="num" maxlength="5" style="width:41px;" tabindex="10" id="slct_end" /> 
                <button type="button" class="btn_etc" name="btn2_check" id="btn2_check" >Check</button>
                <button type="button" class="btn_etc" name="btn2_uncheck" id="btn2_uncheck" >Uncheck</button></td>
             </tr>
		</tbody>
	</table>
</div>
<div class= "opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="90"/>
			<col width="*" />
		</colgroup>
		<tbody>
            <tr style= "display:none">
                <th>Approval Step</th>
                <td><!--
                --><input name="apro_step" type="text" class="input1" size="65" style="width:440px;" value="<%= aproStep %>" disabled id="apro_step" /><!--
                --><button type="button" class="btn_etc" name="btn_clear" id="btn_clear" >Clear</button><!--
                --><button type="button" class="btn_etc" name="btn_popup" id="btn_popup" >Edit Approval Staff</button><!--
                --></td>
			</tr>
		</tbody>
	</table>
	</div>
</div>                       
<div class="wrap_result">
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<h3 class="title_design">Master</h3>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btng_downexcel1" id="btng_downexcel1">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_grid">
		<h3 style="margin-bottom:0" class="title_design">Detail</h3>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btng_downexcel2" id="btng_downexcel2">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	
	<div class="opus_design_grid" style="display: none;">
		<h3 style="margin-bottom:0" class="title_design">Detail</h3>
		<div class="opus_design_btn">
	 		<button type="button" class="btn_normal" name="btng_downexcel2" id="btng_downexcel2">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
   
</form>

<!-- PRINT (S)tart -->
<div style="display:none">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<h3 style="margin-bottom:0" class="title_design">Detail</h3>
			<button type="button" class="btn_normal" name="btng_downexcel2" id="btng_downexcel2">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>   
</div>   
 