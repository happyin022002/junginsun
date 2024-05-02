/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOModifyMGSPayableChgHdrCancelDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.29 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOModifyMGSPayableChgHdrCancelDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.ModifyMGSPayableChgHdrCancelData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOModifyMGSPayableChgHdrCancelDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOModifyMGSPayableChgHdrCancelDataUSQL").append("\n"); 
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
		query.append("(INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT, LSE_CHG_STS_CD, UPD_USR_ID, UPD_DT) =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("INV_SMRY_AMT," ).append("\n"); 
		query.append("CR_SMRY_AMT," ).append("\n"); 
		query.append("TAX_SMRY_AMT," ).append("\n"); 
		query.append("'A'," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("A.COST_YRMON," ).append("\n"); 
		query.append("MAX(A.EQ_KND_cD) EQ_KND_CD," ).append("\n"); 
		query.append("NVL(SUM(B.INV_LSE_CHG_AMT),0) + NVL(SUM(B.INV_TAX_AMT),0) - ABS(NVL(SUM(B.INV_CR_AMT),0)) AS INV_SMRY_AMT," ).append("\n"); 
		query.append("NVL(SUM(B.INV_CR_AMT),0)  AS CR_SMRY_AMT," ).append("\n"); 
		query.append("NVL(SUM(B.INV_TAX_AMT),0)  AS TAX_SMRY_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_LSE_CHG_HDR A, CGM_LSE_CHG_DTL B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD (+)" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ (+)" ).append("\n"); 
		query.append("AND A.COST_YRMON = B.COST_YRMON (+)" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND A.CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("GROUP BY A.AGMT_OFC_CTY_CD, A.AGMT_SEQ, A.COST_YRMON" ).append("\n"); 
		query.append(") T2" ).append("\n"); 
		query.append("WHERE T2.AGMT_OFC_CTY_CD = T.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND T2.AGMT_SEQ = T.AGMT_SEQ" ).append("\n"); 
		query.append("AND T2.COST_YRMON = T.COST_YRMON" ).append("\n"); 
		query.append("AND T2.EQ_KND_CD = T.EQ_KND_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 

	}
}