<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : COM_ENS_0S1.jsp
*@FileTitle : country
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-03
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-11-03 Hyung Choon_Roh
* 1.0 최초 생성  
*----------------------------------------------------------
* History
* 2013.09.05 조인영 [CHM-201326202] ETS연동에 따른 TRS CSR삭제로직 추가 요청
* 2014.07.10 김영신 [CHM-201430993] urgent payment 기능 추가, Approval Step & Comments, Files 버튼 추가 및 활성화 기능 
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가, urgent payment 기능 제거
* 2015.07.16 심성윤 [CHM-201536387] [Develop]ALPS Auth 사후 결재 기능 탭 로직 추가
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.bizcommon.approval.event.ComEns0U1Event"%>
<%@ page import="com.hanjin.bizcommon.approval.event.ComEns0U1EventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%
	ComEns0U1Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	ComEns0U1EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수	
	String ofc_cd  			= ""; 
	
	try {		
	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   ofc_cd	  = account.getOfc_cd();
	   //userAuth=account.getAuth();
	   
	  
		
		event = (ComEns0U1Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (ComEns0U1EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();				
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();					 
				} // end if
			} // end if
		} // end else		
			
		FormCommand formcommand = event.getFormCommand();
		String approveResultMsg = "";		
		if( eventResponse != null && formcommand.isCommand(FormCommand.COMMAND01) ) {
			approveResultMsg = eventResponse.getApproveResultMsg();
		}		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Approval Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->

<body onload="javascript:setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">
<input type="hidden" name="aproSeqKey">
<input type="hidden" name="apro_step"> 
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">
<!-- BackEndJob을 위한 Field -->
<input type="hidden" name="key">
<input type="hidden" name="DB_DATE" value=''>

<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

<!-- ################# TABLE '#A' ::: 'TOP' FRAME (START) ################## -->

<!-- Put your 'STYLESHEET' into the <HEAD> tag on the corresponding page if you make 'FRAMESET's -->


<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (START) ################## -->
<!-- TABLE '#B' : 'Left + Right Body' Table (S)tart -->


		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!-- Tab (S) -->
		<table class="height_10"><tr><td></td></tr></table>
   		<table class="tab">
        	<tr><td><script language="javascript">ComTabObject("tab1")</script>
		</table>
		<!-- Tab (E) -->
		
		
		<!--TAB D.V Expense (S) -->
		<div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="60">Module</td>
					<td width="100"><%= com.hanjin.bizcommon.util.BizComUtil.getCodeCombo("sub_sys_cd", "", "", "SUBSYS", 1, "0: :ALL") %></td>
					<td width="80">ALPS Status</td>
					<td width="110">
						<select name="alps_status" style='width:93' onChange="changeIfStatus(this.value);">
							<option value="">All</option>
							<option value="P" selected>Requested</option>
							<option value="C">Approved</option>							
							<option value="R">Disapproved</option>	
							<option value="X">Canceled</option>					
						</select>
					</td>
					<td width="80">I/F Status</td>
					<td width="110">
						<select name="if_status" style='width:93'>		
							<option value="" selected>All</option>
							<option value="E">I/F Error</option>	
							<option value="R">A/P Rejected</option>						
							<option value="S">I/F Success</option>		
							<option value="P">Paid</option>			
						</select>
					</td>
					<td width="35">Date</td>
					<td width="" class="stm"> 
						<input type="text" style="width:80;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8' class="input"  name="sdate" value="">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;ime-mode:disabled"  maxlength='8' dataformat="ymd" class="input" value="" name="edate">&nbsp;<img class="cursor" name="btns_Calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					</td>
				</tr>
				</table>
				<!-- : ( Scenario ID ) (E) -->

			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>



		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg" valign="top">
					<table width="100%" id="mainTable">
	                                      <tr><td>
	                                             <script language="javascript">ComSheetObject('sheet1');</script>
	                                      </td></tr>
	                        	</table>
			<!-- : ( Grid : Week ) (E) -->
			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="sbutton">
	       	<tr><td class="align">
				<table width="100%" class="button">
					<tr>
					<td class="btn2_bg" style="text-align:left">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2_1" name="btn_comments">Approval Step & Comments</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2_1" name="btn_files">AGMT Files</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
					<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!--
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btng_editapprovalstep">Edit Approval Step</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							-->
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2_1" name="btn_Detail">Detail</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							<!-- 버튼 삭제 2014.07.29 -->
							<!-- 
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2_1" name="btng_viewapprovalstep">View Approval Step</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							-->
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btng_confirm">Approve</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btng_reject">Disapprove</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
						</tr>
						</table>
			</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->

			</td></tr>
		</table>


		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->
	

	</td>
</tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->

<!--TAB D.V Expense (E) -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
</div>
 <!--TAB D.V Expense (S) -->
<div id="tabLayer" style="display:none;">
			
			<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
					
						<!-- : ( Scenario ID ) (S) -->
						<table class="search" border="0" style="width:400;">
							<tr>   							
	        					<td class="stm" width="50"><strong>App TP</strong></td>
	        					<td width="300"><input type="radio" name="auth_apro_tp_cd" value="BF" class="trans">&nbsp;Before&nbsp;&nbsp;&nbsp;<input type="radio" name="auth_apro_tp_cd" value="AF" class="trans" >&nbsp;After&nbsp;&nbsp;&nbsp;<input type="radio" name="auth_apro_tp_cd" value="ALL" class="trans" checked="checked">&nbsp;All&nbsp;</td>
	        				</tr>	 
	        			</table>
	        			<table class="search" border="0" style="width:979;">       												
							<tr class="h23">
								<td width="50">Module</td>
								<td width="110"><script language="javascript" >ComComboObject('sub_sys_cd_auth',1,93,1,1,0);</script></td>
								<td width="40">Menu</td>
								<td width="275"><script language="javascript" >ComComboObject('pgm_no',1,270,1,0);</script></td>
								<td width="35">Date</td>
								<td width="210"><input type="text" style="width:80;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8' class="input"  name="sdate_auth" value="">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;ime-mode:disabled"  maxlength='8' dataformat="ymd" class="input" value="" name="edate_auth">&nbsp;<img class="cursor" name="btns_Calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="40">Excel</td>
								<td width="70">
									<select style="width:60;" name='xls_flg'>
										<option value="ALL" selected>--All--</option>
										<option value="Y">Y</option>
										<option value="N">N</option>
									</select>
								</td>
					
							</tr>							
						</table>
					</td>
				</tr>
			</table>
			<table class="height_10"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr>
					<td class="bg" valign="top">
						<table width="100%" id="mainTable2" >
		                	<tr>
		                		<td>
		                			<div id="defaultAuth" style="display:inline;">
	                            		<script language="javascript">ComSheetObject('sheet2');</script>
	                            	</div>	
	                            	<div id="trsAfWo" style="display:none;">
	                            		<script language="javascript">ComSheetObject('sheet3');</script>
	                            	</div>
		                        </td>
		                    </tr>
		                 </table>
						  <!-- : ( Button : Sub ) (S) -->
						<table width="100%" class="sbutton">
					     	<tr>
					     		<td class="align">
									<table width="100%" class="button">
										<tr>
											<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_approve_auth">Approve</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_disapprove_auth">Disapprove</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_confirm_auth">Confirm</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_save_auth">Save</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_detail_auth">Detail</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>														
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table> 
					</td>
				</tr>
			</table>
			
		
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
</div>



</td></tr>


</table>
<script language="javascript">ComSheetObject('sheet4');</script>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->
</form>


</body>
</html>
