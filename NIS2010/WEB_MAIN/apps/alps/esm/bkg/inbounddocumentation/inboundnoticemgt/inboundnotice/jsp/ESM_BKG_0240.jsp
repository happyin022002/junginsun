<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0240.jsp
*@FileTitle : Integrated Customer Data Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.05.21 박성호
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0240Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0240Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd    = "";
	String strCnt_cd ="";

	String req_cust_cnt_cd = "";
	String req_cust_seq = "";

	String autoSearchFlg = "";

	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.ArrivalNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();
		
		if("US".equals(strCnt_cd)){
			
			//strOfc_cd ="PHXSC"; // 2015.08.03 한진그룹 코드 표준화
			strOfc_cd ="PHXSA";
		}

		req_cust_cnt_cd = JSPUtil.getNull(request.getParameter("cust_cnt_cd"));
		req_cust_seq = JSPUtil.getNull(request.getParameter("cust_seq"));
		autoSearchFlg = JSPUtil.getNull(request.getParameter("autoSearchFlg"));

		event = (EsmBkg0240Event)request.getAttribute("Event");
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
        <title>Customer Master Data</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script language="javascript">
            var autoSearchFlg = "<%=autoSearchFlg%>";
            var sessOfcCd = "<%=strOfc_cd%>";
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
            <input name="f_cmd" type="hidden" />
            <input name="pagerows" type="hidden" />
            <input name="login_ofc_cd" type="hidden" value="<%=strOfc_cd%>"/>
            <!-- 개발자 작업	-->

          <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

                        <!--Button (S) -->
                        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-bottom:2;"> 
                            <tr><td class="btn1_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table></td>
                                            <td class="btn1_line"></td>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                            </table></td>
                                            <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button" id="inq">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_Save">Save</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table></td>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="t1btn_SettingAN">Setup&nbsp;A/N</td>
                                                        <td class="btn1_right"></td>

                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </td></tr>
                        </table>
                        <!--Button (E) -->
                        <!--biz page (S)-->
                        <table class="search"> 
                            <tr>
                                <td class="bg">

                                    <!--  biz_1  (S) -->
                                    <table class="search" border="0" style="width:979;"> 
                                        <tr class="h23">
                                            <td width="210">
                                                <table class="search_sm2" border="0">
                                                    <tr class="h23">
                                                        <td width="120" nowrap><input type="radio" value="" class="trans" name="sel_radio" onClick="fncSelRadioChange()" checked>Customer Code</td>
                                                        <td width="" nowrap><input type="text" style="width:30;ime-mode:disabled;" class="input1" value="<%=req_cust_cnt_cd %>" name="cust_cnt_cd" maxlength="2" onKeyPress="ComKeyOnlyAlphabet('upper');" onKeyDown="ComKeyEnter(this)" fullfill required="true"
                                                                                   onClick="form.sel_radio[0].checked=true;fncSelRadioChange()">&nbsp;<input type="text" style="width:50;" class="input1" value="<%=req_cust_seq %>" name="cust_seq" dataformat="int" maxlength="6" onBlur="fncCustSeqBlur(this)" onKeyDown="ComKeyEnter(this)" style="ime-mode:disabled" required="true" onKeyPress="ComKeyOnlyNumber(this)" onClick="form.sel_radio[0].checked=true;fncSelRadioChange()"></td>  								
                                                    </tr>
                                                </table>
                                            </td>
                                            <td width="10">
                                            <td width="260">
                                                <table class="search_sm2" border="0" style="width:270;">
                                                    <tr class="h23">
                                                        <td width="120" nowrap><input type="radio" value="" class="trans"  name="sel_radio" onClick="fncSelRadioChange()">Country Code</td>
                                                        <td>&nbsp;<input type="text" style="width:30;ime-mode:disabled;" class="input" value="" name="cust_cnt_cd_ext" maxlength="2" dataformat="engup" onClick="form.sel_radio[1].checked=true;fncSelRadioChange()" onKeyPress="ComKeyOnlyAlphabet('upper','32')" onKeyDown="ComKeyEnter(this)"></input></td>
                                                        <td width="250" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;Customer Name&nbsp;&nbsp;<input type="text" style="width:120;ime-mode:disabled" class="input1" name="cust_lgl_eng_nm" onKeyPress="ComKeyOnlyAlphabet('uppernum','32|38|43|45|46')" value="" onClick="form.sel_radio[1].checked=true;fncSelRadioChange()" onKeyDown="ComKeyEnter(this)" minlength="2"></td>        
                                                        <td width="50"><input type="checkbox" name="include" Style="border-style:none">
                                                        <td width="60">Inclusive </td>
					 						                                                                                                    
                                                    </tr>
                                                </table>
                                            </td>
                                            <td width="50">No Use </td>
					 						<td width="30"><input type="checkbox" name="no_use" Style="border-style:none">
					 						<td width="80">Financial Risk </td>
					        				<td width="20"><input type="checkbox" name="bklst"  Style="border-style:none" checked>
