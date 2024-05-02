/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupMappingDBDAOSearchEGBEMappingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.02
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.04.02 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupMappingDBDAOSearchEGBEMappingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Evaluation Group Mapping & Basic Evaluation 화면을 조회한다
	  * </pre>
	  */
	public EvaluationGroupMappingDBDAOSearchEGBEMappingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration").append("\n"); 
		query.append("FileName : EvaluationGroupMappingDBDAOSearchEGBEMappingRSQL").append("\n"); 
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
		query.append("SELECT EG_ID" ).append("\n"); 
		query.append("     , EG_NM" ).append("\n"); 
		query.append("     , SP_SEQ" ).append("\n"); 
		query.append("     , SP_NAME" ).append("\n"); 
		query.append("     , EV_YR" ).append("\n"); 
		query.append("     , BZC_EV_GRD_CD" ).append("\n"); 
		query.append("     , EVR_USR_ID" ).append("\n"); 
		query.append("     , EVR_USR_NM" ).append("\n"); 
		query.append("     , EV_DT" ).append("\n"); 
		query.append("     , SP_BZC_EG_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.EG_ID" ).append("\n"); 
		query.append("     , A.EG_NM" ).append("\n"); 
		query.append("     , LPAD(B.SP_SEQ, 6, '0') AS SP_SEQ" ).append("\n"); 
		query.append("     , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = B.SP_SEQ) AS SP_NAME" ).append("\n"); 
		query.append("     , CASE WHEN TO_NUMBER(@[s_ev_yr])-1 = B.EV_YR THEN '' ELSE B.EV_YR END EV_YR" ).append("\n"); 
		query.append("     , CASE WHEN TO_NUMBER(@[s_ev_yr])-1 = B.EV_YR THEN '' ELSE B.BZC_EV_GRD_CD END BZC_EV_GRD_CD" ).append("\n"); 
		query.append("     , (SELECT EVR_USR_ID FROM SPE_EV_GRP_EVR WHERE EG_ID = A.EG_ID AND EV_KND_CD = 'B') AS EVR_USR_ID" ).append("\n"); 
		query.append("     , (SELECT USR_NM  FROM COM_USER WHERE B.EVR_USR_ID = USR_ID AND USE_FLG = 'Y') AS EVR_USR_NM" ).append("\n"); 
		query.append("     , TO_CHAR(B.EV_DT,'YYYYMMDD') AS EV_DT" ).append("\n"); 
		query.append("     , SP_BZC_EG_SEQ" ).append("\n"); 
		query.append("  FROM SPE_EV_GRP A" ).append("\n"); 
		query.append("     , (SELECT EG_ID" ).append("\n"); 
		query.append("             , SP_SEQ" ).append("\n"); 
		query.append("             , EV_YR" ).append("\n"); 
		query.append("             , BZC_EV_GRD_CD" ).append("\n"); 
		query.append("             , EVR_USR_ID" ).append("\n"); 
		query.append("             , EV_DT" ).append("\n"); 
		query.append("             , SP_BZC_EG_SEQ" ).append("\n"); 
		query.append("          FROM (SELECT A.EG_ID" ).append("\n"); 
		query.append("                     , A.SP_SEQ" ).append("\n"); 
		query.append("                     , A.EV_YR" ).append("\n"); 
		query.append("                     , A.BZC_EV_GRD_CD" ).append("\n"); 
		query.append("                     , A.EVR_USR_ID" ).append("\n"); 
		query.append("                     , A.EV_DT" ).append("\n"); 
		query.append("                     , SP_BZC_EG_SEQ" ).append("\n"); 
		query.append("                  FROM SPE_SP_BZC_EV_GRP A" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("#if(${s_ev_yr} != '')" ).append("\n"); 
		query.append("                    AND A.EV_YR = @[s_ev_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT AA.EG_ID" ).append("\n"); 
		query.append("                     , AA.SP_SEQ" ).append("\n"); 
		query.append("                     , AA.EV_YR" ).append("\n"); 
		query.append("                     , AA.BZC_EV_GRD_CD" ).append("\n"); 
		query.append("                     , AA.EVR_USR_ID" ).append("\n"); 
		query.append("                     , AA.EV_DT" ).append("\n"); 
		query.append("                     , AA.SP_BZC_EG_SEQ" ).append("\n"); 
		query.append("                  FROM SPE_SP_BZC_EV_GRP AA" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("#if(${s_ev_yr} != '')" ).append("\n"); 
		query.append("                    AND AA.EV_YR = TO_NUMBER(@[s_ev_yr])-1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    AND AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND NOT EXISTS (SELECT A.EG_ID" ).append("\n"); 
		query.append("                                         , A.SP_SEQ" ).append("\n"); 
		query.append("                                         , A.EV_YR" ).append("\n"); 
		query.append("                                         , A.BZC_EV_GRD_CD" ).append("\n"); 
		query.append("                                         , A.EVR_USR_ID" ).append("\n"); 
		query.append("                                         , A.EV_DT" ).append("\n"); 
		query.append("                                         , SP_BZC_EG_SEQ" ).append("\n"); 
		query.append("                                      FROM SPE_SP_BZC_EV_GRP A" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                       #if(${s_ev_yr} != '')" ).append("\n"); 
		query.append("                                       AND A.EV_YR = @[s_ev_yr]" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                                       AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                       AND A.EG_ID = AA.EG_ID" ).append("\n"); 
		query.append("                                       AND A.SP_SEQ = AA.SP_SEQ" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${s_chk_map} != '')" ).append("\n"); 
		query.append("   AND A.EG_ID = B.EG_ID" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND A.EG_ID = B.EG_ID(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N' " ).append("\n"); 
		query.append("   AND EG_RHQ_CD        = @[s_eg_rhq_cd]" ).append("\n"); 
		query.append("#if(${s_eg_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND EG_OFC_CD        = @[s_eg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_ev_svc_cate_cd} != '' )" ).append("\n"); 
		query.append("   AND EV_SVC_CATE_CD   = @[s_ev_svc_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${s_chk_map} != '')" ).append("\n"); 
		query.append("   AND BZC_EV_GRD_CD  IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_chk_unmap} != '')" ).append("\n"); 
		query.append("   AND BZC_EV_GRD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY  SP_SEQ" ).append("\n"); 

	}
}