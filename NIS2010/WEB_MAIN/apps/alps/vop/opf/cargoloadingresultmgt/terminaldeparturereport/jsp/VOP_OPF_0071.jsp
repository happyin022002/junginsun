<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VOP_OPF_0071.jsp
*@FileTitle : Vessel Not Operationally Ready Report Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2015.03.27 이병훈
* 1.0 Creation
*
* History
* 2015.04.21 이병훈 [CHM-201535480] VNOR Report Creation 화면 기능 개선(Remark Submit)
* 2015.05.22 이병훈 [CHM-201535464] VNOR Report Summary Inquiry 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0071Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0071Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String vslCd = "";							// VNOR Summary Inquiry 화면에서 오픈 되었을 경우 넘어온 값을 셋팅하기 위한 변수
	String offHireTimeCd = "";					// VNOR Summary Inquiry 화면에서 오픈 되었을 경우 넘어온 값을 셋팅하기 위한 변수
	
	try {
		event = (VopOpf0071Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		vslCd = JSPUtil.getParameter(request , "vsl_cd" , "");
		vslCd = JSPUtil.replaceForHTML(vslCd);
		offHireTimeCd = JSPUtil.getParameter(request , "off_hire_time_cd" , "");
		offHireTimeCd = JSPUtil.replaceForHTML(offHireTimeCd);

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
<title>Vessel Not Operationally Ready Report Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
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
<!-- 기본 필수 hidden -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 업무용 hidden -->
<input type="hidden" name="intg_cd_id">
<input type="hidden" name="intg_cd_val_ctnt">
<input type="hidden" name="vnor_seq">
<input type="hidden" name="cr_chk_flg" value="N">
<input type="hidden" name="save_flg" value="Y">
<input type="hidden" name="office_cd">
<input type="hidden" name="eml_snd_no">
<input type="hidden" name="in_vsl_cd" value="<%=vslCd%>">
<input type="hidden" name="in_off_hire_time_cd" value="<%=offHireTimeCd%>">

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
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Submit">Submit</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Delete">Delete</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Setup">Setup</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Down_Excel">Down Excel</td>
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
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="250">
									Vessel
									&nbsp;
									<input name="vsl_cd" type="text" style="width:60;text-align:center;" class="input1" required fullfill maxlength="4" dataformat="engup" style="ime-mode:disabled">
									&nbsp;
									Voy no.
									&nbsp;
									<input name="skd_voy_no" type="text" style="width:60;text-align:center;" maxlength="5" dataformat="engupnum" style="ime-mode:disabled">
								</td>
								<td width="20" class="stm">
									<input type="checkbox" value="Y" class="trans" name="credit_chk">
								</td>
								<td width="400" style="color:red;">Credit</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="700">
									Off-Hire Time
									&nbsp;
									<input type="text" style="width:120;" class="input1" name="vnor_offh_fm_dt" maxlength="16" dataformat="time">&nbsp;~&nbsp;<input type="text" style="width:120;" class="input1" name="vnor_offh_to_dt" maxlength="16" dataformat="time">&nbsp;<script language="javascript">ComComboObject('off_hire_time_list', 1, 310, 1);</script>
								</td>
								<td width="200">
									Status
									&nbsp;
									<script language="javascript">ComComboObject('vnor_stup_sts_cd', 1, 100, 1);</script>
								</td>
							</tr>
						</table>	
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="360">
									Place
									&nbsp;
									<script language="javascript">ComComboObject('vnor_vsl_sts_cd', 1, 140, 1);</script>&nbsp;<script language="javascript">ComComboObject('vnor_fm_port_cd', 1, 80, 0, 0, 0, true);</script>&nbsp;<script language="javascript">ComComboObject('vnor_to_port_cd', 1, 80, 0, 0, 0, true);</script>
								</td>
								<td width="130">
									Kind
									&nbsp;
									<script language="javascript">ComComboObject('vnor_offh_knd_cd', 1, 90, 1);</script>
								</td>
								<td width="350">
									Type
									&nbsp;
									<script language="javascript">ComComboObject('vnor_offh_tp_cd', 1, 200, 1);</script>
								</td>
							</tr>
						</table>				
						<!-- biz_1  (E) -->		
				
					</td>
				</tr>
			</table>		
			
   			<table class="height_8"><tr><td></td></tr></table>
			<table class="search"> 
   				<tr>
   					<td class="bg">
       					<table class="search">
           					<tr>
           						<td>
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">Off hire time</td>
										</tr>
									</table>
									<!-- Grid  (S) -->
									<table width="100%"  id="mainTable">
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet1');</script>
											</td>					
										</tr>
									</table>
									<br><br>
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">Other Loss</td>
										</tr>
									</table>
									<table width="100%"  id="subTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet2');</script>
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
																	<td class="btn2" name="btn_RowAdd">Row Add</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_RowDelete">Row Delete</td>
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
    								<br><br>
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">Remark</td>
										</tr>
									</table>
									<br>
									<table class="search" border="0">
										<tr>
											<td><textarea style="width:100%;height:200" name="vnor_rmk" class="input" style="ime-mode:disabled"></textarea></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>

					</td>
				</tr>
			</table>
			<!--biz page (E)-->
			<table class="height_10"><tr><td></td></tr></table>
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>