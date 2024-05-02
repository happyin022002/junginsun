<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0034.jsp
*@FileTitle  :  CSR Inquiry
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
<%@ page import="com.clt.apps.opus.esm.acm.acmreport.acmreport.event.EsmAcm0034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0034Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMReport.ACMReport");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0034Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>
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
<!-- 개발자 작업 -->


<input type="hidden" name="ofc_cd" id="ofc_cd" value="<%=strOfc_cd%>"><!-- 로그인 한 사용자의 ofc_cd -->
<input type="hidden" name="csr_no" id="csr_no"><!-- Multi CSR No. -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_detail" id="btn_detail">CSR Detail</button>
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
	<h3 style="margin-bottom:0" class="title_design">Target Search Condition</h3>
	<div class= "opus_design_inquiry wFit">
		<table>
	   		<colgroup>
	   			<col width="60" />
	   			<col width="200" />
	   			<col width="200" />
	   			<col width="80" />
	   			<col width="100" />
	   			<col width="80" />
	   			<col width="*" />
	   		</colgroup>
			<tbody>
				<tr>
					<th>Date</th>
					<td>
      					<input type="radio" name="date_div" id="radio_snc_sc1" class="trans" value="C" checked><!-- 
	                  --><label for="radio_snc_sc1">Creation</label><!-- 
	                  --><input type="radio" name="date_div" id="radio_snc_sc2" class="trans" value="A"><!-- 
	                  --><label for="radio_snc_sc2">Approval</label><!-- 
	                  --><input type="radio" name="date_div" id="radio_snc_sc3" class="trans" value="G"><!-- 
	                  --><label for="radio_snc_sc3">G/L</label>
      				</td>
					<td>
      					<input name="date_fm" id="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="5"><!--
      					--><span class="dash">~</span><!--
      					--><input name="date_to" id="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="6"><!--
      					--><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button>
      				</td>	      				
	      			<th>Office</th>
					<td><select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:100px;" tabindex="1"></select></td>
					<th>Sub Office</th>
					<td id="div_sbOfcCd"><select name="agn_cd" id="agn_cd" required caption="Sub Office" class="input1" style="width:100px;" tabindex="2"></select></td>
				</tr>
      		</tbody>	      		
		</table>  
		<table>
			<colgroup>
				<col width="60" />
	   			<col width="200" />
	   			<col width="200" />
	   			<col width="80" />
	   			<col width="100" />
	   			<col width="80" />
	   			<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>CSR No</th>
					<td id="memo_sheet1_td">
						<div id="memo_sheet1_div">
                              	<script type="text/javascript">ComSheetObject("memo_sheet1");</script>
                        </div>
					</td>
					<td><button type="button" class="btn_etc" name="btn2_csr_no" id="btn2_csr_no" >Multi CSR No.</button></td>
					<th>R.VVD</th>
					<td><input type="text" name="rev_vvd_cd" id="rev_vvd_cd" style="width: 100px; ime-mode: disabled;" maxlength="10" dataformat="engup"></td>
					<th>Status</th>
					<td><select style="width: 100px;" name="sts_cd" id="sts_cd" >
						<option value="1" selected>Created</option>
						<option value="2">Approved</option>
						<option value="3">Paid</option>
						<option value="4">I/F Error</option></select>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid clear"  >
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

	<!-- layout_wrap(S) -->
	<div class="layout_wrap" style="width: 40%">
	    <div class="layout_vertical_2"  style="width: 40%">
		    <table>
		    	 <tr>
				    <th>USD Total</th>
				    <td><input type="text" name="usd_total" id="usd_total" style="width:150px; height:20px; text-align:right;" class="input2" readOnly></td>
				</tr>
			</table>
	    </div>
	     <div class="layout_vertical_2" style="width: 5%">
		    <table>
		    	 <tr>
				    <th>&nbsp;</th>
				</tr>
			</table>
	    </div>
	   	<div class="layout_vertical_2" style="width: 50%">
	     	<div class="opus_design_grid clear"  >
				<script type="text/javascript">ComSheetObject('sheet2');</script>
	   		</div>
		</div>
	</div>
</div>
</form>