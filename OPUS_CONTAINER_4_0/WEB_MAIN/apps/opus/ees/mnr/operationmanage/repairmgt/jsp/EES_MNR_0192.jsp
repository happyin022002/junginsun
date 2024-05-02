<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0192.jsp
*@FileTitle  : Repair Estimate Creation Pop up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/16
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0192Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0192Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0; 						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 

	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= "";  
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");

	// DATA FOR POPUP			 	
	String rqstEqNo = ((request.getParameter("rqst_eq_no")==null )?"":request.getParameter("rqst_eq_no"));
	String rprRqstSeq = ((request.getParameter("rpr_rqst_seq")==null )?"":request.getParameter("rpr_rqst_seq"));
	String rprRqstVerNo = ((request.getParameter("rpr_rqst_ver_no")==null )?"":request.getParameter("rpr_rqst_ver_no"));
	String eqKndCd = ((request.getParameter("eq_knd_cd")==null )?"":request.getParameter("eq_knd_cd"));
	String recentRprTpCd = ((request.getParameter("recent_rpr_tp_cd")==null )?"":request.getParameter("recent_rpr_tp_cd"));
	String estTemp = ((request.getParameter("est_temp")==null )?"":request.getParameter("est_temp"));
	String sppType = ((request.getParameter("spp_type")==null )?"":request.getParameter("spp_type"));


	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();	       
		strUsr_nm = account.getUsr_nm(); 	   
	    strOfc_cd = account.getOfc_cd();   	 

		event = (EesMnr0192Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}       

		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {    
		out.println(e.toString()); 
	}
%>



<!-- common use in MNR -->   
<div style="height:0px; ">             
<script type="text/javascript">   
	function setupPage(){  
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if  
		loadPage();
	}
</script>	 	
<script type="text/javascript">ComSheetObject('sheet1');</script>     
</div>
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- for distinguish issuing estimate and audit.(rqst_cre/rqst_aud) -->
<input type="hidden" name="rqst_type" value="rqst_cre" id="rqst_type" />
<!-- all input data is 'Manual' -->  
<input type="hidden" name="mnr_inp_tp_cd" value="M" id="mnr_inp_tp_cd" />
<input type="hidden" name="eq_tpsz_cd" value="" id="eq_tpsz_cd" />

<!-- AGMT data combo  -->
<input type="hidden" name="trsm_mod_cd" id="trsm_mod_cd" />
<input type="hidden" name="eq_knd_cd" value="<%=eqKndCd%>" id="eq_knd_cd" />
<input type="hidden" name="edi_id" id="edi_id" />

<!-- to get AGMT data  -->
<input type="hidden" name="agmt_ofc_cty_cd" id="agmt_ofc_cty_cd" />
<input type="hidden" name="agmt_seq" id="agmt_seq" />
<input type="hidden" name="agmt_ver_no" id="agmt_ver_no" />

<!-- key value for save estimate  -->
<input type="hidden" name="rpr_rqst_seq" value="<%=rprRqstSeq%>" id="rpr_rqst_seq" />
<input type="hidden" name="rpr_rqst_ver_no" value="<%=rprRqstVerNo%>" id="rpr_rqst_ver_no" />
<input type="hidden" name="rpr_sts_cd" id="rpr_sts_cd" />
<input type="hidden" name="rpr_offh_flg" value="N" id="rpr_offh_flg" />
<input type="hidden" name="disp_flg" value="N" id="disp_flg" />
<input type="hidden" name="rpr_rqst_tmp_seq" value="1" id="rpr_rqst_tmp_seq" />
<input type="hidden" name="rpr_rqst_lst_ver_flg" value="Y" id="rpr_rqst_lst_ver_flg" />
<input type="hidden" name="n3pty_flg" value="N" id="n3pty_flg" />
<input type="hidden" name="file_seq" value="" id="file_seq" />
<input type="hidden" name="rqst_usr_id" value="" id="rqst_usr_id" />

