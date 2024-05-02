<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0072.jsp
*@FileTitle  : Transportation Report & Code
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException = null;
	String strErrMsg = "";

	SignOnUserAccount account = null;
	String loginUserId = null;
	String loginUserCtrlOfcCd = null;
	try {
		account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		loginUserId = account.getUsr_id();
		loginUserCtrlOfcCd = account.getOfc_cd();
		
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
        loadPage();
    }
</script>
<form     method="post" name="form" onSubmit="return false;">
<input     type="hidden" name="f_cmd" />
<input     type="hidden" name="SELECTED_VNDR_SEQ" />
<input     type="hidden" name="SELECTED_CTRL_OFC_CD" />
<input     type="hidden" name="SELECTED_LOC_CD" />
<input     type="hidden" name="LOGIN_USER_OFC_CD"     value="<%=loginUserCtrlOfcCd%>"/>
<input     type="hidden" name="LOGIN_USER_ID"         value="<%=loginUserId%>" />
<input     type="hidden" name="FAX_EMAIL_INDICATOR" />
<input     type="hidden" name="iPage" />

<div class="page_title_area clear">
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve1" id="btn_retrieve1">Retrieve</button><!-- 
         --><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">New</button>
    </div>
    <div class="location">
        <span id="navigation"></span>
    </div>
</div>

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <table>
            <colgroup>
                <col width="150" />
                <col width="50" />
                <col width="150" />
                <col width="150" />
                <col width="100" />
                <col width="80" />
                <col width="80" />
                <col width="80" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr class="h23">
                    <th>Service Provider Code</th>
                    <td><input  class="input1" name="combo_svc_provider" type="text" style="width:80px;" maxlength="6" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)' dataformat="engup"><!-- 
                     --><button type="button" class="input_seach_btn" name="btn_provider" id="btn_provider"></button></td>
                    <th>Service Provider Name</th>
                    <td style="padding-left:3;"><input name="svc_provider"  type="text" style="width:150px;" value="" readonly  class="input2"  title="This inputbox cant't write" dataformat="engup"></td>
                    <th>Control Office</th>
                    <td><input name="control_office_cd" type="text" style="width:80px;" value="" maxlength="6" dataformat="engup"><!--
                     --><button type="button" class="input_seach_btn" name="btn_control_office" id="btn_control_office"></button></td>
                    <th>Location</th>
                    <td align="right"><input name="location_cd" type="text" style="width:80px;" value="" maxlength="5" dataformat="engup"><!-- 
                     --><button type="button" class="input_seach_btn" name="btn_location" id="btn_location"></button></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="wrap_result">    
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
         <!-- opus_grid_btn(S) -->
      <!--   <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_retrieve2" id="btn_retrieve2">Retrieve</button>
        </div> -->
        <script language="javascript">ComSheetObject('sheet1');</script>
    </div>
    <div style="height:10px"></div>
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_fax_row_add" id="btn_fax_row_add">Fax Row Add</button>
            <button type="button" class="btn_normal" name="btn_eml_row_add" id="btn_eml_row_add">Email Row Add</button>
            <button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
        </div>
        <div class="layout_vertical_2" style="width:49%;">
            <script language="javascript">ComSheetObject('sheet2');</script>
        </div>
        <div class="layout_vertical_2 align_center" style="width:2%;">&nbsp;</div>
        <div class="layout_vertical_2" style="width:49%">
            <script language="javascript">ComSheetObject('sheet3');</script>
        </div>
    </div>
</div>
<div class="header_fixed"></div>
</form>
