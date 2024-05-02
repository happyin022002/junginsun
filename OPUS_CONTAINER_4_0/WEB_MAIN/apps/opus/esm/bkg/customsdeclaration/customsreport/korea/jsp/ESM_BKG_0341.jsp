<%--
=========================================================
*right(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0341.jsp
*@FileTitle  : Manifest Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<script type="text/javascript">

    function setupPage(){  

        loadPage();
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="event_no" value="0341">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="mrn_bl_ts_cd">

<!-- 제목 -->
<div class="page_title_area clear">
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->

        <!-- btn_div -->
   <div class="opus_design_btn">
         <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
         --><button type="button" class="btn_normal" name="btn_formprint" id="btn_formprint">Form Print</button><!-- 
         --><button type="button" class="btn_normal" name="btn_listprint" id="btn_listprint">Down Excel</button>
   </div>

   <!-- page_location(S) -->
   <div class="location">
        <span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
<!-- 검색영역 -->
<div class="opus_design_inquiry">       
    <table> 
        <colgroup>
            <col width="55px"  />
            <col width="150px" />
            <col width="30px"  />
            <col width="130px" />
            <col width="65px"  />
            <col width="150px" />
            <col width="65px"  />
            <col width=""      />
        </colgroup>             
        <tbody>
            <tr>
                <th class="sm"><input type="radio" name="search_type" checked value="vvd" class="trans">VVD</th>
                <td class="sm">
                    <input type="text" style="width:100px" name="vvd" class="input1" style="ime-mode:disabled; text-align:center;" dataformat="engup" maxlength="9">
                </td>
                <th class="sm">PORT</th>
                <td class="sm">
                    <input type="text" style="width:70px" name="port_cd" class="input1" style="ime-mode:disabled; text-align:center;" dataformat="engup" maxlength="5" >
                </td>
                <th class="sm"><input type="radio" name="search_type" value="mrn" class="trans">MRN</th>
                <td class="sm">
                    <input type="text" style="width:100px" name="mrn_no" class="input1" style="ime-mode:disabled; text-align:center;" dataformat="engup" maxlength="10">&nbsp;-&nbsp;
                    <input type="text" style="width:20px" name="mrn_chk_no" class="input2" ReadOnly>
                    <button type="button" name="btn_mrn_search" id="btn_mrn_search" class="input_seach_btn"></button>
                </td>
                <th>Mode</th>
                <td><%=JSPUtil.getCodeCombo("io_bnd_cd", "", "", "CD02362", 0, "")%></td>
            </tr>
            <tr>
                <th>B/L No.</th>
                <td>
                    <input type="text" style="width:100px" name="bl_no" class="input" style="ime-mode:disabled; text-align:center;" dataformat="engup" maxlength="12">
                </td>
                <th>MSN</th>
                <td>
                    <input type="text" style="width:70px" name="msn_no" class="input" style="ime-mode:disabled; text-align:center;" dataformat="num" maxlength="4">
                </td>
                <th>Type</th>
                <td colspan = "3">
                    <%=new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil().getCstmsCodeCombo("mrn_bl_ts_cd2", "KR", "MRN_BL_TS_CD","")%>
                </td>
                <script>ComAddBeginComboItem(form.mrn_bl_ts_cd2,"All","")
                        ComSetObjValue(form.mrn_bl_ts_cd2,'' );</script> 
            </tr>
        </tbody>
    </table> 
</div>
</div>
<!-- 검색영역 -->
<!-- 시트영역 -->

<div class="wrap_result">
<div class="opus_design_grid">  
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
</div>
<!-- 시트영역 -->

</form>

