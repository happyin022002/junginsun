<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : vop_scg_0080.jsp
*@FileTitle : Special Cargo Guidance
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.07
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.07 김영오
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
<%@ page import="com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0080Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0080Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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


		event = (VopScg0080Event)request.getAttribute("Event");
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
<title>Packing Instructions/Provisions (Creation)</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" value="<%=strUsr_id%>" name="upd_usr_id">
<input type="hidden" value="<%=strUsr_nm%>" name="upd_usr_nm">
<input type="hidden" name="scg_flg">
<input type="hidden" name="spcl_cgo_guid_seq">
<input type="hidden" name="chk_file">
<input type="hidden" value="VOP_SCG_0080" name="pgm_no">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--top menu (S)-->
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->				
	
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
	       	<tr><td class="btn1_bg">
			
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					</tr>
				</table>
			</td></tr>
			</table>
	    	<!--Button (E) -->
			
			
			<!--biz page-1 (S)-->
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="80">Searched by</td>
								<td width="85">
									<select name="subject_cd"  style="width:80">
										<option value="S" selected>Subject</option>
										<option value="W">Word</option>
									</select>
								</td>
								<td width=""><input type="text" name="subject" style="width:400;" class="input" value="" ></td>
							</tr>
						</table>
						
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>
			<!--biz page-1 (E)-->
			      		
			<table class="height_8"><tr><td></td></tr></table>	
			<table width="100%" class="search"> 
				<tr>
					<td class="bg"><textarea style="height:50;width:100%;text-indent:0%;"  name='msg_hdr_ctnt' maxlength="4000"></textarea></td>
										
				</tr>
			</table>
			
			<!-- Tab ) (S) -->
    		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
	       		<tr>
		       		<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
			<!-- Tab ) (E) -->
			
			<!-- Tab 시작. -->
			<!-- Tab_Layer_1 (S) -->
      		<div id="tabLayer" style="display:inline">
      		
			<!-- 2 (S) -->		
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
       			<tr>
       				<td class="bg" style="height:210;" valign="top">		
						<!-- Grid - 1 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid - 1 (E) -->	
						
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
														<td class="btn2" name="btn1_addrow">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn1_row_delete">Row Delete</td>
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
				    	
						<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td><textarea style="height:320;width:100%;text-indent:0%;"  name='ftr_ctnt01'></textarea></td>
							</tr>
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid - 2 (E) -->		
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
														<td class="btn2" name="btn1_addfile_row">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn1_addfile_delete">Row Delete</td>
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
		    <!-- Tab_Layer_1 (E) -->
						
			<!-- Tab_Layer_2 (S) -->
      		<div id="tabLayer" style="display:none">
			<!-- 2 (S) -->		
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
       			<tr>
       				<td class="bg" style="height:210;" valign="top">		
						<!-- Grid - 1 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
						<!-- Grid - 1 (E) -->	
						
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
														<td class="btn2" name="btn2_addrow">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_row_delete">Row Delete</td>
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
				    	
						<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable"> 
							
							<tr>
								<td><textarea style="height:320;width:100%;text-indent:0%;"  name='ftr_ctnt02'></textarea></td>
							</tr>
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet4');</script>
								</td>
							</tr>
						</table>
						<!-- Grid - 2 (E) -->		
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
														<td class="btn2" name="btn2_addfile_row">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_addfile_delete">Row Delete</td>
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
		    <!-- Tab_Layer_2 (E) -->
						
			
			<!-- Tab_Layer_3 (S) -->
      		<div id="tabLayer" style="display:none">
      		
			<!-- 2 (S) -->		
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
       			<tr>
       				<td class="bg" style="height:210;" valign="top">		
						<!-- Grid - 1 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet5');</script>
								</td>
							</tr>
						</table>
						<!-- Grid - 1 (E) -->	
						
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
														<td class="btn2" name="btn3_addrow">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn3_row_delete">Row Delete</td>
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
				    	
						<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable"> 
							
							<tr>
								<td><textarea style="height:320;width:100%;text-indent:0%;"  name='ftr_ctnt03'></textarea></td>
							</tr>
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet6');</script>
								</td>
							</tr>
						</table>
						<!-- Grid - 2 (E) -->		
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
														<td class="btn2" name="btn3_addfile_row">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn3_addfile_delete">Row Delete</td>
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
		    <!-- Tab_Layer_3 (E) -->
			
	
	<div style="display:none">
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet7');</script>
				</td>
			</tr>
		</table>
	</div>
	<div style="display:none">
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet8');</script>
				</td>
			</tr>
		</table>
	</div>
	<div style="display:none"><!-- display:inline -->
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet9');</script>
				</td>
			</tr>
		</table>
	</div>
	
			<!-- Tab_Layer_4 (S) -->
      		<div id="tabLayer" style="display:none">
      		
			<!-- 2 (S) -->		
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
       			<tr>
       				<td class="bg" style="height:210;" valign="top">		
						<!-- Grid - 1 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet10');</script>
								</td>
							</tr>
						</table>
						<!-- Grid - 1 (E) -->	
						
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
														<td class="btn2" name="btn4_addrow">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn4_row_delete">Row Delete</td>
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
				    	
						<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable"> 
							
							<tr>
								<td><textarea style="height:320;width:100%;text-indent:0%;"  name='ftr_ctnt04'></textarea></td>
							</tr>
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet11');</script>
								</td>
							</tr>
						</table>
						<!-- Grid - 2 (E) -->		
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
														<td class="btn2" name="btn4_addfile_row">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn4_addfile_delete">Row Delete</td>
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
		    <!-- Tab_Layer_4 (E) -->		
	
		</td>
	</tr>
</table>
<!--IBUpload Component (S) -->
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!--IBUpload Component (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>