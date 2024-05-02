<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0004.jsp
*@FileTitle : Tariff List
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.31
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.03 박명종
* 1.0 Creation
*  
* History
* 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
* 2011.10.31 진마리아 선처리(SRM-201121003) [VOP-PSO] Formula Selection 내 Add Row 로직 변경건
* 2014.07.16 이성훈   CHM-201430928    Port Tariff Contract 및 URL 저장
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0004Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_Ofc_cd      = "";

	Logger log = Logger.getLogger("com.hanjin.apps.PortSOMasterDataMgt.PortTariffMgt");
	
	String sType = request.getParameter("type") == null ? "B" : request.getParameter("type");

	//VOP_PSO_0036 화면에서 넘어옴	
	String movedFrom = request.getParameter("moved_from") == null ? "" : request.getParameter("moved_from");
	String movedParams = request.getParameter("moved_params") == null ? "" : request.getParameter("moved_params");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();
	   
		event = (VopPso0004Event)request.getAttribute("Event");
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
<title>Tariff List</title>
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
<form name="form" onKeyDown="ComKeyEnter()">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sXml">
<input type="hidden" name="csearch" value="" >
<input type="hidden" name="acct_cd" value="" >
<input type="hidden" name="yd_chg_no" value="" >
<input type="hidden" name="yd_chg_ver_seq" value="" >
<input type="hidden" name="year" value="" >
<input type="hidden" name="copy_condition" value=""> <!-- Copy Popup에서 내려준 조건 -->

