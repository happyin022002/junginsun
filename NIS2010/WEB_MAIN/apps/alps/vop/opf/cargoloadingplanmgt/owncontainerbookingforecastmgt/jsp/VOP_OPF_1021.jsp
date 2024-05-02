<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0021.jsp
*@FileTitle : Own Container Booking Forecast Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.07.07 우지석
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf1021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf1021Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");

	//Combo String
	StringBuffer vslOprComboItem = new StringBuffer();

	String vsl_cd      = "";
	String skd_voy_no  = "";
	String skd_dir_cd  = "";
	String vsl_nm      = "";
	String yd_cd       = "";
	String loc_nm      = "";
	String yd_nm       = "";
	String slan_cd     = "";
	String slan_nm     = "";
	String cbf_ind_flg = "";
	String upd_dt      = "";
	String crr_cd      = "";
	String pod_cd      = "";
	String mlb_cd      = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopOpf1021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		vsl_cd      = JSPUtil.getParameter(request, "vsl_cd".trim(), "");
		skd_voy_no  = JSPUtil.getParameter(request, "skd_voy_no".trim(), "");
		skd_dir_cd  = JSPUtil.getParameter(request, "skd_dir_cd".trim(), "");
		vsl_nm      = JSPUtil.getParameter(request, "vsl_eng_nm".trim(), "");
		yd_cd       = JSPUtil.getParameter(request, "yd_cd".trim(), "");
		loc_nm      = JSPUtil.getParameter(request, "loc_nm".trim(), "");
		yd_nm       = JSPUtil.getParameter(request, "yd_nm".trim(), "");
		slan_cd     = JSPUtil.getParameter(request, "slan_cd".trim(), "");
		slan_nm     = JSPUtil.getParameter(request, "slan_nm".trim(), "");
		cbf_ind_flg = JSPUtil.getParameter(request, "cbf_ind_flg".trim(), "");
		upd_dt      = JSPUtil.getParameter(request, "upd_dt".trim(), "");
		crr_cd      = JSPUtil.getParameter(request, "crr_cd".trim(), "").equals("ALL")?"":JSPUtil.getParameter(request, "crr_cd".trim(), "");
		pod_cd      = JSPUtil.getParameter(request, "pod_cd".trim(), "");
		mlb_cd      = JSPUtil.getParameter(request, "mlb_cd".trim(), "");
		

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CBF – Volume/Weight/Special Cargo (Inquiry)</title>
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
<input type="hidden" name="head_opr_list" value="">
<input type="hidden" name="com_templateMrd" value="VOP_OPF_1021.mrd">
<input type="hidden" name="com_templateMrdArguments">
<input type="hidden" name="com_templateMrdDescription" value="VOP_OPF_1021.mrd 파일이 첨부되었습니다.">

<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden"   name="com_mrdPath">
<input type="hidden"   name="com_mrdArguments">
<input type="hidden"   name="com_mrdSaveDialogDir">
<input type="hidden"   name="com_mrdSaveDialogFileName">
<input type="hidden"   name="com_mrdSaveDialogFileExt">
<input type="hidden"   name="com_mrdSaveDialogFileExtLimit">
<input type="hidden"   name="com_mrdTitle">
<input type="hidden"   name="com_mrdDisableToolbar">
<input type="hidden"   name="com_mrdBodyTitle">
<input type="hidden"   name="com_isBatch">
<input type="hidden"   name="com_zoomIn">

<!-- 1021 RD파라메터. -->
<input type="hidden"   name="vsl_cd" 		value="<%=vsl_cd%>">
<input type="hidden"   name="skd_voy_no" 	value="<%=skd_voy_no%>">
<input type="hidden"   name="skd_dir_cd" 	value="<%=skd_dir_cd%>">
<input type="hidden"   name="vsl_nm" 		value="<%=vsl_nm%>">
<input type="hidden"   name="yd_cd" 		value="<%=yd_cd%>">
<input type="hidden"   name="loc_nm" 		value="<%=loc_nm%>">
<input type="hidden"   name="yd_nm" 		value="<%=yd_nm%>">
<input type="hidden"   name="slan_cd" 		value="<%=slan_cd%>">
<input type="hidden"   name="slan_nm" 		value="<%=slan_nm%>">
<input type="hidden"   name="cbf_ind_flg" 	value="<%=cbf_ind_flg%>">
<input type="hidden"   name="upd_dt" 		value="<%=upd_dt%>">
<input type="hidden"   name="crr_cd" 		value="<%=crr_cd%>">
<input type="hidden"   name="pod_cd" 		value="<%=pod_cd%>">
<input type="hidden"   name="mlb_cd" 		value="<%=mlb_cd%>">

