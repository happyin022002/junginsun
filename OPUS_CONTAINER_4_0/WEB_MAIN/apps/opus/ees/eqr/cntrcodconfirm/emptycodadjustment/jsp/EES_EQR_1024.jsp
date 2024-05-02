<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1024.jsp
*@FileTitle  : MTY COD Confirmation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================*/
%>     
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1024Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1024Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         
    String strErrMsg = "";                     
    int rowCount     = 0;                       //DB ResultSet

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesEqr1024Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
     
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString()); 
    }
%>
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
    
    function test(){
        alert("33");
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="editRow">
<input type="hidden" name="editPort">
<input type="hidden" name="editIbFlag">
<input type="hidden" name="sh2RC">
<input type="hidden" name="n1stEtb">
<input type="hidden" name="yardcode">
<input type="hidden" name="session_user_id" value="<%= strUsr_id %>">

<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 	
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">   <!-- no TAB  -->
		<table> 
			<tbody>
				<tr>
                    <th width="40">VVD</th>
                    <td width="120">
                        <input type="text" value="CFXT0001E" id="vvd" name="vvd" style="width:85px;ime-mode:disabled" class="input1" value="" dataformat="engup" maxlength="9"><!--
                        --><button type="button" class="input_seach_btn" id="btn_vvd" name="btn_vvd"></button>
                    </td>
                    <th width="30">Lane</th>
                    <td width="45">
                        <input type="text" id="lane" name="lane" style="width:40px;" class="input2" value="" readonly>
                    </td>
                    <th width="30">Bay</th>
                    <td width="60">
                        <input type="text" id="bay" name="bay" style="width:55px;" class="input2" value="" readonly>
                    </td>
                    <th width="50">Version</th>
                    <td width="30">
                        <input type="text" id="version" name="version" style="width:30px;" class="input2" value="" readonly>
                    </td>
                    <th width="100">Update By / DT</th>
                    <td>
                        <input type="text" style="width:90px" id="userid" name="userid" value="<%= strUsr_id %>" class="input2" readOnly> / <input type="text" name="date" class="input2" style="width:80px" value="" readOnly>
                    </td>
				</tr> 
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_remove" id="btn_remove">Confirmation Delete</button>
		</div>
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<table class="line_bluedot"><tr><td></td></tr></table>
	
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button>
			<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
		</div>
		<script language="javascript">ComSheetObject('sheet2');</script>
	</div>
	
	<table class="line_bluedot"><tr><td></td></tr></table>
	
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_rowadd2" id="btn_rowadd2">Row Add</button>
			<button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Row Delete</button>
		</div>
		<script language="javascript">ComSheetObject('sheet3');</script>
	</div>
	
	<table class="line_bluedot"><tr><td></td></tr></table>
	
	<div class="grid2">
		<table>
			<tbody>
				<tr>
					<th width="200"><strong>Remark(s)</strong></th>    
               		<td><textarea  rows="2" name="remark" style="width:100%"></textarea></td>
               	</tr>
			</tbody>
		</table> 
	</div>
	
	<div class="grid_option_right">
		<button type="button" class="btn_etc" name="HRBTN" id="HRBTN"><span id="HRTEXT" style="CURSOR: hand;width:60px;text-align:left" onclick="javascript:popHRBTN();"></span></button>
		<button type="button" class="btn_etc" name="RMBTN" id="RMBTN"><span id="RMTEXT" style="CURSOR: hand;width:100px;text-align:left" onclick="javascript:popRMBTN();"></span></button>
		<button type="button" class="btn_etc" name="DMBTN" id="DMBTN"><span id="DMTEXT" style="CURSOR: hand;width:70px;text-align:left" onclick="javascript:popDMBTN();"></span></button>	
	</div>
</div>
</form>