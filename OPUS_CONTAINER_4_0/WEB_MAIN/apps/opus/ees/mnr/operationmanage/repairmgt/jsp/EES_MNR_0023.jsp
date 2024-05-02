<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0023.jsp
*@FileTitle  : Repair Estimate Auditing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0023Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0023Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 

	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= "";  
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");

	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd();    

		event = (EesMnr0023Event)request.getAttribute("Event"); 
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
<script type="text/javascript">   
	var selfOfcCd = "<%=strOfc_cd%>";  
	function setupPage(){  
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if  
		loadPage();
	}	  
</script><script type="text/javascript">ComSheetObject('sheet1');</script>     

<form name="form" id="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- for distinguish issuing estimate and audit.(rqst_cre/rqst_aud) -->
<input type="hidden" name="rqst_type" value="rqst_aud" id="rqst_type" />
<!-- all input data is 'Manual' -->  
<input type="hidden" name="mnr_inp_tp_cd" value="M" id="mnr_inp_tp_cd" />
<input type="hidden" name="eq_tpsz_cd" value="" id="eq_tpsz_cd" />

<!-- AGMT data combo  --> 
<input type="hidden" name="edi_id" id="edi_id" />

<!-- to get AGMT data  -->	
<input type="hidden" name="agmt_ofc_cty_cd" id="agmt_ofc_cty_cd" />
<input type="hidden" name="agmt_seq" id="agmt_seq" />
<input type="hidden" name="agmt_ver_no" id="agmt_ver_no" />

<!-- key value for save estimate  -->
<input type="hidden" name="rpr_rqst_seq" id="rpr_rqst_seq" />
<input type="hidden" name="rpr_rqst_ver_no" id="rpr_rqst_ver_no" />
<input type="hidden" name="rpr_sts_cd" id="rpr_sts_cd" />
<input type="hidden" name="rpr_offh_flg" value="N" id="rpr_offh_flg" />
<input type="hidden" name="disp_flg" value="N" id="disp_flg" />
<input type="hidden" name="rpr_rqst_tmp_seq" value="1" id="rpr_rqst_tmp_seq" />
<input type="hidden" name="rpr_rqst_lst_ver_flg" value="Y" id="rpr_rqst_lst_ver_flg" />
<input type="hidden" name="n3pty_flg" value="N" id="n3pty_flg" />
<input type="hidden" name="file_seq" value="" id="file_seq" />
<input type="hidden" name="rqst_usr_id" id="rqst_usr_id" />
<input type="hidden" name="rpr_dtl_sts_cd" id="rpr_dtl_sts_cd" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />
<input type="hidden" name="apro_ofc_cd" value="<%=strOfc_cd%>" id="apro_ofc_cd" />

<!-- RD  --> 
<input type="hidden" name="com_mrdPath" value="apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0181.mrd" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdBodyTitle" value="" id="com_mrdBodyTitle" />

