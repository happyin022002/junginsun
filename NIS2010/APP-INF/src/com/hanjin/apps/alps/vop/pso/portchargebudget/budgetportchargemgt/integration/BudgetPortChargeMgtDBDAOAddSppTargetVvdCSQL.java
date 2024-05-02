/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOAddSppTargetVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOAddSppTargetVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOAddSppTargetVvdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bztp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOAddSppTargetVvdCSQL").append("\n"); 
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
		query.append("INSERT INTO PSO_TGT_VVD" ).append("\n"); 
		query.append("  (PSO_BZTP_CD," ).append("\n"); 
		query.append("   VSL_CD," ).append("\n"); 
		query.append("   SKD_VOY_NO," ).append("\n"); 
		query.append("   SKD_DIR_CD," ).append("\n"); 
		query.append("   VSL_SLAN_CD," ).append("\n"); 
		query.append("   EXPN_YRMON," ).append("\n"); 
		query.append("   CNTR_VSL_CLSS_CAPA," ).append("\n"); 
		query.append("   PSO_VVD_ACT_STS_CD," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  SELECT DISTINCT @[bztp_cd] AS PSO_BZTP_CD" ).append("\n"); 
		query.append("                 ,T2.VSL_CD AS VSL_CD" ).append("\n"); 
		query.append("                 ,T2.SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("                 ,T2.SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                 ,T1.VSL_SLAN_CD AS VSL_SLAN_CD" ).append("\n"); 
		query.append("                 ,TO_CHAR(T2.VPS_ETB_DT, 'YYYYMM') AS EXPN_YRMON" ).append("\n"); 
		query.append("                 ,CNTR_VSL_CLSS_CAPA AS CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                 ,'N' AS PSO_VVD_ACT_STS_CD" ).append("\n"); 
		query.append("                 ,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("                 ,SYSDATE" ).append("\n"); 
		query.append("                 ,@[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("                 ,SYSDATE" ).append("\n"); 
		query.append("  FROM   VSK_VSL_SKD          T1" ).append("\n"); 
		query.append("        ,VSK_VSL_PORT_SKD     T2" ).append("\n"); 
		query.append("        ,MDM_VSL_SVC_LANE_DIR T3" ).append("\n"); 
		query.append("        ,VSK_CNL_VNDR         T5" ).append("\n"); 
		query.append("        ,MDM_VENDOR           T6" ).append("\n"); 
		query.append("        ,MDM_VSL_CNTR         T9" ).append("\n"); 
		query.append("  WHERE  1 = 1" ).append("\n"); 
		query.append("  AND    T1.VSL_CD           = T2.VSL_CD" ).append("\n"); 
		query.append("  AND    T1.SKD_VOY_NO       = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND    T1.SKD_DIR_CD       = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND    T1.VSL_SLAN_CD      = T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("  AND    T3.SVC_SCP_BND_CD IS NOT NULL" ).append("\n"); 
		query.append("  AND    T2.SKD_DIR_CD       = T3.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("  AND    T1.VSL_SLAN_CD      = T5.VSL_SLAN_CD" ).append("\n"); 
		query.append("  AND    T5.CNL_AGN_VNDR_SEQ = T6.VNDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--  AND    T2.VPS_ETB_DT BETWEEN TO_DATE(*tgt_date || '-01', 'YYYY-MM-DD') --input" ).append("\n"); 
		query.append("--         AND LAST_DAY(TO_DATE(*tgt_date, 'YYYY-MM')) + 0.99999 --input" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND    T2.VPS_ETB_DT >= TO_DATE(REPLACE(@[tgt_date], '-', '') || '01', 'YYYYMMDD')" ).append("\n"); 
		query.append("  AND    T2.VPS_ETB_DT <  ADD_MONTHS(TO_DATE(REPLACE(@[tgt_date], '-', '') || '01', 'YYYYMMDD'), DECODE(@[bztp_cd], '5', 1, '6', 12)) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND    'S' <> NVL(T2.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("  AND    T1.VSL_CD                     = T9.VSL_CD" ).append("\n"); 
		query.append("  AND    NVL(T1.ACT_CRR_CD, T9.CRR_CD) = 'SML'" ).append("\n"); 
		query.append("  AND    T6.CNL_AGN_FLG                = 'Y'" ).append("\n"); 
		query.append("  AND    T2.VPS_PORT_CD                = @[port_cd] --input" ).append("\n"); 
		query.append("  AND    NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                       FROM PSO_TGT_VVD T" ).append("\n"); 
		query.append("                      WHERE T.PSO_BZTP_CD = @[bztp_cd]" ).append("\n"); 
		query.append("                        AND T.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                        AND T.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND T.SKD_DIR_CD = T1.SKD_DIR_CD)" ).append("\n"); 

	}
}