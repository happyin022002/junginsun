/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CIMCommonDBDAOSearchMovementEdiErrListByContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.06.16 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOSearchMovementEdiErrListByContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Movement History EDI Error 조회
	  * </pre>
	  */
	public CIMCommonDBDAOSearchMovementEdiErrListByContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_event_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_event_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_digit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOSearchMovementEdiErrListByContainerRSQL").append("\n"); 
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
		query.append("AS (SELECT  @[p_cntrno]||@[check_digit] AS CNTR_NO FROM DUAL)" ).append("\n"); 
		query.append("SELECT CNTR_NO				" ).append("\n"); 
		query.append("        , INP_DT" ).append("\n"); 
		query.append("        , INP_TP_CD" ).append("\n"); 
		query.append("        , STATUS" ).append("\n"); 
		query.append("        , MVMT_STS_CD" ).append("\n"); 
		query.append("        , MVMT_CRE_TP_CD" ).append("\n"); 
		query.append("        , ORG_YD_CD" ).append("\n"); 
		query.append("        , CNMV_EVNT_DT" ).append("\n"); 
		query.append("        , CNMV_CYC_NO" ).append("\n"); 
		query.append("        , BKG_NO" ).append("\n"); 
		query.append("        , EDI_BKG_NO" ).append("\n"); 
		query.append("        , OSCA_BKG_FLG" ).append("\n"); 
		query.append("        , VVD_CD" ).append("\n"); 
		query.append("        , REF_NO" ).append("\n"); 
		query.append("        , FCNTR_FLG" ).append("\n"); 
		query.append("        , OB_CNTR_FLG" ).append("\n"); 
		query.append("        , BKG_CGO_TP_CD" ).append("\n"); 
		query.append("        , CNTR_SEAL_NO" ).append("\n"); 
		query.append("        , EDI_GATE_IO_CD" ).append("\n"); 
		query.append("        , CNTR_FULL_STS_CD" ).append("\n"); 
		query.append("        , MVMT_EDI_SGHT_CD" ).append("\n"); 
		query.append("        , CALL_SGN_NO" ).append("\n"); 
		query.append("        , RTY_KNT" ).append("\n"); 
		query.append("        , MVMT_EDI_RMK " ).append("\n"); 
		query.append("		, VNDR_SEQ" ).append("\n"); 
		query.append("        , BKG_KNT" ).append("\n"); 
		query.append("        , CNTR_DMG_FLG" ).append("\n"); 
		query.append("        , CHSS_NO" ).append("\n"); 
		query.append("        , MGST_NO" ).append("\n"); 
		query.append("        , DEST_YD_CD" ).append("\n"); 
		query.append("        , LLOYD_NO" ).append("\n"); 
		query.append("        , WO_NO" ).append("\n"); 
		query.append("        , EDI_VVD_CD" ).append("\n"); 
		query.append("        , TIR_NO" ).append("\n"); 
		query.append("        , MTY_PLN_NO" ).append("\n"); 
		query.append("        , MTY_REPO_NO" ).append("\n"); 
		query.append("        , EDI_CRR_NO" ).append("\n"); 
		query.append("        , TRSP_DOC_NO" ).append("\n"); 
		query.append("		, CRNT_VSL_CD" ).append("\n"); 
		query.append("        , CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("        , CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("        , CNMV_RMK        " ).append("\n"); 
		query.append("        , MVMT_EDI_MSG_AREA_CD  " ).append("\n"); 
		query.append("        , MVMT_EDI_MSG_SEQ      " ).append("\n"); 
		query.append("        , MVMT_EDI_MSG_TP_ID    " ).append("\n"); 
		query.append("        , MVMT_EDI_MSG_YRMONDY  " ).append("\n"); 
		query.append("        , MVMT_EDI_TP_CD   " ).append("\n"); 
		query.append("		, MVMT_TRSP_MOD_CD" ).append("\n"); 
		query.append("        , OFC_CD" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , CRE_USR_ID   " ).append("\n"); 
		query.append("		, CHK_FLG" ).append("\n"); 
		query.append("		, USR_NM" ).append("\n"); 
		query.append("		, CNMV_YR" ).append("\n"); 
		query.append("		, CNMV_SEQ" ).append("\n"); 
		query.append("		, CNMV_ID_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("            SELECT  CM.CNTR_NO" ).append("\n"); 
		query.append("                    ,  TO_CHAR(NVL(EM.CRE_LOCL_DT, CM.CRE_LOCL_DT), 'YYYY-MM-DD HH24:MI') AS INP_DT" ).append("\n"); 
		query.append("                    ,  DECODE(CM.MVMT_CRE_TP_CD, 'A', 'AUTO'" ).append("\n"); 
		query.append("                    	,  DECODE(CM.MVMT_INP_TP_CD, 'MAN', 'MANUAL'" ).append("\n"); 
		query.append("                    		,  DECODE(CM.MVMT_CRE_TP_CD, 'A', ''" ).append("\n"); 
		query.append("								, DECODE(CM.MVMT_EDI_TP_CD, 'A1', '322', SUBSTR(EM.FLT_FILE_REF_NO, 1, 3))" ).append("\n"); 
		query.append("									  )" ).append("\n"); 
		query.append("                              	  )" ).append("\n"); 
		query.append("                              ) AS INP_TP_CD " ).append("\n"); 
		query.append("                    ,  'O.K' AS STATUS" ).append("\n"); 
		query.append("                    ,  CM.MVMT_STS_CD" ).append("\n"); 
		query.append("                    ,  CM.MVMT_CRE_TP_CD           " ).append("\n"); 
		query.append("                    ,  CM.ORG_YD_CD" ).append("\n"); 
		query.append("                    ,  TO_CHAR (CM.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("                    ,  CM.CNMV_CYC_NO AS CNMV_CYC_NO" ).append("\n"); 
		query.append("                    ,  CM.BKG_NO" ).append("\n"); 
		query.append("                    ,  NULL AS EDI_BKG_NO" ).append("\n"); 
		query.append("                    ,  CM.OSCA_BKG_FLG        " ).append("\n"); 
		query.append("                    ,  CM.CRNT_VSL_CD||CM.CRNT_SKD_VOY_NO||CM.CRNT_SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("                    ,  CM.MTY_PLN_NO AS REF_NO    " ).append("\n"); 
		query.append("                    ,  CM.FCNTR_FLG" ).append("\n"); 
		query.append("                    ,  CM.OB_CNTR_FLG" ).append("\n"); 
		query.append("                    ,  CM.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                    ,  TRIM (CM.CNTR_SEAL_NO) AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("                    , EM.EDI_GATE_IO_CD" ).append("\n"); 
		query.append("                    , EM.CNTR_FULL_STS_CD" ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_SGHT_CD" ).append("\n"); 
		query.append("                    , EM.CALL_SGN_NO" ).append("\n"); 
		query.append("                    , EM.RTY_KNT" ).append("\n"); 
		query.append("                    ,  EM.MVMT_EDI_RMK  AS MVMT_EDI_RMK                   " ).append("\n"); 
		query.append("                    , TO_CHAR(CM.CNMV_EVNT_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                     ||TO_CHAR(CM.CNMV_YR, '0000')" ).append("\n"); 
		query.append("                     ||TO_CHAR(CM.CNMV_SEQ, '0000')" ).append("\n"); 
		query.append("                     ||NVL(CM.CNMV_SPLIT_NO, 'XX') AS SORT_KEY" ).append("\n"); 
		query.append("					, EM.VNDR_SEQ" ).append("\n"); 
		query.append("                    , EM.BKG_KNT" ).append("\n"); 
		query.append("                    , EM.CNTR_DMG_FLG" ).append("\n"); 
		query.append("                    , EM.CHSS_NO" ).append("\n"); 
		query.append("                    , EM.MGST_NO" ).append("\n"); 
		query.append("                    , EM.DEST_YD_CD" ).append("\n"); 
		query.append("                    , EM.LLOYD_NO" ).append("\n"); 
		query.append("                    , EM.WO_NO" ).append("\n"); 
		query.append("                    , EM.EDI_VVD_CD" ).append("\n"); 
		query.append("                    , EM.TIR_NO" ).append("\n"); 
		query.append("                    , EM.MTY_PLN_NO" ).append("\n"); 
		query.append("                    , EM.MTY_REPO_NO" ).append("\n"); 
		query.append("                    , EM.EDI_CRR_NO" ).append("\n"); 
		query.append("                    , EM.TRSP_DOC_NO             " ).append("\n"); 
		query.append("					, EM.CRNT_VSL_CD" ).append("\n"); 
		query.append("                    , EM.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("                    , EM.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("                    , EM.CNMV_RMK                    " ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_MSG_AREA_CD  " ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_MSG_SEQ      " ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_MSG_TP_ID    " ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_MSG_YRMONDY  " ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_TP_CD   " ).append("\n"); 
		query.append("					, EM.MVMT_TRSP_MOD_CD" ).append("\n"); 
		query.append("                    , CM.OFC_CD" ).append("\n"); 
		query.append("                    , CM.UPD_USR_ID" ).append("\n"); 
		query.append("                    , CM.CRE_USR_ID" ).append("\n"); 
		query.append("					, 'N' AS CHK_FLG" ).append("\n"); 
		query.append("					, TRIM(CM.USR_NM) AS USR_NM" ).append("\n"); 
		query.append("					, CM.CNMV_YR" ).append("\n"); 
		query.append("					, CM.CNMV_SEQ" ).append("\n"); 
		query.append("					, CM.CNMV_ID_NO" ).append("\n"); 
		query.append("            FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("                  , CTM_MVMT_EDI_MSG EM" ).append("\n"); 
		query.append("                  , PARAM P" ).append("\n"); 
		query.append("            WHERE CM.CNTR_NO = EM.CNTR_NO(+)" ).append("\n"); 
		query.append("            AND    CM.MVMT_EDI_MSG_YRMONDY = EM.MVMT_EDI_MSG_YRMONDY(+)" ).append("\n"); 
		query.append("            AND    CM.MVMT_EDI_MSG_SEQ     = EM.MVMT_EDI_MSG_SEQ(+)" ).append("\n"); 
		query.append("            AND    P.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("			AND     CM.CNMV_EVNT_DT BETWEEN TO_DATE(REPLACE (@[s_event_date1], '-', ''),'YYYYMMDD') AND TO_DATE(REPLACE (@[s_event_date2], '-', ''), 'YYYYMMDD')+ 0.99999" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT  EM.CNTR_NO" ).append("\n"); 
		query.append("                    ,  TO_CHAR (EM.CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS INP_DT" ).append("\n"); 
		query.append("                    ,  SUBSTR(EM.FLT_FILE_REF_NO, 1, 3) AS INP_TP_CD " ).append("\n"); 
		query.append("                    ,  'ERROR' AS STATUS" ).append("\n"); 
		query.append("                    ,  EM.EDI_MVMT_STS_CD" ).append("\n"); 
		query.append("                    ,  NULL  AS MVMT_CRE_TP_CD           " ).append("\n"); 
		query.append("                    ,  EM.EVNT_YD_CD AS ORG_YD_CD" ).append("\n"); 
		query.append("                    ,  TO_CHAR (EM.EVNT_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("                    ,  NULL AS CNMV_CYC_NO" ).append("\n"); 
		query.append("                    ,  EM.BKG_NO" ).append("\n"); 
		query.append("                    ,  EM.EDI_BKG_NO" ).append("\n"); 
		query.append("                    ,  EM.OSCA_BKG_FLG        " ).append("\n"); 
		query.append("                    ,  EM.CRNT_VSL_CD||EM.CRNT_SKD_VOY_NO||EM.CRNT_SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("                    ,  EM.MTY_PLN_NO AS REF_NO    " ).append("\n"); 
		query.append("                    ,  DECODE(EM.CNTR_FULL_STS_CD, 'F', 'Y') AS FCNTR_FLG" ).append("\n"); 
		query.append("                    ,  NULL AS OB_CNTR_FLG" ).append("\n"); 
		query.append("                    ,  NULL AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                    ,  TRIM (EM.CNTR_SEAL_NO) AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("                    , EM.EDI_GATE_IO_CD" ).append("\n"); 
		query.append("                    , EM.CNTR_FULL_STS_CD" ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_SGHT_CD" ).append("\n"); 
		query.append("                    , EM.CALL_SGN_NO" ).append("\n"); 
		query.append("                    , EM.RTY_KNT" ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_RMK" ).append("\n"); 
		query.append("                    , TO_CHAR(EM.EVNT_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                     ||'0000'" ).append("\n"); 
		query.append("                     ||'0000'" ).append("\n"); 
		query.append("                     ||'XX' AS SORT_KEY" ).append("\n"); 
		query.append("					, EM.VNDR_SEQ" ).append("\n"); 
		query.append("                    , EM.BKG_KNT" ).append("\n"); 
		query.append("                    , EM.CNTR_DMG_FLG" ).append("\n"); 
		query.append("                    , EM.CHSS_NO" ).append("\n"); 
		query.append("                    , EM.MGST_NO" ).append("\n"); 
		query.append("                    , EM.DEST_YD_CD" ).append("\n"); 
		query.append("                    , EM.LLOYD_NO" ).append("\n"); 
		query.append("                    , EM.WO_NO" ).append("\n"); 
		query.append("                    , EM.EDI_VVD_CD" ).append("\n"); 
		query.append("                    , EM.TIR_NO" ).append("\n"); 
		query.append("                    , EM.MTY_PLN_NO" ).append("\n"); 
		query.append("                    , EM.MTY_REPO_NO" ).append("\n"); 
		query.append("                    , EM.EDI_CRR_NO" ).append("\n"); 
		query.append("                    , EM.TRSP_DOC_NO  " ).append("\n"); 
		query.append("					, EM.CRNT_VSL_CD" ).append("\n"); 
		query.append("                    , EM.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("                    , EM.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("                    , EM.CNMV_RMK                    " ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_MSG_AREA_CD  " ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_MSG_SEQ      " ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_MSG_TP_ID    " ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_MSG_YRMONDY  " ).append("\n"); 
		query.append("                    , EM.MVMT_EDI_TP_CD     " ).append("\n"); 
		query.append("					, EM.MVMT_TRSP_MOD_CD" ).append("\n"); 
		query.append("                    , EM.OFC_CD" ).append("\n"); 
		query.append("                    , EM.UPD_USR_ID" ).append("\n"); 
		query.append("                    , EM.CRE_USR_ID" ).append("\n"); 
		query.append("					, CASE WHEN EM.mvmt_edi_rmk = 'OK.PROCESSED' THEN 'N'" ).append("\n"); 
		query.append("                           WHEN EM.mvmt_edi_rmk = 'The same data already existed!' THEN 'N'" ).append("\n"); 
		query.append("                      ELSE" ).append("\n"); 
		query.append("                           CASE WHEN SUBSTR(UPPER(EM.MVMT_EDI_RMK), 1, 7) = 'ALREADY' THEN " ).append("\n"); 
		query.append("                                'N'" ).append("\n"); 
		query.append("                           ELSE" ).append("\n"); 
		query.append("                                'Y'" ).append("\n"); 
		query.append("                           END " ).append("\n"); 
		query.append("                      END  AS CHK_FLG" ).append("\n"); 
		query.append("					, '' AS USR_NM" ).append("\n"); 
		query.append("					, '' AS CNMV_YR" ).append("\n"); 
		query.append("					, 0 AS CNMV_SEQ" ).append("\n"); 
		query.append("					, 0 AS CNMV_ID_NO" ).append("\n"); 
		query.append("            FROM CTM_MVMT_EDI_MSG EM, PARAM P" ).append("\n"); 
		query.append("            WHERE 1 = 1" ).append("\n"); 
		query.append("            AND    P.CNTR_NO = EM.CNTR_NO" ).append("\n"); 
		query.append("            AND    EM.MVMT_EDI_RSLT_CD NOT IN ( 'Y', 'D')" ).append("\n"); 
		query.append("			AND     EM.EVNT_DT BETWEEN TO_DATE(REPLACE (@[s_event_date1], '-', ''),'YYYYMMDD') AND TO_DATE(REPLACE (@[s_event_date2], '-', ''), 'YYYYMMDD')+ 0.99999" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("ORDER BY SORT_KEY" ).append("\n"); 

	}
}