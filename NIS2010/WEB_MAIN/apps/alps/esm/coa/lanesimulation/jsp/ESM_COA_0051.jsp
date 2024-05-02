<%--=========================================================================
'주  시 스 템 : ENIS
'서브  시스템 : 항로 Simulation 마스터 및 W/F 생성/조회/변경
'프로그램 ID  : apps/enis/esm/coa/lanesimulation/jsp/ESM_COA_051.jsp
'프로그램 명  : 항로 Simulation 마스터 및 W/F 생성/조회/변경
'프로그램개요 : 항로 Simulation 마스터 및 W/F 생성/조회/변경
'작   성   자 : Park Eun Ju
'작   성   일 : 2006.08.28
=============================================================================
' History :
' 20080219 박은주 N200802040018 COA 내 항로 Simulation 로직 변경
' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
' 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
' 2008,11.06 전성진 CSR No.N200811050011
'		   - 메뉴명 수정, 링크 밑줄 표시
' 2009.03.31 박상희 S2K-09U-002(Lane Simulation System 개선)
' 2009.06.15 배진환 N200905220060 Lane Simulation System 수정사항
' 2009.08.21 박은주 Alps전환작업 [ESM_COA_0169] 
' 2009.07.20 윤진영 Alps전환작업  
' 2010.05.03 윤진영 port clss capa삭제
' 2010.05.25 윤진영 CHM-200901719 UI개선 
'            - Grid1에 sect del과 save 버튼 순서 바꿈   
' 2010.06.14 윤진영 CHM-200901719 UI표준처리 버튼 라인추가 및 save,delete버튼 위치 변경
' 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.lanesimulation.event.EsmCoa0051Event"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
  	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    EsmCoa0051Event event     = null;	//PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg 	 = "";          //에러메세지
    String xml = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.coa.lanesimulation.EsmCoa0051");

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
	      event = (EsmCoa0051Event)request.getAttribute("Event");
	      xml = HttpUtil.makeXML(request,response); 
          xml = xml.replaceAll("\"", "'");
        } 
    }catch(Exception e) {
        log.error("ESM_COA_0051.jsp Exception : " + e.toString());
        out.println(e.toString());
    }
