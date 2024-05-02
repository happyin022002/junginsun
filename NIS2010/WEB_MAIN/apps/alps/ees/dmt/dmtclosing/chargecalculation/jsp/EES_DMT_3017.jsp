<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3017.jsp
*@FileTitle : DEM/DET Adjustment Request & Approval Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.08.03 이성훈
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
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3017Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	 = "";
	String strUsr_nm	 = "";
	String strOfc_cd	 = "";
	String strRhq_ofc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	  = account.getUsr_id();
		strUsr_nm 	  = account.getUsr_nm();
		strOfc_cd 	  = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
	   
		event = (EesDmt3017Event)request.getAttribute("Event");
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
<title>DEM/DET Adjustment Request & Approval Status</title>
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

<!-- Type 설정을 위해서 사용되는 매개변수 -->
<input type="hidden" name="login_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="login_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="login_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="login_rhqofc_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="ofc_cd_old">

<input type="hidden" name="mn_rsn_cd">

<input type="hidden" name="tab_cd" >
<input type="hidden" name="inact_sts_cd" >
<input type="hidden" name="ofc_cd" >
<input type="hidden" name="trf_cd" >
<input type="hidden" name="inact_rsn_cd" >
<input type="hidden" name="spec_rsn_cd" >
<input type="hidden" name="chg_delt_path_cd" >


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
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
							<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
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
							<td class="btn1" name="btn_Detail">Detail</td>
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
    	
	<div id="conditionLayer" style="display:block">	
		<table class="search"> 
       	<tr>
       		<td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td>
						<table class="search" border="0"> 
						<tr class="h23">
							<td width="80" class="stm">Date</td>
							<td width="74" class="stm"><select name="dt_tp" style="width:70;" class="input">
															<option value="R" selected>Request</option>
															<option value="U">Update</option>
														</select>
							</td>
							<td width="220">
								<input type="text" name="fm_dt" style="width:70;" class="input1" dataformat="ymd" maxlength="8" >&nbsp;~&nbsp;
								<input type="text" name="to_dt" style="width:70;" class="input1" dataformat="ymd" maxlength="8" >&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">
							</td>
							<td width="52" class="stm">Status</td>
							<td width="110"><script language="javascript">ComComboObject('inact_sts',2,90,0,0,0,true);</script></td>
							<td width="40" class="stm" >Office</td>
							<td width="270" class="stm">
								<script language="javascript">ComComboObject('office',2,90,0,0,0,true);</script>
							    <img src="img/btns_multisearch.gif" width="17" height="20" alt="" border="0" align="absmiddle" class="cursor">
								<input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans">Incl. Sub Office</td>

							<td width="70" class="stm">Tariff Type</td>
							<td width=""><script language="javascript">ComComboObject('tariff_type',2,120,1,0);</script>
							</td>					
						</tr>
						</table>
				
						<table class="search" border="0"> 
						<tr class="h23">
							<td width="95" class="stm">Inactive No.</td>
							<td width="135"><input type="text" name="inact_no" style="width:100;ime-mode:disabled" class="input" dataformat="engup">
							<img src="img/btns_multisearch.gif"	name="btns_multisearch1" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('inact_no')"></td>
							<td width="85" class="stm">APVL No.</td>
							<td width="130" class="stm"><input name="apvl_no" type="text" style="width:100;ime-mode:disabled" class="input" dataformat="engup">
							<img src="img/btns_multisearch.gif"	name="btns_multisearch2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('apvl_no')"></td>
							<td width="50" class="stm">BKG No.</td>
							<td width="130" class="stm"><input name="bkg_no" type="text" style="width:100;ime-mode:disabled" class="input" dataformat="engup">
							<img src="img/btns_multisearch.gif"	name="btns_multisearch3" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bkg_no')"></td>
							<td width="50" class="stm">BL No.</td>
							<td width="130" class="stm"><input name="bl_no" type="text" style="width:100;ime-mode:disabled" class="input" dataformat="engup">
							<img src="img/btns_multisearch.gif"	name="btns_multisearch4" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bl_no')"></td>
							<td width="60" class="stm">Group by</td>
							<td width=""><select name="group_by" style="width:120;" class="input">
							
								<option value="INACT" selected>Inactivation nbr</option>
								<option value="BKG">B/L No.(BKG No.)</option>
								<option value="CNTR">CNTR No.</option>
							</select></td>
						</tr>
						</table>
						<table class="search" border="0"> 
						<tr class="h23">
							<td width="97" class="stm">Inactive Reason</td>
							<td width="130"><script language="javascript">ComComboObject('inact_reason',2,123,1,0);</script>
							<td width="88" class="stm">Specific Reason</td>
							<td width=""><script language="javascript">ComComboObject('spec_reason',2,123,1,0);</script>
						</tr>
						</table>
					</td>
					</tr>
				</table>
			</td></tr>
		</table>
	</div>
			
		<!-- earch Options_Speed (E) --> 	
		<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Tab ) (S) -->
     	
     	 <table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
			<tr>
				<td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
		<!-- Tab ) (E) --> 
		
	<!--TAB Received (S) -->
	<div id="tabLayer" style="display:inline">		
		
		<!-- Tab BG Box ) (S) -->
		<!-- Grid  (S) -->
		<table class="search"> 
      	<tr><td  class="bg" >				
			<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('t1sheet1');</script>
				</td>
			</tr>
			</table> 	
				<table class="search" border="0">
				<tr class="h23">
					<td align="right">
						<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="t1btn_Alldownexcel">Down Excel</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
		</td></tr>
		</table>
			
		<!-- Grid  (e) -->
 
	</div>
	<!--TAB Received (E) --> 				
			
					

<!--TAB Sent (S) -->
<div id="tabLayer" style="display:none">
		<!-- Tab BG Box ) (S) -->
   		<table class="search"> 
      	<tr><td  class="bg" >				
			<table width="100%" > 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('t2sheet1');</script>
				</td>
			</tr>
			</table> 	
			<table class="search" border="0">
			<tr class="h23">
				<td align="right">
					<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn2_left"></td>
						<td class="btn2" name="t2btn_Processingdownexcel">Down Excel</td>
						<td class="btn2_right"></td>
					</tr>
					</table>
				</td>
			</tr>
			</table>
		</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
</div>
<!--TAB Sent (E) --> 		

<!--TAB Sent (S) -->
<div id="tabLayer" style="display:none">
		<!-- Tab BG Box ) (S) -->
   		<table class="search"> 
      	<tr><td  class="bg" >				
			<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('t3sheet1');</script>
				</td>
			</tr>
			</table> 		
			<table class="search" border="0">
			<tr class="h23">
				<td align="right">
					<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn2_left"></td>
						<td class="btn2" name="t3btn_Enddownexcel">Down Excel</td>
						<td class="btn2_right"></td>
					</tr>
					</table>
				</td>
			</tr>
			</table>
		</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
</div>
<!--TAB Sent (E) -->

			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

	</td></tr>
</table>
	</td></tr>
</table>
</form>
</body>
</html>
