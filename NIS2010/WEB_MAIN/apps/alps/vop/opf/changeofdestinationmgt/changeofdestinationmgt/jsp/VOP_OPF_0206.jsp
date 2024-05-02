<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0206.jsp
*@FileTitle : COD Approval Detail at RSO Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.22 김종옥
* 1.0 Creation
=========================================================
* History
* 2010.07.29 WJK [Ticket-ID:CHM-201004937-01] COD application 외부 E-mail 기능 추가
* 2010.08.24 윤진영 [CHM-201005460] Freight 변경 가능및 Row 추가
* 2012.04.05 김민아 [CHM-201217130-01] COD application 승인 화면내 Rehnadling Q"ty를 계산한 Bayplan 정보 칼럼 추가
* 2015.03.06 이병훈 [CHM-201534196] COD charges DVC 비용 관련 로직 수정
*=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf0206Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	VopOpf0206Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml       = "";
	String strDate          = "";

	String strBkgNo = StringUtil.xssFilter(request.getParameter("bkg_no"));
	String strBlNo = StringUtil.xssFilter(request.getParameter("bl_no"));
	String strBvd = StringUtil.xssFilter(request.getParameter("vvd"));
	String strVslSlanCd = StringUtil.xssFilter(request.getParameter("vsl_slan_cd"));
	String strCodRqstSeq = StringUtil.xssFilter(request.getParameter("cod_rqst_seq"));
	String strCodRhndPortCd = StringUtil.xssFilter(request.getParameter("cod_rhnd_port_cd"));
	String strCodStsCd = StringUtil.xssFilter(request.getParameter("cod_sts_cd"));
	String strCodEmailSendYn = StringUtil.xssFilter(request.getParameter("cod_email_send_yn"));	
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChangeOfDestinationMgt.ChangeOfDestinationMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();
		strDate = DateTime.getYear() + "/" + DateTime.getMonth() + "/" + DateTime.getDay();  


		event = (VopOpf0206Event)request.getAttribute("Event");
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
<title>COD Approval Detail at RSO Office</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage('<%=strDate%>');
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="cod_rqst_seq" value="<%=strCodRqstSeq%>">
<input type="hidden" name="rat_ut_cd">
<input type="hidden" name="tpsz">
<input type="hidden" name="codRemark">
<input type="hidden" name="rejectRmk"> 
<input type="hidden" name="cod_sts_cd" value="<%=strCodStsCd%>">
<input type="hidden" name="codstscd">
<input type="hidden" name="cod" value="<%=strCodStsCd%>">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="cntr_cgo_tp_cd">
<input type="hidden" name="cgo_cate_cd">
<input type="hidden" name="cod_email_send_yn" value="<%=strCodEmailSendYn%>">
<input type="hidden" name="skd_dir_cd">

<!-- 메세지 내용 시작 -->
<input type="hidden" name="sndr_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="sndr_usr_nm" value="<%=strUsr_nm%>">
<!-- input type="text" name="msg_ctnt" -->
<input type="hidden" name="rcvr_usr_id">
<input type="hidden" name="rcvr_usr_nm">
<input type="hidden" name="cntr_no">
<textarea style="width:100;height:20;display:none" name="msg_ctnt"></textarea>
<!-- 메세지 내용 끝 -->

