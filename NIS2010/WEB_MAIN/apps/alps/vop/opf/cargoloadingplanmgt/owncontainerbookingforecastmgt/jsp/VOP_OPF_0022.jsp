<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0022.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.13
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.10.13 김도현
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0022Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopOpf0022Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CBF for Own Booking (Creation)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var userId = '<%=strUsr_id%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="condition_gb">
<input type="hidden" name="condition_gb2">
<input type="hidden" name="tabSelectedIdx" value="0">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pol_clpt_ind_seq">
<input type="hidden" name="dcgo_flg">
<input type="hidden" name="rc_flg">
<input type="hidden" name="awk_cgo_flg">
<input type="hidden" name="bb_cgo_flg">
<input type="hidden" name="bdl_cgo_flg">
<input type="hidden" name="stwg_cgo_flg">
<input type="hidden" name="mty_bkg_flg">
<input type="hidden" name="carrier_cd">
<input type="hidden" name="pod_chk">
<input type="hidden" name="imdg_un_no">
<input type="hidden" name="imdg_subs_rsk_lbl_cd">
<input type="hidden" name="cntr_tpsz_cd" value=" "/>
<input type="hidden" name="re_seach_yn">
<input type="hidden" name="crrCd">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">	
	<tr>
		<td valign="top">
		
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
			
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       			<tr>
       				<td class="btn1_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save" id="btn_Retrieve">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
								 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<!-- <td class="btn2" name="btn_crr_cd_add">Carrier Add</td> -->
											<td class="btn1" name="btn_preview">Preview</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
									
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New" id="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Del" id="btn_Retrieve">Delete</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								
									<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_EdiCheck" id="btn_EdiCheck">EDI</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								
						
							</tr>
						</table>
					</td>
				</tr>
			</table>
    		<!--Button (E) -->
			<!--biz page (S)-->
			<table class="search" border="0"> 
       			<tr>
       				<td class="bg">
						<!-- biz_1  (S) -->
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="40">VVD</td>
								<td width="150">
									<input name="vsl_cd" type="text" style="width:40;" class="input1" value="" caption="VVD CD" required fullfill maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input name="skd_voy_no" type="text" style="width:40;" class="input1" value="" caption="VVD CD" required fullfill maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input name="skd_dir_cd" type="text" style="width:20;" class="input1" value="" caption="VVD CD" fullfill required maxlength="1" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_vvd">&nbsp;<input name="vsl_eng_nm" type="hidden" style="width:120;" class="input2" value="" readonly><input type="text" style="width:0;" name="noname" readOnly>
								</td>
								<td width="30">POL</td>
								<td width="120">
									<script language="javascript">ComComboObject('yd_cd', 1, 80, 0);</script>&nbsp;
									<input type="hidden" style="width:50;" class="input2" name="loc_nm" readOnly>&nbsp;
									<input type="hidden" style="width:88;" class="input2" name="yd_nm" readOnly>
								</td> 
								<td width="40">Lane</td>
								<td width="60">
									<input name="slan_cd" type="text" style="width:40;" class="input2" value="" readOnly>&nbsp;
									<input name="slan_nm" type="hidden" style="width:138;" class="input2" value="" readOnly>
								</td>
								<td width="30">ETA</td>
								<td width="120">
									<input type="text" style="width:110;text-align:center;" class="input2" name="eta" readOnly>
								</td>
								<td width="80" align="center">Created</td>
								<td width="120">
									<input type="hidden" style="width:65;text-align:center;" class="input2" name="upd_usr_id" readOnly>&nbsp;<input type="text" style="width:110;text-align:center;" class="input2" name="cre_dt" readOnly>
								</td>
								<td width="" align="center" >Updated&nbsp;<input type="hidden" style="width:65;text-align:center;" class="input2" name="upd_usr_id" readOnly>&nbsp;<input type="text" style="width:110;text-align:center;" class="input2" name="upd_dt" readOnly></td>
								
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								
								<td width="80">BKG Status</td>
								<td width="150">
									<input type="radio" value="All" name="bkg_sts_cd" class="trans" checked>All
									<input type="radio" value="F" name="bkg_sts_cd" class="trans">Firm
								</td>
								
								<td width="40" align="">
								<table class="search" border="0" style="width:150;padding:2 2 2 2">
										<tr class="h23">
											<td width="30">&nbsp;&nbsp;&nbsp;CBF</td> 
											<td width="" class="stm">
												<input type="radio" value="P" name="cbf_ind_flg" class="trans" checked>Pre&nbsp;
												<input type="radio" value="F" name="cbf_ind_flg" class="trans">Final
											</td>
										</tr>
									</table>
								</td>
								<td width="20"><script language="javascript" >ComComboObject('pod_cd', 2, 0, 0);</script></td>
								
								<td width="560" align="">
									<!--  Button_Sub (S) -->
									<table width="100%" class="button"> 
								       	<tr>
								       		<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
														<tr>
														<td align="center">
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																    <td class="btn2_left">&nbsp;</td>
																	<td class="btn2" name="btn_IFBkgDt">&nbsp;&nbsp;I/F BKG&nbsp;&nbsp;</td>
																	<td class="btn2_right">&nbsp;</td>
																	<td class="btn2_left">&nbsp;</td>
																	<td class="btn2" name="btn_IFPrnrEdi">&nbsp;I/F Partner&nbsp;</td>
																	<td class="btn2_right">&nbsp;</td>
																    	<td class="btn2_left">&nbsp;</td>
																	<td class="btn2" name="btn_Wgt">&nbsp;WGT&nbsp;</td>
																	<td class="btn2_right">&nbsp;</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
	    							<!-- Button_Sub (E) -->
								</td>
							<!-- 	<td width="105" align=""> -->
									<!--  Button_Sub (S) -->
							<!--		<table width="100%" class="button"> 
								       	<tr>
								       		<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
														<tr>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_IFDCUBE">&nbsp;I/F EDI&nbsp;</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>-->
	    							<!-- Button_Sub (E) -->
								</td>
								
							</tr>
						</table>					
					</td>
				</tr>
			</table>		
			
   			<table class="height_8"><tr><td></td></tr></table>
			<!-- Tab (S) -->
