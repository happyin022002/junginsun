<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0588.jsp
*@FileTitle : Special cargo summary information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.05 김기종
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.event.EsmBkg0588Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0588Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.SpecialReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0588Event)request.getAttribute("Event");
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
<title>Special cargo summary information</title>
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
<div id='debug'></div>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="ch_usr_id">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_mrdDisableToolbar">

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
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="35">VVD</td>
						<td width="122">
							<input type="text" name="vvd_cd" style="width:90;" class="input1" value="" style="ime-mode:disabled" dataformat="engupnum"  caption="T/VVD" maxlength="9" required>
						</td>
						<td width="310">
							<table border="0" style="width:280;" class="search_sm2"> 
								<tr class="h23">
									<td width="30">POL</td>
									<td width="122">
										<input type="text" name="pol_cd" style="width:47;" class="input1" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engup" required>
										<input type="text" name="pol_nod_cd" style="width:21;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum">
										<img src="img/btns_search.gif" name="btn_0083PolPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
									</td>
									
									<td class="sm">
										Local&nbsp;<input type="checkbox" name="chk_l_type"  value="Y" class="trans">&nbsp;&nbsp;&nbsp;&nbsp;
										T/S&nbsp;<input type="checkbox" name="chk_t_type" value="Y" class="trans"></td>
								</tr>
							</table>
						</td>	
						<td width="60">Zone</td>
						<td width="130">
							<script language="javascript">ComComboObject('zone_code',1, 80, 0,0,1,true);</script>
						</td>	
						<td width="58">Option</td>
						<td width="">
							<table border="0" style="width:190;" class="search_sm2"> 
								<tr class="h23">
									<td class="sm">
										<input type="radio" name="spcl_cgo_type"  value="" class="trans" checked>ALL&nbsp;&nbsp;
										<input type="radio" name="spcl_cgo_type"  value="DG" class="trans">DG&nbsp;&nbsp;
										<input type="radio" name="spcl_cgo_type"  value="RF" class="trans" >RF&nbsp;&nbsp;
										<input type="radio" name="spcl_cgo_type"  value="AK" class="trans">AK&nbsp;&nbsp;
										<input type="radio" name="spcl_cgo_type"  value="BB" class="trans">BB&nbsp;&nbsp;
									</td>
								</tr>
							</table>
						</td>
						
						<td align="right">
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">POD</td>
					<td width="122">
						<input type="text" name="pod_cd" style="width:47;" class="input" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engup">
						<input type="text" name="pod_nod_cd" style="width:21;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum">
						<img src="img/btns_search.gif" name="btn_0083PodPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="35">POR</td>
					<td width="122">
						<input type="text" name="por_cd" style="width:47;" class="input" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engup">
						<input type="text" name="por_nod_cd" style="width:21;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum">
						<img src="img/btns_search.gif" name="btn_0083PorPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="30">DEL</td>
						<td width="122">
							<input type="text" name="del_cd" style="width:47;" class="input" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engup">
						  	<input type="text" name="del_nod_cd" style="width:21;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum">
						  	<img src="img/btns_search.gif" name="btn_0083DelPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
					
					
					<td width="60">BKG OFC</td>
					<td width="70">
						<input type="text" name="bkg_ofc_cd"  style="width:60;" value="" style="ime-mode:disabled" dataformat="engup"  caption="BKG Office" maxlength="6" >
					</td>
					<td width="46">S.Rep</td>
					<td width="70"><input type="text" name="ob_srep_cd" style="width:55;" value="" style="ime-mode:disabled" dataformat="engup"  caption="S.Rep" maxlength="4"></td>
					<td width="65">BKG Staff</td>
					<td width="">
						<table border="0" style="width:190;" class="search_sm2"> 
							<tr class="h23">
								<td class="sm">
									<input type="radio" name="bkg_staff_type"  value="ID" class="trans" checked>ID&nbsp;&nbsp;
									<input type="radio" name="bkg_staff_type" value="NAME" class="trans">Name&nbsp;&nbsp;<input type="text" name="bkg_staff" style="width:80;" value="" maxlength="20" dataformat="engupnum"></td>
							</tr>
						</table>
					</td>
				</tr>
				</table><!--
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">POR</td>
					<td width="122">
						<input type="text" name="por_cd" style="width:47;" class="input" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engupnum">
						<input type="text" name="por_yd_cd" style="width:21;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum">
						<img src="img/btns_search.gif" name="btn_0083PorPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					
					<td width="30">POL</td>
					<td width="122">
						<input type="text" name="pol_cd" style="width:47;" class="input" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engupnum">
						<input type="text" name="pol_yd_cd" style="width:21;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum">
						<img src="img/btns_search.gif" name="btn_0083PolPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="60">BKG OFC</td>
					<td width="70">
						<input type="text" name="bkg_ofc_cd"  style="width:60;" value="" style="ime-mode:disabled" dataformat="engup"  caption="BKG Office" maxlength="6" >
					</td>
					<td width="46">S.Rep</td>
					<td width="70"><input type="text" name="ob_srep_cd" style="width:55;" value="" style="ime-mode:disabled" dataformat="engup"  caption="S.Rep" maxlength="4"></td>
					<td width="65">BKG Staff</td>
					<td width="208">
						<table border="0" style="width:190;" class="search_sm2"> 
							<tr class="h23">
								<td class="sm">
									<input type="radio" name="rdo_id"  value="ID" class="trans" checked>ID&nbsp;&nbsp;
									<input type="radio" name="rdo_name" value="NAME" class="trans">Name&nbsp;&nbsp;<input type="text" style="width:80;" value=" "></td>
							</tr>
						</table>
					</td>
					<td align="right">
					</td>
				</tr>
				</table>
				
				--><table class="search" border="0" style="width:979;"> 
				<tr class="h23">
						
						
						<td width="50">Status</td>
						<td width="110">
							<script language="javascript">ComComboObject('bkg_sts_cd',1, 90, 0,0,1,true);</script>
						</td>
						
						<td class="stm">Non Approval & container match&nbsp;
							<input type="checkbox" name="spcl_cgo_apro_cd" class="trans" value="Y">
						</td>
				</tr>
				</table>
				
				
				<!--<table class="search" border="0" style="width:100%;"> 
					<tr><td height="3"></td></tr>
					<tr class="h23">
							
						<td width="35">POR</td>
						<td width="122">
							<input type="text" name="por_cd" style="width:47;" class="input" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engupnum">
							<input type="text" name="por_yd_cd" style="width:21;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum">
							<img src="img/btns_search.gif" name="btn_0083PorPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						
						<td width="30">POL</td>
						<td width="122">
							<input type="text" name="pol_cd" style="width:47;" class="input" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engupnum">
							<input type="text" name="pol_yd_cd" style="width:21;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum">
							<img src="img/btns_search.gif" name="btn_0083PolPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						<td width="60">BKG OFC</td>
						<td width="90"><input type="text" name="bkg_ofc_cd"  style="width:60;" value="" style="ime-mode:disabled" dataformat="engup"  caption="BKG Office" maxlength="6" ></td>
						<td width="46">S.Rep</td>
						<td width="92"><input type="text" name="ob_srep_cd" style="width:55;" value="" style="ime-mode:disabled" dataformat="engup"  caption="S.Rep" maxlength="4"></td>
						<td width="65">BKG Staff</td>
						<td width="208">
							<table border="0" style="width:190;" class="search_sm2"> 
								<tr class="h23">
									<td class="sm">
										<input type="radio" name="rdo_id"  value="ID" class="trans" checked>ID&nbsp;&nbsp;
										<input type="radio" name="rdo_name" value="NAME" class="trans">Name&nbsp;&nbsp;<input type="text" style="width:80;" value=" "></td>
								</tr>
							</table>
						</td>
						<td align="right">
						</td>
						
					</tr>
				</table>
				--><!--<table class="search" border="0" style="width:100%;"> 
					<tr><td height="3"></td></tr>
					<tr class="h23">
						<td width="35">POD</td>
						<td width="122">
							<input type="text" name="pod_cd" style="width:47;" class="input" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engupnum">
							<input type="text" name="pod_yd_cd" style="width:21;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum">
							<img src="img/btns_search.gif" name="btn_0083PodPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						<td width="30">DEL</td>
						<td width="122">
							<input type="text" name="del_cd" style="width:47;" class="input" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engupnum">
						  	<input type="text" name="del_yd_cd" style="width:21;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engupnum">
						  	<img src="img/btns_search.gif" name="btn_0083DelPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						<td width="60">Status</td>
						<td width="90">
							<script language="javascript">ComComboObject('bkg_sts_cd',2, 60, 0,0,0,true);</script>
						</td>
						<td class="stm">Non Approval & container match&nbsp;
							<input type="checkbox" name="spcl_cgo_apro_cd" class="trans">
						</td>
						<td align="right">
						</td>
					</tr>
				</table>
				--><!--  biz_1   (E) -->		
				

		</td></tr>
		</table>	
		<!-- 1 (E) -->
		
		<!-- 2 (S) -->		
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
				<!-- Grid (E) -->		
	
			
		</td></tr>
		</table>
		<!-- 2 (E) -->		
		<!--biz page (E)--> 

</td></tr></table>

	

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr></table></td>					
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
					</tr></table></td>		
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_DownExcel">Down Excel</td>
						<td class="btn1_right"></td>
					</tr></table></td>					
				<!--<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_certiDown">Certi Down</td>
						<td class="btn1_right"></td>
					</tr></table></td>					
				--><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_printfor">Print for CBF</td>
						<td class="btn1_right"></td>
					</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_application">Application</td>
						<td class="btn1_right"></td>
					</tr></table></td>					
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_approval">Approval Result Detail</td>
						<td class="btn1_right"></td>
					</tr></table></td>					
				<!--<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_request">Request</td>
						<td class="btn1_right"></td>
					</tr></table></td>		
				
			--></tr>
			</table>
			
			</td></tr>
		</table>
    	<!--Button (E) -->
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>