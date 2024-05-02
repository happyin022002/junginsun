<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0107.jsp
*@FileTitle : Expense Summary by S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.20
*@LastModifier : 민정호
*@LastVersion : 1.4
* 2009.01.07 최종혁
* 1.0 최초 생성
* ----------------------------------------------------------
* History
* 2009.03.04 최종혁 1.1 [N200901080023] Expense Summary Report S/P 메뉴개발
* 2010.10.08 최 선     1.2 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
* 2011.01.04 최 선     1.3 [CHM-201108174] Report 화면 중 S/P code 선택 시 오류팝업 수정요청
* 2011.07.20 민정호 1.4 [CHM-201112196] Expense Summary Report에 Invoice 상태코드를 조회조건에 추가
* 2012.02.23 금병주 1.5 [CHM-201216258] [TRS] Expense Summary Excel Down 버튼 추가
* 2013.04.12 조인영 [CHM-201323766] Report Multiple select 조회 기능 추가
* 2013.08.22 조인영 [CHM-201326241] [TRS] Report data 개수 표시
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.report.expensesummary.event.EsdTrs0107Event"%>

<%
  SignOnUserAccount account = null; //Session 정보
  EsdTrs0107Event  event = null;       //PDTO(Data Transfer Object including Parameters)
  Exception serverException   = null;     //서버에서 발생한 에러
  DBRowSet rowSet   = null;                //DB ResultSet
  String strErrMsg = "";                 //에러메세지
  int rowCount   = 0;                 //DB ResultSet 리스트의 건수
  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String optionStr = "000020:ALL:ALL";
	String eq_ctrl = "";
	String userId  = "";

  try {
  	  account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	    userId=account.getUsr_id();
	    eq_ctrl=account.getOfc_cd();

      event = (EsdTrs0107Event)request.getAttribute("Event");

      serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    /*
    아래부분은 꼭 지켜주셔야 에러메세지가 정상적으로 전달이 됩니다.
    보시다시피 먼저 에러를 받고 에러가 아닐시에 EventResponse로 값을 전달하셔야 합니다.
    */
    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }
  }catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>
