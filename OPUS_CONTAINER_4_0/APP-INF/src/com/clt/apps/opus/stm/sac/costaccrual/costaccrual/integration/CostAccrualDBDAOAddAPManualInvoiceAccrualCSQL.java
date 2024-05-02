/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostAccrualDBDAOAddAPManualInvoiceAccrualCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sac.costaccrual.costaccrual.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAccrualDBDAOAddAPManualInvoiceAccrualCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice별 Accrual로 I/F 처리
	  * </pre>
	  */
	public CostAccrualDBDAOAddAPManualInvoiceAccrualCSQL(){
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
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sac.costaccrual.costaccrual.integration").append("\n"); 
		query.append("FileName : CostAccrualDBDAOAddAPManualInvoiceAccrualCSQL").append("\n"); 
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
		query.append("INSERT INTO GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("        ( EXE_YRMON" ).append("\n"); 
		query.append("        , SYS_SRC_ID" ).append("\n"); 
		query.append("        , REV_YRMON" ).append("\n"); 
		query.append("        , ACCT_CD" ).append("\n"); 
		query.append("        , ESTM_SEQ_NO" ).append("\n"); 
		query.append("        , AGMT_NO" ).append("\n"); 
		query.append("        , WO_NO" ).append("\n"); 
		query.append("        , BIZ_UT_ID" ).append("\n"); 
		query.append("        , LOC_CD" ).append("\n"); 
		query.append("        , VSL_CD" ).append("\n"); 
		query.append("        , SKD_VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD" ).append("\n"); 
		query.append("        , REV_DIR_CD" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , CNTR_QTY" ).append("\n"); 
		query.append("        , BSA_SLT_QTY" ).append("\n"); 
		query.append("        , CRR_CD" ).append("\n"); 
		query.append("        , SLT_COST_AMT" ).append("\n"); 
		query.append("        , CUST_CNT_CD" ).append("\n"); 
		query.append("        , CUST_SEQ" ).append("\n"); 
		query.append("        , VVD_DUR_NO" ).append("\n"); 
		query.append("        , HIR_DT_AMT" ).append("\n"); 
		query.append("        , ESTM_AMT" ).append("\n"); 
		query.append("        , ACT_AMT" ).append("\n"); 
		query.append("        , ACCL_AMT" ).append("\n"); 
		query.append("        , ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("        , ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("        , ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("        , ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("        , OP_LSE_DIV_FLG" ).append("\n"); 
		query.append("        , TTL_TRF_AMT" ).append("\n"); 
		query.append("        , VNDR_INV_NO" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , LOCL_CURR_CD" ).append("\n"); 
		query.append("        , ACT_DT" ).append("\n"); 
		query.append("        , COST_ACT_PLC_CD" ).append("\n"); 
		query.append("        , SLAN_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("SELECT  TO_CHAR(SID.ACCTG_DT, 'YYYYMM')          AS EXE_YRMON" ).append("\n"); 
		query.append("      , 'SAP'                                    AS SYS_SRC_ID" ).append("\n"); 
		query.append("      , NVL((SELECT AMRV.REV_YRMON FROM AR_MST_REV_VVD AMRV " ).append("\n"); 
		query.append("             WHERE  AMRV.VSL_CD = SUBSTR(SLCC.SGM_CTNT6, 1, 4) AND AMRV.SKD_VOY_NO = SUBSTR(SLCC.SGM_CTNT6, 5, 4)" ).append("\n"); 
		query.append("             AND    AMRV.SKD_DIR_CD = SUBSTR(SLCC.SGM_CTNT6, 9, 1) AND AMRV.RLANE_DIR_CD = SUBSTR(SLCC.SGM_CTNT6, 10, 1) AND ROWNUM = 1), TO_CHAR(SID.ACCTG_DT, 'YYYYMM'))" ).append("\n"); 
		query.append("                                                 AS REV_YRMON" ).append("\n"); 
		query.append("      , SLCC.SGM_CTNT4                           AS ACCT_CD" ).append("\n"); 
		query.append("      , ROWNUM + @[estm_seq_no]                  AS ESTM_SEQ_NO" ).append("\n"); 
		query.append("      , NULL                                     AS AGMT_NO" ).append("\n"); 
		query.append("      , SIH.INV_NO                               AS WO_NO" ).append("\n"); 
		query.append("      , NULL                                     AS BIZ_UT_ID" ).append("\n"); 
		query.append("      , SID.ATTR_CTNT3                           AS LOC_CD" ).append("\n"); 
		query.append("      , SUBSTR(SLCC.SGM_CTNT6, 1, 4)             AS VSL_CD" ).append("\n"); 
		query.append("      , SUBSTR(SLCC.SGM_CTNT6, 5, 4)             AS SKD_VOY_NO" ).append("\n"); 
		query.append("      , SUBSTR(SLCC.SGM_CTNT6, 9, 1)             AS SKD_DIR_CD" ).append("\n"); 
		query.append("      , SUBSTR(SLCC.SGM_CTNT6, 10, 1)            AS REV_DIR_CD" ).append("\n"); 
		query.append("      , NULL                                     AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , NULL                                     AS CNTR_QTY" ).append("\n"); 
		query.append("      , NULL                                     AS BSA_SLT_QTY" ).append("\n"); 
		query.append("      , NULL                                     AS CRR_CD" ).append("\n"); 
		query.append("      , NULL                                     AS SLT_COST_AMT" ).append("\n"); 
		query.append("      , MV.VNDR_CNT_CD                           AS CUST_CNT_CD" ).append("\n"); 
		query.append("      , MV.VNDR_SEQ                              AS CUST_SEQ" ).append("\n"); 
		query.append("      , NULL                                     AS VVD_DUR_NO" ).append("\n"); 
		query.append("      , NULL                                     AS HIR_DT_AMT" ).append("\n"); 
		query.append("      , SID.DTRB_AMT                             AS ESTM_AMT" ).append("\n"); 
		query.append("      , 0                                        AS ACT_AMT" ).append("\n"); 
		query.append("      , SID.DTRB_AMT                             AS ACCL_AMT" ).append("\n"); 
		query.append("      , NULL                                     AS ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("      , NULL                                     AS ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("      , NULL                                     AS ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("      , NULL                                     AS ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("      , NULL                                     AS OP_LSE_DIV_FLG" ).append("\n"); 
		query.append("      , SID.DTRB_AMT                             AS TTL_TRF_AMT" ).append("\n"); 
		query.append("      , SUBSTR(SID.ATTR_CTNT1, 1, 20)            AS VNDR_INV_NO" ).append("\n"); 
		query.append("      , @[usr_id]                  AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE                                  AS CRE_DT" ).append("\n"); 
		query.append("      , @[usr_id]                  AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE                                  AS UPD_DT" ).append("\n"); 
		query.append("      , SIH.INV_CURR_CD                          AS CURR_CD" ).append("\n"); 
		query.append("      , TO_CHAR(SIH.INV_DT, 'YYYYMMDD')          AS ACTIVITY_DATE" ).append("\n"); 
		query.append("      , SIH.OFC_CD                               AS ACTIVITY_PLACE" ).append("\n"); 
		query.append("      , SUBSTR(NVL(SID.ATTR_CTNT14, 'COM'), 1, 3) AS SERVICE_LANE" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , SAP_INV_DTL SID" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE   SIH.INV_SEQ = SID.INV_SEQ " ).append("\n"); 
		query.append("AND     SID.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ " ).append("\n"); 
		query.append("AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append("AND     SIH.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("ORDER   BY SID.DTRB_LINE_NO" ).append("\n"); 

	}
}