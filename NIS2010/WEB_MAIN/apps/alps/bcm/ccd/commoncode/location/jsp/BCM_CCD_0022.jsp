<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0022.jsp
*@FileTitle  : equipment ORG chart
*@author     : CLT 
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
        BcmCcd0022Event  event = null;              //PDTO(Data Transfer Object including Parameters)
        Exception serverException   = null;         //Error from server
        String strErrMsg = "";                      //Error message
        int rowCount     = 0;                       //Count of DB resultSet list

        String successFlag = "";
        String codeList  = "";
        String pageRows  = "100";

        String strUsr_id        = "";
        String strUsr_nm        = "";
        Logger log = Logger.getLogger("com.hanjin.apps.commoncode.location");

        try {
            SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
                strUsr_id = account.getUsr_id();
                strUsr_nm = account.getUsr_nm();


                event = (BcmCcd0022Event)request.getAttribute("Event");
                serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

                if (serverException != null) {
                        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
                }


                GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        }catch(Exception e) {
                out.println(e.toString());
        }
%>

<script type="text/javascript">
        var G_MDAA_CHK;
        var G_AHTU_TP_CD;
    
        function setupPage(){
                var errMessage = "<%=strErrMsg%>";
                if (errMessage.length >= 1) {
                        ComShowMessage(errMessage);
                } // end if
                loadPage();
        }
</script>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="mdm_yn" value="Y" id="mdm_yn" />
<input type="hidden" name="user_id" value="<%=strUsr_id%>" id="user_id" />

 	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
  	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
   
               <!--biz page (S)-->
	    <table class="search" id="mainTable"> 
	      <tr>
	        <td class="bg">
	          <!--  biz_1  (S) -->
	          <table class="search" border="0" style="width:989;"> 
	          <tr class="h23">
	            <td>
	              <table class="search" border="0">
	                <tr class="h23">
                    <td width="180">EQ Control Location Code</td>
                    <td width="480">
                        <select style="width:80px;" class="input1" name="loc_type" id="loc_type">
                            <option value="" selected>ALL</option>
                            <option value="R">RCC</option>
                            <option value="L">LCC</option>
                            <option value="E">ECC</option>
                            <option value="S">SCC</option>
                        </select><!--
                        --><input type="text" name="location" style="width:332px;ime-mode:disabled;" class="input2" id="location" dataformat="engup" otherchar="," /><!--
                        --><img src="img/btns_search.gif" name="loc_btn" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
                    </td>
                    <td width="50">Status</td>
                    <td>
                        <select style="width:70px;" class="input" name="delt_flg" id="delt_flg">
                            <option value="">ALL</option>
                            <option value="N" selected>Active</option>
                            <option value="Y">Delete</option>
                        </select>
                    </td>
	                </tr>
	        	</table>    
	        	</td>
	        	</tr>
	        	</table>
	      </td>
		</tr>
	</table>
</tr>
</table>

    <table class="height_8"><tr><td></td></tr></table>  
<!--     <div class="opus_design_grid">
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_Row_Add"         id="btn_Row_Add">Row Add</button>
            <button type="button" class="btn_accent" name="btn_Row_Copy"        id="btn_Row_Copy">Row Copy</button>
            <button type="button" class="btn_normal" name="btn_Row_Delete"  id="btn_Row_Delete">Row Delete</button> 
        </div> -->
    <!--TAB Unmatch (S) -->
    <div id="tabLayer" style="display:inline">
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">  
      
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
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Row_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Row_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
<!-- 						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td> -->
				<tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->    
          </td>
        </tr>
      </table>
      <!--biz page (E)-->
    </div>
    
    
     <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
            	<td id="btn_History">
            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_History">History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_Retrieve">Retrieve</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
                 <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_Down_Excel">Down Excel</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
                 <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_Save">Save</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_New">New</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
 		</tr>
 	</table>
    <!--TAB Unmatch (E) -->
</form>
</body>