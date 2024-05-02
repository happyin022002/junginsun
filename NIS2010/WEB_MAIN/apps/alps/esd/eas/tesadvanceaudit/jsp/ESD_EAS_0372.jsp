<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ESD_EAS_0372.jsp
*@FileTitle : TES Auto Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-14
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0372Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
	String strUsr_id = "";
	String strOfc_cd = "";
	
	String s_popup_flg = "";
	String s_popup_rhq_cd = "";
	String s_popup_inv_ofc_cd = "";
	String s_popup_fm_dt = "";
	String s_popup_to_dt = "";
	String s_popup_auto_aud_sts_cd = "";
	String s_popup_expn_aud_sts_cd = "";
	
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.eas.ESD_EAS_0380");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strOfc_cd = account.getOfc_cd();

		s_popup_flg = (StringUtil.xssFilter(request.getParameter("s_popup_flg"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_flg"));
		s_popup_rhq_cd = (StringUtil.xssFilter(request.getParameter("s_popup_rhq_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_rhq_cd"));
		s_popup_inv_ofc_cd = (StringUtil.xssFilter(request.getParameter("s_popup_inv_ofc_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_inv_ofc_cd"));
		s_popup_fm_dt = (StringUtil.xssFilter(request.getParameter("s_popup_fm_dt"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_fm_dt"));
		s_popup_to_dt = (StringUtil.xssFilter(request.getParameter("s_popup_to_dt"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_to_dt"));
		s_popup_auto_aud_sts_cd = (StringUtil.xssFilter(request.getParameter("s_popup_auto_aud_sts_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_auto_aud_sts_cd"));
		s_popup_expn_aud_sts_cd = (StringUtil.xssFilter(request.getParameter("s_popup_expn_aud_sts_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_expn_aud_sts_cd"));
		
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TES Auto Audit</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<%= JSPUtil.getIBCodeCombo("s_expn_aud_sts_cd", "", "CD03410", 0, " ")%>
<%= JSPUtil.getIBCodeCombo("auto_expn_aud_sts_cd", "01", "CD03417", 0, " ")%>
<%= JSPUtil.getIBCodeCombo("expn_aud_sts_cd", "", "CD03348", 0, "")%>
<%= JSPUtil.getIBCodeCombo("tml_inv_rjct_sts_cd", "", "CD00173", 0, "")%>
<%= JSPUtil.getIBCodeCombo("csr_sts_cd",      "", "CD03411", 0, " ")%>
<%=JSPUtil.getIBCodeCombo("bat_prog_sts_cd", "01", "CD03051", 0, "")%>
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="login_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="ofc_cd"		value="<%=strOfc_cd%>">
<input type="hidden" name="ofclevel">

<!-- Audit Remark Popup -->
<input type="hidden" name="pop_parent_row">
<input type="hidden" name="pop_expn_aud_rslt_usr_nm">
<input type="hidden" name="pop_expn_aud_rslt_usr_id">
<input type="hidden" name="pop_expn_aud_rslt_rmk">
<input type="hidden" name="pop_ofcLevel">
<input type="hidden" name="s_save_tp_cd">

<!-- // CHM-201539630 Split03-Auto Audit Change Detail 수정 요청 - (2016-01-05 김대준C)  -->
<input type="hidden" name="pop_mdl_tp_cd">
<input type="hidden" name="pop_atch_file_lnk_flg">
<input type="hidden" name="pop_auto_aud_sts_cd">
<input type="hidden" name="pop_expn_aud_sts_cd">
<input type="hidden" name="pop_atch_file_lnk_id">
<input type="hidden" name="pop_expn_aud_rslt_cd">
<input type="hidden" name="pop_inv_no">

<input type="hidden" name="s_popup_flg" value="<%=s_popup_flg%>">
<input type="hidden" name="s_popup_rhq_cd" value="<%=s_popup_rhq_cd%>">
<input type="hidden" name="s_popup_inv_ofc_cd" value="<%=s_popup_inv_ofc_cd%>">
<input type="hidden" name="s_popup_fm_dt" value="<%=s_popup_fm_dt%>">
<input type="hidden" name="s_popup_to_dt" value="<%=s_popup_to_dt%>">
<input type="hidden" name="s_popup_auto_aud_sts_cd" value="<%=s_popup_auto_aud_sts_cd%>">
<input type="hidden" name="s_popup_expn_aud_sts_cd" value="<%=s_popup_expn_aud_sts_cd%>">

<input type="hidden" name="s_today">

<input type="hidden" name="pop_inv_aud_curr_cd">
<input type="hidden" name="pop_inv_usd_diff_amt">
<input type="hidden" name="pop_inv_aud_diff_amt">
<input type="hidden" name="pop_inv_cfm_dt">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

     <!--Button_L (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
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
                      <td class="btn1" id="btn_new" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_confirm" name="btn_confirm">Confirm</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_down_excel" name="btn_down_excel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <!-- Repeat Pattern -->
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button_L (E) -->
	
	<!--biz page (S)-->
		<table class="search" > 
       	<tr><td class="bg">		
			<!-- biz_1  (S) -->
            <table class="search_in" border="0" style="width:100%;">
				<tr class="h23">
					<td width="75">RHQ</td>
					<td width="130" style="padding-left:2"><script language="javascript">ComComboObject('s_rhq_ofc_cd',1,93,0);</script></td>
					<td width="65">Inv Office</td>
					<td width="170" style="padding-left:2"><script language="javascript">ComComboObject('s_inv_ofc_cd',1,78,0 );</script></td>
					<td width="92">Inv Cfm Date</td>
					<td width="240">
					<input type="text" style="width:70; text-align:Center" name="s_from_inv_cfm_dt" dataformat="ymd" maxlength="8" class="input1" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="fnYearSet(this)">
					<img name="btns_from_inv_cfm_dt" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" class="cursor">
					&nbsp;~&nbsp;
					<input type="text" style="width:70; text-align:Center" name="s_to_inv_cfm_dt" dataformat="ymd" maxlength="8" class="input1" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="fnYearSet(this)">
					<img name="btns_to_inv_cfm_dt" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="">Inv Type</td>
					<td style="padding-left:2"><script language="javascript">ComComboObject('s_tml_inv_tp_cd',1,100,1);</script></td>
				</tr>
				<tr class="h23">
					<td>Yard</td>
					<td class="stm"><input type="text" name="s_loc_cd" dataformat="engup" style="width:45;" maxlength="5" >&nbsp;<script language="javascript">ComComboObject('s_nod_cd', 1, 44, 0)</script> <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"> </td>					
					<td>Vessel</td>
					<td><input type="text" name="s_vsl_cd" dataformat="engup" style="width:77" maxlength="4"></td>
					<td>Inv. S/P</td>
					<td><input type="text" name="s_vndr_seq" dataformat="int" style="width:54" maxlength="6" onBlur='vender_change();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" name="btn_vndr" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" style="width:131" name="s_vndr_seq_name" class="input2" readOnly></td>
					<td>Diff</td>
					<td style="padding-left:2;"><script language="javascript">ComComboObject('s_diff_sgn',1,50,1);</script><input type="text" name="s_diff_rto" style="width:49; text-align:Right;" dataformat="int" maxlength="4"></td>
				</tr>
				<tr class="h23">
					<td>Invoice No.</td>
					<td><input type="text" name="s_inv_no" style="width:89" maxlength="30">
					<img src="img/btns_multisearch.gif" name="inv_no_multi1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td>CSR No.</td>
					<td><input type="text" name="s_csr_no" style="width:150" maxlength="20">
					<img src="img/btns_multisearch.gif" name="csr_no_multi1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td>Audit Status</td>
					<td style="padding-left:2;"><script language="javascript">ComComboObject('s_auto_expn_aud_sts_cd',1,110,1);</script><script language="javascript">ComComboObject('s_expn_aud_sts_cd',1,104,1);</script></td>
					<td>CSR Status</td>
					<td style="padding-left:2;"><script language="javascript">ComComboObject('s_csr_sts_cd',1,100,1);</script></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	
	<!-- TABLE '#D' : ( Search Options ) (E) -->			
	<table class="height_5"><tr><td></td></tr></table>
	<!-- TABLE '#D' : ( Grid ) (S) -->
    	<table class="search">
      		<tr><td class="bg">
			<!-- <table class="height_10"><tr><td></td></tr></table> -->
			<!-- : ( POR ) (S) -->
			<table width="100%" id="mainTable">
	              <tr><td>
	                     <script language="javascript">ComSheetObject('sheet1');</script>
	              </td></tr>
			</table>
			<!-- : ( POR ) (E) -->
			<table width="100%" class="button">
			<tr>
				<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
	                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                            <tr>
	                                <td class="btn2_left"></td>
	                                <td class="btn2" name="btn_rebatch">ReBatch</td>
	                                <td class="btn2_right"></td>
	                            </tr>
	                        </table>
	                    </td>								
						<td>
	                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                            <tr>
	                                <td class="btn2_left"></td>
	                                <td class="btn2" name="btn_detail">Detail</td>
	                                <td class="btn2_right"></td>
	                            </tr>
	                        </table>
	                    </td>								
						<td>
	                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                            <tr>
	                                <td class="btn2_left"></td>
	                                <td class="btn2" name="btn_agreement">Agreement</td>
	                                <td class="btn2_right"></td>
	                            </tr>
	                        </table>
	                    </td>								
					</tr>
				</table>
				</td>
			</tr>
			</table>
		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<div style="display:none;">
	<script language="javascript">ComSheetObject('sheet2');</script>
</div>
</form>
</body>
</html>