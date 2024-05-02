<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0304.jsp
*@FileTitle : ESM_BKG_0304
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.06 경종윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0304Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0304Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	String s_pod_cd   = (request.getParameter("pod_cd")== null)?"":request.getParameter("pod_cd");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0304Event)request.getAttribute("Event");
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
<title>esm_bkg_0304</title>
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cmd_detail">
<input type="hidden" name="form1_crr_agn_cd">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)-->	
	
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">


				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="130">VVD CODE</td>
					<td width="200">
						<input type="text" style="width:90;ime-mode: disabled" class="input1" name="form1_vvd_cd" 
							required dataformat="eng" maxlength="9" fullfill caption="VVD CODE" >
						<input type="hidden" style="width:80;ime-mode: disabled" class="input1" name="vvd_cd">
					</td>
					<td width="150">POD</td>
					<td>
						<input type="text" style="width:90;ime-mode: disabled" class="input1" name="form1_pod_cd" 
							required dataformat="eng" maxlength="5" fullfill caption="POD" >
						<input type="hidden" style="width:60;ime-mode: disabled" class="input1" name="pod_cd">
							
					</td>
				</tr> 
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="130">IGM No.</td>
					<td width="200">
						<input type="text" style="width:90;ime-mode: disabled" class="input" name="form1_ida_decl_vsl_no" dataformat="eng" maxlength="7">&nbsp;<input type="text" style="width:25;ime-mode:disabled;" class="input" name="form1_ida_yr_no" dataformat="yy" maxlength="2" caption="IGM YEAR">
					</td>
					<td width="150">IGM Date</td>
					<td width="">
						<input type="text" style="width:90; ime-mode: disabled" class="input" name="form1_vsl_decl_dt" 
						dataformat="ymd" caption="IGM Date" maxlength="10">
					</td>
				</tr> 
				<tr class="h23">	
					<td width="">Vessel Name</td>
					<td width="" colspan="3">
						<input type="text" style="width:440;" class="input2" readOnly="true" name="form1_vsl_nm" maxlength="50">
					</td>
				</tr> 	
				<tr class="h23">	
					<td width="">VSL Code(Call Sign)</td>
					<td colspan="3">
						<input type="text" style="width:440;ime-mode: disabled" class="input1" name="form1_call_sgn_no" 
						dataformat="eng" maxlength="15" caption="VSL Code(Call Sign)">
					</td>
				</tr> 
				<tr class="h23">
					<td width="">Voyage</td>
					<td width="">
						<input type="text" style="width:90;ime-mode: disabled" class="input1" name="form1_ida_voy_no" 
						dataformat="eng" maxlength="5" caption="Voyage">
					</td>
					<td width="">Line Code</td>
					<td width="">
						<input type="text" style="width:90;ime-mode: disabled" class="input" name="form1_ida_line_no" 
						dataformat="eng" maxlength="5" caption="Line Code">
					</td>
				</tr> 
				<tr class="h23">	
					<td width="">Agent Code</td>
					<td width="">
			        	
						<input type="text" style="width:180;ime-mode: disabled" class="input1" name="form1_ida_mrn_line_opr_cd"  id="form1_ida_mrn_line_opr_cd"
						dataformat="eng" maxlength="20" caption="Agent Code">
			
					</td>
					<td width="">Nationality</td>
					<td>
						<input type="text" style="width:90;ime-mode: disabled" class="input2" readOnly="true" name="form1_cnt_cd" maxlength="2">
					</td>
				</tr> 
				<tr class="h23">
					<td>Port of Arrival</td>
					<td>
						<input type="text" style="width:90;ime-mode: disabled" class="input1" name="form1_port_cd" 
						dataformat="eng" maxlength="10" caption="Port of Arrival">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_popup1">
					</td>
					<td>Arrival Date</td>
					<td>
						<input type="text" style="width:90;ime-mode: disabled" class="input" name="form1_arr_dt" 
						dataformat="ymd" caption="Arrival Date" maxlength="10">
					</td>
				</tr> 
				<tr class="h23">	
					<td>GLD</td>
					<td>
						<input type="text" style="width:90;ime-mode: disabled" class="input" name="form1_arr_dt2" 
						dataformat="ymd" caption="GLD" maxlength="10">
					</td>
					<td>CFS Code</td>
					<td>
						<input type="text" style="width:90;ime-mode: disabled" class="input1" name="form1_ida_cfs_id" 
						dataformat="eng" maxlength="10" caption="CFS Code">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_popup2">
					</td>
				</tr> 
				<tr class="h23">
					<td>IMO Code of VSL</td>
					<td>
						<input type="text" style="width:90;ime-mode: disabled" class="input" name="form1_ida_vsl_imo_no" 
						dataformat="eng" caption="IMO Code of VSL" maxlength="10">
					</td>
					<td>Bond Code</td>
					<td>
						<input type="text" style="width:90;ime-mode: disabled" class="input" name="form1_bd_area_cd"
						dataformat="eng" caption="Bond Code">
					</td>
					</tr> 
				<tr class="h23">
					<td>Custom House Code</td>
					<td>
						<input type="text" style="width:90;ime-mode: disabled" class="input" name="form1_ida_cstms_hus_no" 
						dataformat="eng" caption="Custom House Code" maxlength="6">
					</td>
					<td>Terminal Operator Code</td>
					<td>
						<input type="text" style="width:90;ime-mode: disabled" class="input" name="form1_ida_tml_opr_no"
						dataformat="eng" caption="Terminal Operator Code" maxlength="10">
					</td>
					</tr>
				<tr class="h23">
					<td>PCont. No.</td>
					<td>
						<input type="text" style="width:150;ime-mode: disabled" class="input" name="form1_ida_port_gnte_no" 
						dataformat="eng" caption="PCont. No." maxlength="20">
					</td>
					<td>PCont. Date</td>
					<td>
						<input type="text" style="width:90;ime-mode: disabled" class="input" name="form1_ida_port_gnte_dt"
						dataformat="ymd" caption="PCont. Date" maxlength="10">(YYYY-MM-DD)
					</td>
					
					</tr>
				</table>
				<!--  biz_1   (E) -->

		</td></tr>
		</table>	
		<!-- 1 (E) -->
		
		
		<!-- 2 (S) -->		
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">T/P Information</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
			
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="120">TP Bond No.</td>
					<td width="">
						<input type="text" style="width:160" class="input" name="form1_ibd_no" 
						dataformat="eng" caption="TP Bond No." maxlength="15">
					</td>
				</tr> 
				<tr class="h23">	
					<td width="">Trans Operator</td>
					<td width="">
						<input type="text" style="width:160" class="input" name="form1_trns_opr_id" 
						dataformat="eng" caption="Trans Operator"  maxlength="10">
					</td>
				</tr> 
				<tr class="h23">	
					<td width="">MLO Code</td>
					<td>
						<input type="text" style="width:180" class="input2"  readOnly="true" name="form1_ida_mrn_line_opr_cd2" 
						dataformat="eng" caption="MLO Code" maxlength="20">
					</td>
				</tr> 
				</table>
				<!--  biz_1   (E) -->
							
			</td></tr>
		</table>
		<!-- 2 (E) -->		
			
		<!--biz page (E)-->

	    <!--biz page 2 (S)-->
	    <table width="100%" id="mainTable" style="display:none">
	    <!-- <table width="100%" id="mainTable"> -->
	        <tr>
	            <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
	        </tr>
	    </table>
	    <!--biz page 2 (E)-->
	
	</td></tr>
		</table>
	
	
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
