<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName   : ESM_COA_4012.jsp
*@FileTitle  : Pendulum Service Setup
*@author     : SJH
*@version    : 1.0
*@since      : 2015/10/01 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa4012Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	Exception serverException   = null;         //Error from server
	String strErrMsg    = "";                               //Error message
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_4012");
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
<input type="hidden" name="f_header" id="f_header" />
<input type="hidden" name="f_selslane" value="">
<input type="hidden" name="f_seldir" value="">
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
        <button type="button" class="btn_accent" name="btn_ApplytolaneTt" id="btn_ApplytolaneTt">Apply to Lane T/T</button><!-- 20151201.MOD -->
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
                <col width="50"  />
                <col width="250"  />
                <col width="100" />
                <col width="100"  />
                <col width="60"  />
                <col width="100" />
                <col width="50"  />
                <col width="" />
            </colgrou> 
            <tbody>
                <tr>
                    <th>Period</th>
                    <td><!-- 
	                --><input class="input1" type="text" name="f_from_dt" id="f_from_dt" style="width:75px;text-align:center;" maxlength="8" autocomplete="off" onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
	                         onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-');this.select();" value=""><!-- 
	                --><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>~&nbsp;<!-- 
	                --><input  type="text" name="f_to_dt" id="f_to_dt" style="width:75px;text-align:center;" maxlength="8" autocomplete="off"
	                          onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
	                         onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-'); this.select();" value="" ><!-- 
	                --><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button><!-- 
	                --></td>
                    <th>Service Lane</th>
                    <td><script language="javascript">ComComboObject('f_slan_cd',1, 110 , 0 )</script></td>
                    <th>Dir.</th>
                    <td><script type="text/javascript">ComComboObject('f_dir_cd', 1, 60 , 0 )</script></td>
                    <th>VVD</th>
                    <td>
	                    <input type="text" name="f_vsl_cd" id="f_vsl_cd" style="width:70px;text-align:center;" maxlength="4" dataformat="engup" onClick="ComAddSeparator(this);"  onKeyUp="ComKeyEnter('f_skd_voy_no');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" onBlur="upper(this);">
                        <input type="text" name="f_skd_voy_no" id="f_skd_voy_no" style="width:70px;text-align:center;" maxlength="4" dataformat="num" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_dir_cd');" onkeyPress="ComKeyOnlyNumber(window);" onFocus="this.select();" >
                        <input type="text" name="f_dir" id="f_dir" style="width:30px;text-align:center;" maxlength="1" dataformat="engup" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_year');" onKeyPress="ComKeyOnlyAlphabet('upper');" onFocus="this.select();" onBlur="upper(this);">
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

    <!----------------------------------------------------------------- MAIN Start --------------------------------------------------------->
    <div class="opus_design_grid"  id="mainTable">
        <script type="text/javascript">ComSheetObject('sheet1');</script>
        <div class="opus_design_btn" style="text-align:right; margin-top:4px;">        	
            <button type="button" class="btn_accent" name="btn_Detail" id="btn_Detail">Detail</button>
            <button type="button" class="btn_accent" name="btn_Rowadd1" id="btn_Rowadd1">Row Add</button>
            <button type="button" class="btn_accent" name="btn_Save1" id="btn_Save1">Save</button>
            <button type="button" class="btn_accent" name="btn_DownExcel1" id="btn_DownExcel1">Down Excel</button>
        </div>                           
    </div>
    <!-- opus_design_grid(E) -->

    <table class="line_bluedot"><tr><td></td></tr></table>

    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid"  id="mainTable">
    	<!-- <h3 class="title_design pad_btm_8">ECC Status</h3> -->
        <script type="text/javascript">ComSheetObject('sheet2');</script>
        <!-- SJH.20141222.MOD -->
        <div class="opus_design_btn" style="text-align:right; margin-top:4px;">            
            <button type="button" class="btn_accent" name="btn_creation" id="btn_creation" disabled>Creation</button>
            <button type="button" class="btn_accent" name="btn_Rowadd2" id="btn_Rowadd2" disabled>Row Add</button>
            <button type="button" class="btn_accent" name="btn_Save2" id="btn_Save2" disabled>Save</button>
            <button type="button" class="btn_accent" name="btn_DownExcel2" id="btn_DownExcel2" disabled>Down Excel</button>
        </div>            
    </div>
    <!-- opus_design_grid(E) -->

    <table class="line_bluedot"><tr><td></td></tr></table>
    <!----------------------------------------------------------------- MAIN End  ----------------------------------------------------------> 
</div>
<!-- wrap_result(E) -->
</form>
