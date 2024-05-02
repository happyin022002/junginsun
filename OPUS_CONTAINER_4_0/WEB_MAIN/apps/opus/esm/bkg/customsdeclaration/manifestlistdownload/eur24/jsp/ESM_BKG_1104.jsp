<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_1104.jsp
*@FileTitle  : Europe Advanced Manifest - Arrival Notice 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1104Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>


<%
	EsmBkg1104Event  event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg1104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// get data from server when load page ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
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
		loadPage();
		document.form.form_vvd.focus();
	}
	<%=ConstantMgr.getCompanyCodeToJS()%>
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cmd_detail">
<input type="hidden" name="p_vvd_cd">
<input type="hidden" name="vvd">
<input type="hidden" name="cvy_ref_no">
<input type="hidden" name="form_cstms_port_cd">
<input type="hidden" name="cstms_yd_cd">
<input type="hidden" name="cstms_yd_cd2">
<input type="hidden" name="form_cvy_ref_no_hidden">
<input type="hidden" name="form_ibflag">
<input type="hidden" name="eur_edi_msg_tp_id" value = "ARN">
<input type="hidden" name="form_an_edi_svc_flg">

	<!-- 제목 -->
	<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	   <div class="opus_design_btn"><!-- 
		      --><button type="button" class="btn_normal" name="btn_MrnDelete" id=btn_MrnDelete style="display:none">All MRN Delete</button><!-- 
			  --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		      --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		      --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		      --><button type="button" class="btn_normal" name="btn_transmit" id="btn_transmit">Transmit</button><!-- 
	    --></div>
	
	   <!-- page_location(S) -->
	   <div class="location">
			<span id="navigation"></span>
	   </div>
	</div>
	<!-- 제목 -->