%>
<!-- %= sLane % -->
<!--  %= "dept_cd : "+v_dept_cd %  -->
<html>
<head>
<title>Set Master-Rule of Lane Simulation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
<!--
    function setupPage(){
	    var errMessage    = "<%= strErrMsg %>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
-->
</script>
</head>
<iframe height="0" width="0" name="frmHidden"></iframe>
<body onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_dept_cd_1" value=""> <!-- dept_cd       -->
<input type="hidden" name="usr_id"  value=""> <!-- usr_id       -->
<input type="hidden" name="f_txtTmp">
<!--input type="hidden" name="vcd_count"--> <!-- vcd_count  -->
<input type="hidden" name="f_vsl_cd">
<input type="hidden" name="f_srow">
<input type="hidden" name="f_trd_cd">
<input type="hidden" name="f_flag">
<input type="hidden" name="f_skd_dir_cd">
<input type="hidden" name="f_sect_no">
<input type="hidden" name="sXml" value="<%=xml%>"> 

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


<!--Page Title, Historical (S)-->
<!--table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
</table-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Vessel Register</td></tr>
</table>
<!--Page Title, Historical (E)-->



		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_filemgmt" name="btn_filemgmt" onclick="javascript:callFmt();">File Mgmt</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->



                <!-- TABLE '#D' : ( Search Options ) (S) -->
                <table class="search">
                    <tr>
                        <td class="bg">


                            <!-- : ( Select 'Simulation No' ) (S) -->
                            <table class="search_in" border="0">
                                <tr class="h23">
                                    <td width="110"><input type="radio" class="trans" name="f_ext_flg" value="N"  onclick="javascript:viewBtn();">New Lane </td>
                                    <td width="400"><input type="radio" class="trans" name="f_ext_flg" value="Y" checked onclick="javascript:viewBtn();" >Existing Lane  </td>
                                    <td width="60">S/Lane</td>
                                    <td width="84" style="text-indent:2;"><script language="javascript">ComComboObject('f_slan_cd', 1, 80 , 0 )</script></td>
                                    <td width="84">
                                    	<div id="div_dept">
                                    	<script language="javascript">ComComboObject('f_dept_cd2',1, 80 , 0 )</script>
                                    	</div>
                                    </td>
                                    <td>
                                    	<div id="div_simNo">
                                    	<script language="javascript">ComComboObject('f_sim',1, 200 , 0 )</script>
                                    	</div>
                                    </td>
                                </tr>
                                <tr class="h23">
                                    <td>Simulation No.</td>
                                    <td>
                                        <input type="text" style="width:30;" name="f_dept_cd" maxlength="3"  readOnly class="input2">&nbsp;&nbsp;-&nbsp;
                                        <input type="text" style="width:75;" name="f_sim_dt" dataformat="ymd" maxlength="8" readOnly class="input2">
                                        <input type="text" style="width:30;" name="f_sim_no" maxlength="3" readOnly class="input2">
                                        <input type="text" style="width:180;" name="f_usr_id" readOnly class="input2">
                                    </td>
                                    <td width="50">Remark</td>
                                    <td colspan = "3">
                                        <input type="text" style="width:384;" name="f_sim_rmk">
                                    </td>
                                </tr>
                                <tr class="h23">
                                	<td colspan="6">Working Steps</td></tr>
                                <tr>
                                    <td colspan="6" valign="top">
                                        <table class="search" border="0">
                                            <tr>
                                            	<td width="110">&nbsp;</td>
                                                <td width="120" style="padding-right:5;"><img class="cursor" src="/hanjin/img/alps/cost_step01_on.gif"    border="0" name="step01"></td>
                                                <td width="120" style="padding-right:5;"><img class="cursor" src="/hanjin/img/alps/cost_step02.gif" border="0" name="step02"></td>
                                                <td width="120" style="padding-right:5;"><img class="cursor" src="/hanjin/img/alps/cost_step03.gif"    border="0" name="step03"></td>
                                                <td><img class="cursor" src="/hanjin/img/alps/cost_step04.gif"    border="0" name="step04"></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <!-- : ( Select 'Simulation No' ) (E) -->
                        </td>
                    </tr>
                </table>
                <!-- TABLE '#D' : ( Search Options ) (E) -->

            <table class="height_10"><tr><td></td></tr></table>

            <!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search">
                <tr>
                    <td class="bg">
                        <table class="search" border="0">
                            <tr><td height="30" valign="top"><img src="img/alps/cost_step01s.gif" height="22" border="0"></td></tr>
                        </table>

                        <table class="search" border="0">
                            <tr>
                                <td class="title_h"></td>
                                <td class="title_s">Service Lane & Deployed Vessels Setting</td>
                                <td align="right">
								<img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="">
                                <a href="javascript:callContiPair();"  class="purple">Continent Pair</a> &nbsp;
							</td>
                            </tr>
                            <tr><td class="height_5"></td></tr>
                        </table>
                        <!-- : ( From Location ) (S) -->
                        <table width="100%" id="mainTable">
                            <tr>
                                <td>
                                    <script language="javascript">ComSheetObject('s1sheet1');</script>
                                </td>
                            </tr>
                        </table>
                        <!-- : ( From Location ) (E) -->


						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td id="btn_lane_pre" class="btn2_left"></td><td class="btn2" id="btn_lane" name="btn_lane">Lane Info. I/F</td><td id="btn_lane_end" class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" onClick="javascript:setVesselInfo1();">Reset Sub Trade</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btn_rowadd1" name="btn_rowadd1">Row Add</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btn_save" name="btn_save">Save</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btn_secdel" name="btn_secdel">Sect Del</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->

                        <table class="line_bluedot"><tr><td></td></tr></table>

                        <!-- : ( BSA & Slot Swap ) (S) -->
                        <table class="search" border="0" style="width:100%;">
                            <tr class="h23">
                                <td width="70%">
                                    <input type="radio" value="0" class="trans" name="radCode" checked>&nbsp;BSA & Slot Swap Volume&nbsp;&nbsp;&nbsp;
                                    <input type="radio" value="1" class="trans" name="radCode">&nbsp;BSA & Slot Swap Revenue & Cost
                                </td>

								<td width="5%" align="right" valign="bottom" style="padding-right:3;">
							        <div id="div_zoom_in1" style="display:inline"> <!-- absolute / relative -->
									<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
									</div>
									<div id="div_zoom_out1" style="display:none">
									<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
									</div>
								</td>
                            </tr>
                            <tr><td class="height_10"></td></tr>
                        </table>

                        <!-- : ( BSA & Slot Swap ) (E) -->
                        <table class="search" border="0">
                            <tr><td class="gray_tit"><img src="img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">&nbsp;<input type="text" name="subtitle" style="width:240;" class="transgray" readonly></td></tr>
                            <tr><td class="height_5"></td></tr>
                            <tr>
                                <td align="right">
								<img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">
                                <a href="javascript:callNonOpExpn();" class="purple">Non Operating Expense</a> &nbsp;
								<img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">
                                <a href="javascript:callTSVolume();" class="purple">T/S Volume</a> &nbsp;
							    </td>
                            </tr>
                            <tr><td class="height_5"></td></tr>
                        </table>
                        <!-- : ( Grid : Week ) (S) -->
                        <!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
                        'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
                        <table width="100%" id="mainTable1">
                            <tr>
                                <td>
                                    <script language="javascript">ComSheetObject('s1sheet2');</script>
                                </td>
                            </tr>
                        </table>
                        <!-- : ( Grid : Week ) (E) -->



						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td id="td_bsa_pre" class="btn2_left"></td><td class="btn2" name="btn_vsl" id="td_bsa" style="display:block;" onclick="javascript:callBSAbyVVD();">VSL & BSA I/F</td><td id="td_bsa_end" class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" onClick="javascript:setVesselInfo2();">Set VSL Info.</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left" id="btn_rowadd3" name="btn_rowadd3"></td><td class="btn2" id="btn_rowadd2" name="btn_rowadd2">Row Add</td><td class="btn2_right" id="btn_rowadd4"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left" id="btn_save3" name="btn_save3"></td><td class="btn2" id="btn_save2" name="btn_save2">Save</td><td class="btn2_right" id="btn_save4"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->

                    </td>
                </tr>
            </table>
            <!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>
