<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0077.jsp
*@FileTitle : Booking Copy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.09 김병규
* 1.0 Creation
* ------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0077Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0077Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingReceipt");

	String bkgNo = "";
	String bkgStsCd = "";
	String bdrFlg = "";	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0077Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		bkgStsCd  = JSPUtil.getParameter(request, "bkg_sts_cd");
		bdrFlg  = JSPUtil.getParameter(request, "bdr_flg");
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Copy</title>
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
<input type="hidden" name="bkg_no" value="<%= bkgNo%>">
<input type="hidden" name="bkg_sts_cd" value="<%= bkgStsCd%>">
<input type="hidden" name="bdr_flg" value="<%= bdrFlg%>">
<input type="hidden" name="trunkSeq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="c_cust_cnt_cd">
<input type="hidden" name="c_cust_seq">
<input type="hidden" name="f_cust_cnt_cd">
<input type="hidden" name="f_cust_seq">
<input type="hidden" name="bkg_trunk_vvd">
<input type="hidden" name="por_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="del_cd">
<input type="hidden" name="pc_inq_flg">
<input type="hidden" name="rfa_no_old" >
<input type="hidden" name="sc_no_old" >
<input type="hidden" name="taa_no_old" >
<input type="hidden" name="vvd_modify_flg" >
<input type="hidden" name="close_bkg_flag" >
<input type="hidden" name="cbf_bkg_flag" >
<input type="hidden" name="mail_open_flag" >
<input type="hidden" name="pctl_no">

<!-- Groupmail시 반영될 Hidden --> 
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_template" value="ESM_BKG_COMM_01T.html">
<input type="hidden" name="gw_args" value="reqcontents;">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Booking Copy</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 		<!-- 1 (S) -->
		<table class="search"> 
       		<tr><td class="bg">
		
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:684;"> 
				<tr class="h23">
					<td width="157">Original booking number</td>
					<td width="210"><input type="text" style="width:130;" class="input2" name="bkg_no" value="<%= bkgNo%>" readonly></td> 
					<td width="105">Number of Copy</td>
					<td width=""><input type="text" style="width:35;" class="input1" name="copy_cnt" value=""  maxlength="2" dataformat="int" tabindex="2"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
		
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
				
				<!--  biz_2  (S) -->
				<table class="height_5">
					<tr><td>
					</td></tr>
				</table>
				<table class="search" border="0" style="width:684;"> 
				<tr class="h23">
					<td width="50">S/C No.</td>
					<td width="150"><input type="text" style="width:100;" class="input" name="sc_no" value=""  maxlength="9"  style="ime-mode:disabled" dataformat="engup" tabindex="7">&nbsp;<img src="img/btns_search.gif" name="btn_ScNo" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td> 
					<td width="50">RFA No.</td>
					<td width="150"><input type="text" style="width:100;" class="input" name="rfa_no" value="" maxlength="11" style="ime-mode:disabled" dataformat="engup" tabindex="8">&nbsp;<img src="img/btns_search.gif" name="btn_RfaNo" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="50">TAA No.</td>
					<td width="150"><input type="text" style="width:100;" class="input" name="taa_no" value="" maxlength="10" style="ime-mode:disabled" dataformat="engup" tabindex="9">&nbsp;<img src="img/btns_search.gif" name="btn_TtaNo" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>					 
				</tr>
				</table>
				<!--  biz_2   (E) -->
				
			</td></tr>
		</table>
		<!-- 1 (E) -->
		
		<!-- 2 (S) -->		
		<table class="height_5">
			<tr><td>
			</td></tr>
		</table>
		<table class="search"> 
       		<tr><td class="bg">
		
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Includes</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				
				<table border="0" style="width:687; background-color:white;" class="grid2"> 
				<tr class="h23">
					<td id="dcgoFlg"><input type="checkbox" class="trans" name="dcgo_flg" value="Y">&nbsp;Danger</td>
					<td id="stowageFlg"><input type="checkbox" class="trans" name="stowage_flg" value="Y">&nbsp;Stowage</td>
					<td id="rcFlg"><input type="checkbox" class="trans" name="rc_flg" value="Y">&nbsp;Reefer</td>
				</tr>
				<tr class="h23">
					<td id="hngrFlg"><input type="checkbox" class="trans" name="hngr_flg" value="Y">&nbsp;Hanger</td>
					<td id="spclHideFlg"><input type="checkbox" class="trans" name="spcl_hide_flg" value="Y">&nbsp;Hide</td>
					<td id="spclHideLnrFlg"><input type="checkbox" class="trans" name="spcl_hide_lnr_flg" value="Y">&nbsp;Hide Liner</td>
				</tr>
				<tr class="h23">
					<td id="awkCgoFlg"><input type="checkbox" class="trans" name="awk_cgo_flg" value="Y">&nbsp;Awkward</td>
					<td id="stopOffFlg"><input type="checkbox" class="trans" name="stop_off_flg" value="Y">&nbsp;Stop Off Cargo</td>
					<td id="fumgFlg"><input type="checkbox" class="trans" name="fumg_flg" value="Y">&nbsp;Fumigation</td>
				</tr>
				<tr class="h23">
					<td id="fdGrdFlg"><input type="checkbox" class="trans" name="fd_grd_flg" value="Y">&nbsp;Food Grade</td>
					<td id="bbCgoFlg"><input type="checkbox" class="trans" name="bb_cgo_flg" value="Y">&nbsp;Break Bulk</td>
					<td id="bulkRailFlg"><input type="checkbox" class="trans" name="bulk_rail_flg" value="Y">&nbsp;Bulk Rail</td>
				</tr>	
				<tr class="h23">
					<td id="prctFlg"><input type="checkbox" class="trans" name="prct_flg" value="Y">&nbsp;Precaution</td>
					<td id="vehCmdtFlg"><input type="checkbox" class="trans" name="veh_cmdt_flg" value="Y" >&nbsp;Vehicle</td>
					<td id="tmp"></td>
				</tr>
				</table>
			
				
			</td></tr>
		</table> 
		<!-- 2 (E) -->
		<table class="height_5">
			<tr><td>
			</td></tr>
		</table>
		<!-- 3 (S) -->		
		<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0">
					<tr><td class="title_h"></td><td class="title_s">Ext Remark</td></tr>
					<tr><td class="height_5"></td></tr>
				</table>
				<table width="100%"  id=""> 
					<tr><td><textarea  name="xter_rmk" style="width:100%;height:60;" tabindex=91></textarea></td></tr>
				</table>				
			
			</td></tr>
		</table> 
		<table class="height_5">
			<tr><td>
			</td></tr>
		</table>
		<table class="search"> 
       		<tr><td class="bg">
		
				<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">New booking numbers</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>				
			
			</td></tr>
		</table> 
		<!-- 3 (E) -->
		<!-- : ( Search Options ) (E) -->


	</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->

<table class="height_5">
	<tr><td>
	</td></tr>
</table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    	<table border="0" cellpadding="0" cellspacing="0">
		    		<tr><td>
		    			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Copy"  id="btn_copy" >Copy</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Print">Print</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td></tr>
				</table>
    <!--Button (E) -->
	
			</td></tr>
		</table>
		<table id="mainTable"> 
			<tr>
				<td>
					<script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			</tr>
		</table>		
<!-- : ( Button : pop ) (E) -->
	</td></tr>
</table>		
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>