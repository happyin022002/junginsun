<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName :  EES_MST_QEXE.jsp
*@FileTitle : Query Execute
*Open Issues :
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
<%@ page import="com.clt.apps.opus.ees.mst.mstcommon.mstcommon.event.MstComEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
 	MstComEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
 	Exception serverException  = null;			//Occurred error from server
 	String strErrMsg = "";	 					//Error message
 	String strUsr_id = "";
 	String strUsr_nm = "";

 	//Variable for existing logic
 	String returnval = ((request.getParameter("returnval")==null )?"":request.getParameter("returnval"));
	String returntitle = ((request.getParameter("returntitle")==null )?"":request.getParameter("returntitle"));

	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm();

 		event = (MstComEvent)request.getAttribute("Event");
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
		<button type="button" class="btn_normal" name="btn_Run" id="btn_Run">Run</button>
		<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_GetInsert" id="btn_GetInsert">Get Insert</button>
<!-- 		<button type="button" class="btn_normal" name="btn_FileOpen" id="btn_FileOpen">File Open</button> -->
		<button type="button" class="btn_normal" name="btn_SendEDI" id="btn_SendEDI">Send EDI</button>
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
	
	
<!-- wrap_result(S) -->
<div class="wrap_search" > 
	<div class="opus_design_inquiry">
		<table>	
			<tbody>
				<tr class="h23">
					<th width="80"><b>Run Count</b></th>
					<td><input type="text" style="width:90px;text-align:center;" class="input1" name="run_cnt" id="run_cnt" value="1" dataformat="int"></td>
				</tr>
				<tr class="h23">
					<th width="80"><b>Query EXE</b></th>
					<td><textarea name="mst_query" wrap="virtual" style="width:70%;height:300px;background-color:beige;" rows="50"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_search" > 
    <div class="opus_design_inquiry">
        <table>
            <colgroup>
                <col width="30px" />
                <col width="50px" />
                <col width="50px" />
                <col width="10px" />
                <col width="*" />
            </colgroup>         
            <tbody>
                <tr class="h23">
                    <th width="100"><b>Identity</b></th>
                    <td><input type="text" style="width:120px;text-align:center;" class="input" name="input_user" id="input_user"></td>
                    <th width="100"><b>Result</b></th>
                    <td><input type="text" style="width:200px;text-align:center;" class="input" name="result_value" id="result_value"></td>                    
                    <td><button type="button" class="btn_normal" name="btn_ret" id="btn_ret">Search</button></td>                   
                </tr>
            </tbody>
        </table>                
    </div>
</div>
<!-- wrap_result(E) -->
<script language="javascript">ComSheetObject('sheet1');</script>
</form>