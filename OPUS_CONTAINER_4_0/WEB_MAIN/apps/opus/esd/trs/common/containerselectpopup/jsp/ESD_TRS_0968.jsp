<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0968.jsp
*@FileTitle : request.getParameter를 XML 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.29
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2008.01.03 poong_yeon
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2010.09.29 최 선  1.1 [] CNTR Select Dup Check 수정
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.syscommon.common.table.TrsTrspSvcOrdVO"%>
<%
try{
	String prefix = request.getParameter("prefix");
	String mode = request.getParameter("mode");
	if(prefix == null) prefix = "";

	String [] ibflag				    = request.getParameterValues("ibflag");
	int codeLength = 0;
	if (ibflag != null) codeLength = ibflag.length;

	TrsTrspSvcOrdVO trsTrspSvcOrdVO = new TrsTrspSvcOrdVO();
	TrsTrspSvcOrdVO trsTrspSvcOrdVO2 = new TrsTrspSvcOrdVO();

	TrsTrspSvcOrdVO[] mainTrsTrspSvcOrdVOs = trsTrspSvcOrdVO.fromRequestGrid(request, prefix);
	TrsTrspSvcOrdVO[] popTrsTrspSvcOrdVOs = trsTrspSvcOrdVO2.fromRequestGrid(request);


	String org_bkg_no = null;
	String org_eq_no = null;

	boolean duplicateFlag = false;
	String tgt_so_seq = null;
	int duplicateCnt = 0;
	int totalCnt = 0;
	String resultStr = "";

	if(ibflag == null || ibflag.length < 1)
	{

%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%
		return;
	}else if("duplicate_check".equals(mode)){

		for(int i=0;popTrsTrspSvcOrdVOs!=null && i<popTrsTrspSvcOrdVOs.length; i++ ) {
			TrsTrspSvcOrdVO org_TrsTrspSvcOrdVO = (TrsTrspSvcOrdVO) popTrsTrspSvcOrdVOs[i];
			org_bkg_no = org_TrsTrspSvcOrdVO.getBkgNo();
			org_eq_no = org_TrsTrspSvcOrdVO.getEqNo();
			duplicateFlag = false;
			for(int k=0; mainTrsTrspSvcOrdVOs != null && k<mainTrsTrspSvcOrdVOs.length; k++){
				TrsTrspSvcOrdVO tgt_TrsTrspSvcOrdVO = (TrsTrspSvcOrdVO) mainTrsTrspSvcOrdVOs[k];
				if( (org_bkg_no.equals(tgt_TrsTrspSvcOrdVO.getBkgNo()) ||
					 org_bkg_no.equals(tgt_TrsTrspSvcOrdVO.getOrgBkgNo()))  &&
					 org_eq_no.equals(tgt_TrsTrspSvcOrdVO.getEqNo()) ){
					duplicateFlag = true;
					tgt_so_seq = tgt_TrsTrspSvcOrdVO.getTrspSoOfcCtyCd()+tgt_TrsTrspSvcOrdVO.getTrspSoSeq();
					duplicateCnt++;
					break;
				}
			}
			if(duplicateFlag) {
				org_TrsTrspSvcOrdVO.setSpclInstrRmk(tgt_so_seq);
			}
			popTrsTrspSvcOrdVOs[i] = org_TrsTrspSvcOrdVO;
		}
		if (popTrsTrspSvcOrdVOs != null ) {
			totalCnt = popTrsTrspSvcOrdVOs.length;
		}
%>
<SHEET>
	<DATA>
<%
		for(int i=0;popTrsTrspSvcOrdVOs!=null && i<popTrsTrspSvcOrdVOs.length; i++ ) {
			TrsTrspSvcOrdVO model = (TrsTrspSvcOrdVO) popTrsTrspSvcOrdVOs[i];
%>
		<TR ROW="<%=model.getPorCd()%>">
			<TD COL="dup_check"><![CDATA[<%=model.getSpclInstrRmk()%>]]></TD>
		</TR>
<%
		}
		if(duplicateCnt == 0) resultStr = "S";
		else if(totalCnt == duplicateCnt) resultStr = "F";
		else resultStr = "P";

%>
  </DATA>
<!-- 선택항목1. ETC-DATA 요소 -->
  <ETC-DATA>
       <ETC KEY='RESULT'><![CDATA[<%=resultStr%>]]></ETC>
  </ETC-DATA>
</SHEET>
<%

	}

}catch(Exception e){
//	e.printStackTrace();
%>
<ERROR>
	<MESSAGE> <![CDATA[ <% out.println(e.getMessage()); %>]]> </MESSAGE>
</ERROR>
<%
	throw new Exception(e.getMessage());
}
%>