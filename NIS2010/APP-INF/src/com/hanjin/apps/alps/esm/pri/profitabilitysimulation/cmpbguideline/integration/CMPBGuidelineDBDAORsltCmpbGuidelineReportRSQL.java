/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMPBGuidelineDBDAORsltCmpbGuidelineReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.12.28 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMPBGuidelineDBDAORsltCmpbGuidelineReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cmpb gine vo 생성용 쿼리
	  * </pre>
	  */
	public CMPBGuidelineDBDAORsltCmpbGuidelineReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration ").append("\n"); 
		query.append("FileName : CMPBGuidelineDBDAORsltCmpbGuidelineReportRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS PRS_CUST_TP_NM  						--CUSTOMER TYPE NAME" ).append("\n"); 
		query.append(",       '' AS VSL_SLAN_CD                           --SVC_LANE" ).append("\n"); 
		query.append(",       '' AS PRC_CMDT_DEF_CD                       --COMMODITY" ).append("\n"); 
		query.append(",       '' AS ORG_ROUT_PNT_LOC_DEF_CD            	--ORIGIN PNT" ).append("\n"); 
		query.append(",       '' AS ORG_ROUT_VIA_PORT_DEF_CD          	--ORIGIN VIA" ).append("\n"); 
		query.append(",       '' AS DEST_ROUT_VIA_PORT_DEF_CD         	--DEST VIA" ).append("\n"); 
		query.append(",       '' AS DEST_ROUT_PNT_LOC_DEF_CD           	--DEST PNT" ).append("\n"); 
		query.append(",       '' AS R_RCV_DE_TERM_CD                      --R TERM" ).append("\n"); 
		query.append(",       '' AS D_RCV_DE_TERM_CD                      --D TERM" ).append("\n"); 
		query.append(",       '' AS RAT_UT_CD                             --PER" ).append("\n"); 
		query.append(",       '' AS PRC_CGO_TP_CD                         --CARGO" ).append("\n"); 
		query.append(",       '' AS CURR_CD                               --CURR" ).append("\n"); 
		query.append(",       '' AS CMPB_AMT                              --AMT" ).append("\n"); 
		query.append(",       '' AS CRE_OFC_CD                            --OFFICE" ).append("\n"); 
		query.append(",       '' AS MQC_RNG_FM_QTY                        --MQC FROM" ).append("\n"); 
		query.append(",       '' AS MQC_RNG_TO_QTY                        --MQC TO" ).append("\n"); 
		query.append(",       '' AS EFF_DT                    			--EFF_DT" ).append("\n"); 
		query.append(",       '' AS EXP_DT                    			--EXP_DT" ).append("\n"); 
		query.append(",       '' AS BSE_SEQ" ).append("\n"); 
		query.append(",       '' AS CMPB_SEQ" ).append("\n"); 
		query.append(",		'' AS ORIGIN_CD" ).append("\n"); 
		query.append(",		'' AS DEST_CD" ).append("\n"); 
		query.append(",		'' AS SVC_SCP_CD" ).append("\n"); 
		query.append(",		'' AS CRE_OFC_CD" ).append("\n"); 
		query.append(",		'' AS PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",		'' AS GLINE_SEQ" ).append("\n"); 
		query.append(",		'' AS BSE_SEQ" ).append("\n"); 
		query.append(",		'' AS SEARCH_COUNT" ).append("\n"); 
		query.append(",		'' AS CRE_OFC_CD_IN" ).append("\n"); 
		query.append(",		'' AS PRS_CUST_TP_CD_IN" ).append("\n"); 
		query.append(",		'' AS RAT_UT_CD_IN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}