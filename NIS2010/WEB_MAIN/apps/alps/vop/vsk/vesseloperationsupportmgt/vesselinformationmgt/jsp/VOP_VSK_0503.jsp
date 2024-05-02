<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0503.jsp
*@FileTitle : Vessel Information inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.22 김종옥
* 1.0 Creation
* 
* History
* 2011.04.11 진마리아 [CHM-201109577-01] Delete Vessel Code에 대한 조회 로직 보완 
* 2011.04.26 진마리아 [CHM-201110282-01] 로직 변경 요청(Engine Power 단위 BHP/KW 항목구분)
* 2012.04.02 진마리아 [CHM-201217105-01] Local Vessel name 칼럼 추가 요청건
* 2014.03.17 박다은    [CHM-201428939-01] vessel particular - performance
* 2014.04.16 박다은    [CHM-201429675-01] Voyage Performance내 Lane Code 구분
=========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event.VopVsk0503Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
      VopVsk0503Event  event = null;                             //PDTO(Data Transfer Object including Parameters)
      Exception serverException   = null;            //서버에서 발생한 에러
      String strErrMsg = "";                               //에러메세지
      int rowCount      = 0;                              //DB ResultSet 리스트의 건수

      String successFlag = "";
      String codeList  = "";
      String pageRows  = "100";

      String strUsr_id        = "";
      String strUsr_nm        = "";
      String strUsr_ofc       = "";
      
      String strUsr_Auth           = "";
      String strUsr_Auth_Perf      = "";
      
      String[] AuthOfcList         			= {"PUSMOV", "HAMUOV", "SHAAOV", "NYCNOV", "SINRSO", "CLTCO"};
      String[] AuthOfcListForPerformance    = {"PUSMOV", "CLTCO"};
      
      Logger log = Logger.getLogger("com.hanjin.apps.VesselOperationSupportMgt.VesselInformationMgt");

      try {
            SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
            strUsr_id = account.getUsr_id();
            strUsr_nm = account.getUsr_nm();
            strUsr_ofc = account.getOfc_cd();
            

            for (int i = 0; i < AuthOfcList.length; i++) {
                  if(AuthOfcList[i].equals(strUsr_ofc)){
                        strUsr_Auth = "authed";
                        break;
                  }
                  
            }
            
            for (int i = 0; i < AuthOfcListForPerformance.length; i++) {
                if(AuthOfcListForPerformance[i].equals(strUsr_ofc)){
                      strUsr_Auth_Perf = "authed";
                      break;
                }
                
          }            


            event = (VopVsk0503Event)request.getAttribute("Event");
            serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

            if (serverException != null) {
                  strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
            }

            // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
            GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

      }catch(Exception e) {
            out.println(e.toString());
      }
%>
<html>
<head>
<title>Vessel Information inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
      function setupPage(){
            var errMessage = "<%=strErrMsg%>";
            if (errMessage.length >= 1) {
                  ComShowMessage(errMessage);
            } // end if
            loadPage();
      }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="inc_del_vsl" value="Y">
<input type="hidden" name="mn_eng_kw_pwr">
<input type="hidden" name="strUsr_Auth" value= "<%=strUsr_Auth%>">
<input type="hidden" name="strUsr_Auth_Perf" value= "<%=strUsr_Auth_Perf%>">
<input type="hidden" name="h_vsl_slan_cd">
<input type="hidden" name="h_pf_skd_tp_cd">

<!-- 개발자 작업   -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
      <tr><td valign="top">
      <!--Page Title, Historical (S)-->
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
                  <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
                  <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
            </table>
      <!--Page Title, Historical (E)-->
      
      <!--biz page (S)-->
            <table class="search"> 
                  <tr><td class="bg">
                        <!-- biz_1  (S) -->
                        <table class="search" border="0" style="width:979;"> 
                        <tr class="h23">
                             <td width="80">Vessel Code</td>
                             <td width="460"><input type="text" style="width:40;text-align:center;" class="input1" name="vsl_cd" dataformat="engup" style="ime-mode:disabled" maxlength="4" caption="Vessel Code">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_vsl_cd" alt="" border="0" align="absmiddle" class="cursor">
                                           &nbsp;<input type="text" style="width:200;" class="input2" name="vsl_eng_nm" readOnly>
                                           &nbsp;<input type="text" style="width:150;" class="input2" name="vsl_locl_nm" readOnly></td>
                             
                             <td width="35"></td>
                             <td width="113"><!-- input type="text" style="width:50;" class="input2" name="year" readOnly></td-->
                             	<div style="visibility:hidden">
                             	<input type="hidden" name="nowYear" style="width:50;" class="input2" value="<%=DateTime.getYear()%>">
                             	<script language="javascript">ComComboObject('year', 1, 80, 1);</script>
                             	</div>
                             </td>
                             
                             <td width="90">Updated Date</td>
                             <td width="116"><input type="text" name="upd_dt" style="width:115;text-align:center;" class="input2" readOnly></td>
                             <td width="85"><input type="text" name="upd_usr_id" style="width:80;" class="input2" readOnly></td>
                             </tr>
                        </table>    
                        <!-- biz_1  (E) -->           
                  </td></tr>
            </table>          
                  
      <table class="height_8"><tr><td></td></tr></table>   

