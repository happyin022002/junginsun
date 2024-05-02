<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0057_17.jsp
*@FileTitle : Amendment History Inquiry - Customer Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.09.17 박성수
* 1.0 Creation

2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.event.EsmPri005717Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri005717Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = ""; 
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCContractPartyProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri005717Event)request.getAttribute("Event");
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
<title>Amendment History Inquiry - Customer Type</title>
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
<input type="hidden" name="cd">
<input type="hidden" name="prop_no">
<input type="hidden" name="amdt_seq">
<input type="hidden" name="prc_ctrt_pty_tp_cd" value="C">
<input type="hidden" name="lgcy_if_flg">
<input type="hidden" name="con_flg">
<table class="search" id="mainTable"> 
     		<tr><td class="bg">	
              <!--Button (S) -->
              <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
              <tr>
                  <td class="btn1_bg">

                  <table border="0" cellpadding="0" cellspacing="0">
                  <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr><td class="btn1_left"></td>
                          <td class="btn1" name="btn_retrieve">Retrieve</td>
                          <td class="btn1_right"></td>
                          </tr>
                      </table></td>
                      </tr>
                  </table>
              </td></tr>
              </table>
              <!--Button (E) -->

	<!-- Grid  (S) -->
		<table width="100%"  id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
		
	<!-- Grid (E) -->		
	
	</td></tr>
</table>
<!--biz page (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>