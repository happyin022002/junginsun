<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_3304.jsp
*@FileTitle  : Container Status Message & Movement Status Mapping Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.manualinput.event.EsdSce3304Event"%>
<%
    EsdSce3304Event  event = null;
    Exception serverException   = null;
    String strErrMsg = "";
    try {
        event = (EsdSce3304Event)request.getAttribute("Event");
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
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd">
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
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_exceldown"   id="btn_exceldown">Down Excel</button><!--
        --><button type="button" class="btn_normal" name="btn_excelup"   id="btn_excelup">Load Excel</button>
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
    
<div id="MiniLayer" style="display:inline">
<!-- wrap_search(S) -->  
	<div class="wrap_search">
	    <div class="opus_design_inquiry wFit">
         <table>
              <colgroup>
                   <col width="80">
                   <col width="110">
                   <col width="*">
               </colgroup>
               <tbody>
               <tr>
	               <th>Region</th>
	               <td>
	                    <select id="csm_cnt_cd" style="width:98px;" onchange="csmCntCd_onchange(this)">
	                        <option value=""  selected>ALL</option>
	                        <option value="US">US</option>
	                        <option value="EU">EU</option>
	                    </select>
	                </td>
	                <td>&nbsp;</td>
              </tr>
             </tbody>
          </table>	    
	    </div>
	</div>
</div>    
<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid"  id="mainTable">
        
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
            <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
            <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row&nbsp;Add</button>
            <button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row&nbsp;Delete</button>
        </div>
        <!-- opus_design_btn(E) -->
        
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script type="text/javascript">ComSheetObject('sheet1');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
        
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
    
</form>
