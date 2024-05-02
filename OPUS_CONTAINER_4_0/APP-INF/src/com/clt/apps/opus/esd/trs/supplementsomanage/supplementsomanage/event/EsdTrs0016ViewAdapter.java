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
package com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esd.trs.common.util.TrsDefaultViewAdapter;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Yeonsil-Kim
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0016ViewAdapter extends TrsDefaultViewAdapter {

	protected String makeDataTag(List vos, String prefix, Event event) {
		FormCommand	 formcommand	= event.getFormCommand();
		StringBuilder sbufXML = new StringBuilder();
		
		if( formcommand.isCommand(FormCommand.SEARCHLIST01) )  {
			DBRowSet rowSet = (DBRowSet)vos.get(0);
			List resultArrayList = (List)vos.get(1);
			
			if(rowSet == null){
				sbufXML.append("<RESULT>");
				sbufXML.append("  <TR-ALL>OK</TR-ALL> ");
				sbufXML.append("</RESULT>");
			}else{
				int i = 0;
				sbufXML.append("  <DATA>");
				
				try{
					while (rowSet.next()) {
						HashMap outputMap	= (HashMap)resultArrayList.get(i);
						sbufXML.append("<TR>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("trsp_so_ofc_cty_cd"))	+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("trsp_so_seq"))			+ "]]></TD>");
						sbufXML.append("<TD></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("eq_no"))					+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("eq_tpsz_cd"))			+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("trsp_cost_dtl_mod_cd"))	+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("trsp_crr_mod_cd"))		+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("fm_loc"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("fm_yard"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("via_loc"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("via_yard"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("to_loc"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("to_yard"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("dor_loc"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("dor_zone"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("cust_val"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("dor_de_addr"))			+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("vndr_seq"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("vndr_nm"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("bkg_sq"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("bl_no"))					+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("truck_vvd"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("so_number"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("wo_number"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("cre_dt"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("inv_no"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("inv_cfm_dt"))			+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("ref_no"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("spl_iss_rsn"))			+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("amt_knd"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("trsp_dflt_vndr_flg"))	+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("sp_type"))			+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("agmt_rate_type_nm"))+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("way_type"))			+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("curr_cd"))			+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("basic_amt"))		+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("nego_amt"))			+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("fuel_scg_amt"))		+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("etc_add_amt"))		+ "]]></TD>");
						sbufXML.append("<TD></TD>");
						sbufXML.append("<TD></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("agmt_ofc_cty_cd"))	+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("agmt_seq"))			+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("agmt_rate_type"))	+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("agmt_way_type"))	+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("cust_nomi_trkr_flg"))+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("cust_cnt_cd"))		+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull((String)outputMap.get("cust_seq"))			+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("cgo_tp_cd"))				+ "]]></TD>");
						sbufXML.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("surcharge_key"))			+ "]]></TD>");
						sbufXML.append("</TR>");
						
						i++;
					}
	
					sbufXML.append("</DATA>");
				} catch(SQLException ex) {
		            throw new RuntimeException(ex.getMessage());
		        } catch(Exception ex) {
		            log.error(ex.getMessage(), ex);
		            throw new RuntimeException(ex.getMessage());
		        }
			}	
		} 
		else;
		
        return sbufXML.toString();
    }
    
    protected String makeDataTag(DBRowSet rs, String prefix, Event event) {
        StringBuilder sb = new StringBuilder();
        if(rs.isPivot()) {
            sb.append(makePivotDataTag(rs));
            return sb.toString();
        }
        String realColNms[] = getColHeader(rs);
        try {
            String changedColNms[] = getChangedColNms(realColNms, prefix);
            sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
            int colCount = realColNms.length;
            for(; rs.next(); sb.append((new StringBuilder()).append(getNull(rs.getObject(colCount))).append("]]></TR>\n").toString())) {
                sb.append("\t<TR><![CDATA[");
                for(int j = 1; j < colCount; j++) {
                    sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).append("\u261C\u261E").toString());
                }
            }

            sb.append("</DATA>\n");
        } catch(SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch(Exception ex) {
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
    /*
    private String getDuplicateCheckByDateString(ArrayList rsList){
    	
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
    */
    /**
     * Duplicate 리스트를 String으로 변환한다.<br>
     * @param ArrayList rsList 
     * @return String
     * @exception
     */
    /*
    private String getDuplicateCheckByDateString(DBRowSet dbRs){
    	
    	StringBuffer returnStr = new StringBuffer();
    	int i=0;
    	try {
	    	if(dbRs != null && dbRs.getRowCount()>0){
	    		while( dbRs.next()){
	    		
	    			if(i==0 && dbRs.getString("TRS_TRSP_SO_SEQ").equals("")) break;
	    			if(i>0)	returnStr.append(" / ");
	    			returnStr.append(dbRs.getString("TRS_TRSP_SO_OFC_CTY_CD"));
	    			returnStr.append(dbRs.getString("TRS_TRSP_SO_SEQ"));
	    			returnStr.append(" , ");
	    			returnStr.append(dbRs.getString("CRE_DT"));
	    			returnStr.append(" , ");
	    			returnStr.append(dbRs.getString("FM_NOD_CD"));
	    			returnStr.append("-");
	    			returnStr.append(dbRs.getString("TO_NOD_CD"));
	    			returnStr.append(" , ");
	    			returnStr.append(dbRs.getString("TRSP_COST_DTL_MOD_CD"));
	    			returnStr.append(" , ");
	    			returnStr.append(dbRs.getString("TRSP_CRR_MOD_CD"));
	    			
	    			i++;
	    		}
	    	}
	    	//return returnStr.toString();
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
        return returnStr.toString();

    }

    private String getOfficeCD(DBRowSet rowSet) throws Exception{

    		StringBuffer returnStr = new StringBuffer();
    		int cnt = 0;
    		while(rowSet != null && rowSet.next()){
    			if(cnt == 0){
    				returnStr.append(rowSet.getString("OFC_CD"));
    				cnt++;
    			}else{
    				returnStr.append("|");
    				returnStr.append(rowSet.getString("OFC_CD"));
    				cnt++;
    			}
    		}
    		return returnStr.toString();
    	}
    	*/
}

