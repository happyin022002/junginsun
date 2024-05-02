<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0007.jsp
*@FileTitle  : Formula & Condition Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String strBtnList = "";//json
	
	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortTariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		strBtnList = (String)eventResponse.getCustomData("BTNLIST");
		//if(firstList!=null)
		//	log.debug("firstList size :=" + firstList.size());

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var btnObjects = [];
	<%=strBtnList%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		//alert(btnObjects);
		loadPage();
	}
</script>

<!-- <body  onLoad="setupPage();" onClick="setFocusIBsheet();" > -->

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value="<%=strUsr_id %>" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->

	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
			<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button>
			<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>						
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
<div class="opus_design_inquiry wFit">	
	<table style="width:979px;"> 
		<tbody>
			<col width="20" />
            <col width="120" />
            <col width="" />
			<tr>
				<th>ID</th>
				<td><input onKeyDown="ComKeyEnter();" onclick="setFlag('0');" name="txtid" dataformat="num" type="text"  maxlength="10" style="width:80px;text-align:center;" class="input1" value=""><button type="button" class="input_seach_btn" name="btn_foml_cond" id="btn_foml_cond">
				</td>
				<td>
					<table class="search sm" border="0" style="width:160px;"> 
						<tr class="h23">
							<td><input onclick="setFlag('1');" name="radioflag" type="radio" value="1" class="trans" checked>Formula&nbsp;&nbsp;&nbsp;<input onclick="setFlag('2');" name="radioflag" type="radio" value="2" class="trans">Condition</td>
						</tr>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<div class="opus_design_inquiry">
	<table class="line_bluedot"><tr><td></td></tr></table>
	<table style="width:100%;">
		<tbody>
			<col width="120" />
			<col width="755" />
	        <col width="60" />			
			<tr>
				<td><h3 class="title_design">Formula</h3></td>
				<td></td>
				<td align="right">
					<button type="button" class="btn_etc align_center" name="btn_Subject_Favorites" id="btn_Subject_Favorites">Subject Favorites</button>											
			    </td>					
			</tr>
		</tbody>				
	</table>
</div>

<div class="opus_design_inquiry wFit" id="btnList">
	<table class="search_sm2" border="0" width="100%" >
	<tr class="h23">
		<td width="60" rowspan="2" valign="top">Subject </td>
	</tr>
	</table>
</div>

</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >	
		<!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->								
				<button type="button" class="btn_normal" name="btng_Row_Add" id="btng_Row_Add">Row Add</button>
				<button type="button" class="btn_normal" name="btng_Row_Delete" id="btng_Row_Delete">Row Delete</button>
				<button type="button" class="btn_normal" name="btng_Cell_Add" id="btng_Cell_Add">Cell Add</button>
				<button type="button" class="btn_normal" name="btng_Cell_Delete" id="btng_Cell_Delete">Cell Delete</button>				
		    </div>
	    <!-- opus_design_btn(E) -->										
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->	
	</div>
	<div class="opus_design_inquiry wFit">
	<table style="width:979px;"> 
		<tr>
			<td width="100%">
				<div id="dspXpr" style="background-color:white;padding:4px 8px 4px 8px;" onclick="setFlag('0');"></div>
			</td>
		</tr>
	</table>
	</div>
	<!-- opus_design_grid(E) -->
	<input type="button" name="dscTbl" id="dscTbl" style="width:1px;height:1px;display:none;" onclick="javascript:showDscTbl();" />
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="sysDscTbl" style="display:none">										
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->					
	</div>
	<!-- opus_design_grid(E) -->
	<table class="line_bluedot"><tr><td></td></tr></table>
