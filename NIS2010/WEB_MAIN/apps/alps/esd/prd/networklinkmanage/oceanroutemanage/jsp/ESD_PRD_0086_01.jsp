<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0086_01.jsp
*@FileTitle : Verification Rule
*Open Issues :
*Change history :
*@LastModifyDate : 2011-12-06
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2011.12.06 변종건 [CHM-201114917-01] Ocean Route Upload Excel 신규 기능 추가건
=========================================================*/
--%> 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd008601Event"%>

<%
	EsdPrd008601Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	try {

	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();



		event = (EsdPrd008601Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Ocean Route Creation – Verification Rule</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();

//		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

	}
</script>
</head>


<body onload="javascript:setupPage();">
<form method="post" name="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top"><!-- : ( Title ) (S) -->
      
      <table width="100%" border="0">
        <tr>
          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Verification Rule</td>
        </tr>
      </table>
      
      <!-- : ( Title ) (E) --> 
      
      <!-- : ( Search Options ) (S) -->
      
      <table class="search">
        <tr>
          <td class="bg"><!-- : ( Grid ) (S) -->
            
            <table width="100%" class="grid">
              <tr class="tr_head">
                <td width="171">Error Type</td>
                <td width="578">Description</td>
              <tr>
                <td class="tr_head2">Port Code Error</td>
                <td>Port code is not registered in MDM</td>
              </tr>
              <tr>
                <td class="tr_head2">Lane  Code Error</td>
                <td>Lane code is not registered in MDM</td>
              </tr>
              <tr>
                <td class="tr_head2">Lane P/F SKD Error</td>
                <td>there is no activated lane P/F Type/SKD</td>
              </tr>
              <tr>
                <td class="tr_head2">Link Error</td>
                <td>There is no registered HQ Link(Truck) or RHQ Link(FDR) Link</td>
              </tr>
              <tr>
                <td class="tr_head2">POD Overlap Error</td>
                <td>Even one of T/S Ports can't be same with final POD</td>
              </tr>
              <tr>
                <td class="tr_head2">Canal Code Error</td>
                <td>Canal Code(EGSUZ, PAPAC) can't be input</td>
              </tr>
              <tr>
                <td rowspan="2" class="tr_head2">Optimization Error(1)</td>
                <td>Country of POL in Trunk lane and Country of POD in Feeder lane can't be same</td>
              </tr>
              <tr>
                <td><img src="/hanjin/img/alps/esd_prd_0086_01_e1.jpg" width="691" height="63"></td>
              </tr>
              <tr>
                <td rowspan="2" class="tr_head2">Optimization Error(2)</td>
                <td>Country of POL in Feeder lane and Country of POD in Truck lane can't be same</td>
              </tr>
              <tr>
                <td><img src="/hanjin/img/alps/esd_prd_0086_01_e2.jpg" width="691" height="63"></td>
              </tr>
              <tr>
                <td class="tr_head2">Optimization Error(3)</td>
                <td><font style="line-height:200%">Ocean Link between same country can't be input except CN, AE.<br>&nbsp;Please use the 'MANUAL Creation' function.</font></td>
              </tr>
              <tr heigth="50">
                <td class="tr_head2">Return Shipment Error</td>
                <td><font style="line-height:200%">Return Shipment can't be registered through 'Upload Excel' function.<br>&nbsp;Please use the 'Manual Creation' function.</font></td>
              </tr>
              <tr>
                <td rowspan="2" class="tr_head2">Temporary Flag Error</td>
                <td>Temporary Ocean Flag should have Reason Type in Remark column.</td>
              </tr> 
              <tr>
                <td><img src="/hanjin/img/alps/esd_prd_0086_01_e3.jpg" width="225" height="180"></td>
              </tr>
              <tr>
                <td class="tr_head2">Ocean Flag Error</td>
                <td>Only 2 kinds of flag (Standard, Temporary) can be input</td> 
              </tr>
              <tr>
                <td class="tr_head2">Transit Time Error</td>
                <td>Total Transit Time can't be over 50 days</td>
              </tr>
              <tr>
                <td class="tr_head2">Trans-shipment Error</td>
                <td>To make T/S Route, T/S Port and Lane by each sequence should be input together</td>
              </tr>
              <tr>
                <td class="tr_head2">Duplication Error</td>
                <td>The same route has already been registered.</td>
              </tr>
              <tr>
                <td class="tr_head2">The others Error</td>
                <td ><font style="line-height:200%">The route just about to be uploaded is ambiguous.<br>&nbsp;Please check whether the route is correct or contact COL - TN</font></td>
              </tr>
            </table>
            
            <!-- : ( Grid ) (E) --> 
            <!-- : ( Button : Grid ) (S) --> 
            <!--  Button_Sub (S) --><!-- Button_Sub (E) --> 
            <!-- : ( Button : Grid ) (E) --></td>
        </tr>
      </table>
      <table class="height_5">
        <tr>
          <td></td>
        </tr>
      </table>
      
      <!-- : ( Search Options ) (E) --></td>
  </tr>
</table>
 
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="46" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                
                <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!--Button (E) --></td>
  </tr>
</table>
<!-- : ( Button : pop ) (E) -->
 
</body>

</html>
