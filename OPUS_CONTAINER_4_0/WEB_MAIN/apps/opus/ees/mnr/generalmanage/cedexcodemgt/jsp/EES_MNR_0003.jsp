<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0003.jsp
*@FileTitle  : EQ Component
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
 	EesMnr0003Event  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//Occurred error from server
 	String strErrMsg = "";						//Error message

 	String strUsr_id		= "";
 	String strUsr_nm		= "";
	String strAccess_System		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
 	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm();
		strAccess_System = account.getAccess_system();
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();

 		event = (EesMnr0003Event)request.getAttribute("Event");
 		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

 		if (serverException != null) {
 			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
 		}
 	}catch(Exception e) {
 		out.println(e.toString());
 	}
 %>

<script type="text/javascript">
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var usrId     = "<%=strUsr_id.trim()%>";
	var rhqOfcCd  = "<%=rhqOfcCd.trim()%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="f_type" id="f_type" />
<input type="hidden" name="pagerows" id="pagerows" />


	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title">Damage Location</span>
			</button>
		</h2>
		<!-- page_title(E) -->

		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
				--><button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button><!-- 
				--><button type="button" class="btn_normal" name="btn_Save"   id="btn_Save">Save</button>
		    </div>
		    <!-- opus_design_btn(E) -->

		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->

	</div>
	<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	          <colgroup>
	            <col width="60" />
	            <col width="100" />
	            <col width="130" />
	            <col width="*" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>EQ Type</th>
					<td>
						<script type="text/javascript">ComComboObject('eq_knd_cd',1,104,1,1,0,false,0);</script>
					</td>

					<th>1st Location Code</th>
					<td>
						<script type="text/javascript">ComComboObject('key_value',2,207,1,1)</script>
					</td>

				</tr>

			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	    <div class="layout_vertical_4">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid"  id="mainTable">
		    <!-- opus_design_btn(S) -->
		    <h3 class="title_design">1st Location Code</h3>
		        <div class="opus_design_btn">
			        <button type="button" class="btn_normal" name="btn_RowAdd1" id="btn_RowAdd1">Row Add</button>
			        <button type="button" class="btn_normal" name="btn_RowDel1" id="btn_RowDel1">Row Delete</button>
			        <button type="button" class="btn_normal" name="btn_Excel1" id="btn_Excel1" title="Download data as excel file">Down Excel</button>
		    	</div>
		    	<script type="text/javascript">ComSheetObject('sheet1');</script>
	   		</div>
	        <!-- opus_design_grid(E) -->
	    </div>

	    <div class="layout_vertical_4 pad_left_8">
	        <div class="opus_design_grid"  id="mainTable">
		    <h3 class="title_design">2nd Location Code</h3>
		        <div class="opus_design_btn">
			        <button type="button" class="btn_normal" name="btn_RowAdd2" id="btn_RowAdd2">Row Add</button>
			        <button type="button" class="btn_normal" name="btn_RowDel2" id="btn_RowDel2">Row Delete</button>
			        <button type="button" class="btn_normal" name="btn_Excel2" id="btn_Excel2" title="Download data as excel file">Down Excel</button>
			    </div>
		    	<script type="text/javascript">ComSheetObject('sheet2');</script>
	    	</div>
	    </div>

	    <div class="layout_vertical_4 pad_left_8">
	        <div class="opus_design_grid"  id="mainTable">
		    <h3 class="title_design">3rd Location Code</h3>
			    <div class="opus_design_btn">
		     		<button type="button" class="btn_normal" name="btn_RowAdd3" id="btn_RowAdd3">Row Add</button>
				    <button type="button" class="btn_normal" name="btn_RowDel3" id="btn_RowDel3">Row Delete</button>
				    <button type="button" class="btn_normal" name="btn_Excel3" id="btn_Excel3" title="Download data as excel file">Down Excel</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet3');</script>
			</div>	    
	    </div>

	    <div class="layout_vertical_4 pad_left_8">
	        <div class="opus_design_grid"  id="mainTable">
		    <h3 class="title_design">4th Location Code</h3>
			    <div class="opus_design_btn">
			        <button type="button" class="btn_normal" name="btn_RowAdd4" id="btn_RowAdd4">Row Add</button>
			        <button type="button" class="btn_normal" name="btn_RowDel4" id="btn_RowDel4">Row Delete</button>
			        <button type="button" class="btn_normal" name="btn_Excel4" id="btn_Excel4" title="Download data as excel file">Down Excel</button>
	    		</div>
    		<script type="text/javascript">ComSheetObject('sheet4');</script>
			</div>	    
	    </div>
</div>	
</form>