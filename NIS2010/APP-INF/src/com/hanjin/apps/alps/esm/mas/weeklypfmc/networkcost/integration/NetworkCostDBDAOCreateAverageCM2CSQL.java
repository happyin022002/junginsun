/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : NetworkCostDBDAOCreateAverageCM2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.02.06 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOCreateAverageCM2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Average U/C (CM2) 생성
	  * </pre>
	  */
	public NetworkCostDBDAOCreateAverageCM2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCreateAverageCM2CSQL").append("\n"); 
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
		query.append("INSERT  INTO MAS_OP_AVG_UT_COST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        COST_YRMON" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , STND_COST_CD" ).append("\n"); 
		query.append("      , COST_USE_TP_CD" ).append("\n"); 
		query.append("      , OP_COST_AMT" ).append("\n"); 
		query.append("      , BSA_CAPA" ).append("\n"); 
		query.append("      , OP_UC_AMT" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    @[cost_yrmon]" ).append("\n"); 
		query.append("  , C2.TRD_CD" ).append("\n"); 
		query.append("  , C2.RLANE_CD" ).append("\n"); 
		query.append("  , C2.DIR_CD" ).append("\n"); 
		query.append("  , '51701011' STND_COST_CD" ).append("\n"); 
		query.append("  , 'C' COST_USE_TP_CD" ).append("\n"); 
		query.append("  , NVL(SUM(C.VVD_COST),0) TOTAL_OP_AMT" ).append("\n"); 
		query.append("  , NVL(SUM(C.VVD_BSA_CAPA),0) TOTAL_BSA" ).append("\n"); 
		query.append("  , DECODE(NVL(SUM(C.VVD_BSA_CAPA),0),0,0,NVL(SUM(C.VVD_COST),0)/NVL(SUM(C.VVD_BSA_CAPA),0)) OP_UC_AMT" ).append("\n"); 
		query.append("  , @[cre_usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , @[upd_usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.TRD_CD" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.VSL_CD" ).append("\n"); 
		query.append("      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("      , A.DIR_CD" ).append("\n"); 
		query.append("      , SUM(DECODE(A.STND_COST_CD, 43102011, 0, A.OP_COST_AMT)) " ).append("\n"); 
		query.append("         - SUM(DECODE(A.STND_COST_CD, 43102011, A.OP_COST_AMT, 0)) VVD_COST" ).append("\n"); 
		query.append("      , MAX(A.BSA_CAPA) OVER(PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD) VVD_BSA_CAPA" ).append("\n"); 
		query.append("      , MAX(A.VVD_SEQ) OVER(PARTITION BY A.TRD_CD, A.RLANE_CD, A.DIR_CD) L_MAX_VVD_SEQ --변경" ).append("\n"); 
		query.append("      , A.VVD_SEQ" ).append("\n"); 
		query.append("      , B.FREQ_NO --5" ).append("\n"); 
		query.append("    FROM MAS_OP_AVG_UT_COST_IF A" ).append("\n"); 
		query.append("      , MAS_LANE_VSL_FREQ B" ).append("\n"); 
		query.append("    WHERE A.COST_YRMON     = @[cost_yrmon]" ).append("\n"); 
		query.append("    AND B.TRD_CD        IN ('IAS', 'IMS', 'IES')" ).append("\n"); 
		query.append("    AND B.COST_USE_TP_CD = 'C'" ).append("\n"); 
		query.append("    AND A.TRD_CD         = B.TRD_CD" ).append("\n"); 
		query.append("    AND A.RLANE_CD       = B.RLANE_CD" ).append("\n"); 
		query.append("    AND A.COST_USE_TP_CD = B.COST_USE_TP_CD" ).append("\n"); 
		query.append("    AND A.DIR_CD         = B.DIR_CD  --추가" ).append("\n"); 
		query.append("    GROUP BY A.TRD_CD" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.VSL_CD" ).append("\n"); 
		query.append("      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("      , A.DIR_CD" ).append("\n"); 
		query.append("      , A.BSA_CAPA" ).append("\n"); 
		query.append("      , A.VVD_SEQ" ).append("\n"); 
		query.append("      , B.FREQ_NO" ).append("\n"); 
		query.append(") C, MAS_LANE_RGST C2" ).append("\n"); 
		query.append("WHERE C.L_MAX_VVD_SEQ(+)    >= C.FREQ_NO(+)" ).append("\n"); 
		query.append("AND   C.VVD_SEQ(+)          <= C.FREQ_NO(+)" ).append("\n"); 
		query.append("AND   C.TRD_CD(+)           = C2.TRD_CD" ).append("\n"); 
		query.append("AND   C.RLANE_CD(+)         = C2.RLANE_CD" ).append("\n"); 
		query.append("AND   C.DIR_CD(+)           = C2.DIR_CD        " ).append("\n"); 
		query.append("AND   C2.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("AND   C2.TRD_CD             IN ('IAS', 'IMS', 'IES')" ).append("\n"); 
		query.append("AND   C2.SUB_TRD_CD         <> 'IP'" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("    C2.TRD_CD" ).append("\n"); 
		query.append("  , C2.RLANE_CD" ).append("\n"); 
		query.append("  , C2.DIR_CD" ).append("\n"); 

	}
}