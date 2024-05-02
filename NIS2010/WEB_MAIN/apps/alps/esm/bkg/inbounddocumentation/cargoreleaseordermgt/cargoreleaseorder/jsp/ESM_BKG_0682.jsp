<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_0682.jsp
*@FileTitle      : Korea Cargo Release (D/O)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.05.22
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.05.22 임진영
* 1.0 Creation
* 2011.11.16 정선용 [CHM-201114497-01]	한국지역 e-D/O EDI 전송 오류
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0682Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0682Event event     = null;         //PDTO(Data Transfer Object including Parameters)
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

        event = (EsmBkg0682Event)request.getAttribute("Event");
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
<title>Korea Cargo Release (D/O)</title>
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
        loadStartDate = new Date();
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
<!-- Hold OR UN-HOLD 구분 값 -->
<input type='hidden' name ='evnt_flag'>
<!--O/BL 회수  여부 Hidden 속성 조회 시 불러온 값 -->
<input type='hidden' name ='h_ori_obl_rdem_flg'>
<!--O/BL 회수  여부 Hidden 속성 O/BL Received 입력 OR Other DOC Receive 입력 시 변경된 값-->
<input type='hidden' name ='h_aft_obl_rdem_flg'>
<!---D/O EVENT에서 변경 전 값 -->
<input type='hidden' name ='pre_ctnt'>
<!---D/O EVENT에서 변경 후 값 -->
<input type='hidden' name ='crnt_ctnt'>
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
<input type='hidden' name ='do_no'>
<input type='hidden' name ='do_no_split'>
<!--Japan D/O 에서 DOR 버튼 클릭시 설정 값 D -->
<input type='hidden' name ='svc_cd'>
<!--OBL 변경 여부-->
<input type='hidden' name ='obl_cng_flg'>
<!--O/BL Received 변경 후 값-->
<input type='hidden' name ='old_obl_rdem_knt'>
<!--O/BL Received 변경 전 값-->
<input type='hidden' name ='new_obl_rdem_knt'>

<!--O/BL Clear  여부 Hidden 속성-->
<input type='hidden' name ='h_obl_rcv_flg'>
<input type="hidden" name="nation_flag" value="kor">
<!-- DO 번호-->
<input type='hidden' name ='h_do_no'>
<input type='hidden' name ='h_do_no_split'>
<!-- Remark for Release  -->
<input type='hidden' name ='releaseRemark'>
<!-- EDI ID 조회하기 위한 쿼리 조건 값-->
<input type='hidden' name ='disc_loc_cd'>
<!--Self Trans To TMNL 체크 여부 -->
<input type='hidden' name ='self_trns_flg'>

<!-- RD를 위한 필수 파라메터-->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type='hidden' name ='mrd_id'>
<input type='hidden' name ='mrd_param'>
<input type='hidden' name ='usr_id' value="<%=strUsr_id%>">

<!--DEM.DET 팝업 호출 파라메터 2009-12-08-->
<input type='hidden' name ="demDtlXmlData">
<input type='hidden' name ='h_hold_remark' value = "">
<!-- 개발자 작업
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
    <td valign="top">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr>
            <td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
        </tr>
        <tr>
            <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
        </tr>
        </table>