<!-- 메일전송 관련 항목 -->
<input type="hidden" name="com_rdSubSysCd" value="OPF">
<input type="hidden" name="com_from" value="<%=strUsr_eml%>">
<input type="hidden" name="com_recipient">
<input type="hidden" name="com_carbonCopy">
<input type="hidden" name="com_blindCarbonCopy">
<input type="hidden" name="com_subject">
<input type="hidden" name="com_fileKey">
<input type="hidden" name="com_content">
<input type="hidden" name="com_templateMrd">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;COD Approval Detail at RSO Office
	</td></tr>
	</table>
	<!-- : ( Title ) (E) -->
		
	<!-- : ( Search Options ) (S) -->
	<table class="search"> 
       <tr><td class="bg">
			<table class="search" border="0" style="width:878;"> 
			<tr class="h23">
				<td width="55">BKG  No.</td>
				<td width="160"><input name="bkg_no" type="text" style="width:110;text-align:center;" class="input2" value="<%=strBkgNo%>" readonly></td>
				<td width="44">BL  No.</td>
				<td width="160"><input name="bl_no" type="text" style="width:110;text-align:center;" class="input2" value="<%=strBlNo%>" readonly></td>
				<td width="39">VVD</td>
				<td width="160"><input name="vvd" type="text" style="width:100;text-align:center;" class="input2" value="<%=strBvd%>" readonly></td>
				<td width="65">Lane Code</td>
				<td width=""><input name="slan_cd" type="text" style="width:80;text-align:center;" class="input2" value="<%=strVslSlanCd%>" readonly></td></tr>
			</table>
			</td>
		</tr>
	</table> 
	<table class="height_10"><tr><td></td></tr></table>
		
	<table class="search"> 
      <tr><td class="bg">
		<table class="search" border="0">
		<tr><td class="title_h"></td>
			<td class="title_s">COD Request Information</td></tr>
		</table>
		
		<!-- : ( Grid ) (S) -->
		<table width="100%" id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table> 				
		<!-- : ( Grid ) (E) -->	
		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
		<table class="search" border="0" style="width:878;"> 
		<tr class="h23">
			<td width="90">Approval RSO</td>
			<td width="85">
				<script language="javascript">ComComboObject('rso', 2, 80, 1, 0);</script>
			</td>
			<td width="70">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr>
					<td class="btn2_left"></td>
					<td class="btn2" name="btn_update"> Update</td>
					<td class="btn2_right"></td>
				</tr>
				<tr><td style="padding-buttom:10"></td></tr>
				</table>
			</td>
			<td width="">&nbsp;</td>
		</tr>
		</table>
		
		<!-- TAB [ Gang Structure ] (E) -->
		<div id="tabLayer" style="display:none">
			<table class="search" id="mainTable"> 
		      	<tr><td class="bg">	
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->			
				
				</td></tr>
			</table>
			<!--biz page (E)-->
		</div>
		<!-- TAB [ Gang Structure ] (E) -->			
		
		<table width="100%" class="grid2"> 
		<tr class="tr2_head">
			<td width="14%">BKG Route	</td>
			<td width="12%">POR	</td>
			<td width="12%">POL	</td>
			<td width="12%">POD	</td>
			<td width="12%">DEL	</td>
			<td width="13%">Target VVD	</td>
			<td width="13%">T/S Detail	</td>
			<td width="%">Remark(s)</td>
		</tr>
		<tr align="center"><td class="tr2_head2">OLD</td>
			<td><input type="text" style="width:80;text-align:center;" class="noinput" name="old_por" readonly></td>
			<td><input type="text" style="width:80;text-align:center;" class="noinput" name="old_pol" readonly></td>
			<td><input type="text" style="width:80;text-align:center;" class="noinput" name="old_pod" readonly></td>
			<td><input type="text" style="width:80;text-align:center;" class="noinput" name="old_del" readonly></td>
			<td><input type="text" style="width:80;text-align:center;" class="noinput" name="old_vvd" readonly></td>
			<td align="center"><img class="cursor" src="img/btng_ts_route.gif" name="old_ts_route" width="75" height="19" border="0" align="absmiddle"></td>
			<td></td>
		</tr>
		<tr align="center"><td class="tr2_head2">NEW</td>
			<td><input type="text" style="width:80;text-align:center;" class="noinput" name="new_por" readonly></td>
			<td><input type="text" style="width:80;text-align:center;" class="noinput" name="new_pol" readonly></td>
			<td><input type="text" style="width:80;text-align:center;" class="noinput" name="new_pod" readonly></td>
			<td><input type="text" style="width:80;text-align:center;" class="noinput" name="new_del" readonly></td>
			<td><input type="text" style="width:80;text-align:center;" class="noinput" name="new_vvd" readonly></td>
			<td align="center"><img class="cursor" src="img/btng_ts_route.gif" name="new_ts_route" width="75" height="19" border="0" align="absmiddle"></td>
			<td align="center"><img class="cursor" src="img/btns_detail.gif" name="new_detail" width="68" height="19" border="0" align="absmiddle"></td>
		</tr>
		</tr>
		</table> 
		<table class="search" border="0" style="width:878;"> 
		<tr class="h23">
			<td width="90">COD Reason</td>
			<td width=""><input type="text" style="width:244;" class="input2" name="cod_rqst_rsn_cd" readonly></td>
			</tr>
		</table>
		</td>
		</tr>
	</table> 
	<table class="height_10"><tr><td></td></tr></table>
				
	<table class="search"> 
      <tr><td class="bg">
		<table class="search" border="0">
		<tr><td class="title_h"></td>
			<td class="title_s">Freight & Charges for COD</td></tr>
		</table>
		
		<table class="search" border="0" style="width:878;"> 
		<tr class="h23">
			<td width="185">
				<table class="search" border="0" style="width:180;"> 
					<tr class="h23">
						<td width="115">Re-Handling PORT</td>
						<td width=""><input type="text" style="width:60; text-align:center;" class="input2" name="cod_rhnd_port_cd" value="<%=strCodRhndPortCd%>" readOnly></td>
					</tr>
				</table>
			</td>
			<td width="110">
				<table width="100%" class="button"> 
		       	<tr>
		       		<td class="" style="text-align:left;">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td align="left"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_calculation"> Calculation</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
			<td width="">
				<table class="search" border="0" style="width:100%;">
					<tr class="h23">
						<td width="100">Applied Bayplan</td>
						<td width="85"><input type="text" style="width:80; text-align:center;" class="input2" name="applied_bayplan_vvd" readOnly></td>
						<td width=""><input type="text" style="width:60; text-align:center;" class="input2" name="applied_bayplan_port" readOnly></td>
					</tr>
				</table> 
			</td>
		</tr>
		</table>
		
		<!-- : ( Grid ) (S) -->
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			</tr>
		</table> 				
		<!-- : ( Grid ) (E) -->	
			
		<!-- : ( Button : Grid ) (S) -->
		<!--  Button_Sub (S) -->
		<table width="100%" class="button"> 
       	<tr><td class="btn2_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_add">Row Add</td>
				<td class="btn2_right"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_del">Row Delete</td>
				<td class="btn2_right"></td>
				</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>

    	<!-- Button_Sub (E) -->
	    <!-- : ( Button : Grid ) (E) -->	
		
		</td></tr>
		</table>
	</td>
	</tr>
	</table> 
		<table class="height_10"><tr><td></td></tr></table>

		<table class="search"> 
      	<tr><td class="bg">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Authority</td>
										
					<td>
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_reject">Reject Reason Remarks</td>
						<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>				
	    		<!-- Button_Sub (E) -->
				</td></tr>
				<td>
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><div id="rejectRmkView" style="visibility:hidden;position:absolute;overflow:hidden;width:100%; height:100%;"><iframe name="rejectRmkIfrm" src="/hanjin/VOP_OPF_1206.do?isPop=R" width="320" height="175" marginWidth="0" marginHeight="0" scrolling=no frameborder="0"></iframe></div></td>
				</tr>
				</table>
				</td>
				</table>
		    	<!-- : ( Button : Grid ) (E) -->			
				</td>
					
				</tr>					
				</table>
				<table class="search" border="0" style="width:878;"> 
				<tr><td width="700">
				<table class="search" border="0" style="width:698;"> 
				<tr class="h23">
					<td width="78">Auth Result</td>
					<td width="100">
						<script language="javascript">ComComboObject('authflag', 1, 80, 1);</script>
					</td>
					<td width="90">Reject Reason</td>
					<td width="">
						<script language="javascript">ComComboObject('rejectcd', 2, 80, 1, 0);</script>
					</td>
					</tr>
				</table>
				</td>
				<td width="10"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Mail">Mail</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>			
				</tr>
				</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 


	</td></tr>
