<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0970.jsp
*@FileTitle : request.getParameter를 XML 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-19
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2007-11-19 poong_yeon
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="com.hanjin.syscommon.common.table.TrsTrspScgDtlVO"%>
<%
try{
	String prefix = request.getParameter("prefix");
	if(prefix == null) prefix = "";

	String [] ibflag				= request.getParameterValues(prefix+"ibflag");
	String multi_ofc_cty_cdStr		= null;
	String [] multi_ofc_cty_cdArray = null;
	String multi_so_seqStr			= null;
	String [] multi_so_seqArray		= null;
	String multi_cgo_tp_cdStr		= null;
	String [] multi_cgo_tp_cdArray	= null;
	String mode						= request.getParameter("mode");

	if(ibflag == null || ibflag.length < 1)
	{
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%
		return;
	}

	multi_ofc_cty_cdStr			= request.getParameter("multi_ofc_cty_cdStr");
	multi_so_seqStr				= request.getParameter("multi_so_seqStr");
	multi_cgo_tp_cdStr			= request.getParameter("multi_cgo_tp_cdStr");

	if(	multi_ofc_cty_cdStr != null &&
		multi_so_seqStr != null) {
	
		multi_ofc_cty_cdArray	= multi_ofc_cty_cdStr.split("[|]");
		multi_so_seqArray		= multi_so_seqStr.split("[|]");
		
	ArrayList sheetV			= new ArrayList();
	String emStr				= null;

	Enumeration emParamName		= request.getParameterNames();
	while(emParamName.hasMoreElements())
	{
		emStr = (String) emParamName.nextElement();
		if(request.getParameterValues(emStr).length == ibflag.length){
			sheetV.add(emStr);
		}
	}

	/* COLORDER 생성 */
	StringBuffer colOrder = new StringBuffer();
	for(int k=0; k<sheetV.size(); k++) {
		colOrder.append((String) sheetV.get(k));
		if(k != sheetV.size()-1) colOrder.append("|");
	}
	colOrder = new StringBuffer((colOrder==null?colOrder.toString():colOrder.toString().toLowerCase()));
	/* COLORDER 생성끝 */

	if("copy_surcharge_popup".equals(mode)){
		multi_cgo_tp_cdArray	= multi_cgo_tp_cdStr.split("[|]");
		String lgsCostCd = null;
%>
<SHEET>
	<DATA TOTAL="<%=ibflag.length * multi_so_seqArray.length%>" COLORDER="<%=colOrder%>">
<%
	for(int w=0; w<multi_so_seqArray.length; w++){

		for(int k=0; k<ibflag.length; k++) {
%>
		<TR>
<%
			for(int j = 0 ; j < sheetV.size() ; j++) {
				
				if( (prefix+"unique_cd").equals((String)sheetV.get(j))) {
%>
			<TD><![CDATA[<%=JSPUtil.getNull(multi_so_seqArray[w]) %>]]></TD>
<%
				}else if ( (prefix+"trsp_so_ofc_cty_cd").equals((String)sheetV.get(j))) {
				
%>				
			<TD><![CDATA[<%=JSPUtil.getNull(multi_ofc_cty_cdArray[w]) %>]]></TD>
<%
				}else if( (prefix+"trsp_so_seq").equals((String)sheetV.get(j))) {
%>
			<TD><![CDATA[<%=JSPUtil.getNull(multi_so_seqArray[w]) %>]]></TD>
<%
				}else if( (prefix+"lgs_cost_cd").equals((String)sheetV.get(j))) {

					lgsCostCd = request.getParameterValues((String)sheetV.get(j))[k];
					//System.out.println("multi_cgo_tp_cdArray["+w+"]="+multi_cgo_tp_cdArray[w]);
					if(lgsCostCd!=null && lgsCostCd.length()>2){
						if(	"F".equals(multi_cgo_tp_cdArray[w]) || "C".equals(multi_cgo_tp_cdArray[w])	) {
							lgsCostCd = "SC"+lgsCostCd.substring(2);
						}else{
							lgsCostCd = "SM"+lgsCostCd.substring(2);
						}
					}
%>
			<TD><![CDATA[<%=lgsCostCd%>]]></TD>
<%
				}else{
%>
			<TD><![CDATA[<%=JSPUtil.getNull(request.getParameterValues((String)sheetV.get(j))[k]) %>]]></TD>
<%
				}
			}
%>
		</TR>
<%
		}
	}
%>
	</DATA>
</SHEET>
<%
	}else if("main_surcharge_dup_check".equals(mode)){
	boolean [] deleteFlag = new boolean[ibflag.length];

	for(int w=0; w<multi_so_seqArray.length; w++){

		for(int k=0; k<ibflag.length; k++) {

			if(deleteFlag[k] || multi_so_seqArray[w].equals(JSPUtil.getNull(request.getParameterValues(prefix+"unique_cd")[k]))){
				deleteFlag[k] = true;
			}
		}
	}



%>
<SHEET>
	<DATA COLORDER="<%=colOrder%>">
<%
		for(int k=0; k<ibflag.length; k++) {
			if(!deleteFlag[k]) {
%>
			<TR>
<%
				for(int j = 0 ; j < sheetV.size() ; j++) {
%>
				<TD><![CDATA[<%=JSPUtil.getNull(request.getParameterValues((String)sheetV.get(j))[k]) %>]]></TD>
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
<%
	}
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