<!-- notice   -->	  
<input type="hidden" name="recent_rpr_tp_cd" value="<%=recentRprTpCd%>" id="recent_rpr_tp_cd" />
<!-- TEMP estimate from EDI  -->   	  
<input type="hidden" name="est_temp" value="<%=estTemp%>" id="est_temp" />
<!-- page_title_area(S) -->

 <div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Estimate Detail Info</span></h2>
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>


<div class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="105" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Notice</th>  
					<td><textarea name="notice" id="notice" style="width:100%;height:30"></textarea></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="105" />				
				<col width="407" />				
				<col width="75" />				
				<col width="138" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Service Provider</th>
					<td><input type="text" name="vndr_seq" caption="Service Provider" style="width:55px;text-align:left;" class="input2" value="" dataformat="num" maxlength="6" readonly id="vndr_seq" /><input type="text" name="vndr_nm" caption="Service Provider" style="width:241px;" class="input2" value="" readonly id="vndr_nm" /> </td>
					<th>C.OFC</th>
					<td><input name="cost_ofc_cd" type="text" style="width:80px;" class="input2" dataformat="engup" value="" readonly id="cost_ofc_cd" /> </td>
					<th></th>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="105" />				
				<col width="140" />				
				<col width="90" />				
				<col width="140" />				
				<col width="75" />				
				<col width="140" />				
				<col width="90" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>	
					<th>EQ No.</th>
					<td><input maxlength="14" style="width:120px;" type="text" name="rqst_eq_no" dataformat="engup" caption="EQ No" class="input1" value="<%=rqstEqNo%>" id="rqst_eq_no" /> </td>
					<th>Estimate No.</th>
					<td><input maxlength="20" style="width:170px;" type="text" name="rqst_ref_no" dataformat="engup" caption="Estimate No" class="input1" value="" id="rqst_ref_no" /> </td>
					<th>Repair Yard</th>
					<td><input style="width:80px;" type="text" name="rpr_yd_cd" dataformat="engup" maxlength="7" caption="yard cd" class="input1" value="" id="rpr_yd_cd" /> </td>
					<th>Repair Status</th>
					<td colspan="2"><script type="text/javascript">ComComboObject('rpr_wrk_tp_cd', 1, 160, 1, 1, 0, false, 0);</script></td>	
				</tr>				 
				<tr>
					<th>Damage Date</th>
					<td><input name="eq_dmg_dt" type="text" style="width:80px;" class="input" value="" dataformat="ymd" maxlength="10" id="eq_dmg_dt" /><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
					<th>Input User</th>
					<td><input type="text" style="width:170px;" name="rqst_usr_nm" dataformat="engup" maxlength="50" class="input2" size="10" value="" readonly id="rqst_usr_nm" /> </td>
					<th>Input Date</th>
					<td><input type="text" style="width:80px;" name="rqst_dt" dataformat="ymd" maxlength="10" class="input2" size="10" value="" readonly id="rqst_dt" /> </td>
					<th>Off-hire <input name="rpr_offh_flg_temp" type="checkbox" value="Y" class="trans" id="rpr_offh_flg_temp" /></th>
					<th width="80">Gate-In Date</th>
					<td><input type="text" style="width:80;" name="mvmt_dt" dataformat="ymd" maxlength="10"  class="input2" size="10"  value="" readonly></td>
				</tr>	
		   </tbody>
		</table>
	</div>
		
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Equipment Information</h3>
		<table class="grid_2">
			<colgroup>
				<col width="8%" />				
				<col width="11%" />				
				<col width="4%" />				
				<col width="10%" />				
				<col width="3%" />				
				<col width="100" />				
				<col width="8%" />				
				<col width="7%" />				
				<col width="3%" />				
				<col width="9%" />				
				<col width="9%" />				
				<col width="12%" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Repair</th>
		   			<td id="Repair" name="Repair"> </td>
		   			<td>
		   				<button class="btn_etc" name="btn_detail" id="btn_detail" onclick="return false">Detail(s)</button>
		   			</td>
		   			<th>IMM.EXIT</th>
					<td  id="ImmExit" name="ImmExit" > </td>
					<th>Off-hire</th>
					<td  id="OffHire" name="OffHire" > </td>
					<th>Disposal</th>
					<td  id="Disposal" name="Disposal" > </td>
					<th>DPP&nbsp;(USD)</th>
					<td  id="DPP" name="DPP" > </td>
					<th>DV Value(USD)</th>
					<td  id="DvValue" name="DvValue" > </td>
				</tr>
				<tr>
					<th>MANU.DT</th>
					
					<td colspan="2" id="ManuDt" name="ManuDt" > </td>
					<th>TP/SZ</th>
					<td  id="TpSz" name="TpSz" > </td>
					<th> Term</th>
					<td  id="Term" name="Term" > </td>
					<th>Lessor</th>
					<td align="left" colspan="3"  id="Lessor" name="Lessor" > </td>
					<th>Warranty</th>
					<td  id="Warranty" name="Warranty" > </td>
				</tr>
		   </tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript"> ComTabObject ('tab1')</script>
	</div>

	<div id="tabLayer" style="display:inline">
		<!-- wrap_result(S) -->		
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid" id="mainTable">
					<!-- opus_design_btn (S) -->
					<div class="opus_design_btn">
						<button class="btn_accent" name="btn_calc" id="btn_calc" type="button">Caculation</button><!--
						--><button class="btn_normal" name="btn_RowAdd" id="btn_RowAdd" type="button">Row Add</button><!--
						--><button class="btn_normal" name="btn_RowDel" id="btn_RowDel" type="button">Row Del</button><!--
						--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
						-->
						<% if(!"Y".equals(sppType)){ %>
						<button class="btn_normal" name="btns_mvmt" id="btns_mvmt" type="button">Movement</button>
						<% } %>
						</div>
					<!-- opus_design_btn (E) -->
					<script type="text/javascript">ComSheetObject('t1sheet1');</script>
				</div>
				<!-- opus_design_grid(E) -->
				<!-- opus_design_data(S) -->
				<div class="opus_design_data">
					<table class="mar_btm_4">
						<colgroup>
							<col width="65" />				
							<col width="*" />				
					   </colgroup> 
					   <tbody>
					   		<tr> 
								<th>Desc.</th>			 			      
								<td><input readonly name="mnr_desc" id="mnr_desc" type="text" style="width:910px;" class="input2" value=""></td>
							</tr>
						 </tbody>
					</table>
					<table>
						<colgroup>
							<col width="65" />				
							<col width="*" />				
					   </colgroup> 
						<tbody>	
					   		<tr> 
								<th>Remark(s)</th>			 			      
								<td><textarea name="mnr_rpr_rmk" id="mnr_rpr_rmk" wrap="off" style="width:910px;background-color:beige;" rows="1"></textarea></td>
							</tr>
					   </tbody>
					</table>
				</div>
				<!-- opus_design_data(E) -->
		<!-- wrap_result(E) -->
	</div>
