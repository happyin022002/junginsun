<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0205.jsp
*@FileTitle : Phase In/Out Information (pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.16
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.02 유혁
* 1.0 Creation
*
* History
* 2010.09.16 유혁 CHM-201005617-01 미지정시 Direction, Port Code에 대해 유저가 선택 가능하도록 변경
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%> 
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VskGloEvent"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PhaseInOutReasonVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VskGloEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.vskcommon.vskcodefinder");
	
	String phaseType = null;
	String clptIndSeq = null;
	//String[] portList = null;
	List<PhaseInOutReasonVO> list = null;
	
	String dirCd = null;
	String[] dirCds = null;
	
	String vpsPortCd = null;
	String[] vpsPortCds = null;
	String firstPortCds = null;
	String secondPortCds = null;
	
	
	String parentUI = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VskGloEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		list = eventResponse.getRsVoList();

		//////////////////////////
		
		phaseType = (String)event.getAttribute("sPhaseType");
		clptIndSeq = (String)event.getAttribute("sClptIndSeq");
		//portList = ((String)event.getAttribute("sPortList")).split("\\|");
		
		dirCd = JSPUtil.replaceForHTML(request.getParameter("dir_cd"));
		dirCd = dirCd==null?"":dirCd;
		
		if(dirCd.indexOf("|")>0){
			dirCds = dirCd.split("\\|");
		}
		
		vpsPortCd = JSPUtil.replaceForHTML(request.getParameter("port_cd"));
		vpsPortCd = vpsPortCd==null?"":vpsPortCd;
		
		firstPortCds = JSPUtil.replaceForHTML(request.getParameter("first_port_cd"));
		firstPortCds = firstPortCds==null?"":firstPortCds;
		
		secondPortCds = JSPUtil.replaceForHTML(request.getParameter("second_port_cd"));
		secondPortCds = secondPortCds==null?"":secondPortCds;
		
		if(firstPortCds.indexOf("|")>0){
			vpsPortCds = firstPortCds.split("\\|");
		}

		parentUI = JSPUtil.replaceForHTML(request.getParameter("parentUI"));
		
		//////////////////////////
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<% 
	if("I".equals(phaseType)){
		out.print("<title>Phase In Information</title>");
	}else if("O".equals(phaseType)){
		out.print("<title>Phase Out Information</title>");
	}
%>
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
<!-- 개발자 작업	-->

<input type="hidden" name="phaseType" value="<%=phaseType %>">
<input type="hidden" name="src_clpt_ind_seq" value="<%=clptIndSeq %>">
<input type="hidden" name="dst_clpt_ind_seq" value="<%=clptIndSeq %>">
<input type="hidden" name="parentUI" value="<%=parentUI%>">

<input type="hidden" name="firstPortCds" value="<%=firstPortCds%>">
<input type="hidden" name="secondPortCds" value="<%=secondPortCds%>">

