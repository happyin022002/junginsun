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
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.common.util.TrsDefaultViewAdapter;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Poong-Yeon Cho
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0201ViewAdapter extends TrsDefaultViewAdapter {

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
        SignOnUserAccount account = null; //Session 정보
        if(rs.isPivot())
        {
            sb.append(makePivotDataTag(rs));
            return sb.toString();
        }
        String realColNms[] = getColHeader(rs);
        try
        {
        	account = (SignOnUserAccount)event.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        	if( formcommand.isCommand(FormCommand.MULTI) ||
    				formcommand.isCommand(FormCommand.ADD) ||
    				formcommand.isCommand(FormCommand.MODIFY) ||
    				formcommand.isCommand(FormCommand.REMOVE) ||
    				formcommand.isCommand(FormCommand.REMOVELIST) ){	//저장XML인 경우
    			
    			sb.append("<RESULT>");
    			sb.append("<TR-ALL>OK</TR-ALL>");
    			sb.append("</RESULT>");
    		}else if( formcommand.isCommand(FormCommand.SEARCH02) ){
    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                while(rs.next()){					
                	sb.append("<TR>");					
					sb.append("<TD>");
					sb.append(getNull(rs.getString("EQ_NO")) + "</TD>");
					sb.append("<TD><![CDATA[");
					sb.append(getNull(rs.getString("VERIFY_RESULT")) + "]]></TD>");
					sb.append("<TD>");
					sb.append(getNull(rs.getString("VERIFY_YN")) + "</TD>");
                    sb.append("</TR>\n");
                }
                sb.append("</DATA>\n");    			
    		}else {	//조회XML인 경우
    			String changedColNms[] = getChangedColNms(realColNms, prefix);
                sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
                int colCount = realColNms.length;
                
                String colName    = "";
    			String sExpt    = "";
    			String sBgcolor = "";
    			String sInterchange1 = "";
    			String sInterchange1_loca = "";
    			String sInterchange1_node = "";
    			String sInterchange2 = "";
    			String sInterchange2_loca = "";
    			String sInterchange2_node = "";
    			String sbkgSpe = "";
    			String sspclCgoCntrTpCd = "";
    			String scntrWgt = "";
    			String scmdtName = "";
    			String srefNo = "";
    			String sshprCustNm = "";
    			String scneeCustNm = "";
    			String sn1stNodPlnDtHms = "";
    			String slstNodPlnDtHms = "";
    			String sinlndRoutRmk = "";
    			String svdDt = "";
    			String sibdNo = "";
    			String scntrSealNo = "";
    			
                while(rs.next()){
                	sExpt = getNull(rs.getString("EXPT"));
					sInterchange1_loca = "";
					sInterchange1_node = "";
					sInterchange2_loca = "";
					sInterchange2_node = "";
					sInterchange1 = getNull(rs.getString("INTERCHANGE1_LOC"));
					sInterchange2 = getNull(rs.getString("INTERCHANGE2_LOC"));
					sbkgSpe = getNull(rs.getString("BKG_SPE"));
	    			sspclCgoCntrTpCd = getNull(rs.getString("SPCL_CGO_CNTR_TP_CD"));
	    			scntrWgt = getNull(rs.getString("CNTR_WGT"));
	    			scmdtName = getNull(rs.getString("CMDT_NAME"));
	    			srefNo = getNull(rs.getString("REF_NO"));
	    			sshprCustNm = getNull(rs.getString("SHPR_CUST_NM"));
	    			scneeCustNm = getNull(rs.getString("CNEE_CUST_NM"));
	    			sn1stNodPlnDtHms = getNull(rs.getString("N1ST_NOD_PLN_DT_HMS"));
	    			slstNodPlnDtHms = getNull(rs.getString("LST_NOD_PLN_DT_HMS"));
	    			sinlndRoutRmk = getNull(rs.getString("INLND_ROUT_RMK"));
	    			svdDt = getNull(rs.getString("VD_DT"));
	    			sibdNo = getNull(rs.getString("IBD_NO")).trim();
	    			scntrSealNo = getNull(rs.getString("CNTR_SEAL_NO")).trim();

					if( sInterchange1.length() > 5 ) {
						sInterchange1_loca = sInterchange1.substring(0, 5);
						sInterchange1_node = sInterchange1.substring(5);
					}
					if( sInterchange2.length() > 5 ) {
						sInterchange2_loca = sInterchange2.substring(0, 5);
						sInterchange2_node = sInterchange2.substring(5);
					}
					if( sExpt.equals("0") ) {
						sBgcolor = "COLOR='RED'";
						sb.append("<TR " + sBgcolor);
	                	sb.append(">");
					} else {
						sBgcolor = "";
						sb.append("<TR>");
					}
					
                    for(int j = 0; j < colCount; j++){
                    	colName = rs.getMetaData().getColumnName(j+1);
                    	
                    	if( "BKG_SPE".equals(colName) ){
                    		if( "".equals(sbkgSpe) ){
                    			sb.append("<TD></TD>");                    			
                    		}else{
                    			sb.append("<TD><![CDATA[");
                        		sb.append(getNull(sbkgSpe) + "]]></TD>");                    			
                    		}                    		                    		
                    	}else if( "SPCL_CGO_CNTR_TP_CD".equals(colName) ) {
                    		if( "".equals(sspclCgoCntrTpCd) ){
                    			sb.append("<TD></TD>");                    			
                    		}else{
                    			sb.append("<TD><![CDATA[");
                        		sb.append(getNull(sspclCgoCntrTpCd) + "]]></TD>");                    			
                    		}
    					}else if( "CNTR_WGT".equals(colName) ) {
    						if( "".equals(scntrWgt) ){
                    			sb.append("<TD></TD>");                    			
                    		}else{
                    			sb.append("<TD><![CDATA[");
                        		sb.append(getNull(scntrWgt) + "]]></TD>");                    			
                    		}
    					}else if( "CMDT_NAME".equals(colName) ) {
    						if( "".equals(scmdtName) ){
                    			sb.append("<TD></TD>");                    			
                    		}else{
                    			sb.append("<TD><![CDATA[");
                        		sb.append(getNull(scmdtName) + "]]></TD>");                    			
                    		}
    					}else if( "REF_NO".equals(colName) ) {
    						if( "".equals(srefNo) ){
                    			sb.append("<TD></TD>");                    			
                    		}else{
                    			sb.append("<TD><![CDATA[");
                        		sb.append(getNull(srefNo) + "]]></TD>");                    			
                    		}
    					}else if( "SHPR_CUST_NM".equals(colName) ) {
    						if( "".equals(sshprCustNm) ){
                    			sb.append("<TD></TD>");                    			
                    		}else{
                    			sb.append("<TD><![CDATA[");
                        		sb.append(getNull(sshprCustNm) + "]]></TD>");                    			
                    		}
    					}else if( "CNEE_CUST_NM".equals(colName) ) {
    						if( "".equals(scneeCustNm) ){
                    			sb.append("<TD></TD>");                    			
                    		}else{
                    			sb.append("<TD><![CDATA[");
                        		sb.append(getNull(scneeCustNm) + "]]></TD>");                    			
                    		}
    					}else if( "N1ST_NOD_PLN_DT_HMS".equals(colName) ) {
    						if( "".equals(sn1stNodPlnDtHms) ){
                    			sb.append("<TD></TD>");                    			
                    		}else{
                    			sb.append("<TD><![CDATA[");
                        		sb.append(getNull(sn1stNodPlnDtHms) + "]]></TD>");                    			
                    		}
    					}else if( "LST_NOD_PLN_DT_HMS".equals(colName) ) {
    						if( "".equals(slstNodPlnDtHms) ){
                    			sb.append("<TD></TD>");                    			
                    		}else{
                    			sb.append("<TD><![CDATA[");
                        		sb.append(getNull(slstNodPlnDtHms) + "]]></TD>");                    			
                    		}
    					}else if( "INLND_ROUT_RMK".equals(colName) ) {
    						if( "".equals(sinlndRoutRmk) ){
                    			sb.append("<TD></TD>");                    			
                    		}else{
                    			sb.append("<TD><![CDATA[");
                        		sb.append(getNull(sinlndRoutRmk) + "]]></TD>");                    			
                    		}
    					}else if( "VD_DT".equals(colName) ) {
    						if( "".equals(svdDt) ){
                    			sb.append("<TD></TD>");                    			
                    		}else{
                    			sb.append("<TD><![CDATA[");
                        		sb.append(getNull(svdDt) + "]]></TD>");                    			
                    		}
    					}else if( "CNTR_SEAL_NO".equals(colName) ) {
    						if( "".equals(scntrSealNo) ){
                    			sb.append("<TD></TD>");                    			
                    		}else{
                        		sb.append("<TD><![CDATA[");
        						sb.append(getNull(scntrSealNo) + "]]></TD>");
                    		}    						
    					}else if( "TRSP_SO_OFC_CTY_CD".equals(colName) ) {
    						sb.append("<TD>");
    						sb.append(getNull(account.getOfc_cd()) + "</TD>");
    					}else if( "CRE_USR_ID".equals(colName) ) {
    						sb.append("<TD><![CDATA[");
    						sb.append(getNull(account.getUsr_id()) + "]]></TD>");
    					}else if( "UPD_USR_ID".equals(colName) ) {
    						sb.append("<TD><![CDATA[");
    						sb.append(getNull(account.getUsr_id()) + "]]></TD>");
    					}else if( "INTERCHANGE1_LOC".equals(colName) ) {
    						sb.append("<TD>");
    						sb.append(getNull(sInterchange1_loca) + "</TD>");
    					}else if( "INTERCHANGE1_NOD".equals(colName) ) {
    						sb.append("<TD>");
    						sb.append(getNull(sInterchange1_node) + "</TD>");
    					}else if( "INTERCHANGE2_LOC".equals(colName) ) {
    						sb.append("<TD>");
    						sb.append(getNull(sInterchange2_loca) + "</TD>");
    					}else if( "INTERCHANGE2_NOD".equals(colName) ) {
    						sb.append("<TD>");
    						sb.append(getNull(sInterchange2_node) + "</TD>");
    					}else if( "IBD_NO".equals(colName) ) {
    						sb.append("<TD>");
    						sb.append(getNull(sibdNo) + "</TD>");
    					}else{
                    		sb.append("<TD>");
    						sb.append(getNull(rs.getObject(colName)) + "</TD>");                    		
                    	}
                    }
                    sb.append("</TR>\n");
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

