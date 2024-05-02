<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0672.jsp
*@FileTitle : Arrival Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.06.03 박성호
* 1.0 Creation
* History
* 2010.09.09 이지영 [CHM-201005825-01] [ESM-BKG] A/N Setting Screen_Arrival Data
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0672Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0672Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_email	    = "";
	String strOfc_cd    = "";

	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.ArrivalNotice");

	// 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (시작)
	String parAutoSearchFlg = JSPUtil.getParameter(request, "autoSearchFlg");
	String parVvd = JSPUtil.getParameter(request, "vvd");
	String parVpsEtaDtStart = JSPUtil.getParameter(request, "vps_eta_dt_start");
	String parVpsEtaDtEnd = JSPUtil.getParameter(request, "vps_eta_dt_end");
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

	String parPgmNo = JSPUtil.getParameter(request, "pgmNo");

	// 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (끝)

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strUsr_email = account.getUsr_eml();
	    strOfc_cd = account.getOfc_cd();


		event = (EsmBkg0672Event)request.getAttribute("Event");
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
        <title>Arrival Information</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="javascript">
            var strUsr_nm    = "<%=strUsr_nm %>";
            var strUsr_email = "<%=strUsr_email %>";
            var strOfc_cd    = "<%=strOfc_cd %>";


            // 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (시작)
            var parAutoSearchFlg = "<%=parAutoSearchFlg%>";
            var parVvd   = "<%=parVvd%>";
            var parVpsEtaDtStart = "<%=parVpsEtaDtStart %>";
            var parVpsEtaDtEnd = "<%=parVpsEtaDtEnd %>";
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
			var parCustRefNo = "<%=parCustRefNo%>";
			var parSNo = "<%=parSNo%>";
			var parCNo = "<%=parCNo%>";

            var parEvalFlg = "<%=parEvalFlg %>";

            var parPgmNo = "<%=parPgmNo%>";

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

    <body  onLoad="setupPage();">
        <form name="form">
            <input name="f_cmd" type="hidden" />
            <input type="hidden" name="pagerows" value="<%=pageRows %>">
            <!-- 0243에서 가져갈 vvd -->
            <input type="hidden" name="vvd0243list" value="">


            <!-- 개발자 작업	-->

            <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>



                        <!--biz page (S)-->
                        <table class="search" id="mainTable"> 
                            <tr><td class="bg">

                                    <!--  biz_1  (S) -->
                                    <table class="search" border="0" style="width:979;"> 
                                        <tr class="h23">
                                            <td width="685">
                                                <table class="search_sm2" border="0" style="width:675;">
                                                    <tr class="h23">
                                                        <td width="135"><input type="radio" value="V" class="trans" name="sch_tp"  checked>VVD&nbsp;<input type="text" style="width:80;" class="input1" name="vvd" caption="VVD"  value="" maxlength="9" size="9" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
                                                        <td width="75" nowrap><input type="radio" value="D" name="sch_tp" class="trans">POD ETA</td>
                                                        <td width="230">
                                                            <input type="text" style="width:75" dataformat="ymd" minlength="8" maxlength="8" value="" class="input1" caption="Duration Start Date" name="vps_eta_dt_start" style="width:100;ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(this);" >&nbsp;&nbsp;~&nbsp;<input type="text" style="width:75" dataformat="ymd" minlength="8" maxlength="8" value="" class="input1" name="vps_eta_dt_end" caption="Duration End Date" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(this);" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="eta_dt_end" />
                                                        </td>
                                                        <td width="25">POD</td>
                                                        <td width="70"><input type="text" style="width:50;" class="input1" value="" name="pod_cd" caption="POD" maxlength="5" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');" fullfill /></td>
                                                        <td width="75">T/S<input type="checkbox" value="Y" name="ts_flg" caption="T/S" class="trans"></td>
                                                        <td width="25">DEL</td>
                                                        <td width=""><input type="text" style="width:50;" class="input" value="" name="del_cd" caption="DEL" minlength="2" maxlength="5" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');"  ></td>
                                                    </tr>
                                                </table>
                                            </td>

                                            <td width="95">
                                                <table class="search" border="0" style="width:90;">
                                                    <tr class="h23">
                                                        <td width="25">POL</td>
                                                        <td width=""><input type="text" style="width:50;" class="input" value="" name="pol_cd" caption="POL" minlength="5" maxlength="5" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');" /></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td width="">
                                                <table class="search_sm2" border="0" style="width:100%;">
                                                    <tr class="h23">
                                                        <td width="95"><input type="radio" value="B" class="trans" name="sch_tp" >B/L No.</td>
                                                        <td><input type="text" style="width:100;" class="input1" value="" name="bl_no" caption="B/L No." maxlength="12" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');" ></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <table class="height_2"><tr><td></td></tr></table>
                                    <table class="search" border="0" style="width:979;"> 
                                        <tr class="h23">
                                            <td width="55" nowrap>Evaluated</td>
                                            <td width="">
                                                <select name="is_validated" class="input1">
                                                    <option value="">All</option>
                                                    <option value="Y">Yes</option>
                                                    <option value="N">No</option>
                                                </select>
                                            </td>
                                            
                                             
							                 <td width="70" nowrap>&nbsp;&nbsp;&nbsp;FRT Term</td>
                                            <td width="20">
                                                <select name="frt_term_cd" style="width:60">
                                                    <option value="">All</option>
                                                    <option value="P">Prepaid</option>
                                                    <option value="C">Collect</option>
                                                </select>
                                            </td>
                                            
                                            <td width="100" nowrap>&nbsp;Customer Code</td>
                                            <td width="123"><input type="text" style="width:30;" class="input" value="" name="cust_cnt_cd" caption="Customer Code" fullfill style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper');"  onKeyUp="fncNextFocusByMax(this,2,cust_seq);" size="2" maxlength="2" />&nbsp;<input type="text" style="width:50;" class="input" value="" name="cust_seq" caption="Customer Code" maxlength="6" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(this);" onBlur="fncCustSeqBlur(this)"/>
                                            </td>
                                            <td width="100" nowrap>Customer Name</td>
                                            <td width="200"><input type="text" style="width:150;" class="input" name="cust_nm" value="" caption="Customer Name" maxlength="500"  onKeyPress="ComKeyOnlyAlphabet('upper','32');"/></td>
                                            <td width="50" nowrap>P/O No.</td>
                                            <td width="110"><input type="text" style="width:80;" class="input" value="" name="cust_ref_no" caption="P/O No." maxlength="500" style="ime-mode:disabled" /></td>
                                            <td width="55" nowrap>S/C No.</td>
                                            <td width=""><input type="text" style="width:40;" class="input" value="" name="s_no" caption="S/C No." maxlength="3" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper');" onKeyUp="fncNextFocusByMax(this,3,c_no);">&nbsp;<input type="text" style="width:72;" class="input" value="" name="c_no" caption="S/C No." maxlength="6" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');" />
                                            </td>

                                        </tr>
                                    </table>	
                                    <!--  biz_1   (E) -->

                                </td></tr></table>
                        <table class="height_8"><tr><td></td></tr></table>	

                        <!-- Tab (S) -->
                        <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%" > 
                            <tr><td width="100%">
                                    <script language="javascript">ComTabObject('tab1')</script>
                                    <!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
                                </td></tr>
                        </table>
                        <!-- Tab (E) -->


                        <!------------------------------------------------------------------------->
                        <!--TAB Arrival Data (S) -->
                        <!------------------------------------------------------------------------->
                        <div id="tabLayer" style="display:inline">

                            <!-- Grid BG Box  (S) -->
                            <table class="search" id="mainTable">
                                <tr><td class="bg">

                                        <!-- Grid  (S) -->

                                        <table width="100%" class="search"  id="mainTable"> 
                                            <tr>
                                                <td width="100%">
                                                    <script language="javascript">ComSheetObject('t2sheet1');</script>
                                                </td>
                                            </tr>
                                        </table> 
                                        <!-- Grid (E) -->
                                        <!--  Button_Sub (S) -->
                                        <table width="100%" class="button"> 
                                            <tr><td class="btn2_bg">
                                                    <table border="0" cellpadding="0" cellspacing="0"><tr>
                                                            <!-- 
                                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                            <tr><td class="btn2_left"></td>
                                                            <td class="btn2" name="btn_t2selectAll">Select&nbsp;All</td>
                                                            <td class="btn2_right"></td>
						</tr>
						</table></td>
                                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                            <tr><td class="btn2_left"></td>
                                                            <td class="btn2" name="btn_t2deSelectAll">Deselect&nbsp;All</td>
                                                            <td class="btn2_right"></td>
						</tr>
						</table></td>
						-->
                                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                        <td class="btn2" name="btn_t2set">Set&nbsp;Data</td>
                                                                        <td class="btn2_right"></td>
                                                                    </tr>
                                                                </table></td>
                                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                        <td class="btn2" name="btn_t2cus">Customer&nbsp;Info.</td>
                                                                        <td class="btn2_right"></td>
                                                                    </tr>
                                                                </table></td>

                                                            <!-- 
                                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                            <tr><td class="btn2_left"></td>
                                                            <td class="btn2" name="btn_t2rtn"><a href="javascript:ComOpenWindow2('http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/bkg/jsp/UI_BKG_0052.jspl','p','scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=522,height=422,left=0,top=0');">MRN RTN Yard Setup</a></td>
                                                            <td class="btn2_right"></td>
						</tr>
						</table></td>
						 -->

                                                        </tr></table>
                                                </td></tr>
                                        </table>
                                        <!-- Button_Sub (E) -->	

                                    </td></tr>
                            </table>
                            <!-- Grid BG Box  (S) -->

                        </div>

                        <!--TAB Arrival Data (E) -->

                        <!------------------------------------------------------------------------->
                        <!--TAB Customer (S) -->
                        <!------------------------------------------------------------------------->
                        <div id="tabLayer" style="display:none">


                            <!-- Grid BG Box  (S) -->
                            <table class="search" id="mainTable">
                                <tr><td class="bg">

                                        <!-- Grid  (S) -->

                                        <table width="100%" class="search"  id="mainTable"> 
                                            <tr>
                                                <td width="100%">
                                                    <script language="javascript">ComSheetObject('t3sheet1');</script>
                                                </td>
                                            </tr>
                                        </table> 

                                        <!-- Grid (E) -->
                                        <!--  Button_Sub (S) -->
                                        <table width="100%" class="button"> 
                                            <tr><td class="btn2_bg">
                                                    <table border="0" cellpadding="0" cellspacing="0"><tr>
                                                            <!-- 
                                                                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_t3select">Select&nbsp;All</td>
                                                                    <td class="btn2_right"></td>
						</tr>
						</table></td>
					 -->
                                                            <!--
                                                                   <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                   <tr><td class="btn2_left"></td>
                                                                   <td class="btn2" name="btn_t3deselect">Deselect&nbsp;All</td>
                                                                   <td class="btn2_right"></td>
						</tr>
						</table></td>
					-->						
                                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                        <td class="btn2" name="btn_t3cust">Customer&nbsp;Info.</td>
                                                                        <td class="btn2_right"></td>
                                                                    </tr>
                                                                </table></td>

                                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                        <td class="btn2" name="btn_t3multi_contact">Multi-Contact</td>
                                                                        <td class="btn2_right"></td>
                                                                    </tr>
                                                                </table></td>

                                                            <!-- 
                                                                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_t3set">Set&nbsp;Data</td>
                                                                    <td class="btn2_right"></td>
						</tr>
						</table></td>
					 -->
                                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                        <td class="btn2" name="btn_t3master">Master&nbsp;Data</td>
                                                                        <td class="btn2_right"></td>
                                                                    </tr>
                                                                </table></td>
                                                        </tr></table>
                                                </td></tr>
                                        </table>
                                        <!-- Button_Sub (E) -->	

                                    </td></tr>
                            </table>
                            <!-- Grid BG Box  (S) -->



                        </div>

                        <!--TAB Customer (E) -->


                        <!--TAB Upload & Match (S) -->

                        <div id="tabLayer" style="display:none">


                            <!-- Grid BG Box  (S) -->
                            <table class="search" id="mainTable">
                                <tr><td class="bg">

                                        <!-- Grid  (S) -->

                                        <table width="100%" class="search"  id="mainTable"> 
                                            <tr>
                                                <td width="100%">
                                                    <script language="javascript">ComSheetObject('t4sheet1');</script>							
                                                </td>
                                            </tr>
                                        </table> 
                                        <table width="100%" class="search"  id="mainTable" style="display:none"> 
                                            <tr>
                                                <td width="100%">
                                                    <script language="javascript">ComSheetObject('t4sheet2');</script>
                                                </td>
                                            </tr>
                                        </table> 
                                        <!-- Grid (E) -->
                                        <!--  Button_Sub (S) -->
                                        <table width="100%" class="button"> 
                                            <tr><td class="btn2_bg">
                                                    <table border="0" cellpadding="0" cellspacing="0"><tr>
                                                            <!-- 
                                                                            <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                            <tr><td class="btn2_left"></td>
                                                                            <td class="btn2" name="btn_t4new">New</td>
                                                                            <td class="btn2_right"></td>
						</tr>
						</table></td>
                                                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                            <tr><td class="btn2_left"></td>
                                                                            <td class="btn2" name="btn_t4selectAll">Select&nbsp;All</td>
                                                                            <td class="btn2_right"></td>
						</tr>
						</table></td>
                                                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                            <tr><td class="btn2_left"></td>
                                                                            <td class="btn2" name="btn_t4deselectAll">Deselect&nbsp;All</td>
                                                                            <td class="btn2_right"></td>
						</tr>
						</table></td>
					 -->
                                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                        <td class="btn2" name="btn_t4downExcel">Down&nbsp;Excel</td>
                                                                        <td class="btn2_right"></td>
                                                                    </tr>
                                                                </table></td>
                                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                        <td class="btn2" name="btn_t4uploadExcel">Upload&nbsp;Excel</td>
                                                                        <td class="btn2_right"></td>
                                                                    </tr>
                                                                </table></td>
                                                            <!--						
                                                                    <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_t4match">Match</td>
                                                                    <td class="btn2_right"></td>
						</tr>
						</table></td>
                                                                    <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_t4set">Set</td>
                                                                    <td class="btn2_right"></td>
						</tr>
						</table></td>
                                                                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_t4master">Master&nbsp;Data</td>
                                                                    <td class="btn2_right"></td>
						</tr>
						</table>
				       </td>
				       -->
                                                        </tr></table>
                                                </td></tr>
                                        </table>
