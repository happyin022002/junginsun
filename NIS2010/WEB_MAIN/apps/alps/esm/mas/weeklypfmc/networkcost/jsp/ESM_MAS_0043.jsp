<%
/*=========================================================
* Copyright(c) 2014 CyberLogitec
* @FileName : ESM_MAS_0043.jsp
* @FileTitle : Average-hire by Own Wessel 조회/변경
* Open Issues :
* Change history : 
* @LastModifyDate : 2014-12-03
* @LastModifier : Je Ryang Yoo
* @LastVersion : 1.0
*  2014-12-03 Je Ryang Yoo
*  1.0 최초 생성
=========================================================
* History                                                        
* 2015.08.24 손진환 [CHM-201537399] AVG-hire by Own-VSL (PA) Month Copy 기능 추가 생성 요청
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0043");
    
    //String userId = "";    
    
    try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		//SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		//userId = account.getUsr_id();        
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
	} catch(Exception e) {
		log.error("JSP Exception : " + e.toString());
	}
%>
<html>
<head>
<title>AVG-hire by Own-VSL (PA)</title>
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
<body onload="javascript:setupPage();form.f_yearweek.focus();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_header">
<input type="hidden" name="tab_item">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr>
          <td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
        </tr>
        <tr>
          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

      <!--Button_L (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Save" name="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <!-- <td class="btn1" id="btn_Downexcel" name="btn_Creation">Creation</td> -->
                      <td class="btn1" id="btn_Creation" name="btn_Creation">Creation</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>              
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Month_Copy" name="btn_Month_Copy">Month Copy</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>                  
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Loadexcel" name="btn_Loadexcel">Load Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <!-- Repeat Pattern -->

              </tr>
            </table>

          </td>
        </tr>
      </table>
      <!--Button_L (E) -->


      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="20%">
                     YYYY-MM <input type="radio" name="f_yrtype" class="trans" value="yrmon" onClick="setYrMon()" checked="true">&nbsp;&nbsp;
                     YYYY-WW <input type="radio" name="f_yrtype" class="trans" value="yrwk">&nbsp;&nbsp;
                </td>
                <td width="8%"><input type="text" style="width:60" class="input1" name="f_yearweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComAddSeparator_Local(this, '-');this.select();" onblur="javascript:fnYearWeekSet(this);"></td>
                <td width="22%" class="sm"><div id="div_period"></div></td>
                <td width="6%">Vessel</td>
                <td width="14%">&nbsp;<script language="javascript">ComComboObject('f_selvessel',1, 80 , 0 )</script></td>
                <td width="9%">Start Month</td>
                <td width="100">
                	<input type="text" style="width:60" class="input1" name="f_syearmonth" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComAddSeparator_Local(this, '-');this.select();" onblur="javascript:fnYearWeekSet(this);"></td>
                </td>
                <!-- <td width="16%">&nbsp;
							<SELECT style='width:70' class="input1" name="f_year" >								
								<OPTION value="2013">2013</OPTION>
								<OPTION value="2014" selected="">2014</OPTION>
								<OPTION value="2015">2015</OPTION>
								<OPTION value="2016">2016</OPTION>
							</SELECT>&nbsp;
							<SELECT style='width:50' class="input1" name="f_mon" >
								<OPTION value="01">01</OPTION>
								<OPTION value="02">02</OPTION>
								<OPTION value="03">03</OPTION>
								<OPTION value="04">04</OPTION>
								<OPTION value="05">05</OPTION>
								<OPTION value="06">06</OPTION>
								<OPTION value="07">07</OPTION>
								<OPTION value="08">08</OPTION>
								<OPTION value="09">09</OPTION>
								<OPTION value="10">10</OPTION>
								<OPTION value="11">11</OPTION>
								<OPTION value="12">12</OPTION>
							</SELECT>
				</td> -->
                <td width="6%">Duration</td>
                <td width="60"><script language="javascript">ComComboObject('f_dur',1, 50 , 0 )</script></td>
                <!-- <td width="16%">&nbsp;
							<SELECT style='width:50' class="input1" name="f_dur" >
								<OPTION value="01">01</OPTION>
								<OPTION value="02">02</OPTION>
								<OPTION value="03">03</OPTION>
								<OPTION value="04">04</OPTION>
								<OPTION value="05">05</OPTION>
								<OPTION value="06">06</OPTION>
								<OPTION value="07">07</OPTION>
								<OPTION value="08">08</OPTION>
								<OPTION value="09">09</OPTION>
								<OPTION value="10">10</OPTION>
								<OPTION value="11">11</OPTION>
								<OPTION value="12">12</OPTION>
							</SELECT>
				</td> -->
                <td></td>
              </tr>
            </table>
            <!-- : ( Year ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
      <!-- <table class="height_10"><tr><td></td></tr></table> -->      
            
      <table class="height_8"><tr><td colspan="8"></td></tr></table>
		
	  <!-- Tab (S) -->
      <table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
      	<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td>
		</tr>
	  </table>
	  <!-- Tab (E) -->
	  
	  
	<div id="tabLayer" style="display:inline">
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
          
       		<!--  Button_Sub (S) -->
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<!-- <tr><td class="btn2_left"></td><td class="btn2" id="btn_Costmodification" name="btn_Loadexcel">Cost Modification</td><td class="btn2_right"></td></tr></table></td> -->
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Costmodification" name="btn_Costmodification">Cost Modification</td><td class="btn2_right"></td></tr></table></td>
					<!-- Repeat Pattern -->
					
				</tr></table>
			</td></tr>
			<tr><td class="height_5" colspan="3"></td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	
            <!-- : ( POR ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>                        
            <!-- : ( POR ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
      <!-- <table class="height_10"><tr><td></td></tr></table> -->            
	</div>
  
	<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Costmodification" name="btn_Costmodification">Cost Modification</td><td class="btn2_right"></td></tr></table></td>					
				</tr></table>
			</td></tr>
			<tr><td class="height_5" colspan="3"></td></tr>
			</table>
			
			<table width="100%"  id="mainTable2">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
							
			</td></tr>
		</table>		
	  </div>
	  
	  <div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Costmodification" name="btn_Costmodification">Cost Modification</td><td class="btn2_right"></td></tr></table></td>					
				</tr></table>
			</td></tr>
			<tr><td class="height_5" colspan="3"></td></tr>
			</table>
			
			<table width="100%"  id="mainTable2">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table>
							
			</td></tr>
		</table>		
	  </div>

	  <div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Costmodification" name="btn_Costmodification">Cost Modification</td><td class="btn2_right"></td></tr></table></td>					
				</tr></table>
			</td></tr>
			<tr><td class="height_5" colspan="3"></td></tr>
			</table>
			
			<table width="100%"  id="mainTable2">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
				</tr>
			</table>
							
			</td></tr>
		</table>		
	  </div>
	  
	  <div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Costmodification" name="btn_Costmodification">Cost Modification</td><td class="btn2_right"></td></tr></table></td>					
				</tr></table>
			</td></tr>
			<tr><td class="height_5" colspan="3"></td></tr>
			</table>
			
			<table width="100%"  id="mainTable2">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet5');</script>
					</td>
				</tr>
			</table>
							
			</td></tr>
		</table>		
	  </div>
	  
	  <div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Costmodification" name="btn_Costmodification">Cost Modification</td><td class="btn2_right"></td></tr></table></td>					
				</tr></table>
			</td></tr>
			<tr><td class="height_5" colspan="3"></td></tr>
			</table>
			
			<table width="100%"  id="mainTable2">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet6');</script>
					</td>
				</tr>
			</table>
							
			</td></tr>
		</table>		
	  </div>
	  
	  <div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Costmodification" name="btn_Costmodification">Cost Modification</td><td class="btn2_right"></td></tr></table></td>					
				</tr></table>
			</td></tr>
			<tr><td class="height_5" colspan="3"></td></tr>
			</table>
			
			<table width="100%"  id="mainTable2">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet7');</script>
					</td>
				</tr>
			</table>
							
			</td></tr>
		</table>		
	  </div>
	  
	  <div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Costmodification" name="btn_Costmodification">Cost Modification</td><td class="btn2_right"></td></tr></table></td>					
				</tr></table>
			</td></tr>
			<tr><td class="height_5" colspan="3"></td></tr>
			</table>
			
			<table width="100%"  id="mainTable2">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet8');</script>
					</td>
				</tr>
			</table>
							
			</td></tr>
		</table>		
	  </div>
	  
	  <div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Costmodification" name="btn_Costmodification">Cost Modification</td><td class="btn2_right"></td></tr></table></td>					
				</tr></table>
			</td></tr>
			<tr><td class="height_5" colspan="3"></td></tr>
			</table>
			
			<table width="100%"  id="mainTable2">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet9');</script>
					</td>
				</tr>
			</table>
							
			</td></tr>
		</table>		
	  </div>
	  
	  <div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			<table width="100%"  id="mainTable2">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet10');</script>
					</td>
				</tr>
			</table>
							
			</td></tr>
		</table>		
	  </div>

    </td>
  </tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>