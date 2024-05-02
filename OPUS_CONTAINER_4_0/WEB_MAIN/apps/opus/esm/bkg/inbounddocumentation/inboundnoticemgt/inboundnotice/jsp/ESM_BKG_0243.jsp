<% 
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0243
*@FileTitle  : Arrival Info. Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0243Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%
	EsmBkg0243Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_email	    = "";
	String strOfc_cd    = "";
	
	String strPodCd = "";
    String code = "";
    String value = "";
	
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strUsr_email = account.getUsr_eml();
	    strOfc_cd = account.getOfc_cd();
	    strPodCd = StringUtil.xssFilter(StringUtil.xssFilter(request.getParameter("pod_cd")));
	    
	   
		event = (EsmBkg0243Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<%
String[] arrColNames = new String[]{"vsl_nm","vvd","pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","an_fom_cd","chn_agn_cd","diff_rmk","ntc_rvis_flg","bkg_no","vsl_cd","skd_voy_no","skd_dir_cd","pod_cd"};
int x = 0;
%>

<script type="text/javascript">
	var strUsr_nm    = "<%=strUsr_nm %>";
	var strUsr_email = "<%=strUsr_email %>";
	var strOfc_cd    = "<%=strOfc_cd %>";
	
	var arrColValues = new Array(<%=arrColNames.length%>);
	<%
	for(int i=0;i<arrColNames.length;i++){
	%>
		arrColValues[<%=i%>] = "<%=JSPUtil.getNull(StringUtil.xssFilter(request.getParameter(arrColNames[i])))%>";		
	<%
	}
	%>
	
    var evtCode = "-|<%=code %>";
    var evtValue = " |<%=value %>";

	function setupPage(){
		loadPage();
	}
	

</script>
 <script>
<%--=OfficeCodeMgr.getOfficeCodeListToJS("000004", "BKG")--%> 
<%--=OfficeCodeMgr.getOfficeCodeListToJS("000005", "BKG")--%> 
</script> 

<form name="form">
<input name="f_cmd" id="f_cmd" type="hidden" />
<input type="hidden" name="pagerows" id="pagerows" value="<%=pageRows %>">
<input type="hidden" name="ofc_cd" id="ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="pod_cd" id="pod_cd" value="<%=strPodCd %>">
<input type="hidden" name="row" id="row" value="<%= StringUtil.xssFilter(request.getParameter("row"))%>"></input>

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Arrival Info. Setting</span></h2>
		<!-- page_title(E) -->
		
		<div class="opus_design_btn">
			 <button type="button" class="btn_accent" name="btn_setup_arrival_info" id="btn_setup_arrival_info">Setup Arrival Info.</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
			
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">	
		<div class="opus_design_grid">
			<div class="opus_design_inquiry wFit">
				<div class="layout_wrap">
					<div class="layout_vertical_2 pad_rgt_4">
						<table> 
							<colgroup>
								<col width="200"/>
								<col width="*" />				
							</colgroup> 
							<tr>
								<td><input type="checkbox" value=""class="trans" name="vsl_nm_chk" id="vsl_nm_chk" onClick="fncCheckboxOnClick('vsl_nm')">  <strong>Arrival Vessel</strong></td>
								<td><input type="text" style="width:100%;" class="input" value="" name="vsl_nm" id="vsl_nm" onblur="fncBlur(this);" maxlength="100"></td>
							</tr>
							<tr>
								<td><input type="checkbox" value=""class="trans" name="vvd_chk" id="vvd_chk">  <strong>VVD</strong></td>
								<td><select name="vvd" id="vvd" onChange="fncChangeVVD(this)"></select></td>
							</tr>
							<tr>
								<td><input type="checkbox" value=""class="trans" name="pod_arr_dt_chk"  id="pod_arr_dt_chk" onClick="fncCheckboxOnClick('pod_arr_dt')">  <strong>ETA  POD</strong></td>
								<td><input type="text" style="width:65%;" class="input" value="" name="pod_arr_dt" id="pod_arr_dt" onKeyPress="ComKeyOnlyNumber(this,'-: ');" onblur="fncBlur(this);fncAutoSettingTime(this);ComChkObjValid(event.srcElement);" dataformat="ymdhm" style="ime-mode:disabled" maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;<strong>NULL</strong>  <input type="checkbox" class="trans" id="pod_arr_dt_null" onclick="pod_arr_dt.value=this.checked?'':pod_arr_dt.value;fncBlur(pod_arr_dt);"></td>
							</tr>
							<tr>
								<td><input type="checkbox" value=""class="trans" name="del_eta_dt_chk" id="del_arr_dt_chk" onClick="fncCheckboxOnClick('del_arr_dt')">  <strong>ETA  DEL.</strong></td>
								<td><input type="text" style="width:65%;" class="input" value="" name="del_arr_dt" id="del_arr_dt" onKeyPress="ComKeyOnlyNumber(this,'-: ');" onblur="fncBlur(this);fncAutoSettingTime(this);ComChkObjValid(event.srcElement);" dataformat="ymdhm" style="ime-mode:disabled" maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;<strong>NULL</strong>  <input type="checkbox" class="trans" id="del_arr_dt_null" onclick="del_arr_dt.value=this.checked?'':del_arr_dt.value;fncBlur(del_arr_dt);"></td>
							</tr>
							<tr>
								<td><input type="checkbox" value=""class="trans" name="pkup_aval_dt_chk" id="pkup_aval_dt_chk" onClick="fncCheckboxOnClick('pkup_aval_dt')">  <strong>Available Date</strong></td>
								<td><input type="text" style="width:65%;" class="input" value="" name="pkup_aval_dt" id="pkup_aval_dt" onKeyPress="ComKeyOnlyNumber(this,'-: ');" onblur="fncBlur(this);fncAutoSettingTime(this);ComChkObjValid(event.srcElement);" dataformat="ymdhm" style="ime-mode:disabled" maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;<strong>NULL</strong>  <input type="checkbox" class="trans" id="pkup_aval_dt_null" onclick="pkup_aval_dt.value=this.checked?'':pkup_aval_dt.value;fncBlur(pkup_aval_dt);"></td>
							</tr>
						
							<tr>
								<td><input type="checkbox" value=""class="trans" name="pkup_free_dt_chk" id="pkup_free_dt_chk" onClick="fncCheckboxOnClick('pkup_free_dt')">  <strong>Last Free Date</strong><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>to Pick up</strong></td>
								<td><input type="text" style="width:65%;" class="input" value="" name="pkup_free_dt" id="pkup_free_dt" onKeyPress="ComKeyOnlyNumber(this,'-: ');" onblur="fncBlur(this);fncAutoSettingTime(this);ComChkObjValid(event.srcElement);" dataformat="ymdhm" maxlength="16" style="ime-mode:disabled;text-decoration:underline">&nbsp;&nbsp;&nbsp;&nbsp;<strong>NULL</strong>  <input type="checkbox" class="trans" id="pkup_free_dt_null" onclick="pkup_free_dt.value=this.checked?'':pkup_free_dt.value;fncBlur(pkup_free_dt);"></td>
							</tr>
							<tr>
								<td><input type="checkbox" value=""class="trans" name="pkup_yd_cd_chk" id="pkup_yd_cd_chk" onClick="fncCheckboxOnClick('pkup_yd_cd')">  <strong>Full CNTR P/Up CY</strong></td>
								<td><input type="text" style="width:100%;" class="input" value="" name="pkup_yd_cd" id="pkup_yd_cd" dataformat="engup" onblur="fncBlur(this)" maxlength="7" style="ime-mode:disabled"></td>
							</tr>
							<tr>
								<td><input type="checkbox" value=""class="trans" name="rtn_yd_cd_chk" id="rtn_yd_cd_chk" onClick="fncCheckboxOnClick('rtn_yd_cd')">  <strong>Empty Return CY</strong></td>
								<td><input type="text" style="width:100%;" class="input" value="" name="rtn_yd_cd" id="rtn_yd_cd" dataformat="engup" onblur="fncBlur(this)" maxlength="7" style="ime-mode:disabled"></td>
							</tr>
							<tr>
								<td><input type="checkbox" value=""class="trans" name="an_fom_cd_chk" id="an_fom_cd_chk">  <strong>A/N Form Type</strong></td>
								<td><select style="width:70%;" name="an_fom_cd" id="an_fom_cd" onChange="fncAnFomCdChange(this);fncBlur(this);"></select></td>
							</tr>
							<tr>
								<td><input type="checkbox" value="" class="trans" name="chn_agn_cd_chk" id="chn_agn_cd_chk" onClick="fncCheckboxOnClick('chn_agn_cd')">  <strong>Agent</strong></td>
								<td><input type="text" style="width:20%;" class="input" value="" name="chn_agn_cd" id="chn_agn_cd" dataformat="engup" onblur="fncBlur(this)" maxlength="2" style="ime-mode:disabled"></td>
							</tr>
							<tr>
								<td><input type="checkbox" value="Y" class="trans" name="ntc_rvis_flg" id="ntc_rvis_flg">  <strong>Revise</strong></td>
								<td></td>
							</tr>
							<tr>
								<td><input type="checkbox" value=""class="trans" name="diff_rmk_chk" id="diff_rmk_chk" onClick="fncCheckboxOnClick('diff_rmk')">&nbsp;<strong>Remark</strong></td>
								<td><textarea style="width:100%;height:42px;overflow-x:hidden;" class="input" name="diff_rmk" id="diff_rmk" onblur="fncBlur(this)" wrap="hard"></textarea></td>
							</tr>
						</table>	
					</div>
					<div class="layout_vertical_2 pad_left_4">
						<table> 						
							<tr><td><h3>Address</h3></td></tr>
							<tr><td class="noinput2"><input type="text" style="width:100%;" class="noinput2" value="" name="addr_cnt" readOnly></td></tr>
						</table>	
						<table class="line_bluedot"><tr><td></td></tr></table>
						<table> 					
							<tr><td><h3>Important Notice</h3></td></tr>
							<tr><td class="noinput2"><textarea style="width:100%;height:260px;resize:none" class="noinput2" name="impt_ntc_rmk" readOnly></textarea></td></tr>
						</table>	
					</div>
				</div>
			</div>
		</div>
	</div>	
	<div class="wrap_result">		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
