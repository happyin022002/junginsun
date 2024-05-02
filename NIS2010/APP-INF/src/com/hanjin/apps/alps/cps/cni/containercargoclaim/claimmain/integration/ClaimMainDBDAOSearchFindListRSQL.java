/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ClaimMainDBDAOSearchFindListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.18
*@LastModifier : 조병연
*@LastVersion : 1.0
* 2012.01.18 조병연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JO BYEANG YEAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchFindListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Find 조회
	  * </pre>
	  */
	public ClaimMainDBDAOSearchFindListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("misc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchFindListRSQL").append("\n"); 
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
		query.append("    CGO_CLM_DIV_CD" ).append("\n"); 
		query.append("  , CGO_CLM_NO" ).append("\n"); 
		query.append("  , CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append("  , CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append("  , TRNK_REF_VVD_NO" ).append("\n"); 
		query.append("  , CLM_AREA_CD" ).append("\n"); 
		query.append("  , HDLR_OFC_CD" ).append("\n"); 
		query.append("  , HDLR_USR_ID" ).append("\n"); 
		query.append("  , STS_CD" ).append("\n"); 
		query.append("  , FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append("  , CGO_CLM_INCI_NO" ).append("\n"); 
		query.append("  , CRM_VOC_NO" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append("  , CLMT_CLM_TP_CD" ).append("\n"); 
		query.append("  , CLAIMANT" ).append("\n"); 
		query.append("  , CLMT_LOCL_AMT" ).append("\n"); 
		query.append("  , CLMT_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , CLMT_USD_AMT" ).append("\n"); 
		query.append("  , CGO_CLM_STL_TP_CD" ).append("\n"); 
		query.append("  , CGO_CLM_STL_LOCL_AMT" ).append("\n"); 
		query.append("  , CGO_CLM_STL_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , CGO_CLM_STL_USD_AMT" ).append("\n"); 
		query.append("  , LIABLE_PARTY" ).append("\n"); 
		query.append("  , CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("  , INSUR_REF_NO" ).append("\n"); 
		query.append("  , PAST_CGO_CLM_NO" ).append("\n"); 
		query.append("  , ROW_NUM" ).append("\n"); 
		query.append("  , TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("	    CLM.CGO_CLM_DIV_CD 												" ).append("\n"); 
		query.append("	  , CLM.CGO_CLM_NO                                                  " ).append("\n"); 
		query.append("	  , BL_DTL.CGO_CLM_REF_BL_NO                                        " ).append("\n"); 
		query.append("	  , CNTR_DTL.CGO_CLM_REF_CNTR_NO                                    " ).append("\n"); 
		query.append("	  , CLM.TRNK_REF_VVD_NO                                             " ).append("\n"); 
		query.append("	  , CLM.CLM_AREA_CD                                                 " ).append("\n"); 
		query.append("	  , CLM.HDLR_OFC_CD                                                 " ).append("\n"); 
		query.append("	  , CLM.HDLR_USR_ID                                                 " ).append("\n"); 
		query.append("	  , CGO_CLM_CLZ_CD||CGO_CLM_STS_CD                      			AS STS_CD" ).append("\n"); 
		query.append("	  , CLM.FMAL_CLM_RCV_DT                                             " ).append("\n"); 
		query.append("	  , CLM.CGO_CLM_INCI_NO                                             " ).append("\n"); 
		query.append("	  , CLM.CRM_VOC_NO                                                  " ).append("\n"); 
		query.append("	  , TO_CHAR(CLM.UPD_DT,'YYYYMMDD')									AS UPD_DT" ).append("\n"); 
		query.append("      , CLMT_CLM_TP_CD													" ).append("\n"); 
		query.append("          , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    PTY_NM" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    CNI_PARTY" ).append("\n"); 
		query.append("                WHERE" ).append("\n"); 
		query.append("                    CLM_PTY_NO = CLM.CLMT_CLM_PTY_NO" ).append("\n"); 
		query.append("            )                        AS CLAIMANT" ).append("\n"); 
		query.append("          , CLM.CLMT_LOCL_AMT" ).append("\n"); 
		query.append("          , CLM.CLMT_LOCL_CURR_CD" ).append("\n"); 
		query.append("          , CLM.CLMT_USD_AMT" ).append("\n"); 
		query.append("          , CLM.CGO_CLM_STL_TP_CD    " ).append("\n"); 
		query.append("          , CLM.CGO_CLM_STL_LOCL_AMT" ).append("\n"); 
		query.append("		  , CLM.CGO_CLM_STL_LOCL_CURR_CD" ).append("\n"); 
		query.append("          , CLM.CGO_CLM_STL_USD_AMT" ).append("\n"); 
		query.append("          , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    PTY_NM" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    CNI_PARTY" ).append("\n"); 
		query.append("                WHERE" ).append("\n"); 
		query.append("                    CLM_PTY_NO = CLM.LABL_CLM_PTY_NO" ).append("\n"); 
		query.append("            ) AS LIABLE_PARTY" ).append("\n"); 
		query.append("          , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    CNI_PARTY" ).append("\n"); 
		query.append("                WHERE" ).append("\n"); 
		query.append("                    CLM_PTY_NO = CLM.INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append("            )                   AS CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("          , CLM.INSUR_REF_NO    " ).append("\n"); 
		query.append("          , CLM.PAST_CGO_CLM_NO " ).append("\n"); 
		query.append("          , ROW_NUMBER () OVER (ORDER BY CLM.CGO_CLM_NO DESC) ROW_NUM" ).append("\n"); 
		query.append("          , COUNT ( *) OVER () TOTAL" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            CNI_CLM_V CLM" ).append("\n"); 
		query.append("          , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    CGO_CLM_NO" ).append("\n"); 
		query.append("                  , CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    CNI_CGO_CLM_BL_DTL" ).append("\n"); 
		query.append("				#if(${sch_cond} != 'BL_NO')" ).append("\n"); 
		query.append("                WHERE" ).append("\n"); 
		query.append("                    MN_BL_FLG = 'Y' --대표 B/L 번호" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            BL_DTL" ).append("\n"); 
		query.append("          , (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    CGO_CLM_NO" ).append("\n"); 
		query.append("                  , CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    CNI_CGO_CLM_CNTR_DTL" ).append("\n"); 
		query.append("				#if(${sch_cond} != 'CNTR_NO')" ).append("\n"); 
		query.append("                WHERE" ).append("\n"); 
		query.append("                    MN_CNTR_FLG = 'Y'--대표 컨테이너 번호" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            CNTR_DTL" ).append("\n"); 
		query.append("           , CNI_AREA_OFC AREA" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            CLM.CGO_CLM_NO = BL_DTL.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("            AND CLM.CGO_CLM_NO = CNTR_DTL.CGO_CLM_NO (+)" ).append("\n"); 
		query.append("			AND CLM.CRE_OFC_CD  = AREA.OFC_CD(+)" ).append("\n"); 
		query.append("            #if(${sch_cond} == 'CLM_NO')" ).append("\n"); 
		query.append("            AND CLM.CGO_CLM_NO LIKE @[sch_str]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if(${sch_cond} == 'BL_NO')" ).append("\n"); 
		query.append("            AND BL_DTL.CGO_CLM_REF_BL_NO LIKE @[sch_str]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if(${sch_cond} == 'CNTR_NO')" ).append("\n"); 
		query.append("            AND CNTR_DTL.CGO_CLM_REF_CNTR_NO LIKE @[sch_str]||'%' " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if(${sch_cond} == 'VVD')" ).append("\n"); 
		query.append("            AND CLM.TRNK_REF_VVD_NO LIKE @[sch_str]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if(${sch_cond} == 'INCI_NO')" ).append("\n"); 
		query.append("            AND CLM.CGO_CLM_INCI_NO LIKE @[sch_str]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if(${sch_cond} == 'VOC_NO')" ).append("\n"); 
		query.append("            AND CLM.CRM_VOC_NO LIKE @[sch_str]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if(${sch_cond} == 'INSURER_REF')" ).append("\n"); 
		query.append("            AND CLM.INSUR_REF_NO LIKE @[sch_str]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if(${sch_cond} == 'IMS_NO')" ).append("\n"); 
		query.append("            AND CLM.PAST_CGO_CLM_NO LIKE @[sch_str]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("			#if(${misc_cd} != '')" ).append("\n"); 
		query.append("            AND CLM.CLM_AREA_CD = @[misc_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("			#if(${vt} != '')" ).append("\n"); 
		query.append("            AND CLM.CGO_CLM_DIV_CD = @[vt]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${start_page} != '') " ).append("\n"); 
		query.append("WHERE ROW_NUM BETWEEN ${start_page} AND ${end_page}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}