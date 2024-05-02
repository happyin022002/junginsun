<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName   : ESM_BKG_3011.jsp
*@FileTitle  : 
*@author     : SJH
*@version    : 1.0
*@since      : 2014/11/21
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg3011Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	Exception serverException   = null;         //Error from server
	String strErrMsg    = "";                               //Error message
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.ESM_BKG_3011");
	String xml = "";
	try {
	    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
	    if (serverException != null) {
	        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	    }
	    
	    xml = HttpUtil.makeXML(request,response); 
	    xml = xml.replaceAll("\"", "'");
	    
	}catch(Exception e) {
	    log.error("Exception : " + e.toString());
	}
%>

<script type="text/javascript">
    function setupPage(){
	    var errMessage = "<%=strErrMsg%>";
	    var formObj = document.form;
	
	    if (errMessage.length >= 1) {
	        ComShowMessage(errMessage);
	    } // end if
	
	    loadPage();
    }
</script>

<form method="post" name="form" onKeyDown="ComKeyEnter()">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sXml" value="<%= xml%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
        <button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
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
    
<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <table>
             <colgroup>
                <col width="20"  />
                <col width="50"  />
                <col width="140" />
                <col width="50" />
                <col width="" />
            </colgrou> 
            <tbody>
                <tr>
                    <th>Country</th>
                    <td><input type="text" style="width:100px; ime-mode:disabled;text-transform:uppercase;" dataformat="engup" otherchar=" -._/" name="country_code" id="country_code" class="input"  maxlength="2" ></td>
                    <th>Place of Issue Name</th>
                    <td><input type="text" style="width:100px; ime-mode:disabled;" name="place_of_issue_name" id="place_of_issue_name" class="input"  maxlength="20"></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <!----------------------------------------------------------------- MAIN Start --------------------------------------------------------->
    <div class="opus_design_grid"  id="mainTable">
    	<div class="opus_design_btn">		
			<button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row Add</button>
			<button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Row Delete</button>
			<button type="button" class="btn_normal" name="btn_Edit" id="btn_Edit">Row Edit</button>
		</div>
        <script type="text/javascript">ComSheetObject('sheet1');</script>                     
    </div>
    <!----------------------------------------------------------------- MAIN End  ----------------------------------------------------------> 
</div>
<!-- wrap_result(E) -->
</form>
