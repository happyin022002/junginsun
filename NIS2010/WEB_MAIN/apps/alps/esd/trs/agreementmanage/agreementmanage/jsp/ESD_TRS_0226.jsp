<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0226.jsp
*@FileTitle : Agreement Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.05
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2010.03.18 최종혁
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.09.13 최종혁 1.1 [CHM-201005934] [TRS] AGMT Verification Error 내용 table 추가 요청
* 2010.10.05 최 선     1.2 [CHM-201006313] From, Via, Door, To POP UP 조회 추가
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception					serverException		= null;			//서버에서 발생한 에러
	String						strErrMsg			= "";								 //에러메세지
	String userId	 = "";
	String ofcCd     = "";
	String agmt_no = ((request.getParameter("chk_agmt_no")==null )?"":request.getParameter("chk_agmt_no"));		
	String trsp_agmt_rt_tp_ser_no = ((request.getParameter("chk_trsp_agmt_rt_tp_ser_no")==null )?"":request.getParameter("chk_trsp_agmt_rt_tp_ser_no"));	
	String trsp_agmt_rt_tp_cd = ((request.getParameter("chk_trsp_agmt_rt_tp_cd")==null )?"":request.getParameter("chk_trsp_agmt_rt_tp_cd"));
	String fm_effective_agmt     = ((request.getParameter("fm_effective_agmt")==null )?"":request.getParameter("fm_effective_agmt"));

	String sub_title = "";
	
	try {
		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId						= account.getUsr_id();
	   	ofcCd						= account.getOfc_cd();
		serverException				= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (!trsp_agmt_rt_tp_ser_no.equals("")) {
			sub_title = " (Rate Type)";
		}
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Agreement Rate Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<%= JSPUtil.getIBCodeCombo("trsp_cost_mod_cd",	"", "CD02177", 0, "")%>
<%= JSPUtil.getIBCodeCombo("agmt_trsp_tp_cd",	"", "CD00283", 0, "")%>
<%= JSPUtil.getIBCodeCombo("cgo_tp_cd",			"", "CD00748", 0, "")%>
<%= JSPUtil.getIBCodeCombo("rail_svc_tp_cd",	"", "CD00916", 0, "")%>
<%= BizComUtil.getIBCodeCombo("curr_cd",		"", "CURR", 0, "")%>
<%= JSPUtil.getIBCodeCombo("wtr_term_cd",	    "", "CD01354", 0, "")%>

  function setupPage(){
	var formObject = document.form;
	formObject.fm_trsp_agmt_rt_tp_cd.value = "<%=trsp_agmt_rt_tp_cd%>";
    loadPage();
  }
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="fm_sub_title"	  value="<%=sub_title%>">
<input type="hidden" name="f_cmd" >
<input type="hidden" name="header_row"	>
<input type="hidden" name="tot_page_cnt"	  value="">
<input type="hidden" name="cur_page_cnt"	  value="">
<input type="hidden" name="page_size"	  value="5000">
<input type="hidden" name="grid_flg"	  value="Y">
<input type="hidden" name="TRSP_SO_EQ_KIND" 		value="">
<input type="hidden" name="fm_eq_knd_cd" >
<input type="hidden" name="fm_trsp_agmt_rt_tp_ser_no" value="<%=trsp_agmt_rt_tp_ser_no%>">
<input type="hidden" name="fm_effective_agmt"   value="<%=fm_effective_agmt%>">

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

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td>
      <!-- TABLE (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Agreement Rate Inquiry <%=sub_title%></td></tr>
      </table>
      <!-- TABLE (E) -->
      
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td id="td_downexcel" name="td_downexcel">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
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
  
      <!--biz page (S)-->
      <table class="height_8"><tr><td></td></tr></table>  
      <div id="MiniLayer" style="display:inline">
      <!--  biz_1  (S) -->
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            <table class="search" border="0" style="width:950;"> 
              <tr class="h23">
                <td width="" valign="top">
                  <table class="search" border="0" style="width:100%;">
                    <tr class="h23">
                      <td width="100">Agreement No.</td>
                      <td width="110"><input name="fm_agmtno" type="text" style="width:80;" class="input" value="<%=agmt_no%>" readonly></td>   
                      <td width="100">Service Provider</td>
                      <td width="60"><input name="fm_vndr_prmry_seq" type="text" style="width:65;" readonly></td>
                      <td width="170"><input name="fm_vndr_prmry_nm" type="text" style="width:141;" readonly></td>
                    </tr>
                  
                    <tr class="h23">
                      <td>Contract Office</td>
                      <td><input name="fm_ctrt_ofc_cd" type="text" style="width:80;" readonly></td>
                      <td>AGMT Type</td>
                      <td colspan="2">
                        <select style="width:95;" class="input" name="fm_trsp_agmt_rt_tp_cd" disabled>
                          <option value="P">Pair</option>
                          <option value="D">Distance</option>
                          <option value="PD">Pair/Distance</option>
                          <option value="DP">Distance/Pair</option>
                        </select>
                      </td>
                    </tr>

                    <tr class="h23">
                      <td>Reference No.</td>
                      <td><input name="fm_agmt_ref_no" type="text" style="width:80;" readonly></td>
                      <td>Remark</td>
                      <td colspan="2"><input name="fm_inter_rmk" type="text" style="width:210;" readonly></td>
                    </tr>
                  </table>
                  <script language="javascript">ComSheetObject('sheet0');</script>
                </td>
                <td width="40"></td>
                <td width="360">
                  <table width="100%" id="mainTable">
                    <tr>
                      <td>
                        <script language="javascript">ComSheetObject('sheet1');</script>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
              <tr><td></td></tr>
            </table>
          </td>
        </tr>
      </table>
      </div>
      <!--  biz_1   (E) -->
    </td>
  </tr>
</table>


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td>
      <!--biz page (S)-->
      <table class="height_8"><tr><td></td></tr></table>  
      <!--  biz_1  (S) -->
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            <table class="search_in" border="0" style="width:950;">
              <tr class="h23">
                <td width="30">From </td>
                <td width="64" align="left"><input name="search_fm_loc" type="text" style="width:60;" maxlength="5" onChange="getComboList(this, document.form.search_fm_yard, 'F');" onBlur="setgetUpper(this);"></td>
                <td width="85"><script language="javascript">ComComboObject('search_fm_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="2" height="1" border="0">
                  <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode">
                </td>
                <td width="20">Via </td>
                <td width="64"><input name="search_via_loc" type="text" style="width:60;" maxlength="5" onChange="getComboList(this, document.search_via_yard, 'V');" onBlur="setgetUpper(this);"></td>
                <td width="100"><script language="javascript">ComComboObject('search_via_yard', 1, 45, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="1" border="0">
                  <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_vianode">
                </td>
                <td width="20">Door </td>
                <td width="64"><input name="search_door_loc" type="text" style="width:60;" maxlength="5" onChange="getComboList(this, document.search_door_yard, 'D');" onBlur="setgetUpper(this);"></td>
                <td width="92"><script language="javascript">ComComboObject('search_door_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="2" height="1" border="0">
                  <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_dornode">
                </td>
                <td width="35">To </td>
                <td width="64"><input name="search_to_loc" type="text" style="width:60;" maxlength="5" onChange="getComboList(this, document.search_to_yard, 'T');" onBlur="setgetUpper(this);"></td>
                <td width="92"><script language="javascript">ComComboObject('search_to_yard', 1, 48, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="1" border="0">
                  <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tonode">
                </td>
                <td width="55">Distance</td>
                <td width="">
                  <input name="fm_trsp_agmt_dist" type="text" style="width:100%;" class="input" >
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--  biz_1   (E) -->
    </td>
  </tr>
</table>

<table class="height_8"><tr><td></td></tr></table>  

<!-- TABLE '#D' : ( Tab ) (S) -->
<table class="tab">
  <tr><td><script language="javascript">ComTabObject('tab1' )</script></td></tr>
</table>
<!-- TABLE '#D' : ( Tab ) (E) -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;"> 
  <tr>
    <td>
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">

            <!-- TABLE '#D' : ( Grid ) (S) -->
            <div id="tabLayer" style="display:inline">
            <table> 
              <tr>
                <td>
                  <!--  biz_1  (S) -->
                  <table border="0">
                    <tr class="h23">
                      <td width="626"></td>
                      <td width="70">Page Size :</td>
                      <td width="90">
                        <select style="width:60;" class="input" name="page_size1" onChange="javascript:input_change();">
                          <option value="500">500</option>
                          <option value="1000">1000</option>
                          <option value="3000" selected>3000</option>
                          <option value="5000">5000</option>
                        </select>
                      </td>
                      <td align="left" width="30"><img class="cursor" img src="/hanjin/img/bu_prev02.gif" border="0" name="reward1"></td>
                      <td align="left" width="45" class="title_s">Page :</td>
                      <td align="left" width="32" valign="bottom"><input type="text"  class="input2" style="width:30; valign:bottom; text-align:right;"  name="tot_page_cnt1" value="0"></td>
                      <td align="left" width="38" valign="bottom"><input type="text" style="width:30; valign:bottom; text-align:right"  name="cur_page_cnt1" onkeydown="if (event.keyCode == 13) gotopage();"></td>
                      <td><img class="cursor" img src="/hanjin/img/bu_next02.gif" border="0" name="forward1"></td>
                    </tr>
                  </table>
                  <!--  biz_1   (E) -->
                </td>
              </tr>
            </table>
            
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
              </tr>
            </table>
            </div>
            <!-- TABLE '#D' : ( Grid ) (E) -->
            <div id="tabLayer" style="display:none">
            <table> 
              <tr>
                <td>
                  <!--  biz_1  (S) -->
                  <table border="0">
                    <tr class="h23">
                      <td width="626"></td>
                      <td width="70">Page Size :</td>
                      <td width="90">
                        <select style="width:60;" class="input" name="page_size2" onChange="javascript:input_change();">
                          <option value="500">500</option>
                          <option value="1000">1000</option>
                          <option value="3000" selected>3000</option>
                          <option value="5000">5000</option>
                        </select>
                      </td>
                      <td align="left" width="30"><img class="cursor" img src="/hanjin/img/bu_prev02.gif" border="0" name="reward2"></td>
                      <td align="left" width="45" class="title_s">Page :</td>
                      <td align="left" width="32" valign="bottom"><input type="text"  class="input2" style="width:30; valign:bottom; text-align:right;"  name="tot_page_cnt2" value="0"></td>
                      <td align="left" width="38" valign="bottom"><input type="text" style="width:30; valign:bottom; text-align:right"  name="cur_page_cnt2" value="1" onkeydown="if (event.keyCode == 13) gotopage();"></td>
                      <td><img class="cursor" img src="/hanjin/img/bu_next02.gif" border="0" name="forward2"></td>
                    </tr>
                  </table>
                  <!--  biz_1   (E) -->
                </td>
              </tr>
            </table>
            
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet3');</script>
                </td>
              </tr>
            </table>
            </div>

            <div id="tabLayer" style="display:none">
            <table> 
              <tr>
                <td>
                  <!--  biz_1  (S) -->
                  <table border="0"> 
                    <tr class="h23">
                      <td width="626"></td>
                      <td width="70">Page Size :</td>
                      <td width="90">
                        <select style="width:60;" class="input" name="page_size3" onChange="javascript:input_change();">
                          <option value="500">500</option>
                          <option value="1000">1000</option>
                          <option value="3000" selected>3000</option>
                          <option value="5000">5000</option>
                        </select>
                      </td>
                      <td align="left" width="30"><img class="cursor" img src="/hanjin/img/bu_prev02.gif" border="0" name="reward3"></td>
                      <td align="left" width="45" class="title_s">Page :</td>
                      <td align="left" width="32" valign="bottom"><input type="text"  class="input2" style="width:30; valign:bottom; text-align:right;"  name="tot_page_cnt3" value="0"></td>
                      <td align="left" width="38" valign="bottom"><input type="text" style="width:30; valign:bottom; text-align:right"  name="cur_page_cnt3" value="1" onkeydown="if (event.keyCode == 13) gotopage();"></td>
                      <td><img class="cursor" img src="/hanjin/img/bu_next02.gif" border="0" name="forward3"></td>
                    </tr>
                  </table>
                  <!--  biz_1   (E) -->
                </td>
              </tr>
            </table>
            
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet4');</script>
                </td>
              </tr>
            </table>
            </div>

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
                            <td class="btn2" id="btng_history" name="btng_history">Rate History</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
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
</form>
</body>
</html>
