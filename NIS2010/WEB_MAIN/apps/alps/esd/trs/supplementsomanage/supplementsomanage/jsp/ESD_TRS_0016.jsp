<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0016.jsp
*@FileTitle : Service Order 생성-Supplement
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.17
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2006.10.30 juhyun
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2009.03.18 정상기 1.1 [N200903160120] Supplement S/O 조회조건 추가
* 2010.11.17 최 선     1.2 [] Date Combo 선택 시, 스크립트 오류 처리
* 2012.08.02 김종호 [CHM-201219248] [TRS] W/O preview 화면에서 최종 confirm 시 로그인ofc와 S/O지역코드를 비교하기 위한 로직 추가
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
<%@ page import="com.hanjin.apps.alps.esd.trs.supplementsomanage.supplementsomanage.event.EsdTrs0016Event"%>

<%
	EsdTrs0016Event  			event 			= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 					serverException	= null;		//서버에서 발생한 에러
	DBRowSet 					rowSet	  		= null;		//DB ResultSet
	String 						strErrMsg 		= "";		//에러메세지
	int 						rowCount	 	= 0;		//DB ResultSet 리스트의 건수
	String today 		= DateTime.getFormatString("yyyyMMdd");
	String userId  		= "";
	String selCOSTMODE 	= ""; //Cost Mode
	String selTRANSMODE = ""; //Transportation Mode
	String selBOUND 	= ""; //RHQ Mode
	String optionStr 	= "000020:ALL:ALL";;
	String eq_ctrl 		= "";
	String eq_ctrl_1 	= "";

	String selCntrSize = ""; //Cntr Size


	selBOUND  			= JSPUtil.getCodeCombo("sel_boundmode"	, "01"	, " onChange='bound_OnChange_1(this);' style='width:70'"	, "CD00591", 0, optionStr);
	selCOSTMODE  		= JSPUtil.getCodeCombo("sel_costmode"	, "01"	, " onChange='bound_OnChange_2(this);' style='width:140'"	, "CD00744", 0, optionStr);
	selTRANSMODE  		= JSPUtil.getCodeCombo("sel_transmode"	, "01"	, " onChange='bound_OnChange_3(this);' style='width:70'"	, "CD00283", 0, optionStr);

    selCntrSize  = JSPUtil.getCodeCombo("cntr_size", "01", "style=width:60", "CD00937", 0, optionStr);


	try {
		/*
		꼭 유저의 정보를 받을 필요는 없습니다. 화면에서 유저의 이름이나
		권한같은 정보를 이용할 필요가 있을 경우에만 사용하면 됩니다.
		덧붙여 USER 정보에 대해서 한마디로 정리하면 user 의 정보를 이용할수 있는 곳은 jsp 와 command 입니다.
		jsp에서는 유저의 정보를 가지고 권한에 따른 버튼 처리등을 할수가 있는 것이고 (enable/disable)
		command에서는 역시 유저의 정보로 예를 들어 update 권한등이 있는지를 확인할 수가 있는 것입니다.

		주의> 사용자 테이블이 변경됨에 따라 변경 될 것입니다.
			SignOnUserAccount 의 메서드를 확인 하십시오.
			getAuth 메서드는 현재 미정이지만 권한 관련 value를 가져올 메서드가 있겠죠?
	   */
	   	SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId						= account.getUsr_id();
	   	eq_ctrl						= account.getOfc_cd();
	   	eq_ctrl_1					= eq_ctrl.substring(0, 3);

		event = (EsdTrs0016Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Service Order Creation - Supplement</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%= JSPUtil.getIBCodeCombo("way_type", "", "CD00929", 0, "")		%>
	<%=	BizComUtil.getIBCodeCombo("curr_cd", "01", "CURR", 1, " |")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form  method="post" name="form" 				onSubmit="return false;">
<input type="hidden" name="f_cmd"										>
<input type="hidden" name="iPage"										>
<input type="hidden" name="form_cre_usr_id" 	value="<%=userId%>"		>
<input type="hidden" name="form_usr_ofc_cd" 	value="<%=eq_ctrl%>"	>
<input type="hidden" name="cre_ofc_cd" 			value="<%=eq_ctrl%>"	>
<input type="hidden" name="cre_ofc_cd_1" 		value="<%=eq_ctrl_1%>"	>
<input type="hidden" name="cre_usr_id" 			value="<%=userId%>"		>
<input type="hidden" name="cre_dt_val" 			value="<%=today%>"		>
<input type="hidden" name="upd_usr_id" 			value="<%=userId%>"		>
<input type="hidden" name="upd_dt" 				value="<%=today%>"		>
<input type="hidden" name="hid_kind" 			value="AS"				>
<input type="hidden" name="hid_eq_radio"  		value="U"				>
<input type="hidden" name="hid_boundmode">
<input type="hidden" name="hid_costmode">
<input type="hidden" name="hid_transmode">
<input type="hidden" name="hid_provider">
<input type="hidden" name="hid_from_node">
<input type="hidden" name="hid_via_node">
<input type="hidden" name="hid_to_node">
<input type="hidden" name="hid_dor_node">
<input type="hidden" name="hid_from_date">
<input type="hidden" name="hid_to_date">
<input type="hidden" name="hid_period">
<input type="hidden" name="hid_tp_sz">
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
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="110">Kind</td>
					<td class="sm">
						<input NAME="btns_radio_kind" type="radio" value="A" class="trans"  Onclick="change_val();" checked>For Additional Surcharge&nbsp;&nbsp;&nbsp;
						<input NAME="btns_radio_kind"  type="radio" value="B" class="trans"   Onclick="change_val();" disabled>For Retroactive Rate</td>
					</tr>
				</table>


				<table class="search_in" border="0">
				<tr class="h23">
					<td width="108">Date</td>
					<td width="134">
						<SELECT style="width:132" name = "sel_period">
						<OPTION  value="S">S/O Creation</OPTION>
						<OPTION  value="W">W/O Issue</OPTION>
						<OPTION  value="I">Invoice Confirm</OPTION>
						<OPTION  value="P">Planned Departure</OPTION>
						<OPTION  value="D">Door Arrival</OPTION>
						</SELECT>
					</TD>

					<td width="317" class="sm">
						<input name="from_date" type="text" style="width:70;"  onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);addBar_from(this);'>&nbsp;~&nbsp;<input name="to_date" type="text" style="width:70;" onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);addBar_to(this);' >
						<img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_calendar"></td>

					<td width="107">Service Provider</td>
					<td><input type='text' name='combo_svc_provider'  style="width:100;" onChange='getTextVendorSeq(docObjects[0], document.form, this.value)' onKeyup='enterCheck(this)'>
						<input name='svc_provider' type="text" style="width:183;" value="" readonly  class="input2"  title="This inputbox cant't write"> <img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_provider'></td>
				</tr>
				</table>

				<table class="search_in" border="0">
				<tr class="h23">

					<td width="108">Bound</td>
					<td width="170"><%=selBOUND%></td>
					<td width="100">Cost Mode</td>
					<td width="180"><%=selCOSTMODE%></td>
					<td width="75">Trans Mode</td>
					<td><%=selTRANSMODE%></td>
				</tr>
				</table>

				<table class="search_in" border="0">
						<tr class="h23">
							<td width="108">From</td>
							<td width="76"><input name="search_fm_loc" type="text" style="width:70;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.search_fm_yard, 'F');" onBlur=""  ></td>
							<td width="94"><script language="javascript">ComComboObject('search_fm_yard', 1, 40, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="2" border="0" align="absmiddle"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>
							<td width="100">Via</td>
							<td width="76"><input name="search_via_loc" type="text" style="width:70;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_via_yard, 'V');" onBlur=""></td>
							<td width="104"><script language="javascript">ComComboObject('search_via_yard', 1, 43, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="2" border="0" align="absmiddle"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_vianode"></td>
							<td width="75">To</td>
							<td width="76"><input name="search_to_loc" type="text" style="width:70;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_to_yard, 'T');"  onBlur=""></td>
							<td width="88"><script language="javascript">ComComboObject('search_to_yard', 1, 48, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="2" border="0" align="absmiddle"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_tonode"></td>
							<td width="38">Door</td>
							<td width="76"><input name="search_door_loc" type="text" style="width:70;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_door_yard, 'D');"  onBlur=""></td>
							<td align="right"><script language="javascript">ComComboObject('search_door_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="2" border="0" align="absmiddle"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_dorloc"></td>
						</tr>
				</table>

				<table class="search_in" border="0">
				<tr class="h23">
					<td width="108">T. VVD</td>
					<td width="170"><input name="vvdnumber"  type="text" style="width:114;" onChange='setgetUpper(this)'> <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="so_OnPopupClick('VVD', 'T.VVD');"></td>
					<td width="100">Booking No.</td>
					<td width="181"><input name="bkgnumber"  type="text" style="width:117;" onFocus='fun_Focus(this)'  onChange='setgetUpper(this)' onBlur="val_check(this,'BKG NUMBER');"><img src="/hanjin/img/blank.gif" width="4" hight="1"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('BKG','BKG No.');"></td>
					<td width="74">B/L No.</td>
					<td><input name="blnumber"  type="text" style="width:122;" onFocus='fun_Focus(this)'  onBlur="val_check(this,'BL NUMBER');" onChange='setgetUpper(this)'><img src="/hanjin/img/blank.gif" width="4" hight="1"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('BL','BL No.');"></td>
					</tr>
				</table>

				<table class="search_in" border="0">
				<tr class="h23">
					<td width="110">Equipment No.</td>
					<td width="448">

								<table border="0" style="height:15; width:415;background-color: #E9E9E9;">
                                	<tr>
                                		<td class="sm" style="padding-left:10;" width="258">
                                			<input NAME="btns_radio_eq"  type="radio" value="A" class="trans" Onclick="change_eq_val();checkDigit();" checked>Container&nbsp;&nbsp;&nbsp;
											<input NAME="btns_radio_eq"  type="radio" value="B" class="trans" Onclick="change_eq_val();">Chassis&nbsp;&nbsp;&nbsp;
											<input NAME="btns_radio_eq"  type="radio" value="C" class="trans" Onclick="change_eq_val();">Genset&nbsp;

										</td>
										<td><input  name="eqnumber"  type="text" style="width:117;"  onFocus='fun_Focus(this)' onChange='checkDigit(this);' onBlur="val_check(this,'EQ NUMBER');"><img src="/hanjin/img/blank.gif" width="4" hight="1"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  name='btn_eq_no'></td>
                                	</tr>
                                </table>

						</td>

					<td width="75">Type / Size</td>
					<td width="112"><SELECT Name="tp_sz" style="width:70;">
					      <OPTION Value="ALL">ALL</OPTION>
						</Select>
					</td>
					<td width="90">Reference No.</td>
					<td><input name="refnumber"  type="text" style="width:100%;" onChange='setgetUpper(this)'></td>

				</tr>
				</table>


				<table class="search_in" border="0">
				<tr class="h23">
					<td width="108">Service Order No.</td>
					<td width="170"><input name="sonumber" type="text" style="width:114;" onFocus='fun_Focus(this)' onBlur="val_check(this,'SO NUMBER');" onChange='setgetUpper(this)'>
									<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="so_OnPopupClick('SO','S/O No.');"></td>
					<td width="100">Work Order No.</td>
					<td width="180"><input name="wonumber"  type="text" style="width:117;" onFocus='fun_Focus(this)'  onBlur="val_check(this,'WO NUMBER');" onChange='setgetUpper(this)'><img src="/hanjin/img/blank.gif" width="4" hight="1"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('WO','W/O No.');"></td>
					<td width="75">Invoice No.</td>
					<td align="right"><input name="invnumber"  type="text" style="width:93%;">
						<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('INV','INV No.');"></td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search"><tr><td class="height_10"></td></tr></table>

				<!-- : ( Seq. ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
				<!-- : ( Seq. ) (E) -->



				<!-- : ( Button : Grid ) (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_surchargeapply" name="btng_surchargeapply">Surcharge Apply</td><td class="btn2_right"></td></tr></table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation" name="btng_socreation">S/O Creation</td><td class="btn2_right"></td></tr></table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_wopreview" name="btng_wopreview">W/O Preview</td><td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


					</tr></table>
				</td></tr>
				</table>
		    	<!-- : ( Button : Grid ) (E) -->


				<!-- : ( Seq. ) (S) Hidden Sheet for S/O Creation Target List Storage -->
                    <table  id="soCreationTable" width="100%">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
                    </table>
					<table id="surchargeTable" width="100%" >
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
                    </table>
				<!-- : ( Seq. ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>



<form name='woForm' method='POST' 	 action='ESD_TRS_0024.screen'>
	<input type='hidden' name='trsp_so_ofc_cty_cd'			 	>
	<input type='hidden' name='trsp_so_seq'					 	>
	<input type='hidden' name='eq_mode' 			value='SF'	>
	<input type="hidden" name="pgmNo" >
	<input type="hidden" name="trsp_so_no">
</form>

<FORM NAME='scgForm' method='POST'>
<input type='hidden' name='unique_cd'>
<input type='hidden' name='open_mode'>
<input type='hidden' name='step_cd'>
<input type='hidden' name='main_row'>
<input type='hidden' name='sheet_arr_no'>
<input type='hidden' name='ofc_cty_cd'>
<input type='hidden' name='so_seq'>
<input type='hidden' name='curr_cd'>
<input type='hidden' name='cgo_tp_cd'>
<input type='hidden' name='multi_ofc_cty_cd'>
<input type='hidden' name='multi_so_seq'>
<input type='hidden' name='multi_cgo_tp_cd'>
<input type='hidden' name='check_row'>
</FORM>
</body>
</html>
