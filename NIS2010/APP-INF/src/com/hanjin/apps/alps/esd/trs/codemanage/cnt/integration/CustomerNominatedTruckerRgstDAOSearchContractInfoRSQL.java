/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomerNominatedTruckerRgstDAOSearchContractInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.05
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.08.05 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerNominatedTruckerRgstDAOSearchContractInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchContractInfo
	  * </pre>
	  */
	public CustomerNominatedTruckerRgstDAOSearchContractInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration").append("\n"); 
		query.append("FileName : CustomerNominatedTruckerRgstDAOSearchContractInfoRSQL").append("\n"); 
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
		query.append("#if (${prc_ctrt_tp_cd} != 'R')" ).append("\n"); 
		query.append("-- S/C 조회" ).append("\n"); 
		query.append("SELECT A3.CTRT_CUST_SLS_OFC_CD AS SLS_OFC_CD" ).append("\n"); 
		query.append("      ,A3.CTRT_CUST_SREP_CD" ).append("\n"); 
		query.append("      ,(SELECT SREP_NM" ).append("\n"); 
		query.append("          FROM MDM_SLS_REP" ).append("\n"); 
		query.append("         WHERE SREP_CD = A3.CTRT_CUST_SREP_CD) CTRT_CUST_SREP_NM" ).append("\n"); 
		query.append("      ,A3.CUST_CNT_CD|| LPAD(A3.CUST_SEQ, 6, 0) CTRT_CUST_CD" ).append("\n"); 
		query.append("      ,(SELECT X.CUST_LGL_ENG_NM FROM MDM_CUSTOMER X WHERE X.CUST_CNT_CD = A3.CUST_CNT_CD AND X.CUST_SEQ = A3.CUST_SEQ) CTRT_CUST_NM" ).append("\n"); 
		query.append("      ,A4.CTRT_EFF_DT" ).append("\n"); 
		query.append("      ,A4.CTRT_EXP_DT" ).append("\n"); 
		query.append("      ,CASE WHEN A5.FNL_MQC_QTY IS NULL THEN ''" ).append("\n"); 
		query.append("            ELSE A5.FNL_MQC_QTY ||'/'|| (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00897' AND INTG_CD_VAL_CTNT = A5.CNTR_LOD_UT_CD) " ).append("\n"); 
		query.append("       END FNL_MQC_DESC" ).append("\n"); 
		query.append("FROM PRI_SP_HDR A1" ).append("\n"); 
		query.append("    ,PRI_SP_MN A2" ).append("\n"); 
		query.append("    ,PRI_SP_CTRT_PTY A3" ).append("\n"); 
		query.append("    ,PRI_SP_DUR A4" ).append("\n"); 
		query.append("    ,PRI_SP_MQC A5" ).append("\n"); 
		query.append("WHERE A1.SC_NO = @[prc_ctrt_no]" ).append("\n"); 
		query.append("  AND A1.PROP_NO = A2.PROP_NO" ).append("\n"); 
		query.append("  AND A2.AMDT_SEQ = (" ).append("\n"); 
		query.append("                    SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                      FROM PRI_SP_MN" ).append("\n"); 
		query.append("                     WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                       AND PROP_STS_CD = 'F')" ).append("\n"); 
		query.append("  AND A2.PROP_NO  = A3.PROP_NO" ).append("\n"); 
		query.append("  AND A2.AMDT_SEQ = A3.AMDT_SEQ" ).append("\n"); 
		query.append("  AND A3.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("  AND A2.PROP_NO  = A4.PROP_NO" ).append("\n"); 
		query.append("  AND A2.AMDT_SEQ = A4.AMDT_SEQ" ).append("\n"); 
		query.append("  AND A2.PROP_NO  = A5.PROP_NO" ).append("\n"); 
		query.append("  AND A2.AMDT_SEQ = A5.AMDT_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- RFA 조회" ).append("\n"); 
		query.append("SELECT A2.RESPB_SLS_OFC_CD AS SLS_OFC_CD" ).append("\n"); 
		query.append("      ,A2.RESPB_SREP_CD    AS CTRT_CUST_SREP_CD" ).append("\n"); 
		query.append("      ,(SELECT SREP_NM" ).append("\n"); 
		query.append("          FROM MDM_SLS_REP" ).append("\n"); 
		query.append("         WHERE SREP_CD = A2.RESPB_SREP_CD) CTRT_CUST_SREP_NM " ).append("\n"); 
		query.append("      ,A2.CTRT_CUST_CNT_CD|| LPAD(A2.CTRT_CUST_SEQ, 6, 0) CTRT_CUST_CD" ).append("\n"); 
		query.append("      ,(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A2.CTRT_CUST_CNT_CD AND CUST_SEQ = A2.CTRT_CUST_SEQ) CTRT_CUST_NM" ).append("\n"); 
		query.append("      ,A3.CTRT_EFF_DT" ).append("\n"); 
		query.append("      ,A3.CTRT_EXP_DT" ).append("\n"); 
		query.append("      ,CASE WHEN A2.TGT_MVC_QTY IS NULL THEN ''" ).append("\n"); 
		query.append("            ELSE A2.TGT_MVC_QTY ||'/'||(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00897' AND INTG_CD_VAL_CTNT = A2.CNTR_LOD_UT_CD) " ).append("\n"); 
		query.append("       END FNL_MQC_DESC" ).append("\n"); 
		query.append("  FROM PRI_RP_HDR A1" ).append("\n"); 
		query.append("      ,PRI_RP_MN A2" ).append("\n"); 
		query.append("      ,PRI_RP_DUR A3" ).append("\n"); 
		query.append(" WHERE A1.RFA_NO = @[prc_ctrt_no]" ).append("\n"); 
		query.append("   AND A1.PROP_NO = A2.PROP_NO" ).append("\n"); 
		query.append("   AND A2.AMDT_SEQ =  (" ).append("\n"); 
		query.append("                       SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                         FROM PRI_RP_MN" ).append("\n"); 
		query.append("                        WHERE PROP_NO = A1.PROP_NO" ).append("\n"); 
		query.append("                          AND PROP_STS_CD = 'A')" ).append("\n"); 
		query.append("   AND A2.PROP_NO  = A3.PROP_NO" ).append("\n"); 
		query.append("   AND A2.AMDT_SEQ = A3.AMDT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}