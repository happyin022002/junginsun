/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOGNAExpAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOGNAExpAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G&A Expense Creation By Office 를 조회한다.
	  * </pre>
	  */
	public NetworkCostDBDAOGNAExpAssignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOGNAExpAssignRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	 A.TRD_CD" ).append("\n"); 
		query.append("	, A.RLANE_CD" ).append("\n"); 
		query.append("	, A.IOC_CD" ).append("\n"); 
		query.append("	, A.VSL_CD" ).append("\n"); 
		query.append("	, A.SKD_VOY_NO" ).append("\n"); 
		query.append("	, A.DIR_CD" ).append("\n"); 
		query.append("	, A.OFC_CD" ).append("\n"); 
		query.append("	, A.LOD_QTA" ).append("\n"); 
		query.append("	, A.HO_EXPN_AMT" ).append("\n"); 
		query.append("	, A.OWN_EXPN_AMT" ).append("\n"); 
		query.append("	, A.HO_QTA_RTO" ).append("\n"); 
		query.append("	, A.OWN_QTA_RTO" ).append("\n"); 
		query.append("	, A.EXPN_TTL" ).append("\n"); 
		query.append("	, A.ADJ_EXPN_TTL" ).append("\n"); 
		query.append("	, A.CRE_USR_ID" ).append("\n"); 
		query.append("	, A.CRE_DT" ).append("\n"); 
		query.append("	, A.UPD_USR_ID" ).append("\n"); 
		query.append("	, A.UPD_DT " ).append("\n"); 
		query.append("	, B.COST_YRMON " ).append("\n"); 
		query.append("	, B.COST_WK" ).append("\n"); 
		query.append("	, B.SUB_TRD_CD" ).append("\n"); 
		query.append("	, (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = C.HUL_BND_CD   ) HUL_BND_CD" ).append("\n"); 
		query.append("	, A.VSL_CD || A.SKD_VOY_NO ||  A.DIR_CD as VVD" ).append("\n"); 
		query.append("    , A.TRD_CD || A.RLANE_CD || A.IOC_CD || A.VSL_CD || A.SKD_VOY_NO || A.DIR_CD || A.OFC_CD as COMPARE_KEY" ).append("\n"); 
		query.append("FROM MAS_GEN_EXPN_ASGN A, MAS_MON_VVD B, MAS_LANE_RGST C" ).append("\n"); 
		query.append("WHERE 	 A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("	AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("	AND A.IOC_CD = B.IOC_CD" ).append("\n"); 
		query.append("	AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("	AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND A.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("	AND B.TRD_CD = C.TRD_CD" ).append("\n"); 
		query.append("	AND B.RLANE_CD = C.RLANE_CD" ).append("\n"); 
		query.append("	AND B.IOC_CD = C.IOC_CD" ).append("\n"); 
		query.append("	AND B.DIR_CD = C.DIR_CD" ).append("\n"); 
		query.append("#if(${f_chkprd} == 'M')" ).append("\n"); 
		query.append("	AND B.COST_YRMON = @[f_year]||@[f_mon]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND SUBSTR(B.COST_YRMON, 1, 4)||B.COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 		" ).append("\n"); 
		query.append("	 B.COST_YRMON " ).append("\n"); 
		query.append("	, B.COST_WK" ).append("\n"); 
		query.append("	, A.TRD_CD" ).append("\n"); 
		query.append("	, A.RLANE_CD" ).append("\n"); 
		query.append("	, A.IOC_CD" ).append("\n"); 
		query.append("	, A.VSL_CD" ).append("\n"); 
		query.append("	, A.SKD_VOY_NO" ).append("\n"); 
		query.append("	, A.DIR_CD" ).append("\n"); 
		query.append("	, A.OFC_CD" ).append("\n"); 

	}
}