<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0002GS.jsp
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : SeongMun_Kang
*@LastVersion : 1.0
* 2006-08-29 SeongMun_Kang
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.ESD_SCE_0001EventResponse_N"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.ESD_SCE_0001Event_N"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet" %>

<%
    ESD_SCE_0001EventResponse_N eventResponse   = null;
	ESD_SCE_0001Event_N event = null;
    Exception                serverException = null;
    DBRowSet                 rowSet          = null;
    String                   strErrMsg       = "";
    String[]                 dlvDTs          = null ;
    String                   dlvPlnDate      = "" ;
    String                   dlvPlnTime      = "" ;
    String                   dlvEstmDate     = "" ;
    String                   dlvEstmTime     = "" ;
    int                      totalCount      = 0;
//System.out.println("-------------------------------------tgs");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (ESD_SCE_0001EventResponse_N)request.getAttribute("EventResponse");
			event = (ESD_SCE_0001Event_N)request.getAttribute("Event");
            if (eventResponse != null) {
                rowSet     = eventResponse.getRowSet();
                totalCount = eventResponse.getTotalCount();
//System.out.println("-------------------------------------tgs1"+totalCount);
//                out.println("\n totalCount:"+totalCount);

            } // end if
        } // end else
    }catch(Exception e) {
        out.println(e.toString());
    }

%>
<%
	if (serverException == null) {
		FormCommand formcommand = event.getFormCommand();
		if( formcommand.isCommand(FormCommand.MODIFY) ) {
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%
		} else {

			%>

			<SHEET>
				<DATA TOTAL="<%=totalCount%>">
			<%
						String scop_sub_sts_cd = "";
						String scop_sts_cd = "";
						boolean bact = false;
						while(rowSet!=null&&rowSet.next()){
							dlvDTs   = rowSet.getString("dlv_dts").split("#") ;
			//System.out.println("-------------------------------------tgs2");
							if( dlvDTs.length == 2 ) {
								if( dlvDTs[0]!=null && dlvDTs[0].length()>10 ) {
									dlvPlnDate = dlvDTs[0].substring(0,10) ;
			//System.out.println("-------------------------------------tgs31"+dlvPlnDate);
									dlvPlnTime = dlvDTs[0].substring(11) ;
			//System.out.println("-------------------------------------tgs32"+dlvPlnTime);
								}
								if(dlvDTs[1]!=null&&dlvDTs[1].length()>10){
									dlvEstmDate = dlvDTs[1].substring(0,10) ;
			//System.out.println("-------------------------------------tgs41"+dlvEstmTime);
									dlvEstmTime = dlvDTs[1].substring(11) ;
			//System.out.println("-------------------------------------tgs42"+dlvEstmTime);
								}
							} else {
								dlvEstmDate = "" ;
								dlvEstmTime = "" ;
							}
							scop_sub_sts_cd = JSPUtil.getNull(rowSet.getString("COP_SUB_STS_CD"));
							scop_sts_cd = JSPUtil.getNull(rowSet.getString("COP_STS_CD"));
							if( scop_sts_cd.equals("F") || scop_sts_cd.equals("T") ) {
								bact = true;
							} else {
								bact = false;
							}
						// minestar Partial Cntr 일 경우에만 Master 여부 표시
						String szCntrVolQyt = JSPUtil.getNull(rowSet.getString("cntr_vol_qty"));
					//	String szMstLclCd = "1".equals( szCntrVolQyt)?"":JSPUtil.getNull(rowSet.getString("mst_lcl_cd"));
						String szMstLclCd = JSPUtil.getNull( rowSet.getString("mst_lcl_cd"));
			//System.out.println("-------------------------------------tgs5"+szCntrVolQyt);
			//System.out.println("-------------------------------------tgs6"+szMstLclCd);
							
			%>

<TR>
<TD></TD>
<TD></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cop_ext_sts_cd"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cop_no"))%>]]></TD>
<TD HIDDEN="TRUE"><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cop_grp_seq"))%>]]></TD>
<TD HIDDEN="TRUE"><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cop_dtl_seq"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("bkg_no"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("bkg_no_split"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cntr_no_v"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cntr_tpsz_cd"))%>]]></TD>
<TD><![CDATA[<%=szCntrVolQyt%>]]></TD>
<TD><![CDATA[<%=szMstLclCd%>]]></TD>
<TD><![CDATA[<%=scop_sts_cd%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cop_sts_nm"))%>]]></TD>
<TD EDIT='<%=bact?"":"FALSE"%>'><![CDATA[<%=scop_sub_sts_cd.equals("R")?"Y":"N"%>]]></TD>
<TD HIDDEN="TRUE"><![CDATA[<%=JSPUtil.getNull(rowSet.getString("ACT_CD"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("act_nm"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("nod_cd"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("pln_date"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("pln_time"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("estm_date"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("estm_time"))%>]]></TD>
<TD><![CDATA[<%=dlvPlnDate%>]]></TD>
<TD><![CDATA[<%=dlvPlnTime%>]]></TD>
<TD><![CDATA[<%=dlvEstmDate%>]]></TD>
<TD><![CDATA[<%=dlvEstmTime%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("due_date"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("due_time"))%>]]></TD>
<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cntr_no"))%>]]></TD>
<TD><![CDATA[<%=scop_sts_cd.equals("F")?scop_sub_sts_cd:""%>]]></TD>
</TR>

			<%
			}
			%>
			  </DATA>
			</SHEET>
			<%
					}
    } else {
%>
<ERROR>
<MESSAGE> <![CDATA[<%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }

%>