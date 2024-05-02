<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0039.jsp
*@FileTitle  : Lane Transit-time
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null;             //Error from server
    String strErrMsg    = "";   
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0039");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error("ESM_COA_0039 Exception : "+e.toString());
    }
%>
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        var formObj = document.form;
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form method="post" name="form" onKeyUp="ComKeyEnter();" id="form">
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
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_Downexcel" id="btn_Downexcel">Down Excel</button>
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
        <table>
             <colgroup>
                <col width="45"  />
                <col width="173" />
                <col width="35"  />
                <col width="135" />
                <col width="60"  />
                <col width="135" />
                <col width="25"  />
                <col width="130" />
                <col width="35"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <td colspan="8"><script language="javascript">coaPeriod1("1","");</script></td>
                </tr>
                <tr>
                    <th>Trade</th>
                    <td>
                        <script language="javascript">ComComboObject('f_seltrade',1, 80 , 0 )</script>
                    </td>
                    <th>Lane</th>
                    <td>
                        <div id="div_rLane">&nbsp;<script language="javascript">ComComboObject('f_selrlane',1, 80 , 0 )</script></div>
                    </td>
                    <th>Direction</th>
                    <td>
                        <script language="javascript">ComComboObject('f_seldir',1, 80 , 0 )</script>
                    </td>
                    <th>IOC</th>
                    <td>
                        <script language="javascript">ComComboObject('f_selioc',1, 80 , 0 )</script>
                    </td>
                    <th title="Vessel Voyage Direction">VVD</th>
                    <td>
                        <input type="text" size="4" name="f_vsl_cd" maxlength="4" dataformat="engup" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:65px;"><!--
                        --><input type="text" size="4" name="f_skd_voy_no" maxlength="4" dataformat="num" onkeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:65px;"><!--
                        --><input type="text" size="1" name="f_dir_cd" maxlength="1" dataformat="engup" onKeyPress="ComKeyOnlyAlphabet('upper');" onBlur="chkVVD();" style="ime-mode:disabled; width:30px;">
                    </td>
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
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid"  id="mainTable">
        <script language="javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>


