<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0055.jsp
*@FileTitle : Inland Route Inquiry 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-04
*@LastModifier : jungsunyong
*@LastVersion : 1.0
* 2006-09-04 jungsunyong
* 1.0 최초 생성
* 마스트 그리드는 update,delete만 일어난다. 
* 신규생성은 디테일에서 추가 해야 한다. 
*
* 2009-07-31 kim kwi-jin
* 1.1 수정
*
*
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0005Event"%>

<%
    EsdPrd0005Event  event = null;                //PDTO(Data Transfer Object including Parameters)
  
    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수
    
    String selInvCodeNoSort ="";
    String selPlanCodeNoSort = "";
    String selWRSFullCode = "";
    String selWRSEmptyCode = "";
    String optStr = "000010::";
    String optStr2="|000010: : "; //ibsheet의 콤보 
    try {

        event = (EsdPrd0005Event)request.getAttribute("Event");

 		
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        selInvCodeNoSort = JSPUtil.getCodeCombo("i_inv", "01", "width='144' onChange='setCombindMode();'", "CD00126", 0, optStr);
        selPlanCodeNoSort = JSPUtil.getCodeCombo("i_rout_pln_cd", "01", "width='140'", "CD00127", 0, optStr);
        selWRSFullCode = JSPUtil.getCodeCombo("i_wrs_fl_cd", "01", "width='140'", "CD00862", 0, optStr);
        selWRSEmptyCode = JSPUtil.getCodeCombo("i_wrs_mt_cd", "01", "width='140'", "CD00863", 0, optStr);
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
<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="i_rout_org_nod_cd">
<input type="hidden" name="i_rout_dest_nod_cd">

<input type="hidden" name="i_rout_seq">
<input type="hidden" name="i_hub_search_gb">
<input type="hidden" name="i_front_gb">
<input type="hidden" name="i_undefine_nod">
<input type="hidden" name="i_newRouteCd">
<input type="hidden" name="i_selRow">
<input type="hidden" name="disable_bkg_flg">
<input type="hidden" name="prio_seq_combo">


<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Route List Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

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
							
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

				<table class="search_in">
			<tr>
				<td width="30%">
			       <table border="0" style="height:20; width:90%;background-color: #E9E9E9;">
			            <tr><input type="hidden" name="rBtnIrgCd" value="I">
			            	<td><input type="radio" name='r_inbound' value='I' class="trans" onClick="changeSelection('I')" checked>IB</td>
			                <td><input type="radio" name='r_inbound' value='O' class="trans" onClick="changeSelection('O')">OB</td>
			                <td><input type="radio" name='r_inbound' value='B' class="trans" onClick="changeSelection('B')">TMNL STL</td>
			                <td><input type="radio" name='r_inbound' value='M' class="trans" onClick="changeSelection('M')">MT</td>
			            </tr>
			        </table>
			    </td>
			    <td>
			        <!--IB (S)-->

			        <table class="search">
			            <tr class="h23">
			                <td width="6%"><img class="nostar">From</td>
			                <td width="20%"><input class="input1" name="i_org_cd" type="text" required caption="From" maxlength="7" tabIndex="1" style="width:70" style="text-transform:uppercase" dataformat="engup">
			                	<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ib_org_loc_btn"></td>
			                <td width="5%"><img class="nostar">To</td>
			                <td><input class="input1" name="i_dest_cd" type="text" required caption="To" maxlength="7" tabIndex="3" style="width:70" style="text-transform:uppercase" dataformat="engup">
			                	<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ib_dest_loc_btn"></td>
			            </tr>
			        </table>

			        <!--IB (E)-->

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
			              <tr class="h23">
							<td>The details are available for checkup by double-click on constraint column.</td>
						  </tr>
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
							<td width="160"><img class="nostar">INV Billing &amp;INV Pattern </td>
							<td width="350">
							<!-- <select class="input1" name="i_inv" style="width:144">
							<option value="0" selected>CT Combine Thru Bill</option>
							<option value="0">Combine & Rule 11</option>
							</select> -->
								<%=selInvCodeNoSort %>

							</td>
							<td width="78"><img class="nostar">Route Plan</td>
							<td>&nbsp;
							    <!--
								<select class="input1" name="i_rout_plan" style="width:215">
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
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<!--  <td width="30%" align="right">Combined Mode&nbsp;<input name="i_combined_mod" type="checkbox" class="trans" value="Y" unchecked>&nbsp;&nbsp;WRS<input name="i_web_rail_sys_flg" type="checkbox" class="trans" value="Y" unchecked>&nbsp;&nbsp;MT<input name="i_mcntr_rout_flg" type="checkbox" class="trans" value="Y" unchecked></td>-->

							<td width="90"><img class="nostar">Booking Flag</td>
							<td width="159"><input name="i_bkg_flg" type="checkbox" class="trans" value="Y" unchecked></td>
							<td width=""><!-- MT<input name="i_mcntr_rout_flg" type="checkbox" class="trans" value="Y" unchecked > --></td>
							<td width="52">WRS(F)</td>
							<td width="218">
							<!-- <select name="i_inv" style="width:92">
							<option value="0" selected>Bulk</option>
							<option value="0"></option>
							</select> -->
							<%=selWRSFullCode %>
							</td>
							<td width="75">WRS(M)</td>
							<td>
							<!-- <select name="i_inv" style="width:100">
							<option value="0" selected>Normal</option>
							<option value="0"></option>
							</select> -->
							<%=selWRSEmptyCode %>
							</td>
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
<table class="height_10"><tr><td></td></tr></table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5px; padding-bottom:10px;">
			<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->
					</tr>
				</table>
			</td></tr>
		</table>
	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>
