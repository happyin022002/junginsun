<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0037.jsp
*@FileTitle : Canada CCT Manage
*Open Issues :
*Change history :
* 1.0 최초 생성 JunKun Lee
* CSR: CHM-201217726-01 Rail Receiving (Cut Off) Date 산출 Logic 변경 및 추가 요청
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.event.EsdPrd0037Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.basic.CanadaCCTManageBCImpl"%>

<%
	EsdPrd0037Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error On Server Side
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet List Count
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_auth_tp_cd = "";
	boolean saveBtnYN = false;
	String [] authUsrArr = {"hjse09182","JINSOOKH","hjse06338"};
    String [] authTpArr = {"A","S"};
	
	Logger log = Logger.getLogger("com.clt.apps.opus.esd.sce.copreport");
	int rowSize = 3000 ;
	
	//selected value in exception combo box
	String expt_tp_idx = JSPUtil.getNull(request.getParameter("expt_tp_selected_idx"));
	String authUsrYn = "N";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_auth_tp_cd = account.getUsr_auth_tp_cd();
		authUsrYn = JSPUtil.getNull(new CanadaCCTManageBCImpl().getAuthUsrYn(strUsr_id));
		
		/* 		
		for(String authUsr : authUsrArr){
			if(authUsr.equals(strUsr_id)){
				saveBtnYN = true;
				break;
			}
		} 
		*/
		
		if("Y".equals(authUsrYn)) {
			saveBtnYN = true;
		}
		
		for(String authTp : authTpArr){
            if(authTp.equals(strUsr_auth_tp_cd)){
            	saveBtnYN = true;
            	break;
            }
        }
		
		event = (EsdPrd0037Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	
		//The data obtained from the server side on load.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<%@include file="/apps/alps/esd/prd/common/prdcommon/jsp/ESD_PRD_AUTH.jsp"%>
<html>
<head>
<title>Rail Receiving(Cut Off) Timetable via Canada ports</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
<%= JSPUtil.getIBCodeCombo("adj_ltst_rcv_dy_cd", "01", "CD00131", 0,  "000010::" )%>
<%= JSPUtil.getIBCodeCombo("ery_rcv_dy_cd", "01", "CD00131", 0,  "000010::" )%>
<%= JSPUtil.getIBCodeCombo("us_adj_ltst_rcv_dy_cd", "01", "CD00131", 0,  "000010::" )%>
<%= JSPUtil.getIBCodeCombo("us_ery_rcv_dy_cd", "01", "CD00131", 0,  "000010::" )%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>
<body onload="javascript:setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pageRows">

<input type="hidden" name="frm_cnt_cd" value="CA">
<input type="hidden" name="frm_loc_cd">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr>
	<td>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
	</td>
</tr>
</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr>
	<td width="66%">
		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
<% if(saveBtnYN) { %>							
							<td><table width='100%' border='0' cellpadding='0' cellspacing='0' class='button'>
							    <tr><td class='btn1_left'></td><td class='btn1' name='btn_save' id='btn_save'>Save</td><td class='btn1_right'></td></tr></table></td>
<%} %>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->
	</td>
	
	
	<td width="34%">
	</td>
</tr>

<tr>
	<td width="66%">
		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr class="h23"><td>*Generic Railroad Schedule for Latest Receiving Date</td></tr>
			<tr><td><table class="height_10"><tr><td></td></tr></table></td></tr>
			<tr><td class="bg">
					<table width="100%" id="mainTable">
						<tr>
							<td>
	                             <script type="text/javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>

					<table width="100%">
					<tr>
					<font color="red">* Latest Receiving Date for CA POL = Vessel Arrival/Berthing Date – Above Days</font>
					</tr>
					<tr>
					<font color="red">* Latest Receiving Date for US POL = Port Cut-Off Time - Above Days</font>
					</tr>
					
					</table>
					
					
					<!-- Button : Sub (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btn_rowadd" id="btn_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btn_rowdel">Row Del</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- Button : Sub (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

	</td>
	
	
	
	<td width="34%">
		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr class="h23"><td>*Interval between Latest and Earliest Receiving Date</td></tr>
			<tr><td><table class="height_10"><tr><td></td></tr></table></td></tr>
			<tr><td class="bg">
					<table width="100%" id="mainTable">
						<tr>
							<td>
	                             <script type="text/javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>

					<!-- font color="red">* LRD is adjusted to Fri according to LRD table left
					</font-->
					
					<!-- Button : Sub (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
						
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btn_save2" id="btn_save2">Save</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->						
						
						</tr></table>
					</td></tr>
					</table>
					<!-- Button : Sub (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

	</td>
</tr>
</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr><td>
		<font style="font-size:10pt;font-family:Tahoma">※ Rail Receiving (Cut Off) Times are based on VSL SKD(ETA/ETB) & Port Cut-off Time.</font>
	</td></tr>
	<tr><td>
		<font style="font-size:10pt;font-family:Tahoma">※ Holidays are  not counted on these calculations.</font>
	</td></tr>
	<tr><td>
		<font style="font-size:10pt;font-family:Tahoma">※ For the source of table above, please contact PHXSAR</font>
	</td></tr>
</table>

<!-- Outer Table (E)-->

</form>
</body>
</html>
