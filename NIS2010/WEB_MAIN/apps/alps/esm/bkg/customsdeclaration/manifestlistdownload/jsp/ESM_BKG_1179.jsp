<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1179.jsp
*@FileTitle : Manual BDR
*Open Issues :
*Change history :
*@LastModifyDate : * 2014.06.02
*@LastModifier : 신규정
*@LastVersion : 1.0
* 2014.06.02 신규정
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1179Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsCustomsStatusNoticeVO"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%
 	EsmBkg1179Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String hndl_ofc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData.BookingMasterMgt");
	
	List<UsCustomsStatusNoticeVO> list = null;
	String hndlOfcCd  = "";
	String autoSndFlg  = "";
	String hndlOfcAddr  = "";
	String hndlOfcEml  = "";
	String cstmsNtcMsg1r = "";
	String cstmsNtcMsg1s = "";
	UsCustomsStatusNoticeVO vo = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
 		event = (EsmBkg1179Event)request.getAttribute("Event");
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
<title>Customs Status Notice Set-Up</title>
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
<input type="hidden" name="pagerows">
<input type="hidden" name="hndl_ofc_cd" value="" >
<input type="hidden" name="frm_auto_snd_flg" value="Y" ><!-- 기본값 -->
<input type="hidden" name="frm_ntc_msg_tp_cd_1r" value="1R" ><!-- 기본값 -->
<input type="hidden" name="frm_ntc_msg_tp_cd_1s" value="" >

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
                <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle" /><span id="navigation"></span></td></tr>
                <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" /><span id="title"></span></td></tr>
            </table>
		<!--Page Title, Historical (E)-->
	
					<!--  biz_1  (S) -->
            <!-- Grid BG Box  (S) -->        
            <table class="search"> 
                <tr>
                    <td class="bg">
                        <!--  biz_1 (S) -->
						<table class="search" border="0"  style="width:100%;">  
							<tr class="h23">
								<td width="320">
									<table>
										<tr class="h23">
											<td width="100">Handling Office</td>
											<td width="120"><input type="text" name="frm_hndl_ofc_cd" style="width:80;" class="input1" value="PHXSA" style="ime-mode:disabled; text-transform:uppercase;" dataformat="uppernum" caption="Handling Office" maxlength="6" fullfill></td>
											
											
										</tr>
									</table>
                        <!--  biz_1   (E) -->       
                    
                        <table class="line_bluedot" style="width:979;"><tr><td></td></tr></table>
                            
                        <!--  biz_2 (S) -->
                        <table class="search_sm2" border="0" style="width:509;"> 
                            <tr class="h23">
								<td width="100">Auto Send</td>
								<td width="">
								<input type="radio" name="frm_auto_snd_flg_radio" value="Y" class="trans" checked>&nbsp;&nbsp;Yes&nbsp;&nbsp;&nbsp;
								<input type="radio" name="frm_auto_snd_flg_radio" value="N" class="trans">&nbsp;&nbsp;No</td>
                            </tr>
                        </table>
                        <!--  biz_2  (E) -->    
                        
                        <table class="height_8" ><tr><td></td></tr></table>  
                        
                        <table class="grid2" border="0" style="width:979;"> 
                            <tr class="tr2_head">
                                <td width="100%" align="left"> &nbsp;Address</td>
                            </tr>
                            <tr>
                                <td><input type="text" style="width:100%;" class="noinput" name="frm_hndl_ofc_addr" format="" maxlength="200" /></td>
                            </tr>
                        </table>

                        <table class="height_8"><tr><td></td></tr></table>  

                        <table class="grid2" border="0" style="width:979;"> 
                            <tr class="tr2_head"><td width="100%" align="left"> &nbsp;From</td></tr>
                            <tr>
                                <td><input type="text" style="width:100%;" class="noinput" name="frm_hndl_ofc_eml" format="" maxlength="200" /></td>
                            </tr>
                        </table>

                        <table class="height_8"><tr><td></td></tr></table>
                        

						<!-- Tab (S) -->
						<table class="tab" border="0" style="width:979;"> 
							<tr class="h23">
								<td>
									<script language="javascript">ComTabObject("tab1")</script>
								</td>
							</tr>
						</table>
						<!-- Tab (E) -->                        


						<!-- biz_2 (S) -->
						<!-- Tab_Layer_1 (S) -->
						<div id="tabLayer" style="width:979;display:inline">
							<table class="search">
								<tr>
									<td class="bg">
										<table class="grid2" border="0" style="width:100%;">
											<tr class="tr2_head">
												<td><textarea style="width:100%; ime-mode:disabled;"  rows="10" dataformat="etc" maxlength="3000" name="frm_cstms_ntc_msg_1r" value="" ></textarea></td>
											</tr>
										</table>
								</td></tr>
							</table>
						</div>
						<!-- Tab_Layer_1 (E) -->
			
			
						<!-- Tab_Layer_2 (S) -->
						<div id="tabLayer" style="width:979;display:none">
							<table class="search">
								<tr>
									<td class="bg">
										<table class="grid2" border="0" style="width:100%;">
											<tr class="tr2_head">
												<td><textarea style="width:100%; ime-mode:disabled;" rows="10" dataformat="etc" maxlength="3000" name="frm_cstms_ntc_msg_1s" value=""></textarea></td>
											</tr>
										</table>
								</td></tr>
							</table>
						</div>
						<!-- Tab_Layer_2 (E) -->
						

                        <table class="height_8"><tr><td></td></tr></table>
						
						<!-- Button (S) -->
						<table class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;width:979;">
							<tr>
								<td class="btn1_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left">
														<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
														<td class="btn1_right">
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left">
														<td class="btn1" name="btn_save" id="btn_save">Save</td>
														<td class="btn1_right">
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- Button (E) -->
			
                    </td>
                </tr>
            </table>




		</td>
	</tr>
</table>

<!--Grid (s)-->
<table width="100%"  id="mainTable">
    <tr>
        <td width="100%">
            <script language="javascript">ComSheetObject('sheet1');</script>
        </td>
    </tr>
</table>
 <!--Grid (E)-->


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>
				
			