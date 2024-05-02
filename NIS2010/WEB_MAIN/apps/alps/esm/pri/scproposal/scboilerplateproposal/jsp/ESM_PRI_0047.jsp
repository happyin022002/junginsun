<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0047.jsp
*@FileTitle : S/C Proposal Boiler Plate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.28 공백진
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.event.EsmPri0047Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%
	EsmPri0047Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCBoilerPlateProposal");
	
	String propNo = "";
	String amdtSeq = "";

	String effDt = "";
	String expDt = "";


	String scNo1 = "";
	String scNo2 = "";
	
	String ctrtExpDt = "";
	String ctrtEffDt = "";
	String blplHdrSeq = "";
	String[] srcInfoCd = null;
	String[] stsCd = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0047Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");	

		effDt = request.getParameter("sEffDt");
		expDt = request.getParameter("sExpDt"); 

		
		scNo1 = request.getParameter("sSc_No1");
		scNo2 = request.getParameter("sSc_No2");;
		ctrtExpDt = request.getParameter("sCtrtExpDt");
		ctrtEffDt = request.getParameter("sCtrtEffDt");

		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoList"), false ,"|","\t","getCode","getName");	
		stsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsList"), false ,"|","\t","getCode","getName");	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C Proposal Boiler Plate Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var srcInfoCdValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdText = "<%=srcInfoCd[1]%>";    
    var stsCdValue = "<%=stsCd[0]%>";
    var stsCdText = "<%=stsCd[1]%>"; 
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
<!-- 개발자 작업	-->

<input type="hidden" name="eff_dt" value="<%=effDt %>">
<input type="hidden" name="exp_dt" value="<%=expDt %>">
<input type="hidden" name="blpl_seq" >
<input type="hidden" name="blpl_hdr_seq" value="<%=blplHdrSeq %>" >
<input type="hidden" name="cd">
<input type="hidden" name="sts_cd">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;S/C Proposal Boiler Plate Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="77">S/C No.</td>
					<td width="120">
					<input type="text" name="scNo1" style="width:40;text-align:center;" class="input2" value="<%=scNo1%>" readonly>
					<input type="text" name="scNo2" style="width:60;text-align:center;" class="input2" value="<%=scNo2%>" readonly></td>
					<td width="60">AMD No.</td>
					<td width="60">
						<input type="text" name="amdt_seq" style="width:40;text-align:center;" class="input2" value="<%=amdtSeq%>" readonly></td>
					<td width="80">Proposal No.</td>
					<td width="140">
						<input type="text" name="prop_no" style="width:90;text-align:center;" class="input2" value="<%=propNo%>" readonly></td>
					<td width="60">Duration</td>
					<td width="">
						<input type="text" name="hdr_eff_dt" caption="Eff Date" maxlength="10" dataformat="ymd" style="width:75" class="input2" value="<%=ctrtEffDt%>" readonly>&nbsp;~&nbsp;
						<input type="text" name="hdr_exp_dt" caption="Expire Date" maxlength="10" dataformat="ymd" style="width:75" class="input2" value="<%=ctrtExpDt%>" readonly>
					</td>
				</tr>
				<tr class="h23">
					<td width="77">Boiler Plate</td>
					<td colspan="5"width="">
						<input type="text" name="blpl_ref_yr" style="width:40;" class="input2" readonly>
						<input type="text" name="blpl_nm" style="width:176;" class="input2" readonly></td></tr>
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

<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
			
			
	    	<!--Grid (S) -->
			<table class="height_5"><tr><td></td></tr></table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
		    <!-- : ( Grid ) (E) -->	
		    
			<!--grid (s) Excel Download-->
			<div id="sheetHidden" style="display:none">		
			<table width="100%"> 
				<tr>
					<td>
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table>
			</div>
			<!--grid(E)-->			    
			
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->


		
		
</td></tr>
</table> 

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>