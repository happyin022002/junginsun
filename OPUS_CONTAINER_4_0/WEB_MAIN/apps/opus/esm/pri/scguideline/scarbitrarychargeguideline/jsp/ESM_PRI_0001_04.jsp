<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0001_004.jsp
*@FileTitle  : Origin/Destination Arbitrary Charge Guideline Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.event.EsmPri000104Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>

<%
	EsmPri000104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCArbitraryChargeGuideline");
	String[] currCd = null;
	String[] perCd = null;	
	String[] termOrgCd = null;
	String[] termDesCd = null;
	String[] transCd = null;	
	String[] cargoCd = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			strUsr_id =	account.getUsr_id();
			strUsr_nm = account.getUsr_nm();
			event = (EsmPri000104Event)request.getAttribute("Event");
			serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
			if (serverException != null) {
					strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}
       GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
       currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"), false);
       perCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("perCd"), false);
       termOrgCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("termOrgCd"), false ,"|","\t","getCode","getName");
       termDesCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("termDesCd"), false ,"|","\t","getCode","getName");
       transCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("transCd"), false ,"|","\t","getCode","getName");
       cargoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargoCd"), true ,"|","\t","getCode","getName");
	} catch(Exception e) {
			out.println(e.toString());
	}
%>
<script type="text/javascript">
    var currCdComboValue = " |<%=currCd[0]%>";
    var currCdComboText = " |<%=currCd[1]%>";
    var perCdComboValue = " |<%=perCd[0]%>";
    var perCdComboText = " |<%=perCd[1]%>";
    var termOrgCdComboValue = " |<%=termOrgCd[0]%>";
    var termOrgCdComboText = " |<%=termOrgCd[1]%>";
    var termDesCdComboValue = " |<%=termDesCd[0]%>";
    var termDesCdComboText = " |<%=termDesCd[1]%>";    
    var transCdComboValue = " |<%=transCd[0]%>";
    var transCdComboText = " |<%=transCd[1]%>";
    var cargoCdComboValue = " |<%=cargoCd[0]%>";
    var cargoCdComboText = " |<%=cargoCd[1]%>";    
		function setupPage(){
				var errMessage = "<%=strErrMsg%>";
				if (errMessage.length >= 1) {
						showErrMessage(errMessage);
				} // end if
				loadPage();
		}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="svc_scp_cd" value="" id="svc_scp_cd" />
<input type="hidden" name="gline_seq" value="" id="gline_seq" />
<input type="hidden" name="org_dest_tp_cd" value="O" id="org_dest_tp_cd" />
<input type="hidden" name="cd" id="cd" />

<div class="opus_design_title clear">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
			 <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
			 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--  
			 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--  
			 --><button type="button" class="btn_normal" name="btn_LoadExcel" id="btn_LoadExcel">Load Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>

<!-- <div class="wrap_search"> -->
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry" style="width:360px;margin-top:-25px;">
		<table>
			<colgroup>
				<col width="40px" />
				<col width="10px" />
				<col width="300px" />
				<col width="%" />
			</colgroup>
			<tr>
				<th class="sm">Type</th>
				<td class="sm"></td>
				<td class="sm"><input type="radio" class="trans" name="dest_tp_cd" checked ><span id="dest_tp_cd1"> Origin Arbitrary </span><label></label><input type="radio" class="trans" name="dest_tp_cd" > <span id="dest_tp_cd2">Destination Arbitrary</span></td>			</td>
				<td></td>
			</tr>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
<!-- </div> -->
	
<!-- <div class="wrap_result"> -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		<!-- Content -->
			<button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Copy" id="btn_Copy">Row Copy</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Delete</button>
		</div>
		<!-- opus_design_btn(e) -->			
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
<!-- </div> -->
</form>