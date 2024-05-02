/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchMovementListByContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchMovementListByContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_CTM_0408 : 컨테이너 번호에 의한 Each Container LIST 조회
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchMovementListByContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchMovementListByContainerRSQL").append("\n"); 
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
		query.append("SELECT CNMV_CYC_NO," ).append("\n"); 
		query.append("       CNMV_CO_CD," ).append("\n"); 
		query.append("       MVMT_STS_CD," ).append("\n"); 
		query.append("       MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("       ORG_YD_CD," ).append("\n"); 
		query.append("       DEST_YD_CD," ).append("\n"); 
		query.append("       CNMV_EVNT_DT," ).append("\n"); 
		query.append("       VVD_CD," ).append("\n"); 
		query.append("       BKG_KNT," ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       BL_NO, " ).append("\n"); 
		query.append("       MTY_PLN_NO," ).append("\n"); 
		query.append("       DECODE (FCNTR_FLG, 'Y', 'F', 'M') AS FCNTR_FLG," ).append("\n"); 
		query.append("       DECODE (OB_CNTR_FLG, 'Y', 'O', 'I') AS OB_CNTR_FLG," ).append("\n"); 
		query.append("       MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("       BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       CNTR_DMG_FLG," ).append("\n"); 
		query.append("       CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("       CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("       CNTR_DISP_FLG," ).append("\n"); 
		query.append("       IMDT_EXT_FLG," ).append("\n"); 
		query.append("       CNTR_XCH_CD,       " ).append("\n"); 
		query.append("       CNTR_RFUB_FLG," ).append("\n"); 
		query.append("       SPCL_CGO_FLG," ).append("\n"); 
		query.append("       VNDR_SEQ," ).append("\n"); 
		query.append("       VNDR_ABBR_NM," ).append("\n"); 
		query.append("	   RSTR_USG_LBL_NM_DESC," ).append("\n"); 
		query.append("	   RSTR_USG_LBL_VAL_DESC," ).append("\n"); 
		query.append("       MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("       CHSS_NO," ).append("\n"); 
		query.append("       MGST_NO," ).append("\n"); 
		query.append("       CNTR_SEAL_NO," ).append("\n"); 
		query.append("       WBL_NO," ).append("\n"); 
		query.append("       PKUP_NO," ).append("\n"); 
		query.append("       UPD_LOCL_DT," ).append("\n"); 
		query.append("       CRE_LOCL_DT," ).append("\n"); 
		query.append("       UPD_DT," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       OFC_CD," ).append("\n"); 
		query.append("       USR_NM," ).append("\n"); 
		query.append("       CNMV_RMK," ).append("\n"); 
		query.append("       CNMV_YR," ).append("\n"); 
		query.append("       CNMV_SEQ," ).append("\n"); 
		query.append("       CNMV_SPLIT_NO," ).append("\n"); 
		query.append("	   DMG_FLG_DT," ).append("\n"); 
		query.append("	   DMG_UNFLG_DT," ).append("\n"); 
		query.append("       USA_EDI_CD" ).append("\n"); 
		query.append("       , CNTR_STWG_PSN_CTNT" ).append("\n"); 
		query.append("  FROM (SELECT /*+ INDEX CTM_MOVEMENT XAK2CTM_MOVEMENT */" ).append("\n"); 
		query.append("               A.CNMV_CYC_NO," ).append("\n"); 
		query.append("               A.CNMV_CO_CD," ).append("\n"); 
		query.append("               A.MVMT_STS_CD," ).append("\n"); 
		query.append("               A.MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("               A.ORG_YD_CD," ).append("\n"); 
		query.append("               A.DEST_YD_CD," ).append("\n"); 
		query.append("               TO_CHAR (A.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("               A.CRNT_VSL_CD||A.CRNT_SKD_VOY_NO||A.CRNT_SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("               A.BKG_KNT," ).append("\n"); 
		query.append("               A.BKG_NO," ).append("\n"); 
		query.append("               A.BL_NO," ).append("\n"); 
		query.append("               NVL(A.MTY_PLN_NO, NVL(A.MTY_REPO_NO,'')) AS MTY_PLN_NO," ).append("\n"); 
		query.append("               A.FCNTR_FLG," ).append("\n"); 
		query.append("               A.OB_CNTR_FLG," ).append("\n"); 
		query.append("               A.MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("               A.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("               A.CNTR_DMG_FLG," ).append("\n"); 
		query.append("               DECODE (A.CNMV_YR||LPAD (A.CNMV_SEQ, 4, 0)||A.CNMV_SPLIT_NO, TEMP_CNMV_CD, CTM.CNTR_HNGR_RCK_CD, '') AS CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("               DECODE (A.CNMV_YR||LPAD (A.CNMV_SEQ, 4, 0)||A.CNMV_SPLIT_NO, TEMP_CNMV_CD, CTM.CNTR_HNGR_BAR_ATCH_KNT, '') AS CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("               A.CNTR_DISP_FLG," ).append("\n"); 
		query.append("               A.IMDT_EXT_FLG," ).append("\n"); 
		query.append("         	   A.CNTR_XCH_CD,               " ).append("\n"); 
		query.append("               A.CNTR_RFUB_FLG," ).append("\n"); 
		query.append("               A.SPCL_CGO_FLG," ).append("\n"); 
		query.append("               C.VNDR_SEQ," ).append("\n"); 
		query.append("               C.VNDR_ABBR_NM," ).append("\n"); 
		query.append("			   CASE WHEN A.CNMV_YR=MST_CNTR.CNMV_YR AND A.CNMV_ID_NO=MST_CNTR.CNMV_ID_NO THEN" ).append("\n"); 
		query.append("                        MST_COMMON_PKG.MST_RU_TP_GET_FNC(@[p_cntrno])" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                        A.RSTR_USG_LBL_NM_DESC" ).append("\n"); 
		query.append("                END RSTR_USG_LBL_NM_DESC," ).append("\n"); 
		query.append("			   CASE WHEN A.CNMV_YR=MST_CNTR.CNMV_YR AND A.CNMV_ID_NO=MST_CNTR.CNMV_ID_NO THEN" ).append("\n"); 
		query.append("                        MST_COMMON_PKG.MST_RU_VAL_GET_FNC(@[p_cntrno])" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                        A.RSTR_USG_LBL_VAL_DESC" ).append("\n"); 
		query.append("                END RSTR_USG_LBL_VAL_DESC," ).append("\n"); 
		query.append("               A.MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("               TRIM (A.CHSS_NO) AS CHSS_NO," ).append("\n"); 
		query.append("               TRIM (A.MGST_NO) AS MGST_NO," ).append("\n"); 
		query.append("               TRIM (A.CNTR_SEAL_NO) AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("               TRIM (A.WBL_NO) AS WBL_NO," ).append("\n"); 
		query.append("               TRIM (A.PKUP_NO) AS PKUP_NO," ).append("\n"); 
		query.append("               TO_CHAR (A.UPD_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS UPD_LOCL_DT," ).append("\n"); 
		query.append("               TO_CHAR (A.CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS CRE_LOCL_DT," ).append("\n"); 
		query.append("               TO_CHAR (A.UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT," ).append("\n"); 
		query.append("               TO_CHAR (A.CRE_DT, 'YYYY-MM-DD HH24:MI') AS CRE_DT," ).append("\n"); 
		query.append("               A.OFC_CD," ).append("\n"); 
		query.append("               TRIM(A.USR_NM) AS USR_NM," ).append("\n"); 
		query.append("               TRIM(A.CNMV_RMK) AS CNMV_RMK," ).append("\n"); 
		query.append("               A.CNMV_YR," ).append("\n"); 
		query.append("               A.CNMV_SEQ," ).append("\n"); 
		query.append("               A.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("               A.CNMV_ID_NO," ).append("\n"); 
		query.append("               A.CNTR_NO," ).append("\n"); 
		query.append("			   TO_CHAR (A.DMG_FLG_DT, 'YYYY-MM-DD HH24:MI') AS DMG_FLG_DT," ).append("\n"); 
		query.append("			   TO_CHAR (A.DMG_UNFLG_DT, 'YYYY-MM-DD HH24:MI') AS DMG_UNFLG_DT," ).append("\n"); 
		query.append("               A.USA_EDI_CD" ).append("\n"); 
		query.append("               , MSG.CNTR_STWG_PSN_CTNT" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT A, " ).append("\n"); 
		query.append("               CTM_MVMT_EDI_MSG MSG," ).append("\n"); 
		query.append("               MDM_VENDOR C," ).append("\n"); 
		query.append("               (SELECT /*+ INDEX(CTM XAK2CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                       CTM.CNTR_NO," ).append("\n"); 
		query.append("                       MAX (CTM.CNMV_YR||LPAD (CTM.CNMV_SEQ, 4, 0)||CTM.CNMV_SPLIT_NO) AS TEMP_CNMV_CD," ).append("\n"); 
		query.append("                       NVL2 (MST.CNTR_HNGR_RCK_CD, 'Y', 'N') AS CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("                       MST.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT CTM, MST_CONTAINER MST" ).append("\n"); 
		query.append("                 WHERE CTM.CNTR_NO = MST.CNTR_NO" ).append("\n"); 
		query.append("                   AND CTM.CNTR_NO = @[p_cntrno]" ).append("\n"); 
		query.append("                   AND CTM.CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                 GROUP BY CTM.CNTR_NO, MST.CNTR_HNGR_RCK_CD, MST.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("               ) CTM," ).append("\n"); 
		query.append("               MST_CONTAINER MST_CNTR" ).append("\n"); 
		query.append("         WHERE A.CNTR_NO = @[p_cntrno]" ).append("\n"); 
		query.append("           AND A.MVMT_EDI_TP_CD = MSG.MVMT_EDI_TP_CD(+)" ).append("\n"); 
		query.append("           AND A.MVMT_EDI_MSG_TP_ID = MSG.MVMT_EDI_MSG_TP_ID(+)" ).append("\n"); 
		query.append("           AND A.MVMT_EDI_MSG_AREA_CD = MSG.MVMT_EDI_MSG_AREA_CD(+)" ).append("\n"); 
		query.append("           AND A.MVMT_EDI_MSG_YRMONDY = MSG.MVMT_EDI_MSG_YRMONDY(+)" ).append("\n"); 
		query.append("           AND A.MVMT_EDI_MSG_SEQ = MSG.MVMT_EDI_MSG_SEQ(+)" ).append("\n"); 
		query.append("           AND A.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("           AND A.CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("           AND A.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("           AND A.CNTR_NO = MST_CNTR.CNTR_NO" ).append("\n"); 
		query.append("       ) CM" ).append("\n"); 
		query.append(" ORDER BY CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO" ).append("\n"); 

	}
}