/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchMfsDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchMfsDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMfsDetail
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchMfsDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchMfsDetailRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    NVL(A.BL_NO,' ')||NVL(A.BL_SPLIT_NO,'  ') BL_NUMBER," ).append("\n"); 
		query.append("	NVL(A.BL_NO,' ')||NVL(A.BL_SPLIT_NO,'  ') BL_NUMBER2," ).append("\n"); 
		query.append("    NVL(A.POL_CD,' ') POL_CD,     " ).append("\n"); 
		query.append("	NVL(A.BKG_DEL_CD,' ') BKG_DEL_CD," ).append("\n"); 
		query.append("    DECODE(A.PCK_QTY,NULL,'N',0,'N','Y') PCK_QTY," ).append("\n"); 
		query.append("    DECODE(A.PCK_TP_CD,NULL,'N','Y') PCK_TP_CD," ).append("\n"); 
		query.append("    DECODE(A.GRS_WGT,NULL,'N',0,'N','Y') GRS_WGT," ).append("\n"); 
		query.append("    DECODE(A.WGT_UT_CD,NULL,'N','Y') WGT_UT_CD," ).append("\n"); 
		query.append("    DECODE(A.MEAS_QTY,NULL,'N',0,'N','Y') MEAS_QTY," ).append("\n"); 
		query.append("    DECODE(A.MEAS_UT_CD,NULL,'N','Y') MEAS_UT_CD," ).append("\n"); 
		query.append("    DECODE(LENGTH(RTRIM(C1.CUST_NM)),NULL,'N','Y') CUST_NM, " ).append("\n"); 
		query.append("    DECODE(LENGTH(RTRIM(C1.CUST_ADDR)),NULL,'N','Y') CUST_ADDR," ).append("\n"); 
		query.append("    DECODE(LENGTH(RTRIM(C2.CUST_NM)),NULL,'N','Y') CUST_NM2, " ).append("\n"); 
		query.append("    DECODE(LENGTH(RTRIM(C2.CUST_ADDR)),NULL,'N','Y') CUST_ADDR2," ).append("\n"); 
		query.append("    DECODE(LENGTH(RTRIM(C3.CUST_NM)),NULL,'N','Y') CUST_NM3, " ).append("\n"); 
		query.append("    DECODE(LENGTH(RTRIM(C3.CUST_ADDR)),NULL,'N','Y') CUST_ADDR3," ).append("\n"); 
		query.append("    DECODE(LENGTH(RTRIM(D.DIFF_RMK)),NULL,'N','Y') DIFF_RMK, " ).append("\n"); 
		query.append("    DECODE(LENGTH(RTRIM(D.BL_DESC)),NULL,'N','Y') BL_DESC," ).append("\n"); 
		query.append("    NVL(B.CNTR_NO,' ') CNTR_NO,    " ).append("\n"); 
		query.append("    DECODE(LENGTH(RTRIM(B.CNTR_SEAL_NO)),NULL,'N','Y') CNTR_SEAL_NO," ).append("\n"); 
		query.append("    NVL(A.LOCL_TS_IND_CD,' ') LOCL_TS_FLG," ).append("\n"); 
		query.append("    NVL(A.PST_VSL_CD||A.PST_SKD_VOY_NO||A.PST_SKD_DIR_CD,' ') PST_VSL_CD,  " ).append("\n"); 
		query.append("	NVL(A.PST_RLY_POD_CD,' ') PST_RLY_POD_CD," ).append("\n"); 
		query.append("    NVL(A.FULL_MTY_CD,' ') FULL_MTY_CD,   " ).append("\n"); 
		query.append("	NVL(A.CY_OPR_ID,' ') CY_OPR_CD," ).append("\n"); 
		query.append("	NVL(@[in_call_sgn_no], ' ') CALL_SGN_NO," ).append("\n"); 
		query.append("	NVL(TO_CHAR(TO_DATE(@[in_eta_dt],'YYYY-MM-dd'),'YYYY-MM-DD'), ' ') ETA_DT," ).append("\n"); 
		query.append("	'' SEQ," ).append("\n"); 
		query.append("    NVL(A.JP_TML_VSL_NO,DECODE((SELECT DECODE(NVL(A.ACT_CRR_CD, B.CRR_CD),'SML','Y','N') CRR_CD" ).append("\n"); 
		query.append("								  FROM VSK_VSL_SKD A, MDM_VSL_CNTR B" ).append("\n"); 
		query.append("								 WHERE 1=1" ).append("\n"); 
		query.append("								   AND A.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("								   AND A.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append(" 								   AND A.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("								   AND A.VSL_CD = B.VSL_CD ),'Y',SUBSTR(@[in_vvd_cd],5,5),' ')) JP_TML_VSL_NO," ).append("\n"); 
		query.append("    DECODE(LENGTH(RTRIM(C1.PHN_NO)),NULL,'N','Y') PHN_NO," ).append("\n"); 
		query.append("    DECODE(LENGTH(RTRIM(C2.PHN_NO)),NULL,'N','Y') PHN_NO2," ).append("\n"); 
		query.append("    DECODE(LENGTH(RTRIM(C3.PHN_NO)),NULL,'N','Y') PHN_NO3," ).append("\n"); 
		query.append("    DECODE(C1.PHN_NO, (SELECT OFC_PHN_NO" ).append("\n"); 
		query.append("					     FROM MDM_LOCATION ML, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("					    WHERE ML.EQ_CTRL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("					      AND ML.LOC_CD         = @[in_pod_cd]), 'D', '', 'N', 'B') AS VIA," ).append("\n"); 
		query.append("    DECODE(C2.PHN_NO, (SELECT OFC_PHN_NO" ).append("\n"); 
		query.append("					     FROM MDM_LOCATION ML, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("					    WHERE ML.EQ_CTRL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("					      AND ML.LOC_CD         = @[in_pod_cd]), 'D', '', 'N', 'B') AS VIA2," ).append("\n"); 
		query.append("    DECODE(C3.PHN_NO, (SELECT OFC_PHN_NO" ).append("\n"); 
		query.append("					     FROM MDM_LOCATION ML, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("					    WHERE ML.EQ_CTRL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("					      AND ML.LOC_CD         = @[in_pod_cd]), 'D', '', 'N', 'B') AS VIA3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL A, " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL_CNTR B, " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL_MK D," ).append("\n"); 
		query.append("  	BKG_CSTMS_JP_BL_CUST C1, " ).append("\n"); 
		query.append("  	BKG_CSTMS_JP_BL_CUST C2, " ).append("\n"); 
		query.append("  	BKG_CSTMS_JP_BL_CUST C3" ).append("\n"); 
		query.append("WHERE A.VSL_CD         = @[in_vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO  = @[in_skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD     = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("#if (${in_pol_cd}!= '') " ).append("\n"); 
		query.append("AND A.POL_CD        = @[in_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.POD_CD        = @[in_pod_cd]" ).append("\n"); 
		query.append("AND A.JP_BL_STS_CD      = 'A'" ).append("\n"); 
		query.append("AND A.BL_NO          = B.BL_NO(+)" ).append("\n"); 
		query.append("AND A.BL_SPLIT_NO    = B.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("AND B.JP_CSTMS_CNTR_STS_CD(+)   = 'A'" ).append("\n"); 
		query.append("AND A.BL_NO          = D.BL_NO(+)" ).append("\n"); 
		query.append("AND A.BL_SPLIT_NO    = D.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("AND D.BL_SEQ(+) = 1" ).append("\n"); 
		query.append("AND A.BL_NO          = C1.BL_NO(+)" ).append("\n"); 
		query.append("AND A.BL_SPLIT_NO    = C1.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("AND C1.BKG_CUST_TP_CD(+)        = 'S'" ).append("\n"); 
		query.append("AND A.BL_NO          = C2.BL_NO(+)" ).append("\n"); 
		query.append("AND A.BL_SPLIT_NO    = C2.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("AND C2.BKG_CUST_TP_CD(+)     = 'C'" ).append("\n"); 
		query.append("AND A.BL_NO          = C3.BL_NO(+)" ).append("\n"); 
		query.append("AND A.BL_SPLIT_NO    = C3.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("AND C3.BKG_CUST_TP_CD(+)     = 'N'" ).append("\n"); 
		query.append("#if (${in_err_gb} == 'E') 	" ).append("\n"); 
		query.append("AND ( DECODE(A.PCK_QTY,NULL,'N',0,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(A.PCK_TP_CD,NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(A.GRS_WGT,NULL,'N',0,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(A.WGT_UT_CD,NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(A.MEAS_QTY,NULL,'N',0,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(A.MEAS_UT_CD,NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(C1.CUST_NM)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(C1.CUST_ADDR)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(C2.CUST_NM)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(C2.CUST_ADDR)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(C3.CUST_NM)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(C3.CUST_ADDR)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(B.CNTR_NO)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(B.CNTR_SEAL_NO)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(D.DIFF_RMK)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(D.BL_DESC)),NULL,'N','Y') = 'N' " ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(C1.PHN_NO)),NULL,'N','Y') = 'N' " ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(C2.PHN_NO)),NULL,'N','Y') = 'N' " ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(C3.PHN_NO)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(LENGTH(RTRIM(C3.PHN_NO)),NULL,'N','Y') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(C1.PHN_NO, (SELECT OFC_PHN_NO" ).append("\n"); 
		query.append("					       FROM MDM_LOCATION ML, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("					      WHERE ML.EQ_CTRL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("					        AND ML.LOC_CD         = @[in_pod_cd]), 'D', '', 'N', 'B') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(C2.PHN_NO, (SELECT OFC_PHN_NO" ).append("\n"); 
		query.append("					       FROM MDM_LOCATION ML, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("					      WHERE ML.EQ_CTRL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("					        AND ML.LOC_CD         = @[in_pod_cd]), 'D', '', 'N', 'B') = 'N'" ).append("\n"); 
		query.append("OR    DECODE(C3.PHN_NO, (SELECT OFC_PHN_NO" ).append("\n"); 
		query.append("					       FROM MDM_LOCATION ML, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("					      WHERE ML.EQ_CTRL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("					        AND ML.LOC_CD         = @[in_pod_cd]), 'D', '', 'N', 'B') = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_bl_type}== '1') " ).append("\n"); 
		query.append("AND A.LOCL_TS_IND_CD     <> 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_bl_type}== '2') " ).append("\n"); 
		query.append("AND A.LOCL_TS_IND_CD     = 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.BL_NO||A.BL_SPLIT_NO" ).append("\n"); 

	}
}