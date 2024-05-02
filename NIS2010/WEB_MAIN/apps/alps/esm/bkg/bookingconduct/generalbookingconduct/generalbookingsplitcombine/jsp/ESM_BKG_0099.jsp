<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0099.jsp
*@FileTitle : Booking Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.18 최영희
* 1.0 Creation
* -------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
* 2011.03.30 정선용 [CHM-201109338-01] Split 18-ALPS의 Location 조회불가건 수정 보완 요청.
* 2011.05.25 김기종 [CHM-201109394-01] DPCS고도화일환으로 Split 처리시 BKG NO 수정과 DPCS SI전송 (ESM_BKG_0455 화면에서 CALL)
* 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
* 2012.10.22 조정민 [CHM-201220706] Special Appliatoin Split시 호출방식 변경
* 2014.07.25 문동선 [CHM-201430707] FumigationHide liner 버튼 및 팝업창 구현, BST 조회 로직
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0099Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%
	EsmBkg0099Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strAsList = "";
	String strAsCode = "";
	String strAsText = "";
	String strBkgNo = "";
	String popUpFlag = "";
	String splitcount = "";
	String openerPgmNo = "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingSplitCombine");
	String strUserHomerFileSeparator = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strAsList=JSPUtil.getIBCodeCombo("", "", "CD01637", 0, "");
		
		if(strAsList != null && strAsList.length() > 8) {
			strAsCode = strAsList.substring(strAsList.indexOf("Code = \"")+8, strAsList.lastIndexOf("\""));
			strAsText = strAsList.substring(strAsList.indexOf("Text = \"")+8, strAsList.indexOf("\";"));  
		}

		event = (EsmBkg0099Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		popUpFlag = JSPUtil.getParameter(request, "popUpFlag");
		splitcount = JSPUtil.getNull(JSPUtil.getParameter(request, "splitcount"),"0");
		openerPgmNo = JSPUtil.getNull(JSPUtil.getParameter(request, "openerPgmNo"));
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strBkgNo =JSPUtil.getNull(event.getBkgBlNoVO().getBkgNo());
		
		String strTemp1 = System.getProperty("user.home");
	    if (strTemp1 != null) {
	    } else {
	    	strTemp1 = "";
	    }
	  	
	    String strTemp2 = System.getProperty("file.separator");
	    if (strTemp2 != null) {
	    } else {
	    	strTemp2 = "";
	    }
	    strUserHomerFileSeparator = strTemp1 + strTemp2;
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Split</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=strAsCode%>","<%=strAsText%>");
	}
</script>
</head>

<body  onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="openerPgmNo" value="<%=openerPgmNo%>">
<input type="hidden" name="orgSplit">


<!-- Groupmail시 반영될 Hidden --> 
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_template" value="ESM_BKG_COMM_01T.html">
<input type="hidden" name="gw_args" value="reqcontents;">

<input type="hidden" name="dg">
<input type="hidden" name="rf">
<input type="hidden" name="ak">
<input type="hidden" name="bb">

<input type="hidden" name="bdr_flag">
<input type="hidden" name="bkgStsCd">
<input type="hidden" name="split_rsn_cd">  <!--MEMO SPLIT된 건 인지 여부-->
<input type="hidden" name="bkg_cgo_tp_cd">
<input type="hidden" name="lastSplitNo"> 
<input type="hidden" name="custSplitNo">
<input type="hidden" name="memosplitno">
<input type="hidden" name="pseudoVvdFlag">
<input type="hidden" name="partialflag">
<input type="hidden" name="old_bkg_no" value="<%=strBkgNo%>">
<input type="hidden" name="codflag" value="N"> <!-- COD 처리 관련 구분자-->
<input type="hidden" name="caflag">
<input type="hidden" name="pctl_no">
<input type="hidden" name="pcIdx" value="0">
<input type="hidden" name="tro_flg">
<input type="hidden" name="splitdel">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">

