/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustRequestDBDAOSearchCustRqstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustRequestDBDAOSearchCustRqstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search customer request list
	  * </pre>
	  */
	public CustRequestDBDAOSearchCustRqstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custrequest.integration").append("\n"); 
		query.append("FileName : CustRequestDBDAOSearchCustRqstListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("    ROWNUM NO, " ).append("\n"); 
		query.append("    A.MDM_CUSTOMER_RQST_SEQ RQST_NO" ).append("\n"); 
		query.append("   ,A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("   ,OFC_CD" ).append("\n"); 
		query.append("   ,SREP_CD" ).append("\n"); 
		query.append("   ,LOC_CD" ).append("\n"); 
		query.append("   ,CUST_EML" ).append("\n"); 
		query.append("   ,A.GRP_INDIV_DIV" ).append("\n"); 
		query.append("   ,TO_CHAR(A.RQST_DT,'YYYY-MM-DD HH24:MI') RQST_DT" ).append("\n"); 
		query.append("   ,TO_CHAR(A.UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("   , TO_CHAR(" ).append("\n"); 
		query.append("         CASE WHEN A.GRP_INDIV_DIV = 'G' THEN (SELECT MCPG.CRE_DT FROM MDM_CUST_PERF_GRP MCPG WHERE MCPG.CUST_GRP_ID = A.CRM_ROW_ID AND ROWNUM = 1)" ).append("\n"); 
		query.append("         ELSE NVL((SELECT MC.CRE_DT FROM MDM_CUSTOMER MC WHERE MC.CRM_ROW_ID = A.CRM_ROW_ID AND ROWNUM = 1)" ).append("\n"); 
		query.append("				  ,(SELECT MC.CRE_DT FROM MDM_CUSTOMER MC WHERE MC.CUST_CNT_CD = A.CUST_CNT_CD AND MC.CUST_SEQ = A.CUST_SEQ AND ROWNUM = 1))" ).append("\n"); 
		query.append("         END,'YYYY-MM-DD HH24:MI')  APP_DT" ).append("\n"); 
		query.append("   , CASE WHEN A.GRP_INDIV_DIV = 'G' THEN (SELECT CUST_GRP_ID FROM MDM_CUST_PERF_GRP MCPG WHERE MCPG.CUST_GRP_ID = A.CRM_ROW_ID AND ROWNUM = 1)" ).append("\n"); 
		query.append("     ELSE NVL((SELECT MC.CUST_CNT_CD||TRIM(TO_CHAR(MC.CUST_SEQ,'000000')) FROM MDM_CUSTOMER MC WHERE MC.CRM_ROW_ID = A.CRM_ROW_ID AND ROWNUM = 1),A.CUST_CNT_CD||TRIM(TO_CHAR(A.CUST_SEQ,'000000')))" ).append("\n"); 
		query.append("     END  CUST_CD" ).append("\n"); 
		query.append("   , CASE WHEN DELT_FLG = 'N' THEN 'Saved'" ).append("\n"); 
		query.append("          WHEN DELT_FLG = 'R' THEN 'Rejected'" ).append("\n"); 
		query.append("          WHEN A.GRP_INDIV_DIV = 'G' THEN NVL((SELECT 'Approved' FROM MDM_CUST_PERF_GRP MCPG WHERE MCPG.CUST_GRP_ID = A.CRM_ROW_ID AND ROWNUM = 1),'Requested' )" ).append("\n"); 
		query.append("          WHEN CUST_CNT_CD IS NOT NULL THEN 'Approved'" ).append("\n"); 
		query.append("          WHEN DELT_FLG = 'P' THEN NVL((SELECT 'Approved' FROM MDM_CUSTOMER MC WHERE MC.CRM_ROW_ID = A.CRM_ROW_ID AND ROWNUM = 1), 'Requested' )" ).append("\n"); 
		query.append("     ELSE 'Saved'" ).append("\n"); 
		query.append("     END  DELT_FLG" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER_RQST A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${rqst_no} != '')" ).append("\n"); 
		query.append("AND A.MDM_CUSTOMER_RQST_SEQ = @[rqst_no]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND A.CUST_LGL_ENG_NM like '%' || UPPER(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD like '%' || UPPER(@[ofc_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '' && ${delt_flg} != 'ALL')" ).append("\n"); 
		query.append("and CASE WHEN DELT_FLG = 'N' THEN 'N'" ).append("\n"); 
		query.append("          WHEN DELT_FLG = 'R' THEN 'R'" ).append("\n"); 
		query.append("          WHEN A.GRP_INDIV_DIV = 'G' THEN NVL((SELECT 'A' FROM MDM_CUST_PERF_GRP MCPG WHERE MCPG.CUST_GRP_ID = A.CRM_ROW_ID AND ROWNUM = 1),'P' )" ).append("\n"); 
		query.append("          WHEN CUST_CNT_CD IS NOT NULL THEN 'A'" ).append("\n"); 
		query.append("          WHEN DELT_FLG = 'P' THEN NVL((SELECT 'A' FROM MDM_CUSTOMER MC WHERE MC.CRM_ROW_ID = A.CRM_ROW_ID AND ROWNUM = 1), 'P' )" ).append("\n"); 
		query.append("     ELSE 'N'" ).append("\n"); 
		query.append("     END = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_fm_dt} != '')" ).append("\n"); 
		query.append("AND RQST_DT >= TO_DATE(@[rqst_fm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_to_dt} != '')" ).append("\n"); 
		query.append("AND RQST_DT <= TO_DATE(@[rqst_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_fm_dt} != '')" ).append("\n"); 
		query.append("AND CRE_DT >= TO_DATE(@[cre_fm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_to_dt} != '')" ).append("\n"); 
		query.append("AND CRE_DT <= TO_DATE(@[cre_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY MDM_CUSTOMER_RQST_SEQ desc" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}