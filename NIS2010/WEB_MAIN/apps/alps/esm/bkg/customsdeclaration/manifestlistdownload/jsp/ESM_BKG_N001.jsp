<%/*=========================================================
*Copyright(c) 2017 SMLines
*@FileName : ESM_BKG_N001.jsp
*@FileTitle : Customs Data Download
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 1.0 Creation
*
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkgN001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkgN001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "50";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String strOfc_cd        = "";
    String strPgmNo         = "";
    String strCustoms       = "";
    String customsCd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
	   
	   
		event = (EsmBkgN001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			   strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
		
		vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
		polCd  = JSPUtil.getParameter(request, "pol_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Customs Data Download</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="total" value="0">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="customs" value="<%=strCustoms%>">
<input type="hidden" name="sheet_id">
<input type="hidden" name="v_pol">
<input type="hidden" name="v_pod">
<input type="hidden" name="pageNo" value="<%=strPgmNo%>">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">Customs Data Download</span></td></tr>
        </table>
    <!--Page Title, Historical (E)-->
    
    
    <!--biz page (S)-->
        <table class="search">
        <tr><td class="bg">
        
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                   <td width="40">VVD</td>
                   <td width="120"><input type="text" style="width:90; ime-mode: disabled;" class="input1" 
                   dataformat="eng" name="vvd" maxlength="9" fullfill caption="VVD" required value="<%=vvdCd%>"></td> 
                   <td width="25">POL</td>
                   <td width="100"><input type="text" style="width:50; ime-mode: disabled;" value="<%=polCd%>" class="input1"
                   dataformat="engupnum" name="pol_cd" maxlength="5" fullfill caption="POL" "required"></td> 
                   <td width="20">POD</td>
                   <td width="100"><input type="text" style="width:50; ime-mode: disabled;" value="<%=podCd%>" class="input"
                   dataformat="engupnum" name="pod_cd" maxlength="5" fullfill caption="POD" ></td> 
                   
					<td width="20"></td>
	                <td width="390"></td> 
	                      
	                <td width="80">Cargo Type</td>
	                <td width="81"><select name="bkg_cgo_tp_cd" style="width:80">
					                <option>All</option>
					                <option value="F" selected>Full</option>
					                <option value="P">Empty</option>
					                </select>
	            	</td>
                </tr>
                </table>
    
                <!-- Grid  (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <!-- 상단 그리드 -->
                            <script language="javascript">ComSheetObject('sheet0');</script>
                        </td>
                    </tr>
                </table> 
            
                <table class="height_8"><tr><td></td></tr></table>
            
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td>
			                <table class="search" border="0" style="width:;"> 
			                <tr>
			                    <td>
			                    &nbsp;M.B/L <input type="text" name="mbl_tot" style="width:40;" readonly class="input2"> + 
			                    &nbsp;H.B/L <input type="text" name="hbl_tot" style="width:40;" readonly class="input2"> =
			                    &nbsp;Target B/L TTL <input type="text" name="bl_ttl" style="width:40;" readonly class="input2">
			                    </td>
			                    </tr>
			                </table>
			            </td>
                    </tr>
                    <tr>
                        <td width="100%">
                            <!-- 하단 그리드 -->
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table> 
                <!-- Grid (E) -->
            </td></tr>
        </table>
<div style="display:none">
    <!-- BackEndJob 상태 확인시 사용  -->
	<script language="javascript">ComSheetObject('sheet3');</script>
	<!-- Terminal EDI 호출 시 사용하는 CntrNo 리스트  -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- Data Download 시 서버에 전송할 데이터 리스트  
    <script language="javascript">ComSheetObject('sheet4');</script> -->
	<!-- Terminal EDI 호출 시 사용하는 CntrNo 리스트  -->
    <script language="javascript">ComSheetObject('sheet4');</script>    
</div>    
        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_datadl">Data Download</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
                <td>
	                <table class="search" border="0" style="width:;"> 
	                <tr>
	                    <td width="120">&nbsp;Selected B/L Count :</td>
	                    <td width="45"><input type="text" name="selected" style="width:40;" readonly class="input2"></td> 
	                    </tr>
	                </table>
                </td>
                
            </tr>
            </table>
        </td></tr>
        </table>
        <!--Button (E) -->
        
    <!--biz page (E)-->
    </td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>