<%/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_SCG_0103.jsp
*@FileTitle : Packing Instruction & Special Packing Provision-Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.22
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2010.01.27 나상보
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0103Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0103Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoMasterDataMgt.SpecialCargoMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0103Event)request.getAttribute("Event");
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
<title>User Management (Creation/Inquiry)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<SCRIPT LANGUAGE="javascript" SRC="apps/alps/vop/scg/specialcargomasterdatamgt/specialcargomasterdatamgt/script/VOP_SCG_0103_01.js" TYPE="text/javascript"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="apps/alps/vop/scg/specialcargomasterdatamgt/specialcargomasterdatamgt/script/VOP_SCG_0103_02.js" TYPE="text/javascript"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="apps/alps/vop/scg/specialcargomasterdatamgt/specialcargomasterdatamgt/script/VOP_SCG_0103_03.js" TYPE="text/javascript"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="apps/alps/vop/scg/specialcargomasterdatamgt/specialcargomasterdatamgt/script/VOP_SCG_0103_04.js" TYPE="text/javascript"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="apps/alps/vop/scg/specialcargomasterdatamgt/specialcargomasterdatamgt/script/VOP_SCG_0103_05.js" TYPE="text/javascript"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="apps/alps/vop/scg/specialcargomasterdatamgt/specialcargomasterdatamgt/script/VOP_SCG_0103_06.js" TYPE="text/javascript"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="apps/alps/vop/scg/specialcargomasterdatamgt/specialcargomasterdatamgt/script/VOP_SCG_0103_07.js" TYPE="text/javascript"></SCRIPT>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="ibflag" value="U">
<input type="hidden" name="delt_flg" value="N">
<input type="hidden" name="pck_div_cd" value="P">
<input type="hidden" name="pck_desc_use_flg" value="N">
<input type="hidden" name="pck_regu_use_flg" value="N">
<input type="hidden" name="inr_pck_use_flg" value="N">
<input type="hidden" name="intmd_pck_use_flg" value="N">
<input type="hidden" name="outr_pck_use_flg" value="N">
<input type="hidden" name="outr_pck_max_capa_flg" value="N">
<input type="hidden" name="sgl_pck_use_flg" value="N">
<input type="hidden" name="sgl_pck_max_capa_flg" value="N">
<input type="hidden" name="prss_desc_use_flg" value="N">
<input type="hidden" name="add_regu_desc_use_flg" value="N">
<input type="hidden" name="spcl_pck_regu_use_flg" value="N">
<input type="hidden" name="gas_use_flg" value="N">
<input type="hidden" name="pck_expt_flg" value="N">

