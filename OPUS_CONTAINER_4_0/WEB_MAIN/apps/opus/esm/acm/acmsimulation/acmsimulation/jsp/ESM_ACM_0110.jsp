<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0110.jsp
*@FileTitle  : Simulation No. Search 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0110Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0110Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수
  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";
  String strUsr_id = "";
  String strUsr_nm = "";
  String f_sim_flg = JSPUtil.getParameter(request, "sim_flg");  
  Logger log = Logger.getLogger("com.clt.apps.ACMSimulation.ACMSimulation");
  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0110Event)request.getAttribute("Event");
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="usr_id" name="usr_id" value="<%=strUsr_id%>" type="hidden" />
<input id="agn_agmt_no" name="agn_agmt_no" type="hidden" />
<input id="opnr_agn_cd" name="opnr_agn_cd" value="<%=strUsr_id%>" type="hidden" />
<input id="delt_flg" name="delt_flg" value="Y" type="hidden" />
<input type="hidden" name="sim_flg" value="<%=f_sim_flg%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Simulation No. Search</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_retrieve" name="btn_retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_select" name="btn_select" class="btn_normal">Select</button><!--
		--><button type="button" id="btn_close" name="btn_close" class="btn_normal">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
				<%
	               if(f_sim_flg.equals("S")){
	             %>
					<col width="100px"/>
					<col width="100px"/>
					<col width="50px"/>
					<col width="*"/>
				 <%
	               } else {
	             %>	
					<col width="25px"/>
					<col width="*"/>
				 <%
	               }
	             %>	
				</colgroup>
           		<tr class="h23">
	            <%
	               if(f_sim_flg.equals("S")){
	             %>
	             <th>Simulation Office</th>
	             <td><select name="sim_usr_ofc_cd" id="sim_usr_ofc_cd" required caption="Office" class="input1" style="width:95px;" tabindex="2"></select></td>
	             <%
	               }
	             %>
	             <th>Date</th>
	             <td>
	               	<input id="date_fm" name="date_fm" dataformat="ymd" maxlength="8" required="required" caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="5" type="text" />~ <input id="date_to" name="date_to" dataformat="ymd" maxlength="8" required="required" caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="6" type="text" />
	               	<button class="calendar ir" name="btn_calendar" id="btn_calendar" type="button"></button>
	             </td>             
	           	</tr>
	    	</tbody>
        </table>
      
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">		
		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
</div>	
</form>