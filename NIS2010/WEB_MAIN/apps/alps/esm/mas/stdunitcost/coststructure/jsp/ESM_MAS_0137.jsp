<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0137.jsp
*@FileTitle : Node/Link U/C Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.07.31 임옥영
* 1.0 Creation
2009.10.29 system1관련 권한 삭제, 소스정리
2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
	             CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2013.06.24 성미영 [CHM-201325332] [MAS] 본사 조직 변경 관련 MAS 변경 사항
* 2014.04.16 박다은 [CHM-201429852] [MAS] SELCOT, SELCON 조직 변경(추가) 관련 MAS 관련 작업 요청
* 2014.08.27 박은주 [CHM-201431751] [MAS] Link U/C Adjustment 조회/입력조건의 Vendor 추가요청(S/P NO)
*                  Volume incentive cost 단가의 경우 Vendor 별로 관리한다.
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd       = "";

	Logger log = Logger.getLogger("com.hanjin.apps.StdUnitCost.CostStructure");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		//strOfc_cd = "SELCTY";

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Node/Link U/C Adjustment</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var combo01Text = "=|>|>=|<|<=|<>|LIKE|NOT LIKE|IN";
	var combo01Code = "=|>|>=|<|<=|<>|LIKE|NOT LIKE|IN";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		sheetObjects[0].SelectCell(2, 3);
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form"  onKeyUp="ComKeyEnter(); ">  <!--  onKeyDown="keyEnter_rslt();"  --> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
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
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
					<%
						//CDA, COL, CTY 에만 권한, admin
						//[CHM-201429852] [MAS] SELCOT, SELCON 조직 변경(추가) 관련 MAS 관련 작업 요청
						if( "SELOPA".equals(strOfc_cd)|| "SELOPB".equals(strOfc_cd)
						||"SELCTY".equals(strOfc_cd)|| "SELCSG".equals(strOfc_cd)|| "SELAPM".equals(strOfc_cd)
						|| "SELCON".equals(strOfc_cd)) {
					%>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_save" name="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<%
					}
					%>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_loadexcel" name="btn_loadexcel">Load Excel</td><td class="btn1_right"></td></tr></table></td>
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
                    <table class="search_in" border="0">
                      <tr class="h23">
                        <td width="15%"><img class="nostar">Node / Link Cost</td>
                        <td>
							<select name="f_table_name" class="input1" style='width:200' onChange="loadPage()">
								<OPTION value='MAS_NOD_AVG_STND_COST'>Node Cost</OPTION>
								<OPTION value='MAS_LNK_AVG_STND_COST'>Link Cost</OPTION>
							</select>
                        </td>
                      </tr>
                    </table>
                    <!-- : ( Year ) (E) -->
                  </td>
                </tr>
              </table>
              <!-- TABLE '#D' : ( Search Options ) (E) -->

              <table class="height_10"><tr><td></td></tr></table>

              <!-- TABLE '#D' : ( Search Options ) (S) -->
              <table class="search">
                <tr>
                  <td class="bg">
                    <table class="height_10">
                      <tr class="h23">
                        <td><img src="/hanjin/img/ico_star.gif" border="0" hspace="5">Condition Input</td>
                      </tr>
                    </table>


                    <!-- Condition -->
                    <table width="100%" id="mainTable">
                      <tr>
                        <td width="34%">
                          <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                        <td width="2%">

                        </td>
                        <td width="64%">
                          <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                      </tr>
                    </table>
                    <!-- Condition -->
                  </td>
                </tr>
              </table>
              <!-- TABLE '#D' : ( Search Options ) (E) -->

              <table class="height_10"><tr><td></td></tr></table>
              <!-- TABLE '#D' : ( Search Options ) (S) -->
              <table class="search">
                <tr>
                  <td class="bg">
                    <!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                      <tr>
                        <td>
                          <script language="javascript">ComSheetObject('sheet3');</script>
                        </td>
                      </tr>
                    </table>
                    <!-- : ( POR ) (E) -->
					<!-- : ( Button : Grid ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
		
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowdel" name="btng_rowdel">Row Del.</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
		
							</tr>
						</table>
						</td></tr>
					</table>
			    	<!-- : ( Button : Grid ) (E) -->
            <table width="100%" border="0">
              <tr class="h23">
                <td class="gray_tit" style="padding-left:0px;"><img src="/hanjin/img/ico_star.gif">&nbsp;<strong>Remark</strong></td>
              </tr>
              <tr class="h23">
                <td class="gray_tit" >
                  <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
                       Maximum to retrieve is 10,000 rows and Maximum to save is 200 rows.<br>
                  <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
                       "VNDR_SEQ" and "S/P no" conditions are only applicable for TRS volume incentive cost codes starting with "TRFX". <br>
                </td>
              </tr>
            </table>			    	
                  </td>
                </tr>
              </table>
              <!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>