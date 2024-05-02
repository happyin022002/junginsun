/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PreventionDBDAOSearchPreventionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.29
*@LastModifier : 표준희
*@LastVersion : 1.0
* 2011.08.29 표준희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.prevention.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author pyojunhee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreventionDBDAOSearchPreventionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Prevention list 조회
	  * </pre>
	  */
	public PreventionDBDAOSearchPreventionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_prve_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_start",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_search_text",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_prve_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.prevention.integration").append("\n"); 
		query.append("FileName : PreventionDBDAOSearchPreventionListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    CLM_PRVE_DIV_CD" ).append("\n"); 
		query.append("  , CLM_PRVE_DIV_NM" ).append("\n"); 
		query.append("  , CLM_PRVE_NO" ).append("\n"); 
		query.append("  , CLM_PRVE_SUBJ_NM" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , CRE_DT_ORD" ).append("\n"); 
		query.append("  , CLM_AREA_CD" ).append("\n"); 
		query.append("  , CRE_OFC_CD" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , DECODE(FILE_CNT , 0 , 1 , 0) FILE_CNT" ).append("\n"); 
		query.append("  , CLM_PRVE_READ_KNT" ).append("\n"); 
		query.append("  , CLM_PRVE_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            CLM_PRVE_DIV_CD" ).append("\n"); 
		query.append("          , CNI_GET_CLM_MISC_NM_FNC ('37', CLM_PRVE_DIV_CD, '2') CLM_PRVE_DIV_NM" ).append("\n"); 
		query.append("          , CLM_PRVE_NO" ).append("\n"); 
		query.append("          , CLM_PRVE_SUBJ_NM" ).append("\n"); 
		query.append("          , TO_CHAR (CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("		  , CRE_DT CRE_DT_ORD" ).append("\n"); 
		query.append("          , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    CLM_AREA_CD" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    CNI_AREA_OFC" ).append("\n"); 
		query.append("                WHERE" ).append("\n"); 
		query.append("                    OFC_CD = CRE_OFC_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            CLM_AREA_CD" ).append("\n"); 
		query.append("          , CRE_OFC_CD" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    COUNT ( *)" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    CNI_ATCH_FILE" ).append("\n"); 
		query.append("                WHERE" ).append("\n"); 
		query.append("                    CLM_FILE_TP_CD     = '002301'" ).append("\n"); 
		query.append("                    AND CGO_CLM_REF_NO = CLM_PRVE_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            FILE_CNT" ).append("\n"); 
		query.append("          , CLM_PRVE_READ_KNT" ).append("\n"); 
		query.append("          , CLM_PRVE_DESC" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            CNI_CLM_PRVE" ).append("\n"); 
		query.append("        WHERE EFF_DT <= @[cur_dt]" ).append("\n"); 
		query.append("		 AND EXP_DT >= @[cur_dt]" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            'C' CLM_PRVE_DIV_CD" ).append("\n"); 
		query.append("          , 'CCC' CLM_PRVE_DIV_NM" ).append("\n"); 
		query.append("          , '' CLM_PRVE_NO" ).append("\n"); 
		query.append("          , CGO_CLM_NO CLM_PRVE_SUBJ_NM" ).append("\n"); 
		query.append("          , TO_CHAR (A.CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("		  , A.CRE_DT CRE_DT_ORD" ).append("\n"); 
		query.append("          , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    CLM_AREA_CD" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    CNI_AREA_OFC" ).append("\n"); 
		query.append("                WHERE" ).append("\n"); 
		query.append("                    OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            CLM_AREA_CD" ).append("\n"); 
		query.append("          , B.OFC_CD CRE_OFC_CD" ).append("\n"); 
		query.append("          , A.CRE_USR_ID" ).append("\n"); 
		query.append("          , 0 FILE_CNT" ).append("\n"); 
		query.append("          , 0 CLM_PRVE_READ_KNT" ).append("\n"); 
		query.append("          , CGO_CLM_STL_DESC CLM_PRVE_DESC" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            CNI_CGO_CLM_STL A" ).append("\n"); 
		query.append("          , COM_USER B" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            B.USR_ID = A.CRE_USR_ID" ).append("\n"); 
		query.append("            AND A.CRE_DT BETWEEN TO_DATE(@[cre_dt_start],'YYYYMMDD') and TO_DATE(@[cre_dt_end],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("        #if (${usr_roles} == '') " ).append("\n"); 
		query.append("			AND 1 = 2" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  #if (${clm_prve_div_cd} != '') " ).append("\n"); 
		query.append("    AND CLM_PRVE_DIV_CD = @[clm_prve_div_cd]" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  #if (${clm_prve_no} != '') " ).append("\n"); 
		query.append("     AND CLM_PRVE_NO = @[clm_prve_no]" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  #if (${cre_dt_start} != '') " ).append("\n"); 
		query.append("    AND CRE_DT BETWEEN @[cre_dt_start] and @[cre_dt_end]" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  #if (${clm_area_cd} != '') " ).append("\n"); 
		query.append("	AND CLM_AREA_CD = @[clm_area_cd]" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  #if (${cre_ofc_cd} != '') " ).append("\n"); 
		query.append("    AND CRE_OFC_CD  = @[cre_ofc_cd]" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  #if (${cre_usr_id} != '') " ).append("\n"); 
		query.append("    AND CRE_USR_ID  = @[cre_usr_id]" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  #if (${cond_search_text} != '') " ).append("\n"); 
		query.append("    AND (CLM_PRVE_DESC LIKE  '%' || @[cond_search_text] || '%'  OR" ).append("\n"); 
		query.append("         CLM_PRVE_SUBJ_NM  LIKE  '%' || @[cond_search_text] || '%'   " ).append("\n"); 
		query.append("    		)" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("    CRE_DT_ORD DESC" ).append("\n"); 

	}
}