<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1031.jsp
*@FileTitle  : Guideline Mailing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/09
=========================================================*/
%>     
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.event.EesEqr1031Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1031ConditionVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1031Event  event      = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String pageRows  = "100";


	try {
		event = (EesEqr1031Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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
</script>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">

	<!--  Mail Sending 에서 인식하는 value () -->
	<input type="hidden" id="com_from" name="com_from" value="">
	<input type="hidden" id="com_fromName" name="com_fromName" value="">
	<input type="hidden" id="com_recipient" name="com_recipient" value="">
	<input type="hidden" id="com_carbonCopy" name="com_carbonCopy" value="">
	<input type="hidden" id="com_blindCarbonCopy" name="com_blindCarbonCopy" value="">
	<input type="hidden" id="com_subject" name="com_subject" value="">
	<input type="hidden" id="com_fileKey" name="com_fileKey" value="">
	<input type="hidden" id="com_content" name="com_content" value="">		
	<!-- input type="hidden" name="com_smtp" 			value="203.246.130.40" -->

	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<h2 class="page_title"><span>Guideline Mailing</span></h2>
			
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_mailsend" id="btn_mailsend">Send Mail</button>
				<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
			</div>
		</div>
	</div>
	
	<div class="layer_popup_contents">
		<div class="wrap_search">
			<div class="opus_design_inquiry wFit">
				<table> 
					<tbody>
						<tr>
							<th width="80">RHQ Office</th>								
							<td width="70">
	                    		<select style="width:85px;" class="input" id="f_rhqcd" name="f_rhqcd">
	                        	<option value="" selected>ALL</option>
	                        	<option value="NYCNA" >NYCNA</option>                        
	                        	<option value="HAMUR" >HAMUR</option>    
	                        	<option value="SHAAS" >SHAAS</option>    
	                        	<option value="SINWA" >SINWA</option>    
	                        	<option value="OTHER" >Others</option>    
	                        	</select>									
	                        </td>
							<th width="80">Office Code</th>
							<td>
							    <input type="text" class="input" name="f_ofccd" caption="Office" dataformat="engup" size="10" maxlength="10" fulfill size="10" style="width:100px;" value="" ><!--
								--><button type="button" class="input_seach_btn" id="btns_open_ofc" name="btns_open_ofc"></button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div style="display:none">
		<script language="javascript">ComSheetObject('sheet1');</script> <!-- ETC 데이터 조회를 위해서만 사용함 -->
	</div>
</form>