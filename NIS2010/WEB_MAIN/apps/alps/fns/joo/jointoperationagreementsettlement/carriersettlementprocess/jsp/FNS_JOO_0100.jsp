<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0100.jsp
*@FileTitle : ROB Container List Inquiry 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.05.19 민정호
* 1.0 Creation  
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0100Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  FnsJoo0100Event  event = null;       //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount   = 0;                  //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementFinder");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (FnsJoo0100Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>
<head>
<title>Each Container</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>
<!-- 개발자 작업 -->
<body onLoad="setupPage();">
<form name="form">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="in_list_type">
<input type="hidden" name="in_cntr_match">
<input type="hidden" name="in_pol_ts">
<input type="hidden" name="in_pod_ts">
<input type="hidden" name="in_cntr_cfm_flg">
<input type="hidden" name="in_bkg_cgo_tp_cd_temp">

<input type="hidden" name="vvd_nkm">
<input type="hidden" name="un_loc_cd">
<input type="hidden" name="vps_eta_dt">
<input type="hidden" name="vps_etd_dt">
<input type="hidden" name="vps_etb_dt">
<input type="hidden" name="in_order_by_type">
<input type="hidden" name="in_ofc_cd_type">
<input type="hidden" name="in_including_type">
<input type="hidden" name="key">
<input type="hidden" name="fax">
<input type="hidden" name="email">
<input type="hidden" name="vessel_name">
<input type="hidden" name="in_pol_cd">
<input type="hidden" name="in_pol_yd_cd">
<input type="hidden" name="clpt_ind_seq">
<input type="hidden" name="pol_split_no">


      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- biz_1 (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
					<td width="100">&nbsp;&nbsp;VVD</td>
					<td width="150"><input type="text" style="width:100;" name="in_vvd_cd" class="input1" value="" dataformat="uppernum" style="ime-mode:disabled" maxlength="9"></td>
					<td width="80">&nbsp;&nbsp;ROB Port</td>
					<td width="*"><script language="javascript">ComComboObject('rob_port_cd',6,100,0,1);</script>&nbsp;&nbsp;<input type="text" style="width:50;" name="in_pol_yd" class="input1" value="" dataformat="engupspecial" style="ime-mode:disabled" readonly></td>						
              </tr>
			</table>
			<table class="search" border="0" style="width:979;">			              
              <tr class="h23">
					<td width="100">&nbsp;&nbsp;Special Cargo</td>
				    <td>				    
				    <input type="checkbox" value="Y" class="trans" name="in_dcgo_flg">Danger
				    &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_rc_flg">Reefer
				    &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_awk_cgo_flg">Awkward
				    &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_bb_cgo_flg">Break Bulk
				    &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_stwg_cd">Stowage
				    &nbsp;<input type="checkbox" value="Y" class="trans" name="in_hot_de_flg" style="display:none;">
				    <input type="checkbox" value="Y" class="trans" name="in_rd_cgo_flg">Reefer Dry
				    &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_soc_flg">SOC
				    &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_prct_flg">Pre-caution
				    &nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="in_hngr_flg">GOH
					</td>              
              </tr>              
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>

      <table class="height_8"><tr><td colspan="8"></td></tr></table>

      <table class="search">
        <tr>
          <td class="bg"  valign="top">

            <!-- biz_2 (S) -->
            <!-- Grid (S) -->
            <table width="100%"  border="0" id="mainTable">
              <tr>
              <td width="100%">
              <script language="javascript">ComSheetObject('sheet1');</script>
              </td>
              </tr>
            </table>
            <!-- Grid (E) -->
            <!-- biz_2 (E) -->

            <table class="height_8"><tr><td colspan="8"></td></tr></table>

            <table class="search" border="0">
              <tr>
                <td class="title_h"></td>
                <td class="title_s">Summary Table</td>
              </tr>
            </table>
            <!-- Grid  (S) -->

            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->

          </td>
        </tr>
      </table>
      <!-- biz page (E) -->
      <!-- Button (S) -->
<table width="100% " class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
        <tr><td>
            <table border="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_ratio" id="btn_ratio">Sub-Alloc and Ratio</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table>
			</td></tr></table>          
		   </td>		          	
       	<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve(BKG)</td>
					<td class="btn1_right"></td>
				</tr></table></td>
<!-- 				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve3">Retrieve2</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve2">Retrievel3</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve4">Retrievel4</td>
					<td class="btn1_right"></td>
				</tr></table></td>
 -->				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve5">Retrieve(CTM)</td>
					<td class="btn1_right"></td>
				</tr></table></td>								
   			    <td class="btn1_line"></td> 				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
	</tr>
</table>
      <!-- Button (E) -->
    </td>
  </tr>
</table>
<!-- 개발자 작업 끝 -->
</form>
</body>
</html>