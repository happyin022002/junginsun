<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0011.jsp
*@FileTitle : VSL OPR's Restriction on DG (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.14
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.14 장강철 jkc
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg0011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DangerousCargoRestriction.CarrierRestriction");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0011Event)request.getAttribute("Event");
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
<head>
<title>VSL OPR's Restriction on DG (Inquiry)</title>
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

<input type="hidden" name="eventFile" value="true">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
 
<!-- 개발자 작업	-->
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
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="120">UN No./Seq.</td>
                    <td width="" colspan="5">&nbsp;<input type="text" style="width:60;" name='imdg_un_no' fullfill class="input1" required maxlength='4' style="ime-mode:disabled"   caption='UN No.'  value="" >&nbsp;<input type="text" style="width:19;"  name='imdg_un_no_seq' class="input1"  caption='UN No./Seq.' maxlength='2'   minlength='1' required   value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name='srch_imdg_un_no' align="absmiddle">&nbsp;<input type="text" style="width:760;" readonly class="input2" name='prp_shp_nm' value=""></td>
                </tr>
                <tr class="h23">
                    <td>Class</td>
                    <td width="" colspan="5">&nbsp;<input type="text" style="width:60;" class="input2"  readonly name='imdg_clss_cd' value="">&nbsp;<input type="text" style="width:806;" class="input2"  name='imdg_clss_cd_desc'  readonly value=""></td>
                </tr>
                <tr class="h23">
                    <td>POL</td>
                    <td width="180">&nbsp;<input type="text" style="width:60;" class="input1" value="" fullfill required  dataformat="engup"  style="ime-mode:disabled" caption='POL'   maxlength=5 name='pol_port_cd'>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name='srch_pol_port_cd' align="absmiddle">&nbsp;<script language="javascript">ComComboObject('pol_port_rotn_seq', 1, 40, 1, 1, 1);</script></td>
                    <td width="30">POD</td>
                    <td width="180">&nbsp;<input type="text" style="width:60;" class="input1" value="" fullfill required   dataformat="engup"  style="ime-mode:disabled" caption='POD'   maxlength=5  name='pod_port_cd'>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name='srch_pod_port_cd' align="absmiddle">&nbsp;<script language="javascript">ComComboObject('pod_port_rotn_seq', 1, 40, 1, 1, 1);</script></td>
                    <td width="80">Target Lane</td>
                    <td width="500">&nbsp;<script language="javascript">ComComboObject('slan_cd', 2, 67, 2, 1,0);</script>&nbsp;</td>
                </tr>
                </table>
                <!--  biz_1   (E) -->
                </td></tr>
            </table>
            <table class="height_8"><tr><td></td></tr></table>
            <table class="search"> 
        <tr><td class="bg">
            <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Vessel Operator’s Restrictions on DG</td></tr>
                <tr><td class="height_5"></td></tr>
            </table>
             <!-- Grid  (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
            <!-- Grid (E) -->
 
			<table height="15"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr>
					<td class="title_h" valign="middle"></td>
					<td style="padding-left:4;">
						<!--  Button_Sub (S) -->
						<table width="150" class="middle"> 
					       	<tr>
					       		<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="srch_irregulars_list" id="srch_irregulars_list">Irregulars List</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>																		
										</tr>
									</table>
								</td>
							</tr>
						</table>
				    	<!-- Button_Sub (E) -->
				    </td>
				</tr>
				<tr><td class="height_5"></td></tr>
			</table>            
            
            
            <table class="height_8"><tr><td></td></tr></table>  
            
            
            <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Port Restrictions En-route</td></tr>
              
            </table>
            
            <!-- Grid  (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet3');</script>
                        </td>
                    </tr>
                </table>                
            <!-- Grid (E) -->
            
            </td></tr>
            </table>
            </td></tr>
        </table>
    <!-- Grid BG Box  (S) -->
    <!--biz page (E)-->
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 

        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New"  id="btn_New">New</td>
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