<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_PRI_3019.jsp
*@FileTitle : TAA Creation & Amendment View
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.08
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.08.08 서미진
* 1.0 Creation
===========================================================
* History
* 2013.09.05 전윤주 [CHM-201326372] Autorating 결과 계약 조회시 편의 기능 구현
	                            - Autorating 에서 사용된 commodity, Route 일 경우 색 변경해줌
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event.EsmPri3019Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>

<%
	EsmPri3019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String usrId = null;
	String usrSrepCd = null;
	String usrOfcCd	 = null;
    String condTaaNo = null;
    String taaNo = null;
    String amdtSeq = null;
    
	//BKG 0079_08 에서 넘겨주는 파라미터
	String sTriNoClr  = "";

	Logger log = Logger.getLogger("com.hanjin.apps.TRIProposal.TAAProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		usrId = account.getUsr_id();
		usrSrepCd = account.getSrep_cd();
		usrOfcCd = account.getOfc_cd();

		event = (EsmPri3019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		taaNo = request.getParameter("taa_no");
		amdtSeq = request.getParameter("amdt_seq");
		
		//BKG 0079_08 에서 넘겨주는 파라미터
	    sTriNoClr = JSPUtil.getNull(request.getParameter("s_tri_no"));
       
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TAA Creation & Amendment</title>
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
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value="<%=usrId %>">
<input type="hidden" name="usr_srep_cd" value="<%=usrSrepCd %>">
<input type="hidden" name="usr_ofc_cd" value="<%=usrOfcCd %>">
<input type="hidden" name="old_svc_scp_cd">
<input type="hidden" name="taa_prop_no">
<input type="hidden" name="cond_taa_no" value="<%=condTaaNo %>">
<!-- BKG 0079_08 에서 넘겨주는 값-->
<input type="hidden" name="s_tri_no_clr" value="<%=sTriNoClr%>">
<!-- 개발자 작업	-->
<table width="100%" class="popup" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

<!-- OUTER - POPUP (S)tart -->
    <tr><td valign="top">    
    
   	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; TAA Creation & Amendment View</td></tr>
	</table>
	<!-- : ( Title ) (E) -->
    
    <table class="height_2"><tr><td colspan="8"></td></tr></table>
    <!--biz page (S)-->
    <table class="search">
        <tr><td class="bg">
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="85">TAA No.</td>
                    <td width="90"><input type="text" caption="TAA Number" name="taa_no" maxlength="12" 
                        style="width:85;ime-mode:disabled;text-align:center;" dataformat="engup" class="input2" value="<%=taaNo %>"></td>
                    <td width="60">AMD  No.</td>
                    <td width="80">
                    <input type="text" style="width:60;text-align:center;" dataformat="int" name="amdt_seq" class="input2" value="<%=amdtSeq %>"></td>
                    <td width="60">Duration</td>
                    <td width="86"><input type="text" caption="Effective date" name="eff_dt" cofield="exp_dt" maxlength="10" 
                        dataformat="ymd" style="width:80;text-align:center;" class="input2" required>
                    </td>
                    <td width="102">&nbsp;~&nbsp;<input type="text" caption="Expiration date" name="exp_dt" cofield="eff_dt" maxlength="10" 
                        dataformat="ymd" style="width:80;text-align:center;" class="input2" required>
                    </td>
                    <td width="80">Confirmation</td>
                    <td width=""><input type="text" name="cfm_nm" style="width:70;text-align:center;" class="input2" readonly="readonly"></td>
                </tr></table>
                <table class="line_bluedot"><tr><td></td></tr></table>
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="85">Service Scope</td>
                    <td width="90"><input type="text" caption="TAA Number" name="svc_scp_cd" maxlength="12" 
                        style="width:85;ime-mode:disabled;text-align:center;" dataformat="engup" class="input2"></td>
                    <td width="" style="padding-bottom:1"><input name="svc_scp_nm" type="text" style="width:385;text-align:left;" class="input2" readonly="readonly" caption="Service Scope">
                    </td>
                </tr></table>
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="85">Customer</td>
                    <td width="90"><input type="text" style="width: 25;"
                        dataformat="engup" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd"
                        class="input2" caption="Customer Code" required>&nbsp;<input
                        type="text" style="width: 55;" dataformat="int" name="ctrt_cust_seq"
                        maxlength="6" class="input2" caption="Customer Sequence"
                        required>&nbsp;</td>

                    <td width="240"><input type="text" style="width: 187;"
                        name="ctrt_cust_nm" readonly="readonly" class="input2"></td>
                    <td width="60">Office</td>
                    <td width="90"><input type="text" name="respb_sls_ofc_cd" dataformat="engup" readonly="readonly"
                        style="width:84;text-align:left;" class="input2" caption="Request Office Code" 
                        required></td>
                    <td width="80">Sales Rep.</td>
                    <td width="82"><input type="text" name="respb_srep_cd" dataformat="engup" readonly="readonly"
                        style="width:80;text-align:left;" class="input2" caption="Request Office Code" 
                        required></td>
                    <td width="" style="padding-bottom:1"><input type="text" style="width:200;text-align:left;" 
                        name="respb_srep_nm" readonly="readonly" class="input2"></td>
                </tr></table>

    </td></tr></table>

    <table class="height_8"><tr><td></td></tr></table>

    <table class="search">
        <tr><td class="bg">
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable" style="display:none;">
                <tr>
                    <td width="100%">
                    <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
                </table>
                <table width="100%"  id="mainTable">
                <tr>
                    <td width="100%">
                    <script language="javascript">ComSheetObject('sheet2');</script>
                    </td>
                </tr>
                </table>
                <!-- : ( Grid ) (E) -->

                <table class="height_8"><tr><td></td></tr></table>

                <table class="grid2" border="0" style="width:100%;">
                <tr class="tr2_head">
                    <td width="25%">Origin</td>
                    <td width="25%">Origin Via</td>
                    <td width="25%">Desination Via</td>
                    <td width="25%">Desination </td>
                </tr>
                <tr class="input2">
                    <td><textarea name="org_pnt_loc_nm" style="width:100%; height:95;" class="textarea2" readonly="readonly"></textarea></td>
                    <td><textarea name="org_via_port_nm" style="width:100%; height:95;" class="textarea2" readonly="readonly"></textarea></td>
                    <td><textarea name="dest_via_port_nm" style="width:100%; height:95;" class="textarea2" readonly="readonly"></textarea></td>
                    <td><textarea name="dest_pnt_loc_nm" style="width:100%; height:95;" class="textarea2" readonly="readonly"></textarea></td>

                </tr></table>
            </td>
            </tr></table>

        <!-- <table class="height_10"><tr><td></td></tr></table> -->

</td></tr>
</table>

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:10;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close">Close</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
			</tr>
			</table>
		</td>
	</tr>
	</table>
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>