<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1068.jsp
*@FileTitle  : TPB Issue Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1068Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1068Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String parBkgNo         = "";
    String parNtcSeq        = "";
	String parBlNo          = "";
	String parCustCd        = "";
	String parCustNm        = "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.HoldNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		parBkgNo = JSPUtil.getParameter(request, "bkg_no");
        parNtcSeq= JSPUtil.getParameter(request, "ntc_seq");
        parBlNo  = JSPUtil.getParameter(request, "bl_no");
        parCustCd= JSPUtil.getParameter(request, "cust_cd");
        parCustNm= JSPUtil.getParameter(request, "cust_nm");

		event = (EsmBkg1068Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		with(document.form) {
            bkg_no.value  = "<%=parBkgNo%>";
            ntc_seq.value = "<%=parNtcSeq%>";
		    bl_no.value   = "<%=parBlNo%>";
		    cust_cd.value = "<%=parCustCd%>";
		    cust_nm.value = "<%=parCustNm%>";
		}
		
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Developer Work	-->

<input type="hidden" name="bkg_no" value='<%=parBkgNo%>' />
<input type="hidden" name="ntc_seq" value='<%=parNtcSeq%>' />

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>TPB Issue</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_GotoTPB" id="btn_GotoTPB">Go to TPB</button><!--  -->
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr class="h23">
                                <td width="50">B/L No.</td>
                                <td width="140">
                                    <input type="text" style="width:110px;text-align:center;" class="input2" readonly="readonly" dataformat="" maxlength="13" caption="B/L No." name="bl_no" value='<%=parBlNo%>' />
                                </td>
                                <td width="50">Customer</td>
                                <td width="">
                                    <input type="text" style="width:70px;text-align:center;" class="input2" readonly="readonly" name="cust_cd" value='<%=parCustCd%>' /><!-- 
                                    --><input type="text" style="width:220px;text-align:left;" class="input2" readonly="readonly" name="cust_nm" value='<%=parCustNm%>' />
                                </td>
                	</tr> 
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>