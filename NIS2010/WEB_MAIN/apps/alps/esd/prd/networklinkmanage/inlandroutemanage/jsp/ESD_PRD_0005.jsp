<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0005.jsp
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
* 2012.06.07 변종건 [CHM-201217633] TRS의 Cost Batch Error Inquiry 화면에서 PRD 화면 호출 기능 추가
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
    //String successFlag = "";
    //String codeList  = "";
    //String pageRows  = "100";
    String selInvCodeNoSort ="";
    String selPlanCodeNoSort = "";
    String selWRSFullCode = "";
    String selWRSEmptyCode = "";
    String optStr = "000010::";
    String optStr2="|000010: : "; //ibsheet의 콤보 
    
    String ioBndCd				= "";
	String fmNodCd				= "";
	String toNodCd				= "";
	String rcvDeTermCd			= "";
	
    try {
    	ioBndCd					= JSPUtil.getNull(request.getParameter("io_bnd_cd"));
    	fmNodCd					= JSPUtil.getNull(request.getParameter("fm_nod_cd"));
    	toNodCd					= JSPUtil.getNull(request.getParameter("to_nod_cd"));
    	rcvDeTermCd				= JSPUtil.getNull(request.getParameter("rcv_de_term_cd"));
       //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
       //userId=account.getSawonNo();
       //userAuth=account.getAuth(); 

        event = (EsdPrd0005Event)request.getAttribute("Event");
 		
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        selInvCodeNoSort = JSPUtil.getCodeCombo("i_inv", "01", "width='144' onChange='setCombindMode();'", "CD00126", 0, optStr);
        selPlanCodeNoSort = JSPUtil.getCodeCombo("i_rout_pln_cd", "01", "width='140'", "CD00127", 0, optStr);
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


<body onload="javascript:setupPage();">
<form method="post" name="form" >
<input    type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<!-- if(!checkMandatory() ) return; // 여기서 실제 서버로 보낼 HIDDEN(조회 조건 인 from , to)의 i_ord_cd,i_dest_cd 를 셋팅한다.  -->
<input type="hidden" name="i_org_cd">
<input type="hidden" name="i_dest_cd">
<!-- sheetObj2 라우트의 처음과  끝  -->
<input type="hidden" name="i_rout_org_nod_cd">
<input type="hidden" name="i_rout_dest_nod_cd">

<input type="hidden" name="i_rout_seq">
<input type="hidden" name="i_hub_search_gb">
<input type="hidden" name="i_front_gb">
<input type="hidden" name="i_undefine_nod">
<input type="hidden" name="i_new_route_cd">
<input type="hidden" name="i_sel_row">
<input type="hidden" name="disable_bkg_flg">
<input type="hidden" name="prio_seq_combo">

<input type="hidden" name="detail_org_i_inv">
<input type="hidden" name="detail_org_i_rout_pln_cd">
<input type="hidden" name="detail_org_i_bkg_flg">
<!-- input type="hidden" name="detail_org_i_mcntr_rout_flg"-->
<input type="hidden" name="i_mcntr_rout_flg" value=""> <!-- 조회조건에 MT라디오버튼이 생겨서 hidden으로 변경  -->
<input type="hidden" name="detail_org_i_wrs_fl_cd">
<input type="hidden" name="detail_org_i_wrs_mt_cd">
<input type="hidden" name="cnt_cd" value="">
<input type="hidden" name="i_old_optm_flg" value=""/>

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
							<!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_routelist" id="btn_routelist">Route List</td><td class="btn1_right"></td></tr></table></td -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_minimize" id="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<td><table border="1" bordercolor="#A3A4C7" class="search" style="height:21; width:100; background-color: #F3F2F8;"><td align="center">Delete Flag&nbsp;<input name="i_del_flg" type="checkbox" class="trans"  value="Y" onClick="changeDeltFlg()" unchecked></td></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

					<table class="search">
						<tr>
							<td width="20%">
						       <table border="0" style="height:20; width:90%;background-color: #E9E9E9;">
						            <tr align="center"><input type="hidden" name="rBtnIrgCd" value="I">
						            	<td><input type="radio" name='r_inbound' value='I' class="trans" onClick="changeSelection('I')" tabIndex="1" <% if( !"O".equals(ioBndCd) ){ %> checked <% } %>>IB</td>
						                <td><input type="radio" name='r_inbound' value='O' class="trans" onClick="changeSelection('O')" <% if( "O".equals(ioBndCd) ){ %> checked <% } %>>OB</td>
						                <td><div id="div_desc"><input type="radio" name='r_inbound' value='B' class="trans" onClick="changeSelection('B')">TMNL SHTL</div></td>
										<!-- td><input type="radio" name='rInbound' value='M' class="trans" onClick="changeSelection('M')">MT</td -->
						            </tr>
						        </table>
								<script type="text/javascript">
								var desc = "Terminal Shuttle IRG for COP change " ;
								document.all.div_desc.title = desc;
			
								</script>
						    </td>
						    <td width="40%">
						        <!--IB (S)-->
			
						        <table class="search">
						            <tr class="h23">
						            	<td width="50"></td>
						                <td width="45">From</td>
						                <td width="150"><input class="input1" name="i_org_cd_ib" type="text" required caption="ORG TML" maxlength="7" tabIndex="2" style="width:70" dataformat="engup" value="<%=fmNodCd%>">
						                	<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ib_org_tml_btn" id="ib_org_tml_btn"></td>
						                <td width="30">To</td>
						                <td width=""><input class="input1" name="i_dest_cd_ib" type="text" required caption="DEST LOC" maxlength="7" tabIndex="3" style="width:70" dataformat="engup" value="<%=toNodCd%>">
						                	<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ib_dest_loc_btn"  id="ib_dest_loc_btn"></td>
			
						            </tr>
						        </table>
						        <!--IB (E)-->
						    </td>
			
							<td width="15%">
						       <table border="0" style="height:20; background-color: #E9E9E9;">
						            <tr>
						                <td class="stm">
						                	<input type="hidden" name="rBtnNodTyCd1" value="Y">
						                	<input type="radio" name='nod_tp_cd1' value='Y' class="trans" onClick="changeNodTy1('Y')" tabIndex="4" <% if( !"DR".equals(rcvDeTermCd) ){ %> checked <% } %>>Yard&nbsp;
						                	<input type="radio" name='nod_tp_cd1' value='Z' class="trans" onClick="changeNodTy1('Z')" <% if( "DR".equals(rcvDeTermCd) ){ %> checked <% } %>>Zone</td>
						                <td></td>
						            </tr>
						        </table>
						    </td>

							<td width="32%">
						       <table class="search" border="0" style="height:20; background-color: #E9E9E9;">
						            <tr class="h23">
						                <td class="search" width="100">Optimum Flag</td>
						                <td class="stm"><input type="hidden" name="rBtnOptmFlg" value="Y"><input type="radio" name='sch_optm_flg' value='A' class="trans" checked tabIndex="5">ALL&nbsp;<input type="radio" name='sch_optm_flg' value='Y' class="trans" >Y&nbsp;<input type="radio" name='sch_optm_flg' value='N' class="trans" >N&nbsp;<input type="radio" name='sch_optm_flg' value='C' class="trans" >C</td>
						                <td></td>
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
					<table width="100%" class="sbutton">
						<tr>
							<td align="left" >
								<table>
									<tr class="bg" height="5">
										<td class="title_h"></td>
										<td align="left" class="title_s">
											&nbsp;&nbsp;If you want to change priority, please double-click on priority column.&nbsp;&nbsp;</td>
									</tr>
								</table>
							</td>
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


					<table class="search_in" border="0">
						<tr class="h23">

							<td width="90">Booking Flag</td>
							<td width="75"><input name="i_bkg_flg" type="checkbox" class="trans" value="" onClick="checkedBkgFlg()" unchecked></td>
							<td width="82%"></td>
						</tr>
					</table>


					<table class="search_in" border="0">
						<tr class="h23">

						<td width="100">Optimum Flag</td>
							<td width="10"><input name="i_optm_flg" type="checkbox" class="trans" disabled value="" onClick="checkedOptmFlg()" unchecked></td>
							<td width="30" align="left"></td>
							<!-- td width="81%"--></td>
						<td width="170">Alternative Optimum Flag</td>
							<td width="10"><input name="i_altn_optm_flg" type="checkbox" class="trans" disabled value="" onClick="checkedAltOptmFlg()" unchecked></td>
							<td width="650"></td>
							<!-- td width="81%"--></td>							
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
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_save" id="btng_save">Save</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_saveas" id="btng_saveas">Save AS</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- Button : Sub (E) -->

					<table class="height_10"><tr><td></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="10%">Remarks</td>
							<td width="90%"><div align="right">
								<input name="i_route_rmk" type="text" style="width:900">
								</div></td>
							</tr>
					</table></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		</div> <!-- div id="minimize" -->

<div style="visibility:hidden;">
<table class="height_10">
<tr>
							<!-- td width="170"><img src="/hanjin/img/ico_star.gif" >INV Billing &amp;INV Pattern </td-->
							<td width="10">
							<!-- <select name="i_inv" style="width:144">
							<option value="0" selected>CT Combine Thru Bill</option>
							<option value="0">Combine & Rule 11</option>
							</select> -->
								<%=selInvCodeNoSort %>

							</td>
							<!-- td width="90"><img src="/hanjin/img/ico_star.gif" >Route Plan</td-->
							<td>&nbsp;
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

							<td width=""><!-- MT<input name="i_mcntr_rout_flg" type="checkbox" class="trans" value="Y" unchecked > --></td>
							<!-- td width="52">WRS(F)</td -->
							<td width="303">
							<!-- <select name="i_inv" style="width:92">
							<option value="0" selected>Bulk</option>
							<option value="0"></option>
							</select> -->
							<%=selWRSFullCode %>
							</td>
							<!-- td width="74">WRS(M)</td -->
							<td>
							<!-- <select name="i_inv" style="width:100">
							<option value="0" selected>Normal</option>
							<option value="0"></option>
							</select> -->
							<%=selWRSEmptyCode %>
							</td>
							</tr>
</table>
</div>
    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>