<input type="hidden" name="moved_from" value="<%=movedFrom%>"> <!-- VOP_PSO_0036 화면에서 호출 -->
<input type="hidden" name="moved_params" value="<%=movedParams%>"> <!-- VOP_PSO_0036 화면에서 호출 -->

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DataDelete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
			</td>			
		</tr>
		</table>
		
    <!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">Port</td>
					<td width="150"><input name="port_cd" type="text" dataformat="uppernum" style="width:50" class="input1" value="" size="5" maxlength="5">&nbsp;<img class="cursor" name="btn_port_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
					<script language="javascript">ComComboObject('combo1',2, 50, 0, 1);</script>
					</td>
					<td width="105"> Account  CD</td>
					<td width="98" style="padding-left:2"><script language="javascript">ComComboObject('combo2',2, 96, 0, 1);</script></td>
					<td width="242"><input type="text" name="account_nm" style="width:220;text-align:left" class="input2" value="" readonly></td>
					<td width="55"> Cost  CD</td>
					<td width="92" style="padding-left:2"><script language="javascript">ComComboObject('combo3',2, 90, 0, 1);</script></td>
					<td width=""><input type="text" name="lgs_cost_nm" style="width:200;text-align:left" class="input2" value="" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="180">Currency&nbsp;<script language="javascript">ComComboObject('combo4',2, 100, 0, 1);</script></td>
					<td width="105">S/P CD</td>
					<td width="342"><input type="text" name="vndr_seq" style="width:73;text-align:center" class="input1" value="" dataformat="num" maxlength="6">&nbsp;<img class="cursor" name="btns_VendorSeq" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="vndr_lgl_eng_nm" style="width:220;text-align:left" class="input2" value="" readonly></td>
					<td width="55">Origin</td>
					<td width=""><input type="text" name="org_vndr_nm" style="width:294;text-align:left" class="input" value="" dataformat="num"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="180">Compulsory&nbsp;<input type="checkbox" name="cpls_flg" value="Y" class="trans" disabled></td>
					<td width="105"> Effective Date</td>
					<td width="225"><input name="from_date" type="text" dataformat="ymd" maxlength="8" style="width:73;ime-mode:disabled" class="input1" value="">&nbsp;<img class="cursor" name="btns_Calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" name="to_date" maxlength="8" dataformat="ymd" style="width:73;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_Calendar2" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="27"> Ver.</td>
					<td width="94" style="padding-left:2"><script language="javascript">ComComboObject('combo5',3, 72, 1);</script></td>
					<td width="55">URL</td>
					<td width=""><input name="port_trf_url" value="" type="text" style="width:294" class="input" maxlength="200"></td>					
				</tr>
				</table>
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="180">&nbsp;</td>
						<td width="130">Contract/Regulation</td>
						<td width="318"><input name="contract" value="" type="text" style="width:270" class="input2" readonly>&nbsp;<img class="cursor" name="btn_cntr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="55">Remark</td>
						<td width=""><input name="port_trf_rmk" value="" type="text" style="width:270" class="input2" readonly>&nbsp;<img class="cursor" name="btn_port_trf_rmk" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					</tr>
				</table>				
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				<!--  biz_2  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100"><input type="checkbox" name="cSur" value="" class="trans" >&nbsp;Surcharge </td>
					<td width="100"><input type="checkbox" name="cDis" value="" class="trans" >&nbsp;Discount</td>
					<td width="">&nbsp;</td>
				</tr>
				</table>
				<!--  biz_2  (E) -->
		
		
		<table class="line_bluedot"><tr><td></td></tr></table>

				
				<!--  biz_2  (S) -->
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td width="" class="title_s">Base</td>
					</tr>
				</table>
				
				<table class="search" border="0" width="979">
				<tr class="h23">
					<td width="350" valign="top">
						<table class="search_sm" border="0" width="100%" height="100%">
							<tr class="h23">
								<td valign="top">
									<!-- Grid  (S) -->
									<table width="100%" id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet1');</script>
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
																	<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_Delete">Row&nbsp;Delete</td>
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
									<table class="height_10"><tr><td></td></tr></table>
									
									<table width="100%" class="" border="0" cellpadding="2" cellspacing="1">
										<tr class="history">
											<td>&nbsp;&nbsp;*Formula</td>
										</tr>
										<tr height="130">
											<td>
												<div id="foml_desc" style="width:100%;height:100%;border:solid 1;overflow-y:auto;overflow-x:hidden;padding:2px;border-color:#5B8A9E;background-color:#FFFFFF"></div>
											</td>
										</tr>
										<tr class="history">
											<td>&nbsp;&nbsp;*Condition</td>
										</tr>
										<tr height="80">
											<td>
												<div id="cond_desc" style="width:100%;height:100%;border:solid 1;overflow-y:auto;overflow-x:hidden;padding:2px;border-color:#5B8A9E;background-color:#FFFFFF"></div>
											</td>
										</tr>
									</table>
						
								</td>
							</tr>
						</table>
					</td>
					<td width="19">&nbsp;</td>
					<td width="" valign="top">
						
						<table width="100%" id="mainTable"> 
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
									    <table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td width=""><input type="text" name="row_cnt" style="width:35;text-align:left" maxlength="3"  class="input" value="1" dataformat="num"></td>
											</tr>
										</table>
										</td>
										
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_RowAdd2">Row&nbsp;Add</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_Delete2">Row&nbsp;Delete</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_GridCopy">Grid Copy</td>
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
						<table class="height_10"><tr><td></td></tr></table>

						<table width="380" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
						
						<!-- [2010.01.13] Regular Value : ReadOnly로 변경
						<table width="380" class="button">
							<tr>
								<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_RowAdd3">Row&nbsp;Add</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_Delete3">Row&nbsp;Delete</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>

									</tr>
								</table>
								</td>
							</tr>
						</table>
						-->
						
					</td>
				</tr>
				</table>
				
				<!--  biz_2   (E) -->
		
		<div id="div_surcharge">
		<table class="line_bluedot"><tr><td></td></tr></table>

				
				<!--  biz_3  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td width="" class="title_s">Surcharge</td>
						
				</tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->	
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd4" id="surRowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete4">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
		</div>	
	    		<!-- Button_Sub (E) -->
				<!--  biz_3   (E) -->
		
		<div id="div_discount">
		<table class="line_bluedot"><tr><td></td></tr></table>

				
				<!--  biz_4  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td width="" class="title_s">Discount</td>
						
				</tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->	

				<!--  biz_4   (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd5" id="disRowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete5">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
		</div>	
	    		
		<div id="div_base_dummy" style="display:none"><!-- Hidden display:none -->
		<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td width="" class="title_s">Base Dummy</td>
					</tr>
				</table>
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet6');</script>
						</td>
					</tr>
				</table>
		</div>
	    		
		<div id="div_dummy" style="display:none"><!-- MultiCombo의 OnChange() 기능用 Sheet, 초기화 안함 -->
			<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet7');</script>
					</td>
				</tr>
			</table>
		</div>		    		
	    		
	    		
				
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	

<table class="height_10"><tr><td></td></tr></table>
	
	
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>