<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_9424.jsp
*@FileTitle : Empty Repo BKG Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.18 김병규
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg9424Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg9424Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String bkg_no = "";
	String bkg_div = "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg9424Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		bkg_no = JSPUtil.getParameter(request, "bkgno");
		bkg_div = JSPUtil.getParameter(request, "bkgdiv");

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
<title>Empty Repo BKG Update</title>
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

<input type="hidden" name="inter_rmk">
<input type="hidden" name="bundle_no">
<input type="hidden" name="bkg_div" value="<%=bkg_div %>">
<!-- 개발자 작업	-->
<% 
String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
if(mainPage.equals("true")){
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5; padding-right:5;" >            
	<tr><td valign="top">
        <table width="100%" border="0" cellpadding="0" cellspacing="0"class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif"  align="absmiddle"><span id="navigation"></span></td>
            </tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
            </tr>
        </table>
<%
}else {
%>     
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title">MTY CNTR Attach/Update</span></td></tr>
		</table>
<%
}
%>  		
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->
		<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"><tr class="h23">
					<td width="140">
						<table class="grid2" border="0" style="width:130;">
							<tr>
								<td class="tr2_head" width="50">MVMT</td>
								<td width="" class="input2">
									<input type="radio" name="bkg_mvmt_cd" value="VL" class="trans" checked>VL&nbsp;
									<input type="radio" name="bkg_mvmt_cd" value="VD" class="trans">VD
								</td>
							</tr>
							<tr>
								<td class="tr2_head" width="">T/VVD</td>
								<td class="input2"><input type="text" name="bkg_trunk_vvd" style="width:75"  value="" class="noinput2" readonly></td>
							</tr>
						</table>
					</td> 
					<td width="210">
						<table class="grid2" border="0" style="width:200;">
							<tr>
								<td class="tr2_head" width="30">BKG</td>
								<td width="" >
									<input type="text" style="width:115" name="bkg_no"  style="ime-mode:disabled"  dataformat="engupnum" maxlength="13"  value="<%=bkg_no %>" class="input">
									<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
									<input type="text" name="bkg_sts_cd" style="width:18" value="" class="input2">
									<input type="hidden" name="split_flg">
								</td>
							</tr>
							<tr>
								<td class="tr2_head" width="">B/L</td>
								<td>
									<input type="text" style="width:115" name="bl_no" style="ime-mode:disabled"  dataformat="engupnum"  maxlength="13" value="" class="input">
									<input type="text" style="width:35;color:blue;font-weight:bold" name="split" value="" class="noinput">
								</td>
							</tr>
						</table>
					</td>
					<td width="140">
						<table class="grid2" border="0" style="width:130;">
							<tr>
								<td class="tr2_head" width="80">RHQ OFC</td>
								<td width="" class="input2"><input type="text" style="width:60" name="sls_rhq_cd" value="" class="noinput2" readonly></td>
							</tr>
							<tr>
								<td class="tr2_head" width="">ORG Yard</td>
								<td class="input2"><input type="text" style="width:60" name="org_yd_cd" value="" class="noinput2" readonly></td>
							</tr>
						</table>
					</td>
					<td width="280" valign="top">
						<table class="grid2" border="0" style="width:270;">		
							<tr>
								<td class="tr2_head" width="50">BKG DT</td>
								<td class="input2" colspan="3" width="109"><input type="text" style="width:80" name="bkg_cre_dt" value="" class="noinput2" readonly></td>
								<td class="tr2_head" width="28">POL</td>
								<td class="input2"><input type="text" style="width:45" name="bkg_pol_cd" value="" class="noinput2" readonly></td>
							</tr>
							<tr>
								<td class="tr2_head" width="">POD</td>
								<td width="42" class="input2"><input type="text" style="width:45" name="bkg_pod_cd" value="" dataformat="engupnum" class="noinput2"></td>
								<td width="25" class="tr2_head" width="25">PRE</td>
								<td width="42" class="input2"><input type="text" style="width:45" name="pol_cd" value="" class="noinput2" readonly></td>
								<td class="tr2_head" width="28">Post</td>
								<td class="input2"><input type="text" style="width:45" name="pod_cd" value="" class="noinput2" readonly></td>
							</tr>
						</table>
					</td>
					<td width="" valign="top">
						<table class="grid2" border="0" style="width:220;">
							<tr>
								<td class="tr2_head" width="25">Ind</td>
								<td width="" class="input2" colspan="5">
									<input type="radio" name="mty_bkg_sts_cd" value="S" class="trans" checked>Sound&nbsp;
									<input type="radio" name="mty_bkg_sts_cd" value="D" class="trans" >Damage&nbsp;
									<input type="radio" name="mty_bkg_sts_cd" value="H" class="trans" >H/Rack
								</td>
							</tr>							
						</table>
					</td>				
				</tr></table>