<script language="javascript">ComSheetObject('t1sheet3');</script>
<script language="javascript">ComSheetObject('t1sheet4');</script>
<input type="hidden" name="an_seq" value="" />
<input type="hidden" name="strUsr_nm" value="" />
<input type="hidden" name="strUsr_email" value="" />
<input type="hidden" name="strOfc_cd" value="" />
<input type="hidden" name="gw_subject" value="Customer Code Request">
<input type="hidden" name="gw_contents" valule="" >
<input type="hidden" name="gw_template" value="template.htmlmail">
<input type="hidden" name="gw_args" value="name;" />
<input type="hidden" name="gw_args" value="" />
                                        <!-- Button_Sub (E) -->	
                                    </td></tr>
                            </table>
                            <!-- Grid BG Box  (S) -->
                        </div>

                        <!--TAB Upload & Match (E) -->



                        <!--Button (S) -->
                        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:0;"> 
                            <tr><td class="btn1_bg">

                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_Retrieve" id="btn_Retrieve" >Retrieve</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table></td>

                                            <td class="btn1_line"></td>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_DownExcel">Down Excel</td>
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
                                                        <td class="btn1" name="btn_code_validate">Code Validate</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table></td>


                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_template">Template</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table></td>

                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_ANSend">A/N Send</td>
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
            
            <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
            <!-- 개발자 작업  끝 -->
        </form>
    </body>
</html>