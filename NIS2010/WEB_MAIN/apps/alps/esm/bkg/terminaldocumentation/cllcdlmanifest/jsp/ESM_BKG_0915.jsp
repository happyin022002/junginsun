<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0915.jsp
*@FileTitle : ESM_BKG_0915
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0915Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0915Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vvdCd		= "";
	String portCd			= "";
	String bkgNo			= "";
	String cntrNo			= "";
	String cntrLodgNo			= "";
	String rowNum ="";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		vvdCd = request.getParameter("vvdCd")==null?"":request.getParameter("vvdCd");
		portCd = request.getParameter("portCd")==null?"":request.getParameter("portCd");
		bkgNo = request.getParameter("bkgNo")==null?"":request.getParameter("bkgNo");
		cntrNo = request.getParameter("cntrNo")==null?"":request.getParameter("cntrNo");
		cntrLodgNo = request.getParameter("cntrLodgNo")==null?"":request.getParameter("cntrLodgNo");
		rowNum = request.getParameter("rowNum")==null?"":request.getParameter("rowNum");

		event = (EsmBkg0915Event)request.getAttribute("Event");
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
<title>ESM_BKG_0915</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="in_vsl_cd" value="<%= vvdCd.substring(0,4)%>">
<input type="hidden" name="in_skd_voy_no" value="<%= vvdCd.substring(4,8)%>">
<input type="hidden" name="in_skd_dir_cd" value="<%= vvdCd.substring(8)%>">
<input type="hidden" name="in_port_cd" value="<%= portCd%>">
<input type="hidden" name="in_bkg_no" value="<%= bkgNo%>">
<input type="hidden" name="in_cntr_no" value="<%= cntrNo%>">
<input type="hidden" name="in_cntr_lodg_no" value="<%= cntrLodgNo%>">
<input type="hidden" name="rowNum" value="<%= rowNum%>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> CLL for EDI - DG Info</span></td></tr>
		</table>	
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="80">Booking No.</td> 
					<td width="120"><input type="text" style="width:100;text-align:center;" class="input2" name="form1_bkg_no" value="<%=bkgNo %>" readonly></td>
					<td width="90">Container No.</td>
					<td width=""><input type="text" style="width:100;text-align:center;" class="input2" name="form1_cntr_no" value="<%=cntrNo %>" readonly></td>
				</tr>
				</table>
			
				<table class="height_5"><tr><td></td></tr></table>
				
				<table class="grid2" border="0" style="width:100%;"> 
				<tr class="tr2_head">
					<td width="15%" >UN	</td> 
					<td width="10%">Class	</td>
					<td width="34%">Tel	</td>
					<td width="10%">	Page</td>
					<td width="10%">Flash	</td>
					<td width="">EMS</td>
				</tr>
				<tr class="h23">
					<td class="noinput"><input type="text" style="width:100%;text-align:center;" class="noinput" name="form1_imdg_un_no" value="" maxlength="4" dataformat="num3" style="ime-mode:disabled"></td>
					<td class="noinput"><input type="text" style="width:100%;text-align:center;" class="noinput" name="form1_imdg_clss_cd" value="" maxlength="3" dataformat="num2" style="ime-mode:disabled"></td>
					<td class="noinput"><input type="text" style="width:100%;text-align:center;" class="noinput" name="form1_emer_cntc_phn_no" value="" dataformat="num" style="ime-mode:disabled"></td>
					<td class="noinput"><input type="text" style="width:100%;text-align:center;" class="noinput" name="form1_imdg_pg_no" value="" maxlength="10" dataformat="num3" style="ime-mode:disabled"></td>
					<td class="noinput"><input type="text" style="width:100%;text-align:center;" class="noinput" name="form1_flsh_pnt_cdo_temp" value="" dataformat="num2" style="ime-mode:disabled"></td>
					<td class="noinput"><input type="text" style="width:100%;text-align:center;" class="noinput" name="form1_emer_prc_no" value="" maxlength="10" dataformat="uppernum2" style="ime-mode:disabled"></td>
				</tr>
				</table>
			
				<table class="height_5"><tr><td></td></tr></table>
				
				<table class="grid2" border="0" style="width:60%;"> 
				<tr class="tr2_head">
					<td width="25%" >Group		</td> 
					<td width="25%">MPoll	</td>
					<td width="25%">Label		</td>
					<td width="">PSA</td>
				</tr>
				<tr class="h23">
					<td class="noinput"><input type="text" style="width:100%;text-align:center;" class="noinput" name="form1_dg_pck_grp_cd" value="" dataformat="uppernum" style="ime-mode:disabled"></td>
					<td class="noinput">
					<select name="form1_polut_flg" style="width:74">
					<option value="Y">Y</option>
					<option value="N">N</option>
					</select>
					<!-- input type="text" style="width:100%;text-align:center;" class="noinput" name="form1_polut_flg" value=""--></td>
					<td class="noinput"><input type="text" style="width:100%;text-align:center;" class="noinput" name="form1_dg_lbl_cd" value="" maxlength="10" dataformat="uppernum" style="ime-mode:disabled"></td>
					<td class="noinput"><input type="text" style="width:100%;text-align:center;" class="noinput" name="form1_dg_clss_cd" value="" maxlength="1" dataformat="uppernum" style="ime-mode:disabled"></td>
				</tr>
				</table>
			
				<table class="height_5"><tr><td></td></tr></table>
				
				<table class="grid2" border="0" style="width:100%;"> 
				<tr class="tr2_head">
					<td width="25%"  colspan="2">Package		</td> 
					<td width="25%"  colspan="2">Net Weight				</td>
					<td width="25%"  colspan="2">Gross Weight				</td>
					<td width="25%"  colspan="2">Measure				</td>
				</tr>
				<tr class="h23">
					<td width="15%"><input type="text" style="width:70;text-align:right;" class="noinput" name="form1_pck_qty" value="" dataformat="num2" style="ime-mode:disabled"></td>
					<td width="10%"><input type="text" style="width:40;text-align:center;" class="noinput" name="form1_tml_pck_ut_id" value="" style="ime-mode:disabled"></td>
					<td width="15%"><input type="text" style="width:70;text-align:right;" class="noinput" name="form1_net_wgt" value="" dataformat="num2" style="ime-mode:disabled"></td>
					<td width="10%">
					<select name="form1_net_wgt_ut_cd">
					<!-- option value=""></option-->
					<option value="KGS">KGS</option>
					<option value="LBS">LBS</option>
					</select>
					<!-- input type="text" style="width:40;text-align:center;" class="noinput" name="form1_net_wgt_ut_cd" value="" style="ime-mode:disabled"--></td>
					<td width="15%"><input type="text" style="width:70;text-align:right;" class="noinput" name="form1_grs_cntr_wgt" value="" dataformat="num2" style="ime-mode:disabled"></td>
					<td width="10%">
					<select name="form1_grs_wgt_ut_cd">
					<!-- option value=""></option-->
					<option value="KGS">KGS</option>
					<option value="LBS">LBS</option>
					</select>					
					<!-- input type="text" style="width:40;text-align:center;" class="noinput" name="form1_grs_wgt_ut_cd" value="" style="ime-mode:disabled"--></td>
					<td width="15%"><input type="text" style="width:70;text-align:right;" class="noinput" name="form1_meas_qty" value="" dataformat="num2" style="ime-mode:disabled"></td>
					<td width="10%">
					<select name="form1_meas_ut_cd">
					<!-- option value=""></option-->
					<option value="CBM">CBM</option>
					<option value="CBF">CBF</option>
					</select>					
					<!-- input type="text" style="width:40;text-align:center;" class="noinput" name="form1_meas_ut_cd" value="" style="ime-mode:disabled"--></td>
				</tr>
				</table>
			
				<table class="height_5"><tr><td></td></tr></table>
				


	
			
				<table class="grid2" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100" class="tr2_head">DG Description	</td> 
					<td><input type="text" style="width:100%" class="noinput" name="form1_dg_desc" value="" dataformat="uppernum2" style="ime-mode:disabled"></td>
				</tr>
				<tr class="h23">
					<td width="100" class="tr2_head">Remark</td> 
					<td><input type="text" style="width:100%" class="noinput" name="form1_dg_rmk" value="" dataformat="uppernum2" style="ime-mode:disabled"></td>
				</tr>
				<tr class="h23">
					<td width="100" class="tr2_head">HAZ Contents		</td> 
					<td><input type="text" style="width:100%" class="noinput" name="form1_hzd_ctnt" value="" dataformat="uppernum2" style="ime-mode:disabled"></td>
				</tr>
				<tr class="h23">
					<td width="100" class="tr2_head">Stowage	</td> 
					<td><input type="text" style="width:100%" class="noinput" name="form1_stwg_desc" value="" dataformat="uppernum2" style="ime-mode:disabled"></td>
				</tr>
				<tr class="h23">
					<td width="100" class="tr2_head">Label Description	</td> 
					<td><input type="text" style="width:100%" class="noinput" name="form1_dg_lbl_desc" value="" dataformat="uppernum2" style="ime-mode:disabled"></td>
				</tr>
				
				</table>
				
			<table class="height_5"><tr><td></td></tr></table>
			
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="60">DG SEQ</td> 
					<td width=""><input type="text" style="width:20;text-align:center;" class="input2" name="currentSeq" value="" readonly>/<input type="text" style="width:20;text-align:center;" class="input2" name="totalSeq" value="" readonly>&nbsp;<img src="img/btns_back.gif" width="18" height="19" alt="" border="0" align="absmiddle" class="cursor" onClick="goPrev();">&nbsp;<img src="img/btns_next.gif" width="18" height="19" alt="" border="0" align="absmiddle" class="cursor" onClick="goNext();"></td>
				</tr>
				</table>
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_rowadd">Add SEQ</td>
					<td class="btn1_right">
				</tr></table></td><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete SEQ</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line">
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
		</td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<table width="100%"  id="mainTable" style="display:none"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>  			
</form>			
</body>
</html>