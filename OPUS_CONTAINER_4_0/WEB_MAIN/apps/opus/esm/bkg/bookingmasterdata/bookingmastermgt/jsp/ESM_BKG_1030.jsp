<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1030.jsp
*@FileTitle  : EMandatory Item(s) Setup for Customized Service Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1030Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1030Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         // error from server
    String strErrMsg = "";                      // error message
    int rowCount     = 0;                       // count of DB resultSET list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    String screenName       = "";
    Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (EsmBkg1030Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        log.debug("====================================");
        Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
        screenName = screen.getName();
        log.debug("====================================");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        ComSetObjValue(document.form.screenName,"<%=screenName%>");
        loadPage();     
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="screenName">

<input type="hidden" name="chk_cust_cd">
<input type="hidden" name="chk_cust_seq">

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
        <% if (screenName.indexOf("Q") < 0){ %> 
         <button type="button" class="btn_normal" name="btn_Save"   id="btn_Save">Save</button>
        <% } %>
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
            <col width="95px" />
            <col width="135px" />
            <col width="50px" />
            <col width="115px" />
            <col width="50px" />
            <col width="130px" />
            <col width="68px" />
            <col width="70px" />
            <col width="35px" />
            <col width="85px" />
            <col width="75px" />
            <col width="" />
        </colgroup>
         
        <tbody>
            <tr class="h23">
                <th>Customer Code</th>
                <td><input id="frm_cust_grp_id" name="frm_cust_grp_id" style="width:18px;" class="input" value="" dataformat="engup" maxlength="1" type="text" /><input id="frm_cust_cnt_cd" name="frm_cust_cnt_cd" style="width:25px;" class="input" value="" dataformat="engup" maxlength="2" type="text" /><input id="frm_cust_seq" name="frm_cust_seq" style="width:50px;" class="input" value="" dataformat="num" maxlength="6" type="text" /></td>
                <th>S/C  No.</th>
                <td><input id="sc_no" name="sc_no" style="width:80px;" class="input" value="" dataformat="engup" maxlength="9" type="text" /></td>
                <th>RFA No.</th>
                <td><input id="rfa_no" name="rfa_no" style="width:100px;" class="input" value="" dataformat="engup" maxlength="11" type="text" /></td>
                <th>SVC Scope</th>
                <td><input id="svc_scp_cd" name="svc_scp_cd" style="width:32px;" class="input" value="" dataformat="enguponly" maxlength="3" type="text" /> </td>
                <th>Origin</th>
                <td><input id="por_cd" name="por_cd" style="width:50px;" class="input" value="" dataformat="engup" maxlength="5" type="text" /> </td>
                <th>Destination</th>
                <td><input id="pod_cd" name="pod_cd" style="width:50px;" class="input" value="" dataformat="engup" maxlength="5" type="text" /> </td>
            </tr>
            
        </tbody>
    </table>
    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <% if (screenName.indexOf("Q") < 0){ %>     
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        
	            <button type="button" class="btn_normal" name="btn_Copy" id="btn_Copy">Row Copy</button>
	            <button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row Add</button>
	            <button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>

	    <!-- opus_design_btn(E) -->
	    <div class="grid_option_right mar_left_4">
	        <input type="text" name="copy_idx" style="width:30px;text-align:center" class="input" value="1" dataformat="num" maxlength="3">
	    </div>      
	    <% } %>
	    </div>	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>