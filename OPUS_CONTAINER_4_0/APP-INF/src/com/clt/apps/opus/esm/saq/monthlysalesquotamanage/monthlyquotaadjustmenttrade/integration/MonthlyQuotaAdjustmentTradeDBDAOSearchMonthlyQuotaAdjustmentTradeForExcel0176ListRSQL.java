/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeDBDAOSearchMonthlyQuotaAdjustmentTradeForExcel0176ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentTradeDBDAOSearchMonthlyQuotaAdjustmentTradeForExcel0176ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * QuotaForExcel 목록 조회
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeDBDAOSearchMonthlyQuotaAdjustmentTradeForExcel0176ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentTradeDBDAOSearchMonthlyQuotaAdjustmentTradeForExcel0176ListRSQL").append("\n"); 
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
		query.append("WITH INPUT_PARAMS AS  " ).append("\n"); 
		query.append("		( " ).append("\n"); 
		query.append("		    SELECT   @[mqta_step_cd] MQTA_STEP_CD " ).append("\n"); 
		query.append("		            ,@[bse_yr] BSE_YR " ).append("\n"); 
		query.append("		            ,@[bse_qtr_cd] BSE_QTR_CD " ).append("\n"); 
		query.append("		            ,@[trd_cd] TRD_CD " ).append("\n"); 
		query.append("		            ,@[dir_cd] DIR_CD " ).append("\n"); 
		query.append("		            ,@[mqta_ver_no] MQTA_VER_NO " ).append("\n"); 
		query.append("		            ,@[gline_ver_no] GLINE_VER_NO " ).append("\n"); 
		query.append("		            ,@[unit] UNIT " ).append("\n"); 
		query.append("		    FROM    DUAL " ).append("\n"); 
		query.append("		), WITH_TGT_VVD_ADJ AS " ).append("\n"); 
		query.append("		(   " ).append("\n"); 
		query.append("		    SELECT   ADJ.BSE_YR " ).append("\n"); 
		query.append("		            ,ADJ.BSE_QTR_CD " ).append("\n"); 
		query.append("		            ,ADJ.TRD_CD " ).append("\n"); 
		query.append("		            ,ADJ.RLANE_CD " ).append("\n"); 
		query.append("		            ,ADJ.DIR_CD " ).append("\n"); 
		query.append("		            ,ADJ.SPRT_GRP_CD " ).append("\n"); 
		query.append("		            ,ADJ.BSA_GRP_CD " ).append("\n"); 
		query.append("		            ,ADJ.BSE_MON " ).append("\n"); 
		query.append("		            ,MIN(ADJ.FNL_BSA_CAPA)                                          BSA " ).append("\n"); 
		query.append("		            ,COUNT(DISTINCT ADJ.VSL_CD||ADJ.SKD_VOY_NO||ADJ.SKD_DIR_CD)     VOYAGE " ).append("\n"); 
		query.append("		    FROM     SAQ_MON_TGT_VVD_ADJ    ADJ " ).append("\n"); 
		query.append("		            ,INPUT_PARAMS           INP " ).append("\n"); 
		query.append("		    WHERE   1=1 " ).append("\n"); 
		query.append("		    AND     ADJ.BSE_YR          = INP.BSE_YR " ).append("\n"); 
		query.append("		    AND     ADJ.BSE_QTR_CD      = INP.BSE_QTR_CD " ).append("\n"); 
		query.append("		    AND     ADJ.GLINE_VER_NO    = INP.GLINE_VER_NO " ).append("\n"); 
		query.append("		    AND     ADJ.TRD_CD          = INP.TRD_CD " ).append("\n"); 
		query.append("		    AND     ADJ.DIR_CD          = INP.DIR_CD " ).append("\n"); 
		query.append("		    GROUP BY ADJ.BSE_YR " ).append("\n"); 
		query.append("		            ,ADJ.BSE_QTR_CD " ).append("\n"); 
		query.append("		            ,ADJ.TRD_CD " ).append("\n"); 
		query.append("		            ,ADJ.RLANE_CD " ).append("\n"); 
		query.append("		            ,ADJ.DIR_CD " ).append("\n"); 
		query.append("		            ,ADJ.SPRT_GRP_CD " ).append("\n"); 
		query.append("		            ,ADJ.BSA_GRP_CD " ).append("\n"); 
		query.append("		            ,ADJ.BSE_MON                         " ).append("\n"); 
		query.append("		)                             " ).append("\n"); 
		query.append("		SELECT   LPAD(ROWNUM, 4, 0)             RN " ).append("\n"); 
		query.append("		        ,'Y' EDITABLE 		" ).append("\n"); 
		query.append("		        ,MQTA_STEP_CD " ).append("\n"); 
		query.append("		        ,BSE_YR " ).append("\n"); 
		query.append("		        ,BSE_QTR_CD " ).append("\n"); 
		query.append("		        ,TRD_CD " ).append("\n"); 
		query.append("		        ,SUB_TRD_CD " ).append("\n"); 
		query.append("		        ,RLANE_CD         " ).append("\n"); 
		query.append("		        ,DIR_CD " ).append("\n"); 
		query.append("		        ,MQTA_VER_NO " ).append("\n"); 
		query.append("		        ,LANE_GRP " ).append("\n"); 
		query.append("		        ,BSE_MON          -- Trade Group" ).append("\n"); 
		query.append("		        ,POL_CD         		" ).append("\n"); 
		query.append("		        ,POD_CD         		" ).append("\n"); 
		query.append("		        ,VOYAGE " ).append("\n"); 
		query.append("		        ,BSA " ).append("\n"); 
		query.append("		        ,RHQ_CD" ).append("\n"); 
		query.append("		        ,UNIT " ).append("\n"); 
		query.append("		        ,LOD_QTY " ).append("\n"); 
		query.append("		        ,GRS_REV " ).append("\n"); 
		query.append("		        ,GRS_RPB_REV " ).append("\n"); 
		query.append("		        ,RA_CM_UC_AMT " ).append("\n"); 
		query.append("		        ,CMPB " ).append("\n"); 
		query.append("		        ,RA_OPFIT_UC_AMT " ).append("\n"); 
		query.append("		        ,OPB " ).append("\n"); 
		query.append("		FROM    (         " ).append("\n"); 
		query.append("		            SELECT   A.MQTA_STEP_CD " ).append("\n"); 
		query.append("		                    ,A.BSE_YR                                                   BSE_YR " ).append("\n"); 
		query.append("		                    ,A.BSE_QTR_CD                                               BSE_QTR_CD " ).append("\n"); 
		query.append("		                    ,A.TRD_CD                                                   TRD_CD " ).append("\n"); 
		query.append("		                    ,A.SUB_TRD_CD                                               SUB_TRD_CD " ).append("\n"); 
		query.append("		                    ,A.RLANE_CD                                                 RLANE_CD " ).append("\n"); 
		query.append("		                    ,A.DIR_CD                                                   DIR_CD " ).append("\n"); 
		query.append("		                    ,A.MQTA_VER_NO                                              MQTA_VER_NO " ).append("\n"); 
		query.append("		                    ,A.SPRT_GRP_CD||A.BSA_GRP_CD                                LANE_GRP " ).append("\n"); 
		query.append("		                    ,A.BSE_MON                                                  BSE_MON " ).append("\n"); 
		query.append("-- Trade Group" ).append("\n"); 
		query.append("		                    ,'00000'                                                    POL_CD 	" ).append("\n"); 
		query.append("		                    ,'00000'                                                    POD_CD 		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		                    ,ADJ.VOYAGE                                                 VOYAGE " ).append("\n"); 
		query.append("		                    ,DECODE(INP.UNIT, 'T', ADJ.BSA  , 'F', ADJ.BSA / 2)         BSA " ).append("\n"); 
		query.append("-- Trade Group" ).append("\n"); 
		query.append("		                    ,CTRT_RHQ_CD                                               RHQ_CD 			" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		                    ,DECODE(INP.UNIT, 'T', 'TEU'      , 'F', 'FEU')             UNIT " ).append("\n"); 
		query.append("		                    ,DECODE(INP.UNIT, 'T', A.LOD_QTY  , 'F', A.LOD_QTY / 2)     LOD_QTY " ).append("\n"); 
		query.append("		                    ,A.LOD_QTY * A.GRS_RPB_REV                                  GRS_REV" ).append("\n"); 
		query.append("		                    ,DECODE(INP.UNIT, 'T', A.GRS_RPB_REV , 'F', A.GRS_RPB_REV * 2)                                           GRS_RPB_REV     " ).append("\n"); 
		query.append("		                    ,DECODE(INP.UNIT, 'T', A.RA_CM_UC_AMT, 'F', A.RA_CM_UC_AMT *2)                                           RA_CM_UC_AMT    " ).append("\n"); 
		query.append("		                    ,DECODE(INP.UNIT, 'T', A.GRS_RPB_REV - A.CM_UC_AMT, 'F', (A.GRS_RPB_REV - A.CM_UC_AMT) * 2)        CMPB            " ).append("\n"); 
		query.append("		                    ,DECODE(INP.UNIT, 'T', A.RA_OPFIT_UC_AMT, 'F', A.RA_OPFIT_UC_AMT * 2)                                    RA_OPFIT_UC_AMT " ).append("\n"); 
		query.append("		                    ,DECODE(INP.UNIT, 'T', A.GRS_RPB_REV - A.RA_OPFIT_UC_AMT, 'F', (A.GRS_RPB_REV - A.RA_OPFIT_UC_AMT) * 2)  OPB " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--		2010.02.26. 김종호 : EDITABLE 코드를 Y로 하드코딩 처리" ).append("\n"); 
		query.append("--		                    ,DECODE(A.SPRT_GRP_CD||A.BSA_GRP_CD, " ).append("\n"); 
		query.append("--		                            MIN(A.SPRT_GRP_CD||A.BSA_GRP_CD)  " ).append("\n"); 
		query.append("--		                                OVER(PARTITION BY    A.MQTA_STEP_CD " ).append("\n"); 
		query.append("--		                                                    ,A.BSE_YR " ).append("\n"); 
		query.append("--		                                                    ,A.BSE_QTR_CD " ).append("\n"); 
		query.append("--		                                                    ,A.TRD_CD " ).append("\n"); 
		query.append("--		                                                    ,A.DIR_CD " ).append("\n"); 
		query.append("--		                                                    ,A.MQTA_VER_NO " ).append("\n"); 
		query.append("--		                                                    ,A.RLANE_CD        " ).append("\n"); 
		query.append("--		                                                    ,A.SPRT_GRP_CD        		" ).append("\n"); 
		query.append("--		                                                    ,A.BSE_MON                                                     " ).append("\n"); 
		query.append("--		                                                    ), 'Y', 'N')    EDITABLE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Trade Group" ).append("\n"); 
		query.append("		            FROM     SAQ_MON_QTA_TRD        A " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		                    ,INPUT_PARAMS           INP " ).append("\n"); 
		query.append("		                    ,WITH_TGT_VVD_ADJ       ADJ " ).append("\n"); 
		query.append("		            WHERE   1=1 " ).append("\n"); 
		query.append("		            AND     A.MQTA_STEP_CD    = INP.MQTA_STEP_CD " ).append("\n"); 
		query.append("		            AND     A.BSE_YR          = INP.BSE_YR " ).append("\n"); 
		query.append("		            AND     A.BSE_QTR_CD      = INP.BSE_QTR_CD " ).append("\n"); 
		query.append("		            AND     A.TRD_CD          = INP.TRD_CD " ).append("\n"); 
		query.append("		            AND     A.DIR_CD          = INP.DIR_CD " ).append("\n"); 
		query.append("		            AND     A.MQTA_VER_NO     = INP.MQTA_VER_NO " ).append("\n"); 
		query.append("		            AND     A.BSE_YR          = ADJ.BSE_YR " ).append("\n"); 
		query.append("		            AND     A.BSE_QTR_CD      = ADJ.BSE_QTR_CD " ).append("\n"); 
		query.append("		            AND     A.TRD_CD          = ADJ.TRD_CD " ).append("\n"); 
		query.append("		            AND     A.RLANE_CD        = ADJ.RLANE_CD " ).append("\n"); 
		query.append("		            AND     A.DIR_CD          = ADJ.DIR_CD " ).append("\n"); 
		query.append("		            AND     A.SPRT_GRP_CD     = ADJ.SPRT_GRP_CD " ).append("\n"); 
		query.append("		            AND     A.BSA_GRP_CD      = ADJ.BSA_GRP_CD " ).append("\n"); 
		query.append("		            AND     A.BSE_MON         = ADJ.BSE_MON " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		            ORDER BY A.MQTA_STEP_CD " ).append("\n"); 
		query.append("		                    ,A.BSE_YR " ).append("\n"); 
		query.append("		                    ,A.BSE_QTR_CD " ).append("\n"); 
		query.append("		                    ,A.BSE_MON " ).append("\n"); 
		query.append("		                    ,A.SUB_TRD_CD " ).append("\n"); 
		query.append("		                    ,DECODE(A.RLANE_CD,'RBCCO','ZZ',SUBSTR(A.RLANE_CD,-2)) " ).append("\n"); 
		query.append("		                    ,A.RLANE_CD " ).append("\n"); 
		query.append("		                    ,A.SPRT_GRP_CD||A.BSA_GRP_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		        )" ).append("\n"); 

	}
}