/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SPServiceCategoryDBDAOSearchSpSvcCateCfmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.17 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPServiceCategoryDBDAOSearchSpSvcCateCfmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 업체의 서비스 카테고리 정보를 조회한다
	  * </pre>
	  */
	public SPServiceCategoryDBDAOSearchSpSvcCateCfmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.integration").append("\n"); 
		query.append("FileName : SPServiceCategoryDBDAOSearchSpSvcCateCfmRSQL").append("\n"); 
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
		query.append("SELECT LPAD(SP_SEQ,6,0 )AS SP_SEQ" ).append("\n"); 
		query.append("     , SP_NAME" ).append("\n"); 
		query.append("     , SP_GRP_OFC_CD" ).append("\n"); 
		query.append("     , SP_CTRL_OFC_CD " ).append("\n"); 
		query.append("     , EV_SVC_CATE_CD" ).append("\n"); 
		query.append("     , MAPTYPE" ).append("\n"); 
		query.append("     , (SELECT SUBSTR(MAX(AAA),2, LENGTH(MAX(AAA))) " ).append("\n"); 
		query.append("           FROM (SELECT SYS_CONNECT_BY_PATH(INTG_CD_VAL_CTNT,',') AAA " ).append("\n"); 
		query.append("                         , NUM " ).append("\n"); 
		query.append("                      FROM (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                 , ROWNUM NUM " ).append("\n"); 
		query.append("                              FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                             WHERE INTG_CD_ID ='CD03377'" ).append("\n"); 
		query.append("                            ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("                            ) " ).append("\n"); 
		query.append("                   START WITH NUM=1" ).append("\n"); 
		query.append("                   CONNECT BY PRIOR NUM=NUM-1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        )PLUSCOL" ).append("\n"); 
		query.append("	 , SP_CTRT_OFC_CD" ).append("\n"); 
		query.append("     , (SELECT COUNT(1)  FROM SPE_SP_BZC_EV_GRP WHERE SP_SEQ = A.SP_SEQ) AS ISFLAG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#if(${s_chk_all} != '')" ).append("\n"); 
		query.append("      SELECT A.SP_SEQ" ).append("\n"); 
		query.append("            ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ= A.SP_SEQ AND NVL(DELT_FLG, 'N') <> 'Y') SP_NAME" ).append("\n"); 
		query.append("            , A.SP_GRP_OFC_CD" ).append("\n"); 
		query.append("            , A.SP_CTRL_OFC_CD " ).append("\n"); 
		query.append("            , B.EV_SVC_CATE_CD " ).append("\n"); 
		query.append("            , 'MAPPER' AS MAPTYPE" ).append("\n"); 
		query.append("	        , A.SP_CTRT_OFC_CD" ).append("\n"); 
		query.append("         FROM SPE_SP A" ).append("\n"); 
		query.append("            , SPE_SP_SVC_CATE_STUP B" ).append("\n"); 
		query.append("        WHERE A.SP_SEQ = B.SP_SEQ" ).append("\n"); 
		query.append("      #if(${s_sp_seq} != '')" ).append("\n"); 
		query.append("          AND A.SP_SEQ = @[s_sp_seq]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${s_eg_rhq_cd} != '')" ).append("\n"); 
		query.append("          AND A.SP_GRP_OFC_CD = @[s_eg_rhq_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${s_eg_ofc_cd} != '')" ).append("\n"); 
		query.append("          AND A.SP_CTRL_OFC_CD = @[s_eg_ofc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("        SELECT AA.VNDR_SEQ " ).append("\n"); 
		query.append("             , AA.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("             , TT.TG" ).append("\n"); 
		query.append("             , AA.OFC_CD" ).append("\n"); 
		query.append("             , ''" ).append("\n"); 
		query.append("             , 'UNMAPPER' AS MAPTYPE" ).append("\n"); 
		query.append("	         , ''" ).append("\n"); 
		query.append("         FROM MDM_VENDOR AA" ).append("\n"); 
		query.append("            , (SELECT OFC_CD" ).append("\n"); 
		query.append("                    , SPE_GET_RHQ_OFC_CD_FNC(OFC_CD) TG" ).append("\n"); 
		query.append("                 FROM  MDM_ORGANIZATION    " ).append("\n"); 
		query.append("               ) TT" ).append("\n"); 
		query.append("         WHERE NVL(AA.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("           AND AA.OFC_CD = TT.OFC_CD" ).append("\n"); 
		query.append("           AND TT.TG =@[s_eg_rhq_cd]" ).append("\n"); 
		query.append("           AND NOT EXISTS(SELECT A.SP_SEQ" ).append("\n"); 
		query.append("                            FROM SPE_SP A" ).append("\n"); 
		query.append("                               , SPE_SP_SVC_CATE_STUP B" ).append("\n"); 
		query.append("                           WHERE A.SP_SEQ = B.SP_SEQ" ).append("\n"); 
		query.append("                             AND A.SP_SEQ = AA.VNDR_SEQ" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_chk_map} != '')" ).append("\n"); 
		query.append("      SELECT A.SP_SEQ" ).append("\n"); 
		query.append("            ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ= A.SP_SEQ AND NVL(DELT_FLG, 'N') <> 'Y') SP_NAME" ).append("\n"); 
		query.append("            , A.SP_GRP_OFC_CD" ).append("\n"); 
		query.append("            , A.SP_CTRL_OFC_CD " ).append("\n"); 
		query.append("            , B.EV_SVC_CATE_CD " ).append("\n"); 
		query.append("            , 'MAPPER' AS MAPTYPE" ).append("\n"); 
		query.append("            , A.SP_CTRT_OFC_CD" ).append("\n"); 
		query.append("         FROM SPE_SP A" ).append("\n"); 
		query.append("            , SPE_SP_SVC_CATE_STUP B" ).append("\n"); 
		query.append("        WHERE A.SP_SEQ = B.SP_SEQ" ).append("\n"); 
		query.append("      #if(${s_sp_seq} != '')" ).append("\n"); 
		query.append("          AND A.SP_SEQ = @[s_sp_seq]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${s_eg_rhq_cd} != '')" ).append("\n"); 
		query.append("          AND A.SP_GRP_OFC_CD = @[s_eg_rhq_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${s_eg_ofc_cd} != '')" ).append("\n"); 
		query.append("          AND A.SP_CTRL_OFC_CD = @[s_eg_ofc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_chk_unmap} != '')" ).append("\n"); 
		query.append("        SELECT AA.VNDR_SEQ AS SP_SEQ " ).append("\n"); 
		query.append("             , AA.VNDR_LGL_ENG_NM AS SP_NAME" ).append("\n"); 
		query.append("             , TT.TG AS SP_GRP_OFC_CD" ).append("\n"); 
		query.append("             , AA.OFC_CD AS SP_CTRL_OFC_CD " ).append("\n"); 
		query.append("             , '' AS EV_SVC_CATE_CD" ).append("\n"); 
		query.append("             , 'UNMAPPER' AS MAPTYPE" ).append("\n"); 
		query.append("	         , '' AS SP_CTRT_OFC_CD" ).append("\n"); 
		query.append("         FROM MDM_VENDOR AA" ).append("\n"); 
		query.append("            , (SELECT OFC_CD" ).append("\n"); 
		query.append("                    , SPE_GET_RHQ_OFC_CD_FNC(OFC_CD) TG" ).append("\n"); 
		query.append("                 FROM  MDM_ORGANIZATION    " ).append("\n"); 
		query.append("               ) TT" ).append("\n"); 
		query.append("         WHERE NVL(AA.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("           AND AA.OFC_CD = TT.OFC_CD" ).append("\n"); 
		query.append("           AND TT.TG =@[s_eg_rhq_cd]" ).append("\n"); 
		query.append("           AND NOT EXISTS(SELECT A.SP_SEQ" ).append("\n"); 
		query.append("                            FROM SPE_SP A" ).append("\n"); 
		query.append("                               , SPE_SP_SVC_CATE_STUP B" ).append("\n"); 
		query.append("                           WHERE A.SP_SEQ = B.SP_SEQ" ).append("\n"); 
		query.append("                             AND A.SP_SEQ =AA.VNDR_SEQ" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ) A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${s_sp_seq} != '')" ).append("\n"); 
		query.append("    AND SP_SEQ = @[s_sp_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_eg_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND SP_CTRL_OFC_CD = @[s_eg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND SP_CTRT_OFC_CD = @[s_ctrt_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SP_SEQ,EV_SVC_CATE_CD" ).append("\n"); 

	}
}