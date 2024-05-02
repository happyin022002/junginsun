<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4031.jsp
*@FileTitle : Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.04.28 최성민
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.primasterdata.location.event.EsmPri4026Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocListVO"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmPri4026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.PRIMasterData.Location");
	
	String groupCmd = "";
	String propNo = "";
	String svcScpCd = "";
	String amdtSeq = "";
	String grpLocSeq = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri4026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		RsltGrpLocListVO rsltGrpLocListVO = event.getRsltGrpLocListVO();
		
		
		
		if(rsltGrpLocListVO != null) {
			groupCmd = rsltGrpLocListVO.getGroupCmd();
			propNo = rsltGrpLocListVO.getPropNo();
			svcScpCd = rsltGrpLocListVO.getSvcScpCd();
			amdtSeq = rsltGrpLocListVO.getAmdtSeq();
			grpLocSeq = rsltGrpLocListVO.getGrpLocSeq();
		}
		
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
<title>Location Inquiry</title>
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
<!-- 개발자 작업	-->

<!-- 테스트하고 값을 삭제할것 -->
<input type="hidden" name="group_cmd" value="<%=StringUtil.xssFilter(request.getParameter("group_cmd"))%>"> <!-- Group Location 구분 -->
<input type="hidden" name="location_cmd" value="LTCR"> <!-- 화면 구분 -->
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>" >
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq")) %>">
<input type="hidden" name="cre_ofc_cd" value="<%=StringUtil.xssFilter(request.getParameter("cre_ofc_cd"))%>" >
<input type="hidden" name="grp_loc_seq" >
<input type="hidden" name="gline_seq" value="<%=StringUtil.xssFilter(request.getParameter("gline_seq"))%>">
<input type="hidden" name="loc_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("loc_tp_cd"))%>"><!-- 화면로딩시 나타날 화면을 지정한다. TYPE으로 저정 -->
<input type="hidden" name="org_dest_cd" value="<%=StringUtil.xssFilter(request.getParameter("org_dest_cd"))%>"><!-- RFA에서 사용(LOCATION CODE)-->
<input type="hidden" name="qttn_no" value="<%=StringUtil.xssFilter(request.getParameter("qttn_no"))%>">
<input type="hidden" name="qttn_ver_no" value="<%=StringUtil.xssFilter(request.getParameter("qttn_ver_no"))%>">
<input type="hidden" name="chg_cd" value="<%=StringUtil.xssFilter(request.getParameter("chg_cd"))%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Type</td>
				    <td width="" class="stm"><input name="radio_type" type="radio" value="1" class="trans" checked="true">Location&nbsp;&nbsp;&nbsp;&nbsp;
					<div id="hiddenLayer" style="display:none"><input type="radio" name="radio_type" value="2" class="trans" >Location Group &nbsp;&nbsp;&nbsp;&nbsp;</div>
					<input type="radio" name="radio_type" value="3" class="trans">State&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="radio_type" value="4" class="trans">Region&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="radio_type" value="5" class="trans">Country
					<!--<input type="radio" name="radio_type" value="6" class="trans">IAA Region&nbsp;&nbsp;&nbsp;&nbsp;
					--></td>
				</tr>
			</table> 

<!-- Raido Tab [ Location ] (S) -->
<div id="radioLayer1" style="display:inline">
			
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="40">&nbsp;&nbsp;Code</td>
				    <td width="100"><input name="loc_cd" type="text" style="width:50;" maxlength="5" minlength="2" class="input" value="" style="ime-mode:disabled" required="true"></td>
					<td width="60">Description</td>
				    <td width=""><input name="loc_nm" type="text" style="width:350;" maxlength="30" class="input" value="<%=request.getParameter("loc_def_nm")==null?"":request.getParameter("loc_def_nm")%>" style="ime-mode:disabled" ></td>
				</tr>
				</table> 
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--grid (S)-->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--grid (E)-->
			
				
				<!--  biz_1   (E) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1Retrieve" id="btn_t1Retrieve">Retrieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1New">New</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</div>
