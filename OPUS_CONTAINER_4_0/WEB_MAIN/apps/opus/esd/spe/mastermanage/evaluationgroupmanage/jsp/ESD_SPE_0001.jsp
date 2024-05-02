<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SPE_0001.jsp
*@FileTitle : Evaluation Group
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.event.EsdSpe0001Event"%>
<%@ page import="com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSpe0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//The count of DB ResultSet list
	
	
	List<SearchEGIdAllListVO> egidList = null;
	
	int h_t = 0;
	int s_t = 0;
	int n_t = 0;
	int k_t = 0;
			
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.MasterManage.EvaluationGroupManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSpe0001Event)request.getAttribute("Event");
	
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	    
		egidList = eventResponse.getRsVoList() ;
					
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<%
		int cnt = egidList.size();
		String[] temp = new String[cnt];
		
		for(int j=0; j<cnt; j++){
			SearchEGIdAllListVO vo = egidList.get(j);
			temp[j] = vo.getEgId();
				
		} 
			
		ArrayList v_ham = new ArrayList();
		ArrayList v_nyc = new ArrayList();
		ArrayList v_sha = new ArrayList();
		ArrayList v_sin = new ArrayList(); //N200902200160
		
		for(int j=0; j<temp.length; j++){
			String[] tmp = temp[j].split(" ");
			if("EGHAM".equals(tmp[0]))
				v_ham.add(tmp);
			if("EGNYC".equals(tmp[0]))
				v_nyc.add(tmp);
			if("EGSHA".equals(tmp[0]))
				v_sha.add(tmp);	
			if("EGSIN".equals(tmp[0])) //N200902200160
				v_sin.add(tmp);		
		}
		
		int[] ham = new int[v_ham.size()]; 
		int[] nyc = new int[v_nyc.size()];
		int[] sha = new int[v_sha.size()];
		int[] sin = new int[v_sin.size()]; //N200902200160
		
		for(int h=0;h<ham.length;h++ ){
			String[] h_tmp = (String[])v_ham.get(h);
			ham[h] = Integer.parseInt(h_tmp[1]);
		}
		
		for(int n=0;n<nyc.length;n++ ){
			String[] n_tmp = (String[])v_nyc.get(n);
			nyc[n] = Integer.parseInt(n_tmp[1]);
		}
		
		for(int s=0;s<sha.length;s++ ){
			String[] s_tmp = (String[])v_sha.get(s);
			sha[s] = Integer.parseInt(s_tmp[1]);
		}
		
		//N200902200160
		for(int k=0;k<sin.length;k++ ){
			String[] s_tmp = (String[])v_sin.get(k);
			sin[k] = Integer.parseInt(s_tmp[1]);
		}
						
		for(int h=0; h<ham.length-1;h++){
			h_t = ham[h];
			if(ham[h]<ham[h+1]){
				h_t = ham[h+1];
			}
		}
		
		for(int n=0; n<nyc.length-1;n++){
			n_t = nyc[n];
			if(nyc[n]<nyc[n+1]){
				n_t = nyc[n+1];
			}
		}
		
		for(int s=0; s<sha.length-1;s++){
			s_t = sha[s];
			if(sha[s]<sha[s+1]){
				s_t = sha[s+1];
			}
		}	
		
		//N200902200160
		for(int k=0; k<sin.length-1;k++){
			k_t = sin[k];
			if(sin[k]<sin[k+1]){
				k_t = sin[k+1];
			}
		}
				
%>
<html>
<head>
<title>Service Provider Evolution</title>
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
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="eg_pic_usr_id_form">
<input type="hidden" name="h_t" value=<%=h_t%>>
<input type="hidden" name="n_t" value=<%=n_t%>>
<input type="hidden" name="s_t" value=<%=s_t%>>
<input type="hidden" name="k_t" value=<%=k_t%>>
<input type="hidden" name="search_flg" value="">



<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


			<!--Button_L (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

						<td class="btn1_line"></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_apply" name="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

				</td></tr>
			</table>
			<!--Button_L (E) -->


			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">


						<table class="search_in" border="0">
							<tr class="h23">
								<td width="80">EG ID</td>
							<td colspan="2">
									<select name="eg_id" style="width:180" onChange="document.form.eg_rhq_cd.value='';document.form.eg_cty_cd.value='';document.form.svc_cate_cd.value='';document.form.search_flg.value='';">
									<option value="" selected>&lt;&lt; select &gt;&gt;</option>
										<%					
										for(int j=0; j<cnt; j++){
											SearchEGIdAllListVO vo = egidList.get(j);
											String egId = vo.getEgId();
									
											String sel = null;
											if(j==0){
												sel = "select";
											}else{
												sel = "";
											}
									%>					
										<option value="<%=egId%>" <%=sel%>><%=egId%></option>
									<%}%>		
									</select>
								</td>
							</tr>
							<tr class="h23">
								<td>EG Namer</td>
								<td width="53" class="stm" style="padding-left:3;">Level 1</td>
								<td width="210">
									<select name="eg_rhq_cd" style="width:124" onChange="document.form.eg_id.value='';document.form.search_flg.value='';">
									<option value="" selected>&lt;&lt; select &gt;&gt;</option>
									<option value="NYC">NYC</option>
									<option value="HAM">HAM</option>
									<option value="SHA">SHA</option>
									<option value="SIN">SIN</option>
									</select></td>
								<td width="50" class="stm">Level 2</td>
								<td width="210"><input type="text" name="eg_cty_cd" style="width:125" value="" style="text-transform:uppercase;" MAXLENGTH="3" onBlur="document.form.eg_id.value='';document.form.search_flg.value='';"></td>
								<td width="50" class="stm">Level 3</td>
								<td><select name="svc_cate_cd" style="width:125" onChange="document.form.eg_id.value='';document.form.search_flg.value='';">
									<option value="" selected>&lt;&lt; select &gt;&gt;</option>
									<option value="TR"> Truck</option>
									<option value="RL"> Rail</option>
									<option value="CY"> ODCY</option>
									<option value="TM"> Terminal</option>
									<option value="WT"> Water</option>
									<option value="EQ"> EQ M&amp;R</option>
								</select></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->


			<table class="height_10"><tr><td></td></tr></table>


			<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg">


						<table width="100%" class="search">
							<tr><td class="gray_tit"><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0"> Evaluation Group</td></tr>
						</table>


						<!-- Grid : Week (S) -->
						<table width="100%" id="mainTable">
				       		<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
						</table>
						<!-- Grid : Week (E) -->


						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btn_delete" name="btn_delete">Delete</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btn_save" name="btn_save">Save</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->



					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>