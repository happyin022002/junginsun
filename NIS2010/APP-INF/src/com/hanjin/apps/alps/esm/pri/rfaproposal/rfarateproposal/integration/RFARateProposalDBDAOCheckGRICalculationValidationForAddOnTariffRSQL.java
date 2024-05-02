/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAOCheckGRICalculationValidationForAddOnTariffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.26
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.26 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOCheckGRICalculationValidationForAddOnTariffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate For Add-On Tariff Gri...
	  * </pre>
	  */
	public RFARateProposalDBDAOCheckGRICalculationValidationForAddOnTariffRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration ").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOCheckGRICalculationValidationForAddOnTariffRSQL").append("\n"); 
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
		query.append("SELECT X.* FROM (" ).append("\n"); 
		query.append("  SELECT      " ).append("\n"); 
		query.append("                 A.PROP_NO" ).append("\n"); 
		query.append("                ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                ,A.ROUT_SEQ" ).append("\n"); 
		query.append("                ,A.RT_SEQ" ).append("\n"); 
		query.append("                ,A.RAT_UT_CD" ).append("\n"); 
		query.append("                ,A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                ,A.CURR_CD" ).append("\n"); 
		query.append("                ,A.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("                ,A.COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append("                ,A.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("                ,A.PRS_SCG_AMT" ).append("\n"); 
		query.append("                ,A.PRS_RESPB_CM_UC_AMT" ).append("\n"); 
		query.append("                ,A.PRS_PFIT_CM_UC_AMT" ).append("\n"); 
		query.append("                ,A.PRS_RESPB_OPFIT_UC_AMT" ).append("\n"); 
		query.append("                ,A.PRS_RESPB_CMPB_AMT" ).append("\n"); 
		query.append("                ,A.PRS_PFIT_CMPB_AMT" ).append("\n"); 
		query.append("                ,A.PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("                ,A.PRS_GID_CMPB_AMT" ).append("\n"); 
		query.append("                ,A.PRS_UPD_DT" ).append("\n"); 
		query.append("                ,A.GRI_APPL_TP_CD" ).append("\n"); 
		query.append("                ,A.GRI_APPL_AMT" ).append("\n"); 
		query.append("                ,A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("                ,A.SRC_INFO_CD" ).append("\n"); 
		query.append("                ,A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("                ,A.UPD_USR_ID" ).append("\n"); 
		query.append("                ,A.UPD_DT" ).append("\n"); 
		query.append("                ,T.FLT_PCT_TP_CD" ).append("\n"); 
		query.append("                ,T.GRI_RT_AMT" ).append("\n"); 
		query.append("                ,T.GRI_RT_RTO" ).append("\n"); 
		query.append("		,(SELECT G1.BLET_DP_SEQ FROM PRI_RP_SCP_RT_CMDT_HDR G1 WHERE G1.PROP_NO = A.PROP_NO AND G1.AMDT_SEQ = A.AMDT_SEQ AND G1.SVC_SCP_CD = A.SVC_SCP_CD AND G1.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ) BLET_DP_SEQ" ).append("\n"); 
		query.append("                ,REGEXP_SUBSTR(PRI_ADDON_RATE_CALCULATE_PKG.PRI_getFICRateByRoute_FNC(A.PROP_NO,A.AMDT_SEQ,A.SVC_SCP_CD, 'O',A.CMDT_HDR_SEQ,A.ROUT_SEQ),'[^|]', 1,1)  AS FIC_ORG_RT_USE_STS_CD" ).append("\n"); 
		query.append("                ,REGEXP_SUBSTR(PRI_ADDON_RATE_CALCULATE_PKG.PRI_getFICRateByRoute_FNC(A.PROP_NO,A.AMDT_SEQ,A.SVC_SCP_CD, 'D', A.CMDT_HDR_SEQ,A.ROUT_SEQ),'[^|]', 1,1)  AS FIC_DEST_RT_USE_STS_CD" ).append("\n"); 
		query.append("            FROM PRI_RP_SCP_RT A" ).append("\n"); 
		query.append("                ,(SELECT A.PROP_NO" ).append("\n"); 
		query.append("                        ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                        ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                        ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                        ,A.ROUT_SEQ" ).append("\n"); 
		query.append("                        ,A.RT_SEQ" ).append("\n"); 
		query.append("                        ,X.FLT_PCT_TP_CD" ).append("\n"); 
		query.append("                        ,X.GRI_RT_AMT" ).append("\n"); 
		query.append("                        ,X.GRI_RT_RTO" ).append("\n"); 
		query.append("                        ,I.GRP_CNT" ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER(PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.RT_SEQ ORDER BY  X.GRI_GRP_SEQ) AS RN" ).append("\n"); 
		query.append("                    FROM PRI_RP_SCP_RT A" ).append("\n"); 
		query.append("                        ,PRI_RP_SCP_RT_CMDT B" ).append("\n"); 
		query.append("                        ,PRI_RP_SCP_RT_ACT_CUST C" ).append("\n"); 
		query.append("                        ,PRI_RP_SCP_RT_ROUT_PNT D" ).append("\n"); 
		query.append("                        ,PRI_RP_SCP_RT_ROUT_VIA E" ).append("\n"); 
		query.append("                        ,PRI_RP_SCP_RT_ROUT_VIA F" ).append("\n"); 
		query.append("                        ,PRI_RP_SCP_RT_ROUT_PNT G" ).append("\n"); 
		query.append("                        ,(" ).append("\n"); 
		query.append("                          SELECT PROP_NO" ).append("\n"); 
		query.append("                                 ,AMDT_SEQ" ).append("\n"); 
		query.append("                                 ,SVC_SCP_CD" ).append("\n"); 
		query.append("                                 ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,RT_SEQ" ).append("\n"); 
		query.append("                                 ,GRP_CNT" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                           SELECT A.PROP_NO" ).append("\n"); 
		query.append("                                ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                                ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                ,A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                ,A.ROUT_SEQ" ).append("\n"); 
		query.append("                                ,A.RT_SEQ" ).append("\n"); 
		query.append("                                ,COUNT(*) AS GRP_CNT" ).append("\n"); 
		query.append("                            FROM PRI_RP_SCP_RT          A" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_RT_CMDT     B" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_RT_ACT_CUST C" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_RT_ROUT_PNT D" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_RT_ROUT_VIA E" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_RT_ROUT_VIA F" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_RT_ROUT_PNT G" ).append("\n"); 
		query.append("                           WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                             AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                             AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                             AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.PROP_NO = D.PROP_NO" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = D.AMDT_SEQ" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("                             AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                             AND A.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("                             AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                             AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.ROUT_SEQ = E.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                             AND A.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.ROUT_SEQ = F.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.PROP_NO = G.PROP_NO" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = G.AMDT_SEQ" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = G.SVC_SCP_CD" ).append("\n"); 
		query.append("                             AND A.CMDT_HDR_SEQ = G.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                             AND A.ROUT_SEQ = G.ROUT_SEQ" ).append("\n"); 
		query.append("                             AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND EXISTS (SELECT 'OK' FROM PRI_RP_SCP_RT_CMDT_HDR  X1 WHERE X1.PROP_NO = A.PROP_NO AND X1.AMDT_SEQ = A.AMDT_SEQ AND X1.SVC_SCP_CD = A.SVC_SCP_CD AND X1.CMDT_HDR_SEQ = A.CMDT_HDR_SEQ AND NVL(X1.FIC_RT_TP_CD, 'G') = NVL(@[gen_spcl_rt_tp_cd], 'G'))     " ).append("\n"); 
		query.append("                             AND D.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                             AND E.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("                             AND F.ORG_DEST_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("                             AND G.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                             AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                             AND B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                             AND C.SRC_INFO_CD(+) <> 'AD'" ).append("\n"); 
		query.append("                             AND D.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                             AND E.SRC_INFO_CD(+) <> 'AD'" ).append("\n"); 
		query.append("                             AND F.SRC_INFO_CD(+) <> 'AD'" ).append("\n"); 
		query.append("                             AND G.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                             AND A.GRI_APPL_TP_CD = 'N'" ).append("\n"); 
		query.append("                             AND (A.N1ST_CMNC_AMDT_SEQ <> A.AMDT_SEQ OR A.AMDT_SEQ = 0)" ).append("\n"); 
		query.append("                           GROUP BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.CMDT_HDR_SEQ, A.ROUT_SEQ, A.RT_SEQ" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                          WHERE ROWNUM > 0" ).append("\n"); 
		query.append("                        ) I" ).append("\n"); 
		query.append("                        ,(SELECT A.PROP_NO" ).append("\n"); 
		query.append("                                ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                                ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                ,A.GRI_GRP_SEQ" ).append("\n"); 
		query.append("                                ,A.FLT_PCT_TP_CD" ).append("\n"); 
		query.append("                                ,A.GRI_APPL_DIV_CD" ).append("\n"); 
		query.append("                                ,B.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                ,C.CUST_CNT_CD" ).append("\n"); 
		query.append("                                ,C.CUST_SEQ" ).append("\n"); 
		query.append("                                ,D.ROUT_PNT_LOC_TP_CD AS ORG_ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                ,D.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                ,D.RCV_DE_TERM_CD AS ORG_RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                ,E.ROUT_VIA_PORT_TP_CD AS ORG_ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                                ,E.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                ,F.ROUT_VIA_PORT_TP_CD AS DEST_ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                                ,F.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                ,G.ROUT_PNT_LOC_TP_CD AS DEST_ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                ,G.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                ,G.RCV_DE_TERM_CD AS DEST_RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                ,H.RAT_UT_CD" ).append("\n"); 
		query.append("                                ,H.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                                ,H.CURR_CD" ).append("\n"); 
		query.append("                                ,H.GRI_RT_AMT" ).append("\n"); 
		query.append("                                ,H.GRI_RT_RTO" ).append("\n"); 
		query.append("                            FROM PRI_RP_SCP_GRI_GRP      A" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_GRI_CMDT     B" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_GRI_ACT_CUST C" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_GRI_ROUT_PNT D" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_GRI_ROUT_VIA E" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_GRI_ROUT_VIA F" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_GRI_ROUT_PNT G" ).append("\n"); 
		query.append("                                ,PRI_RP_SCP_GRI_RT       H" ).append("\n"); 
		query.append("                           WHERE A.PROP_NO = B.PROP_NO(+)" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = B.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                             AND A.GRI_GRP_SEQ = B.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                             AND A.GRI_GRP_SEQ = C.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                             AND A.GRI_GRP_SEQ = D.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                             AND A.GRI_GRP_SEQ = E.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                             AND A.GRI_GRP_SEQ = F.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.PROP_NO = G.PROP_NO(+)" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = G.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = G.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                             AND A.GRI_GRP_SEQ = G.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.PROP_NO = H.PROP_NO(+)" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = H.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = H.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                             AND A.GRI_GRP_SEQ = H.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                             AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                             AND A.GEN_SPCL_RT_TP_CD = NVL(@[gen_spcl_rt_tp_cd], 'G')" ).append("\n"); 
		query.append("                             AND A.GRI_APPL_DIV_CD = 'I'" ).append("\n"); 
		query.append("                             AND D.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("                             AND E.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("                             AND F.ORG_DEST_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("                             AND G.ORG_DEST_TP_CD(+) = 'D') X" ).append("\n"); 
		query.append("                   WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                     AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                     AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND A.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("                     AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                     AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                     AND A.CMDT_HDR_SEQ = C.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                     AND A.PROP_NO = D.PROP_NO" ).append("\n"); 
		query.append("                     AND A.AMDT_SEQ = D.AMDT_SEQ" ).append("\n"); 
		query.append("                     AND A.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND A.CMDT_HDR_SEQ = D.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND A.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("                     AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("                     AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                     AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                     AND A.CMDT_HDR_SEQ = E.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                     AND A.ROUT_SEQ = E.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                     AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("                     AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                     AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                     AND A.CMDT_HDR_SEQ = F.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("                     AND A.ROUT_SEQ = F.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                     AND A.PROP_NO = G.PROP_NO" ).append("\n"); 
		query.append("                     AND A.AMDT_SEQ = G.AMDT_SEQ" ).append("\n"); 
		query.append("                     AND A.SVC_SCP_CD = G.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND A.CMDT_HDR_SEQ = G.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND A.ROUT_SEQ = G.ROUT_SEQ" ).append("\n"); 
		query.append("                     AND A.PROP_NO = I.PROP_NO" ).append("\n"); 
		query.append("                     AND A.AMDT_SEQ = I.AMDT_SEQ" ).append("\n"); 
		query.append("                     AND A.SVC_SCP_CD = I.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND A.CMDT_HDR_SEQ = I.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                     AND A.ROUT_SEQ = I.ROUT_SEQ" ).append("\n"); 
		query.append("                     AND A.RT_SEQ = I.RT_SEQ" ).append("\n"); 
		query.append("                     AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                     AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                     AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                     AND D.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                     AND E.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("                     AND F.ORG_DEST_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("                     AND G.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                     AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                     AND B.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                     AND C.SRC_INFO_CD(+) <> 'AD'" ).append("\n"); 
		query.append("                     AND D.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                     AND E.SRC_INFO_CD(+) <> 'AD'" ).append("\n"); 
		query.append("                     AND F.SRC_INFO_CD(+) <> 'AD'" ).append("\n"); 
		query.append("                     AND G.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                     AND A.GRI_APPL_TP_CD = 'N'" ).append("\n"); 
		query.append("                     AND (A.N1ST_CMNC_AMDT_SEQ <> A.AMDT_SEQ OR A.AMDT_SEQ = 0)" ).append("\n"); 
		query.append("                     AND A.PROP_NO = X.PROP_NO" ).append("\n"); 
		query.append("                     AND A.AMDT_SEQ = X.AMDT_SEQ" ).append("\n"); 
		query.append("                     AND A.SVC_SCP_CD = X.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND (X.PRC_CMDT_DEF_CD IS NULL OR B.PRC_CMDT_DEF_CD = X.PRC_CMDT_DEF_CD)" ).append("\n"); 
		query.append("                     AND (X.CUST_CNT_CD IS NULL OR C.CUST_CNT_CD = X.CUST_CNT_CD)" ).append("\n"); 
		query.append("                     AND (X.CUST_SEQ IS NULL OR C.CUST_SEQ = X.CUST_SEQ)" ).append("\n"); 
		query.append("                     AND (X.ORG_ROUT_PNT_LOC_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("                         (X.ORG_ROUT_PNT_LOC_TP_CD = 'L' AND D.ROUT_PNT_LOC_DEF_CD = X.ORG_ROUT_PNT_LOC_DEF_CD) OR" ).append("\n"); 
		query.append("                         (X.ORG_ROUT_PNT_LOC_TP_CD = 'G' AND D.ROUT_PNT_LOC_DEF_CD = X.ORG_ROUT_PNT_LOC_DEF_CD) OR" ).append("\n"); 
		query.append("                         (X.ORG_ROUT_PNT_LOC_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("                           (SELECT 'OK'" ).append("\n"); 
		query.append("                              FROM MDM_LOCATION" ).append("\n"); 
		query.append("                             WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND CNT_CD = X.ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                               AND LOC_CD = D.ROUT_PNT_LOC_DEF_CD)))" ).append("\n"); 
		query.append("                     AND (X.ORG_RCV_DE_TERM_CD IS NULL OR D.RCV_DE_TERM_CD = X.ORG_RCV_DE_TERM_CD)" ).append("\n"); 
		query.append("                     AND (X.ORG_ROUT_VIA_PORT_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("                         (X.ORG_ROUT_VIA_PORT_TP_CD = 'L' AND E.ROUT_VIA_PORT_DEF_CD = X.ORG_ROUT_VIA_PORT_DEF_CD) OR" ).append("\n"); 
		query.append("                         (X.ORG_ROUT_VIA_PORT_TP_CD = 'G' AND E.ROUT_VIA_PORT_DEF_CD = X.ORG_ROUT_VIA_PORT_DEF_CD) OR" ).append("\n"); 
		query.append("                         (X.ORG_ROUT_VIA_PORT_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("                           (SELECT 'OK'" ).append("\n"); 
		query.append("                              FROM MDM_LOCATION" ).append("\n"); 
		query.append("                             WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND CNT_CD = X.ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                               AND LOC_CD = E.ROUT_VIA_PORT_DEF_CD)))" ).append("\n"); 
		query.append("                     AND (X.DEST_ROUT_VIA_PORT_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("                         (X.DEST_ROUT_VIA_PORT_TP_CD = 'L' AND F.ROUT_VIA_PORT_DEF_CD = X.DEST_ROUT_VIA_PORT_DEF_CD) OR" ).append("\n"); 
		query.append("                         (X.DEST_ROUT_VIA_PORT_TP_CD = 'G' AND F.ROUT_VIA_PORT_DEF_CD = X.DEST_ROUT_VIA_PORT_DEF_CD) OR" ).append("\n"); 
		query.append("                         (X.DEST_ROUT_VIA_PORT_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("                           (SELECT 'OK'" ).append("\n"); 
		query.append("                              FROM MDM_LOCATION" ).append("\n"); 
		query.append("                             WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND CNT_CD = X.DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                               AND LOC_CD = F.ROUT_VIA_PORT_DEF_CD)))" ).append("\n"); 
		query.append("                     AND (X.DEST_ROUT_PNT_LOC_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("                         (X.DEST_ROUT_PNT_LOC_TP_CD = 'L' AND G.ROUT_PNT_LOC_DEF_CD = X.DEST_ROUT_PNT_LOC_DEF_CD) OR" ).append("\n"); 
		query.append("                         (X.DEST_ROUT_PNT_LOC_TP_CD = 'G' AND G.ROUT_PNT_LOC_DEF_CD = X.DEST_ROUT_PNT_LOC_DEF_CD) OR" ).append("\n"); 
		query.append("                         (X.DEST_ROUT_PNT_LOC_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("                           (SELECT 'OK'" ).append("\n"); 
		query.append("                              FROM MDM_LOCATION" ).append("\n"); 
		query.append("                             WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND CNT_CD = X.DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                               AND LOC_CD = G.ROUT_PNT_LOC_DEF_CD)))" ).append("\n"); 
		query.append("                     AND (X.DEST_RCV_DE_TERM_CD IS NULL OR G.RCV_DE_TERM_CD = X.DEST_RCV_DE_TERM_CD)" ).append("\n"); 
		query.append("                     AND A.RAT_UT_CD = X.RAT_UT_CD" ).append("\n"); 
		query.append("                     AND A.PRC_CGO_TP_CD = X.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                     AND A.CURR_CD = X.CURR_CD" ).append("\n"); 
		query.append("                     AND NOT EXISTS" ).append("\n"); 
		query.append("                         (SELECT 'OK'" ).append("\n"); 
		query.append("                            FROM (SELECT A.PROP_NO" ).append("\n"); 
		query.append("                                        ,A.AMDT_SEQ" ).append("\n"); 
		query.append("                                        ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("                                        ,A.GRI_GRP_SEQ" ).append("\n"); 
		query.append("                                        ,A.FLT_PCT_TP_CD" ).append("\n"); 
		query.append("                                        ,A.GRI_APPL_DIV_CD" ).append("\n"); 
		query.append("                                        ,B.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                        ,C.CUST_CNT_CD" ).append("\n"); 
		query.append("                                        ,C.CUST_SEQ" ).append("\n"); 
		query.append("                                        ,D.ROUT_PNT_LOC_TP_CD AS ORG_ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                        ,D.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                        ,D.RCV_DE_TERM_CD AS ORG_RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                        ,E.ROUT_VIA_PORT_TP_CD AS ORG_ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                                        ,E.ROUT_VIA_PORT_DEF_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                        ,F.ROUT_VIA_PORT_TP_CD AS DEST_ROUT_VIA_PORT_TP_CD" ).append("\n"); 
		query.append("                                        ,F.ROUT_VIA_PORT_DEF_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                        ,G.ROUT_PNT_LOC_TP_CD AS DEST_ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("                                        ,G.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                        ,G.RCV_DE_TERM_CD AS DEST_RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                        ,H.RAT_UT_CD" ).append("\n"); 
		query.append("                                        ,H.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                                        ,H.CURR_CD" ).append("\n"); 
		query.append("                                        ,H.GRI_RT_AMT" ).append("\n"); 
		query.append("                                        ,H.GRI_RT_RTO" ).append("\n"); 
		query.append("                                    FROM PRI_RP_SCP_GRI_GRP      A" ).append("\n"); 
		query.append("                                        ,PRI_RP_SCP_GRI_CMDT     B" ).append("\n"); 
		query.append("                                        ,PRI_RP_SCP_GRI_ACT_CUST C" ).append("\n"); 
		query.append("                                        ,PRI_RP_SCP_GRI_ROUT_PNT D" ).append("\n"); 
		query.append("                                        ,PRI_RP_SCP_GRI_ROUT_VIA E" ).append("\n"); 
		query.append("                                        ,PRI_RP_SCP_GRI_ROUT_VIA F" ).append("\n"); 
		query.append("                                        ,PRI_RP_SCP_GRI_ROUT_PNT G" ).append("\n"); 
		query.append("                                        ,PRI_RP_SCP_GRI_RT       H" ).append("\n"); 
		query.append("                                   WHERE A.PROP_NO = B.PROP_NO(+)" ).append("\n"); 
		query.append("                                     AND A.AMDT_SEQ = B.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.SVC_SCP_CD = B.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                                     AND A.GRI_GRP_SEQ = B.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.PROP_NO = C.PROP_NO(+)" ).append("\n"); 
		query.append("                                     AND A.AMDT_SEQ = C.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.SVC_SCP_CD = C.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                                     AND A.GRI_GRP_SEQ = C.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.PROP_NO = D.PROP_NO(+)" ).append("\n"); 
		query.append("                                     AND A.AMDT_SEQ = D.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.SVC_SCP_CD = D.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                                     AND A.GRI_GRP_SEQ = D.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.PROP_NO = E.PROP_NO(+)" ).append("\n"); 
		query.append("                                     AND A.AMDT_SEQ = E.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                                     AND A.GRI_GRP_SEQ = E.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.PROP_NO = F.PROP_NO(+)" ).append("\n"); 
		query.append("                                     AND A.AMDT_SEQ = F.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.SVC_SCP_CD = F.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                                     AND A.GRI_GRP_SEQ = F.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.PROP_NO = G.PROP_NO(+)" ).append("\n"); 
		query.append("                                     AND A.AMDT_SEQ = G.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.SVC_SCP_CD = G.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                                     AND A.GRI_GRP_SEQ = G.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.PROP_NO = H.PROP_NO(+)" ).append("\n"); 
		query.append("                                     AND A.AMDT_SEQ = H.AMDT_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.SVC_SCP_CD = H.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                                     AND A.GRI_GRP_SEQ = H.GRI_GRP_SEQ(+)" ).append("\n"); 
		query.append("                                     AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                                     AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                     AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                                     AND A.GEN_SPCL_RT_TP_CD = NVL(@[gen_spcl_rt_tp_cd], 'G')" ).append("\n"); 
		query.append("                                     AND A.GRI_APPL_DIV_CD = 'E'" ).append("\n"); 
		query.append("                                     AND D.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("                                     AND E.ORG_DEST_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("                                     AND F.ORG_DEST_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("                                     AND G.ORG_DEST_TP_CD(+) = 'D') Y" ).append("\n"); 
		query.append("                           WHERE A.PROP_NO = Y.PROP_NO" ).append("\n"); 
		query.append("                             AND A.AMDT_SEQ = Y.AMDT_SEQ" ).append("\n"); 
		query.append("                             AND A.SVC_SCP_CD = Y.SVC_SCP_CD" ).append("\n"); 
		query.append("                             AND (Y.PRC_CMDT_DEF_CD IS NULL OR B.PRC_CMDT_DEF_CD = Y.PRC_CMDT_DEF_CD)" ).append("\n"); 
		query.append("                             AND (Y.CUST_CNT_CD IS NULL OR C.CUST_CNT_CD = Y.CUST_CNT_CD)" ).append("\n"); 
		query.append("                             AND (Y.CUST_SEQ IS NULL OR C.CUST_SEQ = Y.CUST_SEQ)" ).append("\n"); 
		query.append("                             AND (Y.ORG_ROUT_PNT_LOC_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("                                 (Y.ORG_ROUT_PNT_LOC_TP_CD = 'L' AND D.ROUT_PNT_LOC_DEF_CD = Y.ORG_ROUT_PNT_LOC_DEF_CD) OR" ).append("\n"); 
		query.append("                                 (Y.ORG_ROUT_PNT_LOC_TP_CD = 'G' AND D.ROUT_PNT_LOC_DEF_CD = Y.ORG_ROUT_PNT_LOC_DEF_CD) OR" ).append("\n"); 
		query.append("                                 (Y.ORG_ROUT_PNT_LOC_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("                                   (SELECT 'OK'" ).append("\n"); 
		query.append("                                      FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                     WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                       AND CNT_CD = Y.ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                       AND LOC_CD = D.ROUT_PNT_LOC_DEF_CD)))" ).append("\n"); 
		query.append("                             AND (Y.ORG_RCV_DE_TERM_CD IS NULL OR D.RCV_DE_TERM_CD = Y.ORG_RCV_DE_TERM_CD)" ).append("\n"); 
		query.append("                             AND (Y.ORG_ROUT_VIA_PORT_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("                                 (Y.ORG_ROUT_VIA_PORT_TP_CD = 'L' AND E.ROUT_VIA_PORT_DEF_CD = Y.ORG_ROUT_VIA_PORT_DEF_CD) OR" ).append("\n"); 
		query.append("                                 (Y.ORG_ROUT_VIA_PORT_TP_CD = 'G' AND E.ROUT_VIA_PORT_DEF_CD = Y.ORG_ROUT_VIA_PORT_DEF_CD) OR" ).append("\n"); 
		query.append("                                 (Y.ORG_ROUT_VIA_PORT_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("                                   (SELECT 'OK'" ).append("\n"); 
		query.append("                                      FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                     WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                       AND CNT_CD = Y.ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                       AND LOC_CD = E.ROUT_VIA_PORT_DEF_CD)))" ).append("\n"); 
		query.append("                             AND (Y.DEST_ROUT_VIA_PORT_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("                                 (Y.DEST_ROUT_VIA_PORT_TP_CD = 'L' AND F.ROUT_VIA_PORT_DEF_CD = Y.DEST_ROUT_VIA_PORT_DEF_CD) OR" ).append("\n"); 
		query.append("                                 (Y.DEST_ROUT_VIA_PORT_TP_CD = 'G' AND F.ROUT_VIA_PORT_DEF_CD = Y.DEST_ROUT_VIA_PORT_DEF_CD) OR" ).append("\n"); 
		query.append("                                 (Y.DEST_ROUT_VIA_PORT_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("                                   (SELECT 'OK'" ).append("\n"); 
		query.append("                                      FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                     WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                       AND CNT_CD = Y.DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                                       AND LOC_CD = F.ROUT_VIA_PORT_DEF_CD)))" ).append("\n"); 
		query.append("                             AND (Y.DEST_ROUT_PNT_LOC_DEF_CD IS NULL OR" ).append("\n"); 
		query.append("                                 (Y.DEST_ROUT_PNT_LOC_TP_CD = 'L' AND G.ROUT_PNT_LOC_DEF_CD = Y.DEST_ROUT_PNT_LOC_DEF_CD) OR" ).append("\n"); 
		query.append("                                 (Y.DEST_ROUT_PNT_LOC_TP_CD = 'G' AND G.ROUT_PNT_LOC_DEF_CD = Y.DEST_ROUT_PNT_LOC_DEF_CD) OR" ).append("\n"); 
		query.append("                                 (Y.DEST_ROUT_PNT_LOC_TP_CD = 'C' AND EXISTS" ).append("\n"); 
		query.append("                                   (SELECT 'OK'" ).append("\n"); 
		query.append("                                      FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                     WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                       AND CNT_CD = Y.DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                       AND LOC_CD = G.ROUT_PNT_LOC_DEF_CD)))" ).append("\n"); 
		query.append("                             AND (Y.DEST_RCV_DE_TERM_CD IS NULL OR G.RCV_DE_TERM_CD = Y.DEST_RCV_DE_TERM_CD))) T" ).append("\n"); 
		query.append("           WHERE A.PROP_NO = T.PROP_NO" ).append("\n"); 
		query.append("             AND A.AMDT_SEQ = T.AMDT_SEQ" ).append("\n"); 
		query.append("             AND A.SVC_SCP_CD = T. SVC_SCP_CD" ).append("\n"); 
		query.append("             AND A.CMDT_HDR_SEQ = T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             AND A.ROUT_SEQ = T.ROUT_SEQ" ).append("\n"); 
		query.append("             AND A.RT_SEQ = T. RT_SEQ" ).append("\n"); 
		query.append("             AND T.RN = T.GRP_CNT" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE X.FIC_ORG_RT_USE_STS_CD IN ('1', '2', '3') OR X.FIC_DEST_RT_USE_STS_CD IN ('1', '2', '3') OR (X.FIC_ORG_RT_USE_STS_CD = 'Z' AND X.FIC_DEST_RT_USE_STS_CD = 'Z')" ).append("\n"); 

	}
}