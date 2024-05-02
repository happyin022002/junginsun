<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESS_MNR_0138.jsp
*@FileTitle : Depreciated Value Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.event.MnrComEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	MnrComEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (MnrComEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
    var usrId 		= "<%=strUsr_id%>"; 
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="eq_type">
<input type="hidden" name="pagerows">
<!-- RD  --> 
<input type="hidden" name="com_mrdPath" value="">  
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="com_mrdBodyTitle" value="Depreciated Value Inquiry">

     
<!-- page_title_area(S) -->
	<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button>
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
	<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	<div class="opus_design_inquiry">
		<table>
			 <colgroup>
				<col width="70px" />
				<col width="70px" />
				<col width="70px" />
				<col width="230px" />
				<col width="70px" />
				<col width="" />
			</colgroup> 
			<tbody>
				<tr class="h23">
					<th>EQ Type</th>
					<td>
						<script language="javascript">ComComboObject('combo1',2, 120 , 1,1);</script>
					</td>
					<th>EQ No.</th>
					<td>
						<input type="text" name="eq_no" id="eq_no" style="width:170px;" class="input1" required dataformat="engup"><!--  
						--><button class="multiple_inq ir" name="eq_no_multi" id="eq_no_multi" type="button"></button>
					</td>
					<th>Total Loss Date</th>
					<td>
						<input type="text" name="total_loss_date" style="width:80px;text-align:center" class="input1" required dataformat="ymd" maxlength="10"><!--  
						--><button type="button" class="calendar ir" name="total_loss_date_cal" id="total_loss_date_cal"></button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<div class="wrap_result">			
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
</form>