<!-- Raido Tab [ Location ] (E) -->


<!-- Raido Tab [ Group Location ] (S) -->
<div id="radioLayer2" style="display:none">
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="40">&nbsp;&nbsp;Code</td>
				    <td width="">
				    <script language="javascript">ComComboObject('combo_grp_loc_cd', 2, 70, 0, 1, 0, false);</script>
						&nbsp;<input type="text" name="combo_grp_loc_nm" style="width:150;" class="input"  value="" disabled="true"></td>
				</tr>
				</table> 
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--grid (S)-->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!--grid (E)-->
				
				
				<!--  biz_1   (E) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2Retrieve" id="btn_t2Retrieve">Retrieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2New">New</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
					
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

</div>
<!-- Raido Tab [ Group Location ] (E) -->


<!-- Raido Tab [ State ] (S) -->
<div id="radioLayer3" style="display:none">

			<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="105">&nbsp;&nbsp;Country Code</td>
				   	<td width="" style="padding-left:2">
				   		<script language="javascript">ComComboObject("combo_cnt_cd", 2, 70, 0, 1, 0, false);</script>
						&nbsp;&nbsp;<input type="text" name="combo_cnt_nm" style="width:150;" class="input" value="" disabled="true"></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;&nbsp;State</td>
				    	<td width=""><input type="text" name="ste_cd" style="width:70;" maxlength="2" minlength="1" class="input" value="" style="ime-mode:disabled" required="true">
				    	&nbsp;<input type="text" name="ste_nm" maxlength="30" style="width:173;" class="input" value="" style="ime-mode:disabled"></td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--grid (S)-->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
				<!--grid (E)-->


				<!--  biz_1   (E) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t3Retrieve" id="btn_t3Retrieve">Retrieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t3New">New</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

</div>
<!-- Raido Tab [ State ] (E) -->

<!-- Raido Tab [ Region ] (S) -->
<div id="radioLayer4" style="display:none">
			<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="105">&nbsp;&nbsp;Country Code</td>
				   	<td width="" style="padding-left:2">
				   	<script language="javascript">ComComboObject("combo2_cnt_cd", 2, 70, 0, 1, 0, false);</script>
					&nbsp;&nbsp;<input type="text" name="combo2_cnt_nm" style="width:150;" class="input" value="" disabled="true"></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;&nbsp;Region</td>
				    	<td width=""><input type="text" name="rgn_cd" style="width:70;" maxlength="3" minlength="2" class="input" value="" style="ime-mode:disabled" required="true">
				    	&nbsp;<input type="text" name="rgn_nm" maxlength="30" style="width:173;" class="input" value="" style="ime-mode:disabled"></td>
				</tr>
				
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--grid (S)-->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
				<!--grid (E)-->
				
				
				<!--  biz_1   (E) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t4Retrieve" id="btn_t4Retrieve">Retrieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t4New">New</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

</div>
<!-- Raido Tab [ Region ] (E) -->


<!-- Raido Tab [ Country ] (S) -->
<div id="radioLayer5" style="display:none">
			
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="40"> &nbsp;&nbsp;Code</td>
				    <td width="100"><input name="cnt_cd" type="text" style="width:60;" maxlength="2" class="input" value="" style="ime-mode:disabled" required="true"></td>
					<td width="80">Description</td>
				    <td width=""><input name="cnt_nm" type="text" style="width:200;" maxlength="30" class="input" value="" style="ime-mode:disabled"></td>
				</tr>
				</table> 
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--grid (S)-->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table>
				<!--grid (E)-->
				
				
				<!--  biz_1   (E) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t5Retrieve" id="btn_t5Retrieve">Retrieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t5New">New</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

</div>
<!-- Raido Tab [ Country ] (E) -->
		</td></tr></table>
		
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>