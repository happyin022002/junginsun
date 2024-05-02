<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2036.jsp
 *@FileTitle : RFA Proposal Creation - Summary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.24
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.24 박성수
 * 1.0 Creation
 =========================================================
 * History
 * [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
 * 2015.09.24 전지예 [CHM-201537758] RFA module상 기능개선 및 추가 function 개발요청 관련
 * 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
 =========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2036Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>

<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri2036Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
	String[] prcTrspModCd	= null;
	String[] ratUtCd		= null;
	String[] currCd			= null;
	String[] prcCgoTpCd		= null;
	String[] srcInfoCd		= null;
	String[] prcProgStsCd	= null;
	String[] orgDestTpCd = null;
	String[] prcCmdtTpCd = null;
	
    Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFARateProposal");
	
    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2036Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
		prcTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcTrspModCd"), false,"|","\t","getCode","getName");
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
		currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"),false,"|","\t");
		prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCd"), true,"|","\t","getCode","getName");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoCd"), false,"|","\t","getCode","getName");
		prcProgStsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcProgStsCd"), false,"|","\t","getCode","getName");
		orgDestTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("orgDestTpCd"), false,"|","\t","getCode","getName");
		prcCmdtTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCmdtTpCd"), false,"|","\t","getCode","getName");

    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<% if("Y".equals(JSPUtil.getParameter(request, "is_accept_all"))) { %>
<title>RFA Proposal Creation - Rate [Accept All]</title>
<% } else { %>
<title>RFA Proposal Creation - Rate [Summary]</title>
<% } %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var prcTrspModCdValue = " |<%=prcTrspModCd[0]%>";
	var prcTrspModCdText = " |<%=prcTrspModCd[1]%>";
	var ratUtCdValue = " |<%=ratUtCd[0]%>";
	var ratUtCdText = " |<%=ratUtCd[1]%>";
	var currCdValue = "|<%=currCd[0]%>";
	var currCdText = "|<%=currCd[1]%>";
	var prcCgoTpCdValue = " |<%=prcCgoTpCd[0]%>";
	var prcCgoTpCdText = " |<%=prcCgoTpCd[1]%>";
	var srcInfoCdValue = "|<%=srcInfoCd[0]%>";
	var srcInfoCdText = "|<%=srcInfoCd[1]%>";
	var PrcProgStsCdValue = "|<%=prcProgStsCd[0]%>";
	var PrcProgStsCdText = "|<%=prcProgStsCd[1]%>";
	var orgDestTpCdValue = "|<%=orgDestTpCd[0]%>";
	var orgDestTpCdText = "|<%=orgDestTpCd[1]%>";
	var prcCmdtTpCdValue = "|<%=prcCmdtTpCd[0]%>";
	var prcCmdtTpCdText = "|<%=prcCmdtTpCd[1]%>";

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
<input type="hidden" name="fic_rt_tp_cd" value="<%=JSPUtil.getParameter(request, "fic_rt_tp_cd")%>">
<!-- Arbitrary. A : ARB  -->
<input type="hidden" name="add_chg_tp_cd" value="A" />
<!-- Special Note. P : Special Note  -->
<input type="hidden" name="note_tp_cd" value="P">
<!-- Rate Tab 에서 호출했을 경우 opner 제어를 위해 -->
<input type="hidden" name="is_accept_all" value="<%=JSPUtil.getParameter(request, "is_accept_all")%>">
<!-- OUTER - POPUP (S)tart -->
<table  width="1000" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;RFA Proposal Creation - <%= JSPUtil.getParameter(request, "is_accept_all").equals("Y")?"Accept All":"Summary" %></td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <table class="search"> 
        <tr><td class="bg"> 
        	
            <!-- Grid - 1 (S) -->
			<table class="search" border="0">
				<tr class="h23">
					<td class="title_h"></td>
					<td class="title_s">Rate</td>
				</tr>
			</table>
			
            <table width="100%"  id="mainTable"  class="Grid2">
                <tr>
                    <td width="100%">
                        <script type="text/javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table>
            <!-- Grid - 1 (E) -->   
            
        <% if(!"Y".equals(JSPUtil.getParameter(request, "is_accept_all"))) { %>
            <!-- Grid - 2 (S) -->
			<table class="search" border="0">
				<tr>
					<td class="title_h"></td>
					<td class="title_s">Arbitrary</td>
				</tr>
			</table>
            
            <table width="100%"  id="mainTable" class="Grid2">
                <tr>
                    <td width="100%">
                        <script type="text/javascript">ComSheetObject('sheet2');</script>
                    </td>
                </tr>
            </table>
            <!-- Grid - 2 (E) -->   
            
            <!-- Grid - 3 (S) -->
			<table class="search" border="0">
				<tr>
					<td class="title_h"></td>
					<td class="title_s">Special Notes</td>
				</tr>
			</table>
            
            <table width="100%"  id="mainTable" class="Grid2">
                <tr>
                    <td width="100%">
                        <script type="text/javascript">ComSheetObject('sheet3');</script>
                    </td>
                </tr>
            </table>
            <!-- Grid - 3 (E) -->   
            
            <!-- Grid - 3 (S) -->
			<table class="search" border="0">
				<tr>
					<td class="title_h"></td>
					<td class="title_s">Location Group</td>
				</tr>
			</table>
            
            <table style="width: 100%" id="mainTable" class="Grid2">
                <tr>
                    <td width="100%">
                        <script type="text/javascript">ComSheetObject('sheet4');</script>
                    </td>
                </tr>
            </table>
            <!-- Grid - 3 (E) -->
            
            <!-- Grid - 3 (S) -->
			<table class="search" border="0">
				<tr>
					<td class="title_h"></td>
					<td class="title_s">Commodity Group</td>
				</tr>
			</table>
            
            <table style="width: 100%"  id="mainTable" class="Grid2">
                <tr>
                    <td width="100%">
                        <script type="text/javascript">ComSheetObject('sheet5');</script>
                    </td>
                </tr>
            </table>
            <!-- Grid - 3 (E) -->
        <% } %>
            </td></tr>
        </table>
        <!-- grid box (E) -->
        
        </td></tr>
</table>
<!-- 1 (E) -->

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
					<% if("Y".equals(JSPUtil.getParameter(request, "is_accept_all"))) { %>
						<td>
						<table width="" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
					<% } %>

						<td>
						<table width="" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_acceptall"><%= JSPUtil.getParameter(request, "is_accept_all").equals("Y")?"Accept All":"Approve" %></td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>

						<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
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
				</td>
			</tr>
		</table>
		<!--Button (E) --></td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->

		</form></body>
</html>

