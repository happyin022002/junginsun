<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VOP_OPF_0410.jsp
*@FileTitle : Port Time KPI Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.06
* 1.0 Creation
* 2012.02.06 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
* 2012.07.11 문동선 [CHM-201218855-01] Base line 입력화면 추가 / Dashboard에 반영
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event.VopOpf0410Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0410Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strOfc_cd = "";

	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strOfc_cd = account.getOfc_cd();

		event = (VopOpf0410Event)request.getAttribute("Event");
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
<title>Port Time KPI Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var userOfcCd = "<%=strOfc_cd%>";
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
					<td width="">
						<table class="search_sm2" border="0" style="width:180;"> 
							<tr>
								<td width="" class="input" style="font-size:12;">&nbsp;
									<input type="radio" class="trans" name="tab_chk" value="KPI" checked>KPI Year&nbsp;&nbsp;&nbsp;
									<input type="radio" class="trans" name="tab_chk" value="BSEL">&nbsp;Base line
								</td>
							</tr>
						</table>	
					</td>
					
					<td width="100"><div id="kpi_yr" name="kpi_yr" style="display:block">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; KPI Year</div><div id="bsel_yr" style="display:none">Pre-Year PFMC</div></td>
					
					<td width="180">
							<script language="javascript">ComComboObject('kpi_tgt_yr', 1, 70, 0, 1);</script>&nbsp;
							<script language="javascript">ComComboObject('kpi_ver_seq', 1, 50, 1, 1);</script></td>
								
					<td width="38"> Lane</td>
					<td width="130"><script language="javascript">ComComboObject('slan_cd', 1, 70, 0);</script></td>
					<td width="38"> RHQ</td>
					<td width="121"><script language="javascript">ComComboObject('rhq_cd', 1, 70, 0);</script></td>
					<td width="38">Port</td>
                	<td width=""><script language="javascript">ComComboObject('vps_port_cd', 1, 70, 0);</script></td>
				</tr>	
				</table>
				<!--  biz_1   (E) -->			
			</td>
			</tr>	
			</table>
				
				
		
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	<table width="100%"  class="search"> 
       	<tr><td class="bg">
				<!-- Grid (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->	
	
	<!--  Button (S) -->
	
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
  <tr>
    <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_retrieve">Retrieve</td>
                <td class="btn1_right"></td>
              </tr>
            </table></td>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_creation">Creation</td>
                <td class="btn1_right"></td>
              </tr>
            </table></td>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_new">New</td>
                <td class="btn1_right"></td>
              </tr>
            </table></td>
          <td class="btn1_line"></td>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_delete">Delete</td>
                <td class="btn1_right"></td>
              </tr>
            </table></td>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_save">Save</td>
                <td class="btn1_right"></td>
              </tr>
            </table></td>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_downExcel">Down Excel</td>
                <td class="btn1_right"></td>
              </tr>
            </table></td>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_loadExcel">Load Excel</td>
                <td class="btn1_right"></td>
              </tr>
            </table></td>
        </tr>
      </table></td>
  </tr>
</table>


    <!-- Button (E) -->
	</td></tr>
	</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
	   		<div style="display:none;">
	   		<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
			</table>
			<!-- Grid (E) -->
			</div>
	
	</td></tr>
	</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>