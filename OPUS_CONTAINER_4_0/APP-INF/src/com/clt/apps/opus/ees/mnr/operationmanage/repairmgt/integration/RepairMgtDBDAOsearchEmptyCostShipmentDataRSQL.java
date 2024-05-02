/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RepairMgtDBDAOsearchEmptyCostShipmentDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchEmptyCostShipmentDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public RepairMgtDBDAOsearchEmptyCostShipmentDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchEmptyCostShipmentDataRSQL").append("\n"); 
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
		query.append("SELECT A.COST_CD, " ).append("\n"); 
		query.append("       A.COST_DTL_CD," ).append("\n"); 
		query.append("       A.EQ_NO, " ).append("\n"); 
		query.append("       TO_CHAR(A.RPR_RSLT_DT, 'YYYYMMDD') AS RPR_RSLT_DT, " ).append("\n"); 
		query.append("       B.EQ_KND_CD," ).append("\n"); 
		query.append("       A.MNR_ORD_OFC_CTY_CD," ).append("\n"); 
		query.append("       A.MNR_ORD_SEQ," ).append("\n"); 
		query.append("       A.ORD_DTL_SEQ" ).append("\n"); 
		query.append("  FROM MNR_ORD_DTL A, MNR_ORD_HDR B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.MNR_ORD_SEQ = B.MNR_ORD_SEQ" ).append("\n"); 
		query.append("   AND A.COST_CD||A.COST_DTL_CD IN ( SELECT PRNT_CD_ID || MNR_CD_ID " ).append("\n"); 
		query.append("                                       FROM MNR_GEN_CD" ).append("\n"); 
		query.append("                                      WHERE COST_SHP_SRCH_PATT_NM IS NOT NULL)" ).append("\n"); 
		query.append("--   AND A.CRE_DT BETWEEN TO_DATE(TO_CHAR(TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - 60, 'YYYYMMDD'), 'YYYYMMDD') AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("   AND (A.BKG_NO IS NULL OR A.TRD_CD IS NULL)" ).append("\n"); 
		query.append("   AND A.PAY_INV_SEQ IS NULL" ).append("\n"); 

	}
}