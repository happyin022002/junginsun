<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0042.jsp
*@FileTitle  : Daily hire by Chartered vessel
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>		<!-- SJH.20141027.ADD -->
<%
    Exception serverException = null;   //Error from server
    String strErrMsg = "";              //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0042");
    
    //SJH.20141027.ADD
	String userId = "";
	String ofc_cd = "";
	
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } else {
        	//SJH.20141027.ADD
			SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			userId = account.getUsr_id();
	        ofc_cd = account.getOfc_cd(); //getUserOffice2();
        }
    } catch(Exception e) {
        log.error(e.toString());
    }
%>
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }

</script>


<form method="post" name="form" onKeyDown="ComKeyEnter();" id="form">
<input  type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="v_ofc_cd"  value="<%=ofc_cd%>"> <!-- SJH.20141027.ADD -->

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
        <button type="button" class="btn_normal" name="btn_create" id="btn_create">Create</button><!--
        --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_Downexcel" id="btn_Downexcel">Down Excel</button><!--
        --><button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
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
                <col width="375" />
                <col width="50"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <td><script type="text/javascript">coaPeriod2("2");</script></td>	<!-- SJH.20150108.ADD -->
                    <th>Vessel</th>
                    <td><input type="hidden" name="f_vsl_cd">&nbsp;<script language="javascript">ComComboObject('select1',1, 70 , 0 )</script></td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
    
<!-- wrap_result(S) -->
<div class="wrap_result">    
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid"  id="mainTable">
     	<div align="right" class="mar_btm_4"> (USD)</div>
        <script language="javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
