<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0022.jsp
*@FileTitle  : Customer-Vendor Match for Special Compensation
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
<%@ page import="com.clt.apps.opus.esm.acm.acmmaster.acmcustomerinfo.event.EsmAcm0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0022Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMMaster.ACMCustomerInfo");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0022Event)request.getAttribute("Event");
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
		<button type="button" class="btn_accent" name="btn_retrive" id="btn_retrive">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="100"/>
				<col width="*" />
			</colgroup>
			   <tr>
                <th>AGMT Customer</th>
                 <td> <input name="cust_cnt_seq" id="cust_cnt_seq" type="text" dataformat="engup" maxlength="8" style="width:100px;text-align:center;"><!-- 
                  --><button type="button" name="btn_cust_popup" id="btn_cust_popup" class="input_seach_btn" onClick="openPopup('cust_cd')"></button>
                </td>
              </tr>	
		</tbody>		
	</table>
</div>
</div>
<div class="wrap_result">
<div class="opus_design_grid clear"  >
<div class="opus_design_btn">
		  <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
</form>