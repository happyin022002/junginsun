/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdTrs0033ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2008-11-24
*@LastModifier : Lee SeungYol
*@LastVersion : 1.0
* 2008-11-24 Lee SeungYol
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esd.trs.common.util.TrsDefaultViewAdapter;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;


/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Eunju-Son
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0033ViewAdapter extends TrsDefaultViewAdapter {

	protected String makeDataTag(List vos, String prefix, Event event)
    {
		FormCommand	 formcommand	= event.getFormCommand();
		StringBuilder sbufXML = new StringBuilder();
		String bgColor = null;
		String edit = null;

		
		if( formcommand.isCommand(FormCommand.SEARCH14) )  {
			
			if(vos == null || vos.size() == 0){
				
				sbufXML.append("<RESULT>");
				sbufXML.append("  <TR-ALL>OK</TR-ALL> ");
				sbufXML.append("</RESULT>");
				
			}else{
				sbufXML.append("  <DATA>");
					
				for (int k = 0 ; vos != null && k < vos.size(); k++) {
					ArrayList arr = (ArrayList) vos.get(k);
					for(int i=0; arr != null&& i<arr.size(); i++){
						TrsTrspSvcOrdVO model = (TrsTrspSvcOrdVO) arr.get(i);		
						if(model.getEdiRcvRsltMsg().equals("Currency Mismatch")
							|| model.getEdiRcvRsltMsg().indexOf("Amount Diff") > -1){
							bgColor				= "BGCOLOR=\'252,251,0\'";		// 노랑
						}else if(model.getDtnUseFlg().equals("0")){
							bgColor				= "BGCOLOR=\'255,193,164\'";	// 분홍
						}else{
							bgColor				= "";
						}
		
						if(model.getDtnUseFlg().equals("0")){
							edit				= "EDIT=\'FALSE\'";
						}else{
							edit				= "";
						}
						
						sbufXML.append("<TR ROW='"+model.getTrspSoCmbSeq()+"'>");
						sbufXML.append("<TD COL='ibcheck' " + edit + ">"+model.getDtnUseFlg()+ "</TD>");
						sbufXML.append("<TD COL='eq_no' " + bgColor + ">"+model.getEqNo()+ "</TD>");
						sbufXML.append("<TD COL='eq_tpsz_cd' " + bgColor + ">"+model.getEqTpszCd()+ "</TD>");
						sbufXML.append("<TD COL='prnt_trsp_so_ofc_cty_cd' " + bgColor + ">"+model.getTrspSoOfcCtyCd()+model.getTrspSoSeq()+ "</TD>");
						sbufXML.append("<TD COL='prnt_trsp_so_seq' " + bgColor + ">"+model.getTrspWoOfcCtyCd()+model.getTrspWoSeq()+ "</TD>");
						sbufXML.append("<TD COL='inv_bzc_amt' " + bgColor + ">"+model.getInvBzcAmt()+ "</TD>");
						sbufXML.append("<TD COL='inv_rmk' " + bgColor + ">"+model.getEdiRcvRsltMsg()+ "</TD>");
						sbufXML.append("<TD COL='trsp_wo_ofc_cty_cd'>"+model.getTrspWoOfcCtyCd()+ "</TD>");
						sbufXML.append("<TD COL='trsp_wo_seq'>"+model.getTrspWoSeq()+ "</TD>");
						sbufXML.append("<TD COL='trsp_so_ofc_cty_cd'>"+model.getTrspSoOfcCtyCd()+ "</TD>");
						sbufXML.append("<TD COL='trsp_so_seq'>"+model.getTrspSoSeq()+ "</TD>");
						sbufXML.append("<TD COL='nis_check'>"+model.getEdiRcvRsltCd()+ "</TD>");
						sbufXML.append("<TD COL='cntr_sub_flg'>"+JSPUtil.getNull(model.getCntrSubFlg())+ "</TD>");
						sbufXML.append("</TR>");
					}
					
				}

				sbufXML.append("</DATA>");

			}
		} else if(formcommand.isCommand(FormCommand.SEARCH16)) {

			
			String verifyStr		= "";
			String rowNo			= null;
			

			sbufXML.append("<DATA>");
			for(int i=0;vos!=null && i<vos.size(); i++){
				List<TrsTrspSvcOrdVO> voList= (List<TrsTrspSvcOrdVO>)vos.get(i);
				
				if( voList != null ){
					verifyStr			= getDuplicateCheckByDateString(voList);
					if( voList.size()>0){
						rowNo = ((TrsTrspSvcOrdVO) voList.get(0)).getRefSeq();
				
						sbufXML.append("<TR ROW='"+rowNo+"'>");
						sbufXML.append("<TD COL='verify_result'><![CDATA["+verifyStr+"]]></TD>");
						sbufXML.append("</TR>");
					}
				}	
			}
			sbufXML.append("</DATA>");

		}
		
        return sbufXML.toString();
    }
    
    protected String makeDataTag(DBRowSet rs, String prefix, Event event)
    {
//    	FormCommand	 formcommand	= event.getFormCommand();
        StringBuilder sb = new StringBuilder();
        if(rs.isPivot())
        {
            sb.append(makePivotDataTag(rs));
            return sb.toString();
        }
        String realColNms[] = getColHeader(rs);
        try
        {
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
    
    /**
     * Duplicate 리스트를 String으로 변환한다.<br>
     * @param ArrayList rsList 
     * @return String
     * @exception
     */
    private String getDuplicateCheckByDateString(List<TrsTrspSvcOrdVO> rsList){
    	
    	StringBuffer returnStr = new StringBuffer();
    	if(rsList != null && rsList.size()>0){
    		for(int i=0; i<rsList.size(); i++){
    			TrsTrspSvcOrdVO model = (TrsTrspSvcOrdVO) rsList.get(i);
    			
    			if(i==0 && model.getTrspSoSeq().equals("")) break;
    			if(i>0)	returnStr.append(" / ");
    			returnStr.append(model.getTrspSoOfcCtyCd());
    			returnStr.append(model.getTrspSoSeq());
    			returnStr.append(" , ");
    			returnStr.append(model.getCreDt());
    			returnStr.append(" , ");
    			returnStr.append(model.getFmNodCd());
    			returnStr.append("-");
    			returnStr.append(model.getToNodCd());
    			returnStr.append(" , ");
    			returnStr.append(model.getTrspCostDtlModCd());
    			returnStr.append(" , ");
    			returnStr.append(model.getTrspCrrModCd());
    		}
    	}
    	return returnStr.toString();
    }
    
    /**
     * Duplicate 리스트를 String으로 변환한다.<br>
     * @param ArrayList rsList 
     * @return String
     * @exception
     */
//    private String getDuplicateCheckByDateString(DBRowSet dbRs){
//    	
//    	StringBuffer returnStr = new StringBuffer();
//    	int i=0;
//    	try {
//	    	if(dbRs != null && dbRs.getRowCount()>0){
//	    		while( dbRs.next()){
//	    		
//	    			if(i==0 && dbRs.getString("TRS_TRSP_SO_SEQ").equals("")) break;
//	    			if(i>0)	returnStr.append(" / ");
//	    			returnStr.append(dbRs.getString("TRS_TRSP_SO_OFC_CTY_CD"));
//	    			returnStr.append(dbRs.getString("TRS_TRSP_SO_SEQ"));
//	    			returnStr.append(" , ");
//	    			returnStr.append(dbRs.getString("CRE_DT"));
//	    			returnStr.append(" , ");
//	    			returnStr.append(dbRs.getString("FM_NOD_CD"));
//	    			returnStr.append("-");
//	    			returnStr.append(dbRs.getString("TO_NOD_CD"));
//	    			returnStr.append(" , ");
//	    			returnStr.append(dbRs.getString("TRSP_COST_DTL_MOD_CD"));
//	    			returnStr.append(" , ");
//	    			returnStr.append(dbRs.getString("TRSP_CRR_MOD_CD"));
//	    			
//	    			i++;
//	    		}
//	    	}
//	    	//return returnStr.toString();
//    	 }
//        catch(SQLException ex)
//        {
//            throw new RuntimeException(ex.getMessage());
//        }
//        catch(Exception ex)
//        {
//            log.error(ex.getMessage(), ex);
//            throw new RuntimeException(ex.getMessage());
//        }
//        return returnStr.toString();
//
//    }

    /**
     * @param rowSet
     * @return
     * @throws Exception
     */
//    private String getOfficeCD(DBRowSet rowSet) throws Exception{
//
//    		StringBuffer returnStr = new StringBuffer();
//    		int cnt = 0;
//    		while(rowSet != null && rowSet.next()){
//    			if(cnt == 0){
//    				returnStr.append(rowSet.getString("OFC_CD"));
//    				cnt++;
//    			}else{
//    				returnStr.append("|");
//    				returnStr.append(rowSet.getString("OFC_CD"));
//    				cnt++;
//    			}
//    		}
//    		return returnStr.toString();
//    	}
}

