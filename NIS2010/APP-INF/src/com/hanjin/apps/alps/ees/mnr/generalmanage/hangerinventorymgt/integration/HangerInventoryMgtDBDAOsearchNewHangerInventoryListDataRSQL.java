/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : HangerInventoryMgtDBDAOsearchNewHangerInventoryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.08.07 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HangerInventoryMgtDBDAOsearchNewHangerInventoryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [EES_MNR_0113] Hanger Bar Inventory List 
	  * 기존 [EES_MNR_0110] 항목을 대체하여 신규 작성
	  * 
	  * 2015.02.03 By Jeong-Min, Park
	  * </pre>
	  */
	public HangerInventoryMgtDBDAOsearchNewHangerInventoryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.integration").append("\n"); 
		query.append("FileName : HangerInventoryMgtDBDAOsearchNewHangerInventoryListDataRSQL").append("\n"); 
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
		query.append("WITH HANGER_DATA AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("      ,REPLACE(@[month], '-', '') INVT_YRMON  -- PK, MONTH SEARCH OPTION" ).append("\n"); 
		query.append("      ,A.OFC_CD             -- PK" ).append("\n"); 
		query.append("      ,A.INTG_CD_VAL_CTNT   -- PK " ).append("\n"); 
		query.append("      ,A.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("      ,NVL(B.INVT_QTY, 0) AS FST_MON" ).append("\n"); 
		query.append("      ,NVL(B.INVT_QTY, 0) + NVL(B.DE_HNGR_QTY, 0) + NVL(B.RPR_HNGR_QTY, 0) - NVL(B.OB_HNGR_QTY, 0)- NVL(B.REPO_OUT_HNGR_QTY, 0) AS LST_MON" ).append("\n"); 
		query.append("      ,NVL(B.DE_HNGR_QTY, 0)       DE_HNGR_QTY" ).append("\n"); 
		query.append("      ,NVL(B.OB_HNGR_QTY, 0)       OB_HNGR_QTY " ).append("\n"); 
		query.append("      ,NVL(B.REPO_OUT_HNGR_QTY, 0) REPO_OUT_HNGR_QTY" ).append("\n"); 
		query.append("      ,NVL(B.RPR_HNGR_QTY, 0)      RPR_HNGR_QTY" ).append("\n"); 
		query.append("      ,NVL(B.DISP_HNGR_QTY, 0)     DISP_HNGR_QTY" ).append("\n"); 
		query.append("      ,B.INVT_RMK" ).append("\n"); 
		query.append("      ,B.UPD_USR_ID" ).append("\n"); 
		query.append("      ,B.UPD_DT" ).append("\n"); 
		query.append("FROM      " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- OFFICE, TYPE " ).append("\n"); 
		query.append("    SELECT A.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("          ,A.OFC_CD" ).append("\n"); 
		query.append("          ,C.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("          ,C.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION  A" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT INTG_CD_VAL_CTNT " ).append("\n"); 
		query.append("              ,INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD02011'  -- HARD CODING" ).append("\n"); 
		query.append("    ) C" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    WHERE A.DELT_FLG = 'N'    -- HARD CODING" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	#if(${ar_hd_qtr_ofc_cd} == '')" ).append("\n"); 
		query.append("    -- HQ ALL OPTION" ).append("\n"); 
		query.append("    AND   A.AR_HD_QTR_OFC_CD IN ('SHARC','SELIB','TYOIB','SINRS')" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    -- HQ OPTION" ).append("\n"); 
		query.append("    AND   A.AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",(  -- HANGER INVENTORY" ).append("\n"); 
		query.append("    SELECT INVT_YRMON" ).append("\n"); 
		query.append("          ,OFC_CD" ).append("\n"); 
		query.append("          ,MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("          ,INVT_QTY" ).append("\n"); 
		query.append("          ,DE_HNGR_QTY" ).append("\n"); 
		query.append("          ,OB_HNGR_QTY" ).append("\n"); 
		query.append("          ,REPO_OUT_HNGR_QTY" ).append("\n"); 
		query.append("          ,RPR_HNGR_QTY" ).append("\n"); 
		query.append("          ,DISP_HNGR_QTY" ).append("\n"); 
		query.append("          ,INVT_RMK" ).append("\n"); 
		query.append("          ,UPD_USR_ID" ).append("\n"); 
		query.append("          ,TO_CHAR(UPD_DT, 'YYYYMMDDHH24MISS') UPD_DT" ).append("\n"); 
		query.append("    FROM MNR_HNGR_MON_INVT " ).append("\n"); 
		query.append("    WHERE INVT_YRMON = REPLACE(@[month], '-', '') -- MONTH OPTION" ).append("\n"); 
		query.append(" ) B " ).append("\n"); 
		query.append("WHERE A.OFC_CD           = B.OFC_CD(+)" ).append("\n"); 
		query.append("AND   A.INTG_CD_VAL_CTNT = B.MNR_HNGR_BAR_TP_CD(+)     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT LVL  -- SORTING " ).append("\n"); 
		query.append("      ,AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("      ,INVT_YRMON" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("      ,INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("      ,FST_MON" ).append("\n"); 
		query.append("      ,LST_MON" ).append("\n"); 
		query.append("      ,DE_HNGR_QTY" ).append("\n"); 
		query.append("      ,OB_HNGR_QTY" ).append("\n"); 
		query.append("      ,REPO_OUT_HNGR_QTY" ).append("\n"); 
		query.append("      ,RPR_HNGR_QTY" ).append("\n"); 
		query.append("      ,DISP_HNGR_QTY" ).append("\n"); 
		query.append("      ,INVT_RMK" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(      " ).append("\n"); 
		query.append("    SELECT '00000' LVL" ).append("\n"); 
		query.append("          ,AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("          ,INVT_YRMON" ).append("\n"); 
		query.append("          ,OFC_CD" ).append("\n"); 
		query.append("          ,INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("          ,INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          ,FST_MON" ).append("\n"); 
		query.append("          ,LST_MON" ).append("\n"); 
		query.append("          ,DE_HNGR_QTY" ).append("\n"); 
		query.append("          ,OB_HNGR_QTY" ).append("\n"); 
		query.append("          ,REPO_OUT_HNGR_QTY" ).append("\n"); 
		query.append("          ,RPR_HNGR_QTY" ).append("\n"); 
		query.append("          ,DISP_HNGR_QTY" ).append("\n"); 
		query.append("          ,INVT_RMK" ).append("\n"); 
		query.append("          ,UPD_USR_ID" ).append("\n"); 
		query.append("          ,UPD_DT " ).append("\n"); 
		query.append("    FROM HANGER_DATA     " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    UNION ALL  " ).append("\n"); 
		query.append("    SELECT '00000' LVL" ).append("\n"); 
		query.append("          ,AR_HD_QTR_OFC_CD || ' TOTAL'" ).append("\n"); 
		query.append("          ,NULL INVT_YRMON" ).append("\n"); 
		query.append("          ,NULL OFC_CD" ).append("\n"); 
		query.append("          ,NULL INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("          ,NULL INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          ,SUM(FST_MON)" ).append("\n"); 
		query.append("          ,SUM(LST_MON)" ).append("\n"); 
		query.append("          ,SUM(DE_HNGR_QTY)" ).append("\n"); 
		query.append("          ,SUM(OB_HNGR_QTY)" ).append("\n"); 
		query.append("          ,SUM(REPO_OUT_HNGR_QTY)" ).append("\n"); 
		query.append("          ,SUM(RPR_HNGR_QTY)" ).append("\n"); 
		query.append("          ,SUM(DISP_HNGR_QTY)" ).append("\n"); 
		query.append("          ,NULL INVT_RMK" ).append("\n"); 
		query.append("          ,NULL UPD_USR_ID" ).append("\n"); 
		query.append("          ,NULL UPD_DT " ).append("\n"); 
		query.append("    FROM HANGER_DATA  " ).append("\n"); 
		query.append("    GROUP BY AR_HD_QTR_OFC_CD    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    UNION ALL  " ).append("\n"); 
		query.append("    SELECT '22222' LVL" ).append("\n"); 
		query.append("          ,'TOTAL'" ).append("\n"); 
		query.append("          ,NULL INVT_YRMON" ).append("\n"); 
		query.append("          ,NULL OFC_CD" ).append("\n"); 
		query.append("          ,NULL INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("          ,NULL INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          ,SUM(FST_MON)" ).append("\n"); 
		query.append("          ,SUM(LST_MON)" ).append("\n"); 
		query.append("          ,SUM(DE_HNGR_QTY)" ).append("\n"); 
		query.append("          ,SUM(OB_HNGR_QTY)" ).append("\n"); 
		query.append("          ,SUM(REPO_OUT_HNGR_QTY)" ).append("\n"); 
		query.append("          ,SUM(RPR_HNGR_QTY)" ).append("\n"); 
		query.append("          ,SUM(DISP_HNGR_QTY)" ).append("\n"); 
		query.append("          ,NULL INVT_RMK" ).append("\n"); 
		query.append("          ,NULL UPD_USR_ID" ).append("\n"); 
		query.append("          ,NULL UPD_DT " ).append("\n"); 
		query.append("    FROM HANGER_DATA  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY LVL" ).append("\n"); 
		query.append("       , AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("       , OFC_CD" ).append("\n"); 
		query.append("       , INTG_CD_VAL_CTNT" ).append("\n"); 

	}
}