</table> 

<!-- TAB [ Gang Structure ] (E) -->
<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">	
		<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
						<script language="javascript">ComSheetObject('sheet5');</script>
					</td>
				</tr>
			</table>
		<!-- Grid (E) -->			
		
		</td></tr>
	</table>
	<!--biz page (E)-->
</div>
<!-- TAB [ Gang Structure ] (E) -->	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
      	<tr><td class="btn3_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			<td width="">
			<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_ok">OK</td>
				<td class="btn1_right"></td>
			</table>
			</td>				
			<td class="btn1_line"></td>
			<td width="">
			<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_close">Close</td>
				<td class="btn1_right"></td>
			</table>
			</td>	
			</tr>
		</table>
		</td></tr>
	</table>
   <!--Button (E) -->

</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<div id="codRemarkView" style="visibility:hidden;position:absolute;overflow:hidden;width:100%; height:100%;"><iframe name="codRemarkIfrm" src="/hanjin/VOP_OPF_1206.do?isPop=C" width="320" height="175" marginWidth="0" marginHeight="0" scrolling=no frameborder="0"></iframe></div>
<div id="qtyView" style="visibility:hidden;position:absolute;overflow:hidden;width:100%; height:100%;"><iframe name="qtyIfrm" src="/hanjin/VOP_OPF_1206.do?qty&isPop=Q" width="320" height="175" marginWidth="0" marginHeight="0" scrolling=no frameborder="0"></iframe></div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>