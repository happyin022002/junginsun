<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7009.jsp
*@FileTitle : Exception Cost by Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.03
*@LastModifier :  Kim Hyun Hwa
*@LastVersion : 1.0
* 2012.08.03 Kim Hyun Hwa
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.event.EesDmt7009Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EesDmt7009Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    String strUsr_lc        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.DMTPerformanceAnalysis.DMTCollectionOfficeMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strUsr_lc = account.getCnt_cd();
       


        event = (EesDmt7009Event)request.getAttribute("Event");
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
<title>Exception Cost by Yard</title>
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
<input type="hidden" name="cre_usr_id" value="<%= strUsr_id %>">
<input type="hidden" name="cre_ofc_cd" value="<%= strUsr_of %>">
<input type="hidden" name="upd_usr_id" value="<%= strUsr_id %>">
<input type="hidden" name="upd_ofc_cd" value="<%= strUsr_of %>">

<input type="hidden" name="cnt_cd">
<input type="hidden" name="yd_cd">
<input type="hidden" name="yd_info">
<input type="hidden" name="dmt_ofc">
<input type="hidden" name="chk_yd_cd" > 
<input type="hidden" name="chk_peiod" > 
<input type="hidden" name="eff_dt" > 
<input type="hidden" name="exp_dt" >
 
<input type="hidden" name="h_user_office"  value="<%= strUsr_of %>"  >
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_of %>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="usr_cnt_cd" value="<%= strUsr_lc %>">
<input type="hidden" name="chk_current">
<input type="hidden" name="chk_tobe">
<input type="hidden" name="chk_expired">
<input type="hidden" name="cfm_cancel" value="N">

<!-- 개발자 작업 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
    <!--top menu (S)-->
        <!--top menu (E)-->
    </td></tr>
    
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
                    
                        <td width="105">DEM/DET Office </td>
                        <td width="245" class="sm">
                            <script language="javascript">ComComboObject('office',1,80,0,0,0,true);</script>&nbsp;
                            <img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">
                            <input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()"  class="trans">&nbsp;Incl. Sub Office                        
                        </td>
                        <td width="70">Collection </td>
                        <td class="stm" width="100">I/B 
                            <select style="width:60;" class="input" name="dem_ib_clt_flg">
                                <option value="A" selected>All</option>
                                <option value="Y"         >Yes</option>
                                <option value="N"         >No </option>
                            </select>
                        </td>
                        <td class="stm" width="">O/B 
                            <select style="width:60;" class="input" name="dem_ob_clt_flg">
                                <option value="A" selected>All</option>
                                <option value="Y"         >Yes</option>
                                <option value="N"         >No </option>
                            </select>
                        </td>
                        <td width="70">Cost Status</td>
                        <td width="230">
                            <select style="width:80;" class="input" name="cfm_flg">
                                <option value="A" selected>All</option>
                                <option value="X"         >None</option>
                                <option value="N"         >Temp. Saved</option>
                                <option value="Y"         >Fixed</option>
                            </select>
                        </td>
                    </tr>
                
                </table>
                
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23"> 
                    
                        <td width="57">Country </td>
                        <td width="100" class="sm">
                            <script language="javascript">ComComboObject('combo3', 2, 50 , 0, 0, 0, true)</script>
                        </td>
                        
                        <td width="30">Yard </td>
                        <td  width="162">
                            <input type="text" id="yd_cd1" name="yd_cd1" style="width:60;" class="input" value="" dataformat="engnum" maxlength="5" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" OnKeyUp="checkYard1(this)" >&nbsp;
                            <script language="javascript">ComComboObject('combo5', 2, 50 , 0, 0, 0, true)</script>                        
                        </td>
                        
                        <td width="88">Yard Status </td>
                        <td class="stm" width="">
                            <select style="width:60;" class="input" name="yd_delt_flg">
                                <option value="A"         >All   </option>
                                <option value="N" selected>Live  </option>
                                <option value="Y"         >Deleted</option>
                            </select>
                        </td>
                        <td width="70">Yard Type </td>
                        <td class="stm" width="230">
                        
                            <select style="width:110;" class="input" name="yd_type">
                                <option value="A"         >All   </option>
                                <option value="MA" selected>Marine terminal</option>
                                <option value="CY"         >CY</option>
                                <option value="CF"         >CFS</option>
                                <option value="RA"         >RAIL</option>
                                <option value="BA"         >BARGE</option>
                            </select>
                        </td>
                        
                    </tr>
                </table>
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23"> 
                    
                        <td width="57">Validity </td>
                        <td  width="70" class="sm">
                            <input type="checkbox" name="chk_current_flg" value="N" onClick="doValidity1()" class="trans">&nbsp;Current                       
                        </td>
                        <td  width="70" class="sm">
                            <input type="checkbox" name="chk_tobe_flg" value="N" onClick="doValidity2()" class="trans">&nbsp;To-Be                       
                        </td>
                        <td  width="70" class="sm">
                            <input type="checkbox" name="chk_expired_flg" value="N" onClick="doValidity3()" class="trans">&nbsp;Expired                       
                        </td>
                        <td width="700"> </td>
                    </tr>
                </table>
              
                
                <!--  biz_1  (E) -->
                
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
                <!-- Grid  (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <!-- Grid  (e) -->
                <!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_add">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_delete">Row&nbsp;Delete</td>
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
              <!--Button (S) -->
                  </td></tr>
        </table>
      <table width="100%" class="button">
        <tr>
          <td class="btn2_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_confirm">Confirmation</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_cancel">Confirmation Cancel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td> 
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_upLoadExcel">Excel Upload</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downExcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      
      <!--Button (E) -->           
                    

        
<!-- : ( Search Options ) (E) -->
 
            
            
                    
                    
            
            
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
   
    </td></tr>
</table>
    </td></tr>
</table>
<!-- Copyright (S) -->
<!-- Copyright(E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>