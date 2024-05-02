/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOSearchAdjustmentSlsRhqLoadZero0156ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.23 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentSlsRHQDBDAOSearchAdjustmentSlsRhqLoadZero0156ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trd_cd, dir_cd, mqta_ver_no의 조회키별 Load 합이 0인 월을 체크하여 문자열로 리턴.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentSlsRHQDBDAOSearchAdjustmentSlsRhqLoadZero0156ListRSQL(){
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
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaStepCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("glineVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inclPortFlag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOSearchAdjustmentSlsRhqLoadZero0156ListRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(TO_DATE(BSE_MON, 'MM'), 'MON', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("       ||' / '||LOD_TGT.RLANE_CD||'-'||LOD_TGT.SPRT_GRP_CD||LOD_TGT.BSA_GRP_CD" ).append("\n"); 
		query.append("       ||DECODE( 'Y', @[inclPortFlag], ' / '||POL_CD||' / '||POD_CD, '')" ).append("\n"); 
		query.append("       ||' / '||SLS_RGN_OFC_CD  AS MSG," ).append("\n"); 
		query.append("       SUB_TRD_CD," ).append("\n"); 
		query.append("       NVL(POL.PORT_SEQ, 999) AS POL_SEQ," ).append("\n"); 
		query.append("       NVL(POD.PORT_SEQ, 999) AS POD_SEQ" ).append("\n"); 
		query.append("FROM SAQ_MON_QTA_LOD_TGT LOD_TGT," ).append("\n"); 
		query.append("     SAQ_MON_QTA_PORT_SEQ POL," ).append("\n"); 
		query.append("     SAQ_MON_QTA_PORT_SEQ POD" ).append("\n"); 
		query.append("WHERE  LOD_TGT.MQTA_STEP_CD = @[mQtaStepCd]" ).append("\n"); 
		query.append("AND    LOD_TGT.BSE_YR = @[year]" ).append("\n"); 
		query.append("AND    LOD_TGT.BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND    LOD_TGT.TRD_CD = @[trade]" ).append("\n"); 
		query.append("AND    LOD_TGT.DIR_CD = @[bound]" ).append("\n"); 
		query.append("AND    LOD_TGT.MQTA_VER_NO = @[mQtaVerNo]" ).append("\n"); 
		query.append("AND    POL.BSE_YR(+) = LOD_TGT.BSE_YR" ).append("\n"); 
		query.append("AND    POL.BSE_QTR_CD(+) = LOD_TGT.BSE_QTR_CD" ).append("\n"); 
		query.append("AND    POL.GLINE_VER_NO(+) = @[glineVerNo]" ).append("\n"); 
		query.append("AND    POL.TRD_CD(+) = LOD_TGT.TRD_CD" ).append("\n"); 
		query.append("AND    POL.DIR_CD(+) = LOD_TGT.DIR_CD" ).append("\n"); 
		query.append("AND    POL.RLANE_CD(+) = LOD_TGT.RLANE_CD" ).append("\n"); 
		query.append("AND    POL.SPRT_GRP_CD(+) = LOD_TGT.SPRT_GRP_CD" ).append("\n"); 
		query.append("AND    POL.BSA_GRP_CD(+) = LOD_TGT.BSA_GRP_CD" ).append("\n"); 
		query.append("AND    POL.PORT_CD(+) = LOD_TGT.POL_CD" ).append("\n"); 
		query.append("AND    POD.BSE_YR(+) = LOD_TGT.BSE_YR" ).append("\n"); 
		query.append("AND    POD.BSE_QTR_CD(+) = LOD_TGT.BSE_QTR_CD" ).append("\n"); 
		query.append("AND    POD.GLINE_VER_NO(+) = @[glineVerNo]" ).append("\n"); 
		query.append("AND    POD.TRD_CD(+) = LOD_TGT.TRD_CD" ).append("\n"); 
		query.append("AND    POD.DIR_CD(+) = LOD_TGT.DIR_CD" ).append("\n"); 
		query.append("AND    POD.RLANE_CD(+) = LOD_TGT.RLANE_CD" ).append("\n"); 
		query.append("AND    POD.SPRT_GRP_CD(+) = LOD_TGT.SPRT_GRP_CD" ).append("\n"); 
		query.append("AND    POD.BSA_GRP_CD(+) = LOD_TGT.BSA_GRP_CD" ).append("\n"); 
		query.append("AND    POD.PORT_CD(+) = LOD_TGT.POD_CD" ).append("\n"); 
		query.append("AND    LOD_QTY = 0" ).append("\n"); 
		query.append("ORDER BY BSE_MON, SUB_TRD_CD,DECODE(LOD_TGT.RLANE_CD,'RBCCO','ZZ',SUBSTR(LOD_TGT.RLANE_CD,-2)), LOD_TGT.RLANE_CD, LOD_TGT.SPRT_GRP_CD," ).append("\n"); 
		query.append("         LOD_TGT.BSA_GRP_CD, POL_SEQ, POL_CD, POD_SEQ, POD_CD, SLS_RGN_OFC_CD" ).append("\n"); 

	}
}