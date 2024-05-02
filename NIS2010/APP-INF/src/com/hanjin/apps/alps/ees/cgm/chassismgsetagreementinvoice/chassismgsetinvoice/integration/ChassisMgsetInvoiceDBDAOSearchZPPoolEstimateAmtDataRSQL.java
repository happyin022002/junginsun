/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchZPPoolEstimateAmtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchZPPoolEstimateAmtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [EES_CGM_1225] NP(ZP) Pool Chassis Estimated Expense Input : Retrieve
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchZPPoolEstimateAmtDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchZPPoolEstimateAmtDataRSQL").append("\n"); 
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
		query.append("SELECT AA.MONTH AS MONTH ," ).append("\n"); 
		query.append("  AA.MONTH_NM AS MONTH_NM ," ).append("\n"); 
		query.append("  BB.ESTM_YRMON AS ESTM_YRMON ," ).append("\n"); 
		query.append("  EE.AGMT_OFC_CTY_CD ," ).append("\n"); 
		query.append("  EE.AGMT_SEQ ," ).append("\n"); 
		query.append("  @[chss_pool_tp_cd] AS CHSS_POOL_TP_CD ," ).append("\n"); 
		query.append("  @[chss_pool_cd] AS CHSS_POOL_CD ," ).append("\n"); 
		query.append("  'USD' AS CURR_CD ," ).append("\n"); 
		query.append("  NVL(BB.ESTM_AMT, 0) AS ESTM_AMT ," ).append("\n"); 
		query.append("  NVL(CC.INV_SMRY_AMT, 0) AS INV_SMRY_AMT ," ).append("\n"); 
		query.append("  BB.ESTM_AMT_FX_FLG AS ESTM_AMT_FX_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT @[year] || LPAD(ROWNUM, 2, '0') MONTH ," ).append("\n"); 
		query.append("      DECODE (ROWNUM, 1, 'Jan', 2, 'Feb', 3, 'Mar', 4, 'Apr', 5, 'MAY', 6, 'Jun' , 7, 'Jul', 8, 'Aug', 9, 'Sep', 10, 'Oct', 11, 'Nov', 12, 'Dec') MONTH_NM" ).append("\n"); 
		query.append("    FROM DUAL A CONNECT BY LEVEL<='12') AA ," ).append("\n"); 
		query.append("   (" ).append("\n"); 
		query.append("    SELECT B.ESTM_YRMON ," ).append("\n"); 
		query.append("      B.AGMT_OFC_CTY_CD ," ).append("\n"); 
		query.append("      B.AGMT_SEQ ," ).append("\n"); 
		query.append("      B.CHSS_POOL_TP_CD ," ).append("\n"); 
		query.append("      B.CHSS_POOL_CD ," ).append("\n"); 
		query.append("      B.CURR_CD ," ).append("\n"); 
		query.append("      NVL(B.ESTM_AMT, 0) ESTM_AMT ," ).append("\n"); 
		query.append("      B.ESTM_AMT_FX_FLG " ).append("\n"); 
		query.append("     FROM CGM_CHSS_POOL_EXPN_ESTM B" ).append("\n"); 
		query.append("    WHERE B.ESTM_YRMON LIKE @[year] || '%'" ).append("\n"); 
		query.append("      AND B.CHSS_POOL_TP_CD = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("      AND B.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("    ) BB," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT A.COST_YRMON, A.AGMT_OFC_CTY_CD, A.AGMT_SEQ, NVL(SUM(B.INV_TTL_AMT), 0) INV_SMRY_AMT " ).append("\n"); 
		query.append("    FROM CGM_PAY_INV A, AP_PAY_INV B, AP_INV_HDR C" ).append("\n"); 
		query.append("    WHERE A.INV_RGST_NO = B.INV_RGST_NO " ).append("\n"); 
		query.append("    AND B.CSR_NO = C.CSR_NO" ).append("\n"); 
		query.append("    AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND A.CHSS_MGST_INV_KND_CD = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("    AND A.COST_YRMON LIKE @[year] || '%'" ).append("\n"); 
		query.append("    AND A.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("    AND B.INV_STS_CD IN ('D','P')" ).append("\n"); 
		query.append("    GROUP BY  A.COST_YRMON,A.AGMT_OFC_CTY_CD, A.AGMT_SEQ " ).append("\n"); 
		query.append("    ) CC" ).append("\n"); 
		query.append("    ," ).append("\n"); 
		query.append("    (SELECT AGMT_OFC_CTY_CD, AGMT_SEQ FROM CGM_AGREEMENT" ).append("\n"); 
		query.append("    WHERE CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("    AND AGMT_LSTM_CD = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("    AND ROWNUM=1" ).append("\n"); 
		query.append("    ) EE" ).append("\n"); 
		query.append("WHERE AA.MONTH = BB.ESTM_YRMON (+)" ).append("\n"); 
		query.append("AND AA.MONTH = CC.COST_YRMON(+)" ).append("\n"); 
		query.append("ORDER BY AA.MONTH" ).append("\n"); 

	}
}