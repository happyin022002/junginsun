<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0113.jsp
*@FileTitle  : Location Selection
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
<%@ page import="com.clt.apps.opus.esm.acm.acmcommon.acmcommon.event.EsmAcm0113Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
  EsmAcm0113Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";

  Logger log = Logger.getLogger("com.clt.apps.ACMCommon.ACMCommon");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0113Event)request.getAttribute("Event");
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업 -->


<!-- ESM_ACM_0001에서 넘어온 파라미터 -->
<input type="hidden" name="agn_cd" value="<%=JSPUtil.getParameter(request, "agnCd")%>" id="agn_cd" />
<input type="hidden" name="agn_agmt_no" value="<%=JSPUtil.getParameter(request, "agnAgmtNo")%>" id="agn_agmt_no" />
<input type="hidden" name="io_bnd_cd" value="<%=JSPUtil.getParameter(request, "ioBndCd")%>" id="io_bnd_cd" />
<input type="hidden" name="ac_tp_cd" value="<%=JSPUtil.getParameter(request, "acTpCd")%>" id="ac_tp_cd" />
<input type="hidden" name="agn_agmt_seq" value="<%=JSPUtil.getParameter(request, "agnAgmtSeq")%>" id="agn_agmt_seq" />
<input type="hidden" name="rout_ref_div_cd" value="<%=JSPUtil.getParameter(request, "routRefDivCd")%>" id="rout_ref_div_cd" />

<input type="hidden" name="conti_cd" id="conti_cd" />
<input type="hidden" name="sconti_cd" id="sconti_cd" />
<input type="hidden" name="cnt_cd" id="cnt_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Location Selection</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_ok" id="btn_ok" type="button">Select</button><!--
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

<div class="wrap_result">
	 <!-- layout_wrap(S) -->
	<div class="layout_wrap">
	    <div class="layout_flex_fixed" style="width:300px">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid" id="mainTable1">
	        	 <table class="grid_2 wAuto">
	        	 	<colgroup>
						<col width="300" />				
				   </colgroup> 
				   <tbody>
		                  <tr>
		                    <th style="text-align:center;"><input type="radio" name="route_div" id="route_div0" class="trans" onFocus="javascript:this.blur();" checked>&nbsp;<lable for="route_div0">Conti</lable></th>
		                  </tr>
		             </tbody>
                </table>
	           <script type="text/javascript">ComSheetObject("sheet1");</script>
	        </div>
	        <!-- opus_design_grid(e) -->
	         <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid" id="mainTable2">
	        	<table class="grid_2 wAuto">
	        		<colgroup>
						<col width="300" />				
				   </colgroup> 
				   <tbody>
	                  <tr>
	                    	<th style="text-align:center;"><input type="radio" name="route_div" id="route_div1" class="trans" onFocus="javascript:this.blur();"/>&nbsp;<lable for="route_div1">Sub Conti</lable></th>
	                  </tr>
	            </tbody>
	        </table>
			<script type="text/javascript">ComSheetObject('sheet2');</script>	        
	     </div>
	</div>
	 <div class="pad_left_8 layout_flex_fixed" style="width:300px">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid"   id="mainTable3">
	        	<table class="grid_2 wAuto">
		        	<colgroup>
						<col width="300"/>				
				   </colgroup> 
				   	<tbody>
		                  <tr>
		                    <th style="text-align:center;"><input type="radio" name="route_div" id="route_div2" class="trans" onFocus="javascript:this.blur();">&nbsp;<lable for="route_div2">Country</lable></th>
		                  </tr>
		            </tbody>
                </table>
				<script type="text/javascript">ComSheetObject('sheet3');</script>	           
	        </div>
	        <!-- opus_design_grid(e) -->
	    </div>
	    <div class="layout_flex_flex" style="padding-left:608px;float:right;">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid" id="mainTable4">
	        	<table class="grid_2">
<!-- 	        		<colgroup> -->
<!-- 						<col width="300"/>				 -->
<!-- 				   </colgroup>  -->
				   	<tbody>
		                  <tr>
		                    <th style="text-align:center;"><input type="radio" name="route_div" id="route_div3" class="trans" onFocus="javascript:this.blur();">&nbsp;<lable for="route_div3">Location</lable></th>
		                  </tr>
		        	</tbody>
	            </table>
				<script type="text/javascript">ComSheetObject("sheet4");</script>
	        </div>
	        <!-- opus_design_grid(e) -->
	    </div>
	</div>
	<!-- layout_wrap(e) -->
	
</div>
</form>
