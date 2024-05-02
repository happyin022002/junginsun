/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchOffhireCnfmListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.05
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.05 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchOffhireCnfmListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchOffhireCnfmListRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchOffhireCnfmListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchOffhireCnfmListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append(" AA.* ," ).append("\n"); 
		query.append(" TO_CHAR(VNOR_OFFH_FM_DT2,'YYYY-MM-DD')  AS VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append(" ,TO_CHAR(VNOR_OFFH_TO_DT2,'YYYY-MM-DD')  AS VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append(",D.INTG_CD_VAL_DP_DESC AS vnor_offh_ind" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT O.VSL_CD,                        --VESSEL" ).append("\n"); 
		query.append("       O.SKD_VOY_NO," ).append("\n"); 
		query.append("       O.SKD_DIR_CD,				    --VESSEL" ).append("\n"); 
		query.append("       O.VNOR_VSL_STS_CD,       		--TYPE" ).append("\n"); 
		query.append("       O.VNOR_FM_PORT_CD  			    --PLACE" ).append("\n"); 
		query.append("       ,O.VNOR_OFFH_FM_DT AS VNOR_OFFH_FM_DT2" ).append("\n"); 
		query.append("       ,TO_CHAR(O.VNOR_OFFH_FM_DT,'HH24:MI') AS VNOR_OFFH_FM_DT_HM" ).append("\n"); 
		query.append("       ,O.VNOR_OFFH_TO_DT  AS VNOR_OFFH_TO_DT2" ).append("\n"); 
		query.append("       ,TO_CHAR(O.VNOR_OFFH_TO_DT,'HH24:MI') AS VNOR_OFFH_TO_DT_HM," ).append("\n"); 
		query.append("       F.VNOR_ITM_CD,     -- ITEM" ).append("\n"); 
		query.append("       F.VNOR_ITM_OFC_CD,     -- OFC" ).append("\n"); 
		query.append("       F.VNOR_ITM_UT_CD,      -- UOM" ).append("\n"); 
		query.append("       F.VNOR_ITM_VAL,         -- VALUE" ).append("\n"); 
		query.append("       F.VNOR_ITM_FLET_ADD_CD,   -- KIND  " ).append("\n"); 
		query.append("       F.ATCH_FILE_OP_KNT OPF_CNT,     -- OPF 파일 건수" ).append("\n"); 
		query.append("       F.ATCH_FILE_FLET_KNT FMS_CNT,     -- FMS 파일 건수" ).append("\n"); 
		query.append("       CASE WHEN C.APRO_FLG = 'Y' THEN 'A'" ).append("\n"); 
		query.append("            WHEN C.APRO_FLG = 'N' THEN 'N'" ).append("\n"); 
		query.append("            WHEN I.VNOR_SEQ IS NOT NULL THEN 'S'" ).append("\n"); 
		query.append("            WHEN F.VNOR_ITM_PROC_CD = 'P' THEN 'C'" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("       END vnor_offh_ind2,    -- IND" ).append("\n"); 
		query.append("       F.VNOR_ITM_RMK,            -- REMARK" ).append("\n"); 
		query.append("	   F.VNOR_ITM_FLET_RMK,			-- Audit Comment" ).append("\n"); 
		query.append("       (SELECT U.USR_NM FROM COM_USER U WHERE U.USR_ID = F.CRE_USR_ID) upd_usr_id,  -- USER ID" ).append("\n"); 
		query.append("       TO_CHAR(F.UPD_DT, 'yyyy-mm-dd hh24:mi:ss') AS UPD_DT, " ).append("\n"); 
		query.append("       F.ATCH_FILE_OP_KNT" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM FMS_ATCH_FILE WHERE ATCH_FILE_LNK_ID = F.ATCH_FILE_FLET_LNK_ID ) AS ATCH_FILE_FLET_KNT" ).append("\n"); 
		query.append("      ,F.ATCH_FILE_OP_LNK_ID" ).append("\n"); 
		query.append("	  ,F.ATCH_FILE_FLET_LNK_ID " ).append("\n"); 
		query.append("	  ,F.VNOR_SEQ " ).append("\n"); 
		query.append("      ,F.VNOR_ITM_SEQ      " ).append("\n"); 
		query.append("	  ,O.VNOR_OFFH_KND_CD" ).append("\n"); 
		query.append("      ,I.FLET_CTRT_NO" ).append("\n"); 
		query.append("      ,I.INV_SEQ" ).append("\n"); 
		query.append("FROM FMS_VNOR O, FMS_VNOR_ITM F, FMS_INV_DTL I, FMS_CONSULTATION C" ).append("\n"); 
		query.append("WHERE O.VSL_CD = F.VSL_CD" ).append("\n"); 
		query.append("  AND O.VNOR_SEQ = F.VNOR_SEQ  " ).append("\n"); 
		query.append("  AND F.VNOR_ITM_PROC_CD = 'C'" ).append("\n"); 
		query.append("  AND F.VSL_CD       = I.VSL_CD(+)" ).append("\n"); 
		query.append("  AND F.VNOR_SEQ     = I.VNOR_SEQ(+)" ).append("\n"); 
		query.append("  AND F.VNOR_ITM_SEQ = I.VNOR_ITM_SEQ(+)" ).append("\n"); 
		query.append("  AND I.SLP_TP_CD = C.SLP_TP_CD(+)" ).append("\n"); 
		query.append("  AND I.SLP_FUNC_CD = C.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("  AND I.SLP_OFC_CD = C.SLP_OFC_CD(+)" ).append("\n"); 
		query.append("  AND I.SLP_ISS_DT = C.SLP_ISS_DT(+)" ).append("\n"); 
		query.append("  AND I.SLP_SER_NO = C.SLP_SER_NO(+)  " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT O.VSL_CD,            -- VESSEL" ).append("\n"); 
		query.append("       O.SKD_VOY_NO," ).append("\n"); 
		query.append("       O.SKD_DIR_CD,  		-- VESSEL" ).append("\n"); 
		query.append("       O.VNOR_VSL_STS_CD,   -- TYPE" ).append("\n"); 
		query.append("       O.VNOR_FM_PORT_CD  	-- PLACE" ).append("\n"); 
		query.append("       ,O.VNOR_OFFH_FM_DT AS VNOR_OFFH_FM_DT2" ).append("\n"); 
		query.append("       ,TO_CHAR(O.VNOR_OFFH_FM_DT,'HH24:MI') AS VNOR_OFFH_FM_DT_HM" ).append("\n"); 
		query.append("       ,O.VNOR_OFFH_TO_DT  AS VNOR_OFFH_TO_DT2" ).append("\n"); 
		query.append("       ,TO_CHAR(O.VNOR_OFFH_TO_DT,'HH24:MI') AS VNOR_OFFH_TO_DT_HM," ).append("\n"); 
		query.append("       F.VNOR_ITM_CD,     -- ITEM" ).append("\n"); 
		query.append("       F.VNOR_ITM_OFC_CD,     -- OFC" ).append("\n"); 
		query.append("       F.VNOR_ITM_UT_CD,      -- UOM" ).append("\n"); 
		query.append("       F.VNOR_ITM_VAL,         -- VALUE" ).append("\n"); 
		query.append("       F.VNOR_ITM_FLET_ADD_CD,   -- KIND" ).append("\n"); 
		query.append("       F.ATCH_FILE_OP_KNT OPF_CNT,     -- OPF 파일 건수" ).append("\n"); 
		query.append("       F.ATCH_FILE_FLET_KNT FMS_CNT,     -- FMS 파일 건수" ).append("\n"); 
		query.append("       CASE WHEN C.APRO_FLG = 'Y' THEN 'A'" ).append("\n"); 
		query.append("            WHEN C.APRO_FLG = 'N' THEN 'N'" ).append("\n"); 
		query.append("            WHEN I.VNOR_SEQ IS NOT NULL THEN 'S'" ).append("\n"); 
		query.append("            WHEN F.VNOR_ITM_PROC_CD = 'P' THEN 'C'" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("       END vnor_offh_ind2,    -- IND" ).append("\n"); 
		query.append("       F.VNOR_ITM_RMK,            -- REMARK" ).append("\n"); 
		query.append("	   F.VNOR_ITM_FLET_RMK,			-- Audit Comment" ).append("\n"); 
		query.append("       (SELECT U.USR_NM FROM COM_USER U WHERE U.USR_ID = F.CRE_USR_ID) upd_usr_id,  -- USER ID" ).append("\n"); 
		query.append("       TO_CHAR(F.UPD_DT, 'yyyy-mm-dd hh24:mi:ss') AS UPD_DT, " ).append("\n"); 
		query.append("       F.ATCH_FILE_OP_KNT" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM FMS_ATCH_FILE WHERE ATCH_FILE_LNK_ID = F.ATCH_FILE_FLET_LNK_ID ) AS ATCH_FILE_FLET_KNT    " ).append("\n"); 
		query.append("      ,F.ATCH_FILE_OP_LNK_ID" ).append("\n"); 
		query.append("	  ,F.ATCH_FILE_FLET_LNK_ID " ).append("\n"); 
		query.append("	  ,F.VNOR_SEQ " ).append("\n"); 
		query.append("      ,F.VNOR_ITM_SEQ      " ).append("\n"); 
		query.append("	  ,O.VNOR_OFFH_KND_CD" ).append("\n"); 
		query.append("      ,I.FLET_CTRT_NO" ).append("\n"); 
		query.append("      ,I.INV_SEQ" ).append("\n"); 
		query.append("FROM FMS_VNOR O, FMS_VNOR_ITM F, FMS_INV_DTL I, FMS_CONSULTATION C" ).append("\n"); 
		query.append("WHERE O.VSL_CD = F.VSL_CD" ).append("\n"); 
		query.append("  AND O.VNOR_SEQ = F.VNOR_SEQ  " ).append("\n"); 
		query.append("  AND F.VNOR_ITM_PROC_CD = 'P'" ).append("\n"); 
		query.append("  AND F.VSL_CD       = I.VSL_CD(+)" ).append("\n"); 
		query.append("  AND F.VNOR_SEQ     = I.VNOR_SEQ(+)" ).append("\n"); 
		query.append("  AND F.VNOR_ITM_SEQ = I.VNOR_ITM_SEQ(+)" ).append("\n"); 
		query.append("  AND I.SLP_TP_CD = C.SLP_TP_CD(+)" ).append("\n"); 
		query.append("  AND I.SLP_FUNC_CD = C.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("  AND I.SLP_OFC_CD = C.SLP_OFC_CD(+)" ).append("\n"); 
		query.append("  AND I.SLP_ISS_DT = C.SLP_ISS_DT(+)" ).append("\n"); 
		query.append("  AND I.SLP_SER_NO = C.SLP_SER_NO(+)" ).append("\n"); 
		query.append(") AA, (SELECT * FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03391') D  " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AA.vnor_offh_ind2 = D.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND AA.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vnor_offh_fm_dt} != '' && ${vnor_offh_to_dt} != '')" ).append("\n"); 
		query.append("AND (    AA.VNOR_OFFH_FM_DT2 >= TO_DATE(REPLACE(@[vnor_offh_fm_dt],'-','') || '0000','YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("	 AND AA.VNOR_OFFH_TO_DT2 <= TO_DATE(REPLACE(@[vnor_offh_to_dt],'-','') || '2359','YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vnor_offh_ind} != '')" ).append("\n"); 
		query.append("AND AA.vnor_offh_ind2 = @[vnor_offh_ind]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND AA.vnor_offh_ind2 IN ('A', 'N', 'S', 'C')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY  AA.VNOR_OFFH_FM_DT2, AA.VSL_CD, AA.SKD_VOY_NO" ).append("\n"); 

	}
}