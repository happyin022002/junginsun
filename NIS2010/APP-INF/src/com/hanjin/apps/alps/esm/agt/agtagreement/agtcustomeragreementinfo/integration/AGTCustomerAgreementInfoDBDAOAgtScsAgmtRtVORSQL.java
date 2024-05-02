/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.04.22 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [ESM_AGT_0057]Brokerage Agreement Rate Creation
	  * </pre>
	  */
	public AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_brog_cnt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.integration").append("\n"); 
		query.append("FileName : AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVORSQL").append("\n"); 
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
		query.append("A.AR_OFC_CD," ).append("\n"); 
		query.append("CONCAT(A.CMPN_CNT_CD, TO_CHAR(A.CUST_SEQ, 'FM000000'))                  AS BROG_CNT_CUST_SEQ," ).append("\n"); 
		query.append("CASE TO_CHAR(A.CUST_SEQ, 'FM000000')" ).append("\n"); 
		query.append("WHEN '999999'" ).append("\n"); 
		query.append("THEN 'All customer for General Rate Case'" ).append("\n"); 
		query.append("WHEN '888888'" ).append("\n"); 
		query.append("THEN 'All customer for Special Rate Case'" ).append("\n"); 
		query.append("WHEN '777777'" ).append("\n"); 
		query.append("THEN 'All customer for Canadian Special Rate Case'" ).append("\n"); 
		query.append("ELSE NVL(REPLACE(REPLACE(B.CUST_LGL_ENG_NM,CHR(13)||CHR(10),' '),CHR(9),' '),' ')" ).append("\n"); 
		query.append("END                                                                              AS BROG_CNT_CUST_NM," ).append("\n"); 
		query.append("CASE CONCAT(A.SHPR_CNT_CD, TO_CHAR(A.SHPR_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("WHEN '*000000'" ).append("\n"); 
		query.append("THEN '*'" ).append("\n"); 
		query.append("ELSE NVL(CONCAT(A.SHPR_CNT_CD, TO_CHAR(A.SHPR_SEQ, 'FM000000')), '*')" ).append("\n"); 
		query.append("END                                                                              AS SHPR_CNT_SEQ," ).append("\n"); 
		query.append("NVL(REPLACE(REPLACE(C.CUST_LGL_ENG_NM,CHR(13)||CHR(10),' '),CHR(9),' '),' ') AS SHPR_CNT_NM," ).append("\n"); 
		query.append("NVL(A.POR_GRP_TP_CD, '*')                                                    AS POR_GRP_TP_CD," ).append("\n"); 
		query.append("NVL(A.POR_ROUT_CD,   '*')                                                    AS POR_ROUT_CD," ).append("\n"); 
		query.append("NVL(A.POL_GRP_TP_CD, '*')                                                    AS POL_GRP_TP_CD," ).append("\n"); 
		query.append("NVL(A.POL_ROUT_CD,   '*')                                                    AS POL_ROUT_CD," ).append("\n"); 
		query.append("NVL(A.POD_GRP_TP_CD, '*')                                                    AS POD_GRP_TP_CD," ).append("\n"); 
		query.append("NVL(A.POD_ROUT_CD,   '*')                                                    AS POD_ROUT_CD," ).append("\n"); 
		query.append("NVL(A.FM_EFF_DT, '20000101')                                                 AS FM_EFF_DT," ).append("\n"); 
		query.append("NVL(A.TO_EFF_DT, '29991231')                                                 AS TO_EFF_DT," ).append("\n"); 
		query.append("NVL(A.SC_NO,         '*')                                                    AS SC_NO," ).append("\n"); 
		query.append("NVL(A.RFA_NO,        '*')                                                    AS RFA_NO," ).append("\n"); 
		query.append("NVL(A.CMDT_TP_CD,    '*')                                                    AS CMDT_TP_CD," ).append("\n"); 
		query.append("NVL(A.CMDT_CD,       '*')                                                    AS CMDT_CD," ).append("\n"); 
		query.append("CASE A.CMDT_TP_CD" ).append("\n"); 
		query.append("WHEN '2'" ).append("\n"); 
		query.append("THEN E.REP_CMDT_NM" ).append("\n"); 
		query.append("WHEN '3'" ).append("\n"); 
		query.append("THEN F.CMDT_NM" ).append("\n"); 
		query.append("END                                                                              AS CMDT_NM," ).append("\n"); 
		query.append("NVL(A.CMPN_DIV_CD,   ' ')                                                    AS BROG_DIV_CD," ).append("\n"); 
		query.append("NVL(A.CMPN_TP_CD,    ' ')                                                    AS BROG_TP_CD," ).append("\n"); 
		query.append("NVL(A.CMPN_BKG_RT,     0)                                                    AS BKG_BROG_RT," ).append("\n"); 
		query.append("NVL(A.CMPN_BX_RT,      0)                                                    AS BROG_BX_RT," ).append("\n"); 
		query.append("NVL(A.CMPN_TEU_RT,     0)                                                    AS BROG_TEU_RT," ).append("\n"); 
		query.append("NVL(A.CMPN_FEU_RT,     0)                                                    AS BROG_FEU_RT," ).append("\n"); 
		query.append("NVL(A.CMPN_RF_RT,      0)                                                    AS BROG_RF_RT," ).append("\n"); 
		query.append("NVL(A.CMPN_RF_TEU_RT,  0)                               	       	            AS BROG_RTEU_RT," ).append("\n"); 
		query.append("NVL(A.CMPN_RF_FEU_RT,  0)                                 	                AS BROG_RFEU_RT," ).append("\n"); 
		query.append("NVL(A.CMPN_CHG_CTNT, ' ')                                                    AS BROG_CHG_CTNT," ).append("\n"); 
		query.append("NVL(A.CMPN_KND_CD,   'F')                                                    AS BROG_KND_CD," ).append("\n"); 
		query.append("A.CMPN_RT_SEQ																AS BROG_RT_SEQ" ).append("\n"); 
		query.append("FROM AGT_CMPN_AGMT_RT A," ).append("\n"); 
		query.append("MDM_CUSTOMER     B," ).append("\n"); 
		query.append("MDM_CUSTOMER     C," ).append("\n"); 
		query.append("MDM_REP_CMDT     E," ).append("\n"); 
		query.append("MDM_COMMODITY    F" ).append("\n"); 
		query.append("WHERE A.CMPN_CNT_CD    = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ  = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.SHPR_CNT_CD    = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.SHPR_SEQ       = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CMDT_CD        = E.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("AND A.CMDT_CD        = F.CMDT_CD(+)" ).append("\n"); 
		query.append("AND A.AR_OFC_CD		= @[ofc_cd]" ).append("\n"); 
		query.append("#if(${search_brog_cnt_cust_seq} != '')" ).append("\n"); 
		query.append("AND CONCAT(A.CMPN_CNT_CD, TO_CHAR(A.CUST_SEQ, 'FM000000')) LIKE @[search_brog_cnt_cust_seq]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14" ).append("\n"); 

	}
}