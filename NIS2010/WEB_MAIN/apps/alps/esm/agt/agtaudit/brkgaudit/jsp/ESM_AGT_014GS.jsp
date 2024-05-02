<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_014GS.jsp
*@FileTitle : Brokerage Detail & History fo BL Pop-up 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-23
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-23 Hwang GyeongNam
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
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.event.ESM_AGT_014Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.event.ESM_AGT_014EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%
	ESM_AGT_014Event event = null;
	ESM_AGT_014EventResponse eventResponse = null;	// RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;				// 서버에서 발생한 에러
	DBRowSet basicInfoRowSet = null;				// Database ResultSet (Basic Info)
	DBRowSet chargeRowSet = null;					// Database ResultSet (Charge Detail)
	DBRowSet historyRowSet = null;					// Database ResultSet (History Detail)
	DBRowSet rateRowSet	= null;						// Database ResultSet (요율 정보)
	String strErrMsg = "";							// 에러메세지
	int historyRowCount = 0;						// History Detail DB ResultSet 리스트의 건수
	int i = 1;
	
	String bl_no = "";
	String bkg_no_tmp = "";
	String vsl_dep_dt = "";
	String shpr_cnt_seq = "";
	String shpr_nm = "";
	String frt_fwrd_cnt_seq = "";
	String vndr_cnt_seq = "";
	String frt_fwrd_nm = "";	
	String comm_vsl = "";
	String bkg_por_cd = "";
	String bkg_pol_cd = "";
	String bkg_pod_cd = "";
	String bkg_del_cd = "";
	String brog_ref_no = "";
	String fmc_no = "";
	String sc_no = "";
	String rfa_no = "";
	String brog_knd_cd = "";

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESM_AGT_014Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_014EventResponse)request.getAttribute("EventResponse");
			
			if (eventResponse != null) {
				
				basicInfoRowSet = eventResponse.getBasicInfo();
				chargeRowSet = eventResponse.getChargeDetail();
				historyRowSet = eventResponse.getHistoryDetail();
				rateRowSet = eventResponse.getRateInfo();
				
				if(historyRowSet != null){
					historyRowCount = historyRowSet.getRowCount();
				} // end if
			} // end if
			
			if (basicInfoRowSet != null) {
				if (basicInfoRowSet.next()) {
					bl_no = JSPUtil.getNull(basicInfoRowSet.getString("bl_no"));
					bkg_no_tmp = JSPUtil.getNull(basicInfoRowSet.getString("bkg_no_tmp"));
					vsl_dep_dt = JSPUtil.getNull(basicInfoRowSet.getString("vsl_dep_dt"));
					shpr_cnt_seq = JSPUtil.getNull(basicInfoRowSet.getString("shpr_cnt_seq"));
					shpr_nm = JSPUtil.getNull(basicInfoRowSet.getString("shpr_nm"));
					frt_fwrd_cnt_seq = JSPUtil.getNull(basicInfoRowSet.getString("frt_fwrd_cnt_seq"));
					vndr_cnt_seq = JSPUtil.getNull(basicInfoRowSet.getString("vndr_cnt_seq"));
					frt_fwrd_nm = JSPUtil.getNull(basicInfoRowSet.getString("frt_fwrd_nm"));	
					comm_vsl = JSPUtil.getNull(basicInfoRowSet.getString("comm_vsl"));
					bkg_por_cd = JSPUtil.getNull(basicInfoRowSet.getString("bkg_por_cd"));
					bkg_pol_cd = JSPUtil.getNull(basicInfoRowSet.getString("bkg_pol_cd"));
					bkg_pod_cd = JSPUtil.getNull(basicInfoRowSet.getString("bkg_pod_cd"));
					bkg_del_cd = JSPUtil.getNull(basicInfoRowSet.getString("bkg_del_cd"));
					brog_ref_no = JSPUtil.getNull(basicInfoRowSet.getString("brog_ref_no"));
					fmc_no = JSPUtil.getNull(basicInfoRowSet.getString("fmc_no"));
					sc_no = JSPUtil.getNull(basicInfoRowSet.getString("sc_no"));
					rfa_no = JSPUtil.getNull(basicInfoRowSet.getString("rfa_no"));
					brog_knd_cd = JSPUtil.getNull(basicInfoRowSet.getString("brog_knd_cd"));						
				}
			}
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<%
	if (serverException == null) {
%>
<SHEET>
	<ETC-DATA>
		<ETC KEY="bl_no"><![CDATA[<%=bl_no%>]]></ETC>
		<ETC KEY="bkg_no_tmp"><![CDATA[<%=bkg_no_tmp%>]]></ETC>	
		<ETC KEY="vsl_dep_dt"><![CDATA[<%=vsl_dep_dt%>]]></ETC>
		<ETC KEY="shpr_cnt_seq"><![CDATA[<%=shpr_cnt_seq%>]]></ETC>
		<ETC KEY="shpr_nm"><![CDATA[<%=shpr_nm%>]]></ETC>
		<ETC KEY="frt_fwrd_cnt_seq"><![CDATA[<%=frt_fwrd_cnt_seq%>]]></ETC>
		<ETC KEY="vndr_cnt_seq"><![CDATA[<%=vndr_cnt_seq%>]]></ETC>
		<ETC KEY="frt_fwrd_nm"><![CDATA[<%=frt_fwrd_nm%>]]></ETC>
		<ETC KEY="comm_vsl"><![CDATA[<%=comm_vsl%>]]></ETC>
		<ETC KEY="bkg_por_cd"><![CDATA[<%=bkg_por_cd%>]]></ETC>
		<ETC KEY="bkg_pol_cd"><![CDATA[<%=bkg_pol_cd%>]]></ETC>
		<ETC KEY="bkg_pod_cd"><![CDATA[<%=bkg_pod_cd%>]]></ETC>
		<ETC KEY="bkg_del_cd"><![CDATA[<%=bkg_del_cd%>]]></ETC>
		<ETC KEY="brog_ref_no"><![CDATA[<%=brog_ref_no%>]]></ETC>
		<ETC KEY="fmc_no"><![CDATA[<%=fmc_no%>]]></ETC>
		<ETC KEY="sc_rfa_no"><![CDATA[<%=sc_no%> / <%=rfa_no%>]]></ETC>
		<ETC KEY="brog_knd_cd"><![CDATA[<%=brog_knd_cd%>]]></ETC>
				
		<ETC KEY="sxml1">
    		<![CDATA[
    		<?xml version="1.0" ?>
    		<SHEET>
				<DATA>
<%
		i =1;
		if (chargeRowSet != null) {
			while (chargeRowSet.next()) {
%>
					<TR>
<%
				for (int j=0; j<chargeRowSet.getMetaData().getColumnCount(); j++) {
%>
						<TD><%=JSPUtil.getNull(chargeRowSet.getString(1))%></TD>
						<TD><%=JSPUtil.getNull(chargeRowSet.getString(2))%></TD>
<%
				}
%>
					</TR>
<%
			}
		}
%>
				</DATA>
			</SHEET>
			]]>
    	</ETC>
		<ETC KEY="sxml2">
    		<![CDATA[
    		<?xml version="1.0" ?>
    		<SHEET>
    			<DATA>
<%
		i = 1;

		if (historyRowSet != null) {
			while (historyRowSet.next()) {
%>
					<TR>
<%				
				for (int j=0; j<historyRowSet.getMetaData().getColumnCount(); j++) {
%>
						<TD><%=JSPUtil.getNull(historyRowSet.getString(i++))%></TD>
<%				
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
			]]>
    	</ETC>
		<ETC KEY="sxml3">
    		<![CDATA[
    		<?xml version="1.0" ?>
    		<SHEET>
    			<DATA>
<%
		i = 1;

		if (rateRowSet != null) {
			while (rateRowSet.next()) {
%>
					<TR>
						<TD></TD>
<%				
				for (int j=0; j<rateRowSet.getMetaData().getColumnCount(); j++) {
%>
						<TD><%=JSPUtil.getNull(rateRowSet.getString(i++))%></TD>
<%				
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
			]]>
    	</ETC>
    </ETC-DATA>
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