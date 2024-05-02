<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0029.jsp
*@FileTitle  : Target VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
* SJH.20150106.MOD : coaPeriod1, VVD
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.coa.common.Utils" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%
    Exception serverException   = null;         //Error from server
    String strErrMsg    = "";                               //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0029");
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

<div style="height:0px">
<iframe height="0" width="0" name="frmHidden"></iframe>
<iframe height="0" width="0" name="frmHidden2"></iframe>
</div>
<form method="post" name="form"  id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_flag">
<input type="hidden" name="f_sRow">
<input type="hidden" name="f_trd_cd"> <!-- trade code for sheet trade combo or form trade combo -->
<input type="hidden" name="f_type_cd"><!-- type code -->

<input type="hidden" name="fm_date" value="20090101"><!-- from date for batch -->
<input type="hidden" name="to_date" value="99991231"><!-- end date for batch -->
<input type="hidden" name="f_chkprevcre" value="N">
<input type="hidden" name="sXml" value="<%=xml%>"> 

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
        --><button type="button" class="btn_normal" name="btn_Save"   id="btn_Save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_Auto"   id="btn_Auto">BSA Creation</button><!--
        --><button type="button" class="btn_normal" name="btn_Downexcel"   id="btn_Downexcel">Down Excel</button>
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
<div class="wrap_search"">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <table>
             <colgroup>
                <col width="670"  />
                <col width="110"  />
                <col width="*" />
            </colgroup> 
            <tbody>
                <tr>
                    <td><script type="text/javascript">coaPeriod1("1","");</script></td>
                    <th title="Vessel Voyage Direction">VVD</th>
                    <td><input type="text" name="f_vsl_cd" id="f_vsl_cd" style="width:70px;text-align:center;" maxlength="4" dataformat="engup" onClick="ComAddSeparator(this);"  onKeyUp="ComKeyEnter('f_skd_voy_no');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" onBlur="upper(this);">
                        <input type="text" name="f_skd_voy_no" id="f_skd_voy_no" style="width:70px;text-align:center;" maxlength="4" dataformat="num" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_dir_cd');" onkeyPress="ComKeyOnlyNumber(window);" onFocus="this.select();" >
                        <input type="text" name="f_dir_cd" id="f_dir_cd" style="width:30px;text-align:center;" maxlength="1" dataformat="engup" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_year');" onKeyPress="ComKeyOnlyAlphabet('upper');" onFocus="this.select();" onBlur="upper(this);"></td>
                    </td>
                </tr>
                </tbody>
               </table>
                <table class="line_bluedot"><tr><td colspan="6"></td></tr> </table> 
               <table>
                <colgroup>
                <col width="40"  />
                <col width="135" />
                <col width="57"  />
                <col width="135" />
                <col width="50"  />
                <col width="140" />
                <col width="60"  />
                <col width="135" />
                <col width="25"  />
                <col width="110" />
                <col width="*" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>Trade</th>
                    <td><script type="text/javascript">ComComboObject('f_seltrade',1, 100 , 0 )</script></td>
                    <th>R/Lane</th>
                    <td><script type="text/javascript">ComComboObject('f_selrlane',1, 100 , 0 )</script></td>
                    <th>S/Lane</th>
                    <td><script type="text/javascript">ComComboObject('f_selslane',1, 100 , 0 )</script></td>
                    <th>Direction</th>
                    <td><script type="text/javascript">ComComboObject('f_seldir',1, 80 , 0 )</script></td>
                    <th>IOC</th>
                    <td><script type="text/javascript">ComComboObject('f_selioc',1, 80 , 0 )</script></td>
                    <td><input type="checkbox" name="f_chkdel" id="f_chkdel" value="Y" class="trans" onClick="chgViewColumn();"><label for="f_chkdel">Deleted Data</label>
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
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_Rowadd" id="btn_Rowadd">Row Add</button><!-- 
             --><button type="button" class="btn_normal" name="btn_Creation" id="btn_Creation">Creation</button><!-- 
             --><button type="button" class="btn_normal" name="btn_Tsqty" id="btn_Tsqty">Create T/S Q'ty</button><!-- 
             --><button type="button" class="btn_normal" name="btn_Skdinquiry" id="btn_Skdinquiry">SKD Inquiry</button><!-- 
             --><button type="button" class="btn_normal" name="btn_Vvdcheck" id="btn_Vvdcheck">VVD Check List</button><!-- 
             --><button type="button" class="btn_normal" name="btn_Apply_bsa" id="btn_Apply_bsa">Apply BSA 0</button> 
			 <div id="div_zoom_in" style="display:inline"><button type="button" class="btn_down mar_left_4" id="bu_zoom_in" name="bu_zoom_in" title="Zoom In (+)"></button></div>
			 <div id="div_zoom_out" style="display:none"><button type="button" class="btn_down mar_left_4" id="bu_zoom_out" name="bu_zoom_out" title="Zoom In (-)"></button></div>
		</div>
        
        <!-- opus_design_btn(E) -->
        <script type="text/javascript">ComSheetObject('sheet1');</script></div>
</div>
    <!-- opus_design_grid(E) -->
<!-- wrap_result(E) -->
</form>
