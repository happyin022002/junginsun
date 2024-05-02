<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0030.jsp
*@FileTitle  : FF Compensation CSR Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.event.EsmAcm0030Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0030Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  String aproStep = "";
  String inv_sub_sys_cd = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMRequest.AGNCommRequest");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0030Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
  aproStep =  com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(strOfc_cd,"AGT");
  inv_sub_sys_cd		= JSPUtil.getParameter(request, "inv_sub_sys_cd			".trim(), "");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="rpt/script/common_rd.js"></script>

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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="hid_ff_cnt_seq" id="hid_ff_cnt_seq" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />
<input type="hidden" name="ap_ofc_cd" id="ap_ofc_cd" />
<input type="hidden" name="csr_no" id="csr_no" />

<!-- 개발자 작업 -->


<input type="hidden" name="ofc_cd"  id="ofc_cd" value="<%=strOfc_cd%>"/>
<input type="hidden" name="bl_no" id="bl_no" />
<input type="hidden" name="aproSeqKey" id="aproSeqKey" value="<%=com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(strOfc_cd, inv_sub_sys_cd) %>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_approval" id="btn_approval">Approval Request</button><!-- 
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
		--><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!-- 
		--><button type="button" class="btn_normal" name="btn_csr_print" id="btn_csr_print">CSR Print</button><!--		  
	 --></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- opus_design_inquiry(S) -->

<div class= "wrap_search">
 	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100"/>
				<col width="150"/>
				<col width="150"/>
				<col width="300"/>
				<col width="120"/>
				<col width="*" />
			</colgroup>
			<tr>
	    	    <th>Office</th>
	    	    <td><script type="text/javascript">ComComboObject('f_ap_ofc_cd',1, 100 , 0 )</script></td>			
				<th>Interface Status</th>
			    <td><%=JSPUtil.getCodeCombo("if_opt", "", "tabindex='1' style='width:90px;'", "CD03071", 0, "")%></td>
			    <th>Date</th>
			    <td><%=JSPUtil.getCodeCombo("date_div", "", "tabindex='4' style='width:105px;'", "CD03094", 0, "")%><input name="date_fm" id="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width: 70px;" tabindex="5">~ <input name="date_to" id="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width: 70px;" tabindex="6"><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button></td>
			</tr>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="200"/>
					<col width="100"/>
					<col width="200"/>
					<col width="100"/>
					<col width="120"/>
					<col width="*" />
				</colgroup>
				<tr>
			        <th>F/Forwarder</th>
			        <td><input type="text" name="ff_cnt_seq" id="ff_cnt_seq" dataformat="engup" style="width: 79px; ime-mode: disabled;" maxlength="8"><button type="button" name="btn_forwarder" id="btn_forwarder" class="input_seach_btn" onClick="openPopup('cust_cd')"></button></td>
			      	<th>B/L No</th>
			       	<td id="memo_sheet1_td"><div id="memo_sheet1_div"><script type="text/javascript">ComSheetObject("memo_sheet1");</script></div></td>
			       	<td><button type="button" class="btn_etc" name="btn2_bl_no" id="btn2_bl_no" >Multi B/L No</button></td>
		        	<th>Select</th>
	                <td><input name="slct_start" id="slct_start" type="text" dataformat="int" maxlength="5" style="width: 41px;" tabindex="9">~ <input name="slct_end" id="slct_end" type="text" dataformat="int" maxlength="5" style="width: 41px;" tabindex="10"><button type="button" class="btn_etc" name="btn2_check" id="btn2_check" >Check</button><button type="button" class="btn_etc" name="btn2_uncheck" id="btn2_uncheck" >Uncheck</button></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="200"/>
					<col width="100"/>
					<col width="200"/>
					<col width="114"/>
					<col width="*"/>
				</colgroup>
				<tr>
			        <th>AP Office</th>
			        <td><select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:75px;" tabindex="1"></select></td>
					<th>ASA No</th>
			 	 	<td><select name="asa_no" id="asa_no" style="width: 300px;" tabindex="2"></select></td>
			 		<th>Invoice Date</th>
                	<td><input type="text" class="input1" style="width: 85px" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" name="inv_dt" id="inv_dt"><button type="button" class="calendar ir" name="btn_inv_dt" id="btn_inv_dt"></button></td>
			 	 	<td></td>
				</tr>
			</tbody>
		</table>
		<table style= "display:none">
			<colgroup>
				<col width="100"/>
				<col width="*" />
			</colgroup>
			<tr>
	            <th>Approval Step</th>
	            <td><input name="apro_step" id="apro_step" type="text" class="input1" size="65" style="width: 440px;" value="<%= aproStep %>" disabled><button type="button" class="btn_etc" name="btn_clear" id="btn_clear" >Clear</button><button type="button" class="btn_etc" name="btn_popup" id="btn_popup" >Edit Approval Staff</button></td>
         	</tr>	
		</table>
	</div>
</div>

<div class="wrap_result">

	<div class="opus_design_grid clear"  >
		<h3 style="margin-bottom:0" class="title_design mar_btm_8">Master</h3>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_grid clear"  >
		<h3 style="margin-bottom:0" class="title_design mar_btm_8">Detail</h3>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>

</form>
<DIV style="display: none">
	<div class="opus_design_grid clear"  >
		<script type="text/javascript">ComSheetObject('sheet3');</script>
		<script type="text/javascript">ComSheetObject('sheet4');</script>
		<script type="text/javascript">ComSheetObject('sheet5');</script>
		<script type="text/javascript">ComSheetObject('sheet6');</script>
	</div>
</DIV>
