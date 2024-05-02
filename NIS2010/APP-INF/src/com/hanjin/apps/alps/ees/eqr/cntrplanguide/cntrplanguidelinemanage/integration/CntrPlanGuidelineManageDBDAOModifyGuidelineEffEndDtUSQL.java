/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOModifyGuidelineEffEndDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineManageDBDAOModifyGuidelineEffEndDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Eff_end_dt Updat
	  * - 전차수의 Eff_end_dt를 현재의 차수의 Eff_st_dt -1일로 Update
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOModifyGuidelineEffEndDtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOModifyGuidelineEffEndDtUSQL").append("\n"); 
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
		query.append("UPDATE EQR_CTRL_GLINE_HDR" ).append("\n"); 
		query.append("#if (${cfm_flg} == 'N') " ).append("\n"); 
		query.append("   SET EFF_END_DT = '99991231'" ).append("\n"); 
		query.append("#elseif (${cfm_flg} == 'Y') " ).append("\n"); 
		query.append("   SET EFF_END_DT = (SELECT TO_CHAR(TO_DATE(MAX(EFF_ST_DT),'YYYYMMDD') - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("                        FROM EQR_CTRL_GLINE_HDR" ).append("\n"); 
		query.append("                       WHERE 1=1" ).append("\n"); 
		query.append("                         AND TRD_CD 		= @[trd_cd]" ).append("\n"); 
		query.append("                         AND SUB_TRD_CD 	= @[sub_trd_cd]" ).append("\n"); 
		query.append("                         AND VSL_LANE_CD 	= @[vsl_lane_cd]" ).append("\n"); 
		query.append("                         AND EQ_GLINE_SEQ   = @[eq_gline_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("  AND TRD_CD 		= @[trd_cd]" ).append("\n"); 
		query.append("  AND SUB_TRD_CD 	= @[sub_trd_cd]" ).append("\n"); 
		query.append("  AND VSL_LANE_CD 	= @[vsl_lane_cd]" ).append("\n"); 
		query.append("  AND EQ_GLINE_SEQ  = (SELECT MAX(EQ_GLINE_SEQ)" ).append("\n"); 
		query.append("                         FROM EQR_CTRL_GLINE_HDR" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                          AND TRD_CD 		= @[trd_cd]" ).append("\n"); 
		query.append("                          AND SUB_TRD_CD 	= @[sub_trd_cd]" ).append("\n"); 
		query.append("                          AND VSL_LANE_CD 	= @[vsl_lane_cd]" ).append("\n"); 
		query.append("                          AND EQ_GLINE_SEQ 	< @[eq_gline_seq]" ).append("\n"); 
		query.append(" 						  AND CFM_FLG       = 'Y'" ).append("\n"); 
		query.append("                       )" ).append("\n"); 

	}
}