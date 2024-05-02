<%
	/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_2041_03.jsp
 *@FileTitle  : Amendment History - Commodity Group
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/09
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.event.EsmPri204103Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmPri204103Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //Error from Server
	String strErrMsg = ""; //Error Message
	int rowCount = 0; //Number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	String[] srcInfoCd = null;		//Source
	String[] prcProgStsCd = null;	//Status
	
	Logger log = Logger
			.getLogger("com.clt.apps.RFAProposal.RFAGroupCommodityProposal");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri204103Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
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

<script type="text/javascript">
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="prop_no" id="prop_no" />
<input type="hidden" name="amdt_seq" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd" />
<input type="hidden" name="pre_amdt_seq" id="pre_amdt_seq" />
<input type="hidden" name="prop_sts_cd" id="prop_sts_cd" />
<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="exp_dt" id="exp_dt" />
<input type="hidden" name="pre_exp_dt" id="pre_exp_dt" />

<input type="hidden" name="grp_cmdt_seq" id="grp_cmdt_seq" />
<input type="hidden" name="req_usr_flg" id="req_usr_flg" />
<input type="hidden" name="apro_usr_flg" id="apro_usr_flg" />
<input type="hidden" name="dur_dup_flg" id="dur_dup_flg" />

<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="layout_vertical_2" style="width:39%;">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
        <!-- opus_design_grid(E) -->
    </div>
    <div class="layout_vertical_2" style="width:3%;height:312px;text-align:center;vertical-align:middle;"> 
        <!-- <div class="opus_design_data" style="height:312px;text-align:center;"> -->
            <table style="height:300px;">
            	<tr>
            		<td style="text-align:center;">
              		  <button type="button" class="btn_right"></button>            			
					</td>
            	</tr>
			</table>
    </div>
    <div class="layout_vertical_2" style="width:58%;">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
        <!-- opus_design_grid(E) -->
    </div>
</div>
<!-- layout_wrap(E) -->
</form>
</body>
</html>