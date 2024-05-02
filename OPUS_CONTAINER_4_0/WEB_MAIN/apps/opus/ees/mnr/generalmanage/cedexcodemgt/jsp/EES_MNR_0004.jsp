<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0004.jsp
*@FileTitle  : EQ Damage Type
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
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<% 

 	EesMnr0004Event  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//error from server
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

 		event = (EesMnr0004Event)request.getAttribute("Event");
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
<input type="hidden" name="eq_cedex_otr_tp_cd" id="eq_cedex_otr_tp_cd" />
<input type="hidden" name="eq_cedex_otr_cd" id="eq_cedex_otr_cd" />
<input type="hidden" name="pagerows" id="pagerows" />

	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title">Code by Type</span>
			</button>
		</h2>
		<!-- page_title(E) -->

		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
				<button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button>
				<button type="button" class="btn_normal" name="btn_Save"   id="btn_Save">Save</button>
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
	            <col width="1px" />
	            <col width="130px" />
	            <col width="100px" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr class="h23">
					<th>Type</th>
					<td>
						<script type="text/javascript">ComComboObject('combo1',2, 200 , 1,1)</script>
					</td>
					<th>Code</th>
					<td>
						<input style="width:35px;" type="text" name="eq_cedex_otr_cd_dummy" dataformat="engup" maxlength="2" caption="eq_cedex_otr_cd" class="input" value="" id="eq_cedex_otr_cd_dummy" />
					</td>
				</tr>

			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="mainTable">
	    <h3 class="title_design">Damage Type Code</h3>

	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row&nbsp;Add</button>
	        <button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row&nbsp;Delete</button>
	        <button type="button" class="btn_normal" name="btn_Excel1" id="btn_Excel1">DownExcel</button>
	    </div>
	    <!-- opus_design_btn(E) -->

	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->

	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>