<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
<tr align="left">
	<td width=24%>
		<table width="50%" border="0" cellpadding="0" cellspacing="0" class="search">
			<tr>
				<td><b><font color="navy">Volume by Carrier</font></b></td>
				
			</tr>
		</table>
	</td>
	<td width=1%>&nbsp;</td>
	<td>
		<table width="30%" border="0" cellpadding="0" cellspacing="0" class="search">
			<tr>
				<td><b><font color="navy">Special Item</font></b></td>
				
			</tr>
		</table>
	</td>
</tr>
<tr align="right">
	<td width=24%>
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									 <td>
									 <table class="search" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									 <tr class="h23">
									  <td width="51" >&nbsp;</td>
								      <td width="136"> <script language="javascript">ComComboObject('crr_cd', 2, 0, 0);</script>
								      
								   <!--   <input type="hidden" name="crr_cd">-->
								      <input type="hidden" name="crr_cd_nm"></td>
								      </tr>
								      </table>
								      </td>
								
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<!-- <td class="btn2" name="btn_crr_cd_add">Carrier Add</td> -->
												<td class="btn2" name="btn_crr_cd_add">OPR Add</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<!-- <td class="btn2" name="btn_crr_cd_del">Carrier Delete</td> -->
												<td class="btn2" name="btn_crr_cd_del">OPR Del</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
					
    			<!-- Button_Sub (E) --> 		 
		 
	</td>
	<td width=1%>&nbsp;</td>
	<td>
   			<table class="" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
			</table>
	</td>
