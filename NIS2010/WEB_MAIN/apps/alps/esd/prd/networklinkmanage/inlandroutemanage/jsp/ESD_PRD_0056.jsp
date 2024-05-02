<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0056.jsp
*@FileTitle : Inland Route 정보관리화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-04
*@LastModifier : jungsunyong
*@LastVersion : 1.0
* 2006-09-04 jungsunyong
* 1.0 최초 생성
* 마스트 그리드는 update,delete만 일어난다. 
* 신규생성은 디테일에서 추가 해야 한다. 
* 2011.06.16 변종건 [CHM-201111584-01] [PRD] Inland Route Management상의 입력국가 추가 요청.
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0056Event"%>
<%
	EsdPrd0056Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    
    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수
    //String successFlag = "";
    //String codeList  = "";
    //String pageRows  = "100";
    String selInvCodeNoSort ="";
    String selPlanCodeNoSort = "";
    String selWRSFullCode = "";
    String selWRSEmptyCode = "";
    String optStr = "000010::";
    String optStr2="|000010: : "; //ibsheet의 콤보 

    try {

      
        event = (EsdPrd0056Event)request.getAttribute("Event");

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        selInvCodeNoSort = JSPUtil.getCodeCombo("i_inv", "01", "style='width:200' onChange='setCombindMode();'", "CD00126", 0, optStr);
        selPlanCodeNoSort = JSPUtil.getCodeCombo("i_rout_pln_cd", "01", " style='width:180'", "CD00127", 0, optStr);
        selWRSFullCode = JSPUtil.getCodeCombo("i_wrs_fl_cd", "01", "width='140'", "CD00862", 0, optStr);
        selWRSEmptyCode = JSPUtil.getCodeCombo("i_wrs_mt_cd", "01", "width='140'", "CD00863", 0, optStr);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<%@include file="/apps/alps/esd/prd/common/prdcommon/jsp/ESD_PRD_AUTH.jsp"%>
<html>
<head>
<title>Inland Route 정보관리화면</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("trsp_mod_cd", "01", "CD00997", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("rail_crr_tp_cd", "01", "CD00287", 0, optStr2)%>
	<%= JSPUtil.getIBCodeCombo("inv_bill_ptn", "01", "CD00126", 0, optStr)%>
	<%= JSPUtil.getIBCodeCombo("rout_plan", "01", "CD00127", 0, optStr)%>
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        // InitTab();

        loadPage();
    }
</script>

</head>
<body  onload="javascript:setupPage();">
<form method="post" name="form">
<input    type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- DETAIL 조회시 etc [S]-->
<input type="hidden" name="detail_org_i_inv">
<input type="hidden" name="detail_org_i_rout_pln_cd">

<!-- DETAIL 조회시 라우트의 처음과  끝  -->
<!-- DETAIL 저장시 checkRoute4Mt() 에서 신규일때 -->
<input type="hidden" name="i_rout_org_nod_cd">
<input type="hidden" name="i_rout_dest_nod_cd">

<!-- DETAIL 저장시 checkRoute4Mt() 에서 신규일때 -->
<!-- Sheet1에서 클릭시 상세 조회 ->Sheet2에 표시  -->
<input type="hidden" name="i_rout_seq">

<!-- sheet1 에서 클릭 이벤트 발생시 -->
<input type="hidden" name="i_selrow">

<!-- detail 저장시 checkRoute4Mt()에서  -->
<!--<input type="hidden" name="i_newRouteCd">-->
<input type="hidden" name="i_new_route_cd">

<!-- if(!checkMandatory() ) return; // 여기서 실제 서버로 보낼 HIDDEN(조회 조건 인 from , to)의 i_ord_cd,i_dest_cd 를 셋팅한다.  -->
<input type="hidden" name="i_org_cd">
<input type="hidden" name="i_dest_cd">

<!-- DETAIL 조회시 ETC값으로 셋팅해준것  -->
<input type="hidden" name="detail_org_i_wrs_fl_cd">
<input type="hidden" name="detail_org_i_wrs_mt_cd">

<input type="hidden" name="i_hub_search_gb">
<input type="hidden" name="i_front_gb">
<input type="hidden" name="i_undefine_nod">


<input type="hidden" name="disable_bkg_flg">
<input type="hidden" name="prio_seq_combo">


<input type="hidden" name="detail_org_i_bkg_flg">
<!-- input type="hidden" name="detail_org_i_mcntr_rout_flg"-->
<input type="hidden" name="i_mcntr_rout_flg" value=""> <!-- 조회조건에 MT라디오버튼이 생겨서 hidden으로 변경  -->
<input type="hidden" name="cnt_cd" value="">


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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_minimize" id="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<td><table border="1" bordercolor="#A3A4C7" class="search" style="height:21px; width:100px; background-color: #F3F2F8;"><td align="center">Delete Flag&nbsp;<input name="i_del_flg" type="checkbox" class="trans"  value="Y" onClick="changeDeltFlg()" unchecked></td></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->





		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="45"><img class="nostar">From</td>
							<td width="200"><input name="from_cd" type="text" maxlength="7" tabIndex="1" style="text-transform:uppercase" style="width:100"  >
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ib_org_tml_btn"></td>
							<td width="30"><img class="nostar">To</td>
							<td width="200"><input name="to_cd" type="text"  maxlength="7" tabIndex="2" style="text-transform:uppercase" style="width:100"  >
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ob_dest_tml_btn"></td>
							<td width="">
								<table style="height:21px; width:300px; background-color: #E9E9E9;">
									<tr class="">
										<input type="hidden" name="wrs_flg" value="">
										<td width="120" align="center">WRS Flag</td>
										<td width="60"><input type="radio" class="trans" name='rWrs' value='' onClick="changeSelection('')" checked tabIndex="3"> ALL</td>
										<td width="60"><input type="radio" name='rWrs' value='MN' onClick="changeSelection('MN')" class="trans">Y</td>
										<td width="60"><input type="radio" name='rWrs' value='N'  onClick="changeSelection('N')" class="trans">N</td>
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

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr><td class="bg">

					<!-- Grid : Week (S) -->
					<table width="100%" id="mainTable">
				              <tr><td>
				                     <script type="text/javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
					</table>
					<!-- Grid : Week (E) -->
					</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

	 	<div id="minimize" style="display:inline">

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="170"><img src="/hanjin/img/ico_star.gif" >INV Billing &amp;INV Pattern </td>
							<td width="330">
							<!-- <select name="i_inv" style="width:144">
							<option value="0" selected>CT Combine Thru Bill</option>
							<option value="0">Combine & Rule 11</option>
							</select> -->
								<%=selInvCodeNoSort %>

							</td>
							<td width="90" ><img src="/hanjin/img/ico_star.gif" >Route Plan</td>
							<td width="300">&nbsp;
							    <!--
								<select name="i_rout_plan" style="width:215">
								<option value="0" selected>65 Shuttle To Ramp For Domestic</option>
								<option value="0">80 Shuttle To Shuttle For Inti</option>
								<option value="0">82 Shuttle To Ramp For Inti</option>
								<option value="0">85 Ramp To Ramp For Inti</option>
								<option value="0">87 Ramp To Shuttle For Inti</option>
								<option value="0">45 Ramp To Ramp For Domestic</option>
								</select>
								 -->
								<%=selPlanCodeNoSort %>
							</td>
							<td width="55">WRS(M)</td>
							<td width=""><input name="wrs_chk" type="checkbox" class="trans" value="MN" unchecked> </td>
						</tr>
					</table>




					<!-- Grid : Week (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
				              <tr><td>
				                     <script type="text/javascript">ComSheetObject('sheet2');</script>
				              </td></tr>
					</table>
					<!-- Grid : Week (E) -->

					<!-- Button : Sub (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_clear" id="btng_clear">Clear</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_new" id="btng_new">New</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_listlink" id="btng_listlink">List Link</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowcopy" id="btng_rowcopy">Row Copy</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_save" id="btng_save">Save</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- Button : Sub (E) -->

					<table class="height_10"><tr><td></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="10%"><img class="nostar">Remarks</td>
							<td width="90%"><div align="right">
								<input name="i_route_rmk" type="text" style="width:900">
								</div></td>
							</tr>
					</table></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		</div> <!-- div id="minimize" -->


    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>
