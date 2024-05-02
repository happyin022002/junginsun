<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VOP_OPF_0405.jsp
*@FileTitle : Port Time Activity Creation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.08
* 1.0 Creation
* 2012.02.08 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
* 2012.05.03 조경완 [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event.VopOpf0405Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0405Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strOfc_cd = "";
	String strOprStopCd = "";
	String strInitDataCd = "";

	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strOfc_cd = account.getOfc_cd();

		event = (VopOpf0405Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strOprStopCd  = eventResponse.getETCData("OPR_STOP_CD");
		strInitDataCd = eventResponse.getETCData("INIT_DATA_CD");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Port Time KPI Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var oprStopCd  = "<%=strOprStopCd%>";
	var initDataCd = "<%=strInitDataCd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="clpt_ind_seq">
<input type="hidden" name="act_gen_cd_id">
<input type="hidden" name="vps_port_cd"> <!--  실제 vps_port_cd parameter 값  -->

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
					<td width="50">VVD</td>
					<td width="180"><!-- required fullfill  -->
						<input type="text" style="width:40;" class="input1" name="vsl_cd" caption="Vessel Code" maxlength="4" dataformat="engup" style="ime-mode:disabled; text-align:center;">
						<input type="text" style="width:38;" class="input1" name="skd_voy_no" caption="Schedule Voyage Number" maxlength="4" dataformat="engup" style="ime-mode:disabled; text-align:center;">
						<input type="text" style="width:22;" class="input1" name="skd_dir_cd" caption="Schedule Direction Code" maxlength="1" dataformat="engup" style="ime-mode:disabled; text-align:center;">
						<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_searchVvd">
						
					</td>
					<td width="50">Port</td>
					<td width="">
						<script language="javascript">ComComboObject('vps_port_cd_1', 3, 100, 0,1,2);</script></td>
				</tr>
				<tr class="h23">
					<td width="50">Lane</td>
					<td width=""><input type="text" style="width:40;" class="input2" name="slan_cd" style="text-align:center;" readonly></td>
				</tr>	
				</table>
				<!--  biz_1   (E) -->			
			</td>
			</tr>	
			</table>
				
   			<table class="height_8"><tr><td></td></tr></table>
			<!-- Tab (S) -->
    			<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
			<!-- Tab (E) -->
		
			<!-- Grid BG Box  (S) -->
	     	<table width="100%"  class="search"> 
	       	<tr><td class="bg">
	       		<!--  Tab_1 (S) -->
				<div id="tabLayer" style="display:inline">
				<table class="search">
   					<tr>
   						<td>
							<!-- Grid (S) -->
							<table width="100%" id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t1sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</td>
					</tr>
				</table>
				</div>
				<!--  Tab_1 (E) -->
				<!--  Tab_2 (S) -->
				<div id="tabLayer" style="display:none">
				<table class="search">
   					<tr>
   						<td>
							<!-- Grid (S) -->
							<table width="100%" id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t2sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</td>
					</tr>
				</table>
				</div>
				<!--  Tab_2 (E) -->
	
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
                <td class="btn1" name="btn_new">New</td>
                <td class="btn1_right"></td>
              </tr>
            </table></td>
          <td class="btn1_line"></td>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_save">Save</td>
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
					<script language="javascript">ComSheetObject('tmpsheet1');</script>
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