<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0236.jsp
*@FileTitle : Agreement History Management by Route
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.1
* 2010-03-18 cjh
* 1.0 최초 생성
* HISTORY
* 2010-05-24 김종호 : 기능 구현
* 
* 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
* 1.2 2011.06.29 민정호 [CHM-201111442] R9 CNTR 추가관련 로직 변경요청
* 1.18 2011.10.18 최종혁  [] [TRS] 조회조건 오타정정
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%

  Exception         serverException   = null;     //서버에서 발생한 에러
  String            strErrMsg     = "";                //에러메세지

  String  userId  = "";
  String  ofcCd   = "";

  String optionStr2   = "000020::";
  String selCARGOMODE = ""; //Cargo Type Combo
  String selTRANSMODE = "";	//Trans Mode Combo
  selCARGOMODE  = JSPUtil.getCodeCombo("cargo",     "01"  ,"style='width:80;'", "CD00748", 0, optionStr2);
  selTRANSMODE	= JSPUtil.getCodeCombo("fm_agmt_trsp_tp_cd", "01"	,"style=width:70", "CD00283", 0, optionStr2);
  try {
    SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
      userId	= account.getUsr_id();
      ofcCd     = account.getOfc_cd();
      
    serverException       = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }
  }catch(Exception e) {
    out.println(e.toString());
  }
  
  String today = DateTime.getFormatString("yyyy-MM-dd");
%>

<html>
<head>
<title>Agreement Inquiry by Route </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  function setupPage(){
    <%= JSPUtil.getIBCodeCombo("rail_svc_tp_cd",	"", "CD00916", 0, "")%>
    loadPage();
  }
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">

<input type="hidden" name="fm_rail_svc_tp_cd">
<input type="hidden" name="fm_pop_agmt_trsp_tp_cd">
<input type="hidden" name="fm_agmt_trsp_tp_cd">
<input type="hidden" name="fm_trsp_agmt_ofc_cty_cd">
<input type="hidden" name="fm_trsp_agmt_seq">
<input type="hidden" name="fm_trsp_agmt_rt_tp_ser_no">
<input type="hidden" name="fm_vndr_seq">
<input type="hidden" name="fm_ctrt_ofc_cd">
<input type="hidden" name="fm_eq_knd_cd">
<input type="hidden" name="fm_eqtpsz">					<!-- 추가-민정호 -->
<input type="hidden" name="fm_trsp_agmt_eq_tp_sz_cd">
<input type="hidden" name="fm_cgo_tp_cd">
<input type="hidden" name="fm_fm_nod_cd">
<input type="hidden" name="fm_via_nod_cd">
<input type="hidden" name="fm_dor_nod_cd">
<input type="hidden" name="fm_to_nod_cd">
<input type="hidden" name="fm_trsp_agmt_bdl_qty">
<input type="hidden" name="fm_wgt_meas_ut_cd">
<input type="hidden" name="fm_basic_rt">
<input type="hidden" name="fm_curr_cd">
<input type="hidden" name="fm_way">
<input type="hidden" name="tab_gubun">
<input type="hidden" name="hid_effective_date" value="<%=today%>">

