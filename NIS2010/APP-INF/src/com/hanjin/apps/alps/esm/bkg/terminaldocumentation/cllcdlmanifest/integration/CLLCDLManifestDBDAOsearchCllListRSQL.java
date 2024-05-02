/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllList
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_split_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_local_ts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllListRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("	C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD VVD_CD, " ).append("\n"); 
		query.append("	C.PORT_CD, " ).append("\n"); 
		query.append("	C.CNTR_LODG_NO," ).append("\n"); 
		query.append("	TO_CHAR(C.ETA_DT,'YYYY-MM-DD HH24:MI') ETA_DT, " ).append("\n"); 
		query.append("	TO_CHAR(C.ETD_DT,'YYYY-MM-DD HH24:MI') ETD_DT," ).append("\n"); 
		query.append("	C.BKG_NO," ).append("\n"); 
		query.append("	C.BKG_NO BKG_NO2," ).append("\n"); 
		query.append("	C.CNTR_NO," ).append("\n"); 
		query.append("	C.TS_CGO_CD," ).append("\n"); 
		query.append("	C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	C.POR_CD," ).append("\n"); 
		query.append("	C.POL_CD," ).append("\n"); 
		query.append("	C.POD_CD," ).append("\n"); 
		query.append("	C.DEL_CD," ).append("\n"); 
		query.append("	C.SOC_FLG," ).append("\n"); 
		query.append("	C.FULL_MTY_CD," ).append("\n"); 
		query.append("	C.RCV_TERM_CD||C.DE_TERM_CD RCV_DE_TERM_CD," ).append("\n"); 
		query.append("	C.CNTR_SEAL_NO," ).append("\n"); 
		query.append("	C.CNTR_WGT," ).append("\n"); 
		query.append("	C.WGT_TP_CD," ).append("\n"); 
		query.append("	C.CFM_FLG, " ).append("\n"); 
		query.append("	C.TEU_CNTR_QTY, " ).append("\n"); 
		query.append("	C.FEU_CNTR_QTY," ).append("\n"); 
		query.append("	C.RC_FLG, " ).append("\n"); 
		query.append("	C.DCGO_FLG, " ).append("\n"); 
		query.append("	C.AWK_CGO_FLG, " ).append("\n"); 
		query.append("	C.BB_CGO_FLG, " ).append("\n"); 
		query.append("	C.RD_CGO_FLG," ).append("\n"); 
		query.append("	substr(BL_RMK,1,10) BL_RMK, " ).append("\n"); 
		query.append("	C.EDI_RCV_STS_CD, " ).append("\n"); 
		query.append("	C.UPD_USR_ID," ).append("\n"); 
		query.append("	'' IN_VVD_CD," ).append("\n"); 
		query.append("	'' IN_POL_CD," ).append("\n"); 
		query.append("	'' UPD_USR_ID," ).append("\n"); 
		query.append("	C.PCK_QTY," ).append("\n"); 
		query.append("	C.PCK_TP_CD," ).append("\n"); 
		query.append("	C.WGT_TP_CD," ).append("\n"); 
		query.append("	C.CNTR_WGT," ).append("\n"); 
		query.append("	C.GRS_CNTR_WGT," ).append("\n"); 
		query.append("	C.GRS_WGT_UT_CD," ).append("\n"); 
		query.append("	C.MEAS_QTY," ).append("\n"); 
		query.append("	C.CNTR_MEAS_UT_CD," ).append("\n"); 
		query.append("	C.OVR_FWRD_LEN," ).append("\n"); 
		query.append("	C.OVR_BKWD_LEN," ).append("\n"); 
		query.append("	C.OVR_HGT," ).append("\n"); 
		query.append("	C.OVR_PORT_LEN," ).append("\n"); 
		query.append("	C.OVR_SD_LEN," ).append("\n"); 
		query.append("	C.OVR_WGT_UT_CD," ).append("\n"); 
		query.append("	C.OVR_CNTR_WGT," ).append("\n"); 
		query.append("	C.FDO_TEMP," ).append("\n"); 
		query.append("	C.CDO_TEMP," ).append("\n"); 
		query.append("	C.CNTR_VENT_RTO," ).append("\n"); 
		query.append("	(SELECT COUNT(DISTINCT C.CNTR_NO)" ).append("\n"); 
		query.append("	FROM	BKG_CSTMS_TML_CLL C, BKG_BOOKING B" ).append("\n"); 
		query.append("	WHERE	C.VSL_CD		= SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	AND	C.SKD_VOY_NO		= SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	AND	C.SKD_DIR_CD		= SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	AND	C.PORT_CD			= @[in_pol_cd]	" ).append("\n"); 
		query.append("	#if (${in_pol_split_no} != '')" ).append("\n"); 
		query.append("	AND NVL(C.CLPT_IND_SEQ,'1') = @[in_pol_split_no] -- Add. 2015.02.09. CHM-201533845 " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND	C.TS_CGO_CD		LIKE @[in_local_ts]||'%'" ).append("\n"); 
		query.append("	AND	C.UPD_USR_ID		LIKE @[in_usr_id]||'%'" ).append("\n"); 
		query.append("	AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("-- LOCAL ALL TS VGM" ).append("\n"); 
		query.append("#if (${local_type} =='' && ${ts_type} =='Y' )" ).append("\n"); 
		query.append("AND (( C.TS_CGO_CD = 'L') OR ( C.TS_CGO_CD = 'T'  AND (C.VGM_WGT > 0 OR B.BKG_CGO_TP_CD IN('P', 'B')) ))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- LOCAL VGM TS ALL" ).append("\n"); 
		query.append("#elseif (${local_type} =='Y' && ${ts_type} =='' )" ).append("\n"); 
		query.append("AND ( ( C.TS_CGO_CD = 'L' AND (C.VGM_WGT > 0 OR B.BKG_CGO_TP_CD IN('P', 'B')) ) OR ( C.TS_CGO_CD = 'T' ) )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- LOCAL VGM TS VGM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${local_type} =='Y' && ${ts_type} =='Y' )" ).append("\n"); 
		query.append("AND C.TS_CGO_CD IN ('T','L') AND (C.VGM_WGT > 0 OR B.BKG_CGO_TP_CD IN('P', 'B'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") CNTR_COUNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	(SELECT COUNT(DISTINCT C.BKG_NO)" ).append("\n"); 
		query.append("	FROM	BKG_CSTMS_TML_CLL C, BKG_BOOKING B" ).append("\n"); 
		query.append("	WHERE	C.VSL_CD		= SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	AND	C.SKD_VOY_NO		= SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	AND	C.SKD_DIR_CD		= SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	AND	C.PORT_CD			= @[in_pol_cd]" ).append("\n"); 
		query.append("	#if (${in_pol_split_no} != '')" ).append("\n"); 
		query.append("	AND NVL(C.CLPT_IND_SEQ,'1') = @[in_pol_split_no] -- Add. 2015.02.09. CHM-201533845 " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND	C.TS_CGO_CD		LIKE @[in_local_ts]||'%'" ).append("\n"); 
		query.append("	AND	C.UPD_USR_ID		LIKE @[in_usr_id]||'%'" ).append("\n"); 
		query.append("	AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- LOCAL ALL TS VGM" ).append("\n"); 
		query.append("#if (${local_type} =='' && ${ts_type} =='Y' )" ).append("\n"); 
		query.append("AND (( C.TS_CGO_CD = 'L') OR ( C.TS_CGO_CD = 'T'  AND (C.VGM_WGT > 0 OR B.BKG_CGO_TP_CD IN('P', 'B')) ))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- LOCAL VGM TS ALL" ).append("\n"); 
		query.append("#elseif (${local_type} =='Y' && ${ts_type} =='' )" ).append("\n"); 
		query.append("AND ( ( C.TS_CGO_CD = 'L' AND (C.VGM_WGT > 0 OR B.BKG_CGO_TP_CD IN('P', 'B')) ) OR ( C.TS_CGO_CD = 'T' ) )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- LOCAL VGM TS VGM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${local_type} =='Y' && ${ts_type} =='Y' )" ).append("\n"); 
		query.append("AND C.TS_CGO_CD IN ('T','L') AND (C.VGM_WGT > 0 OR B.BKG_CGO_TP_CD IN('P', 'B'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	) BKG_COUNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   (SELECT BKG.BLCK_STWG_CD" ).append("\n"); 
		query.append("     FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("    WHERE BKG.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("      AND ROWNUM=1) AS BLCK_STWG_CD," ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	C.VGM_WGT," ).append("\n"); 
		query.append("    'KGS' VGM_WGT_UT_CD ," ).append("\n"); 
		query.append("    C.VGM_MZD_TP_CD ," ).append("\n"); 
		query.append("    C.VGM_VRFY_SIG_CTNT " ).append("\n"); 
		query.append("FROM	BKG_CSTMS_TML_CLL C, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("  (	  C.VSL_CD		= SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      AND	C.SKD_VOY_NO		= SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND	C.SKD_DIR_CD		= SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND	C.PORT_CD			= @[in_pol_cd]" ).append("\n"); 
		query.append("#if (${in_pol_split_no} != '')" ).append("\n"); 
		query.append("AND NVL(C.CLPT_IND_SEQ,'1') = @[in_pol_split_no] -- Add. 2015.02.09. CHM-201533845 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	C.TS_CGO_CD		LIKE @[in_local_ts]||'%'" ).append("\n"); 
		query.append("AND	C.UPD_USR_ID		LIKE @[in_usr_id]||'%'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR	" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("C.VSL_CD		= SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND	C.SKD_VOY_NO		= SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND	C.SKD_DIR_CD		= SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND	C.PORT_CD			= @[in_pol_cd]" ).append("\n"); 
		query.append("#if (${in_pol_split_no} != '')" ).append("\n"); 
		query.append("AND NVL(CLPT_IND_SEQ,'1') = @[in_pol_split_no] -- Add. 2015.02.09. CHM-201533845 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	C.EDI_RCV_STS_CD		= 'I'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- LOCAL ALL TS VGM" ).append("\n"); 
		query.append("#if (${local_type} =='' && ${ts_type} =='Y' )" ).append("\n"); 
		query.append("AND (( C.TS_CGO_CD = 'L') OR ( C.TS_CGO_CD = 'T'  AND (C.VGM_WGT > 0 OR B.BKG_CGO_TP_CD IN ('P','B')) ))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- LOCAL VGM TS ALL" ).append("\n"); 
		query.append("#elseif (${local_type} =='Y' && ${ts_type} =='' )" ).append("\n"); 
		query.append("AND ( ( C.TS_CGO_CD = 'L' AND (C.VGM_WGT > 0 OR B.BKG_CGO_TP_CD IN ('P', 'B')) ) OR ( C.TS_CGO_CD = 'T' ) )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- LOCAL VGM TS VGM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${local_type} =='Y' && ${ts_type} =='Y' )" ).append("\n"); 
		query.append("AND C.TS_CGO_CD IN ('T','L') AND (C.VGM_WGT > 0 OR B.BKG_CGO_TP_CD IN ('P','B'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY C.BKG_NO, C.CNTR_NO" ).append("\n"); 

	}
}