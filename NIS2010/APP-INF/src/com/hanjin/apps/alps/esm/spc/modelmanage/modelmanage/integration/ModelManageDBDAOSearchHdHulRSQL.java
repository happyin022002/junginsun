/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelManageDBDAOSearchHdHulRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.04.10 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOSearchHdHulRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 노선별 Head Hual Bound를 조회한다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public ModelManageDBDAOSearchHdHulRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchHdHulRSQL").append("\n"); 
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
		query.append("SELECT A.TRD_CD," ).append("\n"); 
		query.append("       A.SUB_TRD_CD," ).append("\n"); 
		query.append("       A.RLANE_CD," ).append("\n"); 
		query.append("       B.RLANE_NM," ).append("\n"); 
		query.append("       MAX(DIR_CD) AS DIR_CD," ).append("\n"); 
		query.append("       MAX(VSL_LANE_TP_CD) AS LANE_TP" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               TRD_CD         ," ).append("\n"); 
		query.append("               SUB_TRD_CD     ," ).append("\n"); 
		query.append("               RLANE_CD       ," ).append("\n"); 
		query.append("               '' DIR_CD      ," ).append("\n"); 
		query.append("               VSL_LANE_TP_CD" ).append("\n"); 
		query.append("          FROM MAS_LANE_RGST" ).append("\n"); 
		query.append("         WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("#if(${trade} != '')" ).append("\n"); 
		query.append("           AND TRD_CD     = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${subtrade} != '')" ).append("\n"); 
		query.append("           AND SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${lane} != '')" ).append("\n"); 
		query.append("           AND RLANE_CD   = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT TRD_CD         ," ).append("\n"); 
		query.append("               SUB_TRD_CD     ," ).append("\n"); 
		query.append("               RLANE_CD       ," ).append("\n"); 
		query.append("               DIR_CD         ," ).append("\n"); 
		query.append("               '' VSL_LANE_TP_CD" ).append("\n"); 
		query.append("          FROM SPC_HD_HUL_MST" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("#if(${trade} != '')" ).append("\n"); 
		query.append("           AND TRD_CD     = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${subtrade} != '')" ).append("\n"); 
		query.append("           AND SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${lane} != '')" ).append("\n"); 
		query.append("           AND RLANE_CD   = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) A ," ).append("\n"); 
		query.append("       MDM_REV_LANE B" ).append("\n"); 
		query.append(" WHERE B.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append(" GROUP BY A.TRD_CD," ).append("\n"); 
		query.append("          A.SUB_TRD_CD," ).append("\n"); 
		query.append("          A.RLANE_CD," ).append("\n"); 
		query.append("          B.RLANE_NM" ).append("\n"); 
		query.append(" ORDER BY A.TRD_CD," ).append("\n"); 
		query.append("          A.SUB_TRD_CD," ).append("\n"); 
		query.append("          A.RLANE_CD" ).append("\n"); 

	}
}
