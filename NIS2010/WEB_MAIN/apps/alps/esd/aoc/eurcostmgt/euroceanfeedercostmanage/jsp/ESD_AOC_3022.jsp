<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_AOC_3022.jsp
*@FileTitle : Ocean Feeder Cost Management(EUR)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.14
*@LastModifier : 이혜민
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2013.01.14 CHM-201322300 이혜민 [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
* 2013.02.28 이재위 [CHM-201323053] [AOC] OCN FDR DG cargo Tab  상에서의 Scale up & down 설정변경
* 2013.03.19 이재위 [CHM-201323286] [AOC] OCN FDR management 화면 Delete function 관련 기능보완
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청 
* 2015.02.03 전지예 [CHM-201533794] [AOC] 45' Cost 추가
=========================================================*/
%> 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.event.EsdAoc3022Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdAoc3022Event  event 		= null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 			= "";						//에러메세지
	int rowCount	 			= 0;						//DB ResultSet 리스트의 건수

	String successFlag 			= "";
	String codeList  			= "";
	String pageRows  			= "100";

	String trf_no 				= "";
	String rhqCd 				= "";
	
	String strUsr_id			= "";
	String strUsr_nm			= "";
	String strOfc_cd			= "";

	try {
		trf_no = ((StringUtil.xssFilter(request.getParameter("trf_no"))==null)?"":StringUtil.xssFilter(request.getParameter("trf_no")));
		rhqCd = ((StringUtil.xssFilter(request.getParameter("rhq_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("rhq_cd")));
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsdAoc3022Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String sysSrcAgmtCd  = JSPUtil.getCodeCombo("f_sys_src_cd" , "01", "style='width:120'", "CD03050", 0, "000010:ALL:ALL");
%>
<html>
<head>
<title>Ocean Feeder Cost Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("f_sys_src_cd" , "", "CD03050", 0, "")%>
	
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
<!-- 개발자 작업	-->
<input type="hidden" name="trf_no" value="<%=trf_no%>">
<input type="hidden" name="in_ofc_cd" value="<%=rhqCd%>">
<input type="hidden" name="cost_trf_sts_cd" value="">
<input type="hidden" name="cgo_tp_cd" value="">
<input type="hidden" name="in_btn_sts">
<input type="hidden" name="in_rhq_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
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
						                    <td class="btn1" name="btn_retrieve">Retrieve</td>
						                    <td class="btn1_right"></td>
					                    </tr>
				                	</table>
				                </td>
				                <td class="btn1_line"></td>
				                <td>
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
						                    <td class="btn1_left"></td>
						                    <td class="btn1" name="btn_confirm">Confirm</td>
						                    <td class="btn1_right"></td>
					                    </tr>
					                </table>
				                </td>
				                <td>
					                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
						                    <td class="btn1_left"></td>
						                    <td class="btn1" name="btn_confirm_cancel">Confirm Cancel</td>
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
								<td width="90">Cost Tariff No</td>
								<td width="115"><script language="javascript">ComComboObject('in_cost_trf_no', 1, 100, 1, 1);</script></td>
								<td width="30">From</td>
								<td width="140">
									<input name="in_from_nod_cd" type="text" dataformat="uppernum" style="width:100;" maxlength="7">
									<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_from">
								</td>
								<td width="90">Update Date</td>
								<td width="115"><input type="text" name="upd_dt" style="width:100;text-align:center;" class="input2" readonly></td>
								<td width="60">Currency</td>
								<td width="150"><input type="text" name="curr_cd" style="width:140;text-align:center;" class="input2" readonly></td>
								<td width="90">Weight Criteria (KGS)</td>
								<td width="">20' <input type="text" name="cntr_20ft_crte_wgt" style="width:70;text-align:right;" class="input2" readonly></td>
							</tr>
						</table>	
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="90">Status</td>
								<td width="115"><input type="text" name="cost_trf_sts_nm" style="width:100;text-align:center;" class="input2" readonly></td>
								<td width="30">To</td>
								<td width="140">
									<input name="in_to_nod_cd" type="text" dataformat="uppernum" style="width:100;" maxlength="7">
									<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_to">
								</td>
								<td width="90">Effective From</td>
								<td width="115"><input type="text" name="eff_fm_dt" style="width:100;text-align:center;" class="input2" readonly></td>
								<td width="60">User</td>
								<td width="200"><input type="text" name="upd_usr_id" style="width:140;text-align:left;" class="input2" readonly></td>
								<td width="40"></td>
								<td width="">40' <input type="text" name="cntr_40ft_crte_wgt" style="width:70;text-align:right;" class="input2" readonly></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="828" colspan="9"></td>
								<td width="">45' <input type="text" name="cntr_45ft_crte_wgt" style="width:70;text-align:right;" class="input2" readonly></td>
							</tr>
						</table>
						<!-- biz_1  (E) -->		
					</td>
				</tr>
			</table>
						
			<table class="height_8"><tr><td></td></tr></table>
	
			<!-- Tab (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%"><script language="javascript">ComTabObject('tab1')</script></td>
				</tr>
			</table>
			<!-- Tab (E) -->
	
			<!-- TAB [ Dry ] (S) -->
			<div id="tabLayer" style="display:inline">
				<table class="search"> 
					<tr>
						<td class="bg" style="height:330" valign="top">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- TAB [ Dry ] (E) -->
		
			
			<!-- TAB [ Dangerous ] (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search"> 
					<tr>
						<td class="bg" style="height:338" valign="top">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet2');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- TAB [ Dangerous ] (E) -->
			
			
			<!-- TAB [ Reefer ] (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search"> 
					<tr>
						<td class="bg" style="height:330" valign="top">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet3');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- TAB [ Reefer ] (E) -->
			
			
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
											<td class="btn2" name="btn_save">Save</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_delete">Delete</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_cost_detail">Cost Detail</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_agmt_inq">AGMT INQ</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_down_excel">Down Excel</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_load_excel">Load Excel</td>
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
	    	
	    	<table class="height_8"><tr><td></td></tr></table>
	    	
			<table class="search"> 
	       		<tr>
		       		<td class="bg">
						<div id="dryLayer" style="display:inline">
							<!-- biz_1  (S) -->
							<table class="search" border="0" style="width:979;"> 
								<tr class="h23">
									<td width="60">Trans 20’</td>
									<td width="82"><script language="javascript">ComComboObject('co_trans20_src', 1, 80, 1, 0);</script></td>
									<td width="50"><script language="javascript">ComComboObject('co_trans20', 1, 50, 1, 0);</script></td>
									<td width="100"><input type="text" name="in_trans20" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
									<td width="50">MTY 20’</td>
									<td width="82"><script language="javascript">ComComboObject('co_mty20_src', 1, 80, 1, 0);</script></td>
									<td width="82"><script language="javascript">ComComboObject('co_mty20', 1, 82, 1, 0);</script></td>
									<td width="100"><input type="text" name="in_mty20" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input2" readonly></td>
									<td width="60">TMNL 20’</td>
									<td width="82"><script language="javascript">ComComboObject('co_tmnl20_src', 1, 80, 1, 0);</script></td>
									<td width="50"><script language="javascript">ComComboObject('co_tmnl20', 1, 50, 1, 0);</script></td>
									<td width="100"><input type="text" name="in_tmnl20" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
					                <td width="">
						                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                    <tr>
						                    	<td class="btn1_left"></td>
						                    	<td class="btn1" name="btn_apply1">Apply</td>
						                    	<td class="btn1_right"></td>
						                    </tr>
						                </table>
					                </td>
								</tr>
								<tr class="h23">
									<td>Trans 40’</td>
									<td><script language="javascript">ComComboObject('co_trans40_src', 1, 80, 1, 0);</script></td>
									<td><script language="javascript">ComComboObject('co_trans40', 1, 50, 1, 0);</script></td>
									<td><input type="text" name="in_trans40" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
									<td>MTY 40’</td>
									<td><script language="javascript">ComComboObject('co_mty40_src', 1, 80, 1, 0);</script></td>
									<td><script language="javascript">ComComboObject('co_mty40', 1, 82, 1, 0);</script></td>
									<td><input type="text" name="in_mty40" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input2" readonly></td>
									<td>TMNL 40’</td>
									<td><script language="javascript">ComComboObject('co_tmnl40_src', 1, 80, 1, 0);</script></td>
									<td><script language="javascript">ComComboObject('co_tmnl40', 1, 50, 1, 0);</script></td>
									<td><input type="text" name="in_tmnl40" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
					                <td>
						                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                    <tr>
						                    	<td class="btn1_left"></td>
						                    	<td class="btn1" name="btn_reset1">Reset</td>
						                    	<td class="btn1_right"></td>
						                    </tr>
						                </table>
					                </td>
								</tr>
				 			</table>
							<!-- biz_1  (E) -->		
						</div>
						<div id="45dryLayer" style="display:inline">
							<!-- biz_1  (S) -->
							<table class="search" border="0" style="width:979;">
								<tr class="h23">
									<td width="60">Trans 45'</td>
									<td width="82"><script language="javascript">ComComboObject('co_trans45_src', 1, 80, 1, 0);</script></td>
									<td width="50"><script language="javascript">ComComboObject('co_trans45', 1, 50, 1, 0);</script></td>
									<td width="100"><input type="text" name="in_trans45" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
									<td width="50">MTY 45'</td>
									<td width="82"><script language="javascript">ComComboObject('co_mty45_src', 1, 80, 1, 0);</script></td>
									<td width="82"><script language="javascript">ComComboObject('co_mty45', 1, 82, 1, 0);</script></td>
									<td width="100"><input type="text" name="in_mty45" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input2" readonly></td>
									<td width="60">TMNL 45'</td>
									<td width="82"><script language="javascript">ComComboObject('co_tmnl45_src', 1, 80, 1, 0);</script></td>
									<td width="50"><script language="javascript">ComComboObject('co_tmnl45', 1, 50, 1, 0);</script></td>
									<td width="100"><input type="text" name="in_tmnl45" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
					                <td width="81">
					                </td>
								</tr>
							</table>
							<!-- biz_1  (E) -->
						</div>
						<div id="dgLayer" style="display:none">
							<!-- biz_1  (S) -->
							<table class="search" border="0" style="width:979;"> 
								<tr class="h23">
									<td width="40">Class</td>
									<td width="60"><script language="javascript">ComComboObject('class1_combo', 1, 60, 1, 0);</script></td>
									<td width="40"><script language="javascript">ComComboObject('class1_svc', 1, 40, 1, 0);</script></td>
									<td width="50"><script language="javascript">ComComboObject('class1_ind', 1, 50, 1, 0);</script></td>
									<td width="50"><script language="javascript">ComComboObject('class1_cntr', 1, 50, 1, 0);</script></td>
									<td width="50"><input type="text" name="in_class1" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
									<td width="15">||</td>
									<td width="60"><script language="javascript">ComComboObject('class2_combo', 1, 60, 1, 0);</script></td>
									<td width="40"><script language="javascript">ComComboObject('class2_svc', 1, 40, 1, 0);</script></td>
									<td width="50"><script language="javascript">ComComboObject('class2_ind', 1, 50, 1, 0);</script></td>
									<td width="50"><script language="javascript">ComComboObject('class2_cntr', 1, 50, 1, 0);</script></td>
									<td width="50"><input type="text" name="in_class2" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
									<td width="15">||</td>
									<td width="60"><script language="javascript">ComComboObject('class3_combo', 1, 60, 1, 0);</script></td>
									<td width="40"><script language="javascript">ComComboObject('class3_svc', 1, 40, 1, 0);</script></td>
									<td width="50"><script language="javascript">ComComboObject('class3_ind', 1, 50, 1, 0);</script></td>
									<td width="50"><script language="javascript">ComComboObject('class3_cntr', 1, 50, 1, 0);</script></td>
									<td width="50"><input type="text" name="in_class3" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
					                <td width="70">
						                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                    <tr>
						                    	<td class="btn1_left"></td>
						                    	<td class="btn1" name="btn_apply2">Apply</td>
						                    	<td class="btn1_right"></td>
						                    </tr>
						                </table>
					                </td>
					                <td width="70">
						                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                    <tr>
						                    	<td class="btn1_left"></td>
						                    	<td class="btn1" name="btn_reset2">Reset</td>
						                    	<td class="btn1_right"></td>
						                    </tr>
						                </table>
					                </td>
					                <td width=""></td>
								</tr>
				 			</table>
				 		</div>
					</td>
				</tr>
			</table>
			
		</td>
	</tr>
</table>

<div style="display:none">
	<table class="search" id="mainTable"> 
      	<tr>
	      	<td class="bg">	
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table class="search" id="mainTable"> 
      	<tr>
	      	<td class="bg">	
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table class="search" id="mainTable"> 
      	<tr>
	      	<td class="bg">	
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet6');</script>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>