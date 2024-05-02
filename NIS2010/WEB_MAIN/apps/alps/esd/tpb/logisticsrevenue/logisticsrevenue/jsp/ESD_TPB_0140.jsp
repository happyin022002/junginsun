<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0140.jsp
*@FileTitle : Logistics Revenue Registration - Multiple
*Open Issues :
*Change history :
*@LastModifyDate : 2015-03-10
*@LastModifier : Kim Hyun Ju
*@LastVersion : 1.2
* 2015-02-15  Kim Hyun Ju 			1.0	최초 생성
* 2015-03-10 [CHM-201534706] KIM HYUN HWA- Logistics(Operational) Revenue 에서 통화 관련 수정
=========================================================*/
%> 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.event.EsdTpb0140Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0140Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StatusInquiry.PerformanceInquiry");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	String currentDay2 = DateTime.getFormatString("yyyyMMdd");
	String s_state = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		ofc_cd = account.getOfc_cd();
		cnt_cd = account.getCnt_cd();

		event = (EsdTpb0140Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String p_month = "";
	p_month = DateTime.addMonths(currentDay, 0, "yyyy-MM-dd");
	
	if (p_month.length() > 7) {
		p_month = p_month.substring(0,4)+"-"+p_month.substring(5,7);
    }
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:RHQ Code / 3:HO Code
	String ofc_top_lvl = JSPUtil.getNull( TPBUtils.getOfficeTopLevel( ofc_cd ) );
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage();
		_text_ChangeUpperCase();
	}
