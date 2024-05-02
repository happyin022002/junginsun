<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0014.jsp
*@FileTitle  : Service Order Creation - Chassis or Genset
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
--%>

<%@page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
    Exception serverException   = null;
    String strErrMsg = "";
    SignOnUserAccount account = null;
    try {
        account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
    String today = DateTime.getFormatString("yyyyMMdd");
    String beforeOneMonth = DateTime.addDays(today, -30);
%>

<script type="text/javascript"> 
	var today = '<%=today%>';
	var beforeOneMonth = '<%=beforeOneMonth%>';
	<%= BizComUtil.getIBCodeCombo("chss_eq_tpsz_cd", "01", "CHASSIS", 1, "")%>
	<%= BizComUtil.getIBCodeCombo("gen_eq_tpsz_cd", "01", "GENSET", 1, "")%>
    <%= JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "", "CD00283", 0, "")%>
    <%= JSPUtil.getIBCodeCombo("trsp_so_cmb_tp_cd", "", "CD00762", 0, "")%>
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
        loadPage();
        setKindEnabled();
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="TRSP_SO_TP_CD" id="TRSP_SO_TP_CD" />
<input type="hidden" name="TRSP_SO_STS_CD" id="TRSP_SO_STS_CD" />
<input type="hidden" name="TRSP_SO_EQ_KIND" id="TRSP_SO_EQ_KIND" />
<input type="hidden" name="EQ_TPSZ_CD" id="EQ_TPSZ_CD" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button><!--
        --><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">Reset</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="58"  />
                <col width="180" />
                <col width="70"  />
                <col width="4"   />
                <col width="70"  />
                <col width="251" />
                <col width="4"   />
                <col width="100" />
                <col width="60" />
                <col width="60" />
                <col width="130" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr style="height:30px">
                    <th>Kind</th>
                    <td class="sm" colspan="2" align="center"><input type="radio" name='kind_chassis' id='kind_chassis' class="trans" value="Z" onClick='setKindEnabled()'  checked><!--
                        --><label for="kind_chassis">Chassis</label><!--
                        --><input type="radio" name='kind_chassis' id='kind_chassis1' value="G" onClick='setKindEnabled()' class="trans"><!--
                        --><label for="kind_chassis1">Genset</label>
                    </td>
                    <td></td>
                    <td class="sm" colspan="2" align="center"><input type="radio" name='kind_hire' id='kind_hire' class="trans" value="D" onClick='setKindEnabled()' checked><!--
                        --><label for="kind_hire">Drayage</label><!--
                        --><input type="radio" value="N" name='kind_hire' id='kind_hire1' class="trans" onClick='setKindEnabled()'><!--
                        --><label for="kind_hire1">On Hire</label><!--
                        --><input type="radio" value="F" name='kind_hire' id='kind_hire2' class="trans" onClick='setKindEnabled()'><!--
                        --><label for="kind_hire2">Off Hire</label>
                    </td>
                    <td></td>
                    <td class="sm" colspan="4" align="center"><input type="radio" class="trans" name='kind_manual' id='kind_manual1' value="manual" onClick='setKindEnabled();' checked><!--
                        --><label for="kind_manual1">Manual</label><!--
                        --><input type="radio" value="from_eq_master" name='kind_manual' id='kind_manual2' onClick='setKindEnabled();' class="trans"><!--
                        --><label for="kind_manual2">From EQ Master</label>
                    </td>
                    <td></td>
                </tr>
                <tr><td colspan="12"></td></tr>
                <tr>
                    <th></th>
                    <td class="sm" colspan="5" align="center"><input type="radio" class="trans" name='kind_bundle' id='kind_bundle1' value="single_unit" onClick='setKindEnabled();' checked><!--
                        --><label for="kind_bundle1">Single Unit</label><!--
                        --><input type="radio" name='kind_bundle' id='kind_bundle2' value="bundle_stack" class="trans"onClick='setKindEnabled();'><!--
                        --><label for="kind_bundle2">Bundle-Stack</label><!--
                        --><input type="radio" name='kind_bundle' id='kind_bundle3' value="bundle_flatbed" class="trans"onClick='setKindEnabled();'><!--
                        --><label for="kind_bundle3">Bundle-Flatbed</label>
                    </td>
                    <td></td>
                    <th>Unit</th>
                    <td><select name="bundle_unit" id="bundle_unit" style="width:60px;" onChange="">
                            <option value='2'>2</option>
                            <option value='3'>3</option>
                            <option value='4'>4</option>
                            <option value='5'>5</option>
                            <option value='6'>6</option>
                            <option value='7'>7</option>
                            <option value='8'>8</option>
                            <option value='9'>9</option>
                        </select>
                    </td>
                    <th>SET</th>
                    <td><input name="bundle_set" id="bundle_set" type="text" style="width:100px;" onChange='checkNumber(this, true);'maxlength=6></td>
                    <td></td>
                </tr>
                <tr><td colspan="12"></td></tr>
                <tr>
                    <th>Quantity</th>
                    <td><input name="unit_qty" id="unit_qty" type="text" style="width:100px" onBlur='checkNumber(this, true);' dataformat="engup"></td>
                    <th colspan="3">On Hire Creation Date </th>
                    <td><input name="fmdate" id="fmdate" type="text" style="width:75px;" value="<%=beforeOneMonth%>" onfocus="javascript:delHypen(this);" onblur="javascript:delHypen(this); getDateBetween(this);"  dataformat="ymd"  maxlength=8>~ <input name="todate" id="todate" type="text" style="width:75px;" value="<%=today%>" onFocus="javascript:delHypen(this);" onBlur="javascript:delHypen(this);"  dataformat="ymd" maxlength=8><!--
                        --><button type="button" class="calendar ir" name="search_hiredate" id="search_hiredate"></button>
                    </td>
                    <td></td>
                    <th>On Hire Yard</th>
                    <td colspan="5"><input name="hire_loc" id="hire_loc" type="text" style="width:61px" onChange='getComboList(this);' onKeyup='enterCheck(this)' maxlength=5 dataformat="engup"><!--
                        --><script type="text/javascript">ComComboObject('hire_yd', 1, 60, 0);</script><!--
                        --><button type="button" class="input_seach_btn" name="btns_search" id="btns_search"></button>
                    </td>
                </tr>
            </tbody>
        </table>
        <!--  biz_1   (E) -->   
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" >
        <!-- opus_grid_btn(S) -->
        <div class="opus_design_btn"><!-- 
             --><button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!-- 
             --><button type="button" class="btn_normal" name="btng_delete" id="btng_delete">Delete</button><!-- 
             --><button type="button" class="btn_normal" name="btng_fillineq" id="btng_fillineq">File in EQ No.</button><!-- 
             --><button type="button" class="btn_normal" name="btng_multipleapply" id="btng_multipleapply">Multiple Apply</button><!-- 
             --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!-- 
             --><button type="button" class="btn_normal" name="btng_socreation" id="btng_socreation">S/O Creation</button><!-- 
             --><button type="button" class="btn_normal" name="btng_woissue" id="btng_woissue">W/O Issue</button>
        </div>
        <!-- opus_grid_btn(E) -->

        <script type="text/javascript">ComSheetObject('sheet');</script>
        <div style="display:none">
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
        <!-- align_right(S) -->
        <div class="align_right mar_top_4">
            <strong>Unit</strong>
            <select name="bundle2_unit" id="bundle2_unit" style="margin-left:3px">
                <option value='2'>2</option>
                <option value='3'>3</option>
                <option value='4'>4</option>
                <option value='5'>5</option>
                <option value='6'>6</option>
                <option value='7'>7</option>
                <option value='8'>8</option>
                <option value='9'>9</option>
            </select><!--
            --><button type="button" class="btn_etc" name="btng_bundling" id="btng_bundling">Bundling</button><!--
            --><button type="button" class="btn_etc" name="btng_unbundling" id="btng_unbundling">Unbundling</button>
        </div>
    </div>
</div>
</form>

<form name='woForm' method='POST' action='ESD_TRS_0023.screen?parentPgmNo=ESD_TRS_M001'>
<input type='hidden' name='trsp_so_ofc_cty_cd'>
<input type='hidden' name='trsp_so_seq'>
<input type='hidden' name='eq_mode' value='CG'>
<input type="hidden" name="sysCommUiTitle" value="Issue">
<input type="hidden" name="pgmNo" value="ESD_TRS_0023">
<input type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
</form>