<head>
<title>Expense Summary by S/P</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  function setupPage(){
    var errMessage = "";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>
<!--
ComShowMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 alert()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를
대비해서 직접 alert() 하지 마시고 꼭 ComShowMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.
-->

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input  type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="old_ofc_cd" value="<%=eq_ctrl%>">
<input type="hidden" name="hid_period" value="S">
<input type="hidden" name="hid_from_date" >
<input type="hidden" name="hid_to_date" >
<input type="hidden" name="hid_from_node">
<input type="hidden" name="hid_via_node">
<input type="hidden" name="hid_to_node">
<input type="hidden" name="hid_door_node">
<input type="hidden" name="hid_io_bnd">

<!-- xls 다운 구분용 flag 2012.02.23 kbj -->
<input type="hidden" name="hid_grid_flg">


<!-- RD에서 출력용 파라메터 필드-->
<input type="hidden" name="row_ofc_cd">
<input type="hidden" name="row_vndr_seq">
<input type="hidden" name="row_costmode">
<input type="hidden" name="row_transmode">
<input type="hidden" name="row_sotype">
<input type="hidden" name="row_sotype_nm">
<input type="hidden" name="row_fm_loc">
<input type="hidden" name="row_via_loc">
<input type="hidden" name="row_to_loc">
<input type="hidden" name="row_door_loc">
<input type="hidden" name="row_status_cd">
<input type="hidden" name="row_inv_curr">
<input type="hidden" name="cnt">

<!-- SP와 Parent S/P를 조회해야 되기 때문에 필요한 컬럼 -->
<!-- S/P명을 조회하는 모듈에 엘리먼트 명이 하드코딩되어 있는 관계로 어쩔수 없이 이런방식을 취함-->
<input type="hidden" name="combo_svc_provider">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>



			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
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
							<tr><td class="btn1_left"></td><td class="btn1"  id="btng_rtv_downxls" name="btng_rtv_downxls">Down Excel</td><td class="btn1_right"></td></tr></table>
						</td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

				</td></tr>
			</table>
            <!-- TABLE '#D' : ( Button : Main ) (E) -->


              <div id="showMin" style="display:inline">
              <!-- TABLE '#D' : ( Search Options ) (S) -->
              <table class="search">
                <tr><td class="bg">

                    <table class="search_in" border="0">
                      <tr class="h23">
                        <td width="70">Date </td>
                        <td width="440" class="sm">
                          	<select name="sel_period" onChange='change_period();' style="width:110;">
                            <option value="S" selected>S/O Creation</option>
                            <option value="W">W/O Creation</option>
                            <option value="I">Invoice Confirm</option>
                            <option value="G">G/L date</option>
                          	</select>&nbsp;

                          	<input name="from_date" type="text" style="width:70;" value="" onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);addBar_from(this);'>&nbsp;~&nbsp;
                          	<input name="to_date" type="text" style="width:70;"   value="" onFocus='fun_Focus_del(this)' onBlur='BlurDate(this);addBar_to(this);'>
                          	<img name="btns_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
                        <td width="130">Office Code</td>

                        <td>

							<table border="0" style="height:15; width:100%; background-color: #E9E9E9;">
                            <tr><td class="sm" width="142" style="padding-left:3;">
                        			<input type="radio" name="radio_office" value="WO" class="trans" checked>Work Order
                        			<input type="radio" name="radio_office" value="IV" class="trans">Invoice</td>
                        		<td class="sm"><input name="input_office" type="text" class="input" style="width:70" onkeyup="upper(this)" value="<%=eq_ctrl%>" ><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office">&nbsp;&nbsp;<input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC</td>
                          	</tr>
                          	</table>


                        </td>
                      </tr>
                    </table>
                    <table height="2""><tr><td></td></tr></table>

					<table class="search_in" border="0">
				    <tr class="h23">
					<td width="70">Cost Mode</td>
					<td width="190"><script language="javascript">ComComboObject('sel_costmode', 1, 170, 1)</script></td>
					<td width="87">Trans Mode</td>
					<td width="132"><script language="javascript">ComComboObject('sel_transmode', 1, 100, 1)</script></td>
					<td width="160">Service Order Type</td>
					<td><script language="javascript">ComComboObject('sel_sotype', 1, 150, 1)</script></td>
					<td width="46">Bound</td>
						<td width="75"><select name="io_bound" style="width:70;" >
							<option value="A" selected>ALL</option>
							<option value="I">IN</option>
							<option value="O">OUT</option>
							<option value="T">TS</option>
							<option value="P">IN+OUT</option>
							</select></td>
					</tr>
					</table>


					<table class="search_in" border="0">
						<tr class="h23">
						<td width="70">From </td>
						<td width="66"><input name="search_fm_loc" type="text" style="width:62;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.search_fm_yard, 'F');" onBlur=""  ></td>
						<td width="164"><script language="javascript">ComComboObject('search_fm_yard', 1, 60, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>

						<td width="32">Via </td>
						<td width="57"><input name="search_via_loc" type="text" style="width:53;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_via_yard, 'V');" onBlur=""></td>
						<td width="121"><script language="javascript">ComComboObject('search_via_yard', 1, 60, 0);</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_vianode"></td>

						<td width="26">To </td>
						<td width="60"><input name="search_to_loc" type="text" style="width:56;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_to_yard, 'T');"  onBlur=""></td>
						<td width="205"><script language="javascript">ComComboObject('search_to_yard', 1, 60, 0);</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tonode"></td>

						<td width="40">Door</td>
						<td width="57"><input name="search_door_loc" type="text" style="width:53;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_door_yard, 'D');"  onBlur=""></td>
						<td align="right"><script language="javascript">ComComboObject('search_door_yard', 1, 60, 0);</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_dorloc"></td>
						</tr>
					</table>

					<table height="2""><tr><td></td></tr></table>

                    <table class="search_in" border="0">
                      <tr class="h23">
                        <td width="311">
							<table border="0" style="height:15; width:305; background-color: #E9E9E9;">
                            <tr><td style="font-weight:bold;">
	                        	<input type="radio" name='node_div' value="2" class="trans"  Onclick="distance_col_control();" checked>&nbsp;By Country &nbsp;&nbsp;&nbsp;
	                        	<input type="radio" name='node_div' value="5" class="trans"  Onclick="distance_col_control();">By Location&nbsp;&nbsp;&nbsp;
	                        	<input type="radio" name='node_div' value="7" class="trans"  Onclick="distance_col_control();">By Yard</td>
                          	</tr>
                          	</table>
                        </td>
                        <td width="180">Volume by Type/Size</td>
                        <td width="100">
							<table border="0" style="height:15; width:115; background-color: #E9E9E9;">
                            <tr><td class="sm" style="padding-left:5;">
                            	<input type="radio" name='vol_size' value="" class="trans" Onclick='change_volume();' checked>&nbsp;Show&nbsp;
                        		<input type="radio" name='vol_size' value="" class="trans" Onclick='change_volume();' >Hide</td>                        		
                          	</tr>                          	
                          	</table>
                        </td>
                        <td width="10">&nbsp;</td>
                        <td width="130">Invoice Status</td>
                        <td><script language="javascript">ComComboObject('status_cd', 1, 130, 1)</script></td>  
                        <td width="40" align ="right">ETS</td>
							<td>
								<select name="ets_yn" style="width:95;">
									<option value="" selected>ALL</option>
									<option value="Y">Y</option>
									<option value="N">N</option>
								</select>
							</td>                      
                      </tr>
                    </table>

                    <table height="2""><tr><td></td></tr></table>

                    <table class="search_in" border="0">
                      <tr class="h23">
                        <td width="140">Service Provider Code</td>
						<td width="420">

								<table border="0" style="height:15; width:410; background-color: #E9E9E9;">
	                            <tr><td class="sm" width="145" style="padding-left:2;">
				                        <input name='sp_tp' type="radio" value="WO" class="trans" checked>Work Order
				                        <input name='sp_tp' type="radio" value="IV" class="trans">Invoice
									</td>
									<td><input name="combo_svc_provider_chld" type="text" style="width:60;" value="" maxlength="6" onChange='getTextVndrSeq(sheetObjects[0], document.form, this.value, "chld")' onKeyup='enterCheck(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><input name="svc_provider_chld" type="text" class="input" style="width:173" value=""><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_provider_chld'>
									</td></tr>
								</table>

						</td>

                        <td width="170">
                        	<input type="checkbox" name="chk_prnt_provider" value="Y" class="trans" onClick="javascript:fun_chkParentSP();">&nbsp;Parent Service Provider</td>
                        <td width="">
                          <input name="combo_svc_provider_prnt" type="text" style="width:63;" value="" maxlength="6" onChange='getTextVndrSeq(sheetObjects[0], document.form, this.value, "prnt")' onKeyup='enterCheck(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><input name="svc_provider_prnt" type="text" class="input" style="width:162" value=""><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_provider_prnt'>
                        </td>
                      </tr>
                    </table>

                </td>
                </tr>
              </table>
              <!-- TABLE '#D' : ( Search Options ) (E) -->
              </div>

              <table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">


              <!-- : ( Grid ) (S) -->
              <!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
              <table width="100%" id="mainTable">
                <tr>
                  <td>
                    <script language="javascript">ComSheetObject('sheet1');</script>
                  </td>
                </tr>
              </table>

              <!-- Excel DownLoad -->
              <table width="100%" id="mainTable">
                <tr>
                  <td>
                    <script language="javascript">ComSheetObject('sheet2');</script>
                  </td>
                </tr>
              </table>

              <!-- Parent S/P 조회 -->
              <table width="100%" id="mainTable">
                <tr>
                  <td>
                    <script language="javascript">ComSheetObject('sheet3');</script>
                  </td>
                </tr>
              </table>

              <!-- : ( Grid ) (E) -->

        <!-- : ( Button : Grid ) (S) -->
		<table width="100%" class="button">
	       	<tr>
	       	<td class="title_s">
				* For more detailed information over additional column, please use "Down Excel" function on top-right side
				</td>
	       	<td class="btn2_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td><td class="btn2" id="btng_detailinquiry" name="btng_detailinquiry">Detail Inquiry</td><td class="btn2_right"></td></tr></table></td>
				<!-- Repeat Pattern -->


			</tr></table>
		</td></tr>
		<tr>
		<td align="right" height="10"></td>
		</tr>
		</table>
         <!-- : ( Button : Grid ) (E) -->



			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>
