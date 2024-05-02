<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1034.jsp
*@FileTitle : Pick-up Notice Template(Manual Send)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.06.24 박미옥
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1034Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.PickUpNoticeBC");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		

		event = (EsmBkg1034Event)request.getAttribute("Event");
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
<title>Pick-up Notice Template(Manual Send)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		with(document.form) {
            eval("ofc_cd").value        = "<%=strOfc_cd%>";
            
            resetFormData();
        }
        
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
<%-- Main & Popup 공통 삭제 처리 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr>
        <td valign="top">
            <!--Page Title, Historical (S)-->
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
                <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle" /><span id="navigation"></span></td></tr>
                <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" /><span id="title"></span></td></tr>
            </table>
            <!--Page Title, Historical (E)-->
--%>        
                            
            <!--biz page (S)-->
            <table class="search" id="mainTable"> 
                <tr>
                    <td class="bg">                        

                        <!--  biz_1 (S) -->
                        <table class="search" border="0" style="width:979;"> 
                            <tr class="h23">
                                <td width="100">Handling Office</td>
                                <td width="">
                                    <input type="text" style="width:60;ime-mode:disabled;" class="input1" name="ofc_cd" value="" 
                                           caption="Handling Office" maxlength="6" minlength="5" dataformat="" required="" />
                                </td>                                            
                            </tr>                                
                        </table>
                        <!--  biz_1   (E) -->           
                                
                                
                        <table class="line_bluedot"><tr><td></td></tr></table>
                                
                        <!-- Pickup Notice Setup(S) -->
                        <input type="hidden" name="frm_pkup_ntc_seq" />     
                        <input type="hidden" name="frm_pkup_ntc_snd_tp_cd" />
                        <input type="hidden" name="frm_ofc_cd" />
                        <input type="hidden" name="frm_del_cd" />
                        <input type="hidden" name="frm_auto_ntc_flg" />
                        <input type="hidden" name="frm_each_foc_ntc_flg" />
                        <input type="hidden" name="frm_trkr_ntc_flg" />
                        
                        <script language="javascript">ComSheetObject('sheet1');</script>
                        <!--  biz_2 (S) -->
                        <table border="0" style="width:979;"> 
                            <tr class="h23">
                                <td width="180">Enclose Original B/L Copy</td>
                                <td width="300" class="stm">
                                    <input type="radio" class="trans" name="frm_eclz_obl_cpy_flg" value="Y" />&nbsp;Yes&nbsp;&nbsp;
                                    <input type="radio" class="trans" name="frm_eclz_obl_cpy_flg" value="N" />&nbsp;No
                                </td>
                                                                    
                                <td width="180">F/O/C Clear Remark(s) Setup</td>
                                <td width="" class="stm">
                                    <input type="radio" class="trans" name="frm_foc_clr_rmk_stup_flg" value="Y" />&nbsp;Yes&nbsp;&nbsp;
                                    <input type="radio" class="trans" name="frm_foc_clr_rmk_stup_flg" value="N" />&nbsp;No
                                </td>
                            </tr>
                        </table>
                                
                        <table class="height_8"><tr><td></td></tr></table>
                        
                        <table class="grid2" border="0" style="width:979;"> 
                            <tr class="tr2_head">
                                <td width="100%" align="left"> &nbsp;Head Title</td>
                            </tr>
                            <tr>
                                <td>
                                    <textarea style="width:100%;height:36;ime-mode:disabled;" class="textarea1" rows="2" 
                                        caption="Head Title" maxLength="500" required="" name="frm_hd_tit_ctnt"></textarea>
                                </td> 
                            </tr>
                        </table>
                        <!--  biz_2  (E) -->    
                                        
                    </td>
                </tr>
            </table>      
            <table class="height_8"><tr><td></td></tr></table>
              
            <!-- Tab (S) -->
            <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
                <tr>
                    <td width="100%">
                        <script language="javascript">ComTabObject('tab1')</script>
                    </td>
                </tr>
            </table>
            <!-- Tab (E) -->
                
