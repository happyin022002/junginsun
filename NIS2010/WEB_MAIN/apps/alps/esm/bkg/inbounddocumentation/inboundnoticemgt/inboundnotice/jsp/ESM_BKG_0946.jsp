<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0946.jsp
	 *@FileTitle : Integrated Customer Data Management
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
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0946Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	EsmBkg0946Event event = null; //PDTO(Data Transfer Object including Parameters)
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

	Logger log = Logger
			.getLogger("com.hanjin.apps.InboundBLMgt.ArrivalNotice");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_email = account.getUsr_eml();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0946Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
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
        <title>Group A/N Merge Popup</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="javascript">
            var strUsr_id    = "<%=strUsr_id%>";
            var strUsr_nm    = "<%=strUsr_nm%>";
            var strUsr_email = "<%=strUsr_email%>";
            var strOfc_cd    = "<%=strOfc_cd%>";
            var strCustCntCd = "<%=JSPUtil.getNull(request.getParameter("cust_cnt_cd"))%>";
            var strCustSeq = "<%=JSPUtil.getNull(request.getParameter("cust_seq"))%>";
            var strCustNm = "<%=JSPUtil.getNull(request.getParameter("cust_nm")) %>";
            var strScNo = "<%=JSPUtil.getNull(request.getParameter("sc_no"))%>";
            var strGubun = "<%=JSPUtil.getNull(request.getParameter("gubun"))%>";
            var strVpsEtaDtStart = "<%=JSPUtil.getNull(request.getParameter("vps_eta_dt_start"))%>";
            var strVpsEtaDtEnd = "<%=JSPUtil.getNull(request.getParameter("vps_eta_dt_end"))%>";
            var strBkgNo = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>";

            var strRvisFlg = "<%=JSPUtil.getNull(request.getParameter("rvis_flg"))%>";

            var strFaxNo = "<%=JSPUtil.getNull(request.getParameter("fax_no"))%>";
            var strEmail = "<%=JSPUtil.getNull(request.getParameter("email"))%>";

            var strChgDpFlg = "<%=JSPUtil.getNull(request.getParameter("chg_dp_flg"))%>";


            function setupPage(){
                //var errMessage = "<%=strErrMsg%>";
                //if (errMessage.length >= 1) {
                //	showErrMessage(errMessage);
                //} // end if
                loadPage();
            }


        </script>
    </head>

    <body class="popup_bg" onLoad="setupPage();">
        <form name="form"><input name="f_cmd" type="hidden" />
            <input type="hidden" name="pagerows" value="<%=pageRows%>"/>
            <input type="hidden" name="bkg_no" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>"/>

                   <!-- opener 창에서 검색할 정보를 가져옴.-->
                   <input type="hidden" name="sch_tp" value=""></input>
            <input type="hidden" name="vvd" value=""></input>
            <input type="hidden" name="vps_eta_dt_start" value=""></input>
            <input type="hidden" name="vps_eta_dt_end" value=""></input>
            <input type="hidden" name="pod_cd" value=""></input>
            <input type="hidden" name="pol_cd" value=""></input>
            <input type="hidden" name="del_cd" value=""></input>
            <input type="hidden" name="bl_no" value=""></input>
            <input type="hidden" name="cust_ref_no" value=""></input>
            <input type="hidden" name="cust_nm" value=""></input>
            <input type="hidden" name="diff_rmk" value=""></input>
            <input type="hidden" name="rvis_flg" value=""></input>
            <input type="hidden" name="ts_flg" value=""></input>

            <!-- fax, mail 전송시 사용할 값들을 , 로 구분한 문자열로 가져옴. -->
            <input type="hidden" name="fax_no" value=""></input>
            <input type="hidden" name="email" value=""></input>

            <!-- RD 부분  -->
            <input type="hidden" name="com_mrdPath" value="">
            <input type="hidden" name="com_mrdArguments" value="">

            <input type="hidden" size="200" name="com_mrdSaveDialogDir" value="">
            <input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="">
            <input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="pdf">
            <input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="">

            <input type="hidden" name="com_mrdTitle" value="">
            <input type="hidden" name="com_mrdDisableToolbar" value="">
            <input type="hidden" name="com_mrdBodyTitle" value="">
            <input type="hidden" name="com_mrdPrintPaperSize" value="">
            
            <input type="hidden" size="200" name="com_zoomIn">



            <!-- 개발자 작업	-->



            <!-- OUTER - POPUP (S)tart -->
            <table width="100%" class="popup" cellpadding="10" border="0">
                <tr>
                    <td class="top"></td>
                </tr>
                <tr>
                    <td valign="top"><!-- : ( Title ) (S) -->
                        <table width="100%" border="0">
                            <tr>
                                <td class="title"><img src="img/icon_title_dot.gif"
                                                       align="absmiddle">&nbsp;Group A/N Merge Popup</td>
                            </tr>
                        </table>
                        <!-- : ( Title ) (E) --> <!-- : ( Search Options ) (S) -->

                        <table class="search">
                            <tr>
                                <td class="bg">

                                    <table class="search_sm2" border="0" style="width: 500;">
                                        <tr class="h23">
                                            <td width="125"><input type="radio" value="C" class="trans" name="gubun" disabled >&nbsp;Customer
						Code</td>
                                            <td width="123"><input type="text" style="width:30;" class="input2" readOnly value="" name="cust_cnt_cd" caption="Customer Code" fullfill style="ime-mode:disabled" onclick="form.gubun[0].checked=true;" onKeyPress="ComKeyOnlyAlphabet('upper');"  onKeyUp="fncNextFocusByMax(this,2,cust_seq);" size="2" maxlength="2" />&nbsp;<input type="text" style="width:50;" class="input2" value="" name="cust_seq" caption="Customer Code"  readOnly maxlength="6" style="ime-mode:disabled" onclick="form.gubun[0].checked=true;" onKeyPress="ComKeyOnlyNumber(this);" onBlur="fncCustSeqBlur(this)"/>
                                            </td>
                                            <td width="75"><input type="radio" value="S" class="trans" name="gubun" disabled >&nbsp;S/C
						No.</td>
                                            <td width=""><input type="text" style="width:72;" class="input2" readOnly  value="" name="sc_no" caption="S/C No." maxlength="17" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');"  onclick="form.gubun[1].checked=true;"/></td>
                                        </tr>
                                    </table>
                                    <table class="search" border="0">
                                        <tr class="h23">
                                            <td width="105">&nbsp;Customer Name</td>
                                            <td width=""><input type="text" style="width:380;" class="input2" name="cust_nm_view" value="" caption="Customer Name" maxlength="500"  readOnly/></td>
                                            <td align="right"><input type="radio" name="div_cd" value="C" class="trans" checked>Combine <input type="radio" name="div_cd" value="S" class="trans">Separate</td>
                                        </tr>
                                    </table>
                                    <!-- : ( Grid ) (S) -->
                                    <table width="100%" id="mainTable">
                                        <tr>
                                            <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
                                            </td>

                                        </tr>
                                    </table>
                                    
                                    
                                    <!-- : ( Grid ) (E) --> <!--  Button_Sub (S) -->
                                    <table width="100%" class="button">
                                        <tr>
                                            <td class="btn2_bg">
                                                <table border="0" cellpadding="0" cellspacing="0">
                                                    <tr>
                                                        <!--
                                                                <td>
                                                                <table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
                                                                        <tr>
                                                                                <td class="btn2_left"></td>
                                                                                <td class="btn2" name="">Check All</td>
                                                                                <td class="btn2_right"></td>
									</tr>
								</table>
								</td>
                                                                <td>
                                                                <table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
                                                                        <tr>
                                                                                <td class="btn2_left"></td>
                                                                                <td class="btn2" name="">Uncheck All</td>
                                                                                <td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							-->
                                                        <!--
                                                                <td>
                                                                <table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
                                                                        <tr>
                                                                                <td class="btn2_left"></td>
                                                                                <td class="btn2" name="btn_row_delete" id="btn_row_delete">Row Delete</td>
                                                                                <td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								-->
                                                        <td>
                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                                   class="button">
                                                                <tr>
                                                                    <td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_form_setup" id="btn_form_setup">Form Setup</td>
                                                                    <td class="btn2_right"></td>
                                                                </tr>
                                                            </table>
                                                        </td>

                                                        <td>
                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                                   class="button">
                                                                <tr>
                                                                    <td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_preview" id="btn_preview">Preview</td>
                                                                    <td class="btn2_right"></td>
                                                                </tr>
                                                            </table>
                                                        </td>
