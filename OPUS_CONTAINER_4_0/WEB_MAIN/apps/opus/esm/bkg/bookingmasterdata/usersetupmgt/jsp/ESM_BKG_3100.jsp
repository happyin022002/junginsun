<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_3100.js
*@FileTitle  : Packing Instructions/Provisions (Creation)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList = "";
	
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CndManifestListDownload");
	String bl_esig_seq = "";	
	try {
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
	
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");
		
		log.debug("====================================");
		bl_esig_seq = StringUtil.xssFilter((String)request.getParameter("bl_esig_seq")) == null ? "":StringUtil.xssFilter((String)request.getParameter("bl_esig_seq"));
		log.debug("+++++++++++++ " + bl_esig_seq);
		log.debug("====================================");
	} catch (Exception e) {
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="act_flg">
<input type="hidden" name="bl_esig_seq" value="<%= bl_esig_seq %>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><img src="img/icon_title_dot.gif" align="absmiddle"> <span>eSignature Edit ( ESM_BKG_3100 )</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_save" 	id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_close"  id="btn_close">Close</button>	
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_grid clear" >
	<div class="opus_design_data wFit">
        <table height="350px">
           <colgroup>
               <col width="115px">
               <col width="300px">
               <col width="*">
           </colgroup>
           <tbody>
                <tr height="30px;">
                    <th>First Name</th>
                    <td><input type="text" name="esig_n1st_nm" style="width:300" value="" style="ime-mode:disabled" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" required></td>
                    <td></td>
                </tr>
                <tr height="30px;">
                    <th>Last Name</th>
                    <td><input type="text" name="esig_lst_nm" style="width:300" value="" style="ime-mode:disabled" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" required></td>
                    <td></td>
                </tr> 
                <tr height="30px;">
                    <th>Country</th>
                    <td><script type="text/javascript">ComComboObject('cnt_cd', 2, 80, 0, 1);</script></td>
                    <td></td>
                </tr>
                <tr height="30px;">
                    <th>Active Indicator</th>
                    <td><input type="checkbox" name="act_flg_chk" id="act_flg_chk" class="trans">&nbsp;&nbsp;</td>
                    <td></td>
                </tr>
                <tr height="30px;">
                    <th>Signature File</th>
                    <td style="padding-bottom:0px"><div style="width:300px"><script type="text/javascript">ComSheetObjectInput('sheet1');</script></div></td>
                    <td align="left"  style="padding-left: 10px;"><button type="button" class="btn_etc" name="btn_Sign_Fileadd" id="btn_Sign_Fileadd" >Add</button>
                        			<button type="button" class="btn_etc" name="btn_Sign_Filedelete" id="btn_Sign_Filedelete" style="display:none;">Del.</button>
                    </td>
                </tr> 
				<tr height="30px;">
					<th></th>
					<td colspan="2"><img id="img_Sign" name="img_Sign" style="display: none;" /></td>
				</tr> 
                <tr height="30px;">
                    <th>Initials File</th>
                    <td style="padding-bottom:0px"><div style="width:300px"><script type="text/javascript">ComSheetObjectInput('sheet2');</script></div></td>
                    <td align="left" style="padding-left: 10px;"> <button type="button" class="btn_etc" name="btn_Init_Fileadd" id="btn_Init_Fileadd" >Add</button>
                        			<button type="button" class="btn_etc" name="btn_Init_Filedelete" id="btn_Init_Filedelete" style="display:none;">Del.</button>
                    </td>
                </tr> 
				<tr>
					<th></th>
					<td colspan="2"><img id="img_Init" name="img_Init" style="display: none;" /></td>
				</tr>				                   
				<tr>
					<th>Notes<br>Maximum of <br>300 characters</th>
					<td colspan="2"><textarea style="width:100%; ime-mode:disabled;" name="esig_desc" id="esig_desc" cols="120" rows="8" class="noinput" maxlength="300"></textarea></td>
				</tr>                                                                              
            </tbody>
        </table>	
    </div>    
	</div>
	<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
</div>
<div class="wrap_result" style="display:none;">
<!-- opus_design_grid(E) -->
<!--IBUpload Component (S) -->
<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!--IBUpload Component (E) -->
<div id="hiddenLayer" style="display:none;">
	<script language="javascript">ComSheetObject('sheet3');</script>  
</div>
</div>

</form>
