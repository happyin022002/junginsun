/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FACAuditDBDAOSearchFACCommListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.02
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.07.02 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.facaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACAuditDBDAOSearchFACCommListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFACCommList
	  * </pre>
	  */
	public FACAuditDBDAOSearchFACCommListRSQL(){
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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.facaudit.integration").append("\n"); 
		query.append("FileName : FACAuditDBDAOSearchFACCommListRSQL").append("\n"); 
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
		query.append("A.FAC_SEQ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.FRT_FWRD_CNT_CD = ''" ).append("\n"); 
		query.append("OR A.FRT_FWRD_CNT_CD = '*'" ).append("\n"); 
		query.append("THEN ''" ).append("\n"); 
		query.append("ELSE CONCAT(A.FRT_FWRD_CNT_CD, TO_CHAR (A.FRT_FWRD_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("END                                                           AS FRT_FWRD_CNT_SEQ," ).append("\n"); 
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
		query.append("A.BKG_NO                                                  AS BKG_NO," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("MAX (NVL (B.BKG_STS_CD, ' '))" ).append("\n"); 
		query.append("FROM BKG_BOOKING     B" ).append("\n"); 
		query.append("WHERE B.BKG_NO              = A.BKG_NO" ).append("\n"); 
		query.append(")                                                           AS BKG_STS_CD," ).append("\n"); 
		query.append("TO_CHAR (A.VSL_DEP_DT, 'YYYYMMDD')                        AS VSL_DEP_DT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR (A.FAC_DIV_CD, 1, 1) = 'B'" ).append("\n"); 
		query.append("AND A.FAC_DIV_CD = 'BL'" ).append("\n"); 
		query.append("THEN A.ACT_COMM_AMT" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END                                                           AS BL_COMM_AMT," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR (A.FAC_DIV_CD, 1, 1) = 'B'" ).append("\n"); 
		query.append("AND A.FAC_DIV_CD <> 'BL'" ).append("\n"); 
		query.append("THEN A.ACT_COMM_AMT" ).append("\n"); 
		query.append("WHEN A.FAC_DIV_CD = 'DR'" ).append("\n"); 
		query.append("THEN A.ACT_COMM_AMT" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END                                                           AS ACT_COMM_AMT," ).append("\n"); 
		query.append("NVL (A.BKG_BX_QTY, 0)                                     AS BKG_BX_QTY," ).append("\n"); 
		query.append("NVL (A.FAC_BX_RT, 0)                                      AS FAC_BX_RT," ).append("\n"); 
		query.append("NVL (A.BKG_TEU_QTY, 0)                                    AS BKG_TEU_QTY," ).append("\n"); 
		query.append("NVL (A.FAC_TEU_RT, 0)                                     AS FAC_TEU_RT," ).append("\n"); 
		query.append("NVL (A.BKG_FEU_QTY, 0)                                    AS BKG_FEU_QTY," ).append("\n"); 
		query.append("NVL (A.FAC_FEU_RT, 0)                                     AS FAC_FEU_RT," ).append("\n"); 
		query.append("NVL (A.BKG_RF_TEU_QTY, 0)                                 AS BKG_RF_TEU_QTY," ).append("\n"); 
		query.append("NVL (A.FAC_RF_TEU_RT, 0)                                  AS FAC_RF_TEU_RT," ).append("\n"); 
		query.append("NVL (A.BKG_RF_FEU_QTY, 0)                                 AS BKG_RF_FEU_QTY," ).append("\n"); 
		query.append("NVL (A.FAC_RF_FEU_RT, 0)                                  AS FAC_RF_FEU_RT," ).append("\n"); 
		query.append("NVL (A.BKG_SPCL_TEU_QTY, 0)                               AS BKG_SPCL_TEU_QTY," ).append("\n"); 
		query.append("NVL (A.FAC_SPCL_TEU_RT, 0)                                AS FAC_SPCL_TEU_RT," ).append("\n"); 
		query.append("NVL (A.BKG_SPCL_FEU_QTY, 0)                               AS BKG_SPCL_FEU_QTY," ).append("\n"); 
		query.append("NVL (A.FAC_SPCL_FEU_RT, 0)                                AS FAC_SPCL_FEU_RT," ).append("\n"); 
		query.append("CASE SUBSTR (A.FAC_DIV_CD, 1, 1)" ).append("\n"); 
		query.append("WHEN 'C'" ).append("\n"); 
		query.append("THEN A.ACT_COMM_AMT" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END                                                           AS CNTR_COMM_AMT," ).append("\n"); 
		query.append("NVL (A.ACT_PRE_COMM_AMT, 0)                               AS ACT_PRE_COMM_AMT," ).append("\n"); 
		query.append("NVL (A.ACT_IF_COMM_AMT, 0)                                AS ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("A.FAC_RMK," ).append("\n"); 
		query.append("NVL (A.COMM_PROC_STS_CD, ' ')                             AS COMM_PROC_STS_CD," ).append("\n"); 
		query.append("A.COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("NVL (TO_CHAR (A.FAC_IF_DT, 'YYYYMMDD'), ' ')              AS FAC_IF_DT," ).append("\n"); 
		query.append("A.SLS_OFC_CD," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("D.BKG_STS_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING D" ).append("\n"); 
		query.append("WHERE A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append(")                                                           AS BKG_STS_CD," ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("FAC_OFC_CD," ).append("\n"); 
		query.append("AGMT_CNT_CD," ).append("\n"); 
		query.append("AGMT_CUST_SEQ," ).append("\n"); 
		query.append("AGMT_RT_SEQ," ).append("\n"); 
		query.append("A.FAC_DIV_CD," ).append("\n"); 
		query.append("SUBSTR (A.FAC_DIV_CD, 1, 1)                              AS FAC_DIV_CD_1," ).append("\n"); 
		query.append("A.ACT_COMM_AMT                                           AS OLD_ACT_COMM_AMT," ).append("\n"); 
		query.append("A.FAC_IF_USR_ID," ).append("\n"); 
		query.append("TO_CHAR (A.FAC_IF_DT, 'yyyyMMddHH24miss')                AS FAC_IF_DT_1" ).append("\n"); 
		query.append("FROM AGT_FAC_COMM         A," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("MIN (A.FAC_SEQ)     AS FAC_SEQ" ).append("\n"); 
		query.append("FROM AGT_FAC_COMM         A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${date_option} == 'E')" ).append("\n"); 
		query.append("AND A.VSL_DEP_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE (NVL(REPLACE(@[search_dt_fr],'-',''), '19000101'), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE (NVL(REPLACE(@[search_dt_to],'-',''), '29990101'), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ofc_option} == 'S')" ).append("\n"); 
		query.append("AND A.SLS_OFC_CD = @[agn_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.AR_OFC_CD  = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ff_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.FRT_FWRD_CNT_CD     = SUBSTR(@[ff_cnt_cd], 1, 2)" ).append("\n"); 
		query.append("AND A.FRT_FWRD_SEQ        = SUBSTR(@[ff_cnt_cd], 3)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_curr_cd} != '')" ).append("\n"); 
		query.append("AND A.CURR_CD             = @[s_curr_cd]" ).append("\n"); 
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
		query.append("|| NVL (SUBSTR (@[vvd], 10, 1), A.COMM_REV_DIr_cd)" ).append("\n"); 
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
		query.append("( ${bl_nos}" ).append("\n"); 
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
		query.append("AND A.FAC_SEQ             = B.FAC_SEQ" ).append("\n"); 
		query.append("ORDER BY CONCAT (A.FRT_FWRD_CNT_CD, A.FRT_FWRD_SEQ)," ).append("\n"); 
		query.append("CUST_LGL_ENG_NM" ).append("\n"); 

	}
}