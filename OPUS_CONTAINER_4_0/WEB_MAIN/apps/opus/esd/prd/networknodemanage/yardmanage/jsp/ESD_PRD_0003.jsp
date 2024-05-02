<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0003.jsp
*@FileTitle : Lease Company Yard Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.event.EsdPrd0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdPrd0003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RnllwsTest.Yardmanage");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsdPrd0003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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


<form name="form" id="form">
<input	type="hidden" name="f_cmd" id="f_cmd">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title"></span>
			</button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
				--><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button>
		    </div>
		    <!-- opus_design_btn(E) -->
	    
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	
	</div>
	<!-- page_title_area(E) -->
	
	<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="60px" />
	            <col width="130px" />
	            <col width="100px" />
	            <col width="130px" />
	            <col width="100px" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr class="h23">
					<th>Country</th>
					<td>
						<input type="text" maxlength="2" name="country_code" caption="Country" value="" style="width:37px"  tabIndex="1" dataformat="engup"><button type="button" class="input_seach_btn" name="btn_cnt" id="btn_cnt"></button>
					</td>
					<th>Location</th>
					<td>
						<input type="text" name="location_code" maxlength="5" value="" style="width:70px;text-align:center"  tabIndex="2" dataformat="engup" style="text-align:center"><button type="button" class="input_seach_btn" name="loc_btn" id="loc_btn"></button>
					</td>
					<th>Yard</th>
					<td>
						<input type="text" name="node_code" maxlength="7" value="" style="width:70px;text-align:center" tabIndex="3" dataformat="engup" style="text-align:center">
					</td>
				</tr>
				
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
	</div>
	
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
		    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
		<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    				<table>
							<tr>
								<th width="150" style="text-align:left"><h3 class="title_design">Basic Information</h3></th>
								<td width="60" class="stm">Yard Code</td>
								<td width="250"><input name="yard_code" type="text" style="width:200px" value=""  class="input2" readonly ></td>
								<th width="220" style="text-align:left"><h3 class="title_design">Lease Company Information</h3></th>
								<td width="60" class="stm">Lease Com1</td>
								<td width="*"><input name="com_code1" type="text" style="width:70px" value=""  class="input2" readonly >&nbsp;
								<input name="com_name1" type="text" style="width:130px" value=""  class="input2" readonly ></td>
							</tr>
							<tr><td></td>
								<td class="stm">Yard Name</td>
								<td><input name="yard_name" type="text" style="width:200px" value=""  class="input2" readonly ></td>
								<td></td>
								<td class="stm">Lease Com2</td>
								<td><input name="com_code2" type="text" style="width:70px" value=""  class="input2" readonly >&nbsp;
								<input name="com_name2" type="text" style="width:130px" value=""  class="input2" readonly ></td>
							</tr>
							<tr><td></td>
								<td class="stm">Address</td>
								<td><input name="address" type="text" style="width:200px" value=""  class="input2" readonly ></td>
								<td></td>
								<td class="stm">Lease Com3</td>
								<td><input name="com_code3" type="text" style="width:70px" value=""  class="input2" readonly >&nbsp;
								<input name="com_name3" type="text" style="width:130px" value=""  class="input2" readonly ></td>
							</tr>
							<tr><td></td>
								<td class="stm">PIC</td>
								<td><input name="pic" type="text" style="width:200px" value=""  class="input2" readonly ></td>
								<td></td>
								<td class="stm">Lease Com4</td>
								<td><input name="com_code4" type="text" style="width:70px" value=""  class="input2" readonly >&nbsp;
								<input name="com_name4" type="text" style="width:130px" value=""  class="input2" readonly ></td>
							</tr>
							<tr><td></td>
								<td class="stm">TEL</td>
								<td><input name="tel" type="text" style="width:200px" value=""  class="input2" readonly ></td>
								<td></td>
								<td class="stm">Lease Com5</td>
								<td><input name="com_code5" type="text" style="width:70px" value="" class="input2" readonly >&nbsp;
								<input name="com_name5" type="text" style="width:130px" value=""  class="input2" readonly ></td>
							</tr>
							<tr><td></td>
								<td class="stm">FAX</td>
								<td><input name="fax" type="text" style="width:200px" value=""  class="input2" readonly ></td>
								<td></td>
								<td class="stm">Lease Com6</td>
								<td><input name="com_code6" type="text" style="width:70px" value="" class="input2" readonly >&nbsp;
								<input name="com_name6" type="text" style="width:130px" value=""  class="input2" readonly ></td>
							</tr>
							<tr><td></td>
								<td class="stm">E-mail</td>
								<td><input name="e_mail" type="text" style="width:200px" value=""  class="input2" readonly ></td>
								<td></td>
								<td class="stm">Lease Com7</td>
								<td><input name="com_code7" type="text" style="width:70px" value="" class="input2" readonly >&nbsp;
								<input name="com_name7" type="text" style="width:130px" value=""  class="input2" readonly ></td>
							</tr>
							<tr><td></td>
								<td class="stm"></td>
								<td></td>
								<td></td>
								<td class="stm">Lease Com8</td>
								<td><input name="com_code8" type="text" style="width:70px" value="" class="input2" readonly >&nbsp;
								<input name="com_name8" type="text" style="width:130px" value=""  class="input2" readonly ></td>
							</tr>
							<tr><td></td>
								<td class="stm"></td>
								<td></td>
								<td></td>
								<td class="stm">Lease Com9</td>
								<td><input name="com_code9" type="text" style="width:70px" value="" class="input2" readonly >&nbsp;
								<input name="com_name9" type="text" style="width:130px" value=""  class="input2" readonly ></td>
							</tr>
							<tr><td></td>
								<td class="stm"></td>
								<td></td>
								<td></td>
								<td class="stm">Lease Com10</td>
								<td><input name="com_code10" type="text" style="width:70px" value="" class="input2" readonly >&nbsp;
								<input name="com_name10" type="text" style="width:130px" value=""  class="input2" readonly ></td>
							</tr>
						</table>
				
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
	</div>
</form>