<!-- 				<table class="search" border="0" style="width:979;"> 
					<tr class="h23"></tr>
				</table>		 -->
				<table class="search" border="0" style="width:979;"> 
					<tr>
						<td colspan="2" width="460">
							<table class="search" border="0"><tr>
								<td class="title_h"></td>
								<td class="title_s">Repo. Container No.</td>
							</tr></table>				
						</td>
						<td width="39">	&nbsp;</td>
						<td width="">
							<table class="search" border="0">
								<tr><td class="title_s">
									<input type="radio" name="mvmt_option" value="V" class="trans" checked>Movement(VL)&nbsp;&nbsp;
									<input type="radio" name="mvmt_option" value="S" class="trans">Stowage Plan&nbsp;&nbsp;
								</td></tr>
							</table>
						</td>
						<td width="" align="right">
						<table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_Ts">T/S Route</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
					</td>
					</tr>
       				<tr>
       					<td width="420" valign="top" style="padding-right:10">				
						<!-- Grid (S) -->
							<table width="100%" class="search"  id="mainTable"> 
								<tr><td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td></tr>
							</table> 				
						<!-- Grid (E) -->
						</td>
						<td width="190" valign="top">
						<!-- Grid (S) -->
							<table width="100%" class="search"  id="mainTable" > 
								<tr><td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td></tr>
							</table> 				
						<!-- Grid (E) -->
						</td>
						<td width="4">	&nbsp;</td>
						<td width="300" valign="top" style="padding-right:10">
						<!-- Grid (S) -->
							<table width="100%" class="search"  id="mainTable" > 
								<tr><td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td></tr>
							</table> 				
						<!-- Grid (E) -->
						</td>
						<td width="120" valign="top">
						<!-- Grid (S) -->
							<table width="100%" class="search"  id="mainTable"> 
								<tr><td width="100%">
									<script language="javascript">ComSheetObject('sheet4');</script>
								</td></tr>
							</table> 				
						<!-- Grid (E) -->
						</td>
					</tr>			
					<tr>
						<td colspan="3" width="579">
							<!--  Button_Sub (S) -->
							<table width="100%" class="button"> 
					       		<tr><td class="btn2_bg" style="text-align:left;">
									<table border="0" cellpadding="0" cellspacing="0"><tr>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_ExcelFormat">Excel&nbsp;Format</td>
												<td class="btn2_right"></td>
											</tr></table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_LoadExcel">Load&nbsp;Excel</td>
												<td class="btn2_right"></td>
											</tr></table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_DownExcel">Down&nbsp;Excel</td>
												<td class="btn2_right"></td>
											</tr></table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_Add">Add</td>
												<td class="btn2_right"></td>
											</tr></table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_Delete">Del.</td>
												<td class="btn2_right"></td>
											</tr></table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_Mty">MTY</td>
												<td class="btn2_right"></td>
											</tr></table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_Bundle">Bundle</td>
												<td class="btn2_right"></td>
											</tr></table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_Rmk">RMK</td>
												<td class="btn2_right"></td>
											</tr></table>
										</td>
									</tr></table>
								</td></tr>
							</table>
	    				<!-- Button_Sub (E) -->
						</td>
						<td colspan="2" width="">
						<!--  Button_Sub (S) -->
							<table width="100%" class="button"> 
	       						<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0"><tr>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_Move">Move</td>
												<td class="btn2_right"></td>
											</tr></table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_CheckAll">Check&nbsp;All</td>
												<td class="btn2_right"></td>
											</tr></table>
										</td>
<!-- 						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Retrive">Retrieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
-->						
									</tr></table>
								</td></tr>
							</table>
	    				<!-- Button_Sub (E) -->
						</td>
					</tr>			
				</table>
				<!--biz page (E)-->
			</td></tr>
		</table>
	
		<!--Button (S) -->
		<table class="search" width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       		<tr class="h23">
	       		<td class="stm" align="left">* () : No. of GOH</td>
	       		<td class="btn1_bg" align="right">
		    	<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_BtmRetrive" id="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr></table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_BtmNew">New</td>
							<td class="btn1_right"></td>
						</tr></table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_BtmSave">Save</td>
							<td class="btn1_right"></td>
						</tr></table>
					</td>					
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_BtmCancel">BKG Cancel</td>
							<td class="btn1_right"></td>
						</tr></table>
					</td>
				</tr></table>
    			<!--Button (E) -->
			</td></tr>
		</table>
		
		<!--  hidden grid START -->
		<table id="mainTable">
			<tr><td>
				<script language="javascript">ComSheetObject('sheet5');</script>
			</td></tr>
		</table>
		<table id="mainTable">
			<tr><td>
				<script language="javascript">ComSheetObject('sheet6');</script>
			</td></tr>
		</table>
        <!--  hidden grid END -->
	</td></tr>
</table>
		
		<!-- Grid (E) -->
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
		//document.getElementById("title").innerHTML = curTitle;
		document.body.className ="popup_bg";
	}
</script>
<%
}
%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>