<!-- Tab (S) -->
      <table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
            <tr><td width="100%">
                  <script language="javascript">ComTabObject('tab1')</script>
                  <!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
            </td></tr>
      </table>
<!-- Tab (E) -->

<!-- TAB [ Particular I ] (S) -->
<div id="tabLayer" style="display:inline">
            <table class="search"> 
                                   <div id="tabLayer22" style="display:none">
                                   <script language="javascript">ComSheetObject('t1sheet1');</script>
                                   </div>
                                   <!-- Grid  (S) --> 
                                   <!-- table width="100%"  id="mainTable">
                                         <tr>
                                               <td width="100%">
                                                     <script language="javascript">ComSheetObject('t1sheet1');</script>
                                               </td>
                                         </tr>
                                   </table -->
                                   <!-- Grid (E) -->            
            <tr><td class="bg" style="height:425" valign="top">
                        <table class="search" border="0" style="width:979;"> 
                        <tr class="h23">
                             <td width="395" valign="top" rowspan = "7" style="padding:6px; border:1px solid #A3A4C7; ">
                                   <table class="search" border="0">
                                         <tr><td class="title_h"></td>
                                         <td class="title_s">Basic</td></tr>
                                   </table>
                                   <table class="search_sm2" border="0" style="width:410; height:320;"> 
                                         <tr class="h23">
                                               <td width="90">Carrier</td>
                                               <td width="90" colspan="3"><input type="text" style="width:80;text-align:center" class="input" name="crr_cd" readOnly>&nbsp;<!-- <input type="text" style="width:148;" class="input" name="crr_full_nm" readOnly> --></td>
                                               <td width="">Flag</td>
                                               <!--td width=""><input type="text" style="width:60;" class="input" name="vsl_rgst_cnt_cd" readOnly></td-->
                                               <td width=""><input type="text" style="width:25;" class="input" name="cnt_cd" readOnly>&nbsp;<span id="cnt_nm" onmouseover ="msgset('cnt_nm', document.form.cnt_nm.value)" title=""><input type="text" style="width:66;" class="input" name="cnt_nm" readOnly></span></td>
                                               
                                         </tr>
                                         <tr class="h23">
                                               <td width="90">Ship Type</td>
                                               <td width="" colspan="3"><input type="text" style="width:80;text-align:center" class="input" name="vsl_type" readOnly></td>
                                               <td width="">Port of Registry</td>
                                               <td width="" colspan="3"><span id="rgst_port_cd" onmouseover ="msgset('rgst_port_cd', document.form.rgst_port_cd.value)" title=""><input type="text" style="width:95;" class="input" name="rgst_port_cd" readOnly></span></td>
                                               
                                         </tr>
                                         <tr class="h23">
                                               <td width="90">Ownership</td>
                                               <td width="" colspan="3"><input type="text" style="width:80;" class="input" name="vsl_own_ind_cd" readOnly></td>
                                               <td width="">P&I Club</td>
                                               <td width=""><span id="piclb_desc" onmouseover ="msgset('piclb_desc', document.form.piclb_desc.value)" title=""><input type="text" style="width:95;text-align:center" class="input" name="piclb_desc" readOnly></span></td>
                                               
                                         </tr>
                                         <tr class="h23">
                                               <td width="90">New Built</td>
                                               <td width="" colspan="3"><input type="text" style="width:80;text-align:center" class="input" name="vsl_bld_cd" readOnly></td>
                                               <td width="">Heavy Industry</td>
                                               <td width=""><span id="vsl_bldr_nm" onmouseover ="msgset('vsl_bldr_nm', document.form.vsl_bldr_nm.value)" title=""><input type="text" style="width:95;text-align:center" class="input" name="vsl_bldr_nm" readOnly></span></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="90">Keel Laid DT</td>
                                               <td width="" colspan="3"><input type="text" style="width:80;text-align:center" class="input" name="vsl_kel_ly_dt" readOnly></td>
                                               <td width="">Hull No.</td>
                                               <td width=""><input type="text" style="width:95;text-align:center" class="input" name="vsl_hl_no" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="90">Launched DT</td>
                                               <td width="" colspan="3"><input type="text" style="width:80;text-align:center" class="input" name="vsl_lnch_dt" readOnly></td>
                                               <td width="">TEL No.</td>
                                               <td width=""><input type="text" style="width:95" class="input" name="phn_no" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="90">Delivered DT</td>
                                               <td width="" colspan="3"><input type="text" style="width:80;text-align:center" class="input" name="vsl_de_dt" readOnly></td>
                                               <td width="">FAX No.</td>
                                               <td width=""><input type="text" style="width:95" class="input" name="fax_no" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="90">Registered DT</td>
                                               <td width="" colspan="3"><input type="text" style="width:80;text-align:center" class="input" name="rgst_dt" readOnly></td>
                                               <td width="">TLX No.</td>
                                               <td width=""><input type="text" style="width:95" class="input" name="tlx_no" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="90">Call Sign</td>
                                               <td width="" colspan="3"><input type="text" style="width:80;text-align:center" class="input" name="call_sgn_no" readOnly></td>
                                               <td width="">Mail Address</td>
                                               <td width=""><span id="vsl_eml" onmouseover ="msgset('vsl_eml', document.form.vsl_eml.value)" title=""><input type="text" style="width:95" class="input" name="vsl_eml" readOnly></span></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="90">Office No.</td>
                                               <td width="" colspan="3"><input type="text" style="width:80;text-align:center" class="input" name="rgst_no" readOnly></td>
                                               <td width="" > Max. Crew</td>
                                               <td width=""><input type="text" style="width:95;text-align:center" class="input" name="crw_knt" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="90">Class / No.</td>
                                               <td width="" colspan="4"><input type="text" style="width:80;text-align:center;" class="input" name="clss_no_rgst_area_nm">&nbsp;<input type="text" style="width:120;text-align:center" class="input" name="vsl_clss_no" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="90">IMO No.&nbsp;</td>
                                               <td width="" colspan="3"><input type="text" style="width:80;text-align:center" class="input" name="lloyd_no" readOnly></td>
                                               <!-- td colspan="2">Builder Country&nbsp;<input type="text" style="width:35;" class="input" name="cnt_nm" readOnly></td -->
                                               
                                         </tr>
                                   </table>
                             </td>
                             <td width="20">&nbsp;</td>
                             <td style="padding:6px; border:1px solid #A3A4C7; "><table><tr>
                             <td width="170" valign="top">
                             
                                   <table class="search" border="0">
                                         <tr><td class="title_h"></td>
                                         <td class="title_s">Capacity</td></tr>
                                   </table>
                                   
                                   <table class="search_sm2" border="0" style="width:170;"> 
                                         <tr class="h23">
                                               <td width="76" >Vessel Class</td>
                                               <td width=""><input type="text" style="width:70;text-align:right" class="input" name="cntr_vsl_clss_capa" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="76">Design TEU</td>
                                               <td width=""><input type="text" style="width:70;text-align:right" class="input" name="cntr_dzn_capa" readOnly></td>
                                         </tr>
                                         
                                   </table>
                                   
                                   
                             </td>
                             <td width="9">&nbsp;</td>
                             <td width="155" valign="top">
                             
                                   <table class="search" border="0">
                                         <tr><td class="title_h"></td>
                                         <td class="title_s">Reefer</td></tr>
                                   </table>
                                   
                                   <table class="search_sm2" border="0" style="width:155;"> 
                                         <tr class="h23">
                                               <td width="65">OPER</td>
                                               <td width=""><input type="text" style="width:70;text-align:right" class="input" name="rf_rcpt_knt" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="65">MAX.</td>
                                               <td width=""><input type="text" style="width:70;text-align:right" class="input" name="rf_rcpt_max_knt" readOnly></td>
                                         </tr>
                                         
                                   </table>
                                   
                                   
                             </td>
                             <td width="9">&nbsp;</td>
                             <td width="190" valign="top">
                             
                                   <table class="search" border="0">
                                         <tr><td class="title_h"></td>
                                         <td class="title_s">Speed</td></tr>
                                   </table>
                                   
                                   <table class="search_sm2" border="0" style="width:190;"> 
                                         <tr class="h23">
                                               <td width="70">MIN.</td>
                                               <td width="" class="stm"><input type="text" style="width:70;text-align:right" class="input" name="ecn_spd" readOnly>&nbsp; Knots</td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="">Service</td>
                                               <td width="" class="stm"><input type="text" style="width:70;text-align:right" class="input" name="vsl_svc_spd" readOnly>&nbsp; Knots</td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="">MAX.</td>
                                               <td width="" class="stm"><input type="text" style="width:70;text-align:right" class="input" name="max_spd" readOnly>&nbsp; Knots</td>
                                         </tr>
                                         
                                   </table>
                                   
                                   
                             </td>
                             </tr>
                             <tr>
                                   <td>
                                   <table class="height_2"><tr><td></td></tr></table>
                                   </td>
                             </tr>
                             <tr>
                                   
                             <td width="540" valign="top" colspan ="5">
                             
                                   <table class="search" border="0">
                                         <tr><td class="title_h"></td>
                                         <td class="title_s">Dimension</td></tr>
                                   </table>
                                   
                                   <table class="search_sm2" border="0" style="width:530;"> 
                                         <tr class="h23">
                                               <td width="74">L.O.A</td>
                                               <td width="101" class="stm"><input type="text" style="width:70;text-align:right" class="input" name="loa_len" readOnly>&nbsp;M</td>
                                               
                                               <td width="67">Depth</td>
                                               <td width="98" class="stm"><input type="text" style="width:70;text-align:right" class="input" name="vsl_dpth" readOnly>&nbsp;M</td>
                                               
                                               <td width="70">Freeboard</td>
                                               <td width="" class="stm"><input type="text" style="width:70;text-align:right" class="input" name="fbd_capa" readOnly>&nbsp;M</td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="">L.B.P</td>
                                               <td width="" class="stm"><input type="text" style="width:70;text-align:right" class="input" name="lbp_len" readOnly>&nbsp;M</td>
                                               
                                               <td width="">Height</td>
                                               <td width="" class="stm"><input type="text" style="width:70;text-align:right" class="input" name="vsl_hgt" readOnly>&nbsp;M</td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="">Breadth</td>
                                               <td width="" class="stm"><input type="text" style="width:70;text-align:right" class="input" name="vsl_wdt" readOnly>&nbsp;M</td>
                                               
                                               <td width="">Sum Draft</td>
                                               <td width="" class="stm"><input type="text" style="width:70;text-align:right" class="input" name="smr_drft_hgt" readOnly>&nbsp;M</td>
                                         </tr>
                                   </table>
                             </td>
                             </tr></table></td>
                             </tr>
                             <tr>
                                   <td>
                                   <table class="height_2"><tr><td>&nbsp;</td></tr></table>
                                   </td>
                             </tr>
                             <tr  height="160">
                                   <td width="9">&nbsp;</td>
                             <td width="537" valign="top" colspan ="5"  id="rollDevided2" style="padding:6px; border:1px solid #A3A4C7; display:none;">
                             <div id="rollDevided" style="display:none">
                             <table><tr><td >
                                   <table class="search" border="0">
                                         <tr><td class="title_h"></td>
                                         <td class="title_s">First Charter</td></tr>
                                   </table>
                                   
                                   <table class="search_sm2" border="0" style="width:260;"> 
                                         <tr class="h23">
                                               <td width="76" >Period</td>
                                               <td width="" colspan =2><input type="text" style="width:70;text-align:center" class="input" name="n1st_eff_dt" readOnly> ~ <input type="text" style="width:70;text-align:center" class="input" name="n1st_exp_dt" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="76">Remain</td>
                                               <td width="" colspan =2><input type="text" style="width:70;text-align:right; text-align:center;" class="input" name="n1st_rmn_dt" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="50">Curr/Amt1</td>
                                               <td width=""><input type="text" style="width:70;text-align:center;" class="input" name="n1st_hir_curr_n1st_cd" readOnly></td>
                                               <td width=""><input type="text" style="width:70;text-align:right" class="input" name="n1st_hir_rt_n1st_amt" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="50">Curr/Amt2</td>
                                               <td width=""><input type="text" style="width:70;text-align:center;" class="input" name="n1st_hir_curr_n2nd_cd" readOnly></td>
                                               <td width=""><input type="text" style="width:70;text-align:right" class="input" name="n1st_hir_rt_n2nd_amt" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="76">Owner</td>
                                               <td width="" colspan =2><span id="n1st_vndr_nm" onmouseover ="msgset('n1st_vndr_nm', document.form.n1st_vndr_nm.value)" title=""><input type="text" style="width:158;text-align:left" class="input" name="n1st_vndr_nm" readOnly></span></td>
                                         </tr>
                                         
                                   </table>
                                   
                                   
                             </td>
                             <td width="10">&nbsp;</td>
                             <td width="260">
                                   <table class="search" border="0">
                                         <tr><td class="title_h"></td>
                                         <td class="title_s">Second Charter</td></tr>
                                   </table>
                                   
                                   <table class="search_sm2" border="0" style="width:260;"> 
                                         <tr class="h23">
                                               <td width="76" >Period</td>
                                               <td width="" colspan =2><input type="text" style="width:70;text-align:center" class="input" name="n2nd_eff_dt" readOnly> ~ <input type="text" style="width:70;text-align:center" class="input" name="n2nd_exp_dt" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="76">Remain</td>
                                               <td width="" colspan =2><input type="text" style="width:70;text-align:center;" class="input" name="n2nd_rmn_dt" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="76">Curr/Amt1</td>
                                               <td width="50"><input type="text" style="width:70;text-align:center;" class="input" name="n2nd_hir_curr_n1st_cd" readOnly></td> 
                                               <td width=""><input type="text" style="width:70;text-align:right" class="input" name="n2nd_hir_rt_n1st_amt" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="76">Curr/Amt2</td>
                                               <td width="50"><input type="text" style="width:70;text-align:center;" class="input" name="n2nd_hir_curr_n2nd_cd" readOnly></td>
                                               <td width=""><input type="text" style="width:70;text-align:right" class="input" name="n2nd_hir_rt_n2nd_amt" readOnly></td>
                                         </tr>
                                         <tr class="h23">
                                               <td width="76">Owner</td>
                                               <td width="" colspan =2><span id="n2nd_vndr_nm" onmouseover ="msgset('n2nd_vndr_nm', document.form.n2nd_vndr_nm.value)" title=""><input type="text" style="width:158;text-align:left" class="input" name="n2nd_vndr_nm" readOnly></span></td>
                                         </tr>
                                         
                                   </table>
                                   
                                   
                             </td>
                             
                             
                             </tr></table></div>
                             </td></tr>
                             
                             
                        </table>
                  </td></tr>
            </table>
            <!-- Tab BG Box(E) -->
