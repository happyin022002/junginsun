<%
/*=========================================================
* Copyright(c) 2014 CyberLogitec
* @FileName : ESM_BSA_0123.jsp
* @FileTitle : Add Carriers
* Open Issues :
* Change history :
* @LastModifyDate : 2014-05-09
* @LastModifier : Shin Ja Young
* @LastVersion : 1.0
*  2014-05-09 Shin Ja Young
*  1.0 최초 생성
*=========================================================
* History :
* 2014.06.30 김용습 R4J 패치 사전 작업
* 2015.02.23 김용습 [CHM-201534456] - 2015년 1월 소스 보안 결함 건 조치 요청
* 2015.03.20 김용습 [CHM-201534945] - BSA CREATION 화면 / "VVD INQUIRY" 기능 개선 요청
*=========================================================--
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0123Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 

<%
    //DBRowSet rowSet = null;
    DBRowSet[] rowSet = new DBRowSet[2];
    EsmBsa0123Event event = null;
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException = null;
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bsa.ESM_BSA_0123");
    String strErrMsg = "";
    String xml = "";

    String bsa_op_jb_cd1 = "";
    String bsa_op_jb_nm1 = "";
    String crr_cd1 = "";
    String bsa_op_jb_cd2 = "";
    String bsa_op_jb_nm2 = "";
    String crr_cd2 = "";
    
    String popup_sdate = "";
    String popup_edate = "";
    String popup_trade = "";
    String popup_lane = "";
    String popup_dir = "";
    String popup_capa = "";
    String popup_bsa_op_cd = "";
    String popup_row = "";
    String popup_vop = "";
    

	String userId   = "";
	String userName = "";
	String toDay = DateTime.getDateString().replace(".","-"); 
	
	//2014.06.30 김용습 R4J 패치 사전 작업
	String bsaOpJbCd1 = "";
	String bsaOpJbNm1 = "";
	String crrCd1 = "";
	String bsaOpJbCd2 = "";
	String bsaOpJbNm2 = "";
	String crrCd2 = "";
	StringBuffer out1 = new StringBuffer();
	StringBuffer out2 = new StringBuffer();
	StringBuffer out3 = new StringBuffer();
	StringBuffer out4 = new StringBuffer();
	StringBuffer out5 = new StringBuffer();
	StringBuffer out6 = new StringBuffer();

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        //추가----------------------------------------------------------------------------------------- START
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();
        userName  = account.getUsr_nm();

        event = (EsmBsa0123Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
            	CommonBsaRsVO vo = (CommonBsaRsVO)(eventResponse.getCustomData("rtnVo"));
            	CommonBsaRsVO[] vos = vo.getCommonBsaRsVOArray();

                rowSet[0] = vos[0].getDbRowset();
                rowSet[1] = vos[1].getDbRowset();

                if (rowSet != null) {
                    while (rowSet[0].next()) {
                    	//2014.06.30 김용습 R4J 패치 사전 작업
                        //bsa_op_jb_cd1 = bsa_op_jb_cd1 + "|" + JSPUtil.getNull(rowSet[0].getString("bsa_op_jb_cd"));
                        //bsa_op_jb_nm1 = bsa_op_jb_nm1 + "|" + JSPUtil.getNull(rowSet[0].getString("bsa_op_jb_nm"));
                        //crr_cd1       = crr_cd1       + "|" + JSPUtil.getNull(rowSet[0].getString("crr_cd"));
                    	bsaOpJbCd1 = JSPUtil.getNull(rowSet[0].getString("bsa_op_jb_cd"));
                    	bsaOpJbNm1 = JSPUtil.getNull(rowSet[0].getString("bsa_op_jb_nm"));
                    	crrCd1 = JSPUtil.getNull(rowSet[0].getString("crr_cd"));
                    	
                    	out1.append("|").append(bsaOpJbCd1);
                    	out2.append("|").append(bsaOpJbNm1);
                    	out3.append("|").append(crrCd1);
                    } //end of while
                    bsa_op_jb_cd1 = out1.toString();
                    bsa_op_jb_nm1 = out2.toString();
                    crr_cd1       = out3.toString();

                    while (rowSet[1].next()) {
                    	//2014.06.30 김용습 R4J 패치 사전 작업
                        //bsa_op_jb_cd2 = bsa_op_jb_cd2 + "|" + JSPUtil.getNull(rowSet[1].getString("bsa_op_jb_cd"));
                        //bsa_op_jb_nm2 = bsa_op_jb_nm2 + "|" + JSPUtil.getNull(rowSet[1].getString("bsa_op_jb_nm"));
                        //crr_cd2       = crr_cd2       + "|" + JSPUtil.getNull(rowSet[1].getString("crr_cd"));
                    	bsaOpJbCd2 = JSPUtil.getNull(rowSet[1].getString("bsa_op_jb_cd"));
                    	bsaOpJbNm2 = JSPUtil.getNull(rowSet[1].getString("bsa_op_jb_nm"));
                    	crrCd2 = JSPUtil.getNull(rowSet[1].getString("crr_cd"));
                    	
                    	out4.append("|").append(bsaOpJbCd2);
                    	out5.append("|").append(bsaOpJbNm2);
                    	out6.append("|").append(crrCd2);
                    } //end of while
                    bsa_op_jb_cd2 = out4.toString();
                    bsa_op_jb_nm2 = out5.toString();
                    crr_cd2       = out6.toString();

                } //end of if
            } // end if
        } // end else
        //추가----------------------------------------------------------------------------------------- END

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
        // popup open 세팅
    	popup_sdate      = ( JSPUtil.replaceForHTML(request.getParameter("from_dt")) == null )? ""  : JSPUtil.replaceForHTML(request.getParameter("from_dt"));
/* 	        if( popup_sdate != null ){
	        	popup_sdate = popup_sdate.replaceAll("<","&lt;");
	        	popup_sdate = popup_sdate.replaceAll(">","&gt");
	        	popup_sdate = popup_sdate.replaceAll("&","&amp;");
	        	popup_sdate = popup_sdate.replaceAll("\"","&quot;");
	        	popup_sdate = popup_sdate.replaceAll("\'","&#x27;");
	        	popup_sdate = popup_sdate.replaceAll("/","&#x2F;");
	        }else{ return; } */
        
    	popup_edate      = ( JSPUtil.replaceForHTML(request.getParameter("end_dt")) == null )? ""  : JSPUtil.replaceForHTML(request.getParameter("end_dt"));
