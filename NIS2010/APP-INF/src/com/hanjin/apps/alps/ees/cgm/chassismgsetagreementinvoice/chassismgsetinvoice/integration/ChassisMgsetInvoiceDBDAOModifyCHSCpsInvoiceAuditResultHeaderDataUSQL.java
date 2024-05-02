/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOModifyCHSCpsInvoiceAuditResultHeaderDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.14 
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

public class ChassisMgsetInvoiceDBDAOModifyCHSCpsInvoiceAuditResultHeaderDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chang-Young Kim, 20150714 [SRM-201555658, CHM-201536892]
	  *  - DTL의 합산 금액을 잘못계산하여 HDR에 업데이트 하는 오류를 수정
	  *  - HDR와 DTL의 금액이 다를 시 Invoice Confirm시 CSR 모듈에서 에러 남
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOModifyCHSCpsInvoiceAuditResultHeaderDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("parent_cost_yrmon_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOModifyCHSCpsInvoiceAuditResultHeaderDataUSQL").append("\n"); 
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
		query.append("UPDATE  CGM_LSE_CHG_HDR T" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	(LSE_CHG_SMRY_AMT, INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT, LSE_CHG_STS_CD, UPD_USR_ID, UPD_DT) =" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	   SELECT" ).append("\n"); 
		query.append("		   PAY_LSE_CHG_AMT," ).append("\n"); 
		query.append("		   PAY_LSE_CHG_AMT + PAY_TAX_AMT - ABS(PAY_CR_AMT)," ).append("\n"); 
		query.append("	       PAY_CR_AMT," ).append("\n"); 
		query.append("	       PAY_TAX_AMT," ).append("\n"); 
		query.append("	       'S'," ).append("\n"); 
		query.append("	       @[upd_usr_id]," ).append("\n"); 
		query.append("	       SYSDATE" ).append("\n"); 
		query.append("	   FROM " ).append("\n"); 
		query.append("	       (" ).append("\n"); 
		query.append("        	   SELECT " ).append("\n"); 
		query.append("        	       A.AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("        	       A.AGMT_SEQ," ).append("\n"); 
		query.append("        	       NVL(SUM(PAY_LSE_CHG_AMT),0) AS PAY_LSE_CHG_AMT," ).append("\n"); 
		query.append("        	       NVL(SUM(PAY_CR_AMT),0) PAY_CR_AMT," ).append("\n"); 
		query.append("                   NVL(SUM(PAY_TAX_AMT),0) PAY_TAX_AMT" ).append("\n"); 
		query.append("        	   FROM " ).append("\n"); 
		query.append("        	       CGM_LSE_CHG_HDR A, CGM_LSE_CHG_DTL B" ).append("\n"); 
		query.append("        	   WHERE " ).append("\n"); 
		query.append("        	       A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("        	       AND A.AGMT_SEQ = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("        	       AND A.COST_YRMON = B.COST_YRMON(+)" ).append("\n"); 
		query.append("        	       AND A.COST_YRMON_SEQ = B.COST_YRMON_SEQ(+) -- ADD Chang-Young Kim, 20150714 [SRM-201555658, CHM-201536892]" ).append("\n"); 
		query.append("        	       AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("        	       AND A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("                   AND A.COST_YRMON_SEQ = @[parent_cost_yrmon_seq] -- ADD YONGCHAN SHIN, 20140324" ).append("\n"); 
		query.append("        	       AND A.CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("				   AND B.PAY_LSE_CHG_STS_CD (+)= 'C'" ).append("\n"); 
		query.append("               GROUP BY A.AGMT_OFC_CTY_CD, A.AGMT_SEQ" ).append("\n"); 
		query.append("          ) T2" ).append("\n"); 
		query.append("        WHERE T2.AGMT_OFC_CTY_CD = T.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("              AND T2.AGMT_SEQ = T.AGMT_SEQ     " ).append("\n"); 
		query.append("	 )" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("    AND COST_YRMON_SEQ = @[parent_cost_yrmon_seq] -- ADD YONGCHAN SHIN, 20140324" ).append("\n"); 
		query.append("	AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("	AND CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("	AND EXISTS (" ).append("\n"); 
		query.append("	       SELECT 1" ).append("\n"); 
		query.append("	       FROM (" ).append("\n"); 
		query.append("	               SELECT " ).append("\n"); 
		query.append("            	       A.AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("            	       A.AGMT_SEQ" ).append("\n"); 
		query.append("            	   FROM " ).append("\n"); 
		query.append("            	       CGM_LSE_CHG_HDR A, CGM_LSE_CHG_DTL B" ).append("\n"); 
		query.append("            	   WHERE " ).append("\n"); 
		query.append("            	       A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("            	       AND A.AGMT_SEQ = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("            	       AND A.COST_YRMON = B.COST_YRMON(+)" ).append("\n"); 
		query.append("            	       AND A.COST_YRMON_SEQ = B.COST_YRMON_SEQ(+) -- ADD Chang-Young Kim, 20150714 [SRM-201555658, CHM-201536892]" ).append("\n"); 
		query.append("            	       AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("            	       AND A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("                       AND A.COST_YRMON_SEQ = @[parent_cost_yrmon_seq] -- ADD YONGCHAN SHIN, 20140324" ).append("\n"); 
		query.append("            	       AND A.CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("					   AND B.PAY_LSE_CHG_STS_CD (+) = 'C'" ).append("\n"); 
		query.append("                   GROUP BY A.AGMT_OFC_CTY_CD, A.AGMT_SEQ" ).append("\n"); 
		query.append("	            ) T3" ).append("\n"); 
		query.append("	       WHERE T3.AGMT_OFC_CTY_CD = T.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                 AND T3.AGMT_SEQ = T.AGMT_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}