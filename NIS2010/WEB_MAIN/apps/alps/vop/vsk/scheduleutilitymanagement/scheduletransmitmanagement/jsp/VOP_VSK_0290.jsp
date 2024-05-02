<%/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : vop_vsk_0290.jsp
*@FileTitle : ETA sending(Auto FAX/TLX)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.06
*@LastModifier : 황태진
*@LastVersion : 1.0
* 2012.12.06 황태진 
* 1.0 Creation
* History
* 2012.12.20 CHM-201221649-01 황태진  ETA sending(Auto FAX/TLX) 정보 저장
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVsk0290Event"%>


<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>

<%
    VopVsk0290Event  	event 			= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 			serverException	= null;		//서버에서 발생한 에러
	
	String strErrMsg 		= "";					//에러메세지
	int rowCount	 		= 0;					//DB ResultSet 리스트의 건수
	
	String successFlag 		= "";
	String codeList  		= "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strUsr_eml		= "";

	Logger log 				= Logger.getLogger("com.hanjin.apps.scheduleutilitymanagement.scheduletransmitmanagement");

	String vsl_cd 			= null;
	String skd_voy_no 		= null;
	String skd_dir_cd		= null;
	String vps_port_cd		= null;
	String clpt_ind_seq 	= null;

	String yd_cd  			= null;
	String trsm_mzd_cd  	= "TLX";
	String trsm_mzd_chk  	= null;
	String trsm_ownr_cd		= "ALPS";
	String skd_trsm_sts_cd  = "SN"; 
	String yd_nm  			= null;
	String slan_cd  		= null;
	String vvd		  		= null;
	String vsl_eng_nm		= null;
	String act_crr_cd 		= null;
	String vps_eta_dt		= null;
	String vps_etb_dt		= null;
	String vps_etd_dt		= null;
	String ntc_eta_dt		= null;
	String ntc_etb_dt		= null;
	String ntc_etd_dt		= null;
	String vsl_fax_no  		= null;
	String vsl_tlx_no 	    = null;
	String vsl_eml			= null;
	String fax_imst_cd	 	= null;
	String tlx_imst_cd 		= null;
	String vsl_fax_trsm_eml = ""; 
	String vsl_tlx_trsm_eml = "";
	String sndr_eml 		= null;
	String fb_eml	 		= null;
	String lane_pic_eml		= null;

	String tmp_usrEml 		= "vessel-ops@smlines.com";
	
	String sndrNm			= null;
	String sndrPhnNo		= null;

	String ibflag = "";
	
	StringBuffer sbFbEml	= new StringBuffer();
	
	
	try {
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			vsl_cd 		 = JSPUtil.replaceForHTML(request.getParameter("vslCd"));
			vsl_cd  	 = vsl_cd==null?"":vsl_cd;

			skd_voy_no	 = JSPUtil.replaceForHTML(request.getParameter("skdVoyNo"));
			skd_voy_no   = skd_voy_no==null?"":skd_voy_no;
			
			skd_dir_cd   = JSPUtil.replaceForHTML(request.getParameter("skdDirCd"));
			skd_dir_cd   = skd_dir_cd==null?"":skd_dir_cd;
	
			vps_port_cd  = JSPUtil.replaceForHTML(request.getParameter("vpsPortCd"));
			vps_port_cd  = vps_port_cd==null?"":vps_port_cd;
			
			clpt_ind_seq = JSPUtil.replaceForHTML(request.getParameter("clptIndSeq"));
			clpt_ind_seq = clpt_ind_seq==null?"":clpt_ind_seq;
			
			yd_cd  	 	 = JSPUtil.replaceForHTML(request.getParameter("ydCd"));
			yd_cd  	 	 = yd_cd==null?"":yd_cd;
			yd_nm  	 	 = JSPUtil.replaceForHTML(request.getParameter("ydNm"));
			yd_nm  	 	 = yd_nm==null?"":yd_nm;

			slan_cd  	 = JSPUtil.replaceForHTML(request.getParameter("slanCd"));
			slan_cd  	 = slan_cd==null?"":slan_cd;
			
			vvd  	 	 = JSPUtil.replaceForHTML(request.getParameter("vvd"));
			vvd  	 	 = vvd==null?"":vvd;
			vsl_eng_nm   = JSPUtil.replaceForHTML(request.getParameter("vslEngNm"));
			vsl_eng_nm 	 = vsl_eng_nm==null?"":vsl_eng_nm;
	
			vps_eta_dt	 = JSPUtil.replaceForHTML(request.getParameter("vpsEtaDt"));
			vps_eta_dt 	 = vps_eta_dt==null?"":vps_eta_dt;

			ntc_eta_dt	 = JSPUtil.replaceForHTML(request.getParameter("ntcEtaDt"));
			ntc_eta_dt 	 = ntc_eta_dt==null?"":ntc_eta_dt;

			vps_etb_dt	 = JSPUtil.replaceForHTML(request.getParameter("vpsEtbDt"));
			vps_etb_dt 	 = vps_etb_dt==null?"":vps_etb_dt;
			
			ntc_etb_dt	 = JSPUtil.replaceForHTML(request.getParameter("ntcEtbDt"));
			ntc_etb_dt 	 = ntc_etb_dt==null?"":ntc_etb_dt;
			
			vps_etd_dt	 = JSPUtil.replaceForHTML(request.getParameter("vpsEtdDt"));
			vps_etd_dt 	 = vps_etd_dt==null?"":vps_etd_dt;			
		
			ntc_etd_dt	 = JSPUtil.replaceForHTML(request.getParameter("ntcEtdDt"));
			ntc_etd_dt 	 = ntc_etd_dt==null || ntc_etd_dt=="null"?"":ntc_etd_dt;
			
			act_crr_cd = JSPUtil.replaceForHTML(request.getParameter("actCrrCd"));
			act_crr_cd = act_crr_cd==null?"":act_crr_cd;
			
			vsl_fax_no	= JSPUtil.replaceForHTML(request.getParameter("vslFaxNo"));
			vsl_fax_no  = vsl_fax_no==null?"":vsl_fax_no;
			vsl_tlx_no  = JSPUtil.replaceForHTML(request.getParameter("vslTlxNo"));
			vsl_tlx_no  = vsl_tlx_no==null?"":vsl_tlx_no;
			
			vsl_eml     = JSPUtil.replaceForHTML(request.getParameter("vslEml"));
			vsl_eml     = vsl_eml==null?"":vsl_eml;
			
			fax_imst_cd = JSPUtil.replaceForHTML(request.getParameter("dfltFaxImstCd"));
			fax_imst_cd = fax_imst_cd==null?"870":fax_imst_cd;

			tlx_imst_cd = JSPUtil.replaceForHTML(request.getParameter("dfltTlxImstCd"));
			tlx_imst_cd = tlx_imst_cd==null?"":tlx_imst_cd;
			
			lane_pic_eml= JSPUtil.replaceForHTML(request.getParameter("landPicEml"));
			lane_pic_eml= lane_pic_eml==null?"":lane_pic_eml;	
			
			
		   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			strUsr_id  	= account.getUsr_id		();
			strUsr_nm  	= account.getUsr_nm		();
			strOfc_cd  	= account.getOfc_cd		();
			strUsr_eml 	= account.getUsr_eml	();
			strUsr_eml 	= strUsr_eml==null?"":strUsr_eml;
			sndr_eml   	= strUsr_eml;
			
			
			/////////////////////////////////////////////////////////////////////////////
			//::2014-04-18://
			//fb_eml     	= strUsr_eml;
			sbFbEml.append(strUsr_eml);
			
			if(lane_pic_eml != "" && lane_pic_eml != null && lane_pic_eml.length() > 0){
				//::2014-04-18://
				//fb_eml	= fb_eml + ";" + lane_pic_eml;
				
				sbFbEml.append(";");
				sbFbEml.append(lane_pic_eml);
			}
			
			fb_eml		= sbFbEml.toString();
			/////////////////////////////////////////////////////////////////////////////
			
			sndrNm		= account.getUsr_nm		();
			sndrPhnNo	= account.getXtn_phn_no	();
		
		event = (VopVsk0290Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}			
			
			
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>ETA sending(Auto TLX/FAX)</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="ibflag" 				value="<%=ibflag%>"				>
<input type="hidden" name="vsl_cd" 				value="<%=vsl_cd%>"				>
<input type="hidden" name="skd_voy_no" 			value="<%=skd_voy_no%>"			>
<input type="hidden" name="skd_dir_cd" 			value="<%=skd_dir_cd%>"			>
<input type="hidden" name="clpt_ind_seq" 		value="<%=clpt_ind_seq%>"		>
<input type="hidden" name="yd_cd" 				value="<%=yd_cd%>"				>
<input type="hidden" name="act_crr_cd" 			value="<%=act_crr_cd%>"			>
<input type="hidden" name="trsm_mzd_cd" 		value="<%=trsm_mzd_cd%>"		>
<input type="hidden" name="trsm_ownr_cd" 		value="<%=trsm_ownr_cd%>"		>
<input type="hidden" name="skd_trsm_sts_cd" 	value="<%=skd_trsm_sts_cd%>"	>
<input type="hidden" name="vsl_fax_trsm_eml" 	value="<%=vsl_fax_trsm_eml%>"	>
<input type="hidden" name="vsl_tlx_trsm_eml" 	value="<%=vsl_tlx_trsm_eml%>"	>
<input type="hidden" name="vsl_eml" 			value="<%=vsl_eml%>"			>
<input type="hidden" name="fax_imst_cd" 		value="<%=fax_imst_cd%>"		>
<input type="hidden" name="tlx_imst_cd" 		value="<%=tlx_imst_cd%>"		>
<input type="hidden" name="sndr_eml" 			value="<%=sndr_eml%>"			>

<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;ETA sending(Auto TLX/FAX)</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->

			<!-- : ( biz page ) (S) -->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:550;">
							<tr class="h23">
								<td width='200'></td>   
								<td> <input type="radio" class="trans" name="trsm_mzd_chk" value="" checked="checked">TELEX  
								     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								     <input type="radio" class="trans" name="trsm_mzd_chk" value=""  >FAX
								</td>
							</tr>
							<tr class="h23">
								<td>VVD</td>   
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2_red" maxlength=200 name="vvd" value="<%=vvd%>" tabindex="" readonly></td>
							</tr>							
							<tr class="h23">
								<td>Inmarsat</td>   
								<td> <script language="javascript">ComComboObject('imst_cd', 1, 425, 1, 1, 0, false);  </script> </td>
							</tr>
							<tr class="h23">
								<td>TELEX No</td>   
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2" maxlength=200 name="vsl_tlx_no" value="<%=vsl_tlx_no%>" tabindex="" readonly></td>
							</tr>
							<tr class="h23">
								<td>FAX No</td>   
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2" maxlength=200 name="vsl_fax_no" value="<%=vsl_fax_no%>" tabindex="" readonly></td>
							</tr>
							<tr class="h23">
								<td width="90">Port</td>   
								<td width=""><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2" readonly="readonly" maxlength=200 name="vps_port_cd" value="<%=vps_port_cd%>" tabindex="" readonly></td>
							</tr>
							<tr class="h23">
								<td>Terminal</td>   
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2" maxlength=200 name="yd_nm" value="<%=yd_nm%>"  tabindex="" readonly></td>
							</tr>
							<tr class="h23">
								<td>Lane</td>   
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2" maxlength=200 name="slan_cd" value="<%=slan_cd%>" tabindex="" readonly></td>
							</tr>
							<tr class="h23">
								<td>Vessel Name</td>   
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2" maxlength=200 name="vsl_eng_nm" value="<%=vsl_eng_nm%>" tabindex="" readonly></td>
							</tr>
							<tr class="h23">
								<td>Original ETA</td>   
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2" maxlength=200 name="vps_eta_dt" value="<%=vps_eta_dt%>" tabindex="" readonly></td>
							</tr>
							<tr class="h23">
								<td>Updated ETA</td>   
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2" maxlength=200 name="ntc_eta_dt" value="<%=ntc_eta_dt%>"  tabindex="" readonly></td>
							</tr>
							<tr class="h23">
								<td>Original ETB</td>   
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2" maxlength=200 name="vps_etb_dt" value="<%=vps_etb_dt%>"  tabindex="" readonly></td>
							</tr>
							<tr class="h23">
								<td>Updated ETB</td>   
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2" maxlength=200 name="ntc_etb_dt" value="<%=ntc_etb_dt%>" tabindex="" readonly></td>
							</tr>
							<tr class="h23">							
								<td>Original ETD</td>   
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2" maxlength=200 name="vps_etd_dt" value="<%=vps_etd_dt%>"  tabindex="" readonly></td>
							</tr>
							<tr class="h23">
								<td>Updated ETD</td>   
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input2" maxlength=200 name="ntc_etd_dt" value="<%=ntc_etd_dt%>" tabindex="" readonly></td>
							</tr>							
							<tr class="h23">
								<td>Reason</td>
								<td><textarea name="trsm_rsn" style="width:425;height:40;text-align:left;ime-mode:enabled;" class="input1" tabindex="1"></textarea>
								</td>
							</tr>
							
							<tr class="h23">
								<td>PIC(Sender) Name</td>
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input1" maxlength=100 name="sndr_nm" value="<%=sndrNm%>" tabindex="">
								</td>
							</tr>
							<tr class="h23">
								<td>Phone No.</td>
								<td><input type="text" style="width:425;text-align:left;ime-mode:disabled;" class="input1" maxlength=50 name="sndr_phn_no" value="<%=sndrPhnNo%>" tabindex="">
								</td>
							</tr>
														
						</table>
						<table class="search" border="0" style="width:550;">
							<tr class="h23">
								<td >E-mail address for vessel feed back</td>   
							</tr>
							<tr class="h23">
								<td><input type="text" style="width:550;text-align:left;ime-mode:enabled;" class="input1"  maxlength=500 name="fb_eml" value="<%=fb_eml%>" tabindex="2"></td>
							</tr>
							
						</table>

						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>
			<!-- : ( biz page ) (E) -->
			<table class="height_8"><tr><td></td></tr></table>

</td></tr>
</table> 
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
								<td>
									<table width="160" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_save">Auto TLX/FAX send</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="160" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
    <!--Button (E) -->
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
<div style="display:none;">
	<!-- Grid  (S) -->						
	<table width="100%" id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
	</table> 
	<!-- Grid (E) -->
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>