/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LeaseSubleaseDBDAOMstCheckDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseSubleaseDBDAOMstCheckDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Check Digit and Container Checking Inquiry
	  * </pre>
	  */
	public LeaseSubleaseDBDAOMstCheckDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.integration").append("\n"); 
		query.append("FileName : LeaseSubleaseDBDAOMstCheckDetailRSQL").append("\n"); 
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
		query.append("WITH PARAM" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("SELECT /*+ INDEX( A XPKMST_CONTAINER) */" ).append("\n"); 
		query.append("                 CNTR_NO " ).append("\n"); 
		query.append("                 FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                 ##${cntr_no}" ).append("\n"); 
		query.append("                 #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                 AND   A.CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 ##${cntr_no}" ).append("\n"); 
		query.append("                 #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                 AND   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 AND CNMV_DT = (" ).append("\n"); 
		query.append("                               SELECT MAX(CNMV_DT) " ).append("\n"); 
		query.append("                               FROM MST_CONTAINER " ).append("\n"); 
		query.append("                               WHERE 1 = 1" ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                               #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                               AND   CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                               #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                               AND   CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                 AND ROWNUM = 1 " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   @[cntr_no] CNTR_NO," ).append("\n"); 
		query.append("   MST_COMMON_PKG.MST_CNTR_CHK_DGT_FNC(@[cntr_no], 1) CHK_DGT," ).append("\n"); 
		query.append("   @[cntr_no] || MST_COMMON_PKG.MST_CNTR_CHK_DGT_FNC(@[cntr_no], 1) FULL_CNTR_NO," ).append("\n"); 
		query.append("   MAX(A.RGST_CNTR_NO) RGST_CNTR_NO," ).append("\n"); 
		query.append("   MAX(A.CNTR_TPSZ_CD) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("   MAX(A.LSTM_CD) LSTM_CD," ).append("\n"); 
		query.append("   MAX(A.CNMV_STS_CD) CNMV_STS_CD," ).append("\n"); 
		query.append("   MAX(A.CRNT_YD_CD) CRNT_YD_CD," ).append("\n"); 
		query.append("   MAX(A.CNTR_STS_CD) CNTR_STS_CD," ).append("\n"); 
		query.append("   MAX(A.AGMT_NO) AGMT_NO," ).append("\n"); 
		query.append("   MAX(A.VNDR_ABBR_NM) VNDR_ABBR_NM," ).append("\n"); 
		query.append("   MAX(A.CNTR_USE_CO_CD) CNTR_USE_CO_CD," ).append("\n"); 
		query.append("   MAX(A.CNMV_DATE) CNMV_DATE," ).append("\n"); 
		query.append("   MAX(A.FULL_FLG) FULL_FLG," ).append("\n"); 
		query.append("   MAX(A.DMG_FLG) DMG_FLG," ).append("\n"); 
		query.append("   MAX(A.CNTR_HNGR_RCK_CD) CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("   MAX(A.MNR_HNGR_BAR_TP_CD) MNR_HNGR_BAR_TP_CD," ).append("\n"); 
		query.append("   MAX(A.CNTR_HNGR_BAR_ATCH_KNT) CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("   MAX(A.DISP_FLG) DISP_FLG," ).append("\n"); 
		query.append("   MAX(A.IMDT_EXT_FLG) IMDT_EXT_FLG," ).append("\n"); 
		query.append("   MAX(A.LS_FLG) LS_FLG," ).append("\n"); 
		query.append("   MAX(A.UC_FLG) UC_FLG," ).append("\n"); 
		query.append("   MAX(A.PLST_FLR_FLG) PLST_FLR_FLG," ).append("\n"); 
		query.append("   MAX(D_VAL) DV_VAL," ).append("\n"); 
		query.append("   MAX(MFT_DT) MFT_DT," ).append("\n"); 
		query.append("   MAX(BKG_NO) BKG_NO," ).append("\n"); 
		query.append("   MAX(POL_CD) POL_CD," ).append("\n"); 
		query.append("   MAX(POR_CD) POR_CD," ).append("\n"); 
		query.append("   MAX(POD_CD) POD_CD," ).append("\n"); 
		query.append("   MAX(DEL_CD) DEL_CD," ).append("\n"); 
		query.append("   MAX(POL_ETD_DT) ETD_DT," ).append("\n"); 
		query.append("   MAX(POD_ETA_DT) ETA_DT," ).append("\n"); 
		query.append("   MAX(VVD) VVD," ).append("\n"); 
		query.append("   MAX(SC_NO) SC_NO," ).append("\n"); 
		query.append("   MAX(RD_TERM) RD_TERM" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   SUBSTR(A.CNTR_NO, 1, 10) CNTR_NO," ).append("\n"); 
		query.append("   A.CNTR_NO RGST_CNTR_NO," ).append("\n"); 
		query.append("   A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("   B.LSTM_CD," ).append("\n"); 
		query.append("   A.CNMV_STS_CD," ).append("\n"); 
		query.append("   A.CRNT_YD_CD," ).append("\n"); 
		query.append("   A.CNTR_STS_CD," ).append("\n"); 
		query.append("   MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ) AGMT_NO," ).append("\n"); 
		query.append("   NVL(D.VNDR_ABBR_NM, D.VNDR_LGL_ENG_NM) VNDR_ABBR_NM," ).append("\n"); 
		query.append("   A.CNTR_USE_CO_CD," ).append("\n"); 
		query.append("   TO_CHAR(A.CNMV_DT,'YYYY-MM-DD') CNMV_DATE," ).append("\n"); 
		query.append("   DECODE(A.FULL_FLG,'Y','F','M') FULL_FLG," ).append("\n"); 
		query.append("   DECODE(A.DMG_FLG,'Y',A.DMG_FLG,'') DMG_FLG," ).append("\n"); 
		query.append("   (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID='CD02012' AND INTG_CD_VAL_CTNT=A.CNTR_HNGR_RCK_CD) CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("   A.MNR_HNGR_BAR_TP_CD," ).append("\n"); 
		query.append("   A.CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("   DECODE(A.DISP_FLG,'Y',A.DISP_FLG,'') DISP_FLG," ).append("\n"); 
		query.append("   DECODE(A.IMDT_EXT_FLG,'Y',A.IMDT_EXT_FLG,'') IMDT_EXT_FLG," ).append("\n"); 
		query.append("   DECODE(A.UCLM_LS_DIV_CD,'L','Y','') LS_FLG," ).append("\n"); 
		query.append("   DECODE(A.UCLM_LS_DIV_CD,'U','Y','') UC_FLG," ).append("\n"); 
		query.append("   DECODE(A.PLST_FLR_FLG,'Y',A.PLST_FLR_FLG,'') PLST_FLR_FLG" ).append("\n"); 
		query.append("   ,MNR_COMMON_PKG.MNR_CAL_DV_FNC('U',P.CNTR_NO,TO_CHAR(SYSDATE,'YYYYMMDD')) D_VAL" ).append("\n"); 
		query.append("   ,TO_CHAR(A.MFT_DT,'YYYY-MM-DD') MFT_DT" ).append("\n"); 
		query.append("   ,BKG.BKG_NO" ).append("\n"); 
		query.append("   ,BKG.POL_CD" ).append("\n"); 
		query.append("   ,BKG.POR_CD" ).append("\n"); 
		query.append("   ,BKG.POD_CD" ).append("\n"); 
		query.append("   ,BKG.DEL_CD" ).append("\n"); 
		query.append("   ,TO_CHAR(BKG.POL_ETD_DT,'YYYY-MM-DD') POL_ETD_DT" ).append("\n"); 
		query.append("   ,TO_CHAR(BKG.POD_ETA_DT,'YYYY-MM-DD') POD_ETA_DT" ).append("\n"); 
		query.append("   ,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("   ,BKG.SC_NO SC_NO" ).append("\n"); 
		query.append("   ,BKG.RCV_TERM_CD||'/'||BKG.DE_TERM_CD RD_TERM " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("   MST_CONTAINER A," ).append("\n"); 
		query.append("   LSE_AGREEMENT B," ).append("\n"); 
		query.append("   MDM_VENDOR D," ).append("\n"); 
		query.append("   PARAM P" ).append("\n"); 
		query.append("   ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND   A.CNTR_NO        = P.CNTR_NO" ).append("\n"); 
		query.append("AND   B.AGMT_CTY_CD(+) = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND   B.AGMT_SEQ(+)    = A.AGMT_SEQ" ).append("\n"); 
		query.append("AND   D.VNDR_SEQ(+)    = A.VNDR_SEQ" ).append("\n"); 
		query.append("AND   BKG.BKG_NO(+)    = A.BKG_NO" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}