/* 	    	if( popup_edate != null ){
	    		popup_edate = popup_edate.replaceAll("<","&lt;");
	    		popup_edate = popup_edate.replaceAll(">","&gt");
	    		popup_edate = popup_edate.replaceAll("&","&amp;");
	    		popup_edate = popup_edate.replaceAll("\"","&quot;");
	    		popup_edate = popup_edate.replaceAll("\'","&#x27;");
	    		popup_edate = popup_edate.replaceAll("/","&#x2F;");
	        }else{ return; } */
    	
    	popup_trade      = ( JSPUtil.replaceForHTML(request.getParameter("trd_cd")) == null )? ""  : JSPUtil.replaceForHTML(request.getParameter("trd_cd"));
/* 	    	if( popup_trade != null ){
	    		popup_trade = popup_trade.replaceAll("<","&lt;");
	    		popup_trade = popup_trade.replaceAll(">","&gt");
	    		popup_trade = popup_trade.replaceAll("&","&amp;");
	    		popup_trade = popup_trade.replaceAll("\"","&quot;");
	    		popup_trade = popup_trade.replaceAll("\'","&#x27;");
	    		popup_trade = popup_trade.replaceAll("/","&#x2F;");
	        }else{ return; } */
    	
    	popup_lane   	 = ( JSPUtil.replaceForHTML(request.getParameter("rlane_cd")) == null )? ""  : JSPUtil.replaceForHTML(request.getParameter("rlane_cd"));
/* 	    	if( popup_lane != null ){
	    		popup_lane = popup_lane.replaceAll("<","&lt;");
	    		popup_lane = popup_lane.replaceAll(">","&gt");
	    		popup_lane = popup_lane.replaceAll("&","&amp;");
	    		popup_lane = popup_lane.replaceAll("\"","&quot;");
	    		popup_lane = popup_lane.replaceAll("\'","&#x27;");
	    		popup_lane = popup_lane.replaceAll("/","&#x2F;");
	       }else{ return; } */
    	
    	popup_dir   	 = ( JSPUtil.replaceForHTML(request.getParameter("dir_cd")) == null )? ""  : JSPUtil.replaceForHTML(request.getParameter("dir_cd"));