<input type="hidden" name="agmt_no" >				<!-- 추가-민정호 -->
<input type="hidden" name="trsp_agmt_rt_tp_cd" >	<!-- 추가-민정호 -->
<input type="hidden" name="gubun" value="notsave">	<!-- 추가-민정호 -->
<input type="hidden" name="chk_trsp_cost_mod_cd" >
<input type="hidden" name="chk_agmt_trsp_tp_cd" >
<input type="hidden" name="chk_cgo_tp_cd" >
<input type="hidden" name="chk_cust_cd" >
<input type="hidden" name="chk_cmdt_grp_cd" >
<input type="hidden" name="chk_rail_svc_tp_cd" >
<input type="hidden" name="chk_fm_nod_cd" >
<input type="hidden" name="chk_fm_nod_yd" >
<input type="hidden" name="chk_via_nod_cd" >
<input type="hidden" name="chk_via_nod_yd" >
<input type="hidden" name="chk_dor_nod_cd" >
<input type="hidden" name="chk_dor_nod_yd" >
<input type="hidden" name="chk_to_nod_cd" >
<input type="hidden" name="chk_to_nod_yd" >
<input type="hidden" name="chk_trsp_dist_tp_cd" >
<input type="hidden" name="chk_trsp_agmt_dist" >
<input type="hidden" name="chk_dist_meas_ut_cd" >
<input type="hidden" name="chk_trsp_scg_cd">			<!-- 추가-민정호 -->
<input type="hidden" name="chk_agmt_route_all_flg">		<!-- 추가-민정호 -->
<input type="hidden" name="delete_yn" value="N"> <!-- 아래의 combo box 대체처리 -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>        
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
      
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
        </table>
      </td></tr>
      </table>
      <!--Button (E) -->
  
      <div id="MiniLayer" style="display:inline">
      <!--biz page (S)-->
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            <!--  biz_1  (S) --> 
            <!--  필수조건 표시하는 셀 색깔을 설정해주는 코드 :  class="input1"  -->
            <table class="search" border="0" style="width:940px;"> 
              <tr class="h23">
                <td width="100" align="right">From</td>
                <td width="70">
                  <input type="text" name = "search_fm_loc" style="width:70;" class="input1" onFocus='fun_Focus(this)' onChange="getComboList(this, document.search_fm_yard, 'F');" onBlur="" maxlength="5">
                </td>
                <td width="81">
                  <script language="javascript">ComComboObject('search_fm_yard', 1, 60, 0)</script><img src="" width="2" height="2" border="0" align="absmiddle"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode">
                </td>
                <td width="92" align="right">Via</td>
                <td width="60">
                  <input type="text" name = "search_via_loc" style="width:60;" class="input1" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_via_yard, 'V');" onBlur="" maxlength="5">
                </td>
                <td width="81">
                  <script language="javascript">ComComboObject('search_via_yard', 1, 60, 0)</script><img src="" width="2" height="2" border="0" align="absmiddle"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_vianode">
                </td>
                <td width="100" align="right">Door</td>
                <td width="60">
                  <input type="text" name = "search_door_loc" style="width:60;" class="input1" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_door_yard, 'D');"  onBlur="" maxlength="5">
                </td>
                <td width="81">
                  <script language="javascript">ComComboObject('search_door_yard', 1, 60, 0)</script><img src="" width="2" height="2" border="0" align="absmiddle"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_dornode">
                </td>
                <td width="48" align="right">To</td>
                <td width="60">
                  <input type="text" name = "search_to_loc" style="width:60;" class="input1" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_to_yard, 'T');"  onBlur="" maxlength="5">
                </td>
                <td width="81"> 
                  <script language="javascript">ComComboObject('search_to_yard', 1, 60, 0)</script><img src="" width="2" height="2" border="0" align="absmiddle"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_tonode">
                </td>
              </tr>             
              <tr class="h23">
                <td width="100" align="right">Cost Mode</td>
                <td width="70" colspan="2">
                  <select name="costmode" style="width:70;">
                    <option value = ""> </option>
                    <option value = "CY">CY</option>
                    <option value = "DC">DC</option>
                    <option value = "DR">DR</option>
                    <option value = "BS">BS</option>
                    <option value = "BF">BF</option>
                    <option value = "MF">MF</option>
                    <option value = "MM">MM</option>
                  </select>
                </td>
                <td width="92" align="right">Cargo Type</td>
                <td width="105" colspan="2">
                  <%=selCARGOMODE%>
                </td>
                <td width="100" align="right">Service Provider</td>
                <td width="230" colspan="5">
                  <input name="fm_vndr_prmry_seq" type="text" style="width:80;" class="input" value="" onBlur="vender_blur();">
                  <input name="fm_vndr_prmry_nm" type="text" style="width:117;" class="input" value="" readonly>
                  <img name='btn_serviceprovider' class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
              </tr>             
              <tr class="h23">
                <td width="100" align="right">Trans Mode</td>
                <td width="70" colspan="2">
                  <%=selTRANSMODE%>
                </td>
                <td width="92" align="right">EQ</td>
                <td width="230" colspan="3">
                  <select name="eqtype" style="width:80;" class='input1'">
                    <option value="U" selected>Container</option>
                    <option value="Z" >Chassis</option>
                    <option value="G" >Genset</option>
                  </select>
				  <script language="javascript">ComComboObject('combo1', 1, 130, 1)</script>
				  <input type="hidden" name="eqtpsz" value="">
                </td>
                <td width="60" align="right">AGMT No.</td>
                <td width="150" colspan="4">
                  <input name="fm_agmtno" type="text" style="width:80;" class="input" value="" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);">
                  <img name='btn_agmtno' class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
              </tr> 
              <tr class="h23">
              	<td width="100" align="right">Effective AGMT</td>
              	<td width="70" colspan="2">
                  <select style="width:70;" class="input" name="fm_effective_agmt" onChange="effective_agmt_change()">
                    <option value="C" selected>LATEST</option>
                    <option value="A">ALL</option>
                  </select>           	
              	</td>
              	
                <td width="92" align="right">Effective date</td>
                <td width="130" colspan="3">        	
              	<input type="text" name="effective_date" style="width:75" value="<%=today%>" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" disabled>
              	<div id="effLayer" style="display:none"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"></div>
              	</td>
              	
               	<!-- td width="60" align="right">Delete</td>
              	<td width="60">
                  <select style="width:60;" class="input" name="delete_yn" >
                     <option value="" selected>ALL</option>
					 <option value="N">N</option>
					 <option value="Y">Y</option>
                  </select>           	
              	</td --> 
              	
               </tr>             
            </table>
          <!--  biz_1   (E) -->
          </td>
        </tr>     
      </table>
      <table class="height_8"><tr><td></td></tr></table>  
      </div>
    </td>
  </tr>