-->
        <!--Page Title, Historical (E)-->
        <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-bottom:2;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id='cud'>
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_retrieve">Retrieve</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
                 <td class="btn1_line"></td>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id='cud'>
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_save">Save</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id='cud'>
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_assign">Assign</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id='cud'>
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_release">Release</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id='cud'>
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_cancel">D/O Cancel</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
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
            </tr>
            </table>
        </td></tr>
        </table>

        <!--biz page - A (S)-->
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
                        <input name='blInfo_split_flg' type="text" style="width:40;color:red; font-weight:bold;text-align: center" readOnly class="input2">
                    </td>
                    <td>
                        <table class="search_ssm1" border="0" style="width:220">
                        <tr class="h23">
                            <td width="95">&nbsp;Container No.</td>
                            <td width="">
                                <input name="cntr_no" caption="Container No." fullfill type="text" style="width:120;" class="input" maxlength="11" style="ime-mode:disabled">
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
                            <td width="62"><input type="text" style="width: 50; text-align: center" class="input2" readOnly name="blInfo_por_cd"></td>
                            <td width="27">POL</td>
                            <td width="70"><input type="text" style="width: 50; text-align: center" class="input2" readOnly name="blInfo_pol_cd"></td>
                            <td width="27">POD</td>
                            <td width="105"><input type="text" style="width: 52; text-align: center" class="input2" readOnly name="blInfo_pod_cd"></td>
                            <td width="27"> DEL</td>
                            <td width="130"><input type="text" style="width: 50; text-align: center" class="input2" readOnly name="blInfo_del_cd"></td>
                            <td width="65"> DEL Term</td>
                            <td width="110"><input type="text" style="width:79; text-align: left" class="input2" readOnly name="blInfo_de_term_desc"></td>
                            <td width="100">Arrival Vessel</td>
                            <td width="222"><input type="text" style="width: 63%; text-align: left" class="input2" readOnly name="blInfo_arrival_vessel">
                            				<input type="text" style="width: 35%; text-align: left" class="input2" readOnly name="blInfo_vvd">
                            </td>
                        </tr>
                        <tr class="h23">
                            <td width="">&nbsp;ETA</td>
                            <td colspan="3"><input type="text" style="width: 139; text-align: center" class="input2" readOnly name="blInfo_vps_eta_dt"></td>
                            <td width="">PKG</td>
                            <td width=""><input type="text" style="width: 52; text-align: right" class="input2" readOnly name="blInfo_pck_qty">
                            <input type="text" style="width: 30; text-align: center" class="input2" readOnly name="blInfo_pck_tp_cd"></td>
                            <td width="">WGT</td>
                            <td width=""><input type="text" style="width: 70; text-align: right" class="input2" readOnly name="blInfo_act_wgt">
                            <input type="text" style="width: 30; text-align: center" class="input2" readOnly name="blInfo_wgt_ut_cd"></td>
                            <td width="">MEA</td>
                            <td width=""><input type="text" style="width: 45; text-align: right" class="input2" readOnly name="blInfo_meas_qty">
                            <input type="text" style="width: 30; text-align: center" class="input2" readOnly name="blInfo_meas_ut_cd"></td>
                            <td width="">Carry-In CY</td>
                            <td width=""><input type="text" style="width:100%;" class="input2" readOnly name="blInfo_loc_nm"></td>
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>

                <!--  biz_1   (E) -->

                <table class="height_5"><tr><td></td></tr></table>
                <!-- biz_ 2_ POR (E) -->
                <table class="search_sm" border="0" style="width:979">
                <tr class="h23">
                    <td>
                        <table class="search" border="0" style="width:">
                        <tr class="h23">
                            <td width="34" class="">&nbsp;MRN</td>
                            <td width="156" class=""><input type="text" name="blInfo_mf_ref_no" style="width:139" class="input2" readOnly></td>
                            <td width="40">Partial</td>
                            <td width="56"><input type="text" style="width:30;text-align: center" class="input2" readOnly name="blInfo_cntr_prt_flg"></td>
                            <td width="65" class="" nowrap>Consignee</td>
                            <td width="362" class=""><input type="text" name="blInfo_ccust_nm" style="width:360;text-align:left;" class="input2" readOnly></td>
                            <td width="" class=""><input type="text" name="blInfo_ccust_addr"  style="width:259;text-align:left;" class="input2" readOnly></td>
                        </tr>
                        <tr class="h23">
                            <td width="" class="">&nbsp;MSN</td>
                            <td width="" class=""><input type="text" name="blInfo_mf_seq_no" style="width:139" class="input2" readOnly></td>
                            <td width="" nowrap>SOC</td>
                            <td><input type="text" style="width: 30; text-align: center" class="input2" readOnly name="blInfo_soc_flg"></td>
                            <td width="" class="" nowrap align="right">Notify</td>
                            <td width="" class=""><input type="text" name="blInfo_ncust_nm"   style="width:360;text-align:left;" class="input2" readOnly></td>
                            <td width="" class=""><input type="text" name="blInfo_ncust_addr" style="width:259;text-align:left;" class="input2" readOnly></td>
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>
                <!--  biz_1   (E) -->

                <table class="height_5"><tr><td></td></tr></table>

                <!--  biz_2 (S) -->
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="380">
                        <table class="search_sm2" border="0" style="width:99%;">
                        <tr class="h23">
                            <td>
                                <table class="search" border="0" style="width:100%; height:27">
                                <tr class="h23">
                                    <td width="70">Entry Type</td>
                                    <td width="40"><input type="text" name="blInfo_cstms_clr_tp_cd" style="width:30;" class="input2" readOnly></td>
                                    <td width="66">Warehouse</td>
                                    <td align=""><input type="text" style="width:90;" class="input2" name="blInfo_cstms_clr_wh_cd" readOnly>&nbsp;<input type="text" style="width:90;" class="input2" name="blInfo_wh_nm" readOnly></td>
                                </tr>
                                </table>
                                <!-- Button_Sub (E) -->

                                <table width="100%" class="button">
                                <tr>
                                    <td>
                                        <table style="border:0; cellpadding:0; cellspacing:0; width:100%;">
                                        <tr>
                                            <td>
                                                <table class="search" border="0" style="width:100%; height:27">
                                                <tr class="h23"> <td width="67">B/L Type</td>
                                                    <td width="40"><input type="text" name="blInfo_kr_cstms_bl_tp_cd" style="width:30;" class="input2" readOnly></td>
                                                </tr>                                       
                                                </table>
                                            </td>                                        
                                            <td class="btn2_bg">
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_msnbonded">MSN & Bonded</td>
                                                    <td class="btn2_right"></td>
                                                </tr>
                                                </table>
                                            </td>
                                            <td>
												<table class="search" style="width:100%; border:0;"> 
													<tr class="h23">
														<td width="58">Total Vol.</td>
														<td><input type="text" name="total_vol" style="width:70;" class="input2" value="" readonly></td>
													</tr>
											    </table>                                      
                                            </td>
                                        </tr>
                                        </table>
                                    </td>
                                </tr>
                                </table>
                                <!-- Button_Sub (E) -->
                            </td>
                        </tr>
                        </table>
                    </td>
                    <td width="420">
                        <table class="search_sm2" border="0" style="width:99%;">
                        <tr class="h23">
                            <td>
                                    <table width="100%" class="button"  style="width:100%; height:27">
                                <tr><td>
                                        <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td style="padding-left:24"><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
                                            <tr>
                                                <td class="btn1_left"></td>
                                                <td class="btn1" name="btn_do" id="btn_do">D/O 발급</td>
                                                <td class="btn1_right"></td>
                                            </tr>
                                           </table>
                                         </td>
                                         <td width="">
                                             <input type="checkbox" class="trans" name='edo_rqst_sts' value='do' disabled>
                                         </td>
                                        </tr>
                                      </table>
                                    </td>
                                    <td>
                                      <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                         <td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
                                            <tr>
                                                <td class="btn1_left"></td>
                                                <td class="btn1" name="btn_self" id="btn_self">자가요청</td>
                                                <td class="btn1_right"></td>
                                            </tr>
                                           </table>
                                         </td>
                                         <td width="">
                                             <input type="checkbox" class="trans" name='edo_rqst_sts' value='self' disabled>
                                         </td>
                                        </tr>
                                      </table>
                                    </td>
                                     <td>
                                      <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                         <td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
                                            <tr>
                                                <td class="btn1_left"></td>
                                                <td class="btn1" name="btn_bonded" id="btn_bonded">보운동의</td>
                                                <td class="btn1_right"></td>
                                            </tr>
                                           </table>
                                         </td>
                                         <td width="">
                                             <input type="checkbox" class="trans" name='edo_rqst_sts' value='bonded' disabled>
                                         </td>
                                        </tr>
                                      </table>
                                    </td>
                                </tr>
                                </table>

                                <!-- Button_Sub (E) -->
                                <table width="100%" class="button">
                                <tr><td class="btn2_bg">
                                        <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_attorney">위임장</td>
                                                    <td class="btn2_right"></td>
                                                </tr>
                                                </table>
                                            </td>

                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_edoinquiry">ED/O Inquiry</td>
                                                    <td class="btn2_right"></td>
                                                </tr>
                                                </table>
                                            </td>

                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_edotransmit">ED/O Transmit</td>
                                                    <td class="btn2_right"></td>
                                                </tr>
                                                </table>
                                            </td>

                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_edoresult"  id="btn_edoresult">E-D/O Result</td>
                                                    <td class="btn2_right"></td>
                                                </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </table>
                                    </td>
                                </tr>
                                </table>
                                <!-- Button_Sub (E) -->
                            </td>
                        </tr>
                        </table>
                    </td>
                    <td width="">
                        <table class="search_sm2" border="0" style="width:99%;">
                        <tr class="h23">
                            <td>
                                <table height="3"><tr><td></td></tr></table>
                                <table class="search" border="0" style="width:100%;">
                                <tr class="h23">
                                    <td align="right">Self Trans To TMNL&nbsp;&nbsp;<input type="checkbox" class="trans" id='selfTransToTMN'></td>
                                </tr>
                                </table>

                                <!-- Button_Sub (E) -->
                                <table width="100%" class="button">
                                <tr>
                                    <td class="btn2_bg">

                                        <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_stcancel">S/T Cancel</td>
                                                    <td class="btn2_right"></td>
                                                </tr>
                                                </table>
                                            </td>

                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_edisend">EDI Send</td>
                                                    <td class="btn2_right"></td>
                                                </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        </table>
                                    </td>
                                </tr>
                                </table>
                                <!-- Button_Sub (E) -->
                                <table height="1"><tr><td></td></tr></table>
                            </td>
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>
                <!--  biz_2  (E) -->

                <table class="search" height="5"><tr><td></td></tr></table>

                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <td width="979" valign="top">
                        <table border="0" style="width:100%; background-color:white;">
                        <tr>
                            <td width="100%">
                                <!--B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출-->
                                <script language="javascript">ComSheetObject('doRlseSts');</script>
                            </td>
                        </tr>
                        </table>
                        <!--  biz_ 3_ Grid (E) -->
                    </td>
                </tr>
                </table>
                <!-- biz_ 3,4, (E) -->

                <table class="search" height="5"><tr><td></td></tr></table>
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
                            <td width="30"><input type="text" name="blInfo_obl_rdem_flg" style="width:25; color:blue; font-weight:bold;text-align:center;" class="input2" readonly></td>
                            <td width="30" align='right'>No</td>
                            <td width="30"><input type="text" name="blInfo_obl_cpy_knt" style="width:25;color:black;text-align:center; font-weight:bold;" class="input2" readonly></td>
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
                                    <td class="title_s">TPB</td>
                                </tr>
                                </table>
                            </td>
                            <td width="20"><img src="img/btng_icon_g.gif" width="13" height="13" border="0" align="absmiddle" id="tpb_icon"></td>
                            <td width="50"><input type="text" style="width:20;;text-align:center;" name='tpb_cd' class="input2" readOnly>&nbsp;<img class="cursor" name="btn_tpb" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="">
                                <input type="text" name='hold_flag' style="width:50; text-align:center;" class="input2_1" readOnly>
                                <input type="hidden" name='blInfo_do_hld_flg'>
                            </td>
                        </tr>
                        </table>

                        <table class="search" height="3"><tr><td></td></tr></table>

                        <table class="search_sm" border="0" style="width:100%">
                        <tr class="h23">
                            <td width="110">B/L Issue</td>
                            <td width="45"><input type="text" name="blInfo_bl_tp_cd" style="width:89%; text-align:center" class="input2" readOnly></td>
                            <td width="25">OFC</td>
                            <td width="140">
                                <input type="text" name="blInfo_obl_iss_ofc_cd" style="width:60;" class="input2" readOnly>
                                <input type="text" name="blInfo_obl_iss_usr_id" style="width:70;" class="input2" readOnly></td>
                            <td width="20">DT</td>
                            <td width="">
                                <input type="text" name="blInfo_obl_iss_dt" style="width:110;" class="input2" readOnly>
                                <input type="text" style="width:1;text-align:center;"  class="noinput2" readOnly></td>
                        </tr>
                        <tr class="h23">
                            <td>B/L Receive</td>
                            <td><input type="text" name="blInfo_obl_rdem_knt" style="width:89%;text-align:center;" class="input" dataformat="int" style="ime-mode: disabled" maxlength='3'></td>
                            <td>OFC</td>
                            <td>
                                <input type="text" name="blInfo_obl_rdem_ofc_cd" style="width:60;" class="input2" readOnly>
                                <input type="text" name="blInfo_obl_rdem_usr_id" style="width:70;" class="input2" readOnly></td>
                            <td>DT</td>
                            <td>
                                <input type="text" name="blInfo_obl_rdem_dt" style="width:110;text-align:center;" class="input2" readOnly>
                                <input type="text" name="bl_surr_rmk_flg" style="width:50;text-align:center;"  class="input2" readOnly><img id="div_btn_bl_surr_flg" name="btn_bl_surr_rmk" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                        </tr>
                        <tr class="h23">
                            <td>Other DOC RCV</td>
                            <td>
                                <select style="width:89%;text-align:center;" name="blInfo_bl_otr_doc_rcv_cd">
                                    <option ></option>
                                    <option value="LG">LG</option>
                                    <option value="LI">LI</option>
                                </select>
                            </td>
                            <td>OFC</td>
                            <td><input type="text" name="blInfo_otr_doc_rcv_ofc_cd" style="width:60;" class="input2" readOnly>
                            <input type="text" name="blInfo_otr_doc_rcv_usr_id" style="width:70;" class="input2" readOnly></td>
                            <td>DT</td>
                            <td><input type="text" name="blInfo_otr_doc_rcv_dt" style="width:110;" class="input2" readOnly>
                                <select name="blInfo_otr_doc_cgor_flg" style="width:70;text-align:center;">
                                    <option ></option>
                                    <option value="N">Non-Accept</option>
                                    <option value="Y">Accept</option>
                                </select>
                            </td>
                        </tr>
                        <tr class="h23">
                            <td>Inbond DOC RCV</td>
                            <td><input type="text" name="blInfo_aaa" style="width:89%;text-align:center;"  class="input2" readOnly></td>
                            <td>OFC</td>
                            <td>
                                <input type="text" name="blInfo_bbb" style="width:60;text-align:center;"  class="input2" readOnly>
                                <input type="text" name="blInfo_ccc" style="width:70;text-align:center;"  class="input2" readOnly></td>
                            <td>DT</td>
                            <td>
                                <input type="text" name="blInfo_ddd" style="width:110;text-align:center;"  class="input2" readOnly>
                                <input type="text" name="blInfo_ccc" style="width:10;text-align:center;"  class="noinput2" readOnly></td>
                        </tr>
                        </table>
                        <!--  biz_4 _1 (E) -->
                    </td>
                    <td width="10">&nbsp;</td>
                    <td width="424">

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
                                <input type="text" style="width:20;text-align:center;" class="input2_1" name='blInfo_tot_ots_sts_cd' readonly>
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
                            <td width="60" align="left"><input type="text" name="blInfo_ppt_sts_cd" style="width:27;text-align:center;" class="input2" readOnly></td>
                            <td>OFC</td>
                            <td>
                                <input type="text" name="blInfo_ppt_rcv_ofc_cd" style="width:60;text-align:left;" class="input2" readOnly>
                                <input type="text" name="blInfo_ppt_rcv_usr_id" style="width:70;text-align:left;" class="input2" readOnly></td>
                            <td width="20">DT</td>
                            <td width="" nowrap><input type="text" name="blInfo_ppt_rcv_dt" style="width:125;text-align:center;" class="input2" readOnly></td>
                        </tr>
                        <tr class="h23">
                            <td>CCT1</td>
                            <td align="left"><input type="text" name="blInfo_cct_sts_cd" style="width:27;text-align:center;color:red;" class="input2" readOnly>&nbsp;<img id="div_btn_cct" name="btn_cct" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                            <td>OFC</td>
                            <td>
                                <input type="text" name="blInfo_cct_rcv_ofc_cd" style="width:60;text-align:left;" class="input2" readOnly>
                                <input type="text" name="blInfo_cct_rcv_usr_id" style="width:70;text-align:left;" class="input2" readOnly></td>
                            <td>DT</td>
                            <td><input type="text" name="blInfo_cct_rcv_dt" style="width:125;text-align:center;" class="input2" readOnly></td>
                        </tr>
                        <tr class="h23">
                            <td>PPD2</td>
                            <td align="left"><input type="text" name="blInfo_n3pty_ppt_sts_cd" style="width:27;text-align:center;" class="input2" readOnly></td>
                            <td>OFC</td>
                            <td>
                                <input type="text" name="blInfo_n3pty_ppt_rcv_ofc_cd" style="width:60;text-align:left;" class="input2" readOnly>
                                <input type="text" name="blInfo_n3pty_ppt_rcv_usr_id" style="width:70;text-align:left;" class="input2" readOnly></td>
                            <td>DT</td>
                            <td><input type="text" name="blInfo_n3pty_ppt_rcv_dt" style="width:125;text-align:center;" class="input2" readOnly></td>
                        </tr>
                         <tr class="h23">
                            <td>CCT2</td>
                            <td align="left"><input type="text" name="blInfo_n3pty_cct_sts_cd" style="width:27;text-align:center;color:red;" class="input2" readOnly>&nbsp;<img id="div_btn_third_cct" name="btn_third_cct" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                            <td>OFC</td>
                            <td>
                                <input type="text" name="blInfo_n3pty_cct_rcv_ofc_cd" style="width:60;text-align:left;" class="input2" readOnly>
                                <input type="text" name="blInfo_n3pty_cct_rcv_usr_id" style="width:70;text-align:left;" class="input2" readOnly></td>
                            <td>DT</td>
                            <td><input type="text" name="blInfo_n3pty_cct_rcv_dt" style="width:125;text-align:center;" class="input2" readOnly></td>
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
                                        <td  width="" align="left" colspan="3" id="obl_inter_ser_no_chk_title" height="30"></td>
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

                    <td width="">
                        <input type="text" name='demur_sts' style="width:25; font-weight:bold;" class="input2" readOnly>&nbsp;
                        <select style="width:160;font-weight:bold;" class="input2" name='tot_bil_amt'></select>
                    </td>

                    <td width="170">
                        <table class="search_sm2" border="0" style="width:160">
                        <tr class="h23">
                            <td width="">Demurrage Type&nbsp;<input type="text" name='demur_type' style="width:35;" class="input2" readOnly></td>
                        </tr>
                        </table>
                     </td>
                     <td width="" >
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

                    <td width="70">
                        <table width="60" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btn_dmdt">DMDT</td>
                            <td class="btn2_right"></td>
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>

                <table class="height_5"><tr><td></td></tr></table>
                <!--  biz_4   (E) -->

                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <td width="979" valign="top">
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
                    <td>
                </tr>
                </table>

                <div id="" style="display:none">
                <!-- Grid  (S) -->
                <table width="979"  id="mainTable">
                <tr>
                    <td width="100%">
                        <!--컨테이너 별 Demurrage-->
                        <script language="javascript">ComSheetObject('demDtl');</script>
                    </td>
                </tr>
                </table>
                <!-- Grid (E) -->
                </div>

                <table class="height_8"><tr><td colspan="8"></td></tr></table>

                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="49%" valign="top">
                        <table border="0" style="width:100%; background-color: white;" class="grid2">
                        <tr class="h23" align="center">
                            <td width="100%" class="tr2_head">O/B Remark(s)</td>
                        </tr>
                        <tr class="h23" align="center">
                            <td width="" class="noinput2"><textarea style="width: 100%; height:18" name='blInfo_obl_iss_rmk' readonly class="noinput2"></textarea></td>
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
                <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_hold" id='hld'>Hold</td>
                    <td class="btn1" name="btn_hold" id='uhld' style="display:none">Hold Removal</td>
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
                    <td class="btn1" name="btn_preview">Preview</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>

           <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			   <tr><td class="btn1_left"></td>
				   <td class="btn1" name="btn_bl_preview">B/L&nbsp;Preview</td>
				   <td class="btn1_right"></td>
			   </tr>
			</table></td>				
         
        </tr>
        </table>
    </td>
