/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOSearchContractCarriageBLGet1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.03.05 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchContractCarriageBLGet1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchContractCarriage  B/L Get  (1)
	  * </pre>
	  */
	public ClaimMainDBDAOSearchContractCarriageBLGet1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchContractCarriageBLGet1RSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append("      ,BK.POR_CD                        AS POR_CD" ).append("\n"); 
		query.append("      ,BK.POL_CD                        AS POL_CD" ).append("\n"); 
		query.append("      ,BK.POD_CD                        AS POD_CD" ).append("\n"); 
		query.append("      ,BK.DEL_CD                        AS DEL_CD" ).append("\n"); 
		query.append("      ,BK.PRE_RLY_PORT_CD				AS N1ST_PRE_TS_LOC_CD" ).append("\n"); 
		query.append("      ,BK.PST_RLY_PORT_CD				AS N1ST_PST_TS_LOC_CD" ).append("\n"); 
		query.append("      ,BK.RCV_TERM_CD||BK.DE_TERM_CD    AS CRR_TERM_CD" ).append("\n"); 
		query.append("      ,BK.REP_CMDT_CD                   AS REP_CMDT_CD" ).append("\n"); 
		query.append("      ,BL.PCK_TP_CD" ).append("\n"); 
		query.append("      ,VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD    AS TRNK_REF_VVD_NO" ).append("\n"); 
		query.append("      ,RATE.FRT_TERM_CD                 AS CLM_OFRT_TERM_CD" ).append("\n"); 
		query.append("      ,BK.SLAN_CD                       AS SLAN_CD" ).append("\n"); 
		query.append("      ,REP_CMDT.REP_CMDT_NM" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, BKG_BL_DOC BL, BKG_VVD VVD, BKG_RATE RATE," ).append("\n"); 
		query.append("     MDM_PCK_TP PCK, MDM_REP_CMDT REP_CMDT" ).append("\n"); 
		query.append("WHERE BL_NO        = @[bl_no]" ).append("\n"); 
		query.append("  AND BK.BKG_NO    = BL.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BK.BKG_NO    = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BK.BKG_NO    = VVD.BKG_NO(+)" ).append("\n"); 
		query.append("  AND 'T'          = VVD.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("  AND '0'          = VVD.VSL_SEQ(+)" ).append("\n"); 
		query.append("  AND BL.PCK_TP_CD = PCK.PCK_CD(+)" ).append("\n"); 
		query.append("  AND BK.REP_CMDT_CD    = REP_CMDT.REP_CMDT_CD(+)" ).append("\n"); 

	}
}