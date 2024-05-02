<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0329.jsp
	 *@FileTitle : Korea Manifest Download
	 *Open Issues :  
	 *Change history :
	 *@LastModifyDate : 2009.05.25
	 *@LastModifier : 손윤석
	 *@LastVersion : 1.0
	 * 2009.05.25 손윤석
	 * 1.0 Creation
	 *--------------------------------------------------------
	 * history
	 * 2011.03.29 김영철 [CHM-201109637-01] KOR MANIFEST GENERATE 기능 보완  ( 조건 추가 )
	 * 2011.04.13 김영철 [CHM-201109147-01] 1)I/B 선택하면 CARGO TYPE옵션 추가(ALL/I/T) 2)O/B 선택하면 기존 E/L No.옵션을 선택할 수 있게 변경
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0329Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnNoVO"%>

<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg0329Event event 		= null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException 	= null; //서버에서 발생한 에러
	String strErrMsg 			= ""; 	//에러메세지
	int rowCount 				= 0; 	//DB ResultSet 리스트의 건수

	String successFlag 			= "";
	String codeList 			= "";
	String pageRows 			= "100";

	String strUsr_id 			= "";
	String strUsr_nm 			= "";
	String strOfc_cd			= "";
	boolean bBtn_Disabled 		= true;
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.KorManifestListDownload");

	try
	{
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();	
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0329Event) request.getAttribute("Event");

		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null)
		{
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		if ("US".equals(account.getCnt_cd()) || "CA".equals(account.getCnt_cd()))
		{
			bBtn_Disabled = false;
		}
		else
		{

		}
		
	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Korea: Manifest Generate</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="in_bound" value="I">
<input type="hidden" name="bl_dl" value="bl">
<input type="hidden" name="all_err" value="all">
<input type="hidden" name="in_pod_tmnl" value="KRPUSHN">
<input type="hidden" name="mrn_chk_no" value="">
<input type="hidden" name="mrn_nbr" value="">
<input type="hidden" name="in_blno" value="">
<input type="hidden" name="in_bkg_no" value="">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:982;"> 
					<tr class="h23">
						<td width="30">MRN</td>
						<td width="110">
							<input type="text" name="mrn_no" class="input2" style="width:90; text-align:center;" value="" readOnly>
						</td>
						<td width="30">VVD</td>
						<td width="100">
							<input type="text" name="in_vvd" class="input1" style="width:85; text-align:center;" dataformat="eng"  maxlength="9"
								onfocus="javascript:funcOnFocus('vvd');" 
								value="" >
						</td>
						<td width="33">POL</td>
						<td width="87">
							<input type="text" name="in_pol" class="input" style="width:47; text-align:center;" dataformat="engupnum" maxlength="5"	value="">
							<input type="text" name="in_hn2" class="input" style="width:25; text-align:center;" value="" dataformat="eng" maxlength="2">
						</td>
						<td width="33">POD</td>
						<td width="87">
							<input type="text" name="in_pod" class="input1" style="width:47; text-align:center;" dataformat="engupnum" maxlength="5" onChange="funcOnFocus('pod')" value="">
							<input type="text" name="in_hn" class="input" style="width:25; text-align:center;" value="" dataformat="eng" maxlength="2">
						</td>
						<td width="36">Type</td>
						<td width="120">
							<select style="width:115;" class="input" name="sel_type">
								<option value="A" >A : 미주 Local</option>
								<option value="B" >B : 아/구주 Local</option>
								<option value="C" >C : T/S</option>
								<option value="D" >D : A+B+C+M</option>
								<option value="M" >M : eMpty Local</option> 
								<option value="" selected>  </option>
							</select>
						</td>
						<td width="140">
							<table class="search_sm2" border="0" style="width:135;" >
							<tr class="h23">
								<td>Trans</td>
								<td class="stm">
									<input type="radio" class="trans" name="rad_ib" checked>I/B&nbsp;
									<input type="radio" class="trans" name="rad_ob" >O/B
								</td>
							</tr>
							</table>
						</td>
						<td width="90">
							<table class="search_sm2" border="0" style="width:90;" >
							<tr class="h23">
								<td>
									<input type="radio" class="trans" name="rad_all" checked>All&nbsp;
									<input type="radio" class="trans" name="rad_err" >Error
								</td></tr>
							</table>
						</td>
						<td>&nbsp;</td>
					</tr>
				</table>
				
				<table class="height_8"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:982;"> 
					<tr class="h23">
						<td width="55"><SELECT name="bl_bkg_tp" class="input" disabled>
						<OPTION VALUE="BL">B/L No.</OPTION>
						<OPTION VALUE="BKG">BKG No.</OPTION>
						</SELECT></td>
						<td width="120">
							<input type="text" class="input" style="width:105; text-align:center;" value="" name="bl_bkg_no" dataformat="eng"></td>
						<td width="360">
							<table class="search_sm2" border="0" style="width:350;" >
							<tr class="h23">
								<td>Data</td>
								<td class="stm">
									<input type="radio" class="trans" name="rad_nodownlist" checked>&nbsp;B/L List&nbsp;
									<input type="radio" class="trans" name="rad_downedlist" >&nbsp;D/L List&nbsp;
									<input type="radio" class="trans" name="rad_mftcheck" >&nbsp;M/F Chk&nbsp;
									<input type="radio" class="trans" name="rad_crscheck" >&nbsp;Cross Chk&nbsp;
								</td>
							</tr>
							</table>
						</td>
						
						
						<td width="40" align="right" id="sc_td1" style="display:none;">&nbsp;C/S&nbsp;</td>
						<td width="90" align="right" id="sc_td2" style="display:none;"><script language="javascript">ComComboObject('sc', 2, 80, 1, 0)</script></td>
						<td width="40"><input type="text" class="input" name="msn_start_num" style="width:34; text-align:center; display:none;" maxlength="4" dataformat="int"></td>
						<td width="100" align="right"><table id="tb_msn_save" style="display:none;" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_msn_save" id="btn_msn_save">MSN Save</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						<td width="70" align="right" id="etb_td1" style="display:none;">ETB</td>
						<td width="60" align="right" id="etb_td2" style="display:none;"><input type="text" name="etb_dt" class="input2" style="width:80; text-align:center;" ReadOnly></td>
						<td>&nbsp;</td>
					</tr></table>
				<table class="height_8"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:700;"> 
					<tr class="h23">
					
					
						<td width="70">B/L Type</td>
						<td width="80">
							<select style="width:70;" class="input" name="bl_type" onchange="javascript:funcBlTypeOnChange(this);">
								<option value="" selected>ALL</option>
								<option value="S">Simple</option>
								<option value="C">Consol</option>
								<option value="E">Empty</option>
								<option value="M">T/S Empty</option>
							</select></td>
						<td width="40" id="si_flg1" style="display:none;">S/R</td>
						<td width="60" id="si_flg2" style="display:none;">
							<select style="width:50;" class="input" name="si_flg" onchange="javascript:funcSiFlgOnChange(this);">
								<option value="" selected>ALL</option>
								<option value="Y">Yes</option>
								<option value="N">No</option>
							</select>
						</td>
						<td width="60" id="el_no1" style="display:none;">E/L No.</td>
						<td width="60" id="el_no2" style="display:none;">
							<select style="width:50;" class="input" name="el_type" onchange="javascript:funcElTypeOnChange(this);">
								<option value="" selected>ALL</option>
								<option value="Y">Yes</option>
								<option value="N">No</option>
							</select>
						</td>
						<td width="60" id="cgo_tp1" style="display:inline;">CGO TP</td>
						<td width="60" id="cgo_tp2" style="display:inline;">
							<select style="width:50;" class="input" name="cgo_tp" onchange="javascript:funcCargoTypeOnChange(this);">
								<option value="" selected>ALL</option>
								<option value="I">I</option>
								<option value="T">T</option>
							</select>
						</td>
					 <td width="75">Correction</td>
						<td width="60">
							<script language="javascript">ComComboObject('correction', 1, 50, 1, 0)</script>
						</td>											
					<td width="40" align="right"><span id="span_eta_etd">ETA</span></td>
					<td width="90" align="right"><input type="text" name="eta_etd" class="input2" style="width:80; text-align:center;" ReadOnly></td>
					</tr>
				</table>
				
				<!--  biz_1   (E) -->		
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							
						</td>
					</tr>
				</table>

				<table width="100%"  id="subTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
							<script language="javascript">ComSheetObject('sheet3');</script>
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
				
				
			<table width="100%" class="grid" id="mainTable"> 
			<tr class="tr_head3">
				<td colspan="19" align="center" style="height:35;">
				<b>B/L :</b> Local&nbsp;&nbsp;
				<input type="text" style="width:35;" class="input" style="text-align:right;" value="" name="bl_local" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				T/S&nbsp;&nbsp;
				<input type="text" style="width:35;" class="input" style="text-align:right;" value="" name="bl_ts" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Empty&nbsp;&nbsp;
				<input type="text" style="width:35;" class="input" style="text-align:right;" value="" name="bl_empty" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				T/S E.&nbsp;&nbsp;
				<input type="text" style="width:35;" class="input" style="text-align:right;" value="" name="bl_ts_empty" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Total&nbsp;&nbsp;
				<input type="text" style="width:35;" class="input" style="text-align:right;" value="" name="bl_total" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<b>CNTR :</b> Local&nbsp;&nbsp;
				<input type="text" style="width:35;" class="input" style="text-align:right;" value="" name="cntr_local" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				T/S&nbsp;&nbsp;
				<input type="text" style="width:35;" class="input" style="text-align:right;" value="" name="cntr_ts" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Empty&nbsp;&nbsp;
				<input type="text" style="width:35;" class="input" style="text-align:right;" value="" name="cntr_empty" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				T/S E.&nbsp;&nbsp;
				<input type="text" style="width:35;" class="input" style="text-align:right;" value="" name="cntr_ts_empty" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Total&nbsp;&nbsp;
				<input type="text" style="width:35;" class="input" style="text-align:right;" value="" name="cntr_total" readOnly></td></tr>
			</table> 
			<!-- Grid (E) -->		
			</td></tr>
		</table>
		<!--biz page (E)-->
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DataDL">Data D/L</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_AddBL">Add B/L</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_EditBL">Edit B/L</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_EmailS">Email(S)</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_EmailC">Email(C)</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Transmission">Transmission</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td width="60" align="right"><table id="tb_rlst_save" style="display:none;" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_rlst_save" id="btn_rlst_save">Save</td>
							<td class="btn1_right"></td>
							</tr>
							</table></td>				
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	</td></tr>
		</table>
		
<!-- 개발자 작업  끝 -->
</form>
<Form name="transmitForm" id="transmitForm" method="POST" Action="/hanjin/ESM_BKG_0344.do?pgmNo=ESM_BKG_0344" target="transmitWindow">
<input type="hidden" name="in_vvd">
<input type="hidden" name="in_pol">
<input type="hidden" name="in_type">
<input type="hidden" name="in_pod">
<input type="hidden" name="in_blno">
<input type="hidden" name="in_bound">
<input type="hidden" name="in_tml">
<input type="hidden" name="dwell">
<input type="hidden" name="ib_vvd">
<input type="hidden" name="ib_seq">
<input type="hidden" name="ib_cblno">
<input type="hidden" name="ib_port">
<input type="hidden" name="ib_bkgno">
<input type="hidden" name="ib_type">
</Form>
</body>
</html>
