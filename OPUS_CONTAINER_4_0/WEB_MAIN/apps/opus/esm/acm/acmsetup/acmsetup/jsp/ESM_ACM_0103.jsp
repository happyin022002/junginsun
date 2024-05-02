<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0103.jsp
*@FileTitle  :  Charge Deduction User Setting
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmsetup.acmsetup.event.EsmAcm0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0003Event event = null;        //PDTO(Data Transfer Object including Parameters)
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
    event = (EsmAcm0003Event)request.getAttribute("Event");
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

<head>
<title>Charge Deduction User Setting</title>


<script type="text/javascript">
  var sFunc = '<%=JSPUtil.getParameter(request, "func")%>';
  var iSheetIdx = '<%=JSPUtil.getParameter(request, "sheetIdx")%>';
  var iRow = '<%=JSPUtil.getParameter(request, "row")%>';
  var iCol = '<%=JSPUtil.getParameter(request, "col")%>';


  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업 -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Charge Deduction Setting</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_clear" id="btn_clear" type="button">Clear</button><!--
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

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
		   <tbody>
		   		<tr>
                <td style="color:#532FC3; font-weight:bold;"><input type="radio" class="trans" name="grp_idv_div" id="grp_idv_div0"><lable for="grp_idv_div0">User Setting</lable></td>
              </tr>
          		
		   </tbody>
		</table>
		<h3 class="title_design mar_top_12 mar_btm_8">User Set List</h3>	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable1">
			
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
		   <tbody>
		   		<tr>
                <td  style="color:#532FC3; font-weight:bold;"><input type="radio" class="trans" name="grp_idv_div" id="grp_idv_div1" check><lable for="grp_idv_div1">Individual Setting</lable></td>
              </tr>
    	   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="308" />				
				<col width="*" />				
		   </colgroup> 
			<tbody>
	              <tr>
	                <td><h3 class="title_design mar_top_12">Selected Rep.Charge</h3></td>
	                <td><h3 class="title_design mar_top_12">Selected Charge Code</h3></td>
	              </tr>
	              <tr>
	                <td><textarea name="slct_rep_chg" id="slct_rep_chg" style="width:300px; height:34px;resize:none;" class="input2" readOnly><%=JSPUtil.getParameter(request, "rep_chg_cd")%></textarea></td>
	                <td><textarea name="slct_charge" id="slct_charge" style="width:428px; height:34px;resize:none;" class="input2" readOnly><%=JSPUtil.getParameter(request, "chg_cd")%></textarea></td>
	              </tr>
	              <tr>
	                <td><h3 class="title_design mar_top_12">Rep.Charge</h3></td>
	                <td><h3 class="title_design mar_top_12">Charge Code</h3></td>
	              </tr>
	           </tbody>   
          </table>
	</div>
	<div class="layout_wrap">
   <!-- layout_flex_fixed(S) -->
   <div class="layout_flex_fixed" style="width:300px;"> <!-- setting : FIXED width(400px) -->
       <!-- opus_design_grid(S) -->
       <div class="opus_design_grid" id="mainTable2">
           <script type="text/javascript">ComSheetObject('sheet2');</script>
       </div>
       <!-- opus_design_grid(E) -->
   </div>
   <!-- layout_flex_fixed(E) -->
   
   <!-- layout_flex_flex(S) -->
   <div class="layout_flex_flex" style="padding-left:308px"> <!-- (fixed Width) + (padding 8px) = 408 -->
      <!-- opus_design_grid(S) -->
       <div class="opus_design_grid" id="mainTable3">
           <script type="text/javascript">ComSheetObject('sheet3');</script>
       </div>
       <!-- opus_design_grid(E) -->
   </div>
   <!-- layout_flex_flex(E) -->
   </div>
   
</div>

</form>

