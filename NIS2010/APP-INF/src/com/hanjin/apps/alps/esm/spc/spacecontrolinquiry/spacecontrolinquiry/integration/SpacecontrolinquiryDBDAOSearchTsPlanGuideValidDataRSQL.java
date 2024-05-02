/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchTsPlanGuideValidDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSearchTsPlanGuideValidDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [T/S Plan & guide vvd에 맞는 Yard, ETD, Lane]을 [조회]합니다.
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchTsPlanGuideValidDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchTsPlanGuideValidDataRSQL").append("\n"); 
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
		query.append("#if (${search_tp} == '1')" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       SPC_GET_REP_TRD_FNC(A1.RLANE_CD) AS REP_TRD_CD " ).append("\n"); 
		query.append("     , SPC_GET_REP_SUB_TRD_FNC(A1.RLANE_CD) AS REP_SUB_TRD_CD " ).append("\n"); 
		query.append("     , A1.DIR_CD" ).append("\n"); 
		query.append("     , A1.COST_WK" ).append("\n"); 
		query.append("     , NVL(V1.ACT_CRR_CD, M.CRR_CD) AS CRR_CD" ).append("\n"); 
		query.append(" FROM MAS_MON_VVD A1, VSK_VSL_SKD V1, MDM_VSL_CNTR M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A1.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("  AND A1.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("  AND A1.DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("  AND A1.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("  AND M.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("  AND V1.VSL_CD      = A1.VSL_CD" ).append("\n"); 
		query.append("  AND V1.SKD_VOY_NO  = A1.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND V1.SKD_DIR_CD  = A1.DIR_CD" ).append("\n"); 
		query.append("  AND V1.VSL_CD      = M.VSL_CD" ).append("\n"); 
		query.append("  AND A1.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${search_tp} == '2') " ).append("\n"); 
		query.append("SELECT  SUBSTR(YD_CD, -2) AS YD_CD" ).append("\n"); 
		query.append("      , SLAN_CD" ).append("\n"); 
		query.append("      , TO_CHAR(VPS_ETD_DT, 'YYYYMMDD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("   AND CLPT_IND_SEQ = (SELECT MAX(CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                        FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                           AND VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#elseif (${pol_cd} == '') " ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}