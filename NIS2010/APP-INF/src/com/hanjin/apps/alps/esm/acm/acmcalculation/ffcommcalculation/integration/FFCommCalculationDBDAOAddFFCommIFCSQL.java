/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCommCalculationDBDAOAddFFCommIFCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCommCalculationDBDAOAddFFCommIFCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FFCommCalculationDBDAOAddFFCommIFCSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOAddFFCommIFCSQL(){
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
		params.put("bkg_ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_ff_cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n"); 
		query.append("FileName : FFCommCalculationDBDAOAddFFCommIFCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_FF_CMPN " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", BKG_FF_CNT_CD" ).append("\n"); 
		query.append(", BKG_FF_SEQ" ).append("\n"); 
		query.append(", @[new_ff_cmpn_seq] FF_CMPN_SEQ" ).append("\n"); 
		query.append(", FF_CNT_CD" ).append("\n"); 
		query.append(", FF_SEQ " ).append("\n"); 
		query.append(", FF_AGMT_SEQ" ).append("\n"); 
		query.append(", FF_CHG_AMT" ).append("\n"); 
		query.append(", IF_AMT PPD_AMT" ).append("\n"); 
		query.append(", 0 CRNT_AMT" ).append("\n"); 
		query.append(", -IF_AMT IF_AMT" ).append("\n"); 
		query.append(", 'CS' FF_CMPN_STS_CD" ).append("\n"); 
		query.append(", LOC_CD" ).append("\n"); 
		query.append(", AR_OFC_CD" ).append("\n"); 
		query.append(", AP_OFC_CD" ).append("\n"); 
		query.append(", COMM_STND_COST_CD" ).append("\n"); 
		query.append(", VSL_DEP_DT" ).append("\n"); 
		query.append(", FF_DIV_CD" ).append("\n"); 
		query.append(", FF_BKG_RT" ).append("\n"); 
		query.append(", BKG_BX_QTY" ).append("\n"); 
		query.append(", FF_BX_AMT" ).append("\n"); 
		query.append(", BKG_TEU_QTY" ).append("\n"); 
		query.append(", FF_TEU_AMT" ).append("\n"); 
		query.append(", BKG_FEU_QTY" ).append("\n"); 
		query.append(", FF_FEU_AMT" ).append("\n"); 
		query.append(", BKG_RF_QTY" ).append("\n"); 
		query.append(", FF_RF_AMT" ).append("\n"); 
		query.append(", FF_CHG_CTNT" ).append("\n"); 
		query.append(", FMC_NO" ).append("\n"); 
		query.append(", VNDR_CNT_CD" ).append("\n"); 
		query.append(", VNDR_SEQ" ).append("\n"); 
		query.append(", FF_OCCR_INFO_CD" ).append("\n"); 
		query.append(", FF_SLAN_CD" ).append("\n"); 
		query.append(", FF_RLANE_CD" ).append("\n"); 
		query.append(", FF_VSL_CD" ).append("\n"); 
		query.append(", FF_SKD_VOY_NO" ).append("\n"); 
		query.append(", FF_SKD_DIR_CD" ).append("\n"); 
		query.append(", FF_REV_DIR_CD" ).append("\n"); 
		query.append(", OFC_CHR_CD" ).append("\n"); 
		query.append(", FF_REF_NO" ).append("\n"); 
		query.append(", NULL CSR_NO" ).append("\n"); 
		query.append(", NULL APRO_USR_ID" ).append("\n"); 
		query.append(", NULL APRO_DT" ).append("\n"); 
		query.append(", NULL APRO_GDT" ).append("\n"); 
		query.append(", GL_DT" ).append("\n"); 
		query.append(", INV_TAX_RT" ).append("\n"); 
		query.append(", NULL IF_USR_ID" ).append("\n"); 
		query.append(", NULL IF_DT" ).append("\n"); 
		query.append(", NULL IF_GDT" ).append("\n"); 
		query.append(", NULL SC_NO" ).append("\n"); 
		query.append(", RFA_NO" ).append("\n"); 
		query.append(", SHPR_CNT_CD" ).append("\n"); 
		query.append(", SHPR_SEQ" ).append("\n"); 
		query.append(", CMDT_TP_CD" ).append("\n"); 
		query.append(", CMDT_CD" ).append("\n"); 
		query.append(", 'Calculation Success!' FF_CMPN_RMK" ).append("\n"); 
		query.append(", 'Y' ACCL_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM ACM_FF_CMPN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]			" ).append("\n"); 
		query.append("AND FF_CMPN_STS_CD = 'IF'				" ).append("\n"); 
		query.append("AND BKG_FF_CNT_CD||BKG_FF_SEQ <> @[bkg_ff_cnt_cd]||TO_NUMBER(@[bkg_ff_seq])" ).append("\n"); 

	}
}