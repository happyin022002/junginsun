/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BlRatingDBDAOAddVATRevenueCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOAddVATRevenueCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOAddVATRevenueCSQL
	  * </pre>
	  */
	public BlRatingDBDAOAddVATRevenueCSQL(){
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
		params.put("payer_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payer_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_rate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOAddVATRevenueCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CHG_RT " ).append("\n"); 
		query.append("    (BKG_NO" ).append("\n"); 
		query.append("    , RT_SEQ" ).append("\n"); 
		query.append("    , CHG_CD" ).append("\n"); 
		query.append("    , CURR_CD" ).append("\n"); 
		query.append("    , CHG_UT_AMT" ).append("\n"); 
		query.append("    , RAT_AS_QTY" ).append("\n"); 
		query.append("    , RAT_UT_CD" ).append("\n"); 
		query.append("    , CHG_AMT" ).append("\n"); 
		query.append("    , FRT_TERM_CD" ).append("\n"); 
		query.append("    , DP_SEQ" ).append("\n"); 
		query.append("    , CGO_CATE_CD" ).append("\n"); 
		query.append("    , RCV_TERM_CD" ).append("\n"); 
		query.append("    , DE_TERM_CD" ).append("\n"); 
		query.append("    , AUTO_RAT_CD" ).append("\n"); 
		query.append("    , N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("    , N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("    , N3PTY_CUST_SEQ" ).append("\n"); 
		query.append("    --, INCL_OFT_FLG" ).append("\n"); 
		query.append("    , FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("    , PRN_HDN_FLG" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID)" ).append("\n"); 
		query.append("(SELECT @[bkg_no]" ).append("\n"); 
		query.append("    , NVL((SELECT MAX(RT_SEQ) + 1 FROM BKG_CHG_RT WHERE BKG_NO = @[bkg_no]), 1)" ).append("\n"); 
		query.append("    , 'TVA' " ).append("\n"); 
		query.append("    , 'EUR'" ).append("\n"); 
		query.append("    , NVL(@[vat_rate], 0)" ).append("\n"); 
		query.append("    , 20" ).append("\n"); 
		query.append("    , 'PC'" ).append("\n"); 
		query.append("    , NVL(@[vat_rate], 0) * 0.2" ).append("\n"); 
		query.append("    , 'C'" ).append("\n"); 
		query.append("    , 430 " ).append("\n"); 
		query.append("    , 'DR'" ).append("\n"); 
		query.append("    , (SELECT RCV_TERM_CD FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append("    , 'H'" ).append("\n"); 
		query.append("    , 'I'" ).append("\n"); 
		query.append("-- THIRD와 CCT동일한 경우 들어가지 않도록 함 2010.02.23 CATESHIN" ).append("\n"); 
		query.append("	,DECODE(NVL((SELECT CLT_OFC_CD||CLT_PAYR_CNT_CD||CLT_PAYR_CUST_SEQ" ).append("\n"); 
		query.append("		FROM BKG_RATE WHERE BKG_NO = @[bkg_no]), '*'),@[ofc_cd]||@[payer_cnt_cd]||@[payer_cust_seq]," ).append("\n"); 
		query.append("		'', @[ofc_cd])" ).append("\n"); 
		query.append("	,DECODE(NVL((SELECT CLT_OFC_CD||CLT_PAYR_CNT_CD||CLT_PAYR_CUST_SEQ" ).append("\n"); 
		query.append("		FROM BKG_RATE WHERE BKG_NO = @[bkg_no]), '*'),@[ofc_cd]||@[payer_cnt_cd]||@[payer_cust_seq]," ).append("\n"); 
		query.append("		'', @[payer_cnt_cd])" ).append("\n"); 
		query.append("	,DECODE(NVL((SELECT CLT_OFC_CD||CLT_PAYR_CNT_CD||CLT_PAYR_CUST_SEQ" ).append("\n"); 
		query.append("		FROM BKG_RATE WHERE BKG_NO = @[bkg_no]), '*'),@[ofc_cd]||@[payer_cnt_cd]||@[payer_cust_seq]," ).append("\n"); 
		query.append("		'', @[payer_cust_seq])" ).append("\n"); 
		query.append("    , 'N'" ).append("\n"); 
		query.append("    , 'Y'" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append(" FROM MDM_ORGANIZATION OFC" ).append("\n"); 
		query.append("    , MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE OFC.OFC_CD = NVL(@[ofc_cd], (SELECT CLT_OFC_CD FROM BKG_RATE WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append("  AND OFC.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("  AND LOC.CNT_CD = 'FR')" ).append("\n"); 

	}
}