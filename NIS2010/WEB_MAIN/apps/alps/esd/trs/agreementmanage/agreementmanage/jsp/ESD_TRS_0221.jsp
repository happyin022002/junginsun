<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0221.jsp
*@FileTitle : Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010-03-18
*@LastModifier : cjh
*@LastVersion : 1.0
* 2010-03-18 cjh
* 1.0 최초 생성
 * History
 * 2010.09.13 최종혁 [CHM-201005934] [TRS] AGMT Verification Error 내용 table 추가 요청
 * 2014.06.12 최종혁 [CHM-201430337] Row Copy 기능 추가
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException = null;	//서버에서 발생한 에러
	String	  strErrMsg	= "";			//에러메세지
	String	  userId    = "";
	String	  ofcCd		= "";

	try {
		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId						= account.getUsr_id();
	   	ofcCd						= account.getOfc_cd();
		serverException				= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Agreement Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<%= JSPUtil.getIBCodeCombo("trsp_cost_mod_cd",	"", "CD02177", 0, "")%>
<%= JSPUtil.getIBCodeCombo("agmt_trsp_tp_cd",	"", "CD00283", 0, "")%>
<%= JSPUtil.getIBCodeCombo("cgo_tp_cd",			"", "CD00748", 0, "")%>
<%= JSPUtil.getIBCodeCombo("rail_svc_tp_cd",	"", "CD00916", 0, "")%>
<%= BizComUtil.getIBCodeCombo("curr_cd",		"", "CURR", 0, "")%>
<%= JSPUtil.getIBCodeCombo("wtr_term_cd",	    "", "CD01354", 0, "")%>

  function setupPage(){
    loadPage();
  }
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="f_cmd" >
<input type="hidden" name="fm_trsp_agmt_rt_tp_cd"	  value="">
<input type="hidden" name="header_row"	>
<input type="hidden" name="fm_eq_knd_cd"	  value="U">
<input type="hidden" name="TRSP_SO_EQ_KIND" 		value="">

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
                      <td class="btn1" id="btn_creation" name="btn_creation">AGMT Create</td>
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
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:270;"> 
              <tr class="h23">
                <td width="100">Agreement No.</td>
                <td width="130">
                  <input name="fm_agmtno" type="text" style="width:80;" class="input" value="" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);">
                  <img name='btn_agmtno' class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
              </tr>
            </table>
            <!--  biz_1   (E) -->
          </td>
        </tr>
      </table>
    
      <div id="MiniLayer" style="display:inline">
      <table class="height_8"><tr><td></td></tr></table>  
      <!--  biz_1  (S) -->
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                <td width="" valign="top">
                  <table class="search" border="0" style="width:100%;">
                    <tr class="h23">
                      <td width="108">Service Provider</td>
                      <td width="62"><input name="fm_vndr_prmry_seq" type="text"  style="width:60;" readonly></td>
                      <td width="170"><input name="fm_vndr_prmry_nm" type="text" style="width:165;" readonly></td>
                      <td colspan="2" width="50"></td>
                    </tr>
                    <tr class="h23">
                      <td>Reference No.</td>
                      <td colspan="2"><input name="fm_agmt_ref_no" type="text" style="width:227;" readonly></td>
                      <td width="140" align="right">Contract Office</td>
                      <td align="right"><input name="fm_ctrt_ofc_cd" type="text" style="width:77;" readonly></td>
                    </tr>
                    <tr class="h23">
                      <td>Remarks</td>
                      <td colspan="4"><input name="fm_inter_rmk" type="text" style="width:100%;" readonly></td>
                    </tr>
                    <tr class="h23">
                      <td colspan="5"><font color ="RED">EQ type D3 and D2 are treated in the same way.</font></td>
                    </tr>
                  </table>
                  <script language="javascript">ComSheetObject('sheet0');</script>
                </td>
                <td width="30"></td>
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
            <table> 
              <tr>
                <td>
                  <!--  biz_1  (S) -->
                  <table border="0" style="width:800;"> 
                    <tr class="h23">
                      <td width="94">Effective Date</td>
                      <td width="">
                        <input name="fm_eff_fm_dt" type="text" style="width:80;" class="input" value="" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" >&nbsp;~&nbsp;
                        <input name="fm_eff_to_dt" type="text" style="width:80;" class="input" value="" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" >&nbsp;
                        <img src="/hanjin/img/button/btns_calendar.gif" class="cursor" width="19" height="20" alt="" border="0" align="absmiddle" name="btng_calendar">
                      </td>
                      
                      <td width="5"></td>
                      <td width="100">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_date_apply" name="btng_date_apply">Date Apply</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      
                      <td width="50"></td>
                      
                      <td width="140">Agreement Type</td>
                      <td class="stm">
                        <input name="fm_trsp_agmt_rt_tp_radio" type="radio" value="" class="trans" onChange="input_change();" checked>&nbsp;P&nbsp;&nbsp;&nbsp;
                        <input name="fm_trsp_agmt_rt_tp_radio" type="radio" value="" class="trans" onChange="input_change();">&nbsp;D&nbsp;&nbsp;&nbsp;
                        <input name="fm_trsp_agmt_rt_tp_radio" type="radio" value="" class="trans" onChange="input_change();">&nbsp;PD&nbsp;&nbsp;&nbsp;
                        <input name="fm_trsp_agmt_rt_tp_radio" type="radio" value="" class="trans" onChange="input_change();">&nbsp;DP
                      </td>
                      
                    </tr>
                  </table>
                  <!--  biz_1   (E) -->
                </td>
              </tr>
            </table>
            
            <div id="tabLayer" style="display:inline">
            <!-- TABLE '#D' : ( Grid ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
              </tr>
            </table>
            <table>
              <tr class="bg_b1" height="5">
                <td class="title_h"></td>
                <td align="left" class="title_s">Verify Error&nbsp;:&nbsp;</td>
                <td align="left" valign="bottom">&nbsp;<input type="text"  class="input2" style="width:30;valign:bottom;"  name="verify_result_1" value="0" readonly></td>
                <td align="left" valign="bottom">&nbsp;&nbsp;<input type="text"  class="input2" style="width:304;valign:bottom;font-color:red;"  name="verify_result_str_1" value="( UPDATE DISABLE! )" readonly></td>
                <td align="left" class="title_s">&nbsp;&nbsp;&nbsp;Updated Row Count&nbsp;:&nbsp;</td>
                <td align="left" valign="bottom">&nbsp;
                  <input type="text"  class="input2" style="width:35;valign:bottom;"  name="updated_rows_cnt_1" value="0" readonly>&nbsp;/
                  <input type="text"  class="input2" style="width:35;valign:bottom;"  name="total_rows_cnt_1" value="0" readonly>&nbsp;
                  <input type="hidden" name="verify_check_yn_1"	value="N">
                  <input type="hidden" name="message_1"	>
                  <input type="hidden" name="nosave_1" value="N">
                </td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Grid ) (E) -->
            </div>
            <div id="tabLayer" style="display:none">
            <!-- TABLE '#D' : ( Grid ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet3');</script>
                </td>
              </tr>
            </table>
            <table>
              <tr class="bg_b1" height="5">
                <td class="title_h"></td>
                <td align="left" class="title_s">Verify Error&nbsp;:&nbsp;</td>
                <td align="left" valign="bottom">&nbsp;<input type="text"  class="input2" style="width:30;valign:bottom;"  name="verify_result_2" value="0" readonly></td>
                <td align="left" valign="bottom">&nbsp;&nbsp;<input type="text"  class="input2" style="width:304;valign:bottom;font-color:red;"  name="verify_result_str_2" value="( UPDATE DISABLE! )" readonly></td>
                <td align="left" class="title_s">&nbsp;&nbsp;&nbsp;Updated Row Count&nbsp;:&nbsp;</td>
                <td align="left" valign="bottom">&nbsp;
                  <input type="text"  class="input2" style="width:35;valign:bottom;"  name="updated_rows_cnt_2" value="0" readonly>&nbsp;/
                  <input type="text"  class="input2" style="width:35;valign:bottom;"  name="total_rows_cnt_2" value="0" readonly>&nbsp;
                  <input type="hidden" name="verify_check_yn_2"	value="N">
                  <input type="hidden" name="message_2"	>
                  <input type="hidden" name="nosave_2" value="N">
                </td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Grid ) (E) -->
            </div>
            
            <div id="tabLayer" style="display:none">
            <!-- TABLE '#D' : ( Grid ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet4');</script>
                </td>
              </tr>
            </table>
            <table>
              <tr class="bg_b1" height="5">
                <td class="title_h"></td>
                <td align="left" class="title_s">Verify Error&nbsp;:&nbsp;</td>
                <td align="left" valign="bottom">&nbsp;<input type="text"  class="input2" style="width:30;valign:bottom;"  name="verify_result_3" value="0" readonly></td>
                <td align="left" valign="bottom">&nbsp;&nbsp;<input type="text"  class="input2" style="width:304;valign:bottom;font-color:red;"  name="verify_result_str_3" value="( UPDATE DISABLE! )" readonly></td>
                <td align="left" class="title_s">&nbsp;&nbsp;&nbsp;Updated Row Count&nbsp;:&nbsp;</td>
                <td align="left" valign="bottom">&nbsp;
                  <input type="text"  class="input2" style="width:35;valign:bottom;"  name="updated_rows_cnt_3" value="0" readonly>&nbsp;/
                  <input type="text"  class="input2" style="width:35;valign:bottom;"  name="total_rows_cnt_3" value="0" readonly>&nbsp;
                  <input type="hidden" name="verify_check_yn_3"	value="N">
                  <input type="hidden" name="message_3"	>
                  <input type="hidden" name="nosave_3" value="N">
                </td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Grid ) (E) -->
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
                            <td class="btn2" id="btng_surcharge" name="btng_surcharge">Surcharge</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_rowcopy" name="btng_rowcopy">Copy Add</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_loadexcel" name="btng_loadexcel">File Import</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_delete" name="btng_delete">Delete</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_reset" name="btng_reset">Reset</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_verify" name="btng_verify">Verify</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_update" name="btng_update">Update</td>
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
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_help" name="btng_help">Verify Rule</td>
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
