<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0083.jsp
*@FileTitle  : Weekly L/F by POL/POD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0083Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0083Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	
		event = (EsmSpc0083Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		//out.println(e.toString());
		out.println("<!--"+e.toString()+"-->");
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->
<!-- 단축키 설정을 위한 변수 -->
<input type="hidden" name="uiname" value="ESM_SPC_0083" id="uiname" />
<input type="hidden" name="duration" value="" id="duration" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" 		id="btn_downexcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_bsa"  		id="btn_bsa">BSA Input</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->



<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="145"/>
					<col width="80"/>
					<col width="120"/>
					<col width="80"/>
					<col width="80"/>
					<col width="100"/>
					<col width="120"/>
					<col width="40"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Start Week</th>
					<td><select class="input1" name="year" id="year" style="width:80px;" onchange="checkWeek();"></select><select class="input1" name="week" id="week" style="width:60px;"></select></td>
					<th>Duration</th>
					<td><select class="input1" name="temp_duration" id="temp_duration" style="width:80px;" size="1"></td>
					<th>Trade</th>
					<td><script language="JavaScript">ComComboObject("trade", 2, 80, 0, 1);</script></td>
					<th>Sub Trade</th>
					<td><script language="JavaScript">ComComboObject("subtrade", 3, 80, 0, 0);</script></td>
					<th>Lane</th>
					<td><script language="JavaScript">ComComboObject("rlane_cd", 4, 80, 0, 0);</script></td>
				</tr>	
				<tr>
					<th>RHQ</th>
					<td>
						<select class="input1" name="rhq" id="rhq" style="width:145px;"><!--
							--><option value=""></option><!--
							--><option value="A">SHAAS, SINWA</option><!--
							--><option value="M">NYCNA</option><!--
							--><option value="E">HAMUR</option><!--
							--><option value="F">AFRICA</option><!--
							--><option value="O">OTHER</option><!--
						--></select>
					</td>
					<th>Bound</th>
					<td>
						<select name="bound" id="bound" style="width:80px;"></select>
					</td>
					<td><select class="input" name="polpod_flg" id="polpod_flg" style="width:80px;"><!--
							--><option value="POL">POL</option><!--
							--><option value="POD">POD</option><!--
						</select>
					</td>
					<td><input class="input" type="text" name="pol_cd" value="" maxlength="5" style="width:80px;" onkeypress="eventKeyChangeChar(UPPER_CASE);" id="pol_cd" /> </td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input class="input1" type="text" name="vvd" value="" maxlength="9" style="width:80px;" onkeypress="eventKeyChangeChar(UPPER_CASE);" id="vvd" /> </td>
					<th>Full &amp; Mty</th>
					<td>
						<select class="input" name="full_flg" id="full_flg" style="width:80px;"><!--
							--><option value=""></option><!--
							--><option value="S">Full+Mty</option><!--
							--><option value="F">Full</option><!--
						--></select>
					</td>
				</tr>
					
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->


<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<table>
			<tbody>
				<colgroup>
					<col width="120"/>
					<col width="120"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<td><input type="checkbox" value="" name="check_pol" checked="" class="trans" onclick="showPol(this);" id="check_pol" /> <span id="pol" name="pol">POL</span></td>
					<td><input type="checkbox" value="" name="check_pod" class="trans" onclick="showPod(this);" id="check_pod" /> <span id="pod" name="pod">POD</span></td>
					<td><input type="checkbox" value="" name="check_weight" class="trans" onclick="showWeight(this);" id="check_weight" /> <span id="pod"  name="pod">Weight</span></td>
				</tr> 
			</tbody>
		</table>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>