<input type="hidden" name="st_1"> 
<input type="hidden" name="st_2"> 
<input type="hidden" name="st_3">
<input type="hidden" name="st_4"> 
<input type="hidden" name="st_5"> 
<input type="hidden" name="st_6"> 
<input type="hidden" name="st_7"> 
<input type="hidden" name="st_8">
<input type="hidden" name="st_9"> 
<input type="hidden" name="st_10"> 
<input type="hidden" name="st_11"> 
<input type="hidden" name="st_12"> 
<input type="hidden" name="st_13">
<input type="hidden" name="st_14"> 
<input type="hidden" name="st_15">

<input type="hidden" name="opr_st_ct">
<input type="hidden" name="opr1_st1" value="0">  
<input type="hidden" name="opr1_st2" value="0">  
<input type="hidden" name="opr1_st3" value="0">  
<input type="hidden" name="opr1_st4" value="0">  
<input type="hidden" name="opr1_st5" value="0">  
<input type="hidden" name="opr1_st6" value="0">  
<input type="hidden" name="opr1_st7" value="0">  
<input type="hidden" name="opr1_st8" value="0">  
<input type="hidden" name="opr1_st9" value="0">  
<input type="hidden" name="opr1_st10" value="0">
<input type="hidden" name="opr1_st11" value="0">
<input type="hidden" name="opr1_st12" value="0">
<input type="hidden" name="opr1_st13" value="0">
<input type="hidden" name="opr1_st14" value="0">
<input type="hidden" name="opr1_st15" value="0">
<input type="hidden" name="opr2_st1" value="0"> 
<input type="hidden" name="opr2_st2" value="0"> 
<input type="hidden" name="opr2_st3" value="0"> 
<input type="hidden" name="opr2_st4" value="0"> 
<input type="hidden" name="opr2_st5" value="0"> 
<input type="hidden" name="opr2_st6" value="0"> 
<input type="hidden" name="opr2_st7" value="0"> 
<input type="hidden" name="opr2_st8" value="0"> 
<input type="hidden" name="opr2_st9" value="0"> 
<input type="hidden" name="opr2_st10" value="0">
<input type="hidden" name="opr2_st11" value="0">
<input type="hidden" name="opr2_st12" value="0">
<input type="hidden" name="opr2_st13" value="0">
<input type="hidden" name="opr2_st14" value="0">
<input type="hidden" name="opr2_st15" value="0">
<input type="hidden" name="opr3_st1" value="0"> 
<input type="hidden" name="opr3_st2" value="0"> 
<input type="hidden" name="opr3_st3" value="0"> 
<input type="hidden" name="opr3_st4" value="0"> 
<input type="hidden" name="opr3_st5" value="0"> 
<input type="hidden" name="opr3_st6" value="0"> 
<input type="hidden" name="opr3_st7" value="0"> 
<input type="hidden" name="opr3_st8" value="0"> 
<input type="hidden" name="opr3_st9" value="0"> 
<input type="hidden" name="opr3_st10" value="0">
<input type="hidden" name="opr3_st11" value="0">
<input type="hidden" name="opr3_st12" value="0">
<input type="hidden" name="opr3_st13" value="0">
<input type="hidden" name="opr3_st14" value="0">
<input type="hidden" name="opr3_st15" value="0">
<input type="hidden" name="opr4_st1" value="0"> 
<input type="hidden" name="opr4_st2" value="0"> 
<input type="hidden" name="opr4_st3" value="0"> 
<input type="hidden" name="opr4_st4" value="0"> 
<input type="hidden" name="opr4_st5" value="0"> 
<input type="hidden" name="opr4_st6" value="0"> 
<input type="hidden" name="opr4_st7" value="0"> 
<input type="hidden" name="opr4_st8" value="0"> 
<input type="hidden" name="opr4_st9" value="0"> 
<input type="hidden" name="opr4_st10" value="0">
<input type="hidden" name="opr4_st11" value="0">
<input type="hidden" name="opr4_st12" value="0">
<input type="hidden" name="opr4_st13" value="0">
<input type="hidden" name="opr4_st14" value="0">
<input type="hidden" name="opr4_st15" value="0">
<input type="hidden" name="opr5_st1" value="0"> 
<input type="hidden" name="opr5_st2" value="0"> 
<input type="hidden" name="opr5_st3" value="0"> 
<input type="hidden" name="opr5_st4" value="0"> 
<input type="hidden" name="opr5_st5" value="0"> 
<input type="hidden" name="opr5_st6" value="0"> 
<input type="hidden" name="opr5_st7" value="0"> 
<input type="hidden" name="opr5_st8" value="0"> 
<input type="hidden" name="opr5_st9" value="0"> 
<input type="hidden" name="opr5_st10" value="0">
<input type="hidden" name="opr5_st11" value="0">
<input type="hidden" name="opr5_st12" value="0">
<input type="hidden" name="opr5_st13" value="0">
<input type="hidden" name="opr5_st14" value="0">
<input type="hidden" name="opr5_st15" value="0">

