<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0760.jsp
*@FileTitle  : Confirm-Hold Notice Set-Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0760Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0760Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//strErrMsg
	int rowCount	 = 0;						//DB ResultSet rowCount

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String mainpage = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
    String strOfc_cd        = "";
    String strPopUp         = "";
    String strPreOfc_cd     = "";
    String strPrePod_cd     = "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.HoldNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
		mainpage = JSPUtil.getNull(request.getParameter("mainPage"));
        strPopUp     = JSPUtil.getParameter(request, "popUp");
        strPreOfc_cd = JSPUtil.getParameter(request, "ofc_cd");
        strPrePod_cd = JSPUtil.getParameter(request, "pod_cd");
        
		event = (EsmBkg0760Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
        document.form.ofc_cd.value = "<%="Y".equals(strPopUp)?strPreOfc_cd:strOfc_cd%>";
        document.form.pod_cd.value = "<%="Y".equals(strPopUp)?strPrePod_cd:"ALL"%>";
		
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd%>" id="usr_ofc_cd" />
<input type="hidden" name="hld_ntc_tp_cd" value="CF" id="hld_ntc_tp_cd" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" 		id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_ConfirmHoldNotice" 		id="btn_ConfirmHoldNotice">Hold Removal Notice</button><!--
		--><button type="button" class="btn_normal" name="btn_Delete"  		id="btn_Delete">Delete</button><%if(!"true".equals(mainpage)){ %><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><%} %>
	</div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="115"/>
					<col width="100"/>
					<col width="1"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th style="text-align:left;">Handling Office</th>
                    <td><input type="text" style="width:80px;" class="input1" name="ofc_cd" caption="Handling Office" maxlength="6" minlength="5" dataformat="engup" required="" /></td>
                    <th title="Port of Discharging">POD</th>
                    <td><input type="text" style="width:80px;" class="input1" name="pod_cd" caption="POD Code" maxlength="5" minlength="3" dataformat="engup" required="" /><!--
                        --><script type="text/javascript">ComComboObject("pod_cd_list", 1, 100, 0, 0);</script></td>                    
				</tr>	
				<tr class="line_bluedot" style="height:25px"><td colspan="4"></td></tr>
				<tr>
					<th class="sm" style="height:25px">Enclose B/L Copy</th>
                    <td class="sm pad_left_12"><input type="radio" class="trans" name="frm_eclz_obl_flg" value="Y" id="frm_eclz_obl_flg" />Yes&nbsp;&nbsp;&nbsp;<!--
						--><input type="radio" class="trans" name="frm_eclz_obl_flg" value="N" id="frm_eclz_obl_flg" />No</td>   
					<td colspan="2"></td>
                </tr>				
			</tbody>
		</table>
		
	<tr>
					<td>
						<table class="grid2">
							 <colgroup>						    	 
						         <col width="509px" />
						     </colgroup>

			<tbody>
				<tr><th>Address</th></tr>					
				<tr>
					<td><input typ	e="text" style="width:100%;ime-mode:disabled;" class="noinput" name="frm_addr_ctnt" maxlength="4000" id="frm_addr_ctnt" /> </td>
                </tr>				
			</tbody>
		</table>
		</td>
				</tr>
		
		<tr>
					<td>
						<table class="grid2">
							 <colgroup>						    	 
						         <col width="509px" />
						     </colgroup>

			<tbody>
				<tr><th>From</th></tr>					
				<tr>
					<td><input type="text" style="width:100%;ime-mode:disabled;" class="noinput" name="frm_snd_ofc_cntc_ctnt" maxlength="500" id="frm_snd_ofc_cntc_ctnt" /> </td>	
                </tr>				
			</tbody>
		</table>
		</td>
				</tr>
		
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab sm">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:none">
		<div class= "opus_design_inquiry">
			<table class="grid_2">
				<tbody>
					<tr><td align="center"  class="sm"><b>Important Notice</b></td></tr>					
					<tr>
						<td> <textarea cols="7" rows="17"style="width:100%;ime-mode:disabled;" caption="Important Notice" name="frm_t1_hld_rmk"></textarea></td>	
					</tr>				
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="tabLayer" style="display:inline">
		<div class= "opus_design_inquiry">
			<table class="grid_2">
				<tbody>
					<tr><td align="center"  class="sm"><b>Important Notice</b></td></tr>					
					<tr>
						<td><textarea cols="7" rows="17"style="width:100%;ime-mode:disabled;" caption="Important Notice" name="frm_t2_hld_rmk"></textarea></td>	
					</tr>				
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="tabLayer" style="display:none">
		<div class= "opus_design_inquiry">
			<table class="grid_2">
				<tbody>
					<tr><td align="center" class="sm"><b>Important Notice</b></td></tr>					
					<tr>
						<td><textarea cols="7" rows="17"style="width:100%;ime-mode:disabled;" caption="Important Notice" name="frm_t3_hld_rmk"></textarea></td>	
					</tr>				
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="tabLayer" style="display:none">
		<div class= "opus_design_inquiry">
			<table class="grid_2">
				<tbody>
					<tr><td align="center" class="sm"><b>Important Notice</b></td></tr>					
					<tr>
						<td><textarea cols="7" rows="17"style="width:100%;ime-mode:disabled;" caption="Important Notice" name="frm_t4_hld_rmk"></textarea></td>	
					</tr>				
				</tbody>
			</table>
		</div>
	</div>
	<div id="tabLayer" style="display:none">
		<div class= "opus_design_inquiry">
			<table class="grid_2">
				<tbody>
					<tr><td align="center" class="sm"><b>Important Notice</b></td></tr>					
					<tr>
						<td><textarea cols="7" rows="17"style="width:100%;ime-mode:disabled;" caption="Important Notice" name="frm_t5_hld_rmk"></textarea></td>	
					</tr>				
				</tbody>
			</table>
		</div>
	</div>
</div>
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>