</div>

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table style="width:979px;" >
			<tbody>
				<col width="60" />
				<col width="60" />
				<col width="60" />
				<col width="60" />
				<col width="60" />
				<col width="60" />
				<col width="60" />
				<col width="60" />
				<col width="60" />
				<col width="60" />
				<col width="60" />
		        <col width="*" />
				<tr>
					<th style="vertical-align: top;" rowspan="2">Operator</th>
					<!-- * / + - [START] -->
					<td>
						<button type="button" style="width:100%" class="btn_etc align_center" name="btn2_*" id="btn2_*" >X</button>
					</td>
					<td>
						<button type="button" style="width:100%" class="btn_etc align_center" name="btn2_/" id="btn2_/" >/</button>
					</td>
					<td>
						<button type="button" style="width:100%" class="btn_etc align_center" name="btn2_+" id="btn2_+" >+</button>									
					</td>
					<td>
						<button type="button" style="width:100%" class="btn_etc align_center" name="btn2_-" id="btn2_-" >-</button>									
					</td>
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_(" id="btn3_(" >(</button>								
					</td>
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_)" id="btn3_)" >)</button>
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- * / + - [END] -->
				</tr>
				<tr id="oprpanel" style="display:none">
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_And" id="btn3_And" >And</button>									
					</td>
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_Or" id="btn3_Or" >Or</button>									
					</td>
					<!-- IN [START] -->
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_IN" id="btn3_IN" >IN</button>									
					</td>
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_NOT IN" id="btn3_NOT IN" >NOT IN</button>									
					</td>
					<!-- IN [END] -->
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_>" id="btn3_>" >></button>									
					</td>
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_>=" id="btn3_>=" >>=</button>									
					</td>
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_c1" id="btn3_c1" >&lt;</button>								
					</td>								
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_<=" id="btn3_<=" >&lt;=</button>									
					</td>
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_=" id="btn3_=" >=</button>									
					</td>
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_!=" id="btn3_!=" >!=</button>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table id="consTbl" style="display:none" style="width:979px">
			<tbody>
				<col width="60" />
				<col width="60" />
				<col width="60" />
		        <col width="*" />
				<tr>
					<th valign="top" rowspan="2">Constant</th>
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_Y" id="btn3_Y" >Y</button>
					</td>
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_N" id="btn3_N" >N</button>									
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table width="979px">
			<tbody>
				<col width="60" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
		        <col width="*" />
				<tr>
					<th valign="top" rowspan="2">Function</th>
					<td>
						<button type="button" style="width:100%" class="btn_etc align_center" name="btn2_RoundUp" id="btn2_RoundUp" >RoundUp</button>									
					</td>
					<td>
						<button type="button" style="width:100%" class="btn_etc align_center" name="btn2_RoundDown" id="btn2_RoundDown" >RoundDown</button>
					</td>
					<td>
						<button type="button" style="width:100%" class="btn_etc align_center" name="btn2_Round" id="btn2_Round" >Round</button>								
					</td>
					<td>
						<button type="button" style="width:100%" class="btn_etc align_center" name="btn2_MAX" id="btn2_MAX" >MAX</button>								
					</td>
					<td onClick="showAddFuncs(this);" style="cursor:pointer;">▼</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<table id="additonalFuncs" style="display:none;" width="979px">
			<tbody>
				<col width="60px" />
				<col width="100px" />
				<col width="100px" />
				<col width="100px" />
				<col width="100px" />
				<col width="100px" />
				<col width="100px" />
		        <col width="*" />
			    <tr>
			    	<td>&nbsp;</td>
					<td>
						<button type="button" style="width:100%" class="btn_etc align_center" name="btn2_Other1" id="btn2_Other1" >Other1</button>									
					</td>
					<td>
						<button type="button" style="width:100%" class="btn_etc align_center" name="btn2_Other2" id="btn2_Other2" >Other2</button>									
					</td>
					<td>
						<button type="button" style="width:100%" class="btn_etc align_center" name="btn2_Other3" id="btn2_Other3" >Other3</button>									
					</td>
					<td>
						<button type="button" style="width:100%" class="btn_etc align_center" name="btn2_Other4" id="btn2_Other4" >Other4</button>
					</td>
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_Other5" id="btn3_Other5" >Other5</button>
					</td>
					<td>
						<button type="button" style="width:99%" class="btn_etc align_center" name="btn3_Other6" id="btn3_Other6" >Other6</button>
					</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<textarea id="txtDebug" style="display:none;width:1024px;height:300px;"></textarea>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none;">										
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->					
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>