<!-- Tab2 (S) -->
	<div id="tabLayer" style="display:none"> 
			<!-- wrap_result(S) -->
			<div class="wrap_result">
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry wFit">
					<table>
						<colgroup>
							<col width="150" />				
							<col width="*" />				
					   </colgroup> 
						<tbody>	
							<tr>
								<th>Damage Location Code</th>	 
								<td><input type="text" name="damageLocationCode" id="damageLocationCode" style="width:543px;" class="input2" value="" readOnly></td> 
							</tr>
						</tbody>
					</table>
				</div>
				
				<!-- layout_wrap(S) -->
				<div class="layout_wrap" style="width: 100%">
					<!-- layout_vertical_2(S) -->
					<div class="layout_vertical_2" style="width:700px">
						<!-- layout_wrap(S) -->
						<div class="layout_wrap" style="width: 100%">
							<!-- layout_vertical_2(S) -->
							<div class="layout_vertical_2" style="width:130px;margin-right: 3%;">
								<table>
									<colgroup>
										<col width="35px">
										<col width="*">
									</colgroup>
									<tr>
										<td><font size="5">D</font></td>
										<td><!-- opus_design_grid(S) --><div class="opus_design_grid"><!--
										--><script type="text/javascript">ComSheetObject('t2_sheet1');</script><!--
										--></div></td>
									</tr>
								</table>
								<table><tr><td height="20px"></td></tr></table>
								<table>
									<colgroup>
										<col width="30px">
										<col width="*">
									</colgroup>
									<tr>
										<td><font size="5">F</font></td>
										<td><!-- opus_design_grid(S) --><div class="opus_design_grid"><!--
										--><script type="text/javascript">ComSheetObject('t2_sheet2');</script><!--
										--></div></td>
									</tr>
								</table>
							</div>
						     <!-- layout_vertical_2(E) -->
							<!-- layout_vertical_2(S) -->
							<div class="layout_vertical_2" style="width:260px;margin-right: 3%;">
								<table>
									<colgroup>
										<col width="20px">
										<col width="*">
									</colgroup>
									<tr>
										<td><font size="5">L</font></td>
										<td><!-- opus_design_grid(S) --><div class="opus_design_grid"><!--
										--><script type="text/javascript">ComSheetObject('t2_sheet3');</script><!--
										--><span class="grid_option_left"><h3>Front</h3></span>
											<span class="grid_option_right"><h3>Door</h3></span>
										</div></td>
									</tr>
								</table>
								<table>
									<colgroup>
										<col width="20px">
										<col width="*">
									</colgroup>
									<tr>
										<td><font size="5">R</font></td>
										<td><!-- opus_design_grid(S) --><div class="opus_design_grid"><!--
										--><script type="text/javascript">ComSheetObject('t2_sheet4');</script><!--
										--><span class="grid_option_left"><h3>Front</h3></span>
											<span class="grid_option_right"><h3>Door</h3></span>
										</div>
									</td>
									</tr>
								</table>
							</div>
						     <!-- layout_vertical_2(E) -->
							<!-- layout_vertical_2(S) -->
							<div class="layout_vertical_2" style="width:260px;">
								<table>
									<colgroup>
										<col width="20px">
										<col width="*">
									</colgroup>
									<tr>
										<td><font size="5">T</font></td>
										<td><!-- opus_design_grid(S) --><div class="opus_design_grid"><!--
										--><script type="text/javascript">ComSheetObject('t2_sheet5');</script><!--
										--><span class="grid_option_left"><h3>Door</h3></span>
											<span class="grid_option_right"><h3>Front</h3></span>
										</div>
									</td>
									</tr>
								</table>
								<table>
									<colgroup>
										<col width="30px">
										<col width="*">
									</colgroup>
									<tr>
										<td><font size="5">B</font></td>
										<td><!-- opus_design_grid(S) --><div class="opus_design_grid"><!--
										--><script type="text/javascript">ComSheetObject('t2_sheet6');</script><!--
										--><span class="grid_option_left"><h3>Door</h3></span>
											<span class="grid_option_right"><h3>Front</h3></span>
										</div>
									</td>
									</tr>
								</table>
								<table>
									<colgroup>
										<col width="30px">
										<col width="*">
									</colgroup>
									<tr>
										<td><font size="5">U</font></td>
										<td><!-- opus_design_grid(S) --><div class="opus_design_grid"><!--
										--><script type="text/javascript">ComSheetObject('t2_sheet7');</script><!--
										--></div>
									</td>
									</tr>
								</table>
							</div>
						     <!-- layout_vertical_2(E) -->
						</div>
						<!-- layout_wrap(E) -->
					</div>
				     <!-- layout_vertical_2(E) -->
					<!-- layout_vertical_2(S) -->
					<div class="layout_vertical_2 pad_left_12" style="width:260px">
						<!-- opus_design_grid(S) -->
						<div class="opus_design_grid">
							<h3 class="title_design">Photo</h3>
							<script type="text/javascript">ComSheetObject('t2_sheet8');</script>		
						</div>
						<!-- opus_design_grid(E) -->
					</div>
				     <!-- layout_vertical_2(E) -->
				</div>
				<!-- layout_wrap(E) -->
			</div>
			<!-- wrap_result(E) -->
	</div>	
</div>
</form>
<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>	 
