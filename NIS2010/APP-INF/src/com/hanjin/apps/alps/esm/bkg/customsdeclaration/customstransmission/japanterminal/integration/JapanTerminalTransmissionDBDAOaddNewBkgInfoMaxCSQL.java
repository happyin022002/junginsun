/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOaddNewBkgInfoMaxCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.08
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.06.08 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOaddNewBkgInfoMaxCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addNewBkgInfoMax
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOaddNewBkgInfoMaxCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOaddNewBkgInfoMaxCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  BKG_NO" ).append("\n"); 
		query.append(", BKG_SKD_SEQ" ).append("\n"); 
		query.append(", BKG_SKD_DELT_FLG" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_STS_CD" ).append("\n"); 
		query.append(", EDI_SND_DT" ).append("\n"); 
		query.append(", EDI_SND_OFC_CD" ).append("\n"); 
		query.append(", EDI_SND_USR_ID" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", JP_TML_VSL_NO" ).append("\n"); 
		query.append(", POL_CD" ).append("\n"); 
		query.append(", POL_YD_CD" ).append("\n"); 
		query.append(", POR_CD" ).append("\n"); 
		query.append(", POR_YD_CD" ).append("\n"); 
		query.append(", OTR_NTFY_YD_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD1" ).append("\n"); 
		query.append(", CNTR_VOL_QTY1" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD2" ).append("\n"); 
		query.append(", CNTR_VOL_QTY2" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD3" ).append("\n"); 
		query.append(", CNTR_VOL_QTY3" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD4" ).append("\n"); 
		query.append(", CNTR_VOL_QTY4" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD5" ).append("\n"); 
		query.append(", CNTR_VOL_QTY5" ).append("\n"); 
		query.append(", PRT_FLG" ).append("\n"); 
		query.append(", CALL_SGN_NO" ).append("\n"); 
		query.append(", VSL_ENG_NM" ).append("\n"); 
		query.append(", BKG_CRE_DT" ).append("\n"); 
		query.append(", ETD_DT" ).append("\n"); 
		query.append(", SHPR_CNT_CD" ).append("\n"); 
		query.append(", SHPR_CUST_SEQ" ).append("\n"); 
		query.append(", SHPR_CUST_NM" ).append("\n"); 
		query.append(", FRT_FWRD_CNT_CD" ).append("\n"); 
		query.append(", FRT_FWRD_CUST_SEQ" ).append("\n"); 
		query.append(", FRT_FWRD_CUST_NM" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_RCV_TERM_CD" ).append("\n"); 
		query.append(", POD_CD" ).append("\n"); 
		query.append(", DEL_CD" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_DE_TERM_CD" ).append("\n"); 
		query.append(", FNL_DEST_CD" ).append("\n"); 
		query.append(", FNL_DEST_NM" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_CGO_TP_CD" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_CGO_KND_CD" ).append("\n"); 
		query.append(", PCK_TP_CD" ).append("\n"); 
		query.append(", CMDT_NM" ).append("\n"); 
		query.append(", XTER_RMK" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", TTL_PCK_TP_CD" ).append("\n"); 
		query.append(", GRS_WGT" ).append("\n"); 
		query.append(", WGT_UT_CD" ).append("\n"); 
		query.append(", MEAS_QTY" ).append("\n"); 
		query.append(", MEAS_UT_CD" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_STWG_CD" ).append("\n"); 
		query.append(", STWG_RMK" ).append("\n"); 
		query.append(", BLCK_STWG_CD" ).append("\n"); 
		query.append(", DRY_CGO_FLG" ).append("\n"); 
		query.append(", MCNTR_FLG" ).append("\n"); 
		query.append(", SOC_FLG" ).append("\n"); 
		query.append(", RF_CNTR_PRE_CLNG_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", DCGO_FLG" ).append("\n"); 
		query.append(", AWK_CGO_FLG" ).append("\n"); 
		query.append(", BB_CGO_FLG" ).append("\n"); 
		query.append(", RD_CGO_FLG" ).append("\n"); 
		query.append(", SNACCS_TML_EDI_STS_CNG_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("		SELECT NVL(MAX(BKG_SKD_SEQ), 0)+1" ).append("\n"); 
		query.append("		  FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("     , BKG_SKD_DELT_FLG, SNACCS_TML_EDI_STS_CD, EDI_SND_DT, EDI_SND_OFC_CD, EDI_SND_USR_ID" ).append("\n"); 
		query.append("     , VSL_CD, SKD_VOY_NO, SKD_DIR_CD,JP_TML_VSL_NO, POL_CD, POL_YD_CD, POR_CD, POR_YD_CD, OTR_NTFY_YD_CD, CNTR_TPSZ_CD1, CNTR_VOL_QTY1" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD2, CNTR_VOL_QTY2, CNTR_TPSZ_CD3, CNTR_VOL_QTY3, CNTR_TPSZ_CD4, CNTR_VOL_QTY4, CNTR_TPSZ_CD5, CNTR_VOL_QTY5, PRT_FLG" ).append("\n"); 
		query.append("     , CALL_SGN_NO, VSL_ENG_NM, BKG_CRE_DT, ETD_DT, SHPR_CNT_CD, SHPR_CUST_SEQ, SHPR_CUST_NM, FRT_FWRD_CNT_CD, FRT_FWRD_CUST_SEQ, FRT_FWRD_CUST_NM" ).append("\n"); 
		query.append("     , SNACCS_TML_EDI_RCV_TERM_CD, POD_CD, DEL_CD, SNACCS_TML_EDI_DE_TERM_CD, FNL_DEST_CD, FNL_DEST_NM, SNACCS_TML_EDI_CGO_TP_CD, SNACCS_TML_EDI_CGO_KND_CD" ).append("\n"); 
		query.append("     , PCK_TP_CD, CMDT_NM, XTER_RMK, PCK_QTY, TTL_PCK_TP_CD, GRS_WGT, WGT_UT_CD, MEAS_QTY, MEAS_UT_CD, SNACCS_TML_EDI_STWG_CD" ).append("\n"); 
		query.append("     , STWG_RMK, BLCK_STWG_CD, DRY_CGO_FLG, MCNTR_FLG, SOC_FLG, RF_CNTR_PRE_CLNG_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, DCGO_FLG, AWK_CGO_FLG, BB_CGO_FLG, RD_CGO_FLG, SNACCS_TML_EDI_STS_CNG_FLG " ).append("\n"); 
		query.append("  FROM BKG_TML_EDI_JP_BL" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_SKD_SEQ = '0'" ).append("\n"); 

	}
}