</div>
<!-- TAB [ Particular I ] (E) -->


<!-- TAB [ Particular II ] (S) -->
<div id="tabLayer" style="display:none">

      <table class="search"> 
    <tr><td class="bg" style="height:438" valign="top">
                  <!-- biz_1  (S) -->
                  <table class="search" border="0" style="width:979;"> 
                  <tr class="h23">
                        <td width="85">Displacement</td>
                        <td width="230" class="stm"><input type="text" style="width:120;text-align:right" class="input" name="dpl_capa" readOnly> M/T</td>
                        <td width="85">Dead Weight</td>
                        <td width="230" class="stm"><input type="text" style="width:120;text-align:right" class="input" name="dwt_wgt" readOnly> M/T</td>
                        <td width="70">Light Ship</td>
                        <td width="" class="stm"><input type="text" style="width:120;text-align:right" class="input" name="lgt_shp_tong_wgt" readOnly> M/T</td>
                  </tr>
                  </table>    
                  
                  <!-- biz_1  (E) -->           
                  <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

                  <table width="979" class="grid2"> 
                  <tr>
                        <td class="tr2_head" width="19%">Tonnage Type</td>
                        <td class="tr2_head" width="19%">International</td>
                        <td class="tr2_head" width="19%">Panama</td>
                        <td class="tr2_head" width="19%" colspan=2>Suez</td> 
                        <td class="tr2_head" width="24%" colspan=2>SCNT</td>     
                        
                  <tr align="right">
                        <td class="tr2_head2">Gross Ton</td>
                        <td style="aling:right"><input type="text" style="width:130;text-align:right" class="noinput" name="grs_rgst_tong_wgt" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                        <td style="aling:right"><input type="text" style="width:130;text-align:right" class="noinput" name="pnm_gt_wgt" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                        <td style="aling:right" colspan=2><input type="text" style="width:130;text-align:right" class="noinput" name="suz_gt_wgt" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                        <td class="tr2_head" style="width:50">Class</td>
                        <td style="aling:right"><input type="text" style="width:80;text-align:right" class="noinput" name="suz_net_tong_wgt" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                  </tr>
                  <tr align="right">
                        <td class="tr2_head2">Net Ton</td>
                        <td style="aling:right"><input type="text" style="width:130;text-align:right" class="noinput" name="net_rgst_tong_wgt" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                        <td style="aling:right"><input type="text" style="width:130;text-align:right" class="noinput" name="pnm_net_tong_wgt" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
						<td class="tr2_head" style="width:65">ITC</td>
						<td><input type="text" style="width:65;text-align:center" class="noinput" name="intl_tong_certi_flg" readOnly></td>
						<td class="tr2_head" style="width:50">Maiden</td>
                        <td style="aling:right"><input type="text" style="width:80;text-align:right" class="noinput" name="madn_voy_suz_net_tong_wgt" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                        
                  </tr>
                  </table>
                  


                  <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

                  <table width="979" class="grid2"> 
                  <tr>
                        <td class="tr2_head" width="20%">Capacity / Tank</td>
                        <td class="tr2_head" width="20%">F.O (85%)</td>
                        <td class="tr2_head" width="20%">D.O (85%)</td>
                        <td class="tr2_head" width="20%">F.W (100%)</td> 
                        <td class="tr2_head" width="20%">Ballast (100%)</td>     
                        
                  <tr align="right">
                        <td class="tr2_head2">Tank Capacity (M/T)</td>
                        <td style="aling:right"><input type="text" style="width:130;text-align:right" class="noinput" name="foil_capa" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                        <td style="aling:right"><input type="text" style="width:130;text-align:right" class="noinput" name="doil_capa" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                        <td style="aling:right"><input type="text" style="width:130;text-align:right" class="noinput" name="frsh_wtr_capa" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                        <td style="aling:right"><input type="text" style="width:130;text-align:right" class="noinput" name="blst_tnk_capa" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                  </tr>
                  <tr align="right">
                        <td class="tr2_head2">Consumption / Day (M/T)</td>
                        <td style="aling:right"><input type="text" style="width:130;text-align:right" class="noinput" name="foil_csm" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                        <td style="aling:right"><input type="text" style="width:130;text-align:right" class="noinput" name="doil_csm" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                        <td style="aling:right"><input type="text" style="width:130;text-align:right" class="noinput" name="frsh_wtr_csm" readOnly><input type="text" style="width:30;text-align:right" class="noinput" value="M/T" readOnly></td>
                        <td><input type="text" style="width:120;text-align:right" class="noinput" value="" readOnly></td>
                  </tr>
                  </table>
                  
                  <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                                   
                  <table width="979" class="grid2"> 
                  <tr>
                        <td class="tr2_head" width="20%">Machine Type / Spec.</td>
                        <td class="tr2_head" width="40%">Maker</td>
                        <td class="tr2_head" width="13%">Type</td>
                        <td class="tr2_head" width="13%">BHP/KW</td> 
                        <td class="tr2_head" width="13%">RPM</td>
                        <td class="tr2_head" width="%">Tier</td>   
                  </tr> 
                  <tr align="center">
                        <td class="tr2_head2">Main Engine</td>
                        <td align="left"><input type="text" style="width:100%;" class="noinput" name="mn_eng_mkr_nm" readOnly></td>
                        <td><input type="text" style="width:120;text-align:center" class="noinput" name="mn_eng_tp_desc" readOnly></td>
                        <td><input type="text" style="width:120;text-align:right" class="noinput" name="mn_eng_bhp_pwr" readOnly></td>
                        <td><input type="text" style="width:120;text-align:right" class="noinput" name="mn_eng_rpm_pwr" readOnly></td>
                        <td><select style="width:120;text-align:left" class="input" name="mn_eng_tr_knt">
			                        <option value="" selected></option>
									<option value="1">Ⅰ</option>
									<option value="2">Ⅱ</option>
									<option value="3">Ⅲ</option>
									</select> </td>
									
                  </tr>
                             
                  <tr align="center">
                        <td class="tr2_head2">Generator Engine</td>
                        <td align="left"><input type="text" style="width:100%;" class="noinput" name="gnr_mkr_nm" readOnly></td>
                        <td><input type="text" style="width:120;text-align:center" class="noinput" name="gnr_tp_desc" readOnly></td>
                        <td><input type="text" style="width:120;text-align:right" class="noinput" name="gnr_bhp_pwr" readOnly></td>
                        <td><input type="text" style="width:120;text-align:right" class="noinput" name="gnr_rpm_pwr" readOnly></td>
                        <td><input type="text" style="width:120;text-align:right" class="noinput" name="" readOnly></td>
                        <!--
                        <td><select style="width:120;text-align:left" class="input" name="gnr_tr_knt">
			                        <option value="" selected></option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									</select> </td>
						-->
                  </tr>
                        
                  <tr align="center">
                        <td class="tr2_head2">Bow Thrust</td>
                        <td align="left"><input type="text" style="width:100%;" class="noinput" name="bwthst_mkr_nm" readOnly></td>
                        <td><input type="text" style="width:120;text-align:center" class="noinput" name="bwthst_tp_desc" readOnly></td>
                        <td><input type="text" style="width:120;text-align:right" class="noinput" name="bwthst_bhp_pwr" readOnly></td>
                        <td><input type="text" style="width:120;text-align:right" class="noinput" name="bwthst_rpm_pwr" readOnly></td>
                        <td><input type="text" style="width:120;text-align:right" class="noinput" name="" readOnly></td>
                        <!--  
                        <td><select style="width:120;text-align:left" class="input" name="bwthst_tr_knt">
			                        <option value="" selected></option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									</select> </td>
						-->
                  </tr>
                  </table>    
                  
      </td></tr>
      </table>
      <!-- Tab BG Box(E) -->