<input type="hidden" name="opr_stcd1">
<input type="hidden" name="opr_stcd2">
<input type="hidden" name="opr_stcd3">
<input type="hidden" name="opr_stcd4">
<input type="hidden" name="opr_stcd5">
<input type="hidden" name="opr_stcd6">
<input type="hidden" name="opr_stcd7">
<input type="hidden" name="opr_stcd8">
<input type="hidden" name="opr_stcd9">
<input type="hidden" name="opr_stcd10">
<input type="hidden" name="opr_stcd11">
<input type="hidden" name="opr_stcd12">
<input type="hidden" name="opr_stcd13">
<input type="hidden" name="opr_stcd14">
<input type="hidden" name="opr_stcd15">
<input type="hidden" name="opr_stcd16">
<input type="hidden" name="opr_stcd17">
<input type="hidden" name="opr_stcd18">
<input type="hidden" name="opr_stcd19">
<input type="hidden" name="opr_stcd20">
<input type="hidden" name="opr_stcd21">
<input type="hidden" name="opr_stcd22">
<input type="hidden" name="opr_stcd23">
<input type="hidden" name="opr_stcd24">
<input type="hidden" name="opr_stcd25">
<input type="hidden" name="opr_stcd26">
<input type="hidden" name="opr_stcd27">
<input type="hidden" name="opr_stcd28">
<input type="hidden" name="opr_stcd29">
<input type="hidden" name="opr_stcd30">
<input type="hidden" name="opr_stcd31">
<input type="hidden" name="opr_stcd32">
<input type="hidden" name="opr_stcd33">
<input type="hidden" name="opr_stcd34">
<input type="hidden" name="opr_stcd35">
<input type="hidden" name="opr_stcd36">
<input type="hidden" name="opr_stcd37">
<input type="hidden" name="opr_stcd38">
<input type="hidden" name="opr_stcd39">
<input type="hidden" name="opr_stcd40">
<input type="hidden" name="opr_stcd41">
<input type="hidden" name="opr_stcd42">
<input type="hidden" name="opr_stcd43">
<input type="hidden" name="opr_stcd44">
<input type="hidden" name="opr_stcd45">
<input type="hidden" name="opr_stcd46">
<input type="hidden" name="opr_stcd47">
<input type="hidden" name="opr_stcd48">
<input type="hidden" name="opr_stcd49">
<input type="hidden" name="opr_stcd50">
<input type="hidden" name="opr_stcd51">
<input type="hidden" name="opr_stcd52">
<input type="hidden" name="opr_stcd53">
<input type="hidden" name="opr_stcd54">
<input type="hidden" name="opr_stcd55">
<input type="hidden" name="opr_stcd56">
<input type="hidden" name="opr_stcd57">
<input type="hidden" name="opr_stcd58">
<input type="hidden" name="opr_stcd59">
<input type="hidden" name="opr_stcd60">
<input type="hidden" name="opr_stcd61">
<input type="hidden" name="opr_stcd62">
<input type="hidden" name="opr_stcd63">
<input type="hidden" name="opr_stcd64">
<input type="hidden" name="opr_stcd65">
<input type="hidden" name="opr_stcd66">
<input type="hidden" name="opr_stcd67">
<input type="hidden" name="opr_stcd68">
<input type="hidden" name="opr_stcd69">
<input type="hidden" name="opr_stcd70">
<input type="hidden" name="opr_stcd71">
<input type="hidden" name="opr_stcd72">
<input type="hidden" name="opr_stcd73">
<input type="hidden" name="opr_stcd74">
<input type="hidden" name="opr_stcd75">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">	
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Print CBF Summary  </td></tr>
			</table>
			<!-- : ( Title ) (E) -->
		
			<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<table class="search" border="0" style="width:496;">
						    <tr class="h23">
						    	<td width="">
									<table class="search" border="0" style="width:496;">
										<tr class="h23">
											<td width="70">&nbsp;</td>				
											<td width="">
												<table class="search" border="0"> 
													<tr class="h23">
														<td width="30">&nbsp;&nbsp;POD&nbsp;</td>   
														<td width="80"><script language="javascript">ComComboObject('pod_cd2', 1, 70, 1, 0, 0, false);</script></td>
														<td width="30">OPR</td>
														<td width="80"><script language="javascript">ComComboObject('crr_cd2', 1, 70, 1, 0, 0, false);</script></td>
														<td width="30">MLB</td>
														<td width="80"><script language="javascript">ComComboObject('mlb_cd2', 1, 70, 1);</script></td>
													</tr>
												</table>										
											</td>
											<td width="70">&nbsp;</td>	
										</tr>
									</table>
								</td>
							</tr>	
							<tr>
								<td>
									<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>								
								</td>
							</tr>
							<tr class="h23">
								<td width="">
									<table class="search_sm" border="0" style="width:496;"> 
										<tr class="h23">
											<td width="125">Volume</td>
											<td width=""><input type="radio" value="1" name="selPrint"  class="trans" checked>&nbsp;&nbsp;CBF Summary by Volume</td>
										</tr>
										<tr class="h23">
											<td width="">&nbsp;</td>
											<td width=""><input type="radio" value="2" name="selPrint" class="trans">&nbsp;&nbsp;Special Cargo Summary by Volume</td>
										</tr>
										<tr class="h23">
											<td width="">&nbsp;</td>
											<td width=""><input type="radio" value="3" name="selPrint" class="trans">&nbsp;&nbsp;CBF Summary by Volume (Mini Land Bridge)</td>
										</tr>	
										<tr class="h23">
											<td width="">&nbsp;</td>
											<td width=""><input type="radio" value="4" name="selPrint" class="trans">&nbsp;&nbsp;Special Cargo Summary by Volume (Mini Land Bridge)</td>
										</tr>									
										<tr class="h23">
											<td colspan="2">
												<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>								
											</td>
										</tr>
										<tr class="h23">
											<td width="">Weight Group</td>
											<td width=""><input type="radio" value="5" name="selPrint" class="trans">&nbsp;&nbsp;CBF Summary by Weight Group</td>
										</tr>
										<tr class="h23">
											<td width="">&nbsp;</td>
											<td width=""><input type="radio" value="6" name="selPrint" class="trans">&nbsp;&nbsp;CBF Summary by Weight Group (Mini Land Bridge)</td>
										</tr>
										<tr class="h23">
											<td colspan="2">
												<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
											</td>
										</tr>		
										<tr class="h23">
											<td width="">Special Cargo Type</td>
											<td width=""><input type="radio" value="7" name="selPrint" class="trans">&nbsp;&nbsp;All Special Cargo</td>
										</tr>
										<tr class="h23">
											<td width="">&nbsp;</td>
											<td width=""><input type="radio" value="8" name="selPrint" class="trans">&nbsp;&nbsp;Dangerous Cargo</td>
										</tr>
										<tr class="h23">
											<td width="">&nbsp;</td>
											<td width=""><input type="radio" value="9" name="selPrint" class="trans">&nbsp;&nbsp;Reefer Cargo</td>
										</tr>
										<tr class="h23">
											<td width="">&nbsp;</td>
											<td width=""><input type="radio" value="10" name="selPrint" class="trans">&nbsp;&nbsp;Awkward Cargo</td>
										</tr>
										<tr class="h23">
											<td width="">&nbsp;</td>
											<td width=""><input type="radio" value="11" name="selPrint" class="trans">&nbsp;&nbsp;Break Bulk Cargo</td>
										</tr>
										<tr class="h23">
											<td width="">&nbsp;</td>
											<td width=""><input type="radio" value="12" name="selPrint" class="trans">&nbsp;&nbsp;Special Stowage</td>
										</tr>
										<tr class="h23">
											<td width="">&nbsp;</td>
											<td width=""><input type="radio" value="13" name="selPrint" class="trans">&nbsp;&nbsp;Empty Container</td>
										</tr>
									</table>								
								</td> 
							</tr>
						</table>
						<!--  Button_Sub (S) -->
						
		    			<!-- Button_Sub (E) -->
				
					</td> 
				</tr>
			</table>
		</td> 
	</tr>
</table>	

<table class="height_5"><tr><td></td></tr></table>	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
		    					<td width="">
		    						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Print">Print</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td width="">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
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
		</td>
	</tr>
</table>

<table class="search">
	<tr>
		<td class="bg">
			<table width="95%" id="mainTable">
				<tr>
					<td width="95%"><script language="javascript">ComSheetObject('sheet1');</script></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>