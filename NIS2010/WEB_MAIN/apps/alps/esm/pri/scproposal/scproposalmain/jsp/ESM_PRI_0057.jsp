<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0057.jsp
*@FileTitle : Amendment History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.08 공백진
* 1.0 Creation
*=========================================================
* History :
* 2011.03.30 이관샨 [CHM-201109657-01] Amend history 에서 과거 Amendment Print 기능 추가(btn_print 버튼 생성)
* 2011.11.18 서미진 [CHM-201114462] SC No. 를 한칸으로 변경하여 copy & paste 기능 이용 할 수 있도록 정정요청
* 2015.06.16 최성환 [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0057Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmPri0057Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsrSrepCd     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCProposalMain");
	String[] termType = null;
	String scNo0062 = "";
	
	//		account.getSrep_cd()
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    strUsrSrepCd = account.getSrep_cd();
		event = (EsmPri0057Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		termType = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("termType"), false);
		//0004,0062에서 호출		
		scNo0062 = StringUtil.xssFilter(request.getParameter("sc_no_0062"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Amendment History Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var termTypeComboValue = " |<%=termType[0]%>";
    var termTypeComboText = " |<%=termType[1]%>";
    
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
<input type="hidden" name="in_usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="in_usr_srep_cd" value="<%=strUsrSrepCd%>">
<input type="hidden" name="in_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="prop_no">
<input type="hidden" name="lgcy_if_flg">
<input type="hidden" name="in_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="ofc_auth_yn">
<input type="hidden" name="req_usr_flg">

<!--  0062 에서 팝업 호출시 사용-->
<input type="hidden" name="sc_no_0062" value="<%=scNo0062%>">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
								
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="70">S/C No.</td>
					<td width="150"><input type="text" style="width:135; text-align: center; " class="input1" name="sc_no" maxlength="9" class="input" dataformat="engup"></td>
					<td width="65">AMD No.</td>
					<td width="60"><input type="text" style="width:40;text-align:center;" class="input2" name="amdt_seq" readonly></td>
					<td width="65">Customer</td>
					<td width="230"><input type="text" style="width:217;" class="input2" name="ctrt_pty_nm" readonly></td>
					<td width="50">Duration</td>
					<td><input type="text" style="width:80;text-align:center;" class="input2" name="ctrt_eff_dt" readonly maxlength="10" dataformat="ymd">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:80;text-align:center;" class="input2" name="ctrt_exp_dt" readonly maxlength="10" dataformat="ymd"></td>
				</tr>
				<tr class="h23">
					<td>SVC Scope</td>
					<td colspan="5" style="padding-left:2px;">
						<script language="javascript">ComComboObject('svc_scp_cd', 2, 50, 0 , 0);</script>
						&nbsp;<input type="text" style="width:503;" class="input2" name="svc_scp_nm" readonly caption="Service Scope Name"></td>
					<td>By Item</td>
					<td style="padding-left:2"><script language="javascript">ComComboObject('term_type_cd', 1, 186, 0 , 0, 0);</script>
					</td>
					<td width=""><input type="checkbox" name="con_flg" value="" class="trans" >Conversion</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->



		</td></tr></table>
		<!-- 1 (E) -->

		<!--biz page (S)-->
		<table class="height_8"><tr><td></td></tr></table>
		<!-- Tab ) (S) -->
 		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
   		<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- Tab ) (E) -->

			<!-- iFrame (S) -->
			<div id="tabLayer" style="display:none">
			<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
			</div>
            <div id="tabLayer" style="display:none">
            <iframe name="t2frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t3frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t4frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t5frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>               
            <div id="tabLayer" style="display:none">
            <iframe name="t6frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>         
            <div id="tabLayer" style="display:none">
            <iframe name="t7frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>     
            <div id="tabLayer" style="display:none">
            <iframe name="t8frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>               
            <div id="tabLayer" style="display:none">
            <iframe name="t9frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="680" src="about:blank"></iframe>
            </div>         
            <div id="tabLayer" style="display:none">
            <iframe name="t10frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>  
            <div id="tabLayer" style="display:none">
            <iframe name="t11frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>               
            <div id="tabLayer" style="display:none">
            <iframe name="t12frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>         
            <div id="tabLayer" style="display:none">
            <iframe name="t13frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>  
            <div id="tabLayer" style="display:none">
            <iframe name="t14frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>               
            <div id="tabLayer" style="display:none">
            <iframe name="t15frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>         
                                                      
			<!-- iFrame (E) -->		


<table class="height_10"><tr><td></td></tr></table>
		

	</td></tr>
		</table>






 <!-- 개발자 작업  끝 -->
</form>
</body>
</html>