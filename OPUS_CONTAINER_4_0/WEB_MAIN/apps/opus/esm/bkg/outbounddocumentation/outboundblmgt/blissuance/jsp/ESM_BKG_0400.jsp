<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0400.jsp
*@FileTitle  : O.B/L Surrender Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0400Event"%>

<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmBkg0400Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    
    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String strOfc_cd = "";
    Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLIssuance");
    boolean isPopUp = ("Y".equals(JSPUtil.getParameter(request, "isPopUp")) )?true:false;;
    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
        event = (EsmBkg0400Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    } catch (Exception e) {
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

<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows"> 
<input type="hidden" name="strUsr_id" id="strUsr_id" value="<%=strUsr_id%>"> 
<input type="hidden" name="strOfc_cd" id="strOfc_cd" value="<%=strOfc_cd%>"> 
<!-- 개발자 작업    --> 
<input type="hidden" name="bkg_no" id="bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'> 
<input type="hidden" name="bl_no" id="bl_no" value='<%=JSPUtil.getParameter(request, "bl_no")%>'> 
<input type="hidden" name="application_date" id="application_date" />
<input type="hidden" name="frm_sheet1_obl_srnd_flg" id="frm_sheet1_obl_srnd_flg" />
<input type="hidden" name="frm_sheet1_obl_iss_knt" id="frm_sheet1_obl_iss_knt" />
<input type="hidden" name="frm_sheet1_obl_rlse_flg" id="frm_sheet1_obl_rlse_flg" />
<input type="hidden" name="frm_sheet1_bl_tp_cd" id="frm_sheet1_bl_tp_cd" />
<input type="hidden" name="frm_sheet1_cust_to_ord_flg" id="frm_sheet1_cust_to_ord_flg" />
<input type="hidden" name="frm_sheet1_del_cd" id="frm_sheet1_del_cd" />
<input type="hidden" name="com_mrdTitle" value="" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="setupfocoblflag" value="N" id="setupfocoblflag" />
<input type="hidden" name="inquery_only" id="inquery_only" value='<%=JSPUtil.getParameter(request, "inquery_only")%>'> 
<!-- OUTER - POPUP (S)tart -->

<!-- 제목(S) -->
<%if(!isPopUp){%>
<div class="page_title_area clear">
    <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->

    <!-- btn_div(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" id="btn_retrieve" name="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_new">New</button><!--
        --><button type="button" class="btn_normal" name="btn_save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_cancel">Cancel</button>
    </div>
    <!-- btn_div(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<%} else {%>
 <div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title"><span>O.B/L Surrender Information</span></h2>
        <!-- page_title(E) -->
            
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" id="btn_retrieve" name="btn_retrieve">Retrieve</button><!--
            --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
            --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
            --><button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Cancel</button><!--
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
    </div>
    <!-- page_title_area(E) -->
</div>
<%}%>
<!-- 제목(E) -->
<%if(isPopUp){%><div class="layer_popup_contents"><%}%>
<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">

        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="77"  />
                <col width="274" />
                <col width="85"  />
                <col width=""      />
            </colgroup>
            <tbody>
                <tr>
                    <th>Booking No.</th>
                    <td>
                        <input type='text' style='width: 110px;' dataformat="engup" maxlength="13" name='frm_sheet1_bkg_no' id='frm_sheet1_bkg_no'  value='<%=JSPUtil.getParameter(request, "bkg_no")%>' class='input1'><!--
                        --><button type="button" class="btn_down_list" name="pop_bkg_no" id="pop_bkg_no"></button><!--
                        --><div id="span_bkg_no" name="span_bkg_no" style="position:absolute;z-index:999;display:none;"></div>
                    </td>
                    <th>B/L No.</th>
                    <td>
                        <input type='text' style='width: 110px;' dataformat="engup" maxlength="13" name='frm_sheet1_bl_no' id='frm_sheet1_bl_no' value='' class='input1'><!--
                        --><button type="button" class="btn_down_list" name="pop_bl_no" id="pop_bl_no"></button><!--
                        --><div id="span_bl_no" name="span_bl_no" style="position:absolute;z-index:999;display:none;"></div>
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
	<div class="opus_design_grid ">
	    <!-- opus_design_inquiry(S) -->
	    <div class="opus_design_inquiry wFit">
	        <table>
	            <colgroup>
	                <col width="77"  />
	                <col width="120" />
	                <col width="33"  />
	                <col width="120" />
	                <col width="85"  />
	                <col width="120" />
	                <col width="43"  />
	                <col width=""      />
	            </colgroup>
	            <tbody>
	                <tr>
	                    <th>Office</th>
	                    <td><input type="text" style="width: 80px;" class="input2" value="" name="frm_sheet1_obl_rdem_ofc_cd" id="frm_sheet1_obl_rdem_ofc_cd" readonly></td>
	                    <th>Date</th>
	                    <td><input type="text" style="width: 80px;" maxlength="10" dataformat="ymd" style="ime-mode:disabled" class="input" value="" name="frm_sheet1_obl_rdem_dt" id="frm_sheet1_obl_rdem_dt"></td>
	                    <th>No. of O.B/L</th>
	                    <td><input type="text" style="width: 80px;" maxlength="3" dataformat="num" value="" name="frm_sheet1_obl_rdem_knt" id="frm_sheet1_obl_rdem_knt" class="input"></td>
	                    <th>Issuer</th>
	                    <td><input type="text" style="width: 80px;" class="input2" value="" name="frm_sheet1_obl_rdem_usr_id" id="frm_sheet1_obl_rdem_usr_id" readonly></td>
	                </tr>
	                <tr>
	                    <td class="height_5"></td>
	                </tr>
	                <tr>
	                    <th>Remark(s)</th>
	                    <td  colspan = "7">
	                        <textarea style="width: 100%; height: 70px; resize:none" name="frm_sheet1_diff_rmk" id="frm_sheet1_diff_rmk"></textarea>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan = "8" align="right">
	                        <button type="button" class="btn_etc" name="btn_clausesetup" id="btn_clausesetup">Clause Setup</button><!--
	                        --><button type="button" class="btn_etc" name="btn_preview" id="btn_preview">Preview</button><!--
	                        --><button type="button" class="btn_etc" name="btn_print" id="btn_print">Print</button><!--
	                        --><button type="button" class="btn_etc" name="btn_faxemail" id="btn_faxemail">Fax/E-mail</button>
	                    </td>
	                </tr>
	            </tbody>
	        </table>
	    </div>
	    <!-- opus_design_inquiry(E) -->
		<div style="display: none;" id="mainTable">
	   	 	<script type="text/javascript">ComSheetObject('sheet1');</script>
	   	</div>
	</div>
</div>

<%if(isPopUp){%></div><%}%>
</form>