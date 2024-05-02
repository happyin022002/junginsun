/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsVesselArrivalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.19
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2012.03.19 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOsearchAncsCstmsVesselArrivalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOsearchAncsCstmsVesselArrivalRSQL(){
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
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsVesselArrivalRSQL").append("\n"); 
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
		query.append("SELECT C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD AS vvd, E.SSR_NO AS ssr_no,                           " ).append("\n"); 
		query.append("       DECODE (E.VSL_CD, NULL, 'L', E.LLOYD_TP_CD) AS lloyd_type,                                     " ).append("\n"); 
		query.append("       DECODE (E.VSL_CD, NULL, D.LLOYD_NO, E.LLOYD_NO) AS lloyd_no,                                   " ).append("\n"); 
		query.append("       DECODE (E.VSL_CD, NULL, D.VSL_RGST_CNT_CD, E.VSL_CNT_CD) AS vsl_flag,                          " ).append("\n"); 
		query.append("       DECODE (E.VSL_CD, NULL, D.VSL_ENG_NM, E.VVD_NM) AS vsl_name,                                   " ).append("\n"); 
		query.append("       -- e.dep_loc_cd AS prv_prot, DECODE (e.brth_desc, NULL, f.attr_ctnt1, e.brth_desc) AS berth_code, " ).append("\n"); 
		query.append("	   E.DEP_LOC_CD AS prv_prot, DECODE (E.BRTH_DESC, NULL, F.ATTR_CTNT2, E.BRTH_DESC) AS berth_code, " ).append("\n"); 
		query.append("       C.VPS_PORT_CD AS pod,                                                                          " ).append("\n"); 
		query.append("       TO_CHAR (DECODE (E.VSL_CD, NULL, C.VPS_ETA_DT, E.ETA_DT),                                      " ).append("\n"); 
		query.append("                'YYYY-MM-DD'                                                                          " ).append("\n"); 
		query.append("               ) AS eta_call_date,                                                                    " ).append("\n"); 
		query.append("       TO_CHAR (E.DEM_FREE_DT, 'YYYY-MM-DD') AS demdet_free_time,                                     " ).append("\n"); 
		query.append("       E.RMK AS remark, E.ANR_MSG_STS_CD AS crsrep,                                                   " ).append("\n"); 
		query.append("                                                                                                      " ).append("\n"); 
		query.append("--, E.EDI_STS_CD AS LAST_EDI                                                                          " ).append("\n"); 
		query.append("       E.EDI_STS_DESC AS last_edi, E.SND_USR_ID AS user_id,                                           " ).append("\n"); 
		query.append("       TO_CHAR (E.SND_DT, 'YYYY-MM-DD') AS user_date,                                                 " ).append("\n"); 
		query.append("       (SELECT COUNT (C.BKG_NO)                                                                       " ).append("\n"); 
		query.append("          FROM BKG_VVD C, BKG_BOOKING D                                                               " ).append("\n"); 
		query.append("         WHERE C.VSL_CD = SUBSTR (@[vvd], 1, 4)                                                       " ).append("\n"); 
		query.append("           AND C.SKD_VOY_NO = SUBSTR (@[vvd], 5, 4)                                                   " ).append("\n"); 
		query.append("           AND C.SKD_DIR_CD = SUBSTR (@[vvd], 9, 1)                                                   " ).append("\n"); 
		query.append("           AND C.POD_CD = @[pod]                                                                     " ).append("\n"); 
		query.append("           AND D.BKG_NO = C.BKG_NO                                                                    " ).append("\n"); 
		query.append("           AND D.BKG_STS_CD <> 'X'                                                                    " ).append("\n"); 
		query.append("           AND D.BKG_CGO_TP_CD IN ('F', 'B')) AS bkg_ttl,                                             " ).append("\n"); 
		query.append("       (SELECT COUNT (D.BKG_NO)                                                                       " ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ANR_BL D                                                                     " ).append("\n"); 
		query.append("         WHERE D.VSL_CD = SUBSTR (@[vvd], 1, 4)                                                       " ).append("\n"); 
		query.append("           AND D.SKD_VOY_NO = SUBSTR (@[vvd], 5, 4)                                                   " ).append("\n"); 
		query.append("           AND D.SKD_DIR_CD = SUBSTR (@[vvd], 9, 1)) AS dnld_ttl                                      " ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD C, MDM_VSL_CNTR D, " ).append("\n"); 
		query.append("       ( -- 전송 상태 및 VVD 정보가 이미 세관에 있을 것이라 가정하여 임시 VIEW를 만듬                          " ).append("\n"); 
		query.append("        SELECT A.VSL_CD AS vsl_cd, A.SKD_VOY_NO AS skd_voy_no,                                        " ).append("\n"); 
		query.append("               A.SKD_DIR_CD AS skd_dir_cd, A.SVC_RQST_NO AS ssr_no,                                   " ).append("\n"); 
		query.append("               A.LLOYD_TP_CD AS lloyd_tp_cd, A.LLOYD_NO AS lloyd_no,                                  " ).append("\n"); 
		query.append("               A.VSL_CNT_CD AS vsl_cnt_cd, A.VVD_NM AS vvd_nm,                                        " ).append("\n"); 
		query.append("               A.DEP_LOC_CD AS dep_loc_cd, A.BRTH_DESC AS brth_desc,                                  " ).append("\n"); 
		query.append("               A.ETA_DT AS eta_dt, A.DIFF_RMK AS rmk,                                                 " ).append("\n"); 
		query.append("               A.ANR_MSG_STS_CD AS anr_msg_sts_cd,                                                    " ).append("\n"); 
		query.append("               A.DEM_FREE_DT AS dem_free_dt,                                                          " ).append("\n"); 
		query.append("                  NVL (B.EDI_SND_STS_CD, 'N')                                                         " ).append("\n"); 
		query.append("               || NVL (B.EDI_RCV_STS_CD, 'N') AS edi_sts_cd,                                          " ).append("\n"); 
		query.append("               C.ATTR_CTNT2 AS edi_sts_desc, B.EDI_SND_USR_ID AS snd_usr_id,                          " ).append("\n"); 
		query.append("               B.SND_OFC_CD AS snd_ofc_cd, B.SND_DT AS snd_dt                                         " ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ANR_VVD A,                                                                   " ).append("\n"); 
		query.append("               BKG_CSTMS_ANR_EDI_HIS B,                                                               " ).append("\n"); 
		query.append("               BKG_HRD_CDG_CTNT C                                                                     " ).append("\n"); 
		query.append("         WHERE A.VSL_CD = SUBSTR (@[vvd], 1, 4)                                                       " ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = SUBSTR (@[vvd], 5, 4)                                                   " ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = SUBSTR (@[vvd], 9, 1)                                                   " ).append("\n"); 
		query.append("           AND B.MSG_TP_CD(+) = 'R'                                                                      " ).append("\n"); 
		query.append("           AND B.ANR_DECL_NO(+) = A.SVC_RQST_NO || A.LLOYD_TP_CD || A.LLOYD_NO                           " ).append("\n"); 
		query.append("           AND ( B.REF_SEQ =                                                                            " ).append("\n"); 
		query.append("                  (SELECT MAX (C.REF_SEQ)                                                             " ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_ANR_EDI_HIS C                                                     " ).append("\n"); 
		query.append("                    WHERE C.MSG_TP_CD = B.MSG_TP_CD                                                   " ).append("\n"); 
		query.append("                      AND C.ANR_DECL_NO = B.ANR_DECL_NO) OR B.REF_SEQ IS NULL )                                              " ).append("\n"); 
		query.append("           AND C.HRD_CDG_ID(+) = 'ANR_CSTMS_EDI_STS_CD'                                               " ).append("\n"); 
		query.append("           AND C.ATTR_CTNT1(+) =                                                                      " ).append("\n"); 
		query.append("                     NVL (B.EDI_SND_STS_CD, 'N')                                                      " ).append("\n"); 
		query.append("                     || NVL (B.EDI_RCV_STS_CD, 'N') ) E, " ).append("\n"); 
		query.append("       BKG_HRD_CDG_CTNT F                          " ).append("\n"); 
		query.append(" WHERE C.VSL_CD = SUBSTR (@[vvd], 1, 4)                                                               " ).append("\n"); 
		query.append("   AND C.SKD_VOY_NO = SUBSTR (@[vvd], 5, 4)                                                           " ).append("\n"); 
		query.append("   AND C.SKD_DIR_CD = SUBSTR (@[vvd], 9, 1)                                                           " ).append("\n"); 
		query.append("   AND C.VPS_PORT_CD = @[pod]                                                                        " ).append("\n"); 
		query.append("   AND C.CLPT_IND_SEQ = '1'                                                                           " ).append("\n"); 
		query.append("   AND D.VSL_CD = C.VSL_CD                                                                            " ).append("\n"); 
		query.append("   AND E.VSL_CD(+) = C.VSL_CD                                                                         " ).append("\n"); 
		query.append("   AND E.SKD_VOY_NO(+) = C.SKD_VOY_NO                                                                 " ).append("\n"); 
		query.append("   AND E.SKD_DIR_CD(+) = C.SKD_DIR_CD                                                                 " ).append("\n"); 
		query.append("   AND F.HRD_CDG_ID(+) = 'ANR_CSTMS_BRTH_CD'                                                          " ).append("\n"); 
		query.append("   AND F.ATTR_CTNT3(+) = C.YD_CD" ).append("\n"); 

	}
}