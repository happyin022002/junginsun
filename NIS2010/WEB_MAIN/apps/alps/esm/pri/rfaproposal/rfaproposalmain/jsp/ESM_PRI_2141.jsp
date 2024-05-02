<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2141.jsp
*@FileTitle : RFA  Amendment History 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.21 공백진
* 1.0 Creation
=========================================================
* History
* 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만 자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
* 2012.06.27 서미진[CHM-201217633] 구주 Hinterland Operation 개선 Project : Rate (For AEE/AEW), Arbitrary (For AEE/AEW) 탭 화면 추가
* 2012.11.07 이은섭[CHM-201220395] Add-On Tariff 개선 Project : Rate (For AddOn), Arbitrary (For AddOn) 탭 화면 추가
* 2013.12.20 서미진 [선처리 CSR] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청 
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2041Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmPri2041Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
    String rfaNo = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc		= "";
	String strUsrSrepCd     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAProposalMain");
	String[] termType = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strRhq_ofc = account.getRhq_ofc_cd();
	    strUsrSrepCd = account.getSrep_cd();
		event = (EsmPri2041Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		termType = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("termType"), false);
		
        rfaNo = StringUtil.xssFilter(request.getParameter("rfa_no_2043"));
				
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RFA  Amendment History</title>
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
<input type="hidden" name="in_rhq_ofc_cd" value="<%=strRhq_ofc%>">
<input type="hidden" name="in_usr_srep_cd" value="<%=strUsrSrepCd%>">
<input type="hidden" name="in_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="prop_no">
<!--  2043 에서 팝업 호출시 사용-->
<input type="hidden" name="rfa_no_2043" value="<%=rfaNo%>">

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
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
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
					<td width="70">RFA No.</td>
					<td width="150"><input type="text" style="width:100;text-align:center;" class="input1" name="rfa_no" dataformat="engup" maxlength="11" onKeyDown="ComKeyEnter('NextFocus')"></td>
					<td width="65">AMD No.</td>
					<td width="80"><input type="text" style="width:40;text-align:center;" class="input2" name="amdt_seq" readonly></td>
					<td width="70">SVC Scope</td>
					<td width="290" style="padding-left:2px;"><script language="javascript">ComComboObject('svc_scp_cd', 2, 50, 0 , 0);</script>
						&nbsp;<input type="text" style="width:220;" class="input2" name="svc_scp_nm" readonly caption="Service Scope Name"></td>
						
					
					<td width="50">Duration</td>
					<td align="right"><input type="text" style="width:80;text-align:center;" class="input2" name="ctrt_eff_dt" readonly maxlength="10" dataformat="ymd">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:80;text-align:center;" class="input2" name="ctrt_exp_dt" readonly maxlength="10" dataformat="ymd"></td>
				</tr>
				</table>
				
				<!-- CHOI START -->
				<div id="spot_guide_00"   style="display:none">
				<table class="search" border="0" style="width:979;">
			    <tr class="h23">
					<td width="65">Customer</td>
					<td width="270"><input type="text" style="width:220;" class="input2" name="ctrt_pty_nm" readonly></td>
					<td width="70">RFA Type</td>
					<td width="197"><input type="text" style="width:148;text-align:center;" class="input2" name="rfa_ctrt_tp_cd" readonly></td>
					<td width="70">By Item</td>
					<td width=""><script language="javascript">ComComboObject('term_type_cd', 1, 184, 0 , 0, 0);</script></td>
				</tr>	
				</table>
				</div>
				<!-- CHOI END -->
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
			<div id="tabLayer1" style="display:none">
			<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="250" src="about:blank"></iframe>
			</div>
            <div id="tabLayer2" style="display:none">
            <iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="250" src="about:blank"></iframe>
            </div>
            <div id="tabLayer3" style="display:none">
            <iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="250" src="about:blank"></iframe>
            </div>
            <div id="tabLayer4" style="display:none">
            <iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="700" src="about:blank"></iframe>
            </div>
            <div id="tabLayer5" style="display:none">
            <iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="700" src="about:blank"></iframe>
            </div>            
            <div id="tabLayer6" style="display:none">
            <iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="340" src="about:blank"></iframe>
            </div>               
            <div id="tabLayer7" style="display:none">
            <iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="340" src="about:blank"></iframe>
            </div>         
            <div id="tabLayer8" style="display:none">
            <iframe name="t8frame" id="t8frame" frameborder="0" scrolling="no" width="100%" height="340" src="about:blank"></iframe>
            </div>     
            <div id="tabLayer9" style="display:none">
            <iframe name="t9frame" id="t9frame" frameborder="0" scrolling="no" width="100%" height="340" src="about:blank"></iframe>
            </div>              
            <div id="tabLayer10" style="display:none">
            <iframe name="t10frame" id="t10frame" frameborder="0" scrolling="no" width="100%" height="540" src="about:blank"></iframe>
            </div>                                                            
            <div id="tabLayer11" style="display:none">
            <iframe name="t11frame" id="t11frame" frameborder="0" scrolling="no" width="100%" height="700" src="about:blank"></iframe>
            </div>              
            <div id="tabLayer12" style="display:none">
            <iframe name="t12frame" id="t12frame" frameborder="0" scrolling="no" width="100%" height="340" src="about:blank"></iframe>
            </div>                                                            
			<!-- iFrame (E) -->		
<table class="height_10"><tr><td></td></tr></table>
		

	</td></tr>
		</table>



 <!-- 개발자 작업  끝 -->
</form>
</body>
</html>