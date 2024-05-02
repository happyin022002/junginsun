<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0587.jsp
*@FileTitle  : Booking Close for Bay Plan
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0587Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%@ page import="java.util.List"%>
<%
    EsmBkg0587Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //DB ResultSet List count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String strVslCd         = "";
    String strPolCd         = "";
    boolean bFlag= true;
    Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingListSearch");
    
    List<BkgComboVO> bkg_clz_sts_list = null;

    try {

        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

        event = (EsmBkg0587Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        bkg_clz_sts_list = (List<BkgComboVO>) eventResponse.getCustomData("bkg_clz_sts_list");
        strVslCd = event.getVslCd();
        strPolCd = event.getPolCd();
        if (strVslCd.length() > 1 && strPolCd.length() > 1) bFlag=true;
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(flag){
        if('<%=strVslCd.length()%>' > 1) {              
            //Show closing button
            /* document.all.popLayer.style.display = ""; */
            
  /*           try {
                var appName = navigator.appName;
                if (appName.indexOf("Netscape") == -1) {
                    document.all.pophistory.innerHTML = "";
                } else {
                	document.all.pophistory.innerHTML = "";
                }
                
                document.getElementById("mainTbl").className   = "popup";
                document.getElementById("mainTbl").cellPadding = "10";
                document.getElementById("topLine").className   = "top";
            }catch(err) {
                ComShowMessage(err);
            } */
        }
        
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if 
        
        
        $('<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_Excel"  	id="btn_Excel">Down Excel</button>').appendTo("#btnArea");
        
        $('#btn_Excel').after($('#btn_Close'));
		
        document.getElementById("title").innerHTML = "Booking Close for Bay Plan";
		
        loadPage(flag);
        
    }
</script>

<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="userOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="user_id" value="<%=strUsr_id%>">
  
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
<!-- Pop up setting -->
<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
<!-- inquiry_area(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
	    <!--  biz_1 (S) -->
	    <table>
	        <colgroup>
	            <col width="35px"  />
	            <col width="130px"  />
	            <col width="35px"  />
	            <col width="130px"  />
	            <col width="100px"  />
	            <col width="120px" />
	            <col width="50px"  />
	            <col width=""      />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th title="Vessel Voyage Direction">VVD</th>
	                <td><input type="text" style="width:90px;" class="input1" value="<%=strVslCd%>" name="vsl_cd" dataformat="engup" maxlength="9"></td>
	                <th title="Port of Loading">POL</th>
	                <td><input type="text" style="width:60px;" class="input1" value="<%=strPolCd%>" name="pol_cd" dataformat="engup" maxlength="5"><!-- 
	                    --><input type="text" style="width:30px;" class="input" name="yd_cd" dataformat="engup"  maxlength="2"></td>
	                <th>Booking Office</th>
	                <td>
	                    <select style="width:80px;" name="ofc_cd" id="ofc_cd">
	                        <option value="All" selected>All</option>
	                    </select>
	                </td>
	                <th>Status</th>
	                <td>
	                    <%=HTMLUtil.getComboString("bkg_clz_sts_cd", "width:100px;", "", "","All","All", bkg_clz_sts_list)%>
	                </td>
	            </tr> 
	        </tbody>
	    </table>
	    <!--  biz_1   (E) -->   
	</div>
	<!-- inquiry_area(E) -->
</div>
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_Booking_Close" id="btn_Booking_Close" type="button">Booking Close</button>
			<button class="btn_normal" name="btn_Re_Open" id="btn_Re_Open" type="button"> Re-open</button>
		</div>
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div> 
<%if(!mainPage.equals("true")){	%></div><%}%>

</form>
