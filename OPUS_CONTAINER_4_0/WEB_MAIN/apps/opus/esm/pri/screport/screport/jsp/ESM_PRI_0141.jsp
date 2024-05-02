<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0141.jsp
*@FileTitle  : MOT/SSE Tariff
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0141Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
	EsmPri0141Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCReport.SCReport");
	
	String[] motOrgBsePortCdList = null;
	
	String[] motFileCntrTpCdList = null;
	String[] motFileCmdtTpCdList = null;
	String[] motFileCntrSzCdList = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0141Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		motOrgBsePortCdList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("motOrgBsePortCdList"), false, "|", "\t", "getCd", "getCd");
		
		motFileCntrTpCdList = PRIUtil.getValueObject2StringArray((ArrayList<CodeInfo>)eventResponse.getCustomData("motFileCntrTpCdList"), false, "|", "\t", "getCode", "getName" );
		motFileCmdtTpCdList = PRIUtil.getValueObject2StringArray((ArrayList<CodeInfo>)eventResponse.getCustomData("motFileCmdtTpCdList"), false, "|", "\t", "getCode", "getName" );
		motFileCntrSzCdList = PRIUtil.getValueObject2StringArray((ArrayList<CodeInfo>)eventResponse.getCustomData("motFileCntrSzCdList"), false, "|", "\t", "getCode", "getName" );
		
	}catch(Exception e) {
		out.println(e.toString());
	}

	
%>

<script language="javascript">

	var motOrgBsePortCdValue = " |<%=motOrgBsePortCdList[0]%>";
	var motOrgBsePortCdText  = " |<%=motOrgBsePortCdList[1]%>";
	
	var motCntrTpCdValue = " |<%=motFileCntrTpCdList[0]%>";
	var motCntrTpCdText  = " |<%=motFileCntrTpCdList[1]%>";
	
	var motCmdtTpCdValue = " |<%=motFileCmdtTpCdList[0]%>";
	var motCmdtTpCdText  = " |<%=motFileCmdtTpCdList[1]%>";
	
	var motCntrSzCdValue = " |<%=motFileCntrSzCdList[0]%>";
	var motCntrSzCdText  = " |<%=motFileCntrSzCdList[1]%>";
	

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" id="f_cmd" name="f_cmd" />
<input type="hidden" id="pagerows" name="pagerows" />
<!-- 개발자 작업	-->

<input type="hidden" id="lane_list" name="lane_list" />
<input type="hidden" id="inq_tp_cd" name="inq_tp_cd" />
<input type="hidden" id="usr_id" name="usr_id" value="<%=strUsr_id%>" />
<input type="hidden" id="cfm_dt" name="cfm_dt" value="" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent"  type="button" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- -->
		<button class="btn_normal"  type="button" name="btn_new" 			id="btn_new">New</button><!-- -->
		<button class="btn_normal"  type="button" name="btn_save" 			id="btn_save">Save</button><!-- -->
		<button class="btn_normal"  type="button" name="btn_confirm" 		id="btn_confirm">Confirm</button><!-- -->
		<button class="btn_normal"  type="button" name="btn_confirmcancel" 	id="btn_confirmcancel">Confirm&nbsp;Cancel</button><!-- -->
		<button class="btn_normal"  type="button" name="btn_delete" 		id="btn_delete">Delete</button><!-- -->
		<button class="btn_normal"  type="button" name="btn_loadexcel" 		id="btn_loadexcel">Load Excel</button><!-- -->
		<button class="btn_normal"  type="button" name="btn_downexcel" 		id="btn_downexcel">Down Excel</button>
		
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100" />
					<col width="85" />
					<col width="100" />
					<col width="85" />
					<col width="95" />
					<col width="85" />
					<col width="80" />
					<col width="80" />
					<col width="90" />
					<col width="80" />
					<col width="80" />
					<col width="80" />
				</colgroup>
				<tbody>
				<tr class="h23">
					<th>Service Scope</th>
					<td colspan="3" style="padding-left:2px;">
					<script language="javascript">ComComboObject("svc_scp_cd", 2, 60, 0, 1);</script>&nbsp;
					<input type="text" class="input2" id="svc_scp_nm" name="svc_scp_nm" readonly caption="Service Scope" value="" /></td>
					<th>Effective Date</th>
					<td style="padding-left:2px;">
						<script language="javascript">ComComboObject("mot_trf_seq", 5, 90, 0, 1);</script>
						<input type="hidden" class="input1" id="eff_dt" name="eff_dt" required="" caption="Effective Date" value="" />
						<!-- <img src="img/btns_calendar.gif" class="cursor" id="btns_calendar" name="btns_calendar"  width="19" height="20" alt="" border="0" align="absmiddle" /> -->
						<button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
						<input type="text" id="eff_dt_hidden" name="eff_dt_hidden" value="" style="width:0;height:0" /></td>
					<th>File Date</th>
					<td style="padding-left:2px;"><input type="text" class="input1" id="file_dt" name="file_dt" caption="File Date" value="" maxlength="10" dataformat="ymd" /></td>
					<th>Confirmation</th>
					<td cstyle="padding-left:2px;" olspan="3" width="240" ><input type="text" class="input2" id="cfm_flg" name="cfm_flg" sreadonly caption="Confirmation" value="" /></td>
				</tr>

				<tr class="h23">
					<th>Lane Code</th>
					<td style="padding-left:2px;"><script language="javascript">ComComboObject("f_lane_cd", 2, 80, 0, 0);</script></td>
					<th>CNTR Type</th>
					<td style="padding-left:2px;"><script language="javascript">ComComboObject("f_cntr_tp_cd", 1, 80, 0, 0);</script></td>
					<th>CNTR Size</th>
					<td style="padding-left:2px;"><script language="javascript">ComComboObject("f_cntr_sz_cd", 1, 80, 0, 0);</script></td>
					<th>Cargo Type</th>
					<td style="padding-left:2px;"><script language="javascript">ComComboObject("f_cmdt_tp_cd", 1, 80, 0, 0);</script></td>
					<th>POL</th>
					<td style="padding-left:2px;"><script language="javascript">ComComboObject("f_org_cd", 1, 80, 0, 0);</script></td>
					<th>POD</th>
					<td style="padding-left:2px;"><script language="javascript">ComComboObject("f_dest_cd", 1, 80, 0, 0 );</script></td>
				</tr>
				</tbody>
			</table>
		</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid"  id="mainTable">	
		<div class="opus_design_btn">
		     	<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button><!-- 
			 --><button type="button" class="btn_normal"  name="btn_del" id="btn_del">Delete</button>
		</div>
		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>


				


<!-- 개발자 작업  끝 -->
</form>
