<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : apps/enis/esm/coa/multidimensionrpt/sales/jsp/ESM_COA_0135.jsp
*@FileTitle      : STP Income/Cost Inquiry
*Open Issues     : Office Report-vs QTA 화멘에서 콜하는 PopUp 화면 입니다.
*Change history  :
*@LastModifyDate : 2007-04-06
*@LastModifier   : Ari
*@LastVersion    : 1.0
* 2007-04-06 Ari
* 1.0 최초 생성
'=========================================================================
' History :
' 2008.03.07 PEJ N200801154874 검색주건 추가 VVD, STP Income/Cost 선택항목 추가 
' 2008.03.07 PEJ N200802260011 STP Income 화면 수정 요청 
'                화면에 Income/Cost 각각을 선택적으로 볼수 있는 옵션 추가 및 VVD 항차별로 조회할수 있도록 검색조건추가
' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[135]
* 2009.10.06 김기식 Alps전환작업
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================================
*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	String userId   = "";
	String ofc_cd   = "";
	String ofc_lvl  = "";

	//부모창에서 받은 변수 f_year, f_wk, f_rhq_cd, f_sls_ofc_cd
	String f_year = "";
	String f_wk = "";
	String f_rhq_cd = "";
	String f_sls_ofc_cd = "";
	String f_vsl_cd = "";
	String f_skd_voy_no = "";
	String f_dir_cd = "";
	

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		userId = account.getUsr_id();
		ofc_cd = account.getOfc_cd();  //.getUserOffice2();
		ofc_lvl = account.getUsr_auth_tp_cd();  //.getUserLevel();		
		
		f_year =JSPUtil.getNull(request.getParameter("f_year"));
		f_wk =JSPUtil.getNull(request.getParameter("f_wk"));
		f_rhq_cd =JSPUtil.getNull(request.getParameter("f_rhq_cd"));
		f_sls_ofc_cd =JSPUtil.getNull(request.getParameter("f_sls_ofc_cd"));
		f_vsl_cd =JSPUtil.getNull(request.getParameter("f_vsl_cd"));
		f_skd_voy_no =JSPUtil.getNull(request.getParameter("f_skd_voy_no"));
		f_dir_cd =JSPUtil.getNull(request.getParameter("f_dir_cd"));	
		
//		N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조껀 SELHO.  1로 바꿔준다
		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}

%>

<html>
<head>
<title>STP Income/Cost Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setRetrieveAction();
	}
</script>
</head>

<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_ofc_cd" value="<%=ofc_cd %>">
<input type="hidden" name="f_ofc_lvl" value="<%=ofc_lvl %>">
<!-- 부모창의 폼값 -->
<input type="hidden" name="f_year1" value="<%=f_year%>">
<input type="hidden" name="f_wk1" value="<%=f_wk%>">
<input type="hidden" name="f_rhq_cd1" value="<%=f_rhq_cd%>">
<input type="hidden" name="f_sls_ofc_cd1" value="<%=f_sls_ofc_cd%>">
<input type="hidden" name="f_vsl_cd1" value="<%=f_vsl_cd%>">
<input type="hidden" name="f_skd_voy_no1" value="<%=f_skd_voy_no%>">
<input type="hidden" name="f_dir_cd1" value="<%=f_dir_cd%>">

