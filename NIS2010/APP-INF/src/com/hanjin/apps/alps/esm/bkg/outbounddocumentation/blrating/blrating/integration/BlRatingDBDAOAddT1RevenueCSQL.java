/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOAddT1RevenueCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
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

public class BlRatingDBDAOAddT1RevenueCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOAddT1RevenueCSQL
	  * </pre>
	  */
	public BlRatingDBDAOAddT1RevenueCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("haulage_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOAddT1RevenueCSQL").append("\n"); 
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
		query.append("    , FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("    , PRN_HDN_FLG" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID)" ).append("\n"); 
		query.append("values(" ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append("    , NVL((SELECT MAX(RT_SEQ) " ).append("\n"); 
		query.append("             FROM BKG_CHG_RT " ).append("\n"); 
		query.append("            WHERE BKG_NO = @[bkg_no]), 0) + 1" ).append("\n"); 
		query.append("    , DECODE(@[chg_cd], 'A', DECODE(@[io_bnd_cd], 'I', DECODE(@[haulage_cd], 'M', 'DOD', 'C', 'DIH', 'DIH'), 'OIH'), @[chg_cd]) " ).append("\n"); 
		query.append("    , @[curr_cd]" ).append("\n"); 
		query.append("    , NVL(@[rate], 0) " ).append("\n"); 
		query.append("    , 1 " ).append("\n"); 
		query.append("    ,  DECODE(@[io_bnd_cd], 'I', (SELECT CNTR_TPSZ_CD " ).append("\n"); 
		query.append("         FROM BKG_CONTAINER " ).append("\n"); 
		query.append("        WHERE BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("          AND CNTR_NO = @[cntr_no]), @[cntr_tpsz_cd])" ).append("\n"); 
		query.append("    , NVL(@[rate], 0) " ).append("\n"); 
		query.append("    , DECODE(@[io_bnd_cd], 'I', 'C', 'P')" ).append("\n"); 
		query.append("    , 430 " ).append("\n"); 
		query.append("    , 'DR' " ).append("\n"); 
		query.append("    , DECODE(@[io_bnd_cd], 'I'," ).append("\n"); 
		query.append("			(SELECT RCV_TERM_CD " ).append("\n"); 
		query.append("         		FROM BKG_CONTAINER " ).append("\n"); 
		query.append("        		WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("          		AND CNTR_NO = @[cntr_no])," ).append("\n"); 
		query.append("			(SELECT RCV_TERM_CD " ).append("\n"); 
		query.append("         		FROM BKG_BOOKING " ).append("\n"); 
		query.append("        		WHERE BKG_NO  = @[bkg_no]))" ).append("\n"); 
		query.append("    , DECODE(@[io_bnd_cd], 'I'," ).append("\n"); 
		query.append("			 CASE WHEN 'LEHSC' = @[clt_ofc_cd] AND 'Y' = (SELECT VAT_FLG FROM BKG_EUR_TRO WHERE BKG_NO = @[bkg_no] AND IO_BND_CD = 'I' AND TRO_SEQ = @[tro_seq]) THEN 'H'" ).append("\n"); 
		query.append("			 ELSE" ).append("\n"); 
		query.append("			(SELECT DE_TERM_CD  " ).append("\n"); 
		query.append("         		FROM BKG_CONTAINER " ).append("\n"); 
		query.append("        		WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("          		AND CNTR_NO = @[cntr_no]) " ).append("\n"); 
		query.append("			END," ).append("\n"); 
		query.append("			(SELECT DE_TERM_CD " ).append("\n"); 
		query.append("         		FROM BKG_BOOKING " ).append("\n"); 
		query.append("        		WHERE BKG_NO  = @[bkg_no]))" ).append("\n"); 
		query.append("    , 'I'" ).append("\n"); 
		query.append("-- THIRD와 CCT동일한 경우 들어가지 않도록 함 2010.02.23 CATESHIN" ).append("\n"); 
		query.append("	,DECODE(NVL((SELECT CLT_OFC_CD||CLT_PAYR_CNT_CD||CLT_PAYR_CUST_SEQ" ).append("\n"); 
		query.append("		FROM BKG_RATE WHERE BKG_NO = @[bkg_no]), '*'),@[clt_ofc_cd]||@[payer_cnt_cd]||@[payer_cust_seq]," ).append("\n"); 
		query.append("		'', @[clt_ofc_cd])" ).append("\n"); 
		query.append("	,DECODE(NVL((SELECT CLT_OFC_CD||CLT_PAYR_CNT_CD||CLT_PAYR_CUST_SEQ" ).append("\n"); 
		query.append("		FROM BKG_RATE WHERE BKG_NO = @[bkg_no]), '*'),@[clt_ofc_cd]||@[payer_cnt_cd]||@[payer_cust_seq]," ).append("\n"); 
		query.append("		'', @[payer_cnt_cd])" ).append("\n"); 
		query.append("	,DECODE(NVL((SELECT CLT_OFC_CD||CLT_PAYR_CNT_CD||CLT_PAYR_CUST_SEQ" ).append("\n"); 
		query.append("		FROM BKG_RATE WHERE BKG_NO = @[bkg_no]), '*'),@[clt_ofc_cd]||@[payer_cnt_cd]||@[payer_cust_seq]," ).append("\n"); 
		query.append("		'', @[payer_cust_seq])" ).append("\n"); 
		query.append("    , 'N'" ).append("\n"); 
		query.append("    , DECODE(@[io_bnd_cd], 'I', 'Y', 'N')" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , sysdate" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}