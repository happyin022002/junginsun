/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGOHChargeGuidelineDBDAOPriSgGohChgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.05 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGOHChargeGuidelineDBDAOPriSgGohChgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCGOHChargeGuidelineDBDAOPriSgGohChgVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT /*+ INDEX(A XPKPRI_SG_GOH_CHG ) */" ).append("\n"); 
		query.append("A.SVC_SCP_CD" ).append("\n"); 
		query.append(",A.GLINE_SEQ" ).append("\n"); 
		query.append(",A.GOH_CHG_SEQ" ).append("\n"); 
		query.append(",A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",(DECODE (LENGTH(ROUT_PNT_LOC_DEF_CD),'2'" ).append("\n"); 
		query.append(",(SELECT CNT_NM" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE CNT_CD = A.ROUT_PNT_LOC_DEF_CD )" ).append("\n"); 
		query.append(",(SELECT LOC_NM" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD ))) AS LOC_DES" ).append("\n"); 
		query.append(",A.RAT_UT_CD" ).append("\n"); 
		query.append(",A.PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.FRT_RT_AMT" ).append("\n"); 
		query.append(",CASE A.PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("WHEN 'S' THEN 1" ).append("\n"); 
		query.append("WHEN 'D' THEN 2" ).append("\n"); 
		query.append("WHEN 'T' THEN 3" ).append("\n"); 
		query.append("END BAR_ORD" ).append("\n"); 
		query.append(",CASE A.RAT_UT_CD" ).append("\n"); 
		query.append("WHEN 'D2' THEN 1" ).append("\n"); 
		query.append("WHEN 'D4' THEN 2" ).append("\n"); 
		query.append("WHEN 'D5' THEN 3" ).append("\n"); 
		query.append("ELSE 4" ).append("\n"); 
		query.append("END PER_ORD" ).append("\n"); 
		query.append("FROM PRI_SG_GOH_CHG A" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   GLINE_SEQ   = @[gline_seq]" ).append("\n"); 
		query.append("ORDER BY A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(",A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(",BAR_ORD" ).append("\n"); 
		query.append(",PER_ORD" ).append("\n"); 
		query.append(",A.RAT_UT_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.integration").append("\n"); 
		query.append("FileName : SCGOHChargeGuidelineDBDAOPriSgGohChgVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}