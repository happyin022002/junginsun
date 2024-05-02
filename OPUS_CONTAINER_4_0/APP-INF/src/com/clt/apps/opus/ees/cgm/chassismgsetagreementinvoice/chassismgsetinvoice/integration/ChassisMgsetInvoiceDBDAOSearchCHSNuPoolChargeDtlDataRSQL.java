/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSNuPoolChargeDtlDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.10.07 김창식
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

public class ChassisMgsetInvoiceDBDAOSearchCHSNuPoolChargeDtlDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchCHSNuPoolChargeDtlData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSNuPoolChargeDtlDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSNuPoolChargeDtlDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("T1.INTG_CD_VAL_DP_DESC," ).append("\n"); 
		query.append("T1.DTL_POOL_COST_ITM_CD," ).append("\n"); 
		query.append("T2.PAY_INV_SEQ," ).append("\n"); 
		query.append("T2.COST_CHSS_QTY," ).append("\n"); 
		query.append("T2.COST_BIL_DYS," ).append("\n"); 
		query.append("NVL(T2.COST_AMT,0) AS COST_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  A.INTG_CD_VAL_DP_DESC," ).append("\n"); 
		query.append("A.INTG_CD_VAL_CTNT AS DTL_POOL_COST_ITM_CD" ).append("\n"); 
		query.append("FROM  COM_INTG_CD_DTL A" ).append("\n"); 
		query.append("WHERE A.INTG_CD_ID = 'CD01934'" ).append("\n"); 
		query.append("AND A.INTG_CD_VAL_CTNT LIKE 'N%'" ).append("\n"); 
		query.append("ORDER BY A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(") T1," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.PAY_INV_SEQ," ).append("\n"); 
		query.append("A.DTL_POOL_COST_ITM_CD," ).append("\n"); 
		query.append("A.COST_CHSS_QTY," ).append("\n"); 
		query.append("A.COST_BIL_DYS," ).append("\n"); 
		query.append("NVL(A.COST_AMT,0) AS COST_AMT" ).append("\n"); 
		query.append("FROM CGM_PAY_INV_POOL_DTL A" ).append("\n"); 
		query.append("WHERE PAY_INV_SEQ = (SELECT PAY_INV_SEQ FROM CGM_PAY_INV" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND CHSS_MGST_INV_KND_CD = 'NP'" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(") T2" ).append("\n"); 
		query.append("WHERE T1.DTL_POOL_COST_ITM_CD = T2.DTL_POOL_COST_ITM_CD(+)" ).append("\n"); 

	}
}