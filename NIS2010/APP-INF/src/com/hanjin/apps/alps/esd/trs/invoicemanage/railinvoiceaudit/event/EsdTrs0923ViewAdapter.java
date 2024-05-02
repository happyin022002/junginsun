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
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
 * @author Poong-Yeon Cho
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsdTrs0923ViewAdapter extends TrsDefaultViewAdapter {

	protected String makeDataTag(List vos, String prefix, Event event)
    {		
		FormCommand	 formcommand	= event.getFormCommand();
        StringBuilder sbufXML = new StringBuilder();
        
        int totCnt = vos.size();
        int realCnt = vos.size();
        
        try
        {
        	if( formcommand.isCommand(FormCommand.MULTI) ||
    				formcommand.isCommand(FormCommand.ADD) ||
    				formcommand.isCommand(FormCommand.MODIFY) ||
    				formcommand.isCommand(FormCommand.REMOVE) ||
    				formcommand.isCommand(FormCommand.REMOVELIST) ){	//저장XML인 경우
    			
        		sbufXML.append("<RESULT>");
        		sbufXML.append("<TR-ALL>OK</TR-ALL>");
        		sbufXML.append("</RESULT>");
    		}else if( formcommand.isCommand(FormCommand.SEARCH) ){
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
    		}else if( formcommand.isCommand(FormCommand.SEARCH01) ){    			
    			HashMap resultHashMap		= ((EsdTrs0923Event) event).getHashParam();
    			
    			ArrayList hashList			= (ArrayList)	resultHashMap.get("hashList");
    			ArrayList eqNoList			= (ArrayList)	resultHashMap.get("eqNoList");
    			ArrayList resultList		= (ArrayList)	resultHashMap.get("resultList");
    			ArrayList rsltSetList		= (ArrayList)	resultHashMap.get("rsltSetList");
    			ArrayList seqList			= (ArrayList)	resultHashMap.get("seqList");
    			ArrayList eqtpszList		= (ArrayList)	resultHashMap.get("eqtpszList");
    			ArrayList railAudCdList		= (ArrayList)	resultHashMap.get("railAudCdList");

    			ArrayList wbl_dtList		= (ArrayList)	resultHashMap.get("wbl_dtList");
    			ArrayList invBilAmtList		= (ArrayList)	resultHashMap.get("invBilAmtList");
    			HashMap hashParam			= (HashMap)		resultHashMap.get("hashParam");
    			
    			DBRowSet dbRowSet			= null;
    			HashMap  tempMap			= null;
    			String	resultStr			= null;
    			String	applyCheck			= null;
    			String  apply_check_edit	= null;
    			String	cntr_no_edit		= null;
    			String	wbl_dt_edit			= null;
    			String	inv_bil_amt_edit	= null;
    			String	cntrBackColor		= null;
    			String	backColor			= null;
    			
    			String changedColNms[] = null;
    			List cols = new ArrayList();


    			if(rsltSetList == null && rsltSetList.size() == 0){
    				sbufXML.append("<RESULT>");
            		sbufXML.append("<TR-ALL>OK</TR-ALL>");
            		sbufXML.append("</RESULT>");
    			}else{    				
    				cols.add("result");
    				cols.add("coincidence_check");
    				cols.add("descrepancy_check");
    				cols.add("inv_only_check");
    				cols.add("for_nis_check");
    				cols.add("eq_no");
    				cols.add("pay_flg");
    				cols.add("trsp_so_ofc_cty_cd");
    				cols.add("trsp_so_seq");
    				cols.add("rail_cmb_thru_tp_cd");
    				cols.add("cgo_tp_cd");
    				cols.add("curr_cd");
    				cols.add("bzc_amt");
    				cols.add("fuel_scg_amt");
    				cols.add("ovr_wgt_scg_amt");
    				cols.add("nego_amt");
    				cols.add("etc_add_amt");
    				cols.add("org_trsp_rail_inv_aud_cd");
    				cols.add("rail_bil_dt");
    				cols.add("eq_tpsz_cd");
    				cols.add("fm_nod_cd");
    				cols.add("fm_nod_cd1");
    				cols.add("fm_nod_cd2");
    				cols.add("to_nod_cd");
    				cols.add("to_nod_cd1");
    				cols.add("to_nod_cd2");
    				cols.add("trsp_inv_co_ind_cd");
    				cols.add("trsp_inv_tp_cd");
    				
    				changedColNms = (String[]) cols.toArray(new String[cols.size()]);
    				
    				if(seqList.size() > 0){
    					totCnt = seqList.size();
    				}
    				
    				sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' TOTAL='").append(totCnt).append("'>\n").toString());
    				
    				for ( int j = 0 ; j < eqNoList.size() ; j++)
    				{
    					dbRowSet = (DBRowSet)rsltSetList.get(j);
    					tempMap	= (HashMap)hashList.get(j);
    					resultStr = (String)resultList.get(j);
    					
    					if(resultStr != null &&
    						(
    						resultStr.equals("SML")					||
    						resultStr.equals("Domestic")			||
    						resultStr.equals("Invoice Only")		||
    						resultStr.equals("Duplicated  CNTR")	||
    						resultStr.equals("Multiple SO")
    						)
    						){
    						applyCheck						= "1";
    						apply_check_edit				= "EDIT=\"TRUE\"";
    						cntr_no_edit					= "EDIT=\"FALSE\"";
    						wbl_dt_edit						= "EDIT=\"FALSE\"";
    						inv_bil_amt_edit				= "EDIT=\"FALSE\"";
    						backColor						= "BGCOLOR=\"239,235,239\"";
    						cntrBackColor					= "BGCOLOR=\"239,235,239\"";
    					}else{
    						applyCheck						= "0";
    						apply_check_edit				= "EDIT=\"FALSE\"";
    						cntr_no_edit					= "EDIT=\"TRUE\"";
    						wbl_dt_edit						= "EDIT=\"TRUE\"";
    						inv_bil_amt_edit				= "EDIT=\"TRUE\"";
    						backColor						= "BGCOLOR=\"239,235,239\"";
    						cntrBackColor					= "BGCOLOR=\"181,201,253\"";
    					}
    					
    					sbufXML.append("<TR ROW='" + seqList.get(j) + "'>");
    					sbufXML.append("<TD COL='apply_check' " + apply_check_edit + " " + backColor + ">" + JSPUtil.getNull(applyCheck) + "</TD>");
    					    					
    					if( !"".equals( JSPUtil.getNull((String) resultList.get(j)) ) ){
    						sbufXML.append("<TD COL='result' " + backColor + ">" + JSPUtil.getNull((String) resultList.get(j)) + "</TD>");    						
    					}
    					
    					if( !"".equals( JSPUtil.getNull((String) tempMap.get("coincidence_check")) ) ){
    						sbufXML.append("<TD COL='coincidence_check'>" + JSPUtil.getNull((String) tempMap.get("coincidence_check")) + "</TD>");
    						sbufXML.append("<TD COL='pay_flg'>" + JSPUtil.getNull((String) tempMap.get("coincidence_check")) + "</TD>");
    					} 
    					
    					if( !"".equals( JSPUtil.getNull((String) tempMap.get("descrepancy_check")) ) ){
    						sbufXML.append("<TD COL='descrepancy_check'>" + JSPUtil.getNull((String) tempMap.get("descrepancy_check")) + "</TD>");    						
    					}
    					
    					if( !"".equals( JSPUtil.getNull((String) tempMap.get("inv_only_check")) ) ){
    						sbufXML.append("<TD COL='inv_only_check'>" + JSPUtil.getNull((String) tempMap.get("inv_only_check")) + "</TD>");    						
    					}
    					
    					if( !"".equals( JSPUtil.getNull((String) eqNoList.get(j)) ) ){
    						sbufXML.append("<TD COL='cntr_no' " + cntr_no_edit + " " + cntrBackColor + ">" + JSPUtil.getNull((String) eqNoList.get(j)) + "</TD>");
    						sbufXML.append("<TD COL='eq_no'>" + JSPUtil.getNull((String) eqNoList.get(j)) + "</TD>");    						
    					}
    					
    					if( !"".equals( JSPUtil.getNull((String)railAudCdList.get(j)) ) ){
    						sbufXML.append("<TD COL='org_trsp_rail_inv_aud_cd'>" + JSPUtil.getNull((String)railAudCdList.get(j)) + "</TD>");    						
    					}
    					
    					if( !"".equals( JSPUtil.getNull((String) invBilAmtList.get(j)) ) ){
    						sbufXML.append("<TD COL='inv_bil_amt' " + inv_bil_amt_edit + " " + backColor + "><![CDATA[" + JSPUtil.getNull((String) invBilAmtList.get(j)) + "]]></TD>");    						
    					}
    					
    					if( !"".equals( JSPUtil.getNull((String) wbl_dtList.get(j)) ) ){
    						sbufXML.append("<TD COL='wbl_dt' " + wbl_dt_edit + " " + backColor + ">" + JSPUtil.getNull((String) wbl_dtList.get(j)) + "</TD>");    						
    					}
    					
    					if( !"".equals( JSPUtil.getNull((String) hashParam.get("currency")) ) ){
    						sbufXML.append("<TD COL='inv_curr_cd'>" + JSPUtil.getNull((String) hashParam.get("currency")) + "</TD>");    						
    					}
    					
    					if (dbRowSet!= null && dbRowSet.next()) {
    						for (int k = 1 ; k < dbRowSet.getMetaData().getColumnCount()+1 ; k++) {
    							if( "bzc_amt".equals(dbRowSet.getMetaData().getColumnName(k).toLowerCase()) ){
    								if( !"".equals( JSPUtil.getNull(dbRowSet.getString(k)) ) ){
    									sbufXML.append("<TD COL='");
            							sbufXML.append(dbRowSet.getMetaData().getColumnName(k).toLowerCase() + "'><![CDATA[");
            							sbufXML.append(JSPUtil.getNull(dbRowSet.getString(k)));
            							sbufXML.append("]]></TD>");    									
    								}    								
    							}else if( "fuel_scg_amt".equals(dbRowSet.getMetaData().getColumnName(k).toLowerCase()) ){
    								if( !"".equals( JSPUtil.getNull(dbRowSet.getString(k)) ) ){
    									sbufXML.append("<TD COL='");
            							sbufXML.append(dbRowSet.getMetaData().getColumnName(k).toLowerCase() + "'><![CDATA[");
            							sbufXML.append(JSPUtil.getNull(dbRowSet.getString(k)));
            							sbufXML.append("]]></TD>");    									
    								}    								
    							}else if( "ovr_wgt_scg_amt".equals(dbRowSet.getMetaData().getColumnName(k).toLowerCase()) ){
    								if( !"".equals( JSPUtil.getNull(dbRowSet.getString(k)) ) ){
    									sbufXML.append("<TD COL='");
            							sbufXML.append(dbRowSet.getMetaData().getColumnName(k).toLowerCase() + "'><![CDATA[");
            							sbufXML.append(JSPUtil.getNull(dbRowSet.getString(k)));
            							sbufXML.append("]]></TD>");    									
    								}    								
    							}else if( "nego_amt".equals(dbRowSet.getMetaData().getColumnName(k).toLowerCase()) ){
    								if( !"".equals( JSPUtil.getNull(dbRowSet.getString(k)) ) ){
    									sbufXML.append("<TD COL='");
            							sbufXML.append(dbRowSet.getMetaData().getColumnName(k).toLowerCase() + "'><![CDATA[");
            							sbufXML.append(JSPUtil.getNull(dbRowSet.getString(k)));
            							sbufXML.append("]]></TD>");   									
    								}    								
    							}else if( "etc_add_amt".equals(dbRowSet.getMetaData().getColumnName(k).toLowerCase()) ){
    								if( !"".equals( JSPUtil.getNull(dbRowSet.getString(k)) ) ){
    									sbufXML.append("<TD COL='");
            							sbufXML.append(dbRowSet.getMetaData().getColumnName(k).toLowerCase() + "'><![CDATA[");
            							sbufXML.append(JSPUtil.getNull(dbRowSet.getString(k)));
            							sbufXML.append("]]></TD>");    									
    								}    								
    							}else{
    								if( !"".equals( JSPUtil.getNull(dbRowSet.getString(k)) ) ){
    									sbufXML.append("<TD COL='");
            							sbufXML.append(dbRowSet.getMetaData().getColumnName(k).toLowerCase() + "'>");
            							sbufXML.append(JSPUtil.getNull(dbRowSet.getString(k)));
            							sbufXML.append("</TD>");    									
    								}   								
    							}
    						}
    					}else{
    						if( !"".equals( JSPUtil.getNull((String)eqtpszList.get(j)) ) ){
    							sbufXML.append("<TD COL='eq_tpsz_cd'>" + JSPUtil.getNull((String)eqtpszList.get(j)) + "</TD>");    							
    						}
    					}
    					sbufXML.append("</TR>");
    				}
        	        sbufXML.append("</DATA>\n");
    			}  			
    		}
        }
        catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        return sbufXML.toString();
    }
    
    protected String makeDataTag(DBRowSet rs, String prefix, Event event)
    {
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
}

