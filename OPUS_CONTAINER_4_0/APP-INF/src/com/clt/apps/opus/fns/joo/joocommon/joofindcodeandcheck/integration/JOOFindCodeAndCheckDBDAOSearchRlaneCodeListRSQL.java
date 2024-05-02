/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOSearchRlaneCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOSearchRlaneCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 공통 Rlane CD 조회.
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOSearchRlaneCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOSearchRlaneCodeListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT CR.RLANE_CD" ).append("\n"); 
		query.append("     , CR.JO_CRR_CD" ).append("\n"); 
		query.append("     , CR.TRD_CD" ).append("\n"); 
		query.append("     , CR.JO_STL_OPT_CD" ).append("\n"); 
		query.append("     , CASE WHEN CR.VNDR_SEQ IS NOT NULL AND CR.CUST_SEQ IS NOT NULL THEN 'A'" ).append("\n"); 
		query.append("            ELSE CASE WHEN CR.VNDR_SEQ IS NOT NULL THEN 'E'" ).append("\n"); 
		query.append("                      ELSE CASE WHEN CR.CUST_SEQ IS NOT NULL THEN 'R'" ).append("\n"); 
		query.append("                                ELSE 'N'" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("       END AS RE_DIVR_CD" ).append("\n"); 
		query.append("     , NVL(CA.JO_CRR_AUTH_CD,'R') AS JO_CRR_AUTH_CD" ).append("\n"); 
		query.append("     , FM.LOCL_CURR_CD" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("     , SB.JO_STL_TGT_TP_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     , '' AS JO_STL_TGT_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     , CR.JO_CRR_CD||CR.TRD_CD||CR.RLANE_CD AS GRP_KEY" ).append("\n"); 
		query.append("  FROM JOO_CARRIER CR" ).append("\n"); 
		query.append("     , JOO_CRR_AUTH CA" ).append("\n"); 
		query.append("     , JOO_FINC_MTX FM" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("     , JOO_STL_BSS_PORT SB" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND CR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND CA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND CA.AUTH_OFC_CD = @[auth_ofc_cd]" ).append("\n"); 
		query.append("   AND CR.JO_CRR_CD = CA.JO_CRR_CD" ).append("\n"); 
		query.append("   AND CR.RLANE_CD = CA.RLANE_CD" ).append("\n"); 
		query.append("   AND CR.JO_CRR_CD = FM.JO_CRR_CD(+)" ).append("\n"); 
		query.append("   AND CR.RLANE_CD = FM.RLANE_CD (+)" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("   AND FM.RE_DIVR_CD(+) = @[re_divr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("   AND CR.JO_CRR_CD = SB.JO_CRR_CD (+)" ).append("\n"); 
		query.append("   AND CR.RLANE_CD = SB.RLANE_CD (+)" ).append("\n"); 
		query.append("   AND FM.JO_STL_ITM_CD(+) = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("   AND SB.JO_STL_ITM_CD(+) = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY CR.JO_CRR_CD" ).append("\n"); 
		query.append("     , CR.TRD_CD" ).append("\n"); 
		query.append("     , CR.RLANE_CD" ).append("\n"); 

	}
}