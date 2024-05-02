/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOEstmActRsltVOByMonthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.21 
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

public class JointOperationAccrualCreationDBDAOEstmActRsltVOByMonthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * By Month Search
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOEstmActRsltVOByMonthRSQL(){
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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : JointOperationAccrualCreationDBDAOEstmActRsltVOByMonthRSQL").append("\n"); 
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
		query.append("             , 'R' AS IBFLAG" ).append("\n"); 
		query.append("             , A.GRP_NO" ).append("\n"); 
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
		query.append("             , A.MIN_ESTM_YRMON" ).append("\n"); 
		query.append("             , A.MAX_ESTM_YRMON" ).append("\n"); 
		query.append("             , CASE WHEN (SUM(A.CHK_EDIT_CNT) OVER (PARTITION BY A.GRP_NO)) > 0 THEN 'N'" ).append("\n"); 
		query.append("                    ELSE 'Y'" ).append("\n"); 
		query.append("               END AS CHK_EDIT_FLG" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A.EXE_YRMON" ).append("\n"); 
		query.append("                     , A.REV_YRMON" ).append("\n"); 
		query.append("                     , A.JO_CRR_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.REV_DIR_CD" ).append("\n"); 
		query.append("                     , A.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("                     , A.ACCT_CD" ).append("\n"); 
		query.append("                     , A.ESTM_ACT_SEQ" ).append("\n"); 
		query.append("                     , A.JO_STL_JB_CD" ).append("\n"); 
		query.append("                     , A.BSA_QTY AS BSA_QTY" ).append("\n"); 
		query.append("                     , A.BSA_SLT_PRC AS BSA_SLT_PRC" ).append("\n"); 
		query.append("                     , A.ESTM_AMT AS ESTM_AMT" ).append("\n"); 
		query.append("                     , A.ACT_AMT AS ACT_AMT" ).append("\n"); 
		query.append("                     , A.ACCL_AMT AS ACCL_AMT" ).append("\n"); 
		query.append("                     , A.SYS_SRC_ID AS SYS_SRC_ID" ).append("\n"); 
		query.append("                     , A.LOC_CD AS LOC_CD" ).append("\n"); 
		query.append("                     , A.JO_IOC_DIV_CD AS JO_IOC_DIV_CD" ).append("\n"); 
		query.append("                     , A.ESTM_VVD_HDR_ID AS ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("                     , A.JO_CNTR_DIV_CTNT AS JO_CNTR_DIV_CTNT" ).append("\n"); 
		query.append("                     , A.CNTR_BLK_DIV_CD AS CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append("                     , A.ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("                     , A.ACT_DT AS ACT_DT" ).append("\n"); 
		query.append("                     , A.ST_DT AS ST_DT" ).append("\n"); 
		query.append("                     , A.END_DT AS END_DT" ).append("\n"); 
		query.append("                     , A.SAIL_DYS AS SAIL_DYS" ).append("\n"); 
		query.append("                     , A.ESTM_YRMON AS ESTM_YRMON" ).append("\n"); 
		query.append("                     , A.ESTM_DYS AS ESTM_DYS" ).append("\n"); 
		query.append("                     , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     , B.TRD_CD AS TRD_CD" ).append("\n"); 
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
		query.append("                     , A.ORG_ESTM_AMT" ).append("\n"); 
		query.append("                     , A.ORG_ACT_AMT" ).append("\n"); 
		query.append("                     , DENSE_RANK() OVER(ORDER BY A.REV_YRMON||A.JO_CRR_CD||A.RLANE_CD||A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD||A.ESTM_VVD_TP_CD||A.ACCT_CD||A.JO_STL_ITM_CD||A.JO_STL_JB_CD||A.ACCL_AMT_CORR_FLG) AS GRP_NO" ).append("\n"); 
		query.append("                     , MIN(A.ESTM_YRMON) OVER(PARTITION BY A.REV_YRMON||A.JO_CRR_CD||A.RLANE_CD||A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD||A.ESTM_VVD_TP_CD||A.ACCT_CD||A.JO_STL_ITM_CD||A.JO_STL_JB_CD) AS MIN_ESTM_YRMON" ).append("\n"); 
		query.append("                     , MAX(A.ESTM_YRMON) OVER(PARTITION BY A.REV_YRMON||A.JO_CRR_CD||A.RLANE_CD||A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD||A.ESTM_VVD_TP_CD||A.ACCT_CD||A.JO_STL_ITM_CD||A.JO_STL_JB_CD) AS MAX_ESTM_YRMON" ).append("\n"); 
		query.append("                     , CASE WHEN (A.ESTM_AMT <> 0) OR (A.ACT_AMT <> 0) THEN 1" ).append("\n"); 
		query.append("                            ELSE 0" ).append("\n"); 
		query.append("                       END AS CHK_EDIT_CNT" ).append("\n"); 
		query.append("                  FROM JOO_ESTM_ACT_RSLT A" ).append("\n"); 
		query.append("                     , JOO_CARRIER B" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A.EXE_YRMON = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("                   AND A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append("                   AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                   AND B.DELT_FLG  = 'N'" ).append("\n"); 
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
		query.append("                 ORDER BY " ).append("\n"); 
		query.append("                       A.REV_YRMON" ).append("\n"); 
		query.append("                     , A.JO_CRR_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD" ).append("\n"); 
		query.append("                     , B.VNDR_SEQ" ).append("\n"); 
		query.append("					 , A.ACCT_CD" ).append("\n"); 
		query.append("                     , A.JO_STL_JB_CD" ).append("\n"); 
		query.append("                     , A.ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("                     , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     , A.ESTM_YRMON" ).append("\n"); 
		query.append("                     --, A.ESTM_ACT_SEQ " ).append("\n"); 
		query.append("            ) A " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${page_no} != '')" ).append("\n"); 
		query.append("   AND RN >= (TO_NUMBER(@[page_no]) - 1) * TO_NUMBER(@[pagerows]) + 1 AND    RN <= TO_NUMBER(@[page_no]) * TO_NUMBER(@[pagerows])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}