<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0104.jsp
*@FileTitle : (KOR) DOD Collection List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10
* 1.0 최초 생성 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event.EsdEas0104Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsdEas0104Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String mrd_path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1002.mrd";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc      = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc 	= account.getOfc_cd();
		
		event = (EsdEas0104Event)request.getAttribute("Event");
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
<title>(KOR) DOD Invoice Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<!-- 개발자 작업	-->


<!--input type="hidden" name="cust_cnt_cd"-->
<!--input type="hidden" name="cust_seq"-->
<!--input type="hidden" name="cust_cntc_pnt_seq"-->
<!--input type="hidden" name="cntc_pnt_nm"-->

<!--input type="hidden" name="inv_curr_cd" value="KRW"-->
<!--input type="hidden" name="dod_inv_sts_cd" value="I"-->
<input type="hidden" name="cre_ofc_cd" 	value="<%=strUsr_ofc%>">

<input type="hidden" name="mrd" value="<%=mrd_path%>">
<input type="hidden" name="rd_name" value="ESD_EAS_1002.mrd">
<input type="hidden" name="rd_parm">
<!-- input type="hidden" name="send_flg"-->
<!--input type="hidden" name="dod_inv_no"-->

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="DOD Collection List Print">
<input type="hidden" name="com_mrdBodyTitle" value="DOD Collection List Print">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
	<td valign="top">
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
					<td width="100">A/R I/F DATE</td>
				    <td width="250">
						<input type="text" style="width:80;text-align:center;" class="input1" size="8" maxlength="8"  onKeyPress='ComKeyOnlyNumber(window);' onKeyUp="pointAutoMove(this.value);" name="fm_ar_if_dt" required dataformat="ymd" required cofield="to_ar_if_dt" caption="start date">
						~&nbsp;<input type="text" style="width:80;text-align:center;" class="input1" size="8" maxlength="8" onKeyPress='ComKeyOnlyNumber(window);' name="to_ar_if_dt" required dataformat="ymd" required cofield="fm_ar_if_dt" caption="end date">
						<img src="img/btns_calendar.gif" align="absmiddle" class="cursor" name="btn_Calendar" width="19" height="20" alt="" border="0">
					</td>		
					<td width="85">INV OFC</td>
					<td width="90">
							<script language="javascript">ComComboObject('inv_ofc_cd',1,90,1,1);</script>
	                </td>				
							
					<td width="60">D.O LOC</td>
					<td width="90">
	                	<script language="javascript">ComComboObject('do_loc',1,90,1,0);</script>
	                </td>	
					<td width="90">POL Conti</td>
					<td width="90">
	                	<select style="width:80;" name="conti_cd">
	                        <option value="X" selected>ALL</option>
	                        <option value="M">AMERICA</option>
	                        <option value="A">ASIA</option>
	                        <option value="E">EUROPE</option>
	                    </select>
	                </td>	                				
					<!-- td width="170"><input type="text" style="width:100;text-align:left;" class="input1" name="do_loc" value="" dataformat="engup2" maxlength="5"></td-->

				</tr>

				<tr class="h23">
					<td>POR</td>
					<td><input type="text" name="por_cd" style="width:100;text-align:left;" class="input" dataformat="engup2" ></td>
					<td>POL</td>
					<td><input type="text" name="pol_cd" style="width:100;text-align:left;" class="input" dataformat="engup2"></td>				
					<td>POD</td>
					<td><input type="text" name="pod_cd" style="width:100;text-align:left;" class="input" dataformat="engup2"></td>
					<td>DEL</td>
					<td><input type="text" name="del_cd" style="width:100;text-align:left;" class="input" dataformat="engup2"></td>
 				</tr>

				</table>	
				<!-- biz_1  (E) -->		
			</td></tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>

		<table class="search"> 
			<tr><td class="bg" style="height:338" valign="top">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="grid2" id="mainTable"> 
				<tr>
					<td class="tr2_head2" width="35">D2	</td>
					<td width="30"><input type="text" name="d2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">D4	</td>
					<td width="30"><input type="text" name="d4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">D5</td>
					<td width="30"><input type="text" name="d5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">D7	</td>
					<td width="30"><input type="text" name="d7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">D8</td>
					<td width="30"><input type="text" name="d8" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">D9	</td>
					<td width="30"><input type="text" name="d9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">DW	</td>
					<td width="30"><input type="text" name="dw" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">DX	</td>
					<td width="30"><input type="text" name="dx" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">R2	</td>
					<td width="30"><input type="text" name="r2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">R4</td>
					<td width="30"><input type="text" name="r4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">R5	</td>
					<td width="30"><input type="text" name="r5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">F2	</td>
					<td width="30"><input type="text" name="f2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">F4	</td>
					<td width="30"><input type="text" name="f4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2" width="35">F5	</td>
					<td width="30"><input type="text" name="f5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
				<tr>
					<td class="tr2_head2">O2	</td>
					<td><input type="text" name="o2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2">O4		</td>
					<td><input type="text" name="o4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2">O5		</td>
					<td><input type="text" name="o5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2">S2	</td>
					<td><input type="text" name="s2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2">S4		</td>
					<td><input type="text" name="s4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2">T2</td>
					<td><input type="text" name="t2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2">T4		</td>
					<td><input type="text" name="t4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2">A2	</td>
					<td><input type="text" name="a2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2">A4		</td>
					<td><input type="text" name="a4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2">P2	</td>
					<td><input type="text" name="p2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2">P4	</td>
					<td><input type="text" name="p4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2">20'	</td>
					<td><input type="text" name="total20" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head2">40'		</td>
					<td><input type="text" name="total40" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td width=""class="tr2_head2"></td>
					<td width=""align="center" class="sm"></td>
					</tr>
				</table>				
				<table width="100%" class="button">
		       	<tr>
		       		
					<td class="grid2">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="search">
								<tr class="h23">
									<td style="width:105;text-align:right;">SUB TOTAL AMT</td>
									<td width="125"><input type="text" name="sum_bil_amt" style="width:110;text-align:right;" class="input2" readonly></td>
									<td style="width:105;text-align:right;" >VAT(TAX 10%)</td>
									<td width="125"><input type="text" name="sum_tax_amt" style="width:110;text-align:right;" class="input2" readonly></td>
									<td style="width:105;text-align:right;">TOTAL AMT</td>
									<td width="115"><input type="text" name="tot_amt" style="width:110;text-align:right;" class="input2" readonly></td>
									<td style="width:105;text-align:left;">KRW</td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
		    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
		
		<table class="height_8"><tr><td></td></tr></table>
		
		<!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_DownExcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_print">Print</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
		<!--Button (E) -->
		
		
	</td>
	</tr>
</table>

<div style="display:none;">
<!-- Grid  (S) -->
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table> 			
<!-- Grid (E) -->
</div>
<!------- Print용 Hidden RD Object Start -------->
<table>
<tr>
	<td height="1" width="1">
		<script language="javascript">comRdObject('rd_invoice');</script>
	</td>
</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html> 