<!-- 개발자 작업	-->
	<!-- Outer Table (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
			
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<div id="searchLayer">
				<table class="search">
					<tr><td class="bg">					
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="150">Pack. Instruct. Code</td>
								<td width="130"><input type="text" name="imdg_pck_instr_cd" caption="Pack. Instruct. Code" maxlength="7" style="width:120;ime-mode:disabled;" class="input1" value=""></td>
								<td width="30">Seq.</td>
								<td width="130"><input type="text" name="imdg_pck_instr_seq" caption="Seq." readonly style="width:40;text-align:center;" class="input1" value="">&nbsp;<img src="img/btns_back.gif" name="btn_SeqPrev" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<img src="img/btns_next.gif" name="btn_SeqNext" width="19" height="20" alt="" border="0" align="absmiddle"></td> 
								<td width="30">Max.</td>
								<td width="50"><input type="text" name="pck_cd_seq_max" caption="Max." readonly style="width:40;text-align:center;" class="input2" value=""></td> 
								<td width="30">Min.</td>
								<td width="150"><input type="text" name="pck_cd_seq_min" caption="Min." readonly style="width:40;text-align:center;" class="input2" value=""></td> 
								<td width="120">Total Data Count</td>
								<td width="89"><input type="text" name="pck_cd_seq_cnt" caption="Total Date Count" readonly style="width:40;text-align:center;" class="input2" value=""></td>
								<td width="150" align="right">Check Exception &nbsp;&nbsp;<input type="checkbox" name="pck_expt_box"></td>
							</tr>
							<tr class="h23">
								<td>Title suffix</td>
								<td><input type="text" name="pck_instr_tp_ctnt" style="width:120;" class="input" value=""></td>
								<td width="15%" colspan="6">
									<input type="radio" name="pck_div_cd_radio" value="P" class="trans" checked>&nbsp;P&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="pck_div_cd_radio" value="I" class="trans">&nbsp;IBC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="pck_div_cd_radio" value="L" class="trans">&nbsp;LP&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    <input type="radio" name="pck_div_cd_radio" value="T" class="trans">&nbsp;Tank</td> 
 								<td>Update</td>
								<td colspan="2"><input type="text" name="upd_dt" style="width:110;" readonly class="input2" value=""></td>
							</tr>
						</table>
					</td></tr>
				</table>
			</div>
			<table class="height_8"><tr><td></td></tr></table>
			<!-- TABLE '#D' : ( Tab ) (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" style=""> 
       			<tr>
       				<td width="100%">
						<script language="javascript">ComTabObject('tab1');</script>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Tab ) (E) -->
				
			<!-- THIS IS 1st TAB (S) -->	
			<div id="tabLayer" style="display:inline">
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Packing Instruct. Header-1</td>
									<td width="130" align="right">Use Flag &nbsp;&nbsp;<input type="checkbox" name="pck_desc_use_box"></td>
								</tr>
								<tr class="h23">
									<td width="" colspan="3">
										<textarea name="pck_desc" style="width:100%" rows="4"></textarea>
									</td>
								</tr>
							</table>
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<!-- : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Packing Instruct. Header-2</td>
									<td width="130" align="right">Use Flag &nbsp;&nbsp;<input type="checkbox" name="pck_regu_use_box"></td>
								</tr>
								<tr><td colspan="3"><script language="javascript">ComSheetObject('t1sheet1');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn1_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn1_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- THIS IS 1st TAB (E) -->
			
			<!-- THIS IS 2nd TAB (S) -->
			<div id="tabLayer" style="display:none">			
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<!-- inner packaging : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Inner Packaging</td>
									<td width="130" align="right">Use Flag &nbsp;&nbsp;<input type="checkbox" name="in_pkg_use_box"></td>
								</tr>
								<tr><td colspan="3"><script language="javascript">ComSheetObject('t2sheet1');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_1_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_1_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_1_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- inner packaging : ( Grid ) (E) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<!-- Intermediate packaging : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Intermediate Packaging</td>
									<td width="130" align="right">Use Flag &nbsp;&nbsp;<input type="checkbox" name="intmd_pkg_use_box"></td>
								</tr>
								<tr><td colspan="3"><script language="javascript">ComSheetObject('t2sheet2');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_2_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_2_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_2_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- Intermediate packaging : ( Grid ) (E) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<!-- Outer packaging : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Outer Packaging</td>
									<td width="130" align="right">Use Flag &nbsp;&nbsp;<input type="checkbox" name="out_pkg_use_box"></td>
								</tr>
								<tr><td colspan="3"><script language="javascript">ComSheetObject('t2sheet3');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_3_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_3_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_3_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- Outer packaging : ( Grid ) (E) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<!-- Reference Detail : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Reference Detail</td>
								</tr>
								<tr><td colspan="2"><script language="javascript">ComSheetObject('t2sheet4');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_4_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_4_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_4_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- Reference Detail : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- THIS IS 2nd TAB (E) -->
			
			<!-- THIS IS 3rd TAB (S) -->
			<div id="tabLayer" style="display:none">			
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<!-- Single packaging : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Single Packaging</td>
									<td width="130" align="right">Use Flag &nbsp;&nbsp;<input type="checkbox" name=sgl_pkg_use_box></td>
								</tr>
								<tr><td colspan="3"><script language="javascript">ComSheetObject('t3sheet1');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn3_1_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn3_1_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn3_1_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- Single packaging : ( Grid ) (E) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<!-- Reference Detail : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Reference Detail</td>
								</tr>
								<tr><td colspan="2"><script language="javascript">ComSheetObject('t3sheet2');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn3_2_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn3_2_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn3_2_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- Reference Detail : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- THIS IS 3rd TAB (E) -->
			
			<!-- THIS IS 4th TAB (S) -->	
			<div id="tabLayer" style="display:none">
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Pressure Receptacles</td>
									<td width="130" align="right">Use Flag &nbsp;&nbsp;<input type="checkbox" name="prs_desc_use_box"></td>
								</tr>
								<tr class="h23">
									<td width="" colspan="3">
										<textarea name="prss_desc" style="width:100%" rows="4"></textarea>
									</td>
								</tr>
							</table>
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Additional Provisions</td>
									<td width="130" align="right">Use Flag &nbsp;&nbsp;<input type="checkbox" name="add_regu_desc_use_box"></td>
								</tr>
								<tr class="h23">
									<td width="" colspan="3">
										<textarea name="add_regu_desc" style="width:100%" rows="4"></textarea>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<!-- THIS IS 4th TAB (E) -->
			
			<!-- THIS IS 5th TAB (S) -->
			<div id="tabLayer" style="display:none">			
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<!-- Special packing provisions : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Special packing provisions</td>
									<td width="130" align="right">Use Flag &nbsp;&nbsp;<input type="checkbox" name="spcl_pkg_regu_use_box"></td>
								</tr>
								<tr><td colspan="3"><script language="javascript">ComSheetObject('t5sheet1');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn5_1_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn5_1_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn5_1_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- Special packing provisions : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- THIS IS 5th TAB (E) -->
			
			<!-- THIS IS 6th TAB (S) -->
			<div id="tabLayer" style="display:none">			
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<!-- Gases and Others : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Gases and Others</td>
									<td width="130" align="right">Use Flag &nbsp;&nbsp;<input type="checkbox" name="gas_use_box"></td>
								</tr>
								<tr><td colspan="3"><script language="javascript">ComSheetObject('t6sheet1');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn6_1_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn6_1_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn6_1_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- Gases and Others : ( Grid ) (E) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<!-- Reference Detail : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Reference Detail</td>
								</tr>
								<tr><td colspan="2"><script language="javascript">ComSheetObject('t6sheet2');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn6_2_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn6_2_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn6_2_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- Reference Detail : ( Grid ) (E) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<!-- Special packing provisions-Details : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Special packing provisions-Details</td>
								</tr>
								<tr><td colspan="2"><script language="javascript">ComSheetObject('t6sheet3');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn6_3_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn6_3_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn6_3_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- Special packing provisions-Details : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- THIS IS 6th TAB (E) -->
			
			<!-- THIS IS 7th TAB (S) -->
			<div id="tabLayer" style="display:none">			
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<!-- T1-T22 : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">T1-T22</td>
								</tr>
								<tr><td colspan="2"><script language="javascript">ComSheetObject('t7sheet1');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn7_1_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn7_1_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn7_1_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- T1-T22 : ( Grid ) (E) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<!-- T23 : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">T23</td>
								</tr>
								<tr><td colspan="2"><script language="javascript">ComSheetObject('t7sheet2');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn7_2_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn7_2_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn7_2_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- T23 : ( Grid ) (E) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<!-- T50 : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">T50</td>
								</tr>
								<tr><td colspan="2"><script language="javascript">ComSheetObject('t7sheet3');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn7_3_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn7_3_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn7_3_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- T50 : ( Grid ) (E) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<!-- Reference Detail : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Reference Detail</td>
								</tr>
								<tr><td colspan="2"><script language="javascript">ComSheetObject('t7sheet4');</script></td></tr>
							</table>
							<table width="100%" class="button" border="0"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn7_4_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn7_4_RowCopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn7_4_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>								
										</tr>
									</table>
								</td>
							</tr>
						</table>
							<!-- Reference Detail : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- THIS IS 7th TAB (E) -->
			
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
		       	<tr>
		       		<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
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
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		
		</td></tr>
	</table>
	<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>