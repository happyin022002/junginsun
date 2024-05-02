<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0114.jsp
*@FileTitle : S/P Performace Comparison Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 
* 1.0 최초 생성
* ----------------------------------------------------------
* History
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.event.EsdTrs0114Event"%>

<%
  SignOnUserAccount account = null; //Session 정보
  EsdTrs0114Event  event = null;       //PDTO(Data Transfer Object including Parameters)
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
	event = (EsdTrs0114Event)request.getAttribute("Event");
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
<title>S/P Performace Comparison Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  function setupPage(){
    var errMessage = "";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
  <%= JSPUtil.getIBCodeCombo("sel_transmode", "", "CD00283", 0, "")%>
  <%= JSPUtil.getIBCodeCombo("sel_bound", "", "CD00591", 0, "")%>
</script>
</head>
<!--
ComShowMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 alert()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를
대비해서 직접 alert() 하지 마시고 꼭 ComShowMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.
-->

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="old_ofc_cd" value="<%=eq_ctrl%>">
<input type="hidden" name="hid_from_date" >
<input type="hidden" name="hid_to_date" >
<input type="hidden" name="hid_from_node">
<input type="hidden" name="hid_via_node">
<input type="hidden" name="hid_to_node">
<input type="hidden" name="hid_door_node">

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
							<tr><td class="btn1_left"></td><td class="btn1"  id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table>
						</td>
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
                        <td width="122">W/O Issue Date </td>
                        <td width="201" class="sm">
                          	<input name="from_date" type="text" style="width:70;" value="" onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);addBar_from(this);'>&nbsp;~&nbsp;
                          	<input name="to_date" type="text" style="width:70;"   value="" onFocus='fun_Focus_del(this)' onBlur='BlurDate(this);addBar_to(this);'>
                          	<img name="btns_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                        </td>
                        <td width="77">Office Code</td>
                            <td width="248" class="sm">
                            <input name="sel_input_office" type="text" class="input" style="width:70" onkeyup="upper(this)" value="<%=eq_ctrl%>" ><img src="/hanjin/img/blank.gif" width="2" height="1" border="0">
                            <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office">&nbsp;&nbsp;
                            <input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC
                        </td>
                        
                        <td width="150" class="sm">
                        <input type="checkbox" name="chk_compact" value="Y" class="trans" onClick="javascript:fun_compact();">Compact
                        </td>
                        
				   	    <td width="69">S/P</td>
					    <td width="115"><script language="javascript">ComComboObject('sel_spoption', 1, 114, 1)</script></td>
                        
                        <td width="18"></td>
                      </tr>
                    </table>
                    <table height="2"><tr><td></td></tr></table>

					<table class="search_in" border="0">
				    <tr class="h23">
					<td width="125">Service Order Type</td>
					<td width="200"><script language="javascript">ComComboObject('sel_sotype', 1, 150, 1)</script></td>
					<td width="80">Cost Mode</td>
					<td width="169"><script language="javascript">ComComboObject('sel_costmode', 1, 150, 1)</script></td>
					<td width="81">Trans Mode</td>
					<td width="140"><script language="javascript">ComComboObject('sel_transmode', 1, 100, 1)</script></td>
					<td width="70">Bound</td>
					<td width="75"><script language="javascript">ComComboObject('sel_bound', 1, 74, 1)</script></td>
					<td width="60"></td>
					</tr>
					</table>

					<table height="2""><tr><td></td></tr></table>

					<table class="search_in" border="0">
				    <tr class="h23">
					<td width="122">BKG No.</td>
					<td width="203">
								<input name="sel_bkgno"  type="text" style="width:112;">
								<img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('Booking No.');"></td>
					</td>
					<td width="77">CNTR No.</td>
					<td width="173">
								<input name="sel_cntrno"  type="text"  style="width:100px;">
	                            <img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('Container No.');">
					</td>
					<td width="80">S/O No.</td>
					<td width="142">
								<input name="sel_sono"  type="text"  style="width:100px;">
	                            <img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('S/O No.');">
					</td>
					<td width="68">W/O No.</td>
						<td width="135">
								<input name="sel_wono"  type="text"  style="width:100px;">
	                            <img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('W/O No.');">
						</td>
					</tr>
					</table>
					
					<table height="2""><tr><td></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="123">From</td>
							<td width="62"><input name="search_fm_loc" type="text" style="width:56;" maxlength="5" onChange="getComboList(this, document.form.search_fm_yard, 'F');" onBlur=""  ></td>
							<td width="90"><script language="javascript">ComComboObject('search_fm_yard', 1, 48, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>
							<td width="50"></td>
							<td width="78">Via</td>
							<td width="56"><input name="search_via_loc" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.form.search_via_yard, 'V');" onBlur=""></td>
							<td width="84"><script language="javascript">ComComboObject('search_via_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_vianode"></td>
							<td width="32"></td>
							<td width="81">To</td>
							<td width="56"><input name="search_to_loc" type="text" style="width:52;" maxlength="5" onChange="getComboList(this, document.form.search_to_yard, 'T');"  onBlur=""></td>
							<td width="85"><script language="javascript">ComComboObject('search_to_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_tonode"></td>
							<td width="68">Door</td>
							<td width="56"><input name="search_door_loc" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.form.search_door_yard, 'D');"  onBlur=""></td>
							<td width="79"><script language="javascript">ComComboObject('search_door_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_dorloc"></td>
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

              <!-- : ( Grid ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>
