<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_pri_2001_04.js
 *@FileTitle : RFA Rate Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.07
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.07 박성수
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.event.EsmPri200104Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
EsmPri200104Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger
			.getLogger("com.hanjin.apps.RFAGuideline.RFAGuidelineMain");
	
	String[] ratUtCdList = null;
	String[] prcCgoTpCdList = null;
	String[] currCdList = null;
	
	ArrayList<CodeInfo> termOrgCdList = null;
	ArrayList<CodeInfo> termDestCdList = null;
	ArrayList<CodeInfo> transModeCdList = null;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri200104Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");
		
		ratUtCdList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCdList"), false, "|", "\t");
		prcCgoTpCdList = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCdList"), true, "|", "\t", "getCode", "getName");
		currCdList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCdList"), false, "|", "\t");
		
		termOrgCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("termOrgCdList");
		termDestCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("termDestCdList");
		transModeCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("transModeCdList");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RFA Rate Guideline Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var ratUtCdValue = "<%=ratUtCdList[0]%>";
    var ratUtCdText = "<%=ratUtCdList[1]%>";
    var prcCgoTpCddValue = "<%=prcCgoTpCdList[0]%>";
    var prcCgoTpCdText = "<%=prcCgoTpCdList[1]%>";
    var currCdValue = "<%=currCdList[0]%>";
    var currCdText = "<%=currCdList[1]%>";
    
    var arrTermOrg = new Array();
    var arrTermDest = new Array();
    var arrTransMode = new Array();
    
    <%
    for (int i = 0; termOrgCdList != null && i < termOrgCdList.size(); i++) {
    	CodeInfo row = termOrgCdList.get(i);
    	out.println("arrTermOrg[\"" + row.getCode()  + "\"] = \"" + row.getName() + "\";");
    }
    for (int i = 0; termDestCdList != null && i < termDestCdList.size(); i++) {
    	CodeInfo row = termDestCdList.get(i);
    	out.println("arrTermDest[\"" + row.getCode()  + "\"] = \"" + row.getName() + "\";");
    }
    for (int i = 0; transModeCdList != null && i < transModeCdList.size(); i++) {
    	CodeInfo row = transModeCdList.get(i);
    	out.println("arrTransMode[\"" + row.getCode()  + "\"] = \"" + row.getName() + "\";");
    }
    %>
    
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
<form name="form"><input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="gline_seq">
<input type="hidden" name="cmdt_hdr_seq">
<input type="hidden" name="rout_seq">
<table class="search">
	<tr>
		<td class="bg"><!--Button (S) -->
		<table width="100%" border="0" class="button" cellpadding="0"
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
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td class="btn1_line"></td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_LoadExcel">Load Excel</td>
                            <td class="btn1_right"></td>
                            </tr>
                        </table></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) -->
		
		<table class="search" border="0">
            <tr>
                <td class="title_h"></td>
                <td class="title_s">Commodity Group</td>
            </tr>
        </table>

        <!--grid (s)-->
        <table width="100%" id="mainTable">
            <tr>
                <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
                </td>
            </tr>
        </table>
        <!--grid(E)-->
        <!--grid button (S)-->
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
                                <td class="btn2" name="btn_rowadd1" suppressWait="Y">Row&nbsp;Add</td>
                                <td class="btn2_right"></td>
                            </tr>
                        </table>
                        </td>
                        <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0"
                            class="button">
                            <tr>
                                <td class="btn2_left"></td>
                                <td class="btn2" name="btn_rowcopy1" suppressWait="Y">Row&nbsp;Copy</td>
                                <td class="btn2_right"></td>
                            </tr>
                        </table>
                        </td>
                        <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0"
                            class="button">
                            <tr>
                                <td class="btn2_left"></td>
                                <td class="btn2" name="btn_delete1">Delete</td>
                                <td class="btn2_right"></td>
                            </tr>
                        </table>
                        </td>
                        <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0"
                            class="button">
                            <tr>
                                <td class="btn2_left"></td>
                                <td class="btn2" name="btn_save1">Save</td>
                                <td class="btn2_right"></td>
                            </tr>
                        </table>
                        </td>
                    </tr>
                </table>
                </td>
            </tr>
        </table>
        
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

        <table class="search" border="0">
            <tr>
                <td class="title_h"></td>
                <td class="title_s">Route Detail</td>
            </tr>
        </table>

        <!--grid (s)-->
        <table width="100%" id="mainTable">
            <tr>
                <td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
                </td>
            </tr>
        </table>
        <!--grid(E)-->
        
		<table class="height_5"><tr><td></td></tr></table>      
		<table border="0" style="width:100%; background-color:white;" class="grid2"> 
			<tr class="tr2_head">
				<td width="25%">Origin</td>
				<td width="25%">Origin Via</td> 
				<td width="25%">Destination Via</td>    
				<td width="25%">Destination</td>          
			</tr>
			<tr>
				<td class="input2"><textarea name="origin_desc" style="width:100%" rows="3" class="textarea2" readonly></textarea></td>
				<td class="input2"><textarea name="ovia_desc" style="width:100%" rows="3" class="textarea2" readonly></textarea></td>
				<td class="input2"><textarea name="dvia_desc" style="width:100%" rows="3" class="textarea2" readonly></textarea></td>
				<td class="input2"><textarea name="dest_desc" style="width:100%" rows="3" class="textarea2" readonly></textarea></td>
			</tr>
		</table>
		
        <!--grid button (S)-->
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
                                <td class="btn2" name="btn_rowadd2" suppressWait="Y">Row&nbsp;Add</td>
                                <td class="btn2_right"></td>
                            </tr>
                        </table>
                        </td>
                        <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0"
                            class="button">
                            <tr>
                                <td class="btn2_left"></td>
                                <td class="btn2" name="btn_rowcopy2" suppressWait="Y">Row&nbsp;Copy</td>
                                <td class="btn2_right"></td>
                            </tr>
                        </table>
                        </td>
                        <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0"
                            class="button">
                            <tr>
                                <td class="btn2_left"></td>
                                <td class="btn2" name="btn_delete2">Delete</td>
                                <td class="btn2_right"></td>
                            </tr>
                        </table>
                        </td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_save2">Save</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
                    </tr>
                </table>
                </td>
            </tr>
        </table>
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

        <table class="search" border="0">
            <tr>
                <td class="title_h"></td>
                <td class="title_s">Rate</td>
            </tr>
        </table>

		<!--grid (s)-->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			</tr>
		</table>
		<!--grid(E)--> <!--grid button (S)-->
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
								<td class="btn2" name="btn_rowadd3" suppressWait="Y">Row&nbsp;Add</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<!--td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_rowcopy3">Row&nbsp;Copy</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td-->
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
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_save3">Save</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--grid button (E)--></td>
	</tr>
</table>

<table class="height_10">
	<tr>
		<td colspan="8"></td>
	</tr>
</table>

<div id="hiddenSheetLayer" style="display: none">
<script language="javascript">ComSheetObject('sheet4');</script>
<script language="javascript">ComSheetObject('sheet5');</script>
<script language="javascript">ComSheetObject('sheet6');</script>
<script language="javascript">ComSheetObject('sheet7');</script>
<script language="javascript">ComSheetObject('sheet8');</script>
<script language="javascript">ComSheetObject('sheet9');</script>
<script language="javascript">ComSheetObject('sheet10');</script>
</div>

<!-- 개발자 작업  끝 --></form>
</body>
</html>