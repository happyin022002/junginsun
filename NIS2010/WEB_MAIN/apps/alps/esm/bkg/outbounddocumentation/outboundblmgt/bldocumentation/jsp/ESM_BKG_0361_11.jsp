<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_0361_11.jsp
*@FileTitle : Export / Import Information (TURKEY)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 김용진
*@LastVersion : 1.0
* 2011.12.12 김용진
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2012.08.03 이재위 [CHM-201219301] Split 01-[M&D Export&Import Information] Israel VAT ID추가
* 2012.10.16 이재위 [CHM-201220434] [M&D Export/Import Information] Lebanon의 VAT ID추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg036101Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>

<%

	EsmBkg036101Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.outboundblmgt.bldocumentation");

	/*
	*/
	String bkg_no = "";
	String io_bnd_cd = "";
	String pol_cd = "";
	String pod_cd = "";
	String go_cnt_cd = "";
	String pkg_qty = "";
	String wgt_qty = "";
	String pkg_tp = "";
	String wgt_tp = "";

	String popUpTpCd   = "";
    String xter_sndr_id  = "";
    String xter_rqst_no  = "";
    String xter_rqst_seq = "";

	List<XptImpLicVO> xptImpLicVO = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg036101Event)request.getAttribute("Event");
		bkg_no       = event.getBkgNo();
		io_bnd_cd    = event.getIoBndCd();

		pol_cd		 = event.getPolCd();
		pod_cd       = event.getPodCd();
		go_cnt_cd    = (event.getGoCntCd()==null ||event.getGoCntCd().length()==0) ? "" : event.getGoCntCd();
		pkg_qty		 = (event.getPkgQty()==null ||event.getPkgQty().length()==0) ? "0" : event.getPkgQty();
		wgt_qty		 = (event.getWgtQty()==null ||event.getWgtQty().length()==0) ? "0" : event.getWgtQty();
		pkg_tp		 = event.getPkgTp();
		wgt_tp       = event.getWgtTp();

		popUpTpCd       = event.getPopUpTpCd();
		xter_sndr_id    = event.getXterSndrId();
		xter_rqst_no    = event.getXterRqstNo();
		xter_rqst_seq   = event.getXterRqstSeq();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		xptImpLicVO = (List<XptImpLicVO>) eventResponse.getCustomData("xptImpLicVO");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Export / Import Information (TURKEY)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base target="_self">

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

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Export / Import Information
</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0"> 
       	<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
		</table>
		<!-- Tab (E) -->
		<!-- : ( Search Options ) (S) -->
		<!--biz page (S)-->


<!--TAB Export (S) -->
<div id="tabLayer" style="display:inline">
<form name="form" style="margin:0px;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="io_bnd_cd" value="O">
<input type="hidden" name="exp_io_bnd_cd" value="O">
<input type="hidden" name="exp_xpt_imp_seq" value="1">
<input type="hidden" name="go_cnt_cd" value="<%=go_cnt_cd%>">
<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>">
<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>">

<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>">
<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>">
<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>">
<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>">

		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:484;"> 
				<tr class="h23">
					
								<td width="60">Country</td>
								<td width=""><select style="width:280;" name="exp_cnt_cd" onChange="javascript:goCtnCd(this);">
								<option value="BR" >BRAZIL</option>
								<option value="CA" >CANADA</option>
								<option value="CO" >COLOMBIA</option>
								<option value="EC" >ECUADOR</option>
								<option value="ID" >INDONESIA</option>
								<option value="IL" >ISRAEL</option>
								<option value="KR" >KOREA</option>
								<option value="LB" >LEBANON</option>
								<option value="MX" >MEXICO</option>
								<option value="PE" >PERU</option>
								<option value="TR" selected>TURKEY</option>
								<option value="US" >USA</option>		
								<option value="TG" >TOGO</option>
								<option value="NG" >NIGERIA</option>					
								</select>
								</td>
						
				</tr>
				</table>
				<!--  biz_1   (E) -->
		
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Manifest Data for Turkey Customs</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				<table class="search" border="0">
				<tr class="h23">
					<td width="120">Booking No.</td>
					<td width=""><input type="text" name="exp_bkg_no" style="width:110;" class="input2" value="<%=bkg_no%>" readonly></td>
					</tr>
				</table>

				<table class="search" border="0">
				<tr class="h23">
					<td width="120">Shipper Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="exp_tr_shpr_tax_id" dataformat="etc"  maxlength="20" value=""></td>
					</tr>
				<tr class="h23">
					<td width="">Consignee Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="exp_tr_cnee_tax_id" dataformat="etc"  maxlength="20" value=""></td>
					</tr>
				<tr class="h23">
					<td width="">Notify Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="exp_tr_ntfy_tax_id" dataformat="etc"  maxlength="20" value=""></td>
					</tr>
				
				</table>


			</td></tr>
		</table>


