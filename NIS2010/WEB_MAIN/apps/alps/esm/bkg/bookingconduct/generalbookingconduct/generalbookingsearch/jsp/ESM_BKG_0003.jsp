<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : esm_bkg_0003.jsp
*@FileTitle : Customer Advisory Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.29
*@LastModifier : 이인영
*@LastVersion : 1.0
*2011.06.29 이인영
*1.0 Creation
* ===============================================================================
* History
* 2012.03.22 변종건 [CHM-201216424-01] ALPS Customer Advisory 기능 보완 검토 요청 (Template 문서 첨부 등)
* 2013.02.19 김보배 [CHM-201322482] [BKG] 개발:Split 01-Customer Advisory 기능 추가 (BST Download)
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0003Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
    EsmBkg0003Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount = 0; 							//DB ResultSet 리스트의 건수

    String pageRows = "100";
    
    String strUsr_id = "";
    String strUsr_nm = "";
	String strOfc_cd = "";
	String strCnt_cd = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

        event = (EsmBkg0003Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    } catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Customer Advisory Set-up</title>
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
<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="ofc_cd" value="SELCMQ">
<input type="hidden" name="rmk_use_flg" value="Y">
<input type="hidden" name="sel_seq" value="">
<input type="hidden" name="dir_cd" value="">
<input type="hidden" name="search_clss_type" value="">
<input type="hidden" name="searchPopupParam" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
    
    <!--Page Title, Historical (S)-->
    <%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
      <!--Page Title, Historical (E)-->
      <!--biz page (S)-->
      <table class="search">
        <tr>
          <td class="bg"><!-- biz_1  (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="61" height="22">&nbsp;VVD</td>
                <td width="220"><input type="text" style="width:65;" class="input1" name="vvd" value="" maxlength="8"
                					caption="VVD"
                					style="ime-mode:disabled"
                					onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                					fullfill>&nbsp;
                					<input type="checkbox" name="e_dir_cd" style="border-style:none" value="E"> E
									<input type="checkbox" name="w_dir_cd" style="border-style:none" value="W"> W
									<input type="checkbox" name="s_dir_cd" style="border-style:none" value="S"> S
									<input type="checkbox" name="n_dir_cd" style="border-style:none" value="N"> N</option>                					
                </td>
                <td width="25">POR</td>
                <td width="50"><input type="text" style="width:50;" class="input" name="por_cd" value="" maxlength="5"
                					caption="POR"
                					style="ime-mode:disabled"
                					onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                					fullfill></td>
                <td width="25">POL</td>
                <td width="50"><input type="text" style="width:50;" class="input" name="pol_cd" value="" maxlength="5"
                					caption="POD"
                					style="ime-mode:disabled"
                					onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                					fullfill></td>
                <td width="25">POD</td>
                <td width="50"><input type="text" style="width:50;" class="input" name="pod_cd" value="" maxlength="5"
                					caption="POD"
                					style="ime-mode:disabled"
                					onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                					fullfill></td>
                <td width="25">DEL</td>
                <td width="50"><input type="text" style="width:50;" class="input" name="del_cd" value="" maxlength="5"
                					caption="DEL"
                					style="ime-mode:disabled"
                					onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                					fullfill></td>
                				<td width="210">	
                					<input type="checkbox" name="key_acct_flg" style="border-style:none" value="CC"> Core Cust&nbsp;
									<input type="checkbox" name="rgn_acct_flg" style="border-style:none" value="RC"> Regional Cust</option>    
									
									</td>       
              </tr>
              <tr class="h23">
                <td width="61">&nbsp;Customer</td>
                <td width="230">
                	<input type="text" style="width: 30;"
	                     class="input" value="" name="cust_cnt_cd"
	                     caption="Customer Code" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')"
						 size="2" maxlength="2" />&nbsp;<input type="text" style="width: 50;"
	                     class="input" value="" name="cust_seq" caption="Customer Code"
	                     maxlength="6" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(this)" />
                  <input type="text" style="width:130;" class="input2" value="" name="cust_nm"></td>
                <td colspan="2" width="95"  >Customer Type</td>
                <td colspan="2" width="100"><select name="bkg_cust_tp_cd" style="width:100;" class="input" disabled>
                    <option value="A" selected>All</option>
                    <option value="S">Shipper</option>
                    <option value="C">Consignee</option>
                    <option value="S">Notify</option>
                  </select></td>
                <td colspan="2" width="100" style="padding-left:20;">Source Type</td>
                <td colspan="2" width="80">
                	<script language="javascript">ComComboObject('src_dat_tp_cd', 1, 85, 1, 0);</script>
                </td>
               <td width="210">	
									<input type="checkbox" name="lcl_acct_flg" style="border-style:none" value="LC"> Local Cust</option>    
									
									</td>     
                <!-- <td colspan="2" width="90">&nbsp;</td> -->
                <!-- <td colspan="2" width="90">&nbsp;</td> -->
              
                
              </tr>
              <tr class="h23">
			  	<td width="77">Booking No.</td>
				<td width="130"><input type="text" name="bkg_no" style="ime-mode:disabled;width:100;" maxlength="13" dataformat="engupnum" value="" class="input">&nbsp;<img onClick="openAddPaste('bkg_no')" class="cursor" src="img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle" name=""></td>
			  	<td colspan="2" width="85">Container No.</td>
				<td colspan="2" width="130"><input type="text" name="cntr_no" style="ime-mode:disabled;width:100;" maxlength="13" dataformat="engupnum" value="" class="input">&nbsp;<img onClick="openAddPaste('cntr_no')" class="cursor" src="img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle" name=""></td>				
              </tr>
            </table>
       </table>

		<table class="height_8"><tr><td></td></tr></table>
	          
        <!-- Tab (S) -->
        <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%" >
        	<tr>
        		<td width="100%">
		        	<table width="100%"> 
			       	<tr><td class="btn2_bg" align="right">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
								<td><table width="75%" border="0" cellpadding="0" cellspacing="0" class="search">
								<tr class="h23"><td>TOTAL CNTR Count&nbsp;&nbsp;</td></tr>
								</table></td>
								<td><input type="text" style="width:40;text-align:right;" class="input2_red" value="0" name="total_cntr_cnt" readonly></td>
								<td>&nbsp;</td>

								<td><table width="75%" border="0" cellpadding="0" cellspacing="0" class="search">
								<tr class="h23"><td>= Excel Count&nbsp;&nbsp;</td></tr>
								</table></td>
								<td><input type="text" style="width:40;text-align:right;" class="input2_red" value="0" name="excel_cntr_cnt" readonly></td>
								<td>&nbsp;</td>

								<td><table width="75%" border="0" cellpadding="0" cellspacing="0" class="search">
								<tr class="h23"><td>+ BST Count&nbsp;&nbsp;</td></tr>
								</table></td>
								<td><input type="text" style="width:40;text-align:right;" class="input2_red" value="0" name="bst_cntr_cnt" readonly></td>
								<td>&nbsp;</td>
							</tr></table>
					</td></tr>
					</table>
				</td>
        	</tr>
            <tr>
            	<td width="100%">
                    <script language="javascript">ComTabObject('tab1')</script>
                </td>
            </tr>
        </table>
        <!-- Tab (E) -->
        
        <table class="search"><tr>   
            
            <!-- Grid  (S) -->
       		<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
					
            <!-- Grid (E) --></td>
            <table width="100%"  id="mainTable" style="display:none">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			
        </tr>
      </table>
      <!-- Tab BG Box(E) -->
      <!--biz page (E)-->
      <!-- Grid  (S) -->
      <table width="100%"  id="mainTable" style="display:none">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet3');</script>
			</td>
		</tr>
	  </table>
	  
	  <table width="100%"  id="mainTable" style="display:none">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet4');</script>
			</td>
		</tr>
	  </table>
      
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
        <tr>
          <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
				  <td><table width="72" border="0" cellpadding="0" cellspacing="0"
                          class="button">
                       <tr>
                           <td class="btn1_left"></td>
                           <td class="btn1" name="btn_fax">Fax</td>
                           <td class="btn1_right"></td>
                       </tr>
                  </table></td>
                  <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                       <tr>
                           <td class="btn1_left"></td>
                           <td class="btn1" name="btn_email">E-Mail</td>
                           <td class="btn1_right"></td>
                       </tr>
                   </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downExcel">Down  Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                   <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_uploadExcel">Excel  Upload</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                   <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_uploadDownload">BST Download</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                   <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                  <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_history">History</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                  <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                     <tr><td class="btn1_left"></td>
                         <td class="btn1" name="btn_template">Template</td>
                         <td class="btn1_right"></td>
                     </tr>
                 </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!--Button (E) --></td>
  </tr>
</table>
</form>
</body>
</html>
