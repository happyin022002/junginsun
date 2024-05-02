/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OPMasterDBDAOSearchVslRgstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOSearchVslRgstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVslRgstList SELECT
	  * </pre>
	  */
	public OPMasterDBDAOSearchVslRgstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_chkdel",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOSearchVslRgstListRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("		  DECODE(Y.VSL_CD,X.VSL_CD,'R','U')       AS STATUS" ).append("\n"); 
		query.append("		, X.VSL_CD                                AS VSL_CD" ).append("\n"); 
		query.append("		, X.VSL_TP_CD                 		      AS VSL_TP_CD" ).append("\n"); 
		query.append("		, X.VSL_OSHP_CD                           AS VSL_OSHP_CD" ).append("\n"); 
		query.append("		, X.VOP_CD                                AS VOP_CD" ).append("\n"); 
		query.append("		, X.VSL_RGST_CNT_CD                       AS VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("		, X.VSL_CLSS_CAPA                         AS VSL_CLSS_CAPA" ).append("\n"); 
		query.append("		, X.PORT_CLSS_CAPA                        AS PORT_CLSS_CAPA" ).append("\n"); 
		query.append("		, X.VSL_DZND_CAPA                         AS VSL_DZND_CAPA" ).append("\n"); 
		query.append("		, X.STND_LDB_CAPA                         AS STND_LDB_CAPA" ).append("\n"); 
		query.append("		, X.CRR_CD								  AS CRR_CD" ).append("\n"); 
		query.append("	#foreach(${keys} IN ${keyList})" ).append("\n"); 
		query.append("		, NVL(SUM(DECODE(Y.SUB_TRD_CD, '$keys', Y.SUB_TRD_CAPA)),0) AS c$keys" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		, X.VSL_PRC                               AS VSL_PRC" ).append("\n"); 
		query.append("		, NVL(MAX(X.VSL_PRC_RTO),'0')             AS VSL_PRC_RTO" ).append("\n"); 
		query.append("		, TO_CHAR(X.VSL_RETN_FM_DT, 'YYYY-MM-DD') AS VSL_RETN_FM_DT" ).append("\n"); 
		query.append("		, TO_CHAR(X.VSL_RETN_TO_DT, 'YYYY-MM-DD') AS VSL_RETN_TO_DT" ).append("\n"); 
		query.append("		, X.DELT_FLG                              AS DELT_FLG" ).append("\n"); 
		query.append("		/*, NVL(X.BSA_VSL_FLG, 'N')               AS BSA_VSL_FLG*/" ).append("\n"); 
		query.append("		/*로직 변경 히스토리가 있으면 Y 없으면 N*/" ).append("\n"); 
		query.append("		, DECODE((SELECT MAX(VSL_SEQ) " ).append("\n"); 
		query.append("				    FROM COA_VSL_RGST " ).append("\n"); 
		query.append("				   WHERE VSL_CD = X.VSL_CD)" ).append("\n"); 
		query.append("				,NULL || 1, 'N'" ).append("\n"); 
		query.append("				,1, 'N'" ).append("\n"); 
		query.append("				,'Y')                             AS BSA_VSL_FLG" ).append("\n"); 
		query.append("		, X.CRE_USR_ID                            AS CRE_USR_ID" ).append("\n"); 
		query.append("		, X.VSL_SEQ                               AS VSL_SEQ" ).append("\n"); 
		query.append("		, X.LST_FLG                               AS LST_FLG" ).append("\n"); 
		query.append("		, TO_CHAR(X.VSL_APLY_TO_DT, 'yyyy-mm-dd') AS VSL_APLY_TO_DT" ).append("\n"); 
		query.append("		, TO_CHAR(X.VSL_APLY_FM_DT, 'yyyy-mm-dd') AS VSL_APLY_FM_DT" ).append("\n"); 
		query.append("  FROM	COA_VSL_RGST X" ).append("\n"); 
		query.append("	   ,COA_VSL_SUB_TRD_CAPA Y" ).append("\n"); 
		query.append(" WHERE	X.VSL_CD    = Y.VSL_CD(+)" ).append("\n"); 
		query.append("   AND	X.VSL_SEQ   = Y.VSL_SEQ(+)" ).append("\n"); 
		query.append("   AND	X.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND	X.DELT_FLG  = @[f_chkdel]" ).append("\n"); 
		query.append("   AND (TO_CHAR(globaldate_pkg.TIME_LOCAL_OFC_FNC(@[f_ofc_cd]), 'YYYYMMDD') " ).append("\n"); 
		query.append("		BETWEEN TO_CHAR(X.VSL_APLY_FM_DT, 'YYYYMMDD') AND TO_CHAR(X.VSL_APLY_TO_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("      OR" ).append("\n"); 
		query.append("        (TO_CHAR(X.VSL_APLY_FM_DT, 'YYYYMMDD') > TO_CHAR(globaldate_pkg.TIME_LOCAL_OFC_FNC(@[f_ofc_cd]), 'YYYYMMDD') " ).append("\n"); 
		query.append("        AND X.VSL_SEQ = 1 ) -- 적용 날짜가 현재보다 큰 경우 1번 seq vsl 정보 보여줌" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("   AND X.VSL_CD LIKE @[f_vsl_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("	  DECODE(Y.VSL_CD,X.VSL_CD,'R','U')" ).append("\n"); 
		query.append("	, X.VSL_CD" ).append("\n"); 
		query.append("	, X.VSL_SEQ" ).append("\n"); 
		query.append("	, X.VSL_TP_CD" ).append("\n"); 
		query.append("	, X.VSL_OSHP_CD" ).append("\n"); 
		query.append("	, X.VOP_CD" ).append("\n"); 
		query.append("	, X.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("	, X.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("	, X.PORT_CLSS_CAPA" ).append("\n"); 
		query.append("	, X.VSL_DZND_CAPA" ).append("\n"); 
		query.append("	, X.STND_LDB_CAPA" ).append("\n"); 
		query.append("	, X.CRR_CD" ).append("\n"); 
		query.append("	, X.VSL_PRC" ).append("\n"); 
		query.append("	, TO_CHAR(X.VSL_RETN_FM_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("	, TO_CHAR(X.VSL_RETN_TO_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("	, X.DELT_FLG" ).append("\n"); 
		query.append("	, NVL(X.BSA_VSL_FLG, 'N')" ).append("\n"); 
		query.append("	, X.CRE_USR_ID" ).append("\n"); 
		query.append("	, X.LST_FLG" ).append("\n"); 
		query.append("	, X.VSL_APLY_TO_DT" ).append("\n"); 
		query.append("	, X.VSL_APLY_FM_DT" ).append("\n"); 
		query.append("ORDER BY VSL_CD" ).append("\n"); 

	}
}