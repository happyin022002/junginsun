<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0121.jsp
* @FileTitle : SML Slot Swap information By VVD
* Open Issues :
* Change history :
* @LastModifyDate : 2007-01-18
* @LastModifier : Park Eun Ju
* @LastVersion : 1.0
*  2007-01-05 Park Eun Ju
*  1.0 최초 생성
=========================================================
* History :
* 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2009.10.08 남궁진호 ALPS 전환작업  1.0 Creation
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event.EsmBsa0104Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String header = "";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BSAManage.SPCManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		CommonBsaRsVO retVo = (CommonBsaRsVO)eventResponse.getCustomData("retVo");
		header = retVo.getStrTemp();
			
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>SML Slot Swap Information By VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	var saveStatus = false;
	function Exit() {
		//(saveStatus + " : " + self.screenTop);
	    if (self.screenTop > 9000) {
	    	if(saveStatus){
	    		opener.parentExecute();
	    	}
	    	//self.close();
	    	//opener.location.href=opener.document.location;
	    }
	}
</script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=header%>");
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="flag">
<input type="hidden" name="chgValueRowNo">

<input type="hidden" name="pPort_etd_dt"   value="<%= JSPUtil.getNull(request.getParameter("pPort_etd_dt")) %>">
<input type="hidden" name="pTrd_cd"     value="<%= JSPUtil.getNull(request.getParameter("pTrd_cd")) %>">
<input type="hidden" name="pRlane_cd"   value="<%= JSPUtil.getNull(request.getParameter("pRlane_cd")) %>">
<input type="hidden" name="pVsl_cd"     value="<%= JSPUtil.getNull(request.getParameter("pVsl_cd")) %>">
<input type="hidden" name="pSkd_voy_no" value="<%= JSPUtil.getNull(request.getParameter("pSkd_voy_no")) %>">
<input type="hidden" name="pDir_cd"     value="<%= JSPUtil.getNull(request.getParameter("pDir_cd")) %>">
<input type="hidden" name="sRow"        value="<%= JSPUtil.getNull(request.getParameter("sRow")) %>">
<input type="hidden" name="pBsa_op_jb_cd"        value="<%= JSPUtil.getNull(request.getParameter("pBsa_op_jb_cd")) %>">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;SML Slot Swap Information By VVD</td></tr>
		</table>
            <!-- : ( Title ) (E) -->
            <!-- : ( Search Options ) (S) -->
            <table class="search">
                <tr>
                    <td class="bg">
                        <!-- : ( Grid ) (S) -->
                        <table width="100%" id="mainTable">
                            <tr>
                                <td>
                                <script language="javascript">ComSheetObject('sheet');</script>
                                </td>
                            </tr>
                        </table>
                        <!-- : ( Grid ) (E) -->
                    </td>
                </tr>
            </table>
            <!-- : ( Search Options ) (E) -->
        </td>
    </tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_10"><tr><td></td></tr></table>
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton" >
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->
				</tr></table></td>
				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>