</table>
    
<table class="height_8"><tr><td></td></tr></table>  

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;"> 
  <tr>
    <td>
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            <table width="100%" border="0" > 
              <tr class="h23">
                <td width="70">Page Size :</td>
                <td width="90">
                  <select style="width:60;" class="input" name="page_size" onChange="javascript:reset_all();">
                    <option value="500">500</option>
                    <option value="1000">1000</option>
                    <option value="3000" selected>3000</option>
                    <option value="5000">5000</option>
                  </select>
                </td>
                <td align="left" width="30"><img class="cursor" img src="/hanjin/img/bu_prev02.gif" border="0" name="reward"></td>
                <td align="left" width="45" class="title_s">Page :</td>
                <td align="left" width="32" valign="bottom"><input type="text"  class="input2" style="width:30; valign:bottom; text-align:right;"  name="tot_page_cnt" value="0"></td>
                <td align="left" width="38" valign="bottom"><input type="text" style="width:30; valign:bottom; text-align:right"  name="cur_page_cnt" value="1" onkeydown="if (event.keyCode == 13) gotopage();"></td>
                <td><img class="cursor" img src="/hanjin/img/bu_next02.gif" border="0" name="forward"></td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Grid ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet_main');</script>
                </td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Grid ) (E) -->

            <!-- : ( Button_ Sub ) (S) -->
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <!-- Repeat Pattern -->
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <!-- Repeat Pattern -->
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <!-- : ( Button_ Sub ) (E) -->
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<table class="height_10"><tr><td colspan="8"></td></tr></table>
<script language="javascript">ComSheetObject('sheet_tpsz');</script>
</form>
</body>
</html>
