<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_0128.jsp
*@FileTitle      : Cargo Release (D/O)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.05.22
*@LastModifier   : 안진응
*@LastVersion    : 1.0
* 2009.05.22 안진응
* 1.0 Creation
* ------------------------------------------------------
* History
* 2012.02.22 김보배 [CHM-201216247] [BKG] PSA DG EDI 추가 요청 건
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0128Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0128Event event     = null;         //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;         //서버에서 발생한 에러
    String strErrMsg = "";                    //에러메세지
    int rowCount     = 0;                     //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100";

    String strUsr_id   = "";
    String strUsr_nm   = "";
    String strOfcCd    = "";
    String strCntCd    = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfcCd  = account.getOfc_cd();
        strCntCd  = account.getCnt_cd();


        event = (EsmBkg0128Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가.
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Cargo Release (D/O)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">

    /**************************************
        전역 변수 선언
    **************************************/

    var lginOfcCd = "<%=strOfcCd %>"; //로그인 사용자 오피스 코드
    var lginCntCd = "<%=strCntCd %>"; //로그인 사용자 국가 코드
    var strUsr_id = "<%=strUsr_id%>"; //로그인 사용자 아이디

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>
<body  onLoad="setupPage()">

<div id="blLayer" style="position:absolute; background-color:#ffffff; width:125px; visibility: hidden; overflow-y:auto; overflow-x:hidden; border-width:1; border-color:black; border-style:solid;"></div>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!----------------------------------------------------------------------
    Hidden Value Define
----------------------------------------------------------------------->
<input type="hidden" name ="h_cntr_no">
<input type='hidden' name ="xmlData">
<input type='hidden' name ="oaXmlData">
<input type='hidden' name ="blInfo_do_split_flg">
<!-- Hold OR UN-HOLD 구분 값 -->
<input type='hidden' name ='evnt_flag'>
<!--O/BL 회수  여부 Hidden 속성 조회 시 불러온 값 -->
<input type='hidden' name ='h_ori_obl_rdem_flg'>
<!--O/BL 회수  여부 Hidden 속성 O/BL Received 입력 OR Other DOC Receive 입력 시 변경된 값-->
<input type='hidden' name ='h_aft_obl_rdem_flg'>
<!---D/O EVENT에서 변경되기 전의 값 -->
<input type='hidden' name ='pre_ctnt'>
<!--DO validity 변경 여부-->
<input type='hidden' name ='vty_cng_flg'>
<!-- Ivoce Bil_Amt Total-->
<input type='hidden' name ='invTotBilAmt'>
<!-- Dor Interface 발행 실적 및 상태정보 -->
<input type='hidden' name ='dorStsCd'>
<!-- D/O 관련업무에서 발생하는 주요 EVENT -->
<input type='hidden' name ='do_cng_evnt_cd'>
<!-- TPB Status -->
<input type='hidden' name ='tpb_status'>
<!-- D/O의 진행 상태 코드 -->
<input type='hidden' name ='rlse_sts_cd'>
<!--최종 D/O의 진행 상태 코드 -->
<input type='hidden' name ='last_rlse_sts_cd'>
<!-- DO 번호-->
<input type='hidden' name ='h_do_no'>
<!--OBL 변경 여부-->
<input type='hidden' name ='obl_cng_flg'>
<!--O/BL Received 변경 후 값-->
<input type='hidden' name ='old_obl_rdem_knt'>
<!--O/BL Received 변경 전 값-->
<input type='hidden' name ='new_obl_rdem_knt'>
<!-- Remark for Release  -->
<input type='hidden' name ='releaseRemark'>
<input type='hidden' name ='crnt_ctnt'>

<input type="hidden" name="h_cntr_no">
<!-- RD 부분  -->
<input type="hidden" name="h_mrd_id">
<input type="hidden" name="h_mrd_param">
<input type="hidden" name="h_local_lang_flg">
<input type="hidden" name="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" value="">

<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdDisableToolbar" value="">
<input type="hidden" name="com_mrdBodyTitle" value="">

<!--DEM.DET 팝업 호출 파라메터 2009-12-08-->
<input type='hidden' name ="demDtlXmlData">
<input type='hidden' name ='h_hold_remark' value = "">
<input type='hidden' name ='dubai_mrd_id'>

<!-- Event Type : RL (Release), CC(Cancel), AT(Amendment Transmit) -->
<input type="hidden" name="event_tp">

<!-- 개발자 작업 -->
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

<!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-bottom:2;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_retrieve">Retrieve</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>

                <td class="btn1_line"></td>

            <td>
                <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>

            <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_release">Release</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>
            
            <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_cancel">Cancel</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>

            <td id="btn_transmit_dp">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_transmit">Amend Transmit</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>
            
            <td id="btn_result_dp">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_result">EDI Result</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>

            <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_preview">Preview</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>
            <td>
            	<div id="dubai" style="display:none">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_dubai_preview">Dubai Preview</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            	</div>
            </td>
              <td>
            	<div id="abu" style="display:none">
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_abu_preview">ABU DHABI Preview</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            	</div>
            </td>
            <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_receiverinfo">Receiver Info</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>

            <!-- 2009-11-30 고객 요구사항 모든 D/O에서 프린트 버튼 제거
            <td class="btn1_line"></td>

            <td>
                <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_print">Print</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>
            -->
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
        <!--biz page (S)-->

        <table class="search">
        <tr>
            <td class="bg">

                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979">
                <tr class="h23">
                    <td width="55">B/L No.</td>
                    <td width="160">
                        <input name="bl_no" caption="B/L No." type="text" style="width:125;" class="input" maxlength="13"style="ime-mode:disabled" style="background-image : url('img/btn_combo.gif'); background-position:top right; background-repeat:no-repeat;">
                    </td>
                    <td width="60">BKG No.</td>
                    <td width="200">
                        <input name="bkg_no" caption="BKG No." type="text" style="width:120;" class="input" maxlength="13" style="ime-mode:disabled" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
                        <input name='blInfo_split_flg' type="text" style="width:40;color:red; font-weight:bold;text-align: center" readonly="readonly" class="input2">
                    </td>
                    <td>
                        <table class="search_ssm1" border="0" style="width:220">
                        <tr class="h23">
                            <td width="95">&nbsp;Container No.</td>
                            <td width="">
                                <input name="cntr_no" caption="Container No." fullfill="" type="text" style="width:120;" class="input" maxlength="11" style="ime-mode:disabled">
                            </td>
                        </tr>
                        </table>
                    </td>
                    <td id="dubaiDoVty" style="display:none">
                    	<table>
                    	<tr class="h23">
                   		  <td width="">D/O Validity upto</td>
		                     <td width=""><input type="text" name='blInfo_do_vty_dt' style="width:75;ime-mode:disabled" class="input" caption="D/O Validity upto" dataformat="ymd" minlength="8" maxlength="8" required="true">
		                     <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name='img_do_vty_dt'>
		                    <img id="btn_do_vty_his" src="img/btns_search.gif" name="btn_do_vty_his" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			                  
                    	</tr>
                    	</table>
                    </td>
                </tr>
                </table>
                <!--  biz_1   (E) -->
            </td>
        </tr>
        </table>

        <table class="height_8">
        <tr>
            <td colspan="8"></td>
        </tr>
        </table>

        <!-- Grid BG Box  (S) -->
        <table class="search" id="mainTable">
        <tr>
            <td class="bg">
                <!--  biz_1  (S) -->
                <table class="search_sm" border="0" style="width:979">
                <tr class="h23">
                    <td>
                        <table class="search" border="0" style="width:">
                        <tr class="h23">
                            <td width="34">&nbsp;POR</td>
                            <td width="62"><input type="text" style="width: 50; text-align: center" class="input2" readonly="readonly" name="blInfo_por_cd"></td>
                            <td width="27">POL</td>
                            <td width="70"><input type="text" style="width: 50; text-align: center" class="input2" readonly="readonly" name="blInfo_pol_cd"></td>
                            <td width="27">POD</td>
                            <td width="105"><input type="text" style="width: 52; text-align: center" class="input2" readonly="readonly" name="blInfo_pod_cd"></td>
                            <td width="27"> DEL</td>
                            <td width="130"><input type="text" style="width: 50; text-align: center" class="input2" readonly="readonly" name="blInfo_del_cd"></td>
                            <td width="65"> DEL Term</td>
                            <td width="110"><input type="text" style="width:79; text-align: left" class="input2" readonly="readonly" name="blInfo_de_term_desc"></td>
                            <td width="100">Arrival Vessel</td>
                            <td width="222"><input type="text" style="width: 100%; text-align: left" class="input2" readonly="readonly" name="blInfo_arrival_vessel"></td>
                        </tr>
                        <tr class="h23">
                            <td width="">&nbsp;ETA</td>
                            <td colspan="3"><input type="text" style="width: 139; text-align: center" class="input2" readonly="readonly" name="blInfo_vps_eta_dt"></td>
                            <td width="">PKG</td>
                            <td width="">
                                <input type="text" style="width: 52; text-align: right" class="input2" readonly="readonly" name="blInfo_pck_qty">
                                <input type="text" style="width: 30;; text-align: center" class="input2" readonly="readonly" name="blInfo_pck_tp_cd"></td>
                            <td width="">WGT</td>
                            <td width="">
                                <input type="text" style="width: 70; text-align: right" class="input2" readonly="readonly" name="blInfo_act_wgt">
                                <input type="text" style="width: 30; text-align: center" class="input2" readonly="readonly" name="blInfo_wgt_ut_cd"></td>
                            <td width="">MEA</td>
                            <td width="">
                                <input type="text" style="width: 45; text-align: right" class="input2" readonly="readonly" name="blInfo_meas_qty">
                                <input type="text" style="width: 30; text-align: center" class="input2" readonly="readonly" name="blInfo_meas_ut_cd"></td>
                            <td width="">Discharging CY</td>
                            <td width=""><input type="text" style="width: 100%; text-align: left" class="input2" readonly="readonly" name="blInfo_dsch_loc"></td>
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>
                <!--  biz_1   (E) -->

                <table class="height_5"><tr><td></td></tr></table>

                <table class="search_sm" border="0" style="width:979">
                <tr class="h23">
                    <td>
                        <table class="search" border="0" style="width:">
                        <tr class="h23">
                            <td width="114" class="" id="blInfo_cstms_ref_nm"><input type="text" style="width:112;" class="input" name="blInfo_cstms_ref_nm" maxlength='50'></td>
                            <td width="146" class="" id="blInfo_cstms_ref_ctnt"><input type="text" style="width:121;" class="input" name="blInfo_cstms_ref_ctnt" maxlength='20'></td>
                            <td width="40">Partial</td>
                            <td width="50"><input type="text" style="width:30; text-align: center" class="input2" readonly="readonly" name="blInfo_cntr_prt_flg"></td>
                            <td width="65" class="" nowrap="nowrap">Consignee</td>
                            <td width="152" class=""><input type="text" name="blInfo_ccust_nm" style="width:150;text-align:left;" class="input2" readonly="readonly"></td>
                            <td width="" class=""><input type="text" name="blInfo_ccust_addr"  style="width:392;text-align:left;" class="input2" readonly="readonly"></td>
                        </tr>
                        <tr class="h23">
                            <td width="" class="" id="blInfo_cstms_asgn_nm"><input type="text" style="width:112;"  class="input" name="blInfo_cstms_asgn_nm" maxlength='50'></td>
                            <td width="" class="" id="blInfo_cstms_asgn_ctnt"><input type="text" style="width:121;" class="input" value="" name="blInfo_cstms_asgn_ctnt" maxlength='20'></td>
                            <td width="" nowrap="nowrap">SOC</td>
                            <td><input type="text" style="width: 30; text-align: center" class="input2" readonly="readonly" name="blInfo_soc_flg"></td>
                            <td width="65" class="" nowrap="nowrap" align="right" style="padding-right:3">Notify</td>
                            <td width="152" class=""><input type="text" name="blInfo_ncust_nm"   style="width:150;text-align:left;" class="input2" readonly="readonly"></td>
                            <td width="" class=""><input type="text" name="blInfo_ncust_addr" style="width:392;text-align:left;" class="input2" readonly="readonly"></td>
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>
                <!--  biz_1   (E) -->

                <table class="height_5"><tr><td></td></tr></table>

                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="">
                        <table border="0" style="width:100%; background-color:white;">
                        <tr>
                            <td width="100%">
                                <!--B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출-->
                                <script language="javascript">ComSheetObject('doRlseSts');</script>
                            </td>
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>

                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

                <!--  biz_4  (S) -->
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="545">
                        <!--  biz_4 _1 (S) -->
                        <table class="search" border="0" style="width:100%">
                        <tr class="h23">
                            <td width="196">
                                <table class="search" border="0">
                                <tr><td class="title_h"></td>
                                    <td class="title_s">Bill of Lading Status</td></tr>
                                </table>
                            </td>
                            <td width="30"><input type="text" name="blInfo_obl_rdem_flg" style="width:25; color:blue; font-weight:bold;text-align:center;" class="input2" readonly="readonly"></td>
                            <td width="30" align='right'>No</td>
                            <td width="30"><input type="text" name="blInfo_obl_cpy_knt" style="width:25;color:black;text-align:center; font-weight:bold;" class="input2" readonly="readonly"></td>
                            <td width="130" align='center'>
                                <table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                    <td class="btn2_left"></td>
                                    <td class="btn2" name="btn_obl_cancel">RCV Cancel</td>
                                    <td class="btn2_right"></td>
                                </tr>
                                </table>
                            </td>
                            <td width="40">
                                <table class="search" border="0">
                                <tr><td class="title_h"></td>
                                    <td class="title_s">TPB</td></tr>
                                </table>
                            </td>
                            <td width="20"><img src="img/btng_icon_g.gif" width="13" height="13" border="0" align="absmiddle" id="tpb_icon"></td>
                            <td width="50"><input type="text" style="width:20;;text-align:center;" name='tpb_cd' class="input2" readonly="readonly">&nbsp;<img class="cursor" name="btn_tpb" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="">
                                <input type="text" name='hold_flag' style="width:50; text-align:center;" class="input2_1" readonly="readonly">
                                <input type="hidden" name='blInfo_do_hld_flg'>
                            </td>
                        </tr>
                        </table>

                        <table class="search" height="3"><tr><td></td></tr></table>

                        <table class="search_sm" border="0" style="width:100%">
                        <tr class="h23">
                            <td width="110">B/L Issue</td>
                            <td width="45"><input type="text" name="blInfo_bl_tp_cd" style="width:89%; text-align: center" class="input2" readonly="readonly"></td>
                            <td width="25">OFC</td>
                            <td width="140">
                                <input type="text" name="blInfo_obl_iss_ofc_cd" style="width:60;" class="input2" readonly="readonly">
                                <input type="text" name="blInfo_obl_iss_usr_id" style="width:70;" class="input2" readonly="readonly"></td>
                            <td width="20">DT</td>
                            <td width="">
                                <input type="text" name="blInfo_obl_iss_dt" style="width:110;" class="input2" readonly="readonly">
                                <input type="text" style="width:70;text-align:center;" value="" class="noinput2" readonly="readonly"></td>
                        </tr>

                        <tr class="h23">
                            <td class="">B/L Receive</td>
                            <td class=""><input type="text" name="blInfo_obl_rdem_knt" style="width:89%;text-align:center;" class="input" dataformat="int" style="ime-mode: disabled" maxlength='3'></td>
                            <td class="">OFC</td>
                            <td class="">
                                <input type="text" name="blInfo_obl_rdem_ofc_cd" style="width:60;" class="input2" readonly="readonly">
                                <input type="text" name="blInfo_obl_rdem_usr_id" style="width:70;" class="input2" readonly="readonly"></td>
                            <td class="">DT</td>
                            <td class="">
                                <input type="text" name="blInfo_obl_rdem_dt" style="width:110;text-align:center;" class="input2" readonly="readonly">
                                <input type="text" name="bl_surr_rmk_flg" style="width:50;text-align:center;" class="noinput2" readonly="readonly">&nbsp;<img id="div_btn_bl_surr_flg" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_bl_surr_rmk"></td>
                        </tr>

                        <tr class="h23">
                            <td class="">Other DOC RCV</td>
                            <td class="">
                                <select style="width:89%;text-align:center;" name="blInfo_bl_otr_doc_rcv_cd">
                                    <option value=""></option>
                                    <option value="LG">LG</option>
                                    <option value="LI">LI</option>
                                </select>
                            </td>
                            <td class="">OFC</td>
                            <td class="">
                                <input type="text" name="blInfo_otr_doc_rcv_ofc_cd" style="width:60;" class="input2" readonly="readonly">
                                <input type="text" name="blInfo_otr_doc_rcv_usr_id" style="width:70;" class="input2" readonly="readonly"></td>
                            <td class="">DT</td>
                            <td class=""><input type="text" name="blInfo_otr_doc_rcv_dt" style="width:110;" class="input2" readonly="readonly">
                                <select name="blInfo_otr_doc_cgor_flg" style="width:75;text-align:center;">
                                    <option></option>
                                    <option value="N">Non-Accept</option>
                                    <option value="Y">Accept</option>
                                </select>
                            </td>
                        </tr>

                        <tr class="h23">
                            <td class="">Inbond DOC RCV</td>
                            <td class="">
                                <select name="blInfo_ibd_doc_rcv_flg" style="width:89%;text-align:center;">
                                    <option value="N">N</option>
                                    <option value="Y">Y</option>
                                </select>
                            </td>
                            <td class="">OFC</td>
                            <td class="">
                                <input type="text" name="blInfo_ibd_doc_rcv_ofc_cd" style="width:60;" value="" class="input2" readonly="readonly">
                                <input type="text" name="blInfo_ibd_doc_rcv_usr_id" style="width:70;" value="" class="input2" readonly="readonly"></td>
                            <td class="">DT</td>
                            <td class="">
                                <input type="text" name="blInfo_ibd_doc_rcv_dt" style="width:110;text-align:center;" value="" class="input2" readonly="readonly">
                                <input type="text" name="" style="width:70;text-align:center;" value="" class="noinput2" readonly="readonly"></td>
                        </tr>
                        </table>
                        <!--  biz_4 _1 (E) -->
                    </td>
                    <td width="10">&nbsp;</td>
                    <td width="424" valign='top'>
                        <!--  biz_4 _2 (S) -->
                        <table class="search" border="0" style="width:100%;">
                        <tr class="h23">
                            <td width="160">
                                <table class="search" border="0">
                                <tr><td class="title_h"></td>
                                    <td class="title_s">Freight Received Status</td></tr>
                                </table>
                            </td>
                            <td width="">
                                <input type="text" style="width:20;text-align:center;" class="input2_1" name='blInfo_tot_ots_sts_cd' readonly="readonly">
                                <select style="width:150;font-weight:bold;" class="input2" name='tot_ots_amt'></select>
                            </td>
                            <td align="right">
                                <table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                    <td class="btn2_left"></td>
                                    <td class="btn2" name="btn_erp">ERP</td>
                                    <td class="btn2_right"></td>
                                </tr>
                                </table>
                            </td>
                        </tr>
                        <tr><td height="3"></td></tr>
                        </table>

                        <table class="search_sm" border="0" style="width:100%">
                        <tr class="h23">
                            <td>PPD1</td>
                            <td width="60" class="" align="left"><input type="text" name="blInfo_ppt_sts_cd" style="width:27;text-align:center;" class="input2" readonly="readonly"></td>
                            <td>OFC</td>
                            <td>
                                <input type="text" name="blInfo_ppt_rcv_ofc_cd" style="width:60;text-align:left;" class="input2" readonly="readonly">
                                <input type="text" name="blInfo_ppt_rcv_usr_id" style="width:70;text-align:left;" class="input2" readonly="readonly"></td>
                            <td width="20" class="">DT</td>
                            <td width=""  class="" nowrap="nowrap"><input type="text" name="blInfo_ppt_rcv_dt" style="width:125;text-align:center;" class="input2" readonly="readonly"></td>
                        </tr>
                        <tr class="h23">
                            <td class="">CCT1</td>
                            <td class="" align="left"><input type="text" name="blInfo_cct_sts_cd" style="width:27;text-align:center;color:red;" class="input2" readonly="readonly">&nbsp;<img id="div_btn_cct" src="img/btns_search.gif" name="btn_cct" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                            <td class="">OFC</td>
                            <td class="">
                                <input type="text" name="blInfo_cct_rcv_ofc_cd" style="width:60;text-align:left;" class="input2" readonly="readonly">
                                <input type="text" name="blInfo_cct_rcv_usr_id" style="width:70;text-align:left;" class="input2" readonly="readonly"></td>
                            <td class="">DT</td>
                            <td class=""><input type="text" name="blInfo_cct_rcv_dt" style="width:125;text-align:center;" class="input2" readonly="readonly"></td>
                        </tr>
                        <tr class="h23">
                            <td class="">PPD2</td>
                            <td width="40" class="" align="left"><input type="text" name="blInfo_n3pty_ppt_sts_cd" style="width:27;text-align:center;" class="input2" readonly="readonly"></td>
                            <td class="">OFC</td>
                            <td class="">
                                <input type="text" name="blInfo_n3pty_ppt_rcv_ofc_cd" style="width:60;" class="input2" readonly="readonly">
                                <input type="text" name="blInfo_n3pty_ppt_rcv_usr_id" style="width:70;" class="input2" readonly="readonly"></td>
                            <td class="">DT</td>
                            <td class=""><input type="text" name="blInfo_n3pty_ppt_rcv_dt" style="width:125;text-align:center;" class="input2" readonly="readonly"></td>
                        </tr>
                        <tr class="h23">
                            <td class="">CCT2</td>
                            <td class=""><input type="text" name="blInfo_n3pty_cct_sts_cd" style="width:27;text-align:center;color:red;" class="input2" readonly="readonly">&nbsp;<img id="div_btn_third_cct" src="img/btns_search.gif" name="btn_third_cct" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                            <td class="">OFC</td>
                            <td class="">
                                <input type="text" name="blInfo_n3pty_cct_rcv_ofc_cd" style="width:60;" class="input2" readonly="readonly">
                                <input type="text" name="blInfo_n3pty_cct_rcv_usr_id" style="width:70;" class="input2" readonly="readonly"></td>
                            <td class="">DT</td>
                            <td class=""><input type="text" name="blInfo_n3pty_cct_rcv_dt" style="width:125;text-align:center;" class="input2" readonly="readonly"></td>
                        </tr>
                        </table>
                        <!--  biz_4 _2 (E) -->
                    </td>
                </tr>
                </table>


                 <!-- *********************** WEB OB/L 체크 추가 ************************ -->
                <table class="search" border="0">
                        <tr>
                        <td>
                        	<table border='0'>
			                        <tr class="h23" id="web_print">
			                            <td width="150">
											<table border="0" width="100%">
												<tr>
													<td class="title_h"></td>
													<td class="title_s" width="135">OB/L Serial No.</td>
												</tr>
											</table>
										</td>
			                            <td width="" align="center" colspan="6"><script language="javascript">ComComboObject('obl_inter_ser_no', 3, 250, 1, 0);</script></td>
                                        <td  width="" align="left" colspan="3" id="obl_inter_ser_no_chk_title" height="30" value=""></td>
			                        </tr>                        	
                        	</table>
                        </td>
                        </tr>
                </table>
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                <!-- *********************** WEB OB/L 체크 추가 END ************************ -->
                
                <table class="height_10"><tr><td colspan="8"></td></tr></table>

                <table class="search" border="0" style="width:979">
                <tr class="h23">
                    <td width="210">
                        <table class="search" border="0">
                        <tr><td class="title_h"></td>
                            <td class="title_s">Demurrage Status/Outstanding</td></tr>
                        </table>
                    </td>

                    <td width="200">
                        <input type="text" name='demur_sts' style="width:25; font-weight:bold;" class="input2" readonly="readonly">&nbsp;
                        <select style="width:160;font-weight:bold;" class="input2" name='tot_bil_amt'></select>
                    </td>
                    <td width="170">
                        <table class="search_sm2" border="0" style="width:160">
                        <tr class="h23">
                            <td width="">Demurrage Type&nbsp;
                            <input type="text" name='demur_type' style="width:35;" class="input2" readonly="readonly"></td>
                        </tr>
                        </table>
                    </td>

                    <td width="">
                        <table class="search_sm2" border="0" style="width:100%">
                        <tr class="h23">
                            <td width="">Expect Delivery Date</td>
                            <td width=""><input type="text" name='exp_del_dt' style="width:75;ime-mode:disabled" class="input1" caption="Expect Delivery Date" dataformat="ymd" minlength="8" maxlength="8" required="true">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name='img_exp_del_dt'>&nbsp;</td>
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                    <td class="btn2" name="btn_dem_retrieve">Retrieve</td>
                                    <td class="btn2_right"></td>
                                </tr>
                                </table>
                            </td>
                        </tr>
                        </table>

                    </td>
                    <td width="70" align="right">
                        <table width="60" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btn_dmdt">DMDT</td>
                            <td class="btn2_right"></td>
                         </tr>
                         </table>
                    </td>
                </tr>
                </table>

                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                <!--  biz_4   (E) -->

                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="" valign="top">
                        <!-- Grid  (S) -->
                        <table width="100%"  id="mainTable">
                        <tr>
                            <td width="100%">
                                <!--Demurrage-->
                                <script language="javascript">ComSheetObject('demInfo');</script>
                            </td>
                        </tr>
                        </table>
                        <!-- Grid (E) -->
                    </td>
                </tr>
                </table>

                <div id="" style="display:none">
                <!-- Grid  (S) -->
                <table width="460"  id="mainTable">
                <tr>
                    <td width="100%">
                    <!--컨테이너 별 Demurrage-->
                        <script language="javascript">ComSheetObject('demDtl');</script>
                    </td>
                </tr>
                </table>
                <!-- Grid (E) -->
                </div>

                <table class="height_5"><tr><td colspan="8"></td></tr></table>

                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="49%" valign="top">
                        <table border="0" style="width:100%; background-color: white;" class="grid2">
                        <tr class="h23" align="center">
                            <td width="100%" class="tr2_head">O/B Remark(s)</td>
                        </tr>
                        <tr class="h23" align="center">
                            <td width="" class="noinput2"><textarea style="width: 100%; height:18" name='blInfo_obl_iss_rmk' readonly="readonly" class="noinput2"></textarea></td>
                        </tr>
                        </table>
                    </td>

                    <td width="2%" valign="top"></td>

                    <td width="49%" valign="top">
                        <table border="0" style="width:100%; class="search">
                        <tr class="h23" align="center">
                   			 <td width="" align="right">
                       			 <table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
                        			<tr><td class="btn2_left"></td>
                           				<td class="btn2" name="btn_hold_remark" id='hold_remark' style="color:gray">Hold / Internal  Remark(s)</td>
                            			<td class="btn2_right"></td>
                         			</tr>
                         		</table>
                   			 </td>
                        </tr>
                        <tr class="h23" align="center">
                            <td width=""><textarea style="width:99%; height:20" name='blInfo_inter_rmk'  onKeyDown="fncTextareaMaxLine(this.value)"></textarea></td>
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>
            </td>
        </tr>
        </table>
    </td>
</tr>
</table>
<!-- Grid BG Box  (S) -->
<!--biz page (E)-->

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
<tr>
    <td class="btn1_bg">
        <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_remark">External Remark</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table>
            </td>

            <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_hold" id='hld'>Hold</td>
                    <td class="btn1" name="btn_unhold" id='uhld' style="display:none">Hold Removal</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>

            <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_history">History</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>
            <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_form_setup">Form Setup</td>
                      <td class="btn1_right"></td>
                  </tr>
                  </table>
            </td>
            <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_cy">CY or Unstuff</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>
        </tr>
        </table>
    </td>
</tr>
</table>
<!--Button (E) -->

<!--RD -->
<table width="0"border="0" cellpadding="0" cellspacing="0">
<tr>
    <td height="0" width="0"><script language="javascript">comRdObject('csrPrevie');</script></td>
</tr>
</table>

<!----------------------------------------------------------------------
    Hidden IB Sheet Define
----------------------------------------------------------------------->
<!--EU D/O Release 기본 정보-->
<script language="javascript">ComSheetObject('blInfo');</script>
<!--Total Billable Amount-->
<script language="javascript">ComSheetObject('totBlbAmt');</script>
<!--Partial 컨테이너 정보 조회-->
<script language="javascript">ComSheetObject('partial');</script>

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
</form>
<!-- 개발자 작업  끝 -->
</body>
</html>