/* 	    	if( popup_dir != null ){
	    		popup_dir = popup_dir.replaceAll("<","&lt;");
	    		popup_dir = popup_dir.replaceAll(">","&gt");
	    		popup_dir = popup_dir.replaceAll("&","&amp;");
	    		popup_dir = popup_dir.replaceAll("\"","&quot;");
	    		popup_dir = popup_dir.replaceAll("\'","&#x27;");
	    		popup_dir = popup_dir.replaceAll("/","&#x2F;");
	       }else{ return; } */
    	
    	popup_capa   	 = ( JSPUtil.replaceForHTML(request.getParameter("vsl_capa")) == null )? ""  : JSPUtil.replaceForHTML(request.getParameter("vsl_capa"));
/* 	    	if( popup_capa != null ){
	    		popup_capa = popup_capa.replaceAll("<","&lt;");
	    		popup_capa = popup_capa.replaceAll(">","&gt");
	    		popup_capa = popup_capa.replaceAll("&","&amp;");
	    		popup_capa = popup_capa.replaceAll("\"","&quot;");
	    		popup_capa = popup_capa.replaceAll("\'","&#x27;");
	    		popup_capa = popup_capa.replaceAll("/","&#x2F;");
	       }else{ return; } */
    	
    	popup_bsa_op_cd	 = ( JSPUtil.replaceForHTML(request.getParameter("bsa_op_cd")) == null )? ""  : JSPUtil.replaceForHTML(request.getParameter("bsa_op_cd"));
/* 	    	if( popup_bsa_op_cd != null ){
	    		popup_bsa_op_cd = popup_bsa_op_cd.replaceAll("<","&lt;");
	    		popup_bsa_op_cd = popup_bsa_op_cd.replaceAll(">","&gt");
	    		popup_bsa_op_cd = popup_bsa_op_cd.replaceAll("&","&amp;");
	    		popup_bsa_op_cd = popup_bsa_op_cd.replaceAll("\"","&quot;");
	    		popup_bsa_op_cd = popup_bsa_op_cd.replaceAll("\'","&#x27;");
	    		popup_bsa_op_cd = popup_bsa_op_cd.replaceAll("/","&#x2F;");
	       }else{ return; } */
    	
    	popup_row	 	 = ( JSPUtil.replaceForHTML(request.getParameter("popup_row")) == null )? ""  : JSPUtil.replaceForHTML(request.getParameter("popup_row"));
/* 	    	if( popup_row != null ){
	    		popup_row = popup_row.replaceAll("<","&lt;");
	    		popup_row = popup_row.replaceAll(">","&gt");
	    		popup_row = popup_row.replaceAll("&","&amp;");
	    		popup_row = popup_row.replaceAll("\"","&quot;");
	    		popup_row = popup_row.replaceAll("\'","&#x27;");
	    		popup_row = popup_row.replaceAll("/","&#x2F;");
	       }else{ return; } */
    	
    	popup_vop   	 = ( JSPUtil.replaceForHTML(request.getParameter("vop_cd")) == null )? ""  : JSPUtil.replaceForHTML(request.getParameter("vop_cd"));
/* 	    	if( popup_vop != null ){
	    		popup_vop = popup_vop.replaceAll("<","&lt;");
	    		popup_vop = popup_vop.replaceAll(">","&gt");
	    		popup_vop = popup_vop.replaceAll("&","&amp;");
	    		popup_vop = popup_vop.replaceAll("\"","&quot;");
	    		popup_vop = popup_vop.replaceAll("\'","&#x27;");
	    		popup_vop = popup_vop.replaceAll("/","&#x2F;");
	       }else{ return; } */
    	
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>


