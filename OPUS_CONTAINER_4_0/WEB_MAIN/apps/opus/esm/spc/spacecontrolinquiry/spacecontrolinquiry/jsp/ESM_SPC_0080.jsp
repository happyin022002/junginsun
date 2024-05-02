<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_SPC_0080.jsp
 *@FileTitle : Weekly L/F by Carrier
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0080Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0080Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0080Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" 			id="btn_downexcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel_data" 			id="btn_downexcel_data">Down Excel (Data)</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_bsa" 			id="btn_bsa">BSA Input</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="60" />
				<col width="150" />
				<col width="60" />
				<col width="100" />
				<col width="60" />
				<col width="100" />
				<col width="60" />
				<col width="100" />
				<col width="60" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Start Week</th>
				<td><!--
					--><select class="input1" name="year" id="year" style="width:60px;" onchange="checkWeek();"></select><!--
					--><select class="input1" name="week" id="week" style="width:50px;"></select>
				</td>
				<th>Duration</th>
				<td><!--
				--><select style="width: 60px" class="input1" name="duration" size="1"></select>
				</td>
				<th>Trade</th>
				<td><!--
				--><script type="text/javascript">ComComboObject("trade", 2, 60, 0, 1);</script>
				</td>
				<th>Sub Trade</th> <!-- 2010.09.16 이윤정  [CHM-201005916-01] Sub Trade 화면 조건 추가 -->
				<td><!--
				--><script type="text/javascript">ComComboObject("subtrade", 3, 60, 0, 0);</script>
				</td>
				<th>Lane</th>
				<td><!--
				--><script type="text/javascript">ComComboObject("rlane_cd", 4, 70, 0, 0);</script>
				</td>								
			</tr>
			<tr>
				<th>RHQ</th>
				<td><!--
				--><select class="input1" name="rhq"><!--
				--><option value=""></option><!--
				--><option value="A">SHAAS, SINWA</option><!--
				--><option value="M">NYCNA</option><!--
				--><option value="E">HAMUR</option><!--
				--><option value="F">AFRICA</option><!--
				--><option value="O">OTHER</option><!--
				--></select>
				</td>
				
				<th>Bound</th>
				<td><!--
				--><select style="width: 60px" name="bound"></select>
				</td>	
				<th>Carrier</th>
				<td><script type="text/javascript">ComComboObject('operator',1,60,0);</script></td>
				
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<h3 style="float: right;" id="sheetControlDiv" class=""><span style="line-height:2.5" class="pad_rgt_8">Unit : TEU</span><button name="maxi" id="maxi" sheetId="sheet1" onclick="toggleSheetSize();" type="button" class="btn_up"></button></h3>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display:none">
	<h3 style="float: right;">Unit : TEU<button name="maxi" id="maxi" sheetId="sheet1" onclick="toggleSheetSize();" type="button" class="btn_up"></button></h3>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
				
</form>