<!-- (TAB) Event#1 (S) -->
<div id="tabLayer" style="display:inline">
                
            <table class="search" id="mainTable"> 
                <tr>
                    <td class="bg">                             
                      
                        <!-- Grid_2 (S) -->
                        <input type="hidden" name="frm_t1_pkup_ntc_seq" />
                        <input type="hidden" name="frm_t1_pkup_ntc_fom_cd" />
                        <input type="hidden" name="frm_t1_eclz_obl_cpy_flg" />
                        <script language="javascript">ComSheetObject('t1sheet1');</script>
                        <table width="100%" class="grid2"> 
                            <tr class="tr2_head">
                                <td align="left">Bottom Remark(s)</td>
                            </tr>                                   
                            <tr>
                                <td>
                                    <textarea style="width:100%;height:245;ime-mode:disabled;" caption="Bottom Remark(Event#1)" rows="18"
                                        maxLength="3000" name="frm_t1_btm_rmk"></textarea>
                                </td>
                            </tr>   
                        </table> 
                        <!-- Grid_2 (E) -->             
                                              
                    </td>
                </tr>
            </table>
            <!--biz page (E)-->

</div>
<!-- (TAB) Event#1 (E) -->

                
<!-- (TAB) Event#2 (S) -->
<div id="tabLayer" style="display:none">

            <table class="search" id="mainTable"> 
                <tr>
                    <td class="bg">                             
                      
                        <!-- Grid_2 (S) -->
                        <input type="hidden" name="frm_t2_pkup_ntc_seq" />
                        <input type="hidden" name="frm_t2_pkup_ntc_fom_cd" />
                        <input type="hidden" name="frm_t2_eclz_obl_cpy_flg" />
                        <script language="javascript">ComSheetObject('t2sheet1');</script>
                        <table width="100%" class="grid2"> 
                            <tr class="tr2_head">
                                <td align="left">Bottom Remark(s)</td>
                            </tr>                                   
                            <tr>
                                <td>
                                    <textarea style="width:100%;height:245;ime-mode:disabled;" caption="Bottom Remark(Event#2)" rows="18" 
                                        maxLength="3000" name="frm_t2_btm_rmk"></textarea>
                                </td>
                            </tr>   
                        </table> 
                        <!-- Grid_2 (E) -->                                     
                      
                    </td>
                </tr>
            </table>
            <!--biz page (E)-->

</div>
<!-- (TAB) Event#2 (E) -->

<!-- (TAB) Event#3 (S) -->
<div id="tabLayer" style="display:none">

            <table class="search" id="mainTable"> 
                <tr>
                    <td class="bg">                             
                      
                        <!-- Grid_3 (S) -->
                        <input type="hidden" name="frm_t3_pkup_ntc_seq" />
                        <input type="hidden" name="frm_t3_pkup_ntc_fom_cd" />
                        <input type="hidden" name="frm_t3_eclz_obl_cpy_flg" />
                        <script language="javascript">ComSheetObject('t3sheet1');</script>
                        <table width="100%" class="grid2"> 
                            <tr class="tr2_head">
                                <td align="left">Bottom Remark(s)</td>
                            </tr>                                   
                            <tr>
                                <td>
                                    <textarea style="width:100%;height:245;ime-mode:disabled;" caption="Bottom Remark(Event#3)" rows="18" 
                                        maxLength="3000" name="frm_t3_btm_rmk" ></textarea>
                                </td>
                            </tr>   
                        </table> 
                        <!-- Grid_3 (E) -->                                     
                      
                    </td>
                </tr>
            </table>
            <!--biz page (E)-->
</div>
<!-- (TAB) Event#3 (E) -->

            <!--Button (S) -->
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
                <tr>
                    <td class="btn1_bg">
              
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Reset" id="btn_Reset">New</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td class="btn1_line"></td>
                                <td>
                                    <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Save" id="btn_Save">Save</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Delete" id="btn_Delete">Delete</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_PickupNotice">Pick-up Notice</td>
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
        
        </td>
    </tr>
</table>
        
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>        

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>