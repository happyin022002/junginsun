/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOCreRfRdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOCreRfRdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR R/F Creation용
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOCreRfRdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_scg_stl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOCreRfRdrRSQL").append("\n"); 
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
		query.append("WITH  V_DATA AS (" ).append("\n"); 
		query.append("        SELECT A.ACCT_YRMON" ).append("\n"); 
		query.append("             , A.STL_VVD_SEQ" ).append("\n"); 
		query.append("             , A.JO_CRR_CD" ).append("\n"); 
		query.append("             , A.TRD_CD" ).append("\n"); 
		query.append("             , A.RLANE_CD" ).append("\n"); 
		query.append("             , A.RE_DIVR_CD" ).append("\n"); 
		query.append("             , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , A.JO_MNU_NM" ).append("\n"); 
		query.append("             , A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.REV_DIR_CD" ).append("\n"); 
		query.append("             , A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("             , TO_CHAR(A.ETA_DT,'YYYYMMDDHH24MISS') AS ETA_DT" ).append("\n"); 
		query.append("             , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("             , TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("             , A.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("             , A.IOC_CD" ).append("\n"); 
		query.append("             , A.SCONTI_CD" ).append("\n"); 
		query.append("             , A.FM_PORT_CD" ).append("\n"); 
		query.append("             , A.TO_PORT_CD" ).append("\n"); 
		query.append("             , A.FM_PORT_CD AS FM_PORT_CD1" ).append("\n"); 
		query.append("             , A.TO_PORT_CD AS TO_PORT_CD1" ).append("\n"); 
		query.append("             , B.STL_CMB_SEQ" ).append("\n"); 
		query.append("             , B.RVS_CMB_FLG" ).append("\n"); 
		query.append("             , B.SLIP_NO" ).append("\n"); 
		query.append("             , A.JO_STL_JB_CD" ).append("\n"); 
		query.append("             , A.USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("             , A.RF_SCG_PRC" ).append("\n"); 
		query.append("             , A.STL_LOCL_AMT" ).append("\n"); 
		query.append("             , A.STL_SEQ" ).append("\n"); 
		query.append("             , A.STL_DUP_FLG" ).append("\n"); 
		query.append("             , A.STL_ADJ_FLG" ).append("\n"); 
		query.append("             , A.STL_LST_FLG" ).append("\n"); 
		query.append("             , SUM(DECODE(A.JO_STL_JB_CD,'301',A.STL_LOCL_AMT,'302',A.STL_LOCL_AMT,0)) OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD) AS VVD_SUM_AMT" ).append("\n"); 
		query.append("          FROM JOO_SETTLEMENT A" ).append("\n"); 
		query.append("             , (SELECT B.ACCT_YRMON" ).append("\n"); 
		query.append("                     ,B.STL_VVD_SEQ" ).append("\n"); 
		query.append("                     ,B.STL_SEQ" ).append("\n"); 
		query.append("                     ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("                     ,A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO AS SLIP_NO" ).append("\n"); 
		query.append("                     ,A.RVS_CMB_FLG" ).append("\n"); 
		query.append("                  FROM JOO_STL_CMB A" ).append("\n"); 
		query.append("                     , JOO_STL_CMB_DTL B" ).append("\n"); 
		query.append("                 WHERE A.ACCT_YRMON = B.ACCT_YRMON" ).append("\n"); 
		query.append("                   AND A.JO_CRR_CD  = B.JO_CRR_CD" ).append("\n"); 
		query.append("                   AND A.STL_CMB_SEQ= B.STL_CMB_SEQ" ).append("\n"); 
		query.append("                   AND A.RE_DIVR_CD = B.RE_DIVR_CD" ).append("\n"); 
		query.append("                   AND A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("                   AND A.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("                   AND A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("                   -- 2010.01.06 REVERSE 된 것은 COMBINED NO가 보여져서는 안된다 => 삭제가능하게 " ).append("\n"); 
		query.append("                   -- 2010.03.23 REVERSE 된 것은 settlement를 copy하므로 기존 settlement는 combined no를 보여주고 삭제불가하다." ).append("\n"); 
		query.append("               ) B" ).append("\n"); 
		query.append("         WHERE A.ACCT_YRMON     = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("           AND A.STL_VVD_SEQ    = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("           AND A.STL_SEQ        = B.STL_SEQ (+)" ).append("\n"); 
		query.append("           AND A.ACCT_YRMON     = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("           AND A.JO_CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("           AND A.RE_DIVR_CD     = @[re_divr_cd]" ).append("\n"); 
		query.append("           AND A.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("           AND A.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("           AND A.JO_STL_ITM_CD  = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("           AND A.JO_MNU_NM      = @[jo_mnu_nm]" ).append("\n"); 
		query.append("           AND (A.RF_SCG_STL_TP_CD = 'U' OR A.RF_SCG_STL_TP_CD = @[rf_scg_stl_tp_cd])" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("SELECT 'R' AS IBFLAG " ).append("\n"); 
		query.append("     , ACCT_YRMON" ).append("\n"); 
		query.append("     , STL_VVD_SEQ" ).append("\n"); 
		query.append("     , JO_CRR_CD" ).append("\n"); 
		query.append("     , TRD_CD" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , RE_DIVR_CD" ).append("\n"); 
		query.append("     , JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , JO_MNU_NM" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , REV_DIR_CD" ).append("\n"); 
		query.append("     , STL_BZC_PORT_CD" ).append("\n"); 
		query.append("     , ETA_DT" ).append("\n"); 
		query.append("     , LOCL_CURR_CD" ).append("\n"); 
		query.append("     , UC_BSS_PORT_CD" ).append("\n"); 
		query.append("     , UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("     , RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("     , IOC_CD" ).append("\n"); 
		query.append("     , SCONTI_CD" ).append("\n"); 
		query.append("     , FM_PORT_CD" ).append("\n"); 
		query.append("     , TO_PORT_CD" ).append("\n"); 
		query.append("     , FM_PORT_CD1" ).append("\n"); 
		query.append("     , TO_PORT_CD1" ).append("\n"); 
		query.append("     , VVD_SUM_AMT" ).append("\n"); 
		query.append("     , STL_CMB_SEQ" ).append("\n"); 
		query.append("     , SLIP_NO" ).append("\n"); 
		query.append("     , SUM(USD_SLT_BSA_QTY_20)  AS USD_SLT_BSA_QTY_20" ).append("\n"); 
		query.append("     , SUM(USD_SLT_BSA_QTY_40)  AS USD_SLT_BSA_QTY_40" ).append("\n"); 
		query.append("     , SUM(RF_SCG_PRC_20)       AS RF_SCG_PRC_20" ).append("\n"); 
		query.append("     , SUM(RF_SCG_PRC_40)       AS RF_SCG_PRC_40" ).append("\n"); 
		query.append("     , SUM(STL_LOCL_AMT_20)     AS STL_LOCL_AMT_20" ).append("\n"); 
		query.append("     , SUM(STL_LOCL_AMT_40)     AS STL_LOCL_AMT_40" ).append("\n"); 
		query.append("     , STL_SEQ_20" ).append("\n"); 
		query.append("     , STL_SEQ_40" ).append("\n"); 
		query.append("     , MAX(RVS_CMB_FLG_20)      AS RVS_CMB_FLG_20" ).append("\n"); 
		query.append("     , MAX(RVS_CMB_FLG_40)      AS RVS_CMB_FLG_40" ).append("\n"); 
		query.append("     , MIN(STL_DUP_FLG_20)      AS STL_DUP_FLG_20" ).append("\n"); 
		query.append("     , MIN(STL_DUP_FLG_40)      AS STL_DUP_FLG_40" ).append("\n"); 
		query.append("     , MIN(STL_ADJ_FLG_20)      AS STL_ADJ_FLG_20" ).append("\n"); 
		query.append("     , MIN(STL_ADJ_FLG_40)      AS STL_ADJ_FLG_40" ).append("\n"); 
		query.append("     , MIN(STL_LST_FLG_20)      AS STL_LST_FLG_20" ).append("\n"); 
		query.append("     , MIN(STL_LST_FLG_40)      AS STL_LST_FLG_40" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.ACCT_YRMON" ).append("\n"); 
		query.append("             , A.STL_VVD_SEQ" ).append("\n"); 
		query.append("             , A.JO_CRR_CD" ).append("\n"); 
		query.append("             , A.TRD_CD" ).append("\n"); 
		query.append("             , A.RLANE_CD" ).append("\n"); 
		query.append("             , A.RE_DIVR_CD" ).append("\n"); 
		query.append("             , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , A.JO_MNU_NM" ).append("\n"); 
		query.append("             , A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.REV_DIR_CD" ).append("\n"); 
		query.append("             , A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("             , A.ETA_DT" ).append("\n"); 
		query.append("             , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("             , A.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("             , A.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("             , A.IOC_CD" ).append("\n"); 
		query.append("             , A.SCONTI_CD" ).append("\n"); 
		query.append("             , A.FM_PORT_CD" ).append("\n"); 
		query.append("             , A.TO_PORT_CD" ).append("\n"); 
		query.append("             , A.FM_PORT_CD1" ).append("\n"); 
		query.append("             , A.TO_PORT_CD1" ).append("\n"); 
		query.append("             , A.VVD_SUM_AMT" ).append("\n"); 
		query.append("             , 'N'                      AS DUP_FLG" ).append("\n"); 
		query.append("             , A.STL_CMB_SEQ            AS STL_CMB_SEQ" ).append("\n"); 
		query.append("             , NVL(A.RVS_CMB_FLG,'N')   AS RVS_CMB_FLG" ).append("\n"); 
		query.append("             , A.SLIP_NO                AS SLIP_NO" ).append("\n"); 
		query.append("             , A.USD_SLT_BSA_QTY        AS USD_SLT_BSA_QTY_20" ).append("\n"); 
		query.append("             , NULL                     AS USD_SLT_BSA_QTY_40" ).append("\n"); 
		query.append("             , A.RF_SCG_PRC             AS RF_SCG_PRC_20" ).append("\n"); 
		query.append("             , NULL                     AS RF_SCG_PRC_40" ).append("\n"); 
		query.append("             , A.STL_LOCL_AMT           AS STL_LOCL_AMT_20" ).append("\n"); 
		query.append("             , NULL                     AS STL_LOCL_AMT_40" ).append("\n"); 
		query.append("             , A.STL_SEQ                AS STL_SEQ_20" ).append("\n"); 
		query.append("             , (A.STL_SEQ + 1)          AS STL_SEQ_40" ).append("\n"); 
		query.append("             , NVL(A.RVS_CMB_FLG,'N')   AS RVS_CMB_FLG_20" ).append("\n"); 
		query.append("             , NVL(A.RVS_CMB_FLG,'N')   AS RVS_CMB_FLG_40" ).append("\n"); 
		query.append("             , A.STL_DUP_FLG            AS STL_DUP_FLG_20" ).append("\n"); 
		query.append("             , A.STL_DUP_FLG            AS STL_DUP_FLG_40" ).append("\n"); 
		query.append("             , A.STL_ADJ_FLG            AS STL_ADJ_FLG_20" ).append("\n"); 
		query.append("             , A.STL_ADJ_FLG            AS STL_ADJ_FLG_40" ).append("\n"); 
		query.append("             , A.STL_LST_FLG            AS STL_LST_FLG_20" ).append("\n"); 
		query.append("             , A.STL_LST_FLG            AS STL_LST_FLG_40" ).append("\n"); 
		query.append("          FROM V_DATA A" ).append("\n"); 
		query.append("        WHERE A.JO_STL_JB_CD = '301'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT A.ACCT_YRMON" ).append("\n"); 
		query.append("             , A.STL_VVD_SEQ" ).append("\n"); 
		query.append("             , A.JO_CRR_CD" ).append("\n"); 
		query.append("             , A.TRD_CD" ).append("\n"); 
		query.append("             , A.RLANE_CD" ).append("\n"); 
		query.append("             , A.RE_DIVR_CD" ).append("\n"); 
		query.append("             , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , A.JO_MNU_NM" ).append("\n"); 
		query.append("             , A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.REV_DIR_CD" ).append("\n"); 
		query.append("             , A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("             , A.ETA_DT" ).append("\n"); 
		query.append("             , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("             , A.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("             , A.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("             , A.IOC_CD" ).append("\n"); 
		query.append("             , A.SCONTI_CD" ).append("\n"); 
		query.append("             , A.FM_PORT_CD" ).append("\n"); 
		query.append("             , A.TO_PORT_CD" ).append("\n"); 
		query.append("             , A.FM_PORT_CD1" ).append("\n"); 
		query.append("             , A.TO_PORT_CD1" ).append("\n"); 
		query.append("             , A.VVD_SUM_AMT" ).append("\n"); 
		query.append("             , 'N'                      AS DUP_FLG" ).append("\n"); 
		query.append("             , A.STL_CMB_SEQ            AS STL_CMB_SEQ" ).append("\n"); 
		query.append("             , NVL(A.RVS_CMB_FLG,'N')   AS RVS_CMB_FLG" ).append("\n"); 
		query.append("             , A.SLIP_NO                AS SLIP_NO" ).append("\n"); 
		query.append("             , NULL                     AS USD_SLT_BSA_QTY_20" ).append("\n"); 
		query.append("             , A.USD_SLT_BSA_QTY        AS USD_SLT_BSA_QTY_40" ).append("\n"); 
		query.append("             , NULL                     AS RF_SCG_PRC_20" ).append("\n"); 
		query.append("             , A.RF_SCG_PRC             AS RF_SCG_PRC_40" ).append("\n"); 
		query.append("             , NULL                     AS STL_LOCL_AMT_20" ).append("\n"); 
		query.append("             , A.STL_LOCL_AMT           AS STL_LOCL_AMT_40" ).append("\n"); 
		query.append("             , (A.STL_SEQ - 1)          AS STL_SEQ_20" ).append("\n"); 
		query.append("             , A.STL_SEQ                AS STL_SEQ_40" ).append("\n"); 
		query.append("             , NVL(A.RVS_CMB_FLG,'N')   AS RVS_CMB_FLG_20" ).append("\n"); 
		query.append("             , NVL(A.RVS_CMB_FLG,'N')   AS RVS_CMB_FLG_40" ).append("\n"); 
		query.append("             , A.STL_DUP_FLG            AS STL_DUP_FLG_20" ).append("\n"); 
		query.append("             , A.STL_DUP_FLG            AS STL_DUP_FLG_40" ).append("\n"); 
		query.append("             , A.STL_ADJ_FLG            AS STL_ADJ_FLG_20" ).append("\n"); 
		query.append("             , A.STL_ADJ_FLG            AS STL_ADJ_FLG_40" ).append("\n"); 
		query.append("             , A.STL_LST_FLG            AS STL_LST_FLG_20" ).append("\n"); 
		query.append("             , A.STL_LST_FLG            AS STL_LST_FLG_40" ).append("\n"); 
		query.append("          FROM V_DATA A" ).append("\n"); 
		query.append("        WHERE A.JO_STL_JB_CD = '302'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("GROUP BY ACCT_YRMON" ).append("\n"); 
		query.append("     , STL_VVD_SEQ" ).append("\n"); 
		query.append("     , JO_CRR_CD" ).append("\n"); 
		query.append("     , TRD_CD" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , RE_DIVR_CD" ).append("\n"); 
		query.append("     , JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , JO_MNU_NM" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , REV_DIR_CD" ).append("\n"); 
		query.append("     , STL_BZC_PORT_CD" ).append("\n"); 
		query.append("     , ETA_DT" ).append("\n"); 
		query.append("     , LOCL_CURR_CD" ).append("\n"); 
		query.append("     , UC_BSS_PORT_CD" ).append("\n"); 
		query.append("     , UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("     , RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("     , IOC_CD" ).append("\n"); 
		query.append("     , SCONTI_CD" ).append("\n"); 
		query.append("     , FM_PORT_CD" ).append("\n"); 
		query.append("     , TO_PORT_CD" ).append("\n"); 
		query.append("     , FM_PORT_CD1" ).append("\n"); 
		query.append("     , TO_PORT_CD1" ).append("\n"); 
		query.append("     , VVD_SUM_AMT" ).append("\n"); 
		query.append("     , STL_CMB_SEQ" ).append("\n"); 
		query.append("     , SLIP_NO" ).append("\n"); 
		query.append("     , STL_SEQ_20" ).append("\n"); 
		query.append("     , STL_SEQ_40" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    'I' AS IBFLAG" ).append("\n"); 
		query.append("    , T.ACCT_YRMON" ).append("\n"); 
		query.append("    , T.STL_VVD_SEQ" ).append("\n"); 
		query.append("    , T.JO_CRR_CD" ).append("\n"); 
		query.append("    , T.TRD_CD" ).append("\n"); 
		query.append("    , T.RLANE_CD" ).append("\n"); 
		query.append("    , T.RE_DIVR_CD" ).append("\n"); 
		query.append("    , T.JO_STL_ITM_CD" ).append("\n"); 
		query.append("    , T.JO_MNU_NM" ).append("\n"); 
		query.append("    , T.VSL_CD" ).append("\n"); 
		query.append("    , T.SKD_VOY_NO" ).append("\n"); 
		query.append("    , T.SKD_DIR_CD" ).append("\n"); 
		query.append("    , T.REV_DIR_CD" ).append("\n"); 
		query.append("    , T.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("    , TO_CHAR(T.BZC_PORT_ETA_DT,'YYYYMMDDHH24MISS') AS ETA_DT" ).append("\n"); 
		query.append("    , F.LOCL_CURR_CD" ).append("\n"); 
		query.append("    , T.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("    , TO_CHAR(T.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("    , @[rf_scg_stl_tp_cd] AS RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("    , '' AS IOC_CD" ).append("\n"); 
		query.append("    , '' AS SCONTI_CD" ).append("\n"); 
		query.append("    , '' AS FM_PORT_CD" ).append("\n"); 
		query.append("    , '' AS TO_PORT_CD" ).append("\n"); 
		query.append("    , '' AS FM_PORT_CD1" ).append("\n"); 
		query.append("    , '' AS TO_PORT_CD1" ).append("\n"); 
		query.append("    , 0  AS VVD_SUM_AMT" ).append("\n"); 
		query.append("    , NULL AS STL_CMB_SEQ" ).append("\n"); 
		query.append("    , NULL AS SLIP_NO" ).append("\n"); 
		query.append("    , NULL AS USD_SLT_BSA_QTY_20" ).append("\n"); 
		query.append("    , NULL AS USD_SLT_BSA_QTY_40" ).append("\n"); 
		query.append("    , NULL AS USD_RF_SCG_PRC_20" ).append("\n"); 
		query.append("    , NULL AS USD_RF_SCG_PRC_40" ).append("\n"); 
		query.append("    , NULL AS STL_LOCL_AMT_20" ).append("\n"); 
		query.append("    , NULL AS STL_LOCL_AMT_40" ).append("\n"); 
		query.append("    , NULL AS STL_SEQ_20" ).append("\n"); 
		query.append("    , NULL AS STL_SEQ_40" ).append("\n"); 
		query.append("    , 'N' AS RVS_CMB_FLG_20" ).append("\n"); 
		query.append("    , 'N' AS RVS_CMB_FLG_40" ).append("\n"); 
		query.append("    , 'N' AS STL_DUP_FLG_20" ).append("\n"); 
		query.append("    , 'N' AS STL_DUP_FLG_40" ).append("\n"); 
		query.append("    , 'N' AS STL_ADJ_FLG_20" ).append("\n"); 
		query.append("    , 'N' AS STL_ADJ_FLG_40" ).append("\n"); 
		query.append("    , 'Y' AS STL_LST_FLG_20" ).append("\n"); 
		query.append("    , 'Y' AS STL_LST_FLG_40    " ).append("\n"); 
		query.append("FROM  JOO_STL_VVD T" ).append("\n"); 
		query.append("    , JOO_FINC_MTX F" ).append("\n"); 
		query.append("WHERE T.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND   T.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND   T.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("AND   T.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("AND   T.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("AND   T.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("AND   T.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("AND   T.JO_STL_CFM_CD = 'Y' " ).append("\n"); 
		query.append("AND   T.JO_CRR_CD     = F.JO_CRR_CD    (+)" ).append("\n"); 
		query.append("AND   T.RLANE_CD      = F.RLANE_CD     (+)" ).append("\n"); 
		query.append("AND   T.RE_DIVR_CD    = F.RE_DIVR_CD   (+)" ).append("\n"); 
		query.append("AND   T.JO_MNU_NM     = F.JO_STL_ITM_CD(+)         " ).append("\n"); 
		query.append("AND  (T.VSL_CD, T.SKD_VOY_NO, T.SKD_DIR_CD, T.REV_DIR_CD, 'N') NOT IN (" ).append("\n"); 
		query.append("        SELECT X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.REV_DIR_CD, NVL(Y.RVS_CMB_FLG,'N') AS RVS_CMB_FLG" ).append("\n"); 
		query.append("        FROM   JOO_SETTLEMENT  X," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               SELECT Y.ACCT_YRMON, Y.STL_VVD_SEQ, Y.STL_SEQ, Z.RVS_CMB_FLG" ).append("\n"); 
		query.append("               FROM   JOO_STL_CMB_DTL Y," ).append("\n"); 
		query.append("                      JOO_STL_CMB     Z" ).append("\n"); 
		query.append("               WHERE  Y.ACCT_YRMON = Z.ACCT_YRMON" ).append("\n"); 
		query.append("               AND    Y.JO_CRR_CD  = Z.JO_CRR_CD" ).append("\n"); 
		query.append("               AND    Y.STL_CMB_SEQ= Z.STL_CMB_SEQ" ).append("\n"); 
		query.append("               AND    Y.RE_DIVR_CD = Z.RE_DIVR_CD" ).append("\n"); 
		query.append("               ) Y" ).append("\n"); 
		query.append("        WHERE  X.ACCT_YRMON     = Y.ACCT_YRMON  (+)" ).append("\n"); 
		query.append("        AND    X.STL_VVD_SEQ    = Y.STL_VVD_SEQ (+)" ).append("\n"); 
		query.append("        AND    X.STL_SEQ        = Y.STL_SEQ     (+) " ).append("\n"); 
		query.append("        AND    X.ACCT_YRMON     = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("        AND    X.JO_CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("        AND    X.RE_DIVR_CD     = @[re_divr_cd]" ).append("\n"); 
		query.append("        AND    X.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("        AND    X.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("        AND    X.JO_STL_ITM_CD  = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("        AND    X.JO_MNU_NM      = @[jo_mnu_nm]" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("AND   NOT EXISTS (" ).append("\n"); 
		query.append("       SELECT 1" ).append("\n"); 
		query.append("       FROM   JOO_SETTLEMENT  X" ).append("\n"); 
		query.append("       WHERE  X.ACCT_YRMON     = T.ACCT_YRMON" ).append("\n"); 
		query.append("       AND    X.JO_CRR_CD      = T.JO_CRR_CD" ).append("\n"); 
		query.append("       AND    X.RE_DIVR_CD     = T.RE_DIVR_CD" ).append("\n"); 
		query.append("       AND    X.TRD_CD         = T.TRD_CD" ).append("\n"); 
		query.append("       AND    X.RLANE_CD       = T.RLANE_CD" ).append("\n"); 
		query.append("       AND    X.JO_STL_ITM_CD  = T.JO_STL_ITM_CD" ).append("\n"); 
		query.append("       AND    X.JO_MNU_NM      = T.JO_MNU_NM" ).append("\n"); 
		query.append("       AND    X.VSL_CD         = T.VSL_CD" ).append("\n"); 
		query.append("       AND    X.SKD_VOY_NO     = T.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND    X.SKD_DIR_CD     = T.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND    X.REV_DIR_CD     = T.REV_DIR_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("ORDER BY  IBFLAG DESC, ACCT_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, STL_CMB_SEQ, STL_SEQ_20, FM_PORT_CD, TO_PORT_CD" ).append("\n"); 

	}
}