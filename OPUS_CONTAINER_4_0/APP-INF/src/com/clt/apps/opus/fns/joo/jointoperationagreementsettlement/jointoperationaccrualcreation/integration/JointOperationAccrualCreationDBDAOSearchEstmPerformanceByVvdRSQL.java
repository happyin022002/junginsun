/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOSearchEstmPerformanceByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD Search
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOSearchEstmPerformanceByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_stl_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceByVvdRSQL").append("\n"); 
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
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT /*+INDEX(A XPKJOO_ESTM_ACT_RSLT)*/" ).append("\n"); 
		query.append("               ROWNUM AS RN" ).append("\n"); 
		query.append("             , DENSE_RANK() OVER(ORDER BY REV_YRMON||JO_CRR_CD||RLANE_CD||VVD||ESTM_VVD_TP_CD||ACCT_CD||JO_STL_ITM_CD||JO_STL_JB_CD||ACCL_AMT_CORR_FLG) AS GRP_NO" ).append("\n"); 
		query.append("             , 'R' AS IBFLAG" ).append("\n"); 
		query.append("             , A.EXE_YRMON" ).append("\n"); 
		query.append("             , A.REV_YRMON" ).append("\n"); 
		query.append("             , A.JO_CRR_CD" ).append("\n"); 
		query.append("             , A.RLANE_CD" ).append("\n"); 
		query.append("             , A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.REV_DIR_CD" ).append("\n"); 
		query.append("             , A.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("             , A.ACCT_CD" ).append("\n"); 
		query.append("             , A.ESTM_ACT_SEQ" ).append("\n"); 
		query.append("             , A.JO_STL_JB_CD" ).append("\n"); 
		query.append("             , A.BSA_QTY" ).append("\n"); 
		query.append("             , A.BSA_SLT_PRC" ).append("\n"); 
		query.append("             , A.ESTM_AMT" ).append("\n"); 
		query.append("             , A.ACT_AMT" ).append("\n"); 
		query.append("             , A.ACCL_AMT" ).append("\n"); 
		query.append("             , A.SYS_SRC_ID" ).append("\n"); 
		query.append("             , A.LOC_CD" ).append("\n"); 
		query.append("             , A.JO_IOC_DIV_CD" ).append("\n"); 
		query.append("             , A.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("             , A.JO_CNTR_DIV_CTNT" ).append("\n"); 
		query.append("             , A.CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append("             , A.ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("             , A.ACT_DT" ).append("\n"); 
		query.append("             , TO_CHAR(A.ST_DT,'YYYYMMDDHH24MI') AS ST_DT" ).append("\n"); 
		query.append("             , TO_CHAR(A.END_DT, 'YYYYMMDDHH24MI') AS END_DT" ).append("\n"); 
		query.append("             , A.SAIL_DYS" ).append("\n"); 
		query.append("             , A.ESTM_YRMON" ).append("\n"); 
		query.append("             , A.ESTM_DYS" ).append("\n"); 
		query.append("             , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , A.TRD_CD" ).append("\n"); 
		query.append("             , A.VNDR_CUST_SEQ" ).append("\n"); 
		query.append("             , A.CUST_CNT_CD" ).append("\n"); 
		query.append("             , A.CUST_SEQ" ).append("\n"); 
		query.append("             , A.RE_DIVR_CD" ).append("\n"); 
		query.append("             , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD" ).append("\n"); 
		query.append("             , (SELECT C.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                  FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("                 WHERE C.INTG_CD_ID = 'CD01866'" ).append("\n"); 
		query.append("                   AND C.INTG_CD_VAL_CTNT = A.JO_STL_JB_CD" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) AS JO_STL_JB_NM" ).append("\n"); 
		query.append("             , A.ORG_ESTM_AMT" ).append("\n"); 
		query.append("             , A.ORG_ACT_AMT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A.EXE_YRMON" ).append("\n"); 
		query.append("                     , A.REV_YRMON" ).append("\n"); 
		query.append("                     , A.ACCT_CD" ).append("\n"); 
		query.append("                     , A.JO_CRR_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.REV_DIR_CD" ).append("\n"); 
		query.append("                     , A.JO_STL_JB_CD" ).append("\n"); 
		query.append("                     , A.ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("                     , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     , MAX(A.ESTM_VVD_TP_CD) AS ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("                     , MAX(A.ESTM_ACT_SEQ) AS ESTM_ACT_SEQ" ).append("\n"); 
		query.append("                     , MAX(A.BSA_QTY) AS BSA_QTY" ).append("\n"); 
		query.append("                     , MAX(A.BSA_SLT_PRC) AS BSA_SLT_PRC" ).append("\n"); 
		query.append("                     , SUM(A.ESTM_AMT) AS ESTM_AMT" ).append("\n"); 
		query.append("                     , SUM(A.ACT_AMT) AS ACT_AMT" ).append("\n"); 
		query.append("                     , SUM(A.ACCL_AMT) AS ACCL_AMT" ).append("\n"); 
		query.append("                     , MAX(A.SYS_SRC_ID) AS SYS_SRC_ID" ).append("\n"); 
		query.append("                     , MAX(A.LOC_CD) AS LOC_CD" ).append("\n"); 
		query.append("                     , MAX(A.JO_IOC_DIV_CD) AS JO_IOC_DIV_CD" ).append("\n"); 
		query.append("                     , MAX(A.ESTM_VVD_HDR_ID) AS ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("                     , MAX(A.JO_CNTR_DIV_CTNT) AS JO_CNTR_DIV_CTNT" ).append("\n"); 
		query.append("                     , MAX(A.CNTR_BLK_DIV_CD) AS CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append("                     , MAX(A.ACT_DT) AS ACT_DT" ).append("\n"); 
		query.append("                     , MAX(A.ST_DT) AS ST_DT" ).append("\n"); 
		query.append("                     , MAX(A.END_DT) AS END_DT" ).append("\n"); 
		query.append("                     , MAX(A.SAIL_DYS) AS SAIL_DYS" ).append("\n"); 
		query.append("                     , MAX(A.ESTM_YRMON) AS ESTM_YRMON" ).append("\n"); 
		query.append("                     , SUM(A.ESTM_DYS) AS ESTM_DYS" ).append("\n"); 
		query.append("                     , MAX(B.TRD_CD) AS TRD_CD" ).append("\n"); 
		query.append("                     , CASE WHEN A.ACCT_CD LIKE '4%' THEN B.CUST_CNT_CD||B.CUST_SEQ" ).append("\n"); 
		query.append("                            WHEN A.ACCT_CD LIKE '5%' THEN B.VNDR_SEQ||''" ).append("\n"); 
		query.append("                       END AS VNDR_CUST_SEQ" ).append("\n"); 
		query.append("                     , CASE WHEN A.ACCT_CD LIKE '4%' THEN B.CUST_CNT_CD" ).append("\n"); 
		query.append("                            WHEN A.ACCT_CD LIKE '5%' THEN ''" ).append("\n"); 
		query.append("                       END AS CUST_CNT_CD" ).append("\n"); 
		query.append("                     , CASE WHEN A.ACCT_CD LIKE '4%' THEN B.CUST_SEQ" ).append("\n"); 
		query.append("                            WHEN A.ACCT_CD LIKE '5%' THEN B.VNDR_SEQ" ).append("\n"); 
		query.append("                       END AS CUST_SEQ" ).append("\n"); 
		query.append("                     , CASE WHEN A.ACCT_CD LIKE '4%' THEN 'R'" ).append("\n"); 
		query.append("                            WHEN A.ACCT_CD LIKE '5%' THEN 'E'" ).append("\n"); 
		query.append("                       END AS RE_DIVR_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD" ).append("\n"); 
		query.append("                     , MAX(A.ORG_ESTM_AMT) AS ORG_ESTM_AMT" ).append("\n"); 
		query.append("                     , MAX(A.ORG_ACT_AMT) AS ORG_ACT_AMT" ).append("\n"); 
		query.append("                  FROM JOO_ESTM_ACT_RSLT A" ).append("\n"); 
		query.append("                     , JOO_CARRIER B" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A.EXE_YRMON = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("				   AND A.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("                   AND A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append("                   AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("                   AND A.ACCT_CD LIKE DECODE(@[re_divr_cd],'R','4','E','5')||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("                   AND A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("                   AND B.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                   AND A.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                   AND A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD || A.REV_DIR_CD LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_jb_cd} != '')" ).append("\n"); 
		query.append("			       AND A.JO_STL_JB_CD = @[jo_stl_jb_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_include} !='' && ${chk_include} != 'Y')" ).append("\n"); 
		query.append("                   AND NVL(A.ACCL_AMT_CORR_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cds} !='')                                   " ).append("\n"); 
		query.append("                   AND A.JO_STL_ITM_CD IN (" ).append("\n"); 
		query.append("                   	   #foreach($key IN ${jo_stl_itm_cds})" ).append("\n"); 
		query.append("                            #if($velocityCount < $jo_stl_itm_cds.size()) '$key', #else '$key' #end" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${diff_option} == '1')" ).append("\n"); 
		query.append("				   AND A.ESTM_AMT >= A.ACT_AMT" ).append("\n"); 
		query.append("#elseif  (${diff_option} == '2')" ).append("\n"); 
		query.append("				   AND A.ESTM_AMT <> A.ACT_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 GROUP BY A.EXE_YRMON" ).append("\n"); 
		query.append("                     , A.REV_YRMON" ).append("\n"); 
		query.append("                     , A.JO_CRR_CD" ).append("\n"); 
		query.append("                     , B.CUST_CNT_CD" ).append("\n"); 
		query.append("                     , B.CUST_SEQ" ).append("\n"); 
		query.append("                     , B.VNDR_SEQ" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.REV_DIR_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.JO_STL_JB_CD" ).append("\n"); 
		query.append("                     , A.ACCT_CD" ).append("\n"); 
		query.append("                     , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     , A.ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("                 ORDER BY A.REV_YRMON" ).append("\n"); 
		query.append("                     , A.JO_CRR_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD" ).append("\n"); 
		query.append("                     , B.VNDR_SEQ" ).append("\n"); 
		query.append("                     , A.JO_STL_JB_CD" ).append("\n"); 
		query.append("                     , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     , MAX(A.ESTM_YRMON)" ).append("\n"); 
		query.append("            ) A " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${page_no} != '')" ).append("\n"); 
		query.append("   AND RN >= (TO_NUMBER(@[page_no]) - 1) * TO_NUMBER(@[pagerows]) + 1 AND    RN <= TO_NUMBER(@[page_no]) * TO_NUMBER(@[pagerows])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}