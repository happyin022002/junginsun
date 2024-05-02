<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0092.jsp
*@FileTitle : Route Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.28 김병규
* 1.0 Creation
===========================================================
* History
* 2012.01.05 금병주 [CHM-201115389-01] bkg 화면에 Port skip일 경우 표기 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0092Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0092Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";

	// Main에서 Parameter 받기
	String bkgNo = "";
	String calllFunc = "";
	String caFlg = "";
	String callSheetIdx = "";
	String bkgTrunkVvd = "";
	String displayOnly = "";
	String portSkpFlg = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0092Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		caFlg  = JSPUtil.getParameter(request, "ca_flg");
		calllFunc  = JSPUtil.getParameter(request, "func");
		callSheetIdx  = JSPUtil.getParameter(request, "callSheetIdx");
		bkgTrunkVvd  = JSPUtil.getParameter(request, "bkgTrunkVvd");
		displayOnly  = JSPUtil.getParameter(request, "displayOnly");
		portSkpFlg	= JSPUtil.getParameter(request, "portSkpFlg");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Route Detail</title>
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
<input type="hidden" name="bkg_no" value="<%= bkgNo%>">
<input type="hidden" name="ca_flg" value="<%= caFlg%>">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="callSheetIdx" value="<%=callSheetIdx%>">
<input type="hidden" name="bkgTrunkVvd" value="<%=bkgTrunkVvd%>">
<input type="hidden" name="trunkSeq" value="0">
<input type="hidden" name="displayOnly" value="<%=displayOnly%>">
<input type="hidden" name="portSkpFlg" value="<%=portSkpFlg%>">
<input type="hidden" name="vsl_cng_rsn">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top">
	</td></tr>
	<tr><td valign="top">		
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Route Detail</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) -->			
		<table class="search"> 
	       	<tr><td class="bg">
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">OCEAN ROUTE</td>
					</tr>
				</table>
				<table width="684" class="search"> 
					<tr class="h23">
						<td width="100">&nbsp;ETA of 1st VVD</td>
						<td width="" ><input type="text" name="n1st_eta_day" style="width:75;" class="input2" readonly>&nbsp;<input type="text" name="n1st_eta_time" style="width:45;" class="input2" readonly></td>
						<td width="100">&nbsp;ETA of DEL</td>
						<td width="" ><input type="text" name="del_eta_day" style="width:75;" class="input2" readonly>&nbsp;<input type="text" name="del_eta_time" style="width:45;" class="input2" readonly></td>
					</tr>
				</table> 							
				<!-- : ( Grid ) (S) -->				
				<table width="684" class="search"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>						
				<!-- : ( Grid ) (E) -->
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"><tr>
		       		<td class="btn2_bg">		       			
						<table border="0" cellpadding="0" cellspacing="0">
							<tr><td>
		       					<table>
			       					<tr>
				       					<td><input type="checkbox" name="mnl_tvvd_flg" value="N" class="trans"></td>
				       					<td colspan="4" class="title_s" width="300">T.VVD copy from BKG creation</td>
			       					</tr>
			       					<tr> 
				       					<td><input type="checkbox" name="port_skp_flg" value="Y" class="trans"></td>
				       					<td class="title_s">Port Skip</td>
				       					<td>&nbsp;&nbsp;&nbsp;</td>
				       					<td><input type="checkbox" name="cust_ntc_flg" value="Y" class="trans"></td>
				       					<td class="title_s">Customer Notice</td>
			       					</tr>
		       					</table>
		       					</td>
		       					<td width="150"></td>
		       					
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_New">New</td>
										<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_Delete">Row&nbsp;Delete</td>
										<td class="btn2_right"></td>
										</tr>
									</table>
								</td>							
							</tr>
						</table>
					</td>
				</tr></table>
		    	<!-- Button_Sub (E) -->
				<table class="line_bluedot">
					<tr><td>
					</td></tr>
				</table>
				<table width="684" class="search"> 
					<tr class="h23"><td>
						<table width="684" class="search"> 
						    <tr class="h23">
						    	<td>
						   			<table class="search" border="0">
					           			<tr>
					           				<td class="title_h"></td>
						  					<td class="title_s">ORIGIN INLAND ROUTE</td>
						  				</tr>
					           		</table>
					          		<table border="0" style="width:310; background-color:white;" class="grid2"> 
										<tr class="tr2_head">
											<td width="30%" colspan="2">POR</td>
											<td width="30%" colspan="2">POL</td>
											<td width="">Trans Mode</td>
										</tr>
						   				<tr>
											<td width="20%" class="input2"><input type="text" name="por_loc_cd" style="width:100%;" class="noinput2" readonly></td>
											<td width="10%" class="input2"><input type="text" name="por_nod_cd" style="width:100%;" class="noinput2" readonly></td>
											<td width="20%" class="input2"><input type="text" name="pol_loc_cd" style="width:100%;" class="noinput2" readonly></td>
											<td width="10%" class="input2"><input type="text" name="pol_nod_cd" style="width:100%;" class="noinput2" readonly></td>
											<td width=""><script language="javascript" >ComComboObject('combo1', 2, 120, 1, 0, 1)</script></td>
										</tr>
									</table>
					 			</td>
					 		</tr>
					 	</table>	
					</td>
					<td>
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">DESTINATION INLAND ROUTE</td>
							</tr>
						</table>
						<table border="0" style="width:320; background-color:white;" class="grid2"> 
							<tr  class="tr2_head">
								<td width="30%" colspan="2">POD</td>
								<td width="30%" colspan="2">DEL</td>
								<td width="">Trans Mode</td>
							</tr>
							<tr>
								<td width="20%" class="input2"><input type="text" name="pod_loc_cd" style="width:100%;" class="noinput2" readonly></td>
								<td width="10%" class="input2"><input type="text" name="pod_nod_cd" style="width:100%;" class="noinput2" readonly></td>
								<td width="20%" class="input2"><input type="text" name="del_loc_cd" style="width:100%;" class="noinput2" readonly></td>
								<td width="10%" class="input2"><input type="text" name="del_nod_cd" style="width:100%;" class="noinput2" readonly></td>
								<td width=""><script language="javascript" >ComComboObject('combo2', 2, 120, 1, 0, 1)</script></td>
							</tr>
						</table>
					</td></tr>					
           			<tr>
	  					<td class="search">
	  						<input type="text" name="us_west_coast" style="width:200%;" class="noinput2" readonly>
	  					</td>
	  				</tr>
					
				</table>	
			</td></tr>
		</table>					
		<table class="height_5">
			<tr><td>
			</td></tr>
		</table>
	</td></tr>
</table>	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save">OK</td>
						<td class="btn1_right"></td>
					</tr></table></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Clear">Clear</td>
						<td class="btn1_right"></td>
					</tr></table></td>							
					<td class="btn1_line"></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close">Close</td>
						<td class="btn1_right"></td>
					</tr></table></td>
				</tr></table>
			</td></tr>
		</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>