<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0055.jsp
*@FileTitle : Other SO 생성화면
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 유선오
*@LastVersion : 1.1
* 2009-10-01 kimjin
* 1.0 최초 생성
* ----------------------------------------------------------
* History
* 2011.08.31 유선오   1.1 [CHM-201112874] [TRS] OTHER S/O Creation 화면 상 오류 수정요청
* 2011.10.19 유선오   1.2 [CHM-201112874] [TRS] OTHER S/O Creation 화면 상 오류 수정요청
* 2012.08.03 김종호 [CHM-201219248] [TRS] W/O preview 화면에서 최종 confirm 시 로그인ofc와 S/O지역코드를 비교하기 위한 로직 추가
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.event.EsdTrs0018Event"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%
	EsdTrs0018Event  event 		= null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 			= "";			//에러메세지

	SignOnUserAccount account = null;

	try {

		event = (EsdTrs0018Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addMonths(today, -1);
	beforeOneMonth = beforeOneMonth.substring(0,4) + "-" + beforeOneMonth.substring(4,6)+ "-" + beforeOneMonth.substring(6,8);  //월 저장
	String today_1 = DateTime.getFormatString("yyyy-MM-dd");

	String costModeCd   = JSPUtil.getCodeCombo("trs_cost_md_cd", "01", "style='width:145' OnChange='resetSearchCondition(this)'", "CD00744", 0, "000020::");
	String transModeCd  = JSPUtil.getCodeCombo("trs_md_cd", "01", "style='width:96' OnChange='resetSearchCondition(this)'", "CD00283", 0, "000010::");
%>
<html>
<head>
<title>Other SO Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
var today = '<%=today%>';
var today_1 = '<%=today_1%>';
var beforeOneMonth = '<%=beforeOneMonth%>';

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setKindEnabled();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="TRSP_SO_VNDR_NO">
<input type="hidden" name="TRSP_SO_TP_CD" value='O'>
<input type="hidden" name="TRSP_SO_STS_CD">
<input type="hidden" name="TRSP_SO_EQ_KIND">
<input type="hidden" name="EQ_KND_CD">
<input type="hidden" name="CGO_TYP_CD">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="trsp_so_no">

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
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->




<div id="MiniLayer" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="180">Service Order Creation Date</td>
							<td width="328" class="stm"><input type="text" style="width:70;" name='fmdate' value="<%=beforeOneMonth%>" onFocus='fun_Focus_del(this)' onBlur='BlurDate(this);addBar_from(this);'>&nbsp;~&nbsp;<input name="todate" type="text" style="width:70;" value="<%=today_1%>" onFocus='fun_Focus_del(this)' onBlur='BlurDate(this);addBar_to(this);'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name='btns_calendar'></td>

							<td width="72">Cost Mode</td>
							<td width="196"><%=costModeCd%></td>
							<td width="77">Trans Mode</td>
							<td><%=transModeCd%></td>


						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="95">From</td>
							<td width="56"><input type="text" style="width:52;" name='search_fm_loc' onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength=5></td>
							<td width="147"><script language="javascript">ComComboObject('search_fm_yard', 1, 46, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_fm_node'></td>
							<td width="39">Via</td>
							<td width="56"><input type="text" style="width:52;" name='search_via_loc' onFocus='fun_Focus(this)' onChange='getComboList(this)' onKeyup='enterCheck(this)' maxlength=5></td>
							<td width="114"><script language="javascript">ComComboObject('search_via_yard', 1, 46, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_via_node'></td>
							<td width="73">To</td>
							<td width="56"><input type="text" style="width:52;" name='search_to_loc' onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength=5></td>
							<td width="142"><script language="javascript">ComComboObject('search_to_yard', 1, 46, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_to_node'></td>
							<td width="75">Door</td>
							<td width="56"><input type="text" style="width:52;" name='search_dr_loc' onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength=5></td>
							<td><script language="javascript">ComComboObject('search_dr_yard', 1, 42, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_dr_node'></td>
						</tr>
					</table>
					<table height="2"><tr><td></td></tr></table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="97">Equipment No.</td>
							<td>
								<table border="0" style="height:15; width:370; background-color: #E9E9E9;">
                                	<tr><td class="sm" style="padding-left:10;" width="208">
                                		<input type="radio" name='eq_kind' value="container" class="trans" onClick='setEqKindRadio(this);checkDigit();'  checked>Container&nbsp;&nbsp;&nbsp;<input type="radio" name='eq_kind' value="chassis" class="trans" onClick='setEqKindRadio(this);'>Chassis&nbsp;&nbsp;&nbsp;<input type="radio" name='eq_kind' value="genset" class="trans" onClick='setEqKindRadio(this);'>Genset</td>
                                		<td><input type="text" style="width:122;" name='eq_no' onChange='checkDigit(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btn_eq_no'></td>
                                	</tr>
                                </table>
							</td>

						</tr>
					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

	</div>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<!--table class="tab">
		<tr><td><img src="/hanjin/img/sub_tab.gif" alt="" width="755" height="23" border="0"></td></tr>
		</table-->
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
						<tr><td>
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td></tr>
					</table>
					<table id="soCreationTable">
                        <tr><td> 
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
                    </table>
					<table width="100%" id="hiddenTable">
            		      <tr><td>
            		          <script language="javascript">ComSheetObject('sheet3');</script>
            		      </td></tr>
            		</table>
					<!-- : ( Grid ) (E) -->

					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_sodelete" name="btng_sodelete">S/O Delete</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socorrection" name="btng_socorrection">S/O Correction</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_wopreview" name="btng_wopreview">W/O Preview</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td></tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->





</td></tr>
</table>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->

</form>


<form name='woForm' method='POST' action='ESD_TRS_0024.screen'>
<input type='hidden' name='trsp_so_ofc_cty_cd'>
<input type='hidden' name='trsp_so_seq'>
<input type='hidden' name='vndr_seq'>
<input type='hidden' name='eq_mode' value='OT'>
<input type="hidden" name="sysCommUiTitle" value="Preview">
<input type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
<input type="hidden" name="pgmNo" >
<input type="hidden" name="trsp_so_no">

</form>
</body>
</html>
