<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_033GS.jsp
*@FileTitle : Brokerage Commission Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-17
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-17 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.event.ESM_AGT_033Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.event.ESM_AGT_033EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%

	ESM_AGT_033Event event = null;
	ESM_AGT_033EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;				//서버에서 발생한 에러
	DBRowSet rowSet = null;							//DB ResultSet
	String strErrMsg = "";							//에러메세지
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESM_AGT_033Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_033EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}

	if (serverException == null) {
%>
<SHEET>
	<DATA TOTAL="<%=rowCount%>">
<%
		String brog_sts = "";	// Brokerage status
		String bkg_sts = "";	// Booking status
		String bl_no = "";		// bl_no
		String fac_div_cd = "";	//fac_div_cd
		String fac_div_cd_1 = "";	//fac_div_cd 첫째자리 값
		String td_base = "";		
		String td_properties1 = "";
		String td_properties2 = "";
		String td_properties3 = "";
		String td_properties4 = "";
		String sBl_comm_amt = "";
		String sAct_comm_amt = "";
		String sCntr_comm_amt = "";
		String sComm_amt = "";

        // 2009-04-15 (kevin) CURR_CD 추가
		//String curr_cd = "";

		double dComm_amt = 0;
		double dBl_comm_amt = 0;
		double dAct_comm_amt = 0;
		double dCntr_comm_amt = 0;
		
		int i = 1;
		if (rowSet != null) {
			while (rowSet.next()) {
				
				td_base = ""; //초기화
				
				brog_sts = JSPUtil.getNull(rowSet.getString("COMM_PROC_STS_CD"));
				bkg_sts = JSPUtil.getNull(rowSet.getString("BKG_STS_CD"));
				bl_no = (JSPUtil.getNull(rowSet.getString("BL_NO"))).trim();
				fac_div_cd = JSPUtil.getNull(rowSet.getString("FAC_DIV_CD"));
				fac_div_cd_1 = JSPUtil.getNull(rowSet.getString("FAC_DIV_CD_1"));
				sBl_comm_amt = JSPUtil.getNull(rowSet.getString("BL_COMM_AMT"));
				sAct_comm_amt = JSPUtil.getNull(rowSet.getString("ACT_COMM_AMT"));
				sCntr_comm_amt = JSPUtil.getNull(rowSet.getString("CNTR_COMM_AMT"));
				
                // 2009-04-15 (kevin) CURR_CD 추가
				//curr_cd = JSPUtil.getNull(rowSet.getString("CURR_CD"));

				if("CE".equals(brog_sts)) {
					td_base = "COLOR=\"RED\"";
				} else if("CM".equals(brog_sts)) {
					td_base = "COLOR=\"BLUE\"";
				}

				td_properties1 = td_base;
				td_properties4 = td_base + " Edit=\"false\"";
				
				if( "CM".equals(brog_sts) ) {
					td_properties1 = td_properties1 + " Edit=\"false\"";
				} else {
					if( !("F".equals(bkg_sts) && bl_no.length() > 0) ) {
						td_properties1 = td_properties1 + " Edit=\"false\"";
					}
				}
%>
		<TR>
			<TD <%=td_properties1%>></TD>
			<TD>R</TD>
			<TD <%=td_properties1%>></TD>
<%
				for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {

					if (j == 6 || j == 8 || j == 19) {

						td_properties2 = td_base; // 초기값 설정
						
						sComm_amt = (JSPUtil.getNull(rowSet.getString(i++))).trim();
						
						if(sComm_amt.length() > 0) {
							dComm_amt = Double.parseDouble(sComm_amt);
						}

						 // Commission이 '0' 이거나 Status가 'CM'이거나 Booking Status가 'F' 이고 BL이 존재하는 경우가 아닌 경우 수정할 수 없도록한다.
						if( !(dComm_amt != 0) || "CM".equals(brog_sts) || !("F".equals(bkg_sts) && bl_no.length() > 0) ) { 
							td_properties2 = td_properties2 + " Edit=\"false\"";
						} else {
							if( j == 6 && !"BL".equals(fac_div_cd) ) { // BL이 아닌 경우 수정 불가
								td_properties2 = td_properties2 + " Edit=\"false\"";
							} else if( j == 8 && ("BL".equals(fac_div_cd) || "C".equals(fac_div_cd_1)) ) { // BL 이거나 Container 이면 수정 불가
								td_properties2 = td_properties2 + " Edit=\"false\"";
							} else if( j == 19 && !"C".equals(fac_div_cd_1)) { // Container가 아닌 경우 수정 불가
								td_properties2 = td_properties2 + " Edit=\"false\"";
							}
						}
%>
			<TD <%=td_properties2%>><![CDATA[<%=sComm_amt%>]]></TD>
<%
					} else if ( j == 22 ) {
						
						td_properties3 = td_base;

						if(sBl_comm_amt.length() > 0) {
							dBl_comm_amt = Double.parseDouble(sBl_comm_amt);
						}						
						if(sAct_comm_amt.length() > 0) {
							dAct_comm_amt = Double.parseDouble(sAct_comm_amt);
						}
						if(sCntr_comm_amt.length() > 0) {
							dCntr_comm_amt = Double.parseDouble(sCntr_comm_amt);
						}

						if( ( !(dBl_comm_amt != 0) && !(dAct_comm_amt != 0) && !(dCntr_comm_amt != 0) ) 
							|| "CM".equals(brog_sts) 
							|| !("F".equals(bkg_sts) && bl_no.length() > 0) ) 
						{
							td_properties3 = td_properties3 + " Edit=\"false\"";
						}
%>
			<TD <%=td_properties3%>><![CDATA[<%=JSPUtil.getNull(rowSet.getString(i++))%>]]></TD>
<%
					} else {
%>
			<TD <%=td_properties4%>><![CDATA[<%=JSPUtil.getNull(rowSet.getString(i++))%>]]></TD>
<%
					}
				}
				i = 1;
%>
		</TR>
<%
			}
		}
%>
	</DATA>
</SHEET>
<%
	} else {
%>
<ERROR>
	<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
	}
%>
