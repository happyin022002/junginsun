<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0011.jsp
*@FileTitle  : Agent Commission Simulation Agreement Creation
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
<%@ page import="com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0011Event event = null;        //PDTO(Data Transfer Object including Parameters)
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
    event = (EsmAcm0011Event)request.getAttribute("Event");
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
// 공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("effDiv", "", "CD03014", 0, "")%>
<%=JSPUtil.getIBCodeCombo("acTp", "", "CD03021", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ioBnd", "", "CD00592", 0, "")%>
<%=JSPUtil.getIBCodeCombo("fullMty", "", "CD00748", 0, "")%>
<%=JSPUtil.getIBCodeCombo("commPayTerm", "", "CD03022", 0, "")%>
<%=JSPUtil.getIBCodeCombo("revDiv", "", "CD03023", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ofcSetTp", "", "CD03016", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ofcCvrg", "", "CD03019", 0, "")%>


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
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="20"/>
				<col width="100"/>
				<col width="70"/>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="180"/>
				<col width="*" />
			</colgroup>
			<tr class="h23">
   	            <th>RHQ</th>
                <td><select name="rhq_cd_disp" id="rhq_cd_disp" required caption="RHQ" class="input1" style="width:100px; display: none;" tabindex="1"><!--
               --></select><input name="rhq_cd" type="text" class="input2" style="width:100; text-align:center;" tabindex="1" readOnly><!--
               --></td>
                <th>Office</th>
                <td><select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:100px;" tabindex="2"></select></td>
                <th>Sub Office</th>
                <td><select name="agn_cd" id="agn_cd" required caption="Sub Office" class="input1" style="width:100px;" tabindex="3"></select></td>
                <th>Show Deleted Agreement</th>
                <td> <input name="delt_flg" id="delt_flg" type="checkbox" class="trans" value="Y"></td>
              </tr>
			</tbody>
			</table>
		</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result">
    <div class="opus_design_tab sm" >
		<script type="text/javascript">ComTabObject("tab1")</script>
	</div>
	<div id="tabLayer" style="display:inline">
		<div class="opus_design_grid">
			<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="tab1btn_retrieve" id="tab1btn_retrieve">Retrieve</button>
			<button type="button" class="btn_accent" name="tab1btn_save" id="tab1btn_save">Save</button>
			<button type="button" class="btn_accent" name="tab1btn_add" id="tab1btn_add">Row Add</button>
			<button type="button" class="btn_accent" name="tab1btn_copy" id="tab1btn_copy">Copy</button>
			</div>
	    	 <script type="text/javascript">ComSheetObject('tab1sheet1');</script>
	    </div>
    </div>
    
    <div id="tabLayer" style="display:none">
	    <div class="opus_design_grid">
	    	 <h3 style="margin-bottom:0" class="title_design">Selected Agreement</h3>
	    	 <script type="text/javascript">ComSheetObject('tab2sheet1');</script>
	    </div>
	    
	    <!-- layout_wrap(S) -->
			<div class="layout_wrap" style="width: 100%">
				<!-- layout_vertical_2(S) -->
				<div class="layout_vertical_2" style="width: 32%">
					<div class="opus_design_grid">
						<h3 style="margin-bottom:0" class="title_design">Compensation Master</h3>
						<!-- opus_design_btn (S) -->
						<div class="opus_design_btn">
							<button class="btn_accent" name="tab2btn_add" id="tab2btn_add" type="button">Row Add</button><!--
							--><button class="btn_normal" name="tab2btn_delete" id="tab2btn_delete" type="button">Delete</button><!--
							--></div>
						<!-- opus_design_btn (E) -->
		    	 		<script type="text/javascript">ComSheetObject('tab2sheet2');</script>
					</div>
			     	<!-- layout_vertical_2(E) -->
				</div>
				
				<!-- layout_vertical_2(S) -->
				<div class="layout_vertical_2" style="width: 66%;margin-left: 2%;">
					<div class="opus_design_grid">
						<h3 style="margin-bottom:0" class="title_design">Compensation Rate</h3>
						<!-- opus_design_btn (S) -->
						<div class="opus_design_btn">
							<button class="btn_accent" name="tab2btn_retrieve" id="tab2btn_retrieve" type="button">Retrieve</button><!--
							--><button class="btn_normal" name="tab2btn_save" id="tab2btn_save" type="button">Save</button><!--
							--></div>
						<!-- opus_design_btn (E) -->
						<div class=“opus_design_inquiry”>
   							<table class="grid_2">
   								<colgroup>
   									<col width="385">
   									<col width="372">
   								</colgroup>
		                      <tr>
		                        <td class="sm" style="text-align: center; padding-top:0px; padding-bottom:0px; border-bottom:0px;"><input type="radio" name="rate_div" id="rate_div" class="trans" onClick="javascript:chkRate('F');" ">&nbsp;<b>Fixed Amount Base</b></td>
		                        <td class="sm" style="text-align: center; padding-top:0px; padding-bottom:0px; border-bottom:0px;"><input type="radio" name="rate_div" id="rate_div" class="trans" onClick="javascript:chkRate('R');" >&nbsp;<b>Rate Base</b></td>
		                      </tr>
	                    	</table>
                    	</div>
		 	 			 <script type="text/javascript">ComSheetObject('tab2sheet3');</script>
					</div>
					
					<!-- layout_wrap(S) -->
					<div class="layout_wrap" style="width: 100%">
						<!-- layout_vertical_2(S) -->
						<div class="layout_vertical_2" style="width: 48%;margin-right: 4%;">
							<div class="opus_design_grid">
								<h3 style="margin-bottom:0" class="title_design">Office Setting</h3>
		   	 		 			<script type="text/javascript">ComSheetObject('tab2sheet4');</script>
							</div>
						</div>
					     <!-- layout_vertical_2(E) -->
						<!-- layout_vertical_2(S) -->
						<div class="layout_vertical_2" style="width: 48%">
							<div class="opus_design_grid">
								<h3 style="margin-bottom:0" class="title_design">Route Setting</h3>
	    	 					<script type="text/javascript">ComSheetObject('tab2sheet5');</script>
							</div>
						</div>
					     <!-- layout_vertical_2(E) -->
					</div>
					<!-- layout_wrap(E) -->
					
					<div class="opus_design_grid">
						<h3 style="margin-bottom:0" class="title_design">Charge/Surcharge Deduction Setting</h3>
	    	 		 	<script type="text/javascript">ComSheetObject('tab2sheet6');</script>
					</div>
					<div class="opus_design_grid">
						<h3 style="margin-bottom:0" class="title_design">Haulage Deduction Setting</h3>
	    	 		 	<script type="text/javascript">ComSheetObject('tab2sheet7');</script>
					</div>
				</div>
				<!-- layout_vertical_2(S) -->
				
			</div>
			<!-- layout_wrap(E) -->	 
	    </div>
    <div id="tabLayer" style="display:none">
	    <div class="opus_design_grid">
		     <h3 style="margin-bottom:0" class="title_design">Agreement List</h3>
		 	 <div class="opus_design_btn"><button type="button" class="btn_accent" name="tab3btn_retrieve" id="tab3btn_retrieve">Retrieve</button></div>
		   	 <script type="text/javascript">ComSheetObject('tab3sheet1');</script>
		 	 <h3 style="margin-bottom:0" class="title_design">Agreement Detail</h3>
		     <script type="text/javascript">ComSheetObject('tab3sheet2');</script>
	    </div>
    </div>
</div>
</form>