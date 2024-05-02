/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchPoolEstimateAmtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.03
*@LastModifier : 이용태
*@LastVersion : 1.0
* 2010.06.03 이용태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YONG-TAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchPoolEstimateAmtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchPoolEstimateAmtDataRSQL(){
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
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchPoolEstimateAmtDataRSQL").append("\n"); 
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
		query.append("SELECT AA.MONTH MONTH ," ).append("\n"); 
		query.append("  AA.MONTH_NM MONTH_NM ," ).append("\n"); 
		query.append("  BB.ESTM_YRMON ESTM_YRMON ," ).append("\n"); 
		query.append("#if( ${chss_pool_tp_cd} == 'CP')   " ).append("\n"); 
		query.append("  DD.AGMT_OFC_CTY_CD ," ).append("\n"); 
		query.append("  DD.AGMT_SEQ ," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  @[agmt_ofc_cty_cd] AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("  @[agmt_seq] AGMT_SEQ," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  BB.CHSS_POOL_TP_CD CHSS_POOL_TP_CD ," ).append("\n"); 
		query.append("  BB.CHSS_POOL_CD CHSS_POOL_CD ," ).append("\n"); 
		query.append("  BB.CURR_CD CURR_CD ," ).append("\n"); 
		query.append("  NVL(BB.ESTM_AMT, 0) ESTM_AMT ," ).append("\n"); 
		query.append("  NVL(CC.INV_SMRY_AMT, 0) INV_SMRY_AMT ," ).append("\n"); 
		query.append("  DECODE(BB.ESTM_AMT_FX_FLG, 'Y', 1, 0) ESTM_AMT_FX_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT @[year] || LPAD(ROWNUM, 2, '0') MONTH ," ).append("\n"); 
		query.append("      DECODE (ROWNUM, 1, 'Jan', 2, 'Feb', 3, 'Mar', 4, 'Apr', 5, 'MAY', 6, 'Jun' , 7, 'Jul', 8, 'Aug', 9, 'Sep', 10, 'Oct', 11, 'Nov', 12, 'Dec') MONTH_NM" ).append("\n"); 
		query.append("    FROM DUAL A CONNECT BY LEVEL<='12') AA ," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT B.ESTM_YRMON ," ).append("\n"); 
		query.append("      B.AGMT_OFC_CTY_CD ," ).append("\n"); 
		query.append("      B.AGMT_SEQ ," ).append("\n"); 
		query.append("      B.CHSS_POOL_TP_CD ," ).append("\n"); 
		query.append("      B.CHSS_POOL_CD ," ).append("\n"); 
		query.append("      B.CURR_CD ," ).append("\n"); 
		query.append("      NVL(B.ESTM_AMT, 0) ESTM_AMT ," ).append("\n"); 
		query.append("      B.ESTM_AMT_FX_FLG " ).append("\n"); 
		query.append("    FROM CGM_CHSS_POOL_EXPN_ESTM B" ).append("\n"); 
		query.append("    WHERE" ).append("\n"); 
		query.append("      B.ESTM_YRMON LIKE @[year] || '%'" ).append("\n"); 
		query.append("      AND B.CHSS_POOL_TP_CD = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("#if( ${chss_pool_tp_cd} == 'CP') " ).append("\n"); 
		query.append("      AND B.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("     AND  B.AGMT_OFC_CTY_CD =  @[agmt_ofc_cty_cd]  " ).append("\n"); 
		query.append("     AND  B.AGMT_SEQ        = @[agmt_seq]  " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    ) BB," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT A.COST_YRMON, A.AGMT_OFC_CTY_CD, A.AGMT_SEQ, NVL(SUM(B.INV_TTL_AMT), 0) INV_SMRY_AMT " ).append("\n"); 
		query.append("    FROM CGM_PAY_INV A, AP_PAY_INV B, AP_INV_HDR C" ).append("\n"); 
		query.append("    WHERE A.INV_RGST_NO = B.INV_RGST_NO " ).append("\n"); 
		query.append("	AND B.CSR_NO = C.CSR_NO" ).append("\n"); 
		query.append("    AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND A.CHSS_MGST_INV_KND_CD = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("#if( ${chss_pool_tp_cd} == 'CP')  " ).append("\n"); 
		query.append("    AND A.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]  " ).append("\n"); 
		query.append("    AND A.AGMT_SEQ        = @[agmt_seq] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND B.INV_STS_CD IN ('D','P')" ).append("\n"); 
		query.append("    GROUP BY  A.COST_YRMON,A.AGMT_OFC_CTY_CD, A.AGMT_SEQ " ).append("\n"); 
		query.append("    ) CC" ).append("\n"); 
		query.append("#if( ${chss_pool_tp_cd} == 'CP') " ).append("\n"); 
		query.append("    ," ).append("\n"); 
		query.append("    (SELECT AGMT_OFC_CTY_CD, AGMT_SEQ FROM CGM_AGREEMENT" ).append("\n"); 
		query.append("    WHERE CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("    AND ROWNUM=1" ).append("\n"); 
		query.append("    ) DD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE AA.MONTH = BB.ESTM_YRMON (+)" ).append("\n"); 
		query.append("AND AA.MONTH = CC.COST_YRMON(+)" ).append("\n"); 
		query.append("ORDER BY AA.MONTH" ).append("\n"); 

	}
}