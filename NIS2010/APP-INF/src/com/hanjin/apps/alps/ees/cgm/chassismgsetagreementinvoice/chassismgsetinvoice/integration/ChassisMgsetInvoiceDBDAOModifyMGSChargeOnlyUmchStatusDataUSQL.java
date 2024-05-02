/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOModifyMGSChargeOnlyUmchStatusDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.01.08 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOModifyMGSChargeOnlyUmchStatusDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.ModifyMGSChargeOnlyUmchStatusData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOModifyMGSChargeOnlyUmchStatusDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : ChassisMgsetInvoiceDBDAOModifyMGSChargeOnlyUmchStatusDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_LSE_CHG_DTL B" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("(AUD_UMCH_EQ_STS_EVNT_YD_CD," ).append("\n"); 
		query.append("AUD_UMCH_EQ_ASET_STS_CD," ).append("\n"); 
		query.append("AUD_UMCH_EQ_STS_EVNT_DT) =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.STS_EVNT_YD_CD," ).append("\n"); 
		query.append("A.EQ_ASET_STS_CD," ).append("\n"); 
		query.append("A.STS_EVNT_DT" ).append("\n"); 
		query.append("FROM  CGM_EQUIPMENT Q, CGM_EQ_STS_HIS A" ).append("\n"); 
		query.append("WHERE  Q.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("AND Q.EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append("AND Q.EQ_STS_SEQ = A.EQ_STS_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("LSE_CHG_AUD_STS_CD IN ('H','I')" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND (AGMT_OFC_CTY_CD, AGMT_SEQ ,COST_YRMON) IN (" ).append("\n"); 
		query.append("SELECT AGMT_OFC_CTY_CD, AGMT_SEQ ,COST_YRMON" ).append("\n"); 
		query.append("FROM CGM_LSE_CHG_HDR" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}