/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : DefaultViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2008-11-24
*@LastModifier : Lee SeungYol
*@LastVersion : 1.0
* 2008-11-24 Lee SeungYol
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.common.util.TrsDefaultViewAdapter;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Jin-O Choi
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0028ViewAdapter extends TrsDefaultViewAdapter {

	protected String makeDataTag(List vos, String prefix, Event event)
    {
        StringBuilder sbufXML = new StringBuilder();
        int totCnt = vos.size();
        int realCnt = vos.size();
        AbstractValueObject vo = (AbstractValueObject)vos.get(0);
        String realColNms[] = getColHeader(vo);
        String changedColNms[] = getChangedColNms(realColNms, prefix);
        if(vo.getMaxRows() > 0)
            totCnt = vo.getMaxRows();
        sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(totCnt).append("'>\n").toString());
        for(int i = 0; i < realCnt; i++)
        {
            Map colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();
            sbufXML.append("\t<TR><![CDATA[");
            int colCnt = realColNms.length;
            for(int j = 0; j < colCnt - 1; j++)
                sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[j]))))).append("\u261C\u261E").toString());

            sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[colCnt - 1]))))).append("]]></TR>\n").toString());
        }

        sbufXML.append("</DATA>\n");
        return sbufXML.toString();
    }
    
    protected String makeDataTag(DBRowSet rs, String prefix, Event event)
    {        
    	FormCommand	 formcommand	= event.getFormCommand();
        StringBuilder sb = new StringBuilder();
        if(rs.isPivot())
        {
            sb.append(makePivotDataTag(rs));
            return sb.toString();
        }
        String realColNms[] = getColHeader(rs);
        try
        {
        	if( formcommand.isCommand(FormCommand.MULTI) || 
    			formcommand.isCommand(FormCommand.MULTI03) || 
    			formcommand.isCommand(FormCommand.MULTI04) || 
    			formcommand.isCommand(FormCommand.MODIFY) || 
    			formcommand.isCommand(FormCommand.MULTI02) || 
    			formcommand.isCommand(FormCommand.SEARCHLIST12) ){	//저장XML인 경우
    			
    			sb.append("<RESULT>");
    			sb.append("<TR-ALL>OK</TR-ALL>");
    			sb.append("</RESULT>");
    			
    		}else if( formcommand.isCommand(FormCommand.SEARCH) ) {	//조회XML인 경우
    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                int colCount = realColNms.length;
                
                String colName    		= "";                
                String sLastchk   		= "";                
                String sBilIssStsCd 	= "";
                String sBilEdiRcvRsltCd = "";
                String sCgoTpCd 		= "";
                String sTrspBndCd 		= "";                
                String sSpclCgoCntrTpCd	= "";
                String sBkgSpe			= "";       
                String sInvNo	 		= "";
                String sTrspSoStsCd		= "";
                String sVndrAbbrNm		= "";
                String sCxlRqstRsn		= "";
                String sCxlRqstRjctRsn	= "";
                String sCntrWgt			= "";
                String sShprCustNm		= "";
                String sCneeCustNm		= "";
                String sEdiUsrId		= "";
                String sCmdtName		= "";
                String sRefNo			= "";
                String sIbdNo			= "";
                String sAutoXptSysNo	= "";
                String sInterRmk		= "";
                String sSpclInstrRmk	= "";
                
            	String sBgcolor   		= "BGCOLOR='239,235,239'";
            	
                while(rs.next()){
                	                	
                	String sChk1  			= "";
                    String sChk2   			= "";
                    String sChk3   			= "";
                    String sInterRmkChk		= "";
                    String sSpclInstrRmkChk	= "";
                    String sWoRjctRsn		= "";
                    String sLvSpclCgo		= "";
                    String sLvSpclCgoChk	= "";
                	                	
                	sLastchk 		 = getNull(rs.getString("LASTCHK"));
                	sBilIssStsCd 	 = getNull(rs.getString("BIL_ISS_STS_CD"));
                	sBilEdiRcvRsltCd = getNull(rs.getString("BIL_EDI_RCV_RSLT_CD"));
                	sCgoTpCd 		 = getNull(rs.getString("CGO_TP_CD"));
                	sTrspBndCd 		 = getNull(rs.getString("TRSP_BND_CD"));
                	sSpclCgoCntrTpCd = getNull(rs.getString("SPCL_CGO_CNTR_TP_CD"));
                	sBkgSpe 		 = getNull(rs.getString("BKG_SPE"));                	
                	sInvNo	 		 = getNull(rs.getString("INV_NO"));
                	sTrspSoStsCd	 = getNull(rs.getString("TRSP_SO_STS_CD"));
                	sVndrAbbrNm		 = getNull(rs.getString("VNDR_ABBR_NM"));
                	sCxlRqstRsn		 = getNull(rs.getString("CXL_RQST_RSN"));
                	sCxlRqstRjctRsn	 = getNull(rs.getString("CXL_RQST_RJCT_RSN"));
                	sCntrWgt 		 = getNull(rs.getString("CNTR_WGT"));
                	sShprCustNm		 = getNull(rs.getString("SHPR_CUST_NM"));
                	sCneeCustNm		 = getNull(rs.getString("CNEE_CUST_NM"));
                	sEdiUsrId 		 = getNull(rs.getString("EDI_USR_ID"));
                	sCmdtName 		 = getNull(rs.getString("CMDT_NAME"));
                	sRefNo 		 	 = getNull(rs.getString("REF_NO"));
                	sIbdNo 		 	 = getNull(rs.getString("IBD_NO")).trim();
                	sAutoXptSysNo	 = getNull(rs.getString("AUTO_XPT_SYS_NO"));
                	sInterRmk	 	 = getNull(rs.getString("INTER_RMK"));
                	sSpclInstrRmk	 = getNull(rs.getString("SPCL_INSTR_RMK"));
                	
                		
            		// LASTCHK 컬럼으로 Check..
            		if( !"Y".equals(getNull(sLastchk)) ){
            			sChk3 				= "EDIT='FALSE' " + sBgcolor;
            			sChk2 				= "EDIT='FALSE' " + sBgcolor;
            			sChk1 				= "EDIT='FALSE' " + sBgcolor;
            			sInterRmkChk		= "EDIT='FALSE' " + sBgcolor;
            			sSpclInstrRmkChk	= "EDIT='FALSE' " + sBgcolor;
            		}
            		
            		// Bill Issue Code 컬럼으로 Check..
            		if( "I".equals(sBilIssStsCd) ){
            			if( "A".equals(sBilEdiRcvRsltCd) || "E".equals(sBilEdiRcvRsltCd) || "R".equals(sBilEdiRcvRsltCd) ){
            				sChk1	= "EDIT='FALSE' " + sBgcolor;
            			}else{
            				sChk2	= "EDIT='FALSE' " + sBgcolor;
            			}                			
            		}else if( "X".equals(sBilIssStsCd) ){
            			if( "A".equals(sBilEdiRcvRsltCd) && "E".equals(sBilEdiRcvRsltCd) ){
            				sChk2	= "EDIT='FALSE' " + sBgcolor;
            				sChk1	= "EDIT='FALSE' " + sBgcolor;
            			}else{
            				sChk1	= "EDIT='FALSE' " + sBgcolor;
            			}                			
            		}else{
            			sChk2	= "EDIT='FALSE' " + sBgcolor;
            		}
            		
            		// SP-CP(105480), FM_NOD_CD='USDETR5'를 제외하고 DG는 EDI 전송 불가
//            		if( "DG".equals(rs.getString("SPCL_CGO_CNTR_TP_CD")) &&
            		if( rs.getString("SPCL_CGO_CNTR_TP_CD").indexOf("DG") >= 0 &&
            				!("105475".equals(rs.getString("VNDR_SEQ"))) &&
            				!("105484".equals(rs.getString("VNDR_SEQ"))) &&
            				!("105480".equals(rs.getString("VNDR_SEQ")) && "USDETR5".equals(getNull(rs.getString("FM_NOD_CD"))+getNull(rs.getString("FM_NOD_YARD"))))){
            			sChk2	= "EDIT='FALSE' " + sBgcolor;
        				sChk1	= "EDIT='FALSE' " + sBgcolor;
            		}
            		
            		// Cargo Type Code 컬럼으로 Check..
            		if( "M".equals(sCgoTpCd) ){
            			sWoRjctRsn	= "EDIT='FALSE' " + sBgcolor;
            		}
            		
            		// Cargo Type Code 컬럼으로 Check..
            		if( "I".equals(sTrspBndCd) ){
            			sLvSpclCgo = sSpclCgoCntrTpCd;
            		}else{
            			sLvSpclCgo = sBkgSpe;
            		}
            		
            		if( !"".equals(sLvSpclCgo) ){
            			sLvSpclCgoChk = "COLOR='255,0,0'";
            		}
                	
                	// Sheet에 그리기 시작..
            		if( !"".equals(sLvSpclCgoChk) ){
                		sb.append("<TR " + sLvSpclCgoChk + ">");                		
                	}else{
                		sb.append("<TR>");                		
                	}
                	
                    for(int j = 0; j < colCount; j++){
                    	colName = rs.getMetaData().getColumnName(j+1);
                    	
                    	if( "CHK3".equals(colName) ){                    		
                    		if( !"".equals(sChk3) ){                    			
                    			sb.append("<TD " + sChk3 + ">");
                    			sb.append(getNull(rs.getString("CHK3")) + "</TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("CHK3")) + "</TD>");
                    		}
                    	}else if( "CHK2".equals(colName) ){                    		
                    		if( !"".equals(sChk2) ){                    			
                    			sb.append("<TD " + sChk2 + ">");
                    			sb.append(getNull(rs.getString("CHK2")) + "</TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("CHK2")) + "</TD>");
                    		}
                    	}else if( "CHK1".equals(colName) ){                    		
                    		if( !"".equals(sChk1) ){                    			
                    			sb.append("<TD " + sChk1 + ">");
                    			sb.append(getNull(rs.getString("CHK1")) + "</TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("CHK1")) + "</TD>");
                    		}
                    	}else if( "INTER_RMK".equals(colName) ){                    		
                    		if( !"".equals(sInterRmkChk) ){  
                    			if( !"".equals(sInterRmk) ){
                    				sb.append("<TD " + sInterRmkChk + "><![CDATA[");
                        			sb.append(getNull(rs.getString("INTER_RMK")) + "]]></TD>");
                    			}else{
                    				sb.append("<TD " + sInterRmkChk + ">");
                        			sb.append(getNull(rs.getString("INTER_RMK")) + "</TD>");
                    			}                    			
                    		}else{
                    			if( !"".equals(sInterRmk) ){
                    				sb.append("<TD><![CDATA[");
                        			sb.append(getNull(rs.getString("INTER_RMK")) + "]]></TD>");                    				
                    			}else{
                    				sb.append("<TD>");
                        			sb.append(getNull(rs.getString("INTER_RMK")) + "</TD>");                    				
                    			}                    			
                    		}
                    	}else if( "SPCL_INSTR_RMK".equals(colName) ){                    		
                    		if( !"".equals(sSpclInstrRmkChk) ){    
                    			if( !"".equals(sSpclInstrRmk) ){
                    				sb.append("<TD " + sSpclInstrRmkChk + "><![CDATA[");
                        			sb.append(getNull(rs.getString("SPCL_INSTR_RMK")) + "]]></TD>");                    				
                    			}else{
                    				sb.append("<TD " + sSpclInstrRmkChk + ">");
                        			sb.append(getNull(rs.getString("SPCL_INSTR_RMK")) + "</TD>");                    				
                    			}                    			
                    		}else{
                    			if( !"".equals(sSpclInstrRmk) ){
                    				sb.append("<TD><![CDATA[");
                        			sb.append(getNull(rs.getString("SPCL_INSTR_RMK")) + "]]></TD>");                    				
                    			}else{
                    				sb.append("<TD>");
                        			sb.append(getNull(rs.getString("SPCL_INSTR_RMK")) + "</TD>");                    				
                    			}                    			
                    		}
                    	}else if( "WO_RJCT_RSN".equals(colName) ){                    		
                    		if( !"".equals(sWoRjctRsn) ){                    			
                    			sb.append("<TD " + sWoRjctRsn + ">");
                    			sb.append(getNull(rs.getString("WO_RJCT_RSN")) + "</TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("WO_RJCT_RSN")) + "</TD>");
                    		}
                    	}else if( "INV_NO".equals(colName) ){                    		
                    		if( !"".equals(sInvNo) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("INV_NO")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("INV_NO")) + "</TD>");
                    		}
                    	}else if( "TRSP_SO_STS_CD".equals(colName) ){                    		
                    		if( !"".equals(sTrspSoStsCd) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("TRSP_SO_STS_CD")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("TRSP_SO_STS_CD")) + "</TD>");
                    		}
                    	}else if( "VNDR_ABBR_NM".equals(colName) ){                    		
                    		if( !"".equals(sVndrAbbrNm) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("VNDR_ABBR_NM")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("VNDR_ABBR_NM")) + "</TD>");
                    		}
                    	}else if( "BKG_SPE".equals(colName) ){                    		
                    		if( !"".equals(sBkgSpe) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("BKG_SPE")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("BKG_SPE")) + "</TD>");
                    		}
                    	}else if( "SPCL_CGO_CNTR_TP_CD".equals(colName) ){                    		
                    		if( !"".equals(sSpclCgoCntrTpCd) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("SPCL_CGO_CNTR_TP_CD")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("SPCL_CGO_CNTR_TP_CD")) + "</TD>");
                    		}
                    	}else if( "CXL_RQST_RSN".equals(colName) ){                    		
                    		if( !"".equals(sCxlRqstRsn) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("CXL_RQST_RSN")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("CXL_RQST_RSN")) + "</TD>");
                    		}
                    	}else if( "CXL_RQST_RJCT_RSN".equals(colName) ){                    		
                    		if( !"".equals(sCxlRqstRjctRsn) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("CXL_RQST_RJCT_RSN")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("CXL_RQST_RJCT_RSN")) + "</TD>");
                    		}
                    	}else if( "CNTR_WGT".equals(colName) ){                    		
                    		if( !"".equals(sCntrWgt) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("CNTR_WGT")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("CNTR_WGT")) + "</TD>");
                    		}
                    	}else if( "SHPR_CUST_NM".equals(colName) ){                    		
                    		if( !"".equals(sShprCustNm) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("SHPR_CUST_NM")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("SHPR_CUST_NM")) + "</TD>");
                    		}
                    	}else if( "CNEE_CUST_NM".equals(colName) ){                    		
                    		if( !"".equals(sCneeCustNm) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("CNEE_CUST_NM")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("CNEE_CUST_NM")) + "</TD>");
                    		}
                    	}else if( "EDI_USR_ID".equals(colName) ){                    		
                    		if( !"".equals(sEdiUsrId) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("EDI_USR_ID")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("EDI_USR_ID")) + "</TD>");
                    		}
                    	}else if( "CMDT_NAME".equals(colName) ){                    		
                    		if( !"".equals(sCmdtName) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("CMDT_NAME")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("CMDT_NAME")) + "</TD>");
                    		}
                    	}else if( "REF_NO".equals(colName) ){                    		
                    		if( !"".equals(sRefNo) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("REF_NO")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("REF_NO")) + "</TD>");
                    		}
                    	}else if( "IBD_NO".equals(colName) ){                    		
                    		if( !"".equals(sIbdNo) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("IBD_NO")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("IBD_NO")) + "</TD>");
                    		}
                    	}else if( "AUTO_XPT_SYS_NO".equals(colName) ){                    		
                    		if( !"".equals(sAutoXptSysNo) ){                    			
                    			sb.append("<TD><![CDATA[");
                    			sb.append(getNull(rs.getString("AUTO_XPT_SYS_NO")) + "]]></TD>");
                    		}else{                    			
                    			sb.append("<TD>");
                    			sb.append(getNull(rs.getString("AUTO_XPT_SYS_NO")) + "</TD>");
                    		}
                    	}else{
                    		sb.append("<TD>");
    						sb.append(getNull(rs.getObject(colName)) + "</TD>");  
                    	}
                    }//for end
                    sb.append("</TR>\n");
                }//while end
                sb.append("</DATA>\n");    			
    		}else {
    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                int colCount = realColNms.length;
                for(; rs.next(); sb.append((new StringBuilder()).append(getNull(rs.getObject(colCount))).append("]]></TR>\n").toString()))
                {
                    sb.append("\t<TR><![CDATA[");
                    for(int j = 1; j < colCount; j++)
                        sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).append("\u261C\u261E").toString());

                }

                sb.append("</DATA>\n");    			
    		}
        }
        catch(SQLException ex)
        {
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        return sb.toString();
    }
}

