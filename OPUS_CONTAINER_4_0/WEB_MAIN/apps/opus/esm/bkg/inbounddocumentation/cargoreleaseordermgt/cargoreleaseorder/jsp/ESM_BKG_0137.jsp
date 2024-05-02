<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0137
*@FileTitle  : Office Default From Setup
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
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0137Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0137Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         // error from server
    String strErrMsg = "";                      // error message
    int rowCount     = 0;                       // count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOff_cd        = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.FullReleaseOrderBC");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOff_cd = account.getOfc_cd();

        event = (EsmBkg0137Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        $('<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Delete</button>').appendTo("#btnArea");
        
        $('#btn_Delete').after($('#btn_Close'));
        
        document.getElementById("title").innerHTML = "Cargo Release Template";
        
        loadPage();
    }
</script>


<form name="form" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="office_cd" value="<%=strOff_cd %>">
<input type="hidden" name="qryFlag" value="">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
<input type="hidden" name="mainPage" value="<%=mainPage%>">

<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
		    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <table>
		        <tbody>
		        	<colgroup>
						<col width="30"/>					
						<col width="*" />				
					</colgroup> 
					<tr>
						<th>Office</th>
						<td><input type="text" name="office" id="office" style="width:120px;" class="input1" value="<%=JSPUtil.getNull(request.getParameter("office"))%>" maxlength="6" dataformat="engup" style="ime-mode:disabled"></td>			
					</tr>
				</tbody>
			</table>
		    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    
		    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <table>
		        <tbody>
					<colgroup>
						<col width="160"/>					
						<col width="30"/>					
						<col width="230"/>	
						<col width="30"/>	
						<col width="150"/>					
						<col width="*" />				
					</colgroup>
					<tr>
						<th class="sm pad_left_4">Delivery Drder Preview Form</th>
						<td class="sm"></td>
	                    <td class="sm pad_left_4"><input type="radio" name = "do_fom_prv_cd" id="do_fom_prv_cd" value="DO" class="trans" onclick="fnRadioCheck()" checked >&nbsp;D/O Form&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name = "do_fom_prv_cd" id="do_fom_prv_cd" value="BL" class="trans" onclick="fnRadioCheck()">&nbsp;B/L Form&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name = "do_fom_prv_cd" id="do_fom_prv_cd" value="EU" class="trans" onclick="fnRadioCheck()">&nbsp;EU Form</td>
						<td></td>
						<th>Delivery Order Language</th>
						<td><select style="width:120px;" name="locl_lang_flg" id="locl_lang_flg"><option value="Y" selected>English</option><option value="N">Local Language</option></select></td>
					</tr>
				</tbody>
			</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	   </div> 
	</div>
	<!-- opus_design_inquiry(E) -->
	
	<div class="wrap_result">
		<div class="opus_design_grid wFit">
			<div class="opus_design_inquiry sm">
				<table>
					<tr>
	                     <th width="150px">Address</th>
	                     <td>
	                     <textarea  rows="2" style="width:100%;resize:none;" name = "addr_ctnt" id="addr_ctnt" maxlength="4000" style="ime-mode:disabled"></textarea></td>
	                 </tr>
				</table>
				<table>
					<tr>
	                    <th width="150px">External Remark</th>
	                     <td>
	                     <textarea  rows="6" style="width:100%;resize:none;" name = "do_prn_rmk" id="do_prn_rmk" maxlength="4000" style="ime-mode:disabled"></textarea></td>
	                 </tr>
				</table>
				<table>
					<tr>
	                     <th width="150px">Authorization contents</th>
	                     <td>
	                     <textarea  rows="2" style="width:100%;resize:none;" name = "auth_ctnt" id="auth_ctnt" maxlength="4000" ></textarea></td>
	                 </tr>
				</table>
			</div>		
		</div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" hidden="true"> 
		    
		    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<%if(!mainPage.equals("true")){	%></div><%}%>
</form>
 