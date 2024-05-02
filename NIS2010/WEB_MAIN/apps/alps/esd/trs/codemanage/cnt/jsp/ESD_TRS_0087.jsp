<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0087.jsp
*@FileTitle : CNT(Customer Nominated Trucker) Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 김도현
*@LastVersion : 1.0
* 1.0 최초 생성
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.codemanage.cnt.event.EsdTrs0087Event"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	SignOnUserAccount account = null; //Session 정보
	EsdTrs0087Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String userId = "";
	String ofcCd = "";
	String userNm = "";

	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		ofcCd = account.getOfc_cd();
		userNm = account.getUsr_nm();
		event = (EsdTrs0087Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>CNT(Customer Nominated Trucker) Approval</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<%= JSPUtil.getIBCodeCombo("io_bnd_cd", "", "CD00592", 0, "")%>
<%= JSPUtil.getIBCodeCombo("disp_sts_cd", "00", "CD02005", 0, "")%>
<%= JSPUtil.getIBCodeCombo("cust_nomi_trkr_fuel_div_cd", "", "CD03298", 0, "")%>
  function setupPage(){
    loadPage();
  }
</script>

</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" >
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="fm_account_usr_nm"	  value="<%=userNm%>">

<input type="hidden" name="atch_file_lnk_flg" >
<input type="hidden" name="atch_file_lnk_id" >
<input type="hidden" name="real_file_nm" >
<input type="hidden" name="parent_row">
<input type="hidden" name="atch_file_lnk_id">
<input type="hidden" name="mdl_tp_cd">

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
              </tr>
        </table>
      </td></tr>
      </table>
      <!--Button (E) -->
  
        <div id="MiniLayer" style="display:inline">
			<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="height_2" border="0">
						<tr>
							<td></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="50">Date</td>
							<td width="120" class="stm">
								<script language="javascript">ComComboObject('divcombo', 1, 110, 1)</script>
				  				<input type="hidden" name="s_dt_div_cd" value="01">
								<!-- <input name="s_fm_dt" type="text" style="width:75;" maxlength="8" value="" >
								~
								<input name="s_to_dt" type="text" style="width:75;" maxlength="8" value="" onKeyup="javascript:doSearchEnter();">
								<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"> --> 
							</td>
							<td width="90" class="stm">
								<input name="s_fm_dt" type="text" dataformat="ymd" style="width:75;" maxlength="8" value="" >
								~ 
							</td>
							<td width="100" class="stm">
								<input name="s_to_dt" type="text" dataformat="ymd" style="width:75;" maxlength="8" value="" onKeyup="javascript:doSearchEnter();">
								<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
							</td>
							<td width="90">Effective Date</td>
							<td>
								<input name="s_eff_dt" type="text" dataformat="ymd" style="width:75;" class="input" value="" maxlength="8" onFocus=""  onBlur="">
								<img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_onecalendar">
							</td>					
							<td width="80">Contract No</td>
			                <td >
			                  <input name="s_ctrt_no" type="text" style="width:80;"  value="" onBlur="setgetUpper(this);" maxlength=20>
			                </td>
			                <td width="30">CNT</td>
			                <td>
								<SELECT style="width:80;" name='s_cnt_tp_cd'>
										<OPTION value="" selected>All</OPTION>
										<OPTION value="CNT">CNT</OPTION>
										<OPTION value="CPT">CPT</OPTION>
										<OPTION value="HPT">HPT</OPTION>
										<OPTION value="MIC">MIC</OPTION>
									</SELECT>
			                </td>
						</tr>
						<tr class="h23">
							<td>Status</td>
							<td>
								<script language="javascript">ComComboObject('stscombo', 1, 110, 1)</script>
				  				<input type="hidden" name="s_disp_sts_cd" value="">
							</td>
							<td>Door</td>
							<td><input name="s_dor_nod_cd" type="text" style="width:100;"  value="" onBlur="setgetUpper(this);" maxlength=5></td>
							<td>Customer</td>
							<td>
								<input type="text" style="width:75" name='s_cust_seq' maxlength=8 class="input" onchange="setSearchName('cust', this.value);" >
								<input type="text" style="width:90" name='s_cust_seq_nm' maxlength=8 class="input2"  readonly>
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_customer'>
							</td>
							<td>Trucker</td>
							<td colspan="3">
								<input name="s_vndr_seq" type="text" style="width:80;" class="input" value=""  onchange="setSearchName('vndr', this.value);"  maxlength=6>
								<input name="s_vndr_seq_nm" type="text" style="width:115;" class="input2" value="" readonly>
								<img name='btn_serviceprovider' class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
						</tr>
					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>
        
      <table class="height_8"><tr><td></td></tr></table>  
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
            
            <!-- TABLE '#D' : ( Grid ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet1');</script>
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
                            <td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_rowcopy" name="btng_rowcopy">Row Copy</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_rowdelete" name="btng_rowdelete">Row Delete</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_save" name="btng_save">Save</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_comparison" name="btng_comparison">Comparison</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
<!-- 주석처리 2014.12.15 CHM-201432938 CNT 등록 메뉴의 MT Yard 위치 변경 요청  By SHIN DONG IL
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_save" name="btng_save">Save</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
-->

                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_reject" name="btng_reject">Reject</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_approval" name="btng_approval">Approval</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_cancel" name="btng_cancel">Cancel</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_agmt_creation" name="btng_agmt_creation">AGMT Creation</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_agmt_correction" name="btng_agmt_correction">AGMT Correction</td>
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
<script language="javascript">ComSheetObject('sheet_mutistatus');</script>
</form>
</body>
</html>