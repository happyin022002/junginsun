/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOGlEstmIfErpAllCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.18 
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

public class JointOperationAccrualCreationDBDAOGlEstmIfErpAllCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [2015.03.18]exeYrmon All Delete and All Insert 
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOGlEstmIfErpAllCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOGlEstmIfErpAllCSQL").append("\n"); 
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
		query.append("INSERT INTO GL_ESTM_IF_ERP (" ).append("\n"); 
		query.append("	  EXE_YRMON" ).append("\n"); 
		query.append("    , SYS_SRC_ID" ).append("\n"); 
		query.append("    , REV_YRMON" ).append("\n"); 
		query.append("    , ACCT_CD" ).append("\n"); 
		query.append("    , ESTM_SEQ_NO" ).append("\n"); 
		query.append("    , AGMT_NO" ).append("\n"); 
		query.append("    , WO_NO" ).append("\n"); 
		query.append("    , BIZ_UT_ID" ).append("\n"); 
		query.append("    , LOC_CD" ).append("\n"); 
		query.append("    , VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , REV_DIR_CD" ).append("\n"); 
		query.append("    , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    , CNTR_QTY" ).append("\n"); 
		query.append("    , BSA_SLT_QTY" ).append("\n"); 
		query.append("    , CRR_CD" ).append("\n"); 
		query.append("    , SLT_COST_AMT" ).append("\n"); 
		query.append("    , CUST_CNT_CD" ).append("\n"); 
		query.append("    , CUST_SEQ" ).append("\n"); 
		query.append("    , VVD_DUR_NO" ).append("\n"); 
		query.append("    , HIR_DT_AMT" ).append("\n"); 
		query.append("    , ESTM_AMT" ).append("\n"); 
		query.append("    , ACT_AMT" ).append("\n"); 
		query.append("    , ACCL_AMT" ).append("\n"); 
		query.append("    , ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("    , ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("    , ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("    , ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("    , OP_LSE_DIV_FLG" ).append("\n"); 
		query.append("    , TTL_TRF_AMT" ).append("\n"); 
		query.append("    , VNDR_INV_NO" ).append("\n"); 
		query.append("    , LOCL_CURR_CD" ).append("\n"); 
		query.append("    , ACT_DT" ).append("\n"); 
		query.append("    , ACT_PLC_CD" ).append("\n"); 
		query.append("    , SLAN_CD" ).append("\n"); 
		query.append("    , ACCT_DTL_CD" ).append("\n"); 
		query.append("    , COST_ACT_PLC_CD" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.EXE_YRMON          /* PK - EXE_YRMON */" ).append("\n"); 
		query.append("     , A.SYS_SRC_ID         /* PK - SYS_SRC_ID */" ).append("\n"); 
		query.append("     , A.REV_YRMON          /* PK - REV_YRMON */" ).append("\n"); 
		query.append("     , A.ACCT_CD            /* PK - ACCT_CD */" ).append("\n"); 
		query.append("     , (A.ESTM_SEQ_NO + ROWNUM) /* PK - ESTM_SEQ_NO */" ).append("\n"); 
		query.append("     , A.JO_STL_JB_CD       /* AGMT_NO */" ).append("\n"); 
		query.append("     , A.RLANE_CD           /* WO_NO */" ).append("\n"); 
		query.append("     , A.JO_CNTR_DIV_CTNT   /* BIZ_UT_ID */" ).append("\n"); 
		query.append("     , A.LOC_CD             /* LOC_CD */" ).append("\n"); 
		query.append("     , A.VSL_CD             /*VSL_CD */" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO         /*SKD_VOY_NO */" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD         /*SKD_DIR_CD */" ).append("\n"); 
		query.append("     , A.REV_DIR_CD         /*REV_DIR_CD */" ).append("\n"); 
		query.append("     , NULL                 /*CNTR_TPSZ_CD */" ).append("\n"); 
		query.append("     , 0                    /*CNTR_QTY */" ).append("\n"); 
		query.append("     , A.BSA_QTY            /*BSA_SLT_QTY */" ).append("\n"); 
		query.append("     , A.JO_CRR_CD          /*CRR_CD */" ).append("\n"); 
		query.append("     , A.BSA_SLT_PRC        /*SLT_COST_AMT */" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD        /*CUST_CNT_CD */" ).append("\n"); 
		query.append("     , A.CUST_SEQ           /*CUST_SEQ */" ).append("\n"); 
		query.append("     , NULL                 /*VVD_DUR_NO */" ).append("\n"); 
		query.append("     , 0                    /*HIR_DT_AMT */" ).append("\n"); 
		query.append("     , A.ESTM_AMT           /*ESTM_AMT */" ).append("\n"); 
		query.append("     , A.ACT_AMT            /*ACT_AMT */" ).append("\n"); 
		query.append("     , A.ACCL_AMT           /*ACCL_AMT */" ).append("\n"); 
		query.append("     , A.ESTM_VVD_TP_CD     /*ESTM_VVD_TP_CD */" ).append("\n"); 
		query.append("     , A.JO_IOC_DIV_CD      /*ESTM_IOC_DIV_CD */" ).append("\n"); 
		query.append("     , A.ESTM_VVD_HDR_ID    /*ESTM_VVD_HDR_ID */" ).append("\n"); 
		query.append("     , A.CNTR_BLK_DIV_CD    /*ESTM_BC_DIV_CD */" ).append("\n"); 
		query.append("     , 'N'                  /*OP_LSE_DIV_FLG */" ).append("\n"); 
		query.append("     , 0                    /*TTL_TRF_AMT */" ).append("\n"); 
		query.append("     , NULL                 /*VNDR_INV_NO */" ).append("\n"); 
		query.append("     , 'USD'                /*LOCL_CURR_CD */" ).append("\n"); 
		query.append("     , A.ACT_DT             /*ACT_DT */" ).append("\n"); 
		query.append("     , NULL                 /*ACT_PLC_CD 첫번째 포트*/" ).append("\n"); 
		query.append("     , SUBSTR(A.RLANE_CD, 1,3) /*SLAN_CD */" ).append("\n"); 
		query.append("     , NULL                 /*ACCT_DTL_CD */" ).append("\n"); 
		query.append("     , NULL                 /*COST_ACT_PLC_CD */" ).append("\n"); 
		query.append("     , @[usr_id]            /*CRE_USR_ID */" ).append("\n"); 
		query.append("     , SYSDATE              /*CRE_DT */" ).append("\n"); 
		query.append("     , @[usr_id]            /*UPD_USR_ID  */" ).append("\n"); 
		query.append("     , SYSDATE              /*UPD_DT  */" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT /*+INDEX(A XPKJOO_ESTM_ACT_RSLT)*/" ).append("\n"); 
		query.append("               NVL((SELECT /*+INDEX_DESC(G XPKGL_ESTM_IF_ERP)*/" ).append("\n"); 
		query.append("                          NVL(MAX(G.ESTM_SEQ_NO),0)" ).append("\n"); 
		query.append("                          FROM GL_ESTM_IF_ERP G" ).append("\n"); 
		query.append("                         WHERE G.EXE_YRMON = REPLACE(A.EXE_YRMON,'-','')" ).append("\n"); 
		query.append("                           AND G.SYS_SRC_ID = A.SYS_SRC_ID" ).append("\n"); 
		query.append("                           AND G.REV_YRMON = REPLACE(A.REV_YRMON,'-','')" ).append("\n"); 
		query.append("                           AND G.ACCT_CD = A.ACCT_CD" ).append("\n"); 
		query.append("                           AND ROWNUM =1),1) AS ESTM_SEQ_NO" ).append("\n"); 
		query.append("             , A.EXE_YRMON" ).append("\n"); 
		query.append("             , A.REV_YRMON" ).append("\n"); 
		query.append("             , A.JO_CRR_CD" ).append("\n"); 
		query.append("             , A.CUST_CNT_CD" ).append("\n"); 
		query.append("             , A.CUST_SEQ" ).append("\n"); 
		query.append("             , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD" ).append("\n"); 
		query.append("             , A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A.REV_DIR_CD" ).append("\n"); 
		query.append("             , A.RLANE_CD" ).append("\n"); 
		query.append("             , A.JO_STL_JB_CD" ).append("\n"); 
		query.append("             , (SELECT C.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                  FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("                 WHERE C.INTG_CD_ID = 'CD01866'" ).append("\n"); 
		query.append("                   AND C.INTG_CD_VAL_CTNT = A.JO_STL_JB_CD" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) AS JO_STL_JB_NM" ).append("\n"); 
		query.append("             , A.BSA_QTY" ).append("\n"); 
		query.append("             , A.BSA_SLT_PRC" ).append("\n"); 
		query.append("             , A.ACCT_CD" ).append("\n"); 
		query.append("             , A.ESTM_ACT_SEQ" ).append("\n"); 
		query.append("             , A.ESTM_AMT" ).append("\n"); 
		query.append("             , A.ACT_AMT" ).append("\n"); 
		query.append("             , A.ACCL_AMT" ).append("\n"); 
		query.append("             , A.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("             , A.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("             , A.JO_IOC_DIV_CD" ).append("\n"); 
		query.append("             , A.SYS_SRC_ID" ).append("\n"); 
		query.append("             , A.JO_CNTR_DIV_CTNT" ).append("\n"); 
		query.append("             , A.LOC_CD" ).append("\n"); 
		query.append("             , A.ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("             , A.CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append("             , A.ACT_DT" ).append("\n"); 
		query.append("             , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , A.TRD_CD" ).append("\n"); 
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
		query.append("                     , A.ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("                     , MAX(A.ESTM_VVD_TP_CD) AS ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("                     , MAX(A.ESTM_ACT_SEQ) AS ESTM_ACT_SEQ" ).append("\n"); 
		query.append("                     , A.JO_STL_JB_CD AS JO_STL_JB_CD" ).append("\n"); 
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
		query.append("                     , MAX(A.JO_STL_ITM_CD) AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     , MAX(B.TRD_CD) AS TRD_CD" ).append("\n"); 
		query.append("                     , CASE WHEN A.ACCT_CD LIKE '4%' THEN B.CUST_CNT_CD" ).append("\n"); 
		query.append("                            WHEN A.ACCT_CD LIKE '5%' THEN ''" ).append("\n"); 
		query.append("                       END AS CUST_CNT_CD" ).append("\n"); 
		query.append("                     , CASE WHEN A.ACCT_CD LIKE '4%' THEN B.CUST_SEQ" ).append("\n"); 
		query.append("                            WHEN A.ACCT_CD LIKE '5%' THEN B.VNDR_SEQ" ).append("\n"); 
		query.append("                       END AS CUST_SEQ" ).append("\n"); 
		query.append("                     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD" ).append("\n"); 
		query.append("                  FROM JOO_ESTM_ACT_RSLT A" ).append("\n"); 
		query.append("                     , JOO_CARRIER B" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A.EXE_YRMON = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("                   AND A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append("                   AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
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
		query.append("                     , A.ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("                 ORDER BY A.ACCT_CD" ).append("\n"); 
		query.append("                     , A.REV_YRMON" ).append("\n"); 
		query.append("                     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD " ).append("\n"); 
		query.append("                ) A " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 

	}
}