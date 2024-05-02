      <%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SAM_0002.jsp
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.20
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.05.20 박찬민
* 1.0 Creation
* 2015.07.07 이윤정 [CHM-201536740] COA 내 화면의 조회 기능 (Retrieve, Down Excel)을 뺀 나머지 버튼들을 비활성화 요청 CSR
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.stdunitcost.averagerpb.event.EsmCoa0183Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0183Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.StatusReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0183Event)request.getAttribute("Event");
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
<title>Avg RPB</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
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
<input type="hidden" name="tab_item">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Avg RPB</td></tr>
		</table>

	<!--Page Title, Historical (E)-->
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       		<tr>
       			<td class="btn1_bg">
		    		<table border="0" cellpadding="0" cellspacing="0">
		    			<tr><td>
		    				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<!--  
						<td>
		    				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Creation">Creation</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						-->
						<td>						
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_DownExcel">Down Excel</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td></tr>
					</table>
				</td>
			</tr>
		</table>
		<!--Button (E) -->
	

		<!--biz page (S)-->
      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_1 (S) -->
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr class="h23">
              <td width="27%"><table border="0">
              <tr class="h23">
                <td width="5%" class="h18">YYYY-MM</td>
                	<td width="5%"><input type="text" class="input1" name="f_rpb_yrmon" style="width:60" maxlength="7"
                 					onKeyPress="ComKeyOnlyNumber(window)" onChange="setPeriod(this);"
                					onBlur="addDash(this , 4);" 
                					onFocus="this.value=ComReplaceStr(this.value, '-', '');" >
	                </td>
	                <td width="10%" class='sm'><div id='div_period'></div></td>
	                </tr>
                </table></td>
                
                <td width="72%"><table >
                 <tr class="h23">
                <td width="10%" style="padding-left:2px;" id="f_trd_cd">Trade&nbsp;
                	<script language="javascript">ComComboObject('f_trd_cd', 1, 70, 1)</script>
                </td>
                <td width="10%" style="padding-left:2px;" id="f_rlane_cd">Lane&nbsp;
                	<script language="javascript">ComComboObject('f_rlane_cd', 1, 70, 1)</script>
                </td>
                <td width="10%" style="padding-left:2px;" id="f_ioc_cd">IOC&nbsp;
                	<script language="javascript">ComComboObject('f_ioc_cd', 1, 70, 1)</script>
                </td>
                
                <td width="10%" id="f_bkg_por_cd">POR&nbsp;<input type="text" class="input" name="f_bkg_por_cd" style="width:60" maxlength="5"></td>
                <td width="10%" id="f_bkg_del_cd" >DEL&nbsp;<input type="text" class="input" name="f_bkg_del_cd" style="width:60" maxlength="5"></td>
                
                <td width="10%" id="f_bkg_por_scc_cd">POR SCC&nbsp;<input type="text" class="input" name="f_bkg_por_scc_cd" style="width:60" maxlength="5"></td>
                <td width="10%" id="f_bkg_del_scc_cd">DEL SCC&nbsp;<input type="text" class="input" name="f_bkg_del_scc_cd" style="width:60" maxlength="5"></td>
                
                <td width="10%" style="padding-left:2px;" id="f_dir_cd">Direction&nbsp;
                	<script language="javascript">ComComboObject('f_dir_cd', 1, 70, 1)</script>
                </td>
                <td width="10%" style="padding-left:2px;" id="f_cntr_tpsz_cd">Type/Size&nbsp;
                	<script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 70, 1)</script>
                </td>
                </tr>
                </table></td>

              </tr>
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>
      
	<table class="height_8"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
				</td>

			</tr>
			</table>
		<!-- Tab (E) -->

<!--TAB Master B/L (S) -->

<div id="tabLayer" style="display:inline">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable2">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->		
			<table class="search" border="0">
									<tr><td height="18"><img src="/hanjin/img/ico_star.gif" border="0" hspace="3" align="absmiddle"><strong>Remark</strong></td></tr>
									<tr><td style="padding-left:11;" class="sm">
										<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
										Customer RPB” is created automatically after 2 P.M on last Friday of each month.</td></tr>
										</table>
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>

<!--TAB Master B/L (E) -->


<!--TAB House B/L (S) -->

<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable2">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->		
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>

<!--TAB House B/L (E) -->

<!--TAB House B/L (S) -->

<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable2">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->		
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>

<!--TAB House B/L (E) -->

<!--TAB House B/L (S) -->

<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable2">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->		
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>

<!--TAB House B/L (E) -->

<!--TAB House B/L (S) -->

<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable2">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t5sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->		
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>


	</td></tr>
		</table>
	



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               