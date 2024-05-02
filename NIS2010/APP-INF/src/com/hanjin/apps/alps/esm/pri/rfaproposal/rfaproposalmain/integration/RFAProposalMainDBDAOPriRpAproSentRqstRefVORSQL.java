/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpAproSentRqstRefVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOPriRpAproSentRqstRefVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Proposal & Amendment Status 화면 Sent 조회
	  * 
	  * History
	  * 2015.04.07 전지예 [CHM-201535026] Customer code & name 추가
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriRpAproSentRqstRefVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPriRpAproSentRqstRefVORSQL").append("\n"); 
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
		query.append("-- SENT" ).append("\n"); 
		query.append("WITH PROG AS (" ).append("\n"); 
		query.append("    SELECT PROP_NO" ).append("\n"); 
		query.append("         , AMDT_SEQ" ).append("\n"); 
		query.append("         , PROP_PROG_SEQ" ).append("\n"); 
		query.append("         , PROP_STS_CD" ).append("\n"); 
		query.append("         , PROG_USR_ID" ).append("\n"); 
		query.append("         , PROG_OFC_CD" ).append("\n"); 
		query.append("         , PROG_DT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT PROP_NO" ).append("\n"); 
		query.append("             , AMDT_SEQ" ).append("\n"); 
		query.append("             , PROP_PROG_SEQ" ).append("\n"); 
		query.append("             , PROP_STS_CD" ).append("\n"); 
		query.append("             , PROG_USR_ID" ).append("\n"); 
		query.append("             , PROG_OFC_CD" ).append("\n"); 
		query.append("             , PROG_DT" ).append("\n"); 
		query.append("             , DENSE_RANK() OVER (PARTITION BY PROP_NO" ).append("\n"); 
		query.append("                                  ORDER BY PROP_NO, AMDT_SEQ DESC, PROP_PROG_SEQ DESC) AS SEQ" ).append("\n"); 
		query.append("        FROM PRI_RP_PROG" ).append("\n"); 
		query.append("        WHERE PROG_DT BETWEEN TO_DATE(@[eff_dt],'YYYY-MM-DD') AND TO_DATE(@[exp_dt]||' 235959','YYYY-MM-DD HH24MISS')" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE SEQ = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT RQST_TP_CD" ).append("\n"); 
		query.append("     , PROP_STS_CD" ).append("\n"); 
		query.append("     , PROP_STS_NM" ).append("\n"); 
		query.append("     , PROP_NO" ).append("\n"); 
		query.append("     , RFA_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("     , OFC_CD" ).append("\n"); 
		query.append("     , USR_ID" ).append("\n"); 
		query.append("     , SREP_CD" ).append("\n"); 
		query.append("     , USR_NM" ).append("\n"); 
		query.append("     , TO_CHAR(PROG_DT, 'YYYYMMDD') AS PROG_DT" ).append("\n"); 
		query.append("     , CTRT_CUST_CNT_CD || LPAD(CTRT_CUST_SEQ, 6, 0) AS CTRT_CUST_CD" ).append("\n"); 
		query.append("     , ( SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("           FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("          WHERE CUST.CUST_CNT_CD        = CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("            AND CUST.CUST_SEQ           = CTRT_CUST_SEQ" ).append("\n"); 
		query.append("            AND CUST.CNTR_DIV_FLG 	   = 'Y'" ).append("\n"); 
		query.append("       ) CTRT_PTY_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT RQST_TP_CD" ).append("\n"); 
		query.append("         , PROP_STS_CD" ).append("\n"); 
		query.append("         , PROP_STS_NM" ).append("\n"); 
		query.append("         , PROP_NO" ).append("\n"); 
		query.append("         , RFA_NO" ).append("\n"); 
		query.append("         , AMDT_SEQ" ).append("\n"); 
		query.append("         , OFC_CD" ).append("\n"); 
		query.append("         , USR_ID" ).append("\n"); 
		query.append("         , SREP_CD" ).append("\n"); 
		query.append("		 , USR_NM" ).append("\n"); 
		query.append("         , PROG_DT" ).append("\n"); 
		query.append("         , CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("         , CTRT_CUST_SEQ" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT DECODE(RU.APRO_RQST_REF_TP_CD,'T','TO','C','CC') AS RQST_TP_CD" ).append("\n"); 
		query.append("             , PR.PROP_STS_CD" ).append("\n"); 
		query.append("             , (SELECT CD.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                FROM COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("                WHERE CD.INTG_CD_ID = 'CD01722'" ).append("\n"); 
		query.append("                AND   CD.INTG_CD_VAL_CTNT = PR.PROP_STS_CD) AS PROP_STS_NM" ).append("\n"); 
		query.append("             , PR.PROP_NO" ).append("\n"); 
		query.append("             , (SELECT HD.RFA_NO FROM PRI_RP_HDR HD WHERE HD.PROP_NO = PR.PROP_NO) AS RFA_NO" ).append("\n"); 
		query.append("             , PR.AMDT_SEQ" ).append("\n"); 
		query.append("             , RU.APRO_RQST_REF_USR_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("             , RU.APRO_RQST_REF_USR_ID AS USR_ID" ).append("\n"); 
		query.append("             , RE.SREP_CD" ).append("\n"); 
		query.append("    		 , (SELECT UR.USR_NM FROM COM_USER UR " ).append("\n"); 
		query.append("    		    WHERE UR.USR_ID = RU.APRO_RQST_REF_USR_ID) AS USR_NM" ).append("\n"); 
		query.append("             , PR.PROG_DT" ).append("\n"); 
		query.append("             , CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("             , CTRT_CUST_SEQ" ).append("\n"); 
		query.append("             , ROW_NUMBER() OVER (PARTITION BY RQ.PROP_NO, RQ.AMDT_SEQ" ).append("\n"); 
		query.append("                                  ORDER BY RQ.APRO_RQST_SEQ DESC) AS SEQ" ).append("\n"); 
		query.append("        FROM PROG PR" ).append("\n"); 
		query.append("           , PRI_RP_MN MN" ).append("\n"); 
		query.append("           , PRI_RP_APRO_RQST_REF RQ" ).append("\n"); 
		query.append("           , PRI_RP_APRO_RQST_REF_USR RU" ).append("\n"); 
		query.append("           , MDM_SLS_REP RE" ).append("\n"); 
		query.append("        WHERE PR.PROP_STS_CD IN ('I', 'Q')" ).append("\n"); 
		query.append("        AND   MN.RFA_CTRT_TP_CD IN ('S', 'C')" ).append("\n"); 
		query.append("        AND   MN.PROP_NO = PR.PROP_NO" ).append("\n"); 
		query.append("        AND   MN.AMDT_SEQ = PR.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   RQ.PROP_NO = PR.PROP_NO" ).append("\n"); 
		query.append("        AND   RQ.AMDT_SEQ = PR.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   RQ.APRO_RQST_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("        AND   RU.PROP_NO = RQ.PROP_NO" ).append("\n"); 
		query.append("        AND   RU.AMDT_SEQ = RQ.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   RU.APRO_RQST_SEQ = RQ.APRO_RQST_SEQ" ).append("\n"); 
		query.append("        AND   RE.OFC_CD(+) = RU.APRO_RQST_REF_USR_OFC_CD" ).append("\n"); 
		query.append("        AND   RE.EMPE_CD(+) = RU.APRO_RQST_REF_USR_ID" ).append("\n"); 
		query.append("    	AND   RE.SREP_STS_CD(+) <> 'Y'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE SEQ = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'TO' AS RQST_TP_CD" ).append("\n"); 
		query.append("         , PR.PROP_STS_CD" ).append("\n"); 
		query.append("         , (SELECT CD.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("            FROM COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("            WHERE CD.INTG_CD_ID = 'CD01722'" ).append("\n"); 
		query.append("            AND   CD.INTG_CD_VAL_CTNT = PR.PROP_STS_CD) AS PROP_STS_NM" ).append("\n"); 
		query.append("         , PR.PROP_NO" ).append("\n"); 
		query.append("         , (SELECT HD.RFA_NO FROM PRI_RP_HDR HD WHERE HD.PROP_NO = PR.PROP_NO) AS RFA_NO" ).append("\n"); 
		query.append("         , PR.AMDT_SEQ" ).append("\n"); 
		query.append("         , MN.PROP_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("         , RE.EMPE_CD AS USR_ID" ).append("\n"); 
		query.append("         , MN.PROP_SREP_CD AS SREP_CD" ).append("\n"); 
		query.append("		 , (SELECT UR.USR_NM FROM COM_USER UR " ).append("\n"); 
		query.append("		    WHERE UR.USR_ID = RE.EMPE_CD) AS USR_NM" ).append("\n"); 
		query.append("         , PR.PROG_DT" ).append("\n"); 
		query.append("         , CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("         , CTRT_CUST_SEQ" ).append("\n"); 
		query.append("    FROM PROG PR" ).append("\n"); 
		query.append("       , PRI_RP_MN MN" ).append("\n"); 
		query.append("       , MDM_SLS_REP RE" ).append("\n"); 
		query.append("    WHERE PR.PROG_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("    AND   PR.PROP_STS_CD IN ('R','A')" ).append("\n"); 
		query.append("    AND   MN.RFA_CTRT_TP_CD IN ('S', 'C')" ).append("\n"); 
		query.append("    AND   MN.PROP_NO = PR.PROP_NO" ).append("\n"); 
		query.append("    AND   MN.AMDT_SEQ = PR.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   RE.SREP_CD(+) = MN.PROP_SREP_CD" ).append("\n"); 
		query.append("    AND   RE.OFC_CD(+) = MN.PROP_OFC_CD" ).append("\n"); 
		query.append("	AND   RE.SREP_STS_CD(+) <> 'Y'" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("ORDER BY PROG_DT DESC, RQST_TP_CD DESC, PROP_NO, USR_ID" ).append("\n"); 

	}
}