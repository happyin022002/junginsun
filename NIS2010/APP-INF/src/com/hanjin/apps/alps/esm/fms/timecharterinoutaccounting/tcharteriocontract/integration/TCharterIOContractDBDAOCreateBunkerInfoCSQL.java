/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TCharterIOContractDBDAOCreateBunkerInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOContractDBDAOCreateBunkerInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Create Bunker Info
	  * </pre>
	  */
	public TCharterIOContractDBDAOCreateBunkerInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOContractDBDAOCreateBunkerInfoCSQL").append("\n"); 
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
		query.append("MERGE INTO FMS_BUNKER TBL" ).append("\n"); 
		query.append("USING (SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("			  'BOD'            AS BNK_TP_CD," ).append("\n"); 
		query.append("              '33'             AS ACCT_ITM_SEQ," ).append("\n"); 
		query.append("              ACT_FOIL_BOD_QTY AS BNK_QTY," ).append("\n"); 
		query.append("              FOIL_BOD_OUT_PRC AS BNK_PRC_AMT," ).append("\n"); 
		query.append("              BOD_PORT_CD      AS PORT_CD," ).append("\n"); 
		query.append("              EFF_DT           AS BNK_DT," ).append("\n"); 
		query.append("              (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD" ).append("\n"); 
		query.append("               FROM FMS_VVD" ).append("\n"); 
		query.append("               WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("               AND TO_CHAR(A.EFF_DT, 'YYYYMMDD') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append("               AND ROWNUM = 1) VVD_CD" ).append("\n"); 
		query.append("       FROM FMS_CONTRACT A" ).append("\n"); 
		query.append("       WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("       AND (ACT_FOIL_BOD_QTY IS NOT NULL OR FOIL_BOD_OUT_PRC IS NOT NULL)" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("			  'BOD'            AS BNK_TP_CD," ).append("\n"); 
		query.append("              '34'             AS ACCT_ITM_SEQ," ).append("\n"); 
		query.append("              ACT_DOIL_BOD_QTY AS BNK_QTY," ).append("\n"); 
		query.append("              DOIL_BOD_OUT_PRC AS BNK_PRC_AMT," ).append("\n"); 
		query.append("              BOD_PORT_CD      AS PORT_CD," ).append("\n"); 
		query.append("              EFF_DT           AS BNK_DT," ).append("\n"); 
		query.append("              (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD" ).append("\n"); 
		query.append("               FROM FMS_VVD" ).append("\n"); 
		query.append("               WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("               AND TO_CHAR(A.EFF_DT, 'YYYYMMDD') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append("               AND ROWNUM = 1) VVD_CD" ).append("\n"); 
		query.append("       FROM FMS_CONTRACT A" ).append("\n"); 
		query.append("       WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("       AND (ACT_DOIL_BOD_QTY IS NOT NULL OR DOIL_BOD_OUT_PRC IS NOT NULL)" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("			  'BOD'                     AS BNK_TP_CD," ).append("\n"); 
		query.append("              '43'                      AS ACCT_ITM_SEQ," ).append("\n"); 
		query.append("              ACT_LOW_SULP_FOIL_BOD_QTY AS BNK_QTY," ).append("\n"); 
		query.append("              LOW_SULP_FOIL_BOD_OUT_PRC AS BNK_PRC_AMT," ).append("\n"); 
		query.append("              BOD_PORT_CD               AS PORT_CD," ).append("\n"); 
		query.append("              EFF_DT                    AS BNK_DT," ).append("\n"); 
		query.append("              (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD" ).append("\n"); 
		query.append("               FROM FMS_VVD" ).append("\n"); 
		query.append("               WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("               AND TO_CHAR(A.EFF_DT, 'YYYYMMDD') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append("               AND ROWNUM = 1) VVD_CD" ).append("\n"); 
		query.append("       FROM FMS_CONTRACT A" ).append("\n"); 
		query.append("       WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("       AND (ACT_LOW_SULP_FOIL_BOD_QTY IS NOT NULL OR LOW_SULP_FOIL_BOD_OUT_PRC IS NOT NULL)" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("			  'BOD'                        AS BNK_TP_CD," ).append("\n"); 
		query.append("              '70'                         AS ACCT_ITM_SEQ," ).append("\n"); 
		query.append("              ACT_LOW_SULP_GAS_OIL_BOD_QTY AS BNK_QTY," ).append("\n"); 
		query.append("              LOW_SULP_GAS_OIL_BOD_OUT_PRC AS BNK_PRC_AMT," ).append("\n"); 
		query.append("              BOD_PORT_CD                  AS PORT_CD," ).append("\n"); 
		query.append("              EFF_DT                       AS BNK_DT," ).append("\n"); 
		query.append("              (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD" ).append("\n"); 
		query.append("               FROM FMS_VVD" ).append("\n"); 
		query.append("               WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("               AND TO_CHAR(A.EFF_DT, 'YYYYMMDD') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append("               AND ROWNUM = 1) VVD_CD" ).append("\n"); 
		query.append("       FROM FMS_CONTRACT A" ).append("\n"); 
		query.append("       WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("       AND (ACT_LOW_SULP_GAS_OIL_BOD_QTY IS NOT NULL OR LOW_SULP_GAS_OIL_BOD_OUT_PRC IS NOT NULL)" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("			  'BOR'            AS BNK_TP_CD," ).append("\n"); 
		query.append("              '33'             AS ACCT_ITM_SEQ," ).append("\n"); 
		query.append("              ACT_FOIL_BOR_QTY AS BNK_QTY," ).append("\n"); 
		query.append("              FOIL_BOR_OUT_PRC AS BNK_PRC_AMT," ).append("\n"); 
		query.append("              BOR_PORT_CD      AS PORT_CD," ).append("\n"); 
		query.append("              EXP_DT           AS BNK_DT," ).append("\n"); 
		query.append("              (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD" ).append("\n"); 
		query.append("               FROM FMS_VVD" ).append("\n"); 
		query.append("               WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("               AND TO_CHAR(A.EXP_DT, 'YYYYMMDD') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append("               AND ROWNUM = 1) VVD_CD" ).append("\n"); 
		query.append("       FROM FMS_CONTRACT A" ).append("\n"); 
		query.append("       WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("       AND (ACT_FOIL_BOR_QTY IS NOT NULL OR FOIL_BOR_OUT_PRC IS NOT NULL)" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("			  'BOR'            AS BNK_TP_CD," ).append("\n"); 
		query.append("              '34'             AS ACCT_ITM_SEQ," ).append("\n"); 
		query.append("              ACT_DOIL_BOR_QTY AS BNK_QTY," ).append("\n"); 
		query.append("              DOIL_BOR_OUT_PRC AS BNK_PRC_AMT," ).append("\n"); 
		query.append("              BOR_PORT_CD      AS PORT_CD," ).append("\n"); 
		query.append("              EXP_DT           AS BNK_DT," ).append("\n"); 
		query.append("              (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD" ).append("\n"); 
		query.append("               FROM FMS_VVD" ).append("\n"); 
		query.append("               WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("               AND TO_CHAR(A.EXP_DT, 'YYYYMMDD') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append("               AND ROWNUM = 1) VVD_CD" ).append("\n"); 
		query.append("       FROM FMS_CONTRACT A" ).append("\n"); 
		query.append("       WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("       AND (ACT_DOIL_BOR_QTY IS NOT NULL OR DOIL_BOR_OUT_PRC IS NOT NULL)" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("			  'BOR'                     AS BNK_TP_CD," ).append("\n"); 
		query.append("              '43'                      AS ACCT_ITM_SEQ," ).append("\n"); 
		query.append("              ACT_LOW_SULP_FOIL_BOR_QTY AS BNK_QTY," ).append("\n"); 
		query.append("              LOW_SULP_FOIL_BOR_OUT_PRC AS BNK_PRC_AMT," ).append("\n"); 
		query.append("              BOR_PORT_CD               AS PORT_CD," ).append("\n"); 
		query.append("              EXP_DT                    AS BNK_DT," ).append("\n"); 
		query.append("              (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD" ).append("\n"); 
		query.append("               FROM FMS_VVD" ).append("\n"); 
		query.append("               WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("               AND TO_CHAR(A.EXP_DT, 'YYYYMMDD') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append("               AND ROWNUM = 1) VVD_CD" ).append("\n"); 
		query.append("       FROM FMS_CONTRACT A" ).append("\n"); 
		query.append("       WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("       AND (ACT_LOW_SULP_FOIL_BOR_QTY IS NOT NULL OR LOW_SULP_FOIL_BOR_OUT_PRC IS NOT NULL)" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("			  'BOR'                        AS BNK_TP_CD," ).append("\n"); 
		query.append("              '70'                         AS ACCT_ITM_SEQ," ).append("\n"); 
		query.append("              ACT_LOW_SULP_GAS_OIL_BOR_QTY AS BNK_QTY," ).append("\n"); 
		query.append("              LOW_SULP_GAS_OIL_BOR_OUT_PRC AS BNK_PRC_AMT," ).append("\n"); 
		query.append("              BOR_PORT_CD                  AS PORT_CD," ).append("\n"); 
		query.append("              EXP_DT                       AS BNK_DT," ).append("\n"); 
		query.append("              (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD" ).append("\n"); 
		query.append("               FROM FMS_VVD" ).append("\n"); 
		query.append("               WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("               AND TO_CHAR(A.EXP_DT, 'YYYYMMDD') BETWEEN VST_DT AND VED_DT" ).append("\n"); 
		query.append("               AND ROWNUM = 1) VVD_CD" ).append("\n"); 
		query.append("       FROM FMS_CONTRACT A" ).append("\n"); 
		query.append("       WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("       AND (ACT_LOW_SULP_GAS_OIL_BOR_QTY IS NOT NULL OR LOW_SULP_GAS_OIL_BOR_OUT_PRC IS NOT NULL)" ).append("\n"); 
		query.append(") PSD ON (TBL.FLET_CTRT_NO     = PSD.FLET_CTRT_NO" ).append("\n"); 
		query.append("          AND TBL.BNK_TP_CD    = PSD.BNK_TP_CD" ).append("\n"); 
		query.append("          AND TBL.ACCT_ITM_SEQ = PSD.ACCT_ITM_SEQ)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("  SET TBL.BNK_YRMON   = DECODE(TBL.SLP_TP_CD, '', TO_CHAR(PSD.BNK_DT, 'YYYYMM'), TBL.BNK_YRMON)," ).append("\n"); 
		query.append("      TBL.BNK_DT      = DECODE(TBL.SLP_TP_CD, '', PSD.BNK_DT, TBL.BNK_DT)," ).append("\n"); 
		query.append("      TBL.PORT_CD     = DECODE(TBL.SLP_TP_CD, '', PSD.PORT_CD, TBL.PORT_CD)," ).append("\n"); 
		query.append("      TBL.BNK_QTY     = DECODE(TBL.SLP_TP_CD, '', NVL(PSD.BNK_QTY, 0), TBL.BNK_QTY)," ).append("\n"); 
		query.append("      TBL.BNK_PRC_AMT = DECODE(TBL.SLP_TP_CD, '', NVL(PSD.BNK_PRC_AMT, 0), TBL.BNK_PRC_AMT)," ).append("\n"); 
		query.append("      TBL.BNK_AMT     = DECODE(TBL.SLP_TP_CD, '', NVL(PSD.BNK_QTY, 0) * NVL(PSD.BNK_PRC_AMT, 0), TBL.BNK_AMT),     " ).append("\n"); 
		query.append("      TBL.UPD_USR_ID  = DECODE(TBL.SLP_TP_CD, '', @[usr_id], TBL.UPD_USR_ID)," ).append("\n"); 
		query.append("      TBL.UPD_DT      = DECODE(TBL.SLP_TP_CD, '', SYSDATE, TBL.UPD_DT)              " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("      TBL.FLET_CTRT_NO" ).append("\n"); 
		query.append("    , TBL.BNK_SEQ" ).append("\n"); 
		query.append("    , TBL.BNK_YRMON" ).append("\n"); 
		query.append("    , TBL.BNK_TP_CD" ).append("\n"); 
		query.append("    , TBL.ACCT_CD" ).append("\n"); 
		query.append("    , TBL.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("    , TBL.BNK_DT" ).append("\n"); 
		query.append("    , TBL.VSL_CD" ).append("\n"); 
		query.append("    , TBL.SKD_VOY_NO" ).append("\n"); 
		query.append("    , TBL.SKD_DIR_CD" ).append("\n"); 
		query.append("    , TBL.REV_DIR_CD" ).append("\n"); 
		query.append("    , TBL.PORT_CD" ).append("\n"); 
		query.append("    , TBL.FLET_MEAS_UT_CD" ).append("\n"); 
		query.append("    , TBL.BNK_QTY" ).append("\n"); 
		query.append("    , TBL.BNK_PRC_AMT" ).append("\n"); 
		query.append("    , TBL.CRE_USR_ID" ).append("\n"); 
		query.append("    , TBL.CRE_DT" ).append("\n"); 
		query.append("    , TBL.UPD_USR_ID" ).append("\n"); 
		query.append("    , TBL.UPD_DT" ).append("\n"); 
		query.append("    , TBL.BNK_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("      PSD.FLET_CTRT_NO" ).append("\n"); 
		query.append("    , FMS_BNK_SEQ.NEXTVAL" ).append("\n"); 
		query.append("    , TO_CHAR(PSD.BNK_DT, 'YYYYMM')" ).append("\n"); 
		query.append("    , PSD.BNK_TP_CD" ).append("\n"); 
		query.append("    , (SELECT ACCT_CD" ).append("\n"); 
		query.append("       FROM FMS_ACCT_CATE" ).append("\n"); 
		query.append("       WHERE FLET_ACCT_CATE_CD = 'BU'" ).append("\n"); 
		query.append("       AND ACCT_ITM_SEQ = PSD.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("       AND ROWNUM = 1)" ).append("\n"); 
		query.append("    , PSD.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("    , PSD.BNK_DT" ).append("\n"); 
		query.append("    , '' --SUBSTR(PSD.VVD_CD, 1, 4)" ).append("\n"); 
		query.append("    , '' --SUBSTR(PSD.VVD_CD, 5, 4)" ).append("\n"); 
		query.append("    , '' --SUBSTR(PSD.VVD_CD, 9, 1)" ).append("\n"); 
		query.append("    , '' --SUBSTR(PSD.VVD_CD, 10, 1)" ).append("\n"); 
		query.append("    , PSD.PORT_CD" ).append("\n"); 
		query.append("    , 'M'" ).append("\n"); 
		query.append("    , NVL(PSD.BNK_QTY, 0)" ).append("\n"); 
		query.append("    , NVL(PSD.BNK_PRC_AMT, 0)" ).append("\n"); 
		query.append("    , @[usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , NVL(PSD.BNK_QTY, 0) * NVL(PSD.BNK_PRC_AMT, 0)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}