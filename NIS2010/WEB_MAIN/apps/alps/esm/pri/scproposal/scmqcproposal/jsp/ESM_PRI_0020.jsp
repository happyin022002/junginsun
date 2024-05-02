<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0020.jsp
*@FileTitle : MQC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.25 공백진
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.event.EsmPri0020Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%
	EsmPri0020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCMQCProposal");
	
	String propNo = "";
	String amdtSeq = "";
	String preAmdtSeq = "";
	String propStsCd = "";
	String sc_no = "";
	String scNo1 = "";
	String scNo2 = "";
	//String effDt = "";
	//String expDt = "";
	String preExpDt = "";
	String svcScpCd ="";	
	String repUsrFlg = "";
	String aproUsrFlg = "";
	//String durDupFlg = "";
	String[] srcInfoCd = null;
	String[] stsCd = null;
	//String[] scopeCd = null;
	String[] lodUtCd = null;
	String lgcyIfFlg = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	   
		event = (EsmPri0020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");	

		preAmdtSeq = request.getParameter("sPreAmdtSeq");
		propStsCd = request.getParameter("sPropStsCd");
		svcScpCd = request.getParameter("sSvcScpCd");
		sc_no = request.getParameter("sSc_No");
		
		preExpDt = request.getParameter("sPreExpDt");
		/*
		sc_no = "TES090001";
		propNo = "TES090001";
		amdtSeq = "2";
		preAmdtSeq = "1";
		//svcScpCd = "ACE";
		*/
		
		if (sc_no != null && sc_no !="" && sc_no.length() >= 3){
			scNo1 = sc_no.substring(0,3);
			scNo2 = sc_no.substring(3,sc_no.length());
		}	
		repUsrFlg = request.getParameter("sIsReqUsr");		
		aproUsrFlg = request.getParameter("sIsAproUsr");
		lgcyIfFlg = request.getParameter("sLgcyIfFlg");
		//durDupFlg = request.getParameter("sDurDupFlg");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoList"), false ,"|","\t","getCode","getName");	
		stsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsList"), false ,"|","\t","getCode","getName");	
		//scopeCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scopeList"), true);
		lodUtCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("lodUtList"), false ,"|","\t","getCode","getName");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>MQC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var lodUtCdValue = "<%=lodUtCd[0]%>";
    var lodUtCdText = "<%=lodUtCd[1]%>";  
    var srcInfoCdValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdText = "<%=srcInfoCd[1]%>";    
    var stsCdValue = "<%=stsCd[0]%>";
    var stsCdText = "<%=stsCd[1]%>";  
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	function closePage(){
		unloadPage();
	}		
</script>
</head>

<body  onLoad="setupPage();" onunLoad="closePage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pre_amdt_seq" value="<%=preAmdtSeq %>">
<input type="hidden" name="prop_sts_cd" value="<%=propStsCd %>">
<input type="hidden" name="pre_exp_dt" value="<%=preExpDt %>">
<input type="hidden" name="svc_scp" value="<%=svcScpCd %>">
<input type="hidden" name="cd">
<input type="hidden" name="main_eff_dt">
<input type="hidden" name="main_exp_dt">
<input type="hidden" name="eff_dt" >
<input type="hidden" name="exp_dt" >
<input type="hidden" name="edt_flg" >
<input type="hidden" name="sts_cd">
<input type="hidden" name="req_usr_flg" value="<%=repUsrFlg %>">
<input type="hidden" name="apro_usr_flg" value="<%=aproUsrFlg %>">
<input type="hidden" name="dur_dup_flg" >
<input type="hidden" name="dur_sub_dup_flg" >
<input type="hidden" name="srep_cd" value="<%=strUsr_ofc %>">
<input type="hidden" name="usr_id" value="<%=strUsr_id %>" >
<input type="hidden" name="lgcy_if_flg" value="<%=lgcyIfFlg%>">
<input type="hidden" name="save_gbn" >
<input type="hidden" name="save_scp" >
<input type="hidden" name="amendcancel_gbn" >
<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;MQC</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				
				<table class="search" border="0" style="width:600;"> 
				<tr class="h23">
					<td width="72">S/C No.</td>
					<td width="120">
						<input type="text" name="scNo1" style="width:52;text-align:center;" class="input2" value="<%=scNo1%>">&nbsp;<input type="text" name="scNo2" style="width:50;text-align:center;" class="input2" value="<%=scNo2%>"></td>
					<td width="60">AMD No.</td>
					<td width="60">
						<input type="text" style="width:40;text-align:center;" name="amdt_seq" class="input2" value="<%=amdtSeq %>">
					</td>
					<td width="80">Proposal No.</td>
					<td width="">
						<input type="text" style="width:104;text-align:center;" name="prop_no" class="input2" value="<%=propNo %>">
					</td>
				</tr></table>
				<table class="search" border="0" style="width:600;"> 
				<tr class="h23">
					<td width="72">SVC Scope</td>
					<td width="" style="padding-left:2;">
						<script language="javascript">ComComboObject('svc_scp_cd', 2, 52, 0, 1, 0, false);</script>&nbsp;<input type="text" style="width:368;" name="svc_scp_nm" class="input2" ></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:600;"> 
				<tr class="h23">
					<td width="72">Duration</td>
					<td width="240">
						<input type="text" style="width:75;" name ="dur_eff_dt" class="input2" >&nbsp;~&nbsp;<input type="text" style="width:75;" name ="dur_exp_dt" class="input2" ></td>
					<td width="80">S/C MQC</td>
					<td width="">
						<input type="text" style="width:55;text-align:right;" name = "sc_mqc" class="input2">&nbsp;<input type="text" style="width:45;" name = "unit" class="input2" ></td>
					</tr>
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
				

				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Retrieve">Retieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Save">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Amend">Amend</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_AmendCancel">Amend Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Accept">Accept</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_AcceptCancel">Accept Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
				</table>
			</td></tr>
			</table>
			
			
	    	<!-- Button_Sub (E) -->
			<table class="line_bluedot"><tr><td></td></tr></table>
		<!-- : ( Search Options ) (S) --> 
			
				<table class="search" border="0" style="width:600;"> 
					<tr class="h23">
						<td width="">
							<select name="selectMqc" style="width:90;"class="input2">								
								<option name="subMqc" value="0" selected></option>
								<option name="subMqc" value="1" >SUB MQC</option>
							</select>
						</td>					
				</tr></table>
<!-----div---->			
<div id="subDivMqc" style="display:none">	
					<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
					<!-- : ( Grid ) (E) -->	
		    <!-- : ( Button : Grid ) (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_New2">New</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete2">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Save2">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Amend2">Amend</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_AmendCancel2">Amend Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Accept2">Accept</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_AcceptCancel2">Accept Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
				</table>
			</td></tr>
			</table>			
	    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->


		
		
</td></tr>
</table> 
</div>
<!-----div end---->	


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_AcceptAll">Accept All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CancelAll">Accept Cancel</td>
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
		</table>
		</td></tr>
		</table>
	</td></tr>
	</table>
    <!--Button (E) -->

<!-- : ( Button : pop ) (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>