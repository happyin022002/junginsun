/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalDBDAOChkArbiLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFATransportationAdditionalChargeProposalDBDAOChkArbiLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * check the location of Arbi's Point and Base port
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAOChkArbiLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAOChkArbiLocationRSQL").append("\n"); 
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
		query.append("WITH TMP AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       ATTR_CTNT1 AS SEQ" ).append("\n"); 
		query.append("     , ATTR_CTNT2 AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , DECODE(LENGTH(ATTR_CTNT2),4,'G',5,'L') AS ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("     , ATTR_CTNT4 AS PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , ATTR_CTNT5 AS RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , ATTR_CTNT6 AS MIN_CGO_WGT" ).append("\n"); 
		query.append("     , ATTR_CTNT7 AS MAX_CGO_WGT" ).append("\n"); 
		query.append("     , ATTR_CTNT8 AS BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , DECODE(LENGTH(ATTR_CTNT8),4,'G',5,'L') AS BSE_PORT_TP_CD" ).append("\n"); 
		query.append("     , ATTR_CTNT10 AS CUST_DEF_CD" ).append("\n"); 
		query.append("     , ATTR_CTNT11 AS RAT_UT_CD" ).append("\n"); 
		query.append("     , ATTR_CTNT12 AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , ATTR_CTNT13 AS CURR_CD" ).append("\n"); 
		query.append("     , ATTR_CTNT14 AS PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , ATTR_CTNT15 AS NOTE_DP_SEQ" ).append("\n"); 
		query.append("     , ATTR_CTNT16 AS ADD_CHG_NOTE_CTNT" ).append("\n"); 
		query.append("     , ATTR_CTNT17 AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , ATTR_CTNT18 AS PROP_NO" ).append("\n"); 
		query.append("     , ATTR_CTNT19 AS AMDT_SEQ" ).append("\n"); 
		query.append("     , ATTR_CTNT20 AS SVC_SCP_CD" ).append("\n"); 
		query.append("  FROM PRI_VAL_TMP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       TO_NUMBER(A.SEQ) AS ADD_CHG_SEQ" ).append("\n"); 
		query.append("     , A.UKEY" ).append("\n"); 
		query.append("     , SUM(A.ERR_ROW_CNT) OVER (PARTITION BY A.GB) AS TOT_ERR_CNT" ).append("\n"); 
		query.append("     , SUM(A.ERR_ROW_CNT) OVER (PARTITION BY A.SEQ) AS ROW_ERR_CNT" ).append("\n"); 
		query.append("     , A.DUP_CNT" ).append("\n"); 
		query.append("     , A.CHK_LEN_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , A.CHK_LEN_BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , A.CHK_RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , A.CHK_RAT_UT_CD" ).append("\n"); 
		query.append("     , A.CHK_CURR_CD" ).append("\n"); 
		query.append("     , A.CHK_MIN_CGO_WGT" ).append("\n"); 
		query.append("     , A.CHK_MAX_CGO_WGT" ).append("\n"); 
		query.append("     , A.CHK_PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , A.CHK_TERM_PNT_PORT" ).append("\n"); 
		query.append("     , A.CHK_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , A.CHK_BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("     , A.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , A.MIN_CGO_WGT" ).append("\n"); 
		query.append("     , A.MAX_CGO_WGT" ).append("\n"); 
		query.append("     , A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , A.BSE_PORT_TP_CD" ).append("\n"); 
		query.append("     , A.CUST_DEF_CD" ).append("\n"); 
		query.append("     , A.RAT_UT_CD" ).append("\n"); 
		query.append("     , A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , A.NOTE_DP_SEQ" ).append("\n"); 
		query.append("     , A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , A.PROP_NO" ).append("\n"); 
		query.append("     , A.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.SVC_SCP_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       A.SEQ" ).append("\n"); 
		query.append("     , A.GB" ).append("\n"); 
		query.append("     , A.UKEY" ).append("\n"); 
		query.append("     , A.ERR_ROW_CNT" ).append("\n"); 
		query.append("     , A.DUP_CNT" ).append("\n"); 
		query.append("     , A.CHK_LEN_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , A.CHK_LEN_BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , A.CHK_RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , A.CHK_RAT_UT_CD" ).append("\n"); 
		query.append("     , A.CHK_CURR_CD" ).append("\n"); 
		query.append("     , A.CHK_MIN_CGO_WGT" ).append("\n"); 
		query.append("     , A.CHK_MAX_CGO_WGT" ).append("\n"); 
		query.append("     , A.CHK_PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , A.CHK_TERM_PNT_PORT" ).append("\n"); 
		query.append("     , A.CHK_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , A.CHK_BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("     , A.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , A.MIN_CGO_WGT" ).append("\n"); 
		query.append("     , A.MAX_CGO_WGT" ).append("\n"); 
		query.append("     , A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , A.BSE_PORT_TP_CD" ).append("\n"); 
		query.append("     , A.CUST_DEF_CD" ).append("\n"); 
		query.append("     , A.RAT_UT_CD" ).append("\n"); 
		query.append("     , A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , A.NOTE_DP_SEQ" ).append("\n"); 
		query.append("     , A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , A.PROP_NO" ).append("\n"); 
		query.append("     , A.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.SVC_SCP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("        CASE WHEN (A.CHK_LEN_ROUT_PNT_LOC_DEF_CD = 'F' OR A.CHK_LEN_BSE_PORT_DEF_CD = 'F'     OR A.CHK_RCV_DE_TERM_CD = 'F' OR " ).append("\n"); 
		query.append("                  A.CHK_RAT_UT_CD = 'F' OR A.CHK_CURR_CD = 'F' OR A.CHK_MIN_CGO_WGT = 'F' OR " ).append("\n"); 
		query.append("                  A.CHK_MAX_CGO_WGT = 'F' OR A.CHK_PROP_FRT_RT_AMT = 'F' OR A.CHK_TERM_PNT_PORT = 'F' OR " ).append("\n"); 
		query.append("                  A.DUP_CNT > 1 OR A.CHK_ROUT_PNT_LOC_DEF_CD = 'F' OR A.CHK_BSE_PORT_DEF_CD = 'F' ) THEN 1 ELSE 0 END ERR_ROW_CNT" ).append("\n"); 
		query.append("      , A.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE WHEN LENGTH(NVL(A.ROUT_PNT_LOC_DEF_CD,'')) = 5 THEN 'T' ELSE 'F' END CHK_LEN_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , CASE WHEN ( (NVL(A.BSE_PORT_DEF_CD,'1') <> '1') AND ( LENGTH(NVL(A.BSE_PORT_DEF_CD,'')) = 5 OR LENGTH(NVL(A.BSE_PORT_DEF_CD,'')) = 4 ) ) THEN 'T' ELSE 'F' END CHK_LEN_BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , CASE WHEN NVL(A.RCV_DE_TERM_CD,'1') <> '1' THEN 'T' ELSE 'F' END CHK_RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , CASE WHEN NVL(A.RAT_UT_CD,'1') <> '1' THEN 'T' ELSE 'F' END CHK_RAT_UT_CD" ).append("\n"); 
		query.append("     , CASE WHEN NVL(A.CURR_CD,'1') <> '1' THEN 'T' ELSE 'F' END CHK_CURR_CD" ).append("\n"); 
		query.append("     , CASE WHEN A.MIN_CGO_WGT IS NOT NULL AND A.MIN_CGO_WGT > 999.999 THEN 'F' ELSE 'T' END CHK_MIN_CGO_WGT" ).append("\n"); 
		query.append("     , CASE WHEN A.MAX_CGO_WGT IS NOT NULL AND A.MAX_CGO_WGT > 999.999 THEN 'F' ELSE 'T' END CHK_MAX_CGO_WGT" ).append("\n"); 
		query.append("     , CASE WHEN A.PROP_FRT_RT_AMT IS NOT NULL AND LENGTH(A.PROP_FRT_RT_AMT) > 10 THEN 'F' ELSE 'T' END CHK_PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , CASE WHEN A.RCV_DE_TERM_CD <> 'D' AND (A.ROUT_PNT_LOC_DEF_CD = A.BSE_PORT_DEF_CD) THEN 'F' ELSE 'T' END CHK_TERM_PNT_PORT" ).append("\n"); 
		query.append("     , A.UKEY" ).append("\n"); 
		query.append("     , COUNT(A.UKEY) OVER(PARTITION BY A.UKEY) AS DUP_CNT" ).append("\n"); 
		query.append("     , A.CHK_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , A.CHK_BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , A.GB" ).append("\n"); 
		query.append("     , A.SEQ" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("     , A.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , A.MIN_CGO_WGT" ).append("\n"); 
		query.append("     , A.MAX_CGO_WGT" ).append("\n"); 
		query.append("     , A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , A.BSE_PORT_TP_CD" ).append("\n"); 
		query.append("     , A.CUST_DEF_CD" ).append("\n"); 
		query.append("     , A.RAT_UT_CD" ).append("\n"); 
		query.append("     , A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , A.NOTE_DP_SEQ" ).append("\n"); 
		query.append("     , A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , A.PROP_NO" ).append("\n"); 
		query.append("     , A.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.SVC_SCP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       '1' AS GB" ).append("\n"); 
		query.append("     , CASE WHEN B.LOC_CD IS NOT NULL THEN 'T' ELSE 'F' END CHK_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , CASE WHEN C.LOC_CD IS NOT NULL THEN 'T' ELSE 'F' END CHK_BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_DEF_CD||'|'||NVL(A.PRC_TRSP_MOD_CD,'X')||'|'||A.RCV_DE_TERM_CD||'|'||A.BSE_PORT_DEF_CD||'|'||A.RAT_UT_CD||'|'||NVL(A.PRC_CGO_TP_CD,'X')||'|'||TO_CHAR(A.MIN_CGO_WGT)||'|'||TO_CHAR(A.MAX_CGO_WGT)||'|'||NVL(A.CUST_DEF_CD,'X')||'|'||TO_CHAR(A.AMDT_SEQ)||'|'||NVL(A.ADD_CHG_NOTE_CTNT,'X') AS UKEY" ).append("\n"); 
		query.append("     , A.SEQ" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("     , A.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , TO_NUMBER(A.MIN_CGO_WGT) AS MIN_CGO_WGT" ).append("\n"); 
		query.append("     , TO_NUMBER(A.MAX_CGO_WGT) AS MAX_CGO_WGT" ).append("\n"); 
		query.append("     , A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , A.BSE_PORT_TP_CD" ).append("\n"); 
		query.append("     , A.CUST_DEF_CD" ).append("\n"); 
		query.append("     , A.RAT_UT_CD" ).append("\n"); 
		query.append("     , A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , TO_NUMBER(A.PROP_FRT_RT_AMT) AS PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , TO_NUMBER(A.NOTE_DP_SEQ) AS NOTE_DP_SEQ" ).append("\n"); 
		query.append("     , A.ADD_CHG_NOTE_CTNT" ).append("\n"); 
		query.append("     , A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , A.PROP_NO" ).append("\n"); 
		query.append("     , TO_NUMBER(A.AMDT_SEQ) AS AMDT_SEQ" ).append("\n"); 
		query.append("     , A.SVC_SCP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM TMP A" ).append("\n"); 
		query.append("     , (SELECT " ).append("\n"); 
		query.append("               LOC_CD" ).append("\n"); 
		query.append("          FROM MDM_LOCATION" ).append("\n"); 
		query.append("         WHERE DELT_FLG ='N') B" ).append("\n"); 
		query.append("     , (SELECT" ).append("\n"); 
		query.append("               LOC_CD" ).append("\n"); 
		query.append("          FROM (SELECT " ).append("\n"); 
		query.append("                       LOC_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DELT_FLG ='N'" ).append("\n"); 
		query.append("                 UNION" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                       PRC_GRP_LOC_CD AS LOC_CD" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_GRP_LOC A" ).append("\n"); 
		query.append("                     , (SELECT " ).append("\n"); 
		query.append("                               DISTINCT PROP_NO, AMDT_SEQ, GRP_LOC_SEQ, SVC_SCP_CD" ).append("\n"); 
		query.append("                          FROM PRI_RP_SCP_GRP_LOC_DTL" ).append("\n"); 
		query.append("                         WHERE SRC_INFO_CD != 'AD' ) B" ).append("\n"); 
		query.append("                 WHERE A.PROP_NO		= B.PROP_NO" ).append("\n"); 
		query.append("                   AND A.AMDT_SEQ		= B.AMDT_SEQ" ).append("\n"); 
		query.append("                   AND A.SVC_SCP_CD		= B.SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND A.GRP_LOC_SEQ	= B.GRP_LOC_SEQ" ).append("\n"); 
		query.append("                   AND A.PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("                   AND A.AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("                   AND A.SVC_SCP_CD 	= @[svc_scp_cd]) ) C" ).append("\n"); 
		query.append(" WHERE A.ROUT_PNT_LOC_DEF_CD    = B.LOC_CD(+)" ).append("\n"); 
		query.append("   AND A.BSE_PORT_DEF_CD        = C.LOC_CD(+)" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" SELECT" ).append("\n"); 
		query.append("       '2' AS GB" ).append("\n"); 
		query.append("     , NULL AS CHK_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , NULL AS CHK_BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , ROUT_PNT_LOC_DEF_CD||'|'||NVL(PRC_TRSP_MOD_CD,'X')||'|'||RCV_DE_TERM_CD||'|'||BSE_PORT_DEF_CD||'|'||RAT_UT_CD||'|'||NVL(PRC_CGO_TP_CD,'X')||'|'||TO_CHAR(MIN_CGO_WGT)||'|'||TO_CHAR(MAX_CGO_WGT)||'|'||NVL((CUST_CNT_CD||TO_CHAR(CUST_SEQ)),'X')||'|'||TO_CHAR(AMDT_SEQ)||'|'||NVL(ADD_CHG_NOTE_CTNT,'X') AS UKEY" ).append("\n"); 
		query.append("     , NULL AS SEQ" ).append("\n"); 
		query.append("     , ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("     , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , MIN_CGO_WGT" ).append("\n"); 
		query.append("     , MAX_CGO_WGT" ).append("\n"); 
		query.append("     , BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , BSE_PORT_TP_CD" ).append("\n"); 
		query.append("     , CUST_CNT_CD||TO_CHAR(CUST_SEQ) AS CUST_DEF_CD" ).append("\n"); 
		query.append("     , RAT_UT_CD" ).append("\n"); 
		query.append("     , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("     , NOTE_DP_SEQ" ).append("\n"); 
		query.append("     , ADD_CHG_NOTE_CTNT" ).append("\n"); 
		query.append("     , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , PROP_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_TRSP_ADD_CHG WHERE PROP_NO = @[prop_no] AND AMDT_SEQ = @[amdt_seq] AND SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("     ) A ) A " ).append("\n"); 
		query.append("WHERE A.GB = '1' ) A ) A" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER(A.SEQ)" ).append("\n"); 

	}
}