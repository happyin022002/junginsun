/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOBasicRegisterDBDAOSearchFinalRevenueVvdListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDBDAOSearchFinalRevenueVvdListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Final Revenue Vvd List
	  * </pre>
	  */
	public TCharterIOBasicRegisterDBDAOSearchFinalRevenueVvdListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDBDAOSearchFinalRevenueVvdListVORSQL").append("\n"); 
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
		query.append("SELECT 'I' ibflag" ).append("\n"); 
		query.append(",	A.REV_YRMON" ).append("\n"); 
		query.append(",	A.VSL_CD" ).append("\n"); 
		query.append(",	A.SKD_VOY_NO" ).append("\n"); 
		query.append(",	A.SKD_DIR_CD" ).append("\n"); 
		query.append(",	A.REV_DIR_CD" ).append("\n"); 
		query.append(",	A.VST_DT" ).append("\n"); 
		query.append(",	A.VED_DT" ).append("\n"); 
		query.append(",	A.RLANE_CD" ).append("\n"); 
		query.append(",	M.VSL_SLAN_CD SLAN_CD" ).append("\n"); 
		query.append(",	A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("FROM MDM_REV_LANE M, GL_ESTM_REV_VVD A" ).append("\n"); 
		query.append("WHERE	M.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("AND		A.EXE_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND		A.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND     A.LINE_NO = '1'" ).append("\n"); 
		query.append("AND		EXISTS (SELECT NULL FROM FMS_CONTRACT " ).append("\n"); 
		query.append("				WHERE  VSL_CD = A.VSL_CD AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                AND    FLET_CTRT_TP_CD <> 'OW'" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("				SELECT NULL FROM FMS_CONTRACT FC, FMS_ID_VSL FI " ).append("\n"); 
		query.append("				WHERE FI.VSL_CD = A.VSL_CD AND FC.FLET_CTRT_NO = FI.FLET_CTRT_NO " ).append("\n"); 
		query.append("				AND   FC.FLET_CTRT_FACT_CD = 'ACT' AND FI.USE_FLG = 'Y')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'I' ibflag" ).append("\n"); 
		query.append(",	A.REV_YRMON" ).append("\n"); 
		query.append(",	A.VSL_CD" ).append("\n"); 
		query.append(",	A.SKD_VOY_NO" ).append("\n"); 
		query.append(",	A.SKD_DIR_CD" ).append("\n"); 
		query.append(",	A.REV_DIR_CD" ).append("\n"); 
		query.append(",	A.VST_DT" ).append("\n"); 
		query.append(",	A.VED_DT" ).append("\n"); 
		query.append(",	A.RLANE_CD" ).append("\n"); 
		query.append(",	M.VSL_SLAN_CD SLAN_CD" ).append("\n"); 
		query.append(",	A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("FROM MDM_REV_LANE M, GL_ESTM_REV_VVD A" ).append("\n"); 
		query.append("WHERE	M.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("AND		A.EXE_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND		A.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND		A.SKD_DIR_CD = 'V'" ).append("\n"); 
		query.append("AND		A.REV_DIR_CD = 'V'" ).append("\n"); 
		query.append("AND     NVL(A.LINE_NO,'0') <> '1'" ).append("\n"); 
		query.append("AND		EXISTS (SELECT NULL FROM FMS_CONTRACT " ).append("\n"); 
		query.append("				WHERE  VSL_CD = A.VSL_CD AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                AND    FLET_CTRT_TP_CD <> 'OW'" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("				SELECT NULL FROM FMS_CONTRACT FC, FMS_ID_VSL FI " ).append("\n"); 
		query.append("				WHERE FI.VSL_CD = A.VSL_CD AND FC.FLET_CTRT_NO = FI.FLET_CTRT_NO " ).append("\n"); 
		query.append("				AND FC.FLET_CTRT_FACT_CD = 'ACT' AND FI.USE_FLG = 'Y')" ).append("\n"); 

	}
}