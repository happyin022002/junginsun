/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchInvoiceEdiChgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09 
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

public class BLIssuanceDBDAOSearchInvoiceEdiChgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOSearchInvoiceEdiChgInfoRSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchInvoiceEdiChgInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchInvoiceEdiChgInfoRSQL").append("\n"); 
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
		query.append("SELECT '{BL_CHARGE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_CHARGE_CD:' || CHG_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_CHARGE_DESC:' ||(SELECT CHG_NM FROM MDM_CHARGE WHERE CHG_CD = BC.CHG_CD)|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_CHARGE_TP_NM:' || (SELECT REP_CHG_NM FROM MDM_CHARGE MC, MDM_REP_CHG MR WHERE MC.CHG_CD = BC.CHG_CD AND MC.REP_CHG_CD = MR.REP_CHG_CD) || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_CHARGE_CURR:' ||CURR_CD|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_CHARGE_AMT:' ||CHG_AMT ||CHR(10) " ).append("\n"); 
		query.append("       || 'BL_CHARGE_AMT_USD:' || '' ||CHR(10) " ).append("\n"); 
		query.append("       || 'BL_INV_CURR:' || '' || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_INV_CURR_AMT:' || '' ||CHR(10) " ).append("\n"); 
		query.append("       || 'BL_INV_TAX:' ||''|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_INV_CURR_TTL_AMT:' || '' ||CHR(10) " ).append("\n"); 
		query.append("       || 'BL_LOCAL_CURR:' ||'USD'|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_LOCAL_CURR_AMT:' || '' ||CHR(10) " ).append("\n"); 
		query.append("       || 'BL_LOCAL_TAX:' ||''|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_LOCAL_CURR_TTL_AMT:' || '' ||CHR(10) " ).append("\n"); 
		query.append("       || 'BL_FRT_IND:' ||FRT_TERM_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_RATED_AS:' ||RAT_AS_QTY || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_RATE:' ||CHG_UT_AMT || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_INV_EX_RATE:' ||''|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_TAX_RATE:' ||''|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_PERTYPE:' || RAT_UT_CD ||CHR(10)" ).append("\n"); 
		query.append("       || 'BL_TARIFF:' || CASE WHEN RFA_NO NOT LIKE 'DUM%' THEN RFA_NO" ).append("\n"); 
		query.append("	                        WHEN TAA_NO NOT LIKE 'DUM%' THEN TAA_NO" ).append("\n"); 
		query.append("	                        WHEN SC_NO  NOT LIKE 'DUM%' THEN SC_NO" ).append("\n"); 
		query.append("	                   ELSE ''" ).append("\n"); 
		query.append("	                   END" ).append("\n"); 
		query.append("	   || CHR(10) " ).append("\n"); 
		query.append("       || '}BL_CHARGE_INFO' || CHR(10) " ).append("\n"); 
		query.append("  FROM BKG_CHG_RT BC, BKG_BOOKING BK" ).append("\n"); 
		query.append(" WHERE BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BC.BKG_NO = BK.BKG_NO" ).append("\n"); 

	}
}