<!--                                             <td width="80">Exceeding Credit Limit </td> -->
<!-- 					        				<td width="20"><input type="checkbox" name="cre_limit"  Style="border-style:none"> -->
                                             </tr>
                                                </table>
                                            <table class="search" border="0" style="width:979;"> 
                                        <tr class="h23">
                                            <!-- City 조건 삭제 2009.06.02-->
                                            <td width="10">
                                            <td width="55">S/Office</td>
                                            <td width="80"><input type="text" style="width:70;" class="input" value="" name="ofc_cd" dataformat='engup' onKeyDown="ComKeyEnter(this)"></td>
                                            <td width="27">City</td>
										    <td width="95"><input type="text" style="width:80;" class="input" name="cty_nm" dataformat='address' maxlength='10' style="ime-mode:disabled" value="" onKeyDown="ComKeyEnter(this)"></td> 
                                            <td width="30">State</td>
                                            <td width="50"><input type="text" style="width:40;" class="input" value="" name="ste_cd" dataformat='engup' maxlength='3' style="ime-mode:disabled" onKeyDown="ComKeyEnter(this)"></td>
                                            <td width="55">Zip Code</td>
											<td width="81"><input type="text" style="width:60;" class="input"  name="zip_cd" dataformat='zipcode' maxlength='10' style="ime-mode:disabled" value="" onKeyDown="ComKeyEnter(this)"></td>
											 <td width="40" colspan="3"> </td> 
											  <td width="150">Exceeding Credit Limit </td> 
				        					<td width="20"><input type="checkbox" name="cre_limit"  Style="border-style:none">
				        					<td>&nbsp;</td>

                                           
                                             <!-- <td width="45">Status</td> 2012.10.26 CSR : CHM-201220902-->
                                             <!-- <td><select style="width:80;" name="cust_sts_cd" onKeyDown="ComKeyEnter(this)">-->

                                                     <!-- <option value="A" selected>Active</option>-->
                                                     <!-- <option value="I">Inactive</option>-->
                                                     <!-- <option value="P">Pending</option>-->
                                                     <!-- <option value="D">Deleted</option>-->
                                                     <!-- <option value="M">Merged</option>-->
                                                 <!--</select></td>-->
                                        </tr>
                                    </table>
                                    <!--  biz_1   (E) -->

                                    <table class="line_bluedot"><tr><td></td></tr></table>

                                    <table class="search" border="0">
                                        <tr><td class="title_h"></td>
                                            <td class="title_s">Customer Main (MDM)</td></tr>
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

                                </td></tr>
                        </table>
                        <table class="height_8"><tr><td></td></tr></table>
                        <!-- Tab ) (S) -->
                        <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
                            <tr><td width="100%">
                                    <script language="javascript">ComTabObject('tab1')</script>
                                    <!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
                                </td></tr>
                        </table>
                        <!-- Tab ) (E) -->



                        <!--TAB I/B (S) -->

                        <div id="tabLayer" style="display:inline">

                            <!-- Grid BG Box  (S) -->
                            <table class="search" >
                                <tr>
                                    <td class="bg">


                                        <table class="search" border="0" style="width:979;"> 
                                            <tr class="h23">
                                                <td width="">
                                                    <!--  biz_2  (S) -->
                                                    <table class="search_sm2" border="0"> 
                                                        <tr class="h23">										
                                                            <td width="60">Customer</td>
                                                            <td width="240">
                                                                <input type="text" style="width:30;" class="input2" value="" name="cust_cnt_cd_ib" readonly>
                                                                <input type="text" style="width:60;" class="input2" value="" name="cust_seq_ib" readonly>
                                                                <input type="text" style="width:130;" class="input2" value="" name="cust_lgl_eng_nm_ib" readonly>
                                                            </td>	
                                                            <td width="35">Office</td> 
                                                            <td width="55">
                                                                <input type="text" style="width:50;" class="input1" value="" name="ofc_cd_ib" onKeyPress="ComKeyOnlyAlphabet('upper');" onKeyDown="ComKeyEnter('fncSearchIb')" maxlength="6">
                                                            </td>
                                                            <td width=""align="right" valign="center"><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    <tr><td class="btn2_left"></td>
                                                                        <td class="btn2" name="btn_Retrieve_Ib">Retrieve</td>
                                                                        <td class="btn2_right"></td>
                                                                    </tr>
                                                                </table></td>
                                                        </tr>
                                                    </table>
                                                </td>
                                                <td>
                                                    <table width="100%" class=""> 
                                                        <tr><td class="btn2_bg">
                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                    <tr>
                                                                        <td>
                                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn2_left"></td>
                                                                                    <td class="btn2" name="btn_FullUpdatedHistory">Full Updated History</td>
                                                                                    <td class="btn2_right"></td>
                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                        <td>
                                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn2_left"></td>
                                                                                    <td class="btn2" name="btn_CustomersClearanceType">Customer's&nbsp;Clearance&nbsp;Type</td>
                                                                                    <td class="btn2_right"></td>
                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                        <td>
                                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn2_left"></td>
                                                                                    <td class="btn2" name="btn_ConcernedParty" id="btn_ConcernedParty">Multi-Contact</td>
                                                                                    <td class="btn2_right"></td>
                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                        <%
                                                                        /*
                                                                         2015.10.19 메뉴로 등록
                                                                        %>
                                                                        <td>
                                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                                <tr><td class="btn2_left"></td>
                                                                                    <td class="btn2" name="btn_UpdateSetup" id="btn_UpdateSetup">Setup</td>
                                                                                    <td class="btn2_right"></td>
                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                        <%
                                                                        */
                                                                        %>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </td>
                                            </tr>
                                        </table>


                                        <!--  biz_2  (E) -->
                                        <table class="height_5"><tr><td colspan="8"></td></tr></table>
                                        <!-- Grid  (S) -->
                                        <table width="100%"  id="mainTable">
                                            <tr>
                                                <td width="100%">
                                                    <script language="javascript">ComSheetObject('t1sheet');</script>
                                                </td>
                                            </tr>
                                        </table>
                                        <!-- Grid (E) -->
                                    </td>
                                </tr>
                            </table>		

                            <!-- Grid BG Box  (S) -->

                        </div>

                        <!--TAB I/B (E) -->

                        <!--TAB O/B (S) -->

                        <div id="tabLayer" style="display:none">
                            <!-- Grid BG Box  (S) -->
                            <table class="search" id="mainTable">
                                <tr><td class="bg">
                                        <!--  biz_2  (S) -->
                                        <table class="search" border="0"> 
                                            <tr class="h23">
                                                <td width="70">Customer</td>
                                                <td  width=""><input type="text" style="width:30;" class="input2" value="" name="cust_cnt_cd_ob">&nbsp;<input type="text" style="width:60;" class="input2" value="" name="cust_seq_ob">&nbsp;<input type="text" style="width:150;" class="input2" value="" name="cust_lgl_eng_nm_ob"></td>


                                            </tr>
                                        </table>


                                        <!--  biz_2  (E) -->
                                        <table class="height_2"><tr><td colspan="8"></td></tr></table>
                                        <!-- Grid  (S) -->

                                        <table width="100%"  id="mainTable">
                                            <tr>
                                                <td width="100%">
                                                    <script language="javascript">ComSheetObject('t2sheet');</script>
                                                </td>
                                            </tr>
                                        </table>
                                        <!-- Grid (E) -->


                                    </td></tr>
                            </table>
                            <!-- Grid BG Box  (S) -->
                        </div>

                        <!--TAB O/B (E) -->
                        <!--TAB INV (S) -->

                        <div id="tabLayer" style="display:none">
                            <!-- Grid BG Box  (S) -->
                            <table class="search" id="mainTable">
                                <tr><td class="bg">
                                        <!--  biz_2  (S) -->
                                        <table class="search" border="0"> 
                                            <tr class="h23">
                                                <td width="70">Customer</td>
                                                <td  width=""><input type="text" style="width:30;" class="input2" value="" name="cust_cnt_cd_invoice" readonly>&nbsp;<input type="text" style="width:60;" class="input2" value="" name="cust_seq_invoice" readonly>&nbsp;<input type="text" style="width:150;" class="input2" value="" name="cust_lgl_eng_nm_invoice" readonly></td>


                                            </tr>
                                        </table>


                                        <!--  biz_2  (E) -->
                                        <table class="height_2"><tr><td colspan="8"></td></tr></table>
                                        <!-- Grid  (S) -->

                                        <table width="100%"  id="mainTable">
                                            <tr>
                                                <td width="100%">
                                                    <script language="javascript">ComSheetObject('t3sheet');</script>
                                                </td>
                                            </tr>
                                        </table>
                                        <!-- Grid (E) -->


                                    </td></tr>
                            </table>
                            <!-- Grid BG Box  (S) -->

                        </div>

                        <!--TAB INV (E) -->


                        <!--TAB TRO(Warehouse) (S) -->

                        <div id="tabLayer" style="display:none">
                            <!-- Grid BG Box  (S) -->
                            <table class="search" id="mainTable">
                                <tr><td class="bg">
                                        <!--  biz_2  (S) -->
                                        <table class="search" border="0"> 
                                            <tr class="h23">
                                                <td width="70">Customer</td>
                                                <td  width=""><input type="text" style="width:30;" class="input2" value="" name="cust_cnt_cd_tro">&nbsp;<input type="text" style="width:60;" class="input2" value="" name="cust_seq_tro">&nbsp;<input type="text" style="width:150;" class="input2" value="" name="cust_lgl_eng_nm_tro"></td>


                                            </tr>
                                        </table>


                                        <!--  biz_2  (E) -->
                                        <table class="height_2"><tr><td colspan="8"></td></tr></table>
                                        <!-- Grid  (S) -->

                                        <table width="100%"  id="mainTable">
                                            <tr>
                                                <td width="100%">
                                                    <script language="javascript">ComSheetObject('t4sheet');</script>
                                                </td>
                                            </tr>
                                        </table>
                                        <!-- Grid (E) -->


                                    </td></tr>
                            </table>
                            <!-- Grid BG Box  (S) -->

                        </div>

                        <!--TAB TRO(Warehouse) (E) -->


                        <!--biz page (E)-->
                        <!-- 
                        <table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
		</table>
	 -->

                        <!-- 개발자 작업  끝 -->
                    </td></tr>
            </table>
            <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
        </form>
    </body>
</html>