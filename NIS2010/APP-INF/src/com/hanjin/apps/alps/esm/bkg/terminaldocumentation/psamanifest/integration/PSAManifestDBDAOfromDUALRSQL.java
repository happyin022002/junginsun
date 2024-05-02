/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOfromDUALRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.30 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOfromDUALRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 객체 생성용
	  * </pre>
	  */
	public PSAManifestDBDAOfromDUALRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOfromDUALRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("-- ' ' LOC_CD, ' ' PSA_LOC_CD, ' ' TML_CD, ' ' USER_ID -- PsaPortVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' VVD, ' ' RLY_PORT, ' ' TRANS_TP_CD   -- PsaUnmatchCNTRVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' VVD, ' ' RLY_PORT, ' ' ETD_DT, ' ' TRANS_TP_CD, ' ' BKG_NO, ' ' CNTR_NO  -- PsaUnmatchListVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' VVD, ' ' BKG_NO, ' ' RLY_PORT, ' ' CNTR_TP_CD, ' ' CNTR_SZ_CD, ' ' CNTR_NO, ' ' STWG_CD," ).append("\n"); 
		query.append("--' ' SPECIAL, ' ' PORT_CD, ' ' TRANS_TP_CD, ' ' NEXT_POD, ' ' NEXT_VVD -- PsaUnmatchBkgCntrVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' CNTR_NO, ' ' VVD, ' ' RLY_PORT, ' ' TRANS_TP_CD, ' ' ETD_DT, ' ' VSL_NM, ' ' USER_ID," ).append("\n"); 
		query.append("--' ' ALPS_CNTR_TP_CD, ' ' ALPS_CNTR_SZ_CD, ' ' ALPS_PORT_CD, ' ' ALPS_SPECIAL, ' ' ALPS_LOAD," ).append("\n"); 
		query.append("--' ' PSA_CNTR_TP_CD, ' ' PSA_CNTR_SZ_CD, ' ' PSA_PORT_CD, ' ' PSA_SPECIAL, ' ' PSA_LOAD, ' ' DIFF," ).append("\n"); 
		query.append("--' ' ETA_DT, ' ' NEXT_POD, ' ' NEXT_VVD  -- PsaImportVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' VSL_NAME, ' ' VVD_NM, ' ' CNTR_NO, ' ' PORT_CD, ' ' CNTR_TP_CD, ' ' CNTR_SZ_CD, ' ' UND_DECK_TP_ID, ' ' SPECIAL -- PsaJurongIfVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' VSL_NAME, ' ' VVD_NM, ' ' CNTR_NO, ' ' PORT_CD, ' ' CNTR_TP_CD, ' ' CNTR_SZ_CD, ' ' UND_DECK_TP_ID, ' ' SPECIAL -- PsaPSAIfVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("' ' BKG_NO, ' ' USR_ID, ' ' USR_NM, ' ' BKG_SEQ, ' ' SND_DT, ' ' SND_USR_ID, ' ' CNTR_TPSZ_CD, ' ' YD_CD, ' ' CNTR_QTY, ' ' BKG_QTY," ).append("\n"); 
		query.append("' ' PSA_SER_NO, ' ' SUB_PSA_SER_NO, ' ' PSA_IF_CD, ' ' MAIN_BKG_QTY -- PsaBkgIfVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' BKG_SEQ, ' ' VSL_CD, ' ' SKD_VOY_NO, ' ' SKD_DIR_CD, ' ' PSA_IF_CD,  ' ' N1ST_SHPR_NM," ).append("\n"); 
		query.append("--' ' N2ND_SHPR_NM, ' ' POD_CD, ' ' N1ST_POD_CD, ' ' N2ND_POD_CD, ' ' N3RD_POD_CD, ' ' SND_DT," ).append("\n"); 
		query.append("--' ' SND_USR_ID, ' ' ACK_RCV_STS_CD  -- PsaBkgInfoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' CNTR_SZ, ' ' CNTR_HEIGHT, ' ' SPE_RF, ' ' SPE_RD, ' ' RF_TEMP, ' ' OH_IND, ' ' OW_IND, ' ' OL_IND," ).append("\n"); 
		query.append("--' ' SPE_DG, ' ' CNTRTS_CD, ' ' YD_CD   -- PsaBkgQtyTmpVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' BKG_SEQ, ' ' PSA_SER_NO, ' ' CNTR_KNT, ' ' PSA_CNTR_TPSZ_CD -- PsaCntrCntVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' BKG_SEQ, ' ' PSA_SER_NO, ' ' PSA_IF_CD, ' ' CNTR_TPSZ_CD, ' ' FULL_MTY_CD," ).append("\n"); 
		query.append("--' ' DCGO_FLG, ' ' RC_FLG, ' ' RD_CGO_FLG, ' ' OVR_HGT_FLG, ' ' OVR_WDT_FLG, ' ' OVR_LEN_FLG," ).append("\n"); 
		query.append("--' ' CNTR_KNT, ' ' RC_TEMP, ' ' SPCL_CGO_DTL_FLG, ' ' PBC_CNTR_HEIGHT, ' ' PBC_CNTR_TP, ' ' USR_ID -- PsaBkgCntrInfoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' SUB_PSA_SER_NO, ' ' BKG_NO, ' ' BKG_SEQ, ' ' PSA_SER_NO, ' ' YD_CD, ' ' CNTR_TPSZ_CD -- PsaSubSrlNoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' CNTR_QTY, ' ' BKG_NO, ' ' BKG_SEQ, ' ' PSA_SER_NO, ' ' SUB_PSA_SER_NO -- PsaRoCntrQtyVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' SUB_PSA_SER_NO, ' ' BKG_NO, ' ' BKG_SEQ, ' ' PSA_SER_NO -- PsaMaxSubSrlNoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' BKG_NO, ' ' BKG_SEQ, ' ' PSA_SER_NO, ' ' SUB_PSA_SER_NO, ' ' PSA_IF_CD, ' ' YD_CD, ' ' CNTR_TPSZ_CD, ' ' CNTR_QTY," ).append("\n"); 
		query.append("--' ' USR_ID -- PsaBkgRlsOrdVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' BKG_NO, ' ' BKG_SEQ, ' ' ADD_SEQ, ' ' PSA_SER_NO -- PsaSerNoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' BKG_NO, ' ' BKG_SEQ, ' ' ADD_SEQ, ' ' PSA_SER_NO -- PsaRlsOrdSerNoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' CNTR_CNT_NEW, ' ' ADD_VAL, ' ' BKG_NO, ' ' BKG_SEQ, ' ' PSA_SER_NO -- PsaBkgCntrNewVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' BKG_NO, ' ' BKG_SEQ, ' ' PSA_SER_NO, ' ' SUB_PSA_SER_NO -- PsaRlsOrdQtyVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' CNTR_QTY, ' ' BKG_NO, ' ' BKG_SEQ, ' ' PSA_SER_NO, ' ' SUB_PSA_SER_NO -- PsaRlsOrdCntrQtyVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' ADD_VAL1, ' ' ADD_VAL2, ' ' BKG_NO, ' ' BKG_SEQ, ' ' PSA_SER_NO, ' ' SUB_PSA_SER_NO -- PsaRlsOrdSubSerNoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' N1ST_CNTR_NO, ' ' N2ND_CNTR_NO, ' ' N3RD_CNTR_NO, ' ' N4TH_CNTR_NO, ' ' N5TH_CNTR_NO, ' ' N6TH_CNTR_NO," ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' BKG_SEQ, ' ' PSA_SER_NO -- PsaCntrNoVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' BKG_SEQ, ' ' SND_DT, ' ' ACK_RCV_STS_CD -- PsaSndDtVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' PSA_SER_NO, ' ' SUB_PSA_SER_NO, ' ' PSA_IF_CD, ' ' BKG_NO, ' ' BKG_SEQ, ' ' CNTR_TPSZ_CD, ' ' CNTR_QTY, ' ' YD_CD, ' ' USR_ID -- PsaYardCdVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' PSA_SER_NO, ' ' SUB_PSA_SER_NO, ' ' PSA_IF_CD, ' ' BKG_NO, ' ' BKG_SEQ, ' ' CNTR_TPSZ_CD, ' ' CNTR_QTY, ' ' YD_CD, ' ' USR_ID -- PsaRlsForYardVO" ).append("\n"); 
		query.append("--' ' VSL_CD, ' ' SKD_VOY_NO, ' ' SKD_DIR_CD, ' ' PSA_SER_NO, ' ' SUB_PSA_SER_NO, ' ' PSA_IF_CD, ' ' BKG_NO, ' ' BKG_SEQ," ).append("\n"); 
		query.append("--' ' USR_ID, ' ' BKG_SEQ -- PsaBkgForYardVO" ).append("\n"); 
		query.append("--' ' BKG_SEQ, ' ' PSA_SER_NO, ' ' SUB_PSA_SER_NO, ' ' PSA_IF_CD, ' ' BKG_NO, ' ' BKG_SEQ, ' ' USR_ID -- PsaCntrForYardVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}