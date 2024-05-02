/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOsearchBondTsInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchBondTsInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bonded Info T/S정보를 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchBondTsInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchBondTsInfoListRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(SEQ.MF_CFM_FLG, 'Y', 'Y'), ' ') MF_CFM_FLG" ).append("\n"); 
		query.append("     , NVL(SEQ.MF_SEQ_NO, ' ') MF_SEQ_NO" ).append("\n"); 
		query.append("     , NVL(BKG.BL_NO, ' ') BL_NO" ).append("\n"); 
		query.append("     , 'S' KR_CSTMS_BL_TP_CD" ).append("\n"); 
		query.append("     , NVL(SEQ.CSTMS_CLR_TP_CD, '') CSTMS_CLR_TP_CD" ).append("\n"); 
		query.append("     , NVL(SEQ.CSTMS_DCHG_LOC_WH_CD, '') CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append("     , NVL(SEQ.CSTMS_CRR_IN_LOC_WH_CD, '') CSTMS_CRR_IN_LOC_WH_CD" ).append("\n"); 
		query.append("     , NVL(SEQ.CSTMS_CLR_WH_CD, '') CSTMS_CLR_WH_CD" ).append("\n"); 
		query.append("     , NVL(SEQ.BD_TP_CD, ' ') BD_TP_CD" ).append("\n"); 
		query.append("     , NVL(VVD2.VSL_CD||VVD2.SKD_VOY_NO||VVD2.SKD_DIR_CD, ' ') NEXT_VVD" ).append("\n"); 
		query.append("     , NVL(VVD2.POL_CD, ' ') RELAY_POL_CD" ).append("\n"); 
		query.append("     , NVL(VVD2.POD_CD, ' ') RELAY_POD_CD" ).append("\n"); 
		query.append("     , REPLACE(NVL(CUST.CUST_NM, ' '), CHR(13)||CHR(10), ' ') CUST_NM" ).append("\n"); 
		query.append("     , NVL(DOC.PCK_QTY, 0) PCK_QTY" ).append("\n"); 
		query.append("     , NVL(DOC.PCK_TP_CD, ' ') PCK_TP_CD" ).append("\n"); 
		query.append("     , DECODE(DOC.WGT_UT_CD, 'LBS', ROUND(DOC.ACT_WGT*0.4536), ROUND(DOC.ACT_WGT)) ACT_WGT" ).append("\n"); 
		query.append("     , NVL(BKG.POL_CD, ' ') POL_CD" ).append("\n"); 
		query.append("     , NVL(BKG.POD_CD, ' ') POD_CD" ).append("\n"); 
		query.append("     , NVL(BKG.DEL_CD, ' ') DEL_CD" ).append("\n"); 
		query.append("     , NVL(DECODE(BKG.DCGO_FLG,'Y','Y'), ' ') DCGO_FLG" ).append("\n"); 
		query.append("     , NVL(DECODE(BKG.RC_FLG,'Y','Y'), ' ') RC_FLG" ).append("\n"); 
		query.append("     , NVL(DECODE(BKG.AWK_CGO_FLG,'Y','Y'), ' ') AWK_CGO_FLG" ).append("\n"); 
		query.append("     , NVL(DECODE(BKG.BB_CGO_FLG, 'Y','Y'), ' ') BB_CGO_FLG" ).append("\n"); 
		query.append("     , DOC.BDR_FLG BDR_FLG" ).append("\n"); 
		query.append("     , DOC.BDR_CNG_FLG BDR_CNG_FLG" ).append("\n"); 
		query.append("     , NVL(BKG.BKG_STS_CD, ' ') BKG_STS_CD" ).append("\n"); 
		query.append("     , NVL(SEQ.BKG_NO, ' ') BKG_NO" ).append("\n"); 
		query.append("     , NVL(DOC.WGT_UT_CD, ' ') WGT_UT_CD" ).append("\n"); 
		query.append("     , NVL(BKG.POR_CD, ' ') POR_CD" ).append("\n"); 
		query.append("     , DECODE(DOC.MEAS_UT_CD, 'CBF', (DOC.MEAS_QTY*0.0283), DOC.MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append("     , NVL(DOC.MEAS_UT_CD, ' ') MEAS_UT_CD" ).append("\n"); 
		query.append("     , NVL(BKG.BL_TP_CD, ' ') BL_TP_CD" ).append("\n"); 
		query.append("     , NVL(BKG.OB_SLS_OFC_CD, ' ') OB_SLS_OFC_CD" ).append("\n"); 
		query.append("     , NVL(BKG.RCV_TERM_CD, ' ') RCV_TERM_CD" ).append("\n"); 
		query.append("     , NVL(SEQ.MF_REF_NO, ' ') MF_REF_NO" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("     , BKG_BOOKING BKG" ).append("\n"); 
		query.append("     , BKG_CSTMS_KR_MF_SEQ_NO SEQ" ).append("\n"); 
		query.append("     , BKG_BL_DOC DOC" ).append("\n"); 
		query.append("     , BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("     , BKG_VVD VVD2" ).append("\n"); 
		query.append(" WHERE VVD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND VVD.POL_CD = @[pol]" ).append("\n"); 
		query.append("   AND VVD.POD_CD = @[pod]" ).append("\n"); 
		query.append("   AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("   AND DOC.BKG_NO = SEQ.BKG_NO" ).append("\n"); 
		query.append("   AND SEQ.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("   AND CUST.BKG_NO = VVD2.BKG_NO" ).append("\n"); 
		query.append("   AND CUST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND SEQ.MF_REF_NO = @[mrn_no]" ).append("\n"); 
		query.append("   AND VVD2.POL_CD = @[pod]" ).append("\n"); 
		query.append("#if(${bkg_no}!='') " ).append("\n"); 
		query.append("   AND SEQ.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SEQ.MRN_BL_TS_CD = @[mrn_mode]" ).append("\n"); 
		query.append("   AND VVD.POD_CD || SUBSTR(VVD.POD_YD_CD,6,2) = DECODE(TRIM(@[yard]), '', VVD.POD_CD, VVD.POD_CD||@[yard])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY BKG.BL_NO" ).append("\n"); 

	}
}