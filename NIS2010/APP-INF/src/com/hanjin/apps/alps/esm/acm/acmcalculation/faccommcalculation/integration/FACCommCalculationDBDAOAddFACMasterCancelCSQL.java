/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOAddFACMasterCancelCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOAddFACMasterCancelCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOAddFACMasterCancelCSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOAddFACMasterCancelCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cancel_amt_fac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fac_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cancel_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOAddFACMasterCancelCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_FAC_COMM " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", SLS_OFC_CD" ).append("\n"); 
		query.append(", @[fac_seq] AS FAC_SEQ" ).append("\n"); 
		query.append(", 'CS' AS FAC_STS_CD" ).append("\n"); 
		query.append(", @[cancel_amt] AS PPD_AMT" ).append("\n"); 
		query.append(", 0 AS CRNT_AMT" ).append("\n"); 
		query.append(", 0 - TO_NUMBER(@[cancel_amt]) AS IF_AMT" ).append("\n"); 
		query.append(", VSL_DEP_DT" ).append("\n"); 
		query.append(", LOC_DIV_CD" ).append("\n"); 
		query.append(", LOC_CD" ).append("\n"); 
		query.append(", AR_OFC_CD" ).append("\n"); 
		query.append(", AP_OFC_CD" ).append("\n"); 
		query.append(", AP_CTR_CD" ).append("\n"); 
		query.append(", COMM_STND_COST_CD" ).append("\n"); 
		query.append(", FAC_OCCR_INFO_CD" ).append("\n"); 
		query.append(", FAC_SLAN_CD" ).append("\n"); 
		query.append(", FAC_RLANE_CD" ).append("\n"); 
		query.append(", FAC_VSL_CD" ).append("\n"); 
		query.append(", FAC_SKD_VOY_NO" ).append("\n"); 
		query.append(", FAC_SKD_DIR_CD" ).append("\n"); 
		query.append(", FAC_REV_DIR_CD" ).append("\n"); 
		query.append(", BKG_FF_CNT_CD" ).append("\n"); 
		query.append(", BKG_FF_SEQ" ).append("\n"); 
		query.append(", VNDR_CNT_CD" ).append("\n"); 
		query.append(", VNDR_SEQ" ).append("\n"); 
		query.append(", FAC_DIV_CD" ).append("\n"); 
		query.append(", FAC_SPCL_CNTR_TP_CTNT1" ).append("\n"); 
		query.append(", FAC_SPCL_CNTR_RT1" ).append("\n"); 
		query.append(", FAC_SPCL_CNTR_TP_CTNT2" ).append("\n"); 
		query.append(", FAC_SPCL_CNTR_RT2" ).append("\n"); 
		query.append(", FAC_BKG_RT" ).append("\n"); 
		query.append(", FAC_BKG_AMT" ).append("\n"); 
		query.append(", BKG_BX_QTY" ).append("\n"); 
		query.append(", FAC_BX_AMT" ).append("\n"); 
		query.append(", BKG_DRY_TEU_QTY" ).append("\n"); 
		query.append(", FAC_DRY_TEU_AMT" ).append("\n"); 
		query.append(", BKG_DRY_FEU_QTY" ).append("\n"); 
		query.append(", FAC_DRY_FEU_AMT" ).append("\n"); 
		query.append(", BKG_RF_TEU_QTY" ).append("\n"); 
		query.append(", FAC_RF_TEU_AMT" ).append("\n"); 
		query.append(", BKG_RF_FEU_QTY" ).append("\n"); 
		query.append(", FAC_RF_FEU_AMT" ).append("\n"); 
		query.append(", BKG_SPCL_TEU_QTY" ).append("\n"); 
		query.append(", FAC_SPCL_TEU_AMT" ).append("\n"); 
		query.append(", BKG_SPCL_FEU_QTY" ).append("\n"); 
		query.append(", FAC_SPCL_FEU_AMT" ).append("\n"); 
		query.append(", FAC_CHG_CTNT" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", MON_XCH_RT" ).append("\n"); 
		query.append(", PAY_PPD_AMT" ).append("\n"); 
		query.append(", PAY_CRNT_AMT" ).append("\n"); 
		query.append(", PAY_IF_AMT" ).append("\n"); 
		query.append(", CMDT_TP_CD" ).append("\n"); 
		query.append(", CMDT_CD" ).append("\n"); 
		query.append(", OFC_CHR_CD" ).append("\n"); 
		query.append(", ACCL_FLG" ).append("\n"); 
		query.append(", INV_TAX_RT" ).append("\n"); 
		query.append(", GL_DT" ).append("\n"); 
		query.append(", CSR_NO" ).append("\n"); 
		query.append(", APRO_USR_ID" ).append("\n"); 
		query.append(", APRO_DT" ).append("\n"); 
		query.append(", APRO_GDT" ).append("\n"); 
		query.append(", IF_USR_ID" ).append("\n"); 
		query.append(", IF_DT" ).append("\n"); 
		query.append(", IF_GDT" ).append("\n"); 
		query.append(", FAC_OFC_CD" ).append("\n"); 
		query.append(", FF_CNT_CD" ).append("\n"); 
		query.append(", FF_SEQ" ).append("\n"); 
		query.append(", FAC_AGMT_SEQ" ).append("\n"); 
		query.append(", @[fac_rmk] FAC_RMK" ).append("\n"); 
		query.append(", 'COMMISSION' AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(", 'COMMISSION' AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM ACM_FAC_COMM " ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND FAC_SEQ = TO_NUMBER(@[cancel_amt_fac_seq]) - 1" ).append("\n"); 
		query.append("  AND COMM_PROC_STS_CD = 'CM'" ).append("\n"); 

	}
}