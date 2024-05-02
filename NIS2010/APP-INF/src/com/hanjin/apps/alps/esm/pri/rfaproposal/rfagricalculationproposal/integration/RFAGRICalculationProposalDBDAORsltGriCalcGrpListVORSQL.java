/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFAGRICalculationProposalDBDAORsltGriCalcGrpListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.06
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.07.06 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGRICalculationProposalDBDAORsltGriCalcGrpListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Calc. Grp, Commodity, Route 리스트 조회
	  * </pre>
	  */
	public RFAGRICalculationProposalDBDAORsltGriCalcGrpListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.integration").append("\n"); 
		query.append("FileName : RFAGRICalculationProposalDBDAORsltGriCalcGrpListVORSQL").append("\n"); 
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
		query.append("SELECT A.PROP_NO" ).append("\n"); 
		query.append("      ,A.AMDT_SEQ" ).append("\n"); 
		query.append("      ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("      ,A.GRI_GRP_SEQ" ).append("\n"); 
		query.append("      ,A.FLT_PCT_TP_CD" ).append("\n"); 
		query.append("      ,A.GRI_APPL_DIV_CD" ).append("\n"); 
		query.append("      ,A.GRI_APPL_FLG" ).append("\n"); 
		query.append("      ,B.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("      ,B.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("      ,C.CUST_SEQ" ).append("\n"); 
		query.append("      ,REPLACE(C.CUST_LGL_ENG_NM, '^|^', ' / ') AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,D.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,D.ROUT_PNT_LOC_DEF_NM AS ORG_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("      ,E.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,E.ROUT_VIA_PORT_DEF_NM AS ORG_ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append("      ,F.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("      ,F.ROUT_VIA_PORT_DEF_NM AS DEST_ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append("      ,G.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("      ,G.ROUT_PNT_LOC_DEF_NM AS DEST_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_GRI_GRP A" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD, '|')) AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_NM, ' / ')), 4) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("                      ,PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                      ,DECODE(PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                             ,'G'" ).append("\n"); 
		query.append("                             ,(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("                                FROM PRI_RP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("                               WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                                 AND AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("                                 AND SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                 AND PRC_GRP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'R'" ).append("\n"); 
		query.append("                             ,(SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("                               WHERE REP_CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'C'" ).append("\n"); 
		query.append("                             ,(SELECT CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                               WHERE CMDT_CD = A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GRI_GRP_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, GRI_GRP_SEQ, DECODE(PRC_CMDT_TP_CD, 'G', '1', 'C', '2'), PRC_CMDT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_GRI_CMDT A" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND NVL(GEN_SPCL_RT_TP_CD, 'G') = NVL(@[gen_spcl_rt_tp_cd], 'G'))                                " ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR GRI_GRP_SEQ = GRI_GRP_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GRI_GRP_SEQ) B" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(CUST_CNT_CD || CUST_SEQ, '|')) AS CUST_SEQ" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(CUST_LGL_ENG_NM, '^|^')), 4) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("                      ,CUST_CNT_CD" ).append("\n"); 
		query.append("                      ,CUST_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                          FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                         WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                           AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("                 AND CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, GRI_GRP_SEQ ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, GRI_GRP_SEQ, ACT_CUST_SEQ) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_GRI_ACT_CUST A" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND NVL(GEN_SPCL_RT_TP_CD, 'G') = NVL(@[gen_spcl_rt_tp_cd], 'G'))" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR GRI_GRP_SEQ = GRI_GRP_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GRI_GRP_SEQ) C" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, '|')) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', ')), 3) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_DEF_CD || NVL2(RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                                  ,'(' || (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                                             FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                                            WHERE INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("                                                              AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) || ')'" ).append("\n"); 
		query.append("                                                  ,'') AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GRI_GRP_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, GRI_GRP_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_GRI_ROUT_PNT" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND NVL(GEN_SPCL_RT_TP_CD, 'G') = NVL(@[gen_spcl_rt_tp_cd], 'G')                " ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR GRI_GRP_SEQ = GRI_GRP_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("                 ,ORG_DEST_TP_CD) D" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '|')) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GRI_GRP_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, GRI_GRP_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_GRI_ROUT_VIA" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND NVL(GEN_SPCL_RT_TP_CD, 'G') = NVL(@[gen_spcl_rt_tp_cd], 'G')                 " ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'O')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR GRI_GRP_SEQ = GRI_GRP_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("                 ,ORG_DEST_TP_CD) E" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, '|')) AS ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_VIA_PORT_DEF_CD, ', ')), 3) AS ROUT_VIA_PORT_DEF_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GRI_GRP_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, GRI_GRP_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_VIA_PORT_TP_CD, 'G', '1', 'L', '2'), ROUT_VIA_PORT_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_GRI_ROUT_VIA" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND NVL(GEN_SPCL_RT_TP_CD, 'G') = NVL(@[gen_spcl_rt_tp_cd], 'G')              " ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR GRI_GRP_SEQ = GRI_GRP_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("                 ,ORG_DEST_TP_CD) F" ).append("\n"); 
		query.append("      ,(SELECT PROP_NO" ).append("\n"); 
		query.append("              ,AMDT_SEQ" ).append("\n"); 
		query.append("              ,SVC_SCP_CD" ).append("\n"); 
		query.append("              ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("              ,MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, '|')) AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(SYS_CONNECT_BY_PATH(ROUT_PNT_LOC_DEF_CD, ', ')), 3) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("          FROM (SELECT PROP_NO" ).append("\n"); 
		query.append("                      ,AMDT_SEQ" ).append("\n"); 
		query.append("                      ,SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("                      ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ROUT_PNT_LOC_DEF_CD || NVL2(RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                                  ,'(' || (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                                             FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                                            WHERE INTG_CD_ID = 'CD02139'" ).append("\n"); 
		query.append("                                                              AND INTG_CD_VAL_CTNT = RCV_DE_TERM_CD) || ')'" ).append("\n"); 
		query.append("                                                  ,'') AS ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GRI_GRP_SEQ, ORG_DEST_TP_CD ORDER BY PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, GRI_GRP_SEQ, ORG_DEST_TP_CD, DECODE(ROUT_PNT_LOC_TP_CD, 'G', '1', 'L', '2'), ROUT_PNT_LOC_DEF_CD) AS RN" ).append("\n"); 
		query.append("                  FROM PRI_RP_SCP_GRI_ROUT_PNT" ).append("\n"); 
		query.append("                 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND NVL(GEN_SPCL_RT_TP_CD, 'G') = NVL(@[gen_spcl_rt_tp_cd], 'G')               " ).append("\n"); 
		query.append("                   AND ORG_DEST_TP_CD = 'D')" ).append("\n"); 
		query.append("         START WITH RN = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR GRI_GRP_SEQ = GRI_GRP_SEQ" ).append("\n"); 
		query.append("               AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("         GROUP BY PROP_NO" ).append("\n"); 
		query.append("                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                 ,GRI_GRP_SEQ" ).append("\n"); 
		query.append("                 ,ORG_DEST_TP_CD) G" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = B.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = B.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GRI_GRP_SEQ = B.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GRI_GRP_SEQ = C.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GRI_GRP_SEQ = D.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GRI_GRP_SEQ = E.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GRI_GRP_SEQ = F.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = G.PROP_NO(+)" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = G.AMDT_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = G.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("   AND A.GRI_GRP_SEQ = G.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND NVL(A.GEN_SPCL_RT_TP_CD, 'G') = NVL(@[gen_spcl_rt_tp_cd], 'G')" ).append("\n"); 

	}
}