<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0101.jsp
*@FileTitle  : Agreement Copy From
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.event.EsmAcm0101Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0101Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMAgreementSC.AGNCommAgreement");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0101Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업 -->


<input type="hidden" name="agn_agmt_no" id="agn_agmt_no" />
<input type="hidden" name="opnr_agn_cd" value="<%=JSPUtil.getParameter(request, "agn_cd")%>" id="opnr_agn_cd" />
<input type="hidden" name="delt_flg" value="Y" id="delt_flg" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Agreement Copy From</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_select" id="btn_select" type="button">Select</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th><input name="opt" id="radio0" type="radio" class="trans" checked>&nbsp;<lable for="radio0">Direct input</lable>&nbsp;&nbsp;<input name="dir_agmt_no" id="dir_agmt_no" type="text" dataformat="engup" minlength="9" maxlength="9" required caption="Direct input" class="input1" style="width:100px;"><th>
		   			<td></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			 <td><input name="opt" id="radio1" type="radio" class="trans" >&nbsp;<lable for="radio1">Agreement Search</lable></td>
		   			 <td></td>
		   		</tr>
		    </tbody>
		</table>
		<table>
			<colgroup>
				<col width="30" />				
				<col width="70" />				
				<col width="60" />				
				<col width="80" />				
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
                     <th>RHQ</th>
                     <td><select name="rhq_cd_disp" id="rhq_cd_disp" required caption="RHQ" class="input1" style="width:80px; display:none;" tabindex="1" onchange="frmObj_OnChange();"></select><input name="rhq_cd" id="rhq_cd" type="text" class="input2" style="width:80px; text-align:center;" tabindex="1" readOnly></td>
                     <th>Office</th>
                     <td><select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:80px;" tabindex="2" onchange="frmObj_OnChange();"></select></td>
                     <th>Sub Office</th>
                     <td><select name="agn_cd" id="agn_cd" required caption="Sub Office" class="input1" style="width:80px;" tabindex="3" onchange="frmObj_OnChange();"></select></td>
                </tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button>
		</div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

<!-- 개발자 작업 끝 -->
</form>
