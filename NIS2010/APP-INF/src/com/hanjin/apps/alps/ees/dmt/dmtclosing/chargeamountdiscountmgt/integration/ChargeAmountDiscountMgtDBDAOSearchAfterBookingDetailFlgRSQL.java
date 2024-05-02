/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingDetailFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingDetailFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingDetailFlg
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingDetailFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apvl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingDetailFlgRSQL").append("\n"); 
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
		query.append("     NVL((" ).append("\n"); 
		query.append("        SELECT 'Y'" ).append("\n"); 
		query.append("        FROM DMT_AFT_BKG_ACT_COST_RQST" ).append("\n"); 
		query.append("        WHERE AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("        AND AFT_BKG_ACT_COST_ITM_LVL = '8'" ).append("\n"); 
		query.append("        AND TRIM(AFT_BKG_ACT_COST_RMK) IS NOT NULL" ).append("\n"); 
		query.append("     ),'N') AS RSN_DC_FLG" ).append("\n"); 
		query.append("   , NVL((" ).append("\n"); 
		query.append("        SELECT 'Y'" ).append("\n"); 
		query.append("        FROM DMT_AFT_BKG_ACT_COST_RQST" ).append("\n"); 
		query.append("        WHERE AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("        AND AFT_BKG_ACT_COST_ITM_LVL = '9'" ).append("\n"); 
		query.append("        AND TRIM(AFT_BKG_ACT_COST_RMK) IS NOT NULL" ).append("\n"); 
		query.append("     ),'N') AS RSN_CLE_FLG" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("          FROM DMT_AFT_BKG_FILE_RQST A" ).append("\n"); 
		query.append("         WHERE A.AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("           AND AFT_BKG_FILE_DIV_CD = 'CSRL01'" ).append("\n"); 
		query.append("    ),'N') AS CUST_RQST_FLG" ).append("\n"); 
		query.append("   , NVL((" ).append("\n"); 
		query.append("        SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("        FROM DMT_AFT_BKG_ACT_COST_RQST A, DMT_HRD_CDG_CTNT B" ).append("\n"); 
		query.append("        WHERE A.AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("        AND B.HRD_CDG_ID LIKE 'AFT_BKG_ACTUAL_COST'" ).append("\n"); 
		query.append("        AND B.ATTR_CTNT1 = A.AFT_BKG_ACT_COST_ITM_NM" ).append("\n"); 
		query.append("		AND A.AFT_BKG_ACT_COST_AMT != 0" ).append("\n"); 
		query.append("		AND TRIM(A.AFT_BKG_ACT_COST_RMK) IS NOT NULL" ).append("\n"); 
		query.append("    ),'N') AS ACT_COST_FLG" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("          FROM DMT_AFT_BKG_FILE_RQST A" ).append("\n"); 
		query.append("         WHERE A.AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("           AND AFT_BKG_FILE_DIV_CD = 'OAIN01'" ).append("\n"); 
		query.append("    ),'N') AS OTH_ATT_FLG" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("          FROM DMT_AFT_BKG_FILE_RQST A" ).append("\n"); 
		query.append("         WHERE A.AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("           AND AFT_BKG_FILE_DIV_CD = 'CIOD01'" ).append("\n"); 
		query.append("    ),'N') AS CGO_INV_OLD_FLG" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("          FROM DMT_AFT_BKG_FILE_RQST A" ).append("\n"); 
		query.append("         WHERE A.AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("           AND AFT_BKG_FILE_DIV_CD = 'CINW01'" ).append("\n"); 
		query.append("    ),'N') AS CGO_INV_NEW_FLG" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        SELECT MIN( CASE WHEN A.CGOR_DT IS NULL OR A.MCNTR_RTN_DT IS NULL THEN 'N' ELSE 'Y' END )" ).append("\n"); 
		query.append("          FROM DMT_AFT_BKG_EXPT_CLR_RQST A" ).append("\n"); 
		query.append("         WHERE A.AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("    ),'N') AS EXP_CLE_FLG" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("          FROM DMT_AFT_BKG_MAS_RQST A" ).append("\n"); 
		query.append("         WHERE A.AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("    ),'N') AS CUST_SAL_PFMC_FLG" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        SELECT AFT_BKG_FILE_DIV_CD FROM DMT_AFT_BKG_RSN_RMK_RQST" ).append("\n"); 
		query.append("         WHERE AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("           AND AFT_BKG_RMK_LVL = '0'" ).append("\n"); 
		query.append("    ),'') AS RSN_CD" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        SELECT B.ATTR_CTNT2||' ( '||ATTR_CTNT4||' )' " ).append("\n"); 
		query.append("        FROM DMT_AFT_BKG_RSN_RMK_RQST A,DMT_HRD_CDG_CTNT B" ).append("\n"); 
		query.append("        WHERE B.HRD_CDG_ID = 'AFT_BKG_RSN_CD'" ).append("\n"); 
		query.append("        AND A.AFT_BKG_FILE_DIV_CD = B.ATTR_CTNT3" ).append("\n"); 
		query.append("        AND AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("    ),'') AS RSN_DESC" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("          FROM DMT_AFT_BKG_FILE_RQST A" ).append("\n"); 
		query.append("         WHERE A.AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("           AND AFT_BKG_FILE_DIV_CD IN( SELECT ATTR_CTNT3 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'AFT_BKG_RSN_CD' )" ).append("\n"); 
		query.append("    ),'N') AS ATT_FILE_FLG" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("          FROM DMT_AFT_BKG_RSN_RMK_RQST A" ).append("\n"); 
		query.append("         WHERE A.AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("           AND AFT_BKG_FILE_DIV_CD IN( SELECT ATTR_CTNT3 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'AFT_BKG_RSN_CD' )" ).append("\n"); 
		query.append("           AND AFT_BKG_RMK_LVL > '0'" ).append("\n"); 
		query.append("    ),'N') AS RSN_DTL_RMK_FLG" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("          FROM DMT_AFT_BKG_PERF_RQST A" ).append("\n"); 
		query.append("         WHERE A.AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("    ),'N') AS DMT_PFMC_FLG" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("          FROM DMT_AFT_BKG_FULL_HIS_RQST A" ).append("\n"); 
		query.append("         WHERE A.AFT_EXPT_DAR_NO = T.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("    ),'N') AS FULL_HIS_FLG" ).append("\n"); 
		query.append("    , CASE WHEN NVL(T.UC_CGO_PSBL_FLG,' ') = ' ' THEN 'N' ELSE 'Y' END AS HIGH_LOW_FLG" ).append("\n"); 
		query.append("    , NVL((" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT 'Y'" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("				FROM    DMT_AFT_BKG_FILE_RQST FL" ).append("\n"); 
		query.append("				    ,   COM_UPLD_FILE T2" ).append("\n"); 
		query.append("				    ,   DMT_AFT_BKG_ADJ_RQST ADJ_RQST" ).append("\n"); 
		query.append("					,   DMT_AFT_BKG_ADJ_RQST_DTL ADJ_RQST_DTL" ).append("\n"); 
		query.append("					,   BKG_BOOKING BB" ).append("\n"); 
		query.append("					,   PRI_RP_HDR RP_HDR" ).append("\n"); 
		query.append("					,   PRI_RP_MN RP_MN" ).append("\n"); 
		query.append("					,   PRI_SP_HDR SP_HDR" ).append("\n"); 
		query.append("					,   PRI_SP_CTRT_PTY SP_PTY" ).append("\n"); 
		query.append("					,   PRI_TAA_HDR TAA_HDR" ).append("\n"); 
		query.append("					,   PRI_TAA_MN TAA_MN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("					AND ADJ_RQST.DMDT_EXPT_RQST_STS_CD = 'A'" ).append("\n"); 
		query.append("				    AND FL.AFT_BKG_FILE_DIV_CD = 'LETT01'" ).append("\n"); 
		query.append("                    AND FL.FILE_SAV_ID          = T2.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("                    AND T2.DELT_FLG(+)             = 'N'" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("				    AND FL.AFT_EXPT_DAR_NO = ADJ_RQST.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("					AND ADJ_RQST.AFT_EXPT_DAR_NO = ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("					AND ADJ_RQST_DTL.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND BB.RFA_NO = RP_HDR.RFA_NO(+)" ).append("\n"); 
		query.append("					AND RP_HDR.PROP_NO = RP_MN.PROP_NO(+)" ).append("\n"); 
		query.append("					AND	(" ).append("\n"); 
		query.append("							RP_MN.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("							OR" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								RP_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT 	/*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("									FROM	PRI_RP_MN" ).append("\n"); 
		query.append("									WHERE	PROP_NO = RP_MN.PROP_NO" ).append("\n"); 
		query.append("										AND	ROWNUM = 1" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					AND BB.SC_NO = SP_HDR.SC_NO(+)" ).append("\n"); 
		query.append("					AND SP_HDR.PROP_NO = SP_PTY.PROP_NO(+)" ).append("\n"); 
		query.append("					AND (" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SP_PTY.PRC_CTRT_PTY_TP_CD IS NULL AND SP_PTY.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("							OR " ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SP_PTY.PRC_CTRT_PTY_TP_CD = 'C' " ).append("\n"); 
		query.append("								AND " ).append("\n"); 
		query.append("								SP_PTY.AMDT_SEQ = " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT	/*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */AMDT_SEQ " ).append("\n"); 
		query.append("									FROM	PRI_SP_CTRT_PTY " ).append("\n"); 
		query.append("									WHERE 	PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("										AND	PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("										AND	ROWNUM = 1" ).append("\n"); 
		query.append("								)				" ).append("\n"); 
		query.append("							)  " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND TAA_HDR.TAA_NO(+) = BB.TAA_NO" ).append("\n"); 
		query.append("					AND TAA_HDR.TAA_PROP_NO = TAA_MN.TAA_PROP_NO(+)" ).append("\n"); 
		query.append("					AND	(" ).append("\n"); 
		query.append("							TAA_MN.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("							OR" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								TAA_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT 	/*+ INDEX_DESC(PRI_TAA_MN XFK1PRI_TAA_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("									FROM	PRI_TAA_MN" ).append("\n"); 
		query.append("									WHERE	TAA_PROP_NO = TAA_MN.TAA_PROP_NO" ).append("\n"); 
		query.append("										AND	ROWNUM = 1" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND ( RP_MN.CTRT_CUST_CNT_CD || LPAD(RP_MN.CTRT_CUST_SEQ, 6, '0') = @[cust_cd]" ).append("\n"); 
		query.append("                       OR SP_PTY.CUST_CNT_CD || LPAD(SP_PTY.CUST_SEQ, 6, '0') = @[cust_cd]" ).append("\n"); 
		query.append("                       OR TAA_MN.CTRT_CUST_CNT_CD || LPAD(TAA_MN.CTRT_CUST_SEQ, 6, '0') = @[cust_cd]" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				AND ROWNUM = 1" ).append("\n"); 
		query.append("    ),'N') AS GNTE_LTR_FLG" ).append("\n"); 
		query.append("FROM DMT_AFT_BKG_ADJ_RQST T" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("#if(${dar_no} != '')" ).append("\n"); 
		query.append("		T.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("		T.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}