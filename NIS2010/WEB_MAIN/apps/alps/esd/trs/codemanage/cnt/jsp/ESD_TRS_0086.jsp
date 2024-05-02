<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_0086.jsp
*@FileTitle : CNT(Customer Nominated Trucker) Registration.
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : JEON JEE YE
*@LastVersion : 1.0
* 2014.06.11 JEON JEE YE
* 1.0 Creation
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.codemanage.cnt.event.EsdTrs0086Event"%>
<%
	SignOnUserAccount account = null; //Session 정보
	EsdTrs0086Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String userId = "";
	String ofcCd = "";
	String userNm = "";
	String today = DateTime.getFormatString("yyyyMMdd");

	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		ofcCd = account.getOfc_cd();
		userNm = account.getUsr_nm();
		event = (EsdTrs0086Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>CNT(Customer Nominated Trucker) Registration</title>
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
<input type="hidden" name="cre_ofc_cd"				  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="fm_account_usr_nm"	  value="<%=userNm%>">
<input type="hidden" name="fm_prc_ctrt_tp_cd" 	value="">
<input type="hidden" name="pgmId" value="ESD_TRS_0086">

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
							<td width="100">Date</td>
							<td width="400" class="stm">
								&nbsp;<script language="javascript">ComComboObject('divcombo', 1, 97, 1)</script>
				  				<input type="hidden" name="s_dt_div_cd" value="00">
								<input name="s_fm_dt" type="text" style="width:75;" dataformat="ymd" maxlength="8" size="10" value="">~
								<input name="s_to_dt" type="text" style="width:75;" dataformat="ymd" maxlength="8" size="10" value="" onKeyup="javascript:doSearchEnter();">
								<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"> 
							</td>
							<td width="120">Effective Date</td>
							<td width="250">
								<input name="s_eff_dt" type="text" style="width:80;" dataformat="ymd" class="input" value="" maxlength="8" size="10">
								<img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_onecalendar">
							</td>					
							<td width="120">&nbsp;&nbsp;&nbsp;Contract No</td>
			                <td width="250">
			                  <!--  <input name=fm_cfm_usr_id type="text" style="width:72;"  value="" onBlur="setgetUpper(this);">-->
			                  <input name="s_ctrt_no" type="text" style="width:184;"  value="" onBlur="setgetUpper(this);"  maxlength=20>
			                </td>
						</tr>
						<tr class="h23">
							<td width="100">Status</td>
							<td width="390">
								&nbsp;<script language="javascript">ComComboObject('stscombo', 1, 197, 1)</script>
				  				<input type="hidden" name="s_disp_sts_cd" value="">
							</td>
							<td width="120">Customer</td>
							<td width="250">
								<input type="text" style="width:80" name='s_cust_seq' maxlength=8 class="input" onchange="setSearchName('cust', this.value);" />
								<input type="text" style="width:100" name='s_cust_seq_nm' maxlength=8 class="input2" readonly><img src="/hanjin/img/blank.gif" width="2" height="1" border="0" readonly>
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_customer'>
							</td>
							<td width="120">&nbsp;&nbsp;&nbsp;Trucker</td>
							<td width="250">
								<input name="s_vndr_seq" type="text" style="width:80;" class="input" value="" onChange="setSearchName('vndr', this.value);" maxlength=6>
								<input name="s_vndr_seq_nm" type="text" style="width:100;" class="input2" value="" readonly>
								<img name='btn_serviceprovider' class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
						</tr>
						
						<tr class="h23">
							<td width="100">Dest</td>
							<td width="390">
				  				&nbsp;<input type="text" name="s_dest_nod_cd" value="">
							</td>
							<td width="740" colspan="4"></td>
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
                            <td class="btn2" id="btng_delete" name="btng_delete">Row Delete</td>
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
								  <td class="btn2" id="btng_approvalrequest" name="btng_approvalrequest">Request to Approval</td>
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
