/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BRKGAuditDBDAOSearchBRKGCommforAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.02
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.07.02 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOSearchBRKGCommforAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBRKGCommforAudit
	  * </pre>
	  */
	public BRKGAuditDBDAOSearchBRKGCommforAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOSearchBRKGCommforAuditRSQL").append("\n"); 
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
		query.append("A.BROG_SEQ," ).append("\n"); 
		query.append("CASE A.FRT_FWRD_CNT_CD" ).append("\n"); 
		query.append("WHEN ''" ).append("\n"); 
		query.append("THEN ''" ).append("\n"); 
		query.append("ELSE CONCAT(A.FRT_FWRD_CNT_CD, TO_CHAR (A.FRT_FWRD_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("END                                                           AS FRT_FWRD_CNT_SEQ," ).append("\n"); 
		query.append("TO_CHAR (A.VNDR_SEQ, 'FM000000')                          AS VNDR_CNT_SEQ," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("MAX (NVL (LTRIM (C.CUST_LGL_ENG_NM), ' '))" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER          C" ).append("\n"); 
		query.append("WHERE C.CUST_CNT_CD(+)      = A.FRT_FWRD_CNT_CD" ).append("\n"); 
		query.append("AND C.CUST_SEQ(+)         = A.FRT_FWRD_SEQ" ).append("\n"); 
		query.append("AND C.CNTR_DIV_FLG(+)     = 'Y'" ).append("\n"); 
		query.append(")                                                           AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("MAX (NVL (B.BL_NO, ' '))" ).append("\n"); 
		query.append("FROM AGT_COMM_BKG_INFO     B" ).append("\n"); 
		query.append("WHERE B.BKG_NO              = A.BKG_NO" ).append("\n"); 
		query.append(")                                                           AS BL_NO," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("MAX (NVL (B.BKG_STS_CD, ' '))" ).append("\n"); 
		query.append("FROM BKG_BOOKING     B" ).append("\n"); 
		query.append("WHERE B.BKG_NO              = A.BKG_NO" ).append("\n"); 
		query.append(")                                                           AS BKG_STS_CD," ).append("\n"); 
		query.append("TO_CHAR (A.VSL_DEP_DT, 'YYYYMMDD')                        AS VSL_DEP_DT," ).append("\n"); 
		query.append("TO_CHAR (A.CRE_DT, 'YYYYMMDD')                            AS CRE_DT," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("MAX (NVL (B.FMC_NO, ' '))" ).append("\n"); 
		query.append("FROM AGT_COMM_BKG_INFO     B" ).append("\n"); 
		query.append("WHERE B.BKG_NO              = A.BKG_NO" ).append("\n"); 
		query.append(")                                                           AS FMC_NO," ).append("\n"); 
		query.append("NVL (A.BROG_REF_NO, ' ')                                  AS BROG_REF_NO," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR (A.BROG_DIV_CD, 1, 1) = 'B'" ).append("\n"); 
		query.append("AND NVL (A.BROG_BKG_RT, 0) != 0" ).append("\n"); 
		query.append("THEN (A.ACT_COMM_AMT / A.BROG_BKG_RT) * 100" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END                                                           AS ACT_COMM_ABLE," ).append("\n"); 
		query.append("NVL (BROG_BKG_RT, 0)                                      AS BROG_BKG_RT," ).append("\n"); 
		query.append("CASE SUBSTR (A.BROG_DIV_CD, 1, 1)" ).append("\n"); 
		query.append("WHEN 'B'" ).append("\n"); 
		query.append("THEN A.ACT_COMM_AMT" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END                                                           AS ACT_COMM_AMT," ).append("\n"); 
		query.append("NVL (A.BKG_BX_QTY,  0)                                    AS BKG_BX_QTY," ).append("\n"); 
		query.append("NVL (A.BROG_BX_RT,  0)                                    AS BROG_BX_RT," ).append("\n"); 
		query.append("NVL (A.BKG_TEU_QTY, 0)                                    AS BKG_TEU_QTY," ).append("\n"); 
		query.append("NVL (A.BROG_TEU_RT, 0)                                    AS BROG_TEU_RT," ).append("\n"); 
		query.append("NVL (A.BKG_FEU_QTY, 0)                                    AS BKG_FEU_QTY," ).append("\n"); 
		query.append("NVL (A.BROG_FEU_RT, 0)                                    AS BROG_FEU_RT," ).append("\n"); 
		query.append("NVL (A.BKG_RF_QTY,  0)                                    AS BKG_RF_QTY," ).append("\n"); 
		query.append("NVL (A.BROG_RF_RT,  0)                                    AS BROG_RF_RT," ).append("\n"); 
		query.append("CASE SUBSTR (A.BROG_DIV_CD, 1, 1)" ).append("\n"); 
		query.append("WHEN 'C'" ).append("\n"); 
		query.append("THEN A.ACT_COMM_AMT" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END                                                           AS CNTR_COMM_AMT," ).append("\n"); 
		query.append("NVL (A.ACT_PRE_COMM_AMT, 0)                               AS ACT_PRE_COMM_AMT," ).append("\n"); 
		query.append("NVL (A.ACT_IF_COMM_AMT, 0)                                AS ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("NVL (A.COMM_PROC_STS_CD, ' ')                             AS COMM_PROC_STS_CD," ).append("\n"); 
		query.append("A.COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("NVL (TO_CHAR (BROG_IF_DT, 'YYYYMMDD'), ' ')               AS BROG_IF_DT," ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("AGMT_CNT_CD," ).append("\n"); 
		query.append("AGMT_CUST_SEQ," ).append("\n"); 
		query.append("AGMT_RT_SEQ" ).append("\n"); 
		query.append("FROM AGT_BROG_COMM         A," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("MIN (A.BROG_SEQ)     AS BROG_SEQ" ).append("\n"); 
		query.append("FROM AGT_BROG_COMM         A" ).append("\n"); 
		query.append("WHERE A.CRE_USR_ID         != 'COST'" ).append("\n"); 
		query.append("#if(${sts_cd} == 'I')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD    = 'IF'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sts_cd} == 'N')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD   <> 'IF'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${date_option} == 'I')" ).append("\n"); 
		query.append("AND A.BROG_IF_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE (NVL(REPLACE(@[search_dt_fr],'-',''), '19000101'), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE (NVL(REPLACE(@[search_dt_to],'-',''), '29990101'), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${date_option} == 'E')" ).append("\n"); 
		query.append("AND A.VSL_DEP_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE (NVL(REPLACE(@[search_dt_fr],'-',''), '19000101'), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE (NVL(REPLACE(@[search_dt_to],'-',''), '29990101'), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ff_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.FRT_FWRD_CNT_CD     = SUBSTR(@[ff_cnt_cd], 1, 2)" ).append("\n"); 
		query.append("AND A.FRT_FWRD_SEQ        = SUBSTR(@[ff_cnt_cd], 3)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vvd} != '')" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("( A.COMM_VSL_CD" ).append("\n"); 
		query.append("|| A.COMM_SKD_VOY_NO" ).append("\n"); 
		query.append("|| A.COMM_SKD_DIR_CD" ).append("\n"); 
		query.append("|| A.COMM_REV_DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("( NVL (SUBSTR (@[vvd],  1, 4), A.COMM_VSL_CD)" ).append("\n"); 
		query.append("|| NVL (SUBSTR (@[vvd],  5, 4), A.COMM_SKD_VOY_NO)" ).append("\n"); 
		query.append("|| NVL (SUBSTR (@[vvd],  9, 1), A.COMM_SKD_DIR_CD)" ).append("\n"); 
		query.append("|| NVL (SUBSTR (@[vvd], 10, 1), A.COMM_REV_DIR_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${bl_nos} != '' || ${date_option} == 'C')" ).append("\n"); 
		query.append("AND A.BKG_NO" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append("FROM AGT_COMM_BKG_INFO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if( ${bl_nos} != '')" ).append("\n"); 
		query.append("AND BL_NO" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( $bl_nos" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${date_option} == 'C')" ).append("\n"); 
		query.append("AND BKG_CRE_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE (NVL(REPLACE(@[search_dt_fr],'-',''), '19000101'), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE (NVL(REPLACE(@[search_dt_to],'-',''), '29990101'), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO" ).append("\n"); 
		query.append(")                       B" ).append("\n"); 
		query.append("WHERE A.BKG_NO              = B.BKG_NO" ).append("\n"); 
		query.append("AND A.BROG_SEQ            = B.BROG_SEQ" ).append("\n"); 
		query.append("ORDER BY CONCAT (A.FRT_FWRD_CNT_CD, A.FRT_FWRD_SEQ)," ).append("\n"); 
		query.append("CONCAT (A.VNDR_CNT_CD, A.VNDR_SEQ)," ).append("\n"); 
		query.append("CUST_LGL_ENG_NM" ).append("\n"); 

	}
}