/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOSearchOpJobCarrierListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOSearchOpJobCarrierListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOSearchOpJobCarrierListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtfmmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txttomonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtyear",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txttoweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtfmweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOSearchOpJobCarrierListRSQL").append("\n"); 
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
		query.append("SELECT /*+ FULL(A) */  -- 2010.10.06 이행지" ).append("\n"); 
		query.append("       DISTINCT " ).append("\n"); 
		query.append("       '000' AS  BSA_OP_JB_CD, " ).append("\n"); 
		query.append("		   B.CRR_CD " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("      MAS_MON_VVD_YRY_PLN A, " ).append("\n"); 
		query.append("      BSA_BUD_VVD_CRR_PERF B " ).append("\n"); 
		query.append("  WHERE A.TRD_CD       = B.TRD_CD " ).append("\n"); 
		query.append("    AND A.RLANE_CD     = B.RLANE_CD " ).append("\n"); 
		query.append("    AND A.VSL_CD       = B.VSL_CD " ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO   = B.SKD_VOY_NO " ).append("\n"); 
		query.append("    AND A.DIR_CD       = B.SKD_DIR_CD " ).append("\n"); 
		query.append("    AND NVL(A.DELT_FLG,'N') = 'N'   /*추가 (KEVIN.KIM)*/" ).append("\n"); 
		query.append("#if (${chkprd} == 'M') " ).append("\n"); 
		query.append("	AND A.COST_YRMON  BETWEEN @[txtyear] ||@[txtfmmonth]  AND @[txtyear]||@[txttomonth]" ).append("\n"); 
		query.append("#elseif (${chkprd} == 'W') " ).append("\n"); 
		query.append("	AND A.SLS_YRMON   LIKE @[txtyear] || '%' " ).append("\n"); 
		query.append("	AND A.COST_WK     BETWEEN @[txtfmweek] AND @[txttoweek] " ).append("\n"); 
		query.append("#end			" ).append("\n"); 
		query.append("    AND B.BSA_OP_JB_CD = '000' " ).append("\n"); 
		query.append(" UNION ALL " ).append("\n"); 
		query.append(" SELECT DISTINCT " ).append("\n"); 
		query.append("		BSA_OP_JB_CD, " ).append("\n"); 
		query.append("		CRR_CD " ).append("\n"); 
		query.append("  FROM BSA_CRR_RGST " ).append("\n"); 
		query.append("  WHERE ((BSA_OP_JB_CD = '001' AND BSA_OP_CD='J') OR (BSA_OP_JB_CD IN ('002','003','004','005'))) " ).append("\n"); 
		query.append("    AND APLY_FLG = 'Y' " ).append("\n"); 
		query.append("    AND CRR_CD != 'SML' " ).append("\n"); 
		query.append("  ORDER BY BSA_OP_JB_CD, " ).append("\n"); 
		query.append("           CRR_CD" ).append("\n"); 

	}
}