<%--=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0115.jsp
*@FileTitle : Manual Container Mapping
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2008-09 Hun-Il Jung
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@page import="com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.event.EsdSce0115Event"%>
<%@page import="com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.event.EsdSce0115EventResponse"%>
<%
	EsdSce0115Event			event			= null; //PDTO(Data Transfer Object including Parameters)
	EsdSce0115EventResponse	eventResponse	= null;	//RDTO(Data Transfer Object including DB ResultSet)
    Exception					serverException = null;	//

	String strErrMsg = "";                             	//

    try {
        event = (EsdSce0115Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{

            eventResponse = (EsdSce0115EventResponse)request.getAttribute("EventResponse");
        } // end else
    }catch(Exception e) {
    	out.println(e.getMessage()) ;
    }

%>

<html>
<head>
<title>Welcome to NMS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


</head>
<script language="javascript">
    function setupPage(){

	    var errMessage = "<%=strErrMsg%>";
	    if (errMessage.length >= 1) {
	    	ComShowMessage(errMessage);
	    } // end if

		loadPage();
	}

</script>


<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="txtmapgofccd">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
							<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
							<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
						</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
		<table class="height_5"><tr><td></td></tr></table>
		<table class="height_5"><tr><td></td></tr></table>		

		<table width="100%" height="10%" class="title">
		  	<tr>
		  		<td width="7"></td>
		  		<td class="title">Container UnMapping</td>
		    	</tr>
		</table>
		<table class="height_5"><tr><td></td></tr></table>

	<table class="height_4"><tr><td></td></tr></table>
	<!-- TABLE '#D' : ( Search Options ) (S) -->
	<table class="search">
		<tr>
			<td class="bg">
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="300">
						<input type="radio" name ="selection" value ="bkg_no" class="trans" checked>&nbsp;BKG_No.&nbsp;
						<input name="bkg_no" type="text" class="input" style="width:120; text-transform:uppercase;" onBlur='javascript:this.value=this.value.toUpperCase();'>
						</td>
						<td width="300">
						<input type="radio" name ="selection" value ="cntr_no" class="trans">&nbsp;Container No.&nbsp;
						<input name="cntr_no_txt" type="text" class="input" style="width:100; text-transform:uppercase;" maxlength="11" onKeyUp="this.value=this.value.toUpperCase()" onBlur='javascript:this.value=this.value.toUpperCase();'>
						</td>

						<td width="">
							<table class="search"  border="0" style="width:100%;">
								<tr class="h23">
									<td align="center" width="160">
									<input type="radio" name ="selection" value ="bkgcrt_dt" class="trans">&nbsp;Booking Create Date
									</td>
									<td width="75" ><input name="bkgcrt_fm_dt" type="text" class="input" style="width:70; text-transform:uppercase;"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;~&nbsp;</td>
									<td width="76" ><input  maxlength="10"  name="bkgcrt_to_dt" type="text" class="input" style="width:70; text-transform:uppercase;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"></td>
									<td width="" ><img name="btn_bkg_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>

			</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->

	<table class="height_10"><tr><td></td></tr></table>

	<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
    	<table class="search">
      	<tr><td class="bg">

			<!-- : ( Speed ) (S) -->
			<table width="100%" id="mainTable">
				<tr><td>
				   <script language="javascript">ComSheetObject('sheet2');</script>
				</td></tr>
			</table>
			<!-- : ( Speed ) (E) -->
			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button">
			<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="dbtn_retrieve" id="dbtn_retrieve">Retrieve</td>
						<td class="btn2_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="dbtn_new" id="dbtn_new">New</td>
						<td class="btn2_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="dbtn_save" id="dbtn_save">Save</td>
						<td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->
					</tr></table>
			</td></tr>
		</table>
    		<!-- : ( Button : Sub ) (E) -->
		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
</td></tr>
<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->



<tr>
<!-- ####### TABLE '#D' ::: 'LEFT' FRAME (START) ####### -->
	<td class="bodyright" width="100%" height="20%">
		<table width="100%" height="10%" class="title">
	  		<tr>
	  			<td width="7"></td>
	  	  		<td class="title">COP-HDR Mapping</td>
	   		</tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<!--
		<table class="search">
			<tr>
				<td class="bg_a">
					<table class="search" border="0" style="width:200;">
						<tr class="h23">
							<td width="5%">Office</td>
							<td width="90"><input name="mst_ofc_cd" type="text" class="input" style="width:60; text-transform:uppercase;" maxlength="6" onKeyUp="this.value=this.value.toUpperCase()">
							<img onClick="openOfcPopUp(true,'mstofccd')" class="cursor" src="/hanjin/img/enis/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>

						</tr>
					</table>

				</td></tr>
		</table>
		-->
		<!-- TABLE '#D' : ( Search Options ) (E) -->



		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Speed ) (S) -->
				<table width="100%" border="0" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( Speed ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="sbutton">
	       				<tr><td class="align">

			    		<table class="sbutton">
			    			<tr><!--<td class="bt"><img class="cursor" src="/hanjin/img/enis/button/btng_rowadd.gif" width="65" height="19" border="0" name="btng_rowadd"></td>
			    				<td><img class="cursor" src="/hanjin/img/enis/button/btn_new.gif" width="66" height="20" border="0" name="btn_new"></td>
			    				<td><img class="cursor" src="/hanjin/img/button/btn_retrieve.gif" width="66" height="20" border="0" name="btn_retrieve"></td>-->
								</tr>
						</table>

						</td></tr>
					</table>
	    		<!-- : ( Button : Sub ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
</td>
</tr>
<!-- ####### TABLE '#D' ::: 'LEFT' FRAME (END) ####### -->





<!-- : ( Button : Sub ) (S) -->
<tr>
	<td align="center">
		<table class="sbutton">
			<tr><td class="p_bt">
			<!--  <img class="cursor" src="/hanjin/img/enis/button/btn_close.gif" width="66" height="20" border="0" name="btn_close">-->
			</td></tr>
		</table>
	</td>
</tr>
<!-- : ( Button : Sub ) (E) -->



    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>

