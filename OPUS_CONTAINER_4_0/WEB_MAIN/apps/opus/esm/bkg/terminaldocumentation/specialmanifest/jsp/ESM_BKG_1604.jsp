<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1604.jsp
*@FileTitle : EU DG Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/11 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.SpecialReport");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
	StringBuffer fileDir = new StringBuffer();
	String home = System.getProperty("user.home");
	if (home !=null) fileDir.append(home);
	String separator = System.getProperty("file.separator");
	if (separator !=null) fileDir.append(separator);
	
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="usr_nm" value="<%=StringUtil.xssFilter(strUsr_nm)%>" id="usr_nm" />

<input type="hidden" name="in_out" id="in_out" />
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=StringUtil.xssFilter(fileDir.toString())%>" id="com_mrdSaveDialogDir" />
<input type="hidden" name="com_mrdSaveDialogFileName" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_listType" id="com_listType" />
<input type="hidden" name="com_mrdDisableToolbar" value="3" id="com_mrdDisableToolbar" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<input type="hidden" name="com_zoomIn" id="com_zoomIn" />
<input type="hidden" name="com_isBatch" value="N" id="com_isBatch" />

<input type="hidden" name="mrd_nm" id="mrd_nm" />
<input type="hidden" name="rd_param" id="rd_param" />
<input type="hidden" name="mrd_path" id="mrd_path" />
<input type="hidden" name="mrd_arguments" id="mrd_arguments" />
<input type="hidden" name="mrd_title" id="mrd_title" />
<input type="hidden" name="mrd_body_title" id="mrd_body_title" />
<input type="hidden" name="mrd_file_name" id="mrd_file_name" />
<input type="hidden" name="list_nm" id="list_nm" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">		
		<button type="button" class="btn_accent" name="btn_print" id="btn_print">Print</button><!--			
		--><button type="button" class="btn_accent" name="btn_email" id="btn_email">Email</button>
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
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">	    
	    <div clas="opus_design_inquiry">	       
	       <table class="sm mar_btm_4">
	       		<colgroup>
	       			<col width="40"/>
	       			<col width="120"/>
	       			<col width="40"/>
	       			<col width="90"/>
	       			<col width="40"/>
	       			<col width="90"/>
	       			<col width="40"/>
	       			<col width="*"/>
	       		</colgroup>
	       		<tbody>		
					<tr>
						<th>VVD</th>
						<td>
	                        <input type="text" name="vvd_cd" id="vvd_cd" value="" minLength="9" maxlength="9" class="input1" required dataformat="engup" style="width:120px;ime-mode:disabled">&nbsp;							
						</td>
						<th>POL (Transit Port)</th>
						<td>
	                        <input type="text" name="pol_cd" id="pol_cd" value="" minLength="5" maxlength="5" class="input" dataformat="engup" style="width:110px;ime-mode:disabled">&nbsp;							
						</td>
						<th>POD</th>
						<td>
	                        <input type="text" name="pod_cd" id="pod_cd" value="" minLength="5" maxlength="5" class="input" dataformat="engup" style="width:110px;ime-mode:disabled">&nbsp;							
						</td>
						<th>Cargo Operator</th>
						<td>
	                        <input type="text" name="crr_cd" id="crr_cd" value="" class="input" dataformat="engup" style="width:110px;ime-mode:disabled">&nbsp;							
						</td>
					</tr>		
					<tr>
						<th>List Type</th>
						<td><select name="list_type" id="list_type" class="input" style="width:120px;"><!--
								--><option value="L">Load</option><!--						
								--><option value="D">Discharge</option><!--
								--><option value="T">Transit</option><!-
								--><option value="B">On Board</option><!--
								--><option value="BE">On Board Excel</option><!--
								--><option value="SE">Summary Excel</option>
							  </select>
						</td>
						<th>Agents name</th>
						<td>
	                        <input type="text" name="agnt_name" id="agnt_name" value="" class="input" dataformat="engup" otherchar=" " style="width:220px;ime-mode:disabled">&nbsp;							
						</td> 
						<th>Masters Name</th>
						<td>
	                        <input type="text" name="mst_name" id="mst_name" value="" class="input" dataformat="engup" otherchar=" " style="width:220px;ime-mode:disabled">&nbsp;							
						</td>
						<th>eMail To</th>
						<td>
	                        <input type="text" name="email" id="email" value="" class="input" style="width:250px;ime-mode:disabled">&nbsp;							
						</td>
					</tr>					
				</tbody>
			</table>
			</div>
	    </div>
	</div>
	<!-- layout_wrap(e) -->	
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">		
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">		
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>

<form name="form2" id="form2">
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="vsl_cd" id="vsl_cd" />
	<input type="hidden" name="skd_voy_no" id="skd_voy_no" />
	<input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />
	<input type="hidden" name="pol_cd" id="pol_cd" />
	<input type="hidden" name="pod_cd" id="pod_cd" />
	<input type="hidden" name="pol_yd_cd" id="pol_yd_cd" />
	<input type="hidden" name="pod_yd_cd" id="pod_yd_cd" />
</form>

</form> 