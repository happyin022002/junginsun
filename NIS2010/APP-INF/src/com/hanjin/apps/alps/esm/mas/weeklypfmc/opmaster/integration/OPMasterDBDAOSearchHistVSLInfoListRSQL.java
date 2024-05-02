/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OPMasterDBDAOSearchHistVSLInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOSearchHistVSLInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.03.03 Create Lane Table, Create Vessel Table history 자동 관리
	  * </pre>
	  */
	public OPMasterDBDAOSearchHistVSLInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOSearchHistVSLInfoListRSQL").append("\n"); 
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
		query.append("#if (${date_check_flag} == 'Y')" ).append("\n"); 
		query.append("SELECT VSL_CD, VSL_APLY_FM_DT, VSL_APLY_TO_DT, NEXT_FROM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	IBFLAG" ).append("\n"); 
		query.append("    ,A.VSL_SEQ                                 AS VSL_SEQ" ).append("\n"); 
		query.append("    ,A.VSL_CD                                  AS VSL_CD" ).append("\n"); 
		query.append("    ,A.VSL_TP_CD                               AS VSL_TP_CD" ).append("\n"); 
		query.append("    ,A.VSL_OSHP_CD                             AS VSL_OSHP_CD" ).append("\n"); 
		query.append("    ,A.VOP_CD                                  AS VOP_CD" ).append("\n"); 
		query.append("    ,A.VVD_CD                                  AS VVD_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(A.VSL_APLY_FM_DT , 'YYYY-MM-DD')  AS VSL_APLY_FM_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(A.VSL_APLY_TO_DT, 'YYYY-MM-DD')   AS VSL_APLY_TO_DT" ).append("\n"); 
		query.append("#if (${date_check_flag} == 'Y')" ).append("\n"); 
		query.append("    ,(SELECT TO_CHAR(AA.VSL_APLY_FM_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("        FROM MAS_VSL_RGST AA" ).append("\n"); 
		query.append("        WHERE AA.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("            AND AA.VSL_SEQ = A.VSL_SEQ + 1) AS NEXT_FROM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ,A.VSL_CLSS_CAPA                           AS VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,A.PORT_CLSS_CAPA                          AS PORT_CLSS_CAPA" ).append("\n"); 
		query.append("    ,A.VSL_DZND_CAPA                           AS VSL_DZND_CAPA" ).append("\n"); 
		query.append("    ,A.STND_LDB_CAPA                           AS STND_LDB_CAPA" ).append("\n"); 
		query.append("    ,A.CRR_CD" ).append("\n"); 
		query.append("    ,A.BSA_VSL_FLG" ).append("\n"); 
		query.append("    ,A.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("    #foreach(${keys} IN ${keyList})" ).append("\n"); 
		query.append("    ,NVL(SUM(DECODE(A.SUB_TRD_CD, '$keys', A.SUB_TRD_CAPA)),0) AS c$keys" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    ,A.CRE_USR_ID							   AS CRE_USR_ID" ).append("\n"); 
		query.append("	,A.TRD_CHK_FLG								-- HIDDEN" ).append("\n"); 
		query.append("	,A.VSL_PRC									-- HIDDEN " ).append("\n"); 
		query.append("	,A.VSL_PRC_RTO								-- HIDDEN " ).append("\n"); 
		query.append("	,TO_CHAR(A.VSL_RETN_FM_DT , 'YYYY-MM-DD')	-- HIDDEN" ).append("\n"); 
		query.append("	,TO_CHAR(A.VSL_RETN_TO_DT , 'YYYY-MM-DD')	-- HIDDEN" ).append("\n"); 
		query.append("	--,A.BSA_VSL_FLG								-- HIDDEN " ).append("\n"); 
		query.append("    ,A.UPD_USR_ID                              AS UPD_USR_ID" ).append("\n"); 
		query.append("    ,A.UPD_DT                                  AS UPD_DT" ).append("\n"); 
		query.append("  FROM (SELECT" ).append("\n"); 
		query.append("			 DECODE(B.VSL_CD,A.VSL_CD,'R','U') AS IBFLAG" ).append("\n"); 
		query.append("			,A.VSL_CD" ).append("\n"); 
		query.append("			,A.VSL_TP_CD" ).append("\n"); 
		query.append("			,A.VSL_OSHP_CD" ).append("\n"); 
		query.append("			,A.VOP_CD" ).append("\n"); 
		query.append("			,A.PORT_CLSS_CAPA" ).append("\n"); 
		query.append("			,A.STND_LDB_CAPA" ).append("\n"); 
		query.append("			,A.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("			,A.VSL_DZND_CAPA" ).append("\n"); 
		query.append("			,A.VSL_RETN_FM_DT" ).append("\n"); 
		query.append("			,A.VSL_RETN_TO_DT" ).append("\n"); 
		query.append("			,B.SUB_TRD_CD" ).append("\n"); 
		query.append("			,B.SUB_TRD_CAPA" ).append("\n"); 
		query.append("			,DECODE(B.CRE_USR_ID,'BATCH',B.CRE_USR_ID,'') CRE_USR_ID" ).append("\n"); 
		query.append("            ,A.UPD_USR_ID" ).append("\n"); 
		query.append("            ,TO_CHAR(A.UPD_DT, 'YYYY/MM/DD HH:MI') UPD_DT" ).append("\n"); 
		query.append("			,A.VSL_SEQ" ).append("\n"); 
		query.append("			,A.VVD_CD" ).append("\n"); 
		query.append("			,A.VSL_APLY_FM_DT" ).append("\n"); 
		query.append("			,A.VSL_APLY_TO_DT" ).append("\n"); 
		query.append("			,A.CRR_CD" ).append("\n"); 
		query.append("			,A.BSA_VSL_FLG" ).append("\n"); 
		query.append("			,A.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("			,A.TRD_CHK_FLG			-- HIDDEN" ).append("\n"); 
		query.append("			,A.VSL_PRC				-- HIDDEN " ).append("\n"); 
		query.append("			,A.VSL_PRC_RTO			-- HIDDEN " ).append("\n"); 
		query.append("         FROM MAS_VSL_RGST A" ).append("\n"); 
		query.append("            , MAS_VSL_SUB_TRD_CAPA B" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND A.VSL_CD    = B.VSL_CD(+)" ).append("\n"); 
		query.append("          AND A.VSL_SEQ   = B.VSL_SEQ(+)" ).append("\n"); 
		query.append("          AND A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("          AND A.VSL_CD    = @[f_vsl_cd]) A" ).append("\n"); 
		query.append(" GROUP BY" ).append("\n"); 
		query.append("	 IBFLAG     " ).append("\n"); 
		query.append("    ,A.VSL_SEQ                                 " ).append("\n"); 
		query.append("    ,A.VSL_CD                                  " ).append("\n"); 
		query.append("    ,A.VSL_TP_CD                               " ).append("\n"); 
		query.append("    ,A.VSL_OSHP_CD                             " ).append("\n"); 
		query.append("    ,A.VOP_CD                                  " ).append("\n"); 
		query.append("    ,A.VVD_CD                                  " ).append("\n"); 
		query.append("    ,TO_CHAR(A.VSL_APLY_FM_DT , 'YYYY-MM-DD')  " ).append("\n"); 
		query.append("    ,TO_CHAR(A.VSL_APLY_TO_DT, 'YYYY-MM-DD')   " ).append("\n"); 
		query.append("    ,A.VSL_CLSS_CAPA                           " ).append("\n"); 
		query.append("    ,A.PORT_CLSS_CAPA                          " ).append("\n"); 
		query.append("    ,A.VSL_DZND_CAPA                           " ).append("\n"); 
		query.append("    ,A.STND_LDB_CAPA                           " ).append("\n"); 
		query.append("    ,A.CRE_USR_ID" ).append("\n"); 
		query.append("    ,A.UPD_USR_ID" ).append("\n"); 
		query.append("    ,A.UPD_DT" ).append("\n"); 
		query.append("    ,A.CRR_CD" ).append("\n"); 
		query.append("    ,A.BSA_VSL_FLG" ).append("\n"); 
		query.append("    ,A.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("	,A.TRD_CHK_FLG			-- HIDDEN" ).append("\n"); 
		query.append("	,A.VSL_PRC				-- HIDDEN " ).append("\n"); 
		query.append("	,A.VSL_PRC_RTO			-- HIDDEN " ).append("\n"); 
		query.append("	,A.VSL_RETN_FM_DT		-- HIDDEN " ).append("\n"); 
		query.append("	,A.VSL_RETN_TO_DT		-- HIDDEN" ).append("\n"); 
		query.append(" ORDER BY A.VSL_SEQ" ).append("\n"); 
		query.append("#if (${date_check_flag} == 'Y')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NEXT_FROM IS NOT NULL" ).append("\n"); 
		query.append("AND ( " ).append("\n"); 
		query.append("    SUBSTR(REPLACE(VSL_APLY_TO_DT,'-',''), 1, 4) < SUBSTR(REPLACE(VSL_APLY_FM_DT,'-',''), 1, 4)" ).append("\n"); 
		query.append("        OR SUBSTR(REPLACE(VSL_APLY_TO_DT,'-',''), 1, 4) > SUBSTR(REPLACE(NEXT_FROM,'-',''), 1, 4)" ).append("\n"); 
		query.append("        OR (SUBSTR(REPLACE(VSL_APLY_TO_DT,'-',''), 1, 4) = SUBSTR(REPLACE(VSL_APLY_FM_DT,'-',''), 1, 4) AND SUBSTR(REPLACE(VSL_APLY_TO_DT,'-',''), 5, 2) < SUBSTR(REPLACE(VSL_APLY_FM_DT,'-',''), 5, 2))" ).append("\n"); 
		query.append("        OR (SUBSTR(REPLACE(VSL_APLY_TO_DT,'-',''), 1, 4) = SUBSTR(REPLACE(NEXT_FROM,'-',''), 1, 4) AND SUBSTR(REPLACE(VSL_APLY_TO_DT,'-',''), 5, 2) > SUBSTR(REPLACE(NEXT_FROM,'-',''), 5, 2))" ).append("\n"); 
		query.append("        OR (SUBSTR(REPLACE(VSL_APLY_TO_DT,'-',''), 1, 4) = SUBSTR(REPLACE(VSL_APLY_FM_DT,'-',''), 1, 4) AND SUBSTR(REPLACE(VSL_APLY_TO_DT,'-',''), 5, 2) = SUBSTR(REPLACE(VSL_APLY_FM_DT,'-',''), 5, 2) AND SUBSTR(REPLACE(VSL_APLY_TO_DT,'-',''), 7, 2) < SUBSTR(REPLACE(VSL_APLY_FM_DT,'-',''), 7, 2))" ).append("\n"); 
		query.append("        OR (SUBSTR(REPLACE(VSL_APLY_TO_DT,'-',''), 1, 4) = SUBSTR(REPLACE(NEXT_FROM,'-',''), 1, 4) AND SUBSTR(REPLACE(VSL_APLY_TO_DT,'-',''), 5, 2) = SUBSTR(REPLACE(NEXT_FROM,'-',''), 5, 2) AND SUBSTR(REPLACE(VSL_APLY_TO_DT,'-',''), 7, 2) > SUBSTR(REPLACE(NEXT_FROM,'-',''), 7, 2))" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}