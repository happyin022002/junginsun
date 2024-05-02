/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpAproRcvdRqstRefVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.02.21 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOPriRpAproRcvdRqstRefVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriRpAproRcvdRqstRefVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPriRpAproRcvdRqstRefVORSQL").append("\n"); 
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
		query.append("-- RECEIVED" ).append("\n"); 
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
		query.append("     , '' AS TRANS_TP_CD" ).append("\n"); 
		query.append("     , '' AS EFF_DT" ).append("\n"); 
		query.append("     , '' AS EXP_DT" ).append("\n"); 
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
		query.append("             , RQ.APRO_RQST_USR_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("             , RQ.APRO_RQST_USR_ID AS USR_ID" ).append("\n"); 
		query.append("             , RE.SREP_CD" ).append("\n"); 
		query.append("    		 , (SELECT UR.USR_NM FROM COM_USER UR " ).append("\n"); 
		query.append("    		    WHERE UR.USR_ID = RQ.APRO_RQST_USR_ID) AS USR_NM" ).append("\n"); 
		query.append("             , PR.PROG_DT" ).append("\n"); 
		query.append("             , ROW_NUMBER() OVER (PARTITION BY RQ.PROP_NO, RQ.AMDT_SEQ" ).append("\n"); 
		query.append("                                  ORDER BY RQ.APRO_RQST_SEQ DESC) AS SEQ" ).append("\n"); 
		query.append("        FROM PROG PR" ).append("\n"); 
		query.append("           , PRI_RP_APRO_RQST_REF RQ" ).append("\n"); 
		query.append("           , PRI_RP_APRO_RQST_REF_USR RU" ).append("\n"); 
		query.append("           , MDM_SLS_REP RE" ).append("\n"); 
		query.append("        WHERE PR.PROP_STS_CD IN ('I', 'Q')" ).append("\n"); 
		query.append("        AND   RQ.PROP_NO = PR.PROP_NO" ).append("\n"); 
		query.append("        AND   RQ.AMDT_SEQ = PR.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   RU.PROP_NO = RQ.PROP_NO" ).append("\n"); 
		query.append("        AND   RU.AMDT_SEQ = RQ.AMDT_SEQ" ).append("\n"); 
		query.append("        AND   RU.APRO_RQST_SEQ = RQ.APRO_RQST_SEQ" ).append("\n"); 
		query.append("        AND   RU.APRO_RQST_REF_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("        AND   RE.OFC_CD(+) = RQ.APRO_RQST_USR_OFC_CD" ).append("\n"); 
		query.append("        AND   RE.EMPE_CD(+) = RQ.APRO_RQST_USR_ID" ).append("\n"); 
		query.append("    	AND   RE.DELT_FLG(+) <> 'Y'" ).append("\n"); 
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
		query.append("         , PR.PROG_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("         , PR.PROG_USR_ID AS USR_ID" ).append("\n"); 
		query.append("         , RQ.SREP_CD" ).append("\n"); 
		query.append("         , (SELECT UR.USR_NM FROM COM_USER UR " ).append("\n"); 
		query.append("            WHERE UR.USR_ID = PR.PROG_USR_ID) AS USR_NM" ).append("\n"); 
		query.append("         , PR.PROG_DT" ).append("\n"); 
		query.append("    FROM PROG PR" ).append("\n"); 
		query.append("       , PRI_RP_MN MN" ).append("\n"); 
		query.append("       , MDM_SLS_REP RE" ).append("\n"); 
		query.append("       , MDM_SLS_REP RQ" ).append("\n"); 
		query.append("    WHERE PR.PROP_STS_CD IN ('R','A')" ).append("\n"); 
		query.append("    AND   MN.PROP_NO = PR.PROP_NO" ).append("\n"); 
		query.append("    AND   MN.AMDT_SEQ = PR.AMDT_SEQ" ).append("\n"); 
		query.append("    AND   RE.SREP_CD = MN.PROP_SREP_CD" ).append("\n"); 
		query.append("    AND   RE.OFC_CD = MN.PROP_OFC_CD" ).append("\n"); 
		query.append("    AND   RE.EMPE_CD = @[usr_id]" ).append("\n"); 
		query.append("    AND   RQ.EMPE_CD(+) = PR.PROG_USR_ID" ).append("\n"); 
		query.append("    AND   RQ.OFC_CD(+) = PR.PROG_OFC_CD" ).append("\n"); 
		query.append("    AND   RE.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("    AND   RQ.DELT_FLG(+) <> 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY PROG_DT DESC, RQST_TP_CD DESC, PROP_NO, USR_ID" ).append("\n"); 

	}
}