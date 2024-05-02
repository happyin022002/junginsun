/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchInvoiceEdiCntrChgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchInvoiceEdiCntrChgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOSearchInvoiceEdiCntrChgInfo
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchInvoiceEdiCntrChgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchInvoiceEdiCntrChgInfoRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_CHARGE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CHARGE_CD:'   || CHG_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CHARGE_DESC:'    ||(SELECT CHG_NM FROM MDM_CHARGE WHERE CHG_CD = BC.CHG_CD) || CHR(10) " ).append("\n"); 
		query.append("       || 'CHARGE_TP_NM:' || (SELECT REP_CHG_NM FROM MDM_CHARGE MC, MDM_REP_CHG MR WHERE MC.CHG_CD = BC.CHG_CD AND MC.REP_CHG_CD = MR.REP_CHG_CD) || CHR(10) " ).append("\n"); 
		query.append("       || 'CHARGE_CURR:' || CURR_CD || CHR(10) " ).append("\n"); 
		query.append("	   || 'CHARGE_AMT:' || CHG_AMT || CHR(10) " ).append("\n"); 
		query.append("	   || 'CHARGE_AMT_USD:' || '100' || CHR(10) " ).append("\n"); 
		query.append("	   || 'INV_CURR:' || 'USD' || CHR(10) " ).append("\n"); 
		query.append("	   || 'INV_CURR_AMT:' || '100' || CHR(10) " ).append("\n"); 
		query.append("	   || 'INV_TAX:' || '0.00' || CHR(10) " ).append("\n"); 
		query.append("	   || 'INV_CURR_TTL_AMT:' ||'100'|| CHR(10) " ).append("\n"); 
		query.append("	   || 'LOCAL_CURR:' || 'USD'||CHR(10) " ).append("\n"); 
		query.append("	   || 'LOCAL_CURR_AMT:' ||'100'|| CHR(10) " ).append("\n"); 
		query.append("	   || 'LOCAL_TAX:' || '0.00'||CHR(10) " ).append("\n"); 
		query.append("	   || 'LOCAL_CURR_TTL_AMT:' ||'100'|| CHR(10) " ).append("\n"); 
		query.append("	   || 'FRT_IND:' || FRT_TERM_CD || CHR(10) " ).append("\n"); 
		query.append("	   || 'RATED_AS:' || RAT_AS_QTY ||CHR(10) " ).append("\n"); 
		query.append("	   || 'RATE:' || CHG_UT_AMT ||CHR(10) " ).append("\n"); 
		query.append("	   || 'INV_EX_RATE:' ||'0.99'|| CHR(10) " ).append("\n"); 
		query.append("	   || 'TAX_RATE:' ||'0.99'|| CHR(10) " ).append("\n"); 
		query.append("	   || 'PERTYPE:' || RAT_UT_CD ||CHR(10) " ).append("\n"); 
		query.append("	   || 'TARIFF:' || CASE WHEN RFA_NO NOT LIKE 'DUM%' THEN RFA_NO" ).append("\n"); 
		query.append("	                        WHEN TAA_NO NOT LIKE 'DUM%' THEN TAA_NO" ).append("\n"); 
		query.append("	                        WHEN SC_NO  NOT LIKE 'DUM%' THEN SC_NO" ).append("\n"); 
		query.append("	                   ELSE ''" ).append("\n"); 
		query.append("	                   END" ).append("\n"); 
		query.append("	   || CHR(10) " ).append("\n"); 
		query.append("	   || '}CNTR_CHARGE_INFO' || CHR(10) AS BKG_CNTR" ).append("\n"); 
		query.append(",      BC.CNTR_NO" ).append("\n"); 
		query.append("FROM   BKG_CNTR_RT BC, BKG_BOOKING BK" ).append("\n"); 
		query.append(" WHERE BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND BC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append(" ORDER BY BC.CNTR_NO" ).append("\n"); 

	}
}