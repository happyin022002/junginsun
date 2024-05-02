<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0007.jsp
     *@FileTitle : [CPS_GEM-0007] Expense Code Maintenance
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@page import="com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0007Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem0007Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.hanjin.apps.GEMCommon.GEMMasterCodeMgt");

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (CpsGem0007Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
%>


<%@page import="java.util.Date"%><html>
<head>
<title>Expense Code Maintenance</title>
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

<body onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<!-- 개발자 작업 -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
   
    
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
    <!--Page Title, Historical (E)-->
    
    
    <!--biz page (S)-->
        <table class="search"> 
        <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="90">Expense Code</td>
                    <td width="400"><input type="text" style="width:60;ime-mode:disabled" maxlength="6" fullfill required caption="Expense Code" name="gen_expn_cd" class="input1" onkeyup="gen_expn_cd_on_keyup()"></td> 
                    <td width="180">
                        <table class="search_sm2" border="0" style="width:90%;"> 
                            <tr class="h23">
                                <td>&nbsp;Delete</td>
                                <td class="stm"><input type="radio" name="delt_flg" value="N" class="trans" checked>No&nbsp;&nbsp;&nbsp;<input type="radio" name="delt_flg" value="Y" class="trans">Yes</td>
                            </tr>
                        </table> 
                    </td>
                    <td width="50">Creator</td>
                    <td width="80"><input type="text" style="width:70;text-align: center" name="cre_usr_id" readonly="readonly" class="input2" value="<%=strUsr_id%>"></td> 
                    <td width="90">Creation Date</td>
                    <td width=""><input type="text" style="width:90;text-align: center;" name="cre_dt" readonly="readonly" class="input2" value="<%=DateTime.getFormatDate(new Date(),"yyyy-MM-dd")%>"></td> 
                </tr>
                </table> 
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="120">Full Name (ENG)</td>
                    <td width="375"><input type="text" style="width:350;ime-mode:disabled" class="input" maxlength="100" name="eng_full_nm"  dataformat="eng" value=""></td> 
                    <td width="120">Full Name (KOR)</td>
                    <td width=""><input type="text" style="width:365;" class="input" maxlength="100" name="krn_full_nm" value=""></td> 
                </tr>
                <tr class="h23">
                    <td width="">Abbreviation (ENG)</td>
                    <td width=""><input type="text" style="width:350;ime-mode:disabled" class="input1" required maxlength="50" name="eng_abbr_nm" dataformat="eng" value=""></td> 
                    <td width="">Abbreviation (KOR)</td>
                    <td width=""><input type="text" style="width:365;" class="input1" required maxlength="50" name="krn_abbr_nm" value=""></td> 
                </tr>
                </table> 
                    
                <!--  biz_1   (E) -->
                
                <table class="height_10"><tr><td></td></tr></table>
                
                <table class="search" border="0" style="width:100%">
                <tr class="h23">
                    <td class="title_h"></td>
                    <td class="title_s" width="800">Account Information</td>
                    <td width="130">Deleted Data<input type="checkbox" value="Y" name="acct_mtx_delt_flg" class="trans"></td>
                    <td align="right"><table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_Minimize1" id="btn_Minimize1">Minimize</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </tr>
                </table>
    
    
            <!-- Grid  (S) -->
            <div id="sheet1Div">
            <table width="100%" id="mainTable"> 
                <tr>
                    <td width="100%">                    
                        <script language="javascript">ComSheetObject('sheet1');</script>                    
                    </td>
                </tr>
            </table>
            
            <!-- Grid (E) -->
            <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0"><tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_RowAdd1">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_Delete1">Row&nbsp;Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                    </tr></table>
            </td></tr>
            </table>
            </div>
            <!-- Button_Sub (E) -->
            
                <!-- biz_1  (E) -->
            </td></tr>
        </table>
        <table class="height_8"><tr><td></td></tr></table>
        <table class="search"> 
        <tr><td class="bg">
            
                
            <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Code Matching</td>
                </tr>
            </table>
            <!--  biz_2  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="230">
                        <table class="search_sm2" border="0" style="width:90%;"> 
                            <tr class="h23">
                                <td>&nbsp;Initial Setting</td>
                                <td class="stm"><input type="radio" name="gen_expn_agre_flg" value="N" class="trans" checked>No&nbsp;&nbsp;&nbsp;<input name="gen_expn_agre_flg" type="radio" value="Y" class="trans">Yes</td>
                            </tr>
                        </table> 
                    </td>
                    <td width="230">
                        <table class="search_sm2" border="0" style="width:90%;"> 
                            <tr class="h23">
                                <td>&nbsp;Salary  DIV</td>
                                <td class="stm"><input type="radio" name="saly_flg" value="N" class="trans" checked>No&nbsp;&nbsp;&nbsp;<input type="radio" name="saly_flg" value="Y" class="trans">Yes</td>
                            </tr>
                        </table> 
                    </td>
                    <td width="250">
                        <table class="search_sm2" border="0" style="width:90%;"> 
                            <tr class="h23">
                                <td>&nbsp;Sales  DIV</td>
                                <td class="stm"><input type="radio" name="gen_expn_sls_div_cd" value="C" class="trans" checked>Com &nbsp;&nbsp;&nbsp;<input type="radio" name="gen_expn_sls_div_cd" value="N" class="trans">No&nbsp;&nbsp;&nbsp;<input type="radio" name="gen_expn_sls_div_cd" value="Y" class="trans">Yes</td>
                            </tr>
                        </table> 
                    </td>
                    <td align="right">TIC&nbsp;
                    <select style="width:76;" class="input" name="tic_cd">
                        <option value="" selected></option>                        
                     </select></td>
                </tr>
                </table>    
                
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
                
                <table class="search_sm2" border="0" style="width:380;"> 
                    <tr class="h23">
                        <td>&nbsp;Group Level</td>
                        <td class="stm"><input type="radio" name="gen_expn_grp_lvl" value="1" class="trans" >1st&nbsp;&nbsp;&nbsp;<input type="radio" name="gen_expn_grp_lvl" value="2" class="trans">2nd&nbsp;&nbsp;&nbsp;<input type="radio" name="gen_expn_grp_lvl" value="3" class="trans">3rd&nbsp;&nbsp;&nbsp;<input type="radio" name="gen_expn_grp_lvl" value="4" class="trans" checked>Final</td>
                    </tr>
                </table>    
                
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="60">&nbsp;&nbsp;Parent</td>
                    <td width=""><script language="javascript">ComComboObject("combo1", 3, 70, 1);</script>
                    <input type="hidden" name="prnt_gen_expn_cd">&nbsp;<input type="text" style="width:200;" class="input2" name="prnt_krn_abbr_nm" value="">&nbsp;<input type="text" style="width:500;" class="input2" name="prnt_eng_abbr_nm" value=""></td>
                </tr>
                </table>    
                
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
                <table class="search" border="0" style="width:100%;"> 
                <tr class="h23">
                    <td width="800">
                        <table class="search_sm2" border="0" style="width:230;"> 
                            <tr class="h23">
                                <td>&nbsp;Divided by Office</td>
                                <td class="stm"><input type="radio"  checked name="gen_expn_acct_expt_flg" value="N" class="trans" checked>No&nbsp;&nbsp;&nbsp;<input type="radio" name="gen_expn_acct_expt_flg" value="Y" class="trans">Yes</td>
                            </tr>
                        </table> 
                    </td>
                    <td width="130">Deleted Data<input type="checkbox" value="Y" class="trans" name="acct_expt_delt_flg"></td>
                    <td align="right"><table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_Minimize2" id="btn_Minimize2">Minimize</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </tr>
            </table>    
            <!-- Grid  (S) -->
            <div id="sheet2Div">
            <table width="100%" id="mainTable"> 
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet2');</script>
                    </td>
                </tr>
            </table>
            
            <!-- Grid (E) -->
            <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0"><tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_RowAdd2">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_Delete2">Row&nbsp;Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                    </tr></table>
            </td></tr>
            </table>
            </div>
            <!-- Button_Sub (E) -->
                    
            <!--  biz_2   (E) -->
            
            
            
            
            
            </td></tr>
        </table>
    <!-- Grid BG Box  (S) -->
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
    <!--biz page (E)-->
    
    </td></tr>
    </table>
    




 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>