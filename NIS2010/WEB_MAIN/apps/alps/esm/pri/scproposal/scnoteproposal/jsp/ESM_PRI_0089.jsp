<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0089.jsp
*@FileTitle : Guideline Clause & Standard Wording List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.18 문동규
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.event.EsmPri0089Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltCtrtCluzListVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0089Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String propNo = null;
    String amdtSeq = null;
    String svcScpCd = null;
    String noteClssCd = null;
    String chgCd = null;
    StringBuffer itemComboText = new StringBuffer();
    StringBuffer itemComboValue = new StringBuffer();
    //StringBuffer scgComboText = new StringBuffer();
    //StringBuffer scgComboValue = new StringBuffer();
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCNoteProposal");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0089Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        
        RsltCtrtCluzListVO vo = event.getRsltCtrtCluzListVO();
		
        if (vo != null) {
            propNo = vo.getPropNo();
            amdtSeq = vo.getAmdtSeq();
            svcScpCd = vo.getSvcScpCd();
            noteClssCd = vo.getNoteClssCd();
            chgCd = vo.getChgCd();
        } else {
            propNo = "";
            amdtSeq = "";
            svcScpCd = "";
            noteClssCd = "";
            chgCd = "";
        }
        
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        List<CodeInfo> item = (List<CodeInfo>)eventResponse.getCustomData("item");
        
        // Item Combo Data 생성
        if (item.size() > 0) {
            int dataCount = item.size();
            CodeInfo[] vos = new CodeInfo[dataCount];
            item.toArray(vos);
    
            for (int i = 0; i < dataCount; i++) {
                if (i != 0) {
                    itemComboText.append("|");
                    itemComboValue.append("|");
                }
                //itemComboText.append(vos[i].getCode()).append("\t").append(vos[i].getName());
                itemComboText.append(vos[i].getName());
                itemComboValue.append(vos[i].getCode());
            }
        }

        /*List<RsltCdListVO> surchage = (List<RsltCdListVO>)eventResponse.getCustomData("surchage");

        // Sub-continent Combo Data 생성
        if (surchage.size() > 0) {
            int dataCount = surchage.size();
            RsltCdListVO[] vos = new RsltCdListVO[dataCount];
            surchage.toArray(vos);
            
            for (int i = 0; i < dataCount; i++) {
                if (i != 0) {
                    scgComboText.append("|");
                    scgComboValue.append("|");
                }
                //scgComboText.append(vos[i].getCd()).append("\t").append(vos[i].getNm());
                scgComboText.append(vos[i].getNm());
                scgComboValue.append(vos[i].getCd());
            }
        }*/

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Guideline Clause & Standard Wording List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var itemComboText = "<%=itemComboText.toString()%>";
    var itemComboValue = "<%=itemComboValue.toString()%>";

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="prop_no"    value="<%=propNo %>">
<input type="hidden" name="amdt_seq"   value="<%=amdtSeq %>">
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd %>">
<input type="hidden" name="note_clss_cd" value="<%=noteClssCd %>">
<input type="hidden" name="chg_cd" value="<%=chgCd %>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Guideline Clause & Standard Wording List</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
            <table class="search"> 
            <tr><td class="bg">
            
                <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Guideline</td></tr>
                </table>
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <!-- : ( Grid ) (E) --> 
                
                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                
                
                <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Standard Wording</td></tr>
                </table>
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>
                <!-- : ( Grid ) (E) --> 
            
            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->

    </td></tr>
        </table>
<!-- : ( Button : pop ) (S) -->


<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_OK">OK</td>
                    <td class="btn1_right"></td></tr></table></td>
                    <td class="btn1_line"></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td></tr>
                    </table>
                </td>
            </tr>
            </table>
            </td>
        </tr>
        </table>
    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>