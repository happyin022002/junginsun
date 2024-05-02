<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0026.jsp
*@FileTitle : Allocation History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.10.29 주선영
* 1.0 Creation
* 2010.07.02 Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0026Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	
		event = (EsmSpc0026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		//out.println(e.toString());
		out.println("<!--"+e.toString()+"-->");

	}
	
	String ofc_cd	 = event.getSignOnUserAccount().getOfc_cd();
	String ofc_tp_cd = "";
	
	if (serverException == null) {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		ofc_tp_cd = eventResponse.getETCData("ofc_tp_cd");
	}
%>
<html>
<head>
<title>Allocation History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="JavaScript">
var ofc_cd = "<%=ofc_cd%>";
var ofc_tp_cd = "<%=ofc_tp_cd%>";
</script>

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
<input type="hidden" name="acct_clss" value="N">
<!-- 개발자 작업	-->
<!-- 단축키 설정을 위한 변수 -->
<input type="hidden" name="uiname" value="ESM_SPC_0026">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr><td class="btn1_bg">

							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new" alt="Alt+N">New</td><td class="btn1_right"></td></tr></table></td>

								<td class="btn1_line"></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>

					</td></tr>
				</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
				    <td width="35"><img class="nostar">VVD</td>
					<td width="130" style="padding-left:3"><input class="input1" type="input" name="vvd" value = "" size="12" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);" onchange="vvdChanged();" ></td>
					<td width="25"><input type="radio" class="trans" name="ioc" id="id_chk_ocn" onclick = " return chk_combo();" value="O" checked></td>
					<td width="30"><label for="id_chk_ocn">OCN</label></td>
					<td width="25"><input type="radio" class="trans" name="ioc" id="id_chk_ipc" onclick = " return chk_combo();" value="I"></td>
					<td width="30"><label for="id_chk_ipc">IPC</label></td>
					<td width="25"><input type="radio" class="trans" name="ioc" id="id_chk_ts" onclick = " return chk_combo();" value="T"></td>
					<td width="85"><label for="id_chk_ts">T/S by Office</label></td>
					<td width="25"><input type="radio" class="trans" name="ioc" id="id_chk_nycna" onclick = " return Clearcombo();" value="NYCRA"></td>
					<td width="70"><label for="id_chk_nycna">T/S NYCRA</label></td>
					<td width="25"><input type="radio" class="trans" name="ioc" id="id_chk_hamur" onclick = " return Clearcombo();" value="HAMRU"></td>
					<td width="120"><label for="id_chk_hamur">T/S HAMRU</label></td>
					<td width="40">Office</td>
					<td width="140" style="padding-left:3;"><script language="JavaScript">ComComboObject("salesOffice", 2, 106, 0);</script></td>
					<td width="80"><img class="nostar">Sub-Office</td>
					<td width="" style="padding-left:3;"><script language="JavaScript">ComComboObject("subOffice", 2, 80, 0);</script></td>



				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab" style="display:none">
           	<tr><td><script language="javascript">ComTabObject('tab1')</script>
		</table>
		

		<!-- UI_ESM_SPC_028 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_5"><tr><td></td></tr></table>

				<table class="" border="0" width="100%">
				<tr class="h23">
					<td></td>
					<td align="right">(Unit : TEU)</td>
					</tr>
				</table>

				<!-- : ( POR ) (S) -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t1sheet1');</script>
                        </td></tr>
		            </table>


				<!-- : ( POR ) (E) -->




			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</div>

<!-- UI_ESM_SPC_028_T2 : THIS IS 2st TAB -->
<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table width="100%">
				<tr>
				<td>
					<table cellpadding="0" cellspacing="0">
					<tr>
					<td>Data Selection : </td>
					<td width="5"></td>
					<td><input type="hidden" class="trans" name="chkDs2OFC" id="ds2OFC"  checked onclick="return changeDataSelection();"></td><td><label for="ds2OFC"></label></td>
				    <td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs2LocalIpi" id="ds2LocalIpi"  onclick="return changeDataSelection();"></td><td><label for="ds2LocalIpi">Local/IPI</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs2Acct" id="ds2Acct"  onclick="return changeDataSelection();"></td><td><label for="ds2Acct">ACCT</label></td>	    
				    <td width="5"></td>
				    <td><input  type="checkbox" class="trans" name="chkDs2POL" id="ds2POL"  onclick="return changeDataSelection();"></td><td><label for="ds2POL">POL</label></td>
					<td width="5" id="divDs2POD"></td>
					<td id="divDs2POD"><input type="checkbox" class="trans" name="chkDs2POD" id="ds2POD"   onclick="return changeDataSelection();"></td><td id="divDs2POD"><label for="ds2POD">POD</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs2Dest" id="ds2Dest"  onclick="return changeDataSelection();"></td><td><label for="ds2Dest">DEST</label></td>					
					<td width="5"></td>
					<td><input type = "hidden"  class="trans" name="chkDs2OTH" id="ds2OTH"  onclick="return changeDataSelection();"></td><td><label for="ds2OTH"></label></td>
					<td width="5"></td>
					<td><input  type="checkbox" class="trans" name="chkDs2D2" id="ds2D2"  onclick="return changeDataSelection();"></td><td><label for="ds2D2">D2</label></td>
					<td width="5"></td>
					<td><input  type="checkbox" class="trans" name="chkDs2D4" id="ds2D4"  onclick="return changeDataSelection();"></td><td><label for="ds2D4">D4</label></td>					
					<td width="5"></td>
					<td><input  type="checkbox" class="trans" name="chkDs2HC" id="ds2HC"  onclick="return changeDataSelection();"></td><td><label for="ds2HC">HC</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs245" id="ds245"  onclick="return changeDataSelection();"></td><td><label for="ds245">45</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs253" id="ds253"  onclick="return changeDataSelection();"></td><td><label for="ds253">53'</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs2RF" id="ds2RF"  onclick="return changeDataSelection();"></td><td><label for="ds2RF">RF</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs2RD" id="ds2RD"  onclick="return changeDataSelection();"></td><td><label for="ds2RD">RD</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" name="chkDs2WT" id="ds2WT"  onclick="return changeDataSelection();"></td><td><label for="ds2WT">WT</label></td>
					<td width="5" style="display:none;"></td>
					<td style="display:none;"><input type="checkbox" class="trans" name="chkDs2MDL" id="ds2MDL"  onclick="return changeDataSelection();"></td><td style="display:none;"><label for="ds2MDL">MDL</label></td>

					</tr></table>
				</td>
				<td align="right" id="sheetControlDiv">
					<img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="t1sheet2" type="N" onclick="toggleSheetSize();">
				</td>
				</tr>
				</table>

				<!-- : ( POR ) (S) -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t1sheet2');</script>
                        </td></tr>
		            </table>


				<!-- : ( POR ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</div>

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