<html>
<head>
<title>BSA Creation VVD Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage() {
    	document.form.txtSDate.value     = document.form.popup_sdate.value;
		document.form.txtEDate.value     = document.form.popup_edate.value;
		document.form.cobTrade.value     = document.form.popup_trade.value;
		document.form.cobLane.value      = document.form.popup_lane.value;
		document.form.cobDir.value       = document.form.popup_dir.value;
		document.form.cobCapa.value      = document.form.popup_capa.value;
		document.form.cobVop.value	     = document.form.popup_vop.value;
        loadPage();      
    }
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="bsa_op_cd">
<input type="hidden" name="popup_sdate"		value="<%=popup_sdate%>">
<input type="hidden" name="popup_edate"		value="<%=popup_edate%>">
<input type="hidden" name="popup_trade"		value="<%=popup_trade%>">
<input type="hidden" name="popup_lane"		value="<%=popup_lane%>">
<input type="hidden" name="popup_dir"		value="<%=popup_dir%>">
<input type="hidden" name="popup_capa"		value="<%=popup_capa%>">
<input type="hidden" name="popup_vop"		value="<%=popup_vop%>">
<input type="hidden" name="rdoOp_cd"	    value="<%=popup_bsa_op_cd%>">
<input type="hidden" name="popup_row"		value="<%=popup_row%>">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="sXml" value="<%=xml%>"> 

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">

      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr>
          <td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;BSA Creation VVD Inquiry</td>
        </tr>
      </table>

      <!-- : ( Title ) (E) -->
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search" border="0">
              <tr class="h23">
                <td width="40" style="text-indent:7;">Date</td>
                <td width=100>
                  <input class="input1" type="text" name="txtSDate" style="width:75;text-align:center;" maxlength="8"
                         onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
                         onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-');this.select();" value="">
                  <img name="btns_calendar1" src="/hanjin/img/button/btns_calendar.gif" class="cursor"
                       width="19" height="20" border="0" align="absmiddle"> 
                       
	              <div style="display:none">        ~
	                  <input  type="text" name="txtEDate" style="width:75;text-align:center;" maxlength="8"
	                          onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
	                         onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-'); this.select();" value="" >
	                  <img name="btns_calendar2" src="/hanjin/img/button/btns_calendar.gif" class="cursor"
	                       width="19" height="20" border="0" align="absmiddle">
	              </div> 
                </td>
                <td width="100" class="stm" >(ETD of 1st Port)</td>
                <td width="30">Trade</td>
                <td width="50">
                	<input class="input2" type="text" name="cobTrade" style="width:50;text-align:center;ime-mode: disabled;" maxlength="3" readonly>
                <!-- dropdown 제외
                <script language="javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script>
                -->
                </td>
                <td width="30">Lane</td>
                <td width="50">
                	<input class="input2" type="text" name="cobLane" style="width:50;text-align:center;" maxlength="5" readonly>
                <!-- dropdown 제외
                <script language="javascript">ComComboObject('cobLane', 1, 70 , 0 )</script>
                -->
                </td>
                <td width="20">Dir.</td>
                <td width="30">
                	<input class="input2" type="text" name="cobDir" style="width:30;text-align:center;" maxlength="1" readonly>
                <!-- dropdown 제외
                <td><script language="javascript">ComComboObject('cobDir', 1, 60 , 0 )</script>
                -->
                </td>
                <td width="30">Capa</td>
                <td width="50">
                	<input class="input2" type="text" name="cobCapa" style="width:50;text-align:right;" readonly>
                <!-- dropdown 제외
                <td><script language="javascript">ComComboObject('cobDir', 1, 60 , 0 )</script>
                -->
                </td>
                <td width="30">OPR</td>
                <td width="50">
                	<select class="input" name="cobVop"><option value="">ALL</option><option value="SML">SML</option><option value="OTH">OTH</option></select>
                <!-- dropdown 제외
                <td><script language="javascript">ComComboObject('cobDir', 1, 60 , 0 )</script>
                -->
                </td>
              </tr>
            </table>
<!--              <table>
           		<tr>
            		<td>
            		</td>
            	</tr>
            	<tr>
            		<td>
            			
            		</td>
            	</tr> -->
<!--             	<tr>
            		<td>
            			the others are data with '1st Loading ETD' that are after(or the same with) the end date of 'Period'.
            		</td>
            	</tr> -->
            </table>
            <!-- : ( Year ) (E) -->

          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->

      <table class="height_10">
        <tr><td></td></tr>
      </table>

      <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Speed ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
              <tr>
              	<td>*It always shows six rows or less. 
              	</td>
              
              </tr>
              <tr>
              	<td>&nbsp;&nbsp;First row is data with '1st Loading ETD' before 'Date', and the others with '1st Loading ETD' after(or the same with) 'Date'.
              	</td>
              </tr>
            </table>
            <!-- : ( Speed ) (E) -->
            <!-- : ( Button : Sub ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

    </td>
  </tr>
</table>

<!-- OUTER - POPUP (E)nd -->

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                 <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			 <tr>
       			 <td class="btn3_bg">
		    		<table border="0" cellpadding="0" cellspacing="0">
		    		<tr>
		    		<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_OK">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
			</tr>
		</table>
                </td>
                <!-- Repeat Pattern -->
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>