<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton" style="position:absolute;margin:10px 10px 10px -10px;width:600px">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0" align="center">
		    <tr>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
			</table></td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->			
</form>
</div>
<!--TAB Export (E) -->

<!--TAB Import (E) -->
<div id="tabLayer" style="display:none">
<form name="form2" style="margin:0px;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="io_bnd_cd" value="I">
<input type="hidden" name="imp_io_bnd_cd" value="I">
<input type="hidden" name="imp_xpt_imp_seq" value="1">
<input type="hidden" name="go_cnt_cd" value="<%=go_cnt_cd%>">
<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>">
<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>">

<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>">
<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>">
<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>">
<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>">

		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:484;"> 
				<tr class="h23">
					
								<td width="60">Country</td>
								<td width=""><select style="width:280;" name="imp_cnt_cd" onChange="javascript:goCtnCd(this);">
								<option value="BR" >BRAZIL</option>
								<option value="CO" >COLOMBIA</option>
								<option value="EC" >ECUADOR</option>
								<option value="IN" >INDIA</option>
								<option value="ID" >INDONESIA</option>
								<option value="IL" >ISRAEL</option>
								<option value="LB" >LEBANON</option>
								<option value="MX" >MEXICO</option>
								<option value="PE" >PERU</option>
								<option value="TR" selected>TURKEY</option>
								<option value="TG" >TOGO</option>
								<option value="NG" >NIGERIA</option>
								</select>
								</td>						
				</tr>
				</table>
				<!--  biz_1   (E) -->
		
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Manifest Data for Turkey Customs</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				<table class="search" border="0">
				<tr class="h23">
					<td width="120">Booking No.</td>
					<td width=""><input type="text" name="imp_bkg_no" style="width:110;" class="input2" value="<%=bkg_no%>" readonly></td>
					</tr>
				</table>

				<table class="search" border="0">
				<tr class="h23">
					<td width="120">Shipper Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="imp_tr_shpr_tax_id" dataformat="etc"  maxlength="20" value=""></td>
					</tr>
				<tr class="h23">
					<td width="">Consignee Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="imp_tr_cnee_tax_id" dataformat="etc"  maxlength="20" value=""></td>
					</tr>
				<tr class="h23">
					<td width="">Notify Tax ID</td>
					<td width=""><input type="text" style="width:200;" class="input" name="imp_tr_ntfy_tax_id" dataformat="etc"  maxlength="20" value=""></td>
					</tr>
				
				</table>
			

		
<!-- : ( Search Options ) (E) -->
			</td></tr>
		</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton" style="position:absolute;margin:10px 10px 10px -10px;width:600px">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0" align="center">
		    <tr>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save2">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close2">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
			</table></td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>
</div>		
<!--TAB Import (E) -->	
</td></tr>
</table>


				<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->


<form name="form3">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">
<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="get_io_bnd_cd" value="<%=io_bnd_cd%>">
<input type="hidden" name="pkg_qty" value="<%=pkg_qty%>">
<input type="hidden" name="wgt_qty" value="<%=wgt_qty%>">
<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>">
<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>">
<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>">
<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>">
<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>">
<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>">
</form>
<form name="form4">
<input type="hidden" name="tabclosechk">
<input type="hidden" name="savechk">
</form>
<form name="urlForm"></form>
</body>
</html>

