<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0012.jsp
*@FileTitle  : OceanLink Information Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/16
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.event.EsdPrd0012Event"%>
<%
	EsdPrd0012Event  event = null;				    //PDTO(Data Transfer Object including Parameters)
	
	Exception serverException   = null;			    //error from server
	DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//error message
	int rowCount	 = 0;							//count of DB resultSET list
	String optStr="|000010:N:No Change";
	try {
		event = (EsdPrd0012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("ts_ind_cd", "N", "CD00128", 0, optStr)%>
	<%= JSPUtil.getIBCodeCombo("day_cd", "01", "CD00131", 0, "")%>	
	<%= JSPUtil.getIBCodeCombo("dir_cd", "01", "CD00593", 0, "")%>	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
 
		loadPage();
	}
</script>


<form method="post" name="form" id="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">


	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title"></span>
			</button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button><!-- 
		     --></div>
		    <!-- opus_design_btn(E) -->
	    
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	
	</div>
	<!-- page_title_area(E) -->
	
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	         <colgroup>
	            <col width="50" />
	            <col width="130" />
	            <col width="50" />
	            <col width="130" />
	            <col width="50" />
	            <col width="130" />
	            <col width="50" />
	            <col width="130" />
	            <col width="80" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr>
					<th>Status</th>
					<td><!-- 
						 --><select style="width:100px;" class="input" name="delt_flg" id="delt_flg" ><!-- 
			            	 --><option value="A"  >All</option><!-- 
	       		     		 --><option value="N" selected>Live</option><!-- 
	      		   			 --><option value="Y">Deleted</option><!--       		   					    
                         --></select><!-- 
					 --></td>
					<th>Lane</th>
					<td><input type="text" name="vsl_lane_cd" id="vsl_lane_cd" maxlength="3" value="<%=event.getString("vsl_lane_cd")%>" style="width:100px;text-align:center" tabIndex="1"  dataformat="engup" style="text-align:center"><button class="input_seach_btn" name="btn_lane_cd" id="btn_lane_cd" type="button"></button></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="fm_port_cd" id="fm_port_cd" maxlength="5" value="<%=event.getString("fm_port_cd")%>" style="width:100px;text-align:center"  tabIndex="2"   dataformat="engup" style="text-align:center"><button class="input_seach_btn" name="btn_pol_cd" id="btn_pol_cd" type="button"></button></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="to_port_cd" id="to_port_cd" maxlength="5" value="<%=event.getString("to_port_cd")%>" style="width:100px;text-align:center"  tabIndex="3"  dataformat="engup" style="text-align:center"><button class="input_seach_btn" name="btn_pod_cd" id="btn_pod_cd" type="button"></button></td>
					<th>Direction</th>
					<td><!-- 
						 --><input type="hidden" name="skd_dir_cd" id="skd_dir_cd" value="<%=event.getString("skd_dir_cd")%>"><!-- 
						 --><select name="select1" id="select1" style="width:100px" onChange="changeDirection()"><!-- 
							 --><option value="0" selected>ALL</option><!-- 
							 --><option value="E">E</option><!-- 
							 --><option value="W">W</option><!-- 
							 --><option value="S">S</option><!-- 
							 --><option value="N">N</option><!-- 
						 --></select><!-- 
					 --></td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn"><!-- 
	         --><button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!-- 
	         --><button type="button" class="btn_normal" name="btng_constraint" id="btng_constraint">Constraint</button><!-- 
	     --></div>
	    <!-- opus_design_btn(E) -->
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script  type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
