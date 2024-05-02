<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0091.jsp
 *@FileTitle : Commodity Note Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.08
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.06.08 박성수
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri0091Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri0091Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCRateProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session
                .getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri0091Event) request.getAttribute("Event");
        serverException = (Exception) request
                .getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        

    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Commodity Note Creation</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->
<input type="hidden" name="prop_no" value="<%=request.getParameter("prop_no")%>">
<input type="hidden" name="amdt_seq" value="<%=request.getParameter("amdt_seq")%>">
<input type="hidden" name="svc_scp_cd" value="<%=request.getParameter("svc_scp_cd")%>">
<input type="hidden" name="pre_amdt_seq" value="<%=request.getParameter("pre_amdt_seq")%>">
<input type="hidden" name="prc_prop_sts_cd" value="<%=request.getParameter("prc_prop_sts_cd")%>">
<input type="hidden" name="eff_dt" value="<%=request.getParameter("eff_dt")%>">
<input type="hidden" name="exp_dt" value="<%=request.getParameter("exp_dt")%>">
<input type="hidden" name="pre_exp_dt" value="<%=request.getParameter("pre_exp_dt")%>">
<input type="hidden" name="is_req_usr" value="<%=request.getParameter("is_req_usr")%>">
<input type="hidden" name="is_apro_usr" value="<%=request.getParameter("is_apro_usr")%>">
<input type="hidden" name="dur_dup_flg" value="<%=request.getParameter("dur_dup_flg")%>">
<input type="hidden" name="gen_spcl_rt_tp_cd" value="<%=request.getParameter("gen_spcl_rt_tp_cd")%>">
<input type="hidden" name="cmdt_hdr_seq" value="<%=request.getParameter("cmdt_hdr_seq")%>">
<input type="hidden" name="lgcy_if_flg" value="<%=request.getParameter("lgcy_if_flg")%>">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Commodity Note Creation</td></tr>
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
                        <td class="btn2" name="btn_rowcopy" suppressWait="Y">Row&nbsp;Copy</td>
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
                        <td class="btn2" name="btn_amendcancel" suppressWait="Y">Amend Cancel</td>
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

                </td></tr>
            </table>
            <!-- grid box (E) -->
            
        </td></tr>
        </table>            
        <!-- 1 (E) -->
</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup"><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_ok">OK</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>

						<td>
						<table width="72 border=" 0" cellpadding="0" cellspacing="0"
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
				</td>
			</tr>
		</table>
		<!--Button (E) --></td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>

