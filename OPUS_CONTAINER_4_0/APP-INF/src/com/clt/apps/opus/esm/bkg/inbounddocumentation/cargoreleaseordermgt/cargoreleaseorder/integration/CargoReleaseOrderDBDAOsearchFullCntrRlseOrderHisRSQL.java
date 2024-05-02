/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchFullCntrRlseOrderHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchFullCntrRlseOrderHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFullCntrRlseOrderHis
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchFullCntrRlseOrderHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rad",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cre_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cre_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchFullCntrRlseOrderHisRSQL").append("\n"); 
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
		query.append("SELECT BL_NO, BKG_NO, CNTR_NO, CNTR_TP_SZ_CD, CUST_NM, YD_CD, VVD, POL_CD, POD_CD," ).append("\n"); 
		query.append("       DO_NO, DO_ISS_DT, TRSP_MOD, PKUP_DT, CXL_FLG, DE_TERM_CD, RMK, OFC_CD, USR_NM, " ).append("\n"); 
		query.append("       RLSE_DT, MZD , CO_BDG_ID, CGO_CRR_ID, RLSE_EXP_DT, PIN_NO, VEH_RGST_ID, ROAD_HLG_ID, UQ_VSL_ID_NO," ).append("\n"); 
		query.append("       CNTR_SLT_NO, CSTMS_VOY_NO, MTY_RTN_YD_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("         SELECT BKG.BL_NO                                            BL_NO" ).append("\n"); 
		query.append("	     , BKG.BKG_NO                                           BKG_NO" ).append("\n"); 
		query.append("	     , BORD.CNTR_NO                                         CNTR_NO" ).append("\n"); 
		query.append("	     , BCNTR.CNTR_TPSZ_CD                                   CNTR_TP_SZ_CD" ).append("\n"); 
		query.append("	     , REPLACE(BORD.CUST_NM, CHR(10), ' ')                  CUST_NM" ).append("\n"); 
		query.append("	     , BORD.YD_CD                                           YD_CD" ).append("\n"); 
		query.append("	     , BVVD.VSL_CD||BVVD.SKD_VOY_NO || BVVD.SKD_DIR_CD      VVD" ).append("\n"); 
		query.append("	     , BKG.POL_CD                                           POL_CD" ).append("\n"); 
		query.append("	     , BORD.POD_CD                                          POD_CD" ).append("\n"); 
		query.append("	     , BORD.DO_NO ||BORD.DO_NO_SPLIT                        DO_NO" ).append("\n"); 
		query.append("	     , TO_CHAR(BORD.DO_ISS_DT, 'YYYY-MM-DD HH:MI')          DO_ISS_DT" ).append("\n"); 
		query.append("--	     , DECODE(BORD.BKG_TRSP_MOD_CD,'B','Barge'" ).append("\n"); 
		query.append("--	                                  ,'F','Feeder'" ).append("\n"); 
		query.append("--	                                  ,'R','Rail'" ).append("\n"); 
		query.append("--	                                  ,'T','Truck'" ).append("\n"); 
		query.append("--	                                  ,'' )                     TRSP_MOD	--TPJT_INBOUND" ).append("\n"); 
		query.append("         , TMCD.INTG_CD_VAL_DP_DESC                             TRSP_MOD" ).append("\n"); 
		query.append("	     , TO_CHAR(BORD.CGO_PKUP_DT, 'YYYY-MM-DD HH:MI')        PKUP_DT" ).append("\n"); 
		query.append("	     , BORD.CXL_FLG                                         CXL_FLG" ).append("\n"); 
		query.append("	     , BKG.DE_TERM_CD                                       DE_TERM_CD" ).append("\n"); 
		query.append("	     , BORD.DIFF_RMK                                        RMK" ).append("\n"); 
		query.append("	     , BORD.RLSE_OFC_CD                                     OFC_CD" ).append("\n"); 
		query.append("	     , NVL(USR.USR_NM,BORD.RLSE_USR_ID)                     USR_NM" ).append("\n"); 
		query.append("		 , TO_CHAR(BORD.RLSE_CRE_DT, 'YYYY-MM-DD HH:MI')        RLSE_DT" ).append("\n"); 
		query.append("	     , BORD.CGOR_MZD_CD                                     MZD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 , BORD.CO_BDG_ID										CO_BDG_ID" ).append("\n"); 
		query.append("		 , BORD.CGO_CRR_ID										CGO_CRR_ID" ).append("\n"); 
		query.append("		 , TO_CHAR(BORD.RLSE_EXP_DT, 'YYYY-MM-DD HH24:MI') 		RLSE_EXP_DT" ).append("\n"); 
		query.append("		 , BORD.PIN_NO										    PIN_NO" ).append("\n"); 
		query.append("		 , BORD.VEH_RGST_ID										VEH_RGST_ID" ).append("\n"); 
		query.append("		 , BORD.ROAD_HLG_ID										ROAD_HLG_ID" ).append("\n"); 
		query.append("		 , BORD.UQ_VSL_ID_NO									UQ_VSL_ID_NO" ).append("\n"); 
		query.append("         , BORD.CNTR_SLT_NO                                     CNTR_SLT_NO" ).append("\n"); 
		query.append("         , BORD.CSTMS_VOY_NO                                    CSTMS_VOY_NO" ).append("\n"); 
		query.append("         , BORD.MTY_RTN_YD_CD                                   MTY_RTN_YD_CD" ).append("\n"); 
		query.append("	  FROM BKG_BOOKING             BKG        " ).append("\n"); 
		query.append("	     , BKG_FULL_CGO_RLSE_ORD   BORD        " ).append("\n"); 
		query.append("	     , COM_USER                USR        " ).append("\n"); 
		query.append("	     , BKG_CONTAINER           BCNTR            " ).append("\n"); 
		query.append("	     , BKG_VVD                 BVVD " ).append("\n"); 
		query.append("		 , (SELECT INTG_CD_VAL_CTNT, INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01662') TMCD       " ).append("\n"); 
		query.append("	 WHERE 'Released Date'      = @[f_rad]" ).append("\n"); 
		query.append("	  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   AND BORD.RLSE_CRE_DT BETWEEN TO_DATE(REPLACE(@[in_cre_dt_from], '-', ''), 'YYYYMMDD') " ).append("\n"); 
		query.append("	       AND TO_DATE(REPLACE(@[in_cre_dt_to], '-', ''), 'YYYYMMDD') + 0.9999  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("	   AND BORD.CNTR_NO        LIKE @[in_cntr_no] || '%'" ).append("\n"); 
		query.append("	   AND BKG.BKG_NO           = BORD.BKG_NO      " ).append("\n"); 
		query.append("	   AND BKG.BKG_STS_CD       <> 'X'        " ).append("\n"); 
		query.append("	   AND BCNTR.BKG_NO         = BORD.BKG_NO        " ).append("\n"); 
		query.append("	   AND BCNTR.CNTR_NO        = BORD.CNTR_NO        " ).append("\n"); 
		query.append("	   AND USR.USR_ID(+)        = BORD.RLSE_USR_ID  " ).append("\n"); 
		query.append("	   AND BVVD.BKG_NO          = BKG.BKG_NO        " ).append("\n"); 
		query.append("	   AND BVVD.VSL_CD          = BKG.VSL_CD        " ).append("\n"); 
		query.append("	   AND BVVD.SKD_VOY_NO      = BKG.SKD_VOY_NO        " ).append("\n"); 
		query.append("	   AND BVVD.SKD_DIR_CD      = BKG.SKD_DIR_CD        " ).append("\n"); 
		query.append("	   AND BVVD.VSL_PRE_PST_CD  = 'T'" ).append("\n"); 
		query.append("	   AND BORD.YD_CD LIKE @[in_yd_cd] || '%'" ).append("\n"); 
		query.append("	   AND BORD.BKG_TRSP_MOD_CD = TMCD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("	       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	SELECT BKG.BL_NO                                            BL_NO" ).append("\n"); 
		query.append("	     , BKG.BKG_NO                                           BKG_NO" ).append("\n"); 
		query.append("	     , BORD.CNTR_NO                                         CNTR_NO" ).append("\n"); 
		query.append("	     , BCNTR.CNTR_TPSZ_CD                                   CNTR_TP_SZ_CD" ).append("\n"); 
		query.append("	     , REPLACE(BORD.CUST_NM, CHR(10), ' ')                  CUST_NM" ).append("\n"); 
		query.append("	     , BORD.YD_CD                                           YD_CD" ).append("\n"); 
		query.append("	     , BVVD.VSL_CD||BVVD.SKD_VOY_NO || BVVD.SKD_DIR_CD      VVD" ).append("\n"); 
		query.append("	     , BKG.POL_CD                                           POL_CD" ).append("\n"); 
		query.append("	     , BORD.POD_CD                                          POD_CD" ).append("\n"); 
		query.append("	     , BORD.DO_NO ||BORD.DO_NO_SPLIT                        DO_NO" ).append("\n"); 
		query.append("	     , TO_CHAR(BORD.DO_ISS_DT, 'YYYY-MM-DD HH:MI')          DO_ISS_DT" ).append("\n"); 
		query.append("--	     , DECODE(BORD.BKG_TRSP_MOD_CD,'B','Barge'" ).append("\n"); 
		query.append("--	                                  ,'F','Feeder'" ).append("\n"); 
		query.append("--	                                  ,'R','Rail'" ).append("\n"); 
		query.append("--	                                  ,'T','Truck'" ).append("\n"); 
		query.append("--	                                  ,'' )                     TRSP_MOD	--TPJT_INBOUND" ).append("\n"); 
		query.append("         , TMCD.INTG_CD_VAL_DP_DESC                             TRSP_MOD" ).append("\n"); 
		query.append("	     , TO_CHAR(BORD.CGO_PKUP_DT, 'YYYY-MM-DD HH:MI')        PKUP_DT" ).append("\n"); 
		query.append("	     , BORD.CXL_FLG                                         CXL_FLG" ).append("\n"); 
		query.append("	     , BKG.DE_TERM_CD                                       DE_TERM_CD" ).append("\n"); 
		query.append("	     , BORD.DIFF_RMK                                        RMK" ).append("\n"); 
		query.append("	     , BORD.RLSE_OFC_CD                                     OFC_CD" ).append("\n"); 
		query.append("	     , NVL(USR.USR_NM,BORD.RLSE_USR_ID)                     USR_NM" ).append("\n"); 
		query.append("		 , TO_CHAR(BORD.RLSE_CRE_DT, 'YYYY-MM-DD HH:MI')        RLSE_DT" ).append("\n"); 
		query.append("	     , BORD.CGOR_MZD_CD                                     MZD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 , BORD.CO_BDG_ID										CO_BDG_ID" ).append("\n"); 
		query.append("		 , BORD.CGO_CRR_ID										CGO_CRR_ID" ).append("\n"); 
		query.append("		 , TO_CHAR(BORD.RLSE_EXP_DT, 'YYYY-MM-DD HH24:MI') 		RLSE_EXP_DT" ).append("\n"); 
		query.append("		 , BORD.PIN_NO										    PIN_NO" ).append("\n"); 
		query.append("		 , BORD.VEH_RGST_ID										VEH_RGST_ID" ).append("\n"); 
		query.append("		 , BORD.ROAD_HLG_ID										ROAD_HLG_ID" ).append("\n"); 
		query.append("		 , BORD.UQ_VSL_ID_NO									UQ_VSL_ID_NO" ).append("\n"); 
		query.append("         , BORD.CNTR_SLT_NO                                     CNTR_SLT_NO" ).append("\n"); 
		query.append("         , BORD.CSTMS_VOY_NO                                    CSTMS_VOY_NO" ).append("\n"); 
		query.append("         , BORD.MTY_RTN_YD_CD                                   MTY_RTN_YD_CD" ).append("\n"); 
		query.append("	  FROM BKG_BOOKING             BKG        " ).append("\n"); 
		query.append("	     , BKG_FULL_CGO_RLSE_ORD   BORD        " ).append("\n"); 
		query.append("	     , COM_USER                USR        " ).append("\n"); 
		query.append("	     , BKG_CONTAINER           BCNTR            " ).append("\n"); 
		query.append("	     , BKG_VVD                 BVVD" ).append("\n"); 
		query.append("   		 , (SELECT INTG_CD_VAL_CTNT, INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01662') TMCD               " ).append("\n"); 
		query.append("	 WHERE 'BL'                = @[f_rad]" ).append("\n"); 
		query.append("	   AND BKG.BL_NO            = @[in_bl_no]--'PUSE41695103'        " ).append("\n"); 
		query.append("	   AND BKG.BKG_STS_CD      <> 'X'      " ).append("\n"); 
		query.append("       AND BCNTR.BKG_NO         = BKG.BKG_NO      " ).append("\n"); 
		query.append("	   AND BORD.BKG_NO          = BKG.BKG_NO        " ).append("\n"); 
		query.append("	   AND BORD.CNTR_NO        LIKE @[in_cntr_no] || '%'	     " ).append("\n"); 
		query.append("	   AND BORD.CNTR_NO         = BCNTR.CNTR_NO " ).append("\n"); 
		query.append("	   AND USR.USR_ID(+)        = BORD.RLSE_USR_ID " ).append("\n"); 
		query.append("	   AND BVVD.BKG_NO          = BKG.BKG_NO        " ).append("\n"); 
		query.append("	   AND BVVD.VSL_CD          = BKG.VSL_CD        " ).append("\n"); 
		query.append("	   AND BVVD.SKD_VOY_NO      = BKG.SKD_VOY_NO        " ).append("\n"); 
		query.append("	   AND BVVD.SKD_DIR_CD      = BKG.SKD_DIR_CD        " ).append("\n"); 
		query.append("	   AND BVVD.VSL_PRE_PST_CD  = 'T'" ).append("\n"); 
		query.append("	   AND BORD.YD_CD LIKE @[in_yd_cd] || '%'" ).append("\n"); 
		query.append(" 	   AND BORD.BKG_TRSP_MOD_CD = TMCD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT BKG.BL_NO                                            BL_NO         " ).append("\n"); 
		query.append("	     , BKG.BKG_NO                                           BKG_NO         " ).append("\n"); 
		query.append("	     , BORD.CNTR_NO                                         CNTR_NO         " ).append("\n"); 
		query.append("	     , BCNTR.CNTR_TPSZ_CD                                   CNTR_TP_SZ_CD        " ).append("\n"); 
		query.append("	     , REPLACE(BORD.CUST_NM, CHR(10), ' ')                  CUST_NM        " ).append("\n"); 
		query.append("	     , BORD.YD_CD                                           YD_CD       " ).append("\n"); 
		query.append("	     , BVVD.VSL_CD||BVVD.SKD_VOY_NO || BVVD.SKD_DIR_CD      VVD        " ).append("\n"); 
		query.append("	     , BKG.POL_CD                                          POL_CD        " ).append("\n"); 
		query.append("	     , BORD.POD_CD                                          POD_CD " ).append("\n"); 
		query.append("	     , BORD.DO_NO ||BORD.DO_NO_SPLIT                        DO_NO  " ).append("\n"); 
		query.append("	     , TO_CHAR(BORD.DO_ISS_DT, 'YYYY-MM-DD HH:MI')          DO_ISS_DT" ).append("\n"); 
		query.append("--	     , DECODE(BORD.BKG_TRSP_MOD_CD,'B','Barge'    " ).append("\n"); 
		query.append("--	                                  ,'F','Feeder'" ).append("\n"); 
		query.append("--	                                  ,'R','Rail'" ).append("\n"); 
		query.append("--	                                  ,'T','Truck'    " ).append("\n"); 
		query.append("--	                                  ,'' )                     TRSP_MOD        --TPJT_INBOUND" ).append("\n"); 
		query.append("         , TMCD.INTG_CD_VAL_DP_DESC                             TRSP_MOD" ).append("\n"); 
		query.append("	     , TO_CHAR(BORD.CGO_PKUP_DT, 'YYYY-MM-DD HH:MI')        PKUP_DT" ).append("\n"); 
		query.append("	     , BORD.CXL_FLG                                         CXL_FLG        " ).append("\n"); 
		query.append("	     , BKG.DE_TERM_CD                                       DE_TERM_CD        " ).append("\n"); 
		query.append("	     , BORD.DIFF_RMK                                        RMK        " ).append("\n"); 
		query.append("	     , BORD.RLSE_OFC_CD                                     OFC_CD        " ).append("\n"); 
		query.append("	     , NVL(USR.USR_NM,BORD.RLSE_USR_ID)                     USR_NM        " ).append("\n"); 
		query.append("	     , TO_CHAR(BORD.RLSE_CRE_DT, 'YYYY-MM-DD HH:MI')        RLSE_DT" ).append("\n"); 
		query.append("	     , BORD.CGOR_MZD_CD                                     MZD       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 , BORD.CO_BDG_ID										CO_BDG_ID" ).append("\n"); 
		query.append("		 , BORD.CGO_CRR_ID										CGO_CRR_ID" ).append("\n"); 
		query.append("		 , TO_CHAR(BORD.RLSE_EXP_DT, 'YYYY-MM-DD HH24:MI') 		RLSE_EXP_DT" ).append("\n"); 
		query.append("		 , BORD.PIN_NO										    PIN_NO" ).append("\n"); 
		query.append("		 , BORD.VEH_RGST_ID										VEH_RGST_ID" ).append("\n"); 
		query.append("		 , BORD.ROAD_HLG_ID										ROAD_HLG_ID" ).append("\n"); 
		query.append("		 , BORD.UQ_VSL_ID_NO									UQ_VSL_ID_NO" ).append("\n"); 
		query.append("         , BORD.CNTR_SLT_NO                                     CNTR_SLT_NO" ).append("\n"); 
		query.append("         , BORD.CSTMS_VOY_NO                                    CSTMS_VOY_NO" ).append("\n"); 
		query.append("         , BORD.MTY_RTN_YD_CD                                   MTY_RTN_YD_CD" ).append("\n"); 
		query.append("	  FROM BKG_BOOKING             BKG" ).append("\n"); 
		query.append("	     , BKG_FULL_CGO_RLSE_ORD   BORD" ).append("\n"); 
		query.append("	     , COM_USER                USR       " ).append("\n"); 
		query.append("	     , BKG_CONTAINER           BCNTR       " ).append("\n"); 
		query.append("	     , BKG_VVD                 BVVD" ).append("\n"); 
		query.append("   		 , (SELECT INTG_CD_VAL_CTNT, INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01662') TMCD       " ).append("\n"); 
		query.append("	 WHERE 'VVD'                = @[f_rad]" ).append("\n"); 
		query.append("	   AND BVVD.VSL_CD          = SUBSTR(@[in_vvd], 1, 4)" ).append("\n"); 
		query.append("	   AND BVVD.SKD_VOY_NO      = SUBSTR(@[in_vvd], 5, 4)" ).append("\n"); 
		query.append("	   AND BVVD.SKD_DIR_CD      = SUBSTR(@[in_vvd], 9, 1)" ).append("\n"); 
		query.append("	   AND BVVD.VSL_PRE_PST_CD  = 'T'" ).append("\n"); 
		query.append("	   AND BKG.BKG_NO           = BVVD.BKG_NO" ).append("\n"); 
		query.append("	   AND BKG.VSL_CD           = BVVD.VSL_CD" ).append("\n"); 
		query.append("	   AND BKG.SKD_VOY_NO       = BVVD.SKD_VOY_NO" ).append("\n"); 
		query.append("	   AND BKG.SKD_DIR_CD       = BVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("	   AND BKG.BKG_STS_CD      <> 'X'" ).append("\n"); 
		query.append("	   AND BCNTR.BKG_NO         = BKG.BKG_NO" ).append("\n"); 
		query.append("	   AND BCNTR.CNTR_NO        = BORD.CNTR_NO" ).append("\n"); 
		query.append("	   AND BORD.POD_CD          = @[in_pod_cd]" ).append("\n"); 
		query.append("	   AND BORD.BKG_NO          = BKG.BKG_NO" ).append("\n"); 
		query.append("	   AND BORD.RLSE_USR_ID     = USR.USR_ID(+)" ).append("\n"); 
		query.append(" 	   AND BORD.BKG_TRSP_MOD_CD = TMCD.INTG_CD_VAL_CTNT(+)	" ).append("\n"); 
		query.append(") WHERE 1=1" ).append("\n"); 
		query.append("ORDER BY BKG_NO, RLSE_DT desc" ).append("\n"); 

	}
}