<!-- OUTER - POPUP (S)tart -->
	<table width="100%" class="popup" cellpadding="10" border="0">
		<tr><td class="top"></td></tr>
		<tr>
	  		<td valign="top">  				  
			  <table width="100%" class="title">
				<tr>
				  <td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;STP Income/Cost Inquiry</td>
				 </tr>
			  </table>		
			  
			  <!-- TABLE '#D' : ( Button : Main ) (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			       	<tr><td class="btn1_bg">
		
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
		
						</tr></table>
		
					</td></tr>
				</table>
		        <!-- TABLE '#D' : ( Button : Main ) (E) -->		
			  
			  <!-- TABLE '#D' : ( Search Options ) (S) -->
			  <table class="search">
				<tr>
				  <td class="bg">
					<!-- : ( Year ) (S) -->
					<table class="search_in" border="0" style="width:100%;">
						<tr class="h23">
							<td width="5%" >&nbsp;&nbsp;Year</td>
							<td width="9%"><input type="text" style='width:40;text-align:center;' class='input1' name="f_year" maxlength="4" onKeyPress="ComKeyOnlyNumber(this)" onKeyUp="ComKeyEnter('LengthNextFocus');" onChange="setPeriod(this);" value="<%=f_year%>" disabled></td>
							<td width="5%">Week</td>
							<td width="8%"><input  type="text"  style='width:30;text-align:center;' class='input1' name="f_wk" maxlength="2" onKeyPress="ComKeyOnlyNumber(this)" onBlur="this.value=ComLpad(this, 2, '0');" onKeyUp="ComKeyEnter('LengthNextFocus');" onChange="this.value=ComLpad(this, 2, '0');setPeriod(this);" value="<%=f_wk%>" disabled></td>
							<td><div id="div_period">&nbsp;</div></td>
						</tr>
					 </table>
					<table class="search_in" border="0" style="width:100%;">
						<tr><td class="line_bluedot" style="height:11;"></td></tr>
					</table>
					<!-- : ( By Office ) (S) -->
					<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="9%" class="gray_tit"><img src="img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Office</td>
							<td width="8%">OFC Level</td>
							<td width="14%">
								<script language="javascript">ComComboObject('f_rhq_cd',1, 100 , 0 )</script>
							</td>
							<td width="4%">OFC</td>
							<td width="11%">
								<script language="javascript">ComComboObject('f_sls_ofc_cd',1, 80 , 0 )</script>
							</td>
                            <td width="4%">VVD</td>
                            <td width="14%">
                                <input type="text" style="width:40;" maxlength="4" name="f_vsl_cd" value="<%= f_vsl_cd %>" onKeyPress="ComKeyOnlyAlphabet('uppernum')" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled">
                                <input type="text" style="width:40;" maxlength="4" name="f_skd_voy_no" value="<%= f_skd_voy_no %>" onKeyPress="ComKeyOnlyNumber(this)" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled">
                                <input type="text" style="width:20;" maxlength="1" name="f_dir_cd" value="<%= f_dir_cd %>" onKeyPress="ComKeyOnlyAlphabet('upper');" style="ime-mode:disabled">
                            </td>
                            <td width="5%" align=center> BKG</td>
                            <td width="16%">
                                <input type="text" style="width:100;" maxlength="11" name="f_bkg_no" onblur="upper(this)">
                            </td>
                            <td width="14%">
                            	<input type="radio" class="trans" name="f_stp_flg" value="Y" onClick="viewControl('Y');"> STP Income 
                            	<input type="radio" class="trans" name="f_stp_flg" value="N" onClick="viewControl('N');" checked> STP Cost
                            </td>
                            <td>&nbsp</td>
						</tr>
					</table>
					<!-- : ( By Office ) (E) -->
					 <!-- : ( Year ) (E) -->
				  </td>
				</tr>
			  </table>
			  <!-- TABLE '#D' : ( Search Options ) (E) -->
			  <table class="height_10">
				<tr>
				  <td></td>
				</tr>
			  </table>
			  <!-- TABLE '#D' : ( Search Options ) (S) -->
			  <table class="search">
				<tr>
				  <td class="bg_b1">
					<table class="height_10">
					  <tr>
						<td></td>
					  </tr>
					</table>
					<!-- : ( POR ) (S) -->
					<table width="100%" id="mainTable">
					  <tr>
						<td>
						  <script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					  </tr>
					</table>
					<!-- : ( POR ) (E) -->
				  </td>
				</tr>
			  </table>
			  <!-- TABLE '#D' : ( Search Options ) (E) -->
			  <table class="height_10">
				<tr>
				  <td></td>
				</tr>
			  </table>
			  <!-- : ( Button : Sub ) (S) -->
			  <table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
			  <!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->
			</td>
		  </tr>
		</table>
		<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
		<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->
	
  <!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->

</form>
</body>
</html>