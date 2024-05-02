<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0026.jsp
*@FileTitle  : Revenue Structure Setting
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
<%@ page import="com.clt.apps.opus.esm.acm.acmsetup.acmsetup.event.EsmAcm0026Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0026Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMSetup.ACMSetup");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0026Event)request.getAttribute("Event");
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
// 공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("effDiv", "", "CD03014", 0, "")%>


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
<input type="hidden" name="rhq_cd" id="rhq_cd" />
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
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		  <table style = "display: none">
		   		<tr>	<td>
                        <input type="text" name="txtDate" id="txtDate" value="2014-01-01">
                        <input type="text" name="txtDate2" id="txtDate2" value="2014-12-01">
                        <input type="button" value="달력" onclick="cal=new ComCalendar(); cal.select(txtDate, 'yyyy-MM-dd');" >
                        <input type="button" value="년" onclick="cal=new ComCalendar(); cal.setDisplayType('year'); cal.select(txtDate, 'yyyy-MM-dd');" >
                        <input type="button" value="월" onclick="cal=new ComCalendar(); cal.setDisplayType('month'); cal.select(txtDate, 'yyyy-MM-dd');" >
                        <input type="button" value="분기" onclick="cal=new ComCalendar(); cal.setDisplayType('quarter'); cal.select(txtDate, 'yyyy-MM-dd');" >
                        <input type="button" value="FromTo" onclick="cal=new ComCalendarFromTo(); cal.select(txtDate, txtDate2,'yyyy-MM-dd');" >
          			</td>
          		</tr>
           </table>
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
<div class="wrap_result">
<div class="opus_design_grid clear"  >
<div class="opus_design_btn">
		  <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
		  <button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
</form>
