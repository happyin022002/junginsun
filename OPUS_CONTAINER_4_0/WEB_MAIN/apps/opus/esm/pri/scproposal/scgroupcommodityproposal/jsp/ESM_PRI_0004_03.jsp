<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0004_03.jsp
*@FileTitle  : S/C Proposal Commodity Group - Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.event.EsmPri000403Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmPri000403Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	String[] srcInfoCd = null;		//Source
	String[] prcProgStsCd = null;	//Status
	
	Logger log = Logger
			.getLogger("com.clt.apps.SCProposal.SCGroupCommodityProposal");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri000403Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";

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
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
 
<input type="hidden" name="prop_no"> 
<input type="hidden" name="amdt_seq"> 
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="con_chk">

<input type="hidden" name="grp_cmdt_seq">

<div class="opus_design_btn">
	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
</div>
		
<div class="layout_wrap">
    <div class="layout_vertical_2"  style="width:30%">
        <div class="opus_design_grid   mar_rgt_8">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
    </div>
<!--     <div class="layout_vertical_3" style="width:10%">
    	<table>
    		<tr>
    			<td>
    				<button type="button" class="btn_etc" name="" id="" style="width:70px;text-align:center;"> >> </button>
    			</td>
    		</tr>
    	</table>
    	
    </div> -->
    <div class="layout_vertical_2" style="width:69.9%">
        <div class="opus_design_grid">
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
    </div>
</div>
</form>
</body>
</html>