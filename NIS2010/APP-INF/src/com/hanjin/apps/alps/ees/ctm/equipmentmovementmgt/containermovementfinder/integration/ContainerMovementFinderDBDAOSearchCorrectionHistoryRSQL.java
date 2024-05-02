/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchCorrectionHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchCorrectionHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 201.03.03 Correction History Inquiry
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchCorrectionHistoryRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchCorrectionHistoryRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("        CNTR_NO||CNMV_YR||CNMV_ID_NO||CNMV_HIS_SEQ HIS_SEQ" ).append("\n"); 
		query.append("       ,CNTR_NO" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,DECODE(MODI_TP_FLG,'U','Update','D','Deleted','I','Insert') MODI_TP" ).append("\n"); 
		query.append("       ,DECODE(DAT_DIV_FLG,'T',DECODE(MODI_TP_FLG,'U','To','D','Deleted','I','Insert'),'F','From') DAT_DIV_FLG" ).append("\n"); 
		query.append("       ,CNMV_CYC_NO" ).append("\n"); 
		query.append("       ,CNMV_CO_CD" ).append("\n"); 
		query.append("       ,MVMT_STS_CD" ).append("\n"); 
		query.append("       ,MVMT_CRE_TP_CD" ).append("\n"); 
		query.append("       ,ORG_YD_CD" ).append("\n"); 
		query.append("       ,DEST_YD_CD" ).append("\n"); 
		query.append("       ,TO_CHAR (CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') CNMV_EVNT_DT" ).append("\n"); 
		query.append("       ,TRNK_VSL_CD||TRNK_SKD_VOY_NO||TRNK_SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("       ,BKG_NO" ).append("\n"); 
		query.append("       ,DECODE(FCNTR_FLG, 'Y', 'F', 'M') AS FCNTR_FLG" ).append("\n"); 
		query.append("       ,DECODE(OB_CNTR_FLG, 'Y', 'O', 'I') AS OB_CNTR_FLG" ).append("\n"); 
		query.append("       ,MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("       ,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("       ,CNTR_DMG_FLG " ).append("\n"); 
		query.append("       ,CNTR_DISP_FLG " ).append("\n"); 
		query.append("       ,IMDT_EXT_FLG " ).append("\n"); 
		query.append("       ,CNTR_RFUB_FLG " ).append("\n"); 
		query.append("       ,SPCL_CGO_FLG " ).append("\n"); 
		query.append("       ,A.VNDR_SEQ||B.VNDR_ABBR_NM VNDR_SEQ" ).append("\n"); 
		query.append("       ,MVMT_TRSP_MOD_CD" ).append("\n"); 
		query.append("       ,CHSS_NO" ).append("\n"); 
		query.append("       ,MGST_NO" ).append("\n"); 
		query.append("       ,CNTR_SEAL_NO" ).append("\n"); 
		query.append("       ,WBL_NO" ).append("\n"); 
		query.append("       ,PKUP_NO" ).append("\n"); 
		query.append("       ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID='CD03488' AND INTG_CD_VAL_CTNT=A.CNMV_CORR_RSN) CNMV_CORR_RSN" ).append("\n"); 
		query.append("       ,ATCH_FILE_SAV_ID" ).append("\n"); 
		query.append("       ,TO_CHAR (UPD_LOCL_DT, 'YYYY-MM-DD HH24:MI') UPD_LOCL_DT" ).append("\n"); 
		query.append("       ,TO_CHAR (CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') CRE_LOCL_DT" ).append("\n"); 
		query.append("       ,TO_CHAR (A.UPD_DT, 'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("       ,TO_CHAR (A.CRE_DT, 'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("       ,A.OFC_CD" ).append("\n"); 
		query.append("       ,USR_NM" ).append("\n"); 
		query.append("       ,CNMV_RMK" ).append("\n"); 
		query.append("       ,INP_DIV_FLG" ).append("\n"); 
		query.append("FROM CTM_MVMT_MNL_HIS A, MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("  AND CNTR_NO IN (" ).append("\n"); 
		query.append("	       #foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("		        #if($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("	       #end" ).append("\n"); 
		query.append("	            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND A.UPD_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("  -- 2016.05.17 김상현 [CHM-201641462] Correction reason 컨테이너 list 기능 보완 (no highlighted)" ).append("\n"); 
		query.append("  --  -'CNMV_SPLIT_NO'만 변경된 data는 보이지 않도록 조건 추가" ).append("\n"); 
		query.append("  AND 'TRUE' = CASE WHEN A.MODI_TP_FLG = 'U' AND EXISTS(SELECT 1" ).append("\n"); 
		query.append("                                                    FROM CTM_MVMT_MNL_HIS_COL" ).append("\n"); 
		query.append("                                                    WHERE 1 = 1" ).append("\n"); 
		query.append("                                                      AND CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                                                      AND CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("                                                      AND CNMV_ID_NO = A.CNMV_ID_NO" ).append("\n"); 
		query.append("                                                      AND CNMV_HIS_SEQ = A.CNMV_HIS_SEQ" ).append("\n"); 
		query.append("                                                      AND CNMV_COL_NM <> 'CNMV_SPLIT_NO'" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                      THEN 'TRUE'" ).append("\n"); 
		query.append("                    WHEN A.MODI_TP_FLG <> 'U' THEN 'TRUE'" ).append("\n"); 
		query.append("                    ELSE 'FALSE'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("ORDER BY CNTR_NO,CNMV_YR,CNMV_ID_NO,CNMV_HIS_SEQ,DAT_DIV_FLG" ).append("\n"); 

	}
}