<!-- audit column  --> 		
<input type="hidden" name="auto_amt" id="auto_amt" />
<input type="hidden" name="appoval_amt" id="appoval_amt" />
<input type="hidden" name="uppr_ofc_cd" id="uppr_ofc_cd" />

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
			--><button class="btn_normal" name="btn_Later" id="btn_Later" type="button">Audit it Later</button><!--
			--><button class="btn_normal" name="btn_Counteroffer" id="btn_Counteroffer" type="button">Counteroffer</button><!--
			--><button class="btn_normal" name="btn_Reject" id="btn_Reject" type="button">Reject</button><!--
			--><button class="btn_normal" name="btn_Approval" id="btn_Approval" type="button">Approval</button><!--
			--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	
		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	
	<div class="wrap_search_tab">
	
		 <!-- layout_wrap(S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width:410px;">
		     	<!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry">
					<table style="width:399px;">
						<colgroup>
							<col width="110" />					
							<col width="*" />				
					   </colgroup> 
					   <tbody>
					   		<tr>
						   		<th>Service Provider</th>
								<td><input type="text" name="vndr_nm" style="width:277px;" class="input2" value="" readonly id="vndr_nm" /> </td>
					   		</tr>
					   </tbody>
					</table>
					
					<table style="width:399px;">
						<colgroup>
							<col width="80" />				
							<col width="160" />				
							<col width="80" />							
							<col width="*" />				
					   </colgroup> 
					   <tbody>
					   		<tr> 	
								<th>Tariff No.</th>
								<td><input type="text" name="trf_no" style="width:129px;" class="input2" value="" readonly id="trf_no" /> </td>
								<th>Cost Office</th>
								<td><input tabindex="0" type="text" name="cost_ofc_cd" style="width:75px;" class="input2" value="" readonly id="cost_ofc_cd" /> </td>
							</tr>			
							<tr>     
								<th>EQ Type</th>
								<td><script type="text/javascript">ComComboObject('eq_knd_cd', 1, 130, 1, 3,0,false,0);</script></td>
								<th>Currency</th>
								<td><input type="text" name="curr_cd" style="width:75px;" class="input2" value="" readonly id="curr_cd" /> </td>
							</tr>	
							<tr>     
								<th>Transmission</th>
								<td><script type="text/javascript">ComComboObject('trsm_mod_cd', 1, 130, 1, 3,0,false,0);</script></td>
								<th>Measure</th>
								<td><input type="text" name="mnr_meas_ut_nm" style="width:75px;" class="input2" value="" readonly id="mnr_meas_ut_nm" /> </td>	
							</tr>		
					   </tbody>
					</table>
				</div>
		    </div>
		    <div class="layout_vertical_2" style="width:60%;">
		         <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
		            <script type="text/javascript">ComSheetObject('sheet2');</script>
		        </div>
		        <!-- opus_design_grid(e) -->
		    </div>
		</div>
		<!-- layout_wrap(e) -->	
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div class="opus_design_inquiry ">

			<table>
				<colgroup>
					<col width="70" />				
					<col width="140"/>				
					<col width="80" />				
					<col width="140"/>				
					<col width="100" />	
					<col  width="138"/>
					<col  width="80"/>			
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
						<th>EQ No.</th>
						<td><input maxlength="14" style="width:120px;" type="text" name="rqst_eq_no" value="" dataformat="engup" caption="EQ No" class="input2" readonly id="rqst_eq_no" /></td> 
						<th>Estimate No.</th>
						<td><input  maxlength="20" style="width:170px;" type="text" name="rqst_ref_no" otherchar="-" value="" dataformat="engup" caption="Estimate No" class="input2" readonly id="rqst_ref_no" /></td>			   
						<th>Repair Yard</th>
						<td><input style="width:80px;" type="text" name="rpr_yd_cd" value="" dataformat="engup" maxlength="7" caption="yard cd" class="input2" readonly="" id="rpr_yd_cd" /><button type="button" id="btn_popup" name="btn_popup" class="input_seach_btn"></button></td>	 			
						<th>Repair Status</th>
						<td colspan="2"><script type="text/javascript">ComComboObject('rpr_wrk_tp_cd', 1, 160, 1, 1, 0, false, 0);</script></td>	
					</tr>				 
					<tr>	
						<th>Damage Date</th>
						<td><input name="eq_dmg_dt" type="text" style="width:80px;" class="input2" value="" dataformat="ymd" maxlength="10" readonly="" id="eq_dmg_dt" /></td>		
						<th>Input User</th>
						<td><input type="text" style="width:170px;" name="rqst_usr_nm" dataformat="engup" maxlength="50" class="input2" size="10" value="" readonly="" id="rqst_usr_nm" /></td>		
						<th>Input Date</th>
						<td><input type="text" style="width:83px;" name="rqst_dt" dataformat="ymd" maxlength="10" class="input2" size="10" value="" readonly="" id="rqst_dt" /></td>		 
						<th>Off-hire</th>
						<td><input name="rpr_offh_flg_temp" type="checkbox" value="Y" class="trans" id="rpr_offh_flg_temp" /> </td>
						<th width="80">Gate-In Date</th>
						<td><input type="text" style="width:80;" name="mvmt_dt" dataformat="ymd" maxlength="10"  class="input2" size="10"  value="" readonly></td>
					</tr>
			   </tbody>
			</table>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<div class="opus_design_data" style="width:979px;">
				<table class="grid_2">
					<colgroup>
						<col width="60" />				
						<col width="90" />				
						<col width="60" />				
						<col width="90" />	
						<col width="30" />				
						<col width="90" />
						<col width="30" />				
						<col width="90" />			
						<col width="30" />	
						<col width="60" />				
						<col width="90" />
						<col width="80" />	
						<col width="80" />
						<col width="80" />	
						<col width="100" />	
						<col width="*" />				
				   </colgroup> 
				   <tbody>
				   		<tr>
				   			<th style="text-align:center;">Repair </th>
							<td  id="Repair" name="Repair"></td>
							<td><button class="btn_etc"  id="btn_detail" name="btn_detail" type="button">Detail(s)</button></td>	 		
							<th style="text-align:center;">IMM.EXIT</th>
							<td  id="ImmExit" name="ImmExit" > </td>
							<th style="text-align:center;">Off-hire</th>
							<td  id="OffHire" name="OffHire" > </td>
							<th style="text-align:center;">Disposal</th>
							<td  id="Disposal" name="Disposal" > </td>
							<th  style="text-align:center;">DPP&nbsp;(USD)</th>
							<td  id="DPP" name="DPP" > </td>
							<th style="text-align:center;">DV Value(USD)</th>
							<td  id="DvValue" name="DvValue" > </td>
							<th style="text-align:center;">RU Label Type</th>
							<td  id="ruDiv" name="ruDiv" > </td>
						</tr>	
						<tr>
							<th style="text-align:center;">MANU.DT</th>
							<td colspan="2" id="ManuDt" name="ManuDt" > </td>
							<th style="text-align:center;">TP/SZ</th>
							<td  id="TpSz" name="TpSz" > </td>
							<th style="text-align:center;"> Term</th>
							<td  id="Term" name="Term" > </td>
							<th style="text-align:center;">Lessor</th>
							<td colspan="3" id="Lessor" name="Lessor" > </td>
							<th style="text-align:center;">Warranty</th>
							<td  id="Warranty" name="Warranty" > </td>
							<th style="text-align:center;">RU Label Value</th>
							<td  id="ruLabel" name="ruLabel" > </td>
						</tr>
				   </tbody>
				</table>
			</div>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_tab(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		<!-- opus_design_tab(E) -->
		
		
		<!-- Tab1 (S) -->
		<div id="tabLayer" style="display:inline">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<button class="btn_accent" name="btn_Verify" id="btn_Verify" type="button">Verify</button><!--
					--><button class="btn_normal" name="btn_RowAdd" id="btn_RowAdd" type="button">Row Add</button><!--
					--><button class="btn_normal" name="btn_RowDel" id="btn_RowDel" type="button">Row Delete</button><!--
					--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
					--><button class="btn_normal" name="btns_mvmt" id="btns_mvmt" type="button">Movement</button>
					</div>
				<!-- opus_design_btn (E) -->
				<script type="text/javascript">ComSheetObject('t1sheet1');</script>		
			</div>
			<!-- opus_design_grid(E) -->
			<div class="opus_design_inquiry wFit">
				<table class="grid2"> 
					<colgroup>
						<col width="70" />						
						<col width="*" />				
				   </colgroup>
					<tbody>
						<tr>
							<th>Desc.</th>
							<td><input readonly name="mnr_desc" type="text" style="width:99%;" class="input2" value="" id="mnr_desc" /> </td>
						</tr>		
						<tr>		
							<th>Remark(s)</th>
							<td><textarea name="mnr_rpr_rmk" id="mnr_rpr_rmk" wrap="off" style="width:99%;height:22px;background-color:beige; resize:none;"></textarea></td>
						</tr>
					</tbody>
				</table> 
			</div>
			
			
		</div>
		<!-- Tab1 (E) -->
		
		<!-- Tab2 (S) -->
		<div id="tabLayer" style="display:none"> 
						
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
			    <div class="layout_vertical_2" style="width:820px" >
			    	    <div id="t2_selection1" name="t2_selection1"> 
							<table style="width:650px;"> 
								<colgroup>
									<col  width="140"/>						
									<col  width="510" />				
							   </colgroup> 
						     	<tbody>
									<tr>
										<th>Damage Location Code</th>
										<td><input type="text" name="damageLocationCode" style="width:500px;" class="input2" value="" readonly id="damageLocationCode" /> </td>
									</tr>
								</tbody>
							</table>
							<table><tr><td height="5"></td></tr></table>
						</div>
				    	 <div id="t2_selection2" name="t2_selection2"> 
				    	 	<table><tr><td height="15px"></td></tr></table>
					    	 <!-- layout_wrap(S) -->
							 <div class="layout_wrap">
								<div class="layout_vertical_2" style="width:140px">
								     <table>
								     	<colgroup>
											<col  width="50"/>						
											<col  width="140" />				
									   </colgroup> 
								     	<tbody>
											<tr>
												<td  align="center"><font size="5"><b>D</b></font></td>
												<td style="height:140px;" valign="top">  
													 <!-- opus_design_grid(S) -->
	       											 <div class="opus_design_grid">
														<script type="text/javascript">ComSheetObject('t2_sheet1');</script>
													</div>
													 <!-- opus_design_grid(E) -->
												</td>
											</tr>
											<tr>  
												<td  align="center"><font size="5"><b>F</b></font></td>
												<td style="height:140px;" valign="top">
													  <!-- opus_design_grid(S) -->
	     											 	<div class="opus_design_grid">
															<script type="text/javascript">ComSheetObject('t2_sheet2');</script>
														</div>
													 <!-- opus_design_grid(E) -->
												</td>
											</tr>
										</tbody>
									</table>
								 </div>
								    
							    <div class="layout_vertical_2" style="width:280px;">
							        <!-- opus_design_grid(S) -->
							        <div class="opus_design_grid">						          
										<table>
											<colgroup>
												<col  width="80"/>						
												<col  width="110" />
												<col width="*"/>				
										   </colgroup> 
									     	<tbody>
												<tr>
													<td  align="center"><font size="5"><b>L</b></font></td>
													<td colspan="2" style="height:100px;" valign="top">
													    <!-- opus_design_grid(S) -->
	     											 	<div class="opus_design_grid">
															<script type="text/javascript">ComSheetObject('t2_sheet3');</script>
														</div>
													 	<!-- opus_design_grid(E) -->
														
													</td>
												</tr>
												<tr>
													<td></td>
													<th align="left">Front</th>
													<th align="right">Door</th>
												</tr>
												<tr>
													<td colspan="3" height="5"></td>
												</tr>
												<tr>
													<td  align="center"><font size="5"><b>R</b></font></td>
													<td colspan = "2" style="height:100px;" valign="top"> 
														 <!-- opus_design_grid(S) -->
	     											 	<div class="opus_design_grid">
															<script type="text/javascript">ComSheetObject('t2_sheet4');</script>
														</div>
													 	<!-- opus_design_grid(E) -->
													 	
													</td>
												</tr>
												<tr>
													<td></td>
													<th align="left">Front</th>
													<th align="right">Door</th>
												</tr>
												<tr>
													<td></td>
												</tr>
											</tbody>
										</table>
							        </div>
							        <!-- opus_design_grid(E) -->
							    </div>
							    
							     <div class="layout_vertical_2" style="width:280px;">
							        <!-- opus_design_grid(S) -->
							        <div class="opus_design_grid">
							           	<table>
							           		<colgroup>
												<col  width="80"/>						
												<col  width="110" />
												<col width="*"/>				
										   </colgroup> 
									     	<tbody>
												<tr>
													<td  align="center"><font size="5"><b>T</b></font></td>
													<td colspan = "2" style="height:60px;" valign="top">
														 <!-- opus_design_grid(S) -->
	     											 	<div class="opus_design_grid">
															<script type="text/javascript">ComSheetObject('t2_sheet5');</script>
														</div>
													 	<!-- opus_design_grid(E) -->
													</td>
												</tr>
												<tr>
													<td></td>
													<th align="left">Front</th>
													<th align="right">Door</th>
												</tr>
												<tr>
													<td colspan="3" height="5"></td>
												</tr>
												<tr>
													<td  align="center"><font size="5"><b>B</b></font></td>
													<td colspan = "2" style="height:60px;" valign="top">
													 <!-- opus_design_grid(S) -->
	     											 	<div class="opus_design_grid">
															<script type="text/javascript">ComSheetObject('t2_sheet6');</script>
														</div>
													 	<!-- opus_design_grid(E) -->
													</td>
												</tr>
												<tr>
													<td></td>
													<th align="left">Front</th>
													<th align="right">Door</th>
												</tr>
												<tr>
													<td colspan="3" height="5"></td>
												</tr>
												<tr>
													<td align="center"><font size="5"><b>U</b></font></td>
													<td colspan = "2">
														<!-- opus_design_grid(S) -->
	     											 	<div class="opus_design_grid">
															<script type="text/javascript">ComSheetObject('t2_sheet7');</script>
														</div>
													 	<!-- opus_design_grid(E) -->
													</td>
												</tr>
											</tbody>
										</table>
							        </div>
							        <!-- opus_design_grid(E) -->
							    </div>
							</div>
						   <!-- layout_wrap(E) -->
				       </div>
				    </div>
				    
				   
				    <div class="layout_vertical_2" style="width:350px;" >
				    	
				        <!-- opus_design_grid(S) -->
				        <div class="opus_design_grid" >
				        	<h3 class="title_design">Photo</h3>
				            <!-- opus_design_btn (S) -->
							<div class="opus_design_btn">
								<button class="btn_accent" name="btn_FileAdd" id="btn_FileAdd" type="button">Row Add</button><!--
								--><button class="btn_normal" name="btn_FileDel" id="btn_FileDel" type="button">Row Delete</button><!--
								--></div>
							<!-- opus_design_btn (E) -->
							
							<script type="text/javascript">ComSheetObject('t2_sheet8');</script> 
				        </div>
				        <!-- opus_design_grid(E) -->
				    </div>
				  </div>
			</div>
			<!-- layout_wrap(E) -->
			
			
		</div>
		<!-- Tab2 (E) -->
	<div style="display:none">
		<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
	</div>
</form>


