/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchApPayInvDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOsearchApPayInvDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * invoice 생성시 AP_PAY_INV_DTL 에 저장할 정보를 조회한다.
	  * 
	  * ========================================
	  * History
	  * 2012.06.08 진마리아 선처리[ITM-201211026] 공통 CSR로 PSO의 INOVICE DATA I/F 시 DATA 생성로직 변경 요청함.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchApPayInvDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchApPayInvDtlRSQL").append("\n"); 
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
		query.append("SELECT    T1.INV_RGST_NO" ).append("\n"); 
		query.append("        , T1.INV_RGST_SEQ" ).append("\n"); 
		query.append("        , T1.SO_ETT_TP_CD" ).append("\n"); 
		query.append("        , T1.LGS_COST_CD" ).append("\n"); 
		query.append("        , T1.ACCT_CD" ).append("\n"); 
		query.append("        , T1.VSL_CD" ).append("\n"); 
		query.append("        , CASE WHEN T1.DP_IO_BND_CD||T3.TURN_PORT_FLG = 'IY' THEN" ).append("\n"); 
		query.append("          -- IN BOUND, VIRTURE PORT 방향으로 AMOUNT 전환 후 ERP/AP 로 I/F" ).append("\n"); 
		query.append("                    T3.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                    T1.SKD_VOY_NO" ).append("\n"); 
		query.append("               END                  AS SKD_VOY_NO" ).append("\n"); 
		query.append("        , CASE WHEN T1.DP_IO_BND_CD||T3.TURN_PORT_FLG = 'IY' THEN" ).append("\n"); 
		query.append("                    T3.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                    T1.SKD_DIR_CD" ).append("\n"); 
		query.append("               END                  AS SKD_DIR_CD" ).append("\n"); 
		query.append("        , CASE WHEN T1.DP_IO_BND_CD||T3.TURN_PORT_FLG = 'IY' THEN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT  MAX(S.RLANE_DIR_CD)" ).append("\n"); 
		query.append("                    FROM    AR_MST_REV_VVD S" ).append("\n"); 
		query.append("                    WHERE   S.VSL_CD        = T1.VSL_CD" ).append("\n"); 
		query.append("                    AND     S.SKD_VOY_NO    = T3.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND     S.SKD_DIR_CD    = T3.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND     S.RLANE_CD      = NVL(PSO_GET_REV_LANE_FNC(T1.VSL_CD, T3.TURN_SKD_VOY_NO, T3.TURN_SKD_DIR_CD, SUBSTR (T1.YD_CD, 1, 5)), S.RLANE_CD)" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                    T1.REV_DIR_CD" ).append("\n"); 
		query.append("               END                  AS REV_DIR_CD" ).append("\n"); 
		query.append("        , CASE WHEN T1.DP_IO_BND_CD||T3.TURN_PORT_FLG = 'IY' THEN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT  S.VSL_SLAN_CD" ).append("\n"); 
		query.append("                    FROM    VSK_VSL_SKD    S " ).append("\n"); 
		query.append("                    WHERE   S.VSL_CD        = T1.VSL_CD" ).append("\n"); 
		query.append("                    AND     S.SKD_VOY_NO    = T3.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND     S.SKD_DIR_CD    = T3.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                    T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("               END                  AS SLAN_CD" ).append("\n"); 
		query.append("        , T3.VPS_PORT_CD            AS PORT_CD" ).append("\n"); 
		query.append("        , T1.YD_CD" ).append("\n"); 
		query.append("        , T1.INV_AMT" ).append("\n"); 
		query.append("        , T1.SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        , T1.SO_SEQ" ).append("\n"); 
		query.append("        , T1.DELT_FLG" ).append("\n"); 
		query.append("        , T1.CRE_USR_ID" ).append("\n"); 
		query.append("        , T1.CRE_DT" ).append("\n"); 
		query.append("        , T1.UPD_USR_ID" ).append("\n"); 
		query.append("        , T1.UPD_DT" ).append("\n"); 
		query.append("        , T1.INV_DESC" ).append("\n"); 
		query.append("        , T1.ORG_SO_DTL_SEQ" ).append("\n"); 
		query.append("        , T1.N3PTY_BIL_IF_FLG" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  T1.INV_RGST_NO," ).append("\n"); 
		query.append("                SO_DTL_SEQ          AS INV_RGST_SEQ," ).append("\n"); 
		query.append("                '06'                AS SO_ETT_TP_CD," ).append("\n"); 
		query.append("                T2.LGS_COST_CD, DECODE(LENGTH(T2.LGS_COST_CD), 4, 110911, T3.ACCT_CD)  AS ACCT_CD," ).append("\n"); 
		query.append("                T2.VSL_CD,   T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.REV_DIR_CD," ).append("\n"); 
		query.append("                T1.YD_CD," ).append("\n"); 
		query.append("                LOCL_AMT            INV_AMT," ).append("\n"); 
		query.append("                T1.ISS_CTY_CD       SO_OFC_CTY_CD," ).append("\n"); 
		query.append("                T1.SO_SEQ," ).append("\n"); 
		query.append("                'N'                 DELT_FLG," ).append("\n"); 
		query.append("                'USERID'            CRE_USR_ID," ).append("\n"); 
		query.append("                SYSDATE             CRE_DT," ).append("\n"); 
		query.append("                'USERID'            UPD_USR_ID," ).append("\n"); 
		query.append("                SYSDATE             UPD_DT," ).append("\n"); 
		query.append("                SUBSTR(T2.DIFF_RMK, 1, 200) AS INV_DESC," ).append("\n"); 
		query.append("                T2.DP_IO_BND_CD," ).append("\n"); 
		query.append("                T2.ORG_SO_DTL_SEQ," ).append("\n"); 
		query.append("                T2.N3PTY_BIL_IF_FLG" ).append("\n"); 
		query.append("        FROM    PSO_CHARGE T1, PSO_CHG_DTL T2, TES_LGS_COST T3" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T1.ISS_CTY_CD   = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("        AND     T1.SO_SEQ       = T2.SO_SEQ" ).append("\n"); 
		query.append("        AND     T2.LGS_COST_CD  = T3.LGS_COST_CD" ).append("\n"); 
		query.append("    #if(${inv_no}!='')" ).append("\n"); 
		query.append("    	AND (T1.ISS_CTY_CD, T1.SO_SEQ) = (SELECT ISS_CTY_CD, SO_SEQ FROM PSO_CHARGE WHERE INV_NO = @[inv_no] AND VNDR_SEQ = @[vndr_seq] )" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    	AND T1.ISS_CTY_CD  = @[iss_cty_cd]" ).append("\n"); 
		query.append("    	AND T1.SO_SEQ      = @[so_seq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        ) T1, VSK_VSL_SKD T2, VSK_VSL_PORT_SKD T3" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     T1.VSL_CD       = T2.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO   = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD   = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T1.VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T1.YD_CD        = T3.YD_CD" ).append("\n"); 
		query.append("AND     T3.CLPT_IND_SEQ =" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT  MIN(CLPT_IND_SEQ)" ).append("\n"); 
		query.append("       FROM    VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("       WHERE   S.VSL_CD              = T3.VSL_CD" ).append("\n"); 
		query.append("       AND     S.SKD_VOY_NO          = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND     S.SKD_DIR_CD          = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND     S.YD_CD               = T3.YD_CD" ).append("\n"); 
		query.append("       AND     'S'                  != NVL(S.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  T1.INV_RGST_NO," ).append("\n"); 
		query.append("        SO_DTL_SEQ          AS INV_RGST_SEQ," ).append("\n"); 
		query.append("        '06'                AS SO_ETT_TP_CD," ).append("\n"); 
		query.append("        T2.LGS_COST_CD, DECODE(LENGTH(T2.LGS_COST_CD), 4, 110911, T3.ACCT_CD)  AS ACCT_CD," ).append("\n"); 
		query.append("        T2.VSL_CD,   T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.REV_DIR_CD, SUBSTR(RLANE_CD, 1, 3) AS SLAN_CD," ).append("\n"); 
		query.append("        SUBSTR(T1.YD_CD,1,5) PORT_CD, T1.YD_CD," ).append("\n"); 
		query.append("        LOCL_AMT            INV_AMT," ).append("\n"); 
		query.append("        T1.ISS_CTY_CD       SO_OFC_CTY_CD," ).append("\n"); 
		query.append("        T1.SO_SEQ," ).append("\n"); 
		query.append("        'N'                 DELT_FLG," ).append("\n"); 
		query.append("        'USERID'            CRE_USR_ID," ).append("\n"); 
		query.append("        SYSDATE             CRE_DT," ).append("\n"); 
		query.append("        'USERID'            UPD_USR_ID," ).append("\n"); 
		query.append("        SYSDATE             UPD_DT," ).append("\n"); 
		query.append("        SUBSTR(T2.DIFF_RMK, 1, 200) AS INV_DESC," ).append("\n"); 
		query.append("        T2.ORG_SO_DTL_SEQ," ).append("\n"); 
		query.append("        T2.N3PTY_BIL_IF_FLG" ).append("\n"); 
		query.append("FROM    PSO_CHARGE T1, PSO_CHG_DTL T2, TES_LGS_COST T3" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     T1.ISS_CTY_CD   = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("AND     T1.SO_SEQ       = T2.SO_SEQ" ).append("\n"); 
		query.append("AND     T2.LGS_COST_CD  = T3.LGS_COST_CD" ).append("\n"); 
		query.append("AND     NOT EXISTS (SELECT 'A' FROM VSK_VSL_SKD WHERE VSL_CD = T2.VSL_CD AND SKD_VOY_NO = T2.SKD_VOY_NO AND SKD_DIR_CD = T2.SKD_DIR_CD)" ).append("\n"); 
		query.append("    #if(${inv_no}!='')" ).append("\n"); 
		query.append("    	AND (T1.ISS_CTY_CD, T1.SO_SEQ) = (SELECT ISS_CTY_CD, SO_SEQ FROM PSO_CHARGE WHERE INV_NO = @[inv_no] AND VNDR_SEQ = @[vndr_seq] )" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    	AND T1.ISS_CTY_CD  = @[iss_cty_cd]" ).append("\n"); 
		query.append("    	AND T1.SO_SEQ      = @[so_seq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 

	}
}