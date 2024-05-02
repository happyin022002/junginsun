<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ees_mnr_multy.jsp
*@FileTitle : Multi data select common
*Open Issues : 이화면은 서버단을 타지 않는다 MnrComEvent 은 덤프 이벤트이다 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
%>

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
 	MnrComEvent  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//서버에서 발생한 에러
 	String strErrMsg = "";	 					//에러메세지
 	String strUsr_id		= "";     
 	String strUsr_nm		= "";    
 	
 	//기존소스용
 	String returnval = ((request.getParameter("returnval")==null )?"":request.getParameter("returnval"));
	String returntitle = ((request.getParameter("returntitle")==null )?"":request.getParameter("returntitle"));
	returntitle ="("+returntitle+")";
      	
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
 
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();  
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">   
<input type="hidden" name="returnval" id="returnval" value="<%=returnval%>"> 

<div class="layer_popup_title">
    <div class="page_title_area clear">
        <h2 class="page_title"><span>Multiple Input Popup()</span></h2>
        <div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close"	id="btn_Close">Close</button>
        </div>
    </div>
</div>
    
<div class="layer_popup_contents">   
	<div class="wrap_result">	
		<div class="opus_design_grid">
		    	<table>
		    		<colgroup>
		    			<col width="80">
		    			<col width="*">
		    		</colgroup>
		    		<tr>
		    			<th>Row Count</th>
		    			<td><input  name="row_count" id="row_count" type="text" style="width:30px; height:19; text-align:right" value="1" maxlength="3" onFocus="javascript:select()"></td>
					</tr>
				</table>
		    <div class="opus_design_btn">
		        <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
		        <button type="button" class="btn_normal" name="btn_Apply" id="btn_Apply">Apply</button>
		    </div>
		    
		    
		    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
	</div>
</div>

<!-- 개발자 작업  끝 -->  
</form>