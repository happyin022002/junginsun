<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0411.jsp
*@FileTitle : Pick up Notice Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.06.12 박미옥
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0411Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0411Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.PickUpNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0411Event)request.getAttribute("Event");
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
<title>Pick up Notice Setup</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" />
<input type="hidden" name="pagerows" />
<!-- 개발자 작업	-->
<input type="hidden" name="ntc_snd_tp_cd" />
<input type="hidden" name="p_ofc_cd" value="<%=strOfc_cd%>" />

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
        
            <!-- Grid BG Box  (S) -->
        
            <table class="search"> 
                <tr>
                    <td class="bg">
                        <table class="search" border="0" style="width:979;"> 
                            <tr class="h23"><td width="52">EQ OFC</td>
                                <td width="130">
                                    <input type="text" style="width:60;ime-mode:disabled;" class="input1" name="ofc_cd" value="" 
                                           caption="EQ Office Code" maxlength="5" minlength="5" dataformat="" required="" fullfill="fullfill" />
                                </td>
                                <td width="30">DEL</td>
                                <td width="">
                                    <input type="text" style="width:60;ime-mode:disabled;" class="input1" name="del_cd" value="" 
                                           caption="DEL Code" maxlength="5" minlength="3" dataformat="" />&nbsp;
                                    <script language="javascript">ComComboObject("del_cd_list", 1, 75, 0, 1);</script>
                                </td>
                            </tr>
                        </table>
                        
                        <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                        <!-- Pickup Notice Setup(S) -->
                        <input type="hidden" name="frm_pkup_ntc_seq" />     
                        <input type="hidden" name="frm_pkup_ntc_snd_tp_cd" />
                        <input type="hidden" name="frm_ofc_cd" />
                        <input type="hidden" name="frm_del_cd" />
                        <input type="hidden" name="frm_eclz_obl_cpy_flg" />
                        <input type="hidden" name="frm_foc_clr_rmk_stup_flg" />
                        <script language="javascript">ComSheetObject('sheet1');</script>
                        <table class="search" border="0" style="width:979;"> 
                            <tr class="h23">
                                <td width="305">Freight/ B/Ls/ Customs Clear (FOC Clear)</td>
                                <td width="150">
                                    <select style="width:70;" class="input1" name="frm_auto_ntc_flg">
                                        <option value="Y">Auto</option>
                                        <option value="N">Manual</option>
                                    </select>&nbsp;
                                    <input type="text" style="width:60;" class="input2" value="Y/Y/Y" />
                                </td>
                                <td width="90">F/O/C Option</td>
                                <td width="200">
                                    <select style="width:180;" class="input1" name="frm_each_foc_ntc_flg">
                                        <option value="Y">Each Y Send(3times)</option>
                                        <option value="N">Only Y/Y/Y Send(1time)</option>
                                    </select>
                                </td>
                                <td width="155">Notice to a Door Trucker</td>
                                <td width="">
                                    <select style="width:60;" class="input1" name="frm_trkr_ntc_flg">
                                        <option value="N">No</option>
                                        <option value="Y">Yes</option>
                                    </select>
                                </td>
                            </tr>
                        </table>       
                        
                        <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                            <tr class="tr2_head">
                                <td width="100%" align="left"> &nbsp;Head Title</td>
                            </tr>
                            <tr>
                                <td CLASS="input1">
                                    <textarea style="width:100%;height:36;ime-mode:disabled;" class="textarea1" rows="2" 
                                        caption="Head Title" maxLength="500" required="" name="frm_hd_tit_ctnt"></textarea>
                                </td> 
                            </tr>
                        </table>
                        <!-- Pickup Notice Setup(E) -->
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

<!--TAB Pre-Arrival Notice (S) -->
<div id="tabLayer" style="display:inline">

            <table class="search"> 
                <tr>
                    <td class="bg">                        
                        <input type="hidden" name="frm_t1_pkup_ntc_seq" />
                        <input type="hidden" name="frm_t1_pkup_ntc_fom_cd" />
                        <script language="javascript">ComSheetObject('t1sheet1');</script>
                        <table border="0" style="width:100%;" class="search"> 
                            <tr class="h23">
                                <td width="780">
                                    <!--Grid (s)-->
                                    <table width="800" height="100"  id="mainTable">
                                        <tr>
                                            <td width="100%">
                                                <script language="javascript">ComSheetObject('t1sheet2');</script>
                                            </td>
                                        </tr>
                                    </table>
                                    <!--Grid (E)-->                                                                
                                </td>
                                <td width="20"></td>
                                <td width="" valign="top">Enclose B/L Copy 
                                    <select style="width:60;" class="input1" name="frm_t1_eclz_obl_cpy_flg">
                                        <option value="N">No</option>
                                        <option value="Y">Yes</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                                        
                        <table class="height_8"><tr><td></td></tr></table>
                        <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                            <tr class="tr2_head">
                                <td width="100%" align="left"> &nbsp;Bottom Remark(s)</td>
                            </tr>
                            <tr><td CLASS="input1"><textarea style="width:100%;height:205;ime-mode:disabled;" class="textarea1" rows="18"
                                caption="Bottom Remark(Pre-Arrival Notice)" maxLength="3000" name="frm_t1_btm_rmk"></textarea></td> 
                            </tr>
                        </table>                                
                    </td>
                </tr>
            </table>
            
            <!-- Grid BG Box  (S) -->
            <!--biz page (E)-->
</div>
<!--TAB Pre-Arrival Notice (E) -->


<!--TAB Arrival Notice (S) -->
<div id="tabLayer" style="display:inline">
            <table class="search"> 
                <tr>
                    <td class="bg">            
                        <input type="hidden" name="frm_t2_pkup_ntc_seq" />
                        <input type="hidden" name="frm_t2_pkup_ntc_fom_cd" />
                        <script language="javascript">ComSheetObject('t2sheet1');</script>
                        <table border="0" style="width:100%;" class="search"> 
                            <tr class="h23">
                                <td width="780">
                                    <!--Grid (s)-->
                                    <table width="800" height="100" id="mainTable">
                                        <tr>
                                            <td width="100%">
                                                <script language="javascript">ComSheetObject('t2sheet2');</script>
                                            </td>
                                        </tr>
                                    </table>
                                    <!--Grid (E)-->                                                                
                                </td>
                                <td width="20"></td>
                                <td width="" valign="top">Enclose B/L Copy 
                                    <select style="width:60;" class="input1" name="frm_t2_eclz_obl_cpy_flg">
                                        <option value="N">No</option>
                                        <option value="Y">Yes</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                                        
                        <table class="height_8"><tr><td></td></tr></table>
                        <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                            <tr class="tr2_head">
                                <td width="100%" align="left"> &nbsp;Bottom Remark(s)</td>
                            </tr>
                            <tr>
                                <td CLASS="input1"><textarea style="width:100%;height:205;ime-mode:disabled;" class="textarea1" rows="18" 
                                    caption="Bottom Remark(Arrival Notice)" maxLength="3000" name="frm_t2_btm_rmk"></textarea></td> 
                            </tr>
                        </table>                        
                    </td>
                </tr>
            </table>
</div>
<!--TAB Arrival Notice (E) -->
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
                                <td class="btn1_line"></td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr><td class="btn1_left"></td>
                                        <td class="btn1" name="btn_Copy" id="btn_Copy">Copy</td>
                                        <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Save" id="btn_Save">Save</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Delete" id="btn_Delete">Delete</td>
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