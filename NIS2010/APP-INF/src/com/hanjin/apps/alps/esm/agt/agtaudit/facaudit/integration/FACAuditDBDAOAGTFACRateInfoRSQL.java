/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FACAuditDBDAOAGTFACRateInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACAuditDBDAOAGTFACRateInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_015 실제로 Commission 계산한 FAC Agreement 요율 정보 조회
	  * </pre>
	  */
	public FACAuditDBDAOAGTFACRateInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.integration").append("\n"); 
		query.append("FileName : FACAuditDBDAOAGTFACRateInfoRSQL").append("\n"); 
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
		query.append("A.FRT_FWRD_CNT_CD || TO_CHAR (A.FRT_FWRD_CUST_SEQ, 'FM000000') AS FRT_FWRD_CNT_CD_SEQ," ).append("\n"); 
		query.append("DECODE (A.FRT_FWRD_CUST_SEQ, '999999', 'REP. CUSTOMER'," ).append("\n"); 
		query.append("NVL (REPLACE (REPLACE (REPLACE (B.CUST_LGL_ENG_NM, '&', '&amp;'), CHR (13) || CHR (10), ' '), CHR (9), ' '), ' ')) AS FRT_FWRD_CNT_NM," ).append("\n"); 
		query.append("NVL (DECODE (A.SHPR_CNT_CD || TO_CHAR (A.SHPR_CUST_SEQ, 'FM000000'), '*000000', '*'," ).append("\n"); 
		query.append("A.SHPR_CNT_CD || TO_CHAR (A.SHPR_CUST_SEQ, 'FM000000') ), '*') AS SHPR_CNT_CD_SEQ," ).append("\n"); 
		query.append("NVL (REPLACE (REPLACE (REPLACE (C.CUST_LGL_ENG_NM, '&', '&amp;'), CHR (13) || CHR (10), ' '), CHR (9), ' '), ' ') AS SHPR_CNT_NM," ).append("\n"); 
		query.append("NVL (A.POR_GRP_TP_CD, '*') AS POR_GRP_TP_CD," ).append("\n"); 
		query.append("NVL (A.POR_ROUT_CD, '*') AS POR_ROUT_CD," ).append("\n"); 
		query.append("NVL (A.POL_GRP_TP_CD, '*') AS POL_GRP_TP_CD," ).append("\n"); 
		query.append("NVL (A.POL_ROUT_CD, '*') AS POL_ROUT_CD," ).append("\n"); 
		query.append("NVL (A.POD_GRP_TP_CD, '*') AS POD_GRP_TP_CD," ).append("\n"); 
		query.append("NVL (A.POD_ROUT_CD, '*') AS POD_ROUT_CD," ).append("\n"); 
		query.append("NVL (A.DEL_GRP_TP_CD, '*') AS DEL_GRP_TP_CD," ).append("\n"); 
		query.append("NVL (A.DEL_ROUT_CD, '*')  AS DEL_ROUT_CD," ).append("\n"); 
		query.append("NVL (A.BKG_RCV_TERM_CD, '*') AS BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("NVL (A.BKG_DE_TERM_CD, '*') AS BKG_DE_TERM_CD," ).append("\n"); 
		query.append("A.FAC_SGL_FLG AS FAC_SGL_FLG," ).append("\n"); 
		query.append("A.GRS_NET_DIV_CD AS GRS_NET_DIV_CD," ).append("\n"); 
		query.append("NVL (A.SVC_SCP_CD, '*') AS SVC_SCP_CD," ).append("\n"); 
		query.append("NVL (A.FM_EFF_DT, '20000101') AS FM_EFF_DT," ).append("\n"); 
		query.append("NVL (A.TO_EFF_DT, '29990101') AS TO_EFF_DT," ).append("\n"); 
		query.append("NVL (A.SC_NO, '*') AS SC_NO," ).append("\n"); 
		query.append("NVL (A.RFA_NO, '*') AS RFA_NO," ).append("\n"); 
		query.append("NVL (A.CMDT_TP_CD, '*') AS CMDT_TP_CD," ).append("\n"); 
		query.append("NVL (A.CMDT_CD, '*') AS CMDT_CD," ).append("\n"); 
		query.append("DECODE (A.CMDT_TP_CD, '2', D.REP_CMDT_NM, '3', E.CMDT_NM) AS CMDT_NM," ).append("\n"); 
		query.append("A.FAC_DIV_CD AS FAC_DIV_CD," ).append("\n"); 
		query.append("DECODE (A.FAC_DIV_CD, 'BL', 0, NVL (A.BKG_FAC_RT, 0)) AS BKG_FAC_RT," ).append("\n"); 
		query.append("DECODE (A.FAC_DIV_CD, 'BL', NVL (A.BKG_FAC_RT, 0), 0) AS BKG_FAC_BL_AMT," ).append("\n"); 
		query.append("NVL (A.FAC_BX_RT, 0) AS FAC_BX_RT," ).append("\n"); 
		query.append("NVL (A.FAC_TEU_RT, 0) AS FAC_TEU_RT," ).append("\n"); 
		query.append("NVL (A.FAC_FEU_RT, 0) AS FAC_FEU_RT," ).append("\n"); 
		query.append("NVL (A.FAC_RF_TEU_RT, 0) AS FAC_RF_TEU_RT," ).append("\n"); 
		query.append("NVL (A.FAC_RF_FEU_RT, 0) AS FAC_RF_FEU_RT," ).append("\n"); 
		query.append("NVL (A.FAC_CHG_CTNT, ' ') AS FAC_CHG_CTNT" ).append("\n"); 
		query.append("FROM AGT_FAC_AGMT_RT A, MDM_CUSTOMER B, MDM_CUSTOMER C, MDM_REP_CMDT D, MDM_COMMODITY E" ).append("\n"); 
		query.append("WHERE A.FRT_FWRD_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.FRT_FWRD_CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.SHPR_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.SHPR_CUST_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CMDT_CD = D.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_CD = E.CMDT_CD(+)" ).append("\n"); 
		query.append("AND A.FAC_OFC_CD = @[fac_ofc_cd]" ).append("\n"); 
		query.append("AND A.FRT_FWRD_CNT_CD = @[frt_fwrd_cnt_cd]" ).append("\n"); 
		query.append("AND A.FRT_FWRD_CUST_SEQ = @[frt_fwrd_cust_seq]" ).append("\n"); 
		query.append("AND A.FAC_RT_SEQ = @[fac_rt_seq]" ).append("\n"); 

	}
}