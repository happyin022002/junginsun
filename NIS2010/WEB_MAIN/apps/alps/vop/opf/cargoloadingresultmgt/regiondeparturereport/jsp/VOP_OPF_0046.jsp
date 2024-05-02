<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_OPF_0046.jsp
*@FileTitle : RDR Creation – Main
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.03 장강철
* 1.0 Creation
* ---------------------------------------------------------------
* History
* 2011.06.29 이준범 [CHM-201111792-01]
* 제 목 : Cargo Handling Performance + RDR CREATION 화면 보완
* 내 용 : 1)Cargo Handling Performance - region Check 로직삭제
*       2) RDR CREATION - Region 선택 칼럼 삭제 요하며, Port 칼럼은 해당 VVD의 Turning port및 Normal Port check하여
*                      해당 Port의 Region의 last Port만 Select Box로 표시될수 있도록 처리
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf0046Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0046Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml       = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.RegionDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strUsr_eml = account.getUsr_eml();

		event = (VopOpf0046Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head SERVERIP="<%=request.getLocalAddr() %>">
<title>RDR Creation – Main</title  >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="call_ind2">
<!-- 개발자 작업	-->
<input type="hidden" name="flagRetrieveYn" value ="N">
 

<!-- 리포트 팝업 관련 항목 -->
<input type="hidden" size="200" name="com_mrdPath" value="apps/alps/vop/opf/cargoloadingresultmgt/regiondeparturereport/report/VOP_OPF_0145.mrd">
<input type="hidden" size="200" name="com_mrdArguments">
<input type="hidden" size="200" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\">
<input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="RegionalDepartureReport">
<input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" size="200" name="com_mrdDisableToolbar">
<input type="hidden" size="200" name="com_mrdTitle" value="Regional Departure Report">
<input type="hidden" size="200" name="com_mrdBodyTitle" value="<span style=&quot;color:red&quot;>Regional Departure Report</span>">
<input type="hidden" size="200" name="com_isBatch" value="Y">



<input type="hidden" name="subFrameid">
<input type="hidden" name="subFrameSrc">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
    <!--Page Title, Historical (E)-->

    <!--biz page (S)-->
        <table class="search">
        <tr><td class="bg">
                <!-- biz_1  (S) -->
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="50">VVD CD</td>
                    <td width="180">
                        <input type="text" style="width:40;" class="input1" name="vsl_cd" caption="Vessel Code" maxlength="4" required fullfill dataformat="engup" style="ime-mode:disabled">
                        <input type="text" style="width:38;" class="input1" name="voy_no" caption="Schedule Voyage Number" maxlength="4" required fullfill dataformat="engup" style="ime-mode:disabled">
                        <input type="text" style="width:22;" class="input1" name="dir_cd" caption="Schedule Direction Code" maxlength="1" required fullfill  dataformat="engup" style="ime-mode:disabled">
                    &nbsp;<img src="img/btns_search.gif"   width="19" height="20" alt="" border="0" align="absmiddle" name='btns_searchVvd' class="cursor"><input type="text" style="width:0;" name="noname"></td>
                    <td width="30">Port</td>
                    <td width="460">
                        <script language="javascript">ComComboObject('port_cd', 4, 100, 0, 1, 0);</script>&nbsp;<input type="text" style="width:300;" class="input2" readonly name="port_cd_nm">&nbsp;
                    </td>
                    <td width="45">Region</td>
                    <td width="138"><script language="javascript">ComComboObject('region',2,120,0,1,1);</script></td>                    
                    <td width="" align="right"><input type="text" style="width:120;" class="input2" name="sys_create_desc" value="" readonly class="input2"></td>
                </tr>
                </table>
            </td>
         </tr>
         </table>
   <!-- biz_1  (E) -->
 

    <!-- Tab (S) -->
    <table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
    <tr>
          <td width="100%">
                <script language="javascript">ComTabObject('tab1')</script>
          </td>
    </tr>
    </table>
    <!-- Tab (E) -->

<!-- TAB [ VSL Mvmt ] (S) -->
<div id="tabLayer" style="display:inline">
    <iframe name="ifrVslMvmt" id="ifrVslMvmt" frameborder="0" scrolling="no" width="100%" height="460"></iframe>
</div>
<!-- TAB [ VSL Mvmt ] (E) -->

<!-- TAB [ Slot/WGT Util ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="ifrSlotWgtUtil" id="ifrSlotWgtUtil" src="" frameborder="0" scrolling="no" width="100%" height="460"></iframe>
</div>
 
<!-- TAB [ Slot/WGT Util ] (E) -->
 
<!-- TAB [ HC/45' ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="ifrHc45" id="ifrHc45" frameborder="0" src=""  scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ HC/45' ] (E) -->


<!-- TAB [ RF ] (S) Other Logic-->
<div id="tabLayer" style="display:none">
    <iframe name="ifrRf" id="ifrRf" frameborder="0"  src="" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ RF ] (E) -->
 
<!-- TAB [ VSL Alloc. ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="ifrVslAlloc" id="ifrVslAlloc" frameborder="0"  src=""  scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ VSL Alloc. ] (E) -->

 
<!-- TAB [ Remark ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="ifrRemark" id="ifrRemark" frameborder="0" scrolling="no"  src=""  width="100%" height="450"></iframe>
</div>
<!-- TAB [ Remark ] (E) -->
    <table width="100%"  id="mainTable" style='display:none'>
        <tr>
            <td width="100%" >
                <script language="javascript">ComSheetObject('sheet1');</script>
            </td>
        </tr>
    </table>
    <table width="100%"  id="mainTable" style='display:none'>
        <tr>
            <td width="100%">
                <script language="javascript">ComSheetObject('sheet2');</script>
            </td>
        </tr>
    </table>  
    <!--biz page (E)-->
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;display:inline;" id="btnTblRDR">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New" id="btn_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1_1" name="btn_Delete" auth='c' id='btn_Delete'>Delete</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1_1" name="btn_Save"  auth='c'  id="btn_Save" >Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td style='display:none' class="btn1_line"></td>
                <td style='display:none'><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Print">Print</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
    </td></tr>
</table> 

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>