</script>
</head>
<link href="css/alps_contents.css" rel="stylesheet" type="text/css">
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="s_usr_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input type="hidden" name="s_vndr_cust_div_cd">
<input type="hidden" name="s_usr_id" value="<%=strUsr_id%>" >
<input type="hidden" name="s_ofc_cd" value="">
<input type="hidden" name="s_rhq_cd" value="">
<input type="hidden" name="s_cnt_cd" value="">
<input type="hidden" name="val_flag" value="N">
<input type="hidden" name="c_date" value="<%=currentDay%>" >
<input type="hidden" name="s_sdate" value="<%=currentDay2%>" data_format="ymd" >
<input type="hidden" name="s_edate" value="<%=currentDay2%>" data_format="ymd" >


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
     		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
     		<%//@include file="/sys/common/menu/jsp/commonHeader.jsp"%>
      
      		<!--Page Title, Historical (E)-->
      

		 	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_new_t">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new" id="btn_new">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_save_t" >
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_save" id="btn_save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>      
			<!--biz page (S)-->
      
      		<table class="search">
        		<tr>
          			<td class="bg"><!-- biz_1  (S) -->
            			<table width="100%" border="0" class="search">
              				<tr class="h23">
                				<td class="title_h">&nbsp;</td>
                				<td class="title_s"> Multiple Case Registration and Confirmation for Korea Street Turn ONLY </td>
              				</tr>
            			</table>
            			<table class="height_5">
              				<tr>
                				<td></td>
              				</tr>
            			</table>
            
            			<table class="search" border="0" style="width:979;">
			            	<colgroup>
			              		<col width="90px" >
			              		<col width="160px" >
			              		<col width="90px" >
			              		<col width="200px" >
			              		<col width="120px" >
			              		<col width="" >
			              	</colgroup>
              				<tr class="h23">
                				<td>Interface Type</td>
                				<td>&nbsp;
                					<%=TPBUtils.getCodeCombo("s_n3pty_if_tp_cd", "", "style='width:125', class='input1'  onchange='changeExpenseType(this.form)' required caption='Interface Type'", "CD00581", 0, "0:R:Logistics Revenue", "X")%>
                				</td>
                
                				<td>Expense Type</td>
                				<td>
                  					<%=TPBUtils.getCodeCombo("s_n3pty_expn_tp_cd", "", "style='width:162'", "CD00580", 0, "001: :&lt;&lt;Select&gt;&gt;|", "")%>
                  				</td>
                				<td style="width:130;">Logistics Rev. Code</td>
                    			<td>
                    				<select class="input1" name="s_n3pty_bil_tp_cd" style="width:110;">
										<option value=''>&lt;&lt;Select&gt;&gt;</option> 
									</select>
								</td>
								<td>Yard</td>
			    				<td><input class="input" name="s_re_yd_cd" type="text" maxlength="7" tabindex="1" style="width:70"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_yd"></td>	              
              				</tr>
              				<tr class="h23">
                				<td> Cost Office</td>
                				<td>&nbsp;&nbsp;<script language="javascript">ComComboObject('s_if_ofc_cd',1,90,0,1);</script></td>
                				<td>Cost Period</td>
                				<td>
                					<table width="180px" border="0" class="search_sm2" style="margin-left:1px;">
	                    				<tr>
	                      					<td><input type="radio" class="trans" checked="checked" />Month  &nbsp;</td>
	                      					<td >&nbsp;
	                        					<input type="text" name="cost_month" maxlength="7" style="width:70;text-align:center" value="<%=p_month%>" data_format="ym" >
	                        					<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar">
	                        				</td>

	                    				</tr>
                					</table>
                				</td>
                				<td>Currency</td>
                				<td>
                					<select name="s_curr" class="input1" style="width:70px">
                    					<option value="KRW">KRW</option>
                    					<option value="USD">USD</option>
                    					<option value="EUR">EUR</option>
                  					</select>
                  				</td>
              				</tr>
            			</table>
            
						<div id='div_processing' name='div_processing' style='position: absolute; left: 0; top: 0; z-index: 100; display: none; width: 100%; height: 100%'>
						<table border='0' bordercolor='red' cellpadding='0' cellspacing='0' width='100%' height='100%'>
							<tr>
								<td align='center' height='10'>&nbsp;</td>
							</tr>
							<tr>
								<td align='center' height='100'><img
									src="/hanjin/img/alps/processing.gif"></td>
							</tr>
							<tr>
								<td align='center' height='*'>&nbsp;</td>
							</tr>
						</table>
						</div>            
 
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
				          
            			<table class="height_5">
              				<tr>
                				<td></td>
              				</tr>
            			</table>
            			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
              				<tr>
                				<td align="right" class="btn3_bg">
                					<table border="0" align="right" cellpadding="0" cellspacing="0">
                  						<tr>
                    						<td>
                    							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      								<tr>
                        								<td class="btn2_left"></td>
                        								<td class="btn2" id="Excel Upload2" name="btn_Load_Excel">Excel Upload </td>
                        								<td class="btn2_right"></td>
                      								</tr>
                    							</table>
											</td>
                    						<td width="3"></td>
                    						<td>
                    							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      								<tr>
                        								<td class="btn2_left"></td>
                        								<td class="btn2" id="Validate S/P No.2" name="btn_val_sp">Validate S/P No.</td>
                        								<td class="btn2_right"></td>
                      								</tr>
                    							</table>
                    						</td>
                    						<td width="3"></td>
                    						<td>
                    							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      								<tr>
                        								<td class="btn2_left"></td>
                        								<td class="btn2" id="ARow dd2" name="btn_add">Row Add</td>
                        								<td class="btn2_right"></td>
                      								</tr>
                    							</table>
                    						</td>
                    						<td width="3">&nbsp;</td>
                    						<td>
                    							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      								<tr>
                        								<td class="btn2_left"></td>
                        								<td class="btn2" id="btn_Simulation" name="btn_delete">Delete</td>
                        								<td class="btn2_right"></td>
                      								</tr>
                    							</table>
                    						</td>
                  						</tr>
                					</table>
                				</td>
              				</tr>
            			</table>
            		</td>
        		</tr>
      		</table>
      		<table class="height_5">
        		<tr>
          			<td></td>
        		</tr>
      		</table>

      		<!--biz page (E)-->
      	</td>
 	</tr>
</table>
<table class="height_5">
 	<tr>
   		<td></td>
 	</tr>
</table>

</body>
</html>