/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalCollectionInquiryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalCollectionInquiryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DisposalMgtDBDAOsearchDisposalCollectionInquiryListDataRSQL
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalCollectionInquiryListDataRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalCollectionInquiryListDataRSQL").append("\n"); 
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
		query.append("	BOD.OFC_CD " ).append("\n"); 
		query.append("	,BOD.BL_CURR_CD" ).append("\n"); 
		query.append("	,BOD.INV_FRT_AMT" ).append("\n"); 
		query.append("	,BOD.INV_TAX_AMT" ).append("\n"); 
		query.append("	,BOD.CLT_FRT_AMT" ).append("\n"); 
		query.append("	,BOD.CLT_TAX_AMT" ).append("\n"); 
		query.append("	,BOD.BAL_FRT_AMT" ).append("\n"); 
		query.append("	,BOD.BAL_TAX_AMT  " ).append("\n"); 
		query.append("	,TO_CHAR(BOD.CLT_LST_UPD_DT, 'yyyy-mm-dd') AS CLT_LST_UPD_DT " ).append("\n"); 
		query.append("	,E.DP_PRCS_KNT " ).append("\n"); 
		query.append("FROM (SELECT BL_NO," ).append("\n"); 
		query.append("       MAX(OTS_OFC_CD) OFC_CD," ).append("\n"); 
		query.append("       MAX(BL_CURR_CD) BL_CURR_CD," ).append("\n"); 
		query.append("       SUM(INV_AMT) INV_FRT_AMT," ).append("\n"); 
		query.append("       SUM(INV_TAX_AMT) INV_TAX_AMT," ).append("\n"); 
		query.append("       SUM(CLT_AMT) CLT_FRT_AMT," ).append("\n"); 
		query.append("       SUM(CLT_TAX_AMT) CLT_TAX_AMT," ).append("\n"); 
		query.append("       SUM(BAL_AMT) BAL_FRT_AMT," ).append("\n"); 
		query.append("       SUM(BAL_TAX_AMT) BAL_TAX_AMT," ).append("\n"); 
		query.append("       MAX(RCT_UPD_DT) CLT_LST_UPD_DT" ).append("\n"); 
		query.append("  FROM (SELECT BL_NO," ).append("\n"); 
		query.append("               OTS_OFC_CD," ).append("\n"); 
		query.append("               BL_CURR_CD," ).append("\n"); 
		query.append("               RCT_UPD_DT," ).append("\n"); 
		query.append("               CASE WHEN CHG_TP_CD <> 'TVA' THEN INV_AMT ELSE 0 END INV_AMT," ).append("\n"); 
		query.append("               CASE WHEN CHG_TP_CD = 'TVA' THEN INV_AMT ELSE 0 END INV_TAX_AMT," ).append("\n"); 
		query.append("               CASE WHEN CHG_TP_CD <> 'TVA' THEN RCT_AMT ELSE 0 END CLT_AMT," ).append("\n"); 
		query.append("               CASE WHEN CHG_TP_CD = 'TVA' THEN RCT_AMT ELSE 0 END CLT_TAX_AMT," ).append("\n"); 
		query.append("               CASE WHEN CHG_TP_CD <> 'TVA' THEN BAL_AMT ELSE 0 END BAL_AMT," ).append("\n"); 
		query.append("               CASE WHEN CHG_TP_CD = 'TVA' THEN BAL_AMT ELSE 0 END BAL_TAX_AMT" ).append("\n"); 
		query.append("          FROM SAR_OTS_DTL)" ).append("\n"); 
		query.append("      GROUP BY BL_NO) BOD, MDM_CURRENCY E" ).append("\n"); 
		query.append("WHERE BOD.BL_NO = @[inv_no]" ).append("\n"); 
		query.append("AND BOD.BL_CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("ORDER BY CLT_LST_UPD_DT" ).append("\n"); 

	}
}