/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FFCommCalculationDBDAOAddFFCommMasterCancelIFCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCommCalculationDBDAOAddFFCommMasterCancelIFCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FFCommCalculationDBDAOAddFFCommMasterCancelIFCSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOAddFFCommMasterCancelIFCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_proc_rslt_rsn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n"); 
		query.append("FileName : FFCommCalculationDBDAOAddFFCommMasterCancelIFCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_FF_CMPN" ).append("\n"); 
		query.append("(BKG_NO, BKG_FF_CNT_CD, BKG_FF_SEQ, FF_CMPN_SEQ, FF_CNT_CD, FF_SEQ, FF_AGMT_SEQ, FF_CHG_AMT, PPD_AMT, CRNT_AMT, IF_AMT, FF_CMPN_STS_CD, LOC_CD, AR_OFC_CD, AP_OFC_CD, COMM_STND_COST_CD, VSL_DEP_DT, FF_DIV_CD, FF_BKG_RT, BKG_BX_QTY, FF_BX_AMT, BKG_TEU_QTY, FF_TEU_AMT, BKG_FEU_QTY, FF_FEU_AMT, BKG_RF_QTY, FF_RF_AMT, FF_CHG_CTNT, FMC_NO, VNDR_CNT_CD, VNDR_SEQ" ).append("\n"); 
		query.append(", FF_OCCR_INFO_CD, FF_SLAN_CD, FF_RLANE_CD, FF_VSL_CD, FF_SKD_VOY_NO, FF_SKD_DIR_CD, FF_REV_DIR_CD, OFC_CHR_CD, FF_REF_NO, CSR_NO, APRO_USR_ID, APRO_DT, APRO_GDT, GL_DT, INV_TAX_RT, IF_USR_ID, IF_DT, IF_GDT, SC_NO, RFA_NO, SHPR_CNT_CD, SHPR_SEQ, CMDT_TP_CD, CMDT_CD, FF_CMPN_RMK, ACCL_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BRO.BKG_NO" ).append("\n"); 
		query.append(", BRO.BKG_FF_CNT_CD" ).append("\n"); 
		query.append(", BRO.BKG_FF_SEQ" ).append("\n"); 
		query.append(", BRO.FF_CMPN_SEQ + 1 AS FF_CMPN_SEQ" ).append("\n"); 
		query.append(", BRO.FF_CNT_CD" ).append("\n"); 
		query.append(", BRO.FF_SEQ " ).append("\n"); 
		query.append(", BRO.FF_AGMT_SEQ" ).append("\n"); 
		query.append(", CCD.CANCELED_AMT AS PPD_AMT" ).append("\n"); 
		query.append(", 0 AS CRNT_AMT" ).append("\n"); 
		query.append(", 0 - CCD.CANCELED_AMT AS IF_AMT" ).append("\n"); 
		query.append(", 'CS' FF_CMPN_STS_CD" ).append("\n"); 
		query.append(", BRO.LOC_CD" ).append("\n"); 
		query.append(", BRO.AR_OFC_CD" ).append("\n"); 
		query.append(", BRO.AP_OFC_CD" ).append("\n"); 
		query.append(", BRO.COMM_STND_COST_CD" ).append("\n"); 
		query.append(", BRO.VSL_DEP_DT" ).append("\n"); 
		query.append(", BRO.FF_DIV_CD" ).append("\n"); 
		query.append(", BRO.FF_BKG_RT" ).append("\n"); 
		query.append(", BRO.BKG_BX_QTY" ).append("\n"); 
		query.append(", BRO.FF_BX_AMT" ).append("\n"); 
		query.append(", BRO.BKG_TEU_QTY" ).append("\n"); 
		query.append(", BRO.FF_TEU_AMT" ).append("\n"); 
		query.append(", BRO.BKG_FEU_QTY" ).append("\n"); 
		query.append(", BRO.FF_FEU_AMT" ).append("\n"); 
		query.append(", BRO.BKG_RF_QTY" ).append("\n"); 
		query.append(", BRO.FF_RF_AMT" ).append("\n"); 
		query.append(", BRO.FF_CHG_CTNT" ).append("\n"); 
		query.append(", BRO.FMC_NO" ).append("\n"); 
		query.append(", BRO.VNDR_CNT_CD" ).append("\n"); 
		query.append(", BRO.VNDR_SEQ" ).append("\n"); 
		query.append(", BRO.FF_OCCR_INFO_CD" ).append("\n"); 
		query.append(", BRO.FF_SLAN_CD" ).append("\n"); 
		query.append(", BRO.FF_RLANE_CD" ).append("\n"); 
		query.append(", BRO.FF_VSL_CD" ).append("\n"); 
		query.append(", BRO.FF_SKD_VOY_NO" ).append("\n"); 
		query.append(", BRO.FF_SKD_DIR_CD" ).append("\n"); 
		query.append(", BRO.FF_REV_DIR_CD" ).append("\n"); 
		query.append(", BRO.OFC_CHR_CD" ).append("\n"); 
		query.append(", BRO.FF_REF_NO" ).append("\n"); 
		query.append(", NULL CSR_NO" ).append("\n"); 
		query.append(", NULL APRO_USR_ID" ).append("\n"); 
		query.append(", NULL APRO_DT" ).append("\n"); 
		query.append(", NULL APRO_GDT" ).append("\n"); 
		query.append(", NULL GL_DT" ).append("\n"); 
		query.append(", BRO.INV_TAX_RT" ).append("\n"); 
		query.append(", NULL IF_USR_ID" ).append("\n"); 
		query.append(", NULL IF_DT" ).append("\n"); 
		query.append(", NULL IF_GDT" ).append("\n"); 
		query.append(", NULL SC_NO" ).append("\n"); 
		query.append(", BRO.RFA_NO" ).append("\n"); 
		query.append(", BRO.SHPR_CNT_CD" ).append("\n"); 
		query.append(", BRO.SHPR_SEQ" ).append("\n"); 
		query.append(", BRO.CMDT_TP_CD" ).append("\n"); 
		query.append(", BRO.CMDT_CD" ).append("\n"); 
		query.append(", CCD.CANCELED_RSN AS FF_CMPN_RMK" ).append("\n"); 
		query.append(", ACCL_FLG" ).append("\n"); 
		query.append(", CCD.CANCELED_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE CRE_DT" ).append("\n"); 
		query.append(", CCD.CANCELED_USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM ACM_FF_CMPN BRO" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      MAX (BR2.BKG_NO)                             AS BKG_NO," ).append("\n"); 
		query.append("                      ROUND (NVL (SUM (BR2.IF_AMT),0), 2)          AS CANCELED_AMT," ).append("\n"); 
		query.append("                      @[comm_proc_rslt_rsn]                        AS CANCELED_RSN," ).append("\n"); 
		query.append("                      'COMMISSION'                                 AS CANCELED_USR_ID" ).append("\n"); 
		query.append("			     FROM ACM_FF_CMPN BR2" ).append("\n"); 
		query.append("                WHERE BR2.BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("                  AND BR2.FF_CMPN_STS_CD = 'IF'" ).append("\n"); 
		query.append("             GROUP BY BKG_NO" ).append("\n"); 
		query.append("               HAVING 0 < ROUND (NVL (SUM (BR2.IF_AMT),0), 2)" ).append("\n"); 
		query.append("         ) CCD" ).append("\n"); 
		query.append("     WHERE BRO.BKG_NO           = CCD.BKG_NO" ).append("\n"); 
		query.append("       AND BRO.FF_CMPN_SEQ      = @[ff_cmpn_seq]" ).append("\n"); 
		query.append("       AND BRO.FF_CMPN_STS_CD = 'IF'" ).append("\n"); 

	}
}