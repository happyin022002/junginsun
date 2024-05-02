<%
/*========================================================= 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0051.jsp
*@FileTitle  : Representative Charge
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.report.event.BcmCcd0051Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    BcmCcd0051Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.bcm.ccd.commoncode.account");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (BcmCcd0051Event)request.getAttribute("Event");
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

<head>
<title>Representative Charge</title>


<script type="text/javascript">
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->
 	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
  	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

<!-- page_title_area(E) -->

          <!--biz page (S)-->
	    <table class="search" id="mainTable"> 
	      <tr>
	        <td class="bg">
	          <!--  biz_1  (S) -->
	          <table class="search" border="0" style="width:989;"> 
	          <tr class="h23">
	            <td>
	              <table class="search" border="0">
	                <tr class="h23">
                    <td width="80" >Office Kind</td>
					<td width="120"><script type="text/javascript">ComComboObject('ofc_kind_cd', 1, 100, 1, 0 ,0 ,false)</script></td>
					<td width="80" >Office Code</td>
					<td width="120"><input type="text" style="width:82px;ime-mode:disabled;text-align:center;" class="input" value="" name="ofc_cd" maxlength="6" dataformat="engup" id="ofc_cd" />
					<img src="img/btns_search.gif" name="btn_com_ens_071_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" id="btn_com_ens_071_ofc_cd">
			 </td>		
			<td width="60">Status</td>
			<td><select style="width:100px; " class="input2" name="status_cd"><!-- 
			 --><option value="" disabled="disabled">ALL</option><!-- 
	         --><option value="Y" selected>Active</option><!-- 
	 		 --><option value="N" disabled="disabled">Delete</option></select></td>		
		</tr>
	</table>	
	      </td>
		</tr>
	</table>
</tr>
</table>

    <table class="height_8"><tr><td></td></tr></table>  
    <div id="tabLayer" style="display:inline">
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">  
      
            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- Grid (E) -->  
          </td>
        </tr>
      </table>
      <!--biz page (E)-->
    </div>
     <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_Retrieve">Retrieve</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
                 <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_DownExcel">Down Excel</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_New">New</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
 		</tr>
 	</table>
    <!--TAB Unmatch (E) -->
</form>
</body>