<%--/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_REPO_COMMON.jsp
*@FileTitle : getting scenario id 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.event.EesCommonEvent"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO"%>
<%@ page import="com.clt.syscommon.common.table.EqrEqRepoPlnVO"%>
<%@ page import="java.util.List,java.util.Iterator"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesCommonEvent  event = null;				          //PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;	      //RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			          //error from server
	List<EqrEqRepoPlnVO> list	  = null;							  //DB ResultSet
	String strErrMsg = "";								  //error message
	int rowCount	 = 0;								  //count of DB resultSET list
	String scnr_id  ="";
	String repo_pln_id = "";
	String repo_rmk  ="";
	String type = "";
	String dtrb_flg = "";
	
	String[] info = null;
	String[] info1 = null;
	String[] info2 = null;
	String   info3 = null;
	String[] info4 = null;
	String   info5 = null;
	String[] info6 = null;
	String   info7 = null;
	String   info8 = null;
	String[] info9 = null;
	String   info11= null;
	String st_year 		= "";
	String st_month 	= "";
	String st_weekly 	= "";
	String end_year 	= "";
	String end_month 	= "";
	String end_weekly 	= "";
	String perfix_month = "";
	String title_month 	= "";
	String perfix_weekly= "";
	String title_weekly = "";
	String perfix_monthly="";
	String monthly_count= "";
	String max_weekly 	= "";
	String max_plnYr 	= "";
	String max_plnMon 	= "";
	String fromToPlnId 	= "";
	String scnrIdList 	= "";
	String repoPlnIdList= "";
	String max_plnYrWk 	= "";
	String todayWeekly 	= "";
	String exePlnEditFlg= "";
	String exePlnEditFlg_split= "";
	String maxWkStr 	= "";	
	String repoPlnNextWeek= "";	
	String sType = "";
	String replPlnYn = "";
	try {
		//SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	//userId=account.getUsr_id();
	   	//userAuth=account.getAuth(); 
	  	event = (EesCommonEvent)request.getAttribute("Event");
	  
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		sType = StringUtil.xssFilter(request.getParameter("Type"));
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {

				EesCommonConditionVO condiVO = event.getEesCommonConditionVO();
				EesCommonVO eesCommonVO = (EesCommonVO)eventResponse.getCustomData("RetVO");
				list = eesCommonVO.getList();
				//getting year, week, month  
				info = eesCommonVO.getResultset();
				// getting for month title
				info1 = eesCommonVO.getResultset1();
				// getting for week title
				info2 = eesCommonVO.getResultset2(); 
				// getting month with week
				info3 = eesCommonVO.getResultset3();
				// getting 9 weeks
				info4 = eesCommonVO.getResultset4();

				info5 = eesCommonVO.getResultset5();
				// getting scnr_id list of pln id
				info6 = eesCommonVO.getResultset6();
				// getting current year, week
				info7 = eesCommonVO.getResultset7();
				// exePlnEditFlg : edit disable if planwk < local wk 
				info8 = eesCommonVO.getResultset8();
				// maxWk Str(seperator : ,)
				info9 = eesCommonVO.getResultset9();
				// next week of repo plan week
				repoPlnNextWeek	 = eesCommonVO.getResultset10();	
				
				// exePlnEditFlg PrevOneWeek : edit available only split & last week
				info11 = eesCommonVO.getResultset11();
						
				if(list != null ){
					rowCount = list.size();//rowSet.getRowCount();
					Iterator itreator = list.iterator();
					 while (itreator.hasNext()) {
						EqrEqRepoPlnVO vo = (EqrEqRepoPlnVO)itreator.next();
						
				    	scnr_id  = JSPUtil.getNull(vo.getScnrId());
					 	repo_rmk 	= JSPUtil.getNull(vo.getRepoPlnRmk());
					 	type     	= JSPUtil.getNull(vo.getStatus());
					 	repo_pln_id = JSPUtil.getNull(vo.getRepoPlnId());
					 	dtrb_flg = JSPUtil.getNull(vo.getRepoPlnDtrbFlg());
					 	replPlnYn = JSPUtil.getNull(vo.getRepoPlnLst());
					 }
				}
				st_year 		= JSPUtil.getNull(info[0]);    // starting  year 
				st_weekly 		= JSPUtil.getNull(info[1]);   // starting week 
				st_month 		= JSPUtil.getNull(info[2]);   // starting month 
				end_year 		= JSPUtil.getNull(info[3]);    // ending year 
				end_weekly 		= JSPUtil.getNull(info[4]); // ending week. 
				end_month 		= JSPUtil.getNull(info[5]);   // ending month .
				perfix_month 	= JSPUtil.getNull(info1[0]); 
				title_month 	= JSPUtil.getNull(info1[1]);    
				perfix_weekly 	= JSPUtil.getNull(info2[0]);  
				title_weekly 	= JSPUtil.getNull(info2[1]);   
				perfix_monthly 	= JSPUtil.getNull(info2[2]); 
				monthly_count 	= JSPUtil.getNull(info3); 
				max_plnYr 		= JSPUtil.getNull(info4[3]);		
				max_weekly 		= JSPUtil.getNull(info4[4]); //ending  9th week.		
				max_plnMon  	= JSPUtil.getNull(info4[5]); //ending  month of 9th week
				fromToPlnId 	= JSPUtil.getNull(info5);   
				scnrIdList 		= JSPUtil.getNull(info6[0]); //scnr_id List of pln id
				repoPlnIdList 	= JSPUtil.getNull(info6[1]);//repo_pln_id List of pln id
				todayWeekly 	= JSPUtil.getNull(info7);	// current year, week
				exePlnEditFlg 	= JSPUtil.getNull(info8);	// exePlnEditFlg : edit disable if planwk < local wk 
				exePlnEditFlg_split= JSPUtil.getNull(info11);	
				maxWkStr 		= JSPUtil.getNull(info9[0]);//
				
				max_plnYrWk = max_plnYr + max_weekly; 
				
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<html>
<head>
<title>getting scenario id </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function push() {
  		var keycheked = "<%=type%>";
  		
  		if (keycheked != "") {
  			parent.document.form.scnr_id.value = "<%=scnr_id%>";
  			parent.document.form.repo_rmk.value = document.form.remark.value;
  			parent.document.form.repo_rmk.title = document.form.remark.value;
  			parent.document.form.st_year.value = "<%=st_year%>";
  			parent.document.form.st_month.value = "<%=st_month%>";
  			parent.document.form.st_weekly.value = "<%=st_weekly%>";
  			parent.document.form.end_year.value ="<%=end_year%>";
  			parent.document.form.end_month.value ="<%=end_month%>";
  			parent.document.form.end_weekly.value = "<%=end_weekly%>";
  			parent.document.form.perfix_month.value = "<%=perfix_month%>";
  			parent.document.form.title_month.value ="<%=title_month%>";
  			parent.document.form.perfix_weekly.value ="<%=perfix_weekly%>";
  			parent.document.form.title_weekly.value = "<%=title_weekly%>";
  			parent.document.form.monthly_count.value = "<%=monthly_count%>";
  			parent.document.form.status_type.value = "<%=type%>";
  			parent.document.form.dtrb_flg.value = "<%=dtrb_flg%>";
  			parent.document.form.max_weekly.value = "<%=max_weekly%>";
  			parent.document.form.fromToPlnId.value = "<%=fromToPlnId%>";
  			parent.document.form.max_plnYrWk.value = "<%=max_plnYrWk%>";
  			if(parent.document.form.scnrIdList != null )  	parent.document.form.scnrIdList.value 	= "<%=scnrIdList%>";
  			if(parent.document.form.repoPlnIdList != null ) parent.document.form.repoPlnIdList.value= "<%=repoPlnIdList%>";
  			if(parent.document.form.max_plnYr != null )  	parent.document.form.max_plnYr.value 	= "<%=max_plnYr%>";
  			if(parent.document.form.max_plnMon != null )  	parent.document.form.max_plnMon.value 	= "<%=max_plnMon%>";
  			if(parent.document.form.todayWeekly != null )  	parent.document.form.todayWeekly.value 	= "<%=todayWeekly%>";
  			if(parent.document.form.exePlnEditFlg != null ) parent.document.form.exePlnEditFlg.value= "<%=exePlnEditFlg%>";
  			if(parent.document.form.exePlnEditFlg_split != null ) parent.document.form.exePlnEditFlg_split.value= "<%=exePlnEditFlg_split%>";
  			if(parent.document.form.repoPlnNextWeek != null ) parent.document.form.repoPlnNextWeek.value = "<%=repoPlnNextWeek%>";
  			
  			if("Y" == "<%=replPlnYn%>") {
  				parent.ComBtnDisable("btn_create");
  				parent.ComBtnDisable("btn_delete");
  			}else{
  				parent.ComBtnDisable("t1btng_rowadd");
  				parent.ComBtnDisable("t1btng_rowdelete");
  				
  				parent.ComBtnDisable("btn_create");
  				parent.ComBtnEnable("btn_delete");
  			}
  			parent.document.form.maxWkStr.value = "<%=maxWkStr%>";  
  			parent.ibSearchAsync03();
  			parent.setEccCommon();
  			
  		} else {
  			var jType = "<%=sType%>";
  			if(jType != "Loading") { 
  				parent.ComBtnDisable("btn_create");
  				parent.ComBtnDisable("btn_delete");
   				//ComShowCodeMessage("EQR90005");
  			}
   			
   			parent.document.form.repo_rmk.value = "";
   			parent.document.form.st_year.value = "";
   			parent.document.form.st_month.value = "";
   			parent.document.form.st_weekly.value = "";
   			parent.document.form.end_year.value ="";
   			parent.document.form.end_month.value ="";
   			parent.document.form.end_weekly.value = "";
   			parent.document.form.perfix_month.value = "";
   			parent.document.form.title_month.value ="";
   			parent.document.form.perfix_weekly.value ="";
   			parent.document.form.title_weekly.value = "";
   			parent.document.form.monthly_count.value = "";
   			parent.document.form.status_type.value = "";
   			parent.document.form.dtrb_flg.value = "";
   			parent.document.form.max_weekly.value = "";
   			parent.document.form.fromToPlnId.value = "";
   			parent.document.form.max_plnYrWk.value = "";
  			if(parent.document.form.scnrIdList != null )  	parent.document.form.scnrIdList.value = "";
  			if(parent.document.form.repoPlnIdList != null ) parent.document.form.repoPlnIdList.value = "";
  			if(parent.document.form.max_plnYr != null )  	parent.document.form.max_plnYr.value = "";
  			if(parent.document.form.max_plnMon != null )  	parent.document.form.max_plnMon.value = "";
  			if(parent.document.form.todayWeekly != null )  	parent.document.form.todayWeekly.value = "";
  			if(parent.document.form.exePlnEditFlg != null ) parent.document.form.exePlnEditFlg.value = "";
  			if(parent.document.form.exePlnEditFlg_split != null ) parent.document.form.exePlnEditFlg_split.value = "";
  			if(parent.document.form.repoPlnNextWeek != null ) parent.document.form.repoPlnNextWeek.value = "";
  			parent.document.form.maxWkStr.value = "";
  			parent.ibSearchAsync03();
   			parent.setEccCommon();
   			
  		}
 	}

</script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		push();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="remark" value="<%=repo_rmk%>">
</form>
</body>
</html>