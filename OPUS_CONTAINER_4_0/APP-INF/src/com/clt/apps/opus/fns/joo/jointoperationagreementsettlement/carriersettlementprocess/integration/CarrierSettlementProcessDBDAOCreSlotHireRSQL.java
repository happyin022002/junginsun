/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOCreSlotHireRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.22 
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

public class CarrierSettlementProcessDBDAOCreSlotHireRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Slot Hire 의 Create용 Query
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOCreSlotHireRSQL(){
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
		query.append("FileName : CarrierSettlementProcessDBDAOCreSlotHireRSQL").append("\n"); 
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
		query.append("WITH V_BSA AS(" ).append("\n"); 
		query.append("    SELECT C.VSL_CD" ).append("\n"); 
		query.append("         , C.SKD_VOY_NO" ).append("\n"); 
		query.append("         , C.SKD_DIR_CD" ).append("\n"); 
		query.append("         , C.RLANE_CD" ).append("\n"); 
		query.append("         , C.BSA_OP_JB_CD" ).append("\n"); 
		query.append("         , C.CRR_BSA_CAPA AS BSA_QTY" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '' && ${jo_stl_itm_cd} == 'OPR' && ${sch_tp_cd} != 'P')" ).append("\n"); 
		query.append("		 , C.OP_SLT_PRC_CAPA AS BSA_SLT_PRC" ).append("\n"); 
		query.append("		 , C.OP_CRR_PERF_AMT  AS STL_LOCL_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		 , C.SLT_PRC_CAPA AS BSA_SLT_PRC" ).append("\n"); 
		query.append(" 		 , C.CRR_PERF_AMT AS STL_LOCL_AMT" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("	  FROM BSA_VVD_CRR_PERF C" ).append("\n"); 
		query.append("     WHERE  1 = 1" ).append("\n"); 
		query.append("#if(${re_divr_cd} =='R')" ).append("\n"); 
		query.append("       AND C.BSA_OP_JB_CD IN ('001','002','004')" ).append("\n"); 
		query.append("#elseif(${re_divr_cd} =='E')" ).append("\n"); 
		query.append("	   AND C.BSA_OP_JB_CD IN ('000','003','005')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '' && ${jo_stl_itm_cd} == 'OPR' && ${sch_tp_cd} != 'P') " ).append("\n"); 
		query.append("	   AND (C.CRR_BSA_CAPA <> 0 OR C.OP_SLT_PRC_CAPA <> 0) /*OPR*/" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	   AND (C.CRR_BSA_CAPA <> 0 OR C.SLT_PRC_CAPA <> 0) /*S/H*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	   AND C.CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("	   AND C.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("	   AND C.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--SELECT * FROM V_BSA;" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		  'R' AS IBFLAG" ).append("\n"); 
		query.append("		  ,A.ACCT_YRMON" ).append("\n"); 
		query.append("		  ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("		  ,A.STL_SEQ" ).append("\n"); 
		query.append("		  ,A.TRD_CD" ).append("\n"); 
		query.append("		  ,A.JO_CRR_CD" ).append("\n"); 
		query.append("		  ,A.RLANE_CD" ).append("\n"); 
		query.append("		  ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("		  ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("		  ,A.JO_MNU_NM" ).append("\n"); 
		query.append("		  ,A.VSL_CD" ).append("\n"); 
		query.append("		  ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("		  ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("		  ,A.REV_DIR_CD" ).append("\n"); 
		query.append("		  ,A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("		  ,TO_CHAR(A.ETA_DT,'YYYYMMDDHH24MISS') ETA_DT" ).append("\n"); 
		query.append("		  ,A.JO_STL_JB_CD" ).append("\n"); 
		query.append("		  ,A.BSA_QTY" ).append("\n"); 
		query.append("		  ,A.BSA_SLT_PRC" ).append("\n"); 
		query.append("		  ,A.STL_LOCL_AMT" ).append("\n"); 
		query.append("		  ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("		  ,A.ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("		  ,A.ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("		  ,A.STL_USD_AMT" ).append("\n"); 
		query.append("		  ,A.IOC_CD" ).append("\n"); 
		query.append("		  ,A.SCONTI_CD" ).append("\n"); 
		query.append("		  ,A.FNL_OWN_BSA_QTY" ).append("\n"); 
		query.append("		  ,A.FNL_BSA_WGT" ).append("\n"); 
		query.append("		  ,A.USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("		  ,A.USD_SLT_WGT" ).append("\n"); 
		query.append("		  ,A.BSA_PER_WGT" ).append("\n"); 
		query.append("		  ,A.FM_PORT_CD" ).append("\n"); 
		query.append("		  ,A.TO_PORT_CD" ).append("\n"); 
		query.append("		  ,A.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("		  ,A.RF_SCG_PRC" ).append("\n"); 
		query.append("		  ,A.STL_RMK" ).append("\n"); 
		query.append("		  ,A.CMB_CFM_FLG" ).append("\n"); 
		query.append("		  ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("		  ,A.STL_TJ_NO" ).append("\n"); 
		query.append("		  ,A.STL_ADJ_FLG" ).append("\n"); 
		query.append("		  ,A.PRE_ACCT_YRMON" ).append("\n"); 
		query.append("		  ,A.PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("		  ,A.PRE_STL_SEQ" ).append("\n"); 
		query.append("		  ,A.STL_LST_FLG" ).append("\n"); 
		query.append("		  ,A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("		  ,TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("		  ,B.SLIP_NO AS CRE_DT" ).append("\n"); 
		query.append("		  ,NVL(B.RVS_CMB_FLG,'N') AS RVS_CMB_FLG" ).append("\n"); 
		query.append("		  ,TO_CHAR(A.ST_DT , 'YYYYMMDDHH24MI') AS ST_DT" ).append("\n"); 
		query.append("		  ,TO_CHAR(A.END_DT, 'YYYYMMDDHH24MI') AS END_DT" ).append("\n"); 
		query.append("		  ,A.SAIL_DYS" ).append("\n"); 
		query.append("	FROM   JOO_SETTLEMENT A," ).append("\n"); 
		query.append("		   (" ).append("\n"); 
		query.append("		   SELECT" ).append("\n"); 
		query.append("				  B.ACCT_YRMON" ).append("\n"); 
		query.append("				 ,B.STL_VVD_SEQ" ).append("\n"); 
		query.append("				 ,B.STL_SEQ" ).append("\n"); 
		query.append("				 ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("				 ,'' AS SLIP_NO" ).append("\n"); 
		query.append("				 ,A.RVS_CMB_FLG" ).append("\n"); 
		query.append("				 ,A.RJCT_CMB_FLG" ).append("\n"); 
		query.append("		   FROM   JOO_STL_CMB     A," ).append("\n"); 
		query.append("				  JOO_STL_CMB_DTL B" ).append("\n"); 
		query.append("		   WHERE  A.ACCT_YRMON  = B.ACCT_YRMON" ).append("\n"); 
		query.append("		   AND    A.JO_CRR_CD   = B.JO_CRR_CD" ).append("\n"); 
		query.append("		   AND    A.STL_CMB_SEQ = B.STL_CMB_SEQ" ).append("\n"); 
		query.append("		   AND    A.RE_DIVR_CD  = B.RE_DIVR_CD" ).append("\n"); 
		query.append("		   AND    A.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("		   AND    A.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("		   AND    A.RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 
		query.append("		   -- 2010.01.06 REVERSE 된 것은 COMBINED NO가 보여져서는 안된다 => 삭제가능하게 " ).append("\n"); 
		query.append("		  -- 2010.03.23 REVERSE 된 것은 copy를 하므로 기존 reverse data는 combined no를 보여주도록 한다. (삭제불가)" ).append("\n"); 
		query.append("		  --AND    A.RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append("		  --AND    A.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("		   ) B" ).append("\n"); 
		query.append("	WHERE  A.ACCT_YRMON    = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("	AND    A.STL_VVD_SEQ   = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("	AND    A.STL_SEQ       = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("	AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("	AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("	AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("	AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("	AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("	AND	   A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("	AND    A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("	AND    NVL(A.STL_ADJ_FLG,'N') = 'N'" ).append("\n"); 
		query.append("	#if (${sch_tp_cd} != '') " ).append("\n"); 
		query.append("		#if (${sch_tp_cd} == 'G') " ).append("\n"); 
		query.append("		   AND   A.ST_DT IS NOT NULL " ).append("\n"); 
		query.append("		   AND   A.END_DT IS NOT NULL" ).append("\n"); 
		query.append("		   AND   A.SAIL_DYS IS NOT NULL" ).append("\n"); 
		query.append("		#elseif (${sch_tp_cd} == 'P') " ).append("\n"); 
		query.append("		   AND   A.FM_PORT_CD IS NOT NULL " ).append("\n"); 
		query.append("		   AND   A.TO_PORT_CD IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		   AND   A.SAIL_DYS IS NULL" ).append("\n"); 
		query.append("		   AND   A.FM_PORT_CD IS NULL " ).append("\n"); 
		query.append("		   AND   A.TO_PORT_CD IS NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT 'I' AS IBFLAG" ).append("\n"); 
		query.append("		  , ACCT_YRMON" ).append("\n"); 
		query.append("		  , STL_VVD_SEQ" ).append("\n"); 
		query.append("		  , STL_SEQ" ).append("\n"); 
		query.append("		  , TRD_CD" ).append("\n"); 
		query.append("		  , JO_CRR_CD" ).append("\n"); 
		query.append("		  , RLANE_CD" ).append("\n"); 
		query.append("		  , RE_DIVR_CD" ).append("\n"); 
		query.append("		  , JO_STL_ITM_CD" ).append("\n"); 
		query.append("		  , JO_MNU_NM" ).append("\n"); 
		query.append("		  , VSL_CD" ).append("\n"); 
		query.append("		  , SKD_VOY_NO" ).append("\n"); 
		query.append("		  , SKD_DIR_CD" ).append("\n"); 
		query.append("		  , REV_DIR_CD" ).append("\n"); 
		query.append("		  , STL_BZC_PORT_CD" ).append("\n"); 
		query.append("		  , ETA_DT" ).append("\n"); 
		query.append("		  , JO_STL_JB_CD" ).append("\n"); 
		query.append("		  , BSA_QTY" ).append("\n"); 
		query.append("		  , BSA_SLT_PRC" ).append("\n"); 
		query.append("		  , STL_LOCL_AMT" ).append("\n"); 
		query.append("		  , LOCL_CURR_CD" ).append("\n"); 
		query.append("		  , ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("		  , ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("		  , STL_USD_AMT" ).append("\n"); 
		query.append("		  , IOC_CD" ).append("\n"); 
		query.append("		  , SCONTI_CD" ).append("\n"); 
		query.append("		  , FNL_OWN_BSA_QTY" ).append("\n"); 
		query.append("		  , FNL_BSA_WGT" ).append("\n"); 
		query.append("		  , USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("		  , USD_SLT_WGT" ).append("\n"); 
		query.append("		  , BSA_PER_WGT" ).append("\n"); 
		query.append("		  , FM_PORT_CD" ).append("\n"); 
		query.append("		  , TO_PORT_CD" ).append("\n"); 
		query.append("		  , RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("		  , RF_SCG_PRC" ).append("\n"); 
		query.append("		  , STL_RMK" ).append("\n"); 
		query.append("		  , CMB_CFM_FLG" ).append("\n"); 
		query.append("		  , STL_CMB_SEQ" ).append("\n"); 
		query.append("		  , STL_TJ_NO" ).append("\n"); 
		query.append("		  , STL_ADJ_FLG" ).append("\n"); 
		query.append("		  , PRE_ACCT_YRMON" ).append("\n"); 
		query.append("		  , PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("		  , PRE_STL_SEQ" ).append("\n"); 
		query.append("		  , STL_LST_FLG" ).append("\n"); 
		query.append("		  , UC_BSS_PORT_CD" ).append("\n"); 
		query.append("		  , UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("		  , CRE_DT" ).append("\n"); 
		query.append("		  , RVS_CMB_FLG" ).append("\n"); 
		query.append("		  , ST_DT" ).append("\n"); 
		query.append("		  , END_DT" ).append("\n"); 
		query.append("		  , CASE WHEN ST_DT IS NOT NULL THEN ROUND((TO_DATE(END_DT,'YYYYMMDDHH24MI') - TO_DATE(ST_DT,'YYYYMMDDHH24MI') ),3) ELSE NULL END AS SAIL_DYS" ).append("\n"); 
		query.append("	  FROM (" ).append("\n"); 
		query.append("					SELECT" ).append("\n"); 
		query.append("						  'I' AS IBFLAG" ).append("\n"); 
		query.append("						  , ACCT_YRMON" ).append("\n"); 
		query.append("						  , J.STL_VVD_SEQ" ).append("\n"); 
		query.append("						  , 0 AS STL_SEQ" ).append("\n"); 
		query.append("						  , J.TRD_CD" ).append("\n"); 
		query.append("						  , J.JO_CRR_CD" ).append("\n"); 
		query.append("						  , J.RLANE_CD" ).append("\n"); 
		query.append("						  , J.RE_DIVR_CD" ).append("\n"); 
		query.append("						  , J.JO_STL_ITM_CD" ).append("\n"); 
		query.append("						  , J.JO_MNU_NM" ).append("\n"); 
		query.append("						  , J.VSL_CD" ).append("\n"); 
		query.append("						  , J.SKD_VOY_NO" ).append("\n"); 
		query.append("						  , J.SKD_DIR_CD" ).append("\n"); 
		query.append("						  , J.REV_DIR_CD" ).append("\n"); 
		query.append("						  , J.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("						  , TO_CHAR(J.BZC_PORT_ETA_DT,'YYYYMMDDHH24MISS') ETA_DT" ).append("\n"); 
		query.append("					#if (${jo_stl_itm_cd} != '' && ${jo_stl_itm_cd} == 'OPR' && ${sch_tp_cd} != 'P')" ).append("\n"); 
		query.append("						  , DECODE(C.BSA_OP_JB_CD,'000','104','001','104','002','105','003','105','004','106','005','106') JO_STL_JB_CD /*OPR*/" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("						  , DECODE(C.BSA_OP_JB_CD,'000','101','001','101','002','102','003','102','004','103','005','103') JO_STL_JB_CD /*S/H*/" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("					#if (${sch_tp_cd} != '') " ).append("\n"); 
		query.append("						  #if(${sch_tp_cd} == 'G')" ).append("\n"); 
		query.append("						   , C.BSA_QTY" ).append("\n"); 
		query.append("						   , C.BSA_SLT_PRC" ).append("\n"); 
		query.append("						   , C.STL_LOCL_AMT" ).append("\n"); 
		query.append("						  #elseif (${sch_tp_cd} == 'P') " ).append("\n"); 
		query.append("						   , NULL AS BSA_QTY" ).append("\n"); 
		query.append("						   , NULL AS BSA_SLT_PRC" ).append("\n"); 
		query.append("						   , NULL AS STL_LOCL_AMT" ).append("\n"); 
		query.append("						  #else    " ).append("\n"); 
		query.append("						   , C.BSA_QTY" ).append("\n"); 
		query.append("						   , C.BSA_SLT_PRC" ).append("\n"); 
		query.append("						   , C.STL_LOCL_AMT" ).append("\n"); 
		query.append("						  #end" ).append("\n"); 
		query.append("					#else      " ).append("\n"); 
		query.append("						  , C.BSA_QTY" ).append("\n"); 
		query.append("						  , C.BSA_SLT_PRC" ).append("\n"); 
		query.append("						  , C.STL_LOCL_AMT" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("						  , F.LOCL_CURR_CD" ).append("\n"); 
		query.append("						  , NULL AS ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("						  , NULL AS ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("						  , NULL AS STL_USD_AMT" ).append("\n"); 
		query.append("						  , NULL AS IOC_CD" ).append("\n"); 
		query.append("						  , NULL AS SCONTI_CD" ).append("\n"); 
		query.append("						  , NULL AS FNL_OWN_BSA_QTY" ).append("\n"); 
		query.append("						  , NULL AS FNL_BSA_WGT" ).append("\n"); 
		query.append("						  , NULL AS USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("						  , NULL AS USD_SLT_WGT" ).append("\n"); 
		query.append("						  , NULL AS BSA_PER_WGT" ).append("\n"); 
		query.append("						  , NULL AS FM_PORT_CD" ).append("\n"); 
		query.append("						  , NULL AS TO_PORT_CD" ).append("\n"); 
		query.append("						  , NULL AS RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("						  , NULL AS RF_SCG_PRC" ).append("\n"); 
		query.append("						  , NULL AS STL_RMK" ).append("\n"); 
		query.append("						  , NULL AS CMB_CFM_FLG" ).append("\n"); 
		query.append("						  , NULL AS STL_CMB_SEQ" ).append("\n"); 
		query.append("						  , NULL AS STL_TJ_NO" ).append("\n"); 
		query.append("						  , 'N'  AS STL_ADJ_FLG" ).append("\n"); 
		query.append("						  , NULL AS PRE_ACCT_YRMON" ).append("\n"); 
		query.append("						  , NULL AS PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("						  , NULL AS PRE_STL_SEQ" ).append("\n"); 
		query.append("						  , 'Y'  AS STL_LST_FLG" ).append("\n"); 
		query.append("						  , J.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("						  , TO_CHAR(J.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("						  , '' AS CRE_DT" ).append("\n"); 
		query.append("						  , 'N' AS RVS_CMB_FLG" ).append("\n"); 
		query.append("					#if (${sch_tp_cd} != '' && ${sch_tp_cd} == 'G') " ).append("\n"); 
		query.append("						 , (SELECT TO_CHAR(MIN(X.VPS_ETA_DT),'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("							  FROM VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("							 WHERE 1=1" ).append("\n"); 
		query.append("							   AND X.VSL_CD = J.VSL_CD" ).append("\n"); 
		query.append("							   AND X.SKD_VOY_NO = J.SKD_VOY_NO" ).append("\n"); 
		query.append("							   AND X.SKD_DIR_CD = J.SKD_DIR_CD" ).append("\n"); 
		query.append("							   AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                               AND NVL(X.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/) AS ST_DT" ).append("\n"); 
		query.append("						 , NVL((SELECT TO_CHAR(MIN(VPS_ETA_DT) ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND VSK.VSL_CD = J.VSL_CD" ).append("\n"); 
		query.append("                                   AND VSK.SKD_VOY_NO = J.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND VSK.SKD_DIR_CD = J.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND NVL(VSK.SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                   AND VSK.TURN_PORT_IND_CD IN ('D','V','F')" ).append("\n"); 
		query.append("                                   AND NVL(VSK.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/)" ).append("\n"); 
		query.append("                              ,(SELECT TO_CHAR(MAX(VPS_ETA_DT) ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND VSK.VSL_CD = J.VSL_CD" ).append("\n"); 
		query.append("                                   AND VSK.SKD_VOY_NO = J.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND VSK.SKD_DIR_CD = J.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND NVL(VSK.SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                   AND VSK.TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("                                   AND NVL(VSK.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/)) AS END_DT" ).append("\n"); 
		query.append("						  , NULL AS SAIL_DYS" ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("						  , NULL AS ST_DT" ).append("\n"); 
		query.append("						  , NULL AS END_DT" ).append("\n"); 
		query.append("						  , NULL AS SAIL_DYS" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					FROM   JOO_STL_VVD J," ).append("\n"); 
		query.append("						   V_BSA C," ).append("\n"); 
		query.append("						   JOO_FINC_MTX F" ).append("\n"); 
		query.append("					WHERE J.VSL_CD        = C.VSL_CD       (+)" ).append("\n"); 
		query.append("					AND   J.SKD_VOY_NO    = C.SKD_VOY_NO   (+)" ).append("\n"); 
		query.append("					AND   J.SKD_DIR_CD    = C.SKD_DIR_CD   (+)" ).append("\n"); 
		query.append("					AND   J.RLANE_CD      = C.RLANE_CD     (+)" ).append("\n"); 
		query.append("					AND   J.JO_CRR_CD     = F.JO_CRR_CD    (+)" ).append("\n"); 
		query.append("					AND   J.RLANE_CD      = F.RLANE_CD     (+)" ).append("\n"); 
		query.append("					AND   J.RE_DIVR_CD    = F.RE_DIVR_CD   (+)" ).append("\n"); 
		query.append("					AND   J.JO_MNU_NM     = F.JO_STL_ITM_CD(+)" ).append("\n"); 
		query.append("					AND   J.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("					AND   J.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("					AND   J.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("					AND   J.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("					AND   J.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("					AND   J.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("					AND   J.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("					AND   J.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("					AND    NOT EXISTS (" ).append("\n"); 
		query.append("							SELECT 1" ).append("\n"); 
		query.append("							  FROM JOO_SETTLEMENT  X," ).append("\n"); 
		query.append("								   --2010.03.29 REVERSE 된 VVD는 나와야 한다." ).append("\n"); 
		query.append("								   (" ).append("\n"); 
		query.append("								   SELECT Y.ACCT_YRMON, Y.STL_VVD_SEQ, Y.STL_SEQ, Z.RVS_CMB_FLG" ).append("\n"); 
		query.append("								   FROM   JOO_STL_CMB_DTL Y," ).append("\n"); 
		query.append("										  JOO_STL_CMB     Z" ).append("\n"); 
		query.append("								   WHERE  Y.ACCT_YRMON = Z.ACCT_YRMON" ).append("\n"); 
		query.append("								   AND    Y.JO_CRR_CD  = Z.JO_CRR_CD" ).append("\n"); 
		query.append("								   AND    Y.STL_CMB_SEQ= Z.STL_CMB_SEQ" ).append("\n"); 
		query.append("								   AND    Y.RE_DIVR_CD = Z.RE_DIVR_CD" ).append("\n"); 
		query.append("								   ) Y" ).append("\n"); 
		query.append("							WHERE  X.ACCT_YRMON     = Y.ACCT_YRMON  (+)" ).append("\n"); 
		query.append("							AND    X.STL_VVD_SEQ    = Y.STL_VVD_SEQ (+)" ).append("\n"); 
		query.append("							AND    X.STL_SEQ        = Y.STL_SEQ     (+) " ).append("\n"); 
		query.append("							AND    X.ACCT_YRMON     = J.ACCT_YRMON" ).append("\n"); 
		query.append("							AND    X.JO_CRR_CD      = J.JO_CRR_CD" ).append("\n"); 
		query.append("							AND    X.RE_DIVR_CD     = J.RE_DIVR_CD" ).append("\n"); 
		query.append("							AND    X.TRD_CD         = J.TRD_CD" ).append("\n"); 
		query.append("							AND    X.RLANE_CD       = J.RLANE_CD" ).append("\n"); 
		query.append("							AND    X.JO_STL_ITM_CD  = J.JO_STL_ITM_CD" ).append("\n"); 
		query.append("							AND    X.JO_MNU_NM      = J.JO_MNU_NM" ).append("\n"); 
		query.append("							AND    X.VSL_CD         = J.VSL_CD" ).append("\n"); 
		query.append("							AND    X.SKD_VOY_NO     = J.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND    X.SKD_DIR_CD     = J.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND    X.REV_DIR_CD     = J.REV_DIR_CD" ).append("\n"); 
		query.append("                    #if (${jo_stl_itm_cd} != '' && ${jo_stl_itm_cd} == 'OPR' && ${sch_tp_cd} != 'P')" ).append("\n"); 
		query.append("							AND    X.JO_STL_JB_CD   = DECODE(C.BSA_OP_JB_CD,'000','104','001','104','002','105','003','105','004','106','005','106') /*OPR*/" ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("							AND    X.JO_STL_JB_CD   = DECODE(C.BSA_OP_JB_CD,'000','101','001','101','002','102','003','102','004','103','005','103') /*S/H*/" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                       		AND    NVL(Y.RVS_CMB_FLG,'N') =  'N'" ).append("\n"); 
		query.append("					#if (${sch_tp_cd} != '') " ).append("\n"); 
		query.append("						#if (${sch_tp_cd} == 'G') " ).append("\n"); 
		query.append("						   AND   X.ST_DT IS NOT NULL " ).append("\n"); 
		query.append("						   AND   X.END_DT IS NOT NULL" ).append("\n"); 
		query.append("						   AND   X.SAIL_DYS IS NOT NULL" ).append("\n"); 
		query.append("						#elseif (${sch_tp_cd} == 'P') " ).append("\n"); 
		query.append("						   AND   X.FM_PORT_CD IS NOT NULL " ).append("\n"); 
		query.append("						   AND   X.TO_PORT_CD IS NOT NULL" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("						   AND   X.SAIL_DYS IS NULL" ).append("\n"); 
		query.append("						   AND   X.FM_PORT_CD IS NULL " ).append("\n"); 
		query.append("						   AND   X.TO_PORT_CD IS NULL" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	) A" ).append("\n"); 
		query.append("#if (${sch_tp_cd} != '' && ${sch_tp_cd} == 'G') " ).append("\n"); 
		query.append("ORDER BY A.ST_DT, A.SKD_DIR_CD, A.VSL_CD, A.SKD_VOY_NO, A.REV_DIR_CD, JO_STL_JB_CD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY 1 DESC, SKD_DIR_CD, VSL_CD, SKD_VOY_NO, REV_DIR_CD, JO_STL_JB_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}