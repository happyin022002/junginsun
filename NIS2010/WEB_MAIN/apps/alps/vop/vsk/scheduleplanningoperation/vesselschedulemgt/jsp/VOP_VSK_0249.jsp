<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0249.jsp
*@FileTitle : vop_vsk_0249
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.15 유혁
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0249Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0249Event event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.scheduleplanningoperation.vesselschedulemgt");
	
	StringBuilder xml = null;
	
	String vslSlanCd[] = null;
	String bkgVvd[] = null;
	//String nonBkgVvd[] = null;
	String hisflag[] = null;
	String turnVoy[] = null;
	String turnDir[] = null;
	
	String tmpVslSlanCd = null;
	
	String tp = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0249Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		vslSlanCd = request.getParameterValues("lane_vvd");
		//nonBkgVvd = request.getParameterValues("vvd");
		bkgVvd = request.getParameterValues("bkg_vvd");
		hisflag = request.getParameterValues("his_vvd");
		
		turnVoy = request.getParameterValues("turn_voy");
		turnDir = request.getParameterValues("turn_dir");
		
		tmpVslSlanCd = request.getParameter("tmp_vsl_slan_cd");
		tmpVslSlanCd = tmpVslSlanCd==null?"":tmpVslSlanCd.trim();
		
		tp = request.getParameter("tp");
		tp = tp==null?"":tp;
		
		xml = new StringBuilder("<SHEET><DATA>");
		for(int i=0; bkgVvd!=null && i<bkgVvd.length; i++){
			xml.append("<TR><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD>");
			xml.append("<TD><![CDATA[").append(vslSlanCd[i]).append("]]></TD>");
			xml.append("<TD><![CDATA[").append(bkgVvd[i]).append("]]></TD>");
			xml.append("<TD><![CDATA[").append(hisflag[i]).append("]]></TD>");
			xml.append("<TD><![CDATA[").append(turnVoy[i]).append("]]></TD>");
			xml.append("<TD><![CDATA[").append(turnDir[i]).append("]]></TD>");
			xml.append("</TR>");
		}
		xml.append("</DATA></SHEET>");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Delay check (Pop-Up)</title>
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
<!-- 개발자 작업	-->
<input type="hidden" name="xml" value="<%=xml.toString()%>">
<input type="hidden" name="vskd_tp_cd" value="M">
<input type="hidden" name="diff_rmk">
<input type="hidden" name="tp" value="<%=tp%>">

<input type="hidden" name="aft_vsl_slan_cd" value="">
<input type="hidden" name="aft_vsl_cd" value="">
<input type="hidden" name="aft_skd_voy_no" value="">
<input type="hidden" name="aft_skd_dir_cd" value="">
<input type="hidden" name="aft_vps_port_cd" value="">
<input type="hidden" name="aft_clpt_ind_seq" value="">
<input type="hidden" name="aft_yd_cd" value="">
<input type="hidden" name="aft_vps_eta_dt" value="">
<input type="hidden" name="aft_vps_etb_dt" value="">
<input type="hidden" name="aft_vps_etd_dt" value="">


<%
	//for(int i=0; nonBkgVvd!=null && i<nonBkgVvd.length; i++){
		//out.print("<input type='hidden' name='non_bkg_vvd' value='" + nonBkgVvd[i] + "'>");
	//}
%>

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;VSL SKD Delete information  </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:480;"> 
				<tr class="h23">
					<td width="180" valign="top">
					
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Voyage No. List</td></tr>
						</table>
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>	
						<!-- : ( Grid ) (E) -->	
					</td> 
					<td width="20"></td>   
					<td width="280" valign="top">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Remark</td></tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td><select name="vskd_cng_tp_cd" style="width:280;">
								<option value="V" selected>Change Lane </option>
								<option value="V">Change VSK Position and Sequence</option>
								<option value="V">Phase Out</option>
								<option value="V">Voyage Cancellation</option>
								<option value="V">Others</option>
								</select></td>
							</tr>
						</table>
						<table class="grid2" border="0" width="280">
							<tr class="h23">
								<td><input type="text" name="rmk" tabindex="1" style="width:100%;ime-mode:disabled;" class="noinput" value=""></td>
							</tr>
						</table>
						<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Change information</td></tr>
						</table>
						<table class="grid2" border="0" width="280">
							<tr class="h23">
								<td width=""  class="tr_head2">Lane</td>
								<td width="" colspan="3"><input type="text" name="tmp_vsl_slan_cd" maxlength="3" tabindex="2" style="width:100%;ime-mode:disabled;" class="noinput" value="<%=tmpVslSlanCd%>"></td>
								<td width=""><img class="cursor" src="img/btns_search.gif" name="btns_lane_search" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td width="50"  class="tr_head2">VVD</td>
								<td width="60"><input type="text" name="tmp_vsl_cd" maxlength="4" tabindex="3" style="width:100%;ime-mode:disabled;" class="noinput" value=""></td>
								<td width="60"><input type="text" name="tmp_skd_voy_no" maxlength="4" tabindex="4" style="width:100%;ime-mode:disabled;" class="noinput" value=""></td>
								<td width=""><input type="text" name="tmp_skd_dir_cd" maxlength="1" tabindex="5" style="width:100%;ime-mode:disabled;" class="noinput" value=""></td>
								<td width="20"><img class="cursor" src="img/btns_search.gif" name="btns_vvd_search" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td width=""  class="tr_head2">Port</td>
								<td width="" colspan="3"><input type="text" name="tmp_vps_port_cd" maxlength="5" tabindex="6" style="width:100%;ime-mode:disabled;" class="noinput" value=""></td>
								<td width=""><img class="cursor" src="img/btns_search.gif" name="btns_port_search" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
						</table>
					</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				
				
			
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
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok" tabindex="7">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close" tabindex="8">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
		</td></tr>
</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>			
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>