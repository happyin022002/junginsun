<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0091.jsp
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifier : 유선오
*@LastModifyDate : 2011.12.29
*@LastVersion : 2.3
* 2006.11.21 조풍연
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2009.01.09   양봉준 	1.1 [N200901090011] W/O Issue 화면 보완요청
* 2009.04.31   양봉준 	1.2 [CHM-200900431] Customer Code 입력가능요청(09.08.24)
* 2010.10.08   최 선     	1.3 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
* 2011.02.08   이재위 	1.4 [CHM-201108673-01] [TRS] Work Order Issue(ESD_TRS_0091) : W/O Preview per B/L 기능 개발
* 2011.02.10   민정호 	1.5 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
* 2011.04.27   최  선 	1.6 [] [TRS] CREATE USER ID 세션 정보 참조하여 사용
* 2011.05.06 손은주    1.7 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.06.15 최 선      1.8 [] [TRS] TRS-TPB I/F 미실행 오류 조치
* 2011.07.14 김영철    1.9 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청
* 2011.07.20 최 선      2.0 [] UI 상단 공백 제거
* 2011.10.20 이수진    2.1 [CHM-201113210] [TRS] Feeder Term 표기 칼럼 추가 요청
* 2011.12.22 민정호    2.2 [CHM-201115196] [TRS] W/O ISSUE시 S/O History에 agmt no 정보를 남길 수 있도록 기능 수정
* 2011.12.29 유선오    2.3 [CHM-201115242] [TRS] W/O preview 화면 관련 Validation 추가, BKG data 참조로직 변경요청
* 2012.05.08 김종호    2.4 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경
* 2012.07.20 김종호    2.5 [] [TRS] W/O preview 화면에서 최종 confirm 시 로그인ofc와 S/O지역코드를 비교하기 위한 로직 추가
* 2012.12.11 이재위    2.6 [CHM-201221537] W/O issue 화면에 Currency / Negotiated 금액 save 버튼 생성 개발 요건
=========================================================*/
--%>



<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.event.EsdTrs0091Event"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.common.trscommon.event.EsdTrs0999Event"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBCImpl"%>

<%!
    private ArrayList splitStr(String src, String delim)
    {
        if(src == null || src.equals("")) return null;
        ArrayList returnV = new ArrayList();

        StringTokenizer st = new StringTokenizer(src, delim);
        String tempNo = null;

        tempNo = st.nextToken();
        returnV.add(tempNo);

        while (st.hasMoreTokens()) {
            tempNo = st.nextToken(); 
            returnV.add(tempNo);
        }
        return returnV;
    }