</div>
<!-- TAB [ Particular II ] (E) -->
      
<!-- TAB [ Performance ] (S) -->
<div id="tabLayer" style="display:none">
        <table class="search">
               <tr><td class="bg" >
                       <table class="search"> 
                              <tr>
                                      <td style="height:220; width:340" valign="top">
                                             <table class="search" border="0" style="width:340;"> 
                                                     <tr><td width="340" height="240" valign="top" rowspan = "5" style="padding:6px; border:1px solid #A3A4C7;" >
                                   <table class="search" border="0" >
                                         <tr><td class="title_h"></td>
                                         <td class="title_s">Operation</td></tr>
                                   </table>
                                   <table class="search_sm2" border="0" style="width:340; height:80;"> 
                                   <tr><td width ="0"></td><td colspan = "3">
                                     <table>
                                         <tr  style="font-weight:bold; color: #313131;  height:24;">
                                               <td width="67">Lane</td>
                                               <td width="92" colspan="3"><input type="text" style="width:80;text-align:center" class="input2" name="vsl_slan_cd" readOnly>&nbsp;<!-- <input type="text" style="width:148;" class="input" name="crr_full_nm" readOnly> --></td>
                                               <td width="">P/F Speed</td>
                                               <td width=""><input type="text" style="width:80;text-align:right" class="input2" name="pf_spd" readOnly></td>
                                               
                                         </tr>
                                         <tr  style="font-weight:bold; color: #313131;  height:24;">
                                               <td width="67">AVG Slip</td>
                                               <td width="" colspan="3"><input type="text" style="width:80;text-align:right" class="input2" name="avg_slip" readOnly></td>
                                               <td width="">Net Speed</td>
                                               <td width="" colspan="3"><input type="text" style="width:80; text-align:right" class="input2" name="pf_net_spd" readOnly></td>
                                         </tr>
                                         <tr  style="font-weight:bold; color: #313131;  height:24;">
                                               <td width="67">FOC at P/F</td>
                                               <td width="" colspan="3"><input type="text" style="width:80; text-align:right" class="input2" name="pf_foc_qty" readOnly></td>
                                               <td width="82">AVG ACT FOC</td>
                                               <td width=""><input type="text" style="width:80;text-align:right" class="input2" name="avg_act_foc_qty" readOnly></td>
                                         </tr>
                                   </table></td></tr>
                                   </table>
                                   <table class="height_5"><tr><td></td></tr></table>
                                   <table width="100%"  id="mainTable" border="0">
                                      <tr><td width="100%">
                                          <script language="javascript">ComSheetObject('t3sheet1');</script>
                                        </td>
                                      </tr>
                                   </table>
                             </td></tr>
                                             </table>
                                      </td>
                                      <td>&nbsp;</td>
                                      <td style="height:220; width:564" valign="top">
                                             <table width="605" valign="top" style="border:1px solid #A3A4C7;"> 
                                                     <tr>
                                                             <td width="605" valign="top" rowspan = "5" style="padding:6px; border:1px solid #A3A4C7;">
                                                             <table class="search" border="0">
                                         <tr><td class="title_h"></td>
                                         <td class="title_s">RPM & Slow Steaming</td></tr>
                                   </table>
                                   <table class="search_sm2" border="0" style="width:603;"> 
                                         <tr>

				<td>
                  <table width="110" class="grid1" height ="15"> 
                  <tr height ="5">
					<td class="tr1_head" colspan="2" style="text-align:center;"><strong>Critical RPM Zone</strong></td>
                  </tr>      
                  <tr>
                        <td class="tr1_head" width="50%" style="text-align:center;border:1px solid #A3A4C7;">From</td>
                        <td class="tr1_head" width="50%" style="text-align:center;border:1px solid #A3A4C7;">To</td>
                  </tr>      
                  <tr align="right" height ="5">
						<td width="" style="text-align:center;border:1px solid #A3A4C7;"><input type="text" style="width:70;text-align:right;" class="input1" name="ctcl_rpm_no" dataformat="integer" caption="99999999999999999999" ></td>
						<td width="" style="text-align:center;border:1px solid #A3A4C7;"><input type="text" style="width:70;text-align:right" class="input1" name="ctcl_to_rpm_no" dataformat="integer" caption="99999999999999999999" ></td>
                  </tr>
                  </table>
                  </td>



                                         <td><table>
                                               <tr style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="68" style="text-align:center;">OPS MIN. RPM</td>
                                               </tr>
                                               <tr>
                                                     <td width="" style="text-align:center;"><input type="text" style="width:65;text-align:right" class="input1" name="op_min_rpm_no" dataformat="float" caption="999.9" ></td>
                                               </tr>
                                         </table></td>
                                         <td><table>
                                               <tr style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="68" style="text-align:center;">OPS MIN Speed</td>
                                               </tr>
                                               <tr>
                                                     <td width="" style="text-align:center;"><input type="text" style="width:65;text-align:right" class="input1" name="op_min_spd" dataformat="float" caption="999.9"></td>
                                               </tr>
                                         </table></td>
                                         <td><table>
                                               <tr style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="70" style="text-align:center;">Slow Steaming</td>
                                               </tr>
                                               <tr>
                                              <td><script language="javascript">ComComboObject("slw_stmng_flg", 1, 65, 1, 1, 2)</script></td>
                                               </tr>
                                         </table></td>
                                         <td><table>
                                               <tr style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="70" style="text-align:center;">Super Slow Steaming</td>
                                               </tr>
                                               <tr>
                                                     <td><script language="javascript">ComComboObject("spr_slw_stmng_flg", 1, 65, 1, 1, 2)</script></td>                                               
                                               </tr>
                                         </table></td>
                                         <td><table>
                                               <tr style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="70" style="text-align:center;">Fuel Saving Equip</td>
                                               </tr>
                                               <tr>
                                                     <td><script language="javascript">ComComboObject("fuel_sav_eq_flg", 1, 65, 1, 1, 2)</script></td> 
                                               </tr>
                                         </table></td>
                                         <td><table>
                                               <tr style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="70" style="text-align:center;">Load(%)</td>
                                               </tr>
                                               <tr>
                                                     <td width="" style="text-align:center;"><input type="text" style="width:65;text-align:right" class="input1" name="vsl_lod_rto" dataformat="float" caption="99.9"></td>
                                               </tr>
                                         </table></td>                                         
                                         </tr>
                                   </table>
                                    </td>
                            </tr>
                        </table>
                        <table height ="1"><tr><td></td></tr></table>
                                             <table width="580" valign="top" > 
                                                     <tr>
                                                             <td width="420" valign="top" rowspan = "5" style="padding:6px; border:1px solid #A3A4C7;">
                                                                    <table class="search" border="0">
                                         <tr><td class="title_h"></td>
                                         <td class="title_s">Design Max Load Hold/Deck</td></tr>
                                   </table>
                                   <table class="search_sm2" border="0" style="width:420;"> 
                                         <tr>
                                         <td><table>
                                               <tr  style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="70" style="text-align:center;">In Hold by Tier</td>
                                               </tr>
                                               <tr>
                                                     <td width="" style="text-align:center;"><input type="text" style="width:73;text-align:right" class="input1" name="in_hld_per_tr_knt" dataformat="float" caption="999.9"></td>
                                               </tr>
                                         </table></td>
                                         <td><table>
                                               <tr style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="70" style="text-align:center;">In Hold by Row</td>
                                               </tr>
                                               <tr>
                                                     <td width="" style="text-align:center;"><input type="text" style="width:73;text-align:right" class="input1" name="in_hld_per_row_knt" dataformat="float" caption="999.9"></td>
                                               </tr>
                                         </table></td>
                                         <td><table>
                                               <tr style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="70" style="text-align:center;">H/C in Hold</td>
                                               </tr>
                                               <tr>
                                                     <td width="" style="text-align:center;"><input type="text" style="width:73;text-align:right" class="input1" name="htch_cvr_in_hld_knt" dataformat="float" caption="999.9"></td>
                                               </tr>
                                         </table></td>
                                         <td><table>
                                               <tr style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="70" style="text-align:center;">O/Deck by Tier</td>
                                               </tr>
                                               <tr>
                                                     <td width="" style="text-align:center;"><input type="text" style="width:73;text-align:right" class="input1" name="on_deck_per_tr_knt" dataformat="float" caption="999.9"></td>
                                               </tr>
                                         </table></td>
                                         <td><table>
                                               <tr style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="70" style="text-align:center;">O/Deck by Row</td>
                                               </tr>
                                               <tr>
                                                     <td width="" style="text-align:center;"><input type="text" style="width:73;text-align:right" class="input1" name="on_deck_per_row_knt" dataformat="float" caption="999.9"></td>
                                               </tr>
                                         </table></td>                                                                             
                                         </tr>
                                   </table>
                                    </td>
                                    <td width="40">&nbsp;</td>
                                    <td width="150" valign="top" rowspan = "5" style="padding:6px; border:1px solid #A3A4C7;">
                                                                    <table class="search" border="0">
                                         <tr><td class="title_h"></td>
                                         <td class="title_s">OPT trim</td></tr>
                                   </table>
                                   <table class="search_sm2" border="0" style="width:165;"> 
                                         <tr>
                                         <td><table>
                                               <tr  style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="78" style="text-align:center;">Bow</td>
                                               </tr>
                                               <tr>
                                                     <td width="" style="text-align:center;"><input type="text" style="width:73;text-align:right" class="input1" name="bow_hgt" dataformat="float" caption="99.99"></td>
                                               </tr>
                                         </table></td>
                                         <td><table>
                                               <tr style="font-weight:bold;color:#313131;" height ="28">
                                                     <td width="78" style="text-align:center;">Transum</td>
                                               </tr>
                                               <tr>
                                                     <td width="" style="text-align:center;"><input type="text" style="width:73;text-align:right" class="input1" name="trsm_hgt" dataformat="float" caption="99.99"></td>
                                               </tr>
                                         </table></td>
                                         </tr>
                                   </table>
                                    </td>
                            </tr>
                                             </table>       
                                             <table height ="1"><tr><td></td></tr></table>                               
                                             <table width="580"> 
                                                     <tr>
                                                             <td width="490" valign="top" style="padding:6px; border:1px solid #A3A4C7;">
                                                                    <table>
                                                                            <tr><td width="490" valign="top">
                                                       <table class="search" border="0">
                                                           <tr><td class="title_h"></td>
                                                           <td class="title_s">Load Factor</td></tr>
                                                       </table>
                                                   </td></tr>
                                                   <tr><td>
                                                       <table id="mainTable" border="0" border="0" style="width:490;"> 
                                                           <tr><td width="100%">
                                                               <script language="javascript">ComSheetObject('t3sheet2');</script>
                                                           </td> </tr>
                                                       </table>
                                                   </td></tr>
                                               </table>
                                    </td>
                                    <td width="40">&nbsp;</td>
                                    <td width="100" valign="center"  style="padding:6px; border:1px solid #A3A4C7;">
                                                                    <table border="0" class="search_sm2" >
                                        <tr style="font-weight:bold;color:#313131;" height ="28">
                                            <td width="94" style="text-align:center;">ESI Score</td>
                                        </tr>
                                        <tr>
                                            <td width="" style="text-align:center;"><input type="text" style="width:85;text-align:right" class="input1" name="shp_idx_scre" dataformat="float" caption="99.9"></td>
                                        </tr>
                                        <tr style="font-weight:bold;color:#313131;" height ="28">
                                            <td width="94" style="text-align:center;">AMP Type</td>
                                        </tr>
                                        <tr>
                                            <td><script language="javascript">ComComboObject("amp_tp_cd", 1, 85, 1, 1, 2)</script></td> 
                                        </tr>
                                    </table>
                                    </td>
                            </tr>
                                             </table>
                                      </td>
                              </tr>
                       </table>
                       
                       <table class="search"> 
                              <tr><td style="height:130" valign="top">
                                             <table class="search" border="0">
                                                     <tr height ="23"><td class="title_h"></td>
                                                     <td class="title_s">Loadable</td></tr>
                                             </table>
                                             <table width="100%"  id="mainTable" border="0">
                                                     <tr>
                                                             <td width="100%">
                                                                    <script language="javascript">ComSheetObject('t3sheet3');</script>
                                                             </td>
                                                     </tr>
                                             </table>
                              </td></tr>
                       </table>
               </td></tr>
        </table>
      <!-- Tab BG Box(E) -->
