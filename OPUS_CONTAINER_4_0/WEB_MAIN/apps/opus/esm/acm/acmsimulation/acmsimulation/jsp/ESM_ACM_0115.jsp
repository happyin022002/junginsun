<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0115.jsp
*@FileTitle  : Simulation Agreement Copy From
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0115Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0115Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMSimulation.ACMSimulation");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0115Event)request.getAttribute("Event");
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
	<h2 class="page_title"><span>Simulation Agreement Copy From</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_select" id="btn_select" type="button">Select</button><!--
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
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
<table>
	<tbody>
		<colgroup>
			<col width="100" />
			<col width="*" />
		</colgroup>
		<tr>
			<td><input name="opt" type="radio" class="trans" checked id="opt" /><label for = "opt">Direct input</label></td>
       		<td><input name="dir_agmt_no" type="text" dataformat="engup" minlength="9" maxlength="9" required="" caption="Direct input" class="input1" style="width:100px;" id="dir_agmt_no" /></td>
		</tr>
	</tbody>
</table>
<table>
	<colgroup>
		<col width="50" />
		<col width="100" />
		<col width="100" />
		<col width="*" />
	</colgroup>
		<tbody>
			<tr>
				<td><input name="opt" type="radio" class="trans" id="opt1" /><label for = "opt1">Agreement Search</label></td>
           </tr>
          </tbody>
	</table>
 	<table>
		<colgroup>
		<col width="30" />
		<col width="100" />
		<col width="100" />
		<col width="100" />
		<col width="100" />
		<col width="*" />
		</colgroup>
		<tbody>
		<tr>
              <th>RHQ</th>
              <td><select name="rhq_cd_disp" onchange="frmObj_OnChange()" required caption="RHQ" class="input1" style="width:80; display:none;" tabindex="1"></select><input name="rhq_cd" type="text" class="input2" style="width:80; text-align:center;" tabindex="1" readOnly></td>
              <th>Office</th>
              <td><select name="ar_ofc_cd" onchange="frmObj_OnChange()" required caption="Office" class="input1" style="width:80px;" tabindex="2"></select></td>
              <th>Sub Office</th>
              <td><select name="agn_cd" onchange="frmObj_OnChange()" required caption="Sub Office" class="input1" style="width:80px;" tabindex="3"></select></td>
            </tr>
		</tbody>
</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