%>
<%
    EsdTrs0091Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    DBRowSet rowSet   = null;                              //DB ResultSet
    String strErrMsg = "";                               //에러메세지
    int rowCount     = 0;                                 //DB ResultSet 리스트의 건수􋈍

    SignOnUserAccount account = null;

	String cnt_cd 				= "";
	String ofc_cd  				= "";  
	
    try {

        account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        event = (EsdTrs0091Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

    }catch(Exception e) {
        out.println(e.toString());
    }

    String today = DateTime.getFormatString("yyyyMMdd");
    String beforeOneMonth = DateTime.addMonths(today, -1);

    String costModeCd   = JSPUtil.getCodeCombo("trs_cost_md_cd", "01", "style='width:160'", "CD00958", 0, "000020:ALL:ALL");
    String transModeCd  = JSPUtil.getCodeCombo("trs_md_cd", "01", "style='width:50'", "CD00283", 0, "000010:ALL:ALL");
    String boundCd = JSPUtil.getCodeCombo("trs_bnd_cd", "01", "style='width:57'", "CD00591", 0, "000030:ALL:ALL");
    String soTpCd   = JSPUtil.getCodeCombo("trs_so_tp_cd", "01", "style='width:130'", "CD00279", 0, "000040:ALL:ALL");

    ArrayList trsp_so_ofc_cty_cd = splitStr(request.getParameter("trsp_so_ofc_cty_cd"),",");
    ArrayList trsp_so_seq = splitStr(request.getParameter("trsp_so_seq"),",");
    String eq_mode = StringUtil.xssFilter(request.getParameter("eq_mode"));
    String init_searchStr = "";
    if(trsp_so_ofc_cty_cd != null && trsp_so_ofc_cty_cd.size()>0){
    init_searchStr = "&ibflag=R&trsp_so_ofc_cty_cd="+StringUtil.xssFilter(request.getParameter("trsp_so_ofc_cty_cd"))+"&trsp_so_seq="+StringUtil.xssFilter(request.getParameter("trsp_so_seq"));
    }
    
//    이하 기존 enis 방식임, alps의 dbdao에서 W/O NO를 split해서 쓰게함.        
//    StringBuffer init_searchStr = new StringBuffer();

//    if(trsp_so_ofc_cty_cd != null && trsp_so_ofc_cty_cd.size()>0 && trsp_so_ofc_cty_cd.size() == trsp_so_seq.size()) {

//        for(int i=0; i< trsp_so_ofc_cty_cd.size(); i++)
//        {
//            init_searchStr.append( "&ibflag=R&trsp_so_ofc_cty_cd="+(String)trsp_so_ofc_cty_cd.get(i)
//                +"&trsp_so_seq="+(String)trsp_so_seq.get(i));
//        }
//    }

    ofc_cd	= account.getOfc_cd();
    cnt_cd 	= account.getCnt_cd();

    // Office Change 개념의 모듈적용
    TrsCommonBCImpl trsCommonBC = new TrsCommonBCImpl();
    cnt_cd						= trsCommonBC.searchContiCd(ofc_cd);
%>
<html>
<head>
<title>W/O Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var beforeOneMonth = '<%=beforeOneMonth%>';
    var today = '<%=today%>';

    var init_searchStr = '<%=init_searchStr.toString()%>';

    <%=BizComUtil.getIBCodeCombo("po_local_curr_cd", "01", "CURR", 1, " |")%>
    <%= JSPUtil.getIBCodeCombo("trsp_rjct_rsn_cd", "", "CD00957", 0, "")%>
    <%//= JSPUtil.getIBCodeCombo("po_way_type", "", "CD00929", 0, "")%>

	var cnt_cd = "<%=cnt_cd%>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();" >
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="EQ_MODE" value="<%=eq_mode%>">
<input type='hidden' name='wo_prv_grp_seq'>
<input type='hidden' name='wo_iss_no'>
<input type='hidden' name='wo_prv_grp_bl_flg' value="N">
<input type='hidden' name='trsp_so_no'>

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
        <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
        <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


        <!-- TABLE '#D' : ( Button : Main ) (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
            <tr><td class="btn1_bg">

                <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <!-- Repeat Pattern -->
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

                    <td class="btn1_line"></td>

                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
                    <!-- Repeat Pattern -->

                </tr></table>

            </td></tr>
        </table>
        <!-- TABLE '#D' : ( Button : Main ) (E) -->



        <div id="MiniLayer" style="display:inline">

        <!-- TABLE '#D' : ( Search Options ) (S) -->
        <table class="search">
        <tr><td class="bg">

                <!-- : ( Year ) (S) -->
                <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="120">Work Order Issued</td>
                            <td width="137">
                                <table border="0" style="height:15; width:100; background-color: #E9E9E9;">
                                    <tr><td align="center" class="sm"><input type="radio" name='wo_radio' value="N" onClick='setWOIssue(this);' class="trans" checked>No&nbsp;&nbsp;&nbsp;<input type="radio" name='wo_radio' value="Y" onClick='setWOIssue(this);' class="trans">Yes</td></tr>
                                </table>
                            </td>
                            <td width="110">Service Provider</td>
                            <td><input type='text' name='combo_svc_provider'  style="width:100;" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)'>
                                <input type="text" name='svc_provider' readOnly style="width:484;" class="input2"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_provider'></td>
                        </tr>
                    </table>

                    <table class="height_1"><tr><td></td></tr></table>

                    <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="77">Date</td>
                            <td>
                                <table border="0" style="height:15; width:550; background-color: #E9E9E9;">
                                <tr><td class="sm" width="400" style="padding-left:10;">
                                        <!-- <input type="radio" name='dt_radio' value="plan_dpt" onClick='setWOIssue(this);' class="trans" >Planned Departure&nbsp; -->
                                        <!-- <input type="radio" name='dt_radio' value="dor_arr" onClick='setWOIssue(this);' class="trans" >Door Arrival&nbsp; -->
                                        <input type="radio" name='dt_radio' value="so_create" onClick='setWOIssue(this);' class="trans" checked>Service Order Created&nbsp;
                                        <!-- <input type="radio" name='dt_radio' value="wo_issue" onClick='setWOIssue(this);' class="trans" disabled>Work Order Issue&nbsp; -->
                                        <!-- <input type="radio" name='dt_radio' value="wo_reject" onClick='setWOIssue(this);' class="trans">Work Order Rejected -->
                                        <input type="radio" name='dt_radio' value="spot_bid_due" onClick='setWOIssue(this);' class="trans">Spot Bid Due
                                    </td>
                                    <td><input name="fmdate" type="text" maxlength="8" style="width:70;" value="">&nbsp;~&nbsp;<input name="todate" type="text" maxlength="8" style="width:70;" value=""><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name='btns_calendar'>
                                    </td>
                                </tr>
                                </table>
                            </td>
							<!-- <td>CNT&nbsp;</td>
						    <td>
                            	<SELECT name="cnt_flg" style="width:40;">
	                            	<OPTION  value=""></OPTION>
                            		<OPTION  value="Y">Y</OPTION>
                            		<OPTION  value="N">N</OPTION>
                            	</SELECT>
                            </td> -->
							<!-- <td width="450"><input name="fmdate" type="text" maxlength="8" style="width:70;" value="">&nbsp;~&nbsp;<input name="todate" type="text" maxlength="8" style="width:70;" value=""><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name='btns_calendar'> -->
							<%-- <input name="fmdate" type="text" style="width:75;" value="<%=today%>" maxlength=8><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name='btns_duedt'> --%></td>
							<td width="77">Bid No.</td>
                            <td width=""><input name='spot_bid_no' type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onBlur='javascript:this.value=this.value.toUpperCase();' onKeyup='enterCheck(this)' style="width:120;" ><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_spot_bid_no'></td>
                    </table>
                    <table class="height_1"><tr><td></td></tr></table>

                    <table class="search_in" border="0">
                    <tr class="h23">
                    <td width="77">Bound</td>
                    <td width="180"><%=boundCd%></td>
                    <td width="75">Cost Mode</td>
                    <td width="195"><%=costModeCd%></td>
                    <td width="83">Trans Mode</td>
                    <td width="122"><%=transModeCd%></td>
                    <td width="115">Service Order Type</td>
                    <td align="right"><%=soTpCd%></td>
                    </tr>
                    </table>

                    <table class="height_1"><tr><td></td></tr></table>

                    <table class="search_in" border="0">
                        <tr class="h23">
                        <td width="77">From </td>
                        <td width="61"><input type="text" style="width:57;" name="search_fm_loc" onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength="5"></td>
                        <td width="121"><script language="javascript">ComComboObject('search_fm_yard', 1, 49, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>

                        <td width="73">Via </td>
                        <td width="57"><input type="text" style="width:53;" name="search_via_loc" onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength="5"></td>
                        <td width="140"><script language="javascript">ComComboObject('search_via_yard', 1, 46, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_vianode"></td>

                        <td width="23">To </td>
                        <td width="60"><input type="text" style="width:56;" name="search_to_loc" onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength="5"></td>
                        <td width="121"><script language="javascript">ComComboObject('search_to_yard', 1, 50, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tonode"></td>

                        <td width="114">Door </td>
                        <td width="60"><input type="text" style="width:56;" name="search_door_loc" onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength="5"></td>
                        <td><script language="javascript">ComComboObject('search_door_yard', 1, 50, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_dorloc"></td>
                        </tr>
                    </table>

                    <table style="width:949;" class="line_bluedot"><tr><td></td></tr></table>

                    <table class="search_in" border="0" style="display:none">
                        <tr class="h23">
                            <td width="77">T.VVD</td>
                            <td width="182"><input name='tvvd_no' class="input1" type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onKeyup='enterCheck(this)' style="width:107;"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_tvvd_no'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btns_tvvd_s_no'></td>
                            <td width="75">F.VVD</td>
                            <td>

                                <table border="0" style="height:15; width:400; background-color: #E9E9E9;">
                                <tr><td class="sm" width="170" style="padding-left:10;">
                                        <input type="radio" name='f_vvd_radio' value="A" onClick='' class="trans" checked>All&nbsp;
                                        <input type="radio" name='f_vvd_radio' value="I" onClick='' class="trans">In VVD&nbsp;
                                        <input type="radio" name='f_vvd_radio' value="O" onClick='' class="trans">Out VVD&nbsp;
                                    </td>
                                    <td>
                                        <input name='fvvd_no' type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onKeyup='enterCheck(this)' style="width:168;" ><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_fvvd_no'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btns_fvvd_s_no'>
                                    </td></tr>
                                </table>

                            </td></tr>
                    </table>
                    <table class="height_1"><tr><td></td></tr></table>
                    <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="77">Booking No.</td>
                            <td width="182"><input name='bkg_no' type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onBlur='javascript:this.value=this.value.toUpperCase();' onKeyup='enterCheck(this)' style="width:107;" ><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_bkg_no'></td>
                            <td width="73">B/L No.</td>
                            <td width="198"><input name='bl_no' type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onKeyup='enterCheck(this)' style="width:120;" ><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_bl_no'></td>
                            <td width="99">Equipment No.</td>
                            <td align="right">

                                <table border="0" style="height:15; width:350; background-color: #E9E9E9;">
                                <tr><td class="sm" width="200" style="padding-left:13;">
                                        <input type="radio" name='eq_radio' value="U" onClick='checkDigit()' class="trans" checked>Container&nbsp;&nbsp;
                                        <input type="radio" name='eq_radio' value="Z" onClick='' class="trans">Chassis&nbsp;&nbsp;
                                        <input type="radio" name='eq_radio' value="G" onClick='' class="trans">Genset&nbsp;
                                    </td>
                                    <td align="right">
                                        <input name='eq_no' type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onChange='checkDigit(this)' onKeyup='enterCheck(this)'  style="width:109;"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_eq_no'>
                                    </td></tr>
                                </table>

                            </td></tr>
                    </table>
                    <table class="height_1"><tr><td></td></tr></table>
                    <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="77">S/O No.</td>
                            <td width="182"><input name='so_no' type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onKeyup='enterCheck(this)' style="width:129;" ><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_so_no'></td>
                            <td width="73">W/O No.</td>
                            <td width="198"><input name='wo_no' type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onKeyup='enterCheck(this)' style="width:120;" readOnly><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_wo_no'></td>
                            <td width="120">MTY Reference No.</td>
                            <td><input name='mty_rfrn_no' type="text" onBlur='javascript:this.value=this.value.toUpperCase();' onKeyup='enterCheck(this)'  onBlur='javascript:this.value=this.value.toUpperCase();' style="width:120;" ><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_mty_rfrn_no'></td>
                        </tr>
                    </table>

                <!-- : ( Year ) (E) -->


            </td></tr>
        </table>
        <!-- TABLE '#D' : ( Search Options ) (E) -->
       </div>
        <table class="height_10"><tr><td></td></tr></table>


        <!-- TABLE '#D' : ( Search Options ) (S) -->
        <table class="search">
        <tr><td class="bg" height = 330>



                <!-- : ( Seq. ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
                <!-- : ( Seq. ) (E) -->
                <!-- : ( Seq. ) (S) -->
                <!-- surcharge sheet (sheet2) -->
                     <table width="100%" id="hiddenTable1">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
                     </table>

                <!-- : ( Seq. ) (E) -->
                                <!-- : ( Seq. ) (S) -->
                <!--       wo issued 시   sheet에서 so 삭제를 위해 work order preview 화면에서 wo confirm 눌렀을 때  호출되는 함수에서 confirm 후  work order no로 조회된 so 데이터(sheet3) -->
                     <table width="100%" id="hiddenTable2"> 
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
                    </table> 
                    <!--   RateReApply 시 사용되는 (sheet4) -->
                    <table width="100%" id="hiddenTable3">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet4');</script>
                        </td></tr>
                    </table>

                <!-- : ( Seq. ) (E) -->
                <!-- : ( Button : Grid ) (S) -->
                <table width="100%" class="button">
                    <tr><td class="btn2_bg">
                    <table border="0" cellpadding="0" cellspacing="0">
                    <tr>

                        <!-- Repeat Pattern -->                        
                        <!-- <td>
                        <div id="Bundling" style="display:">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" id="btng_bundling" name="btng_bundling">Bundling</td><td class="btn2_right"></td></tr></table>
                        </div>
                        </td>                        
                        <td>
                        <div id="RateReApply" style="display:">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_ratereapply" name="btng_ratereapply">Rate Reapply</td><td class="btn2_right"></td></tr></table>
						</div>
                        </td>
                        <td>
                        <div id="ApptDeliImportLayer" style="display:none">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" id="btng_apptdeliexcelimport" name="btng_apptdeliexcelimport">Appt./Deli. Excel Import</td><td class="btn2_right"></td></tr></table>
                        </div>
                        </td>
                        <td>
                        <div id="ApptDeliSaveLayer" style="display:none">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" id="btng_apptdelisave" name="btng_apptdelisave">Appt./Deli. Save</td><td class="btn2_right"></td></tr></table>
                        </div>
                        </td>
                                                
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" id="btng_surchargeapply" name="btng_surchargeapply">Surcharge Apply</td><td class="btn2_right"></td></tr></table></td>

                        <td>
                        <div id="Currnego" style="display:none">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" id="btng_currnegosave" name="btng_currnegosave">Curr./Nego. Save</td><td class="btn2_right"></td></tr></table>
                        </div>
                        </td>

                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" id="btng_frustrate" name="btng_frustrate">Frustrate</td><td class="btn2_right"></td></tr></table></td>

                        <td>
                        <div id="SpSelect" style="display:">
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td><td class="btn2" id="btng_spselect" name="btng_spselect">S/P Select</td><td class="btn2_right"></td></tr>
                            </table>
                        </div>
                        </td>

                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" id="btng_morecandidate" name="btng_morecandidate">Multi More Candidate</td><td class="btn2_right"></td></tr></table></td>

                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" id="btng_morecntcandidate" name="btng_morecntcandidate">More CNT Candidate</td><td class="btn2_right"></td></tr></table></td> -->
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" id="btng_wopreview" name="btng_wopreview">W/O Preview</td><td class="btn2_right"></td></tr></table></td>

                        <!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" id="btng_wopreviewperbl" name="btng_wopreviewperbl">W/O Preview per B/L</td><td class="btn2_right"></td></tr></table></td> -->
                        <!-- Repeat Pattern -->


                    </tr></table>
                </td></tr>
                </table>
                <!-- : ( Button : Grid ) (E) -->

            </td></tr>
        </table>
        <!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
<form name='woForm' method='POST' action='ESD_TRS_0024.screen'>
<input type="hidden" name="pgmNo" >
<input type='hidden' name='rd_cgo'>
<input type='hidden' name='trsp_so_ofc_cty_cd'>
<input type='hidden' name='trsp_so_seq'>
<input type='hidden' name='wo_cancel_flag'>
<input type='hidden' name='dtn_use_flg'>
<input type='hidden' name='wo_bl_no_iss_flg'>
<input type='hidden' name='vndr_seq'>
<input type='hidden' name='po_local_curr_cd'>
<input type='hidden' name='po_basic_rt'>
<input type='hidden' name='nego_amt'>
<input type='hidden' name='etc_add_amt'>
<input type='hidden' name='po_fuel_scg_rt'>
<input type='hidden' name='po_vat_scg_rt'>
<input type='hidden' name='toll_fee_amt'>
<input type='hidden' name='po_usd_curr_tot_amt'>
<!-- GuideLine Rate Start -->
<input type='hidden' name='gline_vndr_seq'>
<input type='hidden' name='gline_po_local_curr_cd'>
<input type='hidden' name='gline_po_basic_rt'>
<input type='hidden' name='gline_nego_amt'>
<input type='hidden' name='gline_etc_add_amt'>
<input type='hidden' name='gline_po_fuel_scg_rt'>
<input type='hidden' name='gline_po_vat_scg_rt'>
<input type='hidden' name='gline_toll_fee_amt'>
<input type='hidden' name='gline_po_usd_curr_tot_amt'>
<!-- GuideLine Rate End -->
<input type='hidden' name='n3pty_bil_flg'>
<input type='hidden' name='eq_mode' value='IS'>
<input type='hidden' name='issued'>
<input type='hidden' name='scg_grp_seq'>
<input type='hidden' name='cust_cnt_cd'>
<input type='hidden' name='cust_seq'>
<input type='hidden' name='cust_nomi_trkr_flg'>
<input type='hidden' name='trsp_agmt_rt_tp_cd'>
<input type='hidden' name='trsp_agmt_wy_tp_cd'>
<input type='hidden' name='trsp_frst_flg'>
<input type='hidden' name='trsp_rjct_rsn_cd'>
<input type='hidden' name='trsp_dflt_vndr_flg'>

<input type='hidden' name='n1st_nod_pln_dt'>
<input type='hidden' name='lst_nod_pln_dt'>
<input type='hidden' name='dor_nod_pln_dt'>
<input type='hidden' name='inter_rmk'>
<input type='hidden' name='spcl_instr_rmk'>

<input type='hidden' name='FORM_FCTRY_NM'>
<input type='hidden' name='FORM_DOR_PST_CD'>
<input type='hidden' name='FORM_CNTC_PSON_PHN_NO'>
<input type='hidden' name='FORM_CNTC_PSON_FAX_NO'>
<input type='hidden' name='FORM_CNTC_PSON_NM'>

<input type='hidden' name='n3pty_cust_cnt_cd'>
<input type='hidden' name='n3pty_cust_seq'>
<input type='hidden' name='n3pty_desc'>
<input type='hidden' name='n3pty_vndr_seq'>
<input type='hidden' name='n3pty_ofc_cd'>
<input type='hidden' name='n3pty_bil_bzc_amt'>
<input type='hidden' name='n3pty_bil_tp_cd'>
<input type='hidden' name='n3pty_curr_cd'>

<input  type="hidden" name="sysCommUiTitle" value="Preview">
<input  type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">

<input type='hidden' name='wo_prv_grp_bl_flg' value="N">

<input type='hidden' name='wtr_rcv_term_cd'>
<input type='hidden' name='wtr_de_term_cd'>

<input type='hidden' name='po_trsp_agmt_ofc_cty_cd'>
<input type='hidden' name='po_trsp_agmt_seq'>

<input type='hidden' name='po_cfm_flg'>
<input type='hidden' name='po_agmt_rt_seq'>
<input type='hidden' name='po_agmt_upd_dt'>

<input type='hidden' name='trsp_so_no'> <!-- W/O 컨펌 시 S/O와 ofc코드가 일치하는지 확인하기 위해 전송-->

</form>

<form name='soForm' method='POST' action='ESD_TRS_019.screen'>
<input type='hidden' name='trsp_so_ofc_cty_cd'>
<input type='hidden' name='trsp_so_seq'>
</form>

<FORM NAME='scgForm' method='POST'>
<input type='hidden' name='unique_cd'>
<input type='hidden' name='open_mode'>
<input type='hidden' name='step_cd'>
<input type='hidden' name='main_row'>
<input type='hidden' name='sheet_arr_no'>
<input type='hidden' name='ofc_cty_cd'>
<input type='hidden' name='so_seq'>
<input type='hidden' name='curr_cd'>
<input type='hidden' name='cgo_tp_cd'>
<input type='hidden' name='multi_ofc_cty_cd'>
<input type='hidden' name='multi_so_seq'>
<input type='hidden' name='multi_cgo_tp_cd'>
<input type='hidden' name='check_row'>
<input type='hidden' name='agmt_flg'>
<input type='hidden' name='weightUnitParam'>
</FORM>

<form name='negoForm' method='POST'>
<input type='hidden' name='nego_amt'>
<input type='hidden' name='nego_row'>
<input type='hidden' name='nego_col'>
</form>




</body>
</html>

