/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeInvDtlByVvdOwnerAccountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeInvDtlByVvdOwnerAccountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OA 계정만 가져오기
	  * </pre>
	  */
	public CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeInvDtlByVvdOwnerAccountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeInvDtlByVvdOwnerAccountRSQL").append("\n"); 
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
		query.append("SELECT   RQST_AMT AS CREDITS," ).append("\n"); 
		query.append("            T1.VNDR_SEQ, " ).append("\n"); 
		query.append("            T1.PSO_BZTP_CD," ).append("\n"); 
		query.append("            T1.VSL_CD," ).append("\n"); 
		query.append("            T1.SKD_VOY_NO," ).append("\n"); 
		query.append("            T1.SKD_DIR_CD," ).append("\n"); 
		query.append("            T1.YD_CD," ).append("\n"); 
		query.append("            T1.CALL_SEQ," ).append("\n"); 
		query.append("            ( SELECT SUM(RQST_AMT)" ).append("\n"); 
		query.append("                FROM PSO_CNL_TZ_FEE A, PSO_CNL_TZ_FEE_DTL B" ).append("\n"); 
		query.append("               WHERE A.VSL_CD         = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                 AND A.SKD_VOY_NO     = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                 AND A.SKD_DIR_CD     = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                 AND A.YD_CD          = @[yd_cd]" ).append("\n"); 
		query.append("                 AND A.CALL_SEQ       < @[call_seq]                   " ).append("\n"); 
		query.append("                 AND A.CNL_TZ_BZTP_CD = 'I'" ).append("\n"); 
		query.append("                 AND A.VSL_CD         =  B.VSL_CD" ).append("\n"); 
		query.append("                 AND A.SKD_VOY_NO     =  B.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND A.SKD_DIR_CD     =  B.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND A.YD_CD          =  B.YD_CD" ).append("\n"); 
		query.append("                 AND A.PSO_BZTP_CD    = '5'" ).append("\n"); 
		query.append("                 AND A.PSO_BZTP_CD    = B.PSO_BZTP_CD" ).append("\n"); 
		query.append("                 AND B.LGS_COST_CD    LIKE 'CNOW%' ) LAST_INV," ).append("\n"); 
		query.append("               REPLACE(( SELECT WM_CONCAT ( C.INV_NO ||' '|| B.LGS_COST_CD ||' '||B.RQST_AMT ||' '|| B.DIFF_RMK)" ).append("\n"); 
		query.append("                FROM PSO_CNL_TZ_FEE A, PSO_CNL_TZ_FEE_DTL B, PSO_CHARGE C" ).append("\n"); 
		query.append("               WHERE A.VSL_CD         =  substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                 AND A.SKD_VOY_NO     =  substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                 AND A.SKD_DIR_CD     =  substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                 AND A.YD_CD          =  @[yd_cd]" ).append("\n"); 
		query.append("                 AND A.CALL_SEQ       <  @[call_seq]" ).append("\n"); 
		query.append("                 AND A.CNL_TZ_BZTP_CD = 'I'" ).append("\n"); 
		query.append("                 AND A.VSL_CD         =  B.VSL_CD" ).append("\n"); 
		query.append("                 AND A.SKD_VOY_NO     =  B.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND A.SKD_DIR_CD     =  B.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND A.YD_CD          =  B.YD_CD" ).append("\n"); 
		query.append("                 AND A.PSO_BZTP_CD    = '5'" ).append("\n"); 
		query.append("                 AND A.PSO_BZTP_CD    = B.PSO_BZTP_CD" ).append("\n"); 
		query.append("                 AND A.ISS_CTY_CD     = C.ISS_CTY_CD" ).append("\n"); 
		query.append("                 AND A.SO_SEQ         = C.SO_SEQ " ).append("\n"); 
		query.append("                 AND B.LGS_COST_CD    LIKE 'CNOW%'  ),',','\\\\n')  INV_DESC," ).append("\n"); 
		query.append("            C1.LGS_COST_CD," ).append("\n"); 
		query.append("            C1.LGS_COST_FULL_NM," ).append("\n"); 
		query.append("            T2.DIFF_RMK," ).append("\n"); 
		query.append("            RQST_AMT AS CALC_AMT," ).append("\n"); 
		query.append("            T2.YD_CHG_NO," ).append("\n"); 
		query.append("            T2.YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("            T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("           ( SELECT COUNT(*)" ).append("\n"); 
		query.append("            FROM PSO_CNL_TZ_ATCH_FILE X" ).append("\n"); 
		query.append("           WHERE X.VSL_CD         = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("             AND X.SKD_VOY_NO     = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("             AND X.SKD_DIR_CD     = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("             AND X.YD_CD          = @[yd_cd]" ).append("\n"); 
		query.append("             AND X.CALL_SEQ       =  T1.CALL_SEQ" ).append("\n"); 
		query.append("	         AND X.LGS_COST_CD     = T2.LGS_COST_CD" ).append("\n"); 
		query.append("              AND X.LGS_COST_CD    IS NOT NULL" ).append("\n"); 
		query.append("           ) AS ATCH_FILE_NO," ).append("\n"); 
		query.append("           ( SELECT COUNT(*)" ).append("\n"); 
		query.append("              FROM PSO_CNL_TZ_ATCH_FILE X" ).append("\n"); 
		query.append("             WHERE X.VSL_CD          = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                AND X.SKD_VOY_NO     = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                AND X.SKD_DIR_CD     = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                AND X.YD_CD          = @[yd_cd]" ).append("\n"); 
		query.append("                AND X.CALL_SEQ       = T1.CALL_SEQ" ).append("\n"); 
		query.append("                AND X.LGS_COST_CD    IS NULL" ).append("\n"); 
		query.append("             ) AS INV_ATCH_FILE_NO" ).append("\n"); 
		query.append("    FROM PSO_CNL_TZ_FEE T1," ).append("\n"); 
		query.append("         PSO_CNL_TZ_FEE_DTL T2," ).append("\n"); 
		query.append("         TES_LGS_COST C1" ).append("\n"); 
		query.append("  WHERE T1.PSO_BZTP_CD       = T2.PSO_BZTP_CD" ).append("\n"); 
		query.append("     AND T1.VSL_CD           = T2.VSL_CD" ).append("\n"); 
		query.append("     AND T1.SKD_VOY_NO       = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND T1.SKD_DIR_CD       = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND T1.YD_CD            = T2.YD_CD" ).append("\n"); 
		query.append("     AND T1.CALL_SEQ         = T2.CALL_SEQ" ).append("\n"); 
		query.append("     AND T2.LGS_COST_CD      = C1.LGS_COST_CD" ).append("\n"); 
		query.append("     AND T1.PSO_BZTP_CD      = '5'" ).append("\n"); 
		query.append("     AND T1.YD_CD            = @[yd_cd]" ).append("\n"); 
		query.append("     AND T1.CNL_TZ_BZTP_CD   = 'I'" ).append("\n"); 
		query.append("     AND T1.NTC_YRMON        = @[rev_yrmon]" ).append("\n"); 
		query.append("     AND T1.VSL_CD           = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("     AND T1.SKD_VOY_NO       = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("     AND T1.SKD_DIR_CD       = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("     AND T2.LGS_COST_CD      LIKE 'CNOW%'" ).append("\n"); 
		query.append("ORDER BY lgs_cost_cd" ).append("\n"); 

	}
}