<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : COM_ENS_0U2.jsp
*@FileTitle : Approval Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2014-01-02
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014-01-02 SHIN DONG IL
* 1.0 최초 생성  
*----------------------------------------------------------
* History
* 2014-01-02 CHM-201328230 Approval Inquiry 화면 추가 외 조회권한 부여
* 2015.05.13 심성윤 [CHM-201535807] Agmt File 버튼 클릭시 get 주소에 sub_sys_cd 추가
* 2015.07.13 심성윤 [CHM-201536387] [Develop]ALPS Auth 사후 결재 기능 탭 로직 추가
* 2016.06.16 유병희 [CHM-201642161] Approval 로직 수정
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.approval.event.ComEns0U2Event"%>
<%@ page import="com.hanjin.bizcommon.approval.event.ComEns0U2EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%
	ComEns0U2Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	ComEns0U2EventResponse eventResponse = null; 	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//서버에서 발생한 에러
	DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//에러메세지
	String userId    = "";
	String ofc_cd    = "";
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수	

	try {		
	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId   = account.getUsr_id();
	   ofc_cd   = account.getOfc_cd();
	   
		
		event = (ComEns0U2Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (ComEns0U2EventResponse)request.getAttribute("EventResponse");
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

<body onload="javascript:setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">
<input type="hidden" name="ofc_tp_cd">
<input type="hidden" name="ofc_tp_cd_auth">
<input type="hidden" name="usr_ofc_cd" value= "<%=ofc_cd%>">
<input type="hidden" name="usr_ofc_cd_auth" value= "<%=ofc_cd%>">
<input type="hidden" name="acct_rhq_ofc_cd">
<input type="hidden" name="rhq_ofc_cd">
<input type="hidden" name="DB_DATE" value=''>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
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
								<td width="110"><%= com.hanjin.bizcommon.util.BizComUtil.getCodeCombo("sub_sys_cd", "", "style='width:93'", "SUBSYS", 1, "0: :ALL") %></td>
								<td width="80">ALPS Status</td>
								<td width="110">
									<select name="alps_status" style='width:93' onChange="changeIfStatus(this.value);">
										<option value=""  selected>All</option>
										<option value="P">Requested</option>
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
									<input type="text" style="width:80;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8' class="input"  name="sdate" value="" onBlur="obj_blur();">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;ime-mode:disabled"  maxlength='8' dataformat="ymd" class="input" value="" name="edate" onBlur="obj_blur();">&nbsp;<img class="cursor" name="btns_Calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
								</td>
							</tr>
							<tr class="h23">
								<td>RHQ</td>
								<td>
									<select name="rhq_ofc_cd_csr" onChange="changeRhqOfcCd_csr(this.value);" style='width:93' class="input1">
									</select>
								</td>
								<td>Office</td>
								<td>
									<select name="ofc_cd" style='width:93' class="input1">
									</select>
								</td>
								<td width="80">CSR No.</td>
								<td width="" class="stm" colspan="3">
									<input type="text" style="width:180" class="input" name="s_csr_no" maxlength=20 onKeyPress='enterCheck("retrieveEvent");'>
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
						<table width="100%" id="mainTable">
		                	<tr>
		                		<td>
		                            <script language="javascript">ComSheetObject('sheet1');</script>
		                        </td>
		                    </tr>
		                 </table>
						 <!-- : ( Button : Sub ) (S) -->
						 <table width="100%" class="sbutton">
					     	<tr>
					     		<td class="align">
									<table width="100%" class="button">
										<tr>
											<td class="btn2_bg" style="text-align:left">
												<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr><td class="btn2_left"></td>
																<td class="btn2" name="btn_comments">Approval Step & Comments</td>
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
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_files">AGMT Files</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_Detail">Detail</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btng_downexcel">Down Excel</td>
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
	       		<tr>
	       			<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
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
		    </div>
		    <!--TAB D.V Expense (E) -->
		    
		    <!--TAB D.V Expense (S) -->
			<div id="tabLayer" style="display:inline">
			<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
					
						<!-- : ( Scenario ID ) (S) -->
						<table class="search" border="0" style="width:400;">
							<tr >   							
	        					<td class="stm" width="50"><strong>App TP</strong></td>
	        					<td width="300"><input type="radio" name="auth_apro_tp_cd" id="auth_apro_tp_cd" value="BF" class="trans">&nbsp;Before&nbsp;&nbsp;&nbsp;<input type="radio" name="auth_apro_tp_cd" id="auth_apro_tp_cd" value="AF" class="trans">&nbsp;After&nbsp;&nbsp;&nbsp;<input type="radio" name="auth_apro_tp_cd" id="auth_apro_tp_cd" value="ALL" class="trans" checked="checked">&nbsp;All&nbsp;
	        					</td>
	        				</tr>	      
	        				</table>
	        			<table class="search" border="0" style="width:979;">	  												
							<tr class="h23" >
								<td width="50">Module</td>
								<td width="90"><script language="javascript" >ComComboObject('sub_sys_cd_auth',1,75,1,1,1);</script></td>
								<td width="45">Menu</td>
								<td width="290"><script language="javascript" >ComComboObject('pgm_no',1,270,1,0);</script></td>
								<td width="45">Status</td>
								<td width="110"><script language="javascript" >ComComboObject('auth_apsts_cd',1,93,1,0);</script></td>
								<td width="40">Date</td>
								<td>
									<input type="text" style="width:80;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8' class="input"  name="sdate_auth" value="" onBlur="obj_blur();">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;ime-mode:disabled"  maxlength='8' dataformat="ymd" class="input" value="" name="edate_auth" onBlur="obj_blur();">&nbsp;<img class="cursor" name="btns_Calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
							</tr>
							<tr class="h23">
								<td width="50">RHQ</td>
								<td width="90"><select name="rhq_ofc_cd_auth" onChange="changeRhqOfcCd_auth(this.value);" style='width:75' class="input">
									</select></td>
								<td width="45">Office</td>
								<td width="80">
									<select name="ofc_cd_auth" style='width:75' class="input1">
									</select>
								</td>
								<td width="45">
									Excel
									</td>
									<td width="100">
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
						<table width="100%" id="mainTable">
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
														<!-- <td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_files">AGMT Files</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td> -->
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_Detail_Auth">Detail</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<!-- <td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btng_downexcel">Down Excel</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td> -->
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
	       		<tr>
	       			<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
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
		    </div>
		    <!--TAB D.V Expense (E) -->
		</td>
	</tr>
</table>
</form>
</body>
</html>
<%-- <SCRIPT LANGUAGE="javascript">
<!--
	  
	  /* 
		ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다. 
	  */
	  with(document.form)
	  {
	  	<%
		if(event != null){ 
			String frDate   = "";
			   String toDate   = "";
			   
			   java.util.Calendar calendar = java.util.Calendar.getInstance();
			   
			   String toMonth = "" + (calendar.get(java.util.Calendar.MONTH) + 1);
			   if(Integer.parseInt(toMonth) < 10)
				   toMonth = "0" + toMonth;
			   
			   String toDay = "" + calendar.get(java.util.Calendar.DATE);
			   if(Integer.parseInt(toDay) < 10)
				   toDay = "0" + toDay;
			   
			   toDate = calendar.get(java.util.Calendar.YEAR) + "-"
			   		+ toMonth + "-"
			   		+ toDay;
			   
			   calendar.add(java.util.Calendar.MONTH, -1);
			   
			   String frMonth = "" + (calendar.get(java.util.Calendar.MONTH) + 1);
			   if(Integer.parseInt(frMonth) < 10)
				   frMonth = "0" + frMonth;
			   
			   String frDay = "" + calendar.get(java.util.Calendar.DATE);
			   if(Integer.parseInt(frDay) < 10)
				   frDay = "0" + frDay;
			   
			   frDate = calendar.get(java.util.Calendar.YEAR) + "-"
		   			+ frMonth + "-"
		   			+ frDay;
		%>
		
		eval("sdate" ).value = "<%= frDate	 %>";
		eval("edate" ).value = "<%= toDate	 %>";
		eval("sdate_auth" ).value = "<%= frDate	 %>";
		eval("edate_auth" ).value = "<%= toDate	 %>";
		<% } %>
	   }
-->
</SCRIPT> --%>