<!-- OUTER - POPUP (S)tart -->
<table width="650" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; <%= "I".equals(phaseType)?"Phase In":"O".equals(phaseType)?"Phase Out":"" %></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- 거래 처리용 시트 -->
		<!-- Grid  (S) -->
		<table width="100%" id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
		<!-- Grid (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search" width="650"> 
       		<tr><td class="bg">
			<table class="search" border="0">
				<tr class="h23">
					<td width="150">VVD</td>
					<td width="172">
						<input type="text" name="src_vsl_cd" style="width:40;ime-mode:disabled;text-align:center" class="input1" maxlength="4" value="<%=event.getAttribute("sVslCd")%>">
						<input type="text" name="src_skd_voy_no" style="width:40;ime-mode:disabled;text-align:center" class="input1" maxlength="4" value="<%=event.getAttribute("sVoyNo")%>">
						<%if(dirCds==null){%>
						<input type="text" name="src_skd_dir_cd" style="width:20;ime-mode:disabled;text-align:center" class="input1" maxlength="1" value="<%=dirCd%>" readOnly>
						<%}else{ // CHM-201005617-01 %>
						<select name="src_skd_dir_cd" onchange="changePortList()">
							<%for(int i=0; i<dirCds.length; i++){ %>
							<option value="<%=dirCds[i]%>"><%=dirCds[i]%></option>
							<%} %>
						</select>
						<%} %>
						<%if("I".equals(phaseType)){%>
						<img class="cursor" src="img/btns_search.gif" name="btns_search1" width="19" height="20" border="0" align="absmiddle">
						<%} %>
					</td>
					<td width="120">Call Indicator</td>
					<td width=""><select style="width:111;" class="input1" name="clpt_ind_seq_1">
						<option value="1">First</option>
						<option value="2">Second</option>
						<option value="3">Third</option>
						<option value="4">4th</option>
						<option value="5">5th</option>
						<option value="6">6th</option>
						<option value="7">7th</option>
						<option value="8">8th</option>
						<option value="9">9th</option>
						<option value="10">10th</option>
						</select></td>
				</tr>
				<tr class="h23">
					<%
						if("I".equals(phaseType)){
					%>
					<td width="">Phase In indicator</td>
					<td width=""><input type="text" style="width:108;text-align:center" class="input2" value="Phase In" readonly></td>
					<td width="">Phase In Date</td>
					<%
						}else if("O".equals(phaseType)){
					%>
					<td width="">Phase Out indicator</td>
					<td width=""><input type="text" style="width:108;text-align:center" class="input2" value="Phase Out" readonly></td>
					<td width="">Phase Out Date</td>
					<%}%>
					<td width=""><input type="text" style="width:87;text-align:center" class="input1" dataformat = "ymd" maxlength="8" name="src_phase_date" value="<%=event.getAttribute("sPhaseDate")%>">
					<img class="cursor" name="btns_cal1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
				</tr>
				<tr class="h23">
					<td width=""></td>
					<td width=""></td>
					<td width="">P/F SKD Date</td>
					<td width="">
					<%if("I".equals(phaseType)){%>
						<input type="text" style="width:87;text-align:center" class="input1" dataformat = "ymd" maxlength="8" name="src_pf_date" value="<%=JSPUtil.replaceForHTML(request.getParameter("src_pf_date"))%>">
						
						<img class="cursor" name="btns_cal11" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					<%} %>
					</td>
				</tr>
				<tr class="h23">
					<td width="">Lane</td>
					<td width=""><input type="text" name="src_vsl_slan_cd" style="width:108;text-align:center" class="input2" value="<%=event.getAttribute("sVslSlanCd")%>" readonly></td>
					<td width="">Port Code</td>
					<td width="">
						<%if(!"".equals(vpsPortCd) && vpsPortCd != null){ %>
						<input type="text" name="src_port_cd" style="width:111;text-align:center" class="input1" value="<%=vpsPortCd%>" readonly>
						<%}else{ // CHM-201005617-01%>
						<select name="src_port_cd">
							<%if (vpsPortCds != null) { %>
								<%for(int i=0; i<vpsPortCds.length; i++){ %>
								<option value="<%=vpsPortCds[i]%>"><%=vpsPortCds[i]%></option>
								<%} %>
							<%} %>
						</select>
						<%} %>
					</td>
				</tr>
				<tr class="h23">
					<td width="120">Force Majeure</td>
					<td width=""><select style="width:111;" class="input1" name="port_skp_tp_cd">
						<option value="I">No</option>
						<option value="F">Yes</option>
						</select></td>
				</tr>
				
				<!-- 
				<tr class="h23">
					<td width="">Out-In Gap Time</td>
					<td colspan="3"><input type="text" name="gap_time" style="width:425;text-align:right" class="input1" value="" readonly></td>
				</tr>
				 -->
				
				
				<tr class="h23">
					<td width="">Reason</td>
					<td width="" colspan="3" style="padding-left:2">
						 <select style="width:100;" class="input" name="phase_rsn_code">
						 <%
						 	for(int i=0; i<list.size(); i++){
						 		PhaseInOutReasonVO vo = list.get(i);
						 		out.print("<option value='" + vo.getRsnName() + "'>" + vo.getRsnCode() + "</option>"); 
						 	}
						 %>
						 </select>
						 <input type="text" style="width:321;" class="input2" value="" name="phase_rsn_name">
					</td>
				</tr>
				</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="50" class="popup">
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OK">OK</td>
					<td class="btn1_right">
				</tr></table></td></td>
				<td class="btn1_line">
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
</td></tr></table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>