<div class="wrap_search">
	<!-- 검색영역 -->
	<div class="opus_design_inquiry">		
		<table>
				<colgroup>
			  		<col width="120px"></col>
			  		<col width="170px"></col>
			  		<col width="120px"></col>
			  		<col width="150px"></col>
			  		<col width="120px"></col>
			  		<col width="250px"></col>
			  		<col width="60px"></col>
			  		<col width="80px"></col>			  		
			  		<col width=""></col>
			  	</colgroup> 			
				<tbody>
				<tr>
					<th>VVD CODE</th>
					<td><input type="text" style="width:90px;" class="input1" name="form_vvd"  maxlength="9" dataformat="engup" caption="VVD" ></td>
					<th>CRN No.</th>
					<td><input type="text" style="width:120px" class="input" name="form_cvy_ref_no" dataformat="engup" maxlength="50" caption="CRN No." ></td>
					<th>POFE(Port of 1st Entry)</th>
					<td colspan="4"><script type="text/javascript">ComComboObject('cstms_port_cd', 1, 90, 1, 0, false);</script><input type="text" style="width:80px" class="input2" readOnly="true" name="form_cstms_yd_cd" dataformat="engup" maxlength="10" caption="Yard"></td>

				</tr>
				<tr ><td colspan="9" class="line_bluedot"></td></tr>
				<tr>
					<th>Vessel Name</th>
					<td><input type="text" style="width:200px" class="input2" readOnly="true" name="form_vsl_eng_nm" maxlength="50"></td>
					<th>Lloyd No.(IMO)</th>
					<td><input type="text" style="width:80px" class="input2" readOnly="true" name="form_lloyd_no" dataformat="engup" maxlength="20"></td>
					<th>Vessel Flag</th>
					<td><input type="text" style="width:200px" class="input2" readOnly="true" name="form_piclb_desc" dataformat="engup" maxlength="100"></td>
					<th>Operator</th>
					<td><input type="text" style="width:40px" class="input2" readOnly="true" name="form_crr_cd" dataformat="engup" maxlength="10"></td>
					<td></td>
				</tr>
				<tr>
					<th>ENS ETA</th>
					<td><input type="text" style="width:120px class="input2" disabled = "true" name="form_init_eta_dt" caption="Estimated Time of Arrival">
					    <input type="checkbox" value="" class="trans" name="modify_ens_eta" id="modify_ens_eta" disabled="true">
					</td>
					<th>ETA</th>
					<td><input type="text" style="width:120px" class="input2" readOnly="true" name="form_eta_dt" caption="Estimated Time of Arrival"></td>
					<th>ETD</th>
					<td colspan="4"><input type="text" style="width:120px" class="input2" readOnly="true" name="form_etd_dt" caption="Estimated Departure Date"></td>
				</tr>
				<tr>
					<th>First Office</th>
					<td><input type="text" style="width:80px" class="input2" readOnly="true" name="form_n1st_port_ofc_cd" dataformat="engup" maxlength="10" caption="First Port Office Code"></td>
					<th>Calling Terminal</th>
					<td colspan="6"><input type="text" style="width:80px" class="input2" readOnly="true" name="form_tml_cd" dataformat="engup" maxlength="15" caption="Terminal Code"><input type="text" style="width:260px" class="input2" readOnly="true" name="form_tml_nm" dataformat="engup" maxlength="50" caption="Terminal Name"></td>
				</tr>
				<tr>
					<th>Last Calling Port</th>
					<td><input type="text" style="width:80px" class="input" name="form_lst_clpt_cd" dataformat="engup" maxlength="5"></td>
					<th>Next Calling Port</th>
					<td colspan="6"><input type="text" style="width:80px" class="input" name="form_nxt_clpt_cd" dataformat="engup" maxlength="5"></td>
				</tr>
				<tr>
					<th>Cert. Reg No.</th>
					<td><input type="text" style="width:120px class="input2" name="form_rgst_no" dataformat="engup" maxlength="15"></td>
					<th>Cert. Reg Date</th>
					<td><input type="text" style="width:100px" class="input2" name="form_rgst_dt" dataformat="ymd" maxlength="10"></td>
					<th>Cert. Reg Location</th>
					<td colspan="4"><input type="text" style="width:80px" class="input2" name="form_rgst_port_cd" dataformat="engup" maxlength="5"></td>
				</tr>
				<tr>
					<th>Gross Ton</th>
					<td><input type="text" style="width:80px" class="input2" name="form_grs_rgst_tong_wgt" dataformat="engup" maxlength="15"></td>
					<th>Net Ton</th>
					<td colspan="6"><input type="text" style="width:80px" class="input2" name="form_net_rgst_tong_wgt" dataformat="engup" maxlength="15"></td>					
				</tr>				
			</tbody>
		</table>
	</div>
	<div class="line_bluedot"></div>
	<!-- 검색영역 -->
	<div class="opus_design_inquiry">		
		<table>
				<colgroup>
			  		<col width="145px"></col>
			  		<col width="250px"></col>
			  		<col width="50px"></col>
			  		<col width="180px"></col>
			  		<col width="110px"></col>
			  		<col width="180px"></col>			  					  		
			  		<col width=""></col>
			  	</colgroup> 			
				<tbody>
				<tr>
					<th>EDI Transmission Date</th>
					<td><input type="text" style="width:200px" class="input2" name="form_snd_dt"  dataformat="engup"></td>
					<th>By</th>
					<td>
						<input type="text" style="width:80px" class="input2" name="form_snd_usr_id"  dataformat="engup" maxlength="10">
						<input type="text" style="width:80px" class="input2" name="form_snd_ofc_cd"  dataformat="engup" maxlength="10">
					</td>
					<th>EDI ACK</th>
					<td><input type="text" style="width:80px" class="input2" name="form_ack"  dataformat="engup" maxlength="10"><input type="text" style="width:80px" class="input2" name="form_result"  dataformat="engup" maxlength="10"><button type="button" id="btn_viewMsg" name="btn_viewMsg" class="input_seach_btn"></button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>	

<div class="wrap_result">
	<div class="opus_design_inquiry" >		
		<table style="width:750px; border:1px solid #c7e2f8; background-color:#eceff0; height:30px">
			<tr>	
				<td><b>* Transmit button becomes disabled in case Operator is not <%=ConstantMgr.getCompanyName()%> or the customs of First EU Port does not require A/N EDI.</b></td>
			</tr>
		</table>
	</div>
	<div class="opus_design_inquiry" style="font-weight:bold;">		
		<table style="width:750px; border:1px solid #c7e2f8; background-color:#eceff0; height:30px">
			<tr>	
				<td><b>* POFE ETA time is inserted as 12:00 when vessel operator is a consortium member.</b></td>
			</tr>
		</table>
	</div>
	<div class="opus_design_grid" id="mainTable" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<!-- 검색영역 -->
	<div class="opus_design_inquiry" id="mainTable" style="display:none">		
		<table>
				<colgroup>
			  		<col width="145px"></col>		  		
			  		<col width=""></col>
			  	</colgroup> 			
				<tbody>
				<tr>
					<th>FlatFile</th>
					<td><textarea name="flatfile" cols="600" rows="20"  wrap="hard" style="width:100%; background-color: #FBFBFB; border: 1 solid #AEAEAE;resize:none"  style="overflow:hidden; ime-mode:disabled;"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
	
						<div class="search" border="0" style="display:none">
								<script language="javascript">ComComboObject('p_type', 1, 110, 1, '');</script>
						</div>	
</div>
</form>