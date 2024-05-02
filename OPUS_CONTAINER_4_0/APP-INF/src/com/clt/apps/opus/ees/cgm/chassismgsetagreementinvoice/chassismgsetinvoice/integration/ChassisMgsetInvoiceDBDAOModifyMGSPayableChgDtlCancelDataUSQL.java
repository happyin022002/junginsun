/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOModifyMGSPayableChgDtlCancelDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.11.10 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM CHANG SIK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOModifyMGSPayableChgDtlCancelDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.ModifyMGSPayableChgDtlCancelData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOModifyMGSPayableChgDtlCancelDataUSQL(){
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
		query.append("FileName : ChassisMgsetInvoiceDBDAOModifyMGSPayableChgDtlCancelDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("PAY_LSE_CHG_STS_CD = LSE_CHG_AUD_STS_CD," ).append("\n"); 
		query.append("PAY_LSE_USE_DYS = INV_LSE_USE_DYS," ).append("\n"); 
		query.append("PAY_LSE_RT_AMT = INV_LSE_RT_AMT," ).append("\n"); 
		query.append("PAY_LSE_CHG_AMT = INV_LSE_CHG_AMT," ).append("\n"); 
		query.append("PAY_CR_AMT = INV_CR_AMT," ).append("\n"); 
		query.append("PAY_TAX_AMT = INV_TAX_AMT," ).append("\n"); 
		query.append("PAY_INV_SEQ = ''," ).append("\n"); 
		query.append("PAY_CHG_AUD_RMK = ''," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND PAY_LSE_CHG_STS_CD = 'C'" ).append("\n"); 
		query.append("AND AGMT_SEQ IN (SELECT AGMT_SEQ FROM CGM_LSE_CHG_HDR" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND CHG_CRE_SEQ = @[chg_cre_seq])" ).append("\n"); 

	}
}