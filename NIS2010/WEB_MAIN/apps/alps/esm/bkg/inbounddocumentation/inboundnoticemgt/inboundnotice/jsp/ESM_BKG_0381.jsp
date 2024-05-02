<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0381.jsp
	 *@FileTitle : Arrival Notice Send
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.03
	 *@LastModifier : 박성호
	 *@LastVersion : 1.0
	 * 2009.06.03 박성호
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0381Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0381Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_email = "";
	String strOfc_cd = "";
	String strCnt_cd = "";

	Logger log = Logger
			.getLogger("com.hanjin.apps.InboundBLMgt.ArrivalNotice");

	// 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (시작)
	String parAutoSearchFlg = JSPUtil.getParameter(request,			"autoSearchFlg");
	String parVvd = JSPUtil.getParameter(request, "vvd");
	String parVpsEtaDtStart = JSPUtil.getParameter(request,			"vps_eta_dt_start");
	String parVpsEtaDtEnd = JSPUtil.getParameter(request,			"vps_eta_dt_end");
	String parPodCd = JSPUtil.getParameter(request, "pod_cd");
	String parDelCd = JSPUtil.getParameter(request, "del_cd");
	String parPolCd = JSPUtil.getParameter(request, "pol_cd");
	String parBlNo = JSPUtil.getParameter(request, "bl_no");
	String parOfcCd = JSPUtil.getParameter(request, "ofc_cd");
	String parSchTp = JSPUtil.getParameter(request, "sch_tp");

	String parTsFlg = JSPUtil.getParameter(request, "ts_flg");
	String parCustCntCd = JSPUtil.getParameter(request, "cust_cnt_cd");
	String parCustSeq = JSPUtil.getParameter(request, "cust_seq");
	String parCustNm = JSPUtil.getParameter(request, "cust_nm");

	String parCustRefNo = JSPUtil.getParameter(request, "cust_ref_no");
	String parSNo = JSPUtil.getParameter(request, "s_no");
	String parCNo = JSPUtil.getParameter(request, "c_no");
	
	String parEvalFlg = JSPUtil.getParameter(request, "is_validated");


	// 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (끝)
	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_email = account.getUsr_eml();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

		event = (EsmBkg0381Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
        <title>Arrival Notice Send</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
        <script language="javascript">
            var strUsr_id    = "<%=strUsr_id%>";
            var strUsr_nm    = "<%=strUsr_nm%>";
            var strUsr_email = "<%=strUsr_email%>";
            var strOfc_cd    = "<%=strOfc_cd%>";
            var strCnt_cd    = "<%=strCnt_cd%>";


            // 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (시작)
            var parAutoSearchFlg = "<%=parAutoSearchFlg%>";
            var parVvd   = "<%=parVvd%>";
            var parVpsEtaDtStart = "<%=parVpsEtaDtStart%>";
            var parVpsEtaDtEnd = "<%=parVpsEtaDtEnd%>";
            var parPodCd = "<%=parPodCd%>";
            var parDelCd = "<%=parDelCd%>";
            var parPolCd = "<%=parPolCd%>";
            var parBlNo  = "<%=parBlNo%>";
            var parOfcCd = "<%=parOfcCd%>";
            var parSchTp = "<%=parSchTp %>";

            var parTsFlg = "<%=parTsFlg %>";
            var parCustCntCd = "<%=parCustCntCd %>";
            var parCustSeq = "<%=parCustSeq %>";
            var parCustNm = "<%=parCustNm %>";

            var parCustRefNo = "<%=parCustRefNo %>";
            var parSNo = "<%=parSNo %>";
            var parCNo = "<%=parCNo %>";
            
            var parEvalFlg = "<%=parEvalFlg %>";

            // 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (끝)

            function setupPage(){
                var errMessage = "<%=strErrMsg%>";
                if (errMessage.length >= 1) {
                    showErrMessage(errMessage);
                } // end if
                loadPage();

            }
        </script>
    </head>

    <body onLoad="setupPage();">
        <form name="form">
            <input name="f_cmd" type="hidden" />
            <input type="hidden" name="pagerows" value="<%=pageRows%>">
            <input type="hidden" name="keys" value="">

            <!-- 개발자 작업	-->

            <!-- RD 부분  -->
            <input type="hidden" name="com_mrdPath" value="">
            <input type="hidden" name="com_mrdArguments" value="">

            <input type="hidden" size="200" name="com_mrdSaveDialogDir" value="">
            <input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="">
            <input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="">
            <input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="">


            <input type="hidden" name="com_mrdTitle" value="">
            <input type="hidden" name="com_mrdDisableToolbar" value="">
            <input type="hidden" name="com_mrdBodyTitle" value="">

<!-- E-mail Edit start -->
			<input type="hidden" name="edt_ntc_knd_cd">
			<input type="hidden" name="edt_bkg_no_list">
			<input type="hidden" name="edt_to_eml">
			<input type="hidden" name="edt_cc_eml">
			<input type="hidden" name="edt_from_eml">
			<input type="hidden" name="edt_subject">
			<input type="hidden" name="edt_contents">
			<input type="hidden" name="com_fileKey"> 
<!-- E-mail Edit end -->


            <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

                        <table class="search">
                            <tr>
                                <td class="bg">
                                    <!--biz page (S)-->
                                    <!--  biz_1  (S) -->
                                    <table class="search" border="0" style="width: 979;">
                                        <tr class="h23">
                                            <td width="685">
                                                <table class="search_sm2" border="0" style="width: 685;">
                                                    <tr class="h23">
                                                        <td width="135"><input type="radio" value="V"
                                                                               class="trans" name="sch_tp">VVD&nbsp;<input
                                                                               type="text" style="width: 80;" class="input1" name="vvd"
                                                                               caption="VVD" value="" maxlength="9" size="9"
                                                                               style="ime-mode:disabled"
                                                                               onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                                                                               onFocus="form.sch_tp[0].checked=true;"></td>
                                                        <td width="75" nowrap><input type="radio" value="D"
                                                                                     name="sch_tp" class="trans" checked="true">POD ETA</td>
                                                        <td width="230"><input type="text" style="width: 75"
                                                                               dataformat="ymd" minlength="8" maxlength="8" value=""
                                                                               class="input1" caption="Duration Start Date"
                                                                               name="vps_eta_dt_start" style="width:100;ime-mode:disabled"
                                                                               onKeyPress="ComKeyOnlyNumber(this);"
                                                                               onFocus="form.sch_tp[1].checked=true;">&nbsp;&nbsp;~&nbsp;<input
                                                                               type="text" style="width: 75" dataformat="ymd" minlength="8"
                                                                               maxlength="8" value="" class="input1" name="vps_eta_dt_end"
                                                                               caption="Duration End Date" style="ime-mode:disabled"
                                                                               onKeyPress="ComKeyOnlyNumber(this);"
                                                                               onFocus="form.sch_tp[1].checked=true;">&nbsp;<img
                                                                               class="cursor" src="img/btns_calendar.gif" width="19"
                                                                               height="20" border="0" align="absmiddle" name="eta_dt_end" />
                                                        </td>
                                                        <td width="25">POD</td>
                                                        <td width="70"><input type="text" style="width: 50;"
                                                                              class="input1" value="" name="pod_cd" caption="POD"
                                                                              maxlength="5" style="ime-mode:disabled"
                                                                              onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                                                                              fullfill /></td>
                                                        <td width="70">T/S&nbsp;<input type="checkbox" value="Y" name="ts_flg" caption="T/S"/ class="trans"></td>
                                                        <td width="25">DEL</td>
                                                        <td width="70"><input type="text" style="width: 50;"
                                                                              class="input" value="" name="del_cd" caption="DEL"
                                                                              minlength="2" maxlength="5"
                                                                              style="ime-mode:disabled"
                                                                              onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
                                                    </tr>
                                                </table>
                                            </td>

                                            <td width="95">
                                                <table class="search" border="0" style="width: 100;">
                                                    <tr class="h23">
                                                        <td width="25">POL</td>
                                                        <td width="70"><input type="text" style="width: 60;"
                                                                              class="input" value="" name="pol_cd" caption="POL"
                                                                              minlength="5" maxlength="5" style="ime-mode:disabled"
                                                                              onKeyPress="ComKeyOnlyAlphabet('uppernum');" /></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td width="95">
                                                <table class="search_sm2" border="0" style="width: 95;">
                                                    <tr class="h23">
                                                        <td width="70" nowrap><input type="radio" value="B"
                                                                                     class="trans" name="sch_tp">B/L No.</td>
                                                        <td><input type="text" style="width: 95;" class="input1"
                                                                   value="" name="bl_no" caption="B/L No."
                                                                   maxlength="12" style="ime-mode:disabled"
                                                                   onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                                                                   onFocus="form.sch_tp[2].checked=true;"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="height_2"><tr><td></td></tr></table>
                                    <table class="search" border="0" style="width: 979;">
                                        <tr class="h23">

                                            <td width="55" nowrap>Evaluated</td>
                                            <td width="20">
                                                <select name="is_validated" style="width:50">
                                                    <option value="Y">Yes</option>
                                                    <option value="N">No</option>
                                                    <option value="">All</option>
                                                </select>
                                            </td>
                                            
							                 
							                 <td width="70" nowrap>&nbsp;&nbsp;&nbsp;FRT Term</td>
                                            <td width="20">
                                                <select name="frt_term_cd" style="width:70">
                                                    <option value="">All</option>
                                                    <option value="P">Prepaid</option>
                                                    <option value="C">Collect</option>
                                                </select>
                                            </td>

                                            <td width="110" >Cust Code</td>
                                            <td width="110"><input type="text" style="width: 30;"
                                                                   class="input" value="" name="cust_cnt_cd"
                                                                   caption="Customer Code" fullfill style="ime-mode:disabled"
                                                                   onKeyPress="ComKeyOnlyAlphabet('upper');"
                                                                   onKeyUp="fncNextFocusByMax(this,2,cust_seq);" size="2"
                                                                   maxlength="2" />&nbsp;<input type="text" style="width: 50;"
                                                                   class="input" value="" name="cust_seq" caption="Customer Code"
                                                                   maxlength="6" style="ime-mode:disabled"
                                                                   onKeyPress="ComKeyOnlyNumber(this);"
                                                                   onBlur="fncCustSeqBlur(this)" /></td>
                                            <td width="100" >Cust Name</td>
                                            <td width="185"><input type="text" style="width: 130;"
                                                                   class="input" name="cust_nm" value="" caption="Customer Name"
                                                                   maxlength="500" onKeyPress="ComKeyOnlyAlphabet('upper','32');" /></td>
                                            <td width="80" >P/O No.</td>
                                            <td width="110"><input type="text" style="width: 80;"
                                                                   class="input" value="" name="cust_ref_no" caption="P/O No."
                                                                   maxlength="500" style="ime-mode:disabled" /></td>
                                            <td width="80" id="search_sc_title">S/C No.</td>
                                            <td width="150" id="search_sc"><input type="text" style="width: 40;"
                                                                                  class="input" value="" name="s_no" caption="S/C No."
                                                                                  maxlength="3" style="ime-mode:disabled"
                                                                                  onKeyPress="ComKeyOnlyAlphabet('upper');"
                                                                                  onKeyUp="fncNextFocusByMax(this,3,c_no);">&nbsp;<input
                                                                                  type="text" style="width: 77;" class="input" value=""
                                                                                  name="c_no" caption="S/C No." maxlength="17"
                                                                                  style="ime-mode:disabled"
                                                                                  onKeyPress="ComKeyOnlyAlphabet('uppernum');" /></td>
                                        </tr>
                                    </table>
                                    
									<table class="height_2"><tr><td></td></tr></table>
                                    <table border="0">
                                        <tr class="h23">

                                            <td style='padding-right:5px'>A/N Sent Status</td>
                                            <td align="right" style='padding-right:20px'>
                                                <select name="an_snt_sts" style="width:50">
                                                    <option value="">All</option>
                                                    <option value="Y">Yes</option>
                                                    <option value="N">No</option>
                                                </select>
                                            </td>
                                            
                                            <td align="right" style='padding-right:5px'>Contact Info Available</td>
                                            <td align="right" style='padding-right:20px'>
                                                <select name="cntc_info_aval" style="width:50">
                                                    <option value="">All</option>
                                                    <option value="Y">Yes</option>
                                                    <option value="N">No</option>
                                                </select>
                                            </td>
							                 <td align="right" style='padding-right:20px'>Do not Send&nbsp;<input type="checkbox" value="Y" name="donot_snd_flg" caption="T/S"/ class="trans"></td>
							                 
							                 <% 
							                 
							                 //if("NYCNA".equals(strOfc_cd)){ // 2015.08.03 한진그룹 코드 표준화
							                 if("NYCRA".equals(strOfc_cd)){ 
							                 %>
							                 <td id="usca_part"><!-- login Ofc NYCNA 만 오픈   US/CA Part -->
				                                    <table border="0">
				                                        <tr class="h23">
				                                            <td style='padding-right:5px'>HUB</td>
				                                            <td align="right" style='padding-right:20px'>
				                                                <input type="text" name="hub_loc_cd" style="width:50; ime-mode: disabled" class="input" dataformat="eng" maxlength="5" fullfill caption="HUB">
				                                            </td>
				                                            
				                                            <td align="right" style='padding-right:5px'>Customs Loc</td>
				                                            <td align="right" style='padding-right:20px'>
				                                                <input type="text" name="cstms_loc_cd" style="width:50; ime-mode: disabled" class="input"	dataformat="eng" maxlength="5" fullfill caption="Customs HUB">
				                                            </td>
				                                            
				                                            <td align="right" style='padding-right:5px'>Entry Type</td>
				                                            <td align="right" style='padding-right:20px'>
				                                                <select name="entr_tp" style="width:60">
				                                                    <option value=""></option>
				                                                    <option value="L">Local</option>
				                                                    <option value="I">IT</option>
				                                                </select>
				                                            </td>
				                                        </tr>
				                                    </table><!-- US/CA Part end -->
							                 </td>
							                 <% 
							                 	} 
							                 %>
                                        </tr>
                                    </table>
                                    <!--  biz_1   (E) -->
                                </td>
                            </tr>
                        </table>
                        <table class="height_8"><tr><td></td></tr></table>
                        <!-- Tab (S) -->
                        <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%" >
                            <tr><td width="100%">
                                    <script language="javascript">ComTabObject('tab1')</script>
                                    <!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
                                </td></tr>
                        </table>
                        <!-- Tab (E) -->

                        <table class="search"><tr>
                                <td class="bg">



                                    <!--  Button_Sub (S) -->

                                    <table width="100%" class="button">
                                        <tr><td class="btn2_bg">
                                                <table border="0" cellpadding="0" cellspacing="0">
                                                    <tr>
                                                        <td  style="padding-right:5px">(1,5-10,15-20)
															<input type="text" style="width: 95;" class="input" value="" name="select_rows"  style="ime-mode:disabled" dataformat='num_select' >
															<!-- <script language="javascript">ComComboObject('cbo_select_rows', 1, 100, '');</script> -->
                                                        </td>
                                                        <td>
                                                            <table width="100%" border="0" cellpadding="0"
                                                                   cellspacing="0" class="button">
                                                                <tr>
                                                                    <td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_select_rows">Select Rows</td>
                                                                    <td class="btn2_right"></td>
                                                                </tr>
                                                            </table>
                                                        </td>                                                        
                                                        <td class="btn1_line"></td>
                                                        <td>
                                                            <table width="100%" border="0" cellpadding="0"
                                                                   cellspacing="0" class="button">
                                                                <tr>
                                                                    <td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_group_by_code">Grouping by
														Code</td>
                                                                    <td class="btn2_right"></td>
                                                                </tr>
                                                            </table>
                                                        </td>

                                                        <td>
                                                            <table width="100%" border="0" cellpadding="0"
                                                                   cellspacing="0" class="button">
                                                                <tr>
                                                                    <td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_group_sc">Grouping by S/C</td>
                                                                    <td class="btn2_right"></td>
                                                                </tr>
                                                            </table>
                                                        </td>

                                                        <td>
                                                            <table width="100%" border="0" cellpadding="0"
                                                                   cellspacing="0" class="button">
                                                                <tr>
                                                                    <td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_multi_contact">Multi-Contact</td>
                                                                    <td class="btn2_right"></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                        <!--
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
        <tr><td class="btn2_left"></td>
        <td class="btn2" name="">Charge Setup</td>
        <td class="btn2_right"></td>
						</tr>
						</table></td>
						 -->
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- Button_Sub (E) -->


                                    <!--Grid (s)-->
                                    <table width="100%" id="mainTable">
                                        <tr>
                                            <td width="100%"><script language="javascript">ComSheetObject('t1sheet1');</script>
                                            </td>
                                        </tr>
                                    </table>
                                    <!--Grid (E)-->

                                </td>
                            </tr>
                        </table>

                        <!-- Grid BG Box  (S) --> <!--biz page (E)--> <!--Button (S) -->
                        <table width="100%" class="button" border="0" cellpadding="0"
                               cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
                            <tr>
                                <td class="btn1_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                       class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>

                                            <td class="btn1_line"></td>

                                            <!--
<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
    <tr><td class="btn1_left"></td>
    <td class="btn1" name="btn_deselectall">Deselect All</td>
    <td class="btn1_right"></td>
					</tr>
				</table></td>

<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
    <tr><td class="btn1_left"></td>
    <td class="btn1" name="btn_selectall">Select All</td>
    <td class="btn1_right"></td>
					</tr>
				</table></td>
				 -->	<td>
                                                <table width="72" border="0" cellpadding="0" cellspacing="0"
                                                       class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_fax">Fax</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>

                                            <td>
                                                <table width="72" border="0" cellpadding="0" cellspacing="0"
                                                       class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_email">E-Mail</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            
                                            <td>
                                                <table width="110" border="0" cellpadding="0" cellspacing="0"
                                                       class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_email_edit">E-Mail(Edit)</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>

                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                       class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_downexcel">Down Excel</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>

                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                       class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_preview">Preview</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>

                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                       class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_Print">Print</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_template">Template</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table></td>
                                            <!--
                                            <td>
                                            <table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
                                                    <tr>
                                                            <td class="btn1_left"></td>
                                                            <td class="btn1" name="btn_preview_print">Preview Print</td>
                                                            <td class="btn1_right"></td>
											</tr>
										</table>
										</td>
                                            <td>
                                            <table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
                                                    <tr>
                                                            <td class="btn1_left"></td>
                                                            <td class="btn1" name="btn_preview_save">Preview Save</td>
                                                            <td class="btn1_right"></td>
											</tr>
										</table>
										</td>
										 -->
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                       class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_setup">A/N Setup</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                       class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_history">History</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
											
                                            <td style="display:none">
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                       class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_goto_invoice">Go to Invoice</td>
                                                        <td class="btn1_right"></td>
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

<!--biz page 2 (S)-->
<table border="0" width="100%" height="0" style="display:inline">
	<tr><td><script language='javascript'>comRdObject('csrPrevie');</script></td></tr>
</table>            
            
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>


        </form>
        <!--Button (E) -->
        <!-- 파일업로드 컴포넌트를 설치하도록 숨겨둠. -->
        <div style="display: none"><script language="javascript">ComUploadObject('upload1','obj',480,170);</script>
        </div>

    </body>
</html>


<!-- 개발자 작업  끝 -->