</tr>
<tr>
	<td width=38%>	
	            
    			<table class="" border="0" cellpadding="0" cellspacing="0" width="100%">
    		
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet1');</script>
					</td>
				</tr>
				</table>
	            
    			<table class="" border="0" cellpadding="0" cellspacing="0" width="100%">
    		
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet1');</script>
					</td>
				</tr>
				</table>
				
				<table class="" border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td>
							<table class="search" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr class="h23">
									<td>Total&nbsp;<input name="tot_tot_qty" type="text" style="width:50;" class="input2" value="" maxlength="8" dataformat="float" style="TEXT-ALIGN: right" ></td>
									<td>20'&nbsp;<input name="tot_20ft_qty" type="text" style="width:50;" class="input2" value="" maxlength="8" dataformat="float" style="TEXT-ALIGN: right" ></td>
									<td>40'&nbsp;<input name="tot_40ft_qty" type="text" style="width:50;" class="input2" value="" maxlength="8" dataformat="float" style="TEXT-ALIGN: right" ></td>
									<td>40H'&nbsp;<input name="tot_40ft_hc_qty" type="text" style="width:50;" class="input2" value="" maxlength="8" dataformat="float" style="TEXT-ALIGN: right" ></td>
									<td>45&nbsp;<input name="tot_45ft_hc_qty" type="text" style="width:50;" class="input2" value="" maxlength="8" dataformat="float" style="TEXT-ALIGN: right" ></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				
				<table class="" border="0" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td>
										<table class="search" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr class="h23">
											    <td width="40%">&nbsp;</td>
												<td>Weight&nbsp;<input name="cgo_grs_wgt" type="text" style="width:140;" class="input" value="" maxlength="8" dataformat="float" style="TEXT-ALIGN: right" > KGS</td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td>&nbsp;</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
				
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
       				<tr>
       					<td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_RowAdd_carr_pod">POD Add</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_RowDelete_carr_pod">POD Delete</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
    			<!-- Button_Sub (E) --> 
	</td>
	<td rowspan="2" width=1%>&nbsp;</td>
	<td rowspan="2">	
			<!-- Tab (E) -->
			<table width="100%"> 
   				<tr>
   					<td class="bg">
						<!--  Tab_1 (S) -->
						<div id="tabLayer" style="display:inline">
       					<table class="search">
           					<tr>
           						<td>		
									<!-- Grid  (S) -->
									<table width="100%"  id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('t3sheet1');</script>
											</td>					
										</tr>
									</table>
									<!-- Grid (E) -->
									<!--  Button_Sub (S) -->
									<table width="100%" class="button"> 
					       				<tr>
					       					<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_RowAdd_dg">Row Add</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_RowDelete_dg">Row Delete</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
					    			<!-- Button_Sub (E) --> 
								</td>
							</tr>
						</table>
   						</div>
						<!--  Tab_1 (E) -->			
						<!--  Tab_2 (S) -->
						<div id="tabLayer" style="display:none">
					        <table class="search">
					            <tr>
					            	<td>
										<table width="100%"  id="mainTable"> 
											<tr>
												<td width="100%">
													<script language="javascript">ComSheetObject('t4sheet1');</script>
												</td>
											</tr>
										</table>
									<!--  Button_Sub (S) -->
									<table width="100%" class="button"> 
					       				<tr>
					       					<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_RowAdd_awk">Row Add</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_RowDelete_awk">Row Delete</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
					    			<!-- Button_Sub (E) --> 
									</td>
								</tr>
							</table>
					    </div>						
						<!--  Tab_2 (E) -->
						
						<!--  Tab_3 (S) -->
						<div id="tabLayer" style="display:none">
					        <table class="search">
					            <tr>
					            	<td>
										<table width="100%"  id="mainTable"> 
											<tr>
												<td width="100%">
													<script language="javascript">ComSheetObject('t5sheet1');</script>
												</td>
											</tr>
										</table>
										<!--  Button_Sub (S) -->
										<table width="100%" class="button"> 
						       				<tr>
						       					<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_RowAdd_bb">Row Add</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_RowDelete_bb">Row Delete</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
						    			<!-- Button_Sub (E) --> 
									</td>
								</tr>
							</table>
					    </div>						
						<!--  Tab_3 (E) -->
						
						<!--  Tab_4 (S) -->
						<div id="tabLayer" style="display:none">
					        <table class="search">
					            <tr>
					            	<td>
										<table width="100%"  id="mainTable"> 
											<tr>
												<td width="100%">
													<script language="javascript">ComSheetObject('t6sheet1');</script>
												</td>
											</tr>
										</table>
										<!--  Button_Sub (S) -->
										<table width="100%" class="button"> 
						       				<tr>
						       					<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_RowAdd_rf">Row Add</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_RowDelete_rf">Row Delete</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
						    			<!-- Button_Sub (E) --> 
									</td>
								</tr>
							</table>
					    </div>						
						<!--  Tab_4 (E) -->
						
						<!--  Tab_5 (S) -->
						<div id="tabLayer" style="display:none">
					        <table class="search">
					            <tr>
					            	<td>
										<table width="100%"  id="mainTable"> 
											<tr>
												<td width="100%">
													<script language="javascript">ComSheetObject('t7sheet1');</script>
												</td>
											</tr>
										</table>
										<!--  Button_Sub (S) -->
										<table width="100%" class="button"> 
						       				<tr>
						       					<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_RowAdd_mty">Row Add</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_RowDelete_mty">Row Delete</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
						    			<!-- Button_Sub (E) --> 
									</td>
								</tr>
							</table>
					    </div>						
						<!--  Tab_5 (E) -->
						
						
						<!--  Tab_6 (S) -->
						<div id="tabLayer" style="display:none">
					        <table class="search">
					            <tr>
					            	<td>
										<table width="100%"  id="mainTable"> 
											<tr>
												<td width="100%">
													<script language="javascript">ComSheetObject('t8sheet1');</script>
												</td>
											</tr>
										</table>
										<!--  Button_Sub (S) -->
										<table width="100%" class="button"> 
						       				<tr>
						       					<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_RowAdd_bn">Row Add</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_RowDelete_bn">Row Delete</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
						    			<!-- Button_Sub (E) --> 
									</td>
								</tr>
							</table>
					    </div>						
						<!--  Tab_6 (E) -->
						
						<!--  Tab_7 (S) -->
						<div id="tabLayer" style="display:none">
					        <table class="search">
					            <tr>
					            	<td>
										<table width="100%"  id="mainTable"> 
											<tr>
												<td width="100%">
													<script language="javascript">ComSheetObject('t9sheet1');</script>
												</td>
											</tr>
										</table>
										<!--  Button_Sub (S) -->
										<table width="100%" class="button"> 
						       				<tr>
						       					<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_RowAdd_stwg">Row Add</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_RowDelete_stwg">Row Delete</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
						    			<!-- Button_Sub (E) --> 
									</td>
								</tr>
							</table>
					    </div>						
						<!--  Tab_7 (E) -->

					</td>
				</tr>
			</table>
	</td>
</tr>
</table>
			
			<!-- Tab BG Box(E) -->
			<!--biz page (E)-->
			<table class="height_10"><tr><td></td></tr></table>
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>