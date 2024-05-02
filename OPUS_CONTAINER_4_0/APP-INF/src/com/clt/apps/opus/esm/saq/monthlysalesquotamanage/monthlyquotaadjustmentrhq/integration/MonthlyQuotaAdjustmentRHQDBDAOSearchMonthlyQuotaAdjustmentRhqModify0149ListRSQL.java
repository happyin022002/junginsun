/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaAdjustmentRhqModify0149ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.23 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaAdjustmentRhqModify0149ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlyQuotaAdjustmentRHQ 세부 조정을 위한 조회
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaAdjustmentRhqModify0149ListRSQL(){
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
		params.put("month1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("unit_flag",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaAdjustmentRhqModify0149ListRSQL").append("\n"); 
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
		query.append("WITH TMP_INPUT_PARMAS AS" ).append("\n"); 
		query.append("	   (SELECT" ).append("\n"); 
		query.append("		    MQTA_STEP_CD," ).append("\n"); 
		query.append("		    BSE_YR," ).append("\n"); 
		query.append("		    BSE_QTR_CD," ).append("\n"); 
		query.append("		    TRD_CD," ).append("\n"); 
		query.append("		    DIR_CD," ).append("\n"); 
		query.append("		    MQTA_VER_NO," ).append("\n"); 
		query.append("		    SAQ_STS_CD," ).append("\n"); 
		query.append("		    GLINE_VER_NO," ).append("\n"); 
		query.append("		    CRE_OFC_CD," ).append("\n"); 
		query.append("		    INCL_PORT_FLG" ).append("\n"); 
		query.append("	    FROM   SAQ_MON_QTA_STEP_VER" ).append("\n"); 
		query.append("	    WHERE  MQTA_STEP_CD = @[mqta_step_cd]" ).append("\n"); 
		query.append("	    AND    GLINE_VER_NO = @[gline_ver_no]" ).append("\n"); 
		query.append("	    AND    MQTA_VER_NO = @[mqta_ver_no]" ).append("\n"); 
		query.append("	    AND    BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("	    AND    BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("	    AND    TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("	    AND    DIR_CD = @[dir_cd] )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT SUB_TRD_CD, LANE_GRP, OFC_CD," ).append("\n"); 
		query.append("		MIN(CASE WHEN CODE='cur' THEN GRP_SEQ END) AS GRP_SEQ1," ).append("\n"); 
		query.append("		MIN(CASE WHEN CODE='cur' THEN TOT_LOD END) AS LOAD1," ).append("\n"); 
		query.append("		MIN(CASE WHEN CODE='cur' THEN TOT_RPB END) AS G_RPB1," ).append("\n"); 
		query.append("		MIN(CASE WHEN CODE='next1' THEN GRP_SEQ END) AS GRP_SEQ2," ).append("\n"); 
		query.append("		MIN(CASE WHEN CODE='next1' THEN TOT_LOD END) AS LOAD2," ).append("\n"); 
		query.append("		MIN(CASE WHEN CODE='next1' THEN TOT_RPB END) AS G_RPB2," ).append("\n"); 
		query.append("		MIN(CASE WHEN CODE='next2' THEN GRP_SEQ END) AS GRP_SEQ3," ).append("\n"); 
		query.append("		MIN(CASE WHEN CODE='next2' THEN TOT_LOD END) AS LOAD3," ).append("\n"); 
		query.append("		MIN(CASE WHEN CODE='next2' THEN TOT_RPB END) AS G_RPB3," ).append("\n"); 
		query.append("		MIN(TOT_BSA) TOT_BSA," ).append("\n"); 
		query.append("		MIN(RLANE_CD) RLANE_CD," ).append("\n"); 
		query.append("		MIN(SPRT_GRP_CD) SPRT_GRP_CD," ).append("\n"); 
		query.append("		MIN(BSA_GRP_CD) BSA_GRP_CD," ).append("\n"); 
		query.append("		MIN(CTRT_RGN_OFC_CD) CTRT_RGN_OFC_CD," ).append("\n"); 
		query.append("		MIN(BSE_MON) BSE_MON," ).append("\n"); 
		query.append("		MIN(TRD_CD) TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	   (" ).append("\n"); 
		query.append("	   SELECT" ).append("\n"); 
		query.append("	    RHQ.BSE_YR," ).append("\n"); 
		query.append("	    DECODE(RHQ.BSE_YR||RHQ.BSE_MON, RHQ.BSE_YR||@[month1], 'cur'," ).append("\n"); 
		query.append("		TO_CHAR(ADD_MONTHS(TO_DATE(RHQ.BSE_YR||@[month2],'yyyymm'),1),'yyyymm'), 'next1'," ).append("\n"); 
		query.append("		TO_CHAR(ADD_MONTHS(TO_DATE(RHQ.BSE_YR||@[month3],'yyyymm'),2),'yyyymm'), 'next2') CODE," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    RANK() OVER (PARTITION BY RHQ.BSE_MON, SUBSTR(VVD.LANE_GRP, 0,7), RHQ.CTRT_RGN_OFC_CD ORDER BY SUBSTR(VVD.LANE_GRP, 9))  AS GRP_SEQ," ).append("\n"); 
		query.append("	    RHQ.SUB_TRD_CD, --hidden" ).append("\n"); 
		query.append("	    RHQ.RLANE_CD AS RLANE_CD,  --hidden" ).append("\n"); 
		query.append("	    RHQ.SPRT_GRP_CD AS SPRT_GRP_CD,  --hidden" ).append("\n"); 
		query.append("	    RHQ.BSA_GRP_CD AS BSA_GRP_CD,  --hidden" ).append("\n"); 
		query.append("	    RHQ.CTRT_RGN_OFC_CD AS CTRT_RGN_OFC_CD,  --hidden" ).append("\n"); 
		query.append("	    RHQ.BSE_MON AS BSE_MON, --hidden" ).append("\n"); 
		query.append("	    VVD.LANE_GRP AS LANE_GRP," ).append("\n"); 
		query.append("	    RHQ.CTRT_RGN_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("	    VVD.TOT_BSA AS TOT_BSA ," ).append("\n"); 
		query.append("	    RHQ.LOD_QTY / @[unit_flag] AS TOT_LOD ," ).append("\n"); 
		query.append("	    RHQ.GRS_RPB_REV * @[unit_flag] AS TOT_RPB," ).append("\n"); 
		query.append("		VVD.TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 FROM   TMP_INPUT_PARMAS INP," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	       (" ).append("\n"); 
		query.append("		SELECT -- saq_mon_tgt_vvd_adj BSA" ).append("\n"); 
		query.append("		    VVD.BSE_MON," ).append("\n"); 
		query.append("		    VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("		    VVD.RLANE_CD," ).append("\n"); 
		query.append("		    VVD.SPRT_GRP_CD," ).append("\n"); 
		query.append("		    VVD.BSA_GRP_CD," ).append("\n"); 
		query.append("		    VVD.TRD_CD," ).append("\n"); 
		query.append("		    (VVD.RLANE_CD||'-'||VVD.SPRT_GRP_CD||'-'||VVD.BSA_GRP_CD) AS LANE_GRP," ).append("\n"); 
		query.append("		    MIN(VVD.FNL_BSA_CAPA) AS TOT_BSA" ).append("\n"); 
		query.append("		FROM   SAQ_MON_TGT_VVD_ADJ VVD, TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("		WHERE  VVD.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("		AND    VVD.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("		AND    VVD.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("		AND    VVD.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("		AND    VVD.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("		GROUP BY VVD.BSE_MON, VVD.SUB_TRD_CD,VVD.RLANE_CD,VVD.SPRT_GRP_CD,VVD.BSA_GRP_CD,VVD.TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		) VVD," ).append("\n"); 
		query.append("	       SAQ_MON_QTA_RHQ RHQ" ).append("\n"); 
		query.append("	WHERE  RHQ.MQTA_STEP_CD = INP.MQTA_STEP_CD" ).append("\n"); 
		query.append("	AND    RHQ.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("	AND    RHQ.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("	AND    RHQ.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("	AND    RHQ.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("	AND    RHQ.MQTA_VER_NO = INP.MQTA_VER_NO" ).append("\n"); 
		query.append("	AND    RHQ.BSE_MON = VVD.BSE_MON" ).append("\n"); 
		query.append("	AND    RHQ.SUB_TRD_CD = VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("	AND    RHQ.RLANE_CD = VVD.RLANE_CD" ).append("\n"); 
		query.append("	AND    RHQ.SPRT_GRP_CD = VVD.SPRT_GRP_CD" ).append("\n"); 
		query.append("	AND    RHQ.BSA_GRP_CD = VVD.BSA_GRP_CD" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	GROUP BY SUB_TRD_CD, LANE_GRP, OFC_CD" ).append("\n"); 
		query.append("	ORDER BY SUB_TRD_CD, LANE_GRP, OFC_CD" ).append("\n"); 

	}
}