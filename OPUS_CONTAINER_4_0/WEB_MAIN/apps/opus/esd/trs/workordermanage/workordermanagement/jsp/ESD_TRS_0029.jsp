<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0029.jsp
*@FileTitle  : BFI Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/17
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.event.EsdTrs0029Event"%>
<%
    EsdTrs0029Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         
    DBRowSet rowSet   = null;                            
    String strErrMsg = "";                              
    int rowCount     = 0;                                
    SignOnUserAccount account= null;
	String userOfcCd = "";
    try {
        account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        event = (EsdTrs0029Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
    userOfcCd = account.getOfc_cd();
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

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="wo_no_a">
<input type="hidden" name="temp_not_sp">
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
        --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">DownExcel</button><!-- 
        --><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">New</button><!-- 
        --><button type="button" class="btn_normal" name="btn_bfi" id="btn_bfi" disabled >Send BFI</button><!--  
        --><button type="button" class="btn_normal" name="btn_downexcel_inv" id="btn_downexcel_inv">DownExcel For Invoice</button>
    </div>
    <div class="location">
        <span id="navigation"></span>
    </div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit" id="MiniLayer">
	    <!--  biz_1 (S) -->
	    <table>
	        <colgroup>
	            <col width="155" />
	            <col width="130" />
	            <col width="150" />
	            <col width="150" />
	            <col width="130" />
	            <col width="130" />
	            <col width="80"  />
	            <col width=""    />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th>W/O Creation Office</th>
	                <td>
	                    <input required name="cre_ofc_cd" type="text"  maxlength='6' style="width:100px;" value="<%=userOfcCd%>" dataformat="engup" caption="W/O Creation Office" class="input1" onchange="javascript:disableSendBFI();">
	                	<button type="button" class="input_seach_btn" name="btns_wo_issue_office" id="btns_wo_issue_office" onClick="ofc_OnPopupClick()"></button>
	                </td>
	                <th>Date</th>
	                <td>
	                    <input required name="fm_dt" type="text" maxlength="8" style="width:75px;" class="input1" dataformat="ymd" caption="From Date" onchange="javascript:disableSendBFI();">~
	                    <input required name="to_dt" type="text" maxlength="8" style="width:75px;" class="input1" dataformat="ymd" caption="To Date" onchange="javascript:disableSendBFI();">
	                    <button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
	                </td>
	                <th>Service Provider</th>
	                <td colspan="3">
	                    <input name="vndr_seq" id="vndr_seq" type="text" dataformat="num" style="width:250px;" maxlength='200' otherchar="," onchange="javascript:disableSendBFI();"><!--
	                      --><button type="button" class="multiple_inq ir" name="btns_vndr_seq" id="btns_vndr_seq"></button>
	                      <input name="not_sp" id="not_sp" type="checkbox" value="Y" onchange="javascript:disableSendBFI();"><label for="not_sp"><strong>Exclude S/P</strong></label>
	                </td>
	            </tr>
	         </tbody>
	    </table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" >
	    <script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" style="visibility:none; width:780px;" >
	    <script language="javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<div class="header_fixed"></div>
</form>
