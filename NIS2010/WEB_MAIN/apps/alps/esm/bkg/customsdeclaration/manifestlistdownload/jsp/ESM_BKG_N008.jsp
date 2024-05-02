<%
/*=========================================================
 *Copyright(c) 2017 SMLines
 *@FileName : ESM_BKG_N008.jsp
 *@FileTitle : B/L Inquiry: C/M Information
 *Open Issues :
 *Change history :
 *@LastVersion : 1.0
 * 
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkgN008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkgN008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    
	String strCntCd			= "";
    String strBlNo          = "";
    String strBdrFlg		= "";
    String strVvd           = "";
    String strPod           = "";
    String strEta           = "";
    
    //String strPgmNo         = "";
    //String strOffice        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   	   
		event = (EsmBkgN008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strCntCd = JSPUtil.getNullNoTrim(request.getParameter("cnt_cd"));
		strBlNo  = JSPUtil.getNullNoTrim(request.getParameter("bl_no"));
		strBdrFlg = JSPUtil.getNullNoTrim(request.getParameter("trnk_bdr_flg"));
        strVvd = JSPUtil.getNullNoTrim(request.getParameter("vvd"));
        strPod = JSPUtil.getNullNoTrim(request.getParameter("pod_cd"));
        strEta = JSPUtil.getNullNoTrim(request.getParameter("vps_eta_dt2"));
        strEta = strEta.length() > 10 ? strEta.substring(0,10) : strEta;
        		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Inquiry: C/M Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="javascript:setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cntr_no">
<input type="hidden" name="tpsz_cd">
<input type="hidden" name="sheet_id">
<input type="hidden" name="cnt_cd" value="CA">
<input type="hidden" name="bdr_flg" value="<%=strBdrFlg%>">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;B/L Inquiry : C/M Information</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
        <table class="search"> 
        <tr><td class="bg">
            
            <table class="search" border="0" style="width:797;"> 
            <tr class="h23">
	            <td width="50">B/L No</td>
	            <td width="140"><input type="text" name="bl_no" style="width:100; ime-mode: disabled;" class="input1"
	               dataformat="eng" maxlength="12" required caption="B/L No." value="<%=strBlNo%>"></td>
	            <td width="60"><span id="mf_sts"></span></td>
	            <td width="120"><span id="cstms_clr_tp_cd"></span></td>
	            <td width="110">Freight : <span id="f_flg"></span></td>
	            <td width="100">O.B/L : <span id="o_flg"></span></td>
	            <td width="">Customs : <span id="c_flg"></span></td>
            </tr>
            </table>
            
            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
            
            <table class="search" border="0" style="width:797;"> 
            <tr class="h23">
	            <td width="25">VVD</td>
	            <td width="110"><input type="text" name="vvd" style="width:80; ime-mode:disabled;" readonly class="input2"
	               dataformat="eng" maxlength="9" fullfill caption="VVD" value="<%=strVvd%>"></td>
	            <td width="25">POD</td>
	            <td width="70"><input type="text" name="pod_cd" style="width:50; ime-mode:disabled;" readonly class="input2"
	               dataformat="eng" maxlength="5" fullfill caption="POD" value="<%=strPod%>"></td>
	            <td width="25">ETA</td>
	            <td width="110"><input type="text" name="vps_eta_dt" style="width:80; ime-mode:disabled;" readonly class="input2" value="<%=strEta%>"></td>
	            <td width="25">POL</td>
	            <td width="70"><input type="text" name="pol_cd" style="width:50; ime-mode:disabled;" readonly class="input2"
	               dataformat="eng" maxlength="5" fullfill caption="POL"></td>
	            <td width="35">DEL</td>
	            <td width="70"><input type="text" name="del_cd" style="width:50; ime-mode:disabled;" readonly class="input2"
	               dataformat="eng" maxlength="5" fullfill caption="DEL"></td>
	            <td width="40">L.USA</td>
	            <td width="70"><input type="text" name="usa_lst_loc_cd" style="width:50; ime-mode:disabled;" readonly class="input2"
	               dataformat="eng" maxlength="5" fullfill caption="L.USA"></td>
	            <td width="30">Stage</td>
	            <td width=""><input type="text" name="cstms_mf_tp_cd" style="width:30; ime-mode:disabled; text-indent:6" readonly class="input2"></td>
            </tr>
            <tr class="h23">
	            <td width="">Q'ty</td>
	            <td width=""><input type="text" name="pck_qty" style="width:38;ime-mode:disabled;text-align:right;" readonly class="input2" dataformat="int" maxlength="7" caption="Q'ty">
	               <input type="text" name="ams_pck_tp_cd" style="width:38; ime-mode:disabled; text-align:center;" readonly class="input2" dataformat="eng" maxlength="3" caption="Q'ty Code"></td>
	            <td width="">WGT</td>
	            <td width="" colspan="3"><input type="text" name="cgo_wgt" style="width:143; ime-mode: disabled;text-align:right" readonly class="input2" dataformat="float" maxlength="12" caption="WGT">
	               <input type="text" name="wgt_ut_cd" style="width:38; ime-mode:disabled; text-align:center;" readonly class="input2" dataformat="eng" maxlength="3" caption="WGT Code"></td>
	            <td width=""></td>
	            <td width=""></td>
	            <td width="">P/MIB No.</td>
	            <td width="" colspan="3"><input type="text" name="ibd_trsp_no" style="width:105; ime-mode:disabled;" readonly class="input2" dataformat="eng" maxlength="17" caption="P/MIB No."></td>
	            <td width="">Type</td>
	            <td width=""><input type="text" name="ibd_trsp_tp_cd" style="width:30; ime-mode:disabled; text-indent:6px" readonly class="input2" dataformat="eng" maxlength="17" caption="Type"></td>
            </tr>
            </table>
            <table class="height_8"><tr><td></td></tr></table>
    
                <table class="height_8"><tr><td></td></tr></table>
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>                
                <!-- : ( Grid ) (E) --> 
    
                <table class="height_8"><tr><td></td></tr></table>
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%" align="right"><span id="total_cnt" style="font-family:Tahoma; font-size:8pt;">[0 / 0]</span>&nbsp;</td>
                    </tr>
                    <tr><td height="1"></td></tr>
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>
                <!-- : ( Grid ) (E) --> 
                
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet3');</script>
                        </td>
                    </tr>
                </table>                
                <!-- : ( Grid ) (E) --> 
	            
	            <!--  Button_Sub (S) -->
	            <table width="100%" class="button"> 
	            <tr><td class="btn2_bg">
	                <table border="0" cellpadding="0" cellspacing="0"><tr>
	                        <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_add">Row Add</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_del">Row Delete</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                </tr></table>
	            </td></tr>
	            </table>
	            <!-- Button_Sub (E) -->
                
	            <table class="search" border="0" style="width:797;"> 
	            <tr class="h23">
	                <td width="70">Total PKG</td>
	                <td width="150"><input type="text" name="tot_pkg" style="width:100;text-align:right" readonly class="input2"></td>
	                <td width="70">Total WGT</td>
	                <td width=""><input type="text" name="tot_wgt" style="width:100;text-align:right" readonly class="input2"></td>
	            </tr>
	            </table> 
                
		</td></tr>
		</table> 
		<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_clm">CLM Inquiry</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
            </tr>
            </table>
            <!--Button (E) -->
	    </td></tr>
	    </table>
    
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