<input type="hidden" name="qtySplitNo">
<input type="hidden" name="cntrSplitNo">
<input type="hidden" name="dgCntrSplitNo">
<input type="hidden" name="rfCntrSplitNo">
<input type="hidden" name="akCntrSplitNo">
<input type="hidden" name="bbCntrSplitNo">
<input type="hidden" name="troSplitNo">
<input type="hidden" name="troTp">
<input type="hidden" name="validateSplitNo">
<input type="hidden" name="bkgsplitno"> 
<input type="hidden" name="cntrExists"> 
<input type="hidden" name="caRsnCd"> 
<input type="hidden" name="caRemark">
<input type="hidden" name="cntrPopExists" value="N"> 
<input type="hidden" name="popUpFlag" value="<%=popUpFlag%>">
<input type="hidden" name="bkg_close_flg" value="N"> 
<input type="hidden" name="bkg_cbf_flg" value="N"> 
<input type="hidden" name=obl_iss_flg value="N">
<input type="hidden" name="vvd_change_flg" value="N">

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdBodyTitle" value="e-Booking &amp; SI Preview">
<input type="hidden" name="com_zoomIn" value="3">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=strUserHomerFileSeparator%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_zoomIn">
<input type="hidden" name="lt_flg" value="N">
<%

	String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
