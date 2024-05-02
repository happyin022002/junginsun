<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_OFCINFOMULT.jsp
*@FileTitle : Multi data select common
*Open Issues : 이화면은 서버단을 타지 않는다 MnrComEvent 은 덤프 이벤트이다
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
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
 	Exception serverException   = null;			//Occurred error from server
 	String strErrMsg = "";	 					//Error message
 	String strUsr_id		= "";
 	String strUsr_nm		= "";

 	//Variable for existing logic
 	String returnval = ((request.getParameter("returnval")==null )?"":request.getParameter("returnval"));
	String returntitle = ((request.getParameter("returntitle")==null )?"":request.getParameter("returntitle"));
	String presetData = ((request.getParameter("presetData")==null )?"":request.getParameter("presetData"));
	String sheet_id = ((request.getParameter("sheet_id")==null )?"":request.getParameter("sheet_id"));
	String rprQty = ((request.getParameter("rpr_qty")==null )?"":request.getParameter("rpr_qty"));
	String targetRow = ((request.getParameter("targetRow")==null )?"":request.getParameter("targetRow"));

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
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="returnval" value="<%=returnval%>">
<input type="hidden" name="presetData" value="<%=presetData%>">
<input type="hidden" name="sheet_id" value="<%=sheet_id%>">
<input type="hidden" name="rpr_qty" value="<%=rprQty%>">
<input type="hidden" name="targetRow" value="<%=targetRow%>">
<!-- Developer's task	-->

<div class="layer_popup_title">
    <div class="page_title_area clear">
        <h2 class="page_title"><span>Hanger Bar Offer Infomation</span></h2>
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

<!-- Developer's task   -->
</form>