<!-- 
                                                        <td>
                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                                   class="button">
                                                                <tr>
                                                                    <td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_fax" id="bnt_fax">Fax</td>
                                                                    <td class="btn2_right"></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                        <td>
                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                                   class="button">
                                                                <tr>
                                                                    <td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_email" id="btn_email">E-mail
                                                                    </td>
                                                                    <td class="btn2_right"></td>
                                                                </tr>
                                                            </table>
                                                        </td>
-->                                                        
                                                        <!--
                                                        <td>
                                                        <table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
                                                                <tr>
                                                                        <td class="btn2_left"></td>
                                                                        <td class="btn2" name="btn_email_separate" id="btn_email_separate">E-mail
										(Separate)</td>
                                                                        <td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								 -->
                                                        <td>
                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                                   class="button">
                                                                <tr>
                                                                    <td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_down_excel" id="btn_down_excel">Down Excel</td>
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
                                    <table class="height_8"><tr><td></td></tr></table> 
                                <!-- Tab (S) -->
		                        <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%" >
		                            <tr><td width="100%">
		                                    <script language="javascript">ComTabObject('tab1')</script>
		                                    <!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
		                                </td></tr>
		                        </table>
		                        <!-- Tab (E) -->
		                          <table class="search">
                            <tr>
                                <td class="bg">
                                    <!--Grid (s)-->
                                    <table width="100%" id="mainTable1">
                                        <tr>
                                            <td width="100%"><script language="javascript">ComSheetObject('t1sheet1');</script>
                                            </td>
                                        </tr>
                                    </table>
                                    <!--Grid (E)-->
                                
                                <!--  Button_Sub (S) -->
                                    <table width="100%" class="button">
                                        <tr>
                                            <td class="btn2_bg">
                                                <table border="0" cellpadding="0" cellspacing="0">
                                                    <tr>
                                                        
                                                        <td>
                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                                   class="button">
                                                                <tr>
                                                                    <td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_fax" id="bnt_fax">Fax</td>
                                                                    <td class="btn2_right"></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                        <td>
                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                                                   class="button">
                                                                <tr>
                                                                    <td class="btn2_left"></td>
                                                                    <td class="btn2" name="btn_email" id="btn_email">E-mail
                                                                    </td>
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
                        <!-- : ( Search Options ) (E) -->
                         <table class="height_5">
                <tr>
                    <td></td>
                </tr>
            </table></td>
                </tr>
            </table>

           


            <!-- : ( Button : pop ) (S) -->
            <table width="100%" class="sbutton">
                <tr>
                    <td height="71" class="popup">

                        <table width="100%" class="button" border="0" cellpadding="0"
                               cellspacing="0" style="padding-top: 5; padding-bottom: 10;">
                            <tr>
                                <td class="btn3_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>

                                            <td>
                                                <table width="72" border="0" cellpadding="0" cellspacing="0"
                                                       class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_close">Close</td>
                                                        <td class="btn1_right">
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <!--Button (E) --></td>
                            </tr>
                        </table>
                        <!-- : ( Button : pop ) (E) --></td>
                </tr>
            </table>
            <!-- 개발자 작업  끝 --></form>
    </body>
</html>