<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0013.jsp
*@FileTitle  : Returned CSR Reprocess 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.event.EsmAcm0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0013Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMApproval.AGNCommApproval");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0013Event)request.getAttribute("Event");
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
<input type="hidden" name="csr_no_master" id="csr_no_master"><!-- master sheet에서 선택한 csr no. -->
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
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Reprocess to Audit Confirm</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">CSR Cancel</button>
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
		<tbody>
			<colgroup>
				<col width="60"/>
				<col width="100"/>
				<col width="70"/>
				<col width="100"/>
				<col width="80"/>
				<col width="100"/>
				<col width="60"/>
				<col width="150"/>
				<col width="*" />
			</colgroup>
			 <tr class="h23">
                <th>Office</th>
                <td><select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:80px;" tabindex="1"></select></td>
                <th>Sub Office</th>
                <td><select name="agn_cd" id="agn_cd" required caption="Sub Office" class="input1" style="width:80px;" tabindex="2"></select></td>
                <th>Approval Date</th>
                <td><!-- 
                   --><input name="date_fm" id="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="3">~&nbsp;<!-- 
                   --><input name="date_to" id="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="4"><!-- 
                   --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
                <th>CSR No.</th>
                <td><input name="csr_no" type="text" dataformat="engup" maxlength="20" style="width:150px;" tabindex="5"></td>
                <td></td>
              </tr>
		</tbody>		
	</table>
</div>
</div>
<div class="wrap_result">
<div class="opus_design_grid"  >
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<div class="opus_design_inquiry"><h3 class="title_design">CSR Detail</h3></div>
<div class="opus_design_grid"  >
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<div class="opus_design_inquiry"><h3 class="title_design">Reprocessed Audit No. Detail</h3></div>
<div class="opus_design_grid"  >
	<script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
</div>
</form>