<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2022.jsp
 *@FileTitle : RFA Proposal Creation - Rate (Commodity Note)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.24
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.24 박성수
 * 1.0 Creation
 =========================================================
 * History
 * 2014.03.31 서미진 [CHM-201429599] RFA Conversion 상 S/I Column 추가
 * [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
 =========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2022Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri2022Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";

	String[] rtApplTpCd = null;		    //APLICATION
	String[] bkgPrcCgoTpCd = null;    	//CARGO TYPE
	String[] rtOpCd = null;    			//CAL.
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgHngrBarTpCd = null;    	//BAR TYPE
	String[] bkgRatUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	String[] ruleCd = null;				//NOTE CONVERSION RULE CODE 
	String[] chargeCd = null;    		//SCOPE CHARGE CODE LIST
	String[] bkgEsvcTpCd = null;		//S/I

	String beforeExpDt = null;    	//MAIN-BEFORE_EXP_DT
				
    Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFARateProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session
                .getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2022Event) request.getAttribute("Event");
        serverException = (Exception) request
                .getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
        rtApplTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
        bkgPrcCgoTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_PRC_CGO_TP_CD"), false);       
        rtOpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_OP_CD"));      
        payTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);      
        bkgHngrBarTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_HNGR_BAR_TP_CD"), false);       
        bkgRatUtCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RAT_UT_CD"), false);      
        currCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);       
        ruleCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_CD"));       
        chargeCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHARGE_CD"));
        bkgEsvcTpCd     = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_ESVC_TP_CD"), false);    
        beforeExpDt		= (String)eventResponse.getCustomData("BEFORE_EXP_DT");
        
    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>RFA Proposal Creation - Rate (Commodity Note)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var rtApplTpCdComboValue = " |<%=rtApplTpCd[0]%>";
    var rtApplTpCdComboText = " |<%=rtApplTpCd[1]%>";

    var bkgPrcCgoTpCdComboValue = " |<%=bkgPrcCgoTpCd[0]%>";
    var bkgPrcCgoTpCdComboText = " |<%=bkgPrcCgoTpCd[1]%>";
        
    var rtOpCdComboValue = "<%=rtOpCd[0]%>";   
    var rtOpCdComboText = "<%=rtOpCd[1]%>";

    var payTermCdComboValue = " |<%=payTermCd[0]%>";   
    var payTermCdComboText = " |<%=payTermCd[1]%>";
    
    var bkgHngrBarTpCdComboValue = " |<%=bkgHngrBarTpCd[0]%>";   
    var bkgHngrBarTpCdComboText = " |<%=bkgHngrBarTpCd[1]%>";
    
    var bkgRatUtCdComboValue = " |<%=bkgRatUtCd[0]%>";   
    var bkgRatUtCdComboText = " |<%=bkgRatUtCd[1]%>";
    
    var currCdComboValue = "<%=currCd[0]%>";   
    var currCdComboText = "<%=currCd[1]%>";
     
    var chargeRuleCdComboValue = " |<%=(chargeCd[0].length()>0)? ruleCd[0]+"|"+chargeCd[0]:ruleCd[0]%>";   
    var chargeRuleCdComboText = " |<%=(chargeCd[0].length()>0)? ruleCd[1]+"|"+chargeCd[1]:ruleCd[1]%>";  
   
    var bkgEsvcTpCdComboValue = " |<%=bkgEsvcTpCd[0]%>";   
    var bkgEsvcTpCdComboText = " |<%=bkgEsvcTpCd[1]%>";
    
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>">
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>">
<input type="hidden" name="pre_amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("pre_amdt_seq"))%>">
<input type="hidden" name="prc_prop_sts_cd" value="<%=StringUtil.xssFilter(request.getParameter("prc_prop_sts_cd"))%>">
<input type="hidden" name="eff_dt" value="<%=StringUtil.xssFilter(request.getParameter("eff_dt"))%>">
<input type="hidden" name="exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("exp_dt"))%>">
<input type="hidden" name="pre_exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("pre_exp_dt"))%>">
<input type="hidden" name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr"))%>">
<input type="hidden" name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr"))%>">
<input type="hidden" name="dur_dup_flg" value="<%=StringUtil.xssFilter(request.getParameter("dur_dup_flg"))%>">
<input type="hidden" name="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(request.getParameter("cmdt_hdr_seq"))%>">
<input type="hidden" name="select_row" value="<%=StringUtil.xssFilter(request.getParameter("select_row"))%>">

<input type="hidden" name="note_conv_mapg_id" value="<%=StringUtil.xssFilter(request.getParameter("note_conv_mapg_id"))%>">
<input type="hidden" name="fic_rt_tp_cd" value="<%=JSPUtil.getParameter(request, "fic_rt_tp_cd") %>">
<input type="hidden" name="cd">

<input type="hidden" name="before_exp_dt" value="<%=beforeExpDt%>">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;RFA Proposal Creation - Rate (Commodity Note)</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- 1 (S) -->
        <table class="search" id="mainTable"> 
        <tr><td class="bg"> 
        
            <!-- Grid - 2 (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
            <!-- Grid - 2 (E) -->
            
            <table class="height_10"><tr><td></td></tr></table>
                
            <!-- Grid - 2 (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>
            <!-- Grid - 2 (E) -->   
            <table width="100%" class="button" border="0"> 
            <tr><td class="btn2_bg">
                <table cellpadding="0" cellspacing="0"><tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_add" suppressWait="Y">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_delete" suppressWait="Y">Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_amend" suppressWait="Y">Amend</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_amendcancel">Amend Cancel</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_accept">Accept</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_acceptcancel">Accept Cancel</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                    </tr></table>
            </td></tr>
            </table>

		<!--  biz_1   (E) -->
			<table class="height_5"><tr><td></td></tr></table>
			
			<table class="grid2" border="0" style="width:100%;"> 
				<tr class="tr2_head">
					<td width="100" class="input" align="center">Commodity Note</td>
				<td width=""><textarea name="ta_note_ctnt" style="width:100%;height:80" ></textarea></td>
				</tr></table>		
		
			<table class="height_8"><tr><td></td></tr></table>
			
            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<!--biz page (E)--> 

				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Conversion</td></tr>
				</table>
				<!--Grid (s)-->

					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table> 
					
						<!--Grid (E)-->		
						
						<!--Grid (E)--> <!--  Button_Sub (S) -->
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
												<td class="btn2" name="btn_copy">Copy</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_paste">Paste</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_rowadd3" suppressWait="Y">Row&nbsp;Add</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
				
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_rowcopy" suppressWait="Y">Row&nbsp;Copy</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
				
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_delete3" suppressWait="Y">Delete</td>
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
						
				</td></tr></table>		
						
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	
	<!--biz page (E)-->
	<table class="height_5"><tr><td></td></tr></table>
	
	<!-- : ( Button : pop ) (S) -->
	
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->  
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_ok">OK</td>
                    <td class="btn1_right">
                </tr></table></td>  
            <td class="btn1_line"></td>     
            
            <td><table width="72 border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right">
                </tr></table></td>
            </tr>
        </table></td>
            </tr>
        </table>
        <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>
