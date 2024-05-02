/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOMVMTBookingInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOMVMTBookingInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOMVMTBookingInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nls_cnt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOMVMTBookingInfoVORSQL").append("\n"); 
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
		query.append("SELECT CTR.CNTR_NO," ).append("\n"); 
		query.append("       CTR.CNMV_CYC_NO," ).append("\n"); 
		query.append("       CTR.CNMV_LVL_NO," ).append("\n"); 
		query.append("       CTR.CNMV_CO_CD," ).append("\n"); 
		query.append("       CTR.MVMT_STS_CD," ).append("\n"); 
		query.append("       CTR.MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("       CTR.ORG_YD_CD," ).append("\n"); 
		query.append("       CTR.DEST_YD_CD," ).append("\n"); 
		query.append("       TO_CHAR(CTR.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') CNMV_EVNT_DT," ).append("\n"); 
		query.append("       CTR.CRNT_VSL_CD || CTR.CRNT_SKD_VOY_NO || CTR.CRNT_SKD_DIR_CD CNTR_ID," ).append("\n"); 
		query.append("       DECODE(CTR.FCNTR_FLG, 'Y' , 'F','M') FCNTR_FLG," ).append("\n"); 
		query.append("       DECODE(CTR.OB_CNTR_FLG, 'Y' , 'O','I') OB_CNTR_FLG," ).append("\n"); 
		query.append("       CTR.MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("       CTR.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       CTR.CNTR_DMG_FLG," ).append("\n"); 
		query.append("       DECODE (CTR.CNMV_YR||LPAD (CTR.CNMV_SEQ, 4, 0)||CTR.CNMV_SPLIT_NO, TEMP_CNMV_CD, CTM.CNTR_HNGR_RCK_CD, '') AS CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("       DECODE (CTR.CNMV_YR||LPAD (CTR.CNMV_SEQ, 4, 0)||CTR.CNMV_SPLIT_NO, TEMP_CNMV_CD, CTM.CNTR_HNGR_BAR_ATCH_KNT, '') AS CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("       CTR.CNTR_DISP_FLG," ).append("\n"); 
		query.append("       CTR.IMDT_EXT_FLG," ).append("\n"); 
		query.append("       CTR.CNTR_RFUB_FLG, " ).append("\n"); 
		query.append("       CTR.CNTR_XCH_CD," ).append("\n"); 
		query.append("       CTR.SPCL_CGO_FLG," ).append("\n"); 
		query.append("       CTR.VNDR_SEQ," ).append("\n"); 
		query.append("       VEN.VNDR_ABBR_NM," ).append("\n"); 
		query.append("       CTR.MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("       TRIM(CTR.CHSS_NO) CHSS_NO," ).append("\n"); 
		query.append("       TRIM(CTR.MGST_NO) MGST_NO," ).append("\n"); 
		query.append("       TRIM(CTR.CNTR_SEAL_NO) CNTR_SEAL_NO," ).append("\n"); 
		query.append("       TRIM(CTR.WBL_NO) WBL_NO," ).append("\n"); 
		query.append("       TRIM(CTR.PKUP_NO) PKUP_NO," ).append("\n"); 
		query.append("       TO_CHAR(CTR.UPD_DT, 'YYYY-MM-DD HH24:MI') UPD_DT," ).append("\n"); 
		query.append("       TO_CHAR(CTR.CRE_DT,  'YYYY-MM-DD HH24:MI') CRE_DT," ).append("\n"); 
		query.append("       TO_CHAR (CTR.UPD_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS UPD_LOCL_DT," ).append("\n"); 
		query.append("       TO_CHAR (CTR.CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS CRE_LOCL_DT," ).append("\n"); 
		query.append("       CTR.OFC_CD," ).append("\n"); 
		query.append("       TRIM(CTR.USR_NM) USR_NM," ).append("\n"); 
		query.append("       TRIM(CTR.CHSS_MGST_MVMT_RMK) CNMV_RMK," ).append("\n"); 
		query.append("       TRIM(CTR.CHSS_MGST_MVMT_RMK) CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("       CTR.CNMV_ID_NO," ).append("\n"); 
		query.append("       CTR.CNMV_SEQ," ).append("\n"); 
		query.append("       CTR.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("       CTR.CRE_USR_ID," ).append("\n"); 
		query.append("       CTR.UPD_USR_ID," ).append("\n"); 
		query.append("       CTR.BKG_NO," ).append("\n"); 
		query.append("       '' BKG_NO_SPLIT," ).append("\n"); 
		query.append("       CTR.BKG_KNT," ).append("\n"); 
		query.append("       CTR.BL_NO," ).append("\n"); 
		query.append("       '' BL_NO_TP," ).append("\n"); 
		query.append("       '' BL_NO_CHK," ).append("\n"); 
		query.append("       CTR.CNMV_YR," ).append("\n"); 
		query.append("       CTR.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       max(CTR.CNMV_ID_NO) OVER (PARTITION BY CTR.CNMV_YR) VR_SEQ," ).append("\n"); 
		query.append("       CASE WHEN CTR.SYS_AREA_GRP_ID = (SELECT SYS_AREA_GRP_ID FROM COM_SYS_AREA_GRP_ID WHERE CNT_CD = @[nls_cnt] AND CO_IND_CD = 'H') THEN 1 ELSE 0 END AS SVR_ID," ).append("\n"); 
		query.append("	   CTR.SYS_AREA_GRP_ID AS CNTR_SVR_ID," ).append("\n"); 
		query.append("       DECODE (CLM.CNTR_NO, NULL, 'N', 'Y') EXT," ).append("\n"); 
		query.append("       MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("       MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("       MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("       MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("       TRNK_VSL_CD || TRNK_SKD_VOY_NO || TRNK_SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("       CTRT_SEQ" ).append("\n"); 
		query.append("  FROM CTM_MOVEMENT CTR, MST_CONTAINER CNTR, MDM_VENDOR VEN, (SELECT CNTR_NO, CNMV_YR, CNMV_ID_NO, MAX(CLM_SEQ) SEQ FROM SCE_CLM WHERE CNTR_NO = @[p_cntrno] GROUP BY CNTR_NO, CNMV_YR, CNMV_ID_NO) CLM," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX(CTM XAK2CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                       CTM.CNTR_NO," ).append("\n"); 
		query.append("                       MAX (CTM.CNMV_YR||LPAD (CTM.CNMV_SEQ, 4, 0)||CTM.CNMV_SPLIT_NO) AS TEMP_CNMV_CD," ).append("\n"); 
		query.append("                       NVL2 (MST.CNTR_HNGR_RCK_CD, 'Y', 'N') AS CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("                       MST.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT CTM, MST_CONTAINER MST" ).append("\n"); 
		query.append("                 WHERE CTM.CNTR_NO = MST.CNTR_NO" ).append("\n"); 
		query.append("                   AND CTM.CNTR_NO = @[p_cntrno]" ).append("\n"); 
		query.append("                   #if (${p_date1} != '' && ${p_date2} != '')" ).append("\n"); 
		query.append("                   AND CTM.CNMV_EVNT_DT BETWEEN TO_DATE (REPLACE (@[p_date1], '-', ''), 'YYYY-MM-DD') AND TO_DATE (REPLACE (@[p_date2], '-', ''), 'YYYY-MM-DD') + 0.9999" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("              GROUP BY CTM.CNTR_NO, MST.CNTR_HNGR_RCK_CD, MST.CNTR_HNGR_BAR_ATCH_KNT) CTM" ).append("\n"); 
		query.append(" WHERE CTR.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("#if (${p_date1} != '' && ${p_date2} != '')" ).append("\n"); 
		query.append("   AND CTR.CNMV_EVNT_DT BETWEEN TO_DATE (REPLACE (@[p_date1], '-', ''), 'YYYY-MM-DD') AND TO_DATE (REPLACE (@[p_date2], '-', ''), 'YYYY-MM-DD') + 0.9999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND CTR.VNDR_SEQ = VEN.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND CTR.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("   AND CTR.CNTR_NO = CLM.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND CTR.CNMV_YR = CLM.CNMV_YR(+)" ).append("\n"); 
		query.append("   AND CTR.CNMV_ID_NO = CLM.CNMV_ID_NO(+)" ).append("\n"); 
		query.append("#if (${p_cntrno} != '')" ).append("\n"); 
		query.append("   AND CTR.CNTR_NO = @[p_cntrno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CTR.CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO" ).append("\n"); 

	}
}