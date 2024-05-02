<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0206.jsp
*@FileTitle  : COD Approval Detail at RSO Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf0206Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%
	VopOpf0206Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml       = "";
	String strDate          = "";

	String strBkgNo = request.getParameter("bkg_no");
	String strBlNo = request.getParameter("bl_no");
	String strBvd = request.getParameter("vvd");
	String strVslSlanCd = request.getParameter("vsl_slan_cd");
	String strCodRqstSeq = request.getParameter("cod_rqst_seq");
	String strCodRhndPortCd = request.getParameter("cod_rhnd_port_cd");
	String strCodStsCd = request.getParameter("cod_sts_cd");
	String strCodEmailSendYn = request.getParameter("cod_email_send_yn");
	String strCodRhndPortYdCd = request.getParameter("cod_rhnd_port_yd_cd");	
	String strVslOprCd = request.getParameter("vsl_opr_cd");	

	String pNewPol = request.getParameter("new_pol");
	String pNewPod = request.getParameter("new_pod");
	
	Logger log = Logger.getLogger("com.clt.apps.ChangeOfDestinationMgt.ChangeOfDestinationMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();
		strDate = DateTime.getYear() + "/" + DateTime.getMonth() + "/" + DateTime.getDay();  


		event = (VopOpf0206Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=strDate%>");
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- Developer Performance	-->
<input type="hidden" name="cod_rqst_seq" value="<%=StringUtil.xssFilter(strCodRqstSeq)%>" id="cod_rqst_seq" />
<input type="hidden" name="rat_ut_cd" id="rat_ut_cd" />
<input type="hidden" name="tpsz" id="tpsz" />
<input type="hidden" name="codRemark" id="codRemark" />
<input type="hidden" name="rejectRmk" id="rejectRmk" />
<input type="hidden" name="cod_sts_cd" value="<%=StringUtil.xssFilter(strCodStsCd)%>" id="cod_sts_cd" />
<input type="hidden" name="codstscd" id="codstscd" />
<input type="hidden" name="cod" value="<%=StringUtil.xssFilter(strCodStsCd)%>" id="cod" />
<input type="hidden" name="rgn_cd" id="rgn_cd" />
<input type="hidden" name="vsl_opr_cd" value="<%=StringUtil.xssFilter(strVslOprCd)%>" id="vsl_opr_cd" />
<input type="hidden" name="cntr_cgo_tp_cd" id="cntr_cgo_tp_cd" />
<input type="hidden" name="cgo_cate_cd" id="cgo_cate_cd" />
<input type="hidden" name="cod_email_send_yn" value="<%=StringUtil.xssFilter(strCodEmailSendYn)%>" id="cod_email_send_yn" />
<input type="hidden" name="qty_list" id="qty_list" />
<input type="hidden" name="cod_rhnd_port_cd" value="<%=StringUtil.xssFilter(strCodRhndPortCd)%>" id="cod_rhnd_port_cd" />
<input type="hidden" name="p_new_pol" value="<%=StringUtil.xssFilter(pNewPol)%>" id="p_new_pol" />
<input type="hidden" name="p_new_pod" value="<%=StringUtil.xssFilter(pNewPod)%>" id="p_new_pod" />

<!-- Message start -->
<input type="hidden" name="sndr_usr_id" value="<%=strUsr_id%>" id="sndr_usr_id" />
<input type="hidden" name="sndr_usr_nm" value="<%=strUsr_nm%>" id="sndr_usr_nm" />
<!-- input type="text" name="msg_ctnt" -->
<input type="hidden" name="rcvr_usr_id" id="rcvr_usr_id" />
<input type="hidden" name="rcvr_usr_nm" id="rcvr_usr_nm" />
<input type="hidden" name="cntr_no" id="cntr_no" />
<textarea style="width:100;height:20;display:none" name="msg_ctnt"></textarea>
<!-- Message end -->

<!-- Sending Mail relevant item -->
<input type="hidden" name="com_rdSubSysCd" value="OPF" id="com_rdSubSysCd" />
<input type="hidden" name="com_from" value="<%=strUsr_eml%>" id="com_from" />
<input type="hidden" name="com_recipient" id="com_recipient" />
<input type="hidden" name="com_carbonCopy" id="com_carbonCopy" />
<input type="hidden" name="com_blindCarbonCopy" id="com_blindCarbonCopy" />
<input type="hidden" name="com_subject" id="com_subject" />
<input type="hidden" name="com_fileKey" id="com_fileKey" />
<input type="hidden" name="com_content" id="com_content" />
<input type="hidden" name="com_templateMrd" id="com_templateMrd" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>COD Approval Detail at RSO Office</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_ok" id="btn_ok" type="button">OK</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->




<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">

		
	<!-- wrap_search(S) -->
	<div class="wrap_search">
	
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="60" />				
						<col width="160" />				
						<col width="50" />				
						<col width="160" />				
						<col width="40" />	
						<col width="160" />				
						<col width="70" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
				   			<th>BKG  No.</th>
							<td><input name="bkg_no" id="bkg_no" type="text" style="width:110px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(strBkgNo)%>" readonly></td>
							<th>BL  No.</th>
							<td><input name="bl_no" id="bl_no" type="text" style="width:110px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(strBlNo)%>" readonly></td>
							<th title="Vessel Voyage Direction">VVD</th>
							<td><input name="vvd" id="vvd" type="text" style="width:100px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(strBvd)%>" readonly></td>
							<th>Lane Code</th>
							<td><input name="slan_cd" id="slan_cd" type="text" style="width:80px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(strVslSlanCd)%>" readonly></td>
				   		</tr>
				   </tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
			
	</div>
	<!-- wrap_search(E) -->




	<!-- wrap_result(S) -->
	<div class="wrap_result" >
		
		
		<!-- 01 - COD Request Information(S) -->
		<div class="opus_design_inquiry">
		
			<!-- opus_design_grid(S) -->
			<h3 class="title_design mar_top_8">COD Request Information</h3>
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>	
			</div>
			<div class="opus_design_inquiry">
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				<table> 
					<colgroup>
						<col width="90" />				
						<col width="85" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
						<tr>
							<th>Approval RSO</th>
							<td><script type="text/javascript">ComComboObject('rso', 2, 80, 1, 0);</script></td>
							<td><button type="button" class="btn_etc" name="btn_update" id="btn_update"> Update</button></td>
						</tr>
					</tbody>
				</table>
			</div>
	
			<!-- TAB [ Gang Structure ] (E) -->
			<div id="tabLayer" style="display:none">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet2');</script>	
				</div>
			</div>
			<!-- opus_design_grid(E) -->
			
				<table class="grid_2"> 
					<colgroup>
						<col width="180" />				
						<col width="160" />				
						<col width="160" />				
						<col width="160" />				
						<col width="160" />	
						<col width="160" />				
						<col width="160" />				
						<col width="*" />				
				   </colgroup> 
					<tbody>
						<tr>
							<th style="text-align:center;">BKG Route</th>
							<th style="text-align:center;">POR</th>
							<th style="text-align:center;">POL</th>
							<th style="text-align:center;">POD</th>
							<th style="text-align:center;">DEL</th>
							<th style="text-align:center;">Target VVD</th>
							<th style="text-align:center;">T/S Detail</th>
							<th style="text-align:center;">Remark(s)</th>
						</tr>
						<tr align="center">
							<th style="text-align:center;">OLD</th>
							<td><input type="text" style="width:80px;text-align:center;background-color:transparent;" class="noinput" name="old_por" readonly id="old_por" /> </td>
							<td><input type="text" style="width:80px;text-align:center;background-color:transparent;" class="noinput" name="old_pol" readonly id="old_pol" /> </td>
							<td><input type="text" style="width:80px;text-align:center;background-color:transparent;" class="noinput" name="old_pod" readonly id="old_pod" /> </td>
							<td><input type="text" style="width:80px;text-align:center;background-color:transparent;" class="noinput" name="old_del" readonly id="old_del" /> </td>
							<td><input type="text" style="width:80px;text-align:center;background-color:transparent;" class="noinput" name="old_vvd" readonly id="old_vvd" /> </td>
							<td align="center"><button type="button" class="btn_etc" name="old_ts_route" id="old_ts_route">T/S Route</button></td>
							<td></td>
						</tr>
						<tr align="center">
							<th style="text-align:center;">NEW</th>
							<td><input type="text" style="width:80px;text-align:center;background-color:transparent;" class="noinput" name="new_por" readonly id="new_por" /> </td>
							<td><input type="text" style="width:80px;text-align:center;background-color:transparent;" class="noinput" name="new_pol" readonly id="new_pol" /> </td>
							<td><input type="text" style="width:80px;text-align:center;background-color:transparent;" class="noinput" name="new_pod" readonly id="new_pod" /> </td>
							<td><input type="text" style="width:80px;text-align:center;background-color:transparent;" class="noinput" name="new_del" readonly id="new_del" /> </td>
							<td><input type="text" style="width:80px;text-align:center;background-color:transparent;" class="noinput" name="new_vvd" readonly id="new_vvd" /> </td>
							<td align="center"><button type="button" class="btn_etc" name="new_ts_route" id="new_ts_route">T/S Route</button></td>
							<td align="center"><button type="button" class="btn_etc" name="new_detail" id="new_detail">Detail</button></td>
						</tr>
					</tbody>
				</table> 
				
				<table>
					<colgroup>
						<col width="90"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<th>COD Reason</th>
							<td><input type="text" style="width:244px;" class="input2" name="cod_rqst_rsn_cd" id="cod_rqst_rsn_cd" readonly></td>
						</tr>
					</tbody>
				</table>

	
		</div>
		<!-- 01 - COD Request Information(E) -->
	
		
		



		
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	

		<!-- 02 - Freight n Charges for COD (S) -->
		<div class="opus_design_inquiry">
			
			<h3 class="title_design mar_top_8">Freight & Charges for COD</h3>
			
			<!-- opus_design_grid (S) -->
			<div class="opus_design_grid">
				<div class="grid_option_left">
					<table> 
						<colgroup>
							<col width="120" />				
							<col width="*" />				
					   </colgroup> 
					   <tbody>
							<tr>
								<th>Re-Handling PORT</th>
								<td><!--<input type="hidden" style="width:60px;" class="input2" name="cod_rhnd_port_yd_cd" id="cod_rhnd_port_yd_cd" value="<%=StringUtil.xssFilter(strCodRhndPortYdCd)%>" readOnly> 
								 --><button type="button" class="btn_etc" name="btn_calculation" id="btn_calculation"> Calculation</button></td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="grid_option_right opus_design_btn">
					<button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
					--><button class="btn_normal" name="btn_del" id="btn_del" type="button">Row Delete</button><!--
					--></div>
				<script type="text/javascript">ComSheetObject('sheet3');</script>
					
			</div>
			<!-- opus_design_grid (E) -->
			
		</div>
		<!-- 02 - Freight n Charges for COD (E) -->
	
	
		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
		<!-- 03 - Authority (S) -->
		<div class="opus_design_inquiry">
		
			<!-- 
			<div class="opus_design_inquiry">
				<table> 
					<colgroup>
						<col width="120" />				
						<col width="*" />				
				   </colgroup> 
				   <tbody>
						<tr>
							<th>Re-Handling PORT</th>
							<td><input type="text" style="width:60px;" class="input2" name="cod_rhnd_port_cd" id="cod_rhnd_port_cd" value="<%=strCodRhndPortCd%>" readOnly><button type="button" class="btn_etc" name="btn_calculation" id="btn_calculation"> Calculation</button></td>
						</tr>
					</tbody>
				</table>
			</div> -->
			
			<div class="opus_design_grid">

				<h3 class="title_design grid-option-left">Authority</h3>
				<div class="opus_design_btn grid-option-right">
					<button class="btn_normal" name="btn_reject" id="btn_reject" type="button">Reject Reason Remarks</button>
				</div>
				<!-- <div id="rejectRmkView" style="display:none;position:absolute;overflow:hidden;padding-top:4;"><iframe name="rejectRmkIfrm" id="rejectRmkIfrm" src="/opuscntr/VOP_OPF_1206.do?isPop=R" width="440px" height="220px" marginWidth="0" marginHeight="0" scrolling=no frameborder="0"></iframe></div> -->
			</div>
			<table> 
				<colgroup>
					<col width="80"/>
					<col width="100"/>
					<col width="120"/>
					<col width="150"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>Auth Result</th>
						<td><script type="text/javascript">ComComboObject('authflag', 1, 80, 1);</script></td>
						<th>Reject Reason</th>
						<td><script type="text/javascript">ComComboObject('rejectcd', 2, 80, 1, 0);</script></td>
						<td><button type="button" class="btn_etc" name="btn_Mail" id="btn_Mail">Mail</button></td>
					</tr>
				</tbody> 
			</table>
			
		</div>
		<!-- 03 - Authority (E) -->
		
		
		
		<!-- TAB [ Gang Structure ] (E) -->
		<div id="tabLayer" style="display:none">
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet4');</script>
			</div>
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet5');</script>
			</div>
		
		</div>
		<!-- TAB [ Gang Structure ] (E) -->	
		
	</div>
	<!-- wrap_result(E) -->
	<!-- <div id="codRemarkView" style="display:none;position:absolute;overflow:hidden;padding-top:4;"><iframe name="codRemarkIfrm" id="codRemarkIfrm" src="/opuscntr/VOP_OPF_1206.do?isPop=C" width="320" height="220" marginWidth="0" marginHeight="0" scrolling=no frameborder="0"></iframe></div> -->
	<!-- <div id="qtyView" style="display:none;position:absolute;overflow:hidden;"><iframe name="qtyIfrm" id="qtyIfrm" src="/opuscntr/VOP_OPF_1206.do?qty&isPop=Q" width="320" height="175" marginWidth="0" marginHeight="0" scrolling=no frameborder="0"></iframe></div> -->
	
</div>
<!-- popup_contens_area(E) -->



<!-- : ( Button : pop ) (E) -->
<!-- Developer Performance  end  -->
</form>