</div>
<!-- TAB [ Performance ] (E) -->

      
<!-- TAB [ Gang Structure ] (E) -->
<div id="tabLayer" style="display:none">
            <table class="search" id="mainTable"> 
                  <tr><td class="bg" style="height:438" valign="top">        
                  
                  <!-- Grid  (S) -->
                        <table width="100%"  id="mainTable">
                             <tr>
                                   <td width="100%">
                                         <script language="javascript">ComSheetObject('t10sheet1');</script>
                                   </td>
                             </tr>
                        </table>
                  <!-- Grid (E) -->            
                  
                  </td></tr>
            </table>
            <!--biz page (E)-->
</div>
<!-- TAB [ Gang Structure ] (E) -->      
      
      <!--biz page (E)-->
      <!--Button (S) -->
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
             <tr><td class="btn1_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                <tr>

                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                             <tr><td class="btn1_left"></td>
                             <td class="btn1" name="btn_New">New</td>
                             <td class="btn1_right"></td>
                             </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                             <tr><td class="btn1_left"></td>
                             <td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
                             <td class="btn1_right"></td>
                             </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                             <tr><td class="btn1_left"></td>
                             <td class="btn1" name="btn_Save">Save</td>
                             <td class="btn1_right"></td>
                             </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                             <tr><td class="btn1_left"></td>
                             <td class="btn1" name="btn_Excel">Download</td>
                             <td class="btn1_right"></td>
                             </tr>
                        </table></td>                           
<!--                         <td class="btn1_line"></td> -->
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                             <tr><td class="btn1_left"></td>
                             <td class="btn1" name="btn_LoadExcel">Upload</td>
                             <td class="btn1_right"></td>
                             </tr>
                        </table></td>                      
                     
                  </tr>
                  </table>
            </td></tr>
            </table>
    <!--Button (E) -->
      </td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
