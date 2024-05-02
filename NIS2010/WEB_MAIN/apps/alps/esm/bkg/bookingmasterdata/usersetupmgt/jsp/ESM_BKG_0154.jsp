<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0154.jsp
*@FileTitle : Client Default for Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2012.02.24 변종건 [CHM-201216228-01] ALPS COMMON USER INFORMATION 상 E-mail column을 BKG/DOC Client default 화면으로 이동
* 2012.12.03 김보배 [CHM-201221634] [BKG] Client Default for Booking 화면 보완
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0154Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.HTMLUtil" %>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	EsmBkg0154Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData.UserSetupMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EsmBkg0154Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//log.debug("===>>"+eventResponse.getEventName()); 
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Client Default for Booking</title>
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
<input type="hidden" name="screenName" value="<%=screenName %>">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">&nbsp; Client Default for Booking</span></td></tr>
		</table>
		
		<!--Page Title, Historical (E)-->

			
		<!-- : ( Grid ) (S) -->
		<table width="100%" class="search"  id="leftTable"> 
            <tr>
                <td width="120">
                	<script language="javascript">ComSheetObject('sheet1');</script>
            	</td>
        	</tr>
        </table>
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">
			
				<!--  biz_1  (S) -->
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="56">User ID</td>
							<td width="">
								<input type="text" style="width:80;" class="input2" value="<%=strUsr_id%>">&nbsp;
								<input type="text" style="width:200;" class="input2" value="<%=strUsr_nm%>">
							</td>
						</tr> 
					</table>				
				<!--  biz_1   (E) -->
				</td>
			</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">	
					<table class="search" border="0">
						<tr>
							<td class="title_h"></td>
							<td class="title_s">Booking Main</td>
						</tr>
						<tr>
							<td class="height_5"></td>
						</tr>
					</table>
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="95">Receiving Term</td>
							<td width="90" style="padding-left:2">
								<script language="javascript" >ComComboObject('rcv_term_cd', 2, 60, 1)</script>
							</td>
							<td width="90">Delivery Term</td>
							<td width="90">
								<script language="javascript" >ComComboObject('de_term_cd', 2, 50, 1)</script>
					<!--
								<select style="width:60;">
									<option value="0" selected>Y</option>
									<option value="1"></option>
								</select>
				-->			</td>
							<td width="100">Empty P/UP CY</td>
							<td width="90"><input type="text" name="mty_pkup_yd_cd" style="width:80;" class="input" value="" style="ime-mode:disabled" caption="Empty P/UP CY" maxlength="7"></td>
							
							<td width="90"></td>
							<td width="130"></td>
							
							<td width="90"></td>
							<td width="130"></td>
							
							<td width=""></td>
						</tr>
						<tr class="h23">
							<td width="">EQ TY/SZ</td>
							<td width=""><input type="text" name="cntr_tpsz_cd" style="width:58;" class="input" value="" style="ime-mode:disabled" caption="EQ TY/SZ" maxlength="4"></td>
							<td width="">Weight Unit</td>
							<td width="">
								<%=JSPUtil.getCodeCombo("wgt_ut_cd", "", "", "CD00775", 0, "")%>
							</td>	
							<td width="">Measure Unit</td>
							<td width="" style="padding-left:2">
								<%=JSPUtil.getCodeCombo("meas_ut_cd", "", "", "CD01116", 0, "")%>
							</td>
							
							<td width=""></td>
							<td width=""></td>
							
							<td width=""></td>
							<td width=""></td>
							
							<td width=""></td>
							
						</tr> 
						<tr class="h23">
							<td width="">Auto EDI Hold</td>
							<td width=""><input type="checkbox" name="auto_edi_hld_flg" value="" class="trans"></td>
							<td width="">Default Email</td>
							<td width="" colspan="3"><input type="text" name="dflt_eml" value="" style="width:270;" maxlength="200" class="input"></td>
							
							<td width="">&nbsp;&nbsp;&nbsp;Default Tel.</td>
							<td width=""><input type="text" name="dflt_phn_no" style="width:120;" class="input" value="" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(this,'-');"></td>
							
							<td width="">&nbsp;&nbsp;&nbsp;Default Fax</td>
							<td width=""><input type="text" name="dflt_fax_no" style="width:120;" class="input" value="" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(this,'-');"></td>
							
							<td width="">&nbsp;</td>
						</tr> 
					</table>	
			
					<!--DIV Booking Receipt Notice  (S) -->
					<div style="display:none">
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
					
					<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Booking Receipt Notice</td></tr>
						<tr><td class="height_5"></td></tr>
						</table>
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="280"><input type="checkbox" name="rtn_cct_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Cargo Cut-off (Return CY)</td>
							<td width="280"><input type="checkbox" name="tml_cct_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Cargo Cut-off (Terminal CY)</td>
							<td width="280"><input type="checkbox" name="doc_cct_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Documentation Cut-off Time</td>
							<td></td>
						</tr>
						<tr class="h23">
							<td width="280"><input type="checkbox" name="xpt_cstms_cct_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Export Customs Cut-off Time</td>
							<td width="280"><input type="checkbox" name="rail_cct_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Rail Cut-off Time</td>
							<td colspan="2"></td>
						</tr>
					</table>	
					</div>
					<!--DIV Booking Receipt Notice  (E) -->
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
					<!--DIV Draft B/L  (S) -->
					<div style="display:none">
					<table class="search" border="0">
						<tr>
							<td class="title_h"></td>
							<td class="title_s">Draft B/L</td>
						</tr>
						<tr>
							<td class="height_5"></td>
						</tr>
					</table>
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="280"><input type="checkbox" name="drft_bl_xch_rt_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Exchange Rate</td>
							<td width="280"><input type="checkbox" name="drft_bl_call_sgn_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Call Sign</td>
							<td width=""><!--<input type="checkbox" name="drft_bl_mrn_no_dp_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;MRN No-->
							</td>
						</tr> 	
						<tr class="h23">
							<td width="" colspan="3">Remark.
							<textarea name="drft_bl_rmk" cols="10" rows="3" style="width:375;" class=""></textarea></td>
						</tr>
					</table>
					
					
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
					</div>
					<!--DIV Draft B/L  (E) -->
			
					<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Arrival Notice</td></tr>
						<tr><td class="height_5"></td></tr>
					</table>
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width=""><input type="checkbox" name="an_prn_rt_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Display Collect Charge</td>
						</tr> 	
					</table>
					<table border="0" style="width:979; background-color:white;" class="grid2"> 
						<tr>
							<td>
								<textarea  name="an_rmk"  rows="2" style="width:100%"></textarea>
							</td>
						</tr>
					</table>
			
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
					<table class="search" border="0">
						<tr>
							<td class="title_h"></td>
							<td class="title_s">Receiving mail copy option</td></tr>
						<tr><td class="height_5"></td></tr>
					</table>
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="30">Booking : </td>
							<td width="200"><input type="checkbox" name="bkg_rct_ntc_rcv_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Booking Receipt Notice</td>
							<td width="200"><input type="checkbox" name="mty_rlse_ord_rcv_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Empty Release Order</td>
							<td width="200"><input type="checkbox" name="tro_ntc_rcv_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;TRO Notice</td>
							<td width="200"><input type="checkbox" name="vskd_dlay_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Schedule Delay (ETA)</td>
							<td></td>
						</tr>
							<tr class="h23">
							<td width="30">Document : </td>
							<td width="200"><input type="checkbox" name="drft_wbl_rcv_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Draft & Waybill</td>
							<td width="200"><input type="checkbox" name="srnd_ntc_rcv_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Surrender Notice</td>
							<td width="200"><input type="checkbox" name="an_rcv_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Arrival Notice</td>
							<td></td>
						</tr>
						<tr class="h23">
							<td width="30"> </td>
							<td width="200"><input type="checkbox" name="eur_cgor_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;EU Cargo Release</td>
							<td width="200"><input type="checkbox" name="fcntr_rlse_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Full Container Release</td>
							<td width="200"><input type="checkbox" name="smpl_si_flg" value="" class="trans">&nbsp;&nbsp;&nbsp;Simple S/I</td>
							<td width="200"></td>
							<td></td>
						</tr>
					</table>	
			
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="Notice">
						<tr class="h23">&nbsp;</tr>
						<tr class="h23"><td class="Notice"><img src="img/ico_star.gif" align="absmiddle"><span id="notice">&nbsp; To update Tel, Fax and E-Mail, please go to "Common -> Security -> User Information"</span></td></tr>
					</table>
				</td>
			</tr>
		</table>
		<!--biz page (E)-->
		
<!--Button (S) -->
		<table width="100%" class="button"  border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr>
       			<td class="btn1_bg">
		    		<table border="0" cellpadding="0" cellspacing="0">
		    			<tr>
							<td>
								<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_save">Save</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
    <!--Button (E) -->
		
	</td></tr>
		</table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>