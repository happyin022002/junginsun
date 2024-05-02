/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOSearchEstCreByMonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtBCDBDAOSearchEstCreByMonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public BudgetPortChargeMgtBCDBDAOSearchEstCreByMonRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtBCDBDAOSearchEstCreByMonRSQL").append("\n"); 
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
		query.append("SELECT V.*" ).append("\n"); 
		query.append("     , (SELECT MAX(CRE_USR_ID)" ).append("\n"); 
		query.append("          FROM PSO_TGT_YD_EXPN T" ).append("\n"); 
		query.append("         WHERE T.PSO_BZTP_CD = '2'" ).append("\n"); 
		query.append("           AND T.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("           AND T.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND T.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("           --AND T.RLANE_CD = V.RLANE_CD" ).append("\n"); 
		query.append("           --AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS CRE_USR_ID" ).append("\n"); 
		query.append("     , (SELECT /*+INDEX_DESC( T )*/" ).append("\n"); 
		query.append("               TO_CHAR(MAX(T.CRE_DT), 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("          FROM PSO_TGT_YD_EXPN T" ).append("\n"); 
		query.append("         WHERE T.PSO_BZTP_CD = '2'" ).append("\n"); 
		query.append("           AND T.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("           AND T.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND T.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("           --AND T.RLANE_CD = V.RLANE_CD" ).append("\n"); 
		query.append("           --AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) AS CRE_DT" ).append("\n"); 
		query.append("  FROM (SELECT /*+  HASH_SJ(V, TV) */" ).append("\n"); 
		query.append("               NVL(TV.EXPN_YRMON, V.REV_YRMON) AS REV_YRMON" ).append("\n"); 
		query.append("             , V.EXE_YRMON" ).append("\n"); 
		query.append("             , V.VSL_CD || V.SKD_VOY_NO || V.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("             , V.VSL_CD" ).append("\n"); 
		query.append("             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("             , V.REV_DIR_CD" ).append("\n"); 
		query.append("             , V.RLANE_CD" ).append("\n"); 
		query.append("             , V.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("          FROM GL_ESTM_REV_VVD V" ).append("\n"); 
		query.append("             , PSO_TGT_VVD TV" ).append("\n"); 
		query.append("         WHERE V.EXE_YRMON          = REPLACE(@[rev_yrmon], '-', '') /*EXE_YRMON*/" ).append("\n"); 
		query.append("           AND V.ESTM_VVD_TP_CD     = 'RV'" ).append("\n"); 
		query.append("           AND V.ESTM_IOC_DIV_CD    = 'OO'" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("           AND V.RLANE_CD LIKE @[vsl_slan_cd] || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("           AND EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("                          FROM VSK_VSL_SKD A" ).append("\n"); 
		query.append("                             , MDM_VSL_CNTR B" ).append("\n"); 
		query.append("                         WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                           AND NVL(A.ACT_CRR_CD,B.CRR_CD) = COM_CONSTANTMGR_PKG.COM_GETCOMPANYCODE_FNC()" ).append("\n"); 
		query.append("                           AND A.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                           AND A.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND A.SKD_DIR_CD = V.SKD_DIR_CD )" ).append("\n"); 
		query.append("           AND V.VSL_CD             = TV.VSL_CD(+)" ).append("\n"); 
		query.append("           AND V.SKD_VOY_NO         = TV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND V.SKD_DIR_CD         = TV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND TV.PSO_BZTP_CD       (+)= '2' ) V" ).append("\n"); 
		query.append(" ORDER BY V.REV_YRMON" ).append("\n"); 
		query.append("     , V.VSL_CD" ).append("\n"); 
		query.append("     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("     , V.SKD_DIR_CD" ).append("\n"); 

	}
}