<%/*=========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : ESM_MAS_0272.jsp
 * @FileTitle : Full Storage Daily Calculation
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2015-01-29
  * @LastModifier :  
 * @LastVersion : 1.0
 *  2015-01-29 김종옥
 *  1.0 최초 생성
 =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event.EsmMas0115Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmMas0115Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";

	Logger log = Logger
			.getLogger("com.hanjin.apps.WeeklyPFMC.WeeklyCM");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmMas0115Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

	} catch (Exception e) {
		log.error("Exception : " + e.toString());
	}
%>
<html>
<head>
<title>Full Storage Daily Calculation</title>
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
<body  onload="javascript:setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td>
                      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
                          <td class="btn1_left"></td>
                          <td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
                          <td class="btn1_right"></td>
                        </tr>
                      </table>
					</td>
					<td class="btn1_line"></td>
	                <td>
	                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                    <tr>
	                      <td class="btn1_left"></td>
	                      <td class="btn1" id="btn_New" name="btn_New">New</td>
	                      <td class="btn1_right"></td>
	                    </tr>
	                  </table>
	                </td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr>
			<td class="bg">
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="100">Control Office</td>
					<td width="240" class="stm">
						<input type="text" name="ofc_cd" class="input1" style="width:60" value="" maxlength="6" style='ime-mode:disabled' onKeyPress="ComKeyOnlyAlphabet('upper');">
						<input type="checkbox" name="chk_sub_ofc" value="Y" onClick="javascript:chkSubOfc(this);" class="trans">Incl. Sub Office
					</td>
					<td width="100">Storage Type</td>
					<td width="210">
						<script language="javascript">ComComboObject('f_sto_type', 1, 170 , 0, 0 )</script>
					</td>
					<td width="60">Status</td>
					<td width="150">			
						<script language="javascript">ComComboObject('f_sto_sts', 2, 120 , 0, 0 )</script>
					</td>
					<td width="80">Cal. Result</td>
					<td width="">			
						<script language="javascript">ComComboObject('f_cal_rslt', 1, 90 , 0, 0 )</script>
					</td>
					<td>&nbsp;</td>
				</tr>
				</table>
				
				<table class="search_sm2" border="0" style="width:100%;"> 
				<tr class="h23">
				<td>
				<table class="search" border="0" style="width:975;"> 
					<tr class="h23">
						<td width="100"><input type="radio" name="cond_type" value="date" class="trans" checked>Date</td>
						<td width="70" class="stm">MVMT Date</td>
						<td width="220" >
						<div id="mvmtDt" style="display:inline">
						<table class="search" border="0">
						  <tr class="h23">
						  	<td width="200" class="stm">
							<input type="text" style="width:72;" name="sto_fm_dt" maxlength="8" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="fnYearSet(this)" caption="MVMT From Date" >&nbsp;~
							<input type="text" style="width:72;" name="sto_to_dt" maxlength="8" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="fnYearSet(this)" caption="MVMT To Date">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar" width="19"height="20"alt=""border="0"align="absmiddle" class="cursor">
							</td>
		                  </tr>
		                </table>
						</div>
						</td>
						<td width="70" class="stm">Node</td>
						<td width="220" >
						<div id="mvmtDt" style="display:inline">
						<table class="search" border="0">
						  <tr class="h23">
						  	<td width="200" class="stm">
							<input type="text" style="width:70;" name="sto_fm_nod" maxlength="7" onKeyPress="ComKeyOnlyAlphabet('uppernum');" caption="Node From Date">&nbsp;~
							<input type="text" style="width:70;" name="sto_to_nod" maxlength="7" onKeyPress="ComKeyOnlyAlphabet('uppernum');" caption="Node To Date">
							</td>
		                  </tr>
		                </table>
						</div>
						</td>
						<td width="80">&nbsp;</td>
						<td width="">&nbsp;</td>
					</tr>
					<tr class="h23">
						<td><input type="radio" name="cond_type" value="bkg_cntr" class="trans">BKG/CNTR</td>
						<td class="stm">BKG No.</td>
						<td>
						<div id="mvmtDt" style="display:inline">
						<table class="search" border="0">
						  <tr class="h23">
						  	<td>
							  <input type="text" class="input" name="bkg_no" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="width:105;" maxlength="13">
							</td>
						  </tr>
						</table>
						</div>
						</td>
						<td class="stm">CNTR No.</td>
						<td colspan="3">
						<div id="mvmtDt" style="display:inline">
						<table class="search" border="0">
						  <tr class="h23">
						  	<td>
							  <input type="text" name="cntr_no" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="width:110;" maxlength="11">
							</td>
						  </tr>
						</table>
						</div>
						</td>
					</tr>
				</table>
				</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>
		
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search" border="0">
		<tr>
		  <td class="bg">
		    <table width="100%" id="mainTable">
		      <tr>
		        <td>
		          <script language="javascript">ComSheetObject("sheet1");</script>
		          </td>
		        </tr>
		      </table>
		    </td>
		  </tr>
		</table>
		<!-- Outer Table (E)-->

    </td>
  </tr>
</table>
<div style="display:none;">
	<script language="javascript">ComSheetObject('sheet2');</script>
</div>
</form>
</body>
</html>