</tr>
</table>
<!--Button (E) -->

<!--RD -->
<table width="0"border="0" cellpadding="0" cellspacing="0">
<tr>
    <td height="0" width="0"><script language="javascript">comRdObject('report1');</script></td>
</tr>
</table>

<!----------------------------------------------------------------------
    Hidden IB Sheet Define
----------------------------------------------------------------------->
<!--Korea D/O Release 기본 정보-->
<script language="javascript">ComSheetObject('blInfo');</script>
<!--Korea D/O Release Reference 정보
<script language="javascript">ComSheetObject('refInfo');</script>
-->
<!--Korea 세관 신고를 위한 B/L INFO
<script language="javascript">ComSheetObject('cstmsInfo');</script>
-->
<!--Original B/L 회수 여부와 발행 통수 및  Detail정보
<script language="javascript">ComSheetObject('blIss');</script>
-->
<!--운임 결재 여부와 Outstanding Amounts 정보
<script language="javascript">ComSheetObject('otsRcvInfo');</script>
-->
<!--Total Billable Amount-->
<script language="javascript">ComSheetObject('totBlbAmt');</script>
<!--KT-NET
<script language="javascript">ComSheetObject('ktNet');</script>
-->
<!--S/T Cancel
<script language="javascript">ComSheetObject('stCancel');</script>
-->
<!--Partial 컨테이너 정보 조회-->
<script language="javascript">ComSheetObject('partial');</script>
<!--OutStanding Amount 팝업용 조회
<script language="javascript">ComSheetObject('otsRcvPop');</script>
-->
<script language="javascript">ComSheetObject('totVol');</script>
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>