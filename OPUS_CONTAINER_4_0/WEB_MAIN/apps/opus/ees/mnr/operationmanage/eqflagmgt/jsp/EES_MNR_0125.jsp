<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_MNR_0125.jsp
*@FileTitle : Damage History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0125Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0125Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list
	    
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
 	
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String workApp 		    = "";
	
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.EQFlagMgt");
	       
	try {    
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();      
		strUsr_nm = account.getUsr_nm();   
		workApp = account.getAccess_system(); 
		
		event = (EesMnr0125Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 
		if (serverException != null) {    
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}      
		
		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	    	  
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<!-- common use in MNR -->                
<script language="javascript">   
	//workApp ALP or SPP   
	var workApp = '<%=workApp%>';  
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
<input type="hidden" name="pagerows">   
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
		<button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_DownExcel"   id="btn_DownExcel">Down Excel</button>
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
<div class="opus_design_inquiry wFit">
	<table>
		 <colgroup>
			<col width="70px" />
			<col width="130px" />
			<col width="130px" />
			<col width="" />
		</colgroup> 
		<tbody>
			<tr class="h23">
				<th>EQ No.</th>
				<td>
					<input style="width:120px;" required type="text" name="eq_no" value='' dataformat="engup" caption="EQ No" class="input1" value="">
				</td>
				<th>Damage Period</th>
				<td>
					<input type="text" name="from_date" dataformat="ymd"    caption="from date"        maxlength="10"  size="10"  cofield="to_date" value="">   
                              	~ <input type="text" name="to_date" dataformat="ymd"    caption="to date"        maxlength="10"  size="10"  cofield="from_date"><!--  
                              	--><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
				</td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		
		 <div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
		<h3 class="title_design">Damage Flagging/Unflagging History Detail</h3>
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script language="javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		</div>
		<!-- opus_design_grid(E) -->
</form>