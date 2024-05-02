<%--=========================================================================
'주  시 스 템 : ENIS
'서브  시스템 : IAS T/S Volume
'프로그램 ID  : apps/enis/esm/mas/lanesimulation/jsp/ESM_MAS_166.jsp
'프로그램 명  : IAS T/S Volume
'프로그램개요 : IAS T/S Volume
'작   성   자 :
'작   성   일 : 2009.02
=========================================================================
' History     :
2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
2009.07.20 윤진영 Alps전환작업 
2010.05.03 윤진영 port clss capa삭제 
2010.06.14 CHM-200901719 윤진영 UI표준처리 탭키 이동 가능하도록 수정
2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
2013.01.14 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair 가 맞지 않는 부분 수정 
=========================================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.lanesimulation.event.EsmMas0166Event"%>
<%@ page import="java.util.*"%>
<%
    EsmMas0166Event  event = null;     //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null; //서버에서 발생한 에러
    String strErrMsg    = "";           //에러메세지

    String prevWeek 	= "";
    String v_trd_cd 		= "";
    String v_rlane_cd 		= "";
    String v_dir_cd 		= "";
    String v_ioc_cd 		= "";
    String v_i_cnt 		    = "";
    String v_i_vsl 		    = "";
    String v_r_vsl 		    = "";
    String v_vsl 		    = "";
    String v_sect_no	    = "";
    String fYear			= "";

    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.mas.lanesimulation.EsmMas0166Event");

    try {

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsmMas0166Event)request.getAttribute("Event");

            v_trd_cd   = JSPUtil.getNull(request.getParameter("trd_cd"));
            v_rlane_cd = JSPUtil.getNull(request.getParameter("rlane_cd"));
            v_dir_cd   = JSPUtil.getNull(request.getParameter("skd_dir_cd"));
            v_ioc_cd   = JSPUtil.getNull(request.getParameter("ioc_cd"));
            v_i_cnt    = JSPUtil.getNull(request.getParameter("i_cnt"));
            v_i_vsl    = JSPUtil.getNull(request.getParameter("i_vsl"));
						//v_i_vsl    = v_i_vsl.replaceAll(",","|"); 
            v_r_vsl    = JSPUtil.getNull(request.getParameter("r_vsl"));
            //v_r_vsl 	 = v_r_vsl.replaceAll(",","|");
            v_vsl      = JSPUtil.getNull(request.getParameter("vsl"));
            //v_vsl 		 = v_vsl.replaceAll(",","|");
            v_sect_no  = JSPUtil.getNull(request.getParameter("f_sect_no"));
            
         // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    		
    		Map<String,String> returnVal = new HashMap<String,String>();
    		returnVal = eventResponse.getETCData();
    		if (returnVal.get("prevWeek") != null){
    			prevWeek = returnVal.get("prevWeek");
    		}
    		if (returnVal.get("fYear") != null){
    			fYear = returnVal.get("fYear");
    		}
        } // end else

         //Utils.getPrevWkPrd();


    }catch(Exception e) {
        log.error("EsmMas0166Event Exception : "+e.toString());
        out.println(e.toString());
    }
%>
<html>
<head>
<title>BSA by VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<!--
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        var formObj = document.form;
        formObj.f_year.focus();
        formObj.f_year.value = "<%=fYear%>";
        formObj.f_fm_wk.value = "<%=prevWeek%>";
        formObj.f_to_wk.value = "<%=prevWeek%>";
        setPeriod(formObj.f_to_wk);
        loadPage();
    }
-->
</script>
</head>


<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<input type="hidden" name="f_i_cnt" value="<%= v_i_cnt %>">
<input type="hidden" name="f_i_vsl" value="<%= v_i_vsl %>">
<input type="hidden" name="f_r_vsl" value="<%= v_r_vsl %>">
<input type="hidden" name="f_vsl" value="<%= v_vsl %>">
<input type="hidden" name="f_sect_no" value="<%= v_sect_no %>">
<input type="hidden" name="f_chkprd" value="W">

<!-- OUTER - POPUP (S)tart -->

<table width="1000" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; BSA by VVD</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->



			<table class="search">
                    <tr>
                        <td class="bg">

				            <table class="search" border="0" width="100%">

				              	<tr class="h23">
				              		<td width="40">Year</td>
				              		<td width="100"><input type='text' style='width:60;text-align:center;' class='input1' name='f_year'  maxlength='4' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onChange='setPeriod(this);'>&nbsp;</td>
				              		<td width="40">Week</td>
				              		<td width="90" class="stm">
				              						<input type='text' class="input1" style='width:30;text-align:center;' style='ime-mode:disabled' name='f_fm_wk' maxlength='2' onKeyPress='ComKeyOnlyNumber(window);' onBlur="fillSpace(this, 2, '0', 'left');" onKeyUp='moveTab(this, f_to_wk);' onChange='setPeriod(this);' >&nbsp;~&nbsp;
				              			           <input type='text' class="input1" style='width:30;text-align:center;' style='ime-mode:disabled' name='f_to_wk' maxlength='2' onKeyPress='ComKeyOnlyNumber(window);' onBlur="fillSpace(this, 2, '0', 'left');" onChange="fillSpace(this, 2, '0', 'left');setPeriod(this);">&nbsp;</td>
				              		<td width="145" class="sm"><div id='div_period'></div></td>
				              		<td>&nbsp; </td>
				             	</tr>

				             </table>


							<table class="line_bluedot"><tr><td></td></tr></table>


				            <table class="search" border="0" width="100%">
				            	<tr class="h23">
				             		<td width="40">Trade</td>
				             		<td width="100"><input type="text" name="trd_cd" style="width:60;" class="noact2"  value="<%=v_trd_cd%>" readOnly></td>
				             		<td width="40">Lane</td>
				             		<td width="120"><input type="text" name="rlane_cd" style="width:80;" class="noact2" value="<%=v_rlane_cd%>" readOnly></td>
				             		<td width="60">Direction</td>
				             		<td width="100"><input type="text" name="dir_cd" style="width:60;" class="noact2" value="<%=v_dir_cd%>" readOnly></td>
				             		<td width="30">IOC</td>
				             		<td><input type="text" name="ioc_cd" style="width:60;" class="noact2" value="<%=v_ioc_cd%>" readOnly></td>
				             	</tr>
				            </table>
				         </td>
				     </tr>
			</table>


			<table class="height_10"><tr><td></td></tr></table>

			<!-- : ( Grid BG Box ) (S) -->
			<table class="search" width="100%" >
				<tr>
					<td class="bg">
						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td>
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- : ( c ) (E) -->

 						<!-- : ( Grid ) (S) -->

					</td>
				</tr>
			</table>
			<!-- : ( Grid BG Box ) (E) -->
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Apply</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->



</form>
</body>
</html>