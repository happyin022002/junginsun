/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOEstdCarRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOEstdCarRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOEstdCarRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOEstdCarRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       DECODE(BSA_OP_JB_CD,'001','R','002','R','004','R','000','E','003','E','005','E') BSA_OP_JB_CD," ).append("\n"); 
		query.append("       A.RLANE_CD, C.CRR_CD JO_CRR_CD" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD A" ).append("\n"); 
		query.append("     , BSA_VVD_MST B" ).append("\n"); 
		query.append("     , BSA_VVD_CRR_PERF C, (SELECT MIN(REV_YRMON)MIN_REV_YRMON, MAX(REV_YRMON) MAX_REV_YRMON" ).append("\n"); 
		query.append("                              FROM JOO_ESTM_ACT_RSLT J" ).append("\n"); 
		query.append("                             WHERE J.EXE_YRMON = @[acct_yrmon])   M_P" ).append("\n"); 
		query.append(" WHERE A.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.DIR_CD        = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.TRD_CD        = B.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD      = B.RLANE_CD" ).append("\n"); 
		query.append("   AND A.VSL_CD        = C.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO    = C.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.DIR_CD        = C.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.TRD_CD        = C.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD      = C.RLANE_CD" ).append("\n"); 
		query.append("   AND A.COST_YRMON BETWEEN M_P.MIN_REV_YRMON AND M_P.MAX_REV_YRMON" ).append("\n"); 
		query.append("   AND C.CRR_CD       <> 'SML'" ).append("\n"); 
		query.append("   AND A.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("   -- 2010.01.20 TEU, PRICE중 하나라도 0이 아니면 나와야 한다." ).append("\n"); 
		query.append("   AND   NOT (NVL(C.CRR_BSA_CAPA,0) = 0 AND NVL(C.SLT_PRC_CAPA,0) = 0)" ).append("\n"); 
		query.append("--   AND (C.CRR_BSA_CAPA) <> 0 AND (C.CRR_PERF_AMT) <> 0" ).append("\n"); 
		query.append("MINUS " ).append("\n"); 
		query.append("SELECT DISTINCT S.*" ).append("\n"); 
		query.append(" FROM ( " ).append("\n"); 
		query.append("       SELECT 'E' BSA_OP_JB_CD,RLANE_CD, JO_CRR_CD FROM JOO_CARRIER" ).append("\n"); 
		query.append("        WHERE  VNDR_SEQ IS NOT NULL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("       SELECT 'R' BSA_OP_JB_CD,RLANE_CD, JO_CRR_CD FROM JOO_CARRIER" ).append("\n"); 
		query.append("      WHERE  CUST_SEQ IS NOT NULL )S" ).append("\n"); 
		query.append("ORDER BY RLANE_CD, JO_CRR_CD" ).append("\n"); 

	}
}