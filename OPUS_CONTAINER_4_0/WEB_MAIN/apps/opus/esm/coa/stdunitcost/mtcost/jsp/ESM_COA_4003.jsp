<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName   : ESM_COA_4003.jsp
*@FileTitle  : Slot Internal Pricing
*@author     : SJH
*@version    : 1.0
*@since      : 2014/10/02
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.mtcost.event.EsmCoa4003Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	Exception serverException   = null;         //Error from server
	String strErrMsg    = "";                               //Error message
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_4003");
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
<input type="hidden" name="f_ecc_cd2" value="">
<input type="hidden" name="f_view_tpsz" value="">
<input type="hidden" name="f_from" value="">
<input type="hidden" name="f_to" value="">


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
                <col width="70"  />
                <col width="120"  />
                <col width="100" />
                <col width="100"  />
                <col width="60"  />
                <col width="100" />
                <col width="50"  />
                <col width="100"  />
                <col width="50"  />
                <col width="" />
            </colgrou> 
            <tbody>
                <tr>
                    <th>YYYY-MM</th>
                    <td><input type="text" name="f_cost_yrmon" class="input1" style="width:60px;" value="" maxlength="6" onkeypress="ComKeyOnlyNumber(window)" onKeyDown="ComKeyEnter();" onfocus="this.value=ComReplaceStr(this.value, '-', '');" onblur="addDash(this , 4);" id="f_cost_yrmon" /></td>
                    <th>Location Hierarchy</th>
                    <td><script type="text/javascript">ComComboObject('f_cost_loc_grp_cd', 1, 70 , 0 )</script></td>
                    <th>Location</th>
                    <td><script type="text/javascript">ComComboObject('f_ecc_cd', 1, 70 , 0 )</script></td>
                    <th>Type/Size</th>
                    <td><script type="text/javascript">ComComboObject('f_cntr_tpsz_cd', 1, 70 , 0 )</script></td>
                    <th>Trade</th>
                    <td><script type="text/javascript">ComComboObject('f_trd_cd', 1, 70 , 0 )</script></td>
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
    <!-- : location link Added (S) -->
    <div id="mainTable">
        <!-- : location link Added -->
        <table class=" " border="0" style="width:100%;height:28px">
            <tr>
            	<td align="left" width="27.5%" valign="bottom" class=" "><h3 class="title_design">FULL Repo. Unit Cost Inquiry (Per FULL Vol.)</h3></td>
                <td align="right" width="70%" class=" ">
                	<button type="button" class="btn_etc" name="btn_Location" id="btn_Location" >Location</button>&nbsp;
                </td>
                <td class="gray" width="2.5%">(USD)</td>
            </tr>
        </table>
    </div>
    <!-- : location link Added (S) -->

    <!----------------------------------------------------------------- MAIN Start --------------------------------------------------------->
    <div class="opus_design_grid"  id="mainTable">
        <script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- SJH.20141222.MOD -->
        <div class="opus_design_btn" style="text-align:right; margin-top:4px;">        	
            <button type="button" class="btn_accent" name="btn_EccStatus" id="btn_EccStatus">ECC Status</button>
            <button type="button" class="btn_accent" name="btn_Rowadd1" id="btn_Rowadd1">Row Add</button>
            <button type="button" class="btn_accent" name="btn_Save1" id="btn_Save1">Save</button>
            <button type="button" class="btn_accent" name="btn_DownExcel1" id="btn_DownExcel1">Down Excel</button>
            <button type="button" class="btn_accent" name="btn_LoadExcel1" id="btn_LoadExcel1">Load Excel</button>
            <button type="button" class="btn_accent" name="btn_Validation1" id="btn_Validation1">Validation</button>
        </div>                           
    </div>
    <!-- opus_design_grid(E) -->

    <table class="line_bluedot"><tr><td></td></tr></table>

    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid"  id="mainTable">
    	<h3 class="title_design pad_btm_8">ECC Status</h3>
        <script type="text/javascript">ComSheetObject('sheet2');</script>
        <!-- SJH.20141222.MOD -->
        <div class="opus_design_btn" style="text-align:right; margin-top:4px;">
            <button type="button" class="btn_accent" name="btn_Rowadd2" id="btn_Rowadd2">Row Add</button>
            <button type="button" class="btn_accent" name="btn_Save2" id="btn_Save2">Save</button>
            <button type="button" class="btn_accent" name="btn_DownExcel2" id="btn_DownExcel2">Down Excel</button>
            <button type="button" class="btn_accent" name="btn_LoadExcel2" id="btn_LoadExcel2">Load Excel</button>
            <button type="button" class="btn_accent" name="btn_Validation2" id="btn_Validation2">Validation</button>
        </div>            
    </div>
    <!-- opus_design_grid(E) -->

    <table class="line_bluedot"><tr><td></td></tr></table>
    <!----------------------------------------------------------------- MAIN End  ----------------------------------------------------------> 
</div>
<!-- wrap_result(E) -->
</form>