%>
<% 
if(mainPage.equals("true")){
%>


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5; padding-right:5;" >
            
                <tr>
                    <td valign="top">
                        <!--Page Title, Historical (S)-->
                        <table width="100%" border="0" cellpadding="0" cellspacing="0"
                               class="title">
                            <tr>
                                <td class="history"><img src="img/icon_history_dot.gif"  align="absmiddle"><span id="navigation"></span></td>
                            </tr>
                            <tr>
                                <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
                            </tr>

                        </table>
                        <!--Page Title, Historical (E)--> <!-- Grid BG Box  (S) -->
<%
}else {
%>     
		<table width="100%" class="popup" cellpadding="10" border="0"> 
			<tr><td class="top"></td></tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0">
					<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
					</table>
<%
}
%>                   
		<!--Page Title, Historical (E)-->
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="330" valign="top">
							<!--  biz_1_1 (S) -->
							<table class="search" border="0" style="width:98%;"> 
								<tr class="h23">
									<td width="50">BKG No.</td>
									<td ><input type="text" style="width:110;" value="<%=strBkgNo%>" class="input" dataformat="engup" name="bkg_no" maxlength="13">&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_split_pop"></td>
									<td><div id="splitFlag" style="display:none"></div></td>
									<td><div id="bdrFlag" style="display:none"></div></td>
								</tr>
								<tr class="h23">
									<td width="50">B/L No.</td>
									<td width="140"><input type="text" style="width:110;"  class="input" dataformat="engup" name="bl_no" disabled></td>
									<td width="30">T/VVD</td>
									<td width=""><input type="text" style="width:80;"  class="input" dataformat="engup" name="tvvd" disabled></td>
								</tr>
								<tr class="h23">
									<td width="">Route</td>
									<td colspan="3"><input type="text" style="width:52;" class="input" dataformat="engupnum" name="por_cd" disabled>&nbsp;<input type="text" style="width:53;"  class="input" dataformat="engupnum" name="pol_cd" disabled>&nbsp;<input type="text" style="width:53;"  class="input" dataformat="engupnum" name="pod_cd" disabled>&nbsp;<input type="text" style="width:53;"  class="input" dataformat="engupnum" name="del_cd" disabled>&nbsp;</td>
								</tr>
							</table>
							<!--  biz_1_1   (E) -->		
						
						
						</td>
						<td width="330" valign="top">
							
							<!--  biz_1_1 (S) -->
							<table class="search" border="0" style="width:98%;"> 
								<tr class="h23">
									<td width="100"><input type="checkbox"  class="trans" name="stwg_cd">Stowage</td>
									<td width="100"><input type="checkbox"  class="trans" name="rail_blk_cd">Bulk Rail</td>
									<td width=""><input type="checkbox"     class="trans" name="fd_grd_flg">Food Grade</td>
								</tr>
								<tr class="h23">
									<td width="100"><input type="checkbox"  class="trans" name="hngr_flg">Hanger</td>
									<td width=""><input type="checkbox"     class="trans" name="prct_flg">Precaution</td>
									<td width="100"><input type="checkbox"  class="trans" name="stop_off_loc_cd">Stop Off</td>
								</tr>
								<tr class="h23">
									<td width="100"><input type="checkbox"  class="trans" name="fumg_loc_cd">Fumigation</td>
									<td width=""><input type="checkbox"  class="trans" name="spcl_hide_flg">Hide</td>
									<td width="100"><input type="checkbox"  class="trans" name="spcl_hide_lnr_flg">Hide Liner</td>
								</tr>
								<tr class="h23">
									<td width="100"><input type="checkbox"     class="trans" name="remark">Remark</td>
									<td width=""><input type="checkbox"     class="trans" name="veh_cmdt_flg">Vehicle</td>
									<td width="100"></td>
								</tr>
							</table>
							<!--  biz_1_1   (E) -->		
						
						</td>
						<td width="19">&nbsp;</td>
						<td width="300">
						<!--  biz_1_2 (S) -->
							<table class="search_sm" border="0" style="width:300;"> 
								<tr class="h23">
									<td width="">
									   <table class="grid2" border="0" style="width:280;"> 
											<tr class="tr2_head">
												<td width="200" colspan="2">Type</td>
												<td width="" >No.</td>
											</tr>
											<tr class="">
												<td width="100"><input type="radio" value="C" class="trans" checked name="splitreason" id="C">Customer</td>
												<td width="100"><input type="radio" value="M" class="trans" name="splitreason" id="M">Memo B/L</td>
												<td width=""><input type="text" style="width:60;" name="splitcount" class="input1" dataformat="num" value="<%=splitcount%>" <%=openerPgmNo.equals("ESM_BKG_0445") ? "readonly":"" %>></td>
											</tr>
										</table>
									   <table class="Search" border="0" style="width:280;"> 
											
											<tr class="h23">
												<td width="208" align="right"><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr><td class="btn2_left"></td>
																	<td class="btn2" name="btn_auto" id="btn_auto">Auto</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
												</td>
												<td width=""><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr><td class="btn2_left"></td>
																	<td class="btn2" name="btn_manual" id="btn_manual" >Manual</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
												</td>
											</tr>
										</table>
									
									</td>
								</tr>
								
							</table>
							<!--  biz_1_2   (E) -->		
						</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<!-- 1 (E) -->


		<!-- 2 (S) -->		
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
		
		
		
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Original</td></tr>
				</table>
				
				
			<!-- Grid_2 (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid_2 (E) -->		
			
			
			
			<table class="height_8"><tr><td></td></tr></table>	
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Split</td></tr>
				</table>
				
				
				
			<!-- Grid_2 (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid_2 (E) -->	
			<!--  Button_Sub (S) -->
			<table width="100%" class="button" border="0"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0" id="pc_list">
				<tr>
					<!--<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="">P/C</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					-->
				</tr>
				</table>
				
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			<table class="height_8"><tr><td></td></tr></table>	

			<!-- 2-1 (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="480" valign="top">
							
					<!-- Grid_2 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid_2 (E) -->	
					
			<table class="height_10"><tr><td></td></tr></table>	
				
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Special Cargo Application Split</td></tr>
				</table>
					
					<table width="100%" class="search"> 
					<tr>
						<td width="75"><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_dg">DG</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width="75"><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rf">RF</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width="75"><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_ak">AK</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width="75"><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_bb">BB</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width="180"></td>
					</tr>	
					</table> 	
					
					</td>
					<td width="19" valign="top">&nbsp;</td>
					<td width="480" valign="top">
					
						<!-- Grid_2 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
					<tr>
						<td height=25>
						</td>
					</tr>
					<tr>
						<td width="100%" align=right>
						<input type="checkbox" name="edi_hld_flg" value="Y" /> &nbsp;<b>Auto EDI Hold</b>
						</td>
					</tr>
				</table> 
			<!-- Grid_2 (E) -->	
					</td>
				</tr>
			</table>
			<!-- 2-1 (E) -->			
			</td></tr>
		</table>
		<!-- 2 (E) -->
		
		
			</td></tr>
		</table>
		<!--biz page (E)-->
		<!-- Grid_5 (S) -->
				<table width="0"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table> 
				<table width="0"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet6');</script>
						</td>
					</tr>
				</table> 
				<table width="0"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet7');</script>
						</td>
					</tr>
				</table> 
				<table width="0"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet8');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid_5 (E) -->	

	

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="40" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="40"><input name="txtProgress" style="width:40;" class="input2" readonly></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td id="btn_save"><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btn_save2"><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save2">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td id="btn_upload"><table width="112" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_upload">Excel Upload</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> 
				<!-- <td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left" id="btn_left"></td>
					<td class="btn1" name="btn_reason" id="btn_reason">C/A Reason</td>
					<td class="btn1_right" id="btn_right"></td>
					</tr>
				</table></td> -->
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
<%
if(!mainPage.equals("true")){
%>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
			
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Close" onClick="self.close()">Close</td>
										<td class="btn1_right"></td>
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
<script>
	if(typeof(document.getElementById("title")) != "undefined"){
		document.getElementById("title").innerHTML = curTitle;
		document.body.className ="popup_bg";
	}
</script>
<%
}
%>
<!-- 개발자 작업  끝 -->
</form>
 <table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
</body>
</html>